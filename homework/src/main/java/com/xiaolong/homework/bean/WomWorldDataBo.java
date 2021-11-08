package com.xiaolong.homework.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 返回的世界数据Bo对象
 * @Author xiaolong
 * @Date 2021/11/5 7:22 上午
 */
@Data
@NoArgsConstructor
public class WomWorldDataBo {

    @JsonProperty("PubDate")
    private String pubDate;
    @JsonProperty("y")
    private String y;
    @JsonProperty("date")
    private String date;
    @JsonProperty("nowConfirm")
    private Integer nowConfirm;
    @JsonProperty("nowConfirmAdd")
    private Integer nowConfirmAdd;
    @JsonProperty("confirm")
    private Integer confirm;
    @JsonProperty("confirmAdd")
    private Integer confirmAdd;
    @JsonProperty("heal")
    private Integer heal;
    @JsonProperty("healAdd")
    private Integer healAdd;
    @JsonProperty("dead")
    private Integer dead;
    @JsonProperty("deadAdd")
    private Integer deadAdd;
    @JsonProperty("deathrate")
    private Integer deathrate;
    @JsonProperty("curerate")
    private Integer curerate;
    @JsonProperty("lastUpdateTime")
    private String lastUpdateTime;
}
