package com.amap.api.col.n3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviViewOptions;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.AmapRouteActivity;
import com.amap.api.navi.INavi;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.LBSNaviView;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.navi.view.TmcBarView;
import com.amap.api.navi.view.ZoomInIntersectionView;
import com.android.hoinnet.highde.R;
import com.autonavi.ae.gmap.gloverlay.GLCrossVector;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.ae.pos.LocManager;
import com.autonavi.ae.pos.LocObjectId;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Calendar;

/* compiled from: LBSNaviViewCore */
public final class fq implements View.OnClickListener, gb, AMap.OnCameraChangeListener, AMap.OnMapLoadedListener, AMap.OnMapTouchListener {
    private static int J = 500;
    int A = 480;
    int B = GLMapStaticValue.ANIMATION_FLUENT_TIME;
    boolean C = false;
    int D = 0;
    int E = 0;
    boolean F = false;
    boolean G = false;
    LBSNaviView H;
    public hi I;
    /* access modifiers changed from: private */
    public boolean K = false;
    private double L = 0.0d;
    private double M = 0.0d;
    private int N = 17;
    private int O = 35;
    private AMapNaviViewOptions P = null;
    private TextureMapView Q;
    /* access modifiers changed from: private */
    public INavi R;
    /* access modifiers changed from: private */
    public fp S;
    private AMap T;
    /* access modifiers changed from: private */
    public a U;
    private long V = 5000;
    private boolean W = false;
    private int X = 0;
    private ImageButton Y;
    private ImageButton Z;
    RelativeLayout a;
    private View.OnClickListener aa = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (fq.this.K) {
                    fq.this.s();
                    return;
                }
                fq.this.d(true);
                fq.this.a(false);
                if (fq.this.C) {
                    fq.this.S.a(fq.this.I.getWidth() + fq.this.e(50), fq.this.e(20), fq.this.e(40), fq.this.e(30));
                } else {
                    fq.this.S.a(fq.this.e(65), fq.this.e(65), fq.this.I.getHeight() + fq.this.e(50), fq.this.e(120));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public Context ab;
    private View.OnClickListener ac = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                fq.d(fq.this);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private CrossOverlay ad;
    private boolean ae = false;
    private boolean af = false;
    private AMapModelCross ag;
    private hj ah;
    private hj ai;
    private int aj = 540;
    private int ak = 220;
    private int al = 360;
    private int am = 120;
    private boolean an = false;
    /* access modifiers changed from: private */
    public AmapRouteActivity ao;
    private int ap;
    private long aq;
    private boolean ar = true;
    /* access modifiers changed from: private */
    public int as = 2;
    private float at = 0.0f;
    private Dialog au;
    /* access modifiers changed from: private */
    public ho av;
    /* access modifiers changed from: private */
    public boolean aw = true;
    /* access modifiers changed from: private */
    public Handler ax = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 1:
                        ho.c();
                        if (ho.b() == 0) {
                            fq.this.ax.removeCallbacksAndMessages((Object) null);
                            fq.this.av.dismiss();
                        }
                        if (fq.this.aw) {
                            Message message2 = new Message();
                            message2.what = 1;
                            fq.this.ax.sendMessageDelayed(message2, 1000);
                            return;
                        }
                        return;
                    case 2:
                        ho.a();
                        boolean unused = fq.this.aw = false;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private int ay = 0;
    RelativeLayout b;
    TextView c;
    RelativeLayout d;
    TmcBarView e;
    ImageView f;
    ImageButton g;
    ZoomInIntersectionView h;
    View i = null;
    FrameLayout j;
    FrameLayout k;
    RelativeLayout l;
    LinearLayout m;
    TextView n;
    TextView o;
    TextView p;
    TextView q;
    ImageButton r;
    ImageButton s;
    TextView t;
    ImageButton u;
    ImageButton v;
    ImageButton w;
    RelativeLayout x;
    RelativeLayout y;
    ImageButton z;

    /* compiled from: LBSNaviViewCore */
    static class a extends Handler {
        private WeakReference<fq> a;

        a(fq fqVar) {
            try {
                this.a = new WeakReference<>(fqVar);
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "AMapNaviView", "MapViewListenerTriggerHandler()");
            }
        }

        public final void handleMessage(Message message) {
            fq fqVar = (fq) this.a.get();
            if (fqVar != null) {
                try {
                    int i = message.what;
                    if (i == 0) {
                        fqVar.a(true);
                    } else if (i == 2) {
                        fq.o(fqVar);
                    } else if (i == 4) {
                        fqVar.a(false);
                    }
                } catch (Throwable th) {
                    hq.a(th);
                    iu.b(th, "AMapNaviView", "MapViewListenerTriggerHandler.handleMessage(android.os.Message msg) ");
                }
            }
        }
    }

    static /* synthetic */ void c(fq fqVar, int i2) {
        if (i2 != fqVar.ap) {
            fqVar.f(i2);
        }
    }

