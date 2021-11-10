package com.xiaolong.homework.service.Impl;


import com.xiaolong.homework.bean.Covid19Death;
import com.xiaolong.homework.bean.bo.CountryDeathsByAge;
import com.xiaolong.homework.bean.bo.CountryDeathsByRegion;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadBo;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadRegionBo;
import com.xiaolong.homework.dao.AmericaMapper;
import com.xiaolong.homework.service.AmericaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: AmericaService implement class
 * @Author xiaolong
 * @Date 2021/11/8 9:14 上午
 */
@Service
public class AmericaServiceImpl implements AmericaService {

    @Autowired
    AmericaMapper americaMapper;

    @Override
    public List<CountryDeathsByAge> query(QueryAmericaDeadBo queryAmericaDeadBo) {
        List<Covid19Death> covid19Deaths = americaMapper.query(queryAmericaDeadBo);
        return covid19Deaths.stream().map(
                covid19Death -> doToBo(queryAmericaDeadBo, covid19Death)
        ).collect(Collectors.toList());
    }

    @Override
    public List<CountryDeathsByRegion> queryRegion(QueryAmericaDeadRegionBo queryAmericaDeadRegionBo) {
        return americaMapper.queryRegion(queryAmericaDeadRegionBo);
    }

    @Override
    public String returnFile(String country) throws IOException {
        BufferedReader bufferedReader = null;
        try {
            InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("map/" + country + ".json");
            bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String in;
        while ((in = bufferedReader.readLine()) != null){
            builder.append(in);
        }
        return builder.toString();
    }

    private CountryDeathsByAge doToBo(QueryAmericaDeadBo queryAmericaDeadBo, Covid19Death covid19Death) {
        CountryDeathsByAge countryDeathsByAge = new CountryDeathsByAge();
        countryDeathsByAge.setAge(covid19Death.getAgeGroup());
        countryDeathsByAge.setCountry("America");
        countryDeathsByAge.setDeathsNumber(covid19Death.getCovid19Deaths().toString());
        countryDeathsByAge.setDate(queryAmericaDeadBo.getDataAsOf());
        countryDeathsByAge.setState(queryAmericaDeadBo.getState());
        countryDeathsByAge.setTotalDeaths(String.valueOf(covid19Death.getTotalDeaths()));
        countryDeathsByAge.setPneumoniaDeaths(String.valueOf(covid19Death.getPneumoniaDeaths()));
        countryDeathsByAge.setInfluenzaDeaths(String.valueOf(covid19Death.getInfluenzaDeaths()));
        countryDeathsByAge.setSex(covid19Death.getSex());
        countryDeathsByAge.setPneumoniaAndCovid19Deaths(String.valueOf(covid19Death.getPneumoniaAndCovid19Deaths()));
        countryDeathsByAge.setPneumoniaInfluenzaOrCovid(String.valueOf(covid19Death.getPneumoniaInfluenzaOrCovid()));
        return countryDeathsByAge;
    }
}
