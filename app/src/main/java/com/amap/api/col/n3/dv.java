package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.n3.im;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.FPoint3;
import com.autonavi.amap.mapcore.FileUtil;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: Util */
public final class dv {
    private static FPoint[] a = {FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain()};
    private static List<Float> b = new ArrayList(4);
    private static List<Float> c = new ArrayList(4);

    public static float a(float f, float f2) {
        if (f <= 40.0f) {
            return f;
        }
        if (f2 <= 15.0f) {
            return 40.0f;
        }
        if (f2 <= 16.0f) {
            return 50.0f;
        }
        if (f2 <= 17.0f) {
            return 54.0f;
        }
        return f2 <= 18.0f ? 57.0f : 60.0f;
    }

    public static boolean b(int i, int i2) {
        return i > 0 && i2 > 0;
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = dr.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th) {
            iu.b(th, "Util", "fromAsset");
            return null;
        }
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static float a(MapConfig mapConfig, float f) {
        if (mapConfig != null) {
            if (f > mapConfig.maxZoomLevel) {
                return mapConfig.maxZoomLevel;
            }
            return f < mapConfig.minZoomLevel ? mapConfig.minZoomLevel : f;
        } else if (f > 19.0f) {
            return 19.0f;
        } else {
            if (f < 3.0f) {
                return 3.0f;
            }
            return f;
        }
    }

