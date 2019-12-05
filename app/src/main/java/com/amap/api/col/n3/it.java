package com.amap.api.col.n3;

import java.util.HashMap;
import java.util.Map;

/* compiled from: LogUpdateRequest */
public final class it extends kj {
    private byte[] a;
    private String b = "1";

    public final Map<String, String> b() {
        return null;
    }

    public it(byte[] bArr) {
        this.a = (byte[]) bArr.clone();
    }

    public it(byte[] bArr, String str) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
    }

    public final Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.a.length));
        return hashMap;
    }

    public final String c() {
        String c = in.c(ip.b);
        byte[] a2 = in.a(ip.a);
        byte[] bArr = new byte[(a2.length + 50)];
        System.arraycopy(this.a, 0, bArr, 0, 50);
        System.arraycopy(a2, 0, bArr, 50, a2.length);
        return String.format(c, new Object[]{"1", this.b, "1", "open", ij.a(bArr)});
    }

    public final byte[] f() {
        return this.a;
    }
}
