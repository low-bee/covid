package com.xiaolong.spider.bean.foreign;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 法国新冠疫情数据条目
 *
 * @Author xiaolong
 * @Date 2021/10/31 9:11 上午
 */
@NoArgsConstructor
@Data
public class FrenchCovidHospitalData {
    /**
     * 地区
     */
    private String department;
    private Integer sex;
    private String date;
    /**
     * Number of people currently hospitalized
     */
    private Integer hospitalized;
    /**
     * Number of people currently in resuscitation or critical care
      */
    private Integer resuscitation;
    /**
     * 	Total amount of patient that returned home
     */
    private Integer returnHome;
    /**
     * Total amount of deaths at the hospital
     */
    private Integer dc;
    /**
     * 当前在ssr或者USLD服务中的人数（重症）
     */
    private Integer ssrOrUSLD;
    /**
     * 常规医院服务中的人数
     */
    private Integer hospconv;

    /**
     * 接受其他类型服务人数
     */
    private Integer otherService;
}
