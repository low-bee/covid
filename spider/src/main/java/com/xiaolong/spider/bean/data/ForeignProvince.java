package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 国外省份数据
 * @Author xiaolong
 * @Date 2021/10/24 7:23 下午
 */
@NoArgsConstructor
@Data
public class ForeignProvince implements SupperData {

    @JsonProperty("name")
    private String name;
    @JsonProperty("date")
    private String date;
    @JsonProperty("nameMap")
    private String nameMap;
    @JsonProperty("isUpdated")
    private Boolean isUpdated;
    @JsonProperty("confirmAdd")
    private Integer confirmAdd;
    @JsonProperty("confirmAddCut")
    private Integer confirmAddCut;
    @JsonProperty("confirm")
    private Integer confirm;
    @JsonProperty("suspect")
    private Integer suspect;
    @JsonProperty("dead")
    private Integer dead;
    @JsonProperty("heal")
    private Integer heal;

    private String country;


}
