package com.loc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.Hashtable;
import org.json.JSONObject;

/* compiled from: Cache */
public final class ci {
    Hashtable<String, ArrayList<a>> a = new Hashtable<>();
    boolean b = true;
    long c = 0;
    String d = null;
    cc e = null;
    boolean f = true;
    boolean g = true;
    private long h = 0;
    private boolean i = false;
    private String j = "2.0.201501131131".replace(".", "");
    private String k = null;
    private String l = null;
    private long m = 0;

    /* compiled from: Cache */
    static class a {
        private AMapLocationServer a = null;
        private String b = null;

        protected a() {
        }

        public final AMapLocationServer a() {
            return this.a;
        }

        public final void a(AMapLocationServer aMapLocationServer) {
            this.a = aMapLocationServer;
        }

        public final void a(String str) {
            this.b = TextUtils.isEmpty(str) ? null : str.replace("##", "#");
        }

        public final String b() {
            return this.b;
        }
    }

    private AMapLocationServer a(String str, StringBuilder sb) {
        a a2 = (!str.contains("cgiwifi") && !str.contains("wifi")) ? (!str.contains("cgi") || !this.a.containsKey(str)) ? null : (a) this.a.get(str).get(0) : a(sb, str);
        if (a2 != null && da.a(a2.a())) {
            AMapLocationServer a3 = a2.a();
            a3.e("mem");
            a3.g(a2.b());
            if (cr.b(a3.getTime())) {
                if (da.a(a3)) {
                    this.c = 0;
                }
                a3.setLocationType(4);
                return a3;
            } else if (this.a != null && this.a.containsKey(str)) {
                this.a.get(str).remove(a2);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed A[LOOP:1: B:34:0x00e7->B:36:0x00ed, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0107 A[LOOP:2: B:38:0x0101->B:40:0x0107, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0177 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0152 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.loc.ci.a a(java.lang.StringBuilder r26, java.lang.String r27) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.ci$a>> r2 = r0.a
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 != 0) goto L_0x0195
            boolean r2 = android.text.TextUtils.isEmpty(r26)
            if (r2 == 0) goto L_0x0015
            goto L_0x0195
        L_0x0015:
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.ci$a>> r2 = r0.a
            boolean r2 = r2.containsKey(r1)
            if (r2 != 0) goto L_0x001e
            return r3
        L_0x001e:
            java.util.Hashtable r2 = new java.util.Hashtable
            r2.<init>()
            java.util.Hashtable r4 = new java.util.Hashtable
            r4.<init>()
            java.util.Hashtable r5 = new java.util.Hashtable
            r5.<init>()
            java.util.Hashtable<java.lang.String, java.util.ArrayList<com.loc.ci$a>> r6 = r0.a
            java.lang.Object r1 = r6.get(r1)
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r6 = r1.size()
            r7 = 1
            int r6 = r6 - r7
        L_0x003b:
            if (r6 < 0) goto L_0x0189
            java.lang.Object r8 = r1.get(r6)
            com.loc.ci$a r8 = (com.loc.ci.a) r8
            java.lang.String r9 = r8.b()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0182
            java.lang.String r9 = r8.b()
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            r11 = 0
            if (r10 != 0) goto L_0x00b6
            boolean r10 = android.text.TextUtils.isEmpty(r26)
            if (r10 == 0) goto L_0x005f
            goto L_0x00b6
        L_0x005f:
            java.lang.String r10 = ",access"
            boolean r10 = r9.contains(r10)
            if (r10 == 0) goto L_0x00b6
            java.lang.String r10 = ",access"
            r12 = r26
            int r10 = r12.indexOf(r10)
            r13 = -1
            if (r10 != r13) goto L_0x0073
            goto L_0x00b8
        L_0x0073:
            java.lang.String r10 = ",access"
            java.lang.String[] r9 = r9.split(r10)
            r10 = r9[r11]
            java.lang.String r13 = "#"
            boolean r10 = r10.contains(r13)
            if (r10 == 0) goto L_0x0093
            r10 = r9[r11]
            r9 = r9[r11]
            java.lang.String r13 = "#"
            int r9 = r9.lastIndexOf(r13)
            int r9 = r9 + r7
            java.lang.String r9 = r10.substring(r9)
            goto L_0x0095
        L_0x0093:
            r9 = r9[r11]
        L_0x0095:
            boolean r10 = android.text.TextUtils.isEmpty(r9)
            if (r10 == 0) goto L_0x009c
            goto L_0x00b8
        L_0x009c:
            java.lang.String r10 = r26.toString()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r9)
            java.lang.String r9 = ",access"
            r13.append(r9)
            java.lang.String r9 = r13.toString()
            boolean r9 = r10.contains(r9)
            goto L_0x00b9
        L_0x00b6:
            r12 = r26
        L_0x00b8:
            r9 = r11
        L_0x00b9:
            if (r9 == 0) goto L_0x00cd
            java.lang.String r9 = r8.b()
            java.lang.String r10 = r26.toString()
            boolean r9 = com.loc.da.a((java.lang.String) r9, (java.lang.String) r10)
            if (r9 == 0) goto L_0x00cb
            goto L_0x017f
        L_0x00cb:
            r9 = r7
            goto L_0x00ce
        L_0x00cd:
            r9 = r11
        L_0x00ce:
            java.lang.String r10 = r8.b()
            a((java.lang.String) r10, (java.util.Hashtable<java.lang.String, java.lang.String>) r2)
            java.lang.String r10 = r26.toString()
            a((java.lang.String) r10, (java.util.Hashtable<java.lang.String, java.lang.String>) r4)
            r5.clear()
            java.util.Set r10 = r2.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x00e7:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x00f9
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = ""
            r5.put(r13, r14)
            goto L_0x00e7
        L_0x00f9:
            java.util.Set r10 = r4.keySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0101:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x0113
            java.lang.Object r13 = r10.next()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r14 = ""
            r5.put(r13, r14)
            goto L_0x0101
        L_0x0113:
            java.util.Set r10 = r5.keySet()
            int r13 = r10.size()
            double[] r13 = new double[r13]
            int r14 = r10.size()
            double[] r14 = new double[r14]
            java.util.Iterator r15 = r10.iterator()
            r16 = r11
        L_0x0129:
            if (r15 == 0) goto L_0x0158
            boolean r17 = r15.hasNext()
            if (r17 == 0) goto L_0x0158
            java.lang.Object r17 = r15.next()
            r3 = r17
            java.lang.String r3 = (java.lang.String) r3
            boolean r17 = r2.containsKey(r3)
            r19 = 0
            r21 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r17 == 0) goto L_0x0146
            r23 = r21
            goto L_0x0148
        L_0x0146:
            r23 = r19
        L_0x0148:
            r13[r16] = r23
            boolean r3 = r4.containsKey(r3)
            if (r3 == 0) goto L_0x0152
            r19 = r21
        L_0x0152:
            r14[r16] = r19
            int r16 = r16 + 1
            r3 = 0
            goto L_0x0129
        L_0x0158:
            r10.clear()
            double[] r3 = a((double[]) r13, (double[]) r14)
            r13 = r3[r11]
            r15 = 4605380979056443392(0x3fe99999a0000000, double:0.800000011920929)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x016b
            goto L_0x017f
        L_0x016b:
            r13 = r3[r7]
            r15 = 4603741668684706349(0x3fe3c6a7ef9db22d, double:0.618)
            int r10 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r10 < 0) goto L_0x0177
            goto L_0x017f
        L_0x0177:
            if (r9 == 0) goto L_0x0184
            r9 = r3[r11]
            int r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r3 < 0) goto L_0x0184
        L_0x017f:
            r18 = r8
            goto L_0x018b
        L_0x0182:
            r12 = r26
        L_0x0184:
            int r6 = r6 + -1
            r3 = 0
            goto L_0x003b
        L_0x0189:
            r18 = 0
        L_0x018b:
            r2.clear()
            r4.clear()
            r5.clear()
            return r18
        L_0x0195:
            r1 = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ci.a(java.lang.StringBuilder, java.lang.String):com.loc.ci$a");
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r6, java.lang.StringBuilder r7, android.content.Context r8) {
        /*
            r5 = this;
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = r5.k     // Catch:{  }
            if (r2 != 0) goto L_0x0019
            java.lang.String r2 = "MD5"
            java.lang.String r8 = com.loc.k.c((android.content.Context) r8)     // Catch:{  }
            java.lang.String r8 = com.loc.ch.a((java.lang.String) r2, (java.lang.String) r8)     // Catch:{  }
            r5.k = r8     // Catch:{  }
        L_0x0019:
            java.lang.String r8 = "&"
            boolean r8 = r6.contains(r8)     // Catch:{  }
            r2 = 0
            if (r8 == 0) goto L_0x002c
            java.lang.String r8 = "&"
            int r8 = r6.indexOf(r8)     // Catch:{  }
            java.lang.String r6 = r6.substring(r2, r8)     // Catch:{  }
        L_0x002c:
            java.lang.String r8 = "#"
            int r8 = r6.lastIndexOf(r8)     // Catch:{  }
            int r8 = r8 + 1
            java.lang.String r8 = r6.substring(r8)     // Catch:{  }
            java.lang.String r3 = "cgi"
            boolean r3 = r8.equals(r3)     // Catch:{  }
            if (r3 == 0) goto L_0x0050
            java.lang.String r7 = "cgi"
            int r8 = r6.length()     // Catch:{  }
            int r8 = r8 + -12
            java.lang.String r6 = r6.substring(r2, r8)     // Catch:{  }
        L_0x004c:
            r1.put(r7, r6)     // Catch:{  }
            goto L_0x009e
        L_0x0050:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{  }
            if (r3 != 0) goto L_0x009e
            java.lang.String r3 = "access"
            int r3 = r7.indexOf(r3)     // Catch:{  }
            r4 = -1
            if (r3 == r4) goto L_0x009e
            r3 = 9
            int r8 = r8.length()     // Catch:{  }
            int r3 = r3 + r8
            int r8 = r6.length()     // Catch:{  }
            int r8 = r8 - r3
            java.lang.String r6 = r6.substring(r2, r8)     // Catch:{  }
            java.lang.String r8 = "cgi"
            r1.put(r8, r6)     // Catch:{  }
            java.lang.String r6 = r7.toString()     // Catch:{  }
            java.lang.String r7 = ",access"
            java.lang.String[] r6 = r6.split(r7)     // Catch:{  }
            r7 = r6[r2]     // Catch:{  }
            java.lang.String r8 = "#"
            boolean r7 = r7.contains(r8)     // Catch:{  }
            if (r7 == 0) goto L_0x0099
            r7 = r6[r2]     // Catch:{  }
            r6 = r6[r2]     // Catch:{  }
            java.lang.String r8 = "#"
            int r6 = r6.lastIndexOf(r8)     // Catch:{  }
            int r6 = r6 + 1
            java.lang.String r6 = r7.substring(r6)     // Catch:{  }
            goto L_0x009b
        L_0x0099:
            r6 = r6[r2]     // Catch:{  }
        L_0x009b:
            java.lang.String r7 = "mmac"
            goto L_0x004c
        L_0x009e:
            java.lang.String r6 = r1.toString()     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r7 = "UTF-8"
            byte[] r6 = r6.getBytes(r7)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r7 = r5.k     // Catch:{ Throwable -> 0x00b3 }
            byte[] r6 = com.loc.ch.c(r6, r7)     // Catch:{ Throwable -> 0x00b3 }
            java.lang.String r6 = com.loc.o.a((byte[]) r6)     // Catch:{  }
            return r6
        L_0x00b3:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ci.a(java.lang.String, java.lang.StringBuilder, android.content.Context):java.lang.String");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.sqlite.SQLiteDatabase$CursorFactory, java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103 A[Catch:{ Throwable -> 0x0075, Throwable -> 0x027e }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02a0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r11, java.lang.String r12) throws java.lang.Exception {
        /*
            r10 = this;
            boolean r0 = com.loc.cr.u()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            if (r11 != 0) goto L_0x000a
            return
        L_0x000a:
            r0 = 0
            java.lang.String r1 = "hmdb"
            r2 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.openOrCreateDatabase(r1, r2, r0)     // Catch:{ Throwable -> 0x0283, all -> 0x0280 }
            java.lang.String r3 = "hist"
            boolean r3 = com.loc.da.a((android.database.sqlite.SQLiteDatabase) r1, (java.lang.String) r3)     // Catch:{ Throwable -> 0x027e }
            if (r3 != 0) goto L_0x0026
            if (r1 == 0) goto L_0x0025
            boolean r11 = r1.isOpen()     // Catch:{ Throwable -> 0x027e }
            if (r11 == 0) goto L_0x0025
            r1.close()     // Catch:{ Throwable -> 0x027e }
        L_0x0025:
            return
        L_0x0026:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r3.<init>()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = "SELECT feature, nb, loc FROM "
            r3.append(r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = "hist"
            r3.append(r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = r10.j     // Catch:{ Throwable -> 0x027e }
            r3.append(r4)     // Catch:{ Throwable -> 0x027e }
            long r4 = com.loc.da.a()     // Catch:{ Throwable -> 0x027e }
            long r6 = com.loc.cr.t()     // Catch:{ Throwable -> 0x027e }
            long r4 = r4 - r6
            java.lang.String r6 = " WHERE time > "
            r3.append(r6)     // Catch:{ Throwable -> 0x027e }
            r3.append(r4)     // Catch:{ Throwable -> 0x027e }
            if (r12 == 0) goto L_0x0066
            java.lang.String r4 = " and feature = '"
            r3.append(r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r4.<init>()     // Catch:{ Throwable -> 0x027e }
            r4.append(r12)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r12 = "'"
            r4.append(r12)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r12 = r4.toString()     // Catch:{ Throwable -> 0x027e }
            r3.append(r12)     // Catch:{ Throwable -> 0x027e }
        L_0x0066:
            java.lang.String r12 = " ORDER BY time ASC;"
            r3.append(r12)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r12 = r3.toString()     // Catch:{ Throwable -> 0x0075 }
            android.database.Cursor r12 = r1.rawQuery(r12, r0)     // Catch:{ Throwable -> 0x0075 }
            r0 = r12
            goto L_0x008c
        L_0x0075:
            r12 = move-exception
            java.lang.String r4 = "DB"
            java.lang.String r5 = "fetchHist"
            com.loc.cs.a(r12, r4, r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r12 = r12.getMessage()     // Catch:{ Throwable -> 0x027e }
            boolean r4 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x027e }
            if (r4 != 0) goto L_0x008c
            java.lang.String r4 = "no such table"
            r12.contains(r4)     // Catch:{ Throwable -> 0x027e }
        L_0x008c:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r12.<init>()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = r10.k     // Catch:{ Throwable -> 0x027e }
            if (r4 != 0) goto L_0x00a1
            java.lang.String r4 = "MD5"
            java.lang.String r5 = com.loc.k.c((android.content.Context) r11)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = com.loc.ch.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x027e }
            r10.k = r4     // Catch:{ Throwable -> 0x027e }
        L_0x00a1:
            if (r0 == 0) goto L_0x026d
            boolean r4 = r0.moveToFirst()     // Catch:{ Throwable -> 0x027e }
            if (r4 == 0) goto L_0x026d
        L_0x00a9:
            java.lang.String r4 = r0.getString(r2)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "{"
            boolean r4 = r4.startsWith(r5)     // Catch:{ Throwable -> 0x027e }
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x010c
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Throwable -> 0x027e }
            java.lang.String r7 = r0.getString(r2)     // Catch:{ Throwable -> 0x027e }
            r4.<init>(r7)     // Catch:{ Throwable -> 0x027e }
            int r7 = r12.length()     // Catch:{ Throwable -> 0x027e }
            r12.delete(r2, r7)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r7 = r0.getString(r6)     // Catch:{ Throwable -> 0x027e }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x027e }
            if (r7 != 0) goto L_0x00d9
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Throwable -> 0x027e }
        L_0x00d5:
            r12.append(r6)     // Catch:{ Throwable -> 0x027e }
            goto L_0x00f2
        L_0x00d9:
            java.lang.String r6 = "mmac"
            boolean r6 = com.loc.da.a((org.json.JSONObject) r4, (java.lang.String) r6)     // Catch:{ Throwable -> 0x027e }
            if (r6 == 0) goto L_0x00f2
            java.lang.String r6 = "#"
            r12.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "mmac"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x027e }
            r12.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = ",access"
            goto L_0x00d5
        L_0x00f2:
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Throwable -> 0x027e }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "type"
            boolean r5 = com.loc.da.a((org.json.JSONObject) r6, (java.lang.String) r5)     // Catch:{ Throwable -> 0x027e }
            if (r5 == 0) goto L_0x0195
            java.lang.String r5 = "type"
            java.lang.String r7 = "new"
            r6.put(r5, r7)     // Catch:{ Throwable -> 0x027e }
            goto L_0x0195
        L_0x010c:
            java.lang.String r4 = r0.getString(r2)     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.o.b((java.lang.String) r4)     // Catch:{ Throwable -> 0x027e }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Throwable -> 0x027e }
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x027e }
            java.lang.String r9 = r10.k     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.ch.d(r4, r9)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r9 = "UTF-8"
            r8.<init>(r4, r9)     // Catch:{ Throwable -> 0x027e }
            r7.<init>(r8)     // Catch:{ Throwable -> 0x027e }
            int r4 = r12.length()     // Catch:{ Throwable -> 0x027e }
            r12.delete(r2, r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = r0.getString(r6)     // Catch:{ Throwable -> 0x027e }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x027e }
            if (r4 != 0) goto L_0x0150
            java.lang.String r4 = r0.getString(r6)     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.o.b((java.lang.String) r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = new java.lang.String     // Catch:{ Throwable -> 0x027e }
            java.lang.String r8 = r10.k     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.ch.d(r4, r8)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r8 = "UTF-8"
            r6.<init>(r4, r8)     // Catch:{ Throwable -> 0x027e }
            r12.append(r6)     // Catch:{ Throwable -> 0x027e }
            goto L_0x016b
        L_0x0150:
            java.lang.String r4 = "mmac"
            boolean r4 = com.loc.da.a((org.json.JSONObject) r7, (java.lang.String) r4)     // Catch:{ Throwable -> 0x027e }
            if (r4 == 0) goto L_0x016b
            java.lang.String r4 = "#"
            r12.append(r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = "mmac"
            java.lang.String r4 = r7.getString(r4)     // Catch:{ Throwable -> 0x027e }
            r12.append(r4)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = ",access"
            r12.append(r4)     // Catch:{ Throwable -> 0x027e }
        L_0x016b:
            java.lang.String r4 = r0.getString(r5)     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.o.b((java.lang.String) r4)     // Catch:{ Throwable -> 0x027e }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x027e }
            java.lang.String r8 = r10.k     // Catch:{ Throwable -> 0x027e }
            byte[] r4 = com.loc.ch.d(r4, r8)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r8 = "UTF-8"
            r5.<init>(r4, r8)     // Catch:{ Throwable -> 0x027e }
            r6.<init>(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r4 = "type"
            boolean r4 = com.loc.da.a((org.json.JSONObject) r6, (java.lang.String) r4)     // Catch:{ Throwable -> 0x027e }
            if (r4 == 0) goto L_0x0194
            java.lang.String r4 = "type"
            java.lang.String r5 = "new"
            r6.put(r4, r5)     // Catch:{ Throwable -> 0x027e }
        L_0x0194:
            r4 = r7
        L_0x0195:
            com.autonavi.aps.amapapi.model.AMapLocationServer r7 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = ""
            r7.<init>(r5)     // Catch:{ Throwable -> 0x027e }
            r7.b((org.json.JSONObject) r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "mmac"
            boolean r5 = com.loc.da.a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x027e }
            if (r5 == 0) goto L_0x0206
            java.lang.String r5 = "cgi"
            boolean r5 = com.loc.da.a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x027e }
            if (r5 == 0) goto L_0x0206
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r5.<init>()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "cgi"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x027e }
            r5.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "#"
            r5.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x027e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r6.<init>()     // Catch:{ Throwable -> 0x027e }
            r6.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "network#"
            r6.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = r6.toString()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "cgi"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "#"
            boolean r4 = r4.contains(r6)     // Catch:{ Throwable -> 0x027e }
            if (r4 == 0) goto L_0x01f8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r4.<init>()     // Catch:{ Throwable -> 0x027e }
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "cgiwifi"
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
        L_0x01f2:
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x027e }
            r5 = r4
            goto L_0x0252
        L_0x01f8:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r4.<init>()     // Catch:{ Throwable -> 0x027e }
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "wifi"
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
            goto L_0x01f2
        L_0x0206:
            java.lang.String r5 = "cgi"
            boolean r5 = com.loc.da.a((org.json.JSONObject) r4, (java.lang.String) r5)     // Catch:{ Throwable -> 0x027e }
            if (r5 == 0) goto L_0x0259
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r5.<init>()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "cgi"
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Throwable -> 0x027e }
            r5.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "#"
            r5.append(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x027e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r6.<init>()     // Catch:{ Throwable -> 0x027e }
            r6.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "network#"
            r6.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = r6.toString()     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "cgi"
            java.lang.String r4 = r4.getString(r6)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r6 = "#"
            boolean r4 = r4.contains(r6)     // Catch:{ Throwable -> 0x027e }
            if (r4 == 0) goto L_0x0259
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x027e }
            r4.<init>()     // Catch:{ Throwable -> 0x027e }
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
            java.lang.String r5 = "cgi"
            r4.append(r5)     // Catch:{ Throwable -> 0x027e }
            goto L_0x01f2
        L_0x0252:
            r9 = 0
            r4 = r10
            r6 = r12
            r8 = r11
            r4.a(r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x027e }
        L_0x0259:
            boolean r4 = r0.moveToNext()     // Catch:{ Throwable -> 0x027e }
            if (r4 != 0) goto L_0x00a9
            int r11 = r12.length()     // Catch:{ Throwable -> 0x027e }
            r12.delete(r2, r11)     // Catch:{ Throwable -> 0x027e }
            int r11 = r3.length()     // Catch:{ Throwable -> 0x027e }
            r3.delete(r2, r11)     // Catch:{ Throwable -> 0x027e }
        L_0x026d:
            if (r0 == 0) goto L_0x0272
            r0.close()
        L_0x0272:
            if (r1 == 0) goto L_0x027d
            boolean r11 = r1.isOpen()
            if (r11 == 0) goto L_0x027d
            r1.close()
        L_0x027d:
            return
        L_0x027e:
            r11 = move-exception
            goto L_0x0285
        L_0x0280:
            r11 = move-exception
            r1 = r0
            goto L_0x029e
        L_0x0283:
            r11 = move-exception
            r1 = r0
        L_0x0285:
            java.lang.String r12 = "DB"
            java.lang.String r2 = "fetchHist p2"
            com.loc.cs.a(r11, r12, r2)     // Catch:{ all -> 0x029d }
            if (r0 == 0) goto L_0x0291
            r0.close()
        L_0x0291:
            if (r1 == 0) goto L_0x029c
            boolean r11 = r1.isOpen()
            if (r11 == 0) goto L_0x029c
            r1.close()
        L_0x029c:
            return
        L_0x029d:
            r11 = move-exception
        L_0x029e:
            if (r0 == 0) goto L_0x02a3
            r0.close()
        L_0x02a3:
            if (r1 == 0) goto L_0x02ae
            boolean r12 = r1.isOpen()
            if (r12 == 0) goto L_0x02ae
            r1.close()
        L_0x02ae:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ci.a(android.content.Context, java.lang.String):void");
    }

    private void a(String str, AMapLocation aMapLocation, StringBuilder sb, Context context) throws Exception {
        if (context != null) {
            if (this.k == null) {
                this.k = ch.a("MD5", k.c(context));
            }
            String a2 = a(str, sb, context);
            StringBuilder sb2 = new StringBuilder();
            SQLiteDatabase sQLiteDatabase = null;
            try {
                SQLiteDatabase sQLiteDatabase2 = context.openOrCreateDatabase("hmdb", 0, (SQLiteDatabase.CursorFactory) null);
                try {
                    sb2.append("CREATE TABLE IF NOT EXISTS hist");
                    sb2.append(this.j);
                    sb2.append(" (feature VARCHAR PRIMARY KEY, nb VARCHAR, loc VARCHAR, time VARCHAR);");
                    sQLiteDatabase2.execSQL(sb2.toString());
                    sb2.delete(0, sb2.length());
                    sb2.append("REPLACE INTO ");
                    sb2.append("hist");
                    sb2.append(this.j);
                    sb2.append(" VALUES (?, ?, ?, ?)");
                    Object[] objArr = {a2, ch.c(sb.toString().getBytes("UTF-8"), this.k), ch.c(aMapLocation.toStr().getBytes("UTF-8"), this.k), Long.valueOf(aMapLocation.getTime())};
                    for (int i2 = 1; i2 < objArr.length - 1; i2++) {
                        objArr[i2] = o.a((byte[]) objArr[i2]);
                    }
                    sQLiteDatabase2.execSQL(sb2.toString(), objArr);
                    sb2.delete(0, sb2.length());
                    sb2.delete(0, sb2.length());
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    sb2.delete(0, sb2.length());
                    if (sQLiteDatabase2 != null && sQLiteDatabase2.isOpen()) {
                        sQLiteDatabase2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cs.a(th, "DB", "updateHist");
                sb2.delete(0, sb2.length());
                if (sQLiteDatabase != null) {
                }
            }
        }
    }

    private static void a(String str, Hashtable<String, String> hashtable) {
        if (!TextUtils.isEmpty(str)) {
            hashtable.clear();
            for (String str2 : str.split("#")) {
                if (!TextUtils.isEmpty(str2) && !str2.contains("|")) {
                    hashtable.put(str2, "");
                }
            }
        }
    }

    private static double[] a(double[] dArr, double[] dArr2) {
        double[] dArr3 = dArr;
        double[] dArr4 = new double[3];
        double d2 = 0.0d;
        double d3 = 0.0d;
        double d4 = 0.0d;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < dArr3.length; i4++) {
            d2 += dArr3[i4] * dArr3[i4];
            d3 += dArr2[i4] * dArr2[i4];
            d4 += dArr3[i4] * dArr2[i4];
            if (dArr2[i4] == 1.0d) {
                i3++;
                if (dArr3[i4] == 1.0d) {
                    i2++;
                }
            }
        }
        dArr4[0] = d4 / (Math.sqrt(d2) * Math.sqrt(d3));
        double d5 = (double) i2;
        dArr4[1] = (1.0d * d5) / ((double) i3);
        dArr4[2] = d5;
        for (int i5 = 0; i5 < dArr4.length - 1; i5++) {
            if (dArr4[i5] > 1.0d) {
                dArr4[i5] = 1.0d;
            }
        }
        return dArr4;
    }

    private boolean b() {
        return this.h != 0 && (this.a.size() > 360 || da.b() - this.h > 36000000);
    }

    private void c() {
        this.h = 0;
        if (!this.a.isEmpty()) {
            this.a.clear();
        }
        this.i = false;
    }

    public final AMapLocationServer a(Context context, String str, StringBuilder sb, boolean z) {
        if (TextUtils.isEmpty(str) || !cr.u()) {
            return null;
        }
        String str2 = str + "&" + this.f + "&" + this.g;
        if (str2.contains(GeocodeSearch.GPS) || !cr.u() || sb == null) {
            return null;
        }
        if (b()) {
            c();
            return null;
        }
        if (z && !this.i) {
            try {
                String a2 = a(str2, sb, context);
                c();
                a(context, a2);
            } catch (Throwable unused) {
            }
        }
        if (this.a.isEmpty()) {
            return null;
        }
        return a(str2, sb);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0048 A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0066 A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009e A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5 A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ce A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3 A[Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00dc A[ADDED_TO_REGION, Catch:{ Throwable -> 0x00fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ea A[Catch:{ Throwable -> 0x00fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer a(com.loc.cd r17, boolean r18, com.autonavi.aps.amapapi.model.AMapLocationServer r19, com.loc.cg r20, java.lang.StringBuilder r21, java.lang.String r22, android.content.Context r23) {
        /*
            r16 = this;
            r0 = r16
            r2 = r19
            r3 = r22
            boolean r4 = r0.b
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0015
            boolean r4 = com.loc.cr.u()
            if (r4 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r4 = r5
            goto L_0x0016
        L_0x0015:
            r4 = r6
        L_0x0016:
            if (r4 != 0) goto L_0x001a
        L_0x0018:
            r4 = r6
            goto L_0x0028
        L_0x001a:
            if (r2 == 0) goto L_0x0027
            long r7 = r19.getTime()
            boolean r4 = com.loc.cr.b((long) r7)
            if (r4 != 0) goto L_0x0027
            goto L_0x0018
        L_0x0027:
            r4 = r5
        L_0x0028:
            r7 = 0
            if (r4 != 0) goto L_0x002c
            return r7
        L_0x002c:
            com.loc.cc r4 = r17.c()     // Catch:{ Throwable -> 0x00fd }
            if (r4 != 0) goto L_0x0036
            com.loc.cc r8 = r0.e     // Catch:{ Throwable -> 0x00fd }
            if (r8 == 0) goto L_0x0043
        L_0x0036:
            com.loc.cc r8 = r0.e     // Catch:{ Throwable -> 0x00fd }
            if (r8 == 0) goto L_0x0045
            com.loc.cc r8 = r0.e     // Catch:{ Throwable -> 0x00fd }
            boolean r4 = r8.a(r4)     // Catch:{ Throwable -> 0x00fd }
            if (r4 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r4 = r6
            goto L_0x0046
        L_0x0045:
            r4 = r5
        L_0x0046:
            if (r2 == 0) goto L_0x005f
            java.util.ArrayList r8 = r20.b()     // Catch:{ Throwable -> 0x00fd }
            int r8 = r8.size()     // Catch:{ Throwable -> 0x00fd }
            float r9 = r19.getAccuracy()     // Catch:{ Throwable -> 0x00fd }
            r10 = 1133871104(0x43958000, float:299.0)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x005f
            r9 = 5
            if (r8 <= r9) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r5 = r6
        L_0x0060:
            r8 = 3000(0xbb8, double:1.482E-320)
            r10 = 0
            if (r2 == 0) goto L_0x009b
            java.lang.String r12 = r0.d     // Catch:{ Throwable -> 0x00fd }
            if (r12 == 0) goto L_0x009b
            if (r5 != 0) goto L_0x009b
            if (r4 != 0) goto L_0x009b
            java.lang.String r4 = r0.d     // Catch:{ Throwable -> 0x00fd }
            java.lang.String r12 = r21.toString()     // Catch:{ Throwable -> 0x00fd }
            boolean r4 = com.loc.da.a((java.lang.String) r4, (java.lang.String) r12)     // Catch:{ Throwable -> 0x00fd }
            if (r4 != 0) goto L_0x008b
            long r12 = r0.c     // Catch:{ Throwable -> 0x00fd }
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 == 0) goto L_0x009c
            long r12 = com.loc.da.b()     // Catch:{ Throwable -> 0x00fd }
            long r14 = r0.c     // Catch:{ Throwable -> 0x00fd }
            long r12 = r12 - r14
            int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x009c
        L_0x008b:
            boolean r12 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r19)     // Catch:{ Throwable -> 0x00fd }
            if (r12 == 0) goto L_0x009c
            java.lang.String r1 = "mem"
            r2.e(r1)     // Catch:{ Throwable -> 0x00fd }
            r1 = 2
            r2.setLocationType(r1)     // Catch:{ Throwable -> 0x00fd }
            return r2
        L_0x009b:
            r4 = r6
        L_0x009c:
            if (r4 != 0) goto L_0x00a5
            long r12 = com.loc.da.b()     // Catch:{ Throwable -> 0x00fd }
            r0.c = r12     // Catch:{ Throwable -> 0x00fd }
            goto L_0x00a7
        L_0x00a5:
            r0.c = r10     // Catch:{ Throwable -> 0x00fd }
        L_0x00a7:
            java.lang.String r2 = r0.l     // Catch:{ Throwable -> 0x00fd }
            if (r2 == 0) goto L_0x00ca
            java.lang.String r2 = r0.l     // Catch:{ Throwable -> 0x00fd }
            boolean r2 = r3.equals(r2)     // Catch:{ Throwable -> 0x00fd }
            if (r2 != 0) goto L_0x00ca
            long r12 = com.loc.da.a()     // Catch:{ Throwable -> 0x00fd }
            long r14 = r0.m     // Catch:{ Throwable -> 0x00fd }
            long r12 = r12 - r14
            int r2 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r2 >= 0) goto L_0x00c1
            java.lang.String r2 = r0.l     // Catch:{ Throwable -> 0x00fd }
            goto L_0x00da
        L_0x00c1:
            long r8 = com.loc.da.a()     // Catch:{ Throwable -> 0x00fd }
        L_0x00c5:
            r0.m = r8     // Catch:{ Throwable -> 0x00fd }
            r0.l = r3     // Catch:{ Throwable -> 0x00fd }
            goto L_0x00d9
        L_0x00ca:
            java.lang.String r2 = r0.l     // Catch:{ Throwable -> 0x00fd }
            if (r2 != 0) goto L_0x00d3
            long r8 = com.loc.da.a()     // Catch:{ Throwable -> 0x00fd }
            goto L_0x00c5
        L_0x00d3:
            long r8 = com.loc.da.a()     // Catch:{ Throwable -> 0x00fd }
            r0.m = r8     // Catch:{ Throwable -> 0x00fd }
        L_0x00d9:
            r2 = r3
        L_0x00da:
            if (r5 != 0) goto L_0x00e7
            if (r18 != 0) goto L_0x00e7
            r3 = r21
            r4 = r23
            com.autonavi.aps.amapapi.model.AMapLocationServer r2 = r0.a((android.content.Context) r4, (java.lang.String) r2, (java.lang.StringBuilder) r3, (boolean) r6)     // Catch:{ Throwable -> 0x00fd }
            goto L_0x00e8
        L_0x00e7:
            r2 = r7
        L_0x00e8:
            if (r18 != 0) goto L_0x00f0
            boolean r3 = com.loc.da.a((com.autonavi.aps.amapapi.model.AMapLocationServer) r2)     // Catch:{ Throwable -> 0x00fd }
            if (r3 == 0) goto L_0x00f2
        L_0x00f0:
            if (r5 == 0) goto L_0x00f3
        L_0x00f2:
            return r7
        L_0x00f3:
            if (r18 == 0) goto L_0x00f6
            return r7
        L_0x00f6:
            r0.c = r10     // Catch:{ Throwable -> 0x00fd }
            r1 = 4
            r2.setLocationType(r1)     // Catch:{ Throwable -> 0x00fd }
            return r2
        L_0x00fd:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ci.a(com.loc.cd, boolean, com.autonavi.aps.amapapi.model.AMapLocationServer, com.loc.cg, java.lang.StringBuilder, java.lang.String, android.content.Context):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    public final void a() {
        this.c = 0;
        this.d = null;
    }

    public final void a(Context context) {
        if (!this.i) {
            try {
                c();
                a(context, (String) null);
            } catch (Throwable th) {
                cs.a(th, "Cache", "loadDB");
            }
            this.i = true;
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.g = aMapLocationClientOption.isNeedAddress();
        this.f = aMapLocationClientOption.isOffset();
        this.b = aMapLocationClientOption.isLocationCacheEnable();
    }

    public final void a(cc ccVar) {
        this.e = ccVar;
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(String str, StringBuilder sb, AMapLocationServer aMapLocationServer, Context context, boolean z) {
        if (da.a(aMapLocationServer)) {
            String str2 = str + "&" + aMapLocationServer.isOffset() + "&" + aMapLocationServer.i();
            if (((TextUtils.isEmpty(str2) || !da.a(aMapLocationServer) || str2.startsWith("#")) ? false : str2.contains("network")) && !aMapLocationServer.e().equals("mem") && !aMapLocationServer.e().equals("file") && !aMapLocationServer.d().equals("-3")) {
                if (b()) {
                    c();
                }
                JSONObject f2 = aMapLocationServer.f();
                if (da.a(f2, "offpct")) {
                    f2.remove("offpct");
                    aMapLocationServer.a(f2);
                }
                if (str2.contains("wifi")) {
                    if (!TextUtils.isEmpty(sb)) {
                        if (aMapLocationServer.getAccuracy() >= 300.0f) {
                            int i2 = 0;
                            for (String contains : sb.toString().split("#")) {
                                if (contains.contains(",")) {
                                    i2++;
                                }
                            }
                            if (i2 >= 8) {
                                return;
                            }
                        } else if (aMapLocationServer.getAccuracy() <= 3.0f) {
                            return;
                        }
                        if (str2.contains("cgiwifi") && !TextUtils.isEmpty(aMapLocationServer.g())) {
                            String replace = str2.replace("cgiwifi", "cgi");
                            AMapLocationServer h2 = aMapLocationServer.h();
                            if (da.a(h2)) {
                                a(replace, new StringBuilder(), h2, context, true);
                            }
                        }
                    } else {
                        return;
                    }
                } else if (str2.contains("cgi") && (!(sb == null || sb.indexOf(",") == -1) || aMapLocationServer.d().equals("4"))) {
                    return;
                }
                AMapLocationServer a2 = a(str2, sb);
                if (!da.a(a2) || !a2.toStr().equals(aMapLocationServer.toStr(3))) {
                    this.h = da.b();
                    a aVar = new a();
                    aVar.a(aMapLocationServer);
                    aVar.a(TextUtils.isEmpty(sb) ? null : sb.toString());
                    if (this.a.containsKey(str2)) {
                        this.a.get(str2).add(aVar);
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(aVar);
                        this.a.put(str2, arrayList);
                    }
                    if (z) {
                        try {
                            a(str2, (AMapLocation) aMapLocationServer, sb, context);
                        } catch (Throwable th) {
                            cs.a(th, "Cache", "add");
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        if (r9.isOpen() != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c A[SYNTHETIC, Splitter:B:38:0x007c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r9) {
        /*
            r8 = this;
            r8.c()     // Catch:{ Throwable -> 0x0099 }
            r0 = 0
            r1 = 0
            if (r9 == 0) goto L_0x0090
            java.lang.String r2 = "hmdb"
            android.database.sqlite.SQLiteDatabase r9 = r9.openOrCreateDatabase(r2, r0, r1)     // Catch:{ Throwable -> 0x0071, all -> 0x006e }
            java.lang.String r2 = "hist"
            boolean r2 = com.loc.da.a((android.database.sqlite.SQLiteDatabase) r9, (java.lang.String) r2)     // Catch:{ Throwable -> 0x006c }
            if (r2 != 0) goto L_0x0022
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x006c }
            if (r2 == 0) goto L_0x0090
            r9.close()     // Catch:{ Throwable -> 0x006c }
            goto L_0x0090
        L_0x0022:
            java.lang.String r2 = "time<?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ Throwable -> 0x006c }
            long r4 = com.loc.da.a()     // Catch:{ Throwable -> 0x006c }
            r6 = 86400000(0x5265c00, double:4.2687272E-316)
            long r4 = r4 - r6
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Throwable -> 0x006c }
            r3[r0] = r4     // Catch:{ Throwable -> 0x006c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r5 = "hist"
            r4.<init>(r5)     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r5 = r8.j     // Catch:{ Throwable -> 0x0049 }
            r4.append(r5)     // Catch:{ Throwable -> 0x0049 }
            java.lang.String r4 = r4.toString()     // Catch:{ Throwable -> 0x0049 }
            r9.delete(r4, r2, r3)     // Catch:{ Throwable -> 0x0049 }
            goto L_0x0060
        L_0x0049:
            r2 = move-exception
            java.lang.String r3 = "DB"
            java.lang.String r4 = "clearHist"
            com.loc.cs.a(r2, r3, r4)     // Catch:{ Throwable -> 0x006c }
            java.lang.String r2 = r2.getMessage()     // Catch:{ Throwable -> 0x006c }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x006c }
            if (r3 != 0) goto L_0x0060
            java.lang.String r3 = "no such table"
            r2.contains(r3)     // Catch:{ Throwable -> 0x006c }
        L_0x0060:
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r2 == 0) goto L_0x0090
        L_0x0068:
            r9.close()     // Catch:{ Throwable -> 0x0099 }
            goto L_0x0090
        L_0x006c:
            r2 = move-exception
            goto L_0x0073
        L_0x006e:
            r0 = move-exception
            r9 = r1
            goto L_0x0084
        L_0x0071:
            r2 = move-exception
            r9 = r1
        L_0x0073:
            java.lang.String r3 = "DB"
            java.lang.String r4 = "clearHist p2"
            com.loc.cs.a(r2, r3, r4)     // Catch:{ all -> 0x0083 }
            if (r9 == 0) goto L_0x0090
            boolean r2 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r2 == 0) goto L_0x0090
            goto L_0x0068
        L_0x0083:
            r0 = move-exception
        L_0x0084:
            if (r9 == 0) goto L_0x008f
            boolean r1 = r9.isOpen()     // Catch:{ Throwable -> 0x0099 }
            if (r1 == 0) goto L_0x008f
            r9.close()     // Catch:{ Throwable -> 0x0099 }
        L_0x008f:
            throw r0     // Catch:{ Throwable -> 0x0099 }
        L_0x0090:
            r8.i = r0     // Catch:{ Throwable -> 0x0099 }
            r8.d = r1     // Catch:{ Throwable -> 0x0099 }
            r0 = 0
            r8.m = r0     // Catch:{ Throwable -> 0x0099 }
            return
        L_0x0099:
            r9 = move-exception
            java.lang.String r0 = "Cache"
            java.lang.String r1 = "destroy part"
            com.loc.cs.a(r9, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ci.b(android.content.Context):void");
    }
}
