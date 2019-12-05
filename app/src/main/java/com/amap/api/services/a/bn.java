package com.amap.api.services.a;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public class bn extends dd {
    private byte[] a;
    private String b = "1";

    public Map<String, String> d() {
        return null;
    }

    public bn(byte[] bArr) {
        this.a = (byte[]) bArr.clone();
    }

    public bn(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    private String a() {
        byte[] a2 = bi.a(bj.a);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return bf.a(bArr);
    }

    public Map<String, String> e() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    public String i() {
        return String.format(bj.b, new Object[]{"1", this.b, "1", "open", a()});
    }

    public byte[] h() {
        return this.a;
    }
}
