package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: TileCreator */
final class b implements Parcelable.Creator<Tile> {
    b() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new Tile[i];
    }
}
