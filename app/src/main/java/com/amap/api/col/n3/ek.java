package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.col.n3.eh;

/* compiled from: ZoomControllerView */
final class ek extends LinearLayout {
    /* access modifiers changed from: private */
    public Bitmap a;
    private Bitmap b;
    /* access modifiers changed from: private */
    public Bitmap c;
    private Bitmap d;
    /* access modifiers changed from: private */
    public Bitmap e;
    /* access modifiers changed from: private */
    public Bitmap f;
    private Bitmap g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap l;
    /* access modifiers changed from: private */
    public ImageView m;
    /* access modifiers changed from: private */
    public ImageView n;
    /* access modifiers changed from: private */
    public k o;

    public final void a() {
        try {
            removeAllViews();
            this.a.recycle();
            this.b.recycle();
            this.c.recycle();
            this.d.recycle();
            this.e.recycle();
            this.f.recycle();
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            if (this.g != null) {
                this.g.recycle();
                this.g = null;
            }
            if (this.h != null) {
                this.h.recycle();
                this.h = null;
            }
            if (this.i != null) {
                this.i.recycle();
                this.i = null;
            }
            if (this.j != null) {
                this.j.recycle();
                this.g = null;
            }
            if (this.k != null) {
                this.k.recycle();
                this.k = null;
            }
            if (this.l != null) {
                this.l.recycle();
                this.l = null;
            }
            this.m = null;
            this.n = null;
        } catch (Throwable th) {
            iu.b(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public ek(Context context, k kVar) {
        super(context);
        this.o = kVar;
        try {
            this.g = dv.a(context, "zoomin_selected.png");
            this.a = dv.a(this.g, g.a);
            this.h = dv.a(context, "zoomin_unselected.png");
            this.b = dv.a(this.h, g.a);
            this.i = dv.a(context, "zoomout_selected.png");
            this.c = dv.a(this.i, g.a);
            this.j = dv.a(context, "zoomout_unselected.png");
            this.d = dv.a(this.j, g.a);
            this.k = dv.a(context, "zoomin_pressed.png");
            this.e = dv.a(this.k, g.a);
            this.l = dv.a(context, "zoomout_pressed.png");
            this.f = dv.a(this.l, g.a);
            this.m = new ImageView(context);
            this.m.setImageBitmap(this.a);
            this.m.setClickable(true);
            this.n = new ImageView(context);
            this.n.setImageBitmap(this.c);
            this.n.setClickable(true);
            this.m.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ek.this.o.h() < ek.this.o.getMaxZoomLevel()) {
                            if (ek.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ek.this.m.setImageBitmap(ek.this.e);
                                } else if (motionEvent.getAction() == 1) {
                                    ek.this.m.setImageBitmap(ek.this.a);
                                    ek.this.o.b(z.a());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (RemoteException e) {
                        iu.b((Throwable) e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.n.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ek.this.o.h() > ek.this.o.getMinZoomLevel()) {
                            if (ek.this.o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ek.this.n.setImageBitmap(ek.this.f);
                                } else if (motionEvent.getAction() == 1) {
                                    ek.this.n.setImageBitmap(ek.this.c);
                                    ek.this.o.b(z.b());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        iu.b(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                }
            });
            this.m.setPadding(0, 0, 20, -2);
            this.n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.m);
            addView(this.n);
        } catch (Throwable th) {
            iu.b(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a(float f2) {
        try {
            if (f2 < this.o.getMaxZoomLevel() && f2 > this.o.getMinZoomLevel()) {
                this.m.setImageBitmap(this.a);
                this.n.setImageBitmap(this.c);
            } else if (f2 == this.o.getMinZoomLevel()) {
                this.n.setImageBitmap(this.d);
                this.m.setImageBitmap(this.a);
            } else if (f2 == this.o.getMaxZoomLevel()) {
                this.m.setImageBitmap(this.b);
                this.n.setImageBitmap(this.c);
            }
        } catch (Throwable th) {
            iu.b(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i2) {
        try {
            eh.a aVar = (eh.a) getLayoutParams();
            if (i2 == 1) {
                aVar.d = 16;
            } else if (i2 == 2) {
                aVar.d = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            iu.b(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z) {
        if (z) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
