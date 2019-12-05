package com.amap.api.col.n3;

import android.content.Context;
import java.util.Map;

/* compiled from: BasicHandler */
public abstract class hw<T, V> extends kj {
    protected T a;
    protected int b = 1;
    protected String c = "";
    protected Context d;
    protected String e;
    private int i = 1;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws hv;

    public Map<String, String> a() {
        return null;
    }

    public Map<String, String> b() {
        return null;
    }

    public hw(Context context, T t) {
        this.d = context;
        this.a = t;
        this.b = 1;
        b(30000);
        a(30000);
    }

    private V a(byte[] bArr) throws hv {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = this.e;
        hy.a(str);
        return a(str);
    }

    public final V d() throws hv {
        if (this.a != null) {
            return e();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        throw new com.amap.api.col.n3.hv(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        throw new com.amap.api.col.n3.hv(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        java.lang.Thread.sleep((long) (r6.i * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        throw new com.amap.api.col.n3.hv(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        throw new com.amap.api.col.n3.hv(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c4, code lost:
        throw new com.amap.api.col.n3.hv(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        throw new com.amap.api.col.n3.hv(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ExcHandler: Throwable (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[SYNTHETIC, Splitter:B:23:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0002 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V e() throws com.amap.api.col.n3.hv {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r6.b
            if (r1 >= r2) goto L_0x00cd
            com.amap.api.col.n3.ki r2 = com.amap.api.col.n3.ki.c()     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            android.content.Context r3 = r6.d     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            java.net.Proxy r3 = com.amap.api.col.n3.ik.a(r3)     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            r6.a((java.net.Proxy) r3)     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            byte[] r2 = r2.a((com.amap.api.col.n3.kj) r6)     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            java.lang.Object r2 = r6.a((byte[]) r2)     // Catch:{ ic -> 0x0043, hv -> 0x0032, Throwable -> 0x002a }
            int r0 = r6.b     // Catch:{ ic -> 0x0025, hv -> 0x0020, Throwable -> 0x002a }
            r1 = r0
            r0 = r2
            goto L_0x0002
        L_0x0020:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0033
        L_0x0025:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0044
        L_0x002a:
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = "未知错误"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            r2 = move-exception
        L_0x0033:
            int r1 = r1 + 1
            int r3 = r6.b
            if (r1 < r3) goto L_0x0002
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x0043:
            r2 = move-exception
        L_0x0044:
            int r1 = r1 + 1
            int r3 = r6.b
            if (r1 >= r3) goto L_0x008a
            int r3 = r6.i     // Catch:{ InterruptedException -> 0x0053 }
            int r3 = r3 * 1000
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x0053 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0053 }
            goto L_0x0002
        L_0x0053:
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0082
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0082
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0078
            goto L_0x0082
        L_0x0078:
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x0082:
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            r0.<init>(r1)
            throw r0
        L_0x008a:
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "未知的错误"
            java.lang.String r1 = r2.a()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00bb
            goto L_0x00c5
        L_0x00bb:
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x00c5:
            com.amap.api.col.n3.hv r0 = new com.amap.api.col.n3.hv
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            r0.<init>(r1)
            throw r0
        L_0x00cd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hw.e():java.lang.Object");
    }
}
