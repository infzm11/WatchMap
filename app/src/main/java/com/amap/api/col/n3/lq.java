package com.amap.api.col.n3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;

@SuppressLint({"NewApi"})
/* compiled from: Req */
public final class lq {
    public static String K;
    public String A = null;
    public String B = null;
    public ArrayList<lk> C = new ArrayList<>();
    public String D = null;
    public String E = null;
    public ArrayList<ScanResult> F = new ArrayList<>();
    public ArrayList<li> G = new ArrayList<>();
    public String H = null;
    public String I = null;
    public byte[] J = null;
    public String L = null;
    private byte[] M = null;
    private int N = 0;
    public String a = "1";
    public short b = 0;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public String j = null;
    public String k = null;
    public String l = null;
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public String v = null;
    public String w = null;
    public String x = null;
    public String y = null;
    public int z = 0;

    private String a(String str, int i2) {
        String[] split = this.B.split("\\*")[i2].split(",");
        if (str.equals("lac")) {
            return split[0];
        }
        if (str.equals("cellid")) {
            return split[1];
        }
        if (str.equals("signal")) {
            return split[2];
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0023 A[Catch:{ Throwable -> 0x0010 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = ":"
            java.lang.String[] r0 = r7.split(r0)
            r1 = 6
            byte[] r2 = new byte[r1]
            r3 = 0
            if (r0 == 0) goto L_0x0012
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r4 == r1) goto L_0x001f
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            goto L_0x0042
        L_0x0012:
            java.lang.String[] r0 = new java.lang.String[r1]     // Catch:{ Throwable -> 0x0010 }
            r1 = r3
        L_0x0015:
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r1 >= r4) goto L_0x001f
            java.lang.String r4 = "0"
            r0[r1] = r4     // Catch:{ Throwable -> 0x0010 }
            int r1 = r1 + 1
            goto L_0x0015
        L_0x001f:
            r1 = r3
        L_0x0020:
            int r4 = r0.length     // Catch:{ Throwable -> 0x0010 }
            if (r1 >= r4) goto L_0x005b
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x0010 }
            r5 = 2
            if (r4 <= r5) goto L_0x0034
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            java.lang.String r4 = r4.substring(r3, r5)     // Catch:{ Throwable -> 0x0010 }
            r0[r1] = r4     // Catch:{ Throwable -> 0x0010 }
        L_0x0034:
            r4 = r0[r1]     // Catch:{ Throwable -> 0x0010 }
            r5 = 16
            int r4 = java.lang.Integer.parseInt(r4, r5)     // Catch:{ Throwable -> 0x0010 }
            byte r4 = (byte) r4     // Catch:{ Throwable -> 0x0010 }
            r2[r1] = r4     // Catch:{ Throwable -> 0x0010 }
            int r1 = r1 + 1
            goto L_0x0020
        L_0x0042:
            java.lang.String r1 = "Req"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "getMacBa "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.amap.api.col.n3.lr.a(r0, r1, r7)
            java.lang.String r7 = "00:00:00:00:00:00"
            byte[] r2 = r6.a(r7)
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lq.a(java.lang.String):byte[]");
    }

    private String b(String str) {
        String str2 = this.A;
        if (!str2.contains(str + ">")) {
            return "0";
        }
        String str3 = this.A;
        int indexOf = str3.indexOf(str + ">");
        String str4 = this.A;
        return this.A.substring(indexOf + str.length() + 1, str4.indexOf("</" + str));
    }

