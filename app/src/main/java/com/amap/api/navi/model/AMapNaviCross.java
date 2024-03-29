package com.amap.api.navi.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class AMapNaviCross {
    private Bitmap mBitmap;
    private int mHeight;
    private int mPicFormat;
    private int mWidth;

    public AMapNaviCross(int i, byte[] bArr, byte[] bArr2) {
        this.mPicFormat = i;
        try {
            this.mBitmap = eraseArrayBackground(BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length), BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public AMapNaviCross(int i, int i2, int i3, byte[] bArr) {
        this.mPicFormat = i;
        this.mHeight = i3;
        this.mWidth = i2;
        if (bArr.length == 0) {
            return;
        }
        if (i2 < 400 || i3 < 400) {
            this.mBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        this.mBitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
    }

    private Bitmap eraseArrayBackground(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap == null || bitmap2 == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[i];
        int i2 = width;
        int i3 = width;
        int i4 = height;
        bitmap.getPixels(iArr, 0, i2, 0, 0, i3, i4);
        bitmap2.getPixels(iArr2, 0, i2, 0, 0, i3, i4);
        int length = iArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (iArr[i5] == -65281) {
                iArr[i5] = iArr2[i5];
            }
        }
        bitmap.recycle();
        bitmap2.recycle();
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.RGB_565);
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public int getPicFormat() {
        return this.mPicFormat;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getHeight() {
        return this.mHeight;
    }
}
