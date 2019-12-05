package com.amap.api.location;

import android.content.Context;
import android.content.Intent;
import com.loc.au;
import com.loc.cs;
import com.loc.cy;
import com.loc.d;
import com.loc.s;
import com.loc.t;

public class AMapLocationClient {
    Context a;
    LocationManagerBase b;

    public AMapLocationClient(Context context) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                cs.a(th, "AMapLocationClient", "AMapLocationClient 1");
            }
        } else {
            this.a = context.getApplicationContext();
            this.b = a(this.a, (Intent) null);
        }
    }

    public AMapLocationClient(Context context, Intent intent) {
        if (context == null) {
            try {
                throw new IllegalArgumentException("Context参数不能为null");
            } catch (Throwable th) {
                cs.a(th, "AMapLocationClient", "AMapLocationClient 2");
            }
        } else {
            this.a = context.getApplicationContext();
            this.b = a(this.a, intent);
        }
    }

    private static LocationManagerBase a(Context context, Intent intent) {
        LocationManagerBase locationManagerBase;
        try {
            s b2 = cs.b();
            cy.a(context, b2);
            boolean c = cy.c(context);
            cy.a(context);
            if (c) {
                locationManagerBase = (LocationManagerBase) au.a(context, b2, t.c("IY29tLmFtYXAuYXBpLmxvY2F0aW9uLkxvY2F0aW9uTWFuYWdlcldyYXBwZXI="), d.class, new Class[]{Context.class, Intent.class}, new Object[]{context, intent});
            } else {
                locationManagerBase = new d(context, intent);
            }
        } catch (Throwable unused) {
            locationManagerBase = new d(context, intent);
        }
        return locationManagerBase == null ? new d(context, intent) : locationManagerBase;
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.a = str;
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "setApiKey");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            if (this.b != null) {
                return this.b.getLastKnownLocation();
            }
            return null;
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "getLastKnownLocation");
            return null;
        }
    }

    public String getVersion() {
        return "3.6.1";
    }

    public boolean isStarted() {
        try {
            if (this.b != null) {
                return this.b.isStarted();
            }
            return false;
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "isStarted");
            return false;
        }
    }

    public void onDestroy() {
        try {
            if (this.b != null) {
                this.b.onDestroy();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "onDestroy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        if (aMapLocationListener == null) {
            try {
                throw new IllegalArgumentException("listener参数不能为null");
            } catch (Throwable th) {
                cs.a(th, "AMapLocationClient", "setLocationListener");
            }
        } else if (this.b != null) {
            this.b.setLocationListener(aMapLocationListener);
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            try {
                throw new IllegalArgumentException("LocationManagerOption参数不能为null");
            } catch (Throwable th) {
                cs.a(th, "AMapLocationClient", "setLocationOption");
            }
        } else if (this.b != null) {
            this.b.setLocationOption(aMapLocationClientOption);
        }
    }

    public void startAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.startAssistantLocation();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "startAssistantLocation");
        }
    }

    public void startLocation() {
        try {
            if (this.b != null) {
                this.b.startLocation();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "startLocation");
        }
    }

    public void stopAssistantLocation() {
        try {
            if (this.b != null) {
                this.b.stopAssistantLocation();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "stopAssistantLocation");
        }
    }

    public void stopLocation() {
        try {
            if (this.b != null) {
                this.b.stopLocation();
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "stopLocation");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (this.b != null) {
                this.b.unRegisterLocationListener(aMapLocationListener);
            }
        } catch (Throwable th) {
            cs.a(th, "AMapLocationClient", "unRegisterLocationListener");
        }
    }
}
