package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

public class RideRouteResult extends RouteResult implements Parcelable {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() {
        /* renamed from: a */
        public RideRouteResult createFromParcel(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        /* renamed from: a */
        public RideRouteResult[] newArray(int i) {
            return new RideRouteResult[i];
        }
    };
    private List<RidePath> a = new ArrayList();
    private RouteSearch.RideRouteQuery b;

    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.a;
    }

    public void setPaths(List<RidePath> list) {
        this.a = list;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.b;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.b = rideRouteQuery;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.a);
        parcel.writeParcelable(this.b, i);
    }

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.b = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    public RideRouteResult() {
    }
}
