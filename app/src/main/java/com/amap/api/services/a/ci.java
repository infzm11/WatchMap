package com.amap.api.services.a;

/* compiled from: DexDownloadItem */
public class ci {
    String a;
    String b;
    String c;
    String d;
    String e;
    int f;
    int g;
    private String h;
    private String i;

    public ci(String str, String str2, String str3) {
        this.h = str;
        this.i = str2;
        try {
            String[] split = str.split("/");
            int length = split.length;
            if (length > 1) {
                this.a = split[length - 1];
                String[] split2 = this.a.split("_");
                this.b = split2[0];
                this.c = split2[2];
                this.d = split2[1];
                this.f = Integer.parseInt(split2[3]);
                this.g = Integer.parseInt(split2[4].split("\\.")[0]);
            }
        } catch (Throwable th) {
            cs.a(th, "DexDownloadItem", "DexDownloadItem");
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.c;
    }
}
