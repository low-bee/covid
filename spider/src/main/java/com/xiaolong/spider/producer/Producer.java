package com.xiaolong.spider.producer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaolong.spider.bean.foreign.*;
import com.xiaolong.spider.bean.supper.SupperData;
import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;
import com.xiaolong.spider.util.JsonUtil;
import com.xiaolong.spider.util.URLUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: 从网页中获取数据
 * @Author xiaolong
 * @Date 2021/10/26 10:57 下午
 */
@Service
public class Producer {

    private final RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<SupperData> getData(String pram){
        // todo 参数校验

        String url = URLUtil.handleLocationUrl(pram);
        if ("".equals(url)){
            throw new InvalidParameterException("传入的参数无法生成一个正常的url！");
        }
        return getSupperData(pram, url);
    }

    private Class<SupperData> handlerClassName(String pram) {
        StringBuilder builder = new StringBuilder();
        builder.append("com.xiaolong.spider.bean.data.");
        builder.append(Character.toUpperCase(pram.charAt(0)));
        builder.append(pram.substring(1));
        try {
            return (Class<SupperData>) Class.forName(builder.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);
        return factory;
    }

    public List<SupperData> getForeignData(String pram) {
        // todo 参数校验

        String url = URLUtil.handleForeignUrl(pram);

        if ("".equals(url)){
            throw new InvalidParameterException("传入的参数无法生成一个正常的url！");

        }
        return getSupperData(pram, url);
    }

    private List<SupperData> getSupperData(String pram, String url) {
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject data = (JSONObject) JsonUtil.string2JSONObj(forEntity.getBody()).get("data");

        if ("WomWorld".equals(pram)){
            try {
                List<SupperData> ret = new ArrayList<>();
                ret.add(objectMapper.readValue(data.getObject(pram, String.class), handlerClassName(pram)));
                return ret;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }
        // 转为一个数据存储对象
        return ((JSONArray) data.getOrDefault(pram, new JSONArray()))
                .stream().map(Object::toString)
                .map(jsonStr -> {
                    try {
                        return objectMapper.readValue(jsonStr, handlerClassName(pram));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    public List<Covid19Deaths> getDataFromDataCdcGov(){
        StringBuilder url = new StringBuilder("https://data.cdc.gov/resource/9bhg-hcku.json?$$app_token=");
        url.append(new Config().getProperties().getProperty(Constant.SPIDER_FOREIGN_TOKEN));
        url.append("&$select=*");
        url.append("&$limit=1000000");
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url.toString(), String.class);
        JSONArray array = JsonUtil.string2JsonArray(forEntity.getBody());

        return array.stream().map(Object::toString)
                .map(json -> {
                    try {
                        return objectMapper.readValue(json, Covid19Deaths.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).collect(Collectors.toList());
    }

    public List<WHOCovid19> getDataFromWHO() throws IOException, InstantiationException, IllegalAccessException {
        return getCSVFromURL("https://covid19.who.int/WHO-COVID-19-global-data.csv", WHOCovid19.class);

    }

    public List<FrenchCovidHospitalData> getFrenchCovidHospitalData() throws IOException, InstantiationException, IllegalAccessException {
        return getCSVFromURL("https://www.data.gouv.fr/fr/datasets/r/63352e38-d353-4b54-bfd1-f1b3ee1cabd7", FrenchCovidHospitalData.class);
    }

    public List<FrenchCovidAgeData> getFrenchCovidAgeData() throws IOException, InstantiationException,IllegalAccessException{
        return getCSVFromURL("https://www.data.gouv.fr/fr/datasets/r/08c18e08-6780-452d-9b8c-ae244ad529b3", FrenchCovidAgeData.class);
    }

    public List<FrenchLastDayNumberData> getFrenchLastDayNumberData() throws IOException, InstantiationException,IllegalAccessException{
        return getCSVFromURL("https://www.data.gouv.fr/fr/datasets/r/a1466f7f-4ece-4158-a373-f5d4db167eb0", FrenchLastDayNumberData.class);
    }


    private <T> List<T> getCSVFromURL(String url, Class<T> clazz) throws IOException, InstantiationException, IllegalAccessException {
        int n = clazz.getFields().length;
        URL currURL = new URL(url);
        URLConnection urlConnection = currURL.openConnection();
        urlConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        List<T> ret = new ArrayList<>();
        String curr;
        boolean vis = false;
        while ((curr = bufferedReader.readLine()) != null){
            if (!vis){
                vis = true;
                continue;
            }
            ret.add(string2Clazz(clazz, curr));
        }
        return ret;
    }

    private <T> T string2Clazz(Class<T> clazz, String curr) throws InstantiationException, IllegalAccessException {
        String[] split = curr.split(curr.contains(",") ? "," : ";");
        T obj = clazz.newInstance();
        HashMap<String, String> fieldValue = new HashMap<>();
        int i = 0;
        Field[] fields = clazz.getDeclaredFields();
        while (i < fields.length){
            Field field = fields[i];
            field.setAccessible(true);
            if (!"update".equals(field.getName())){
                fieldValue.put(field.getName(), split[i]);
            }
            i++;
        }
        fieldValue.forEach(
                (key, value) -> {
                    try {
                        BeanUtils.setProperty(obj, key, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                });
        return obj;
    }

    private WHOCovid19 stringToWhoCovid19(String current) {
        String[] split = current.split(",");
        if (split.length != 8){
            return null;
        }
        WHOCovid19 whoCovid19 = new WHOCovid19();
        whoCovid19.setDateReported(split[0]);
        whoCovid19.setCountryCode(split[1]);
        whoCovid19.setCountry(split[2]);
        whoCovid19.setWhoRegion(split[3]);
        whoCovid19.setNewCases(Integer.parseInt(split[4]));
        whoCovid19.setCumulativeCases(Integer.parseInt(split[5]));
        whoCovid19.setNewDeaths(Integer.parseInt(split[6]));
        whoCovid19.setCumulativeDeaths(Integer.parseInt(split[7]));
        return whoCovid19;
    }

    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        new Producer().getFrenchCovidHospitalData();
    }

}
