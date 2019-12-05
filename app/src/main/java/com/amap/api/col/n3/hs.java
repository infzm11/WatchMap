package com.amap.api.col.n3;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: ResourcesUtil */
public class hs {
    private static AssetManager a = null;
    private static Resources b = null;
    private static Resources c = null;
    private static boolean d = true;
    private static Context e = null;
    /* access modifiers changed from: private */
    public static String f = "autonavi_Resource";
    /* access modifiers changed from: private */
    public static String g = "1_1_0";
    private static String h = ".png";
    /* access modifiers changed from: private */
    public static String i = ".jar";
    private static String j = (f + g + i);
    private static String k = (f + g + h);
    private static String l = "";
    private static String m;
    private static Resources.Theme n;
    private static Resources.Theme o;
    private static Field p;
    private static Field q;
    private static Activity r;

    /* compiled from: ResourcesUtil */
    static class a implements FilenameFilter {
        a() {
        }

        public final boolean accept(File file, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append(hs.g);
            sb.append(hs.i);
            return str.startsWith(hs.f) && !str.endsWith(sb.toString());
        }
    }

    public static void b() {
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(l);
        sb.append(j);
        m = sb.toString();
    }

    public static boolean a(Context context) {
        try {
            e = context;
            l = hq.a(e).getAbsolutePath() + "/";
            m = l + j;
            if (!d) {
                return true;
            }
            if (!b(context)) {
                return false;
            }
            a = a(m);
            AssetManager assetManager = a;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            b = new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static Resources a() {
        if (b == null) {
            return e.getResources();
        }
        return b;
    }

    private static AssetManager a(String str) {
        AssetManager assetManager;
        try {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            assetManager = (AssetManager) cls.getConstructor((Class[]) null).newInstance((Object[]) null);
            try {
                cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assetManager, new Object[]{str});
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            assetManager = null;
            iu.b(th, "ResourcesUtil", "getAssetManager(String apkPath)");
            return assetManager;
        }
        return assetManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e A[SYNTHETIC, Splitter:B:37:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b1 A[SYNTHETIC, Splitter:B:44:0x00b1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(android.content.Context r9) {
        /*
            java.io.File r0 = r9.getFilesDir()
            java.lang.String r0 = r0.getAbsolutePath()
            l = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = l
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            java.lang.String r1 = j
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            m = r0
            r0 = 0
            r1 = 0
            android.content.res.Resources r9 = r9.getResources()     // Catch:{ Throwable -> 0x008e, all -> 0x008b }
            android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ Throwable -> 0x008e, all -> 0x008b }
            java.lang.String r2 = k     // Catch:{ Throwable -> 0x008e, all -> 0x008b }
            java.io.InputStream r9 = r9.open(r2)     // Catch:{ Throwable -> 0x008e, all -> 0x008b }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x0089 }
            java.lang.String r2 = m     // Catch:{ Throwable -> 0x0089 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x0089 }
            long r2 = r1.length()     // Catch:{ Throwable -> 0x0089 }
            int r4 = r9.available()     // Catch:{ Throwable -> 0x0089 }
            boolean r1 = r1.exists()     // Catch:{ Throwable -> 0x0089 }
            r5 = 1
            if (r1 == 0) goto L_0x0054
            long r6 = (long) r4     // Catch:{ Throwable -> 0x0089 }
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 != 0) goto L_0x0054
            r9.close()     // Catch:{ Throwable -> 0x0089 }
            r1 = r5
            goto L_0x0055
        L_0x0054:
            r1 = r0
        L_0x0055:
            if (r1 == 0) goto L_0x0069
            if (r9 == 0) goto L_0x0068
            r9.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0068
        L_0x005d:
            r9 = move-exception
            r9.printStackTrace()
            java.lang.String r0 = "ResourcesUtil"
            java.lang.String r1 = "copyResourceJarToAppFilesDir(Context ctx)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r9, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0068:
            return r5
        L_0x0069:
            f()     // Catch:{ Throwable -> 0x0089 }
            java.io.OutputStream r1 = a((java.io.InputStream) r9)     // Catch:{ Throwable -> 0x0089 }
            if (r9 == 0) goto L_0x0078
            r9.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x0078
        L_0x0076:
            r9 = move-exception
            goto L_0x007e
        L_0x0078:
            if (r1 == 0) goto L_0x0088
            r1.close()     // Catch:{ IOException -> 0x0076 }
            goto L_0x0088
        L_0x007e:
            r9.printStackTrace()
            java.lang.String r0 = "ResourcesUtil"
            java.lang.String r1 = "copyResourceJarToAppFilesDir(Context ctx)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r9, (java.lang.String) r0, (java.lang.String) r1)
        L_0x0088:
            return r5
        L_0x0089:
            r1 = move-exception
            goto L_0x0092
        L_0x008b:
            r0 = move-exception
            r9 = r1
            goto L_0x00af
        L_0x008e:
            r9 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
        L_0x0092:
            r1.printStackTrace()     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = "ResourcesUtil"
            java.lang.String r3 = "copyResourceJarToAppFilesDir(Context ctx)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ae }
            if (r9 == 0) goto L_0x00ad
            r9.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00ad
        L_0x00a2:
            r9 = move-exception
            r9.printStackTrace()
            java.lang.String r1 = "ResourcesUtil"
            java.lang.String r2 = "copyResourceJarToAppFilesDir(Context ctx)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)
        L_0x00ad:
            return r0
        L_0x00ae:
            r0 = move-exception
        L_0x00af:
            if (r9 == 0) goto L_0x00c0
            r9.close()     // Catch:{ IOException -> 0x00b5 }
            goto L_0x00c0
        L_0x00b5:
            r9 = move-exception
            r9.printStackTrace()
            java.lang.String r1 = "ResourcesUtil"
            java.lang.String r2 = "copyResourceJarToAppFilesDir(Context ctx)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)
        L_0x00c0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hs.b(android.content.Context):boolean");
    }

    private static OutputStream a(InputStream inputStream) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(new File(l, j));
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return fileOutputStream;
            }
            fileOutputStream.write(bArr, 0, read);
        }
    }

    private static void f() {
        File[] listFiles = new File(l).listFiles(new a());
        if (listFiles != null && listFiles.length > 0) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public static View a(Context context, int i2, ViewGroup viewGroup) {
        XmlResourceParser xml = a().getXml(i2);
        if (!d) {
            return LayoutInflater.from(context).inflate(xml, viewGroup);
        }
        try {
            View inflate = LayoutInflater.from(new hr(context, hs.class.getClassLoader())).inflate(xml, viewGroup);
            xml.close();
            return inflate;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.view.animation.Animation a(android.content.Context r3, int r4) throws android.content.res.Resources.NotFoundException {
        /*
            android.content.res.Resources$NotFoundException r0 = new android.content.res.Resources$NotFoundException
            r0.<init>()
            r1 = 0
            android.content.res.Resources r2 = a()     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x0027 }
            android.content.res.XmlResourceParser r4 = r2.getAnimation(r4)     // Catch:{ XmlPullParserException -> 0x0030, IOException -> 0x0027 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r4)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x001f, all -> 0x001c }
            android.view.animation.Animation r3 = a(r3, r4, r1, r2)     // Catch:{ XmlPullParserException -> 0x0022, IOException -> 0x001f, all -> 0x001c }
            if (r4 == 0) goto L_0x001b
            r4.close()
        L_0x001b:
            return r3
        L_0x001c:
            r3 = move-exception
            r1 = r4
            goto L_0x0039
        L_0x001f:
            r3 = move-exception
            r1 = r4
            goto L_0x0028
        L_0x0022:
            r3 = move-exception
            r1 = r4
            goto L_0x0031
        L_0x0025:
            r3 = move-exception
            goto L_0x0039
        L_0x0027:
            r3 = move-exception
        L_0x0028:
            java.lang.String r4 = "ResourcesUtil"
            java.lang.String r2 = "loadAnimation(Context context, int id)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0030:
            r3 = move-exception
        L_0x0031:
            java.lang.String r4 = "ResourcesUtil"
            java.lang.String r2 = "loadAnimation(Context context, int id)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r2)     // Catch:{ all -> 0x0025 }
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0039:
            if (r1 == 0) goto L_0x003e
            r1.close()
        L_0x003e:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hs.a(android.content.Context, int):android.view.animation.Animation");
    }

    private static Animation a(Context context, XmlPullParser xmlPullParser, AnimationSet animationSet, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int next;
        Animation animation;
        int depth = xmlPullParser.getDepth();
        do {
            next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
            }
        } while (next != 2);
        String name = xmlPullParser.getName();
        if (name.equals("set")) {
            animation = new AnimationSet(context, attributeSet);
            a(context, xmlPullParser, (AnimationSet) animation, attributeSet);
        } else if (name.equals("alpha")) {
            animation = new AlphaAnimation(context, attributeSet);
        } else if (name.equals("scale")) {
            animation = new ScaleAnimation(context, attributeSet);
        } else if (name.equals("rotate")) {
            animation = new RotateAnimation(context, attributeSet);
        } else if (name.equals("translate")) {
            animation = new TranslateAnimation(context, attributeSet);
        } else {
            throw new RuntimeException("Unknown animation name: " + xmlPullParser.getName());
        }
        if (animationSet != null) {
            animationSet.addAnimation(animation);
        }
        return animation;
    }
}
