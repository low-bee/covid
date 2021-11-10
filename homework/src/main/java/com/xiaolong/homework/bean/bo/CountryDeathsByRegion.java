package com.xiaolong.homework.bean.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 分区域数据对象
 * @Author xiaolong
 * @Date 2021/11/9 10:45 上午
 */
@Data
@NoArgsConstructor
public class CountryDeathsByRegion {

    @JsonProperty("name")
    private String name;
    @JsonProperty("date")
    private String date;
    @JsonProperty("name_map")
    private String nameMap;
    @JsonProperty("confirm")
    private String confirm;
    @JsonProperty("dead")
    private String dead;
    @JsonProperty("heal")
    private String heal;

}
