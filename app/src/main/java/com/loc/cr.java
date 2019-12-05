package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.loc.l;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AuthUtil */
public final class cr {
    private static int A = 1000;
    private static int B = 200;
    private static boolean C = false;
    private static boolean D = true;
    private static boolean E = true;
    private static int F = -1;
    private static long G = 0;
    private static ArrayList<String> H = new ArrayList<>();
    private static boolean I = false;
    private static int J = -1;
    private static long K = 0;
    private static ArrayList<String> L = new ArrayList<>();
    private static String M = null;
    private static String N = null;
    private static boolean O = false;
    private static boolean P = false;
    private static int Q = 3000;
    private static int R = 3000;
    private static boolean S = true;
    private static long T = 300000;
    private static boolean U = false;
    private static boolean V = false;
    private static boolean W = false;
    private static List<cu> X = new ArrayList();
    private static boolean Y = false;
    private static long Z = 0;
    static boolean a = false;
    private static int aa = 0;
    private static int ab = 0;
    private static List<String> ac = new ArrayList();
    private static boolean ad = true;
    private static int ae = 80;
    private static boolean af = false;
    static boolean b = false;
    static int c = 3600000;
    static long d = 0;
    static long e = 0;
    static boolean f = false;
    static boolean g = true;
    private static String h = "提示信息";
    private static String i = "确认";
    private static String j = "取消";
    private static String k = "";
    private static String l = "";
    private static String m = "";
    private static boolean n = false;
    private static long o = 0;
    private static long p = 0;
    private static long q = 5000;
    private static boolean r = false;
    private static int s = 0;
    private static boolean t = false;
    private static int u = 0;
    private static boolean v = false;
    private static int w = 3600000;
    private static int x = 0;
    private static int y = 0;
    private static boolean z = true;

    /* compiled from: AuthUtil */
    static class a {
        boolean a = false;
        String b = "0";
        boolean c = false;
        int d = 5;

        a() {
        }
    }

    public static int A() {
        return ae;
    }

    public static boolean B() {
        return af;
    }

    public static boolean C() {
        if (!f) {
            return f;
        }
        f = false;
        return true;
    }

    public static boolean D() {
        return g;
    }

    private static a a(JSONObject jSONObject, String str) {
        a aVar;
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                if (jSONObject2 != null) {
                    aVar = new a();
                    try {
                        aVar.a = l.a(jSONObject2.optString("b"), false);
                        aVar.b = jSONObject2.optString("t");
                        aVar.c = l.a(jSONObject2.optString("st"), false);
                        aVar.d = jSONObject2.optInt("i", 0);
                        return aVar;
                    } catch (Throwable th) {
                        th = th;
                        cs.a(th, "AuthUtil", "getLocateObj");
                        return aVar;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
                cs.a(th, "AuthUtil", "getLocateObj");
                return aVar;
            }
        }
        return null;
    }

    public static boolean a() {
        return r;
    }

    public static boolean a(long j2) {
        long b2 = da.b();
        return n && b2 - p <= o && b2 - j2 >= q;
    }

    public static boolean a(Context context) {
        D = true;
        boolean z2 = false;
        try {
            l.a a2 = l.a(context, cs.b(), cs.b(context));
            if (a2 != null) {
                z2 = a(context, a2);
            }
        } catch (Throwable th) {
            cs.a(th, "AuthUtil", "getConfig");
        }
        e = da.b();
        d = da.b();
        return z2;
    }

