package com.amap.api.navi;

import android.content.Context;
import android.os.PowerManager;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.iu;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.rtbt.IAE8;

public class NaviSetting {
    private boolean mCameraInfoUpdateEnabled = true;
    boolean mIsMonitorCameraEnabled = true;
    private IAE8 mTbtControl;
    private boolean screenAlwaysBright = false;
    private boolean trafficInfoUpdateEnabled = true;
    private boolean trafficStatusUpdateEnabled = false;
    PowerManager.WakeLock wl;

    public NaviSetting(Context context, IAE8 iae8) {
        try {
            Context applicationContext = context.getApplicationContext();
            this.mTbtControl = iae8;
            if (applicationContext != null) {
                this.wl = ((PowerManager) applicationContext.getSystemService("power")).newWakeLock(10, GeocodeSearch.AMAP);
                this.wl.setReferenceCounted(false);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "NaviSetting", "NaviSetting(Context context, WTBTControl tbtControl)");
        }
    }

    public boolean isTrafficStatusUpdateEnabled() {
        return this.trafficStatusUpdateEnabled;
    }

    public void setTrafficStatusUpdateEnabled(boolean z) {
        this.trafficStatusUpdateEnabled = z;
        if (this.mTbtControl != null) {
            this.mTbtControl.setTrafficStatusUpdateEnabled(this.trafficStatusUpdateEnabled);
        }
    }

    public boolean isTrafficInfoUpdateEnabled() {
        return this.trafficInfoUpdateEnabled;
    }

    public void setTrafficInfoUpdateEnabled(boolean z) {
        this.trafficInfoUpdateEnabled = z;
        if (this.mTbtControl != null) {
            this.mTbtControl.setTrafficInfoUpdateEnabled(this.trafficInfoUpdateEnabled);
        }
    }

    public boolean isCameraInfoUpdateEnabled() {
        return this.mCameraInfoUpdateEnabled;
    }

    public void setCameraInfoUpdateEnabled(boolean z) {
        this.mCameraInfoUpdateEnabled = z;
        if (this.mTbtControl != null) {
            this.mTbtControl.setCameraInfoUpdateEnabled(this.mCameraInfoUpdateEnabled);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isMonitorCameraEnabled() {
        return this.mIsMonitorCameraEnabled;
    }

    public void setMonitorCameraEnabled(boolean z) {
        this.mIsMonitorCameraEnabled = z;
    }

    public boolean isScreenAlwaysBright() {
        return this.screenAlwaysBright;
    }

    public void setScreenAlwaysBright(boolean z) {
        this.screenAlwaysBright = z;
        try {
            if (this.screenAlwaysBright) {
                this.wl.acquire();
            } else if (this.wl.isHeld()) {
                this.wl.release();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "NaviSetting", "setScreenAlwaysBright(boolean isAlwaysBright)");
        }
    }

    public void destroy() {
        try {
            if (this.wl.isHeld()) {
                this.wl.release();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "NaviSetting", "destroy()");
        }
    }
}
