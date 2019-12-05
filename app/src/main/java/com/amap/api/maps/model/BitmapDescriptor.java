package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    int a = 0;
    int b = 0;
    Bitmap c;

    public final int describeContents() {
        return 0;
    }

    BitmapDescriptor(Bitmap bitmap) {
        if (bitmap != null) {
            this.a = bitmap.getWidth();
            this.b = bitmap.getHeight();
            if (bitmap.getConfig() == null) {
                this.c = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            } else {
                this.c = bitmap.copy(bitmap.getConfig(), true);
            }
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = bitmap;
    }

    public final BitmapDescriptor clone() {
        try {
            return new BitmapDescriptor(this.c.copy(this.c.getConfig(), true), this.a, this.b);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Bitmap getBitmap() {
        return this.c;
    }

    public final int getWidth() {
        return this.a;
    }

    public final int getHeight() {
        return this.b;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
    }

    public final void recycle() {
        if (this.c != null && !this.c.isRecycled()) {
            this.c.recycle();
            this.c = null;
        }
    }

    public final boolean equals(Object obj) {
        if (this.c == null || this.c.isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) obj;
        if (bitmapDescriptor.c == null || bitmapDescriptor.c.isRecycled() || this.a != bitmapDescriptor.getWidth() || this.b != bitmapDescriptor.getHeight()) {
            return false;
        }
        try {
            return this.c.sameAs(bitmapDescriptor.c);
        } catch (Throwable unused) {
            return false;
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
