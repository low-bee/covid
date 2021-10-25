package com.xiaolong.spider.bean.supper;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author xiaolong
 * @Date 2021/10/24 9:45 下午
 */
@NoArgsConstructor
@Data
public class SupperClass {

    @JsonProperty("ret")
    private Integer ret;
    @JsonProperty("info")
    private String info;
    @JsonProperty("data")
    private SupperData data;
}
