package com.xiaolong.spider.bean.foreign;

import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 保存来自数据WHO的疫情数据
 * @Author xiaolong
 * @Date 2021/10/28 6:03 下午
 */
@NoArgsConstructor
@Data
public class WHOCovid19 implements SupperData {

    private String dateReported;
    private String countryCode;
    private String country;
    private String wHORegion;
    private Integer newCases;
    private Integer cumulativeCases;
    private Integer newDeaths;
    private Integer cumulativeDeaths;
}
