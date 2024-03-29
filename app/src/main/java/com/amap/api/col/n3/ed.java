package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.LinearInterpolator;

/* compiled from: BlankView */
public final class ed extends View {
    public static final int a = Color.argb(255, 235, 235, 235);
    public static final int b = Color.argb(255, 21, 21, 21);
    private Paint c = new Paint();

    public ed(Context context) {
        super(context);
        this.c.setAntiAlias(true);
        this.c.setColor(a);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), this.c);
    }

    public final void a() {
        setVisibility(8);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(200);
        clearAnimation();
        startAnimation(alphaAnimation);
    }
}
