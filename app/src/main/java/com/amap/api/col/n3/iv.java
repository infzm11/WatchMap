package com.amap.api.col.n3;

import android.content.Context;
import android.os.Looper;

/* compiled from: AnrLogProcessor */
public final class iv extends iy {
    private static boolean b = true;
    private String[] c = new String[10];
    private int d = 0;
    private boolean e = false;
    private int f = 0;

    protected iv(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (ih.n(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            jl jlVar = new jl(context);
            jm a = jlVar.a();
            if (a == null) {
                return true;
            }
            if (!a.c()) {
                return false;
            }
            a.c(false);
            jlVar.a(a);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        com.amap.api.col.n3.ir.a(r6, "alg", "aDa");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
        r11 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013f A[SYNTHETIC, Splitter:B:103:0x013f] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0156 A[SYNTHETIC, Splitter:B:110:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:120:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0170 A[SYNTHETIC, Splitter:B:121:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0187 A[SYNTHETIC, Splitter:B:128:0x0187] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0193 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: EOFException (unused java.io.EOFException), SYNTHETIC, Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f9 A[SYNTHETIC, Splitter:B:77:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0110 A[SYNTHETIC, Splitter:B:84:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0121 A[SYNTHETIC, Splitter:B:92:0x0121] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0138 A[SYNTHETIC, Splitter:B:99:0x0138] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.util.List<com.amap.api.col.n3.im> r11) {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x016c, IOException -> 0x0115, Throwable -> 0x00ed, all -> 0x00e9 }
            java.lang.String r2 = "/data/anr/traces.txt"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x016c, IOException -> 0x0115, Throwable -> 0x00ed, all -> 0x00e9 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x016c, IOException -> 0x0115, Throwable -> 0x00ed, all -> 0x00e9 }
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x016c, IOException -> 0x0115, Throwable -> 0x00ed, all -> 0x00e9 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x016c, IOException -> 0x0115, Throwable -> 0x00ed, all -> 0x00e9 }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
            r3 = 1024000(0xfa000, float:1.43493E-39)
            if (r1 <= r3) goto L_0x0022
            int r1 = r1 - r3
            long r3 = (long) r1     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
            r2.skip(r3)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
        L_0x0022:
            com.amap.api.col.n3.kb r1 = new com.amap.api.col.n3.kb     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
            java.nio.charset.Charset r3 = com.amap.api.col.n3.kc.a     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, Throwable -> 0x00e0, all -> 0x00dc }
            r3 = 0
            r4 = r3
        L_0x002b:
            java.lang.String r5 = r1.a()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String r5 = r5.trim()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String r6 = "pid"
            boolean r6 = r5.contains(r6)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r7 = 1
            if (r6 == 0) goto L_0x004a
        L_0x003c:
            java.lang.String r4 = "\"main\""
            boolean r4 = r5.startsWith(r4)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r4 != 0) goto L_0x0049
            java.lang.String r5 = r1.a()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x003c
        L_0x0049:
            r4 = r7
        L_0x004a:
            java.lang.String r6 = ""
            boolean r6 = r5.equals(r6)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r6 == 0) goto L_0x0055
            if (r4 == 0) goto L_0x0055
            goto L_0x00aa
        L_0x0055:
            if (r4 == 0) goto L_0x002b
            int r6 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            r8 = 9
            if (r6 <= r8) goto L_0x005f
            r10.d = r3     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
        L_0x005f:
            java.lang.String[] r6 = r10.c     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            int r8 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            r6[r8] = r5     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            int r6 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            int r6 = r6 + r7
            r10.d = r6     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7 }
            goto L_0x0073
        L_0x006b:
            r6 = move-exception
            java.lang.String r8 = "alg"
            java.lang.String r9 = "aDa"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
        L_0x0073:
            int r6 = r10.f     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r8 = 5
            if (r6 != r8) goto L_0x0079
            goto L_0x00aa
        L_0x0079:
            boolean r6 = r10.e     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r6 != 0) goto L_0x009f
            java.util.Iterator r6 = r11.iterator()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
        L_0x0081:
            boolean r7 = r6.hasNext()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r7 == 0) goto L_0x002b
            java.lang.Object r7 = r6.next()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            com.amap.api.col.n3.im r7 = (com.amap.api.col.n3.im) r7     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String[] r8 = r7.g()     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            boolean r8 = a((java.lang.String[]) r8, (java.lang.String) r5)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r10.e = r8     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            boolean r8 = r10.e     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r8 == 0) goto L_0x0081
            r10.a((com.amap.api.col.n3.im) r7)     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x002b
        L_0x009f:
            int r5 = r10.f     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            int r5 = r5 + r7
            r10.f = r5     // Catch:{ EOFException -> 0x00aa, FileNotFoundException -> 0x016e, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x002b
        L_0x00a5:
            r11 = move-exception
            goto L_0x00f0
        L_0x00a7:
            r11 = move-exception
            goto L_0x0118
        L_0x00aa:
            if (r1 == 0) goto L_0x00c1
            r1.close()     // Catch:{ IOException -> 0x00b9, Throwable -> 0x00b0 }
            goto L_0x00c1
        L_0x00b0:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x00c1
        L_0x00b9:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00c1:
            if (r2 == 0) goto L_0x018a
            r2.close()     // Catch:{ IOException -> 0x00d2, Throwable -> 0x00c8 }
            goto L_0x018a
        L_0x00c8:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x018a
        L_0x00d2:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x018a
        L_0x00dc:
            r11 = move-exception
            r1 = r0
            goto L_0x013d
        L_0x00e0:
            r11 = move-exception
            r1 = r0
            goto L_0x00f0
        L_0x00e3:
            r11 = move-exception
            r1 = r0
            goto L_0x0118
        L_0x00e6:
            r1 = r0
            goto L_0x016e
        L_0x00e9:
            r11 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x013d
        L_0x00ed:
            r11 = move-exception
            r1 = r0
            r2 = r1
        L_0x00f0:
            java.lang.String r3 = "alg"
            java.lang.String r4 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x013c }
            if (r1 == 0) goto L_0x010e
            r1.close()     // Catch:{ IOException -> 0x0106, Throwable -> 0x00fd }
            goto L_0x010e
        L_0x00fd:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x010e
        L_0x0106:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x010e:
            if (r2 == 0) goto L_0x018a
            r2.close()     // Catch:{ IOException -> 0x00d2, Throwable -> 0x00c8 }
            goto L_0x018a
        L_0x0115:
            r11 = move-exception
            r1 = r0
            r2 = r1
        L_0x0118:
            java.lang.String r3 = "alg"
            java.lang.String r4 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x013c }
            if (r1 == 0) goto L_0x0136
            r1.close()     // Catch:{ IOException -> 0x012e, Throwable -> 0x0125 }
            goto L_0x0136
        L_0x0125:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x0136
        L_0x012e:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0136:
            if (r2 == 0) goto L_0x018a
            r2.close()     // Catch:{ IOException -> 0x00d2, Throwable -> 0x00c8 }
            goto L_0x018a
        L_0x013c:
            r11 = move-exception
        L_0x013d:
            if (r1 == 0) goto L_0x0154
            r1.close()     // Catch:{ IOException -> 0x014c, Throwable -> 0x0143 }
            goto L_0x0154
        L_0x0143:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x0154
        L_0x014c:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0154:
            if (r2 == 0) goto L_0x016b
            r2.close()     // Catch:{ IOException -> 0x0163, Throwable -> 0x015a }
            goto L_0x016b
        L_0x015a:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x016b
        L_0x0163:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x016b:
            throw r11
        L_0x016c:
            r1 = r0
            r2 = r1
        L_0x016e:
            if (r1 == 0) goto L_0x0185
            r1.close()     // Catch:{ IOException -> 0x017d, Throwable -> 0x0174 }
            goto L_0x0185
        L_0x0174:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x0185
        L_0x017d:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0185:
            if (r2 == 0) goto L_0x018a
            r2.close()     // Catch:{ IOException -> 0x00d2, Throwable -> 0x00c8 }
        L_0x018a:
            boolean r11 = r10.e
            if (r11 == 0) goto L_0x0193
            java.lang.String r11 = r10.d()
            return r11
        L_0x0193:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.iv.a(java.util.List):java.lang.String");
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = this.d;
            while (i < 10 && i <= 9) {
                sb.append(this.c[i]);
                i++;
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                sb.append(this.c[i2]);
            }
        } catch (Throwable th) {
            ir.a(th, "alg", "gLI");
        }
        return sb.toString();
    }
}
