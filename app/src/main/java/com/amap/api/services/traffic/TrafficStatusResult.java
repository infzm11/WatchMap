package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class TrafficStatusResult implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusResult> CREATOR = new Parcelable.Creator<TrafficStatusResult>() {
        /* renamed from: a */
        public TrafficStatusResult createFromParcel(Parcel parcel) {
            return new TrafficStatusResult(parcel);
        }

        /* renamed from: a */
        public TrafficStatusResult[] newArray(int i) {
            return new TrafficStatusResult[i];
        }
    };
    private String a;
    private TrafficStatusEvaluation b;
    private List<TrafficStatusInfo> c;

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.a;
    }

    public void setDescription(String str) {
        this.a = str;
    }

    public TrafficStatusEvaluation getEvaluation() {
        return this.b;
    }

    public void setEvaluation(TrafficStatusEvaluation trafficStatusEvaluation) {
        this.b = trafficStatusEvaluation;
    }

    public List<TrafficStatusInfo> getRoads() {
        return this.c;
    }

    public void setRoads(List<TrafficStatusInfo> list) {
        this.c = list;
    }

    public TrafficStatusResult() {
    }

    protected TrafficStatusResult(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (TrafficStatusEvaluation) parcel.readParcelable(TrafficStatusEvaluation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(TrafficStatusInfo.CREATOR);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
    }
}
