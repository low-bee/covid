package com.xiaolong.homework.service;


import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.bean.bo.CountryDeathsByRegion;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadBo;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadRegionBo;

import java.io.IOException;
import java.util.List;

public interface AmericaService {
    List<CountryDeathsByAge> query(QueryAmericaDeadBo queryAmericaDeadBo);

    List<CountryDeathsByRegion> queryRegion(QueryAmericaDeadRegionBo queryAmericaDeadRegionBo);

    String returnFile(String country) throws IOException;
}
