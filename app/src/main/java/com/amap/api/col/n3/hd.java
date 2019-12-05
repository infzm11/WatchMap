package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: SubPoiItem */
public class hd implements Parcelable {
    public static final Parcelable.Creator<hd> a = new Parcelable.Creator<hd>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return null;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new hd(parcel);
        }
    };
    private String b;
    private String c;
    private String d;
    private int e;
    private gs f;
    private String g;
    private String h;

    public int describeContents() {
        return 0;
    }

    public hd(String str, gs gsVar, String str2, String str3) {
        this.b = str;
        this.f = gsVar;
        this.c = str2;
        this.g = str3;
    }

    public hd(Parcel parcel) {
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = (gs) parcel.readValue(gs.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(int i) {
        this.e = i;
    }

    public final void b(String str) {
        this.h = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeValue(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }
}