    static /* synthetic */ void d(fq fqVar) {
        AMap aMap;
        boolean z2;
        if (fqVar.T.isTrafficEnabled()) {
            fqVar.s.setBackgroundDrawable(hs.a().getDrawable(2130837567));
            aMap = fqVar.T;
            z2 = false;
        } else {
            fqVar.s.setBackgroundDrawable(hs.a().getDrawable(2130837568));
            aMap = fqVar.T;
            z2 = true;
        }
        aMap.setTrafficEnabled(z2);
    }

    static /* synthetic */ void h(fq fqVar) {
        ImageButton imageButton;
        Resources a2;
        int i2;
        if (fqVar.X == 0) {
            fqVar.U.removeMessages(0);
            fqVar.c(1);
            imageButton = fqVar.r;
            a2 = hs.a();
            i2 = 2130837561;
        } else {
            fqVar.U.removeMessages(0);
            fqVar.c(0);
            imageButton = fqVar.r;
            a2 = hs.a();
            i2 = 2130837560;
        }
        imageButton.setBackgroundDrawable(a2.getDrawable(i2));
    }

    static /* synthetic */ void o(fq fqVar) {
        try {
            new AlertDialog.Builder(fqVar.ab).setTitle("提示").setMessage("确定退出导航?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    try {
                        dialogInterface.cancel();
                        fq.this.R.stopNavi();
                        fq.this.U.sendEmptyMessage(3);
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
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "showDialog()");
        }
    }

    public fq(LBSNaviView lBSNaviView, AMapNaviViewOptions aMapNaviViewOptions) {
        this.P = aMapNaviViewOptions;
        this.H = lBSNaviView;
        this.ab = lBSNaviView.getContext();
    }

    public final double a() {
        return this.L;
    }

    public final double b() {
        return this.M;
    }

    public final int c() {
        return this.N;
    }

    public final void a(int i2) {
        if (i2 != this.N) {
            this.P.setZoom(i2);
            a(this.P);
        }
    }

    public final int d() {
        return this.O;
    }

    public final void b(int i2) {
        if (i2 != this.O) {
            this.P.setTilt(i2);
            a(this.P);
        }
    }

    public final int e() {
        return this.X;
    }

    public final void c(int i2) {
        if ((i2 == 1 || i2 == 0) && i2 != this.X) {
            this.X = i2;
            a(false);
            if (i2 == 1) {
                if (this.S != null) {
                    this.S.d();
                }
            } else if (i2 == 0) {
                this.S.e();
            }
        }
    }

    public final boolean f() {
        return this.W;
    }

    public final AMapNaviViewOptions g() {
        return this.P;
    }

    public final void a(AMapNaviViewOptions aMapNaviViewOptions) {
        this.P = aMapNaviViewOptions;
        k();
    }

    public final AMap h() {
        return this.T;
    }

    public final void a(AmapRouteActivity amapRouteActivity) {
        try {
            this.ao = amapRouteActivity;
            if (this.P == null) {
                this.P = new AMapNaviViewOptions();
            }
            this.R = AMapNavi.getInstance(this.ab);
            if (this.ab != null) {
                this.ap = this.R.strategyConvert(hf.a(this.ab, "NAVI_STRATEGY_TAB1"), hf.a(this.ab, "NAVI_STRATEGY_TAB2"), hf.a(this.ab, "NAVI_STRATEGY_TAB3"), hf.a(this.ab, "NAVI_STRATEGY_TAB4"), true);
            }
            this.aj = e(180);
            this.ak = e(74);
            this.al = e(120);
            this.am = e(40);
            hs.a(this.ab.getApplicationContext());
            this.i = hs.a(this.ab, R.attr.actionButtonStyle, (ViewGroup) null);
            this.H.addView(this.i);
            this.Q = (TextureMapView) this.i.findViewById(2131296271);
            this.C = G();
            if (this.S == null) {
                this.S = new fp(this.ab, this.Q, this);
            }
            this.z = (ImageButton) this.i.findViewById(2131296351);
            this.z.setOnClickListener(this);
            this.a = (RelativeLayout) this.i.findViewById(2131296335);
            this.b = (RelativeLayout) this.i.findViewById(2131296336);
            this.c = (TextView) this.i.findViewById(2131296342);
            this.d = (RelativeLayout) this.i.findViewById(2131296347);
            this.e = (TmcBarView) this.i.findViewById(2131296348);
            this.f = (ImageView) this.i.findViewById(2131296349);
            this.g = (ImageButton) this.i.findViewById(2131296345);
            this.g.setOnClickListener(this);
            this.h = (ZoomInIntersectionView) this.H.findViewById(2131296281);
            this.r = (ImageButton) this.i.findViewById(2131296344);
            this.r.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        fq.h(fq.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            this.x = (RelativeLayout) this.i.findViewById(2131296270);
            this.y = (RelativeLayout) this.i.findViewById(2131296341);
            if (this.ah == null) {
                this.ah = new hj(this.ab);
                this.ah.setVisibility(8);
                this.H.addView(this.ah);
            }
            if (this.ai == null) {
                this.ai = new hj(this.ab);
                this.ai.setVisibility(8);
                this.y.addView(this.ai);
            }
            this.t = (TextView) this.i.findViewById(2131296340);
            this.j = (FrameLayout) this.i.findViewById(2131296295);
            this.k = (FrameLayout) this.i.findViewById(2131296290);
            this.v = (ImageButton) this.i.findViewById(2131296337);
            this.u = (ImageButton) this.i.findViewById(2131296288);
            this.m = (LinearLayout) this.i.findViewById(2131296287);
            this.n = (TextView) this.i.findViewById(2131296339);
            this.n.setOnClickListener(this);
            this.o = (TextView) this.i.findViewById(2131296296);
            this.p = (TextView) this.i.findViewById(2131296343);
            this.q = (TextView) this.i.findViewById(2131296338);
            this.s = (ImageButton) this.i.findViewById(2131296346);
            this.s.setOnClickListener(this.ac);
            this.w = (ImageButton) this.i.findViewById(2131296350);
            this.w.setOnClickListener(this.aa);
            this.l = (RelativeLayout) this.i.findViewById(2131296282);
            this.Y = (ImageButton) this.i.findViewById(2131296312);
            this.Z = (ImageButton) this.i.findViewById(2131296313);
            this.Y.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        fq.this.y();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.Z.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        fq.this.z();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "init()");
            return;
        }
        this.U = new a(this);
    }

