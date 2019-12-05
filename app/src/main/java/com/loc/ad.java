package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LogProcessor */
public abstract class ad {
    static final List a = Collections.synchronizedList(new ArrayList());
    private s b;
    private int c;
    private bf d;
    private be e;

    /* compiled from: LogProcessor */
    class a implements bf {
        private an b;

        a(an anVar) {
            this.b = anVar;
        }

        public final void a(String str) {
            try {
                this.b.b(str, x.a(ad.this.b()));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    protected ad(int i) {
        this.c = i;
    }

    private static be a(Context context, String str) {
        try {
            File file = new File(x.a(context, str));
            if (file.exists() || file.mkdirs()) {
                return be.a(file, 20480);
            }
            return null;
        } catch (Throwable th) {
            w.a(th, "lg", "id");
            return null;
        }
    }

    private bf a(an anVar) {
        try {
            if (this.d == null) {
                this.d = new a(anVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.d;
    }

    private static String a(Throwable th) {
        try {
            return t.a(th);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public static List a() {
        return a;
    }

    private static void a(an anVar, String str, String str2, int i) {
        ao b2 = x.b(i);
        b2.a(0);
        b2.b(str);
        b2.a(str2);
        anVar.a(b2);
    }

    private void a(List<? extends ao> list, an anVar) {
        if (list != null && list.size() > 0) {
            for (ao aoVar : list) {
                if (c(aoVar.b())) {
                    anVar.a(aoVar.b(), (Class<? extends ao>) aoVar.getClass());
                } else {
                    aoVar.a(2);
                    anVar.b(aoVar);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x00f4 A[SYNTHETIC, Splitter:B:107:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x00fe A[SYNTHETIC, Splitter:B:112:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a7 A[SYNTHETIC, Splitter:B:67:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b1 A[SYNTHETIC, Splitter:B:72:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x00d3 A[SYNTHETIC, Splitter:B:90:0x00d3] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x00dd A[SYNTHETIC, Splitter:B:95:0x00dd] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:64:0x00a2=Splitter:B:64:0x00a2, B:87:0x00ce=Splitter:B:87:0x00ce} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, com.loc.an r9) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.lang.String r5 = com.loc.x.a(r5, r7)     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            java.io.File r7 = new java.io.File     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            boolean r5 = r7.exists()     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            if (r5 != 0) goto L_0x0018
            boolean r5 = r7.mkdirs()     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            if (r5 != 0) goto L_0x0018
            return r0
        L_0x0018:
            r2 = 20480(0x5000, double:1.01185E-319)
            com.loc.be r5 = com.loc.be.a((java.io.File) r7, (long) r2)     // Catch:{ IOException -> 0x00ca, Throwable -> 0x009e, all -> 0x0099 }
            com.loc.bf r7 = r4.a((com.loc.an) r9)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            r5.a((com.loc.bf) r7)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            com.loc.be$b r7 = r5.a((java.lang.String) r6)     // Catch:{ IOException -> 0x0096, Throwable -> 0x0093, all -> 0x008f }
            if (r7 == 0) goto L_0x0046
            if (r7 == 0) goto L_0x0035
            r7.close()     // Catch:{ Throwable -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0035:
            if (r5 == 0) goto L_0x0045
            boolean r6 = r5.c()
            if (r6 != 0) goto L_0x0045
            r5.close()     // Catch:{ Throwable -> 0x0041 }
            return r0
        L_0x0041:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0045:
            return r0
        L_0x0046:
            byte[] r8 = com.loc.t.a((java.lang.String) r8)     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            com.loc.be$a r6 = r5.b((java.lang.String) r6)     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            java.io.OutputStream r9 = r6.a()     // Catch:{ IOException -> 0x008d, Throwable -> 0x008b }
            r9.write(r8)     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            r6.b()     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            r5.d()     // Catch:{ IOException -> 0x0088, Throwable -> 0x0085, all -> 0x0081 }
            if (r9 == 0) goto L_0x0065
            r9.close()     // Catch:{ Throwable -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0065:
            if (r7 == 0) goto L_0x006f
            r7.close()     // Catch:{ Throwable -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x006f:
            if (r5 == 0) goto L_0x007f
            boolean r6 = r5.c()
            if (r6 != 0) goto L_0x007f
            r5.close()     // Catch:{ Throwable -> 0x007b }
            goto L_0x007f
        L_0x007b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007f:
            r5 = 1
            return r5
        L_0x0081:
            r6 = move-exception
            r1 = r9
            goto L_0x00f2
        L_0x0085:
            r6 = move-exception
            r1 = r9
            goto L_0x00a2
        L_0x0088:
            r6 = move-exception
            r1 = r9
            goto L_0x00ce
        L_0x008b:
            r6 = move-exception
            goto L_0x00a2
        L_0x008d:
            r6 = move-exception
            goto L_0x00ce
        L_0x008f:
            r6 = move-exception
            r7 = r1
            goto L_0x00f2
        L_0x0093:
            r6 = move-exception
            r7 = r1
            goto L_0x00a2
        L_0x0096:
            r6 = move-exception
            r7 = r1
            goto L_0x00ce
        L_0x0099:
            r5 = move-exception
            r6 = r5
            r5 = r1
            r7 = r5
            goto L_0x00f2
        L_0x009e:
            r5 = move-exception
            r6 = r5
            r5 = r1
            r7 = r5
        L_0x00a2:
            r6.printStackTrace()     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x00af
            r1.close()     // Catch:{ Throwable -> 0x00ab }
            goto L_0x00af
        L_0x00ab:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00af:
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ Throwable -> 0x00b5 }
            goto L_0x00b9
        L_0x00b5:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00b9:
            if (r5 == 0) goto L_0x00f0
            boolean r6 = r5.c()
            if (r6 != 0) goto L_0x00f0
            r5.close()     // Catch:{ Throwable -> 0x00c5 }
            return r0
        L_0x00c5:
            r5 = move-exception
            r5.printStackTrace()
            return r0
        L_0x00ca:
            r5 = move-exception
            r6 = r5
            r5 = r1
            r7 = r5
        L_0x00ce:
            r6.printStackTrace()     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x00db
            r1.close()     // Catch:{ Throwable -> 0x00d7 }
            goto L_0x00db
        L_0x00d7:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00db:
            if (r7 == 0) goto L_0x00e5
            r7.close()     // Catch:{ Throwable -> 0x00e1 }
            goto L_0x00e5
        L_0x00e1:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00e5:
            if (r5 == 0) goto L_0x00f0
            boolean r6 = r5.c()
            if (r6 != 0) goto L_0x00f0
            r5.close()     // Catch:{ Throwable -> 0x00c5 }
        L_0x00f0:
            return r0
        L_0x00f1:
            r6 = move-exception
        L_0x00f2:
            if (r1 == 0) goto L_0x00fc
            r1.close()     // Catch:{ Throwable -> 0x00f8 }
            goto L_0x00fc
        L_0x00f8:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00fc:
            if (r7 == 0) goto L_0x0106
            r7.close()     // Catch:{ Throwable -> 0x0102 }
            goto L_0x0106
        L_0x0102:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0106:
            if (r5 == 0) goto L_0x0116
            boolean r7 = r5.c()
            if (r7 != 0) goto L_0x0116
            r5.close()     // Catch:{ Throwable -> 0x0112 }
            goto L_0x0116
        L_0x0112:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0116:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ad.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.loc.an):boolean");
    }

    public static boolean a(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            String str2 = str;
            for (String str3 : strArr) {
                str2 = str2.trim();
                if (str2.startsWith("at ")) {
                    if (str2.contains(str3 + ".") && str2.endsWith(")") && !str2.contains("uncaughtException")) {
                        return true;
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private static String b(String str) {
        try {
            return m.c(t.a(str));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static boolean b(String[] strArr, String str) {
        if (strArr == null || str == null) {
            return false;
        }
        try {
            for (String trim : str.split("\n")) {
                if (a(strArr, trim.trim())) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private boolean c(String str) {
        if (this.e == null) {
            return false;
        }
        try {
            return this.e.c(str);
        } catch (Throwable th) {
            w.a(th, "lg", "dl-" + str);
            return false;
        }
    }

    private static int d(String str) {
        y yVar = new y(t.c(t.a(str)));
        int i = 1;
        try {
            bi.a();
            byte[] a2 = bi.a(yVar);
            if (a2 == null) {
                return 0;
            }
            try {
                JSONObject jSONObject = new JSONObject(t.a(a2));
                if (jSONObject.has("code")) {
                    return jSONObject.getInt("code");
                }
                return 0;
            } catch (JSONException e2) {
                w.a((Throwable) e2, "lg", "pru");
                return 1;
            }
        } catch (j e3) {
            if (e3.e() == 27) {
                i = 0;
            }
            w.a((Throwable) e3, "lg", "pru");
            return i;
        }
    }

    private static List<s> d(Context context) {
        List<s> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                try {
                    List<s> a2 = new ap(context, false).a();
                    try {
                        return a2;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        list = a2;
                        th = th2;
                        throw th;
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

    private static String e(Context context) {
        try {
            return String.format(t.c(new String(u.a(9))), new Object[]{k.f(context), n.r(context), k.c(context), Build.MODEL, k.b(context), k.d(context), Build.VERSION.RELEASE});
        } catch (Throwable th) {
            w.a(th, "lg", "gpi");
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x0068 A[SYNTHETIC, Splitter:B:43:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0076 A[SYNTHETIC, Splitter:B:48:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0086 A[SYNTHETIC, Splitter:B:56:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0094 A[SYNTHETIC, Splitter:B:61:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String e(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            com.loc.be r1 = r6.e     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            if (r1 != 0) goto L_0x0006
            return r0
        L_0x0006:
            com.loc.be r1 = r6.e     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            com.loc.be$b r7 = r1.a((java.lang.String) r7)     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            if (r7 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.InputStream r7 = r7.a()     // Catch:{ Throwable -> 0x005c, all -> 0x0057 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Throwable -> 0x0054, all -> 0x004f }
            r1.<init>()     // Catch:{ Throwable -> 0x0054, all -> 0x004f }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x004d }
        L_0x001c:
            int r3 = r7.read(r2)     // Catch:{ Throwable -> 0x004d }
            r4 = -1
            if (r3 == r4) goto L_0x0028
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ Throwable -> 0x004d }
            goto L_0x001c
        L_0x0028:
            byte[] r2 = r1.toByteArray()     // Catch:{ Throwable -> 0x004d }
            java.lang.String r2 = com.loc.t.a((byte[]) r2)     // Catch:{ Throwable -> 0x004d }
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x003e
        L_0x0036:
            r0 = move-exception
            java.lang.String r1 = "lg"
            java.lang.String r3 = "rlg1"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x003e:
            if (r7 == 0) goto L_0x004c
            r7.close()     // Catch:{ IOException -> 0x0044 }
            return r2
        L_0x0044:
            r7 = move-exception
            java.lang.String r0 = "lg"
            java.lang.String r1 = "rlg2"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r0, (java.lang.String) r1)
        L_0x004c:
            return r2
        L_0x004d:
            r2 = move-exception
            goto L_0x005f
        L_0x004f:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x0084
        L_0x0054:
            r2 = move-exception
            r1 = r0
            goto L_0x005f
        L_0x0057:
            r7 = move-exception
            r1 = r0
            r0 = r7
            r7 = r1
            goto L_0x0084
        L_0x005c:
            r2 = move-exception
            r7 = r0
            r1 = r7
        L_0x005f:
            java.lang.String r3 = "lg"
            java.lang.String r4 = "rlg"
            com.loc.w.a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0074
            r1.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x0074
        L_0x006c:
            r1 = move-exception
            java.lang.String r2 = "lg"
            java.lang.String r3 = "rlg1"
            com.loc.w.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0074:
            if (r7 == 0) goto L_0x0082
            r7.close()     // Catch:{ IOException -> 0x007a }
            return r0
        L_0x007a:
            r7 = move-exception
            java.lang.String r1 = "lg"
            java.lang.String r2 = "rlg2"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0082:
            return r0
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0092
            r1.close()     // Catch:{ IOException -> 0x008a }
            goto L_0x0092
        L_0x008a:
            r1 = move-exception
            java.lang.String r2 = "lg"
            java.lang.String r3 = "rlg1"
            com.loc.w.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x0092:
            if (r7 == 0) goto L_0x00a0
            r7.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x00a0
        L_0x0098:
            r7 = move-exception
            java.lang.String r1 = "lg"
            java.lang.String r2 = "rlg2"
            com.loc.w.a((java.lang.Throwable) r7, (java.lang.String) r1, (java.lang.String) r2)
        L_0x00a0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ad.e(java.lang.String):java.lang.String");
    }

    private static String f(Context context) {
        try {
            String e2 = e(context);
            if ("".equals(e2)) {
                return null;
            }
            return m.b(t.a(e2));
        } catch (Throwable th) {
            w.a(th, "lg", "gpi");
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        return p.c(str);
    }

    /* access modifiers changed from: protected */
    public abstract String a(List<s> list);

    /* access modifiers changed from: package-private */
    public final void a(Context context, Throwable th, String str, String str2) {
        List<s> d2 = d(context);
        if (d2 != null && d2.size() != 0) {
            String a2 = a(th);
            if (a2 != null && !"".equals(a2)) {
                for (s next : d2) {
                    if (b(next.f(), a2)) {
                        a(next, context, th, a2.replaceAll("\n", "<br/>"), str, str2);
                        return;
                    }
                }
                if (a2.contains("com.amap.api.col")) {
                    try {
                        a(t.a(), context, th, a2, str, str2);
                    } catch (j e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(s sVar) {
        this.b = sVar;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void a(s sVar, Context context, String str, String str2, String str3, String str4) {
        s sVar2 = sVar;
        Context context2 = context;
        String str5 = str;
        String str6 = str2;
        String str7 = str3;
        String str8 = str4;
        this.b = sVar2;
        String a2 = bt.a();
        String a3 = bt.a(context2, sVar2);
        k.a(context2);
        if (str5 != null && !"".equals(str5)) {
            int i = this.c;
            StringBuilder sb = new StringBuilder();
            if (str7 != null) {
                sb.append("class:");
                sb.append(str7);
            }
            if (str8 != null) {
                sb.append(" method:");
                sb.append(str8);
                sb.append("$<br/>");
            }
            sb.append(str6);
            String a4 = a(str6);
            String a5 = bt.a(a3, a2, i, str5, sb.toString());
            if (a5 != null && !"".equals(a5)) {
                String b2 = b(a5);
                String c2 = x.c(this.c);
                synchronized (Looper.getMainLooper()) {
                    try {
                        an anVar = new an(context2);
                        a(context2, a4, c2, b2, anVar);
                        a(anVar, sVar2.a(), a4, i);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar, Context context, Throwable th, String str, String str2, String str3) {
        a(sVar, context, th.toString(), str, str2, str3);
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(Context context);

    /* access modifiers changed from: protected */
    public final int b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final void b(Context context) {
        List<s> d2 = d(context);
        if (d2 != null && d2.size() != 0) {
            String a2 = a(d2);
            if (a2 != null && !"".equals(a2)) {
                String a3 = bt.a();
                String a4 = bt.a(context, this.b);
                k.a(context);
                int i = this.c;
                String a5 = bt.a(a4, a3, i, "ANR", a2);
                if (a5 != null && !"".equals(a5)) {
                    String a6 = a(a2);
                    String b2 = b(a5);
                    String c2 = x.c(this.c);
                    synchronized (Looper.getMainLooper()) {
                        an anVar = new an(context);
                        a(context, a6, c2, b2, anVar);
                        a(anVar, this.b.a(), a6, i);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        try {
            if (this.e != null && !this.e.c()) {
                this.e.close();
            }
        } catch (Throwable th) {
            w.a(th, "lg", "cdru");
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00db, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00dd, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.content.Context r11) {
        /*
            r10 = this;
            boolean r0 = r10.a((android.content.Context) r11)     // Catch:{ Throwable -> 0x00e0 }
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            android.os.Looper r0 = android.os.Looper.getMainLooper()     // Catch:{ Throwable -> 0x00e0 }
            monitor-enter(r0)     // Catch:{ Throwable -> 0x00e0 }
            int r1 = r10.c     // Catch:{ Throwable -> 0x001c }
            java.lang.String r1 = com.loc.x.c(r1)     // Catch:{ Throwable -> 0x001c }
            com.loc.be r1 = a((android.content.Context) r11, (java.lang.String) r1)     // Catch:{ Throwable -> 0x001c }
            r10.e = r1     // Catch:{ Throwable -> 0x001c }
            goto L_0x0024
        L_0x0019:
            r11 = move-exception
            goto L_0x00de
        L_0x001c:
            r1 = move-exception
            java.lang.String r2 = "LogProcessor"
            java.lang.String r3 = "LogUpDateProcessor"
            com.loc.w.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0019 }
        L_0x0024:
            com.loc.an r1 = new com.loc.an     // Catch:{ all -> 0x0019 }
            r1.<init>(r11)     // Catch:{ all -> 0x0019 }
            int r2 = r10.c     // Catch:{ all -> 0x0019 }
            r3 = 2
            java.lang.Class r2 = com.loc.x.a((int) r2)     // Catch:{ Throwable -> 0x0038 }
            java.util.List r2 = r1.a((int) r3, (java.lang.Class<? extends com.loc.ao>) r2)     // Catch:{ Throwable -> 0x0038 }
            r10.a((java.util.List<? extends com.loc.ao>) r2, (com.loc.an) r1)     // Catch:{ Throwable -> 0x0038 }
            goto L_0x0040
        L_0x0038:
            r2 = move-exception
            java.lang.String r3 = "lg"
            java.lang.String r4 = "pdf"
            com.loc.w.a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0019 }
        L_0x0040:
            int r2 = r10.c     // Catch:{ all -> 0x0019 }
            java.lang.Class r2 = com.loc.x.a((int) r2)     // Catch:{ all -> 0x0019 }
            r3 = 0
            java.util.List r2 = r1.a((int) r3, (java.lang.Class<? extends com.loc.ao>) r2)     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x00dc
            int r4 = r2.size()     // Catch:{ all -> 0x0019 }
            if (r4 != 0) goto L_0x0055
            goto L_0x00dc
        L_0x0055:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            r4.<init>()     // Catch:{ all -> 0x0019 }
            java.lang.String r5 = "{\"pinfo\":\""
            r4.append(r5)     // Catch:{ all -> 0x0019 }
            java.lang.String r11 = f(r11)     // Catch:{ all -> 0x0019 }
            r4.append(r11)     // Catch:{ all -> 0x0019 }
            java.lang.String r11 = "\",\"els\":["
            r4.append(r11)     // Catch:{ all -> 0x0019 }
            java.util.Iterator r11 = r2.iterator()     // Catch:{ all -> 0x0019 }
            r5 = 1
            r6 = r5
        L_0x0071:
            boolean r7 = r11.hasNext()     // Catch:{ all -> 0x0019 }
            if (r7 == 0) goto L_0x00be
            java.lang.Object r7 = r11.next()     // Catch:{ all -> 0x0019 }
            com.loc.ao r7 = (com.loc.ao) r7     // Catch:{ all -> 0x0019 }
            java.lang.String r8 = r7.b()     // Catch:{ all -> 0x0019 }
            java.lang.String r8 = r10.e((java.lang.String) r8)     // Catch:{ all -> 0x0019 }
            if (r8 == 0) goto L_0x0071
            java.lang.String r9 = ""
            boolean r9 = r9.equals(r8)     // Catch:{ all -> 0x0019 }
            if (r9 != 0) goto L_0x0071
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            r9.<init>()     // Catch:{ all -> 0x0019 }
            r9.append(r8)     // Catch:{ all -> 0x0019 }
            java.lang.String r8 = "||"
            r9.append(r8)     // Catch:{ all -> 0x0019 }
            int r7 = r7.c()     // Catch:{ all -> 0x0019 }
            r9.append(r7)     // Catch:{ all -> 0x0019 }
            java.lang.String r7 = r9.toString()     // Catch:{ all -> 0x0019 }
            if (r6 == 0) goto L_0x00ab
            r6 = r3
            goto L_0x00b0
        L_0x00ab:
            java.lang.String r8 = ","
            r4.append(r8)     // Catch:{ all -> 0x0019 }
        L_0x00b0:
            java.lang.String r8 = "{\"log\":\""
            r4.append(r8)     // Catch:{ all -> 0x0019 }
            r4.append(r7)     // Catch:{ all -> 0x0019 }
            java.lang.String r7 = "\"}"
            r4.append(r7)     // Catch:{ all -> 0x0019 }
            goto L_0x0071
        L_0x00be:
            if (r6 == 0) goto L_0x00c2
            r11 = 0
            goto L_0x00cb
        L_0x00c2:
            java.lang.String r11 = "]}"
            r4.append(r11)     // Catch:{ all -> 0x0019 }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x0019 }
        L_0x00cb:
            if (r11 != 0) goto L_0x00cf
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x00cf:
            int r11 = d((java.lang.String) r11)     // Catch:{ all -> 0x0019 }
            if (r11 != r5) goto L_0x00da
            int r11 = r10.c     // Catch:{ all -> 0x0019 }
            r10.a((java.util.List<? extends com.loc.ao>) r2, (com.loc.an) r1)     // Catch:{ all -> 0x0019 }
        L_0x00da:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x00dc:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return
        L_0x00de:
            monitor-exit(r0)     // Catch:{ Throwable -> 0x00e0 }
            throw r11     // Catch:{ Throwable -> 0x00e0 }
        L_0x00e0:
            r11 = move-exception
            java.lang.String r0 = "lg"
            java.lang.String r1 = "pul"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r0, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ad.c(android.content.Context):void");
    }
}