    public static FloatBuffer a(float[] fArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            asFloatBuffer.put(fArr);
            asFloatBuffer.position(0);
            return asFloatBuffer;
        } catch (Throwable th) {
            iu.b(th, "Util", "makeFloatBuffer1");
            th.printStackTrace();
            return null;
        }
    }

    public static FloatBuffer a(float[] fArr, FloatBuffer floatBuffer) {
        try {
            floatBuffer.clear();
            floatBuffer.put(fArr);
            floatBuffer.position(0);
            return floatBuffer;
        } catch (Throwable th) {
            iu.b(th, "Util", "makeFloatBuffer2");
            th.printStackTrace();
            return null;
        }
    }

    public static int a() {
        return a(Bitmap.createBitmap(512, 1024, Bitmap.Config.ARGB_8888), true);
    }

    public static int a(Bitmap bitmap) {
        return a(bitmap, false);
    }

    public static int b(Bitmap bitmap) {
        return a(bitmap, true);
    }

    private static int a(Bitmap bitmap, boolean z) {
        int a2 = a(0, bitmap, z);
        if (bitmap != null) {
            bitmap.recycle();
        }
        return a2;
    }

    public static int a(int i, Bitmap bitmap, boolean z) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glBindTexture(3553, i);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        if (z) {
            GLES20.glTexParameterf(3553, 10242, 10497.0f);
            GLES20.glTexParameterf(3553, 10243, 10497.0f);
        } else {
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return i;
    }

    public static int a(int i, Bitmap bitmap, int i2, int i3) {
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        if (i == 0) {
            int[] iArr = {0};
            GLES20.glGenTextures(1, iArr, 0);
            i = iArr[0];
        }
        GLES20.glBindTexture(3553, i);
        GLUtils.texSubImage2D(3553, 0, i2, i3, bitmap);
        return i;
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String append : strArr) {
            sb.append(append);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static String a(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), "data");
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(file.toString() + File.separator);
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String b(Context context) {
        String a2 = a(context);
        if (a2 == null) {
            return null;
        }
        File file = new File(a2, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        NetworkInfo.State state = activeNetworkInfo.getState();
        if (state == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static void b(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
    }

    public static String a(InputStream inputStream) {
        try {
            return new String(b(inputStream), "utf-8");
        } catch (Throwable th) {
            iu.b(th, "Util", "decodeAssetResData");
            th.printStackTrace();
            return null;
        }
    }

    private static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        while (true) {
            int read = inputStream.read(bArr, 0, 2048);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x00e7 A[SYNTHETIC, Splitter:B:110:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006e A[SYNTHETIC, Splitter:B:46:0x006e] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x008b A[SYNTHETIC, Splitter:B:62:0x008b] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x009d A[SYNTHETIC, Splitter:B:70:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00ba A[SYNTHETIC, Splitter:B:86:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x00ca A[SYNTHETIC, Splitter:B:94:0x00ca] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.io.File r6) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0060, all -> 0x005c }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x0060, all -> 0x005c }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x0052, all -> 0x004c }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x0052, all -> 0x004c }
            java.lang.String r4 = "utf-8"
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x0052, all -> 0x004c }
            r6.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0057, IOException -> 0x0052, all -> 0x004c }
        L_0x0017:
            java.lang.String r1 = r6.readLine()     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0042, all -> 0x003d }
            if (r1 == 0) goto L_0x0021
            r0.append(r1)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0042, all -> 0x003d }
            goto L_0x0017
        L_0x0021:
            r2.close()     // Catch:{ IOException -> 0x002b }
            r6.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x0029:
            r0 = move-exception
            goto L_0x0034
        L_0x002b:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0029 }
            r6.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x0034:
            r6.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003c:
            throw r0
        L_0x003d:
            r0 = move-exception
            r1 = r2
            r2 = r6
            goto L_0x00c8
        L_0x0042:
            r1 = move-exception
            r5 = r2
            r2 = r6
            r6 = r1
            goto L_0x0055
        L_0x0047:
            r1 = move-exception
            r5 = r2
            r2 = r6
            r6 = r1
            goto L_0x005a
        L_0x004c:
            r0 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
            goto L_0x00c8
        L_0x0052:
            r6 = move-exception
            r5 = r2
            r2 = r1
        L_0x0055:
            r1 = r5
            goto L_0x0062
        L_0x0057:
            r6 = move-exception
            r5 = r2
            r2 = r1
        L_0x005a:
            r1 = r5
            goto L_0x0091
        L_0x005c:
            r0 = move-exception
            r2 = r1
            goto L_0x00c8
        L_0x0060:
            r6 = move-exception
            r2 = r1
        L_0x0062:
            java.lang.String r3 = "Util"
            java.lang.String r4 = "readFile io"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00c7 }
            r6.printStackTrace()     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0089
            r1.close()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0089
        L_0x0072:
            r6 = move-exception
            goto L_0x007e
        L_0x0074:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x0072 }
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x007e:
            if (r2 == 0) goto L_0x0088
            r2.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x0088
        L_0x0084:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0088:
            throw r6
        L_0x0089:
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x008f:
            r6 = move-exception
            r2 = r1
        L_0x0091:
            java.lang.String r3 = "Util"
            java.lang.String r4 = "readFile fileNotFound"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r6, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00c7 }
            r6.printStackTrace()     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x00b8
            r1.close()     // Catch:{ IOException -> 0x00a3 }
            goto L_0x00b8
        L_0x00a1:
            r6 = move-exception
            goto L_0x00ad
        L_0x00a3:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00ad:
            if (r2 == 0) goto L_0x00b7
            r2.close()     // Catch:{ IOException -> 0x00b3 }
            goto L_0x00b7
        L_0x00b3:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00b7:
            throw r6
        L_0x00b8:
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00be }
            goto L_0x00c2
        L_0x00be:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00c2:
            java.lang.String r6 = r0.toString()
            return r6
        L_0x00c7:
            r0 = move-exception
        L_0x00c8:
            if (r1 == 0) goto L_0x00e5
            r1.close()     // Catch:{ IOException -> 0x00d0 }
            goto L_0x00e5
        L_0x00ce:
            r6 = move-exception
            goto L_0x00da
        L_0x00d0:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ all -> 0x00ce }
            if (r2 == 0) goto L_0x00ef
            r2.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ef
        L_0x00da:
            if (r2 == 0) goto L_0x00e4
            r2.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e4
        L_0x00e0:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00e4:
            throw r6
        L_0x00e5:
            if (r2 == 0) goto L_0x00ef
            r2.close()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ef
        L_0x00eb:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00ef:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dv.a(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.amap.api.maps.model.LatLng r32, java.util.List<com.amap.api.maps.model.LatLng> r33) {
        /*
            r0 = r32
            r1 = r33
            double r14 = r0.longitude
            double r12 = r0.latitude
            double r10 = r0.latitude
            int r0 = r33.size()
            r8 = 0
            r2 = 3
            if (r0 >= r2) goto L_0x0013
            return r8
        L_0x0013:
            java.lang.Object r0 = r1.get(r8)
            com.amap.api.maps.model.LatLng r0 = (com.amap.api.maps.model.LatLng) r0
            int r2 = r33.size()
            r16 = 1
            int r2 = r2 + -1
            java.lang.Object r2 = r1.get(r2)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0032
            java.lang.Object r0 = r1.get(r8)
            r1.add(r0)
        L_0x0032:
            r0 = r8
            r17 = r0
        L_0x0035:
            int r2 = r33.size()
            int r2 = r2 + -1
            if (r0 >= r2) goto L_0x010a
            java.lang.Object r2 = r1.get(r0)
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2
            double r6 = r2.longitude
            java.lang.Object r2 = r1.get(r0)
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2
            double r4 = r2.latitude
            int r0 = r0 + 1
            java.lang.Object r2 = r1.get(r0)
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2
            double r2 = r2.longitude
            java.lang.Object r9 = r1.get(r0)
            com.amap.api.maps.model.LatLng r9 = (com.amap.api.maps.model.LatLng) r9
            r18 = r0
            double r0 = r9.latitude
            r19 = r2
            r2 = r14
            r21 = r4
            r4 = r12
            r23 = r6
            r25 = r8
            r8 = r21
            r26 = r10
            r10 = r19
            r28 = r12
            r12 = r0
            boolean r2 = a(r2, r4, r6, r8, r10, r12)
            if (r2 == 0) goto L_0x007b
            return r16
        L_0x007b:
            double r12 = r0 - r21
            double r2 = java.lang.Math.abs(r12)
            r4 = 4472406533629990549(0x3e112e0be826d695, double:1.0E-9)
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x00fe
            r10 = 4640537203540230144(0x4066800000000000, double:180.0)
            r2 = r23
            r4 = r21
            r6 = r14
            r8 = r28
            r30 = r12
            r12 = r26
            boolean r2 = a(r2, r4, r6, r8, r10, r12)
            if (r2 == 0) goto L_0x00a7
            int r0 = (r21 > r0 ? 1 : (r21 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fe
            int r17 = r17 + 1
            goto L_0x00fe
        L_0x00a7:
            r10 = 4640537203540230144(0x4066800000000000, double:180.0)
            r2 = r19
            r4 = r0
            r6 = r14
            r8 = r28
            r12 = r26
            boolean r2 = a(r2, r4, r6, r8, r10, r12)
            if (r2 == 0) goto L_0x00c1
            int r0 = (r0 > r21 ? 1 : (r0 == r21 ? 0 : -1))
            if (r0 <= 0) goto L_0x00fe
            int r17 = r17 + 1
            goto L_0x00fe
        L_0x00c1:
            double r2 = r19 - r23
            double r10 = r26 - r28
            double r0 = r2 * r10
            r4 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r4 = r4 - r14
            double r12 = r30 * r4
            double r0 = r0 - r12
            r6 = 0
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            double r8 = r21 - r28
            double r4 = r4 * r8
            double r12 = r23 - r14
            double r10 = r10 * r12
            double r4 = r4 - r10
            double r4 = r4 / r0
            double r8 = r8 * r2
            double r12 = r12 * r30
            double r8 = r8 - r12
            double r8 = r8 / r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            r0 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f8
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x00f8
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x00f8
            r0 = r16
            goto L_0x00fa
        L_0x00f8:
            r0 = r25
        L_0x00fa:
            if (r0 == 0) goto L_0x00fe
            int r17 = r17 + 1
        L_0x00fe:
            r0 = r18
            r8 = r25
            r10 = r26
            r12 = r28
            r1 = r33
            goto L_0x0035
        L_0x010a:
            r25 = r8
            int r17 = r17 % 2
            if (r17 == 0) goto L_0x0111
            goto L_0x0113
        L_0x0111:
            r16 = r25
        L_0x0113:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.dv.a(com.amap.api.maps.model.LatLng, java.util.List):boolean");
    }

    private static boolean a(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2))) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static List<FPoint> a(FPoint[] fPointArr, List<FPoint> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (i < size - 1) {
                FPoint fPoint = (FPoint) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint fPoint2 = (FPoint) arrayList2.get(i2 % size);
                if (i == 0 && a(fPoint, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint);
                }
                int i3 = b2 + 1;
                if (a(fPoint, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint2);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    }
                } else if (a(fPoint2, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint, fPoint2));
                    arrayList.add(fPoint2);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static List<FPoint> b(FPoint[] fPointArr, List<FPoint> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (i < size - 1) {
                FPoint3 fPoint3 = (FPoint3) arrayList2.get(i % size);
                int i2 = i + 1;
                FPoint3 fPoint32 = (FPoint3) arrayList2.get(i2 % size);
                if (i == 0 && a((FPoint) fPoint3, fPointArr[b2], fPointArr[(b2 + 1) % fPointArr.length])) {
                    arrayList.add(fPoint3);
                }
                int i3 = b2 + 1;
                if (a((FPoint) fPoint3, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    if (a((FPoint) fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                        arrayList.add(fPoint32);
                    } else {
                        arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32));
                    }
                } else if (a((FPoint) fPoint32, fPointArr[b2], fPointArr[i3 % fPointArr.length])) {
                    arrayList.add(a(fPointArr[b2], fPointArr[i3 % fPointArr.length], fPoint3, fPoint32));
                    arrayList.add(fPoint32);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    public static FPoint[] a(k kVar) {
        float cameraAngle = kVar.getCameraAngle();
        float f = cameraAngle == 50.0f ? 0.082f : cameraAngle == 54.0f ? 0.15f : cameraAngle == 57.0f ? 0.2f : cameraAngle == 60.0f ? 0.25f : 0.0f;
        double mapHeight = (double) kVar.getMapHeight();
        FPoint obtain = FPoint.obtain();
        int i = (int) (((float) (mapHeight * ((double) f))) - 10.0f);
        kVar.a(-100, i, (PointF) obtain);
        a[0].set(obtain.x, obtain.y);
        FPoint obtain2 = FPoint.obtain();
        kVar.a(kVar.getMapWidth() + 100, i, (PointF) obtain2);
        a[1].set(obtain2.x, obtain2.y);
        FPoint obtain3 = FPoint.obtain();
        kVar.a(kVar.getMapWidth() + 100, kVar.getMapHeight() + 100, (PointF) obtain3);
        a[2].set(obtain3.x, obtain3.y);
        FPoint obtain4 = FPoint.obtain();
        kVar.a(-100, kVar.getMapHeight() + 100, (PointF) obtain4);
        a[3].set(obtain4.x, obtain4.y);
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        obtain4.recycle();
        return a;
    }

    private static FPoint3 a(FPoint fPoint, FPoint fPoint2, FPoint3 fPoint3, FPoint3 fPoint32) {
        FPoint3 fPoint33 = new FPoint3(0.0f, 0.0f, fPoint3.colorIndex);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint32.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint32.y - fPoint3.y)));
        fPoint33.x = (float) (((double) fPoint3.x) + ((((double) (fPoint32.x - fPoint3.x)) * d) / d2));
        fPoint33.y = (float) (((double) fPoint3.y) + ((((double) (fPoint32.y - fPoint3.y)) * d) / d2));
        return fPoint33;
    }

    private static FPoint a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3, FPoint fPoint4) {
        FPoint obtain = FPoint.obtain(0.0f, 0.0f);
        double d = (double) (((fPoint2.y - fPoint.y) * (fPoint.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint.y - fPoint3.y)));
        double d2 = (double) (((fPoint2.y - fPoint.y) * (fPoint4.x - fPoint3.x)) - ((fPoint2.x - fPoint.x) * (fPoint4.y - fPoint3.y)));
        obtain.x = (float) (((double) fPoint3.x) + ((((double) (fPoint4.x - fPoint3.x)) * d) / d2));
        obtain.y = (float) (((double) fPoint3.y) + ((((double) (fPoint4.y - fPoint3.y)) * d) / d2));
        return obtain;
    }

    public static boolean a(FPoint fPoint, FPoint[] fPointArr) {
        if (fPointArr == null) {
            return false;
        }
        byte b2 = 0;
        while (b2 < fPointArr.length) {
            FPoint fPoint2 = fPointArr[b2];
            int i = b2 + 1;
            if (!a(fPoint, fPoint2, fPointArr[i % fPointArr.length])) {
                return false;
            }
            b2 = (byte) i;
        }
        return true;
    }

    private static boolean a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return ((double) (((fPoint3.x - fPoint2.x) * (fPoint.y - fPoint2.y)) - ((fPoint.x - fPoint2.x) * (fPoint3.y - fPoint2.y)))) >= 0.0d;
    }

    public static List<IPoint> a(IPoint[] iPointArr, List<IPoint> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        for (byte b2 = 0; b2 < 4; b2 = (byte) (b2 + 1)) {
            arrayList.clear();
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                IPoint iPoint = (IPoint) arrayList2.get(i % size);
                int i2 = i + 1;
                IPoint iPoint2 = (IPoint) arrayList2.get(i2 % size);
                if (i == 0 && a(iPoint, iPointArr[b2], iPointArr[(b2 + 1) % iPointArr.length])) {
                    arrayList.add(iPoint);
                }
                int i3 = b2 + 1;
                if (a(iPoint, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                    if (a(iPoint2, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                        arrayList.add(iPoint2);
                    } else {
                        arrayList.add(a(iPointArr[b2], iPointArr[i3 % iPointArr.length], iPoint, iPoint2));
                    }
                } else if (a(iPoint2, iPointArr[b2], iPointArr[i3 % iPointArr.length])) {
                    arrayList.add(a(iPointArr[b2], iPointArr[i3 % iPointArr.length], iPoint, iPoint2));
                    arrayList.add(iPoint2);
                }
                i = i2;
            }
            arrayList2.clear();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                arrayList2.add(arrayList.get(i4));
            }
        }
        return arrayList2;
    }

    private static IPoint a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, IPoint iPoint4) {
        IPoint obtain = IPoint.obtain(0, 0);
        double d = (((double) (iPoint2.y - iPoint.y)) * ((double) (iPoint.x - iPoint3.x))) - (((double) (iPoint2.x - iPoint.x)) * ((double) (iPoint.y - iPoint3.y)));
        double d2 = (((double) (iPoint2.y - iPoint.y)) * ((double) (iPoint4.x - iPoint3.x))) - (((double) (iPoint2.x - iPoint.x)) * ((double) (iPoint4.y - iPoint3.y)));
        obtain.x = (int) (((double) iPoint3.x) + ((((double) (iPoint4.x - iPoint3.x)) * d) / d2));
        obtain.y = (int) (((double) iPoint3.y) + ((((double) (iPoint4.y - iPoint3.y)) * d) / d2));
        return obtain;
    }

    public static boolean a(List<IPoint> list, int i) {
        List<IPoint> list2 = list;
        int i2 = i;
        if (i2 < 3) {
            return false;
        }
        int i3 = i2 - 1;
        double d = 0.0d;
        for (int i4 = 0; i4 < i2; i4++) {
            IPoint iPoint = list2.get(i3);
            IPoint iPoint2 = list2.get(i4);
            d += ((((double) iPoint.x) / 1000000.0d) * (((double) iPoint2.y) / 1000000.0d)) - ((((double) iPoint2.x) / 1000000.0d) * (((double) iPoint.y) / 1000000.0d));
            i3 = i4;
        }
        if (d < 0.0d) {
            return true;
        }
        return false;
    }

    private static boolean a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3) {
        return (((double) (iPoint3.x - iPoint2.x)) * ((double) (iPoint.y - iPoint2.y))) - (((double) (iPoint.x - iPoint2.x)) * ((double) (iPoint3.y - iPoint2.y))) >= 0.0d;
    }

    public static Bitmap a(int i, int i2) {
        int i3 = i * i2;
        try {
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            IntBuffer wrap = IntBuffer.wrap(iArr);
            wrap.position(0);
            GLES20.glReadPixels(0, 0, i, i2, 6408, 5121, wrap);
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    int i6 = iArr[(i4 * i) + i5];
                    iArr2[(((i2 - i4) - 1) * i) + i5] = (i6 & -16711936) | ((i6 << 16) & 16711680) | ((i6 >> 16) & 255);
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImpGLSurfaceView", "SavePixels");
            th.printStackTrace();
            return null;
        }
    }

    public static im f() {
        try {
            if (g.f == null) {
                return new im.a("3dmap", "5.4.0", g.d).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("5.4.0").a();
            }
            return g.f;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void b(View view) {
        int i = 0;
        if (view instanceof ViewGroup) {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i < viewGroup.getChildCount()) {
                    b(viewGroup.getChildAt(i));
                    i++;
                } else {
                    return;
                }
            }
        } else if (view instanceof TextView) {
            ((TextView) view).setHorizontallyScrolling(false);
        }
    }

    public static Bitmap a(View view) {
        try {
            b(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th) {
            iu.b(th, "Utils", "getBitmapFromView");
            th.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(((latLng.longitude / 360.0d) + 0.5d) * 1.0d, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * 1.0d);
    }

    public static boolean a(Rect rect, int i, int i2) {
        return rect.contains(i, i2);
    }

    public static Pair<Float, IPoint> a(CameraUpdateMessage cameraUpdateMessage, MapConfig mapConfig) {
        LatLngBounds latLngBounds = cameraUpdateMessage.bounds;
        int i = cameraUpdateMessage.width;
        int i2 = cameraUpdateMessage.height;
        return a(mapConfig, Math.max(cameraUpdateMessage.paddingLeft, 1), Math.max(cameraUpdateMessage.paddingRight, 1), Math.max(cameraUpdateMessage.paddingTop, 1), Math.max(cameraUpdateMessage.paddingBottom, 1), latLngBounds, i, i2);
    }

    public static Pair<Float, IPoint> a(MapConfig mapConfig, int i, int i2, int i3, int i4, LatLngBounds latLngBounds, int i5, int i6) {
        boolean z;
        float f;
        int i7;
        int i8;
        LatLngBounds latLngBounds2 = latLngBounds;
        Point LatLongToPixels = VirtualEarthProjection.LatLongToPixels(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude, 20);
        Point LatLongToPixels2 = VirtualEarthProjection.LatLongToPixels(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude, 20);
        int i9 = LatLongToPixels.x - LatLongToPixels2.x;
        int i10 = LatLongToPixels2.y - LatLongToPixels.y;
        int i11 = i5 - (i + i2);
        int i12 = i6 - (i3 + i4);
        if (i9 < 0 && i10 < 0) {
            return null;
        }
        if (i9 <= 0) {
            i9 = 1;
        }
        if (i10 <= 0) {
            i10 = 1;
        }
        if (i11 <= 0) {
            i11 = 1;
        }
        if (i12 <= 0) {
            i12 = 1;
        }
        int i13 = LatLongToPixels.x;
        int i14 = LatLongToPixels.y;
        int i15 = LatLongToPixels2.x;
        int i16 = LatLongToPixels2.y;
        mapConfig.getS_z();
        if (i13 == i15 && i14 == i16) {
            f = mapConfig.getMaxZoomLevel();
            z = true;
        } else {
            float a2 = (float) a(mapConfig.getMapZoomScale(), (double) i11, (double) Math.abs(i15 - i13));
            float min = Math.min(a2, (float) a(mapConfig.getMapZoomScale(), (double) i12, (double) Math.abs(i16 - i14)));
            z = min == a2;
            f = Math.min(mapConfig.getMaxZoomLevel(), Math.max(mapConfig.getMinZoomLevel(), min));
        }
        Pair pair = new Pair(Float.valueOf(f), Boolean.valueOf(z));
        float floatValue = ((Float) pair.first).floatValue();
        boolean booleanValue = ((Boolean) pair.second).booleanValue();
        float a3 = a(mapConfig.getMapZoomScale(), floatValue, (double) i9);
        float a4 = a(mapConfig.getMapZoomScale(), floatValue, (double) i10);
        if (floatValue >= mapConfig.maxZoomLevel) {
            i8 = (int) (((float) LatLongToPixels2.x) + (((((float) (i2 - i)) + a3) * ((float) i9)) / (a3 * 2.0f)));
            i7 = (int) (((float) LatLongToPixels.y) + (((((float) (i4 - i3)) + a4) * ((float) i10)) / (2.0f * a4)));
        } else if (booleanValue) {
            i8 = (int) (((float) LatLongToPixels2.x) + ((((float) ((i5 / 2) - i)) / a3) * ((float) i9)));
            i7 = (int) (((float) LatLongToPixels.y) + (((((float) (i4 - i3)) + a4) * ((float) i10)) / (2.0f * a4)));
        } else {
            i8 = (int) (((float) LatLongToPixels2.x) + (((((float) (i2 - i)) + a3) * ((float) i9)) / (2.0f * a3)));
            i7 = (int) (((float) LatLongToPixels.y) + ((((float) ((i6 / 2) - i3)) / a4) * ((float) i10)));
        }
        return new Pair<>(Float.valueOf(floatValue), IPoint.obtain((int) (((float) i8) + a(mapConfig.getMapZoomScale(), floatValue, (float) (mapConfig.getAnchorX() - (mapConfig.getMapWidth() >> 1)))), (int) (((float) i7) + a(mapConfig.getMapZoomScale(), floatValue, (float) (mapConfig.getAnchorY() - (mapConfig.getMapHeight() >> 1))))));
    }

    private static double a(float f, double d, double d2) {
        return 20.0d - (Math.log(d2 / (d * ((double) f))) / Math.log(2.0d));
    }

    private static float a(float f, float f2, double d) {
        return (float) (d / (Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f)));
    }

    private static float a(float f, float f2, float f3) {
        return (float) (((double) f3) * Math.pow(2.0d, (double) (20.0f - f2)) * ((double) f));
    }

    public static float a(MapConfig mapConfig, int i, int i2, int i3, int i4, int i5, int i6) {
        float s_z = mapConfig.getS_z();
        if (i == i3 || i2 == i4) {
            return s_z;
        }
        return Math.max((float) a(mapConfig.getMapZoomScale(), (double) i5, (double) Math.abs(i3 - i)), (float) a(mapConfig.getMapZoomScale(), (double) i6, (double) Math.abs(i4 - i2)));
    }

    public static synchronized int[] a(int i, int i2, int i3, int i4, MapConfig mapConfig, GLMapState gLMapState, int i5, int i6) {
        int[] iArr;
        synchronized (dv.class) {
            int mapWidth = mapConfig.getMapWidth();
            int mapHeight = mapConfig.getMapHeight();
            int anchorX = mapConfig.getAnchorX();
            int anchorY = mapConfig.getAnchorY();
            float f = (float) i5;
            iArr = new int[]{(int) Math.max(((float) i3) + a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorX), Math.min(f, ((float) i) - a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapWidth - anchorX)))), (int) Math.max(((float) i2) + a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) anchorY), Math.min((float) i6, ((float) i4) - a(mapConfig.getMapZoomScale(), gLMapState.getMapZoomer(), (float) (mapHeight - anchorY))))};
        }
        return iArr;
    }

    public static void a(Rect rect) {
        if (rect != null) {
            rect.set(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, Integer.MIN_VALUE, Integer.MIN_VALUE, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
    }

    public static void b(Rect rect, int i, int i2) {
        if (rect != null) {
            if (i < rect.left) {
                rect.left = i;
            }
            if (i > rect.right) {
                rect.right = i;
            }
            if (i2 > rect.top) {
                rect.top = i2;
            }
            if (i2 < rect.bottom) {
                rect.bottom = i2;
            }
        }
    }
}