    private void F() {
        if (this.af) {
            I();
            b(this.ag);
        }
        if (G()) {
            if (this.I != null) {
                this.I.b();
                this.H.removeView(this.I);
                this.I = null;
            }
            this.I = new hl(this.ab, (byte) 0);
            if (Build.VERSION.SDK_INT >= 17) {
                this.I.setId(View.generateViewId());
            } else {
                this.I.setId(1234);
            }
            if (this.R.getNaviType() == 2) {
                this.I.b(true);
                this.I.a(this.as);
                this.q.setVisibility(8);
                this.I.c(false);
            } else {
                this.I.c(true);
                this.q.setVisibility(0);
            }
            this.p.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.aj, -1);
            this.I.setLayoutParams(layoutParams);
            this.I.a().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        if (fq.this.R.getNaviType() == 2) {
                            switch (fq.this.as) {
                                case 1:
                                    fq.this.R.setEmulatorNaviSpeed(80);
                                    int unused = fq.this.as = 2;
                                    break;
                                case 2:
                                    fq.this.R.setEmulatorNaviSpeed(120);
                                    int unused2 = fq.this.as = 3;
                                    break;
                                case 3:
                                    fq.this.R.setEmulatorNaviSpeed(40);
                                    int unused3 = fq.this.as = 1;
                                    break;
                            }
                            fq.this.I.a(fq.this.as);
                            return;
                        }
                        fq.this.U.sendEmptyMessage(0);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.H.addView(this.I);
            if (!(this.S == null || this.S.c() == null)) {
                this.I.a(this.S.c());
            }
            if (this.T != null) {
                this.T.getUiSettings().setLogoBottomMargin(e(5));
                this.T.getUiSettings().setLogoLeftMargin(this.aj + e(65));
            }
            this.L = 0.65d;
            this.a.setLayoutParams(layoutParams);
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.A / 2, -1);
            layoutParams2.addRule(3, this.a.getId());
            this.h.setLayoutParams(layoutParams2);
            this.ai.setVisibility(0);
            this.ah.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = e(7);
            layoutParams3.addRule(14);
            this.ai.setLayoutParams(layoutParams3);
            this.m.setVisibility(8);
            this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        } else {
            if (this.I != null) {
                this.I.b();
                this.H.removeView(this.I);
                this.I = null;
            }
            this.I = new hm(this.ab, (byte) 0);
            if (Build.VERSION.SDK_INT >= 17) {
                this.I.setId(View.generateViewId());
            } else {
                this.I.setId(12345);
            }
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, this.al);
            layoutParams4.addRule(10);
            this.I.setLayoutParams(layoutParams4);
            this.H.addView(this.I);
            if (!(this.S == null || this.S.c() == null)) {
                this.I.a(this.S.c());
            }
            if (this.T != null) {
                this.T.getUiSettings().setLogoBottomMargin(e(45));
                this.T.getUiSettings().setLogoLeftMargin(5);
            }
            if (this.R.getNaviType() == 2) {
                switch (this.as) {
                    case 1:
                        this.n.setText("低速");
                        break;
                    case 2:
                        this.n.setText("中速");
                        break;
                    case 3:
                        this.n.setText("高速");
                        break;
                }
                this.p.setVisibility(8);
                this.I.c(false);
            } else {
                this.I.c(true);
                this.p.setVisibility(0);
            }
            this.q.setVisibility(8);
            this.L = 0.5d;
            this.b.setLayoutParams(layoutParams4);
            this.b.setVisibility(0);
            this.a.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, J);
            layoutParams5.addRule(3, this.b.getId());
            this.h.setLayoutParams(layoutParams5);
            this.ai.setVisibility(8);
            this.ah.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, e(50));
            layoutParams6.addRule(3, this.I.getId());
            this.ah.setLayoutParams(layoutParams6);
            this.m.setVisibility(0);
            this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        }
        this.I.setBackgroundColor(Color.parseColor("#282c37"));
        if (this.av != null && this.av.isShowing()) {
            if (this.C) {
                this.av.setHeight(this.B - e(50));
                this.av.update(0, 0, -1, this.B - e(50));
            } else {
                this.av.setHeight(this.B - this.al);
                this.av.update(0, 0, -1, (this.B - this.al) - e(20));
            }
        }
        if (this.ae) {
            e(true);
        }
        if (this.F) {
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.s.setVisibility(8);
            this.q.setVisibility(8);
            this.p.setVisibility(8);
            this.c.setText("0");
            this.v.setEnabled(false);
        }
        J();
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        this.ai.a(bArr, bArr2);
        this.ah.a(bArr, bArr2);
        if (G()) {
            this.ai.setVisibility(0);
        } else {
            this.ah.setVisibility(0);
        }
    }

    public final void i() {
        this.ah.setVisibility(8);
        this.ai.setVisibility(8);
    }

    private boolean G() {
        if (this.ao == null) {
            return false;
        }
        "isLandscape--->" + this.ao.getRequestedOrientation() + "," + this.ao.getResources().getConfiguration().orientation;
        if (this.ao.getRequestedOrientation() == 0 || this.ao.getResources().getConfiguration().orientation == 2) {
            return true;
        }
        return false;
    }

    private void H() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.ab.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.A = displayMetrics.widthPixels;
        this.B = displayMetrics.heightPixels;
    }

    public final void j() {
        try {
            H();
            this.C = G();
            boolean z2 = this.C;
            F();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onConfigurationChanged(Configuration newConfig)");
        }
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        try {
            this.L = this.P.getMapCenter_X();
            this.M = this.P.getMapCenter_Y();
            this.V = this.P.getLockMapDelayed();
            this.W = this.P.isAutoChangeZoom();
            if (TextUtils.isEmpty(this.P.getCustomMapStylePath())) {
                this.T.setMapCustomEnable(false);
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(System.currentTimeMillis());
                int i2 = instance.get(11);
                if ((i2 < 18 || i2 >= 24) && (i2 < 0 || i2 >= 6)) {
                    this.T.setMapType(4);
                } else {
                    this.T.setMapType(3);
                }
            } else {
                this.T.setMapCustomEnable(true);
                this.T.setCustomMapStylePath(this.P.getCustomMapStylePath());
            }
            this.S.d(this.P.isSensorEnable());
            this.S.g();
            this.S.a(this.P.isAutoDrawRoute());
            this.S.b(this.P.isLaneInfoShow());
            this.S.e(this.P.isCameraBubbleShow());
            this.R.getNaviSetting().setScreenAlwaysBright(this.P.isScreenAlwaysBright());
            this.R.getNaviSetting().setTrafficInfoUpdateEnabled(this.P.isTrafficInfoUpdateEnabled());
            this.R.getNaviSetting().setCameraInfoUpdateEnabled(this.P.isCameraInfoUpdateEnabled());
            this.R.setReCalculateRouteForYaw(this.P.isReCalculateRouteForYaw());
            this.R.setReCalculateRouteForTrafficJam(this.P.isReCalculateRouteForTrafficJam());
            this.T.moveCamera(CameraUpdateFactory.zoomTo((float) this.N));
            this.T.moveCamera(CameraUpdateFactory.changeTilt((float) this.O));
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "checkViewOptions()");
        }
    }

    /* access modifiers changed from: private */
    public int e(int i2) {
        Context context = this.ab;
        if (i2 == 0) {
            return 0;
        }
        if (context == null) {
            return i2;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        } catch (Exception e2) {
            e2.printStackTrace();
            iu.b((Throwable) e2, "AMapNaviView", "dp2px(int dipValue)");
            return i2;
        }
    }

    public final void a(Bundle bundle) {
        try {
            this.Q.onCreate(bundle);
            this.T = this.Q.getMap();
            MyTrafficStyle myTrafficStyle = new MyTrafficStyle();
            myTrafficStyle.setRatio(0.7f);
            myTrafficStyle.setSmoothColor(Color.parseColor("#CC80CD65"));
            myTrafficStyle.setCongestedColor(Color.parseColor("#F2CB7257"));
            myTrafficStyle.setSlowColor(Color.parseColor("#F2D5C247"));
            myTrafficStyle.setSeriousCongestedColor(Color.parseColor("#CCA52A2A"));
            this.T.setMyTrafficStyle(myTrafficStyle);
            this.T.getUiSettings().setZoomControlsEnabled(false);
            this.T.getUiSettings().setGestureScaleByMapCenter(true);
            this.T.getUiSettings().setScaleControlsEnabled(true);
            this.T.setTrafficEnabled(false);
            k();
            this.T.setOnMapLoadedListener(this);
            this.T.setOnCameraChangeListener(this);
            this.T.setOnMapTouchListener(this);
            this.R.addAMapNaviListener(this.S);
            this.j.setOnClickListener(this);
            this.v.setOnClickListener(this);
            this.u.setOnClickListener(this);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onCreate(Bundle bundle)");
            return;
        }
        H();
        F();
    }

    public final void l() {
        try {
            this.Q.onResume();
            H();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onResume()");
        }
    }

    public final void m() {
        try {
            this.Q.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onPause()");
        }
    }

    public final void n() {
        try {
            this.e = null;
            if (this.h != null) {
                this.h.recycleResource();
            }
            if (this.I != null) {
                this.I.b();
                this.I = null;
            }
            if (this.ad != null) {
                this.ad.remove();
            }
            this.ab = null;
            if (this.S != null) {
                this.S.f();
            }
            this.R.removeAMapNaviListener(this.S);
            this.Q.onDestroy();
            hs.b();
            if (this.h != null) {
                this.h.setVisibility(8);
                this.h.recycleResource();
            }
            if (this.I != null) {
                this.I.b();
            }
            if (this.U != null) {
                this.U.removeCallbacksAndMessages((Object) null);
            }
            if (this.av != null) {
                this.av.e();
                this.av = null;
            }
            if (this.H != null) {
                this.H.removeAllViews();
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onDestroy()");
        }
    }

    public final void b(Bundle bundle) {
        try {
            this.Q.onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapNaviView", "onSaveInstanceState(android.os.Bundle paramBundle)");
        }
    }

    public final void onMapLoaded() {
        try {
            this.D = this.Q.getHeight();
            this.E = this.Q.getWidth();
            H();
            J = (this.B / 10) * 4;
            if (!(this.D == 0 || this.E == 0)) {
                this.T.setPointToCenter((int) (((double) this.E) * this.L), (int) (((double) this.D) * this.M));
            }
            this.S.a();
            this.S.a(this.R.getNaviPath());
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onMapLoaded() ");
        }
    }

    public final void onCameraChange(CameraPosition cameraPosition) {
        try {
            if (!(cameraPosition.zoom == this.at || this.S == null)) {
                this.S.a(cameraPosition);
            }
            this.at = cameraPosition.zoom;
            if (!this.ae) {
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onCameraChange(CameraPosition arg0)");
        }
    }

    public final void onCameraChangeFinish(CameraPosition cameraPosition) {
        if (this.T != null) {
            if (this.T.getCameraPosition().zoom >= this.T.getMaxZoomLevel()) {
                this.Y.setEnabled(false);
                this.Y.setBackgroundResource(2130837570);
            } else {
                this.Y.setEnabled(true);
                this.Y.setBackgroundResource(2130837569);
            }
            if (this.T.getCameraPosition().zoom <= this.T.getMinZoomLevel()) {
                this.Z.setEnabled(false);
                this.Z.setBackgroundResource(2130837572);
                return;
            }
            this.Z.setEnabled(true);
            this.Z.setBackgroundResource(2130837571);
        }
    }

    public final void o() {
        d(true);
        a(false);
        if (this.C) {
            this.S.a(this.I.getWidth() + e(50), e(20), e(10), e(10));
        } else {
            this.S.a(e(65), e(65), this.I.getHeight() + e(50), e(50));
        }
    }

    public final void p() {
        this.X = 1;
        a(true);
        this.S.d();
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapNaviCross aMapNaviCross) {
        this.G = true;
        e(true);
        this.h.setVisibility(0);
        this.h.setIntersectionBitMap(aMapNaviCross);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ah.getLayoutParams();
        layoutParams.height = this.h.getHeight();
        this.ah.setLayoutParams(layoutParams);
        this.H.requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        if (this.h.getVisibility() == 0) {
            this.G = false;
            this.h.setVisibility(8);
            this.h.recycleResource();
            this.H.requestLayout();
            e(false);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ah.getLayoutParams();
            layoutParams.height = e(50);
            this.ah.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(AMapModelCross aMapModelCross) {
        b(aMapModelCross);
        e(true);
    }

    private void b(AMapModelCross aMapModelCross) {
        if (aMapModelCross != null) {
            try {
                GLCrossVector.AVectorCrossAttr aVectorCrossAttr = new GLCrossVector.AVectorCrossAttr();
                aVectorCrossAttr.nCenterX = 0;
                aVectorCrossAttr.nCenterY = 0;
                aVectorCrossAttr.stRectMax = new Rect();
                aVectorCrossAttr.stRectMin = new Rect();
                aVectorCrossAttr.nAngle = 0;
                if (G()) {
                    aVectorCrossAttr.stAreaRect = new Rect(0, this.ak, (int) (((double) this.A) * 0.5d), this.B);
                } else {
                    aVectorCrossAttr.stAreaRect = new Rect(0, this.am, this.A, (this.B / 2) - this.am);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ah.getLayoutParams();
                    layoutParams.height = ((this.B / 2) - this.am) - this.am;
                    this.ah.setLayoutParams(layoutParams);
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
                if (this.P.isNaviNight()) {
                    aVectorCrossAttr.dayMode = false;
                } else {
                    aVectorCrossAttr.dayMode = true;
                }
                InputStream open = this.ao.getResources().getAssets().open("vector3d_arrow_in.png");
                this.ad = this.T.addCrossOverlay(new CrossOverlayOptions().setAttribute(aVectorCrossAttr).setRes(BitmapFactory.decodeStream(open)));
                this.ad.setData(aMapModelCross.getPicBuf1());
                open.close();
                this.ag = aMapModelCross;
                this.af = true;
            } catch (Throwable th) {
                th.printStackTrace();
                this.af = false;
            }
        }
    }

    private void I() {
        if (this.af && this.ad != null) {
            this.ad.remove();
            this.af = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void r() {
        I();
        this.I.setVisibility(0);
        e(false);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ah.getLayoutParams();
        layoutParams.height = e(50);
        this.ah.setLayoutParams(layoutParams);
    }

    public final void s() {
        a(true);
    }

    public final void onTouch(MotionEvent motionEvent) {
        try {
            q();
            r();
            this.I.b(true);
            this.r.setVisibility(0);
            this.U.sendEmptyMessage(4);
            this.U.removeMessages(0);
            this.U.sendEmptyMessageDelayed(0, this.V);
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onTouch(MotionEvent arg0)");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        if (z2) {
            try {
                if (this.R.getNaviType() == 1) {
                    this.c.setVisibility(0);
                }
                this.r.setVisibility(8);
                this.l.setVisibility(8);
                this.d.setVisibility(0);
                this.s.setVisibility(8);
                this.g.setVisibility(8);
            } catch (Throwable th) {
                hq.a(th);
                iu.b(th, "AMapNaviView", "setCarLock(boolean isLock, boolean autoRestore)");
            }
        } else {
            this.c.setVisibility(8);
            this.l.setVisibility(0);
            this.d.setVisibility(8);
            this.s.setVisibility(0);
            if (this.R.getNaviType() == 1) {
                this.g.setVisibility(0);
            }
        }
        this.j.setVisibility(z2 ? 8 : 0);
        this.k.setVisibility(z2 ? 0 : 8);
        if (this.C) {
            if (z2) {
                this.I.b(false);
            }
        } else if (z2) {
            this.T.getUiSettings().setLogoLeftMargin(5);
        } else {
            this.T.getUiSettings().setLogoLeftMargin(e(65));
        }
        if (this.F) {
            this.g.setVisibility(8);
            this.c.setVisibility(8);
        }
        this.an = z2;
        this.U.removeMessages(0);
        if (z2) {
            d(false);
        } else {
            this.U.sendEmptyMessageDelayed(0, this.V);
        }
        this.S.c(z2);
        d(this.ay);
        this.H.requestLayout();
    }

    public final void onClick(View view) {
        ho hoVar;
        int height;
        int e2;
        try {
            switch (view.getId()) {
                case 2131296288:
                    if (this.R.getNaviType() == 2) {
                        this.R.stopNavi();
                        Bundle bundle = new Bundle();
                        bundle.putInt("from", 2);
                        this.ao.closeScr(bundle);
                        return;
                    }
                    if (this.au == null) {
                        Dialog dialog = new Dialog(this.ao);
                        dialog.requestWindowFeature(1);
                        dialog.getWindow().setBackgroundDrawableResource(17170445);
                        View a2 = hs.a(this.ao, R.attr.actionBarTheme, (ViewGroup) null);
                        ((TextView) a2.findViewById(2131296327)).setOnClickListener(this);
                        ((TextView) a2.findViewById(2131296328)).setOnClickListener(this);
                        dialog.setContentView(a2);
                        dialog.setCancelable(true);
                        this.au = dialog;
                    }
                    this.au.show();
                    return;
                case 2131296295:
                    this.r.setVisibility(8);
                    a(true);
                    e(false);
                    return;
                case 2131296327:
                    if (this.au != null) {
                        this.au.dismiss();
                        return;
                    }
                    return;
                case 2131296328:
                    if (this.au != null) {
                        this.au.dismiss();
                    }
                    this.R.stopNavi();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("from", 2);
                    this.ao.closeScr(bundle2);
                    return;
                case 2131296337:
                    if (this.R.getNaviType() != 2) {
                        if (this.av == null) {
                            this.av = new ho(this.ab);
                            this.av.a(true);
                        }
                        if (this.C) {
                            hoVar = this.av;
                            height = this.B;
                            e2 = e(50);
                        } else {
                            if (this.I != null) {
                                hoVar = this.av;
                                height = this.B - this.I.getHeight();
                                e2 = e(20);
                            }
                            this.av.d();
                            this.av.showAtLocation(this.H, 81, 0, 0);
                            final WindowManager.LayoutParams attributes = this.ao.getWindow().getAttributes();
                            attributes.alpha = 0.7f;
                            this.ao.getWindow().setAttributes(attributes);
                            this.av.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                public final void onDismiss() {
                                    fq.this.ax.obtainMessage(2).sendToTarget();
                                    attributes.alpha = 1.0f;
                                    fq.this.ao.getWindow().setAttributes(attributes);
                                    fq.c(fq.this, fq.this.R.strategyConvert(hf.a(fq.this.ab, "NAVI_STRATEGY_TAB1"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB2"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB3"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB4"), true));
                                }
                            });
                            this.aw = true;
                            this.ax.obtainMessage(1).sendToTarget();
                            return;
                        }
                        hoVar.setHeight(height - e2);
                        this.av.d();
                        this.av.showAtLocation(this.H, 81, 0, 0);
                        final WindowManager.LayoutParams attributes2 = this.ao.getWindow().getAttributes();
                        attributes2.alpha = 0.7f;
                        this.ao.getWindow().setAttributes(attributes2);
                        this.av.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            public final void onDismiss() {
                                fq.this.ax.obtainMessage(2).sendToTarget();
                                attributes2.alpha = 1.0f;
                                fq.this.ao.getWindow().setAttributes(attributes2);
                                fq.c(fq.this, fq.this.R.strategyConvert(hf.a(fq.this.ab, "NAVI_STRATEGY_TAB1"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB2"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB3"), hf.a(fq.this.ab, "NAVI_STRATEGY_TAB4"), true));
                            }
                        });
                        this.aw = true;
                        this.ax.obtainMessage(1).sendToTarget();
                        return;
                    } else if (this.ar) {
                        this.R.pauseNavi();
                        this.ar = false;
                        this.v.setBackgroundDrawable(hs.a().getDrawable(2130837566));
                        return;
                    } else {
                        this.R.resumeNavi();
                        this.ar = true;
                        this.v.setBackgroundDrawable(hs.a().getDrawable(2130837562));
                        return;
                    }
                case 2131296339:
                    switch (this.as) {
                        case 1:
                            this.R.setEmulatorNaviSpeed(80);
                            this.as = 2;
                            this.n.setText("中速");
                            return;
                        case 2:
                            this.R.setEmulatorNaviSpeed(120);
                            this.as = 3;
                            this.n.setText("高速");
                            return;
                        case 3:
                            this.R.setEmulatorNaviSpeed(40);
                            this.as = 1;
                            this.n.setText("低速");
                            return;
                        default:
                            return;
                    }
                case 2131296345:
                    if (System.currentTimeMillis() - this.aq > 6000) {
                        f(this.ap);
                        this.aq = System.currentTimeMillis();
                        return;
                    }
                    Toast.makeText(this.ao, "暂无新路线", 0).show();
                    return;
                case 2131296351:
                    if (hq.b(this.ab)) {
                        LocManager.switchParallelRoad((LocObjectId) null);
                        return;
                    } else {
                        Toast.makeText(this.ab, "无网络", 0).show();
                        return;
                    }
                default:
                    return;
            }
        } catch (Throwable th) {
            hq.a(th);
            iu.b(th, "AMapNaviView", "onClick(View v)");
        }
        hq.a(th);
        iu.b(th, "AMapNaviView", "onClick(View v)");
    }

    private void f(int i2) {
        try {
            c(true);
            Poi f2 = this.ao.getSearchResult().f();
            Poi c2 = this.ao.getSearchResult().c();
            Poi d2 = this.ao.getSearchResult().d();
            Poi e2 = this.ao.getSearchResult().e();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            NaviLatLng naviLatLng = null;
            if (!(this.S == null || this.S.b() == null)) {
                naviLatLng = this.S.b();
            }
            if (naviLatLng == null || naviLatLng.getLatitude() <= 0.0d || naviLatLng.getLongitude() <= 0.0d) {
                fz searchResult = this.ao.getSearchResult();
                if (!(searchResult == null || searchResult.a() == null)) {
                    Poi a2 = searchResult.a();
                    arrayList.add(new NaviLatLng(a2.getCoordinate().latitude, a2.getCoordinate().longitude));
                }
            } else {
                arrayList.add(naviLatLng);
            }
            arrayList3.add(new NaviLatLng(f2.getCoordinate().latitude, f2.getCoordinate().longitude));
            if (c2 != null) {
                arrayList2.add(new NaviLatLng(c2.getCoordinate().latitude, c2.getCoordinate().longitude));
            }
            if (d2 != null) {
                arrayList2.add(new NaviLatLng(d2.getCoordinate().latitude, d2.getCoordinate().longitude));
            }
            if (e2 != null) {
                arrayList2.add(new NaviLatLng(e2.getCoordinate().latitude, e2.getCoordinate().longitude));
            }
            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
            if (callback != null && !hq.a) {
                callback.onGetNavigationText("路线重新规划");
            }
            this.R.reCalculateRoute(i2);
            this.aq = System.currentTimeMillis();
            this.ap = i2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean t() {
        return this.T.isTrafficEnabled();
    }

    public final void b(boolean z2) {
        this.T.setTrafficEnabled(z2);
    }

    public final void u() {
        this.F = true;
        this.g.setVisibility(8);
        this.j.setVisibility(8);
        this.s.setVisibility(8);
        this.q.setVisibility(8);
        this.p.setVisibility(8);
        this.c.setText("0");
        this.c.setVisibility(8);
        this.v.setEnabled(false);
    }

    public final boolean v() {
        return this.G;
    }

    public final boolean w() {
        return this.C;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[Catch:{ Throwable -> 0x001e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void x() {
        /*
            r3 = this;
            int r0 = r3.D     // Catch:{ Throwable -> 0x001e }
            com.amap.api.maps.TextureMapView r1 = r3.Q     // Catch:{ Throwable -> 0x001e }
            int r1 = r1.getHeight()     // Catch:{ Throwable -> 0x001e }
            if (r0 != r1) goto L_0x0017
            int r0 = r3.E     // Catch:{ Throwable -> 0x001e }
            com.amap.api.maps.TextureMapView r1 = r3.Q     // Catch:{ Throwable -> 0x001e }
            int r1 = r1.getWidth()     // Catch:{ Throwable -> 0x001e }
            if (r0 == r1) goto L_0x0015
            goto L_0x0017
        L_0x0015:
            r0 = 0
            goto L_0x0018
        L_0x0017:
            r0 = 1
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r3.J()     // Catch:{ Throwable -> 0x001e }
        L_0x001d:
            return
        L_0x001e:
            r0 = move-exception
            r0.printStackTrace()
            java.lang.String r1 = "AMapNaviView"
            java.lang.String r2 = "onLayout(boolean changed, int left, int top, int right,\n                            int bottom)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.fq.x():void");
    }

    private void J() {
        try {
            this.D = this.Q.getHeight();
            this.E = this.Q.getWidth();
            if (!(this.D == 0 || this.E == 0)) {
                this.T.setPointToCenter((int) (((double) this.E) * this.L), (int) (((double) this.D) * this.M));
            }
            this.S.h();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        this.K = z2;
        if (!z2) {
            this.w.setBackgroundDrawable(hs.a().getDrawable(2130837563));
        } else {
            this.w.setBackgroundDrawable(hs.a().getDrawable(2130837564));
        }
    }

    public final void y() {
        a(false);
        this.T.animateCamera(CameraUpdateFactory.zoomIn());
    }

    public final void z() {
        a(false);
        this.T.animateCamera(CameraUpdateFactory.zoomOut());
    }

    public final boolean A() {
        return this.K;
    }

    public final void B() {
        if (this.u != null) {
            this.u.performClick();
        }
    }

    public final void d(int i2) {
        try {
            "parallelRoadType=" + i2;
            this.ay = i2;
            if (this.ay == 0) {
                this.z.setVisibility(8);
                return;
            }
            this.z.setVisibility(0);
            if (this.ay == 1) {
                this.z.setBackgroundResource(2130837661);
            }
            if (this.ay == 2) {
                this.z.setBackgroundResource(2130837660);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.z.getLayoutParams();
            if (this.an) {
                layoutParams.addRule(12);
            } else if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.removeRule(12);
            }
            this.z.setLayoutParams(layoutParams);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void C() {
        if (this.U != null) {
            this.U.sendEmptyMessage(0);
        }
    }

    /* access modifiers changed from: package-private */
    public final void D() {
        this.v.setVisibility(0);
        this.j.setVisibility(8);
        this.k.setVisibility(0);
        this.s.setVisibility(8);
        this.r.setVisibility(8);
        boolean z2 = this.C;
        this.c.setText("0");
        if (this.R.getNaviType() == 2) {
            this.R.setEmulatorNaviSpeed(80);
            this.as = 2;
            this.c.setVisibility(8);
            this.k.setVisibility(8);
            this.n.setVisibility(0);
            this.p.setVisibility(8);
            this.q.setVisibility(8);
            this.g.setVisibility(8);
            this.v.setBackgroundDrawable(hs.a().getDrawable(2130837562));
        }
    }

    private void e(boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        "threadName=" + Thread.currentThread().getName() + ",checkCrossView=" + z2;
        if (z2) {
            this.ae = true;
            this.d.setVisibility(8);
            this.I.a(false);
            if (this.C) {
                layoutParams = new RelativeLayout.LayoutParams(this.A / 2, this.ak);
                this.a.setVisibility(0);
                this.a.setLayoutParams(layoutParams);
                this.b.setVisibility(8);
                this.L = 0.75d;
                J();
                if (this.T != null) {
                    this.T.getUiSettings().setLogoBottomMargin(e(5));
                    this.T.getUiSettings().setLogoLeftMargin((this.A / 2) + e(65));
                }
            } else {
                layoutParams = new RelativeLayout.LayoutParams(-1, this.am);
                this.b.setVisibility(0);
                this.b.setLayoutParams(layoutParams);
                this.a.setVisibility(8);
                this.L = 0.5d;
            }
        } else {
            this.ae = false;
            if (this.an) {
                this.d.setVisibility(0);
            }
            this.I.a(true);
            if (this.C) {
                layoutParams = new RelativeLayout.LayoutParams(this.aj, -1);
                this.a.setLayoutParams(layoutParams);
                this.a.setVisibility(0);
                this.b.setVisibility(8);
                this.L = 0.65d;
                J();
                if (this.T != null) {
                    this.T.getUiSettings().setLogoBottomMargin(e(5));
                    this.T.getUiSettings().setLogoLeftMargin(this.aj + e(65));
                }
            } else {
                this.L = 0.5d;
                layoutParams = new RelativeLayout.LayoutParams(-1, this.al);
                this.b.setVisibility(0);
                this.b.setLayoutParams(layoutParams);
                this.a.setVisibility(8);
                J();
            }
        }
        this.I.setLayoutParams(layoutParams);
        this.H.invalidate();
    }

    public final boolean E() {
        return this.ae;
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z2) {
        if (this.ao != null) {
            if (z2) {
                this.ao.showLoadingDialog();
            } else {
                this.ao.removeLoadingDialog();
            }
        }
    }
}
