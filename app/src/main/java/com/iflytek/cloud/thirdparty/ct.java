package com.iflytek.cloud.thirdparty;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.TypedValue;
import java.io.InputStream;

public class ct {
    private static int a;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r2 != 65535) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.res.Resources r1, android.util.TypedValue r2, java.io.InputStream r3, android.graphics.Rect r4, android.graphics.BitmapFactory.Options r5) {
        /*
            if (r5 != 0) goto L_0x0007
            android.graphics.BitmapFactory$Options r5 = new android.graphics.BitmapFactory$Options
            r5.<init>()
        L_0x0007:
            int r0 = r5.inDensity
            if (r0 != 0) goto L_0x001c
            if (r2 == 0) goto L_0x001c
            int r2 = r2.density
            if (r2 != 0) goto L_0x0016
            r2 = 160(0xa0, float:2.24E-43)
        L_0x0013:
            r5.inDensity = r2
            goto L_0x001c
        L_0x0016:
            r0 = 65535(0xffff, float:9.1834E-41)
            if (r2 == r0) goto L_0x001c
            goto L_0x0013
        L_0x001c:
            int r2 = r5.inTargetDensity
            if (r2 != 0) goto L_0x002a
            if (r1 == 0) goto L_0x002a
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.densityDpi
            r5.inTargetDensity = r1
        L_0x002a:
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r3, r4, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ct.a(android.content.res.Resources, android.util.TypedValue, java.io.InputStream, android.graphics.Rect, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static Drawable a(Resources resources, Bitmap bitmap, byte[] bArr, Rect rect, String str) {
        if (bArr == null) {
            return new BitmapDrawable(resources, bitmap);
        }
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(resources, bitmap, bArr, rect, str);
        return ninePatchDrawable;
    }

    public static Drawable a(Resources resources, TypedValue typedValue, InputStream inputStream, String str, BitmapFactory.Options options) {
        Rect rect = null;
        if (inputStream == null) {
            return null;
        }
        Rect rect2 = new Rect();
        if (options == null) {
            options = new BitmapFactory.Options();
        }
        Bitmap a2 = a(resources, typedValue, inputStream, rect2, options);
        if (a2 == null) {
            return null;
        }
        byte[] ninePatchChunk = a2.getNinePatchChunk();
        if (ninePatchChunk == null || !NinePatch.isNinePatchChunk(ninePatchChunk)) {
            ninePatchChunk = null;
        } else {
            rect = rect2;
        }
        return a(resources, a2, ninePatchChunk, rect, str);
    }
}
