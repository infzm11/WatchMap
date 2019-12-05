package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TileProjectionCreator implements Parcelable.Creator<TileProjection> {
    public TileProjection createFromParcel(Parcel parcel) {
        TileProjection tileProjection = new TileProjection(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        return tileProjection;
    }

    public TileProjection[] newArray(int i) {
        return new TileProjection[i];
    }
}
