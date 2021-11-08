package com.xiaolong.homework.bean.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 数据查询Bo
 * @Author xiaolong
 * @Date 2021/11/8 8:51 上午
 */
@Data
@NoArgsConstructor
public class QueryAmericaDeadBo {

    @JsonProperty("data_as_of")
    private String dataAsOf;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("state")
    private String state;
    @JsonProperty("sex")
    private String sex;
    @JsonProperty("age_group")
    private String ageGroup;
    @JsonProperty("group")
    private String group;

}
