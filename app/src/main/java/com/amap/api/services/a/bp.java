package com.amap.api.services.a;

import android.content.Context;
import android.os.Looper;

/* compiled from: AnrLogProcessor */
public class bp extends bs {
    private static boolean b = true;
    private String[] c = new String[10];
    private int d = 0;
    private boolean e = false;
    private int f = 0;

    protected bp(int i) {
        super(i);
    }

    /* access modifiers changed from: protected */
    public boolean a(Context context) {
        if (bd.m(context) != 1 || !b) {
            return false;
        }
        b = false;
        synchronized (Looper.getMainLooper()) {
            cf cfVar = new cf(context);
            cg a = cfVar.a();
            if (a == null) {
                return true;
            }
            if (!a.c()) {
                return false;
            }
            a.c(false);
            cfVar.a(a);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x013c A[SYNTHETIC, Splitter:B:102:0x013c] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0156 A[SYNTHETIC, Splitter:B:113:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x016d A[SYNTHETIC, Splitter:B:120:0x016d] */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0179 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00df A[SYNTHETIC, Splitter:B:69:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f6 A[SYNTHETIC, Splitter:B:76:0x00f6] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0107 A[SYNTHETIC, Splitter:B:84:0x0107] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x011e A[SYNTHETIC, Splitter:B:91:0x011e] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0125 A[SYNTHETIC, Splitter:B:95:0x0125] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.util.List<com.amap.api.services.a.bh> r9) {
        /*
            r8 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0152, IOException -> 0x00fb, Throwable -> 0x00d3, all -> 0x00cf }
            java.lang.String r2 = "/data/anr/traces.txt"
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0152, IOException -> 0x00fb, Throwable -> 0x00d3, all -> 0x00cf }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException -> 0x0152, IOException -> 0x00fb, Throwable -> 0x00d3, all -> 0x00cf }
            if (r2 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0152, IOException -> 0x00fb, Throwable -> 0x00d3, all -> 0x00cf }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0152, IOException -> 0x00fb, Throwable -> 0x00d3, all -> 0x00cf }
            int r1 = r2.available()     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
            r3 = 1024000(0xfa000, float:1.43493E-39)
            if (r1 <= r3) goto L_0x0022
            int r1 = r1 - r3
            long r3 = (long) r1     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
            r2.skip(r3)     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
        L_0x0022:
            com.amap.api.services.a.cv r1 = new com.amap.api.services.a.cv     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
            java.nio.charset.Charset r3 = com.amap.api.services.a.cw.a     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
            r1.<init>(r2, r3)     // Catch:{ FileNotFoundException -> 0x00cc, IOException -> 0x00c9, Throwable -> 0x00c6, all -> 0x00c2 }
            r3 = 0
        L_0x002a:
            java.lang.String r4 = r1.a()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            java.lang.String r4 = r4.trim()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            java.lang.String r5 = "pid"
            boolean r5 = r4.contains(r5)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            r6 = 1
            if (r5 == 0) goto L_0x0049
        L_0x003b:
            java.lang.String r3 = "\"main\""
            boolean r3 = r4.startsWith(r3)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            if (r3 != 0) goto L_0x0048
            java.lang.String r4 = r1.a()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            goto L_0x003b
        L_0x0048:
            r3 = r6
        L_0x0049:
            java.lang.String r5 = ""
            boolean r5 = r4.equals(r5)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            if (r5 == 0) goto L_0x0054
            if (r3 == 0) goto L_0x0054
            goto L_0x0090
        L_0x0054:
            if (r3 == 0) goto L_0x002a
            r8.c(r4)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            int r5 = r8.f     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            r7 = 5
            if (r5 != r7) goto L_0x005f
            goto L_0x0090
        L_0x005f:
            boolean r5 = r8.e     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            if (r5 != 0) goto L_0x0085
            java.util.Iterator r5 = r9.iterator()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
        L_0x0067:
            boolean r6 = r5.hasNext()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            if (r6 == 0) goto L_0x002a
            java.lang.Object r6 = r5.next()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            com.amap.api.services.a.bh r6 = (com.amap.api.services.a.bh) r6     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            java.lang.String[] r7 = r6.f()     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            boolean r7 = b((java.lang.String[]) r7, (java.lang.String) r4)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            r8.e = r7     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            boolean r7 = r8.e     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            if (r7 == 0) goto L_0x0067
            r8.a((com.amap.api.services.a.bh) r6)     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            goto L_0x002a
        L_0x0085:
            int r4 = r8.f     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            int r4 = r4 + r6
            r8.f = r4     // Catch:{ EOFException -> 0x0090, FileNotFoundException -> 0x0154, IOException -> 0x008d, Throwable -> 0x008b }
            goto L_0x002a
        L_0x008b:
            r9 = move-exception
            goto L_0x00d6
        L_0x008d:
            r9 = move-exception
            goto L_0x00fe
        L_0x0090:
            if (r1 == 0) goto L_0x00a7
            r1.close()     // Catch:{ IOException -> 0x009f, Throwable -> 0x0096 }
            goto L_0x00a7
        L_0x0096:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x00a7
        L_0x009f:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00a7:
            if (r2 == 0) goto L_0x0170
            r2.close()     // Catch:{ IOException -> 0x00b8, Throwable -> 0x00ae }
            goto L_0x0170
        L_0x00ae:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r2 = "initLog4"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0170
        L_0x00b8:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r2 = "initLog3"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0170
        L_0x00c2:
            r9 = move-exception
            r1 = r0
            goto L_0x0123
        L_0x00c6:
            r9 = move-exception
            r1 = r0
            goto L_0x00d6
        L_0x00c9:
            r9 = move-exception
            r1 = r0
            goto L_0x00fe
        L_0x00cc:
            r1 = r0
            goto L_0x0154
        L_0x00cf:
            r9 = move-exception
            r1 = r0
            r2 = r1
            goto L_0x0123
        L_0x00d3:
            r9 = move-exception
            r1 = r0
            r2 = r1
        L_0x00d6:
            java.lang.String r3 = "ANRWriter"
            java.lang.String r4 = "initLog"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x00f4
            r1.close()     // Catch:{ IOException -> 0x00ec, Throwable -> 0x00e3 }
            goto L_0x00f4
        L_0x00e3:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x00f4
        L_0x00ec:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
        L_0x00f4:
            if (r2 == 0) goto L_0x0170
            r2.close()     // Catch:{ IOException -> 0x00b8, Throwable -> 0x00ae }
            goto L_0x0170
        L_0x00fb:
            r9 = move-exception
            r1 = r0
            r2 = r1
        L_0x00fe:
            java.lang.String r3 = "ANRWriter"
            java.lang.String r4 = "initLog"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0122 }
            if (r1 == 0) goto L_0x011c
            r1.close()     // Catch:{ IOException -> 0x0114, Throwable -> 0x010b }
            goto L_0x011c
        L_0x010b:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x011c
        L_0x0114:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
        L_0x011c:
            if (r2 == 0) goto L_0x0170
            r2.close()     // Catch:{ IOException -> 0x00b8, Throwable -> 0x00ae }
            goto L_0x0170
        L_0x0122:
            r9 = move-exception
        L_0x0123:
            if (r1 == 0) goto L_0x013a
            r1.close()     // Catch:{ IOException -> 0x0132, Throwable -> 0x0129 }
            goto L_0x013a
        L_0x0129:
            r0 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x013a
        L_0x0132:
            r0 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)
        L_0x013a:
            if (r2 == 0) goto L_0x0151
            r2.close()     // Catch:{ IOException -> 0x0149, Throwable -> 0x0140 }
            goto L_0x0151
        L_0x0140:
            r0 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r2 = "initLog4"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            goto L_0x0151
        L_0x0149:
            r0 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r2 = "initLog3"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x0151:
            throw r9
        L_0x0152:
            r1 = r0
            r2 = r1
        L_0x0154:
            if (r1 == 0) goto L_0x016b
            r1.close()     // Catch:{ IOException -> 0x0163, Throwable -> 0x015a }
            goto L_0x016b
        L_0x015a:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog2"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
            goto L_0x016b
        L_0x0163:
            r9 = move-exception
            java.lang.String r1 = "ANRWriter"
            java.lang.String r3 = "initLog1"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r3)
        L_0x016b:
            if (r2 == 0) goto L_0x0170
            r2.close()     // Catch:{ IOException -> 0x00b8, Throwable -> 0x00ae }
        L_0x0170:
            boolean r9 = r8.e
            if (r9 == 0) goto L_0x0179
            java.lang.String r9 = r8.e()
            return r9
        L_0x0179:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bp.a(java.util.List):java.lang.String");
    }

    private String e() {
        StringBuilder sb = new StringBuilder();
        try {
            int i = this.d;
            while (true) {
                if (i >= 10) {
                    break;
                } else if (i > 9) {
                    break;
                } else {
                    sb.append(this.c[i]);
                    i++;
                }
            }
            for (int i2 = 0; i2 < this.d; i2++) {
                sb.append(this.c[i2]);
            }
        } catch (Throwable th) {
            bl.a(th, "ANRWriter", "getLogInfo");
        }
        return sb.toString();
    }

    private void c(String str) {
        try {
            if (this.d > 9) {
                this.d = 0;
            }
            this.c[this.d] = str;
            this.d++;
        } catch (Throwable th) {
            bl.a(th, "ANRWriter", "addData");
        }
    }
}
