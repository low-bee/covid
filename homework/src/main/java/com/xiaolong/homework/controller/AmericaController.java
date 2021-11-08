package com.xiaolong.homework.controller;

import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadBo;
import com.xiaolong.homework.service.AmericaService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 用作前端美国数据接口展示
 * @Author xiaolong
 * @Date 2021/11/8 8:42 上午
 */
@RestController
public class AmericaController {

    @Autowired
    AmericaService americaService;

    // 分国家给出死亡病例和年龄之间的关系
    @ApiOperation("美国年龄和死亡率之间的关系")
    @GetMapping("/age")
    public List<CountryDeathsByAge> getCountryDeaths(QueryAmericaDeadBo queryAmericaDeadBo){
        return americaService.query(queryAmericaDeadBo);
    }
}
