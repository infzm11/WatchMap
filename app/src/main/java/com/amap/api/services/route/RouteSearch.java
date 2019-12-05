package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.a.au;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.a.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.ArrayList;
import java.util.List;

public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;
    private IRouteSearch a;

    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new Parcelable.Creator<BusRouteQuery>() {
            /* renamed from: a */
            public BusRouteQuery createFromParcel(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            /* renamed from: a */
            public BusRouteQuery[] newArray(int i) {
                return new BusRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private String c;
        private String d;
        private int e;

        public int describeContents() {
            return 0;
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i, String str, int i2) {
            this.a = fromAndTo;
            this.b = i;
            this.c = str;
            this.e = i2;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public String getCity() {
            return this.c;
        }

        public int getNightFlag() {
            return this.e;
        }

        public String getCityd() {
            return this.d;
        }

        public void setCityd(String str) {
            this.d = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeString(this.c);
            parcel.writeInt(this.e);
            parcel.writeString(this.d);
        }

        public BusRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.readString();
            this.e = parcel.readInt();
            this.d = parcel.readString();
        }

        public BusRouteQuery() {
        }

        public int hashCode() {
            int i = 0;
            int hashCode = 31 * ((((((((this.c == null ? 0 : this.c.hashCode()) + 31) * 31) + (this.a == null ? 0 : this.a.hashCode())) * 31) + this.b) * 31) + this.e);
            if (this.d != null) {
                i = this.d.hashCode();
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            if (this.c == null) {
                if (busRouteQuery.c != null) {
                    return false;
                }
            } else if (!this.c.equals(busRouteQuery.c)) {
                return false;
            }
            if (this.d == null) {
                if (busRouteQuery.d != null) {
                    return false;
                }
            } else if (!this.d.equals(busRouteQuery.d)) {
                return false;
            }
            if (this.a == null) {
                if (busRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(busRouteQuery.a)) {
                return false;
            }
            return this.b == busRouteQuery.b && this.e == busRouteQuery.e;
        }

        public BusRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.a, this.b, this.c, this.e);
            busRouteQuery.setCityd(this.d);
            return busRouteQuery;
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() {
            /* renamed from: a */
            public DriveRouteQuery createFromParcel(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            /* renamed from: a */
            public DriveRouteQuery[] newArray(int i) {
                return new DriveRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;
        private List<LatLonPoint> c;
        private List<List<LatLonPoint>> d;
        private String e;

        public int describeContents() {
            return 0;
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.a = fromAndTo;
            this.b = i;
            this.c = list;
            this.d = list2;
            this.e = str;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.c;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.d;
        }

        public String getAvoidRoad() {
            return this.e;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.c == null || this.c.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.c.size(); i++) {
                LatLonPoint latLonPoint = this.c.get(i);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i < this.c.size() - 1) {
                    stringBuffer.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasPassPoint() {
            return !i.a(getPassedPointStr());
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.d == null || this.d.size() == 0) {
                return null;
            }
            for (int i = 0; i < this.d.size(); i++) {
                List list = this.d.get(i);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LatLonPoint latLonPoint = (LatLonPoint) list.get(i2);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i2 < list.size() - 1) {
                        stringBuffer.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                    }
                }
                if (i < this.d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidpolygons() {
            return !i.a(getAvoidpolygonsStr());
        }

        public boolean hasAvoidRoad() {
            return !i.a(getAvoidRoad());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
            parcel.writeTypedList(this.c);
            if (this.d == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(this.d.size());
                for (List<LatLonPoint> writeTypedList : this.d) {
                    parcel.writeTypedList(writeTypedList);
                }
            }
            parcel.writeString(this.e);
        }

        public DriveRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
            this.c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.d = null;
            } else {
                this.d = new ArrayList();
            }
            for (int i = 0; i < readInt; i++) {
                this.d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.e = parcel.readString();
        }

        public DriveRouteQuery() {
        }

        public int hashCode() {
            int i = 0;
            int hashCode = 31 * ((((((((this.e == null ? 0 : this.e.hashCode()) + 31) * 31) + (this.d == null ? 0 : this.d.hashCode())) * 31) + (this.a == null ? 0 : this.a.hashCode())) * 31) + this.b);
            if (this.c != null) {
                i = this.c.hashCode();
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            if (this.e == null) {
                if (driveRouteQuery.e != null) {
                    return false;
                }
            } else if (!this.e.equals(driveRouteQuery.e)) {
                return false;
            }
            if (this.d == null) {
                if (driveRouteQuery.d != null) {
                    return false;
                }
            } else if (!this.d.equals(driveRouteQuery.d)) {
                return false;
            }
            if (this.a == null) {
                if (driveRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(driveRouteQuery.a)) {
                return false;
            }
            if (this.b != driveRouteQuery.b) {
                return false;
            }
            if (this.c == null) {
                if (driveRouteQuery.c != null) {
                    return false;
                }
            } else if (!this.c.equals(driveRouteQuery.c)) {
                return false;
            }
            return true;
        }

        public DriveRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.a, this.b, this.c, this.d, this.e);
            return driveRouteQuery;
        }
    }

    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() {
            /* renamed from: a */
            public FromAndTo createFromParcel(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            /* renamed from: a */
            public FromAndTo[] newArray(int i) {
                return new FromAndTo[i];
            }
        };
        private LatLonPoint a;
        private LatLonPoint b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public int describeContents() {
            return 0;
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public String getOriginType() {
            return this.e;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public String getDestinationType() {
            return this.f;
        }

        public void setDestinationType(String str) {
            this.f = str;
        }

        public String getPlateNumber() {
            return this.g;
        }

        public void setPlateNumber(String str) {
            this.g = str;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }

        public FromAndTo(Parcel parcel) {
            this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo() {
        }

        public int hashCode() {
            int i = 0;
            int hashCode = 31 * ((((((((((this.d == null ? 0 : this.d.hashCode()) + 31) * 31) + (this.a == null ? 0 : this.a.hashCode())) * 31) + (this.c == null ? 0 : this.c.hashCode())) * 31) + (this.b == null ? 0 : this.b.hashCode())) * 31) + (this.e == null ? 0 : this.e.hashCode()));
            if (this.f != null) {
                i = this.f.hashCode();
            }
            return hashCode + i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FromAndTo fromAndTo = (FromAndTo) obj;
            if (this.d == null) {
                if (fromAndTo.d != null) {
                    return false;
                }
            } else if (!this.d.equals(fromAndTo.d)) {
                return false;
            }
            if (this.a == null) {
                if (fromAndTo.a != null) {
                    return false;
                }
            } else if (!this.a.equals(fromAndTo.a)) {
                return false;
            }
            if (this.c == null) {
                if (fromAndTo.c != null) {
                    return false;
                }
            } else if (!this.c.equals(fromAndTo.c)) {
                return false;
            }
            if (this.b == null) {
                if (fromAndTo.b != null) {
                    return false;
                }
            } else if (!this.b.equals(fromAndTo.b)) {
                return false;
            }
            if (this.e == null) {
                if (fromAndTo.e != null) {
                    return false;
                }
            } else if (!this.e.equals(fromAndTo.e)) {
                return false;
            }
            if (this.f == null) {
                if (fromAndTo.f != null) {
                    return false;
                }
            } else if (!this.f.equals(fromAndTo.f)) {
                return false;
            }
            return true;
        }

        public FromAndTo clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e2) {
                i.a(e2, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i);
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new Parcelable.Creator<RideRouteQuery>() {
            /* renamed from: a */
            public RideRouteQuery createFromParcel(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            /* renamed from: a */
            public RideRouteQuery[] newArray(int i) {
                return new RideRouteQuery[i];
            }
        };
        private FromAndTo a;
        private int b;

        public int describeContents() {
            return 0;
        }

        public RideRouteQuery(FromAndTo fromAndTo, int i) {
            this.a = fromAndTo;
            this.b = i;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.a = fromAndTo;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
        }

        public RideRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
        }

        public RideRouteQuery() {
        }

        public int hashCode() {
            return (31 * ((this.a == null ? 0 : this.a.hashCode()) + 31)) + this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.a == null) {
                if (walkRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(walkRouteQuery.a)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public RideRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearch", "RideRouteQueryclone");
            }
            return new RideRouteQuery(this.a);
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new Parcelable.Creator<WalkRouteQuery>() {
            /* renamed from: a */
            public WalkRouteQuery createFromParcel(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            /* renamed from: a */
            public WalkRouteQuery[] newArray(int i) {
                return new WalkRouteQuery[i];
            }
        };
        /* access modifiers changed from: private */
        public FromAndTo a;
        /* access modifiers changed from: private */
        public int b;

        public int describeContents() {
            return 0;
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i) {
            this.a = fromAndTo;
            this.b = i;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.a = fromAndTo;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public int getMode() {
            return this.b;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeInt(this.b);
        }

        public WalkRouteQuery(Parcel parcel) {
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.b = parcel.readInt();
        }

        public WalkRouteQuery() {
        }

        public int hashCode() {
            return (31 * ((this.a == null ? 0 : this.a.hashCode()) + 31)) + this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            if (this.a == null) {
                if (walkRouteQuery.a != null) {
                    return false;
                }
            } else if (!this.a.equals(walkRouteQuery.a)) {
                return false;
            }
            return this.b == walkRouteQuery.b;
        }

        public WalkRouteQuery clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                i.a(e, "RouteSearch", "WalkRouteQueryclone");
            }
            return new WalkRouteQuery(this.a);
        }
    }

    public RouteSearch(Context context) {
        try {
            Context context2 = context;
            this.a = (IRouteSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.RouteSearchWrapper", au.class, new Class[]{Context.class}, new Object[]{context});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new au(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        if (this.a != null) {
            this.a.setRouteSearchListener(onRouteSearchListener);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        if (this.a != null) {
            return this.a.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        if (this.a != null) {
            this.a.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        if (this.a != null) {
            return this.a.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        if (this.a != null) {
            this.a.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        if (this.a != null) {
            return this.a.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        if (this.a != null) {
            this.a.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        if (this.a != null) {
            this.a.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        if (this.a != null) {
            return this.a.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }
}
