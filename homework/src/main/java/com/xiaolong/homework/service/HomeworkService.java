package com.xiaolong.homework.service;

import java.util.Map;
import java.util.Set;

/**
 * @Description: Homework Service interface
 * @Author xiaolong
 * @Date 2021/10/30 9:06 上午
 */

public interface HomeworkService {

    /**
     * 获取所有的国家可选列表
     * @return 一个包含所有国家名字的Set
     */
    Set<String> getCountrySet();

    /**
     * 通过国家名字获取年龄和死亡的关系
     * @param country 国家名
     * @return 一个Map, key是年龄分段，value是对应的死亡数字
     */
    Map<String, Integer> getAgeDeathsByCountry(String country);



}
