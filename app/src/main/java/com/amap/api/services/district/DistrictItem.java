package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new Parcelable.Creator<DistrictItem>() {
        /* renamed from: a */
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        /* renamed from: a */
        public DistrictItem[] newArray(int i) {
            return new DistrictItem[i];
        }
    };
    private String a;
    private String b;
    private String c;
    private LatLonPoint d;
    private String e;
    private List<DistrictItem> f = new ArrayList();
    private String[] g = new String[0];

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeString(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeInt(this.g.length);
        parcel.writeStringArray(this.g);
    }

    public void setDistrictBoundary(String[] strArr) {
        this.g = strArr;
    }

    public String[] districtBoundary() {
        return this.g;
    }

    public DistrictItem() {
    }

    public DistrictItem(String str, String str2, String str3, LatLonPoint latLonPoint, String str4) {
        this.c = str;
        this.a = str2;
        this.b = str3;
        this.d = latLonPoint;
        this.e = str4;
    }

    public String getCitycode() {
        return this.a;
    }

    public void setCitycode(String str) {
        this.a = str;
    }

    public String getAdcode() {
        return this.b;
    }

    public void setAdcode(String str) {
        this.b = str;
    }

    public String getName() {
        return this.c;
    }

    public void setName(String str) {
        this.c = str;
    }

    public LatLonPoint getCenter() {
        return this.d;
    }

    public void setCenter(LatLonPoint latLonPoint) {
        this.d = latLonPoint;
    }

    public String getLevel() {
        return this.e;
    }

    public void setLevel(String str) {
        this.e = str;
    }

    public List<DistrictItem> getSubDistrict() {
        return this.f;
    }

    public void setSubDistrict(ArrayList<DistrictItem> arrayList) {
        this.f = arrayList;
    }

    public DistrictItem(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.e = parcel.readString();
        this.f = parcel.createTypedArrayList(CREATOR);
        this.g = new String[parcel.readInt()];
        parcel.readStringArray(this.g);
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        int hashCode = ((((this.b == null ? 0 : this.b.hashCode()) + 31) * 31) + (this.d == null ? 0 : this.d.hashCode())) * 31;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        int hashCode2 = (((hashCode + i) * 31) + Arrays.hashCode(this.g)) * 31;
        if (this.f == null) {
            i2 = 0;
        } else {
            i2 = this.f.hashCode();
        }
        int hashCode3 = 31 * (((hashCode2 + i2) * 31) + (this.e == null ? 0 : this.e.hashCode()));
        if (this.c != null) {
            i3 = this.c.hashCode();
        }
        return hashCode3 + i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        if (this.b == null) {
            if (districtItem.b != null) {
                return false;
            }
        } else if (!this.b.equals(districtItem.b)) {
            return false;
        }
        if (this.d == null) {
            if (districtItem.d != null) {
                return false;
            }
        } else if (!this.d.equals(districtItem.d)) {
            return false;
        }
        if (this.a == null) {
            if (districtItem.a != null) {
                return false;
            }
        } else if (!this.a.equals(districtItem.a)) {
            return false;
        }
        if (!Arrays.equals(this.g, districtItem.g)) {
            return false;
        }
        if (this.f == null) {
            if (districtItem.f != null) {
                return false;
            }
        } else if (!this.f.equals(districtItem.f)) {
            return false;
        }
        if (this.e == null) {
            if (districtItem.e != null) {
                return false;
            }
        } else if (!this.e.equals(districtItem.e)) {
            return false;
        }
        if (this.c == null) {
            if (districtItem.c != null) {
                return false;
            }
        } else if (!this.c.equals(districtItem.c)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.a + ", mAdcode=" + this.b + ", mName=" + this.c + ", mCenter=" + this.d + ", mLevel=" + this.e + ", mDistricts=" + this.f + "]";
    }
}
