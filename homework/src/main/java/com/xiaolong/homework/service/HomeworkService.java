package com.xiaolong.homework.service;

import com.xiaolong.homework.bean.WomWorldDataBo;
import com.xiaolong.homework.bean.bo.CountryDeathsByAge;

import java.util.List;
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
    List<CountryDeathsByAge> getAgeDeathsByCountry(String country);

    /**
     * 获取全球数据
     * @return 当前全球数据对象
     */
    WomWorldDataBo getWorldData();
}
