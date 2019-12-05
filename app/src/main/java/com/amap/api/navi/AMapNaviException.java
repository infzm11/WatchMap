package com.amap.api.navi;

public class AMapNaviException extends Exception {
    public static final String CALCULATE_ROUTE_FAILURE = "算路失败";
    public static final String ERROR_UNKNOWN = "未知的错误";
    public static final String ILLEGAL_ARGUMENT = "非法参数";
    private String mDetailMessage = "未知的错误";

    public AMapNaviException(String str) {
        super(str);
        this.mDetailMessage = str;
    }

    public AMapNaviException() {
    }

    public String getErrorMessage() {
        return this.mDetailMessage;
    }
}
