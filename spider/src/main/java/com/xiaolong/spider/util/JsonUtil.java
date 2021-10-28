package com.xiaolong.spider.util;


import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * @Description: Json对象的一个工具类,使用什么工具完全由这个来决定，外界无感知
 * @Author xiaolong
 * @Date 2021/10/24 8:29 下午
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static HashMap<String, String> string2Map(String jsonString) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, HashMap.class);
    }

    public static JSONObject string2JSONObj(String jsonString){
        return JSONObject.parseObject(jsonString);
    }

    public static JSONArray string2JsonArray(String jsonString){
        return JSONObject.parseArray(jsonString);
    }







}
