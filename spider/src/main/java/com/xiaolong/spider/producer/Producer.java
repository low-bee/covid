package com.xiaolong.spider.producer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaolong.spider.bean.foreign.Covid19Deaths;
import com.xiaolong.spider.bean.foreign.WHOCovid19;
import com.xiaolong.spider.bean.supper.SupperData;
import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;
import com.xiaolong.spider.util.JsonUtil;
import com.xiaolong.spider.util.URLUtil;
import org.apache.tomcat.jni.OS;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
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

    public List<WHOCovid19> getDataFromWHO() throws IOException {
        final URL url = new URL("https://covid19.who.int/WHO-COVID-19-global-data.csv");
        final URLConnection urlConnection = url.openConnection();
        urlConnection.addRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36");
        urlConnection.addRequestProperty("cookie", "_gcl_au=1.1.1802247154.1635380733; _ga=GA1.2.1343273890.1635380733; _gid=GA1.2.757475202.1635380733; _clck=1k6lsh5|1|evy|0; _clsk=1y0je4|1635406599873|12|0|www.clarity.ms/eus2-b/collect");
        urlConnection.addRequestProperty("referer", "https://covid19.who.int/info/");
        final InputStream inputStream = urlConnection.getInputStream();
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<WHOCovid19> ret = new ArrayList<>();
        String current;
        boolean vis = false;
        while ((current = bufferedReader.readLine()) != null) {
            if (!vis){
                vis = true;
                continue;
            }
            WHOCovid19 whoCovid19 = stringToWhoCovid19(current);
            if (whoCovid19 != null) {
                ret.add(whoCovid19);
            }
        }
        return ret;
    }

    private WHOCovid19 stringToWhoCovid19(String current) {
        String[] split = current.split(",");
        if (split.length != 8){
            return null;
        }
        WHOCovid19 whoCovid19 = new WHOCovid19();
        whoCovid19.setDateReported(split[0]);
        whoCovid19.setCountry(split[1]);
        whoCovid19.setCountryCode(split[2]);
        whoCovid19.setWHORegion(split[3]);
        whoCovid19.setNewCases(Integer.parseInt(split[4]));
        whoCovid19.setCumulativeCases(Integer.parseInt(split[5]));
        whoCovid19.setNewDeaths(Integer.parseInt(split[6]));
        whoCovid19.setCumulativeDeaths(Integer.parseInt(split[7]));
        return whoCovid19;
    }

    public static void main(String[] args) throws IOException {
        final List<WHOCovid19> dataFromWHO = new Producer().getDataFromWHO();
        System.out.println(dataFromWHO);
    }

}
