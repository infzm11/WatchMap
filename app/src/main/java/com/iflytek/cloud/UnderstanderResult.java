package com.iflytek.cloud;

import android.os.Parcel;
import android.os.Parcelable;

public class UnderstanderResult implements Parcelable {
    public static final Parcelable.Creator<UnderstanderResult> CREATOR = new Parcelable.Creator<UnderstanderResult>() {
        /* renamed from: a */
        public UnderstanderResult createFromParcel(Parcel parcel) {
            return new UnderstanderResult(parcel);
        }

        /* renamed from: a */
        public UnderstanderResult[] newArray(int i) {
            return new UnderstanderResult[i];
        }
    };
    private String a = "";

    public UnderstanderResult(Parcel parcel) {
        this.a = parcel.readString();
    }

    public UnderstanderResult(String str) {
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
