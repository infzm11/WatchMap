package com.iflytek.cloud.thirdparty;

import java.util.Map;

public class ad {
    private String a;
    private String b;
    private String c;
    private String d;
    private Map<String, byte[]> e;
    private long f;
    private boolean g;

    public ad() {
    }

    public ad(String str, String str2, String str3, String str4, Map<String, byte[]> map, long j, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = map;
        this.f = j;
        this.g = z;
    }

    public String a() {
        return this.b;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public Map<String, byte[]> d() {
        return this.e;
    }

    public long e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }
}
