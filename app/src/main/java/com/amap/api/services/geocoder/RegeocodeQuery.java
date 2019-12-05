package com.amap.api.services.geocoder;

import com.amap.api.services.core.LatLonPoint;

public class RegeocodeQuery {
    private LatLonPoint a;
    private float b;
    private String c = GeocodeSearch.AMAP;
    private String d = "";

    public RegeocodeQuery(LatLonPoint latLonPoint, float f, String str) {
        this.a = latLonPoint;
        this.b = f;
        setLatLonType(str);
    }

    public LatLonPoint getPoint() {
        return this.a;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.a = latLonPoint;
    }

    public float getRadius() {
        return this.b;
    }

    public void setRadius(float f) {
        this.b = f;
    }

    public String getLatLonType() {
        return this.c;
    }

    public void setLatLonType(String str) {
        if (str == null) {
            return;
        }
        if (str.equals(GeocodeSearch.AMAP) || str.equals(GeocodeSearch.GPS)) {
            this.c = str;
        }
    }

    public String getPoiType() {
        return this.d;
    }

    public void setPoiType(String str) {
        this.d = str;
    }

    public int hashCode() {
        int i;
        int i2 = 0;
        if (this.c == null) {
            i = 0;
        } else {
            i = this.c.hashCode();
        }
        int i3 = (i + 31) * 31;
        if (this.a != null) {
            i2 = this.a.hashCode();
        }
        return (31 * (i3 + i2)) + Float.floatToIntBits(this.b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RegeocodeQuery regeocodeQuery = (RegeocodeQuery) obj;
        if (this.c == null) {
            if (regeocodeQuery.c != null) {
                return false;
            }
        } else if (!this.c.equals(regeocodeQuery.c)) {
            return false;
        }
        if (this.a == null) {
            if (regeocodeQuery.a != null) {
                return false;
            }
        } else if (!this.a.equals(regeocodeQuery.a)) {
            return false;
        }
        return Float.floatToIntBits(this.b) == Float.floatToIntBits(regeocodeQuery.b);
    }
}
