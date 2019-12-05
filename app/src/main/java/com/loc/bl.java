package com.loc;

import android.os.Build;
import com.loc.bi;
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
public final class bl {
    private static bm a;
    private int b;
    private int c;
    private boolean d;
    private SSLContext e;
    private Proxy f;
    private volatile boolean g;
    private long h;
    private long i;
    private String j;
    private bi.a k;
    private HostnameVerifier l;

    bl(int i2, int i3, Proxy proxy) {
        this(i2, i3, proxy, false);
    }

    bl(int i2, int i3, Proxy proxy, boolean z) {
        this(i2, i3, proxy, z, (byte) 0);
    }

    private bl(int i2, int i3, Proxy proxy, boolean z, byte b2) {
        this.g = false;
        this.h = -1;
        this.i = 0;
        this.l = new HostnameVerifier() {
            public final boolean verify(String str, SSLSession sSLSession) {
                HostnameVerifier defaultHostnameVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
                return defaultHostnameVerifier.verify("*.amap.com", sSLSession) || defaultHostnameVerifier.verify("*.apilocate.amap.com", sSLSession);
            }
        };
        this.b = i2;
        this.c = i3;
        this.f = proxy;
        this.d = z;
        this.k = null;
        try {
            this.j = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        } catch (Throwable th) {
            w.a(th, "ht", "ic");
        }
        if (z) {
            try {
                SSLContext instance = SSLContext.getInstance("TLS");
                instance.init((KeyManager[]) null, (TrustManager[]) null, (SecureRandom) null);
                this.e = instance;
            } catch (Throwable th2) {
                w.a(th2, "ht", "ne");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x011e A[SYNTHETIC, Splitter:B:80:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x012c A[SYNTHETIC, Splitter:B:85:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x013a A[SYNTHETIC, Splitter:B:90:0x013a] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0148 A[SYNTHETIC, Splitter:B:95:0x0148] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.loc.bo a(java.net.HttpURLConnection r11) throws com.loc.j, java.io.IOException {
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
            com.loc.j r2 = new com.loc.j     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
            java.lang.String r5 = "网络异常原因："
            r4.<init>(r5)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
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
            r2.a(r3)     // Catch:{ IOException -> 0x010d, all -> 0x0108 }
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
            com.loc.bm r4 = a     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            if (r4 == 0) goto L_0x00a5
            com.loc.bm r4 = a     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
            r4.a()     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
        L_0x00a5:
            com.loc.bo r4 = new com.loc.bo     // Catch:{ IOException -> 0x00f4, all -> 0x00f1 }
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
            java.lang.String r2 = "ht"
            java.lang.String r3 = "par"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x00c6:
            if (r11 == 0) goto L_0x00d4
            r11.close()     // Catch:{ Throwable -> 0x00cc }
            goto L_0x00d4
        L_0x00cc:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r2 = "par"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x00d4:
            if (r5 == 0) goto L_0x00e2
            r5.close()     // Catch:{ Throwable -> 0x00da }
            goto L_0x00e2
        L_0x00da:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r2 = "par"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r2)
        L_0x00e2:
            if (r1 == 0) goto L_0x00f0
            r1.close()     // Catch:{ Throwable -> 0x00e8 }
            return r4
        L_0x00e8:
            r11 = move-exception
            java.lang.String r0 = "ht"
            java.lang.String r1 = "par"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r1)
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
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x0118 }
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
            java.lang.String r3 = "ht"
            java.lang.String r4 = "par"
            com.loc.w.a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)
        L_0x012a:
            if (r0 == 0) goto L_0x0138
            r0.close()     // Catch:{ Throwable -> 0x0130 }
            goto L_0x0138
        L_0x0130:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r3 = "par"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0138:
            if (r5 == 0) goto L_0x0146
            r5.close()     // Catch:{ Throwable -> 0x013e }
            goto L_0x0146
        L_0x013e:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r3 = "par"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0146:
            if (r2 == 0) goto L_0x0154
            r2.close()     // Catch:{ Throwable -> 0x014c }
            goto L_0x0154
        L_0x014c:
            r0 = move-exception
            java.lang.String r1 = "ht"
            java.lang.String r2 = "par"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0154:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bl.a(java.net.HttpURLConnection):com.loc.bo");
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

    private HttpURLConnection a(String str, Map<String, String> map, boolean z) throws IOException {
        URLConnection uRLConnection;
        HttpURLConnection httpURLConnection;
        n.b();
        URL url = new URL(str);
        if (this.k != null) {
            bi.a aVar = this.k;
            Proxy proxy = this.f;
            uRLConnection = aVar.a();
        } else {
            uRLConnection = null;
        }
        if (uRLConnection == null) {
            uRLConnection = this.f != null ? url.openConnection(this.f) : url.openConnection();
        }
        if (this.d) {
            httpURLConnection = (HttpsURLConnection) uRLConnection;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.e.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(this.l);
        } else {
            httpURLConnection = (HttpURLConnection) uRLConnection;
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
            return httpURLConnection;
        }
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public static void a(bm bmVar) {
        a = bmVar;
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
            w.a(th, "ht", "adh");
        }
        httpURLConnection.setConnectTimeout(this.b);
        httpURLConnection.setReadTimeout(this.c);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ba A[SYNTHETIC, Splitter:B:67:0x00ba] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.loc.bo a(java.lang.String r3, java.util.Map<java.lang.String, java.lang.String> r4, byte[] r5) throws com.loc.j {
        /*
            r2 = this;
            r0 = 1
            r1 = 0
            java.net.HttpURLConnection r3 = r2.a((java.lang.String) r3, (java.util.Map<java.lang.String, java.lang.String>) r4, (boolean) r0)     // Catch:{ ConnectException -> 0x00ac, MalformedURLException -> 0x00a0, UnknownHostException -> 0x0094, SocketException -> 0x0088, SocketTimeoutException -> 0x007c, InterruptedIOException -> 0x0074, IOException -> 0x0068, j -> 0x005f, Throwable -> 0x004f }
            if (r5 == 0) goto L_0x0038
            int r4 = r5.length     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            if (r4 <= 0) goto L_0x0038
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            java.io.OutputStream r0 = r3.getOutputStream()     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.<init>(r0)     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.write(r5)     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            r4.close()     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            goto L_0x0038
        L_0x001b:
            r4 = move-exception
            r1 = r3
            goto L_0x00b8
        L_0x001f:
            r4 = move-exception
            r1 = r3
            goto L_0x0050
        L_0x0022:
            r4 = move-exception
            r1 = r3
            goto L_0x0060
        L_0x0025:
            r4 = move-exception
            r1 = r3
            goto L_0x0069
        L_0x0028:
            r4 = move-exception
            r1 = r3
            goto L_0x007d
        L_0x002b:
            r4 = move-exception
            r1 = r3
            goto L_0x0089
        L_0x002e:
            r4 = move-exception
            r1 = r3
            goto L_0x0095
        L_0x0031:
            r4 = move-exception
            r1 = r3
            goto L_0x00a1
        L_0x0034:
            r4 = move-exception
            r1 = r3
            goto L_0x00ad
        L_0x0038:
            com.loc.bo r4 = r2.a((java.net.HttpURLConnection) r3)     // Catch:{ ConnectException -> 0x0034, MalformedURLException -> 0x0031, UnknownHostException -> 0x002e, SocketException -> 0x002b, SocketTimeoutException -> 0x0028, InterruptedIOException -> 0x004b, IOException -> 0x0025, j -> 0x0022, Throwable -> 0x001f, all -> 0x001b }
            if (r3 == 0) goto L_0x004a
            r3.disconnect()     // Catch:{ Throwable -> 0x0042 }
            return r4
        L_0x0042:
            r3 = move-exception
            java.lang.String r5 = "ht"
            java.lang.String r0 = "mPt"
            com.loc.w.a((java.lang.Throwable) r3, (java.lang.String) r5, (java.lang.String) r0)
        L_0x004a:
            return r4
        L_0x004b:
            r1 = r3
            goto L_0x0074
        L_0x004d:
            r4 = move-exception
            goto L_0x00b8
        L_0x004f:
            r4 = move-exception
        L_0x0050:
            java.lang.String r3 = "ht"
            java.lang.String r5 = "mPt"
            com.loc.w.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x005f:
            r4 = move-exception
        L_0x0060:
            java.lang.String r3 = "ht"
            java.lang.String r5 = "mPt"
            com.loc.w.a((java.lang.Throwable) r4, (java.lang.String) r3, (java.lang.String) r5)     // Catch:{ all -> 0x004d }
            throw r4     // Catch:{ all -> 0x004d }
        L_0x0068:
            r4 = move-exception
        L_0x0069:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "IO 操作异常 - IOException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x0074:
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "未知的错误"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x007c:
            r4 = move-exception
        L_0x007d:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "socket 连接超时 - SocketTimeoutException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x0088:
            r4 = move-exception
        L_0x0089:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "socket 连接异常 - SocketException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x0094:
            r4 = move-exception
        L_0x0095:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "未知主机 - UnKnowHostException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x00a0:
            r4 = move-exception
        L_0x00a1:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "url异常 - MalformedURLException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x00ac:
            r4 = move-exception
        L_0x00ad:
            r4.printStackTrace()     // Catch:{ all -> 0x004d }
            com.loc.j r3 = new com.loc.j     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "http连接失败 - ConnectionException"
            r3.<init>(r4)     // Catch:{ all -> 0x004d }
            throw r3     // Catch:{ all -> 0x004d }
        L_0x00b8:
            if (r1 == 0) goto L_0x00c6
            r1.disconnect()     // Catch:{ Throwable -> 0x00be }
            goto L_0x00c6
        L_0x00be:
            r3 = move-exception
            java.lang.String r5 = "ht"
            java.lang.String r0 = "mPt"
            com.loc.w.a((java.lang.Throwable) r3, (java.lang.String) r5, (java.lang.String) r0)
        L_0x00c6:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bl.a(java.lang.String, java.util.Map, byte[]):com.loc.bo");
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.i = 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:57|56|62|63|(2:65|66)|(3:70|71|90)(1:92)) */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0102, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0109, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x010a, code lost:
        com.loc.w.a(r10, "ht", "mdr");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        r8.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0117, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0118, code lost:
        com.loc.w.a(r8, "ht", "mdr");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:62:0x00eb */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f0 A[SYNTHETIC, Splitter:B:65:0x00f0] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00fe A[SYNTHETIC, Splitter:B:70:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0105 A[SYNTHETIC, Splitter:B:74:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0113 A[SYNTHETIC, Splitter:B:79:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r8, java.util.Map<java.lang.String, java.lang.String> r9, java.util.Map<java.lang.String, java.lang.String> r10, com.loc.bk.a r11) {
        /*
            r7 = this;
            if (r11 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            java.lang.String r10 = a((java.util.Map<java.lang.String, java.lang.String>) r10)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r1.<init>()     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r1.append(r8)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            if (r10 == 0) goto L_0x001a
            java.lang.String r8 = "?"
            r1.append(r8)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r1.append(r10)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
        L_0x001a:
            java.lang.String r8 = r1.toString()     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            r10 = 0
            java.net.HttpURLConnection r8 = r7.a((java.lang.String) r8, (java.util.Map<java.lang.String, java.lang.String>) r9, (boolean) r10)     // Catch:{ Throwable -> 0x00ea, all -> 0x00e6 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r1 = "bytes="
            r9.<init>(r1)     // Catch:{ Throwable -> 0x00eb }
            long r1 = r7.i     // Catch:{ Throwable -> 0x00eb }
            r9.append(r1)     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r1 = "-"
            r9.append(r1)     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r9 = r9.toString()     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r1 = "RANGE"
            r8.setRequestProperty(r1, r9)     // Catch:{ Throwable -> 0x00eb }
            r8.connect()     // Catch:{ Throwable -> 0x00eb }
            int r9 = r8.getResponseCode()     // Catch:{ Throwable -> 0x00eb }
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 1
            if (r9 == r1) goto L_0x004b
            r1 = r2
            goto L_0x004c
        L_0x004b:
            r1 = r10
        L_0x004c:
            r3 = 206(0xce, float:2.89E-43)
            if (r9 == r3) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r2 = r10
        L_0x0052:
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0077
            com.loc.j r1 = new com.loc.j     // Catch:{ Throwable -> 0x00eb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r3 = "网络异常原因："
            r2.<init>(r3)     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r3 = r8.getResponseMessage()     // Catch:{ Throwable -> 0x00eb }
            r2.append(r3)     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r3 = " 网络异常状态码："
            r2.append(r3)     // Catch:{ Throwable -> 0x00eb }
            r2.append(r9)     // Catch:{ Throwable -> 0x00eb }
            java.lang.String r9 = r2.toString()     // Catch:{ Throwable -> 0x00eb }
            r1.<init>(r9)     // Catch:{ Throwable -> 0x00eb }
            r11.d()     // Catch:{ Throwable -> 0x00eb }
        L_0x0077:
            java.io.InputStream r9 = r8.getInputStream()     // Catch:{ Throwable -> 0x00eb }
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r0]     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
        L_0x007f:
            boolean r2 = java.lang.Thread.interrupted()     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            if (r2 != 0) goto L_0x00b8
            boolean r2 = r7.g     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            if (r2 != 0) goto L_0x00b8
            int r2 = r9.read(r1, r10, r0)     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            if (r2 <= 0) goto L_0x00b8
            long r3 = r7.h     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x009f
            long r3 = r7.i     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            long r5 = r7.h     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b8
        L_0x009f:
            if (r2 != r0) goto L_0x00a7
            long r3 = r7.i     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            r11.a(r1, r3)     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            goto L_0x00b1
        L_0x00a7:
            byte[] r3 = new byte[r2]     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            java.lang.System.arraycopy(r1, r10, r3, r10, r2)     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            long r4 = r7.i     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            r11.a(r3, r4)     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
        L_0x00b1:
            long r3 = r7.i     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            long r5 = (long) r2     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            long r3 = r3 + r5
            r7.i = r3     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            goto L_0x007f
        L_0x00b8:
            boolean r10 = r7.g     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            if (r10 == 0) goto L_0x00c0
            r11.b()     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
            goto L_0x00c3
        L_0x00c0:
            r11.c()     // Catch:{ Throwable -> 0x00e4, all -> 0x00e0 }
        L_0x00c3:
            if (r9 == 0) goto L_0x00d1
            r9.close()     // Catch:{ IOException | Throwable -> 0x00c9 }
            goto L_0x00d1
        L_0x00c9:
            r9 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mdr"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
        L_0x00d1:
            if (r8 == 0) goto L_0x0101
            r8.disconnect()     // Catch:{ Throwable -> 0x00d7 }
            return
        L_0x00d7:
            r8 = move-exception
            java.lang.String r9 = "ht"
            java.lang.String r10 = "mdr"
            com.loc.w.a((java.lang.Throwable) r8, (java.lang.String) r9, (java.lang.String) r10)
            return
        L_0x00e0:
            r10 = move-exception
            r0 = r9
            r9 = r10
            goto L_0x0103
        L_0x00e4:
            r0 = r9
            goto L_0x00eb
        L_0x00e6:
            r8 = move-exception
            r9 = r8
            r8 = r0
            goto L_0x0103
        L_0x00ea:
            r8 = r0
        L_0x00eb:
            r11.d()     // Catch:{ all -> 0x0102 }
            if (r0 == 0) goto L_0x00fc
            r0.close()     // Catch:{ IOException | Throwable -> 0x00f4 }
            goto L_0x00fc
        L_0x00f4:
            r9 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mdr"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
        L_0x00fc:
            if (r8 == 0) goto L_0x0101
            r8.disconnect()     // Catch:{ Throwable -> 0x00d7 }
        L_0x0101:
            return
        L_0x0102:
            r9 = move-exception
        L_0x0103:
            if (r0 == 0) goto L_0x0111
            r0.close()     // Catch:{ IOException | Throwable -> 0x0109 }
            goto L_0x0111
        L_0x0109:
            r10 = move-exception
            java.lang.String r11 = "ht"
            java.lang.String r0 = "mdr"
            com.loc.w.a((java.lang.Throwable) r10, (java.lang.String) r11, (java.lang.String) r0)
        L_0x0111:
            if (r8 == 0) goto L_0x011f
            r8.disconnect()     // Catch:{ Throwable -> 0x0117 }
            goto L_0x011f
        L_0x0117:
            r8 = move-exception
            java.lang.String r10 = "ht"
            java.lang.String r11 = "mdr"
            com.loc.w.a((java.lang.Throwable) r8, (java.lang.String) r10, (java.lang.String) r11)
        L_0x011f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bl.a(java.lang.String, java.util.Map, java.util.Map, com.loc.bk$a):void");
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        this.h = -1;
    }
}
