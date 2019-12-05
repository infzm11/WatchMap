package com.amap.api.col.n3;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* compiled from: AMapGLRenderer */
public final class b implements l {
    protected boolean a;
    private k b;

    public final void a(di diVar) {
    }

    public final void a(dj djVar) {
    }

    public final int getHeight() {
        return 0;
    }

    public final int getRenderMode() {
        return 0;
    }

    public final int getWidth() {
        return 0;
    }

    public final boolean post(Runnable runnable) {
        return false;
    }

    public final boolean postDelayed(Runnable runnable, long j) {
        return false;
    }

    public final void requestRender() {
    }

    public final void setRenderMode(int i) {
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    public final void setVisibility(int i) {
    }

    public b(Context context) {
        this(context, (byte) 0);
    }

    private b(Context context, byte b2) {
        this.b = null;
        this.a = false;
        this.b = new a(this, context);
    }

    public final k a() {
        return this.b;
    }

    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public final boolean isEnabled() {
        return this.b != null;
    }
}
