package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.util.LongSparseArray;
import com.amap.api.col.n3.df;
import com.amap.api.maps.AMapException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HeatmapTileProvider implements TileProvider {
    public static final Gradient DEFAULT_GRADIENT = new Gradient(a, b);
    public static final double DEFAULT_OPACITY = 0.6d;
    public static final int DEFAULT_RADIUS = 12;
    private static final int[] a = {Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)};
    private static final float[] b = {0.2f, 1.0f};
    private a c;
    private Collection<WeightedLatLng> d;
    private df e;
    private int f;
    private Gradient g;
    private int[] h;
    private double[] i;
    private double j;
    private double[] k;

    public static class Builder {
        /* access modifiers changed from: private */
        public Collection<WeightedLatLng> a;
        /* access modifiers changed from: private */
        public int b = 12;
        /* access modifiers changed from: private */
        public Gradient c = HeatmapTileProvider.DEFAULT_GRADIENT;
        /* access modifiers changed from: private */
        public double d = 0.6d;

        public Builder data(Collection<LatLng> collection) {
            return weightedData(HeatmapTileProvider.a((Collection) collection));
        }

        public Builder weightedData(Collection<WeightedLatLng> collection) {
            this.a = collection;
            return this;
        }

        public Builder radius(int i) {
            this.b = Math.max(10, Math.min(i, 50));
            return this;
        }

        public Builder gradient(Gradient gradient) {
            this.c = gradient;
            return this;
        }

        public Builder transparency(double d2) {
            this.d = Math.max(0.0d, Math.min(d2, 1.0d));
            return this;
        }

        public HeatmapTileProvider build() {
            if (this.a == null || this.a.size() == 0) {
                try {
                    throw new AMapException("No input points.");
                } catch (AMapException e) {
                    e.getErrorMessage();
                    e.printStackTrace();
                    return null;
                }
            } else {
                try {
                    return new HeatmapTileProvider(this, (byte) 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        }
    }

    public int getTileHeight() {
        return 256;
    }

    public int getTileWidth() {
        return 256;
    }

    /* synthetic */ HeatmapTileProvider(Builder builder, byte b2) {
        this(builder);
    }

    static /* synthetic */ Collection a(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(new WeightedLatLng((LatLng) it.next()));
        }
        return arrayList;
    }

    private HeatmapTileProvider(Builder builder) {
        this.d = builder.a;
        this.f = builder.b;
        this.g = builder.c;
        if (this.g == null || !this.g.isAvailable()) {
            this.g = DEFAULT_GRADIENT;
        }
        this.j = builder.d;
        this.i = a(this.f, ((double) this.f) / 3.0d);
        Gradient gradient = this.g;
        this.g = gradient;
        this.h = gradient.generateColorMap(this.j);
        b(this.d);
    }

    private void b(Collection<WeightedLatLng> collection) {
        try {
            ArrayList arrayList = new ArrayList();
            for (WeightedLatLng next : collection) {
                if (next.latLng.latitude < 85.0d && next.latLng.latitude > -85.0d) {
                    arrayList.add(next);
                }
            }
            this.d = arrayList;
            this.e = c(this.d);
            this.c = new a(this.e);
            for (WeightedLatLng a2 : this.d) {
                this.c.a(a2);
            }
            this.k = a(this.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.maps.model.Tile getTile(int r39, int r40, int r41) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            r2 = r40
            r3 = r41
            double r4 = (double) r3
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r6, r4)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r4 = r8 / r4
            int r10 = r0.f
            double r10 = (double) r10
            double r10 = r10 * r4
            r12 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r10 = r10 / r12
            double r6 = r6 * r10
            double r6 = r6 + r4
            int r12 = r0.f
            int r12 = r12 * 2
            r13 = 256(0x100, float:3.59E-43)
            int r12 = r12 + r13
            double r14 = (double) r12
            double r6 = r6 / r14
            double r14 = (double) r1
            double r14 = r14 * r4
            double r14 = r14 - r10
            int r1 = r1 + 1
            double r8 = (double) r1
            double r8 = r8 * r4
            double r19 = r8 + r10
            double r8 = (double) r2
            double r8 = r8 * r4
            double r8 = r8 - r10
            int r1 = r2 + 1
            double r1 = (double) r1
            double r1 = r1 * r4
            double r1 = r1 + r10
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r16 = 0
            int r5 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r5 >= 0) goto L_0x005d
            com.amap.api.col.n3.df r4 = new com.amap.api.col.n3.df
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r28 = r14 + r16
            r30 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r27 = r4
            r32 = r8
            r34 = r1
            r27.<init>(r28, r30, r32, r34)
            r16 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            com.amap.api.maps.model.a r5 = r0.c
            java.util.Collection r4 = r5.a((com.amap.api.col.n3.df) r4)
        L_0x005a:
            r25 = r16
            goto L_0x007a
        L_0x005d:
            r21 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r5 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r5 <= 0) goto L_0x005a
            com.amap.api.col.n3.df r4 = new com.amap.api.col.n3.df
            r28 = 0
            double r30 = r19 - r21
            r27 = r4
            r32 = r8
            r34 = r1
            r27.<init>(r28, r30, r32, r34)
            com.amap.api.maps.model.a r5 = r0.c
            java.util.Collection r4 = r5.a((com.amap.api.col.n3.df) r4)
            r25 = r21
        L_0x007a:
            com.amap.api.col.n3.df r5 = new com.amap.api.col.n3.df
            r16 = r5
            r17 = r14
            r21 = r8
            r23 = r1
            r16.<init>(r17, r19, r21, r23)
            com.amap.api.col.n3.df r1 = new com.amap.api.col.n3.df
            com.amap.api.col.n3.df r2 = r0.e
            r36 = r14
            double r13 = r2.a
            double r28 = r13 - r10
            com.amap.api.col.n3.df r2 = r0.e
            double r12 = r2.c
            double r30 = r12 + r10
            com.amap.api.col.n3.df r2 = r0.e
            double r12 = r2.b
            double r32 = r12 - r10
            com.amap.api.col.n3.df r2 = r0.e
            double r12 = r2.d
            double r34 = r12 + r10
            r27 = r1
            r27.<init>(r28, r30, r32, r34)
            boolean r1 = r5.a(r1)
            if (r1 != 0) goto L_0x00b1
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00b1:
            com.amap.api.maps.model.a r1 = r0.c
            java.util.Collection r1 = r1.a((com.amap.api.col.n3.df) r5)
            boolean r2 = r1.isEmpty()
            if (r2 == 0) goto L_0x00c0
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.TileProvider.NO_TILE
            return r1
        L_0x00c0:
            int r2 = r0.f
            int r2 = r2 * 2
            r5 = 256(0x100, float:3.59E-43)
            int r13 = r5 + r2
            int r2 = r0.f
            int r2 = r2 * 2
            int r2 = r2 + r5
            int[] r2 = new int[]{r13, r2}
            java.lang.Class<double> r5 = double.class
            java.lang.Object r2 = java.lang.reflect.Array.newInstance(r5, r2)
            double[][] r2 = (double[][]) r2
            java.util.Iterator r1 = r1.iterator()
        L_0x00dd:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0102
            java.lang.Object r5 = r1.next()
            com.amap.api.maps.model.WeightedLatLng r5 = (com.amap.api.maps.model.WeightedLatLng) r5
            com.autonavi.amap.mapcore.DPoint r10 = r5.getPoint()
            double r11 = r10.x
            double r11 = r11 - r36
            double r11 = r11 / r6
            int r11 = (int) r11
            double r12 = r10.y
            double r12 = r12 - r8
            double r12 = r12 / r6
            int r10 = (int) r12
            r11 = r2[r11]
            r12 = r11[r10]
            double r14 = r5.intensity
            double r12 = r12 + r14
            r11[r10] = r12
            goto L_0x00dd
        L_0x0102:
            java.util.Iterator r1 = r4.iterator()
        L_0x0106:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x012d
            java.lang.Object r4 = r1.next()
            com.amap.api.maps.model.WeightedLatLng r4 = (com.amap.api.maps.model.WeightedLatLng) r4
            com.autonavi.amap.mapcore.DPoint r5 = r4.getPoint()
            double r10 = r5.x
            double r10 = r10 + r25
            double r10 = r10 - r36
            double r10 = r10 / r6
            int r10 = (int) r10
            double r11 = r5.y
            double r11 = r11 - r8
            double r11 = r11 / r6
            int r5 = (int) r11
            r10 = r2[r10]
            r11 = r10[r5]
            double r13 = r4.intensity
            double r11 = r11 + r13
            r10[r5] = r11
            goto L_0x0106
        L_0x012d:
            double[] r1 = r0.i
            double[][] r1 = a((double[][]) r2, (double[]) r1)
            int[] r2 = r0.h
            double[] r4 = r0.k
            r3 = r4[r3]
            android.graphics.Bitmap r1 = a(r1, r2, r3)
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG
            r4 = 100
            r1.compress(r3, r4, r2)
            byte[] r1 = r2.toByteArray()
            r2 = 256(0x100, float:3.59E-43)
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.Tile.obtain(r2, r2, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.HeatmapTileProvider.getTile(int, int, int):com.amap.api.maps.model.Tile");
    }

    private double[] a(int i2) {
        int i3;
        Iterator<WeightedLatLng> it;
        double d2;
        int i4 = 21;
        double[] dArr = new double[21];
        int i5 = 5;
        while (true) {
            if (i5 >= 11) {
                break;
            }
            Collection<WeightedLatLng> collection = this.d;
            df dfVar = this.e;
            int pow = (int) (1280.0d * Math.pow(2.0d, (double) i5));
            double d3 = dfVar.a;
            double d4 = dfVar.c;
            double d5 = dfVar.b;
            double d6 = d4 - d3;
            double d7 = dfVar.d - d5;
            if (d6 > d7) {
                d7 = d6;
            }
            double d8 = ((double) ((int) (((double) (pow / (2 * i2))) + 0.5d))) / d7;
            LongSparseArray longSparseArray = new LongSparseArray();
            Iterator<WeightedLatLng> it2 = collection.iterator();
            double d9 = 0.0d;
            while (it2.hasNext()) {
                WeightedLatLng next = it2.next();
                double d10 = next.getPoint().x;
                double[] dArr2 = dArr;
                int i6 = (int) ((next.getPoint().y - d5) * d8);
                long j2 = (long) ((int) ((d10 - d3) * d8));
                LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.get(j2);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    longSparseArray.put(j2, longSparseArray2);
                }
                long j3 = (long) i6;
                Double d11 = (Double) longSparseArray2.get(j3);
                if (d11 == null) {
                    it = it2;
                    d2 = d8;
                    d11 = Double.valueOf(0.0d);
                } else {
                    it = it2;
                    d2 = d8;
                }
                Double valueOf = Double.valueOf(d11.doubleValue() + next.intensity);
                longSparseArray2.put(j3, valueOf);
                if (valueOf.doubleValue() > d9) {
                    d9 = valueOf.doubleValue();
                }
                dArr = dArr2;
                d8 = d2;
                it2 = it;
            }
            double[] dArr3 = dArr;
            dArr3[i5] = d9;
            if (i5 == 5) {
                for (int i7 = 0; i7 < i5; i7++) {
                    dArr3[i7] = dArr3[i5];
                }
            }
            i5++;
            dArr = dArr3;
            i4 = 21;
        }
        double[] dArr4 = dArr;
        for (i3 = 11; i3 < i4; i3++) {
            dArr4[i3] = dArr4[10];
        }
        return dArr4;
    }

    private static df c(Collection<WeightedLatLng> collection) {
        Iterator<WeightedLatLng> it = collection.iterator();
        WeightedLatLng next = it.next();
        double d2 = next.getPoint().x;
        double d3 = next.getPoint().x;
        double d4 = d2;
        double d5 = d3;
        double d6 = next.getPoint().y;
        double d7 = next.getPoint().y;
        while (it.hasNext()) {
            WeightedLatLng next2 = it.next();
            double d8 = next2.getPoint().x;
            double d9 = next2.getPoint().y;
            if (d8 < d4) {
                d4 = d8;
            }
            if (d8 > d5) {
                d5 = d8;
            }
            if (d9 < d6) {
                d6 = d9;
            }
            if (d9 > d7) {
                d7 = d9;
            }
        }
        df dfVar = new df(d4, d5, d6, d7);
        return dfVar;
    }

    private static double[] a(int i2, double d2) {
        double[] dArr = new double[((i2 * 2) + 1)];
        for (int i3 = -i2; i3 <= i2; i3++) {
            dArr[i3 + i2] = Math.exp(((double) ((-i3) * i3)) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    private static double[][] a(double[][] dArr, double[] dArr2) {
        double[][] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int floor = (int) Math.floor(((double) dArr4.length) / 2.0d);
        int length = dArr3.length;
        int i2 = length - (2 * floor);
        int i3 = (floor + i2) - 1;
        double[][] dArr5 = (double[][]) Array.newInstance(double.class, new int[]{length, length});
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length; i5++) {
                double d2 = dArr3[i4][i5];
                if (d2 != 0.0d) {
                    int i6 = i4 + floor;
                    if (i3 < i6) {
                        i6 = i3;
                    }
                    int i7 = i6 + 1;
                    int i8 = i4 - floor;
                    for (int i9 = floor > i8 ? floor : i8; i9 < i7; i9++) {
                        double[] dArr6 = dArr5[i9];
                        dArr6[i5] = dArr6[i5] + (dArr4[i9 - i8] * d2);
                    }
                }
            }
        }
        double[][] dArr7 = (double[][]) Array.newInstance(double.class, new int[]{i2, i2});
        for (int i10 = floor; i10 < i3 + 1; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                double d3 = dArr5[i10][i11];
                if (d3 != 0.0d) {
                    int i12 = i11 + floor;
                    if (i3 < i12) {
                        i12 = i3;
                    }
                    int i13 = i12 + 1;
                    int i14 = i11 - floor;
                    for (int i15 = floor > i14 ? floor : i14; i15 < i13; i15++) {
                        double[] dArr8 = dArr7[i10 - floor];
                        int i16 = i15 - floor;
                        dArr8[i16] = dArr8[i16] + (dArr4[i15 - i14] * d3);
                    }
                }
            }
        }
        return dArr7;
    }

    private static Bitmap a(double[][] dArr, int[] iArr, double d2) {
        int i2 = iArr[iArr.length - 1];
        double length = ((double) (iArr.length - 1)) / d2;
        int length2 = dArr.length;
        int[] iArr2 = new int[(length2 * length2)];
        for (int i3 = 0; i3 < length2; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                double d3 = dArr[i4][i3];
                int i5 = (i3 * length2) + i4;
                int i6 = (int) (d3 * length);
                if (d3 == 0.0d) {
                    iArr2[i5] = 0;
                } else if (i6 < iArr.length) {
                    iArr2[i5] = iArr[i6];
                } else {
                    iArr2[i5] = i2;
                }
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(length2, length2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, length2, 0, 0, length2, length2);
        return createBitmap;
    }
}
