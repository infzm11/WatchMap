package com.amap.api.col.n3;

import android.content.Context;
import android.os.Build;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: ScrollerCompat */
public final class hg {
    Object a;
    a b;

    /* compiled from: ScrollerCompat */
    interface a {
        Object a(Context context, Interpolator interpolator);

        void a(Object obj, int i, int i2, int i3, int i4, int i5);

        boolean a(Object obj);

        int b(Object obj);

        int c(Object obj);

        boolean d(Object obj);

        void e(Object obj);

        int f(Object obj);

        int g(Object obj);
    }

    /* compiled from: ScrollerCompat */
    static class b implements a {
        b() {
        }

        public final Object a(Context context, Interpolator interpolator) {
            return interpolator != null ? new Scroller(context, interpolator) : new Scroller(context);
        }

        public final boolean a(Object obj) {
            return ((Scroller) obj).isFinished();
        }

        public final int b(Object obj) {
            return ((Scroller) obj).getCurrX();
        }

        public final int c(Object obj) {
            return ((Scroller) obj).getCurrY();
        }

        public final boolean d(Object obj) {
            return ((Scroller) obj).computeScrollOffset();
        }

        public final void a(Object obj, int i, int i2, int i3, int i4, int i5) {
            ((Scroller) obj).startScroll(i, i2, i3, i4, i5);
        }

        public final void e(Object obj) {
            ((Scroller) obj).abortAnimation();
        }

        public final int f(Object obj) {
            return ((Scroller) obj).getFinalX();
        }

        public final int g(Object obj) {
            return ((Scroller) obj).getFinalY();
        }
    }

    public static hg a(Context context, Interpolator interpolator) {
        return new hg(context, interpolator);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private hg(Context context, Interpolator interpolator) {
        this(context, interpolator, (byte) 0);
        int i = Build.VERSION.SDK_INT;
    }

    private hg(Context context, Interpolator interpolator, byte b2) {
        this.b = new b();
        this.a = this.b.a(context, interpolator);
    }

    public final boolean a() {
        return this.b.a(this.a);
    }

    public final int b() {
        return this.b.b(this.a);
    }

    public final int c() {
        return this.b.c(this.a);
    }

    public final int d() {
        return this.b.f(this.a);
    }

    public final int e() {
        return this.b.g(this.a);
    }

    public final boolean f() {
        return this.b.d(this.a);
    }

    public final void a(int i, int i2, int i3, int i4, int i5) {
        this.b.a(this.a, i, i2, i3, i4, i5);
    }

    public final void g() {
        this.b.e(this.a);
    }
}
