package com.amap.api.col.n3;

/* compiled from: FileCopy */
public final class bd {

    /* compiled from: FileCopy */
    public interface a {
        void a();

        void a(float f);

        void b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(java.io.File r19, java.io.File r20, long r21, long r23, com.amap.api.col.n3.bd.a r25) {
        /*
            r18 = this;
            r1 = r19
            r2 = r20
            r11 = r23
            r13 = r25
            r3 = 0
            int r7 = (r21 > r3 ? 1 : (r21 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x001b
            java.io.PrintStream r1 = java.lang.System.err
            java.lang.String r2 = "sizeOfDirectory is the total Size,  must be a positive number"
            r1.println(r2)
            if (r13 == 0) goto L_0x001a
            r25.b()
        L_0x001a:
            return r3
        L_0x001b:
            r19.getAbsolutePath()
            r20.getAbsolutePath()
            boolean r3 = r19.isDirectory()     // Catch:{ Exception -> 0x00eb }
            r4 = 0
            if (r3 == 0) goto L_0x007c
            boolean r3 = r20.exists()     // Catch:{ Exception -> 0x00eb }
            if (r3 != 0) goto L_0x004c
            boolean r3 = r20.mkdirs()     // Catch:{ Exception -> 0x00eb }
            if (r3 != 0) goto L_0x004c
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb }
            java.lang.String r4 = "Cannot create dir "
            r3.<init>(r4)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r2 = r20.getAbsolutePath()     // Catch:{ Exception -> 0x00eb }
            r3.append(r2)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x00eb }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00eb }
            throw r1     // Catch:{ Exception -> 0x00eb }
        L_0x004c:
            java.lang.String[] r14 = r19.list()     // Catch:{ Exception -> 0x00eb }
            if (r14 == 0) goto L_0x0078
            r16 = r21
            r15 = r4
        L_0x0055:
            int r3 = r14.length     // Catch:{ Exception -> 0x0075 }
            if (r15 >= r3) goto L_0x00f7
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0075 }
            r3 = r14[r15]     // Catch:{ Exception -> 0x0075 }
            r4.<init>(r1, r3)     // Catch:{ Exception -> 0x0075 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0075 }
            r3 = r14[r15]     // Catch:{ Exception -> 0x0075 }
            r5.<init>(r2, r3)     // Catch:{ Exception -> 0x0075 }
            r3 = r18
            r6 = r16
            r8 = r11
            r10 = r13
            long r3 = r3.a(r4, r5, r6, r8, r10)     // Catch:{ Exception -> 0x0075 }
            int r15 = r15 + 1
            r16 = r3
            goto L_0x0055
        L_0x0075:
            r0 = move-exception
            goto L_0x00ee
        L_0x0078:
            r16 = r21
            goto L_0x00f7
        L_0x007c:
            java.io.File r3 = r20.getParentFile()     // Catch:{ Exception -> 0x00eb }
            if (r3 == 0) goto L_0x00a6
            boolean r7 = r3.exists()     // Catch:{ Exception -> 0x00eb }
            if (r7 != 0) goto L_0x00a6
            boolean r7 = r3.mkdirs()     // Catch:{ Exception -> 0x00eb }
            if (r7 != 0) goto L_0x00a6
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x00eb }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00eb }
            java.lang.String r4 = "Cannot create dir "
            r2.<init>(r4)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ Exception -> 0x00eb }
            r2.append(r3)     // Catch:{ Exception -> 0x00eb }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00eb }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00eb }
            throw r1     // Catch:{ Exception -> 0x00eb }
        L_0x00a6:
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00eb }
            r3.<init>(r1)     // Catch:{ Exception -> 0x00eb }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00eb }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00eb }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00eb }
            r5 = r21
        L_0x00b6:
            int r7 = r3.read(r2)     // Catch:{ Exception -> 0x00e6 }
            if (r7 <= 0) goto L_0x00cd
            r1.write(r2, r4, r7)     // Catch:{ Exception -> 0x00e6 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x00e6 }
            long r5 = r5 + r7
            if (r13 == 0) goto L_0x00b6
            float r7 = (float) r5     // Catch:{ Exception -> 0x00e6 }
            float r8 = (float) r11     // Catch:{ Exception -> 0x00e6 }
            float r7 = r7 / r8
            r8 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 * r8
            r13.a(r7)     // Catch:{ Exception -> 0x00e6 }
            goto L_0x00b6
        L_0x00cd:
            r3.close()     // Catch:{ Exception -> 0x00e6 }
            r1.flush()     // Catch:{ Exception -> 0x00e6 }
            r1.close()     // Catch:{ Exception -> 0x00e6 }
            if (r13 == 0) goto L_0x00e3
            r1 = 1
            long r1 = r11 - r1
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x00e3
            r25.a()     // Catch:{ Exception -> 0x00e6 }
        L_0x00e3:
            r16 = r5
            goto L_0x00f7
        L_0x00e6:
            r0 = move-exception
            r1 = r0
            r16 = r5
            goto L_0x00ef
        L_0x00eb:
            r0 = move-exception
            r16 = r21
        L_0x00ee:
            r1 = r0
        L_0x00ef:
            r1.printStackTrace()
            if (r13 == 0) goto L_0x00f7
            r25.b()
        L_0x00f7:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bd.a(java.io.File, java.io.File, long, long, com.amap.api.col.n3.bd$a):long");
    }
}
