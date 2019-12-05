package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class PolygonHoleOptions extends BaseHoleOptions implements Parcelable {
    public static final Parcelable.Creator<PolygonHoleOptions> CREATOR = new Parcelable.Creator<PolygonHoleOptions>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PolygonHoleOptions(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PolygonHoleOptions[i];
        }
    };
    private final List<LatLng> a;

    public int describeContents() {
        return 0;
    }

    public PolygonHoleOptions() {
        this.a = new ArrayList();
    }

    protected PolygonHoleOptions(Parcel parcel) {
        this.a = parcel.createTypedArrayList(LatLng.CREATOR);
    }

    public PolygonHoleOptions addAll(Iterable<LatLng> iterable) {
        try {
            for (LatLng add : iterable) {
                this.a.add(add);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this;
    }

    public List<LatLng> getPoints() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.a);
    }
}
