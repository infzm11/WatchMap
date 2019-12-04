package com.iflytek.cloud.thirdparty;

public class n extends Exception {
    private static final long serialVersionUID = 2569308067518897199L;
    private int a = 0;
    private String b = "";

    public n(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
