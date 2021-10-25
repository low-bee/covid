package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/10/24 7:35 下午
 */
@NoArgsConstructor
@Data
public class WomAboard implements SupperData {
    @JsonProperty("continent")
    private String continent;
    @JsonProperty("name")
    private String name;
    @JsonProperty("confirm")
    private Integer confirm;
    @JsonProperty("confirmAdd")
    private Integer confirmAdd;
    @JsonProperty("dead")
    private Integer dead;
    @JsonProperty("deadCompare")
    private Integer deadCompare;
    @JsonProperty("heal")
    private Integer heal;
    @JsonProperty("healCompare")
    private Integer healCompare;
    @JsonProperty("pub_date")
    private String pubDate;
    @JsonProperty("y")
    private String y;
    @JsonProperty("date")
    private String date;
    @JsonProperty("nowConfirm")
    private Integer nowConfirm;
    @JsonProperty("nowConfirmCompare")
    private Integer nowConfirmCompare;
    @JsonProperty("confirmAddCut")
    private Integer confirmAddCut;
    @JsonProperty("suspect")
    private Integer suspect;
    @JsonProperty("confirmCompare")
    private Integer confirmCompare;
}
