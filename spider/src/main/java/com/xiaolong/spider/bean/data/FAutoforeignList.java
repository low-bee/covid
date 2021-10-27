package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 国外国家数据
 * @Author xiaolong
 * @Date 2021/10/24 7:21 下午
 */
@NoArgsConstructor
@Data
public class FAutoforeignList implements SupperData {

    @JsonProperty("name")
    private String name;
    @JsonProperty("continent")
    private String continent;
    @JsonProperty("y")
    private String y;
    @JsonProperty("date")
    private String date;
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
    @JsonProperty("nowConfirm")
    private Integer nowConfirm;
    @JsonProperty("confirmCompare")
    private Integer confirmCompare;
    @JsonProperty("nowConfirmCompare")
    private Integer nowConfirmCompare;
    @JsonProperty("healCompare")
    private Integer healCompare;
    @JsonProperty("deadCompare")
    private Integer deadCompare;
    @JsonProperty("children")
    private List<ForeignProvince> foreignProvince;


}
