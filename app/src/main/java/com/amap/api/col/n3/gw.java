package com.amap.api.col.n3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PoiItem */
public final class gw implements Parcelable {
    public static final Parcelable.Creator<gw> a = new Parcelable.Creator<gw>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new gw(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new gw[i];
        }
    };
    private gx A;
    private String B;
    private String C;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f = "";
    private int g = -1;
    private final gs h;
    private final String i;
    private final String j;
    private gs k;
    private gs l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private boolean t;
    private gm u;
    private String v;
    private String w;
    private String x;
    private List<hd> y = new ArrayList();
    private List<gu> z = new ArrayList();

    public final int describeContents() {
        return 0;
    }

    public gw(String str, gs gsVar, String str2, String str3) {
        this.b = str;
        this.h = gsVar;
        this.i = str2;
        this.j = str3;
    }

    public final void a(String str) {
        this.w = str;
    }

    public final void b(String str) {
        this.s = str;
    }

    public final void c(String str) {
        this.r = str;
    }

    public final void d(String str) {
        this.q = str;
    }

    public final void e(String str) {
        this.f = str;
    }

    public final void f(String str) {
        this.c = str;
    }

    public final void g(String str) {
        this.d = str;
    }

    public final void a(int i2) {
        this.g = i2;
    }

    public final String a() {
        return this.i;
    }

    public final gs b() {
        return this.h;
    }

    public final void h(String str) {
        this.e = str;
    }

    public final gs c() {
        return this.k;
    }

    public final void a(gs gsVar) {
        this.k = gsVar;
    }

    public final gs d() {
        return this.l;
    }

    public final void b(gs gsVar) {
        this.l = gsVar;
    }

    public final void i(String str) {
        this.m = str;
    }

    public final void j(String str) {
        this.n = str;
    }

    public final void k(String str) {
        this.o = str;
    }

    public final void l(String str) {
        this.p = str;
    }

    public final void a(boolean z2) {
        this.t = z2;
    }

    public final void m(String str) {
        this.v = str;
    }

    public final void n(String str) {
        this.x = str;
    }

    public final void a(List<hd> list) {
        this.y = list;
    }

    public final void a(gm gmVar) {
        this.u = gmVar;
    }

    public final void b(List<gu> list) {
        this.z = list;
    }

    public final void a(gx gxVar) {
        this.A = gxVar;
    }

    public final void o(String str) {
        this.B = str;
    }

    public final void p(String str) {
        this.C = str;
    }

    protected gw(Parcel parcel) {
        this.b = parcel.readString();
        this.d = parcel.readString();
        this.c = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readInt();
        this.h = (gs) parcel.readValue(gs.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.e = parcel.readString();
        this.k = (gs) parcel.readValue(gs.class.getClassLoader());
        this.l = (gs) parcel.readValue(gs.class.getClassLoader());
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.t = zArr[0];
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.x = parcel.readString();
        this.y = parcel.readArrayList(hd.class.getClassLoader());
        this.u = (gm) parcel.readValue(gm.class.getClassLoader());
        this.z = parcel.createTypedArrayList(gu.a);
        this.A = (gx) parcel.readParcelable(gx.class.getClassLoader());
        this.B = parcel.readString();
        this.C = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.b);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeValue(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.e);
        parcel.writeValue(this.k);
        parcel.writeValue(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeBooleanArray(new boolean[]{this.t});
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeList(this.y);
        parcel.writeValue(this.u);
        parcel.writeTypedList(this.z);
        parcel.writeParcelable(this.A, i2);
        parcel.writeString(this.B);
        parcel.writeString(this.C);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        gw gwVar = (gw) obj;
        if (this.b == null) {
            if (gwVar.b != null) {
                return false;
            }
        } else if (!this.b.equals(gwVar.b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 31 + (this.b == null ? 0 : this.b.hashCode());
    }

    public final String toString() {
        return this.i;
    }
}
