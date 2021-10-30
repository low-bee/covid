package com.xiaolong.homework.service.Impl;

import com.xiaolong.homework.bean.Covid19Deaths;
import com.xiaolong.homework.dao.HomeworkMapper;
import com.xiaolong.homework.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return homeworkMapper.getCountrySet();
    }

    @Override
    public Map<String, Integer> getAgeDeathsByCountry(String country) {
        List<Covid19Deaths> covid19Deaths = homeworkMapper.getCountryAge(country);
        HashMap<String, Integer> ret = new HashMap<>();
        covid19Deaths.stream().forEach(covidDeath -> {
            ret.put(covidDeath.getAgeGroup(), covidDeath.getCovid19Deaths());
        });
        return ret;
    }
}
