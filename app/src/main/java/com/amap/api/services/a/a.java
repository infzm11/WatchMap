package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import java.util.Map;

/* compiled from: BasicHandler */
public abstract class a<T, V> extends dd {
    protected T a;
    protected int b = 1;
    protected String c = "";
    protected Context d;
    protected String e = "";
    private int i = 1;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws AMapException;

    public Map<String, String> d() {
        return null;
    }

    public Map<String, String> e() {
        return null;
    }

    /* access modifiers changed from: protected */
    public V f() {
        return null;
    }

    public a(Context context, T t) {
        a(context, t);
    }

    private void a(Context context, T t) {
        this.d = context;
        this.a = t;
        this.b = 1;
        b(ServiceSettings.getInstance().getSoTimeOut());
        a(ServiceSettings.getInstance().getConnectionTimeOut());
    }

    public String a() {
        return this.e;
    }

    public String b() {
        String i2 = i();
        if (i2 == null) {
            return null;
        }
        try {
            int indexOf = i2.indexOf(".com/");
            int indexOf2 = i2.indexOf("?");
            if (indexOf2 == -1) {
                return i2.substring(indexOf + ".com/".length());
            }
            return i2.substring(indexOf + ".com/".length(), indexOf2);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e2) {
            i.a(e2, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.b(str);
        return a(str);
    }

    public V c() throws AMapException {
        if (this.a == null) {
            return null;
        }
        try {
            return g();
        } catch (AMapException e2) {
            af.a(b(), a(), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004d, code lost:
        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0064, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        java.lang.Thread.sleep((long) (r12.i * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r6.getMessage()) != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b4, code lost:
        throw new com.amap.api.services.core.AMapException(r6.a(), 1, r6.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, r6.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c1, code lost:
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ce, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r6.getMessage()) != false) goto L_0x0103;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0102, code lost:
        throw new com.amap.api.services.core.AMapException(r6.a(), 1, r6.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x010e, code lost:
        throw new com.amap.api.services.core.AMapException(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION, 1, r6.c());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[ExcHandler: Throwable (unused java.lang.Throwable), SYNTHETIC, Splitter:B:4:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A[SYNTHETIC, Splitter:B:23:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0063 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V g() throws com.amap.api.services.core.AMapException {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r2 = r1
            r1 = r0
        L_0x0004:
            int r3 = r12.b
            if (r1 >= r3) goto L_0x010f
            long r3 = java.lang.System.currentTimeMillis()
            r5 = 1
            com.amap.api.services.core.ServiceSettings r6 = com.amap.api.services.core.ServiceSettings.getInstance()     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            int r6 = r6.getProtocol()     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            com.amap.api.services.a.dc r7 = com.amap.api.services.a.dc.a((boolean) r0)     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            android.content.Context r8 = r12.d     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            java.net.Proxy r8 = com.amap.api.services.a.bg.a((android.content.Context) r8)     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            r12.a((java.net.Proxy) r8)     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            byte[] r6 = r12.a(r6, r7, r12)     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            java.lang.Object r6 = r12.b(r6)     // Catch:{ ay -> 0x0064, AMapException -> 0x004e, Throwable -> 0x0046 }
            android.content.Context r2 = r12.d     // Catch:{ ay -> 0x0041, AMapException -> 0x003d, Throwable -> 0x0046 }
            java.lang.String r9 = r12.b()     // Catch:{ ay -> 0x0041, AMapException -> 0x003d, Throwable -> 0x0046 }
            long r7 = r7 - r3
            com.amap.api.services.a.af.a(r2, r9, r7, r5)     // Catch:{ ay -> 0x0041, AMapException -> 0x003d, Throwable -> 0x0046 }
            int r2 = r12.b     // Catch:{ ay -> 0x0041, AMapException -> 0x003d, Throwable -> 0x0046 }
            r1 = r2
            r2 = r6
            goto L_0x0004
        L_0x003d:
            r2 = move-exception
            r5 = r2
            r2 = r6
            goto L_0x004f
        L_0x0041:
            r2 = move-exception
            r11 = r6
            r6 = r2
            r2 = r11
            goto L_0x0065
        L_0x0046:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException
            java.lang.String r1 = "未知错误"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            r5 = move-exception
        L_0x004f:
            long r6 = java.lang.System.currentTimeMillis()
            android.content.Context r8 = r12.d
            java.lang.String r9 = r12.b()
            long r6 = r6 - r3
            com.amap.api.services.a.af.a(r8, r9, r6, r0)
            int r1 = r1 + 1
            int r3 = r12.b
            if (r1 < r3) goto L_0x0004
            throw r5
        L_0x0064:
            r6 = move-exception
        L_0x0065:
            long r7 = java.lang.System.currentTimeMillis()
            android.content.Context r9 = r12.d
            java.lang.String r10 = r12.b()
            long r7 = r7 - r3
            com.amap.api.services.a.af.a(r9, r10, r7, r0)
            int r1 = r1 + 1
            int r3 = r12.b
            if (r1 >= r3) goto L_0x00c1
            int r3 = r12.i     // Catch:{ InterruptedException -> 0x0082 }
            int r3 = r3 * 1000
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x0082 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0082 }
            goto L_0x0004
        L_0x0082:
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b5
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00a7
            goto L_0x00b5
        L_0x00a7:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException
            java.lang.String r1 = r6.a()
            java.lang.String r2 = r6.c()
            r0.<init>(r1, r5, r2)
            throw r0
        L_0x00b5:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            java.lang.String r2 = r6.c()
            r0.<init>(r1, r5, r2)
            throw r0
        L_0x00c1:
            r12.f()
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0103
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0103
            java.lang.String r0 = "未知的错误"
            java.lang.String r1 = r6.a()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0103
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r6.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00f5
            goto L_0x0103
        L_0x00f5:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException
            java.lang.String r1 = r6.a()
            java.lang.String r2 = r6.c()
            r0.<init>(r1, r5, r2)
            throw r0
        L_0x0103:
            com.amap.api.services.core.AMapException r0 = new com.amap.api.services.core.AMapException
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            java.lang.String r2 = r6.c()
            r0.<init>(r1, r5, r2)
            throw r0
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.a.g():java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public byte[] a(int i2, dc dcVar, dd ddVar) throws ay {
        df dfVar;
        if (i2 == 1) {
            dfVar = dcVar.a(ddVar, false);
        } else {
            dfVar = i2 == 2 ? dcVar.a(ddVar, true) : null;
        }
        if (dfVar == null) {
            return null;
        }
        byte[] bArr = dfVar.a;
        this.e = dfVar.d;
        return bArr;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }
}
