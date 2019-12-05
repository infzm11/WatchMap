package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;

/* compiled from: LocationView */
public final class eg extends LinearLayout {
    Bitmap a;
    Bitmap b;
    Bitmap c;
    Bitmap d;
    Bitmap e;
    Bitmap f;
    ImageView g;
    k h;
    boolean i = false;

    public final void a() {
        try {
            removeAllViews();
            if (this.a != null) {
                this.a.recycle();
            }
            if (this.b != null) {
                this.b.recycle();
            }
            if (this.b != null) {
                this.c.recycle();
            }
            this.a = null;
            this.b = null;
            this.c = null;
            if (this.d != null) {
                this.d.recycle();
                this.d = null;
            }
            if (this.e != null) {
                this.e.recycle();
                this.e = null;
            }
            if (this.f != null) {
                this.f.recycle();
                this.f = null;
            }
        } catch (Throwable th) {
            iu.b(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public eg(Context context, k kVar) {
        super(context);
        this.h = kVar;
        try {
            this.d = dv.a(context, "location_selected.png");
            this.a = dv.a(this.d, g.a);
            this.e = dv.a(context, "location_pressed.png");
            this.b = dv.a(this.e, g.a);
            this.f = dv.a(context, "location_unselected.png");
            this.c = dv.a(this.f, g.a);
            this.g = new ImageView(context);
            this.g.setImageBitmap(this.a);
            this.g.setClickable(true);
            this.g.setPadding(0, 20, 20, 0);
            this.g.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!eg.this.i) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        eg.this.g.setImageBitmap(eg.this.b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            eg.this.g.setImageBitmap(eg.this.a);
                            eg.this.h.setMyLocationEnabled(true);
                            Location myLocation = eg.this.h.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                            eg.this.h.a(myLocation);
                            eg.this.h.a(z.a(latLng, eg.this.h.h()));
                        } catch (Throwable th) {
                            iu.b(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.g);
        } catch (Throwable th) {
            iu.b(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        this.i = z;
        if (z) {
            try {
                this.g.setImageBitmap(this.a);
            } catch (Throwable th) {
                iu.b(th, "LocationView", "showSelect");
                th.printStackTrace();
                return;
            }
        } else {
            this.g.setImageBitmap(this.c);
        }
        this.g.invalidate();
    }
}
