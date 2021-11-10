package com.xiaolong.homework.dao;

import com.xiaolong.homework.bean.Covid19Death;
import com.xiaolong.homework.bean.WomWorldDataBo;
import com.xiaolong.homework.bean.bo.ContinentStatus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Description: homework Mapper
 * @Author xiaolong
 * @Date 2021/10/30 9:13 上午
 */
@Mapper
@Repository
public interface HomeworkMapper {

    Set<String> getCountrySet();

    List<Covid19Death> getCountryAge(String country);

    WomWorldDataBo getWomWorldData();

    List<ContinentStatus> getContinentStatus();
}
