package com.xiaolong.spider.consumer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaolong.spider.bean.data.ChinaDayAdd;
import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;
import com.xiaolong.spider.dao.DatabaseMapper;
import com.xiaolong.spider.enumc.LocationRequestPram;
import com.xiaolong.spider.util.JsonUtil;
import com.xiaolong.spider.util.URLUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @Description: 生产者，将数据加载到内存中
 * @Author xiaolong
 * @Date 2021/10/24 7:49 下午
 */

@Service
public class Consumer implements Runnable{

    Properties myProperties = new Config().getProperties();

    RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory());

    @Autowired
    DatabaseMapper databaseMapper;

    @Override
    public void run() {
        String url = URLUtil.handleUrl(myProperties.getProperty(Constant.SPIDER_LOCATION_URL), LocationRequestPram.chinaDayAddList.getCode());
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        JSONObject data = (JSONObject) JsonUtil.string2JSONObj(forEntity.getBody()).get("data");
        ObjectMapper objectMapper = new ObjectMapper();
        // 转为一个数据存储对象
        List<ChinaDayAdd> chinaDayAddList = ((JSONArray) data.getOrDefault("chinaDayAddList", new JSONArray()))
                .stream().map(Object::toString)
                .map(jsonStr -> {
            try {
                return objectMapper.readValue(jsonStr, ChinaDayAdd.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        databaseMapper.saveChinaDayAdd(chinaDayAddList);
    }

    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(15000);
        factory.setReadTimeout(5000);
        return factory;
    }

    public static void main(String[] args) {
        new Thread(new Consumer(), "thread-consumer").start();
    }

}
