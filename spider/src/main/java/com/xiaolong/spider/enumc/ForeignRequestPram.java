package com.xiaolong.spider.enumc;

public enum ForeignRequestPram {

    FAutoCountryConfirmAdd(0),
    WomWorld(1),
    WomAboard(2),
    FAutoForeignList(3);

    private int code ;

    ForeignRequestPram(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
