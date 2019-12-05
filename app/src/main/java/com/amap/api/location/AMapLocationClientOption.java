package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.loc.cs;

public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = new Parcelable.Creator<AMapLocationClientOption>() {
        public final /* synthetic */ AMapLocationClientOption createFromParcel(Parcel parcel) {
            return new AMapLocationClientOption(parcel);
        }

        public final /* bridge */ /* synthetic */ AMapLocationClientOption[] newArray(int i) {
            return new AMapLocationClientOption[i];
        }
    };
    static String a = "";
    private static AMapLocationProtocol j = AMapLocationProtocol.HTTP;
    private long b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private AMapLocationMode i;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private long r;

    public enum AMapLocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum AMapLocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int a;

        private AMapLocationProtocol(int i) {
            this.a = i;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public AMapLocationClientOption() {
        this.b = 2000;
        this.c = (long) cs.f;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = 30000;
    }

    protected AMapLocationClientOption(Parcel parcel) {
        this.b = 2000;
        this.c = (long) cs.f;
        boolean z = false;
        this.d = false;
        this.e = true;
        this.f = true;
        this.g = true;
        this.h = true;
        this.i = AMapLocationMode.Hight_Accuracy;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = 30000;
        this.b = parcel.readLong();
        this.c = parcel.readLong();
        this.d = parcel.readByte() != 0;
        this.e = parcel.readByte() != 0;
        this.f = parcel.readByte() != 0;
        this.g = parcel.readByte() != 0;
        this.h = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.i = readInt == -1 ? AMapLocationMode.Hight_Accuracy : AMapLocationMode.values()[readInt];
        this.k = parcel.readByte() != 0;
        this.l = parcel.readByte() != 0;
        this.m = parcel.readByte() != 0;
        this.n = parcel.readByte() != 0;
        this.o = parcel.readByte() != 0;
        this.p = parcel.readByte() != 0;
        this.q = parcel.readByte() != 0 ? true : z;
        this.r = parcel.readLong();
        int readInt2 = parcel.readInt();
        j = readInt2 == -1 ? AMapLocationProtocol.HTTP : AMapLocationProtocol.values()[readInt2];
    }

    public static String getAPIKEY() {
        return a;
    }

    public static void setLocationProtocol(AMapLocationProtocol aMapLocationProtocol) {
        j = aMapLocationProtocol;
    }

    public AMapLocationClientOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.b = this.b;
        aMapLocationClientOption.d = this.d;
        aMapLocationClientOption.i = this.i;
        aMapLocationClientOption.e = this.e;
        aMapLocationClientOption.k = this.k;
        aMapLocationClientOption.l = this.l;
        aMapLocationClientOption.f = this.f;
        aMapLocationClientOption.g = this.g;
        aMapLocationClientOption.c = this.c;
        aMapLocationClientOption.m = this.m;
        aMapLocationClientOption.n = this.n;
        aMapLocationClientOption.o = this.o;
        aMapLocationClientOption.p = isSensorEnable();
        aMapLocationClientOption.q = isWifiScan();
        aMapLocationClientOption.r = this.r;
        return aMapLocationClientOption;
    }

    public int describeContents() {
        return 0;
    }

    public long getHttpTimeOut() {
        return this.c;
    }

    public long getInterval() {
        return this.b;
    }

    public long getLastLocationLifeCycle() {
        return this.r;
    }

    public AMapLocationMode getLocationMode() {
        return this.i;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return j;
    }

    public boolean isGpsFirst() {
        return this.l;
    }

    public boolean isKillProcess() {
        return this.k;
    }

    public boolean isLocationCacheEnable() {
        return this.n;
    }

    public boolean isMockEnable() {
        return this.e;
    }

    public boolean isNeedAddress() {
        return this.f;
    }

    public boolean isOffset() {
        return this.m;
    }

    public boolean isOnceLocation() {
        if (this.o) {
            return true;
        }
        return this.d;
    }

    public boolean isOnceLocationLatest() {
        return this.o;
    }

    public boolean isSensorEnable() {
        return this.p;
    }

    public boolean isWifiActiveScan() {
        return this.g;
    }

    public boolean isWifiScan() {
        return this.q;
    }

    public AMapLocationClientOption setGpsFirst(boolean z) {
        this.l = z;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long j2) {
        this.c = j2;
        return this;
    }

    public AMapLocationClientOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.b = j2;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean z) {
        this.k = z;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long j2) {
        this.r = j2;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean z) {
        this.n = z;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode aMapLocationMode) {
        this.i = aMapLocationMode;
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean z) {
        this.e = z;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean z) {
        this.f = z;
        return this;
    }

    public AMapLocationClientOption setOffset(boolean z) {
        this.m = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean z) {
        this.d = z;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean z) {
        this.o = z;
        return this;
    }

    public AMapLocationClientOption setSensorEnable(boolean z) {
        this.p = z;
        return this;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean z) {
        this.g = z;
        this.h = z;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean z) {
        this.q = z;
        this.g = this.q ? this.h : false;
        return this;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.b) + "#" + "isOnceLocation:" + String.valueOf(this.d) + "#" + "locationMode:" + String.valueOf(this.i) + "#" + "locationProcol:" + String.valueOf(j) + "#" + "isMockEnable:" + String.valueOf(this.e) + "#" + "isKillProcess:" + String.valueOf(this.k) + "#" + "isGpsFirst:" + String.valueOf(this.l) + "#" + "isNeedAddress:" + String.valueOf(this.f) + "#" + "isWifiActiveScan:" + String.valueOf(this.g) + "#" + "httpTimeOut:" + String.valueOf(this.c) + "#" + "isOffset:" + String.valueOf(this.m) + "#" + "isLocationCacheEnable:" + String.valueOf(this.n) + "#" + "isLocationCacheEnable:" + String.valueOf(this.n) + "#" + "isOnceLocationLatest:" + String.valueOf(this.o) + "#" + "sensorEnable:" + String.valueOf(this.p) + "#" + "lastLocationLifeCycle:" + String.valueOf(this.r) + "#";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.b);
        parcel.writeLong(this.c);
        parcel.writeByte(this.d ? (byte) 1 : 0);
        parcel.writeByte(this.e ? (byte) 1 : 0);
        parcel.writeByte(this.f ? (byte) 1 : 0);
        parcel.writeByte(this.g ? (byte) 1 : 0);
        parcel.writeByte(this.h ? (byte) 1 : 0);
        int i3 = -1;
        parcel.writeInt(this.i == null ? -1 : this.i.ordinal());
        parcel.writeByte(this.k ? (byte) 1 : 0);
        parcel.writeByte(this.l ? (byte) 1 : 0);
        parcel.writeByte(this.m ? (byte) 1 : 0);
        parcel.writeByte(this.n ? (byte) 1 : 0);
        parcel.writeByte(this.o ? (byte) 1 : 0);
        parcel.writeByte(this.p ? (byte) 1 : 0);
        parcel.writeByte(this.q ? (byte) 1 : 0);
        parcel.writeLong(this.r);
        if (j != null) {
            i3 = getLocationProtocol().ordinal();
        }
        parcel.writeInt(i3);
    }
}
