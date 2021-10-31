package com.xiaolong.spider.bean.foreign;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: French age data from https://www.data.gouv.fr/fr/datasets/r/08c18e08-6780-452d-9b8c-ae244ad529b3
 * @Author xiaolong
 * @Date 2021/10/31 8:29 下午
 */
@Data
@NoArgsConstructor
public class FrenchCovidAgeData {
    /**
     * 	Region
     */
    private String region;

    /**
     * Age group
     */
    private String 	ageGroup;

    /**
     *	Date of notice
     */
    private String 	dateOfNotice;

    /**
     * Number of people currently hospitalized
     */
    private String currHospitalized;

    /**
     * Number of people currently in resuscitation or critical care
     */
    private String resuscitation;

    /**
     * 	Total amount of patient that returned home
     */
    private String returnHome;

    /**
     * 	Total amout of deaths
     */
    private String totalDeaths;

    /**
     * ssr_usld 当前处在ssr和usld状态中的人（重症）
     */
    private String ssrUsld;

    /**
     * 常规医院服务中的人数
     */
    private Integer hospconv;

    /**
     * 接受其他类型服务人数
     */
    private Integer otherService;

}
