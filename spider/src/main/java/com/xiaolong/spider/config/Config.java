package com.xiaolong.spider.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: 将配置文件增加到项目中
 * @Author xiaolong
 * @Date 2021/10/24 6:45 下午
 */
@Slf4j
public class Config {

    private final Properties properties  = new Properties();

    {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            log.error("配置文件出错");
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public static void main(String[] args) {
        Properties properties = new Config().getProperties();
        System.out.println(properties.getProperty("spider.location.url"));
    }

}
