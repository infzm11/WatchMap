package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        int readInt = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e) {
                e = e;
            }
        } catch (BadParcelableException e2) {
            e = e2;
            latLng2 = null;
            e.printStackTrace();
            latLng = null;
            return new LatLngBounds(readInt, latLng2, latLng);
        }
        return new LatLngBounds(readInt, latLng2, latLng);
    }

    public LatLngBounds[] newArray(int i) {
        return new LatLngBounds[i];
    }

    static void a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i);
        parcel.writeParcelable(latLngBounds.northeast, i);
    }
}
