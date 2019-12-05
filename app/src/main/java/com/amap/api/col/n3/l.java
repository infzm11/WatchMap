package com.amap.api.col.n3;

import android.opengl.GLSurfaceView;

/* compiled from: IGLSurfaceView */
public interface l {
    void a(di diVar);

    void a(dj djVar);

    int getHeight();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setRenderMode(int i);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i);
}
