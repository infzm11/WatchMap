package com.amap.api.navi;

import android.location.Location;

public interface IGpsCallback {
    public static final int GPS_OFFSET_AFTER = 2;
    public static final int GPS_OFFSET_BEFORE = 1;

    void onLocationChanged(int i, Location location);
}
