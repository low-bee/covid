package com.xiaolong.spider.consumer;

import com.xiaolong.spider.bean.data.*;
import com.xiaolong.spider.bean.foreign.*;
import com.xiaolong.spider.bean.supper.SupperData;
import com.xiaolong.spider.dao.DatabaseMapper;
import com.xiaolong.spider.enumc.ForeignRequestPram;
import com.xiaolong.spider.enumc.LocationRequestPram;
import com.xiaolong.spider.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 生产者，将数据从网页加载到内存
 * @Author xiaolong
 * @Date 2021/10/24 7:49 下午
 */

@Service
@Slf4j
public class Consumer{

    private HashMap<String, String> mapTable = new HashMap<>();
    {
        mapTable.put(LocationRequestPram.chinaDayAddList.getCode(), "china_day_add");
        mapTable.put(LocationRequestPram.chinaDayList.getCode(), "china_day");
        mapTable.put(ForeignRequestPram.FAutoForeignList.getCode(), "foreign_country");
        mapTable.put(ForeignRequestPram.WomAboard.getCode(), "wom_aboard");
        mapTable.put(ForeignRequestPram.WomWorld.getCode(), "wom_world");
    }

    @Autowired
    DatabaseMapper databaseMapper;

    @Autowired
    Producer producer;

    // @PostConstruct
    @Transactional
    @Scheduled(cron = "0 */60 * * * ?")
    public void runHourse() {
//        List<SupperData> data3 = producer.getData(LocationRequestPram.nowConfirmStatis.getCode());
//        List<NowConfirmStatis> d3 = data3.stream().map(iter -> (NowConfirmStatis) iter).collect(Collectors.toList());
//        databaseMapper.saveNowConfirmStatis(d3);

//        List<SupperData> data4 = producer.getData(LocationRequestPram.provinceCompare.getCode());
//        List<ProvinceCompare> d4 = data4.stream().map(iter -> (ProvinceCompare) iter).collect(Collectors.toList());
//        databaseMapper.saveProvinceCompare(d4);
        // 入库之前删除所有的数据

        List<SupperData> data1 = producer.getData(LocationRequestPram.chinaDayAddList.getCode());
        List<ChinaDayAddList> d1 = data1.stream().map(iter -> (ChinaDayAddList) iter).collect(Collectors.toList());
        databaseMapper.deleteTable(mapTable.get(LocationRequestPram.chinaDayAddList.getCode()));
        databaseMapper.saveChinaDayAdd(d1);

        List<SupperData> data2 = producer.getData(LocationRequestPram.chinaDayList.getCode());
        List<ChinaDayList> d2 = data2.stream().map(iter -> (ChinaDayList) iter).collect(Collectors.toList());
        databaseMapper.deleteTable(mapTable.get(LocationRequestPram.chinaDayList.getCode()));
        databaseMapper.saveChinaDay(d2);
        List<SupperData> foreignData1 = producer.getForeignData(ForeignRequestPram.FAutoForeignList.getCode());
        List<FAutoforeignList> fd1 = foreignData1.stream().map(item -> (FAutoforeignList) item).collect(Collectors.toList());
        databaseMapper.deleteTable(mapTable.get(ForeignRequestPram.FAutoForeignList.getCode()));
        databaseMapper.saveForeignData(fd1);

        // 清洗一下数据 country - list<province>
        List<ForeignProvince> fdp1 = fd1.stream().map(item -> {
            String country = item.getName();
            if (item.getForeignProvince() != null){
                return item.getForeignProvince().stream().filter(Objects::nonNull).peek(
                        province -> province.setCountry(country)
                ).collect(Collectors.toList());
            } else {
                return null;
            }
        }).filter(Objects::nonNull).flatMap(Collection::stream).collect(Collectors.toList());
        databaseMapper.deleteTable("foreign_province");
        databaseMapper.saveForeignProvince(fdp1);

        List<SupperData> foreignData2 = producer.getForeignData(ForeignRequestPram.WomAboard.getCode());
        List<WomAboard> fd2 = foreignData2.stream().map(item -> (WomAboard) item).collect(Collectors.toList());
        databaseMapper.deleteTable(mapTable.get(ForeignRequestPram.WomAboard.getCode()));
        databaseMapper.saveWomAboard(fd2);

        List<SupperData> foreignData3 = producer.getForeignData(ForeignRequestPram.WomWorld.getCode());
        List<WomWorld> fd3 = foreignData3.stream().map(item -> (WomWorld) item).collect(Collectors.toList());
        databaseMapper.deleteTable(mapTable.get(ForeignRequestPram.WomWorld.getCode()));
        databaseMapper.saveWomWorld(fd3);
        log.info("本国一次执行完毕");

    }

    @Scheduled(cron = "0 0 1 * * *")
    public void runDay(){
        List<Covid19Deaths> dataFromDataCdcGov = producer.getDataFromDataCdcGov();
        databaseMapper.deleteTable("covid19_deaths");
        databaseMapper.saveDataFromDataCdcGov(dataFromDataCdcGov);
        log.info("年龄数据执行一次完成！");

        try {
            final List<WHOCovid19> dataFromWHO = producer.getDataFromWHO();
            databaseMapper.deleteTable("who_covid19");
            databaseMapper.saveDataFromWHO(dataFromWHO);

            List<FrenchCovidHospitalData> frenchCovidHospitalData = producer.getFrenchCovidHospitalData();
            databaseMapper.deleteTable("french_covid_hospital_data");
            databaseMapper.savaFrenchCovidHospitalData(frenchCovidHospitalData);

            List<FrenchCovidAgeData> frenchCovidAgeData = producer.getFrenchCovidAgeData();
            databaseMapper.deleteTable("french_covid_age_data");
            databaseMapper.saveFrenchAgeData(frenchCovidAgeData);

            List<FrenchLastDayNumberData> frenchLastDayNumberData = producer.getFrenchLastDayNumberData();
            databaseMapper.deleteTable("french_last_day_number_data");
            databaseMapper.saveFrenchLastDayNumberData(frenchLastDayNumberData);

        } catch (IOException e) {
            log.error("访问WHO数据失败！");
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
