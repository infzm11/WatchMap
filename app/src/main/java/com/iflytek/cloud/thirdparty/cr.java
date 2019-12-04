package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.Version;
import com.iflytek.cloud.thirdparty.cq;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class cr extends cq {
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    private static boolean g = true;
    private static String h = "300008448508";
    private static final byte[] i = {31};
    private static final String j = new String(i);
    private static Context k = null;
    private static boolean l = false;
    private static int m;
    private static final int n;
    private static final int o;
    private static final int p;
    private static final int q;
    private static final int r;
    private static final int s = m;
    private static boolean v = (true ^ MSC.isIflyVersion());
    private String[] t = new String[s];
    private Object u = this;
    private cq.a w = null;
    private boolean x = false;
    private long y = System.currentTimeMillis();

    static {
        int i2 = m;
        m = i2 + 1;
        b = i2;
        int i3 = m;
        m = i3 + 1;
        n = i3;
        int i4 = m;
        m = i4 + 1;
        o = i4;
        int i5 = m;
        m = i5 + 1;
        c = i5;
        int i6 = m;
        m = i6 + 1;
        p = i6;
        int i7 = m;
        m = i7 + 1;
        q = i7;
        int i8 = m;
        m = i8 + 1;
        r = i8;
        int i9 = m;
        m = i9 + 1;
        d = i9;
        int i10 = m;
        m = i10 + 1;
        e = i10;
        int i11 = m;
        m = i11 + 1;
        f = i11;
    }

    private cr(cq.a aVar) {
        this.w = aVar;
        h();
    }

    private static String a(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS", Locale.CHINA).format(Long.valueOf(str));
        } catch (Throwable th) {
            h("DC exception:" + th.getLocalizedMessage());
            th.printStackTrace();
            return null;
        }
    }

    private static void a(Context context) {
        synchronized (a) {
            k = context;
        }
    }

    private static synchronized void a(boolean z) {
        synchronized (cr.class) {
            synchronized (a) {
                g = z;
            }
        }
    }

    private static final boolean a(int i2) {
        return o == i2 || p == i2 || q == i2 || r == i2;
    }

    public static synchronized cr b(cq.a aVar) {
        cr crVar;
        synchronized (cr.class) {
            g("DC create enter.");
            crVar = new cr(aVar);
            g("DC create leave.");
        }
        return crVar;
    }

    public static synchronized boolean b(Context context, String str, boolean z) {
        synchronized (cr.class) {
            g("DC init enter.");
            synchronized (a) {
                try {
                    a(z);
                    a(context);
                    c(str);
                    g();
                } catch (Throwable th) {
                    h("DC exception:" + th.getLocalizedMessage());
                    th.printStackTrace();
                }
            }
            g("DC init leave.");
        }
        return false;
    }

    private static boolean b(String str) {
        return str != null && str.length() >= 12;
    }

    public static synchronized void c() {
        synchronized (cr.class) {
            g("DC destory enter.");
            synchronized (a) {
                try {
                    k = null;
                    l = false;
                } catch (Throwable th) {
                    h("DC exception:" + th.getLocalizedMessage());
                    th.printStackTrace();
                }
            }
            g("DC destory leave.");
        }
    }

    private static void c(String str) {
        synchronized (a) {
            if (b(str)) {
                h = str;
            }
        }
    }

    private static String d(String str) {
        String str2;
        g("getMscParameter enter key=" + str);
        String str3 = null;
        if (!MSC.isLoaded()) {
            str2 = "getMscParameter MSC is not loaded";
        } else if (TextUtils.isEmpty(str)) {
            str2 = "getMscParameter key is empty";
        } else {
            try {
                SpeechUtility utility = SpeechUtility.getUtility();
                String parameter = utility != null ? utility.getParameter("pte") : null;
                if (TextUtils.isEmpty(parameter)) {
                    parameter = "utf-8";
                }
                byte[] bytes = str.getBytes(parameter);
                MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
                int QMSPGetParam = MSC.QMSPGetParam(bytes, mSCSessionInfo);
                if (QMSPGetParam == 0) {
                    str3 = new String(mSCSessionInfo.buffer, parameter);
                } else {
                    g("getMscParameter MSC return " + QMSPGetParam);
                }
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            g("getMscParameter value=" + str3);
            g("getMscParameter leave");
            return str3;
        }
        h(str2);
        g("getMscParameter value=" + str3);
        g("getMscParameter leave");
        return str3;
    }

    public static synchronized boolean d() {
        boolean z;
        synchronized (cr.class) {
            g("DC getEnable enter.");
            synchronized (a) {
                g("DC getEnable static value=" + g);
                z = g;
            }
            if (z) {
                String d2 = d("idc");
                g("DC getEnable msc val=" + d2);
                if (!TextUtils.isEmpty(d2)) {
                    if ("li".equalsIgnoreCase(d2)) {
                        v = true;
                    } else {
                        v = false;
                    }
                }
                z = v;
            }
            g("DC getEnable value=" + z);
            g("DC getEnable leave.");
        }
        return z;
    }

    private static void e(String str) {
    }

    public static boolean e() {
        boolean z;
        f("DC isActive enter.");
        synchronized (a) {
            z = l;
        }
        g("DC isActive=" + z);
        f("DC isActive leave.");
        return z;
    }

    private static void f(String str) {
    }

    private static void g() {
        f("DC inner init enter.");
        synchronized (a) {
            try {
                if (!d()) {
                    g("DC init is not enable.");
                } else if (n() != null) {
                    g("DC calling MA.init");
                    b.d(n(), m(), "MobileMarket");
                    g("DC MA.init end");
                    l = true;
                }
            } catch (Throwable th) {
                h("DC exception:" + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        f("DC inner init leave.");
    }

    private static void g(String str) {
        cb.a(str);
    }

    private void h() {
        g("DC resetAllValues enter.");
        synchronized (this.u) {
            int i2 = 0;
            while (i2 < this.t.length) {
                try {
                    this.t[i2] = "";
                    i2++;
                } catch (Throwable th) {
                    h("DC exception:" + th.getLocalizedMessage());
                    th.printStackTrace();
                }
            }
        }
        g("DC resetAllValues leave.");
    }

    private static void h(String str) {
        cb.c(str);
    }

    private void i() {
        g("DC resetDynamicValues enter.");
        synchronized (this.u) {
            int i2 = 0;
            while (i2 < this.t.length) {
                try {
                    if (!a(i2)) {
                        this.t[i2] = "";
                    }
                    i2++;
                } catch (Throwable th) {
                    h("DC exception:" + th.getLocalizedMessage());
                    th.printStackTrace();
                }
            }
        }
        g("DC resetDynamicValues leave.");
    }

    private void j() {
        g("DC initStaticValues enter.");
        synchronized (this.u) {
            try {
                if (TextUtils.isEmpty(this.t[o])) {
                    this.t[o] = SpeechUtility.getUtility().getParameter("appid");
                    f("DC info APPID:" + this.t[o]);
                }
                if (TextUtils.isEmpty(this.t[p])) {
                    this.t[p] = Version.getVersion();
                }
                if (TextUtils.isEmpty(this.t[q])) {
                    this.t[q] = bp.a(k).e("os.imsi");
                }
                if (TextUtils.isEmpty(this.t[r])) {
                    this.t[r] = bp.a(k).e("os.imei");
                }
                if (TextUtils.isEmpty(this.t[n])) {
                    this.t[n] = l();
                }
            } catch (Throwable th) {
                h("DC exception:" + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        g("DC initStaticValues leave.");
    }

    private final void k() {
        f("DC check enter.");
        int i2 = 0;
        while (i2 < this.t.length) {
            try {
                if (this.t[i2] == null) {
                    this.t[i2] = "";
                }
                i2++;
            } catch (Throwable th) {
                h("DC exception:" + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        f("DC check leave.");
    }

    private static synchronized String l() {
        String str;
        String str2;
        synchronized (cr.class) {
            g("DC getUid enter.");
            str = null;
            try {
                String parameter = SpeechUtility.getUtility().getParameter("pte");
                if (TextUtils.isEmpty(parameter)) {
                    parameter = "utf-8";
                }
                MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
                if (MSC.QMSPGetParam("loginid".getBytes(parameter), mSCSessionInfo) == 0) {
                    String trim = new String(mSCSessionInfo.buffer).trim();
                    f("DC getUid loginid=" + trim);
                    int indexOf = trim.indexOf("@");
                    if (indexOf < 0 || indexOf >= trim.length()) {
                        str2 = "DC getUid error, loginid has no tag of @:" + trim;
                    } else {
                        str = trim.substring(0, indexOf);
                        g("DC getUid leave.");
                    }
                } else {
                    str2 = "DC getUid error:" + r2;
                }
                h(str2);
            } catch (Throwable th) {
                h("DC exception:" + th.getLocalizedMessage());
                th.printStackTrace();
            }
            g("DC getUid leave.");
        }
        return str;
    }

    private static String m() {
        String str;
        synchronized (a) {
            str = h;
        }
        return str;
    }

    private static Context n() {
        Context context;
        synchronized (a) {
            context = k;
        }
        return context;
    }

    public void a(int i2, int i3) {
        a(i2, String.valueOf(i3));
    }

    public void a(int i2, long j2) {
        a(i2, String.valueOf(j2));
    }

    public void a(int i2, String str) {
        f("DC setData enter: key=" + i2 + ", value=" + str);
        synchronized (this.u) {
            try {
                this.t[i2] = str;
                if (d == i2 || e == i2) {
                    this.t[i2] = a(str);
                }
                if (d == i2 || e == i2 || b == i2 || c == i2) {
                    g("DC info: key=" + i2 + ", value=" + this.t[i2]);
                }
            } catch (Throwable th) {
                h("DC exception:" + th.getLocalizedMessage());
                th.printStackTrace();
            }
        }
        f("DC setData leave.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0011, code lost:
        if (d() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        if (r3.w == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0017, code lost:
        r0 = r3.w.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        a(c, r0);
        a(d, r3.y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
        if ("local".equals(r3.w.A()) == false) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
        r0 = "csid:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r0 = "sid:";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r1 = b;
        a(r1, r0 + r3.w.B());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005c, code lost:
        if (r4 != null) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r4 = r4.getErrorCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        a(f, r4);
        a(e, java.lang.System.currentTimeMillis());
        f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.iflytek.cloud.SpeechError r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.u     // Catch:{ Throwable -> 0x0079 }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x0079 }
            boolean r1 = r3.x     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0009:
            r1 = 1
            r3.x = r1     // Catch:{ all -> 0x0076 }
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            boolean r0 = d()     // Catch:{ Throwable -> 0x0079 }
            if (r0 == 0) goto L_0x0082
            com.iflytek.cloud.thirdparty.cq$a r0 = r3.w     // Catch:{ Throwable -> 0x0079 }
            if (r0 == 0) goto L_0x0082
            com.iflytek.cloud.thirdparty.cq$a r0 = r3.w     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r0 = r0.g()     // Catch:{ Throwable -> 0x0079 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0079 }
            if (r1 != 0) goto L_0x0082
            int r1 = c     // Catch:{ Throwable -> 0x0079 }
            r3.a((int) r1, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0079 }
            int r0 = d     // Catch:{ Throwable -> 0x0079 }
            long r1 = r3.y     // Catch:{ Throwable -> 0x0079 }
            r3.a((int) r0, (long) r1)     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r0 = "local"
            com.iflytek.cloud.thirdparty.cq$a r1 = r3.w     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r1 = r1.A()     // Catch:{ Throwable -> 0x0079 }
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x0079 }
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = "csid:"
            goto L_0x0042
        L_0x0040:
            java.lang.String r0 = "sid:"
        L_0x0042:
            int r1 = b     // Catch:{ Throwable -> 0x0079 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0079 }
            r2.<init>()     // Catch:{ Throwable -> 0x0079 }
            r2.append(r0)     // Catch:{ Throwable -> 0x0079 }
            com.iflytek.cloud.thirdparty.cq$a r0 = r3.w     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r0 = r0.B()     // Catch:{ Throwable -> 0x0079 }
            r2.append(r0)     // Catch:{ Throwable -> 0x0079 }
            java.lang.String r0 = r2.toString()     // Catch:{ Throwable -> 0x0079 }
            r3.a((int) r1, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0079 }
            if (r4 != 0) goto L_0x0060
            r4 = 0
            goto L_0x0064
        L_0x0060:
            int r4 = r4.getErrorCode()     // Catch:{ Throwable -> 0x0079 }
        L_0x0064:
            int r0 = f     // Catch:{ Throwable -> 0x0079 }
            r3.a((int) r0, (int) r4)     // Catch:{ Throwable -> 0x0079 }
            int r4 = e     // Catch:{ Throwable -> 0x0079 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x0079 }
            r3.a((int) r4, (long) r0)     // Catch:{ Throwable -> 0x0079 }
            r3.f()     // Catch:{ Throwable -> 0x0079 }
            return
        L_0x0076:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r4     // Catch:{ Throwable -> 0x0079 }
        L_0x0079:
            r4 = move-exception
            java.lang.String r0 = "DC exception:"
            com.iflytek.cloud.thirdparty.cb.c(r0)
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r4)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.cr.a(com.iflytek.cloud.SpeechError):void");
    }

    public void a(String str, boolean z) {
    }

    public void b() {
        this.y = System.currentTimeMillis();
    }

    public boolean f() {
        g("DC flush enter.");
        try {
            if (!e()) {
                g();
            }
            if (e()) {
                j();
                k();
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < this.t.length; i2++) {
                    if (this.t[i2] != null) {
                        stringBuffer.append(this.t[i2]);
                    }
                    stringBuffer.append(j);
                }
                String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
                f("DC flush data=" + substring);
                e(substring);
                synchronized (a) {
                    if (!TextUtils.isEmpty(substring) && e()) {
                        g("DC calling MA.onEvent");
                        b.a(k, "iflytek", substring);
                        g("DC MA.onEvent end");
                    }
                }
                i();
            }
        } catch (Throwable th) {
            h("DC exception:" + th.getLocalizedMessage());
            th.printStackTrace();
        }
        g("DC flush leave.");
        return true;
    }
}
