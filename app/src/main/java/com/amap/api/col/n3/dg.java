package com.amap.api.col.n3;

/* compiled from: EarClippingTriangulator */
public final class dg {
    private final dt a = new dt();
    private short[] b;
    private double[] c;
    private int d;
    private final dl e = new dl();
    private final dt f = new dt();

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d3, code lost:
        r3 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.n3.dt a(double[] r43) {
        /*
            r42 = this;
            r0 = r42
            r1 = r43
            r2 = 2
            r3 = 0
            int r4 = r1.length
            r0.c = r1
            int r4 = r4 / r2
            r0.d = r4
            com.amap.api.col.n3.dt r1 = r0.a
            r1.b = r3
            r1.b(r4)
            r1.b = r4
            short[] r1 = r1.a
            r0.b = r1
            int r5 = r4 + -1
            r6 = r3
        L_0x001c:
            if (r6 >= r4) goto L_0x0027
            int r7 = r3 + r5
            int r7 = r7 - r6
            short r7 = (short) r7
            r1[r6] = r7
            int r6 = r6 + 1
            goto L_0x001c
        L_0x0027:
            com.amap.api.col.n3.dl r1 = r0.e
            r1.b = r3
            r1.b(r4)
            r5 = r3
        L_0x002f:
            if (r5 >= r4) goto L_0x003b
            int r6 = r0.a((int) r5)
            r1.a(r6)
            int r5 = r5 + 1
            goto L_0x002f
        L_0x003b:
            com.amap.api.col.n3.dt r1 = r0.f
            r1.b = r3
            int r4 = r4 - r2
            int r4 = java.lang.Math.max(r3, r4)
            r5 = 3
            int r4 = r4 * r5
            r1.b(r4)
            com.amap.api.col.n3.dl r4 = r0.e
            int[] r4 = r4.a
        L_0x004d:
            int r6 = r0.d
            r7 = 1
            if (r6 <= r5) goto L_0x019e
            int r6 = r0.d
            r8 = r3
        L_0x0055:
            r9 = -1
            if (r8 >= r6) goto L_0x00da
            com.amap.api.col.n3.dl r10 = r0.e
            int[] r10 = r10.a
            r11 = r10[r8]
            if (r11 != r9) goto L_0x0062
            goto L_0x00d1
        L_0x0062:
            int r9 = r0.b(r8)
            int r11 = r0.c(r8)
            short[] r12 = r0.b
            short r13 = r12[r9]
            int r13 = r13 * r2
            short r14 = r12[r8]
            int r14 = r14 * r2
            short r15 = r12[r11]
            int r15 = r15 * r2
            double[] r3 = r0.c
            r28 = r3[r13]
            int r13 = r13 + r7
            r30 = r3[r13]
            r32 = r3[r14]
            int r14 = r14 + r7
            r13 = r3[r14]
            r34 = r3[r15]
            int r15 = r15 + r7
            r36 = r3[r15]
        L_0x0086:
            int r11 = r0.c(r11)
            if (r11 == r9) goto L_0x00d0
            r15 = r10[r11]
            if (r15 == r7) goto L_0x0086
            short r15 = r12[r11]
            int r15 = r15 * r2
            r38 = r3[r15]
            int r15 = r15 + r7
            r40 = r3[r15]
            r16 = r34
            r18 = r36
            r20 = r28
            r22 = r30
            r24 = r38
            r26 = r40
            int r15 = a(r16, r18, r20, r22, r24, r26)
            if (r15 < 0) goto L_0x0086
            r16 = r28
            r18 = r30
            r20 = r32
            r22 = r13
            r24 = r38
            r26 = r40
            int r15 = a(r16, r18, r20, r22, r24, r26)
            if (r15 < 0) goto L_0x0086
            r16 = r32
            r18 = r13
            r20 = r34
            r22 = r36
            r24 = r38
            r26 = r40
            int r15 = a(r16, r18, r20, r22, r24, r26)
            if (r15 < 0) goto L_0x0086
            r3 = 0
            goto L_0x00d1
        L_0x00d0:
            r3 = r7
        L_0x00d1:
            if (r3 == 0) goto L_0x00d5
        L_0x00d3:
            r3 = r8
            goto L_0x00ea
        L_0x00d5:
            int r8 = r8 + 1
            r3 = 0
            goto L_0x0055
        L_0x00da:
            com.amap.api.col.n3.dl r3 = r0.e
            int[] r3 = r3.a
            r8 = 0
        L_0x00df:
            if (r8 >= r6) goto L_0x00e9
            r10 = r3[r8]
            if (r10 == r9) goto L_0x00e6
            goto L_0x00d3
        L_0x00e6:
            int r8 = r8 + 1
            goto L_0x00df
        L_0x00e9:
            r3 = 0
        L_0x00ea:
            short[] r6 = r0.b
            com.amap.api.col.n3.dt r8 = r0.f
            int r9 = r0.b(r3)
            short r9 = r6[r9]
            r8.a((short) r9)
            short r9 = r6[r3]
            r8.a((short) r9)
            int r9 = r0.c(r3)
            short r6 = r6[r9]
            r8.a((short) r6)
            com.amap.api.col.n3.dt r6 = r0.a
            int r8 = r6.b
            if (r3 < r8) goto L_0x0129
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "index can't be >= size: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = " >= "
            r2.append(r3)
            int r3 = r6.b
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0129:
            short[] r8 = r6.a
            int r9 = r6.b
            int r9 = r9 - r7
            r6.b = r9
            boolean r9 = r6.c
            if (r9 == 0) goto L_0x013d
            int r9 = r3 + 1
            int r6 = r6.b
            int r6 = r6 - r3
            java.lang.System.arraycopy(r8, r9, r8, r3, r6)
            goto L_0x0143
        L_0x013d:
            int r6 = r6.b
            short r6 = r8[r6]
            r8[r3] = r6
        L_0x0143:
            com.amap.api.col.n3.dl r6 = r0.e
            int r8 = r6.b
            if (r3 < r8) goto L_0x0167
            java.lang.IndexOutOfBoundsException r1 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "index can't be >= size: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r3 = " >= "
            r2.append(r3)
            int r3 = r6.b
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x0167:
            int[] r8 = r6.a
            int r9 = r6.b
            int r9 = r9 - r7
            r6.b = r9
            boolean r9 = r6.c
            if (r9 == 0) goto L_0x017b
            int r9 = r3 + 1
            int r6 = r6.b
            int r6 = r6 - r3
            java.lang.System.arraycopy(r8, r9, r8, r3, r6)
            goto L_0x0181
        L_0x017b:
            int r6 = r6.b
            r6 = r8[r6]
            r8[r3] = r6
        L_0x0181:
            int r6 = r0.d
            int r6 = r6 - r7
            r0.d = r6
            int r6 = r0.b(r3)
            int r7 = r0.d
            if (r3 != r7) goto L_0x018f
            r3 = 0
        L_0x018f:
            int r7 = r0.a((int) r6)
            r4[r6] = r7
            int r6 = r0.a((int) r3)
            r4[r3] = r6
            r3 = 0
            goto L_0x004d
        L_0x019e:
            int r3 = r0.d
            if (r3 != r5) goto L_0x01b6
            com.amap.api.col.n3.dt r3 = r0.f
            short[] r4 = r0.b
            r5 = 0
            short r5 = r4[r5]
            r3.a((short) r5)
            short r5 = r4[r7]
            r3.a((short) r5)
            short r2 = r4[r2]
            r3.a((short) r2)
        L_0x01b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dg.a(double[]):com.amap.api.col.n3.dt");
    }

    private int a(int i) {
        short[] sArr = this.b;
        int i2 = sArr[b(i)] * 2;
        int i3 = sArr[i] * 2;
        int i4 = sArr[c(i)] * 2;
        double[] dArr = this.c;
        return a(dArr[i2], dArr[i2 + 1], dArr[i3], dArr[i3 + 1], dArr[i4], dArr[i4 + 1]);
    }

    private int b(int i) {
        if (i == 0) {
            i = this.d;
        }
        return i - 1;
    }

    private int c(int i) {
        return (i + 1) % this.d;
    }

    private static int a(double d2, double d3, double d4, double d5, double d6, double d7) {
        return (int) Math.signum((d2 * (d7 - d5)) + (d4 * (d3 - d7)) + (d6 * (d5 - d3)));
    }
}
