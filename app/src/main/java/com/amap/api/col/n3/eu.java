package com.amap.api.col.n3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviView;
import com.amap.api.navi.AMapNaviViewListener;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.IAMapNaviView;
import com.amap.api.navi.INavi;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.view.DirectionView;
import com.amap.api.navi.view.DriveWayView;
import com.amap.api.navi.view.NextTurnTipView;
import com.amap.api.navi.view.OverviewButtonView;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.navi.view.TrafficBarView;
import com.amap.api.navi.view.TrafficButtonView;
import com.amap.api.navi.view.TrafficProgressBar;
import com.amap.api.navi.view.ZoomButtonView;
import com.amap.api.navi.view.ZoomInIntersectionView;
import com.android.hoinnet.highde.R;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* compiled from: AMapNaviViewCore */
public class eu implements View.OnClickListener, AMap.OnCameraChangeListener, AMap.OnMapLoadedListener, AMap.OnMapTouchListener, IAMapNaviView {
    private static int M = 1000;
    private static int N = 500;
    OverviewButtonView A;
    DriveWayView B;
    RelativeLayout C;
    RelativeLayout D;
    int E = 480;
    int F = GLMapStaticValue.ANIMATION_FLUENT_TIME;
    boolean G = false;
    int H = 0;
    int I = 0;
    boolean J = false;
    boolean K = true;
    boolean L = false;
    /* access modifiers changed from: private */
    public boolean O = false;
    private double P = 0.0d;
    private double Q = 0.0d;
    private int R = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int S = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private AMapNaviViewOptions T = null;
    private MapView U;
    /* access modifiers changed from: private */
    public INavi V;
    /* access modifiers changed from: private */
    public fg W;
    private AMap X;
    /* access modifiers changed from: private */
    public a Y;
    private long Z = 6000;
    ZoomInIntersectionView a;
    private boolean aa = true;
    private int ab = 0;
    /* access modifiers changed from: private */
    public AMapNaviViewListener ac;
    private boolean ad = true;
    private boolean ae = true;
    private boolean af = false;
    private int ag = 0;
    private DriveWayView ah;
    private ZoomInIntersectionView ai;
    private TrafficBarView aj;
    private TrafficProgressBar ak;
    private DirectionView al;
    private TrafficButtonView am;
    private NextTurnTipView an;
    private ZoomButtonView ao;
    /* access modifiers changed from: private */
    public AMapNaviView ap;
    private View.OnClickListener aq = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (eu.this.O) {
                    eu.this.recoverLockMode();
                } else {
                    eu.this.d(true);
                    eu.this.a(false);
                    eu.this.W.b();
                }
                if (eu.this.ac != null) {
                    eu.this.ac.onScanViewButtonClick();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private Context ar;
    private ZoomButtonView as;
    /* access modifiers changed from: private */
    public OverviewButtonView at;
    private View.OnClickListener au = new View.OnClickListener() {
        public final void onClick(View view) {
            eu.e(eu.this);
        }
    };
    private View.OnClickListener av = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (eu.this.ap != null && eu.this.at != null) {
                    if (eu.this.ap.isRouteOverviewNow()) {
                        eu.this.ap.recoverLockMode();
                    } else {
                        eu.this.ap.displayOverview();
                    }
                    eu.this.at.setChecked(eu.this.ap.isRouteOverviewNow());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private CrossOverlay aw;
    private boolean ax = false;
    private boolean ay = false;
    private AMapModelCross az;
    View b = null;
    NextTurnTipView c;
    TextView d;
    TextView e;
    TextView f;
    FrameLayout g;
    FrameLayout h;
    LinearLayout i;
    LinearLayout j;
    LinearLayout k;
    FrameLayout l;
    LinearLayout m;
    TextView n;
    TextView o;
    TrafficProgressBar p;
    DirectionView q;
    TrafficButtonView r;
    Drawable s;
    Drawable t;
    TextView u;
    TextView v;
    ImageView w;
    ImageView x;
    ImageView y;
    ImageView z;

    /* compiled from: AMapNaviViewCore */
    class a extends Handler {
        private WeakReference<eu> b;

        a(eu euVar) {
            try {
                this.b = new WeakReference<>(euVar);
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "AMapNaviView", "MapViewListenerTriggerHandler()");
            }
        }

        public final void handleMessage(Message message) {
            eu euVar = (eu) this.b.get();
            if (euVar != null) {
                try {
                    boolean z = false;
                    switch (message.what) {
                        case 0:
                            euVar.a(true);
                            return;
                        case 1:
                            if (euVar.ac != null) {
                                euVar.ac.onNaviSetting();
                                return;
                            }
                            return;
                        case 2:
                            new AlertDialog.Builder(euVar.ar).setTitle("提示").setMessage("确定退出导航?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    try {
                                        dialogInterface.cancel();
                                        eu.this.V.stopNavi();
                                        eu.this.Y.sendEmptyMessage(3);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (dialogInterface != null) {
                                        try {
                                            dialogInterface.cancel();
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                }
                            }).show();
                            return;
                        case 3:
                            if (euVar.ac != null) {
                                euVar.ac.onNaviCancel();
                                return;
                            }
                            return;
                        case 4:
                            euVar.a(false);
                            return;
                        case 5:
                            if (euVar.ac != null) {
                                euVar.ac.onNaviViewLoaded();
                                return;
                            }
                            return;
                        case 6:
                            boolean z2 = message.arg1 == 1;
                            if (message.arg2 == 1) {
                                z = true;
                            }
                            eu.this.a(z2, z);
                            return;
                        case 7:
                            eu.this.a();
                            return;
                        case 8:
                            if (eu.this.r != null && message.obj != null) {
                                eu.this.r.setIsTrafficOpen(((Boolean) message.obj).booleanValue());
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                } catch (Throwable th) {
                    hq.a(th);
                    iu.b(th, "AMapNaviView", "MapViewListenerTriggerHandler.handleMessage(android.os.Message msg) ");
                }
            }
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
    }

    static /* synthetic */ void e(eu euVar) {
        try {
            boolean isTrafficEnabled = euVar.X.isTrafficEnabled();
            euVar.r.setIsTrafficOpen(!isTrafficEnabled);
            if (euVar.getLazyTrafficButtonView() != null) {
                euVar.getLazyTrafficButtonView().setIsTrafficOpen(!isTrafficEnabled);
            }
            euVar.setTrafficLine(!isTrafficEnabled);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public eu(AMapNaviView aMapNaviView, AMapNaviViewOptions aMapNaviViewOptions) {
        this.T = aMapNaviViewOptions;
        this.ap = aMapNaviView;
        this.ar = aMapNaviView.getContext();
    }

    public double getAnchorX() {
        return this.P;
    }

    public double getAnchorY() {
        return this.Q;
    }

    public int getLockZoom() {
        return this.R;
    }

    public void setLockZoom(int i2) {
        if (i2 != this.R) {
            if (this.T != null) {
                this.T.setZoom(i2);
            }
            setViewOptions(this.T);
        }
    }

    public int getLockTilt() {
        return this.S;
    }

    public void setLockTilt(int i2) {
        try {
            if (i2 != this.S) {
                this.T.setTilt(i2);
                setViewOptions(this.T);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getNaviMode() {
        return this.ag;
    }

    public void setNaviMode(int i2) {
        if (i2 == 1 || i2 == 0) {
            try {
                if (i2 != this.ag) {
                    this.ag = i2;
                    a(true);
                    if (i2 == 1) {
                        if (this.W != null) {
                            this.W.d();
                        }
                    } else if (i2 == 0 && this.W != null) {
                        this.W.e();
                    }
                    if (this.ac != null) {
                        this.ac.onNaviMapMode(this.ag);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean isAutoChangeZoom() {
        return this.af;
    }

    public AMapNaviViewOptions getViewOptions() {
        return this.T;
    }

    public void setViewOptions(AMapNaviViewOptions aMapNaviViewOptions) {
        if (aMapNaviViewOptions != null) {
            this.T = aMapNaviViewOptions;
            if (this.Y != null) {
                this.Y.obtainMessage(7).sendToTarget();
            }
        }
    }

    public AMap getMap() {
        return this.X;
    }

    public void init() {
        try {
            if (this.T == null) {
                this.T = new AMapNaviViewOptions();
            }
            this.V = AMapNavi.getInstance(this.ar);
            hs.a(this.ar.getApplicationContext());
            this.b = hs.a(this.ar, R.attr.actionBarPopupTheme, (ViewGroup) null);
            this.ap.addView(this.b);
            this.U = (MapView) this.b.findViewById(2131296271);
            this.G = h();
            if (this.W == null) {
                this.W = new fg(this.ar, this.U, this);
            }
            this.a = (ZoomInIntersectionView) this.ap.findViewById(2131296281);
            this.q = (DirectionView) this.b.findViewById(2131296276);
            this.D = (RelativeLayout) this.b.findViewById(2131296270);
            this.B = (DriveWayView) this.b.findViewById(2131296285);
            this.B.setAMapNaviView(this.ap);
            this.c = (NextTurnTipView) this.b.findViewById(2131296275);
            this.d = (TextView) this.b.findViewById(2131296274);
            this.e = (TextView) this.b.findViewById(2131296278);
            this.f = (TextView) this.b.findViewById(2131296279);
            this.u = (TextView) this.b.findViewById(2131296291);
            this.v = (TextView) this.b.findViewById(2131296292);
            this.g = (FrameLayout) this.b.findViewById(2131296295);
            this.h = (FrameLayout) this.b.findViewById(2131296290);
            this.x = (ImageView) this.b.findViewById(2131296297);
            this.y = (ImageView) this.b.findViewById(2131296289);
            this.z = (ImageView) this.b.findViewById(2131296298);
            this.w = (ImageView) this.b.findViewById(2131296288);
            this.l = (FrameLayout) this.b.findViewById(2131296293);
            this.m = (LinearLayout) this.b.findViewById(2131296287);
            this.n = (TextView) this.b.findViewById(2131296294);
            this.o = (TextView) this.b.findViewById(2131296296);
            this.r = (TrafficButtonView) this.b.findViewById(2131296280);
            this.r.setOnClickListener(this.au);
            this.A = (OverviewButtonView) this.b.findViewById(2131296284);
            this.A.setOnClickListener(this.aq);
            this.s = hs.a().getDrawable(2130837682);
            this.t = hs.a().getDrawable(2130837681);
            this.C = (RelativeLayout) this.b.findViewById(2131296286);
            this.i = (LinearLayout) this.b.findViewById(2131296272);
            this.j = (LinearLayout) this.b.findViewById(2131296277);
            this.k = (LinearLayout) this.b.findViewById(2131296282);
            this.ao = (ZoomButtonView) this.b.findViewById(2131296283);
            this.ao.getZoomInBtn().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    eu.this.zoomIn();
                }
            });
            this.ao.getZoomOutBtn().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    eu.this.zoomOut();
                }
            });
            this.p = new TrafficProgressBar(this.ar);
            this.p.setVisibility(8);
            b(this.G);
            this.D.addView(this.p);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "init()");
            return;
        }
        this.Y = new a(this);
    }

    private boolean h() {
        return ((Activity) this.ar).getRequestedOrientation() == 0 || this.ap.getResources().getConfiguration().orientation == 2;
    }

    private void i() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.ar.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.E = displayMetrics.widthPixels;
        this.F = displayMetrics.heightPixels;
    }

    private void b(boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        int b2 = hq.b(this.ar, 12);
        if (z2) {
            layoutParams = new RelativeLayout.LayoutParams(-2, hq.b(this.ar, 220));
            layoutParams.addRule(12);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, hq.b(this.ar, 350));
            layoutParams.addRule(15);
        }
        layoutParams.rightMargin = b2;
        layoutParams.addRule(11);
        this.p.setLayoutParams(layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        try {
            i();
            this.G = h();
            M = this.E / 2;
            c(this.G);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onConfigurationChanged(Configuration newConfig)");
        }
    }

    private void c(boolean z2) {
        if (this.aj != null) {
            this.aj.onConfigurationChanged(z2);
        }
        b(z2);
        if (z2) {
            if (!this.J) {
                this.f.setVisibility(0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams.width = a(320);
            this.C.setLayoutParams(layoutParams);
            b(0);
            d(0);
            if (this.a.getVisibility() == 0) {
                j();
            }
        } else {
            this.f.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams2.width = -2;
            this.C.setLayoutParams(layoutParams2);
            b(40);
            d(30);
            if (this.a.getVisibility() == 0) {
                j();
            }
        }
        a(this.aa);
        if (this.ay && this.az != null && this.aw != null) {
            this.aw.remove();
            a(this.az);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0081 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b1 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c8 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00db A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0102 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012c A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0216 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0221 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0235 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0253 A[Catch:{ Throwable -> 0x0055, Throwable -> 0x02d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r10 = this;
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            double r0 = r0.getMapCenter_X()     // Catch:{ Throwable -> 0x02d0 }
            r10.P = r0     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            double r0 = r0.getMapCenter_Y()     // Catch:{ Throwable -> 0x02d0 }
            r10.Q = r0     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r0 = r0.isLayoutVisible()     // Catch:{ Throwable -> 0x02d0 }
            r10.K = r0     // Catch:{ Throwable -> 0x02d0 }
            r0 = 8
            r1 = 0
            boolean r2 = r10.K     // Catch:{ Throwable -> 0x0055 }
            if (r2 != 0) goto L_0x0037
            android.widget.LinearLayout r2 = r10.m     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.k     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.i     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.j     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x0055 }
        L_0x0033:
            r10.b((int) r1)     // Catch:{ Throwable -> 0x0055 }
            goto L_0x0059
        L_0x0037:
            android.widget.LinearLayout r2 = r10.m     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.k     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.i     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x0055 }
            android.widget.LinearLayout r2 = r10.j     // Catch:{ Throwable -> 0x0055 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x0055 }
            boolean r2 = r10.G     // Catch:{ Throwable -> 0x0055 }
            if (r2 != 0) goto L_0x0033
            r2 = 40
            r10.b((int) r2)     // Catch:{ Throwable -> 0x0055 }
            goto L_0x0059
        L_0x0055:
            r2 = move-exception
            r2.printStackTrace()     // Catch:{ Throwable -> 0x02d0 }
        L_0x0059:
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            long r2 = r2.getLockMapDelayed()     // Catch:{ Throwable -> 0x02d0 }
            r10.Z = r2     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isAutoChangeZoom()     // Catch:{ Throwable -> 0x02d0 }
            r10.af = r2     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isRealCrossDisplayShow()     // Catch:{ Throwable -> 0x02d0 }
            r10.ad = r2     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isModelCrossDisplayShow()     // Catch:{ Throwable -> 0x02d0 }
            r10.ae = r2     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isCompassEnabled()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 != 0) goto L_0x0086
            com.amap.api.navi.view.DirectionView r2 = r10.q     // Catch:{ Throwable -> 0x02d0 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x02d0 }
        L_0x0086:
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            if (r2 == 0) goto L_0x00a9
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            int r2 = r2.getEngineType()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 != 0) goto L_0x00a9
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isTrafficBarEnabled()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 != 0) goto L_0x009d
            com.amap.api.navi.view.TrafficProgressBar r2 = r10.p     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x00a5
        L_0x009d:
            com.amap.api.navi.view.TrafficProgressBar r2 = r10.p     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r10.aa     // Catch:{ Throwable -> 0x02d0 }
            if (r3 == 0) goto L_0x00a5
            r3 = r1
            goto L_0x00a6
        L_0x00a5:
            r3 = r0
        L_0x00a6:
            r2.setVisibility(r3)     // Catch:{ Throwable -> 0x02d0 }
        L_0x00a9:
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isTrafficLayerEnabled()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 == 0) goto L_0x00c8
            com.amap.api.navi.view.TrafficButtonView r2 = r10.r     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r3 = r3.getDefaultTrafficBitmap()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r4 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r4 = r4.getPressedTrafficBitmap()     // Catch:{ Throwable -> 0x02d0 }
            r2.reDrawBackground(r3, r4)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.view.TrafficButtonView r2 = r10.r     // Catch:{ Throwable -> 0x02d0 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x00cd
        L_0x00c8:
            com.amap.api.navi.view.TrafficButtonView r2 = r10.r     // Catch:{ Throwable -> 0x02d0 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x02d0 }
        L_0x00cd:
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isRouteListButtonShow()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 != 0) goto L_0x00db
            com.amap.api.navi.view.OverviewButtonView r2 = r10.A     // Catch:{ Throwable -> 0x02d0 }
            r2.setVisibility(r0)     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x00f5
        L_0x00db:
            com.amap.api.navi.view.OverviewButtonView r2 = r10.A     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r3 = r3.getDefaultOverBitmap()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r4 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r4 = r4.getPressedOverBitmap()     // Catch:{ Throwable -> 0x02d0 }
            r2.reDrawBackground(r3, r4)     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r10.aa     // Catch:{ Throwable -> 0x02d0 }
            if (r2 != 0) goto L_0x00f5
            com.amap.api.navi.view.OverviewButtonView r2 = r10.A     // Catch:{ Throwable -> 0x02d0 }
            r2.setVisibility(r1)     // Catch:{ Throwable -> 0x02d0 }
        L_0x00f5:
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            java.lang.String r2 = r2.getCustomMapStylePath()     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x02d0 }
            r3 = 1
            if (r2 == 0) goto L_0x012c
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            r2.setMapCustomEnable(r1)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isNaviNight()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 == 0) goto L_0x011e
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            int r2 = r2.getMapType()     // Catch:{ Throwable -> 0x02d0 }
            r3 = 3
            if (r2 == r3) goto L_0x013c
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            r2.setMapType(r3)     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x013c
        L_0x011e:
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            int r2 = r2.getMapType()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 == r3) goto L_0x013c
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            r2.setMapType(r3)     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x013c
        L_0x012c:
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            r2.setMapCustomEnable(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.maps.AMap r2 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            java.lang.String r3 = r3.getCustomMapStylePath()     // Catch:{ Throwable -> 0x02d0 }
            r2.setCustomMapStylePath(r3)     // Catch:{ Throwable -> 0x02d0 }
        L_0x013c:
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isTrafficLine()     // Catch:{ Throwable -> 0x02d0 }
            r2.d((boolean) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isSensorEnable()     // Catch:{ Throwable -> 0x02d0 }
            r2.e((boolean) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            int r3 = r3.getLeaderLineColor()     // Catch:{ Throwable -> 0x02d0 }
            r2.a((int) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isAutoDrawRoute()     // Catch:{ Throwable -> 0x02d0 }
            r2.a((boolean) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isLaneInfoShow()     // Catch:{ Throwable -> 0x02d0 }
            r2.b((boolean) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isCameraBubbleShow()     // Catch:{ Throwable -> 0x02d0 }
            r2.f((boolean) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r2 = r2.getStartMarker()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r3 = r3.getEndMarker()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r4 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r4 = r4.getWayMarker()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r5 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r5 = r5.getMonitorMarker()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r6 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r6 = r6.getCarBitmap()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r7 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            android.graphics.Bitmap r7 = r7.getFourCornersBitmap()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r8 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.model.RouteOverlayOptions r8 = r8.getRouteOverlayOptions()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r9 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r9.a((android.graphics.Bitmap) r2)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.b((android.graphics.Bitmap) r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.c((android.graphics.Bitmap) r4)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.d((android.graphics.Bitmap) r5)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.e((android.graphics.Bitmap) r6)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.f((android.graphics.Bitmap) r7)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r2 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            r2.a((com.amap.api.navi.model.RouteOverlayOptions) r8)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.NaviSetting r2 = r2.getNaviSetting()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isScreenAlwaysBright()     // Catch:{ Throwable -> 0x02d0 }
            r2.setScreenAlwaysBright(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.NaviSetting r2 = r2.getNaviSetting()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isTrafficInfoUpdateEnabled()     // Catch:{ Throwable -> 0x02d0 }
            r2.setTrafficInfoUpdateEnabled(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.NaviSetting r2 = r2.getNaviSetting()     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isCameraInfoUpdateEnabled()     // Catch:{ Throwable -> 0x02d0 }
            r2.setCameraInfoUpdateEnabled(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isReCalculateRouteForYaw()     // Catch:{ Throwable -> 0x02d0 }
            r2.setReCalculateRouteForYaw(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.INavi r2 = r10.V     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r3 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r3 = r3.isReCalculateRouteForTrafficJam()     // Catch:{ Throwable -> 0x02d0 }
            r2.setReCalculateRouteForTrafficJam(r3)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.navi.AMapNaviViewOptions r2 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            boolean r2 = r2.isSettingMenuEnabled()     // Catch:{ Throwable -> 0x02d0 }
            if (r2 == 0) goto L_0x0221
            android.widget.ImageView r0 = r10.x     // Catch:{ Throwable -> 0x02d0 }
            r0.setVisibility(r1)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r0 = r10.z     // Catch:{ Throwable -> 0x02d0 }
            r0.setVisibility(r1)     // Catch:{ Throwable -> 0x02d0 }
            goto L_0x022b
        L_0x0221:
            android.widget.ImageView r1 = r10.x     // Catch:{ Throwable -> 0x02d0 }
            r1.setVisibility(r0)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r1 = r10.z     // Catch:{ Throwable -> 0x02d0 }
            r1.setVisibility(r0)     // Catch:{ Throwable -> 0x02d0 }
        L_0x022b:
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            int r0 = r0.getZoom()     // Catch:{ Throwable -> 0x02d0 }
            int r1 = r10.R     // Catch:{ Throwable -> 0x02d0 }
            if (r0 == r1) goto L_0x0249
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            int r0 = r0.getZoom()     // Catch:{ Throwable -> 0x02d0 }
            r10.R = r0     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.maps.AMap r0 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            int r1 = r10.R     // Catch:{ Throwable -> 0x02d0 }
            float r1 = (float) r1     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.maps.CameraUpdate r1 = com.amap.api.maps.CameraUpdateFactory.zoomTo(r1)     // Catch:{ Throwable -> 0x02d0 }
            r0.moveCamera(r1)     // Catch:{ Throwable -> 0x02d0 }
        L_0x0249:
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            int r0 = r0.getTilt()     // Catch:{ Throwable -> 0x02d0 }
            int r1 = r10.S     // Catch:{ Throwable -> 0x02d0 }
            if (r0 == r1) goto L_0x0267
            com.amap.api.navi.AMapNaviViewOptions r0 = r10.T     // Catch:{ Throwable -> 0x02d0 }
            int r0 = r0.getTilt()     // Catch:{ Throwable -> 0x02d0 }
            r10.S = r0     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.maps.AMap r0 = r10.X     // Catch:{ Throwable -> 0x02d0 }
            int r1 = r10.S     // Catch:{ Throwable -> 0x02d0 }
            float r1 = (float) r1     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.maps.CameraUpdate r1 = com.amap.api.maps.CameraUpdateFactory.changeTilt(r1)     // Catch:{ Throwable -> 0x02d0 }
            r0.moveCamera(r1)     // Catch:{ Throwable -> 0x02d0 }
        L_0x0267:
            android.widget.TextView r0 = r10.d     // Catch:{ Throwable -> 0x02d0 }
            r1 = -1
            r0.setTextColor(r1)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.TextView r0 = r10.e     // Catch:{ Throwable -> 0x02d0 }
            r0.setTextColor(r1)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.TextView r0 = r10.f     // Catch:{ Throwable -> 0x02d0 }
            r0.setTextColor(r1)     // Catch:{ Throwable -> 0x02d0 }
            android.content.res.Resources r0 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x02d0 }
            r2 = 2130837688(0x7f0200b8, float:1.7280337E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.LinearLayout r2 = r10.m     // Catch:{ Throwable -> 0x02d0 }
            r2.setBackgroundDrawable(r0)     // Catch:{ Throwable -> 0x02d0 }
            android.content.res.Resources r0 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x02d0 }
            r2 = 2130837705(0x7f0200c9, float:1.7280372E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r2 = r10.x     // Catch:{ Throwable -> 0x02d0 }
            r2.setBackgroundDrawable(r0)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r2 = r10.y     // Catch:{ Throwable -> 0x02d0 }
            r2.setBackgroundDrawable(r0)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r0 = r10.w     // Catch:{ Throwable -> 0x02d0 }
            android.content.res.Resources r2 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x02d0 }
            r3 = 2130837760(0x7f020100, float:1.7280483E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Throwable -> 0x02d0 }
            r0.setImageDrawable(r2)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.ImageView r0 = r10.z     // Catch:{ Throwable -> 0x02d0 }
            android.content.res.Resources r2 = com.amap.api.col.n3.hs.a()     // Catch:{ Throwable -> 0x02d0 }
            r3 = 2130837762(0x7f020102, float:1.7280487E38)
            android.graphics.drawable.Drawable r2 = r2.getDrawable(r3)     // Catch:{ Throwable -> 0x02d0 }
            r0.setImageDrawable(r2)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.TextView r0 = r10.n     // Catch:{ Throwable -> 0x02d0 }
            r0.setTextColor(r1)     // Catch:{ Throwable -> 0x02d0 }
            android.widget.TextView r0 = r10.o     // Catch:{ Throwable -> 0x02d0 }
            r0.setTextColor(r1)     // Catch:{ Throwable -> 0x02d0 }
            com.amap.api.col.n3.fg r0 = r10.W     // Catch:{ Throwable -> 0x02d0 }
            java.lang.String r1 = "#ffffff"
            java.lang.String r2 = "#ffffff"
            r0.a((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x02d0 }
            return
        L_0x02d0:
            r0 = move-exception
            com.amap.api.col.n3.hq.a((java.lang.Throwable) r0)
            java.lang.String r1 = "AMapNaviView"
            java.lang.String r2 = "checkViewOptions()"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.eu.a():void");
    }

    private int a(int i2) {
        Context context = this.ar;
        if (i2 == 0) {
            return 0;
        }
        if (context == null) {
            return i2;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "dp2px(int dipValue)");
            return i2;
        }
    }

    public final void onCreate(Bundle bundle) {
        try {
            this.U.onCreate(bundle);
            this.X = this.U.getMap();
            MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
            myTrafficStyle.setRatio(0.7f);
            myTrafficStyle.setSmoothColor(Color.parseColor("#CC80CD65"));
            myTrafficStyle.setCongestedColor(Color.parseColor("#F2CB7257"));
            myTrafficStyle.setSlowColor(Color.parseColor("#F2D5C247"));
            myTrafficStyle.setSeriousCongestedColor(Color.parseColor("#CCA52A2A"));
            this.X.setMyTrafficStyle(myTrafficStyle);
            this.X.getUiSettings().setZoomControlsEnabled(false);
            this.X.setTrafficEnabled(true);
            a();
            this.X.setOnMapLoadedListener(this);
            this.X.setOnCameraChangeListener(this);
            this.X.setOnMapTouchListener(this);
            this.V.addAMapNaviListener(this.W);
            this.g.setOnClickListener(this);
            this.z.setOnClickListener(this);
            this.w.setOnClickListener(this);
            this.c.setOnClickListener(this);
            this.q.setOnClickListener(this);
            this.n.setOnClickListener(this);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onCreate(Bundle bundle)");
            return;
        }
        i();
        c(this.G);
    }

    public final void onResume() {
        try {
            this.U.onResume();
            i();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onResume()");
        }
    }

    public final void onPause() {
        try {
            this.U.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onPause()");
        }
    }

    public final void onDestroy() {
        try {
            this.V.removeAMapNaviListener(this.W);
            this.W.f();
            long currentTimeMillis = System.currentTimeMillis();
            this.U.onDestroy();
            long currentTimeMillis2 = System.currentTimeMillis();
            "mapView destroy()-->" + (currentTimeMillis2 - currentTimeMillis);
            hs.b();
            if (this.a != null) {
                this.a.setVisibility(8);
                this.a.recycleResource();
            }
            if (this.ai != null) {
                this.ai.setVisibility(8);
                this.ai.recycleResource();
            }
            if (this.B != null) {
                this.B.setVisibility(8);
                this.B.recycleResource();
            }
            if (this.ah != null) {
                this.ah.setVisibility(8);
                this.ah.recycleResource();
            }
            if (this.q != null) {
                this.q.setVisibility(8);
                this.q.recycleResource();
            }
            if (this.al != null) {
                this.al.setVisibility(8);
                this.al.recycleResource();
            }
            if (this.aj != null) {
                this.aj.setVisibility(8);
                this.aj.recycleResource();
            }
            if (this.c != null) {
                this.c.setVisibility(8);
                this.c.recycleResource();
            }
            if (this.an != null) {
                this.an.setVisibility(8);
                this.an.recycleResource();
            }
            if (this.r != null) {
                this.r.setVisibility(8);
                this.r.recycleResource();
            }
            if (this.am != null) {
                this.am.setVisibility(8);
                this.am.recycleResource();
            }
            if (this.A != null) {
                this.A.setVisibility(8);
                this.A.recycleResource();
            }
            if (this.at != null) {
                this.at.setVisibility(8);
                this.at.recycleResource();
            }
            if (this.ao != null) {
                this.ao.setVisibility(8);
            }
            if (this.as != null) {
                this.as.setVisibility(8);
            }
            this.ap.removeAllViews();
            this.Y.removeCallbacksAndMessages((Object) null);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onDestroy()");
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            this.U.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onSaveInstanceState(android.os.Bundle paramBundle)");
        }
    }

    public void onMapLoaded() {
        try {
            this.H = this.U.getHeight();
            this.I = this.U.getWidth();
            i();
            N = (this.F / 10) * 4;
            M = this.E / 2;
            if (!(this.H == 0 || this.I == 0)) {
                this.X.setPointToCenter((int) (((double) this.I) * this.P), (int) (((double) this.H) * this.Q));
            }
            this.W.a();
            this.W.a(this.V.getNaviPath());
        } catch (Throwable th) {
            this.Y.sendEmptyMessage(5);
            throw th;
        }
        this.Y.sendEmptyMessage(5);
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        try {
            if (!this.ax) {
                if (getLazyDirectionView() != null) {
                    getLazyDirectionView().setRotate(360.0f - cameraPosition.bearing);
                }
                if (this.q.isShown()) {
                    this.q.setRotate(360.0f - cameraPosition.bearing);
                }
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onCameraChange(CameraPosition arg0)");
        }
    }

    public void displayOverview() {
        d(true);
        if (this.Y != null) {
            this.Y.obtainMessage(6, 0, 0).sendToTarget();
        }
        this.W.b();
    }

    public void openNorthMode() {
        try {
            this.ag = 1;
            a(true);
            this.W.d();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapNaviCross aMapNaviCross) {
        try {
            if (this.K && this.ad) {
                j();
                this.ap.requestLayout();
                this.L = true;
                this.a.setVisibility(0);
                this.a.setIntersectionBitMap(aMapNaviCross);
                e(true);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        try {
            if (this.ad && this.a.getVisibility() == 0) {
                this.L = false;
                k();
                this.a.setVisibility(8);
                this.a.recycleResource();
                this.ap.requestLayout();
                e(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapModelCross aMapModelCross) {
        if (this.ae) {
            try {
                this.ay = true;
                this.az = aMapModelCross;
                GLCrossVector.AVectorCrossAttr aVectorCrossAttr = new GLCrossVector.AVectorCrossAttr();
                aVectorCrossAttr.nCenterX = 0;
                aVectorCrossAttr.nCenterY = 0;
                aVectorCrossAttr.stRectMax = new Rect();
                aVectorCrossAttr.stRectMin = new Rect();
                aVectorCrossAttr.nAngle = 0;
                if (h()) {
                    Rect landscapeCross = this.T.getLandscapeCross();
                    if (landscapeCross != null) {
                        aVectorCrossAttr.stAreaRect = landscapeCross;
                    } else {
                        aVectorCrossAttr.stAreaRect = new Rect(0, a(48), (int) (((double) this.E) * 0.4d), this.F);
                    }
                } else {
                    Rect verticalCross = this.T.getVerticalCross();
                    if (verticalCross != null) {
                        aVectorCrossAttr.stAreaRect = verticalCross;
                    } else {
                        aVectorCrossAttr.stAreaRect = new Rect(0, a(48), this.E, a(290));
                    }
                }
                aVectorCrossAttr.stAreaColor = Color.argb(217, 95, 95, 95);
                aVectorCrossAttr.fImportBorderWidth = 22;
                aVectorCrossAttr.stImportBorderColor = Color.argb(255, 255, 255, 255);
                aVectorCrossAttr.fUnImportBorderWidth = aVectorCrossAttr.fImportBorderWidth;
                aVectorCrossAttr.stUnImportBorderColor = aVectorCrossAttr.stImportBorderColor;
                aVectorCrossAttr.fArrowBorderWidth = 22;
                aVectorCrossAttr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
                aVectorCrossAttr.fImportLineWidth = 18;
                aVectorCrossAttr.stImportLineColor = Color.argb(255, PoiInputSearchWidget.DEF_ANIMATION_DURATION, 170, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                aVectorCrossAttr.fUnImportLineWidth = aVectorCrossAttr.fImportLineWidth;
                aVectorCrossAttr.stUnImportLineColor = aVectorCrossAttr.stImportLineColor;
                aVectorCrossAttr.fDashLineWidth = 2;
                aVectorCrossAttr.stDashLineColor = aVectorCrossAttr.stUnImportBorderColor;
                aVectorCrossAttr.fArrowLineWidth = 18;
                aVectorCrossAttr.stArrowLineColor = Color.argb(255, 255, 253, 65);
                if (this.T.isNaviNight()) {
                    aVectorCrossAttr.dayMode = false;
                } else {
                    aVectorCrossAttr.dayMode = true;
                }
                InputStream open = this.ar.getResources().getAssets().open("vector3d_arrow_in.png");
                this.aw = getMap().addCrossOverlay(new CrossOverlayOptions().setAttribute(aVectorCrossAttr).setRes(BitmapFactory.decodeStream(open)));
                this.aw.setData(aMapModelCross.getPicBuf1());
                this.aw.setVisible(true);
                open.close();
                e(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        if (this.ae && this.aw != null) {
            this.ay = false;
            this.az = null;
            this.aw.setVisible(false);
            e(false);
        }
    }

    private void j() {
        int i2;
        if (this.G) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(M, -1);
            layoutParams.topMargin = hq.a(this.ar, 48);
            this.a.setLayoutParams(layoutParams);
            float f2 = (float) M;
            Context context = this.ar;
            if (f2 == 0.0f) {
                i2 = 0;
            } else {
                if (context != null) {
                    f2 = (f2 / context.getResources().getDisplayMetrics().density) + 0.5f;
                }
                i2 = (int) f2;
            }
            c(i2);
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, N);
        layoutParams2.topMargin = hq.a(this.ar, 48);
        this.a.setLayoutParams(layoutParams2);
    }

    private void k() {
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        if (this.G) {
            c(0);
        }
    }

    public void recoverLockMode() {
        a(true);
    }

    public void onTouch(MotionEvent motionEvent) {
        try {
            if (this.a.getVisibility() == 0) {
                this.a.setVisibility(8);
            }
            if (this.ax && this.aw != null) {
                this.aw.setVisible(false);
            }
            this.Y.sendEmptyMessage(4);
            this.Y.removeMessages(0);
            if (this.T != null && this.T.isAutoLockCar()) {
                this.Y.sendEmptyMessageDelayed(0, this.Z);
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onTouch(MotionEvent arg0)");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        int i2 = 0;
        boolean isAutoLockCar = this.T != null ? this.T.isAutoLockCar() : false;
        if (this.Y != null) {
            a aVar = this.Y;
            if (isAutoLockCar) {
                i2 = 1;
            }
            aVar.obtainMessage(6, z2 ? 1 : 0, i2).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2, boolean z3) {
        try {
            if (!(this.ac == null || this.aa == z2 || this.J)) {
                this.ac.onLockMap(z2);
            }
            int i2 = 8;
            if (!this.G) {
                this.C.setVisibility(0);
            } else if (z2) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            if (!this.J) {
                this.aa = z2;
                this.Y.removeMessages(0);
                if (z2) {
                    d(false);
                } else {
                    k();
                    if (z3) {
                        this.Y.sendEmptyMessageDelayed(0, this.Z);
                    }
                }
                this.W.c(z2);
                this.g.setVisibility(z2 ? 8 : 0);
                this.h.setVisibility(z2 ? 0 : 8);
                this.ao.setVisibility(!z2 ? 0 : 8);
                if (this.T.isRouteListButtonShow()) {
                    this.A.setVisibility(!z2 ? 0 : 8);
                }
                if (this.T.isTrafficBarEnabled() && this.V.getEngineType() == 0) {
                    TrafficProgressBar trafficProgressBar = this.p;
                    if (z2) {
                        i2 = 0;
                    }
                    trafficProgressBar.setVisibility(i2);
                }
                this.ap.requestLayout();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "setCarLock(boolean isLock, boolean autoRestore)");
        }
    }

    public void onClick(View view) {
        try {
            if (2131296295 == view.getId()) {
                recoverLockMode();
                e(false);
            }
            if (2131296298 == view.getId()) {
                this.Y.sendEmptyMessage(1);
            }
            if (2131296288 == view.getId() && this.ac != null && !this.ac.onNaviBackClick()) {
                this.Y.sendEmptyMessage(2);
            }
            if (2131296275 == view.getId() && this.ac != null) {
                this.ac.onNaviTurnClick();
            }
            if (this.q.equals(view)) {
                l();
            }
            if (this.n.equals(view) && this.ac != null) {
                this.ac.onNextRoadClick();
            }
            if (this.c.equals(view)) {
                this.ab++;
                if (this.ab > 2) {
                    this.ab = 0;
                    if (this.W != null) {
                        this.W.c();
                    }
                }
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onClick(View v)");
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        try {
            this.X.animateCamera(CameraUpdateFactory.changeBearing(0.0f));
            this.Y.sendEmptyMessage(4);
            this.Y.removeMessages(0);
            this.Y.sendEmptyMessageDelayed(0, this.Z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isTrafficLine() {
        if (this.X != null) {
            return this.X.isTrafficEnabled();
        }
        return false;
    }

    public void setTrafficLine(boolean z2) {
        try {
            this.X.setTrafficEnabled(z2);
            if (this.Y != null) {
                this.Y.obtainMessage(8, Boolean.valueOf(z2)).sendToTarget();
            }
            if (this.W != null) {
                this.W.d(z2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAMapNaviViewListener(AMapNaviViewListener aMapNaviViewListener) {
        if (aMapNaviViewListener != null) {
            this.ac = aMapNaviViewListener;
        }
    }

    public final void d() {
        try {
            this.J = true;
            this.l.setVisibility(0);
            this.g.setVisibility(8);
            this.x.setVisibility(8);
            this.z.setVisibility(8);
            this.h.setVisibility(8);
            this.p.setVisibility(8);
            this.r.setVisibility(8);
            this.e.setVisibility(8);
            this.A.setVisibility(8);
            this.f.setVisibility(8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        try {
            this.l.setVisibility(8);
            this.x.setVisibility(0);
            this.z.setVisibility(0);
            this.g.setVisibility(8);
            this.e.setVisibility(0);
            this.h.setVisibility(0);
            this.r.setVisibility(0);
            this.ao.setVisibility(8);
            this.A.setVisibility(8);
            c(this.G);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean isShowRoadEnlarge() {
        return this.L;
    }

    public boolean isOrientationLandscape() {
        return this.G;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b A[Catch:{ Throwable -> 0x0040 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void layout(boolean r1, int r2, int r3, int r4, int r5) {
        /*
            r0 = this;
            int r1 = r0.H     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.maps.MapView r2 = r0.U     // Catch:{ Throwable -> 0x0040 }
            int r2 = r2.getHeight()     // Catch:{ Throwable -> 0x0040 }
            r3 = 0
            if (r1 != r2) goto L_0x0018
            int r1 = r0.I     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.maps.MapView r2 = r0.U     // Catch:{ Throwable -> 0x0040 }
            int r2 = r2.getWidth()     // Catch:{ Throwable -> 0x0040 }
            if (r1 == r2) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = r3
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            if (r1 == 0) goto L_0x003f
            r0.m()     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.navi.view.DriveWayView r1 = r0.B     // Catch:{ Throwable -> 0x0040 }
            if (r1 == 0) goto L_0x003f
            com.amap.api.navi.view.DriveWayView r1 = r0.B     // Catch:{ Throwable -> 0x0040 }
            android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()     // Catch:{ Throwable -> 0x0040 }
            android.widget.RelativeLayout$LayoutParams r1 = (android.widget.RelativeLayout.LayoutParams) r1     // Catch:{ Throwable -> 0x0040 }
            android.widget.TextView r2 = r0.e     // Catch:{ Throwable -> 0x0040 }
            int r2 = r2.getHeight()     // Catch:{ Throwable -> 0x0040 }
            int r2 = r2 + 10
            r1.setMargins(r3, r2, r3, r3)     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.navi.view.DriveWayView r2 = r0.B     // Catch:{ Throwable -> 0x0040 }
            r2.setLayoutParams(r1)     // Catch:{ Throwable -> 0x0040 }
            com.amap.api.navi.view.DriveWayView r1 = r0.B     // Catch:{ Throwable -> 0x0040 }
            r1.invalidate()     // Catch:{ Throwable -> 0x0040 }
        L_0x003f:
            return
        L_0x0040:
            r1 = move-exception
            r1.printStackTrace()
            java.lang.String r2 = "AMapNaviView"
            java.lang.String r3 = "onLayout(boolean changed, int left, int top, int right,\n                            int bottom)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.eu.layout(boolean, int, int, int, int):void");
    }

    private void m() {
        try {
            this.H = this.U.getHeight();
            this.I = this.U.getWidth();
            if (!(this.H == 0 || this.I == 0)) {
                this.X.setPointToCenter((int) (((double) this.I) * this.P), (int) (((double) this.H) * this.Q));
            }
            this.W.g();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(int i2) {
        try {
            if (this.K || i2 == 0) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, a(i2));
                this.U.setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(int i2) {
        try {
            boolean z2 = this.K;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.U.getLayoutParams();
            layoutParams.setMargins(a(i2), a(0), a(0), a(0));
            this.U.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void d(int i2) {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.k.getLayoutParams();
            layoutParams.setMargins(a(0), a(0), a(10), a(i2));
            this.k.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        this.O = z2;
        if (this.A != null) {
            this.A.setChecked(z2);
        }
    }

    public DriveWayView getLazyDriveWayView() {
        return this.ah;
    }

    public void setLazyDriveWayView(DriveWayView driveWayView) {
        if (driveWayView != null) {
            this.ah = driveWayView;
        }
    }

    public ZoomInIntersectionView getLazyZoomInIntersectionView() {
        return this.ai;
    }

    public void setLazyZoomInIntersectionView(ZoomInIntersectionView zoomInIntersectionView) {
        if (zoomInIntersectionView != null) {
            this.ai = zoomInIntersectionView;
        }
    }

    public TrafficBarView getLazyTrafficBarView() {
        return this.aj;
    }

    public void setLazyTrafficBarView(TrafficBarView trafficBarView) {
        if (trafficBarView != null) {
            this.aj = trafficBarView;
        }
    }

    public final TrafficProgressBar f() {
        return this.ak;
    }

    public DirectionView getLazyDirectionView() {
        return this.al;
    }

    public void setLazyDirectionView(DirectionView directionView) {
        if (directionView != null) {
            this.al = directionView;
            this.al.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    eu.this.l();
                }
            });
        }
    }

    public TrafficButtonView getLazyTrafficButtonView() {
        return this.am;
    }

    public void setLazyTrafficButtonView(TrafficButtonView trafficButtonView) {
        if (trafficButtonView != null) {
            this.am = trafficButtonView;
            this.am.setOnClickListener(this.au);
        }
    }

    public NextTurnTipView getLazyNextTurnTipView() {
        return this.an;
    }

    public void setLazyNextTurnTipView(NextTurnTipView nextTurnTipView) {
        if (nextTurnTipView != null) {
            this.an = nextTurnTipView;
        }
    }

    public void zoomIn() {
        try {
            a(false);
            this.X.animateCamera(CameraUpdateFactory.zoomIn());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void zoomOut() {
        try {
            a(false);
            this.X.animateCamera(CameraUpdateFactory.zoomOut());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setLazyZoomButtonView(ZoomButtonView zoomButtonView) {
        if (zoomButtonView != null) {
            this.as = zoomButtonView;
            if (this.as != null) {
                this.as.getZoomInBtn().setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (eu.this.ap != null) {
                            eu.this.ap.zoomIn();
                        }
                    }
                });
                this.as.getZoomOutBtn().setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        if (eu.this.ap != null) {
                            eu.this.ap.zoomOut();
                        }
                    }
                });
            }
        }
    }

    public void setLazyOverviewButtonView(OverviewButtonView overviewButtonView) {
        if (overviewButtonView != null) {
            this.at = overviewButtonView;
            if (this.at != null) {
                this.at.setChecked(isRouteOverviewNow());
                this.at.setOnClickListener(this.av);
            }
        }
    }

    public boolean isRouteOverviewNow() {
        return this.O;
    }

    private void e(boolean z2) {
        try {
            "threadName=" + Thread.currentThread().getName() + ",checkCrossView=" + z2;
            if (z2) {
                this.ax = true;
                this.r.setVisibility(8);
                this.q.setVisibility(8);
                if (this.ay) {
                    if (this.G) {
                        Rect landscapeCross = this.T.getLandscapeCross();
                        if (landscapeCross == null) {
                            landscapeCross = new Rect(0, a(48), (int) (((double) this.E) * 0.4d), this.F);
                        }
                        this.P = ((double) (((this.U.getWidth() - landscapeCross.right) / 2) + landscapeCross.right)) / ((double) this.U.getWidth());
                    } else {
                        this.P = this.T.getMapCenter_X();
                    }
                }
            } else {
                this.ax = false;
                this.q.setVisibility(0);
                this.r.setVisibility(0);
                this.P = this.T.getMapCenter_X();
                this.Q = this.T.getMapCenter_Y();
            }
            m();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean g() {
        return this.ax;
    }
}
