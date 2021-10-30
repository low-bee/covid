package com.xiaolong.homework.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 查询出来的数据库年龄数据库
 * @Author xiaolong
 * @Date 2021/10/30 9:57 下午
 */
@NoArgsConstructor
@Data
public class Covid19Deaths {
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
    @JsonProperty("year")
    private String year;
    @JsonProperty("month")
    private String month;
    @JsonProperty("day")
    private String day;
}
