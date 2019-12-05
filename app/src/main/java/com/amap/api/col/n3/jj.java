package com.amap.api.col.n3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogInfo */
public abstract class jj {
    @jc(a = "b2", b = 2)
    protected int a = -1;
    @jc(a = "b1", b = 6)
    protected String b;
    @jc(a = "b3", b = 2)
    protected int c = 1;
    @jc(a = "a1", b = 6)
    private String d;

    public final int a() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final String b() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(String str) {
        this.d = in.b(str);
    }

    public final int c() {
        return this.c;
    }

    public final void b(int i) {
        this.c = i;
    }

    public static String c(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("b1", str);
        return ja.a((Map<String, String>) hashMap);
    }

    public static String c(int i) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("b2=");
            sb.append(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
