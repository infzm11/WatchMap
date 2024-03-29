package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

/* renamed from: com.amap.api.col.n3.do  reason: invalid class name */
/* compiled from: NinePatchTool */
public final class Cdo {
    public static Drawable a(Context context, String str) throws Exception {
        int i;
        Bitmap bitmap;
        InputStream open = dr.a(context).open(str);
        Bitmap decodeStream = BitmapFactory.decodeStream(open);
        int width = decodeStream.getWidth();
        int height = decodeStream.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 0; i2 < 32; i2++) {
            byteArrayOutputStream.write(0);
        }
        int i3 = width - 2;
        int[] iArr = new int[i3];
        decodeStream.getPixels(iArr, 0, width, 1, 0, i3, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[iArr.length - 1] == -16777216;
        int length = iArr.length;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            if (i4 != iArr[i6]) {
                i5++;
                a((OutputStream) byteArrayOutputStream, i6);
                i4 = iArr[i6];
            }
        }
        if (z2) {
            i5++;
            a((OutputStream) byteArrayOutputStream, iArr.length);
        }
        int i7 = i5;
        int i8 = i7 + 1;
        if (z) {
            i8--;
        }
        if (z2) {
            i8--;
        }
        int i9 = i8;
        int i10 = height - 2;
        int[] iArr2 = new int[i10];
        decodeStream.getPixels(iArr2, 0, 1, 0, 1, 1, i10);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[iArr2.length - 1] == -16777216;
        int length2 = iArr2.length;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < length2; i13++) {
            if (i11 != iArr2[i13]) {
                i12++;
                a((OutputStream) byteArrayOutputStream, i13);
                i11 = iArr2[i13];
            }
        }
        if (z4) {
            i12++;
            a((OutputStream) byteArrayOutputStream, iArr2.length);
        }
        int i14 = i12 + 1;
        if (z3) {
            i14--;
        }
        if (z4) {
            i14--;
        }
        int i15 = 0;
        while (true) {
            i = i9 * i14;
            if (i15 >= i) {
                break;
            }
            a((OutputStream) byteArrayOutputStream, 1);
            i15++;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray[0] = 1;
        byteArray[1] = (byte) i7;
        byteArray[2] = (byte) i12;
        byteArray[3] = (byte) i;
        a(decodeStream, byteArray);
        if (NinePatch.isNinePatchChunk(byteArray)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            decodeStream.recycle();
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, byteArray);
            bitmap = createBitmap;
        } else {
            bitmap = decodeStream;
        }
        open.close();
        if (bitmap.getNinePatchChunk() == null) {
            return new BitmapDrawable(bitmap);
        }
        Rect rect = new Rect();
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        rect.left = a(ninePatchChunk, 12);
        rect.right = a(ninePatchChunk, 16);
        rect.top = a(ninePatchChunk, 20);
        rect.bottom = a(ninePatchChunk, 24);
        NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, bitmap.getNinePatchChunk(), rect, (String) null);
        return ninePatchDrawable;
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[(bitmap.getWidth() - 2)];
        int i = 0;
        bitmap.getPixels(iArr, 0, iArr.length, 1, bitmap.getHeight() - 1, iArr.length, 1);
        int i2 = 0;
        while (true) {
            if (i2 >= iArr.length) {
                break;
            } else if (-16777216 == iArr[i2]) {
                a(bArr2, 12, i2);
                break;
            } else {
                i2++;
            }
        }
        int length = iArr.length - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (-16777216 == iArr[length]) {
                a(bArr2, 16, (iArr.length - length) - 2);
                break;
            } else {
                length--;
            }
        }
        int[] iArr2 = new int[(bitmap.getHeight() - 2)];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, iArr2.length);
        while (true) {
            if (i >= iArr2.length) {
                break;
            } else if (-16777216 == iArr2[i]) {
                a(bArr2, 20, i);
                break;
            } else {
                i++;
            }
        }
        for (int length2 = iArr2.length - 1; length2 >= 0; length2--) {
            if (-16777216 == iArr2[length2]) {
                a(bArr2, 24, (iArr2.length - length2) - 2);
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static int a(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << 24) | (b & 255) | (b2 << 8) | (b3 << 16);
    }
}
