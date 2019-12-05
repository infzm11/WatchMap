package com.amap.api.col.n3;

@jb(a = "update_item_file")
/* compiled from: DTFileInfo */
class ay {
    @jc(a = "mAdcode", b = 6)
    private String a = "";
    @jc(a = "file", b = 6)
    private String b = "";

    public ay() {
    }

    public ay(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.b;
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }
}
