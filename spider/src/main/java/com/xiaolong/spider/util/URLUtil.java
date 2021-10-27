package com.xiaolong.spider.util;

import com.xiaolong.spider.config.Config;
import com.xiaolong.spider.constant.Constant;

import java.util.Properties;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/10/24 8:06 下午
 */
public class URLUtil {

    private static final Properties myProperties = new Config().getProperties();

    public static String handleLocationUrl(String pram){
        return myProperties.getProperty(Constant.SPIDER_LOCATION_URL) + pram;
    }

    public static String handleForeignUrl(String pram){
        return myProperties.getProperty(Constant.SPIDER_FOREIGN_URL) + pram;
    }
}
