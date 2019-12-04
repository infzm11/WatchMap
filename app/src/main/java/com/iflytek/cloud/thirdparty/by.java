package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import com.iflytek.cloud.SpeechError;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.apache.http.util.ByteArrayBuffer;

public class by extends Thread {
    private int a = 20000;
    private a b = null;
    private volatile boolean c = false;
    private URL d = null;
    private ArrayList<byte[]> e = new ArrayList<>();
    private String f;
    private Object g = null;
    private int h = 0;

    public interface a {
        void a(SpeechError speechError);

        void a(by byVar, byte[] bArr);
    }

    public static URL a(String str, String str2) throws MalformedURLException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!str.endsWith("?")) {
                str = str + "?";
            }
            str = str + str2;
        }
        return new URL(str);
    }

    private void a(SpeechError speechError) {
        if (this.b != null && !this.c) {
            this.b.a(speechError);
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
        }
        return byteArrayBuffer.toByteArray();
    }

    private void b(byte[] bArr) {
        if (this.b != null && !this.c) {
            this.b.a(this, bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00af A[SYNTHETIC, Splitter:B:30:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9 A[SYNTHETIC, Splitter:B:36:0x00b9] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00be A[Catch:{ Exception -> 0x00c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "Start connect server"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0085, all -> 0x0081 }
            java.net.URL r1 = r6.d     // Catch:{ Exception -> 0x0085, all -> 0x0081 }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x0085, all -> 0x0081 }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x0085, all -> 0x0081 }
            int r2 = r6.a     // Catch:{ Exception -> 0x007f }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x007f }
            int r2 = r6.a     // Catch:{ Exception -> 0x007f }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x007f }
            java.lang.String r2 = "GET"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x007f }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x007f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
            r3.<init>()     // Catch:{ Exception -> 0x007f }
            java.lang.String r4 = "responseCode = "
            r3.append(r4)     // Catch:{ Exception -> 0x007f }
            r3.append(r2)     // Catch:{ Exception -> 0x007f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007f }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007f }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x0051
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x007f }
            byte[] r0 = r6.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x004c, all -> 0x0046 }
            r6.b((byte[]) r0)     // Catch:{ Exception -> 0x004c, all -> 0x0046 }
            r0 = r2
            goto L_0x0074
        L_0x0046:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x00b7
        L_0x004c:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0088
        L_0x0051:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007f }
            r3.<init>()     // Catch:{ Exception -> 0x007f }
            java.lang.String r4 = "MscHttpRequest connect error:"
            r3.append(r4)     // Catch:{ Exception -> 0x007f }
            r3.append(r2)     // Catch:{ Exception -> 0x007f }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007f }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x007f }
            com.iflytek.cloud.SpeechError r3 = new com.iflytek.cloud.SpeechError     // Catch:{ Exception -> 0x007f }
            r4 = 12000(0x2ee0, float:1.6816E-41)
            int r2 = java.lang.Math.abs(r2)     // Catch:{ Exception -> 0x007f }
            int r4 = r4 + r2
            r3.<init>((int) r4)     // Catch:{ Exception -> 0x007f }
            r6.a((com.iflytek.cloud.SpeechError) r3)     // Catch:{ Exception -> 0x007f }
        L_0x0074:
            if (r0 == 0) goto L_0x0079
            r0.close()     // Catch:{ Exception -> 0x00b5 }
        L_0x0079:
            if (r1 == 0) goto L_0x00b5
        L_0x007b:
            r1.disconnect()     // Catch:{ Exception -> 0x00b5 }
            return
        L_0x007f:
            r2 = move-exception
            goto L_0x0088
        L_0x0081:
            r1 = move-exception
            r2 = r1
            r1 = r0
            goto L_0x00b7
        L_0x0085:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x0088:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x00b6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b6 }
            r3.<init>()     // Catch:{ all -> 0x00b6 }
            java.lang.String r4 = "MscHttpRequest error:"
            r3.append(r4)     // Catch:{ all -> 0x00b6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b6 }
            r3.append(r2)     // Catch:{ all -> 0x00b6 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x00b6 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r2)     // Catch:{ all -> 0x00b6 }
            com.iflytek.cloud.SpeechError r2 = new com.iflytek.cloud.SpeechError     // Catch:{ all -> 0x00b6 }
            r3 = 20003(0x4e23, float:2.803E-41)
            r2.<init>((int) r3)     // Catch:{ all -> 0x00b6 }
            r6.a((com.iflytek.cloud.SpeechError) r2)     // Catch:{ all -> 0x00b6 }
            if (r0 == 0) goto L_0x00b2
            r0.close()     // Catch:{ Exception -> 0x00b5 }
        L_0x00b2:
            if (r1 == 0) goto L_0x00b5
            goto L_0x007b
        L_0x00b5:
            return
        L_0x00b6:
            r2 = move-exception
        L_0x00b7:
            if (r0 == 0) goto L_0x00bc
            r0.close()     // Catch:{ Exception -> 0x00c1 }
        L_0x00bc:
            if (r1 == 0) goto L_0x00c1
            r1.disconnect()     // Catch:{ Exception -> 0x00c1 }
        L_0x00c1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.by.c():void");
    }

    private int d() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            i += this.e.get(i2).length;
        }
        return i;
    }

    public void a() {
        this.c = true;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(a aVar) {
        this.b = aVar;
        start();
    }

    public void a(String str, String str2, byte[] bArr) {
        this.e.clear();
        a(bArr);
        try {
            this.d = a(str, str2);
        } catch (MalformedURLException e2) {
            cb.a((Throwable) e2);
        }
    }

    public void a(String str, String str2, byte[] bArr, String str3) {
        this.f = str3;
        a(str, str2, bArr);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.e.add(bArr);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0103 A[SYNTHETIC, Splitter:B:38:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010d A[SYNTHETIC, Splitter:B:44:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0112 A[Catch:{ Exception -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = "MscHttpRequest start Post"
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00dd, all -> 0x00da }
            java.net.URL r1 = r6.d     // Catch:{ Exception -> 0x00dd, all -> 0x00da }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ Exception -> 0x00dd, all -> 0x00da }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ Exception -> 0x00dd, all -> 0x00da }
            r2 = 1
            r1.setDoOutput(r2)     // Catch:{ Exception -> 0x00d8 }
            r1.setDoInput(r2)     // Catch:{ Exception -> 0x00d8 }
            r2 = 0
            r1.setUseCaches(r2)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "POST"
            r1.setRequestMethod(r2)     // Catch:{ Exception -> 0x00d8 }
            int r2 = r6.a     // Catch:{ Exception -> 0x00d8 }
            r1.setConnectTimeout(r2)     // Catch:{ Exception -> 0x00d8 }
            int r2 = r6.a     // Catch:{ Exception -> 0x00d8 }
            r1.setReadTimeout(r2)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "Content-length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
            r3.<init>()     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = ""
            r3.append(r4)     // Catch:{ Exception -> 0x00d8 }
            int r4 = r6.d()     // Catch:{ Exception -> 0x00d8 }
            r3.append(r4)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d8 }
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "Connection"
            java.lang.String r3 = "Keep-Alive"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "Charset"
            java.lang.String r3 = "utf-8"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-gzip"
            r1.setRequestProperty(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r2 = r6.f     // Catch:{ Exception -> 0x00d8 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00d8 }
            if (r2 != 0) goto L_0x006f
            java.lang.String r2 = r6.f     // Catch:{ Exception -> 0x00d8 }
            byte[] r2 = r2.getBytes()     // Catch:{ Exception -> 0x00d8 }
            r3 = 2
            java.lang.String r2 = android.util.Base64.encodeToString(r2, r3)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = "X-Par"
            r1.setRequestProperty(r3, r2)     // Catch:{ Exception -> 0x00d8 }
        L_0x006f:
            java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ Exception -> 0x00d8 }
            java.util.ArrayList<byte[]> r3 = r6.e     // Catch:{ Exception -> 0x00d8 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x00d8 }
        L_0x0079:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x00d8 }
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x00d8 }
            byte[] r4 = (byte[]) r4     // Catch:{ Exception -> 0x00d8 }
            r2.write(r4)     // Catch:{ Exception -> 0x00d8 }
            goto L_0x0079
        L_0x0089:
            r2.flush()     // Catch:{ Exception -> 0x00d8 }
            r2.close()     // Catch:{ Exception -> 0x00d8 }
            int r2 = r1.getResponseCode()     // Catch:{ Exception -> 0x00d8 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r3 != r2) goto L_0x00ae
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ Exception -> 0x00d8 }
            byte[] r0 = r6.a((java.io.InputStream) r2)     // Catch:{ Exception -> 0x00a9, all -> 0x00a4 }
            r6.b((byte[]) r0)     // Catch:{ Exception -> 0x00a9, all -> 0x00a4 }
            r0 = r2
            goto L_0x00cd
        L_0x00a4:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x010b
        L_0x00a9:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x00df
        L_0x00ae:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8 }
            r3.<init>()     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r4 = "Http Request Failed."
            r3.append(r4)     // Catch:{ Exception -> 0x00d8 }
            r3.append(r2)     // Catch:{ Exception -> 0x00d8 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00d8 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r3)     // Catch:{ Exception -> 0x00d8 }
            com.iflytek.cloud.SpeechError r3 = new com.iflytek.cloud.SpeechError     // Catch:{ Exception -> 0x00d8 }
            r4 = 12000(0x2ee0, float:1.6816E-41)
            int r4 = r4 + r2
            r3.<init>((int) r4)     // Catch:{ Exception -> 0x00d8 }
            r6.a((com.iflytek.cloud.SpeechError) r3)     // Catch:{ Exception -> 0x00d8 }
        L_0x00cd:
            if (r0 == 0) goto L_0x00d2
            r0.close()     // Catch:{ Exception -> 0x0109 }
        L_0x00d2:
            if (r1 == 0) goto L_0x0109
        L_0x00d4:
            r1.disconnect()     // Catch:{ Exception -> 0x0109 }
            return
        L_0x00d8:
            r2 = move-exception
            goto L_0x00df
        L_0x00da:
            r2 = move-exception
            r1 = r0
            goto L_0x010b
        L_0x00dd:
            r2 = move-exception
            r1 = r0
        L_0x00df:
            com.iflytek.cloud.SpeechError r3 = new com.iflytek.cloud.SpeechError     // Catch:{ all -> 0x010a }
            r4 = 20003(0x4e23, float:2.803E-41)
            r3.<init>((int) r4)     // Catch:{ all -> 0x010a }
            r6.a((com.iflytek.cloud.SpeechError) r3)     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            r3.<init>()     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "MscHttpRequest error:"
            r3.append(r4)     // Catch:{ all -> 0x010a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x010a }
            r3.append(r2)     // Catch:{ all -> 0x010a }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x010a }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r2)     // Catch:{ all -> 0x010a }
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ Exception -> 0x0109 }
        L_0x0106:
            if (r1 == 0) goto L_0x0109
            goto L_0x00d4
        L_0x0109:
            return
        L_0x010a:
            r2 = move-exception
        L_0x010b:
            if (r0 == 0) goto L_0x0110
            r0.close()     // Catch:{ Exception -> 0x0115 }
        L_0x0110:
            if (r1 == 0) goto L_0x0115
            r1.disconnect()     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.by.b():void");
    }

    public void b(int i) {
        this.a = i;
    }

    public void run() {
        if (this.h == 1) {
            b();
        } else {
            c();
        }
    }
}
