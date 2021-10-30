package com.xiaolong.homework.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: covid19 查询数据 bo 对象
 * @Author xiaolong
 * @Date 2021/10/30 10:23 下午
 */
@Data
@NoArgsConstructor
public class Covid19DeathBo {

    private String dataAsOf;
    private String startDate;
    private String endData;
    private String group;
    private String state;
    private String sex;
    private String ageGroup;
}
