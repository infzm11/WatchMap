package com.amap.api.navi.model;

public class AMapLaneInfo {
    int laneTypeId = 0;

    public boolean isRecommended() {
        try {
            if (!getLaneTypeIdHexString().endsWith("F")) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getLaneTypeId() {
        return this.laneTypeId;
    }

    public void setLaneTypeId(int i) {
        this.laneTypeId = i;
    }

    public String getLaneTypeIdHexString() {
        try {
            return String.format("%1$02X", new Object[]{Integer.valueOf(this.laneTypeId)});
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
