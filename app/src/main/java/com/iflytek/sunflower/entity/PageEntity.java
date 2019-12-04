package com.iflytek.sunflower.entity;

public class PageEntity {
    public long duration;
    public String pageName;

    public PageEntity(String str, long j) {
        this.pageName = str;
        this.duration = j;
    }
}
