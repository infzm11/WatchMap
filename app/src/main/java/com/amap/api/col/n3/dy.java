package com.amap.api.col.n3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: ImageResizer */
public class dy extends dz {
    protected int a;
    protected int b;

    public dy(Context context, int i, int i2) {
        super(context);
        this.a = i;
        this.b = i2;
    }

    /* access modifiers changed from: protected */
    public Bitmap a(Object obj) {
        int parseInt = Integer.parseInt(String.valueOf(obj));
        Resources resources = this.d;
        int i = this.a;
        int i2 = this.b;
        a();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, parseInt, options);
        options.inSampleSize = a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, parseInt, options);
    }

    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        int round2 = Math.round(((float) i4) / ((float) i));
        if (round >= round2) {
            round = round2;
        }
        while (((float) (i4 * i3)) / ((float) (round * round)) > ((float) (i * i2 * 2))) {
            round++;
        }
        return round;
    }
}
