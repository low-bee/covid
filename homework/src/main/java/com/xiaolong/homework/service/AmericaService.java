package com.xiaolong.homework.service;


import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadBo;

import java.util.List;

public interface AmericaService {
    List<CountryDeathsByAge> query(QueryAmericaDeadBo queryAmericaDeadBo);
}
