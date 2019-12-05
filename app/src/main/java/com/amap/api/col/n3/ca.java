package com.amap.api.col.n3;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlay */
public abstract class ca {
    private k a;

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);

    public void destroy() {
        k kVar = this.a;
    }
}
