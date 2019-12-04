package com.iflytek.clientadapter.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class RouteInfo implements Parcelable {
    public static final Parcelable.Creator<RouteInfo> CREATOR = new Parcelable.Creator<RouteInfo>() {
        public RouteInfo createFromParcel(Parcel parcel) {
            return new RouteInfo(parcel);
        }

        public RouteInfo[] newArray(int i) {
            return new RouteInfo[i];
        }
    };
    private static String CUR_ROAD_NAME;
    private static int CUR_SPEED;
    private static int LIMETED_SPEED;
    private static String NEXT_ROAD_NAME;
    private static int ROUTE_ALL_DIS;
    private static int ROUTE_ALL_TIME;
    private static int ROUTE_REMAIN_DIS;
    private static int ROUTE_REMAIN_TIME;
    private static int SEG_REMAIN_DIS;
    private static int SEG_REMAIN_TIME;
    private int EXTRA_DEV;
    private double EXTRA_FMIDLAT;
    private double EXTRA_FMIDLON;
    private String EXTRA_FMIDNAME;
    private double EXTRA_SMIDLAT;
    private double EXTRA_SMIDLON;
    private String EXTRA_SMIDNAME;
    private double EXTRA_TMIDLAT;
    private double EXTRA_TMIDLON;
    private String EXTRA_TMIDNAME;
    private String FromPoiAddr;
    private double FromPoiLatitude;
    private double FromPoiLongitude;
    private String FromPoiName;
    private String ToPoiAddr;
    private double ToPoiLatitude;
    private double ToPoiLongitude;
    private String ToPoiName;
    private int distance;
    private String method;
    private int midPoisNum;
    private int pathNum;
    private int routePredilection;
    private String streetNames;
    private int streetNamesSize;
    private int time;

    public int describeContents() {
        return 0;
    }

    public RouteInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.FromPoiName);
        parcel.writeString(this.FromPoiAddr);
        parcel.writeDouble(this.FromPoiLongitude);
        parcel.writeDouble(this.FromPoiLongitude);
        parcel.writeInt(this.EXTRA_DEV);
        parcel.writeString(this.ToPoiName);
        parcel.writeString(this.ToPoiAddr);
        parcel.writeDouble(this.ToPoiLongitude);
        parcel.writeDouble(this.ToPoiLatitude);
        parcel.writeInt(this.midPoisNum);
        parcel.writeInt(this.pathNum);
        parcel.writeDouble(this.EXTRA_FMIDLAT);
        parcel.writeDouble(this.EXTRA_FMIDLON);
        parcel.writeString(this.EXTRA_FMIDNAME);
        parcel.writeDouble(this.EXTRA_SMIDLAT);
        parcel.writeDouble(this.EXTRA_SMIDLON);
        parcel.writeString(this.EXTRA_SMIDNAME);
        parcel.writeDouble(this.EXTRA_TMIDLAT);
        parcel.writeDouble(this.EXTRA_TMIDLON);
        parcel.writeString(this.EXTRA_TMIDNAME);
        parcel.writeInt(this.streetNamesSize);
        parcel.writeString(this.streetNames);
        parcel.writeString(this.method);
        parcel.writeInt(this.time);
        parcel.writeInt(this.distance);
        parcel.writeInt(this.routePredilection);
        parcel.writeString(CUR_ROAD_NAME);
        parcel.writeString(NEXT_ROAD_NAME);
        parcel.writeInt(ROUTE_REMAIN_DIS);
        parcel.writeInt(ROUTE_REMAIN_TIME);
        parcel.writeInt(SEG_REMAIN_DIS);
        parcel.writeInt(SEG_REMAIN_TIME);
        parcel.writeInt(LIMETED_SPEED);
        parcel.writeInt(ROUTE_ALL_DIS);
        parcel.writeInt(ROUTE_ALL_TIME);
        parcel.writeInt(CUR_SPEED);
    }

    public RouteInfo(Parcel parcel) {
        this.FromPoiName = parcel.readString();
        this.FromPoiAddr = parcel.readString();
        this.FromPoiLongitude = parcel.readDouble();
        this.FromPoiLongitude = parcel.readDouble();
        this.EXTRA_DEV = parcel.readInt();
        this.ToPoiName = parcel.readString();
        this.ToPoiAddr = parcel.readString();
        this.ToPoiLongitude = parcel.readDouble();
        this.ToPoiLatitude = parcel.readDouble();
        this.midPoisNum = parcel.readInt();
        this.pathNum = parcel.readInt();
        this.EXTRA_FMIDLAT = parcel.readDouble();
        this.EXTRA_FMIDLON = parcel.readDouble();
        this.EXTRA_FMIDNAME = parcel.readString();
        this.EXTRA_SMIDLAT = parcel.readDouble();
        this.EXTRA_SMIDLON = parcel.readDouble();
        this.EXTRA_SMIDNAME = parcel.readString();
        this.EXTRA_TMIDLAT = parcel.readDouble();
        this.EXTRA_TMIDLON = parcel.readDouble();
        this.EXTRA_TMIDNAME = parcel.readString();
        this.streetNamesSize = parcel.readInt();
        this.streetNames = parcel.readString();
        this.method = parcel.readString();
        this.time = parcel.readInt();
        this.distance = parcel.readInt();
        this.routePredilection = parcel.readInt();
        CUR_ROAD_NAME = parcel.readString();
        NEXT_ROAD_NAME = parcel.readString();
        ROUTE_REMAIN_DIS = parcel.readInt();
        ROUTE_REMAIN_TIME = parcel.readInt();
        SEG_REMAIN_DIS = parcel.readInt();
        SEG_REMAIN_TIME = parcel.readInt();
        LIMETED_SPEED = parcel.readInt();
        ROUTE_ALL_DIS = parcel.readInt();
        ROUTE_ALL_TIME = parcel.readInt();
        CUR_SPEED = parcel.readInt();
    }

    public String getFromPoiName() {
        return this.FromPoiName;
    }

    public void setFromPoiName(String str) {
        this.FromPoiName = str;
    }

    public String getFromPoiAddr() {
        return this.FromPoiAddr;
    }

    public void setFromPoiAddr(String str) {
        this.FromPoiAddr = str;
    }

    public double getFromPoiLongitude() {
        return this.FromPoiLongitude;
    }

    public void setFromPoiLongitude(double d) {
        this.FromPoiLongitude = d;
    }

    public double getFromPoiLatitude() {
        return this.FromPoiLatitude;
    }

    public void setFromPoiLatitude(double d) {
        this.FromPoiLatitude = d;
    }

    public String getToPoiName() {
        return this.ToPoiName;
    }

    public void setToPoiName(String str) {
        this.ToPoiName = str;
    }

    public String getToPoiAddr() {
        return this.ToPoiAddr;
    }

    public void setToPoiAddr(String str) {
        this.ToPoiAddr = str;
    }

    public double getToPoiLongitude() {
        return this.ToPoiLongitude;
    }

    public void setToPoiLongitude(double d) {
        this.ToPoiLongitude = d;
    }

    public double getToPoiLatitude() {
        return this.ToPoiLatitude;
    }

    public void setToPoiLatitude(double d) {
        this.ToPoiLatitude = d;
    }

    public int getMidPoisNum() {
        return this.midPoisNum;
    }

    public void setMidPoisNum(int i) {
        this.midPoisNum = i;
    }

    public int getPathNum() {
        return this.pathNum;
    }

    public void setPathNum(int i) {
        this.pathNum = i;
    }

    public int getStreetNamesSize() {
        return this.streetNamesSize;
    }

    public void setStreetNamesSize(int i) {
        this.streetNamesSize = i;
    }

    public String getStreetNames() {
        return this.streetNames;
    }

    public void setStreetNames(String str) {
        this.streetNames = str;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }

    public int getRoutePredilection() {
        return this.routePredilection;
    }

    public void setRoutePredilection(int i) {
        this.routePredilection = i;
    }

    public int getEXTRA_DEV() {
        return this.EXTRA_DEV;
    }

    public void setEXTRA_DEV(int i) {
        this.EXTRA_DEV = i;
    }

    public double getEXTRA_FMIDLAT() {
        return this.EXTRA_FMIDLAT;
    }

    public void setEXTRA_FMIDLAT(double d) {
        this.EXTRA_FMIDLAT = d;
    }

    public double getEXTRA_FMIDLON() {
        return this.EXTRA_FMIDLON;
    }

    public void setEXTRA_FMIDLON(double d) {
        this.EXTRA_FMIDLON = d;
    }

    public String getEXTRA_FMIDNAME() {
        return this.EXTRA_FMIDNAME;
    }

    public void setEXTRA_FMIDNAME(String str) {
        this.EXTRA_FMIDNAME = str;
    }

    public double getEXTRA_SMIDLAT() {
        return this.EXTRA_SMIDLAT;
    }

    public void setEXTRA_SMIDLAT(double d) {
        this.EXTRA_SMIDLAT = d;
    }

    public double getEXTRA_SMIDLON() {
        return this.EXTRA_SMIDLON;
    }

    public void setEXTRA_SMIDLON(double d) {
        this.EXTRA_SMIDLON = d;
    }

    public String getEXTRA_SMIDNAME() {
        return this.EXTRA_SMIDNAME;
    }

    public void setEXTRA_SMIDNAME(String str) {
        this.EXTRA_SMIDNAME = str;
    }

    public double getEXTRA_TMIDLAT() {
        return this.EXTRA_TMIDLAT;
    }

    public void setEXTRA_TMIDLAT(double d) {
        this.EXTRA_TMIDLAT = d;
    }

    public double getEXTRA_TMIDLON() {
        return this.EXTRA_TMIDLON;
    }

    public void setEXTRA_TMIDLON(double d) {
        this.EXTRA_TMIDLON = d;
    }

    public String getEXTRA_TMIDNAME() {
        return this.EXTRA_TMIDNAME;
    }

    public void setEXTRA_TMIDNAME(String str) {
        this.EXTRA_TMIDNAME = str;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int i) {
        this.distance = i;
    }

    public static String getCUR_ROAD_NAME() {
        return CUR_ROAD_NAME;
    }

    public static void setCUR_ROAD_NAME(String str) {
        CUR_ROAD_NAME = str;
    }

    public static String getNEXT_ROAD_NAME() {
        return NEXT_ROAD_NAME;
    }

    public static void setNEXT_ROAD_NAME(String str) {
        NEXT_ROAD_NAME = str;
    }

    public static int getROUTE_REMAIN_DIS() {
        return ROUTE_REMAIN_DIS;
    }

    public static void setROUTE_REMAIN_DIS(int i) {
        ROUTE_REMAIN_DIS = i;
    }

    public static int getROUTE_REMAIN_TIME() {
        return ROUTE_REMAIN_TIME;
    }

    public static void setROUTE_REMAIN_TIME(int i) {
        ROUTE_REMAIN_TIME = i;
    }

    public static int getSEG_REMAIN_DIS() {
        return SEG_REMAIN_DIS;
    }

    public static void setSEG_REMAIN_DIS(int i) {
        SEG_REMAIN_DIS = i;
    }

    public static int getSEG_REMAIN_TIME() {
        return SEG_REMAIN_TIME;
    }

    public static void setSEG_REMAIN_TIME(int i) {
        SEG_REMAIN_TIME = i;
    }

    public static int getLIMETED_SPEED() {
        return LIMETED_SPEED;
    }

    public static void setLIMETED_SPEED(int i) {
        LIMETED_SPEED = i;
    }

    public static int getROUTE_ALL_DIS() {
        return ROUTE_ALL_DIS;
    }

    public static void setROUTE_ALL_DIS(int i) {
        ROUTE_ALL_DIS = i;
    }

    public static int getROUTE_ALL_TIME() {
        return ROUTE_ALL_TIME;
    }

    public static void setROUTE_ALL_TIME(int i) {
        ROUTE_ALL_TIME = i;
    }

    public static int getCUR_SPEED() {
        return CUR_SPEED;
    }

    public static void setCUR_SPEED(int i) {
        CUR_SPEED = i;
    }
}
