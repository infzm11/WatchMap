package com.amap.api.services.a;

import android.os.Build;
import com.amap.api.services.a.cx;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

/* compiled from: HttpUrlUtil */
public class da {
    private static db a;
    private int b;
    private int c;
    private boolean d;
    private SSLContext e;
    private Proxy f;
    private volatile boolean g;
    private long h;
    private long i;
    private String j;
    private cx.a k;
    private HostnameVerifier l;

    private void a() {
        try {
            this.j = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            bl.a(th, "HttpUrlUtil", "initCSID");
        }
    }

    public static void a(db dbVar) {
        a = dbVar;
    }

    da(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, (cx.a) null);
    }

    da(int i2, int i3, Proxy proxy, boolean z, cx.a aVar) {
        this.g = false;
        this.h = -1;
        this.i = 0;
        this.l = new HostnameVerifier() {
            public boolean verify(String str, SSLSession sSLSession) {
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                return defaultHostnameVerifier.verify("*.amap.com", sSLSession) || defaultHostnameVerifier.verify("*.apilocate.amap.com", sSLSession);
            }
        };
        this.b = i2;
        this.c = i3;
        this.f = proxy;
        this.d = z;
        this.k = aVar;
        a();
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.e = instance;
            } catch (Throwable th) {
                bl.a(th, "HttpUtil", "HttpUtil");
            }
        }
    }

    da(int i2, int i3, Proxy proxy) {
        this(i2, i3, proxy, false);
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.i = j2;
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.h = j2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fc A[SYNTHETIC, Splitter:B:64:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0113 A[SYNTHETIC, Splitter:B:71:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0123 A[SYNTHETIC, Splitter:B:77:0x0123] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013a A[SYNTHETIC, Splitter:B:84:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.util.Map<java.lang.String, java.lang.String> r10, com.amap.api.services.a.cz.a r11) {
        /*
            r7 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.String r10 = a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            r1.<init>()     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            r1.append(r8)     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            if (r10 == 0) goto L_0x001a
            java.lang.String r8 = "?"
            r1.append(r8)     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            r1.append(r10)     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
        L_0x001a:
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            r10 = 0
            java.net.HttpURLConnection r8 = r7.a((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r9, (boolean) r10)     // Catch:{ Throwable -> 0x00f4, all -> 0x00f0 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00ee }
            r9.<init>()     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r1 = "bytes="
            r9.append(r1)     // Catch:{ Throwable -> 0x00ee }
            long r1 = r7.i     // Catch:{ Throwable -> 0x00ee }
            r9.append(r1)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r1 = "-"
            r9.append(r1)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r1 = "RANGE"
            r8.setRequestProperty(r1, r9)     // Catch:{ Throwable -> 0x00ee }
            r8.connect()     // Catch:{ Throwable -> 0x00ee }
            int r9 = r8.getResponseCode()     // Catch:{ Throwable -> 0x00ee }
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 1
            if (r9 == r1) goto L_0x004e
            r1 = r2
            goto L_0x004f
        L_0x004e:
            r1 = r10
        L_0x004f:
            r3 = 206(0xce, float:2.89E-43)
            if (r9 == r3) goto L_0x0054
            goto L_0x0055
        L_0x0054:
            r2 = r10
        L_0x0055:
            r1 = r1 & r2
            if (r1 == 0) goto L_0x007d
            com.amap.api.services.a.ay r1 = new com.amap.api.services.a.ay     // Catch:{ Throwable -> 0x00ee }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00ee }
            r2.<init>()     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r3 = "网络异常原因："
            r2.append(r3)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r3 = r8.getResponseMessage()     // Catch:{ Throwable -> 0x00ee }
            r2.append(r3)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r3 = " 网络异常状态码："
            r2.append(r3)     // Catch:{ Throwable -> 0x00ee }
            r2.append(r9)     // Catch:{ Throwable -> 0x00ee }
            java.lang.String r9 = r2.toString()     // Catch:{ Throwable -> 0x00ee }
            r1.<init>(r9)     // Catch:{ Throwable -> 0x00ee }
            r11.a(r1)     // Catch:{ Throwable -> 0x00ee }
        L_0x007d:
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ Throwable -> 0x00ee }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
        L_0x0085:
            boolean r2 = java.lang.Thread.interrupted()     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            if (r2 != 0) goto L_0x00be
            boolean r2 = r7.g     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            if (r2 != 0) goto L_0x00be
            int r2 = r9.read(r1, r10, r0)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            if (r2 <= 0) goto L_0x00be
            long r3 = r7.h     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00a5
            long r3 = r7.i     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            long r5 = r7.h     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00be
        L_0x00a5:
            if (r2 != r0) goto L_0x00ad
            long r3 = r7.i     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r11.a(r1, r3)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            goto L_0x00b7
        L_0x00ad:
            byte[] r3 = new byte[r2]     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            java.lang.System.arraycopy(r1, r10, r3, r10, r2)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            long r4 = r7.i     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r11.a(r3, r4)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
        L_0x00b7:
            long r3 = r7.i     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            long r5 = (long) r2     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            long r3 = r3 + r5
            r7.i = r3     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            goto L_0x0085
        L_0x00be:
            boolean r10 = r7.g     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            if (r10 == 0) goto L_0x00c6
            r11.e()     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            goto L_0x00c9
        L_0x00c6:
            r11.d()     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
        L_0x00c9:
            if (r9 == 0) goto L_0x00e0
            r9.close()     // Catch:{ IOException -> 0x00d8, Throwable -> 0x00cf }
            goto L_0x00e0
        L_0x00cf:
            r9 = move-exception
            java.lang.String r10 = "HttpUrlUtil"
            java.lang.String r11 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
            goto L_0x00e0
        L_0x00d8:
            r9 = move-exception
            java.lang.String r10 = "HttpUrlUtil"
            java.lang.String r11 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
        L_0x00e0:
            if (r8 == 0) goto L_0x011f
            r8.disconnect()     // Catch:{ Throwable -> 0x0117 }
            goto L_0x011f
        L_0x00e6:
            r10 = move-exception
            r0 = r9
            r9 = r10
            goto L_0x0121
        L_0x00ea:
            r10 = move-exception
            r0 = r9
            r9 = r10
            goto L_0x00f7
        L_0x00ee:
            r9 = move-exception
            goto L_0x00f7
        L_0x00f0:
            r8 = move-exception
            r9 = r8
            r8 = r0
            goto L_0x0121
        L_0x00f4:
            r8 = move-exception
            r9 = r8
            r8 = r0
        L_0x00f7:
            r11.a(r9)     // Catch:{ all -> 0x0120 }
            if (r0 == 0) goto L_0x0111
            r0.close()     // Catch:{ IOException -> 0x0109, Throwable -> 0x0100 }
            goto L_0x0111
        L_0x0100:
            r9 = move-exception
            java.lang.String r10 = "HttpUrlUtil"
            java.lang.String r11 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
            goto L_0x0111
        L_0x0109:
            r9 = move-exception
            java.lang.String r10 = "HttpUrlUtil"
            java.lang.String r11 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
        L_0x0111:
            if (r8 == 0) goto L_0x011f
            r8.disconnect()     // Catch:{ Throwable -> 0x0117 }
            goto L_0x011f
        L_0x0117:
            r8 = move-exception
            java.lang.String r9 = "HttpUrlUtil"
            java.lang.String r10 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r8, (java.lang.String) r9, (java.lang.String) r10)
        L_0x011f:
            return
        L_0x0120:
            r9 = move-exception
        L_0x0121:
            if (r0 == 0) goto L_0x0138
            r0.close()     // Catch:{ IOException -> 0x0130, Throwable -> 0x0127 }
            goto L_0x0138
        L_0x0127:
            r10 = move-exception
            java.lang.String r11 = "HttpUrlUtil"
            java.lang.String r0 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r10, (java.lang.String) r11, (java.lang.String) r0)
            goto L_0x0138
        L_0x0130:
            r10 = move-exception
            java.lang.String r11 = "HttpUrlUtil"
            java.lang.String r0 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r10, (java.lang.String) r11, (java.lang.String) r0)
        L_0x0138:
            if (r8 == 0) goto L_0x0146
            r8.disconnect()     // Catch:{ Throwable -> 0x013e }
            goto L_0x0146
        L_0x013e:
            r8 = move-exception
            java.lang.String r10 = "HttpUrlUtil"
            java.lang.String r11 = "makeDownloadGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r8, (java.lang.String) r10, (java.lang.String) r11)
        L_0x0146:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.da.a(java.lang.String, java.util.Map, java.util.Map, com.amap.api.services.a.cz$a):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0098 A[SYNTHETIC, Splitter:B:63:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.a.df a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, java.util.Map<java.lang.String, java.lang.String> r5) throws com.amap.api.services.a.ay {
        /*
            r2 = this;
            r0 = 0
            java.lang.String r5 = a((java.util.Map<java.lang.String, java.lang.String>) r5)     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            r1.<init>()     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            r1.append(r3)     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            if (r5 == 0) goto L_0x0017
            java.lang.String r3 = "?"
            r1.append(r3)     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            r1.append(r5)     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
        L_0x0017:
            java.lang.String r3 = r1.toString()     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            r5 = 0
            java.net.HttpURLConnection r3 = r2.a((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r5)     // Catch:{ ConnectException -> 0x008e, MalformedURLException -> 0x0086, UnknownHostException -> 0x007e, SocketException -> 0x0076, SocketTimeoutException -> 0x006e, InterruptedIOException -> 0x0066, IOException -> 0x005e, ay -> 0x005c, Throwable -> 0x0050 }
            com.amap.api.services.a.df r4 = r2.a((java.net.HttpURLConnection) r3)     // Catch:{ ConnectException -> 0x004c, MalformedURLException -> 0x004a, UnknownHostException -> 0x0048, SocketException -> 0x0046, SocketTimeoutException -> 0x0044, InterruptedIOException -> 0x0042, IOException -> 0x0040, ay -> 0x003c, Throwable -> 0x0038, all -> 0x0033 }
            if (r3 == 0) goto L_0x0032
            r3.disconnect()     // Catch:{ Throwable -> 0x002a }
            goto L_0x0032
        L_0x002a:
            r3 = move-exception
            java.lang.String r5 = "HttpUrlUtil"
            java.lang.String r0 = "makeGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r3, (java.lang.String) r5, (java.lang.String) r0)
        L_0x0032:
            return r4
        L_0x0033:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x0096
        L_0x0038:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x0051
        L_0x003c:
            r4 = move-exception
            r0 = r3
            r3 = r4
            goto L_0x005d
        L_0x0040:
            r0 = r3
            goto L_0x005e
        L_0x0042:
            r0 = r3
            goto L_0x0066
        L_0x0044:
            r0 = r3
            goto L_0x006e
        L_0x0046:
            r0 = r3
            goto L_0x0076
        L_0x0048:
            r0 = r3
            goto L_0x007e
        L_0x004a:
            r0 = r3
            goto L_0x0086
        L_0x004c:
            r0 = r3
            goto L_0x008e
        L_0x004e:
            r3 = move-exception
            goto L_0x0096
        L_0x0050:
            r3 = move-exception
        L_0x0051:
            r3.printStackTrace()     // Catch:{ all -> 0x004e }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x005c:
            r3 = move-exception
        L_0x005d:
            throw r3     // Catch:{ all -> 0x004e }
        L_0x005e:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "IO 操作异常 - IOException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x0066:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x006e:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "socket 连接超时 - SocketTimeoutException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x0076:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "socket 连接异常 - SocketException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x007e:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "未知主机 - UnKnowHostException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x0086:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "url异常 - MalformedURLException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x008e:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004e }
            java.lang.String r4 = "http连接失败 - ConnectionException"
            r3.<init>(r4)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x0096:
            if (r0 == 0) goto L_0x00a4
            r0.disconnect()     // Catch:{ Throwable -> 0x009c }
            goto L_0x00a4
        L_0x009c:
            r4 = move-exception
            java.lang.String r5 = "HttpUrlUtil"
            java.lang.String r0 = "makeGetRequest"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r0)
        L_0x00a4:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.da.a(java.lang.String, java.util.Map, java.util.Map):com.amap.api.services.a.df");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b9 A[SYNTHETIC, Splitter:B:66:0x00b9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.services.a.df a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, byte[] r5) throws com.amap.api.services.a.ay {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            java.net.HttpURLConnection r3 = r2.a((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r0)     // Catch:{ ConnectException -> 0x00ab, MalformedURLException -> 0x009f, UnknownHostException -> 0x0093, SocketException -> 0x0087, SocketTimeoutException -> 0x007b, InterruptedIOException -> 0x0073, IOException -> 0x0067, ay -> 0x005e, Throwable -> 0x004e }
            if (r5 == 0) goto L_0x0039
            int r4 = r5.length     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            if (r4 <= 0) goto L_0x0039
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            java.io.OutputStream r0 = r3.getOutputStream()     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.<init>(r0)     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.write(r5)     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.close()     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            goto L_0x0039
        L_0x001b:
            r4 = move-exception
            r1 = r3
            goto L_0x00b7
        L_0x001f:
            r4 = move-exception
            r1 = r3
            goto L_0x004f
        L_0x0022:
            r4 = move-exception
            r1 = r3
            goto L_0x005f
        L_0x0025:
            r4 = move-exception
            r1 = r3
            goto L_0x0068
        L_0x0028:
            r1 = r3
            goto L_0x0073
        L_0x002a:
            r4 = move-exception
            r1 = r3
            goto L_0x007c
        L_0x002d:
            r4 = move-exception
            r1 = r3
            goto L_0x0088
        L_0x0030:
            r4 = move-exception
            r1 = r3
            goto L_0x0094
        L_0x0033:
            r4 = move-exception
            r1 = r3
            goto L_0x00a0
        L_0x0036:
            r4 = move-exception
            r1 = r3
            goto L_0x00ac
        L_0x0039:
            com.amap.api.services.a.df r4 = r2.a((java.net.HttpURLConnection) r3)     // Catch:{ ConnectException -> 0x0036, MalformedURLException -> 0x0033, UnknownHostException -> 0x0030, SocketException -> 0x002d, SocketTimeoutException -> 0x002a, InterruptedIOException -> 0x0028, IOException -> 0x0025, ay -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            if (r3 == 0) goto L_0x004b
            r3.disconnect()     // Catch:{ Throwable -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r3 = move-exception
            java.lang.String r5 = "HttpUrlUtil"
            java.lang.String r0 = "makePostReqeust"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r3, (java.lang.String) r5, (java.lang.String) r0)
        L_0x004b:
            return r4
        L_0x004c:
            r4 = move-exception
            goto L_0x00b7
        L_0x004e:
            r4 = move-exception
        L_0x004f:
            java.lang.String r3 = "HttpUrlUtil"
            java.lang.String r5 = "makePostReqeust"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x005e:
            r4 = move-exception
        L_0x005f:
            java.lang.String r3 = "HttpUrlUtil"
            java.lang.String r5 = "makePostReqeust"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x004c }
            throw r4     // Catch:{ all -> 0x004c }
        L_0x0067:
            r4 = move-exception
        L_0x0068:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "IO 操作异常 - IOException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x0073:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x007b:
            r4 = move-exception
        L_0x007c:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "socket 连接超时 - SocketTimeoutException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x0087:
            r4 = move-exception
        L_0x0088:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "socket 连接异常 - SocketException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x0093:
            r4 = move-exception
        L_0x0094:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "未知主机 - UnKnowHostException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x009f:
            r4 = move-exception
        L_0x00a0:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "url异常 - MalformedURLException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x00ab:
            r4 = move-exception
        L_0x00ac:
            r4.printStackTrace()     // Catch:{ all -> 0x004c }
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x004c }
            java.lang.String r4 = "http连接失败 - ConnectionException"
            r3.<init>(r4)     // Catch:{ all -> 0x004c }
            throw r3     // Catch:{ all -> 0x004c }
        L_0x00b7:
            if (r1 == 0) goto L_0x00c5
            r1.disconnect()     // Catch:{ Throwable -> 0x00bd }
            goto L_0x00c5
        L_0x00bd:
            r3 = move-exception
            java.lang.String r5 = "HttpUrlUtil"
            java.lang.String r0 = "makePostReqeust"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r3, (java.lang.String) r5, (java.lang.String) r0)
        L_0x00c5:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.da.a(java.lang.String, java.util.Map, byte[]):com.amap.api.services.a.df");
    }

    /* access modifiers changed from: package-private */
    public HttpURLConnection a(String str, Map<String, String> map, boolean z) throws IOException {
        HttpURLConnection httpURLConnection;
        bd.b();
        URL url = new URL(str);
        URLConnection a2 = this.k != null ? this.k.a(this.f, url) : null;
        if (a2 == null) {
            if (this.f != null) {
                a2 = url.openConnection(this.f);
            } else {
                a2 = url.openConnection();
            }
        }
        if (this.d) {
            httpURLConnection = (HttpsURLConnection) a2;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.e.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(this.l);
        } else {
            httpURLConnection = (HttpURLConnection) a2;
        }
        if (Build.VERSION.SDK != null && Build.VERSION.SDK_INT > 13) {
            httpURLConnection.setRequestProperty("Connection", "close");
        }
        a(map, httpURLConnection);
        if (z) {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
        } else {
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);
        }
        return httpURLConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x011e A[SYNTHETIC, Splitter:B:79:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x012c A[SYNTHETIC, Splitter:B:84:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013a A[SYNTHETIC, Splitter:B:89:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0148 A[SYNTHETIC, Splitter:B:94:0x0148] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amap.api.services.a.df a(java.net.HttpURLConnection r11) throws com.amap.api.services.a.ay, java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = ""
            r1 = 0
            r11.connect()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.util.Map r2 = r11.getHeaderFields()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            int r3 = r11.getResponseCode()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4 = 0
            if (r2 == 0) goto L_0x0028
            java.lang.String r5 = "gsid"
            java.lang.Object r5 = r2.get(r5)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            if (r5 == 0) goto L_0x0028
            int r6 = r5.size()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            if (r6 <= 0) goto L_0x0028
            java.lang.Object r5 = r5.get(r4)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r0 = r5
        L_0x0028:
            r5 = 200(0xc8, float:2.8E-43)
            if (r3 == r5) goto L_0x0061
            com.amap.api.services.a.ay r2 = new com.amap.api.services.a.ay     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4.<init>()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r5 = "网络异常原因："
            r4.append(r5)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = r11.getResponseMessage()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4.append(r11)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = " 网络异常状态码："
            r4.append(r11)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4.append(r3)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = "  "
            r4.append(r11)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4.append(r0)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = " "
            r4.append(r11)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = r10.j     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r4.append(r11)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r11 = r4.toString()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r2.<init>(r11, r0)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            throw r2     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
        L_0x0061:
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            r3.<init>()     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.io.InputStream r11 = r11.getInputStream()     // Catch:{ IOException -> 0x0103, all -> 0x00fd }
            java.io.PushbackInputStream r5 = new java.io.PushbackInputStream     // Catch:{ IOException -> 0x00fb, all -> 0x00f6 }
            r6 = 2
            r5.<init>(r11, r6)     // Catch:{ IOException -> 0x00fb, all -> 0x00f6 }
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r5.read(r6)     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r5.unread(r6)     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            byte r7 = r6[r4]     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r8 = 31
            if (r7 != r8) goto L_0x008c
            r7 = 1
            byte r6 = r6[r7]     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r7 = -117(0xffffffffffffff8b, float:NaN)
            if (r6 != r7) goto L_0x008c
            java.util.zip.GZIPInputStream r6 = new java.util.zip.GZIPInputStream     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r1 = r6
            goto L_0x008d
        L_0x008c:
            r1 = r5
        L_0x008d:
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
        L_0x0091:
            int r7 = r1.read(r6)     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r8 = -1
            if (r7 == r8) goto L_0x009c
            r3.write(r6, r4, r7)     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            goto L_0x0091
        L_0x009c:
            com.amap.api.services.a.db r4 = a     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            if (r4 == 0) goto L_0x00a5
            com.amap.api.services.a.db r4 = a     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.a()     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
        L_0x00a5:
            com.amap.api.services.a.df r4 = new com.amap.api.services.a.df     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.<init>()     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            byte[] r6 = r3.toByteArray()     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.a = r6     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.b = r2     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            java.lang.String r2 = r10.j     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.c = r2     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.d = r0     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            if (r3 == 0) goto L_0x00c6
            r3.close()     // Catch:{ Throwable -> 0x00be }
            goto L_0x00c6
        L_0x00be:
            r0 = move-exception
            java.lang.String r2 = "HttpUrlUtil"
            java.lang.String r3 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x00c6:
            if (r11 == 0) goto L_0x00d4
            r11.close()     // Catch:{ Throwable -> 0x00cc }
            goto L_0x00d4
        L_0x00cc:
            r11 = move-exception
            java.lang.String r0 = "HttpUrlUtil"
            java.lang.String r2 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x00d4:
            if (r5 == 0) goto L_0x00e2
            r5.close()     // Catch:{ Throwable -> 0x00da }
            goto L_0x00e2
        L_0x00da:
            r11 = move-exception
            java.lang.String r0 = "HttpUrlUtil"
            java.lang.String r2 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x00e2:
            if (r1 == 0) goto L_0x00f0
            r1.close()     // Catch:{ Throwable -> 0x00e8 }
            goto L_0x00f0
        L_0x00e8:
            r11 = move-exception
            java.lang.String r0 = "HttpUrlUtil"
            java.lang.String r1 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r1)
        L_0x00f0:
            return r4
        L_0x00f1:
            r0 = move-exception
            r2 = r1
            goto L_0x00f9
        L_0x00f4:
            r2 = r1
            goto L_0x0106
        L_0x00f6:
            r0 = move-exception
            r2 = r1
            r5 = r2
        L_0x00f9:
            r1 = r3
            goto L_0x0119
        L_0x00fb:
            r2 = r1
            goto L_0x0105
        L_0x00fd:
            r11 = move-exception
            r0 = r1
            r2 = r0
            r5 = r2
            r1 = r3
            goto L_0x011c
        L_0x0103:
            r11 = r1
            r2 = r11
        L_0x0105:
            r5 = r2
        L_0x0106:
            r1 = r3
            goto L_0x0110
        L_0x0108:
            r11 = move-exception
            r0 = r1
            r2 = r0
            r5 = r2
            goto L_0x011c
        L_0x010d:
            r11 = r1
            r2 = r11
            r5 = r2
        L_0x0110:
            com.amap.api.services.a.ay r3 = new com.amap.api.services.a.ay     // Catch:{ all -> 0x0118 }
            java.lang.String r4 = "IO 操作异常 - IOException"
            r3.<init>(r4, r0)     // Catch:{ all -> 0x0118 }
            throw r3     // Catch:{ all -> 0x0118 }
        L_0x0118:
            r0 = move-exception
        L_0x0119:
            r9 = r0
            r0 = r11
            r11 = r9
        L_0x011c:
            if (r1 == 0) goto L_0x012a
            r1.close()     // Catch:{ Throwable -> 0x0122 }
            goto L_0x012a
        L_0x0122:
            r1 = move-exception
            java.lang.String r3 = "HttpUrlUtil"
            java.lang.String r4 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)
        L_0x012a:
            if (r0 == 0) goto L_0x0138
            r0.close()     // Catch:{ Throwable -> 0x0130 }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            java.lang.String r1 = "HttpUrlUtil"
            java.lang.String r3 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0138:
            if (r5 == 0) goto L_0x0146
            r5.close()     // Catch:{ Throwable -> 0x013e }
            goto L_0x0146
        L_0x013e:
            r0 = move-exception
            java.lang.String r1 = "HttpUrlUtil"
            java.lang.String r3 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0146:
            if (r2 == 0) goto L_0x0154
            r2.close()     // Catch:{ Throwable -> 0x014c }
            goto L_0x0154
        L_0x014c:
            r0 = move-exception
            java.lang.String r1 = "HttpUrlUtil"
            java.lang.String r2 = "parseResult"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0154:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.da.a(java.net.HttpURLConnection):com.amap.api.services.a.df");
    }

    private void a(Map<String, String> map, HttpURLConnection httpURLConnection) {
        if (map != null) {
            for (String next : map.keySet()) {
                httpURLConnection.addRequestProperty(next, map.get(next));
            }
        }
        try {
            httpURLConnection.addRequestProperty("csid", this.j);
        } catch (Throwable th) {
            bl.a(th, "HttpUrlUtil", "addHeaders");
        }
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
    }

    static String a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (str2 == null) {
                str2 = "";
            }
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str));
            sb.append("=");
            sb.append(URLEncoder.encode(str2));
        }
        return sb.toString();
    }
}
