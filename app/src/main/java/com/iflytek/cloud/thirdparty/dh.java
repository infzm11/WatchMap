package com.iflytek.cloud.thirdparty;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class dh extends Thread {
    boolean a = true;
    private String b;
    private di c;

    public dh(String str, di diVar) {
        this.b = str;
        this.c = diVar;
    }

    private String a(byte[] bArr) {
        String str;
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            dr.a("HttpGetThread", "unzip len " + bArr.length);
            a(byteArrayInputStream, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            str = new String(byteArrayOutputStream.toByteArray());
            try {
                dr.a("HttpGetThread", "unzip str " + str);
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
                return str;
            } catch (Exception e) {
                e = e;
                dr.a("HttpGetThread", "unzip error ", e);
                return str;
            }
        } catch (Exception e2) {
            e = e2;
            str = null;
            dr.a("HttpGetThread", "unzip error ", e);
            return str;
        }
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr, 0, 1024);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return;
            }
        }
    }

    public void run() {
        byte[] bArr;
        try {
            DefaultHttpClient defaultHttpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(this.b);
            httpGet.setHeader("Accept-Encoding", "gzip, deflate");
            HttpResponse execute = defaultHttpClient.execute(httpGet);
            if (execute.getStatusLine().getStatusCode() == 200) {
                Header firstHeader = execute.getFirstHeader("Content-Length");
                int parseInt = firstHeader != null ? Integer.parseInt(firstHeader.getValue()) : 0;
                if (parseInt <= 0 || parseInt >= 1048576) {
                    byte[] bArr2 = new byte[1048576];
                    int read = execute.getEntity().getContent().read(bArr2);
                    byte[] bArr3 = new byte[read];
                    System.arraycopy(bArr2, 0, bArr3, 0, read);
                    bArr = bArr3;
                } else {
                    bArr = new byte[parseInt];
                    execute.getEntity().getContent().read(bArr);
                }
                String a2 = this.a ? a(bArr) : null;
                if (a2 == null) {
                    a2 = new String(bArr);
                }
                if (this.c != null) {
                    this.c.a(a2, 0);
                    return;
                }
                return;
            }
        } catch (Exception e) {
            dr.a("HttpGetThread", "Other Exception", e);
        }
        if (this.c != null) {
            this.c.a((String) null, -1);
        }
    }
}
