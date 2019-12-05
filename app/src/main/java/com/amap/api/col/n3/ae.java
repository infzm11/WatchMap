package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.Marker;

/* compiled from: InfoWindowDelegate */
public final class ae {
    AMap.InfoWindowAdapter a = null;
    Context b;
    private boolean c = true;
    /* access modifiers changed from: private */
    public View d;
    /* access modifiers changed from: private */
    public TextView e;
    /* access modifiers changed from: private */
    public TextView f;
    /* access modifiers changed from: private */
    public Drawable g = null;
    private ad h;
    private ad i;
    private AMap.InfoWindowAdapter j = new AMap.InfoWindowAdapter() {
        public final View getInfoContents(Marker marker) {
            return null;
        }

        public final View getInfoWindow(Marker marker) {
            try {
                if (ae.this.g == null) {
                    Drawable unused = ae.this.g = Cdo.a(ae.this.b, "infowindow_bg.9.png");
                }
                if (ae.this.d == null) {
                    View unused2 = ae.this.d = new LinearLayout(ae.this.b);
                    ae.this.d.setBackground(ae.this.g);
                    TextView unused3 = ae.this.e = new TextView(ae.this.b);
                    ae.this.e.setText(marker.getTitle());
                    ae.this.e.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    TextView unused4 = ae.this.f = new TextView(ae.this.b);
                    ae.this.f.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    ae.this.f.setText(marker.getSnippet());
                    ((LinearLayout) ae.this.d).setOrientation(1);
                    ((LinearLayout) ae.this.d).addView(ae.this.e);
                    ((LinearLayout) ae.this.d).addView(ae.this.f);
                }
            } catch (Throwable th) {
                iu.b(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return ae.this.d;
        }
    };

    public ae(Context context) {
        this.b = context;
        this.a = this.j;
    }

    public final void a(ad adVar) {
        this.h = adVar;
        if (this.h != null) {
            this.h.a(this);
        }
    }

    public final void b(ad adVar) {
        this.i = adVar;
        if (this.i != null) {
            this.i.a(this);
        }
    }

    public final synchronized boolean a() {
        return this.c;
    }

    public final void a(String str, String str2) {
        if (this.e != null) {
            this.e.setText(str);
        }
        if (this.f != null) {
            this.f.setText(str2);
        }
        if (this.d != null) {
            this.d.requestLayout();
        }
    }

    public final synchronized void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.a = infoWindowAdapter;
        if (this.a == null) {
            this.a = this.j;
            this.c = true;
        } else {
            this.c = false;
        }
        if (this.i != null) {
            this.i.b_();
        }
        if (this.h != null) {
            this.h.b_();
        }
    }

    public final void b() {
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.j = null;
        this.a = null;
        dv.a(this.g);
        this.g = null;
    }

    public final View a(Marker marker) {
        if (this.a != null) {
            return this.a.getInfoWindow(marker);
        }
        return null;
    }

    public final View b(Marker marker) {
        if (this.a != null) {
            return this.a.getInfoContents(marker);
        }
        return null;
    }

    public final View c(Marker marker) {
        if (this.a == null || !(this.a instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) this.a).getInfoWindowClick(marker);
    }

    public final View d(Marker marker) {
        if (this.a == null || !(this.a instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) this.a).getOverturnInfoWindow(marker);
    }

    public final View e(Marker marker) {
        if (this.a == null || !(this.a instanceof AMap.MultiPositionInfoWindowAdapter)) {
            return null;
        }
        return ((AMap.MultiPositionInfoWindowAdapter) this.a).getOverturnInfoWindowClick(marker);
    }

    public final long c() {
        if (this.a == null || !(this.a instanceof AMap.ImageInfoWindowAdapter)) {
            return 0;
        }
        return ((AMap.ImageInfoWindowAdapter) this.a).getInfoWindowUpdateTime();
    }

    public final synchronized ad d() {
        if (this.a == null) {
            return null;
        }
        if (this.a instanceof AMap.ImageInfoWindowAdapter) {
            return this.i;
        } else if (this.a instanceof AMap.MultiPositionInfoWindowAdapter) {
            return this.i;
        } else {
            return this.h;
        }
    }

    public final Drawable e() {
        if (this.g == null) {
            try {
                this.g = Cdo.a(this.b, "infowindow_bg.9.png");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.g;
    }
}
