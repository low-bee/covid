package com.xiaolong.spider.bean.data;

import com.xiaolong.spider.bean.supper.SupperData;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

/**
 * @Description: 省份比较数据
 * @Author xiaolong
 * @Date 2021/10/24 7:12 下午
 */
@Data
@NoArgsConstructor
public class ProvinceCompare implements SupperData {


    private HashMap<String, ProvinceData> provinceData = new HashMap<>();

}
