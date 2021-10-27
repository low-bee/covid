package com.xiaolong.spider.enumc;

public enum ForeignRequestPram {

    FAutoCountryConfirmAdd("FAutoCountryConfirmAdd"),
    WomWorld("WomWorld"),
    WomAboard("WomAboard"),
    FAutoForeignList("FAutoforeignList");

    private String code ;

    ForeignRequestPram(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
