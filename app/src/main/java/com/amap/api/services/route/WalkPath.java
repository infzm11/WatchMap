package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class WalkPath extends Path implements Parcelable {
    public static final Parcelable.Creator<WalkPath> CREATOR = new Parcelable.Creator<WalkPath>() {
        /* renamed from: a */
        public WalkPath[] newArray(int i) {
            return null;
        }

        /* renamed from: a */
        public WalkPath createFromParcel(Parcel parcel) {
            return new WalkPath(parcel);
        }
    };
    private List<WalkStep> a = new ArrayList();

    public int describeContents() {
        return 0;
    }

    public List<WalkStep> getSteps() {
        return this.a;
    }

    public void setSteps(List<WalkStep> list) {
        this.a = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    public WalkPath() {
    }
}
