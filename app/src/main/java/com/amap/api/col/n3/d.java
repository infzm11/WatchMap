package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import com.amap.api.col.n3.j;
import com.autonavi.ae.gmap.GLMapRender;

/* compiled from: AMapGLTextureView */
public final class d extends j implements l {
    protected boolean a;
    private k b;
    /* access modifiers changed from: private */
    public GLMapRender c;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b2) {
        super(context);
        this.b = null;
        this.c = null;
        this.a = false;
        dh.a(this);
        this.b = new a(this, context);
    }

    public final k a() {
        return this.b;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void a(di diVar) {
        super.a((j.e) diVar);
    }

    public final void a(dj djVar) {
        super.a((j.f) djVar);
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public final void b() {
        if (!this.c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        if (d.this.c != null) {
                            d.this.c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            int i = 0;
            while (!this.c.mSurfacedestoryed) {
                int i2 = i + 1;
                if (i >= 20) {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException unused) {
                }
                i = i2;
            }
        }
        super.b();
    }

    public final void c() {
        super.c();
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        requestRender();
        try {
            Thread.sleep(100);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8 || i == 4) {
            if (this.c != null) {
                this.c.renderPause();
                this.a = false;
            }
            requestRender();
        } else if (i == 0) {
            try {
                if (this.c != null) {
                    this.c.renderResume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        try {
            if (this.c != null) {
                this.c.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.c();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        b();
        try {
            if (this.c != null) {
                this.c.onDetachedFromWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDetachedFromWindow();
    }
}
