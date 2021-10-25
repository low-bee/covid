package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/10/24 7:33 下午
 */
@NoArgsConstructor
@Data
public class WomWorld implements SupperData {

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
