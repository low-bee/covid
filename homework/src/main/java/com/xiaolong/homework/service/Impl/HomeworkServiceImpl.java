package com.xiaolong.homework.service.Impl;

import com.xiaolong.homework.bean.Covid19Death;
import com.xiaolong.homework.bean.WomWorldDataBo;
import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.dao.HomeworkMapper;
import com.xiaolong.homework.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description: Homework Service 服务实现类
 * @Author xiaolong
 * @Date 2021/10/30 9:07 上午
 */

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    HomeworkMapper homeworkMapper;

    @Override
    public Set<String> getCountrySet() {
        return homeworkMapper.getCountrySet().stream().filter(country ->
            !country.contains("\"") && !country.contains("(")
        ).collect(Collectors.toSet());
    }

    @Override
    public List<CountryDeathsByAge> getAgeDeathsByCountry(String country) {
        List<Covid19Death> covid19Deaths = homeworkMapper.getCountryAge(country);
        List<CountryDeathsByAge> ret = new ArrayList<>();
        covid19Deaths.forEach(covidDeath -> {
            CountryDeathsByAge temp = new CountryDeathsByAge();
            temp.setAge(covidDeath.getAgeGroup());
            temp.setDeathsNumber(String.valueOf(covidDeath.getCovid19Deaths()));
            ret.add(temp);
        });
        return ret;
    }

    @Override
    public WomWorldDataBo getWorldData() {
        return homeworkMapper.getWomWorldData();
    }
}
