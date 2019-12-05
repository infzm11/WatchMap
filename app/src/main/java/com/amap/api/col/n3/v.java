package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;

/* compiled from: UiSettingsDelegateImp */
final class v implements n {
    final Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message != null && v.this.b != null) {
                try {
                    switch (message.what) {
                        case 0:
                            v.this.b.a(v.this.h);
                            return;
                        case 1:
                            v.this.b.e(v.this.j);
                            return;
                        case 2:
                            v.this.b.d(v.this.i);
                            return;
                        case 3:
                            v.this.b.c(v.this.f);
                            return;
                        case 4:
                            v.this.b.b(v.this.n);
                            return;
                        case 5:
                            v.this.b.f(v.this.k);
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    iu.b(th, "UiSettingsDelegateImp", "handleMessage");
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public k b;
    private boolean c = true;
    private boolean d = true;
    private boolean e = true;
    /* access modifiers changed from: private */
    public boolean f = false;
    private boolean g = true;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = true;
    /* access modifiers changed from: private */
    public boolean j = false;
    /* access modifiers changed from: private */
    public boolean k = true;
    private int l = 0;
    private int m = 1;
    /* access modifiers changed from: private */
    public boolean n = true;
    private boolean o = false;
    private boolean p = false;

    v(k kVar) {
        this.b = kVar;
    }

    public final boolean isIndoorSwitchEnabled() throws RemoteException {
        return this.n;
    }

    public final void setIndoorSwitchEnabled(boolean z) throws RemoteException {
        this.n = z;
        this.a.obtainMessage(4).sendToTarget();
    }

    public final void setScaleControlsEnabled(boolean z) throws RemoteException {
        this.j = z;
        this.a.obtainMessage(1).sendToTarget();
    }

    public final void setZoomControlsEnabled(boolean z) throws RemoteException {
        this.h = z;
        this.a.obtainMessage(0).sendToTarget();
    }

    public final void setCompassEnabled(boolean z) throws RemoteException {
        this.i = z;
        this.a.obtainMessage(2).sendToTarget();
    }

    public final void setMyLocationButtonEnabled(boolean z) throws RemoteException {
        this.f = z;
        this.a.obtainMessage(3).sendToTarget();
    }

    public final void setScrollGesturesEnabled(boolean z) throws RemoteException {
        this.d = z;
    }

    public final void setZoomGesturesEnabled(boolean z) throws RemoteException {
        this.g = z;
    }

    public final void setTiltGesturesEnabled(boolean z) throws RemoteException {
        this.e = z;
    }

    public final void setRotateGesturesEnabled(boolean z) throws RemoteException {
        this.c = z;
    }

    public final void setAllGesturesEnabled(boolean z) throws RemoteException {
        this.c = z;
        this.e = z;
        this.g = z;
        this.d = z;
    }

    public final void setLogoPosition(int i2) throws RemoteException {
        this.l = i2;
        this.b.g(i2);
    }

    public final void setZoomPosition(int i2) throws RemoteException {
        this.m = i2;
        this.b.e(i2);
    }

    public final boolean isScaleControlsEnabled() throws RemoteException {
        return this.j;
    }

    public final boolean isZoomControlsEnabled() throws RemoteException {
        return this.h;
    }

    public final boolean isCompassEnabled() throws RemoteException {
        return this.i;
    }

    public final boolean isMyLocationButtonEnabled() throws RemoteException {
        return this.f;
    }

    public final boolean isScrollGesturesEnabled() throws RemoteException {
        return this.d;
    }

    public final boolean isZoomGesturesEnabled() throws RemoteException {
        return this.g;
    }

    public final boolean isTiltGesturesEnabled() throws RemoteException {
        return this.e;
    }

    public final boolean isRotateGesturesEnabled() throws RemoteException {
        return this.c;
    }

    public final int getLogoPosition() throws RemoteException {
        return this.l;
    }

    public final int getZoomPosition() throws RemoteException {
        return this.m;
    }

    public final void setZoomInByScreenCenter(boolean z) {
        this.o = z;
    }

    public final boolean isZoomInByScreenCenter() {
        return this.o;
    }

    public final void setLogoBottomMargin(int i2) {
        this.b.h(i2);
    }

    public final void setLogoLeftMargin(int i2) {
        this.b.i(i2);
    }

    public final float getLogoMarginRate(int i2) {
        return this.b.j(i2);
    }

    public final void setLogoMarginRate(int i2, float f2) {
        this.b.a(i2, f2);
    }

    public final void setGestureScaleByMapCenter(boolean z) throws RemoteException {
        this.p = z;
    }

    public final boolean isGestureScaleByMapCenter() throws RemoteException {
        return this.p;
    }

    public final void setLogoEnable(boolean z) {
        this.k = z;
        this.a.obtainMessage(5).sendToTarget();
    }

    public final boolean isLogoEnable() {
        return this.k;
    }
}
