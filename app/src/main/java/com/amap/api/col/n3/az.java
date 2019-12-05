package com.amap.api.col.n3;

@jb(a = "update_item")
/* compiled from: DTInfo */
public class az {
    @jc(a = "title", b = 6)
    protected String a = null;
    @jc(a = "url", b = 6)
    protected String b = null;
    @jc(a = "mAdcode", b = 6)
    protected String c = null;
    @jc(a = "fileName", b = 6)
    protected String d = null;
    @jc(a = "version", b = 6)
    protected String e = "";
    @jc(a = "lLocalLength", b = 5)
    protected long f = 0;
    @jc(a = "lRemoteLength", b = 5)
    protected long g = 0;
    @jc(a = "localPath", b = 6)
    protected String h;
    @jc(a = "isProvince", b = 2)
    protected int i = 0;
    @jc(a = "mCompleteCode", b = 2)
    protected int j;
    @jc(a = "mCityCode", b = 6)
    protected String k = "";
    @jc(a = "mState", b = 2)
    public int l;
    @jc(a = "mPinyin", b = 6)
    public String m = "";

    public final String c() {
        return this.a;
    }

    public final String d() {
        return this.e;
    }

    public final String e() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final int f() {
        return this.j;
    }

    public final void d(String str) {
        this.k = str;
    }

    public final String g() {
        return this.m;
    }

    public static String e(String str) {
        return "mAdcode" + "='" + str + "'";
    }

    public static String f(String str) {
        return "mPinyin" + "='" + str + "'";
    }
}
