package com.xiaolong.homework.bean.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 将国家死亡数据返回给前端
 * @Author xiaolong
 * @Date 2021/11/7 11:15 上午
 */
@Data
@NoArgsConstructor
public class CountryDeathsByAge {
    @JsonProperty("country")
    private String country;
    @JsonProperty("age")
    private String age;
    @JsonProperty("state")
    private String state;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("deaths_number")
    private String deathsNumber;
    @JsonProperty("date")
    private String date;
    @JsonProperty("total_deaths")
    private String totalDeaths;
    @JsonProperty("pneumonia_deaths")
    private String pneumoniaDeaths;
    @JsonProperty("pneumonia_and_covid19_deaths")
    private String pneumoniaAndCovid19Deaths;
    @JsonProperty("influenza_deaths")
    private String influenzaDeaths;
    @JsonProperty("pneumonia_influenza_or_covid")
    private String pneumoniaInfluenzaOrCovid;

}
