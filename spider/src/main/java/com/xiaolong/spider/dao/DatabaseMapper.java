package com.xiaolong.spider.dao;

import com.xiaolong.spider.bean.data.*;
import com.xiaolong.spider.bean.foreign.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: 一个数据库接口
 * @Author xiaolong
 * @Date 2021/10/25 11:32 上午
 */

@Mapper
@Repository
public interface DatabaseMapper {

    void saveChinaDayAdd(List<ChinaDayAddList> chinaDayAddList);

    void saveChinaDay(List<ChinaDayList> chinaDayLists);

    void saveNowConfirmStatis(List<NowConfirmStatis> nowConfirmStatis);

    void saveProvinceCompare(List<ProvinceCompare> provinceCompare);

    void saveForeignData(List<FAutoforeignList> fAutoforeignList);

    void saveForeignProvince(List<ForeignProvince> foreignProvince);

    void saveWomAboard(List<WomAboard> womAboard);

    void saveWomWorld(List<WomWorld> womWorld);

    void deleteTable(@Param("tableName") String tableName);

    void saveDataFromDataCdcGov(List<Covid19Deaths> dataFromDataCdcGov);

    void saveDataFromWHO(List<WHOCovid19> dataFromWHO);

    void savaFrenchCovidHospitalData(List<FrenchCovidHospitalData> frenchCovidHospitalData);

    void saveFrenchAgeData(List<FrenchCovidAgeData> frenchCovidAgeData);

    void saveFrenchLastDayNumberData(List<FrenchLastDayNumberData> frenchLastDayNumberData);
}
