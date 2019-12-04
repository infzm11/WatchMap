package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Locale;

public class ah {
    an a;
    private af b;
    private char[] c;
    private MSCSessionInfo d = new MSCSessionInfo();
    private MSCSessionInfo e = new MSCSessionInfo();
    private ae f;
    private String g = "";
    private String h = "";
    private boolean i;

    public ah(af afVar) {
        this.b = afVar;
        this.f = ae.a();
    }

    public int a(ce ceVar) throws n {
        this.i = false;
        try {
            byte[] bytes = ceVar.toString().getBytes("utf-8");
            synchronized (this) {
                if (this.c != null) {
                    return 0;
                }
                long currentTimeMillis = System.currentTimeMillis();
                this.c = MSC.AIUISessionBegin(bytes, this.d);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                int i2 = this.d.errorcode;
                cb.a("AIUISession", String.format(Locale.ENGLISH, "session begin, errorCode=%d, spent=%dms", new Object[]{Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}));
                if (i2 == 0) {
                    return 0;
                }
                throw new n(i2, "");
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            this.c = null;
            return -1;
        }
    }

    public int a(String str, String str2, String str3, String str4, String str5, Object obj) {
        return MSC.AIUIRegisterNotify(this.c, str, str2, str3, str4, str5, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r6.f.b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r0 == 0) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        throw new com.iflytek.cloud.thirdparty.n(r0, "");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() throws com.iflytek.cloud.thirdparty.n {
        /*
            r6 = this;
            r0 = 0
            r6.i = r0
            monitor-enter(r6)
            char[] r1 = r6.c     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x000a
            monitor-exit(r6)     // Catch:{ all -> 0x005e }
            return
        L_0x000a:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005e }
            char[] r3 = r6.c     // Catch:{ UnsupportedEncodingException -> 0x001e }
            java.lang.String r4 = ""
            java.lang.String r5 = "utf-8"
            byte[] r4 = r4.getBytes(r5)     // Catch:{ UnsupportedEncodingException -> 0x001e }
            int r3 = com.iflytek.msc.MSC.AIUISessionEnd(r3, r4)     // Catch:{ UnsupportedEncodingException -> 0x001e }
            r0 = r3
            goto L_0x0022
        L_0x001e:
            r3 = move-exception
            r3.printStackTrace()     // Catch:{ all -> 0x005e }
        L_0x0022:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x005e }
            long r3 = r3 - r1
            r1 = 0
            r6.c = r1     // Catch:{ all -> 0x005e }
            java.lang.String r1 = "AIUISession"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r5 = "session end, ret="
            r2.append(r5)     // Catch:{ all -> 0x005e }
            r2.append(r0)     // Catch:{ all -> 0x005e }
            java.lang.String r5 = ", spent="
            r2.append(r5)     // Catch:{ all -> 0x005e }
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "ms"
            r2.append(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005e }
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)     // Catch:{ all -> 0x005e }
            monitor-exit(r6)     // Catch:{ all -> 0x005e }
            com.iflytek.cloud.thirdparty.ae r1 = r6.f
            r1.b()
            if (r0 == 0) goto L_0x005d
            com.iflytek.cloud.thirdparty.n r1 = new com.iflytek.cloud.thirdparty.n
            java.lang.String r2 = ""
            r1.<init>(r0, r2)
            throw r1
        L_0x005d:
            return
        L_0x005e:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x005e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ah.a():void");
    }

    public synchronized void a(ce ceVar, byte[] bArr, int i2, boolean z) throws n {
        String str;
        String str2;
        int i3;
        this.i = true;
        if (z) {
            this.h = "";
            ce b2 = ceVar.clone();
            this.a = new an();
            this.a.a(ceVar);
            b2.a("dts", "1");
            b2.a("scene", ac.a("global", "scene", ""), false);
            b2.a("userparams", ac.a());
            br a2 = br.a(this.b.g());
            float a3 = a2.a("msc.lng");
            float a4 = a2.a("msc.lat");
            if (a3 > 0.0f && a4 > 0.0f) {
                b2.a("msc.lng", a3 + "", false);
                b2.a("msc.lat", a4 + "", false);
            }
            this.g = ceVar.e("stmid");
            ao.b("speech", al.a());
            str2 = ac.c(b2);
            str = ac.d(b2);
            i3 = 1;
        } else {
            if (TextUtils.isEmpty(this.h)) {
                ceVar.a("dts", "2");
                this.h = ac.d(ceVar);
            }
            str2 = "";
            str = this.h;
            i3 = 2;
        }
        if (1 == i3) {
            long currentTimeMillis = System.currentTimeMillis();
            cb.a("AIUISession", "stmid=" + this.g + ", dts=" + i3 + ", tstamp=" + currentTimeMillis);
        }
        a(str2, str, bArr, i2);
    }

    public void a(String str, String str2, byte[] bArr, int i2) throws n {
        synchronized (this) {
            if (this.c != null) {
                try {
                    MSC.AIUIDataWrite(this.c, str.getBytes("utf-8"), str2.getBytes("utf-8"), bArr, i2, this.e);
                    cb.a("AIUISession", String.format(Locale.ENGLISH, "dataLen=%d, params=%s, mscParams=%s, errorCode=%d, timestamp=%d", new Object[]{Integer.valueOf(i2), str, str2, Integer.valueOf(this.e.errorcode), Long.valueOf(System.currentTimeMillis())}));
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (this.e.errorcode != 0) {
                    throw new n(this.e.errorcode, "");
                }
            }
        }
    }

    public void a(String str, byte[] bArr, int i2) throws n {
        synchronized (this) {
            if (this.c != null) {
                try {
                    MSC.AIUISendLog(this.c, str.getBytes("utf-8"), bArr, i2, this.e);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
                if (this.e.errorcode != 0) {
                    throw new n(this.e.errorcode, "");
                }
            }
        }
    }

    public void a(byte[] bArr, byte[] bArr2, int i2, int i3) throws n {
        synchronized (this) {
            if (this.c != null) {
                MSC.AIUISyncData(this.c, bArr, bArr2, i2, i3, this.e);
                cb.a("AIUISession", String.format(Locale.ENGLISH, "dataLen=%d, errorCode=%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.e.errorcode)}));
                if (this.e.errorcode != 0) {
                    String str = "";
                    if (this.e.buffer != null) {
                        str = new String(this.e.buffer);
                    }
                    throw new n(this.e.errorcode, str);
                }
            }
        }
    }

    public boolean a(String str, String str2) {
        int i2;
        if (this.c == null) {
            return false;
        }
        try {
            i2 = MSC.AIUISetParam(this.c, str.getBytes("utf-8"), str2.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            i2 = -1;
        }
        return i2 == 0;
    }

    public void b() {
        synchronized (this) {
            if (this.c != null) {
                cb.a("AIUISession", "clear session data.");
                MSC.AIUIClear(this.c);
            }
            this.f.b();
        }
    }

    public synchronized void b(ce ceVar) throws n {
        try {
            String e2 = ceVar.e("stmid");
            byte[] bytes = this.a.a().getBytes("utf-8");
            StringBuffer stringBuffer = new StringBuffer("log=sessinfo");
            stringBuffer.append(",dtype=audio,cnt_id=0,");
            stringBuffer.append("stmid=" + e2);
            a("", stringBuffer.toString(), bytes, bytes.length);
        } catch (UnsupportedEncodingException e3) {
            cb.a((Throwable) e3);
        }
        return;
    }

    public synchronized void c(ce ceVar) throws n {
        this.a.a("app_lau");
        b(ceVar);
        ce b2 = ceVar.clone();
        b2.a("dts", "4");
        byte[] bArr = new byte[1];
        a("", ac.d(b2), bArr, bArr.length);
        long currentTimeMillis = System.currentTimeMillis();
        cb.a("AIUISession", "stmid=" + this.g + ", dts=4, tstamp=" + currentTimeMillis);
        this.g = ceVar.e("stmid");
        ao.a("speech", this.g, (HashMap<String, String>) null);
        this.i = false;
    }

    public boolean c() {
        boolean z;
        synchronized (this) {
            z = this.c != null;
        }
        return z;
    }

    public boolean d() {
        return this.i;
    }
}
