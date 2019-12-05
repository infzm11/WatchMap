package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor((Bitmap) null);
        bitmapDescriptor.c = (Bitmap) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        bitmapDescriptor.a = parcel.readInt();
        bitmapDescriptor.b = parcel.readInt();
        return bitmapDescriptor;
    }

    public BitmapDescriptor[] newArray(int i) {
        return new BitmapDescriptor[i];
    }
}