    public final void a(Context context, boolean z2, boolean z3, ll llVar, lm lmVar, ConnectivityManager connectivityManager, String str, String str2) {
        String str3;
        String str4;
        NetworkInfo networkInfo;
        String str5;
        String str6;
        String str7;
        String str8;
        int i2;
        ll llVar2 = llVar;
        String f2 = id.f(context);
        int f3 = lu.f();
        this.L = str2;
        String str9 = "api_serverSDK_130905";
        String str10 = "S128DF1572465B890OE3F7A13167KLEI";
        if (!z3) {
            str9 = "UC_nlp_20131029";
            str10 = "BKZCHMBBSSUK7U8GLUKHBB56CCFF78U";
        }
        StringBuilder sb = new StringBuilder();
        String str11 = "0";
        StringBuilder sb2 = new StringBuilder();
        String str12 = "";
        int i3 = llVar2.a;
        String str13 = "";
        int i4 = llVar2.a & 3;
        String str14 = "";
        TelephonyManager telephonyManager = llVar2.c;
        int i5 = f3;
        ArrayList<lk> arrayList = llVar2.b;
        String str15 = f2;
        ArrayList<lk> a2 = llVar.a();
        ArrayList<ScanResult> a3 = lmVar.a();
        String str16 = "0";
        if (i4 == 2) {
            str11 = "1";
        }
        String str17 = str11;
        if (telephonyManager != null) {
            if (TextUtils.isEmpty(lr.d)) {
                try {
                    lr.d = ih.q(context);
                } catch (Throwable th) {
                    str4 = "0";
                    str3 = "0";
                    lr.a(th, "APS", "getApsReq part4");
                }
            }
            str3 = "0";
            str4 = "0";
            if (TextUtils.isEmpty(lr.d)) {
                lr.d = "888888888888888";
            }
            if (TextUtils.isEmpty(lr.e)) {
                try {
                    lr.e = telephonyManager.getSubscriberId();
                } catch (SecurityException unused) {
                } catch (Throwable th2) {
                    lr.a(th2, "APS", "getApsReq part2");
                }
            }
            if (TextUtils.isEmpty(lr.e)) {
                lr.e = "888888888888888";
            }
        } else {
            str3 = "0";
            str4 = "0";
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Throwable th3) {
            lr.a(th3, "APS", "getApsReq part");
            networkInfo = null;
        }
        WifiInfo f4 = lmVar.f();
        boolean a4 = lm.a(f4);
        if (lu.a(networkInfo) != -1) {
            str6 = lu.b(telephonyManager);
            str5 = (!a4 || !lmVar.e()) ? "1" : "2";
        } else {
            str6 = str12;
            str5 = str13;
        }
        String str18 = str5;
        if (!arrayList.isEmpty()) {
            StringBuilder sb3 = new StringBuilder();
            switch (i4) {
                case 1:
                    lk lkVar = arrayList.get(0);
                    str7 = str6;
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(lkVar.a);
                    sb3.append("</mcc>");
                    sb3.append("<mnc>");
                    sb3.append(lkVar.b);
                    sb3.append("</mnc>");
                    sb3.append("<lac>");
                    sb3.append(lkVar.c);
                    sb3.append("</lac>");
                    sb3.append("<cellid>");
                    sb3.append(lkVar.d);
                    sb3.append("</cellid>");
                    sb3.append("<signal>");
                    sb3.append(lkVar.j);
                    sb3.append("</signal>");
                    String sb4 = sb3.toString();
                    int i6 = 1;
                    while (i6 < arrayList.size()) {
                        lk lkVar2 = arrayList.get(i6);
                        String str19 = sb4;
                        sb.append(lkVar2.c);
                        sb.append(",");
                        sb.append(lkVar2.d);
                        sb.append(",");
                        sb.append(lkVar2.j);
                        if (i6 < arrayList.size() - 1) {
                            sb.append("*");
                        }
                        i6++;
                        sb4 = str19;
                    }
                    str8 = sb4;
                    break;
                case 2:
                    lk lkVar3 = arrayList.get(0);
                    sb3.delete(0, sb3.length());
                    sb3.append("<mcc>");
                    sb3.append(lkVar3.a);
                    sb3.append("</mcc>");
                    sb3.append("<sid>");
                    sb3.append(lkVar3.g);
                    sb3.append("</sid>");
                    sb3.append("<nid>");
                    sb3.append(lkVar3.h);
                    sb3.append("</nid>");
                    sb3.append("<bid>");
                    sb3.append(lkVar3.i);
                    sb3.append("</bid>");
                    if (lkVar3.f > 0 && lkVar3.e > 0) {
                        sb3.append("<lon>");
                        sb3.append(lkVar3.f);
                        sb3.append("</lon>");
                        sb3.append("<lat>");
                        sb3.append(lkVar3.e);
                        sb3.append("</lat>");
                    }
                    sb3.append("<signal>");
                    sb3.append(lkVar3.j);
                    sb3.append("</signal>");
                    str8 = sb3.toString();
                    str7 = str6;
                    break;
                default:
                    str7 = str6;
                    str8 = str14;
                    break;
            }
            sb3.delete(0, sb3.length());
        } else {
            str7 = str6;
            str8 = str14;
        }
        if ((i3 & 4) != 4 || a2.isEmpty()) {
            this.C.clear();
        } else {
            this.C.clear();
            this.C.addAll(a2);
        }
        if (lmVar.e()) {
            if (a4) {
                sb2.append(lmVar.f().getBSSID());
                sb2.append(",");
                int rssi = lmVar.f().getRssi();
                if (rssi < -128 || rssi > 127) {
                    rssi = 0;
                }
                sb2.append(rssi);
                sb2.append(",");
                String ssid = f4.getSSID();
                try {
                    i2 = f4.getSSID().getBytes("UTF-8").length;
                } catch (Exception unused2) {
                    i2 = 32;
                }
                if (i2 >= 32) {
                    ssid = "unkwn";
                }
                sb2.append(ssid.replace("*", "."));
            }
            if (!(a3 == null || this.F == null)) {
                this.F.clear();
                this.F.addAll(a3);
            }
        } else {
            lmVar.b();
            if (this.F != null) {
                this.F.clear();
            }
        }
        this.b = !z2 ? (short) 2 : 0;
        this.c = str9;
        this.d = str10;
        this.f = lu.d();
        this.g = "android" + lu.e();
        this.h = lu.b(context);
        this.i = str17;
        this.j = "0";
        this.k = "0";
        this.l = str3;
        this.m = str4;
        this.n = str16;
        this.o = str15;
        this.p = lr.d;
        this.q = lr.e;
        this.s = String.valueOf(i5);
        this.t = str;
        this.v = "3.6.0";
        this.w = null;
        this.u = "";
        this.x = str7;
        this.y = str18;
        this.z = i3;
        this.A = str8;
        this.B = sb.toString();
        this.D = llVar.e();
        this.H = lm.i();
        this.E = sb2.toString();
        try {
            if (TextUtils.isEmpty(K)) {
                K = ih.f(context);
            }
        } catch (Throwable unused3) {
        }
        sb.delete(0, sb.length());
        sb2.delete(0, sb2.length());
    }

