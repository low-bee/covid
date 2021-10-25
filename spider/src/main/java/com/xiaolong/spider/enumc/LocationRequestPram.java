package com.xiaolong.spider.enumc;

public enum LocationRequestPram {
    chinaDayList("chinaDayList"),
    chinaDayAddList("chinaDayAddList"),
    nowConfirmStatis("nowConfirmStatis"),
    provinceCompare("provinceCompare");

    private String code;

    LocationRequestPram(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
