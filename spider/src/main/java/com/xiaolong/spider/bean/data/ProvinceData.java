package com.xiaolong.spider.bean.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 国内省份数据
 * @Author xiaolong
 * @Date 2021/10/24 7:14 下午
 */
@NoArgsConstructor
@Data
public class ProvinceData implements SupperData {

    @JsonProperty("heal")
    private Integer heal;
    @JsonProperty("零日天数")
    private Integer zero;
    @JsonProperty("nowConfirm")
    private Integer nowConfirm;
    @JsonProperty("confirmAdd")
    private Integer confirmAdd;
    @JsonProperty("dead")
    private Integer dead;
}