    /* JADX WARNING: Removed duplicated region for block: B:240:0x05b0 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x06c7  */
    /* JADX WARNING: Removed duplicated region for block: B:281:0x06cc  */
    /* JADX WARNING: Removed duplicated region for block: B:304:0x0751  */
    /* JADX WARNING: Removed duplicated region for block: B:305:0x0758  */
    /* JADX WARNING: Removed duplicated region for block: B:338:0x081b A[Catch:{ Throwable -> 0x0831 }] */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x081e A[Catch:{ Throwable -> 0x0831 }] */
    /* JADX WARNING: Removed duplicated region for block: B:341:0x0823 A[Catch:{ Throwable -> 0x0831 }] */
    /* JADX WARNING: Removed duplicated region for block: B:350:0x0844 A[Catch:{ Throwable -> 0x0869 }] */
    /* JADX WARNING: Removed duplicated region for block: B:356:0x0856 A[SYNTHETIC, Splitter:B:356:0x0856] */
    /* JADX WARNING: Removed duplicated region for block: B:368:0x087e  */
    /* JADX WARNING: Removed duplicated region for block: B:373:0x0889  */
    /* JADX WARNING: Removed duplicated region for block: B:430:0x0930  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0935  */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x0944  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] a() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r2 = r1.a
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x000e
            java.lang.String r2 = ""
            r1.a = r2
        L_0x000e:
            java.lang.String r2 = r1.c
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = ""
            r1.c = r2
        L_0x001a:
            java.lang.String r2 = r1.d
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0026
            java.lang.String r2 = ""
            r1.d = r2
        L_0x0026:
            java.lang.String r2 = r1.e
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0032
            java.lang.String r2 = ""
            r1.e = r2
        L_0x0032:
            java.lang.String r2 = r1.f
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x003e
            java.lang.String r2 = ""
            r1.f = r2
        L_0x003e:
            java.lang.String r2 = r1.g
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x004a
            java.lang.String r2 = ""
            r1.g = r2
        L_0x004a:
            java.lang.String r2 = r1.h
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0056
            java.lang.String r2 = ""
            r1.h = r2
        L_0x0056:
            java.lang.String r2 = r1.i
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0062
            java.lang.String r2 = ""
            r1.i = r2
        L_0x0062:
            java.lang.String r2 = r1.j
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x006f
        L_0x006a:
            java.lang.String r2 = "0"
            r1.j = r2
            goto L_0x0084
        L_0x006f:
            java.lang.String r2 = r1.j
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0084
            java.lang.String r2 = r1.j
            java.lang.String r3 = "2"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0084
            goto L_0x006a
        L_0x0084:
            java.lang.String r2 = r1.k
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0091
        L_0x008c:
            java.lang.String r2 = "0"
            r1.k = r2
            goto L_0x00a6
        L_0x0091:
            java.lang.String r2 = r1.k
            java.lang.String r3 = "0"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00a6
            java.lang.String r2 = r1.k
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x00a6
            goto L_0x008c
        L_0x00a6:
            java.lang.String r2 = r1.l
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00b2
            java.lang.String r2 = ""
            r1.l = r2
        L_0x00b2:
            java.lang.String r2 = r1.m
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00be
            java.lang.String r2 = ""
            r1.m = r2
        L_0x00be:
            java.lang.String r2 = r1.n
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00ca
            java.lang.String r2 = ""
            r1.n = r2
        L_0x00ca:
            java.lang.String r2 = r1.o
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00d6
            java.lang.String r2 = ""
            r1.o = r2
        L_0x00d6:
            java.lang.String r2 = r1.p
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00e2
            java.lang.String r2 = ""
            r1.p = r2
        L_0x00e2:
            java.lang.String r2 = r1.q
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00ee
            java.lang.String r2 = ""
            r1.q = r2
        L_0x00ee:
            java.lang.String r2 = r1.r
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x00fa
            java.lang.String r2 = ""
            r1.r = r2
        L_0x00fa:
            java.lang.String r2 = r1.s
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0106
            java.lang.String r2 = ""
            r1.s = r2
        L_0x0106:
            java.lang.String r2 = r1.t
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0112
            java.lang.String r2 = ""
            r1.t = r2
        L_0x0112:
            java.lang.String r2 = r1.u
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x011e
            java.lang.String r2 = ""
            r1.u = r2
        L_0x011e:
            java.lang.String r2 = r1.v
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x012a
            java.lang.String r2 = ""
            r1.v = r2
        L_0x012a:
            java.lang.String r2 = r1.w
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0136
            java.lang.String r2 = ""
            r1.w = r2
        L_0x0136:
            java.lang.String r2 = r1.x
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0142
            java.lang.String r2 = ""
            r1.x = r2
        L_0x0142:
            java.lang.String r2 = r1.y
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x014f
        L_0x014a:
            java.lang.String r2 = "0"
            r1.y = r2
            goto L_0x0164
        L_0x014f:
            java.lang.String r2 = r1.y
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0164
            java.lang.String r2 = r1.y
            java.lang.String r3 = "2"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0164
            goto L_0x014a
        L_0x0164:
            int r2 = r1.z
            r3 = 1
            r4 = 0
            if (r2 <= 0) goto L_0x0171
            r5 = 15
            if (r2 <= r5) goto L_0x016f
            goto L_0x0171
        L_0x016f:
            r2 = r3
            goto L_0x0172
        L_0x0171:
            r2 = r4
        L_0x0172:
            if (r2 != 0) goto L_0x0176
            r1.z = r4
        L_0x0176:
            java.lang.String r2 = r1.A
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0182
            java.lang.String r2 = ""
            r1.A = r2
        L_0x0182:
            java.lang.String r2 = r1.B
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x018e
            java.lang.String r2 = ""
            r1.B = r2
        L_0x018e:
            java.lang.String r2 = r1.E
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x019a
            java.lang.String r2 = ""
            r1.E = r2
        L_0x019a:
            java.lang.String r2 = r1.H
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x01a6
            java.lang.String r2 = ""
            r1.H = r2
        L_0x01a6:
            java.lang.String r2 = r1.I
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x01b2
            java.lang.String r2 = ""
            r1.I = r2
        L_0x01b2:
            java.lang.String r2 = K
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x01be
            java.lang.String r2 = ""
            K = r2
        L_0x01be:
            byte[] r2 = r1.J
            if (r2 != 0) goto L_0x01c6
            byte[] r2 = new byte[r4]
            r1.J = r2
        L_0x01c6:
            r2 = 2
            byte[] r5 = new byte[r2]
            r6 = 4
            byte[] r7 = new byte[r6]
            byte[] r8 = r1.J
            r9 = 4096(0x1000, float:5.74E-42)
            if (r8 == 0) goto L_0x01d7
            byte[] r8 = r1.J
            int r8 = r8.length
            int r8 = r8 + r3
            int r9 = r9 + r8
        L_0x01d7:
            byte[] r8 = r1.M
            if (r8 == 0) goto L_0x01e3
            int r8 = r1.N
            if (r9 <= r8) goto L_0x01e0
            goto L_0x01e3
        L_0x01e0:
            byte[] r8 = r1.M
            goto L_0x01e9
        L_0x01e3:
            byte[] r8 = new byte[r9]
            r1.M = r8
            r1.N = r9
        L_0x01e9:
            java.lang.String r9 = r1.a
            byte r9 = java.lang.Byte.parseByte(r9)
            r8[r4] = r9
            short r9 = r1.b
            r10 = 0
            byte[] r9 = com.amap.api.col.n3.lu.a((int) r9, (byte[]) r10)
            int r11 = r9.length
            java.lang.System.arraycopy(r9, r4, r8, r3, r11)
            int r9 = r9.length
            int r9 = r9 + r3
            java.lang.String r11 = r1.c     // Catch:{ Throwable -> 0x0213 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x0213 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x0213 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x0213 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x0213 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x0213 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x0213 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x0213 }
            int r9 = r9 + r11
            goto L_0x0221
        L_0x0213:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot2"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0221:
            java.lang.String r11 = r1.d     // Catch:{ Throwable -> 0x0236 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x0236 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x0236 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x0236 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x0236 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x0236 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x0236 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x0236 }
            int r9 = r9 + r11
            goto L_0x0244
        L_0x0236:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot21"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0244:
            java.lang.String r11 = r1.o     // Catch:{ Throwable -> 0x0259 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x0259 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x0259 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x0259 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x0259 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x0259 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x0259 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x0259 }
            int r9 = r9 + r11
            goto L_0x0267
        L_0x0259:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot22"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0267:
            java.lang.String r11 = r1.e     // Catch:{ Throwable -> 0x027c }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x027c }
            int r12 = r11.length     // Catch:{ Throwable -> 0x027c }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x027c }
            r8[r9] = r12     // Catch:{ Throwable -> 0x027c }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x027c }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x027c }
            int r11 = r11.length     // Catch:{ Throwable -> 0x027c }
            int r9 = r9 + r11
            goto L_0x028a
        L_0x027c:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot23"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x028a:
            java.lang.String r11 = r1.f     // Catch:{ Throwable -> 0x029f }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x029f }
            int r12 = r11.length     // Catch:{ Throwable -> 0x029f }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x029f }
            r8[r9] = r12     // Catch:{ Throwable -> 0x029f }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x029f }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x029f }
            int r11 = r11.length     // Catch:{ Throwable -> 0x029f }
            int r9 = r9 + r11
            goto L_0x02ad
        L_0x029f:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot24"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x02ad:
            java.lang.String r11 = r1.g     // Catch:{ Throwable -> 0x02c2 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x02c2 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x02c2 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x02c2 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x02c2 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x02c2 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x02c2 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x02c2 }
            int r9 = r9 + r11
            goto L_0x02d0
        L_0x02c2:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot25"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x02d0:
            java.lang.String r11 = r1.u     // Catch:{ Throwable -> 0x02e5 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x02e5 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x02e5 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x02e5 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x02e5 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x02e5 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x02e5 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x02e5 }
            int r9 = r9 + r11
            goto L_0x02f3
        L_0x02e5:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot26"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x02f3:
            java.lang.String r11 = r1.h     // Catch:{ Throwable -> 0x0308 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x0308 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x0308 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x0308 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x0308 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x0308 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x0308 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x0308 }
            int r9 = r9 + r11
            goto L_0x0316
        L_0x0308:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot27"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0316:
            java.lang.String r11 = r1.p     // Catch:{ Throwable -> 0x032b }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x032b }
            int r12 = r11.length     // Catch:{ Throwable -> 0x032b }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x032b }
            r8[r9] = r12     // Catch:{ Throwable -> 0x032b }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x032b }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x032b }
            int r11 = r11.length     // Catch:{ Throwable -> 0x032b }
            int r9 = r9 + r11
            goto L_0x0339
        L_0x032b:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot28"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0339:
            java.lang.String r11 = r1.q     // Catch:{ Throwable -> 0x034e }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x034e }
            int r12 = r11.length     // Catch:{ Throwable -> 0x034e }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x034e }
            r8[r9] = r12     // Catch:{ Throwable -> 0x034e }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x034e }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x034e }
            int r11 = r11.length     // Catch:{ Throwable -> 0x034e }
            int r9 = r9 + r11
            goto L_0x035c
        L_0x034e:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot29"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x035c:
            java.lang.String r11 = r1.t     // Catch:{ Throwable -> 0x037b }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x037b }
            if (r11 == 0) goto L_0x0368
            r8[r9] = r4     // Catch:{ Throwable -> 0x037b }
            int r9 = r9 + r3
            goto L_0x0389
        L_0x0368:
            java.lang.String r11 = r1.t     // Catch:{ Throwable -> 0x037b }
            byte[] r11 = r1.a(r11)     // Catch:{ Throwable -> 0x037b }
            int r12 = r11.length     // Catch:{ Throwable -> 0x037b }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x037b }
            r8[r9] = r12     // Catch:{ Throwable -> 0x037b }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x037b }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x037b }
            int r11 = r11.length     // Catch:{ Throwable -> 0x037b }
            int r9 = r9 + r11
            goto L_0x0389
        L_0x037b:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot219"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0389:
            java.lang.String r11 = r1.v     // Catch:{ Throwable -> 0x039e }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x039e }
            int r12 = r11.length     // Catch:{ Throwable -> 0x039e }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x039e }
            r8[r9] = r12     // Catch:{ Throwable -> 0x039e }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x039e }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x039e }
            int r11 = r11.length     // Catch:{ Throwable -> 0x039e }
            int r9 = r9 + r11
            goto L_0x03ac
        L_0x039e:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot211"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x03ac:
            java.lang.String r11 = r1.w     // Catch:{ Throwable -> 0x03c1 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x03c1 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x03c1 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x03c1 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x03c1 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x03c1 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x03c1 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x03c1 }
            int r9 = r9 + r11
            goto L_0x03cf
        L_0x03c1:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot212"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x03cf:
            java.lang.String r11 = K     // Catch:{ Throwable -> 0x03f0 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x03f0 }
            if (r11 == 0) goto L_0x03db
            r8[r9] = r4     // Catch:{ Throwable -> 0x03f0 }
            int r9 = r9 + r3
            goto L_0x03fe
        L_0x03db:
            java.lang.String r11 = K     // Catch:{ Throwable -> 0x03f0 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x03f0 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x03f0 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x03f0 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x03f0 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x03f0 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x03f0 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x03f0 }
            int r9 = r9 + r11
            goto L_0x03fe
        L_0x03f0:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot212"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x03fe:
            java.lang.String r11 = r1.x     // Catch:{ Throwable -> 0x0413 }
            java.lang.String r12 = "GBK"
            byte[] r11 = r11.getBytes(r12)     // Catch:{ Throwable -> 0x0413 }
            int r12 = r11.length     // Catch:{ Throwable -> 0x0413 }
            byte r12 = (byte) r12     // Catch:{ Throwable -> 0x0413 }
            r8[r9] = r12     // Catch:{ Throwable -> 0x0413 }
            int r9 = r9 + 1
            int r12 = r11.length     // Catch:{ Throwable -> 0x0413 }
            java.lang.System.arraycopy(r11, r4, r8, r9, r12)     // Catch:{ Throwable -> 0x0413 }
            int r11 = r11.length     // Catch:{ Throwable -> 0x0413 }
            int r9 = r9 + r11
            goto L_0x0421
        L_0x0413:
            r0 = move-exception
            r11 = r9
            r9 = r0
            java.lang.String r12 = "Req"
            java.lang.String r13 = "buildV4Dot213"
            com.amap.api.col.n3.lr.a(r9, r12, r13)
            r8[r11] = r4
            int r9 = r11 + 1
        L_0x0421:
            java.lang.String r11 = r1.y
            byte r11 = java.lang.Byte.parseByte(r11)
            r8[r9] = r11
            int r9 = r9 + r3
            java.lang.String r11 = r1.j
            byte r11 = java.lang.Byte.parseByte(r11)
            r8[r9] = r11
            int r9 = r9 + r3
            int r11 = r1.z
            r12 = 3
            r11 = r11 & r12
            int r13 = r1.z
            byte r13 = (byte) r13
            r8[r9] = r13
            int r9 = r9 + r3
            r13 = -128(0xffffffffffffff80, float:NaN)
            r14 = 127(0x7f, float:1.78E-43)
            if (r11 != r3) goto L_0x04fc
            java.lang.String r11 = "mcc"
            java.lang.String r11 = r1.b(r11)
            byte[] r11 = com.amap.api.col.n3.lu.b((java.lang.String) r11)
            int r15 = r11.length
            java.lang.System.arraycopy(r11, r4, r8, r9, r15)
            int r11 = r11.length
            int r9 = r9 + r11
            java.lang.String r11 = "mnc"
            java.lang.String r11 = r1.b(r11)
            byte[] r11 = com.amap.api.col.n3.lu.b((java.lang.String) r11)
            int r15 = r11.length
            java.lang.System.arraycopy(r11, r4, r8, r9, r15)
            int r11 = r11.length
            int r9 = r9 + r11
            java.lang.String r11 = "lac"
            java.lang.String r11 = r1.b(r11)
            byte[] r11 = com.amap.api.col.n3.lu.b((java.lang.String) r11)
            int r15 = r11.length
            java.lang.System.arraycopy(r11, r4, r8, r9, r15)
            int r11 = r11.length
            int r9 = r9 + r11
            java.lang.String r11 = "cellid"
            java.lang.String r11 = r1.b(r11)
            byte[] r11 = com.amap.api.col.n3.lu.c((java.lang.String) r11)
            int r15 = r11.length
            java.lang.System.arraycopy(r11, r4, r8, r9, r15)
            int r11 = r11.length
            int r9 = r9 + r11
            java.lang.String r11 = "signal"
            java.lang.String r11 = r1.b(r11)
            int r11 = java.lang.Integer.parseInt(r11)
            if (r11 <= r14) goto L_0x0491
        L_0x048f:
            r11 = r4
            goto L_0x0494
        L_0x0491:
            if (r11 >= r13) goto L_0x0494
            goto L_0x048f
        L_0x0494:
            byte r11 = (byte) r11
            r8[r9] = r11
            int r9 = r9 + r3
            byte[] r11 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r5)
            int r15 = r11.length
            java.lang.System.arraycopy(r11, r4, r8, r9, r15)
            int r9 = r9 + r2
            java.lang.String r11 = r1.B
            int r11 = r11.length()
            if (r11 != 0) goto L_0x04ae
            r8[r9] = r4
        L_0x04ab:
            int r9 = r9 + r3
            goto L_0x0580
        L_0x04ae:
            java.lang.String r11 = r1.B
            java.lang.String r15 = "\\*"
            java.lang.String[] r11 = r11.split(r15)
            int r11 = r11.length
            byte r15 = (byte) r11
            r8[r9] = r15
            int r9 = r9 + r3
            r15 = r9
            r9 = r4
        L_0x04bd:
            if (r9 >= r11) goto L_0x04f9
            java.lang.String r10 = "lac"
            java.lang.String r10 = r1.a(r10, r9)
            byte[] r10 = com.amap.api.col.n3.lu.b((java.lang.String) r10)
            int r12 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r15, r12)
            int r10 = r10.length
            int r15 = r15 + r10
            java.lang.String r10 = "cellid"
            java.lang.String r10 = r1.a(r10, r9)
            byte[] r10 = com.amap.api.col.n3.lu.c((java.lang.String) r10)
            int r12 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r15, r12)
            int r10 = r10.length
            int r15 = r15 + r10
            java.lang.String r10 = "signal"
            java.lang.String r10 = r1.a(r10, r9)
            int r10 = java.lang.Integer.parseInt(r10)
            if (r10 <= r14) goto L_0x04ed
        L_0x04eb:
            r10 = r4
            goto L_0x04f0
        L_0x04ed:
            if (r10 >= r13) goto L_0x04f0
            goto L_0x04eb
        L_0x04f0:
            byte r10 = (byte) r10
            r8[r15] = r10
            int r15 = r15 + r3
            int r9 = r9 + 1
            r10 = 0
            r12 = 3
            goto L_0x04bd
        L_0x04f9:
            r9 = r15
            goto L_0x0580
        L_0x04fc:
            if (r11 != r2) goto L_0x0580
            java.lang.String r10 = "mcc"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.b((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "sid"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.b((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "nid"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.b((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "bid"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.b((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "lon"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.c((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "lat"
            java.lang.String r10 = r1.b(r10)
            byte[] r10 = com.amap.api.col.n3.lu.c((java.lang.String) r10)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r10 = r10.length
            int r9 = r9 + r10
            java.lang.String r10 = "signal"
            java.lang.String r10 = r1.b(r10)
            int r10 = java.lang.Integer.parseInt(r10)
            if (r10 <= r14) goto L_0x056c
        L_0x056a:
            r10 = r4
            goto L_0x056f
        L_0x056c:
            if (r10 >= r13) goto L_0x056f
            goto L_0x056a
        L_0x056f:
            byte r10 = (byte) r10
            r8[r9] = r10
            int r9 = r9 + r3
            byte[] r10 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r5)
            int r11 = r10.length
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)
            int r9 = r9 + r2
            r8[r9] = r4
            goto L_0x04ab
        L_0x0580:
            java.lang.String r10 = r1.D
            if (r10 == 0) goto L_0x05a2
            int r11 = r1.z
            r12 = 8
            r11 = r11 & r12
            if (r11 != r12) goto L_0x05a2
            java.lang.String r11 = "GBK"
            byte[] r10 = r10.getBytes(r11)     // Catch:{ Exception -> 0x05a2 }
            int r11 = r10.length     // Catch:{ Exception -> 0x05a2 }
            r12 = 60
            int r11 = java.lang.Math.min(r11, r12)     // Catch:{ Exception -> 0x05a2 }
            byte r12 = (byte) r11     // Catch:{ Exception -> 0x05a2 }
            r8[r9] = r12     // Catch:{ Exception -> 0x05a2 }
            int r9 = r9 + 1
            java.lang.System.arraycopy(r10, r4, r8, r9, r11)     // Catch:{ Exception -> 0x05a2 }
            int r9 = r9 + r11
            goto L_0x05a5
        L_0x05a2:
            r8[r9] = r4
            int r9 = r9 + r3
        L_0x05a5:
            java.util.ArrayList<com.amap.api.col.n3.lk> r10 = r1.C
            int r11 = r10.size()
            int r12 = r1.z
            r12 = r12 & r6
            if (r12 != r6) goto L_0x06ba
            if (r11 <= 0) goto L_0x06ba
            java.lang.Object r12 = r10.get(r4)
            com.amap.api.col.n3.lk r12 = (com.amap.api.col.n3.lk) r12
            boolean r12 = r12.o
            if (r12 != 0) goto L_0x05be
            int r11 = r11 + -1
        L_0x05be:
            byte r12 = (byte) r11
            r8[r9] = r12
            int r9 = r9 + r3
            r12 = r9
            r9 = r4
        L_0x05c4:
            if (r9 >= r11) goto L_0x06bf
            java.lang.Object r15 = r10.get(r9)
            com.amap.api.col.n3.lk r15 = (com.amap.api.col.n3.lk) r15
            boolean r13 = r15.o
            if (r13 == 0) goto L_0x06b3
            int r13 = r15.k
            r16 = 99
            if (r13 == r3) goto L_0x0658
            int r13 = r15.k
            r3 = 3
            if (r13 == r3) goto L_0x0658
            int r13 = r15.k
            if (r13 != r6) goto L_0x05e1
            goto L_0x0658
        L_0x05e1:
            int r13 = r15.k
            if (r13 != r2) goto L_0x06b3
            int r13 = r15.k
            byte r13 = (byte) r13
            boolean r3 = r15.n
            if (r3 == 0) goto L_0x05ef
            r3 = r13 | 8
            byte r13 = (byte) r3
        L_0x05ef:
            r8[r12] = r13
            int r12 = r12 + 1
            int r3 = r15.a
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.g
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.h
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.i
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.f
            byte[] r3 = com.amap.api.col.n3.lu.b((int) r3, (byte[]) r7)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.e
            byte[] r3 = com.amap.api.col.n3.lu.b((int) r3, (byte[]) r7)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.j
            if (r3 <= r14) goto L_0x0642
        L_0x063f:
            r3 = r16
            goto L_0x0647
        L_0x0642:
            r13 = -128(0xffffffffffffff80, float:NaN)
            if (r3 >= r13) goto L_0x0647
            goto L_0x063f
        L_0x0647:
            byte r3 = (byte) r3
            r8[r12] = r3
            r3 = 1
            int r12 = r12 + r3
            short r3 = r15.l
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            goto L_0x06b2
        L_0x0658:
            int r3 = r15.k
            byte r3 = (byte) r3
            boolean r13 = r15.n
            if (r13 == 0) goto L_0x0662
            r3 = r3 | 8
            byte r3 = (byte) r3
        L_0x0662:
            r8[r12] = r3
            int r12 = r12 + 1
            int r3 = r15.a
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.b
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.c
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.d
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r7)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
            int r12 = r12 + r3
            int r3 = r15.j
            if (r3 <= r14) goto L_0x069d
        L_0x069a:
            r3 = r16
            goto L_0x06a2
        L_0x069d:
            r13 = -128(0xffffffffffffff80, float:NaN)
            if (r3 >= r13) goto L_0x06a2
            goto L_0x069a
        L_0x06a2:
            byte r3 = (byte) r3
            r8[r12] = r3
            r3 = 1
            int r12 = r12 + r3
            short r3 = r15.l
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r5)
            int r13 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r13)
            int r3 = r3.length
        L_0x06b2:
            int r12 = r12 + r3
        L_0x06b3:
            int r9 = r9 + 1
            r3 = 1
            r13 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x05c4
        L_0x06ba:
            r8[r9] = r4
            r3 = 1
            int r12 = r9 + 1
        L_0x06bf:
            java.lang.String r7 = r1.E
            int r7 = r7.length()
            if (r7 != 0) goto L_0x06cc
            r8[r12] = r4
        L_0x06c9:
            int r12 = r12 + r3
            goto L_0x0743
        L_0x06cc:
            r8[r12] = r3
            int r12 = r12 + r3
            java.lang.String r3 = r1.E     // Catch:{ Throwable -> 0x0721 }
            java.lang.String r7 = ","
            java.lang.String[] r3 = r3.split(r7)     // Catch:{ Throwable -> 0x0721 }
            r7 = r3[r4]     // Catch:{ Throwable -> 0x0721 }
            byte[] r7 = r1.a(r7)     // Catch:{ Throwable -> 0x0721 }
            int r9 = r7.length     // Catch:{ Throwable -> 0x0721 }
            java.lang.System.arraycopy(r7, r4, r8, r12, r9)     // Catch:{ Throwable -> 0x0721 }
            int r7 = r7.length     // Catch:{ Throwable -> 0x0721 }
            int r12 = r12 + r7
            r7 = r3[r2]     // Catch:{ Throwable -> 0x06f8 }
            java.lang.String r9 = "GBK"
            byte[] r7 = r7.getBytes(r9)     // Catch:{ Throwable -> 0x06f8 }
            int r9 = r7.length     // Catch:{ Throwable -> 0x06f8 }
            byte r9 = (byte) r9     // Catch:{ Throwable -> 0x06f8 }
            r8[r12] = r9     // Catch:{ Throwable -> 0x06f8 }
            int r12 = r12 + 1
            int r9 = r7.length     // Catch:{ Throwable -> 0x06f8 }
            java.lang.System.arraycopy(r7, r4, r8, r12, r9)     // Catch:{ Throwable -> 0x06f8 }
            int r7 = r7.length     // Catch:{ Throwable -> 0x06f8 }
            int r12 = r12 + r7
            goto L_0x0705
        L_0x06f8:
            r0 = move-exception
            r7 = r0
            java.lang.String r9 = "Req"
            java.lang.String r10 = "buildV4Dot214"
            com.amap.api.col.n3.lr.a(r7, r9, r10)     // Catch:{ Throwable -> 0x0721 }
            r8[r12] = r4     // Catch:{ Throwable -> 0x0721 }
            int r12 = r12 + 1
        L_0x0705:
            r7 = 1
            r3 = r3[r7]     // Catch:{ Throwable -> 0x0721 }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ Throwable -> 0x0721 }
            if (r3 <= r14) goto L_0x0710
        L_0x070e:
            r3 = r4
            goto L_0x0715
        L_0x0710:
            r7 = -128(0xffffffffffffff80, float:NaN)
            if (r3 >= r7) goto L_0x0715
            goto L_0x070e
        L_0x0715:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ Throwable -> 0x0721 }
            byte r3 = java.lang.Byte.parseByte(r3)     // Catch:{ Throwable -> 0x0721 }
            r8[r12] = r3     // Catch:{ Throwable -> 0x0721 }
            r3 = 1
            goto L_0x06c9
        L_0x0721:
            r0 = move-exception
            r3 = r0
            java.lang.String r7 = "Req"
            java.lang.String r9 = "buildV4Dot216"
            com.amap.api.col.n3.lr.a(r3, r7, r9)
            java.lang.String r3 = "00:00:00:00:00:00"
            byte[] r3 = r1.a(r3)
            int r7 = r3.length
            java.lang.System.arraycopy(r3, r4, r8, r12, r7)
            int r3 = r3.length
            int r12 = r12 + r3
            r8[r12] = r4
            r3 = 1
            int r12 = r12 + r3
            java.lang.String r7 = "0"
            byte r7 = java.lang.Byte.parseByte(r7)
            r8[r12] = r7
            goto L_0x06c9
        L_0x0743:
            java.util.ArrayList<android.net.wifi.ScanResult> r7 = r1.F
            int r9 = r7.size()
            r10 = 25
            int r9 = java.lang.Math.min(r9, r10)
            if (r9 != 0) goto L_0x0758
            r8[r12] = r4
            int r12 = r12 + r3
            r6 = r4
            r2 = r5
            goto L_0x080a
        L_0x0758:
            byte r10 = (byte) r9
            r8[r12] = r10
            int r12 = r12 + r3
            int r3 = com.amap.api.col.n3.lu.c()
            r10 = 17
            if (r3 < r10) goto L_0x0766
            r3 = 1
            goto L_0x0767
        L_0x0766:
            r3 = r4
        L_0x0767:
            r10 = 0
            if (r3 == 0) goto L_0x0773
            long r10 = com.amap.api.col.n3.lu.b()
            r17 = 1000(0x3e8, double:4.94E-321)
            long r10 = r10 / r17
        L_0x0773:
            r13 = r12
            r12 = r4
        L_0x0775:
            if (r12 >= r9) goto L_0x07f7
            java.lang.Object r15 = r7.get(r12)
            android.net.wifi.ScanResult r15 = (android.net.wifi.ScanResult) r15
            java.lang.String r6 = r15.BSSID
            byte[] r6 = r1.a(r6)
            int r2 = r6.length
            java.lang.System.arraycopy(r6, r4, r8, r13, r2)
            int r2 = r6.length
            int r13 = r13 + r2
            java.lang.String r2 = r15.SSID     // Catch:{ Exception -> 0x079f }
            java.lang.String r6 = "GBK"
            byte[] r2 = r2.getBytes(r6)     // Catch:{ Exception -> 0x079f }
            int r6 = r2.length     // Catch:{ Exception -> 0x079f }
            byte r6 = (byte) r6     // Catch:{ Exception -> 0x079f }
            r8[r13] = r6     // Catch:{ Exception -> 0x079f }
            int r13 = r13 + 1
            int r6 = r2.length     // Catch:{ Exception -> 0x079f }
            java.lang.System.arraycopy(r2, r4, r8, r13, r6)     // Catch:{ Exception -> 0x079f }
            int r2 = r2.length     // Catch:{ Exception -> 0x079f }
            int r13 = r13 + r2
            r2 = 1
            goto L_0x07a3
        L_0x079f:
            r8[r13] = r4
            r2 = 1
            int r13 = r13 + r2
        L_0x07a3:
            int r6 = r15.level
            if (r6 <= r14) goto L_0x07a9
        L_0x07a7:
            r6 = r4
            goto L_0x07ae
        L_0x07a9:
            r14 = -128(0xffffffffffffff80, float:NaN)
            if (r6 >= r14) goto L_0x07ae
            goto L_0x07a7
        L_0x07ae:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            byte r6 = java.lang.Byte.parseByte(r6)
            r8[r13] = r6
            int r13 = r13 + r2
            if (r3 == 0) goto L_0x07d1
            r19 = r5
            long r4 = r15.timestamp
            long r4 = r10 - r4
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r17
            r17 = 1
            long r4 = r4 + r17
            int r4 = (int) r4
            if (r4 >= 0) goto L_0x07ce
            goto L_0x07d3
        L_0x07ce:
            r2 = r19
            goto L_0x07d6
        L_0x07d1:
            r19 = r5
        L_0x07d3:
            r2 = r19
            r4 = 0
        L_0x07d6:
            byte[] r4 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r2)
            int r5 = r4.length
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r8, r13, r5)
            int r4 = r4.length
            int r13 = r13 + r4
            int r4 = r15.frequency
            byte[] r4 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r2)
            int r5 = r4.length
            java.lang.System.arraycopy(r4, r6, r8, r13, r5)
            int r4 = r4.length
            int r13 = r13 + r4
            int r12 = r12 + 1
            r5 = r2
            r4 = r6
            r2 = 2
            r6 = 4
            r14 = 127(0x7f, float:1.78E-43)
            goto L_0x0775
        L_0x07f7:
            r6 = r4
            r2 = r5
            java.lang.String r3 = r1.H
            int r3 = java.lang.Integer.parseInt(r3)
            byte[] r3 = com.amap.api.col.n3.lu.a((int) r3, (byte[]) r2)
            int r4 = r3.length
            java.lang.System.arraycopy(r3, r6, r8, r13, r4)
            int r3 = r3.length
            int r12 = r13 + r3
        L_0x080a:
            r8[r12] = r6
            r3 = 1
            int r12 = r12 + r3
            java.lang.String r3 = r1.I     // Catch:{ Throwable -> 0x0831 }
            java.lang.String r4 = "GBK"
            byte[] r10 = r3.getBytes(r4)     // Catch:{ Throwable -> 0x0831 }
            int r3 = r10.length     // Catch:{ Throwable -> 0x0831 }
            r4 = 127(0x7f, float:1.78E-43)
            if (r3 <= r4) goto L_0x081c
            r10 = 0
        L_0x081c:
            if (r10 != 0) goto L_0x0823
            r3 = 0
            r8[r12] = r3     // Catch:{ Throwable -> 0x0831 }
            r3 = 1
            goto L_0x0835
        L_0x0823:
            int r3 = r10.length     // Catch:{ Throwable -> 0x0831 }
            byte r3 = (byte) r3     // Catch:{ Throwable -> 0x0831 }
            r8[r12] = r3     // Catch:{ Throwable -> 0x0831 }
            int r12 = r12 + 1
            int r3 = r10.length     // Catch:{ Throwable -> 0x0831 }
            r4 = 0
            java.lang.System.arraycopy(r10, r4, r8, r12, r3)     // Catch:{ Throwable -> 0x0831 }
            int r3 = r10.length     // Catch:{ Throwable -> 0x0831 }
            int r12 = r12 + r3
            goto L_0x0836
        L_0x0831:
            r3 = 0
            r8[r12] = r3
            r3 = 1
        L_0x0835:
            int r12 = r12 + r3
        L_0x0836:
            r3 = 2
            byte[] r4 = new byte[r3]
            r4 = {0, 0} // fill-array
            java.lang.String r3 = r1.L     // Catch:{ Throwable -> 0x0869 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x0869 }
            if (r3 != 0) goto L_0x084e
            java.lang.String r4 = r1.L     // Catch:{ Throwable -> 0x0869 }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x0869 }
            byte[] r4 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r2)     // Catch:{ Throwable -> 0x0869 }
        L_0x084e:
            r5 = 0
            r6 = 2
            java.lang.System.arraycopy(r4, r5, r8, r12, r6)     // Catch:{ Throwable -> 0x0867 }
            int r12 = r12 + r6
            if (r3 != 0) goto L_0x0865
            java.lang.String r3 = r1.L     // Catch:{ Throwable -> 0x0865 }
            java.lang.String r4 = "GBK"
            byte[] r3 = r3.getBytes(r4)     // Catch:{ Throwable -> 0x0865 }
            int r4 = r3.length     // Catch:{ Throwable -> 0x0865 }
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r8, r12, r4)     // Catch:{ Throwable -> 0x0865 }
            int r3 = r3.length     // Catch:{ Throwable -> 0x0865 }
            int r12 = r12 + r3
        L_0x0865:
            r3 = 2
            goto L_0x086b
        L_0x0867:
            r3 = r6
            goto L_0x086a
        L_0x0869:
            r3 = 2
        L_0x086a:
            int r12 = r12 + r3
        L_0x086b:
            java.util.ArrayList<com.amap.api.col.n3.li> r4 = r1.G
            int r5 = r4.size()
            r6 = 65536(0x10000, float:9.18355E-41)
            int r5 = java.lang.Math.min(r5, r6)
            byte[] r6 = new byte[r3]
            r6 = {0, 0} // fill-array
            if (r5 != 0) goto L_0x0889
            r6 = 0
            byte[] r2 = com.amap.api.col.n3.lu.a((int) r6, (byte[]) r2)     // Catch:{ Throwable -> 0x0886 }
            java.lang.System.arraycopy(r2, r6, r8, r12, r3)     // Catch:{ Throwable -> 0x0886 }
        L_0x0886:
            int r12 = r12 + r3
            goto L_0x092c
        L_0x0889:
            r6 = 0
            byte[] r2 = com.amap.api.col.n3.lu.a((int) r5, (byte[]) r2)     // Catch:{ Throwable -> 0x0891 }
            java.lang.System.arraycopy(r2, r6, r8, r12, r3)     // Catch:{ Throwable -> 0x0891 }
        L_0x0891:
            int r12 = r12 + r3
            r2 = 0
        L_0x0893:
            if (r2 >= r5) goto L_0x092c
            java.lang.Object r3 = r4.get(r2)
            com.amap.api.col.n3.li r3 = (com.amap.api.col.n3.li) r3
            byte[] r6 = r3.c     // Catch:{ Throwable -> 0x08a5 }
            int r7 = r6.length     // Catch:{ Throwable -> 0x08a5 }
            r9 = 0
            java.lang.System.arraycopy(r6, r9, r8, r12, r7)     // Catch:{ Throwable -> 0x08a5 }
            int r6 = r6.length     // Catch:{ Throwable -> 0x08a5 }
            int r12 = r12 + r6
            goto L_0x08a7
        L_0x08a5:
            int r12 = r12 + 6
        L_0x08a7:
            java.lang.String r6 = r3.a     // Catch:{ Throwable -> 0x08bb }
            java.lang.String r7 = "GBK"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Throwable -> 0x08bb }
            int r7 = r6.length     // Catch:{ Throwable -> 0x08bb }
            r9 = 32
            if (r7 <= r9) goto L_0x08b6
        L_0x08b4:
            r7 = 0
            goto L_0x08b8
        L_0x08b6:
            int r9 = r6.length     // Catch:{ Throwable -> 0x08bb }
            goto L_0x08b4
        L_0x08b8:
            java.lang.System.arraycopy(r6, r7, r8, r12, r9)     // Catch:{ Throwable -> 0x08bb }
        L_0x08bb:
            int r12 = r12 + 32
            r6 = 4
            byte[] r7 = new byte[r6]     // Catch:{ Throwable -> 0x08d0 }
            r7 = {0, 0, 0, 0} // fill-array     // Catch:{ Throwable -> 0x08d0 }
            java.lang.String r6 = r3.d     // Catch:{ Throwable -> 0x08d0 }
            java.lang.String r7 = "GBK"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Throwable -> 0x08d0 }
            int r7 = r6.length     // Catch:{ Throwable -> 0x08d0 }
            r9 = 0
            java.lang.System.arraycopy(r6, r9, r8, r12, r7)     // Catch:{ Throwable -> 0x08d0 }
        L_0x08d0:
            int r12 = r12 + 4
            r6 = 4
            byte[] r7 = new byte[r6]     // Catch:{ Throwable -> 0x08e5 }
            r7 = {0, 0, 0, 0} // fill-array     // Catch:{ Throwable -> 0x08e5 }
            java.lang.String r6 = r3.e     // Catch:{ Throwable -> 0x08e5 }
            java.lang.String r7 = "GBK"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Throwable -> 0x08e5 }
            int r7 = r6.length     // Catch:{ Throwable -> 0x08e5 }
            r9 = 0
            java.lang.System.arraycopy(r6, r9, r8, r12, r7)     // Catch:{ Throwable -> 0x08e5 }
        L_0x08e5:
            int r12 = r12 + 4
            int r6 = r3.g     // Catch:{ Throwable -> 0x0902 }
            r7 = 127(0x7f, float:1.78E-43)
            if (r6 <= r7) goto L_0x08f3
            r6 = 0
            r3.g = r6     // Catch:{ Throwable -> 0x0904 }
            r10 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x08fc
        L_0x08f3:
            r6 = 0
            int r9 = r3.g     // Catch:{ Throwable -> 0x0904 }
            r10 = -128(0xffffffffffffff80, float:NaN)
            if (r9 >= r10) goto L_0x08fc
            r3.g = r6     // Catch:{ Throwable -> 0x0906 }
        L_0x08fc:
            int r6 = r3.g     // Catch:{ Throwable -> 0x0906 }
            byte r6 = (byte) r6     // Catch:{ Throwable -> 0x0906 }
            r8[r12] = r6     // Catch:{ Throwable -> 0x0906 }
            goto L_0x0906
        L_0x0902:
            r7 = 127(0x7f, float:1.78E-43)
        L_0x0904:
            r10 = -128(0xffffffffffffff80, float:NaN)
        L_0x0906:
            int r12 = r12 + 1
            r6 = 4
            byte[] r9 = new byte[r6]     // Catch:{ Throwable -> 0x0916 }
            int r6 = r3.f     // Catch:{ Throwable -> 0x0916 }
            byte[] r6 = com.amap.api.col.n3.lu.b((int) r6, (byte[]) r9)     // Catch:{ Throwable -> 0x0916 }
            int r9 = r6.length     // Catch:{ Throwable -> 0x0916 }
            r11 = 0
            java.lang.System.arraycopy(r6, r11, r8, r12, r9)     // Catch:{ Throwable -> 0x0916 }
        L_0x0916:
            int r12 = r12 + 4
            r6 = 4
            byte[] r9 = new byte[r6]     // Catch:{ Throwable -> 0x0926 }
            int r3 = r3.i     // Catch:{ Throwable -> 0x0926 }
            byte[] r3 = com.amap.api.col.n3.lu.b((int) r3, (byte[]) r9)     // Catch:{ Throwable -> 0x0926 }
            int r9 = r3.length     // Catch:{ Throwable -> 0x0926 }
            r11 = 0
            java.lang.System.arraycopy(r3, r11, r8, r12, r9)     // Catch:{ Throwable -> 0x0926 }
        L_0x0926:
            int r12 = r12 + 4
            int r2 = r2 + 1
            goto L_0x0893
        L_0x092c:
            byte[] r2 = r1.J
            if (r2 == 0) goto L_0x0935
            byte[] r2 = r1.J
            int r4 = r2.length
            r2 = 0
            goto L_0x0937
        L_0x0935:
            r2 = 0
            r4 = 0
        L_0x0937:
            byte[] r2 = com.amap.api.col.n3.lu.a((int) r4, (byte[]) r2)
            int r3 = r2.length
            r5 = 0
            java.lang.System.arraycopy(r2, r5, r8, r12, r3)
            int r2 = r2.length
            int r12 = r12 + r2
            if (r4 <= 0) goto L_0x0950
            byte[] r2 = r1.J
            byte[] r3 = r1.J
            int r3 = r3.length
            java.lang.System.arraycopy(r2, r5, r8, r12, r3)
            byte[] r2 = r1.J
            int r2 = r2.length
            int r12 = r12 + r2
        L_0x0950:
            byte[] r2 = new byte[r12]
            java.lang.System.arraycopy(r8, r5, r2, r5, r12)
            java.util.zip.CRC32 r3 = new java.util.zip.CRC32
            r3.<init>()
            r3.update(r2)
            long r3 = r3.getValue()
            byte[] r3 = com.amap.api.col.n3.lu.a((long) r3)
            int r4 = r3.length
            int r4 = r4 + r12
            byte[] r4 = new byte[r4]
            java.lang.System.arraycopy(r2, r5, r4, r5, r12)
            int r2 = r3.length
            java.lang.System.arraycopy(r3, r5, r4, r12, r2)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lq.a():byte[]");
    }
}
