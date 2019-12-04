package com.iflytek.cloud;

import android.os.Parcel;
import android.os.Parcelable;

public class EvaluatorResult implements Parcelable {
    public static final Parcelable.Creator<EvaluatorResult> CREATOR = new Parcelable.Creator<EvaluatorResult>() {
        /* renamed from: a */
        public EvaluatorResult createFromParcel(Parcel parcel) {
            return new EvaluatorResult(parcel);
        }

        /* renamed from: a */
        public EvaluatorResult[] newArray(int i) {
            return new EvaluatorResult[i];
        }
    };
    private String a;

    private EvaluatorResult(Parcel parcel) {
        this.a = "";
        this.a = parcel.readString();
    }

    public EvaluatorResult(String str) {
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
