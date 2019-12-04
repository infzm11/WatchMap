package com.iflytek.cloud;

import android.os.Parcel;
import android.os.Parcelable;

public class RecognizerResult implements Parcelable {
    public static final Parcelable.Creator<RecognizerResult> CREATOR = new Parcelable.Creator<RecognizerResult>() {
        /* renamed from: a */
        public RecognizerResult createFromParcel(Parcel parcel) {
            return new RecognizerResult(parcel);
        }

        /* renamed from: a */
        public RecognizerResult[] newArray(int i) {
            return new RecognizerResult[i];
        }
    };
    private String a = "";

    public RecognizerResult(Parcel parcel) {
        this.a = parcel.readString();
    }

    public RecognizerResult(String str) {
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
