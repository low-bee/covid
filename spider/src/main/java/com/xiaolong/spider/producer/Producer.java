package com.xiaolong.spider.producer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaolong.spider.bean.foreign.Covid19Deaths;
import com.xiaolong.spider.bean.supper.SupperData;
import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;
import com.xiaolong.spider.util.JsonUtil;
import com.xiaolong.spider.util.URLUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        String url = "https://data.cdc.gov/resource/9bhg-hcku.json?$$app_token=" + new Config().getProperties().getProperty(Constant.SPIDER_FOREIGN_TOKEN);

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
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

}
