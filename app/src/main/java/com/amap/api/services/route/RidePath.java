package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class RidePath extends Path implements Parcelable {
    public static final Parcelable.Creator<RidePath> CREATOR = new Parcelable.Creator<RidePath>() {
        /* renamed from: a */
        public RidePath[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }
    };
    private List<RideStep> a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<RideStep> getSteps() {
        return this.a;
    }

    public void setSteps(List<RideStep> list) {
        this.a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    public RidePath() {
    }
}
