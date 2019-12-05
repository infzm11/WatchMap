package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.gesture.HoverGestureDetector;
import com.autonavi.ae.gmap.gesture.MoveGestureDetector;
import com.autonavi.ae.gmap.gesture.ScaleRotateGestureDetector;
import com.autonavi.ae.gmap.gesture.ZoomOutGestureDetector;
import com.autonavi.amap.mapcore.message.GestureMapMessage;
import com.autonavi.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: GLMapGestureDetector */
public final class h {
    k a;
    Context b;
    GestureDetector c;
    public AMapGestureListener d;
    private ScaleRotateGestureDetector e;
    private MoveGestureDetector f;
    private HoverGestureDetector g;
    private ZoomOutGestureDetector h;
    /* access modifiers changed from: private */
    public boolean i = false;
    /* access modifiers changed from: private */
    public int j = 0;
    /* access modifiers changed from: private */
    public int k = 0;
    /* access modifiers changed from: private */
    public int l = 0;
    /* access modifiers changed from: private */
    public int m = 0;
    /* access modifiers changed from: private */
    public int n = 0;
    /* access modifiers changed from: private */
    public boolean o = false;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = true;
    private Handler r = new Handler(Looper.getMainLooper());

    /* compiled from: GLMapGestureDetector */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0;
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = h.this.o = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (h.this.d != null) {
                h.this.d.onFling(f, f2);
            }
            try {
                if (h.this.a.i().isScrollGesturesEnabled() && h.this.m <= 0 && h.this.k <= 0 && h.this.l == 0 && !h.this.q) {
                    this.e.mGestureState = 3;
                    this.e.mGestureType = 3;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int a2 = h.this.a.a(this.e);
                    h.this.a.onFling();
                    h.this.a.a().startMapSlidAnim(a2, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (h.this.n == 1) {
                this.e.mGestureState = 3;
                this.e.mGestureType = 7;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                h.this.a.a(h.this.a.a(this.e), motionEvent);
                if (h.this.d != null) {
                    h.this.d.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (h.this.d == null) {
                return false;
            }
            h.this.d.onScroll(f, f2);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
            try {
                this.e.mGestureState = 3;
                this.e.mGestureType = 7;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                h.this.a.a().clearAnimations(h.this.a.a(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            h.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            if (h.this.d != null) {
                h.this.d.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.d != 1) {
                return false;
            }
            try {
                if (!h.this.a.i().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                this.e.mGestureState = 1;
                this.e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int a2 = h.this.a.a(this.e);
                this.a = motionEvent.getY();
                h.this.a.a(a2, (GestureMapMessage) ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.b = SystemClock.uptimeMillis();
                return true;
            } else if (action == 2) {
                boolean unused = h.this.o = true;
                float y = this.a - motionEvent.getY();
                if (Math.abs(y) < 20.0f) {
                    return true;
                }
                this.e.mGestureState = 2;
                this.e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                h.this.a.a(h.this.a.a(this.e), (GestureMapMessage) ScaleGestureMapMessage.obtain(101, (4.0f * y) / ((float) h.this.a.getMapHeight()), 0, 0));
                this.a = motionEvent.getY();
                return true;
            } else {
                this.e.mGestureState = 3;
                this.e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.e;
                eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int a3 = h.this.a.a(this.e);
                h.this.c.setIsLongpressEnabled(true);
                h.this.a.a(a3, (GestureMapMessage) ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                if (action == 1) {
                    h.this.a.a(3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.b;
                    if (!h.this.o || uptimeMillis < 200) {
                        return h.this.a.b(a3, motionEvent);
                    }
                    boolean unused2 = h.this.o = false;
                    return true;
                }
                boolean unused3 = h.this.o = false;
                return true;
            }
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (h.this.n != 1) {
                return false;
            }
            this.e.mGestureState = 3;
            this.e.mGestureType = 8;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            h.this.a.a(this.e);
            if (h.this.d != null) {
                try {
                    h.this.d.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return h.this.a.a(motionEvent);
        }
    }

    /* compiled from: GLMapGestureDetector */
    private class b implements HoverGestureDetector.OnHoverGestureListener {
        private EAMapPlatformGestureInfo b;

        private b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ b(h hVar, byte b2) {
            this();
        }

        public final boolean onHove(HoverGestureDetector hoverGestureDetector) {
            this.b.mGestureState = 2;
            this.b.mGestureType = 6;
            boolean z = false;
            this.b.mLocation = new float[]{hoverGestureDetector.getEvent().getX(), hoverGestureDetector.getEvent().getY()};
            try {
                if (!h.this.a.i().isTiltGesturesEnabled()) {
                    return true;
                }
                int a2 = h.this.a.a(this.b);
                h.this.a.b();
                if (h.this.l > 3) {
                    return false;
                }
                float f = hoverGestureDetector.getFocusDelta().x;
                float f2 = hoverGestureDetector.getFocusDelta().y;
                if (!h.this.i) {
                    PointF pointerDelta = hoverGestureDetector.getPointerDelta(0);
                    PointF pointerDelta2 = hoverGestureDetector.getPointerDelta(1);
                    if ((pointerDelta.y > 10.0f && pointerDelta2.y > 10.0f) || (pointerDelta.y < -10.0f && pointerDelta2.y < -10.0f)) {
                        z = true;
                    }
                    if (z && Math.abs(f2) > 10.0f && Math.abs(f) < 10.0f) {
                        boolean unused = h.this.i = true;
                    }
                }
                if (h.this.i) {
                    boolean unused2 = h.this.i = true;
                    float f3 = f2 / 6.0f;
                    if (Math.abs(f3) > 1.0f) {
                        h.this.a.a(a2, (GestureMapMessage) HoverGestureMapMessage.obtain(101, f3));
                        int unused3 = h.this.m = h.this.m + 1;
                        return true;
                    }
                }
                return true;
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        public final boolean onHoveBegin(HoverGestureDetector hoverGestureDetector) {
            this.b.mGestureState = 1;
            this.b.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mLocation = new float[]{hoverGestureDetector.getEvent().getX(), hoverGestureDetector.getEvent().getY()};
            try {
                if (!h.this.a.i().isTiltGesturesEnabled()) {
                    return true;
                }
                int a2 = h.this.a.a(this.b);
                h.this.a.b();
                h.this.a.a(a2, (GestureMapMessage) HoverGestureMapMessage.obtain(100, h.this.a.l(a2)));
                return true;
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public final void onHoveEnd(HoverGestureDetector hoverGestureDetector) {
            this.b.mGestureState = 3;
            this.b.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mLocation = new float[]{hoverGestureDetector.getEvent().getX(), hoverGestureDetector.getEvent().getY()};
            try {
                if (h.this.a.i().isTiltGesturesEnabled()) {
                    int a2 = h.this.a.a(this.b);
                    h.this.a.b();
                    if (h.this.a.l(a2) >= 0.0f && h.this.m > 0) {
                        h.this.a.a(7);
                    }
                    boolean unused = h.this.i = false;
                    h.this.a.a(a2, (GestureMapMessage) HoverGestureMapMessage.obtain(102, h.this.a.l(a2)));
                }
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GLMapGestureDetector */
    private class c implements MoveGestureDetector.OnMoveGestureListener {
        private final float b;
        private final float c;
        private EAMapPlatformGestureInfo d;

        private c() {
            this.b = 1.0f;
            this.c = 4.0f;
            this.d = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ c(h hVar, byte b2) {
            this();
        }

        public final boolean onMove(MoveGestureDetector moveGestureDetector) {
            if (h.this.i) {
                return true;
            }
            try {
                if (!h.this.a.i().isScrollGesturesEnabled() || h.this.p) {
                    return true;
                }
                this.d.mGestureState = 2;
                this.d.mGestureType = 3;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.d;
                eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.getEvent().getX(), moveGestureDetector.getEvent().getY()};
                int a2 = h.this.a.a(this.d);
                PointF focusDelta = moveGestureDetector.getFocusDelta();
                float f = 1.0f;
                if (h.this.j == 0) {
                    f = 4.0f;
                }
                if (Math.abs(focusDelta.x) <= f && Math.abs(focusDelta.y) <= f) {
                    return false;
                }
                if (h.this.j == 0) {
                    h.this.a.a().clearAnimations(a2, false);
                }
                h.this.a.a(a2, (GestureMapMessage) MoveGestureMapMessage.obtain(101, focusDelta.x, focusDelta.y));
                int unused = h.this.j = h.this.j + 1;
                return true;
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        public final boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            try {
                if (!h.this.a.i().isScrollGesturesEnabled()) {
                    return true;
                }
                this.d.mGestureState = 1;
                this.d.mGestureType = 3;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.d;
                eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.getEvent().getX(), moveGestureDetector.getEvent().getY()};
                h.this.a.a(h.this.a.a(this.d), (GestureMapMessage) MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                return true;
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public final void onMoveEnd(MoveGestureDetector moveGestureDetector) {
            try {
                if (h.this.a.i().isScrollGesturesEnabled()) {
                    this.d.mGestureState = 3;
                    this.d.mGestureType = 3;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.d;
                    eAMapPlatformGestureInfo.mLocation = new float[]{moveGestureDetector.getEvent().getX(), moveGestureDetector.getEvent().getY()};
                    int a2 = h.this.a.a(this.d);
                    if (h.this.j > 0) {
                        h.this.a.a(5);
                    }
                    h.this.a.a(a2, (GestureMapMessage) MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: GLMapGestureDetector */
    private class d extends ScaleRotateGestureDetector.SimpleOnScaleRotateGestureListener {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ d(h hVar, byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c4, code lost:
            if (java.lang.Math.abs(r4) >= 0.02f) goto L_0x00c6;
         */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0124 A[Catch:{ Throwable -> 0x019a }] */
        /* JADX WARNING: Removed duplicated region for block: B:70:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean onScaleRotate(com.autonavi.ae.gmap.gesture.ScaleRotateGestureDetector r18) {
            /*
                r17 = this;
                r1 = r17
                com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo r2 = r1.j
                r3 = 2
                r2.mGestureState = r3
                com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo r2 = r1.j
                r4 = 4
                r2.mGestureType = r4
                com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo r2 = r1.j
                float[] r4 = new float[r3]
                android.view.MotionEvent r5 = r18.getEvent()
                float r5 = r5.getX()
                r6 = 0
                r4[r6] = r5
                android.view.MotionEvent r5 = r18.getEvent()
                float r5 = r5.getY()
                r7 = 1
                r4[r7] = r5
                r2.mLocation = r4
                com.amap.api.col.n3.h r2 = com.amap.api.col.n3.h.this
                com.amap.api.col.n3.k r2 = r2.a
                com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo r4 = r1.j
                int r2 = r2.a((com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo) r4)
                float r4 = r18.getScaleFactor()
                long r8 = r18.getTimeDelta()
                float r5 = (float) r8
                float r8 = r18.getFocusX()
                int r8 = (int) r8
                float r9 = r18.getFocusY()
                int r9 = (int) r9
                android.graphics.Point r10 = r1.e
                int r10 = r10.x
                int r10 = r8 - r10
                int r10 = java.lang.Math.abs(r10)
                float r10 = (float) r10
                android.graphics.Point r11 = r1.e
                int r11 = r11.y
                int r11 = r9 - r11
                int r11 = java.lang.Math.abs(r11)
                float r11 = (float) r11
                android.graphics.Point r12 = r1.e
                r12.x = r8
                android.graphics.Point r12 = r1.e
                r12.y = r9
                double r12 = (double) r4
                double r12 = java.lang.Math.log(r12)
                float r4 = (float) r12
                com.amap.api.col.n3.h r12 = com.amap.api.col.n3.h.this
                int r12 = r12.k
                if (r12 > 0) goto L_0x0081
                float r12 = java.lang.Math.abs(r4)
                double r12 = (double) r12
                r14 = 4596373779694328218(0x3fc999999999999a, double:0.2)
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 <= 0) goto L_0x0081
                r1.d = r7
            L_0x0081:
                r12 = 101(0x65, float:1.42E-43)
                r13 = 1073741824(0x40000000, float:2.0)
                com.amap.api.col.n3.h r14 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x010a }
                com.amap.api.col.n3.k r14 = r14.a     // Catch:{ Throwable -> 0x010a }
                com.amap.api.col.n3.n r14 = r14.i()     // Catch:{ Throwable -> 0x010a }
                boolean r14 = r14.isZoomGesturesEnabled()     // Catch:{ Throwable -> 0x010a }
                if (r14 == 0) goto L_0x0116
                boolean r14 = r1.b     // Catch:{ Throwable -> 0x010a }
                if (r14 != 0) goto L_0x00a4
                r14 = 1031127695(0x3d75c28f, float:0.06)
                float r15 = java.lang.Math.abs(r4)     // Catch:{ Throwable -> 0x010a }
                int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
                if (r14 >= 0) goto L_0x00a4
                r1.b = r7     // Catch:{ Throwable -> 0x010a }
            L_0x00a4:
                boolean r14 = r1.b     // Catch:{ Throwable -> 0x010a }
                if (r14 == 0) goto L_0x0116
                r14 = 1008981770(0x3c23d70a, float:0.01)
                float r15 = java.lang.Math.abs(r4)     // Catch:{ Throwable -> 0x010a }
                int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
                if (r14 >= 0) goto L_0x0116
                int r6 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
                if (r6 > 0) goto L_0x00bb
                int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r6 <= 0) goto L_0x00c6
            L_0x00bb:
                float r6 = java.lang.Math.abs(r4)     // Catch:{ Throwable -> 0x0106 }
                r14 = 1017370378(0x3ca3d70a, float:0.02)
                int r6 = (r6 > r14 ? 1 : (r6 == r14 ? 0 : -1))
                if (r6 < 0) goto L_0x00fc
            L_0x00c6:
                r6 = 0
                int r14 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
                if (r14 <= 0) goto L_0x00fc
                float r14 = r4 / r5
                r1.g = r14     // Catch:{ Throwable -> 0x0106 }
                float r14 = r1.g     // Catch:{ Throwable -> 0x0106 }
                float r14 = java.lang.Math.abs(r14)     // Catch:{ Throwable -> 0x0106 }
                float[] r15 = r1.f     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.h r13 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0106 }
                int r13 = r13.k     // Catch:{ Throwable -> 0x0106 }
                int r13 = r13 % 10
                r15[r13] = r14     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.h r13 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0106 }
                int unused = r13.k = r13.k + 1     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.h r13 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.k r13 = r13.a     // Catch:{ Throwable -> 0x0106 }
                com.autonavi.amap.mapcore.message.ScaleGestureMapMessage r14 = com.autonavi.amap.mapcore.message.ScaleGestureMapMessage.obtain(r12, r4, r8, r9)     // Catch:{ Throwable -> 0x0106 }
                r13.a((int) r2, (com.autonavi.amap.mapcore.message.GestureMapMessage) r14)     // Catch:{ Throwable -> 0x0106 }
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 <= 0) goto L_0x00fe
                com.amap.api.col.n3.h r3 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.k r3 = r3.a     // Catch:{ Throwable -> 0x0106 }
                r3.a((int) r7)     // Catch:{ Throwable -> 0x0106 }
            L_0x00fc:
                r6 = r7
                goto L_0x0116
            L_0x00fe:
                com.amap.api.col.n3.h r4 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0106 }
                com.amap.api.col.n3.k r4 = r4.a     // Catch:{ Throwable -> 0x0106 }
                r4.a((int) r3)     // Catch:{ Throwable -> 0x0106 }
                goto L_0x00fc
            L_0x0106:
                r0 = move-exception
                r3 = r0
                r6 = r7
                goto L_0x010c
            L_0x010a:
                r0 = move-exception
                r3 = r0
            L_0x010c:
                java.lang.String r4 = "GLMapGestrureDetector"
                java.lang.String r13 = "onScaleRotate"
                com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r13)
                r3.printStackTrace()
            L_0x0116:
                com.amap.api.col.n3.h r3 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.k r3 = r3.a     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.n r3 = r3.i()     // Catch:{ Throwable -> 0x019a }
                boolean r3 = r3.isRotateGesturesEnabled()     // Catch:{ Throwable -> 0x019a }
                if (r3 == 0) goto L_0x01a6
                com.amap.api.col.n3.h r3 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.k r3 = r3.a     // Catch:{ Throwable -> 0x019a }
                boolean r3 = r3.d((int) r2)     // Catch:{ Throwable -> 0x019a }
                if (r3 != 0) goto L_0x01a6
                boolean r3 = r1.d     // Catch:{ Throwable -> 0x019a }
                if (r3 != 0) goto L_0x01a6
                float r3 = r18.getRotationDegreesDelta()     // Catch:{ Throwable -> 0x019a }
                boolean r4 = r1.c     // Catch:{ Throwable -> 0x019a }
                r13 = 1082130432(0x40800000, float:4.0)
                if (r4 != 0) goto L_0x0146
                float r4 = java.lang.Math.abs(r3)     // Catch:{ Throwable -> 0x019a }
                int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
                if (r4 < 0) goto L_0x0146
                r1.c = r7     // Catch:{ Throwable -> 0x019a }
            L_0x0146:
                boolean r4 = r1.c     // Catch:{ Throwable -> 0x019a }
                if (r4 == 0) goto L_0x01a6
                r4 = 1065353216(0x3f800000, float:1.0)
                float r14 = java.lang.Math.abs(r3)     // Catch:{ Throwable -> 0x019a }
                int r4 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r4 >= 0) goto L_0x01a6
                int r4 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
                if (r4 > 0) goto L_0x015c
                int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r4 <= 0) goto L_0x0166
            L_0x015c:
                float r4 = java.lang.Math.abs(r3)     // Catch:{ Throwable -> 0x019a }
                r10 = 1073741824(0x40000000, float:2.0)
                int r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
                if (r4 < 0) goto L_0x01a6
            L_0x0166:
                float r4 = r3 / r5
                r1.i = r4     // Catch:{ Throwable -> 0x019a }
                float r4 = r1.i     // Catch:{ Throwable -> 0x019a }
                float r4 = java.lang.Math.abs(r4)     // Catch:{ Throwable -> 0x019a }
                float[] r5 = r1.h     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.h r10 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x019a }
                int r10 = r10.l     // Catch:{ Throwable -> 0x019a }
                int r10 = r10 % 10
                r5[r10] = r4     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.h r4 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x019a }
                int unused = r4.l = r4.l + 1     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.h r4 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.k r4 = r4.a     // Catch:{ Throwable -> 0x019a }
                com.autonavi.amap.mapcore.message.RotateGestureMapMessage r3 = com.autonavi.amap.mapcore.message.RotateGestureMapMessage.obtain(r12, r3, r8, r9)     // Catch:{ Throwable -> 0x019a }
                r4.a((int) r2, (com.autonavi.amap.mapcore.message.GestureMapMessage) r3)     // Catch:{ Throwable -> 0x019a }
                com.amap.api.col.n3.h r2 = com.amap.api.col.n3.h.this     // Catch:{ Throwable -> 0x0196 }
                com.amap.api.col.n3.k r2 = r2.a     // Catch:{ Throwable -> 0x0196 }
                r3 = 6
                r2.a((int) r3)     // Catch:{ Throwable -> 0x0196 }
                r6 = r7
                goto L_0x01a6
            L_0x0196:
                r0 = move-exception
                r2 = r0
                r6 = r7
                goto L_0x019c
            L_0x019a:
                r0 = move-exception
                r2 = r0
            L_0x019c:
                java.lang.String r3 = "GLMapGestrureDetector"
                java.lang.String r4 = "onScaleRotate"
                com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)
                r2.printStackTrace()
            L_0x01a6:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.h.d.onScaleRotate(com.autonavi.ae.gmap.gesture.ScaleRotateGestureDetector):boolean");
        }

        public final boolean onScaleRotateBegin(ScaleRotateGestureDetector scaleRotateGestureDetector) {
            this.j.mGestureState = 1;
            this.j.mGestureType = 4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mLocation = new float[]{scaleRotateGestureDetector.getEvent().getX(), scaleRotateGestureDetector.getEvent().getY()};
            int a2 = h.this.a.a(this.j);
            int focusX = (int) scaleRotateGestureDetector.getFocusX();
            int focusY = (int) scaleRotateGestureDetector.getFocusY();
            this.d = false;
            this.e.x = focusX;
            this.e.y = focusY;
            this.b = false;
            this.c = false;
            h.this.a.a(a2, (GestureMapMessage) ScaleGestureMapMessage.obtain(100, 1.0f, focusX, focusY));
            try {
                if (h.this.a.i().isRotateGesturesEnabled() && !h.this.a.d(a2)) {
                    h.this.a.a(a2, (GestureMapMessage) RotateGestureMapMessage.obtain(100, h.this.a.k(a2), focusX, focusY));
                }
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        public final void onScaleRotateEnd(ScaleRotateGestureDetector scaleRotateGestureDetector) {
            int i2;
            this.j.mGestureState = 3;
            this.j.mGestureType = 4;
            this.j.mLocation = new float[]{scaleRotateGestureDetector.getEvent().getX(), scaleRotateGestureDetector.getEvent().getY()};
            int a2 = h.this.a.a(this.j);
            this.d = false;
            h.this.a.a(a2, (GestureMapMessage) ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (h.this.k > 0) {
                int b2 = h.this.k > 10 ? 10 : h.this.k;
                float f2 = 0.0f;
                for (int i3 = 0; i3 < 10; i3++) {
                    f2 += this.f[i3];
                    this.f[i3] = 0.0f;
                }
                if (0.004f <= f2 / ((float) b2)) {
                    float f3 = this.g;
                    h.this.a.b(a2);
                }
                this.g = 0.0f;
            }
            if (!h.this.a.d(a2)) {
                try {
                    if (h.this.a.i().isRotateGesturesEnabled()) {
                        h.this.a.a(a2, (GestureMapMessage) RotateGestureMapMessage.obtain(102, h.this.a.k(a2), 0, 0));
                    }
                } catch (Throwable th) {
                    iu.b(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (h.this.l > 0) {
                    h.this.a.a(6);
                    if (h.this.l > 10) {
                        i2 = 10;
                    } else {
                        i2 = h.this.l;
                    }
                    float f4 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        f4 += this.h[i4];
                        this.h[i4] = 0.0f;
                    }
                    if (0.1f <= f4 / ((float) i2)) {
                        h.this.a.k(a2);
                        float f5 = this.i;
                    }
                }
                this.g = 0.0f;
            }
        }
    }

    /* compiled from: GLMapGestureDetector */
    private class e extends ZoomOutGestureDetector.SimpleOnZoomOutGestureListener {
        EAMapPlatformGestureInfo a;

        private e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ e(h hVar, byte b2) {
            this();
        }

        public final void onZoomOut(ZoomOutGestureDetector zoomOutGestureDetector) {
            try {
                if (h.this.a.i().isZoomGesturesEnabled() && Math.abs(zoomOutGestureDetector.getFocusX()) <= 10.0f && Math.abs(zoomOutGestureDetector.getFocusY()) <= 10.0f && zoomOutGestureDetector.getTimeDelta() < 200) {
                    boolean unused = h.this.q = true;
                    this.a.mGestureState = 2;
                    this.a.mGestureType = 2;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                    eAMapPlatformGestureInfo.mLocation = new float[]{zoomOutGestureDetector.getEvent().getX(), zoomOutGestureDetector.getEvent().getY()};
                    int a2 = h.this.a.a(this.a);
                    h.this.a.a(4);
                    h.this.a.c(a2);
                }
            } catch (Throwable th) {
                iu.b(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public final void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public h(k kVar) {
        this.b = kVar.u();
        this.a = kVar;
        a aVar = new a(this, (byte) 0);
        this.c = new GestureDetector(this.b, aVar, this.r);
        this.c.setOnDoubleTapListener(aVar);
        this.e = new ScaleRotateGestureDetector(this.b, new d(this, (byte) 0));
        this.f = new MoveGestureDetector(this.b, new c(this, (byte) 0));
        this.g = new HoverGestureDetector(this.b, new b(this, (byte) 0));
        this.h = new ZoomOutGestureDetector(this.b, new e(this, (byte) 0));
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            boolean onTouchEvent = this.g.onTouchEvent(motionEvent);
            if (this.i && this.m > 0) {
                return onTouchEvent;
            }
            this.h.onTouchEvent(motionEvent);
            if (this.o) {
                return onTouchEvent;
            }
            this.e.onTouchEvent(motionEvent);
            return this.f.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void b() {
        if (this.r != null) {
            this.r.removeCallbacks((Runnable) null);
            this.r = null;
        }
    }
}
