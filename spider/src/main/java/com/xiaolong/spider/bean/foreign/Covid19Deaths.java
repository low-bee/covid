package com.xiaolong.spider.bean.foreign;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 创建Covid19Deaths类
 * @Author xiaolong
 * @Date 2021/10/28 10:38 上午
 */
@NoArgsConstructor
@Data
public class Covid19Deaths implements SupperData {


    @JsonProperty("data_as_of")
    private String dataAsOf;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("group")
    private String group;
    @JsonProperty("state")
    private String state;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age_group")
    private String ageGroup;
    @JsonProperty("covid_19_deaths")
    private Integer covid19Deaths;
    @JsonProperty("total_deaths")
    private Integer totalDeaths;
    @JsonProperty("pneumonia_deaths")
    private Integer pneumoniaDeaths;
    @JsonProperty("pneumonia_and_covid_19_deaths")
    private Integer pneumoniaAndCovid19Deaths;
    @JsonProperty("influenza_deaths")
    private Integer influenzaDeaths;
    @JsonProperty("pneumonia_influenza_or_covid")
    private Integer pneumoniaInfluenzaOrCovid;
    @JsonProperty("footnote")
    private String footnote;
}
