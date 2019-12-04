package com.iflytek.sunflower.a;

import android.text.TextUtils;
import com.iflytek.sunflower.util.j;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class a extends Thread {
    private int a = 20000;
    private C0007a b = null;
    private volatile boolean c = false;
    private URL d = null;
    private ArrayList<byte[]> e = new ArrayList<>();
    private Object f = null;
    private int g = 0;

    /* renamed from: com.iflytek.sunflower.a.a$a  reason: collision with other inner class name */
    public interface C0007a {
        void a(a aVar, byte[] bArr);

        void a(Exception exc);

        void a(byte[] bArr);
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(String str, String str2, byte[] bArr) {
        this.e.clear();
        a(bArr);
        try {
            this.d = a(str, str2);
        } catch (MalformedURLException e2) {
            j.d("Collector", "url error:" + e2);
        }
    }

    public void b(int i) {
        this.a = i;
    }

    public void a(C0007a aVar) {
        this.b = aVar;
    }

    public void b(C0007a aVar) {
        this.b = aVar;
        start();
    }

    public static URL a(String str, String str2) throws MalformedURLException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            str = str + str2;
        }
        j.e("Collector", "url:" + str);
        return new URL(str);
    }

    public void run() {
        if (this.g == 1) {
            a();
        } else {
            b();
        }
    }

    private byte[] a(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(1024);
        byte[] bArr = new byte[1024];
        while (!this.c) {
            int read = bufferedInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                break;
            }
            byteArrayBuffer.append(bArr, 0, read);
            if (this.b != null) {
                this.b.a(byteArrayBuffer.toByteArray());
            }
        }
        return byteArrayBuffer.toByteArray();
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005d A[SYNTHETIC, Splitter:B:29:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067 A[SYNTHETIC, Splitter:B:35:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006c A[Catch:{ Exception -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r5 = this;
            r0 = 0
            java.net.URL r1 = r5.d     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            int r2 = r5.a     // Catch:{ Exception -> 0x004c }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x004c }
            int r2 = r5.a     // Catch:{ Exception -> 0x004c }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x004c }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x004c }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x004c }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x0037
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x004c }
            byte[] r0 = r5.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r5.b((byte[]) r0)     // Catch:{ Exception -> 0x0032, all -> 0x002d }
            r0 = r2
            goto L_0x0041
        L_0x002d:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x0065
        L_0x0032:
            r0 = move-exception
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x0055
        L_0x0037:
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x004c }
            java.lang.String r3 = "HttpRequest Failed."
            r2.<init>(r3)     // Catch:{ Exception -> 0x004c }
            r5.a((java.lang.Exception) r2)     // Catch:{ Exception -> 0x004c }
        L_0x0041:
            if (r0 == 0) goto L_0x0046
            r0.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0046:
            if (r1 == 0) goto L_0x0063
        L_0x0048:
            r1.disconnect()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0063
        L_0x004c:
            r2 = move-exception
            goto L_0x0055
        L_0x004e:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x0065
        L_0x0052:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0055:
            r2.printStackTrace()     // Catch:{ all -> 0x0064 }
            r5.a((java.lang.Exception) r2)     // Catch:{ all -> 0x0064 }
            if (r0 == 0) goto L_0x0060
            r0.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0060:
            if (r1 == 0) goto L_0x0063
            goto L_0x0048
        L_0x0063:
            return
        L_0x0064:
            r2 = move-exception
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()     // Catch:{ Exception -> 0x006f }
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.disconnect()     // Catch:{ Exception -> 0x006f }
        L_0x006f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.a.a.b():void");
    }

    private void b(byte[] bArr) {
        if (this.b != null && !this.c) {
            this.b.a(this, bArr);
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e.add(bArr);
        }
    }

    private void a(Exception exc) {
        if (this.b != null && !this.c) {
            this.b.a(exc);
        }
    }

    private int c() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            i += this.e.get(i2).length;
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2 A[SYNTHETIC, Splitter:B:34:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc A[SYNTHETIC, Splitter:B:40:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1 A[Catch:{ Exception -> 0x00c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = r6.d     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00ab, all -> 0x00a8 }
            r2 = 1
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x00a6 }
            r1.setDoInput(r2)     // Catch:{ Exception -> 0x00a6 }
            r2 = 0
            r1.setUseCaches(r2)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00a6 }
            int r2 = r6.a     // Catch:{ Exception -> 0x00a6 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00a6 }
            int r2 = r6.a     // Catch:{ Exception -> 0x00a6 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = "Content-length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a6 }
            r3.<init>()     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r4 = ""
            r3.append(r4)     // Catch:{ Exception -> 0x00a6 }
            int r4 = r6.c()     // Catch:{ Exception -> 0x00a6 }
            r3.append(r4)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00a6 }
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "Keep-Alive"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = "Charset"
            java.lang.String r3 = "utf-8"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-gzip"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00a6 }
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ Exception -> 0x00a6 }
            java.util.ArrayList<byte[]> r3 = r6.e     // Catch:{ Exception -> 0x00a6 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00a6 }
        L_0x005c:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00a6 }
            if (r4 == 0) goto L_0x006c
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00a6 }
            byte[] r4 = (byte[]) r4     // Catch:{ Exception -> 0x00a6 }
            r2.write(r4)     // Catch:{ Exception -> 0x00a6 }
            goto L_0x005c
        L_0x006c:
            r2.flush()     // Catch:{ Exception -> 0x00a6 }
            r2.close()     // Catch:{ Exception -> 0x00a6 }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00a6 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x0091
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00a6 }
            byte[] r0 = r6.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x008c, all -> 0x0087 }
            r6.b((byte[]) r0)     // Catch:{ Exception -> 0x008c, all -> 0x0087 }
            r0 = r2
            goto L_0x009b
        L_0x0087:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x00ba
        L_0x008c:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x00ad
        L_0x0091:
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r3 = "Http Request Failed."
            r2.<init>(r3)     // Catch:{ Exception -> 0x00a6 }
            r6.a((java.lang.Exception) r2)     // Catch:{ Exception -> 0x00a6 }
        L_0x009b:
            if (r0 == 0) goto L_0x00a0
            r0.close()     // Catch:{ Exception -> 0x00b8 }
        L_0x00a0:
            if (r1 == 0) goto L_0x00b8
        L_0x00a2:
            r1.disconnect()     // Catch:{ Exception -> 0x00b8 }
            goto L_0x00b8
        L_0x00a6:
            r2 = move-exception
            goto L_0x00ad
        L_0x00a8:
            r2 = move-exception
            r1 = r0
            goto L_0x00ba
        L_0x00ab:
            r2 = move-exception
            r1 = r0
        L_0x00ad:
            r6.a((java.lang.Exception) r2)     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x00b5
            r0.close()     // Catch:{ Exception -> 0x00b8 }
        L_0x00b5:
            if (r1 == 0) goto L_0x00b8
            goto L_0x00a2
        L_0x00b8:
            return
        L_0x00b9:
            r2 = move-exception
        L_0x00ba:
            if (r0 == 0) goto L_0x00bf
            r0.close()     // Catch:{ Exception -> 0x00c4 }
        L_0x00bf:
            if (r1 == 0) goto L_0x00c4
            r1.disconnect()     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.a.a.a():void");
    }

    public static boolean a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("rsp") && jSONObject.getJSONObject("rsp").getInt("code") != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
