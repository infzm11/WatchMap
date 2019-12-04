package com.iflytek.cloud.thirdparty;

import android.os.Parcel;
import android.os.Parcelable;

public class dd implements Parcelable {
    public static final Parcelable.Creator<dd> CREATOR = new Parcelable.Creator<dd>() {
        /* renamed from: a */
        public dd createFromParcel(Parcel parcel) {
            dd ddVar = new dd();
            String unused = ddVar.a = parcel.readString();
            String unused2 = ddVar.b = parcel.readString();
            String unused3 = ddVar.c = parcel.readString();
            String unused4 = ddVar.d = parcel.readString();
            String unused5 = ddVar.e = parcel.readString();
            String unused6 = ddVar.f = parcel.readString();
            String unused7 = ddVar.g = parcel.readString();
            return ddVar;
        }

        /* renamed from: a */
        public dd[] newArray(int i) {
            return new dd[i];
        }
    };
    /* access modifiers changed from: private */
    public String a = null;
    /* access modifiers changed from: private */
    public String b = null;
    /* access modifiers changed from: private */
    public String c = null;
    /* access modifiers changed from: private */
    public String d = null;
    /* access modifiers changed from: private */
    public String e = null;
    /* access modifiers changed from: private */
    public String f = null;
    /* access modifiers changed from: private */
    public String g = null;

    public dd() {
    }

    public dd(String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.g = str6;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
    }
}
