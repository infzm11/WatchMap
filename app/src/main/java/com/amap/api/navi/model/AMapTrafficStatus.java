package com.amap.api.navi.model;

import com.autonavi.ae.route.model.TmcBarItem;

public class AMapTrafficStatus {
    private int linkIndex;
    private int mLength;
    private int mStatus;

    public AMapTrafficStatus(TmcBarItem tmcBarItem) {
        try {
            this.mStatus = tmcBarItem.status;
            this.mLength = tmcBarItem.length;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLinkIndex(int i) {
        this.linkIndex = i;
    }

    public int getLinkIndex() {
        return this.linkIndex;
    }

    public int getStatus() {
        return this.mStatus;
    }

    /* access modifiers changed from: package-private */
    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getLength() {
        return this.mLength;
    }

    public void setLength(int i) {
        this.mLength = i;
    }
}
