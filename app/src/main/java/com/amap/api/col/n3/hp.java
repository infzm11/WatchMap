package com.amap.api.col.n3;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* compiled from: ViewDragHelper */
public final class hp {
    private static final Interpolator v = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private int a;
    private int b;
    private int c = -1;
    private float[] d;
    private float[] e;
    private float[] f;
    private float[] g;
    private int[] h;
    private int[] i;
    private int[] j;
    private int k;
    private VelocityTracker l;
    private float m;
    private float n;
    private int o;
    private int p;
    private hg q;
    private final a r;
    private View s;
    private boolean t;
    private final ViewGroup u;
    private final Runnable w = new Runnable() {
        public final void run() {
            try {
                hp.this.a(0);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* compiled from: ViewDragHelper */
    public static abstract class a {
        public void a() {
        }

        public void a(int i) {
        }

        public void a(View view, float f) {
        }

        public abstract boolean a(View view);

        public int b(int i) {
            return 0;
        }

        public void b() {
        }

        public int c() {
            return 0;
        }
    }

    public static hp a(ViewGroup viewGroup, Interpolator interpolator, a aVar) {
        hp hpVar = new hp(viewGroup.getContext(), viewGroup, interpolator, aVar);
        hpVar.b = (int) (((float) hpVar.b) * 2.0f);
        return hpVar;
    }

    private hp(Context context, ViewGroup viewGroup, Interpolator interpolator, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.u = viewGroup;
            this.r = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.b = viewConfiguration.getScaledTouchSlop();
            this.m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = hg.a(context, interpolator == null ? v : interpolator);
        }
    }

    public final void a(float f2) {
        this.n = f2;
    }

    public final int a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final void c() {
        this.c = -1;
        if (this.d != null) {
            Arrays.fill(this.d, 0.0f);
            Arrays.fill(this.e, 0.0f);
            Arrays.fill(this.f, 0.0f);
            Arrays.fill(this.g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.j, 0);
            this.k = 0;
        }
        if (this.l != null) {
            this.l.recycle();
            this.l = null;
        }
    }

    public final void d() {
        c();
        if (this.a == 2) {
            this.q.b();
            this.q.c();
            this.q.g();
            this.q.b();
            int c2 = this.q.c();
            a aVar = this.r;
            View view = this.s;
            aVar.a(c2);
        }
        a(0);
    }

    public final boolean a(View view, int i2, int i3) {
        this.s = view;
        this.c = -1;
        return a(i2, i3, 0, 0);
    }

    public final boolean a(int i2, int i3) {
        if (this.t) {
            return a(i2, i3, (int) hh.a(this.l, this.c), (int) hh.b(this.l, this.c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean a(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.s.getLeft();
        int top = this.s.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        if (i6 == 0 && i7 == 0) {
            this.q.g();
            a(0);
            return false;
        }
        View view = this.s;
        int b2 = b(i4, (int) this.n, (int) this.m);
        int b3 = b(i5, (int) this.n, (int) this.m);
        int abs = Math.abs(i6);
        int abs2 = Math.abs(i7);
        int abs3 = Math.abs(b2);
        int abs4 = Math.abs(b3);
        int i8 = abs3 + abs4;
        int i9 = abs + abs2;
        if (b2 != 0) {
            f2 = (float) abs3;
            f3 = (float) i8;
        } else {
            f2 = (float) abs;
            f3 = (float) i9;
        }
        float f6 = f2 / f3;
        if (b3 != 0) {
            f4 = (float) abs4;
            f5 = (float) i8;
        } else {
            f4 = (float) abs2;
            f5 = (float) i9;
        }
        float f7 = f4 / f5;
        a aVar = this.r;
        int a2 = a(i6, b2, 0);
        this.q.a(left, top, i6, i7, (int) ((((float) a2) * f6) + (((float) a(i7, b3, this.r.c())) * f7)));
        a(2);
        return true;
    }

    private int a(int i2, int i3, int i4) {
        int i5;
        if (i2 == 0) {
            return 0;
        }
        int width = this.u.getWidth();
        float f2 = (float) (width / 2);
        float sin = f2 + (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i2)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * f2);
        int abs = Math.abs(i3);
        if (abs > 0) {
            i5 = 4 * Math.round(1000.0f * Math.abs(sin / ((float) abs)));
        } else {
            i5 = (int) (((((float) Math.abs(i2)) / ((float) i4)) + 1.0f) * 256.0f);
        }
        return Math.min(i5, 600);
    }

    private static int b(int i2, int i3, int i4) {
        int abs = Math.abs(i2);
        if (abs < i3) {
            return 0;
        }
        if (abs > i4) {
            return i2 > 0 ? i4 : -i4;
        }
        return i2;
    }

    private static float a(float f2, float f3, float f4) {
        float abs = Math.abs(f2);
        if (abs < f3) {
            return 0.0f;
        }
        if (abs > f4) {
            return f2 > 0.0f ? f4 : -f4;
        }
        return f2;
    }

    public final boolean e() {
        if (this.s == null) {
            return false;
        }
        if (this.a == 2) {
            boolean f2 = this.q.f();
            int b2 = this.q.b();
            int c2 = this.q.c();
            int left = b2 - this.s.getLeft();
            int top = c2 - this.s.getTop();
            if (f2 || top == 0) {
                if (left != 0) {
                    this.s.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.s.offsetTopAndBottom(top);
                }
                if (!(left == 0 && top == 0)) {
                    a aVar = this.r;
                    View view = this.s;
                    aVar.a(c2);
                }
                if (f2 && b2 == this.q.d() && c2 == this.q.e()) {
                    this.q.g();
                    f2 = this.q.a();
                }
                if (!f2) {
                    this.u.post(this.w);
                }
            } else {
                this.s.setTop(0);
                return true;
            }
        }
        if (this.a == 2) {
            return true;
        }
        return false;
    }

    private void b(float f2) {
        this.t = true;
        this.r.a(this.s, f2);
        this.t = false;
        if (this.a == 1) {
            a(0);
        }
    }

    private void b(int i2) {
        if (this.d != null && this.d.length > i2) {
            this.d[i2] = 0.0f;
            this.e[i2] = 0.0f;
            this.f[i2] = 0.0f;
            this.g[i2] = 0.0f;
            this.h[i2] = 0;
            this.i[i2] = 0;
            this.j[i2] = 0;
            this.k = (~(1 << i2)) & this.k;
        }
    }

    private void a(float f2, float f3, int i2) {
        int i3 = 0;
        if (this.d == null || this.d.length <= i2) {
            int i4 = i2 + 1;
            float[] fArr = new float[i4];
            float[] fArr2 = new float[i4];
            float[] fArr3 = new float[i4];
            float[] fArr4 = new float[i4];
            int[] iArr = new int[i4];
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            if (this.d != null) {
                System.arraycopy(this.d, 0, fArr, 0, this.d.length);
                System.arraycopy(this.e, 0, fArr2, 0, this.e.length);
                System.arraycopy(this.f, 0, fArr3, 0, this.f.length);
                System.arraycopy(this.g, 0, fArr4, 0, this.g.length);
                System.arraycopy(this.h, 0, iArr, 0, this.h.length);
                System.arraycopy(this.i, 0, iArr2, 0, this.i.length);
                System.arraycopy(this.j, 0, iArr3, 0, this.j.length);
            }
            this.d = fArr;
            this.e = fArr2;
            this.f = fArr3;
            this.g = fArr4;
            this.h = iArr;
            this.i = iArr2;
            this.j = iArr3;
        }
        float[] fArr5 = this.d;
        this.f[i2] = f2;
        fArr5[i2] = f2;
        float[] fArr6 = this.e;
        this.g[i2] = f3;
        fArr6[i2] = f3;
        int[] iArr4 = this.h;
        int i5 = (int) f2;
        int i6 = (int) f3;
        if (i5 < this.u.getLeft() + this.o) {
            i3 = 1;
        }
        if (i6 < this.u.getTop() + this.o) {
            i3 |= 4;
        }
        if (i5 > this.u.getRight() - this.o) {
            i3 |= 2;
        }
        if (i6 > this.u.getBottom() - this.o) {
            i3 |= 8;
        }
        iArr4[i2] = i3;
        this.k |= 1 << i2;
    }

    private void c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            float x = motionEvent.getX(i2);
            float y = motionEvent.getY(i2);
            if (this.f != null && this.g != null && this.f.length > pointerId && this.g.length > pointerId) {
                this.f[pointerId] = x;
                this.g[pointerId] = y;
            }
        }
    }

    public final void a(int i2) {
        if (this.a != i2) {
            this.a = i2;
            this.r.a();
            if (this.a == 0) {
                this.s = null;
            }
        }
    }

    private boolean a(View view, int i2) {
        if (view == this.s && this.c == i2) {
            return true;
        }
        if (view == null || !this.r.a(view)) {
            return false;
        }
        this.c = i2;
        if (view.getParent() != this.u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + ")");
        }
        this.s = view;
        this.c = i2;
        this.r.b();
        a(1);
        return true;
    }

    public final boolean a(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                a(x, y, pointerId);
                View b2 = b((int) x, (int) y);
                if (b2 == this.s && this.a == 2) {
                    a(b2, pointerId);
                }
                if ((this.h[pointerId] & this.p) != 0) {
                    a aVar = this.r;
                    int i2 = this.p;
                    break;
                }
                break;
            case 1:
            case 3:
                c();
                break;
            case 2:
                int pointerCount = motionEvent.getPointerCount();
                for (int i3 = 0; i3 < pointerCount && this.d != null && this.e != null; i3++) {
                    int pointerId2 = motionEvent.getPointerId(i3);
                    if (pointerId2 < this.d.length && pointerId2 < this.e.length) {
                        float x2 = motionEvent.getX(i3);
                        float y2 = motionEvent.getY(i3);
                        float f2 = x2 - this.d[pointerId2];
                        float f3 = y2 - this.e[pointerId2];
                        b(f2, f3, pointerId2);
                        if (this.a != 1) {
                            View b3 = b((int) this.d[pointerId2], (int) this.e[pointerId2]);
                            if (b3 != null && a(b3, f3) && a(b3, pointerId2)) {
                            }
                        }
                    }
                }
                c(motionEvent);
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x3 = motionEvent.getX(actionIndex);
                float y3 = motionEvent.getY(actionIndex);
                a(x3, y3, pointerId3);
                if (this.a != 0) {
                    if (this.a == 2) {
                        View b4 = b((int) x3, (int) y3);
                        if (b4 == this.s) {
                            a(b4, pointerId3);
                            break;
                        }
                    }
                } else if ((this.h[pointerId3] & this.p) != 0) {
                    a aVar2 = this.r;
                    int i4 = this.p;
                    break;
                }
                break;
            case 6:
                b(motionEvent.getPointerId(actionIndex));
                break;
        }
        return this.a == 1;
    }

    public final void b(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            c();
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        this.l.addMovement(motionEvent);
        int i3 = 0;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View b2 = b((int) x, (int) y);
                a(x, y, pointerId);
                a(b2, pointerId);
                if ((this.h[pointerId] & this.p) != 0) {
                    a aVar = this.r;
                    int i4 = this.p;
                    return;
                }
                return;
            case 1:
                if (this.a == 1) {
                    g();
                }
                c();
                return;
            case 2:
                if (this.a == 1) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    int i5 = (int) (x2 - this.f[this.c]);
                    int i6 = (int) (y2 - this.g[this.c]);
                    this.s.getLeft();
                    int top = this.s.getTop() + i6;
                    int left = this.s.getLeft();
                    int top2 = this.s.getTop();
                    if (i5 != 0) {
                        a aVar2 = this.r;
                        View view = this.s;
                        this.s.offsetLeftAndRight(0 - left);
                    }
                    if (i6 != 0) {
                        a aVar3 = this.r;
                        View view2 = this.s;
                        top = aVar3.b(top);
                        this.s.offsetTopAndBottom(top - top2);
                    }
                    if (!(i5 == 0 && i6 == 0)) {
                        a aVar4 = this.r;
                        View view3 = this.s;
                        aVar4.a(top);
                    }
                    c(motionEvent);
                    return;
                }
                int pointerCount = motionEvent.getPointerCount();
                while (i3 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i3);
                    float x3 = motionEvent.getX(i3);
                    float y3 = motionEvent.getY(i3);
                    float f2 = x3 - this.d[pointerId2];
                    float f3 = y3 - this.e[pointerId2];
                    b(f2, f3, pointerId2);
                    if (this.a != 1) {
                        View b3 = b((int) this.d[pointerId2], (int) this.e[pointerId2]);
                        if (!a(b3, f3) || !a(b3, pointerId2)) {
                            i3++;
                        }
                    }
                    c(motionEvent);
                    return;
                }
                c(motionEvent);
                return;
            case 3:
                if (this.a == 1) {
                    b(0.0f);
                }
                c();
                return;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                a(x4, y4, pointerId3);
                if (this.a == 0) {
                    a(b((int) x4, (int) y4), pointerId3);
                    if ((this.h[pointerId3] & this.p) != 0) {
                        a aVar5 = this.r;
                        int i7 = this.p;
                        return;
                    }
                    return;
                }
                int i8 = (int) x4;
                int i9 = (int) y4;
                View view4 = this.s;
                if (view4 != null && i8 >= view4.getLeft() && i8 < view4.getRight() && i9 >= view4.getTop() && i9 < view4.getBottom()) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    a(this.s, pointerId3);
                    return;
                }
                return;
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.a == 1 && pointerId4 == this.c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i3 < pointerCount2) {
                            int pointerId5 = motionEvent.getPointerId(i3);
                            if (pointerId5 != this.c) {
                                if (b((int) motionEvent.getX(i3), (int) motionEvent.getY(i3)) == this.s && a(this.s, pointerId5)) {
                                    i2 = this.c;
                                }
                            }
                            i3++;
                        } else {
                            i2 = -1;
                        }
                    }
                    if (i2 == -1) {
                        g();
                    }
                }
                b(pointerId4);
                return;
            default:
                return;
        }
    }

    private void b(float f2, float f3, int i2) {
        boolean a2 = a(f2, f3, i2, 1);
        if (a(f3, f2, i2, 4)) {
            a2 |= true;
        }
        if (a(f2, f3, i2, 2)) {
            a2 |= true;
        }
        if (a(f3, f2, i2, 8)) {
            a2 |= true;
        }
        if (a2) {
            int[] iArr = this.i;
            iArr[i2] = iArr[i2] | a2;
            a aVar = this.r;
        }
    }

    private boolean a(float f2, float f3, int i2, int i3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if ((this.h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.j[i2] & i3) == i3 || (this.i[i2] & i3) == i3 || (abs <= ((float) this.b) && abs2 <= ((float) this.b))) {
            return false;
        }
        if (abs < abs2 * 0.5f) {
            a aVar = this.r;
        }
        if ((this.i[i2] & i3) != 0 || abs <= ((float) this.b)) {
            return false;
        }
        return true;
    }

    private boolean a(View view, float f2) {
        if (view == null) {
            return false;
        }
        a aVar = this.r;
        if (!(this.r.c() > 0) || Math.abs(f2) <= ((float) this.b)) {
            return false;
        }
        return true;
    }

    public final boolean f() {
        return this.a == 1;
    }

    private void g() {
        this.l.computeCurrentVelocity(1000, this.m);
        a(hh.a(this.l, this.c), this.n, this.m);
        b(a(hh.b(this.l, this.c), this.n, this.m));
    }

    private View b(int i2, int i3) {
        for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
            ViewGroup viewGroup = this.u;
            a aVar = this.r;
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
