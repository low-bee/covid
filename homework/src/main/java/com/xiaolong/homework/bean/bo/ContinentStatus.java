package com.xiaolong.homework.bean.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 大洲状态数据
 * @Author xiaolong
 * @Date 2021/11/10 9:13 下午
 */
@Data
@NoArgsConstructor
public class ContinentStatus {

    @JsonProperty("continent")
    private String continent;
    @JsonProperty("confirm")
    private Long confirm;
    @JsonProperty("confirm_add")
    private Integer confirmAdd;
    @JsonProperty("dead")
    private Long dead;
    @JsonProperty("dead_compare")
    private Integer deadCompare;
    @JsonProperty("heal")
    private Long heal;
    @JsonProperty("heal_compare")
    private Integer healCompare;

}
