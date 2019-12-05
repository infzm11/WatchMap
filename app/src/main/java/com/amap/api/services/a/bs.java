package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogProcessor */
public abstract class bs {
    static final List<b> a = Collections.synchronizedList(new ArrayList());
    private bh b;
    private int c;
    private cu d;
    private ct e;

    /* compiled from: LogProcessor */
    class a implements cu {
        private cc b;

        a(cc ccVar) {
            this.b = ccVar;
        }

        public void a(String str) {
            try {
                this.b.b(str, bm.a(bs.this.c()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* compiled from: LogProcessor */
    public interface b {
        void a(Context context);
    }

    /* access modifiers changed from: protected */
    public abstract String a(List<bh> list);

    /* access modifiers changed from: protected */
    public abstract boolean a(Context context);

    public static List<b> a() {
        return a;
    }

    protected bs(int i) {
        this.c = i;
    }

    private void f(Context context) {
        try {
            this.e = b(context, b());
        } catch (Throwable th) {
            bl.a(th, "LogProcessor", "LogUpDateProcessor");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(bh bhVar, Context context, Throwable th, String str, String str2, String str3) {
        a(bhVar, context, c(th), str, str2, str3);
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void a(bh bhVar, Context context, String str, String str2, String str3, String str4) {
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        a(bhVar);
        String a2 = dk.a();
        String a3 = a(context2, bhVar);
        String a4 = az.a(context);
        if (str5 != null && !"".equals(str5)) {
            int c2 = c();
            StringBuilder sb = new StringBuilder();
            if (str7 != null) {
                sb.append("class:");
                sb.append(str7);
            }
            if (str8 != null) {
                sb.append(" method:");
                sb.append(str8);
                sb.append("$");
                sb.append("<br/>");
            }
            sb.append(str6);
            String a5 = a(str6);
            String a6 = dk.a(a4, a3, a2, c2, str5, sb.toString());
            if (a6 != null && !"".equals(a6)) {
                String a7 = a(context2, a6);
                String b2 = b();
                synchronized (Looper.getMainLooper()) {
                    try {
                        cc ccVar = new cc(context2);
                        boolean a8 = a(context2, a5, b2, a7, ccVar);
                        a(ccVar, bhVar.a(), a5, c2, a8);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    public static String a(Context context, bh bhVar) {
        return dk.a(context, bhVar);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, Throwable th, String str, String str2) {
        List<bh> g = g(context);
        if (g != null && g.size() != 0) {
            String a2 = a(th);
            if (a2 != null && !"".equals(a2)) {
                for (bh next : g) {
                    if (a(next.f(), a2)) {
                        a(next, context, th, a2.replaceAll("\n", "<br/>"), str, str2);
                        return;
                    }
                }
                if (a2.contains("com.amap.api.col")) {
                    try {
                        a(bi.a(), context, th, a2, str, str2);
                    } catch (ay e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Context context) {
        List<bh> g = g(context);
        if (g != null && g.size() != 0) {
            String a2 = a(g);
            if (a2 != null && !"".equals(a2)) {
                String a3 = dk.a();
                String a4 = dk.a(context, this.b);
                String a5 = az.a(context);
                int c2 = c();
                String a6 = dk.a(a5, a4, a3, c2, "ANR", a2);
                if (a6 != null && !"".equals(a6)) {
                    String a7 = a(a2);
                    String a8 = a(context, a6);
                    String b2 = b();
                    synchronized (Looper.getMainLooper()) {
                        cc ccVar = new cc(context);
                        boolean a9 = a(context, a7, b2, a8, ccVar);
                        a(ccVar, this.b.a(), a7, c2, a9);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(bh bhVar) {
        this.b = bhVar;
    }

    private List<bh> g(Context context) {
        List<bh> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    List<bh> a2 = new ce(context, false).a();
                    try {
                        return a2;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        list = a2;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
            return list;
        }
    }

    private void a(cc ccVar, String str, String str2, int i, boolean z) {
        cd b2 = bm.b(i);
        b2.a(0);
        b2.b(str);
        b2.a(str2);
        ccVar.a(b2);
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        return bf.c(str);
    }

    /* access modifiers changed from: protected */
    public cu a(cc ccVar) {
        try {
            if (this.d == null) {
                this.d = new a(ccVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.d;
    }

    private String a(Context context, String str) {
        try {
            return bc.e(context, bi.a(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String a(Throwable th) {
        try {
            return b(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private String c(Throwable th) {
        return th.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x00f1 A[SYNTHETIC, Splitter:B:105:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x00fb A[SYNTHETIC, Splitter:B:110:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a5 A[SYNTHETIC, Splitter:B:67:0x00a5] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00af A[SYNTHETIC, Splitter:B:72:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00cb A[SYNTHETIC, Splitter:B:86:0x00cb] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00d5 A[SYNTHETIC, Splitter:B:91:0x00d5] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00a0=Splitter:B:64:0x00a0, B:83:0x00c6=Splitter:B:83:0x00c6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, com.amap.api.services.a.cc r9) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r5 = com.amap.api.services.a.bm.a((android.content.Context) r5, (java.lang.String) r7)     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            boolean r5 = r7.exists()     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            if (r5 != 0) goto L_0x0018
            boolean r5 = r7.mkdirs()     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            if (r5 != 0) goto L_0x0018
            return r1
        L_0x0018:
            r2 = 20480(0x5000, double:1.01185E-319)
            r5 = 1
            com.amap.api.services.a.ct r7 = com.amap.api.services.a.ct.a(r7, r5, r5, r2)     // Catch:{ IOException -> 0x00c3, Throwable -> 0x009d, all -> 0x0099 }
            com.amap.api.services.a.cu r9 = r4.a((com.amap.api.services.a.cc) r9)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            r7.a((com.amap.api.services.a.cu) r9)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            com.amap.api.services.a.ct$b r9 = r7.a((java.lang.String) r6)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            if (r9 == 0) goto L_0x0047
            if (r9 == 0) goto L_0x0036
            r9.close()     // Catch:{ Throwable -> 0x0032 }
            goto L_0x0036
        L_0x0032:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0036:
            if (r7 == 0) goto L_0x0046
            boolean r5 = r7.c()
            if (r5 != 0) goto L_0x0046
            r7.close()     // Catch:{ Throwable -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0046:
            return r1
        L_0x0047:
            byte[] r8 = com.amap.api.services.a.bi.a((java.lang.String) r8)     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            com.amap.api.services.a.ct$a r6 = r7.b((java.lang.String) r6)     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            java.io.OutputStream r2 = r6.a((int) r1)     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            r2.write(r8)     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            r6.a()     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            r7.d()     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            if (r2 == 0) goto L_0x0066
            r2.close()     // Catch:{ Throwable -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0066:
            if (r9 == 0) goto L_0x0070
            r9.close()     // Catch:{ Throwable -> 0x006c }
            goto L_0x0070
        L_0x006c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0070:
            if (r7 == 0) goto L_0x0080
            boolean r6 = r7.c()
            if (r6 != 0) goto L_0x0080
            r7.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0080
        L_0x007c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0080:
            return r5
        L_0x0081:
            r5 = move-exception
            r0 = r2
            goto L_0x00ef
        L_0x0085:
            r5 = move-exception
            r0 = r2
            goto L_0x00a0
        L_0x0088:
            r5 = move-exception
            r0 = r2
            goto L_0x00c6
        L_0x008b:
            r5 = move-exception
            goto L_0x00a0
        L_0x008d:
            r5 = move-exception
            goto L_0x00c6
        L_0x008f:
            r5 = move-exception
            r9 = r0
            goto L_0x00ef
        L_0x0093:
            r5 = move-exception
            r9 = r0
            goto L_0x00a0
        L_0x0096:
            r5 = move-exception
            r9 = r0
            goto L_0x00c6
        L_0x0099:
            r5 = move-exception
            r7 = r0
            r9 = r7
            goto L_0x00ef
        L_0x009d:
            r5 = move-exception
            r7 = r0
            r9 = r7
        L_0x00a0:
            r5.printStackTrace()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00ad
            r0.close()     // Catch:{ Throwable -> 0x00a9 }
            goto L_0x00ad
        L_0x00a9:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00ad:
            if (r9 == 0) goto L_0x00b7
            r9.close()     // Catch:{ Throwable -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00b7:
            if (r7 == 0) goto L_0x00ed
            boolean r5 = r7.c()
            if (r5 != 0) goto L_0x00ed
            r7.close()     // Catch:{ Throwable -> 0x00e9 }
            goto L_0x00ed
        L_0x00c3:
            r5 = move-exception
            r7 = r0
            r9 = r7
        L_0x00c6:
            r5.printStackTrace()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00d3
            r0.close()     // Catch:{ Throwable -> 0x00cf }
            goto L_0x00d3
        L_0x00cf:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00d3:
            if (r9 == 0) goto L_0x00dd
            r9.close()     // Catch:{ Throwable -> 0x00d9 }
            goto L_0x00dd
        L_0x00d9:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00dd:
            if (r7 == 0) goto L_0x00ed
            boolean r5 = r7.c()
            if (r5 != 0) goto L_0x00ed
            r7.close()     // Catch:{ Throwable -> 0x00e9 }
            goto L_0x00ed
        L_0x00e9:
            r5 = move-exception
            r5.printStackTrace()
        L_0x00ed:
            return r1
        L_0x00ee:
            r5 = move-exception
        L_0x00ef:
            if (r0 == 0) goto L_0x00f9
            r0.close()     // Catch:{ Throwable -> 0x00f5 }
            goto L_0x00f9
        L_0x00f5:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f9:
            if (r9 == 0) goto L_0x0103
            r9.close()     // Catch:{ Throwable -> 0x00ff }
            goto L_0x0103
        L_0x00ff:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0103:
            if (r7 == 0) goto L_0x0113
            boolean r6 = r7.c()
            if (r6 != 0) goto L_0x0113
            r7.close()     // Catch:{ Throwable -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0113:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bs.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.amap.api.services.a.cc):boolean");
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String trim : str.split("\n")) {
                if (b(strArr, trim.trim())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public static boolean b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            String str2 = str;
            for (String str3 : strArr) {
                str2 = str2.trim();
                if (str2.startsWith("at ")) {
                    if (str2.contains(str3 + ".") && str2.endsWith(")")) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = r4.a((android.content.Context) r5)     // Catch:{ Throwable -> 0x004e }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x004e }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x004e }
            r4.f(r5)     // Catch:{ all -> 0x004b }
            com.amap.api.services.a.cc r1 = new com.amap.api.services.a.cc     // Catch:{ all -> 0x004b }
            r1.<init>(r5)     // Catch:{ all -> 0x004b }
            int r2 = r4.c()     // Catch:{ all -> 0x004b }
            r4.a((com.amap.api.services.a.cc) r1, (int) r2)     // Catch:{ all -> 0x004b }
            r2 = 0
            int r3 = r4.c()     // Catch:{ all -> 0x004b }
            java.lang.Class r3 = com.amap.api.services.a.bm.a((int) r3)     // Catch:{ all -> 0x004b }
            java.util.List r2 = r1.a((int) r2, (java.lang.Class<? extends com.amap.api.services.a.cd>) r3)     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0049
            int r3 = r2.size()     // Catch:{ all -> 0x004b }
            if (r3 != 0) goto L_0x0031
            goto L_0x0049
        L_0x0031:
            java.lang.String r5 = r4.a((java.util.List<? extends com.amap.api.services.a.cd>) r2, (android.content.Context) r5)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0039
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x0039:
            int r5 = b((java.lang.String) r5)     // Catch:{ all -> 0x004b }
            r3 = 1
            if (r5 != r3) goto L_0x0047
            int r5 = r4.c()     // Catch:{ all -> 0x004b }
            r4.a(r2, r1, r5)     // Catch:{ all -> 0x004b }
        L_0x0047:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            goto L_0x0056
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return
        L_0x004b:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r5     // Catch:{ Throwable -> 0x004e }
        L_0x004e:
            r5 = move-exception
            java.lang.String r0 = "LogProcessor"
            java.lang.String r1 = "processUpdateLog"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bs.c(android.content.Context):void");
    }

    private boolean c(String str) {
        if (this.e == null) {
            return false;
        }
        try {
            return this.e.c(str);
        } catch (Throwable th) {
            bl.a(th, "LogUpdateProcessor", "deleteLogData-" + str);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String b() {
        return bm.c(this.c);
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.c;
    }

    private void a(cc ccVar, int i) {
        try {
            a(ccVar.a(2, bm.a(i)), ccVar, i);
        } catch (Throwable th) {
            bl.a(th, "LogProcessor", "processDeleteFail");
        }
    }

    public static int b(String str) {
        bn bnVar = new bn(bi.c(bi.a(str)));
        int i = 1;
        try {
            byte[] a2 = cx.a().a(bnVar);
            if (a2 == null) {
                return 0;
            }
            try {
                JSONObject jSONObject = new JSONObject(bi.a(a2));
                if (jSONObject.has("code")) {
                    return jSONObject.getInt("code");
                }
                return 0;
            } catch (JSONException e2) {
                bl.a((Throwable) e2, "LogProcessor", "processUpdate");
                return 1;
            }
        } catch (ay e3) {
            if (e3.e() == 27) {
                i = 0;
            }
            bl.a((Throwable) e3, "LogProcessor", "processUpdate");
            return i;
        }
    }

    private void a(List<? extends cd> list, cc ccVar, int i) {
        if (list != null && list.size() > 0) {
            for (cd cdVar : list) {
                if (c(cdVar.b())) {
                    ccVar.a(cdVar.b(), (Class<? extends cd>) cdVar.getClass());
                } else {
                    cdVar.a(2);
                    ccVar.b(cdVar);
                }
            }
        }
    }

    public static String d(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"key\":\"");
            sb.append(az.f(context));
            sb.append("\",\"platform\":\"android\",\"diu\":\"");
            sb.append(bd.q(context));
            sb.append("\",\"pkg\":\"");
            sb.append(az.c(context));
            sb.append("\",\"model\":\"");
            sb.append(Build.MODEL);
            sb.append("\",\"appname\":\"");
            sb.append(az.b(context));
            sb.append("\",\"appversion\":\"");
            sb.append(az.d(context));
            sb.append("\",\"sysversion\":\"");
            sb.append(Build.VERSION.RELEASE);
            sb.append("\",");
        } catch (Throwable th) {
            bl.a(th, "CInfo", "getPublicJSONInfo");
        }
        return sb.toString();
    }

    public static String e(Context context) {
        try {
            String d2 = d(context);
            if ("".equals(d2)) {
                return null;
            }
            return bc.b(context, bi.a(d2));
        } catch (Throwable th) {
            bl.a(th, "LogProcessor", "getPublicInfo");
            return null;
        }
    }

    private String a(List<? extends cd> list, Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"pinfo\":\"");
        sb.append(e(context));
        sb.append("\",\"els\":[");
        boolean z = true;
        for (cd b2 : list) {
            String d2 = d(b2.b());
            if (d2 != null && !"".equals(d2)) {
                String str = d2 + "||" + b2.c();
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append("{\"log\":\"");
                sb.append(str);
                sb.append("\"}");
            }
        }
        if (z) {
            return null;
        }
        sb.append("]}");
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0067 A[SYNTHETIC, Splitter:B:42:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0075 A[SYNTHETIC, Splitter:B:47:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0085 A[SYNTHETIC, Splitter:B:54:0x0085] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0093 A[SYNTHETIC, Splitter:B:59:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String d(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            com.amap.api.services.a.ct r1 = r6.e     // Catch:{ Throwable -> 0x005b, all -> 0x0056 }
            if (r1 != 0) goto L_0x0006
            return r0
        L_0x0006:
            com.amap.api.services.a.ct r1 = r6.e     // Catch:{ Throwable -> 0x005b, all -> 0x0056 }
            com.amap.api.services.a.ct$b r7 = r1.a((java.lang.String) r7)     // Catch:{ Throwable -> 0x005b, all -> 0x0056 }
            if (r7 != 0) goto L_0x000f
            return r0
        L_0x000f:
            r1 = 0
            java.io.InputStream r7 = r7.a(r1)     // Catch:{ Throwable -> 0x005b, all -> 0x0056 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0053, all -> 0x004f }
            r2.<init>()     // Catch:{ Throwable -> 0x0053, all -> 0x004f }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x004d }
        L_0x001d:
            int r4 = r7.read(r3)     // Catch:{ Throwable -> 0x004d }
            r5 = -1
            if (r4 == r5) goto L_0x0028
            r2.write(r3, r1, r4)     // Catch:{ Throwable -> 0x004d }
            goto L_0x001d
        L_0x0028:
            byte[] r1 = r2.toByteArray()     // Catch:{ Throwable -> 0x004d }
            java.lang.String r1 = com.amap.api.services.a.bi.a((byte[]) r1)     // Catch:{ Throwable -> 0x004d }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r0 = move-exception
            java.lang.String r2 = "LogProcessor"
            java.lang.String r3 = "readLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r2, (java.lang.String) r3)
        L_0x003e:
            if (r7 == 0) goto L_0x004c
            r7.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r7 = move-exception
            java.lang.String r0 = "LogProcessor"
            java.lang.String r2 = "readLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r7, (java.lang.String) r0, (java.lang.String) r2)
        L_0x004c:
            return r1
        L_0x004d:
            r1 = move-exception
            goto L_0x005e
        L_0x004f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0083
        L_0x0053:
            r1 = move-exception
            r2 = r0
            goto L_0x005e
        L_0x0056:
            r7 = move-exception
            r2 = r0
            r0 = r7
            r7 = r2
            goto L_0x0083
        L_0x005b:
            r1 = move-exception
            r7 = r0
            r2 = r7
        L_0x005e:
            java.lang.String r3 = "LogProcessor"
            java.lang.String r4 = "readLog"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r1, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x0073
            r2.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x0073
        L_0x006b:
            r1 = move-exception
            java.lang.String r2 = "LogProcessor"
            java.lang.String r3 = "readLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0073:
            if (r7 == 0) goto L_0x0081
            r7.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x0081
        L_0x0079:
            r7 = move-exception
            java.lang.String r1 = "LogProcessor"
            java.lang.String r2 = "readLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0081:
            return r0
        L_0x0082:
            r0 = move-exception
        L_0x0083:
            if (r2 == 0) goto L_0x0091
            r2.close()     // Catch:{ IOException -> 0x0089 }
            goto L_0x0091
        L_0x0089:
            r1 = move-exception
            java.lang.String r2 = "LogProcessor"
            java.lang.String r3 = "readLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0091:
            if (r7 == 0) goto L_0x009f
            r7.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x009f
        L_0x0097:
            r7 = move-exception
            java.lang.String r1 = "LogProcessor"
            java.lang.String r2 = "readLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r2)
        L_0x009f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bs.d(java.lang.String):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        try {
            if (this.e != null && !this.e.c()) {
                this.e.close();
            }
        } catch (IOException e2) {
            bl.a((Throwable) e2, "LogProcessor", "closeDiskLru");
        } catch (Throwable th) {
            bl.a(th, "LogProcessor", "closeDiskLru");
        }
    }

    private ct b(Context context, String str) {
        try {
            File file = new File(bm.a(context, str));
            if (file.exists() || file.mkdirs()) {
                return ct.a(file, 1, 1, 20480);
            }
            return null;
        } catch (IOException e2) {
            bl.a((Throwable) e2, "LogProcessor", "initDiskLru");
            return null;
        } catch (Throwable th) {
            bl.a(th, "LogProcessor", "initDiskLru");
            return null;
        }
    }

    public static String b(Throwable th) {
        return bi.a(th);
    }
}
