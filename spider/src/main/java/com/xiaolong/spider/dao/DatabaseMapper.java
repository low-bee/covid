package com.xiaolong.spider.dao;

import com.xiaolong.spider.bean.data.ChinaDayAdd;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: 一个数据库接口
 * @Author xiaolong
 * @Date 2021/10/25 11:32 上午
 */

@Mapper
public interface DatabaseMapper {

    void saveChinaDayAdd(List<ChinaDayAdd> chinaDayAddList);

}
