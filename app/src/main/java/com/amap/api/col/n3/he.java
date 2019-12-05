package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: Tip */
public final class he implements Parcelable {
    public static final Parcelable.Creator<he> a = new Parcelable.Creator<he>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return null;
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new he(parcel, (byte) 0);
        }
    };
    private String b;
    private gs c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ he(Parcel parcel, byte b2) {
        this(parcel);
    }

    public he() {
    }

    public final String a() {
        return this.b;
    }

    public final void a(String str) {
        this.b = str;
    }

    public final gs b() {
        return this.c;
    }

    public final void a(gs gsVar) {
        this.c = gsVar;
    }

    public final String c() {
        return this.d;
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void c(String str) {
        this.e = str;
    }

    public final void d(String str) {
        this.f = str;
    }

    public final String d() {
        return this.g;
    }

    public final void e(String str) {
        this.g = str;
    }

    public final void f(String str) {
        this.h = str;
    }

    public final String toString() {
        return "name:" + this.d + " district:" + this.e + " adcode:" + this.f;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.f);
        parcel.writeString(this.e);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
    }

    private he(Parcel parcel) {
        this.d = parcel.readString();
        this.f = parcel.readString();
        this.e = parcel.readString();
        this.b = parcel.readString();
        this.c = (gs) parcel.readValue(gs.class.getClassLoader());
        this.g = parcel.readString();
        this.h = parcel.readString();
    }
}
