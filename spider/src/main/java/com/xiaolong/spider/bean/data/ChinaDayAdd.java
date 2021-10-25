package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 中国每日新增
 * @Author xiaolong
 * @Date 2021/10/24 7:06 下午
 */
@NoArgsConstructor
@Data
public class ChinaDayAdd implements SupperData {

    @JsonProperty("localConfirmadd")
    private Integer localConfirmadd;
    @JsonProperty("deadRate")
    private String deadRate;
    @JsonProperty("healRate")
    private String healRate;
    @JsonProperty("date")
    private String date;
    @JsonProperty("dead")
    private Integer dead;
    @JsonProperty("heal")
    private Integer heal;
    @JsonProperty("infect")
    private Integer infect;
    @JsonProperty("localinfectionadd")
    private Integer localinfectionadd;
    @JsonProperty("confirm")
    private Integer confirm;
    @JsonProperty("suspect")
    private Integer suspect;
    @JsonProperty("importedCase")
    private Integer importedCase;
    @JsonProperty("y")
    private String y;
}
