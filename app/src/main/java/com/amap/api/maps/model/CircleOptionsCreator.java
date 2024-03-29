package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public CircleOptions createFromParcel(Parcel parcel) {
        CircleOptions circleOptions = new CircleOptions();
        Bundle readBundle = parcel.readBundle();
        circleOptions.center(new LatLng(readBundle.getDouble("lat"), readBundle.getDouble("lng")));
        circleOptions.radius(parcel.readDouble());
        circleOptions.strokeWidth(parcel.readFloat());
        circleOptions.strokeColor(parcel.readInt());
        circleOptions.fillColor(parcel.readInt());
        circleOptions.zIndex((float) parcel.readInt());
        boolean z = true;
        if (parcel.readByte() != 1) {
            z = false;
        }
        circleOptions.visible(z);
        circleOptions.a = parcel.readString();
        return circleOptions;
    }

    public CircleOptions[] newArray(int i) {
        return new CircleOptions[i];
    }
}
