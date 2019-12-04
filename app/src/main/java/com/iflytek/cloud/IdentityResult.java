package com.iflytek.cloud;

import android.os.Parcel;
import android.os.Parcelable;

public class IdentityResult implements Parcelable {
    public static final Parcelable.Creator<IdentityResult> CREATOR = new Parcelable.Creator<IdentityResult>() {
        /* renamed from: a */
        public IdentityResult createFromParcel(Parcel parcel) {
            return new IdentityResult(parcel);
        }

        /* renamed from: a */
        public IdentityResult[] newArray(int i) {
            return new IdentityResult[i];
        }
    };
    private String a;

    private IdentityResult(Parcel parcel) {
        this.a = "";
        this.a = parcel.readString();
    }

    public IdentityResult(String str) {
        this.a = "";
        if (str != null) {
            this.a = str;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getResultString() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }
}
