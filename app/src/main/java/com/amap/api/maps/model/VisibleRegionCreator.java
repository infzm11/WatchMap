package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLngBounds latLngBounds;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        int readInt = parcel.readInt();
        try {
            latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                } catch (BadParcelableException e) {
                    e = e;
                    latLng2 = null;
                    latLng = latLng2;
                    e.printStackTrace();
                    latLngBounds = null;
                    VisibleRegion visibleRegion = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                    return visibleRegion;
                }
            } catch (BadParcelableException e2) {
                e = e2;
                latLng3 = null;
                latLng2 = latLng3;
                latLng = latLng2;
                e.printStackTrace();
                latLngBounds = null;
                VisibleRegion visibleRegion2 = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                return visibleRegion2;
            }
            try {
                latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                } catch (BadParcelableException e3) {
                    e = e3;
                    e.printStackTrace();
                    latLngBounds = null;
                    VisibleRegion visibleRegion22 = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                    return visibleRegion22;
                }
            } catch (BadParcelableException e4) {
                e = e4;
                latLng = null;
                e.printStackTrace();
                latLngBounds = null;
                VisibleRegion visibleRegion222 = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
                return visibleRegion222;
            }
        } catch (BadParcelableException e5) {
            e = e5;
            latLng4 = null;
            latLng3 = null;
            latLng2 = latLng3;
            latLng = latLng2;
            e.printStackTrace();
            latLngBounds = null;
            VisibleRegion visibleRegion2222 = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
            return visibleRegion2222;
        }
        VisibleRegion visibleRegion22222 = new VisibleRegion(readInt, latLng4, latLng3, latLng2, latLng, latLngBounds);
        return visibleRegion22222;
    }

    public VisibleRegion[] newArray(int i) {
        return new VisibleRegion[i];
    }

    static void a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i);
        parcel.writeParcelable(visibleRegion.nearRight, i);
        parcel.writeParcelable(visibleRegion.farLeft, i);
        parcel.writeParcelable(visibleRegion.farRight, i);
        parcel.writeParcelable(visibleRegion.latLngBounds, i);
    }
}
