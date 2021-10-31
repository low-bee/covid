package com.xiaolong.spider.bean.foreign;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 法国二十四小时新入重症人数，并且提供了地区到地区名映射
 * @Author xiaolong
 * @Date 2021/10/31 9:21 上午
 */
@NoArgsConstructor
@Data
public class FrenchLastDayNumberData {

    private String date;
    /**
     * Region name
     */
    private String regionName;
    /**
     * Region number
     */
    private Integer regionNumber;
    /**
     * Number of new intensive care admissions in the last 24 hours
     */
    private Integer lastDayIntensiveNumber;
}
