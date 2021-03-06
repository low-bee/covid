package com.xiaolong.homework.controller;

import com.xiaolong.homework.bean.WomWorldDataBo;
import com.xiaolong.homework.bean.bo.ContinentStatus;
import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.service.HomeworkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @Description: 家庭作业Controller
 * 1.
 * @Author xiaolong
 * @Date 2021/10/30 8:50 上午
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired
    HomeworkService homeworkService;

    // 分国家给出死亡病例和年龄之间的关系
    @ApiOperation("age")
    @GetMapping("/{country}/age")
    public List<CountryDeathsByAge> getCountryDeaths(@PathVariable String country){
        return homeworkService.getAgeDeathsByCountry(country);
    }
    // 感染病例和年龄之间的关系

    // 返回国家列表
    @ApiOperation("country")
    @GetMapping("/country")
    public Set<String> getCountrySet(){
        return homeworkService.getCountrySet();
    }
    // 分地区的死亡率

    // 返回世界数据
    @ApiOperation("world")
    @GetMapping("/world")
    public WomWorldDataBo getWorldData(){
        return homeworkService.getWorldData();
    }

    // 返回大洲数据
    // 返回世界数据
    @ApiOperation("world")
    @GetMapping("/world/continent")
    public List<ContinentStatus> getContinentStatus(){
        return homeworkService.getContinentStatus();
    }
}
