package com.loc;

import android.content.Context;
import android.os.Looper;

/* compiled from: AnrLogProcessor */
public final class aa extends ad {
    private static boolean b = true;
    private String[] c = new String[10];
    private int d = 0;
    private boolean e = false;
    private int f = 0;

    protected aa(int i) {
        super(i);
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
            w.a(th, "alg", "gLI");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x013a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x013b, code lost:
        com.loc.w.a(r11, "alg", "getA");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a5, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a7, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00e8, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00e9, code lost:
        com.loc.w.a(r11, "alg", "getA");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0106, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0107, code lost:
        com.loc.w.a(r11, "alg", "getA");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0125 A[SYNTHETIC, Splitter:B:100:0x0125] */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[ExcHandler: FileNotFoundException (unused java.io.FileNotFoundException), SYNTHETIC, Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0136 A[SYNTHETIC, Splitter:B:109:0x0136] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0144 A[SYNTHETIC, Splitter:B:114:0x0144] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0150 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a7 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[ExcHandler: EOFException (unused java.io.EOFException), SYNTHETIC, Splitter:B:12:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e4 A[SYNTHETIC, Splitter:B:73:0x00e4] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f2 A[SYNTHETIC, Splitter:B:78:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0102 A[SYNTHETIC, Splitter:B:86:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0110 A[SYNTHETIC, Splitter:B:91:0x0110] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0117 A[SYNTHETIC, Splitter:B:95:0x0117] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.util.List<com.loc.s> r11) {
        /*
            r10 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0132, IOException -> 0x00f6, Throwable -> 0x00d8, all -> 0x00d4 }
            java.lang.String r2 = "/data/anr/traces.txt"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0132, IOException -> 0x00f6, Throwable -> 0x00d8, all -> 0x00d4 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0132, IOException -> 0x00f6, Throwable -> 0x00d8, all -> 0x00d4 }
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0132, IOException -> 0x00f6, Throwable -> 0x00d8, all -> 0x00d4 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0132, IOException -> 0x00f6, Throwable -> 0x00d8, all -> 0x00d4 }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
            r3 = 1024000(0xfa000, float:1.43493E-39)
            if (r1 <= r3) goto L_0x0022
            int r1 = r1 - r3
            long r3 = (long) r1     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
            r2.skip(r3)     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
        L_0x0022:
            com.loc.bg r1 = new com.loc.bg     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
            java.nio.charset.Charset r3 = com.loc.bh.a     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x00d1, IOException -> 0x00ce, Throwable -> 0x00cb, all -> 0x00c8 }
            r3 = 0
            r4 = r3
        L_0x002b:
            java.lang.String r5 = r1.a()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String r5 = r5.trim()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String r6 = "pid"
            boolean r6 = r5.contains(r6)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r7 = 1
            if (r6 == 0) goto L_0x004a
        L_0x003c:
            java.lang.String r4 = "\"main\""
            boolean r4 = r5.startsWith(r4)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r4 != 0) goto L_0x0049
            java.lang.String r5 = r1.a()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x003c
        L_0x0049:
            r4 = r7
        L_0x004a:
            java.lang.String r6 = ""
            boolean r6 = r5.equals(r6)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r6 == 0) goto L_0x0055
            if (r4 == 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            if (r4 == 0) goto L_0x002b
            int r6 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            r8 = 9
            if (r6 <= r8) goto L_0x005f
            r10.d = r3     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
        L_0x005f:
            java.lang.String[] r6 = r10.c     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            int r8 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            r6[r8] = r5     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            int r6 = r10.d     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            int r6 = r6 + r7
            r10.d = r6     // Catch:{ Throwable -> 0x006b, EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7 }
            goto L_0x0073
        L_0x006b:
            r6 = move-exception
            java.lang.String r8 = "alg"
            java.lang.String r9 = "aDa"
            com.loc.w.a((java.lang.Throwable) r6, (java.lang.String) r8, (java.lang.String) r9)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
        L_0x0073:
            int r6 = r10.f     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r8 = 5
            if (r6 != r8) goto L_0x0079
            goto L_0x00a9
        L_0x0079:
            boolean r6 = r10.e     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r6 != 0) goto L_0x009f
            java.util.Iterator r6 = r11.iterator()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
        L_0x0081:
            boolean r7 = r6.hasNext()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r7 == 0) goto L_0x002b
            java.lang.Object r7 = r6.next()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            com.loc.s r7 = (com.loc.s) r7     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            java.lang.String[] r8 = r7.f()     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            boolean r8 = a((java.lang.String[]) r8, (java.lang.String) r5)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            r10.e = r8     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            boolean r8 = r10.e     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            if (r8 == 0) goto L_0x0081
            r10.a((com.loc.s) r7)     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x002b
        L_0x009f:
            int r5 = r10.f     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            int r5 = r5 + r7
            r10.f = r5     // Catch:{ EOFException -> 0x00a9, FileNotFoundException -> 0x0134, IOException -> 0x00a7, Throwable -> 0x00a5 }
            goto L_0x002b
        L_0x00a5:
            r11 = move-exception
            goto L_0x00db
        L_0x00a7:
            r11 = move-exception
            goto L_0x00f9
        L_0x00a9:
            if (r1 == 0) goto L_0x00b7
            r1.close()     // Catch:{ IOException | Throwable -> 0x00af }
            goto L_0x00b7
        L_0x00af:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00b7:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ IOException | Throwable -> 0x00be }
            goto L_0x0147
        L_0x00be:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0147
        L_0x00c8:
            r11 = move-exception
            r1 = r0
            goto L_0x0115
        L_0x00cb:
            r11 = move-exception
            r1 = r0
            goto L_0x00db
        L_0x00ce:
            r11 = move-exception
            r1 = r0
            goto L_0x00f9
        L_0x00d1:
            r1 = r0
            goto L_0x0134
        L_0x00d4:
            r11 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0115
        L_0x00d8:
            r11 = move-exception
            r1 = r0
            r2 = r1
        L_0x00db:
            java.lang.String r3 = "alg"
            java.lang.String r4 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x00f0
            r1.close()     // Catch:{ IOException | Throwable -> 0x00e8 }
            goto L_0x00f0
        L_0x00e8:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00f0:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ IOException | Throwable -> 0x00be }
            goto L_0x0147
        L_0x00f6:
            r11 = move-exception
            r1 = r0
            r2 = r1
        L_0x00f9:
            java.lang.String r3 = "alg"
            java.lang.String r4 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0114 }
            if (r1 == 0) goto L_0x010e
            r1.close()     // Catch:{ IOException | Throwable -> 0x0106 }
            goto L_0x010e
        L_0x0106:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x010e:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ IOException | Throwable -> 0x00be }
            goto L_0x0147
        L_0x0114:
            r11 = move-exception
        L_0x0115:
            if (r1 == 0) goto L_0x0123
            r1.close()     // Catch:{ IOException | Throwable -> 0x011b }
            goto L_0x0123
        L_0x011b:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0123:
            if (r2 == 0) goto L_0x0131
            r2.close()     // Catch:{ IOException | Throwable -> 0x0129 }
            goto L_0x0131
        L_0x0129:
            r0 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r2 = "getA"
            com.loc.w.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0131:
            throw r11
        L_0x0132:
            r1 = r0
            r2 = r1
        L_0x0134:
            if (r1 == 0) goto L_0x0142
            r1.close()     // Catch:{ IOException | Throwable -> 0x013a }
            goto L_0x0142
        L_0x013a:
            r11 = move-exception
            java.lang.String r1 = "alg"
            java.lang.String r3 = "getA"
            com.loc.w.a((java.lang.Throwable) r11, (java.lang.String) r1, (java.lang.String) r3)
        L_0x0142:
            if (r2 == 0) goto L_0x0147
            r2.close()     // Catch:{ IOException | Throwable -> 0x00be }
        L_0x0147:
            boolean r11 = r10.e
            if (r11 == 0) goto L_0x0150
            java.lang.String r11 = r10.d()
            return r11
        L_0x0150:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.aa.a(java.util.List):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final boolean a(Context context) {
        if (n.n(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            aq aqVar = new aq(context);
            ar a = aqVar.a();
            if (a == null) {
                return true;
            }
            if (!a.c()) {
                return false;
            }
            a.c(false);
            aqVar.a(a);
            return true;
        }
    }
}
