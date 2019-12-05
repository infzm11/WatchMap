package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.AMapException;
import java.util.ArrayList;

public final class DistrictResult implements Parcelable {
    public Parcelable.Creator<DistrictResult> CREATOR = new Parcelable.Creator<DistrictResult>() {
        /* renamed from: a */
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        /* renamed from: a */
        public DistrictResult[] newArray(int i) {
            return new DistrictResult[i];
        }
    };
    private DistrictSearchQuery a;
    private ArrayList<DistrictItem> b = new ArrayList<>();
    private int c;
    private AMapException d;

    public int describeContents() {
        return 0;
    }

    public DistrictResult(DistrictSearchQuery districtSearchQuery, ArrayList<DistrictItem> arrayList) {
        this.a = districtSearchQuery;
        this.b = arrayList;
    }

    public DistrictResult() {
    }

    public ArrayList<DistrictItem> getDistrict() {
        return this.b;
    }

    public void setDistrict(ArrayList<DistrictItem> arrayList) {
        this.b = arrayList;
    }

    public DistrictSearchQuery getQuery() {
        return this.a;
    }

    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.a = districtSearchQuery;
    }

    public int getPageCount() {
        return this.c;
    }

    public void setPageCount(int i) {
        this.c = i;
    }

    public AMapException getAMapException() {
        return this.d;
    }

    public void setAMapException(AMapException aMapException) {
        this.d = aMapException;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeTypedList(this.b);
    }

    protected DistrictResult(Parcel parcel) {
        this.a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        int i3 = 31 * (i + 31);
        if (this.b != null) {
            i2 = this.b.hashCode();
        }
        return i3 + i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        if (this.a == null) {
            if (districtResult.a != null) {
                return false;
            }
        } else if (!this.a.equals(districtResult.a)) {
            return false;
        }
        if (this.b == null) {
            if (districtResult.b != null) {
                return false;
            }
        } else if (!this.b.equals(districtResult.b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.a + ", mDistricts=" + this.b + "]";
    }
}
