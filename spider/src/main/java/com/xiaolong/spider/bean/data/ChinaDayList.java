package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 中国每日数据
 * @Author xiaolong
 * @Date 2021/10/24 7:02 下午
 */
@NoArgsConstructor
@Data
public class ChinaDayList implements SupperData {

    @JsonProperty("nowConfirm")
    private Integer nowConfirm;
    @JsonProperty("y")
    private String y;
    @JsonProperty("confirm")
    private Integer confirm;
    @JsonProperty("deadRate")
    private String deadRate;
    @JsonProperty("date")
    private String date;
    @JsonProperty("localConfirm")
    private Integer localConfirm;
    @JsonProperty("localConfirmH5")
    private Integer localConfirmH5;
    @JsonProperty("nowSevere")
    private Integer nowSevere;
    @JsonProperty("noInfect")
    private Integer noInfect;
    @JsonProperty("suspect")
    private Integer suspect;
    @JsonProperty("heal")
    private Integer heal;
    @JsonProperty("importedCase")
    private Integer importedCase;
    @JsonProperty("healRate")
    private String healRate;
    @JsonProperty("noInfectH5")
    private Integer noInfectH5;
    @JsonProperty("local_acc_confirm")
    private Integer localAccConfirm;
    @JsonProperty("dead")
    private Integer dead;

}
