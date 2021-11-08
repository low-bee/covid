package com.xiaolong.homework.dao;

import com.xiaolong.homework.bean.Covid19Death;
import com.xiaolong.homework.bean.bo.QueryAmericaDeadBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/11/8 9:18 上午
 */
@Mapper
@Repository
public interface AmericaMapper {
    List<Covid19Death> query(@Param("queryAmericaDeadBo") QueryAmericaDeadBo queryAmericaDeadBo);
}