    public static boolean a(Context context, long j2) {
        if (!P) {
            return false;
        }
        long a2 = da.a();
        if (a2 - j2 < ((long) Q)) {
            return false;
        }
        if (R == -1) {
            return true;
        }
        if (!da.c(a2, cz.b(context, "pref", "ngpsTime", 0))) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                edit.putLong("ngpsTime", a2);
                edit.putInt("ngpsCount", 0);
                cz.a(edit);
            } catch (Throwable th) {
                cs.a(th, "AuthUtil", "resetPrefsNGPS");
            }
            cz.a(context, "pref", "ngpsCount", 1);
            return true;
        }
        int b2 = cz.b(context, "pref", "ngpsCount", 0);
        if (b2 >= R) {
            return false;
        }
        cz.a(context, "pref", "ngpsCount", b2 + 1);
        return true;
    }

    private static boolean a(Context context, l.a.b bVar, String str, String str2) {
        if (bVar != null) {
            try {
                boolean z2 = bVar.a;
                String str3 = bVar.b;
                String str4 = bVar.c;
                String str5 = bVar.d;
                boolean z3 = bVar.e;
                s a2 = cs.a(str, str2);
                if (z2) {
                    if (z3 && !TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str5)) {
                        au.a(context, new at(str3, str4), a2);
                    }
                } else if (cx.a(context, a2)) {
                    cy.a(context, str, "config|get dex able is false");
                }
                return z2 && z3;
            } catch (Throwable th) {
                cs.a(th, "AuthUtil", "downLoadPluginDex");
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x020e A[Catch:{ Throwable -> 0x0270 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0291 A[Catch:{ Throwable -> 0x029e, Throwable -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02ae A[Catch:{ Throwable -> 0x029e, Throwable -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02d5 A[Catch:{ Throwable -> 0x029e, Throwable -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0309 A[Catch:{ Throwable -> 0x0334 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0340 A[Catch:{ Throwable -> 0x0370 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x037c A[Catch:{ Throwable -> 0x0392 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x039e A[Catch:{ Throwable -> 0x03a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x03b5 A[Catch:{ Throwable -> 0x03c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x03cc A[Catch:{ Throwable -> 0x04bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x04c7 A[Catch:{ Throwable -> 0x04e2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04ee  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01db A[Catch:{ Throwable -> 0x0202 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(android.content.Context r14, com.loc.l.a r15) {
        /*
            r0 = -1
            r1 = 0
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = r15.h     // Catch:{ Throwable -> 0x0083 }
            if (r5 == 0) goto L_0x008b
            java.lang.String r6 = "callamapflag"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ Throwable -> 0x0083 }
            boolean r7 = E     // Catch:{ Throwable -> 0x0083 }
            boolean r6 = com.loc.l.a((java.lang.String) r6, (boolean) r7)     // Catch:{ Throwable -> 0x0083 }
            E = r6     // Catch:{ Throwable -> 0x0083 }
            java.lang.String r6 = "co"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ Throwable -> 0x0083 }
            boolean r6 = com.loc.l.a((java.lang.String) r6, (boolean) r4)     // Catch:{ Throwable -> 0x0083 }
            if (r6 == 0) goto L_0x0029
            boolean r6 = E     // Catch:{ Throwable -> 0x0083 }
            if (r6 == 0) goto L_0x0029
            r6 = r3
            goto L_0x002a
        L_0x0029:
            r6 = r4
        L_0x002a:
            a = r6     // Catch:{ Throwable -> 0x0083 }
            boolean r6 = E     // Catch:{ Throwable -> 0x0083 }
            if (r6 == 0) goto L_0x008b
            java.lang.String r6 = "count"
            int r7 = F     // Catch:{ Throwable -> 0x0083 }
            int r6 = r5.optInt(r6, r7)     // Catch:{ Throwable -> 0x0083 }
            F = r6     // Catch:{ Throwable -> 0x0083 }
            java.lang.String r6 = "sysTime"
            long r7 = G     // Catch:{ Throwable -> 0x0083 }
            long r6 = r5.optLong(r6, r7)     // Catch:{ Throwable -> 0x0083 }
            G = r6     // Catch:{ Throwable -> 0x0083 }
            java.lang.String r6 = "sn"
            org.json.JSONArray r5 = r5.optJSONArray(r6)     // Catch:{ Throwable -> 0x0083 }
            if (r5 == 0) goto L_0x0065
            int r6 = r5.length()     // Catch:{ Throwable -> 0x0083 }
            if (r6 <= 0) goto L_0x0065
            r6 = r4
        L_0x0053:
            int r7 = r5.length()     // Catch:{ Throwable -> 0x0083 }
            if (r6 >= r7) goto L_0x0065
            java.util.ArrayList<java.lang.String> r7 = H     // Catch:{ Throwable -> 0x0083 }
            java.lang.String r8 = r5.getString(r6)     // Catch:{ Throwable -> 0x0083 }
            r7.add(r8)     // Catch:{ Throwable -> 0x0083 }
            int r6 = r6 + 1
            goto L_0x0053
        L_0x0065:
            int r5 = F     // Catch:{ Throwable -> 0x0083 }
            if (r5 == r0) goto L_0x008b
            long r5 = G     // Catch:{ Throwable -> 0x0083 }
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x008b
            java.lang.String r5 = "pref"
            java.lang.String r6 = "nowtime"
            long r5 = com.loc.cz.b((android.content.Context) r14, (java.lang.String) r5, (java.lang.String) r6, (long) r1)     // Catch:{ Throwable -> 0x0083 }
            long r7 = G     // Catch:{ Throwable -> 0x0083 }
            boolean r5 = com.loc.da.b((long) r7, (long) r5)     // Catch:{ Throwable -> 0x0083 }
            if (r5 != 0) goto L_0x008b
            i(r14)     // Catch:{ Throwable -> 0x0083 }
            goto L_0x008b
        L_0x0083:
            r5 = move-exception
            java.lang.String r6 = "AuthUtil"
            java.lang.String r7 = "loadConfigData_callAMapSer"
            com.loc.cs.a(r5, r6, r7)     // Catch:{ Throwable -> 0x0569 }
        L_0x008b:
            org.json.JSONObject r5 = r15.k     // Catch:{ Throwable -> 0x00f2 }
            if (r5 == 0) goto L_0x00fa
            java.lang.String r6 = "amappushflag"
            java.lang.String r6 = r5.optString(r6)     // Catch:{ Throwable -> 0x00f2 }
            boolean r7 = I     // Catch:{ Throwable -> 0x00f2 }
            boolean r6 = com.loc.l.a((java.lang.String) r6, (boolean) r7)     // Catch:{ Throwable -> 0x00f2 }
            I = r6     // Catch:{ Throwable -> 0x00f2 }
            if (r6 == 0) goto L_0x00fa
            java.lang.String r6 = "count"
            int r7 = J     // Catch:{ Throwable -> 0x00f2 }
            int r6 = r5.optInt(r6, r7)     // Catch:{ Throwable -> 0x00f2 }
            J = r6     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r6 = "sysTime"
            long r7 = K     // Catch:{ Throwable -> 0x00f2 }
            long r6 = r5.optLong(r6, r7)     // Catch:{ Throwable -> 0x00f2 }
            K = r6     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r6 = "sn"
            org.json.JSONArray r5 = r5.optJSONArray(r6)     // Catch:{ Throwable -> 0x00f2 }
            if (r5 == 0) goto L_0x00d4
            int r6 = r5.length()     // Catch:{ Throwable -> 0x00f2 }
            if (r6 <= 0) goto L_0x00d4
            r6 = r4
        L_0x00c2:
            int r7 = r5.length()     // Catch:{ Throwable -> 0x00f2 }
            if (r6 >= r7) goto L_0x00d4
            java.util.ArrayList<java.lang.String> r7 = L     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r8 = r5.getString(r6)     // Catch:{ Throwable -> 0x00f2 }
            r7.add(r8)     // Catch:{ Throwable -> 0x00f2 }
            int r6 = r6 + 1
            goto L_0x00c2
        L_0x00d4:
            int r5 = J     // Catch:{ Throwable -> 0x00f2 }
            if (r5 == r0) goto L_0x00fa
            long r5 = K     // Catch:{ Throwable -> 0x00f2 }
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x00fa
            java.lang.String r5 = "pref"
            java.lang.String r6 = "pushSerTime"
            long r1 = com.loc.cz.b((android.content.Context) r14, (java.lang.String) r5, (java.lang.String) r6, (long) r1)     // Catch:{ Throwable -> 0x00f2 }
            long r5 = K     // Catch:{ Throwable -> 0x00f2 }
            boolean r1 = com.loc.da.b((long) r5, (long) r1)     // Catch:{ Throwable -> 0x00f2 }
            if (r1 != 0) goto L_0x00fa
            j(r14)     // Catch:{ Throwable -> 0x00f2 }
            goto L_0x00fa
        L_0x00f2:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_callAMapPush"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x00fa:
            org.json.JSONObject r1 = r15.l     // Catch:{ Throwable -> 0x0198 }
            if (r1 == 0) goto L_0x01a0
            java.lang.String r2 = "f"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x0198 }
            boolean r5 = O     // Catch:{ Throwable -> 0x0198 }
            boolean r2 = com.loc.l.a((java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x0198 }
            O = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "mco"
            int r2 = r1.optInt(r2, r4)     // Catch:{ Throwable -> 0x0198 }
            x = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "co"
            int r2 = r1.optInt(r2, r4)     // Catch:{ Throwable -> 0x0198 }
            y = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "it"
            r5 = 3600(0xe10, float:5.045E-42)
            int r2 = r1.optInt(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            int r2 = r2 * 1000
            w = r2     // Catch:{ Throwable -> 0x0198 }
            r5 = 3600000(0x36ee80, float:5.044674E-39)
            if (r2 >= r5) goto L_0x012f
            w = r5     // Catch:{ Throwable -> 0x0198 }
        L_0x012f:
            java.lang.String r2 = "a"
            java.lang.String r5 = "提示信息"
            java.lang.String r2 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            h = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "o"
            java.lang.String r5 = "确认"
            java.lang.String r2 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            i = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "c"
            java.lang.String r5 = "取消"
            java.lang.String r2 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            j = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "i"
            java.lang.String r5 = ""
            java.lang.String r2 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            k = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "u"
            java.lang.String r5 = ""
            java.lang.String r2 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            l = r2     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r2 = "t"
            java.lang.String r5 = ""
            java.lang.String r1 = r1.optString(r2, r5)     // Catch:{ Throwable -> 0x0198 }
            m = r1     // Catch:{ Throwable -> 0x0198 }
            java.lang.String r1 = k     // Catch:{ Throwable -> 0x0198 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0198 }
            if (r1 != 0) goto L_0x017d
            java.lang.String r1 = "null"
            java.lang.String r2 = k     // Catch:{ Throwable -> 0x0198 }
            boolean r1 = r1.equals(r2)     // Catch:{ Throwable -> 0x0198 }
            if (r1 == 0) goto L_0x018f
        L_0x017d:
            java.lang.String r1 = l     // Catch:{ Throwable -> 0x0198 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0198 }
            if (r1 != 0) goto L_0x0195
            java.lang.String r1 = "null"
            java.lang.String r2 = l     // Catch:{ Throwable -> 0x0198 }
            boolean r1 = r1.equals(r2)     // Catch:{ Throwable -> 0x0198 }
            if (r1 != 0) goto L_0x0195
        L_0x018f:
            int r1 = y     // Catch:{ Throwable -> 0x0198 }
            int r2 = x     // Catch:{ Throwable -> 0x0198 }
            if (r1 <= r2) goto L_0x01a0
        L_0x0195:
            O = r4     // Catch:{ Throwable -> 0x0198 }
            goto L_0x01a0
        L_0x0198:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_openAMap"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x01a0:
            com.loc.s r1 = com.loc.cs.b()     // Catch:{ Throwable -> 0x01cf }
            com.loc.l$a$d r2 = r15.x     // Catch:{ Throwable -> 0x01cf }
            r5 = 0
            if (r2 == 0) goto L_0x01cb
            java.lang.String r6 = r2.b     // Catch:{ Throwable -> 0x01cf }
            java.lang.String r7 = r2.a     // Catch:{ Throwable -> 0x01cf }
            java.lang.String r2 = r2.c     // Catch:{ Throwable -> 0x01cf }
            boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x01cf }
            if (r8 != 0) goto L_0x01cb
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x01cf }
            if (r8 != 0) goto L_0x01cb
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x01cf }
            if (r2 == 0) goto L_0x01c2
            goto L_0x01cb
        L_0x01c2:
            com.loc.at r2 = new com.loc.at     // Catch:{ Throwable -> 0x01cf }
            r2.<init>(r7, r6)     // Catch:{ Throwable -> 0x01cf }
            com.loc.au.a((android.content.Context) r14, (com.loc.at) r2, (com.loc.s) r1)     // Catch:{ Throwable -> 0x01cf }
            goto L_0x01d7
        L_0x01cb:
            com.loc.au.a((android.content.Context) r14, (com.loc.at) r5, (com.loc.s) r1)     // Catch:{ Throwable -> 0x01cf }
            goto L_0x01d7
        L_0x01cf:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_sdkUpdate"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x01d7:
            com.loc.l$a$c r1 = r15.y     // Catch:{ Throwable -> 0x0202 }
            if (r1 == 0) goto L_0x020a
            java.lang.String r2 = r1.a     // Catch:{ Throwable -> 0x0202 }
            M = r2     // Catch:{ Throwable -> 0x0202 }
            java.lang.String r1 = r1.b     // Catch:{ Throwable -> 0x0202 }
            N = r1     // Catch:{ Throwable -> 0x0202 }
            java.lang.String r1 = M     // Catch:{ Throwable -> 0x0202 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0202 }
            if (r1 != 0) goto L_0x020a
            java.lang.String r1 = N     // Catch:{ Throwable -> 0x0202 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0202 }
            if (r1 != 0) goto L_0x020a
            com.loc.r r1 = new com.loc.r     // Catch:{ Throwable -> 0x0202 }
            java.lang.String r2 = "loc"
            java.lang.String r5 = M     // Catch:{ Throwable -> 0x0202 }
            java.lang.String r6 = N     // Catch:{ Throwable -> 0x0202 }
            r1.<init>(r14, r2, r5, r6)     // Catch:{ Throwable -> 0x0202 }
            r1.a()     // Catch:{ Throwable -> 0x0202 }
            goto L_0x020a
        L_0x0202:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_groupOffset"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x020a:
            com.loc.l$a$a r1 = r15.w     // Catch:{ Throwable -> 0x0270 }
            if (r1 == 0) goto L_0x0278
            boolean r2 = r1.a     // Catch:{ Throwable -> 0x0270 }
            z = r2     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r2 = "pref"
            java.lang.String r5 = "exception"
            boolean r6 = z     // Catch:{ Throwable -> 0x0270 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r2, (java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x0270 }
            org.json.JSONObject r1 = r1.c     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r2 = "fn"
            int r5 = A     // Catch:{ Throwable -> 0x0270 }
            int r2 = r1.optInt(r2, r5)     // Catch:{ Throwable -> 0x0270 }
            A = r2     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r2 = "mpn"
            int r5 = B     // Catch:{ Throwable -> 0x0270 }
            int r2 = r1.optInt(r2, r5)     // Catch:{ Throwable -> 0x0270 }
            B = r2     // Catch:{ Throwable -> 0x0270 }
            r5 = 500(0x1f4, float:7.0E-43)
            if (r2 <= r5) goto L_0x0237
            B = r5     // Catch:{ Throwable -> 0x0270 }
        L_0x0237:
            int r2 = B     // Catch:{ Throwable -> 0x0270 }
            r5 = 30
            if (r2 >= r5) goto L_0x023f
            B = r5     // Catch:{ Throwable -> 0x0270 }
        L_0x023f:
            java.lang.String r2 = "igu"
            java.lang.String r1 = r1.optString(r2)     // Catch:{ Throwable -> 0x0270 }
            boolean r2 = C     // Catch:{ Throwable -> 0x0270 }
            boolean r1 = com.loc.l.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Throwable -> 0x0270 }
            C = r1     // Catch:{ Throwable -> 0x0270 }
            int r1 = A     // Catch:{ Throwable -> 0x0270 }
            boolean r2 = C     // Catch:{ Throwable -> 0x0270 }
            com.loc.bq.a((int) r1, (boolean) r2)     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "fn"
            int r5 = A     // Catch:{ Throwable -> 0x0270 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (int) r5)     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "mpn"
            int r5 = B     // Catch:{ Throwable -> 0x0270 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (int) r5)     // Catch:{ Throwable -> 0x0270 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "igu"
            boolean r5 = C     // Catch:{ Throwable -> 0x0270 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x0270 }
            goto L_0x0278
        L_0x0270:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_uploadException"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x0278:
            r1 = 2
            org.json.JSONObject r2 = r15.m     // Catch:{ Throwable -> 0x02fd }
            if (r2 == 0) goto L_0x0305
            java.lang.String r5 = "able"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ Throwable -> 0x02fd }
            boolean r5 = com.loc.l.a((java.lang.String) r5, (boolean) r4)     // Catch:{ Throwable -> 0x02fd }
            if (r5 == 0) goto L_0x0305
            java.lang.String r5 = "fs"
            com.loc.cr$a r5 = a((org.json.JSONObject) r2, (java.lang.String) r5)     // Catch:{ Throwable -> 0x02fd }
            if (r5 == 0) goto L_0x02a6
            boolean r6 = r5.c     // Catch:{ Throwable -> 0x02fd }
            r = r6     // Catch:{ Throwable -> 0x02fd }
            java.lang.String r5 = r5.b     // Catch:{ Throwable -> 0x029e }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Throwable -> 0x029e }
            s = r5     // Catch:{ Throwable -> 0x029e }
            goto L_0x02a6
        L_0x029e:
            r5 = move-exception
            java.lang.String r6 = "AuthUtil"
            java.lang.String r7 = "loadconfig part2"
            com.loc.cs.a(r5, r6, r7)     // Catch:{ Throwable -> 0x02fd }
        L_0x02a6:
            java.lang.String r5 = "us"
            com.loc.cr$a r5 = a((org.json.JSONObject) r2, (java.lang.String) r5)     // Catch:{ Throwable -> 0x02fd }
            if (r5 == 0) goto L_0x02cd
            boolean r6 = r5.c     // Catch:{ Throwable -> 0x02fd }
            t = r6     // Catch:{ Throwable -> 0x02fd }
            boolean r6 = r5.a     // Catch:{ Throwable -> 0x02fd }
            v = r6     // Catch:{ Throwable -> 0x02fd }
            java.lang.String r5 = r5.b     // Catch:{ Throwable -> 0x02bf }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Throwable -> 0x02bf }
            u = r5     // Catch:{ Throwable -> 0x02bf }
            goto L_0x02c7
        L_0x02bf:
            r5 = move-exception
            java.lang.String r6 = "AuthUtil"
            java.lang.String r7 = "loadconfig part1"
            com.loc.cs.a(r5, r6, r7)     // Catch:{ Throwable -> 0x02fd }
        L_0x02c7:
            int r5 = u     // Catch:{ Throwable -> 0x02fd }
            if (r5 >= r1) goto L_0x02cd
            t = r4     // Catch:{ Throwable -> 0x02fd }
        L_0x02cd:
            java.lang.String r5 = "rs"
            com.loc.cr$a r2 = a((org.json.JSONObject) r2, (java.lang.String) r5)     // Catch:{ Throwable -> 0x02fd }
            if (r2 == 0) goto L_0x0305
            boolean r5 = r2.c     // Catch:{ Throwable -> 0x02fd }
            n = r5     // Catch:{ Throwable -> 0x02fd }
            if (r5 == 0) goto L_0x02e8
            long r5 = com.loc.da.b()     // Catch:{ Throwable -> 0x02fd }
            p = r5     // Catch:{ Throwable -> 0x02fd }
            int r5 = r2.d     // Catch:{ Throwable -> 0x02fd }
            int r5 = r5 * 1000
            long r5 = (long) r5     // Catch:{ Throwable -> 0x02fd }
            q = r5     // Catch:{ Throwable -> 0x02fd }
        L_0x02e8:
            java.lang.String r2 = r2.b     // Catch:{ Throwable -> 0x02f4 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Throwable -> 0x02f4 }
            int r2 = r2 * 1000
            long r5 = (long) r2     // Catch:{ Throwable -> 0x02f4 }
            o = r5     // Catch:{ Throwable -> 0x02f4 }
            goto L_0x0305
        L_0x02f4:
            r2 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "loadconfig part"
            com.loc.cs.a(r2, r5, r6)     // Catch:{ Throwable -> 0x02fd }
            goto L_0x0305
        L_0x02fd:
            r2 = move-exception
            java.lang.String r5 = "AuthUtil"
            java.lang.String r6 = "loadConfigData_locate"
            com.loc.cs.a(r2, r5, r6)     // Catch:{ Throwable -> 0x0569 }
        L_0x0305:
            org.json.JSONObject r2 = r15.o     // Catch:{ Throwable -> 0x0334 }
            if (r2 == 0) goto L_0x033c
            java.lang.String r5 = "able"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ Throwable -> 0x0334 }
            boolean r6 = P     // Catch:{ Throwable -> 0x0334 }
            boolean r5 = com.loc.l.a((java.lang.String) r5, (boolean) r6)     // Catch:{ Throwable -> 0x0334 }
            P = r5     // Catch:{ Throwable -> 0x0334 }
            if (r5 == 0) goto L_0x033c
            java.lang.String r5 = "c"
            int r5 = r2.optInt(r5, r4)     // Catch:{ Throwable -> 0x0334 }
            if (r5 != 0) goto L_0x0326
            r5 = 3000(0xbb8, float:4.204E-42)
            Q = r5     // Catch:{ Throwable -> 0x0334 }
            goto L_0x032a
        L_0x0326:
            int r5 = r5 * 1000
            Q = r5     // Catch:{ Throwable -> 0x0334 }
        L_0x032a:
            java.lang.String r5 = "t"
            int r2 = r2.getInt(r5)     // Catch:{ Throwable -> 0x0334 }
            int r2 = r2 / r1
            R = r2     // Catch:{ Throwable -> 0x0334 }
            goto L_0x033c
        L_0x0334:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_ngps"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x033c:
            org.json.JSONObject r1 = r15.p     // Catch:{ Throwable -> 0x0370 }
            if (r1 == 0) goto L_0x0378
            java.lang.String r2 = "able"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x0370 }
            boolean r5 = S     // Catch:{ Throwable -> 0x0370 }
            boolean r2 = com.loc.l.a((java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x0370 }
            S = r2     // Catch:{ Throwable -> 0x0370 }
            if (r2 == 0) goto L_0x035d
            java.lang.String r2 = "c"
            r5 = 300(0x12c, float:4.2E-43)
            int r1 = r1.optInt(r2, r5)     // Catch:{ Throwable -> 0x0370 }
            int r1 = r1 * 1000
            long r1 = (long) r1     // Catch:{ Throwable -> 0x0370 }
            T = r1     // Catch:{ Throwable -> 0x0370 }
        L_0x035d:
            java.lang.String r1 = "pref"
            java.lang.String r2 = "ca"
            boolean r5 = S     // Catch:{ Throwable -> 0x0370 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x0370 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "ct"
            long r5 = T     // Catch:{ Throwable -> 0x0370 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (long) r5)     // Catch:{ Throwable -> 0x0370 }
            goto L_0x0378
        L_0x0370:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_cacheAble"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x0378:
            com.loc.l$a$b r1 = r15.A     // Catch:{ Throwable -> 0x0392 }
            if (r1 == 0) goto L_0x039a
            java.lang.String r2 = "OfflineLocation"
            java.lang.String r5 = "1.0.0"
            boolean r1 = a(r14, r1, r2, r5)     // Catch:{ Throwable -> 0x0392 }
            V = r1     // Catch:{ Throwable -> 0x0392 }
            com.loc.bw.a = r1     // Catch:{ Throwable -> 0x0392 }
            java.lang.String r1 = "pref"
            java.lang.String r2 = "oAble"
            boolean r5 = V     // Catch:{ Throwable -> 0x0392 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r1, (java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x0392 }
            goto L_0x039a
        L_0x0392:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_OfflineDex"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x039a:
            com.loc.l$a$b r1 = r15.z     // Catch:{ Throwable -> 0x03a9 }
            if (r1 == 0) goto L_0x03b1
            java.lang.String r2 = "Collection"
            java.lang.String r5 = "1.0.0"
            boolean r1 = a(r14, r1, r2, r5)     // Catch:{ Throwable -> 0x03a9 }
            U = r1     // Catch:{ Throwable -> 0x03a9 }
            goto L_0x03b1
        L_0x03a9:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_CollectorDex"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x03b1:
            com.loc.l$a$b r1 = r15.B     // Catch:{ Throwable -> 0x03c0 }
            if (r1 == 0) goto L_0x03c8
            java.lang.String r2 = "HttpDNS"
            java.lang.String r5 = "1.0.0"
            boolean r1 = a(r14, r1, r2, r5)     // Catch:{ Throwable -> 0x03c0 }
            W = r1     // Catch:{ Throwable -> 0x03c0 }
            goto L_0x03c8
        L_0x03c0:
            r1 = move-exception
            java.lang.String r2 = "AuthUtil"
            java.lang.String r5 = "loadConfigData_dnsDex"
            com.loc.cs.a(r1, r2, r5)     // Catch:{ Throwable -> 0x0569 }
        L_0x03c8:
            org.json.JSONObject r1 = r15.j     // Catch:{ Throwable -> 0x04bb }
            if (r1 == 0) goto L_0x04c3
            java.lang.String r2 = "able"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ Throwable -> 0x04bb }
            boolean r5 = Y     // Catch:{ Throwable -> 0x04bb }
            boolean r2 = com.loc.l.a((java.lang.String) r2, (boolean) r5)     // Catch:{ Throwable -> 0x04bb }
            Y = r2     // Catch:{ Throwable -> 0x04bb }
            java.lang.String r2 = "sysTime"
            long r5 = com.loc.da.a()     // Catch:{ Throwable -> 0x04bb }
            long r5 = r1.optLong(r2, r5)     // Catch:{ Throwable -> 0x04bb }
            Z = r5     // Catch:{ Throwable -> 0x04bb }
            java.lang.String r2 = "n"
            int r2 = r1.optInt(r2, r3)     // Catch:{ Throwable -> 0x04bb }
            aa = r2     // Catch:{ Throwable -> 0x04bb }
            java.lang.String r2 = "nh"
            int r2 = r1.optInt(r2, r3)     // Catch:{ Throwable -> 0x04bb }
            ab = r2     // Catch:{ Throwable -> 0x04bb }
            boolean r2 = Y     // Catch:{ Throwable -> 0x04bb }
            if (r2 == 0) goto L_0x04c3
            int r2 = aa     // Catch:{ Throwable -> 0x04bb }
            if (r2 == r0) goto L_0x0404
            int r0 = aa     // Catch:{ Throwable -> 0x04bb }
            int r2 = ab     // Catch:{ Throwable -> 0x04bb }
            if (r0 < r2) goto L_0x04c3
        L_0x0404:
            java.lang.String r0 = "l"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Throwable -> 0x04bb }
            r2 = r4
        L_0x040b:
            int r5 = r0.length()     // Catch:{ Throwable -> 0x04bb }
            if (r2 >= r5) goto L_0x0494
            org.json.JSONObject r5 = r0.optJSONObject(r2)     // Catch:{ Throwable -> 0x0490 }
            com.loc.cu r6 = new com.loc.cu     // Catch:{ Throwable -> 0x0490 }
            r6.<init>()     // Catch:{ Throwable -> 0x0490 }
            java.lang.String r7 = "able"
            java.lang.String r8 = "false"
            java.lang.String r7 = r5.optString(r7, r8)     // Catch:{ Throwable -> 0x0490 }
            boolean r7 = com.loc.l.a((java.lang.String) r7, (boolean) r4)     // Catch:{ Throwable -> 0x0490 }
            r6.a = r7     // Catch:{ Throwable -> 0x0490 }
            if (r7 != 0) goto L_0x042b
            goto L_0x0490
        L_0x042b:
            java.lang.String r7 = "pn"
            java.lang.String r8 = ""
            java.lang.String r7 = r5.optString(r7, r8)     // Catch:{ Throwable -> 0x0490 }
            r6.b = r7     // Catch:{ Throwable -> 0x0490 }
            java.lang.String r7 = "cn"
            java.lang.String r8 = ""
            java.lang.String r7 = r5.optString(r7, r8)     // Catch:{ Throwable -> 0x0490 }
            r6.c = r7     // Catch:{ Throwable -> 0x0490 }
            java.lang.String r7 = "a"
            java.lang.String r8 = ""
            java.lang.String r7 = r5.optString(r7, r8)     // Catch:{ Throwable -> 0x0490 }
            r6.e = r7     // Catch:{ Throwable -> 0x0490 }
            java.lang.String r7 = "b"
            org.json.JSONArray r7 = r5.optJSONArray(r7)     // Catch:{ Throwable -> 0x0490 }
            if (r7 == 0) goto L_0x047d
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ Throwable -> 0x0490 }
            r8.<init>()     // Catch:{ Throwable -> 0x0490 }
            r9 = r4
        L_0x0457:
            int r10 = r7.length()     // Catch:{ Throwable -> 0x0490 }
            if (r9 >= r10) goto L_0x047b
            org.json.JSONObject r10 = r7.optJSONObject(r9)     // Catch:{ Throwable -> 0x0490 }
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ Throwable -> 0x0490 }
            r11.<init>()     // Catch:{ Throwable -> 0x0490 }
            java.lang.String r12 = "k"
            java.lang.String r12 = r10.optString(r12)     // Catch:{ Throwable -> 0x0478 }
            java.lang.String r13 = "v"
            java.lang.String r10 = r10.optString(r13)     // Catch:{ Throwable -> 0x0478 }
            r11.put(r12, r10)     // Catch:{ Throwable -> 0x0478 }
            r8.add(r11)     // Catch:{ Throwable -> 0x0478 }
        L_0x0478:
            int r9 = r9 + 1
            goto L_0x0457
        L_0x047b:
            r6.d = r8     // Catch:{ Throwable -> 0x0490 }
        L_0x047d:
            java.lang.String r7 = "is"
            java.lang.String r8 = "false"
            java.lang.String r5 = r5.optString(r7, r8)     // Catch:{ Throwable -> 0x0490 }
            boolean r5 = com.loc.l.a((java.lang.String) r5, (boolean) r4)     // Catch:{ Throwable -> 0x0490 }
            r6.f = r5     // Catch:{ Throwable -> 0x0490 }
            java.util.List<com.loc.cu> r5 = X     // Catch:{ Throwable -> 0x0490 }
            r5.add(r6)     // Catch:{ Throwable -> 0x0490 }
        L_0x0490:
            int r2 = r2 + 1
            goto L_0x040b
        L_0x0494:
            java.lang.String r0 = "sl"
            org.json.JSONArray r0 = r1.optJSONArray(r0)     // Catch:{ Throwable -> 0x04bb }
            if (r0 == 0) goto L_0x04c3
            r1 = r4
        L_0x049d:
            int r2 = r0.length()     // Catch:{ Throwable -> 0x04bb }
            if (r1 >= r2) goto L_0x04c3
            org.json.JSONObject r2 = r0.optJSONObject(r1)     // Catch:{ Throwable -> 0x04bb }
            java.lang.String r5 = "pan"
            java.lang.String r2 = r2.optString(r5)     // Catch:{ Throwable -> 0x04bb }
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x04bb }
            if (r5 != 0) goto L_0x04b8
            java.util.List<java.lang.String> r5 = ac     // Catch:{ Throwable -> 0x04bb }
            r5.add(r2)     // Catch:{ Throwable -> 0x04bb }
        L_0x04b8:
            int r1 = r1 + 1
            goto L_0x049d
        L_0x04bb:
            r0 = move-exception
            java.lang.String r1 = "AuthUtil"
            java.lang.String r2 = "loadConfigData_otherServiceList"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x0569 }
        L_0x04c3:
            org.json.JSONObject r0 = r15.i     // Catch:{ Throwable -> 0x04e2 }
            if (r0 == 0) goto L_0x04ea
            java.lang.String r1 = "able"
            java.lang.String r1 = r0.optString(r1)     // Catch:{ Throwable -> 0x04e2 }
            boolean r2 = ad     // Catch:{ Throwable -> 0x04e2 }
            boolean r1 = com.loc.l.a((java.lang.String) r1, (boolean) r2)     // Catch:{ Throwable -> 0x04e2 }
            ad = r1     // Catch:{ Throwable -> 0x04e2 }
            if (r1 == 0) goto L_0x04ea
            java.lang.String r1 = "c"
            int r2 = ae     // Catch:{ Throwable -> 0x04e2 }
            int r0 = r0.optInt(r1, r2)     // Catch:{ Throwable -> 0x04e2 }
            ae = r0     // Catch:{ Throwable -> 0x04e2 }
            goto L_0x04ea
        L_0x04e2:
            r0 = move-exception
            java.lang.String r1 = "AuthUtil"
            java.lang.String r2 = "loadConfigData_gpsGeoAble"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x0569 }
        L_0x04ea:
            org.json.JSONObject r15 = r15.g     // Catch:{ Throwable -> 0x0560 }
            if (r15 == 0) goto L_0x0568
            java.lang.String r0 = "at"
            r1 = 123(0x7b, float:1.72E-43)
            int r0 = r15.optInt(r0, r1)     // Catch:{ Throwable -> 0x04fd }
            int r0 = r0 * 60
            int r0 = r0 * 1000
            c = r0     // Catch:{ Throwable -> 0x04fd }
            goto L_0x0505
        L_0x04fd:
            r0 = move-exception
            java.lang.String r1 = "AuthUtil"
            java.lang.String r2 = "requestSdkAuthInterval"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x0560 }
        L_0x0505:
            java.lang.String r0 = "ila"
            java.lang.String r0 = r15.optString(r0)     // Catch:{ Throwable -> 0x0514 }
            boolean r1 = af     // Catch:{ Throwable -> 0x0514 }
            boolean r0 = com.loc.l.a((java.lang.String) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0514 }
            af = r0     // Catch:{ Throwable -> 0x0514 }
            goto L_0x051c
        L_0x0514:
            r0 = move-exception
            java.lang.String r1 = "AuthUtil"
            java.lang.String r2 = "loadConfigData_indoor"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x0560 }
        L_0x051c:
            java.lang.String r0 = "icbd"
            java.lang.String r0 = r15.optString(r0)     // Catch:{ Throwable -> 0x0532 }
            boolean r1 = b     // Catch:{ Throwable -> 0x0532 }
            boolean r0 = com.loc.l.a((java.lang.String) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0532 }
            b = r0     // Catch:{ Throwable -> 0x0532 }
            if (r0 == 0) goto L_0x053a
            java.lang.String r0 = "loc"
            com.loc.au.a((android.content.Context) r14, (java.lang.String) r0)     // Catch:{ Throwable -> 0x0532 }
            goto L_0x053a
        L_0x0532:
            r0 = move-exception
            java.lang.String r1 = "AuthUtil"
            java.lang.String r2 = "loadConfigData_CallBackDex"
            com.loc.cs.a(r0, r1, r2)     // Catch:{ Throwable -> 0x0560 }
        L_0x053a:
            if (r14 == 0) goto L_0x0568
            if (r15 != 0) goto L_0x053f
            return r3
        L_0x053f:
            java.lang.String r0 = "re"
            java.lang.String r15 = r15.optString(r0)     // Catch:{ Throwable -> 0x0557 }
            boolean r0 = g     // Catch:{ Throwable -> 0x0557 }
            boolean r15 = com.loc.l.a((java.lang.String) r15, (boolean) r0)     // Catch:{ Throwable -> 0x0557 }
            g = r15     // Catch:{ Throwable -> 0x0557 }
            java.lang.String r15 = "pref"
            java.lang.String r0 = "fr"
            boolean r1 = g     // Catch:{ Throwable -> 0x0557 }
            com.loc.cz.a((android.content.Context) r14, (java.lang.String) r15, (java.lang.String) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0557 }
            return r3
        L_0x0557:
            r14 = move-exception
            java.lang.String r15 = "AuthUtil"
            java.lang.String r0 = "checkReLocationAble"
            com.loc.cs.a(r14, r15, r0)     // Catch:{ Throwable -> 0x0560 }
            return r3
        L_0x0560:
            r14 = move-exception
            java.lang.String r15 = "AuthUtil"
            java.lang.String r0 = "loadConfigData_hotUpdate"
            com.loc.cs.a(r14, r15, r0)     // Catch:{ Throwable -> 0x0569 }
        L_0x0568:
            return r3
        L_0x0569:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cr.a(android.content.Context, com.loc.l$a):boolean");
    }

    public static int b() {
        return s;
    }

    public static boolean b(long j2) {
        if (!S) {
            return false;
        }
        return T < 0 || da.a() - j2 < T;
    }

    public static boolean b(Context context) {
        if (!E) {
            return false;
        }
        if (F == -1 || G == 0) {
            return true;
        }
        if (!da.b(G, cz.b(context, "pref", "nowtime", 0))) {
            i(context);
            cz.a(context, "pref", "count", 1);
            return true;
        }
        int b2 = cz.b(context, "pref", "count", 0);
        if (b2 >= F) {
            return false;
        }
        cz.a(context, "pref", "count", b2 + 1);
        return true;
    }

    public static boolean c() {
        return t;
    }

    public static boolean c(Context context) {
        if (!I) {
            return false;
        }
        if (J == -1 || K == 0) {
            return true;
        }
        if (!da.b(K, cz.b(context, "pref", "pushSerTime", 0))) {
            j(context);
            cz.a(context, "pref", "pushCount", 1);
            return true;
        }
        int b2 = cz.b(context, "pref", "pushCount", 0);
        if (b2 >= J) {
            return false;
        }
        cz.a(context, "pref", "pushCount", b2 + 1);
        return true;
    }

    public static int d() {
        return u;
    }

    public static boolean d(Context context) {
        if (!O || y <= 0 || x <= 0 || y > x) {
            return false;
        }
        long b2 = cz.b(context, "abcd", "lct", 0);
        long b3 = cz.b(context, "abcd", "lst", 0);
        long b4 = da.b();
        if (b4 < b2) {
            cz.a(context, "abcd", "lct", b4);
            return false;
        }
        if (b4 - b2 > 86400000) {
            cz.a(context, "abcd", "lct", b4);
            cz.a(context, "abcd", "t", 0);
        }
        if (b4 - b3 < ((long) w)) {
            return false;
        }
        int b5 = cz.b(context, "abcd", "t", 0) + 1;
        if (b5 > x) {
            return false;
        }
        cz.a(context, "abcd", "lst", b4);
        cz.a(context, "abcd", "t", b5);
        return true;
    }

    public static void e(Context context) {
        try {
            z = cz.b(context, "pref", "exception", z);
            f(context);
        } catch (Throwable th) {
            cs.a(th, "AuthUtil", "loadLastAbleState p1");
        }
        try {
            V = cz.b(context, "pref", "oAble", false);
        } catch (Throwable th2) {
            cs.a(th2, "AuthUtil", "loadLastAbleState p2");
        }
        try {
            A = cz.b(context, "pref", "fn", A);
            B = cz.b(context, "pref", "mpn", B);
            C = cz.b(context, "pref", "igu", C);
            bq.a(A, C);
        } catch (Throwable unused) {
        }
        try {
            S = cz.b(context, "pref", "ca", S);
            T = cz.b(context, "pref", "ct", T);
        } catch (Throwable unused2) {
        }
        try {
            g = cz.b(context, "pref", "fr", g);
        } catch (Throwable unused3) {
        }
    }

    public static boolean e() {
        return v;
    }

    public static String f() {
        return h;
    }

    public static void f(Context context) {
        try {
            s b2 = cs.b();
            b2.a(z);
            z.a(context, b2);
        } catch (Throwable unused) {
        }
    }

    public static String g() {
        return i;
    }

    public static boolean g(Context context) {
        if (!Y || aa == 0 || ab == 0 || Z == 0 || (aa != -1 && aa < ab)) {
            return false;
        }
        if (ac != null && ac.size() > 0) {
            for (String b2 : ac) {
                if (da.b(context, b2)) {
                    return false;
                }
            }
        }
        if (aa == -1 && ab == -1) {
            return true;
        }
        long b3 = cz.b(context, "pref", "ots", 0);
        long b4 = cz.b(context, "pref", "otsh", 0);
        int b5 = cz.b(context, "pref", "otn", 0);
        int b6 = cz.b(context, "pref", "otnh", 0);
        if (aa != -1) {
            if (!da.b(Z, b3)) {
                try {
                    SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
                    edit.putLong("ots", Z);
                    edit.putLong("otsh", Z);
                    edit.putInt("otn", 0);
                    edit.putInt("otnh", 0);
                    cz.a(edit);
                } catch (Throwable th) {
                    cs.a(th, "AuthUtil", "resetPrefsBind");
                }
                cz.a(context, "pref", "otn", 1);
                cz.a(context, "pref", "otnh", 1);
                return true;
            } else if (b5 < aa) {
                if (ab == -1) {
                    cz.a(context, "pref", "otn", b5 + 1);
                    cz.a(context, "pref", "otnh", 0);
                    return true;
                } else if (!da.a(Z, b4)) {
                    cz.a(context, "pref", "otsh", Z);
                    cz.a(context, "pref", "otn", b5 + 1);
                    cz.a(context, "pref", "otnh", 1);
                    return true;
                } else if (b6 < ab) {
                    cz.a(context, "pref", "otn", b5 + 1);
                    cz.a(context, "pref", "otnh", b6 + 1);
                    return true;
                }
            }
        }
        if (aa == -1) {
            cz.a(context, "pref", "otn", 0);
            if (ab == -1) {
                cz.a(context, "pref", "otnh", 0);
                return true;
            } else if (!da.a(Z, b4)) {
                cz.a(context, "pref", "otsh", Z);
                cz.a(context, "pref", "otnh", 1);
                return true;
            } else if (b6 < ab) {
                cz.a(context, "pref", "otnh", b6 + 1);
                return true;
            }
        }
        return false;
    }

    public static String h() {
        return j;
    }

    public static boolean h(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (da.b() - e >= ((long) c)) {
                f = true;
                return true;
            }
        } catch (Throwable th) {
            cs.a(th, "APS", "isConfigNeedUpdate");
        }
        return false;
    }

    public static String i() {
        return k;
    }

    private static void i(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("nowtime", G);
            edit.putInt("count", 0);
            cz.a(edit);
        } catch (Throwable th) {
            cs.a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static String j() {
        return l;
    }

    private static void j(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("pref", 0).edit();
            edit.putLong("pushSerTime", K);
            edit.putInt("pushCount", 0);
            cz.a(edit);
        } catch (Throwable th) {
            cs.a(th, "AuthUtil", "resetPrefsBind");
        }
    }

    public static String k() {
        return m;
    }

    public static boolean l() {
        return a;
    }

    public static ArrayList<String> m() {
        return H;
    }

    public static ArrayList<String> n() {
        return L;
    }

    public static boolean o() {
        return z;
    }

    public static int p() {
        return B;
    }

    public static boolean q() {
        return D;
    }

    public static void r() {
        D = false;
    }

    public static boolean s() {
        return P;
    }

    public static long t() {
        return T;
    }

    public static boolean u() {
        return S;
    }

    public static boolean v() {
        return U;
    }

    public static boolean w() {
        return V;
    }

    public static boolean x() {
        return W;
    }

    public static List<cu> y() {
        return X;
    }

    public static boolean z() {
        return ad;
    }
}
