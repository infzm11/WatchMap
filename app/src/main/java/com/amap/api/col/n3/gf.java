package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.col.n3.fx;
import com.amap.api.col.n3.gz;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AMapNaviListener;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INaviInfoCallback;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.AMapNaviStep;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.model.NaviLatLng;
import com.amap.api.navi.view.LoadingView;
import com.amap.api.navi.view.NaviGuideWidget;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.amap.api.navi.view.SlidingUpPanelLayout;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.hoinnet.highde.R;
import com.autonavi.ae.route.model.RoutePoi;
import com.autonavi.tbt.TrafficFacilityInfo;
import com.iflytek.aiui.AIUIConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: RoutePage */
public final class gf extends fu implements View.OnClickListener, gd, AMap.OnCameraChangeListener, AMapNaviListener {
    private TextView A;
    private TextView B;
    private TextView C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    /* access modifiers changed from: private */
    public Button H;
    private Button I;
    private Button J;
    private ImageButton K;
    private ImageButton L;
    private ImageButton M;
    private ImageButton N;
    private NaviGuideWidget O;
    /* access modifiers changed from: private */
    public SlidingUpPanelLayout P;
    private LinearLayout Q;
    private RelativeLayout R;
    private TextView S;
    private LoadingView T;
    private RelativeLayout U;
    private List<NaviLatLng> V = new ArrayList();
    private List<NaviLatLng> W = new ArrayList();
    private List<NaviLatLng> X = new ArrayList();
    private SparseArray<fr> Y = new SparseArray<>();
    private int Z = 1;
    private int aa = 10;
    /* access modifiers changed from: private */
    public Poi ab;
    /* access modifiers changed from: private */
    public Poi ac;
    /* access modifiers changed from: private */
    public Poi ad;
    /* access modifiers changed from: private */
    public Poi ae;
    /* access modifiers changed from: private */
    public Poi af;
    /* access modifiers changed from: private */
    public PoiInputSearchWidget ag;
    private int ah;
    private int[] ai;
    private int aj = 2131296394;
    private a ak = a.SUCCESS;
    private long al;
    private Polygon am;
    /* access modifiers changed from: private */
    public ho an;
    /* access modifiers changed from: private */
    public boolean ao = true;
    /* access modifiers changed from: private */
    public Handler ap = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 1:
                        ho.c();
                        if (ho.b() == 0) {
                            gf.this.ap.removeCallbacksAndMessages((Object) null);
                            gf.this.an.dismiss();
                        }
                        if (gf.this.ao) {
                            Message message2 = new Message();
                            message2.what = 1;
                            gf.this.ap.sendMessageDelayed(message2, 1000);
                            return;
                        }
                        return;
                    case 2:
                        ho.a();
                        boolean unused = gf.this.ao = false;
                        return;
                    case 3:
                        gf.e(gf.this);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public List<Poi> aq = new ArrayList();
    private Poi ar;
    private Poi as;
    private Poi at;
    private Poi au;
    private Poi av;
    protected AMapNavi j;
    ImageButton k = null;
    ImageButton l = null;
    int m = 12;
    private final String n = "RoutePage";
    private TextureMapView o;
    private AMap p;
    private RelativeLayout q;
    private RelativeLayout r;
    /* access modifiers changed from: private */
    public RelativeLayout s;
    /* access modifiers changed from: private */
    public gc t;
    private LinearLayout u;
    private LinearLayout v;
    private LinearLayout w;
    private TextView x;
    private TextView y;
    private TextView z;

    /* compiled from: RoutePage */
    enum a {
        SUCCESS,
        LOCATION_FAILE,
        CALCULATE_FAILE
    }

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public final void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    public final void hideCross() {
    }

    public final void hideLaneInfo() {
    }

    public final void notifyParallelRoad(int i) {
    }

    public final void onArriveDestination() {
    }

    public final void onArrivedWayPoint(int i) {
    }

    public final void onCameraChange(CameraPosition cameraPosition) {
    }

    public final void onEndEmulatorNavi() {
    }

    public final void onGetNavigationText(int i, String str) {
    }

    public final void onGetNavigationText(String str) {
    }

    public final void onGpsOpenStatus(boolean z2) {
    }

    public final void onInitNaviSuccess() {
    }

    public final void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    public final void onNaviInfoUpdate(NaviInfo naviInfo) {
    }

    public final void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public final void onPlayRing(int i) {
    }

    public final void onReCalculateRouteForTrafficJam() {
    }

    public final void onReCalculateRouteForYaw() {
    }

    public final void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    public final void onStartNavi(int i) {
    }

    public final void onTrafficStatusUpdate() {
    }

    public final void showCross(AMapNaviCross aMapNaviCross) {
    }

    public final void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    public final void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    public final void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    public final void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    static /* synthetic */ void a(gf gfVar, int i) {
        if (i == gfVar.aa) {
            Toast.makeText(gfVar.i, "策略未改变，不进行重算.", 0).show();
            return;
        }
        gfVar.aa = i;
        gfVar.a(i);
    }

    static /* synthetic */ void e(gf gfVar) {
        try {
            gfVar.i.removeLoadingDialog();
            if (gfVar.ac == null) {
                gfVar.P.setVisibility(8);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gfVar.s.getLayoutParams();
                layoutParams.bottomMargin = 0;
                gfVar.s.setLayoutParams(layoutParams);
                gfVar.K.setVisibility(8);
                gfVar.L.setVisibility(8);
            }
            String str = "";
            String str2 = "";
            if (gfVar.ab != null) {
                str = gfVar.ab.getName();
            }
            if (gfVar.ac != null) {
                str2 = gfVar.ac.getName();
                gfVar.i.getSearchResult().f(gfVar.ac);
            }
            gfVar.ag.initUI(new Poi(str, (LatLng) null, "0"), new Poi(str2, (LatLng) null, "0"), gfVar.aq, 3);
            gfVar.a(gfVar.aq);
            gfVar.a(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        this.i.setRequestedOrientation(1);
        this.j = AMapNavi.getInstance(this.i);
        this.j.addAMapNaviListener(this);
        this.o = new TextureMapView(this.i);
        this.r = (RelativeLayout) this.q.findViewById(2131296306);
        this.r.addView(this.o);
        this.o.setBackgroundColor(-1);
        this.o.onCreate(bundle);
        this.p = this.o.getMap();
        this.p.setOnCameraChangeListener(this);
        this.p.getUiSettings().setZoomControlsEnabled(false);
        this.p.getUiSettings().setLogoLeftMargin(a(45.0f));
        this.p.getUiSettings().setLogoBottomMargin(a(7.0f));
        this.p.setMapType(4);
        this.ah = bundle.getInt("from");
        this.O = (NaviGuideWidget) this.q.findViewById(2131296316);
        this.U = (RelativeLayout) this.q.findViewById(2131296391);
        this.s = (RelativeLayout) this.q.findViewById(2131296305);
        this.T = (LoadingView) this.q.findViewById(2131296319);
        this.ag = (PoiInputSearchWidget) this.q.findViewById(2131296307);
        this.P = (SlidingUpPanelLayout) this.q.findViewById(2131296314);
        this.Q = (LinearLayout) this.q.findViewById(2131296393);
        this.R = (RelativeLayout) this.q.findViewById(2131296406);
        this.S = (TextView) this.q.findViewById(2131296407);
        this.P.setPanelHeight(a(150.0f));
        this.P.setTopView(this.ag);
        this.H = (Button) this.q.findViewById(2131296410);
        this.H.setOnClickListener(this);
        this.P.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            public final void onPanelSlide(View view, float f) {
                "slideOffset=" + f;
                if (gf.this.H != null) {
                    gf.this.H.setAlpha(1.0f - f);
                    if (f == 1.0f) {
                        gf.this.H.setVisibility(4);
                    } else {
                        gf.this.H.setVisibility(0);
                    }
                }
            }

            public final void onPanelStateChanged(View view, SlidingUpPanelLayout.PanelState panelState, SlidingUpPanelLayout.PanelState panelState2) {
                "previousState=" + panelState;
            }
        });
        this.u = (LinearLayout) this.q.findViewById(2131296394);
        this.v = (LinearLayout) this.q.findViewById(2131296398);
        this.w = (LinearLayout) this.q.findViewById(2131296402);
        this.u.setOnClickListener(this);
        this.v.setOnClickListener(this);
        this.w.setOnClickListener(this);
        this.x = (TextView) this.q.findViewById(2131296395);
        this.y = (TextView) this.q.findViewById(2131296399);
        this.z = (TextView) this.q.findViewById(2131296403);
        this.A = (TextView) this.q.findViewById(2131296396);
        this.B = (TextView) this.q.findViewById(2131296400);
        this.C = (TextView) this.q.findViewById(2131296404);
        this.D = (TextView) this.q.findViewById(2131296397);
        this.E = (TextView) this.q.findViewById(2131296401);
        this.F = (TextView) this.q.findViewById(2131296405);
        this.G = (TextView) this.q.findViewById(2131296409);
        this.I = (Button) this.q.findViewById(2131296412);
        this.I.setOnClickListener(this);
        this.J = (Button) this.q.findViewById(2131296413);
        this.J.setOnClickListener(this);
        this.M = (ImageButton) this.q.findViewById(2131296308);
        this.M.setOnClickListener(this);
        this.L = (ImageButton) this.q.findViewById(2131296309);
        this.L.setOnClickListener(this);
        this.K = (ImageButton) this.q.findViewById(2131296310);
        this.K.setOnClickListener(this);
        this.k = (ImageButton) this.q.findViewById(2131296312);
        this.k.setOnClickListener(this);
        this.l = (ImageButton) this.q.findViewById(2131296313);
        this.l.setOnClickListener(this);
        this.N = (ImageButton) this.q.findViewById(2131296311);
        this.N.setOnClickListener(this);
        if (this.i != null) {
            this.aa = this.j.strategyConvert(hf.a((Context) this.i, "NAVI_STRATEGY_TAB1"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB2"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB3"), hf.a((Context) this.i, "NAVI_STRATEGY_TAB4"), true);
        }
        this.ag.setCallback(new PoiInputSearchWidget.Callback() {
            public final void onStartChooseMid() {
            }

            public final void onSwitchFail() {
            }

            public final void onClick(int i, int i2, Poi poi) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, "北京市");
                    if (gf.this.t != null) {
                        String e = gf.this.t.e();
                        if (!TextUtils.isEmpty(e)) {
                            bundle.putString(DistrictSearchQuery.KEYWORDS_CITY, e);
                        }
                    }
                    bundle.putString(AIUIConstant.KEY_CONTENT, gf.this.a(i, i2));
                    bundle.putInt("input_type", i);
                    bundle.putInt("input_type_mid", i2);
                    gf.this.i.newScr(new fy(3, bundle));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public final void onDelete(int i, Poi poi) {
                if (i < gf.this.aq.size()) {
                    gf.this.aq.remove(i);
                    gf.this.a((List<Poi>) gf.this.aq);
                }
            }

            public final void onBack() {
                gf.this.i.closeScr();
            }

            public final void onSwitch() {
                Poi b = gf.this.i.getSearchResult().b();
                Poi f = gf.this.i.getSearchResult().f();
                Poi c = gf.this.i.getSearchResult().c();
                Poi d = gf.this.i.getSearchResult().d();
                Poi e = gf.this.i.getSearchResult().e();
                gf.this.i.getSearchResult().c(e);
                gf.this.i.getSearchResult().e(c);
                gf.this.i.getSearchResult().b(f);
                gf.this.i.getSearchResult().f(b);
                ArrayList arrayList = new ArrayList();
                if (e != null) {
                    arrayList.add(e);
                }
                if (d != null) {
                    arrayList.add(d);
                }
                if (c != null) {
                    arrayList.add(c);
                }
                List unused = gf.this.aq = arrayList;
                if (!gf.this.ag.isFinishBtnVisible()) {
                    gf.this.j();
                }
            }

            public final void onFinishChooseMid() {
                if (gf.this.i()) {
                    if (gf.this.P.getVisibility() == 8) {
                        gf.this.P.setVisibility(0);
                        gf.this.P.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) gf.this.s.getLayoutParams();
                        layoutParams.bottomMargin = gf.this.a(150.0f);
                        gf.this.s.setLayoutParams(layoutParams);
                    }
                    gf.this.j();
                }
            }
        });
        if (this.ah == 4) {
            try {
                this.i.showLoadingDialog();
                this.ac = (Poi) bundle.getParcelable(AmapNaviPage.POI_END);
                this.ab = (Poi) bundle.getParcelable(AmapNaviPage.POI_START);
                this.ad = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY1);
                this.ae = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY2);
                this.af = (Poi) bundle.getParcelable(AmapNaviPage.POI_WAY3);
                new Thread(new Runnable() {
                    public final void run() {
                        if (gf.this.ac != null) {
                            try {
                                if (!TextUtils.isEmpty(gf.this.ac.getPoiId())) {
                                    gw a2 = new gz(gf.this.i, (gz.b) null).a(gf.this.ac.getPoiId());
                                    if (!(a2 == null || a2.c() == null)) {
                                        gs c = a2.c();
                                        if (c != null && c.b() > 0.0d && c.a() > 0.0d) {
                                            Poi unused = gf.this.ac = new Poi(a2.a(), new LatLng(c.b(), c.a()), gf.this.ac.getPoiId());
                                        }
                                    }
                                }
                            } catch (gh e) {
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        if (gf.this.ab != null) {
                            try {
                                if (!TextUtils.isEmpty(gf.this.ab.getPoiId())) {
                                    gw a3 = new gz(gf.this.i, (gz.b) null).a(gf.this.ab.getPoiId());
                                    if (!(a3 == null || a3.b() == null)) {
                                        gs b = a3.b();
                                        if (b != null && b.b() > 0.0d && b.a() > 0.0d) {
                                            Poi unused2 = gf.this.ab = new Poi(a3.a(), new LatLng(b.b(), b.a()), gf.this.ab.getPoiId());
                                        }
                                    }
                                }
                            } catch (gh e2) {
                                e2.printStackTrace();
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                        gf.this.aq.clear();
                        if (gf.this.ad != null) {
                            try {
                                if (!TextUtils.isEmpty(gf.this.ad.getPoiId())) {
                                    gw a4 = new gz(gf.this.i, (gz.b) null).a(gf.this.ad.getPoiId());
                                    if (a4 != null) {
                                        gs c2 = a4.c();
                                        if (c2 == null || c2.b() <= 0.0d || c2.a() <= 0.0d) {
                                            gs b2 = a4.b();
                                            if (b2 != null) {
                                                Poi unused3 = gf.this.ad = new Poi(a4.a(), new LatLng(b2.b(), b2.a()), gf.this.ad.getPoiId());
                                            }
                                        } else {
                                            Poi unused4 = gf.this.ad = new Poi(a4.a(), new LatLng(c2.b(), c2.a()), gf.this.ad.getPoiId());
                                        }
                                    }
                                }
                                gf.this.aq.add(gf.this.ad);
                            } catch (gh e3) {
                                e3.printStackTrace();
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                        }
                        if (gf.this.ae != null) {
                            try {
                                if (!TextUtils.isEmpty(gf.this.ae.getPoiId())) {
                                    gw a5 = new gz(gf.this.i, (gz.b) null).a(gf.this.ae.getPoiId());
                                    if (a5 != null) {
                                        gs c3 = a5.c();
                                        if (c3 == null || c3.b() <= 0.0d || c3.a() <= 0.0d) {
                                            gs b3 = a5.b();
                                            if (b3 != null) {
                                                Poi unused5 = gf.this.ae = new Poi(a5.a(), new LatLng(b3.b(), b3.a()), gf.this.ae.getPoiId());
                                            }
                                        } else {
                                            Poi unused6 = gf.this.ae = new Poi(a5.a(), new LatLng(c3.b(), c3.a()), gf.this.ae.getPoiId());
                                        }
                                    }
                                }
                                gf.this.aq.add(gf.this.ae);
                            } catch (gh e4) {
                                e4.printStackTrace();
                            } catch (Throwable th4) {
                                th4.printStackTrace();
                            }
                        }
                        if (gf.this.af != null) {
                            try {
                                if (!TextUtils.isEmpty(gf.this.af.getPoiId())) {
                                    gw a6 = new gz(gf.this.i, (gz.b) null).a(gf.this.af.getPoiId());
                                    if (a6 != null) {
                                        gs c4 = a6.c();
                                        if (c4 != null) {
                                            Poi unused7 = gf.this.af = new Poi(a6.a(), new LatLng(c4.b(), c4.a()), gf.this.af.getPoiId());
                                        } else {
                                            gs b4 = a6.b();
                                            if (b4 != null) {
                                                Poi unused8 = gf.this.af = new Poi(a6.a(), new LatLng(b4.b(), b4.a()), gf.this.af.getPoiId());
                                            }
                                        }
                                    }
                                }
                                gf.this.aq.add(gf.this.af);
                            } catch (gh e5) {
                                e5.printStackTrace();
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                        gf.this.ap.sendEmptyMessage(3);
                    }
                }).start();
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.i != null) {
                    this.i.removeLoadingDialog();
                }
            }
        } else if (this.ah == 2) {
            try {
                ArrayList arrayList = new ArrayList(this.j.getNaviPaths().keySet());
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                if (iArr.length > 0) {
                    onCalculateRouteSuccess(iArr);
                }
                a(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.ah == 3) {
            try {
                boolean z2 = bundle.getBoolean("needRecalculate");
                int i2 = bundle.getInt("input_type");
                int i3 = bundle.getInt("input_type_mid");
                if (i2 == 0) {
                    this.ag.setPoi(0, -1, this.i.getSearchResult().b());
                } else if (i2 == 1) {
                    this.ag.setPoi(1, -1, this.i.getSearchResult().f());
                } else if (i2 == 2) {
                    Poi c = this.i.getSearchResult().c();
                    Poi d = this.i.getSearchResult().d();
                    Poi e2 = this.i.getSearchResult().e();
                    if (i3 == 0) {
                        this.ag.setPoi(2, 0, c);
                    }
                    if (i3 == 1) {
                        this.ag.setPoi(2, 1, d);
                    }
                    if (i3 == 2) {
                        this.ag.setPoi(2, 2, e2);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    if (c != null) {
                        arrayList2.add(c);
                    }
                    if (d != null) {
                        arrayList2.add(d);
                    }
                    if (e2 != null) {
                        arrayList2.add(e2);
                    }
                    this.aq = arrayList2;
                }
                "RoutePage initParams(来自搜索页面)mRecalculate=" + z2;
                if (z2 && this.ag != null && this.ag.isAllInputItemsFilled()) {
                    if (this.P.getVisibility() == 8) {
                        this.P.setVisibility(0);
                        this.P.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
                        layoutParams.bottomMargin = a(150.0f);
                        this.s.setLayoutParams(layoutParams);
                    }
                    this.ag.setShowChooseRes();
                    j();
                } else if (this.ai != null) {
                    onCalculateRouteSuccess(this.ai);
                }
                a(false);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(List<Poi> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    switch (list.size()) {
                        case 1:
                            this.i.getSearchResult().c(list.get(0));
                            this.i.getSearchResult().d((Poi) null);
                            this.i.getSearchResult().e((Poi) null);
                            this.ag.setPoi(2, 0, list.get(0));
                            return;
                        case 2:
                            this.i.getSearchResult().c(list.get(0));
                            this.i.getSearchResult().d(list.get(1));
                            this.i.getSearchResult().e((Poi) null);
                            this.ag.setPoi(2, 0, list.get(0));
                            this.ag.setPoi(2, 1, list.get(1));
                            return;
                        case 3:
                            this.i.getSearchResult().c(list.get(0));
                            this.i.getSearchResult().d(list.get(1));
                            this.i.getSearchResult().e(list.get(2));
                            this.ag.setPoi(2, 0, list.get(0));
                            this.ag.setPoi(2, 1, list.get(1));
                            this.ag.setPoi(2, 2, list.get(2));
                            return;
                        default:
                            return;
                    }
                } else {
                    this.i.getSearchResult().c((Poi) null);
                    this.i.getSearchResult().d((Poi) null);
                    this.i.getSearchResult().e((Poi) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean i() {
        Poi b = this.i.getSearchResult().b();
        Poi f = this.i.getSearchResult().f();
        Poi c = this.i.getSearchResult().c();
        Poi d = this.i.getSearchResult().d();
        Poi e = this.i.getSearchResult().e();
        if (b == this.ar && this.av == e && this.at == c && this.au == d && this.as == f) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (c != null) {
            arrayList.add(c);
        }
        if (d != null) {
            arrayList.add(d);
        }
        if (e != null) {
            arrayList.add(e);
        }
        a((List<Poi>) arrayList);
        if (b == null || f == null) {
            a("起点或终点坐标不能为空");
            return false;
        } else if (c != null || d != null || e != null) {
            return true;
        } else {
            try {
                if (b.getCoordinate().longitude != f.getCoordinate().longitude || b.getCoordinate().latitude != f.getCoordinate().latitude) {
                    return true;
                }
                a("起点和终点坐标不能相同");
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }
    }

    /* access modifiers changed from: private */
    public String a(int i, int i2) {
        String name;
        fz searchResult = this.i.getSearchResult();
        String str = "";
        if (searchResult == null) {
            return str;
        }
        if (i == 0) {
            try {
                if (searchResult.b() != null) {
                    name = searchResult.b().getName();
                    str = name;
                    if (TextUtils.isEmpty(str) || "我的位置".equals(str)) {
                        return "";
                    }
                    return str;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (i != 1 || searchResult.f() == null) {
            if (i == 2) {
                if (i2 == 0 && searchResult.c() != null) {
                    str = searchResult.c().getName();
                }
                if (i2 == 1 && searchResult.d() != null) {
                    str = searchResult.d().getName();
                }
                if (i2 == 2 && searchResult.e() != null) {
                    name = searchResult.e().getName();
                    str = name;
                }
            }
            return "";
        }
        name = searchResult.f().getName();
        str = name;
        return "";
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            a(this.aa);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(int i) {
        try {
            Poi b = this.i.getSearchResult().b();
            Poi f = this.i.getSearchResult().f();
            Poi c = this.i.getSearchResult().c();
            Poi d = this.i.getSearchResult().d();
            Poi e = this.i.getSearchResult().e();
            if (b == null || f == null) {
                Toast.makeText(this.i, "起点或终点坐标不能为空", 0).show();
                return;
            }
            if (c == null && d == null && e == null) {
                if (b.getCoordinate().longitude == f.getCoordinate().longitude && b.getCoordinate().latitude == f.getCoordinate().latitude) {
                    Toast.makeText(this.i, "起点和终点坐标不能相同", 0).show();
                    return;
                }
            }
            this.aj = 2131296394;
            this.P.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            this.T.showLoading();
            this.P.setTouchEnabled(false);
            this.T.setVisibility(0);
            this.U.setVisibility(4);
            this.V.clear();
            this.X.clear();
            this.W.clear();
            this.V.add(new NaviLatLng(b.getCoordinate().latitude, b.getCoordinate().longitude));
            this.X.add(new NaviLatLng(f.getCoordinate().latitude, f.getCoordinate().longitude));
            if (c != null) {
                this.W.add(new NaviLatLng(c.getCoordinate().latitude, c.getCoordinate().longitude));
            }
            if (d != null) {
                this.W.add(new NaviLatLng(d.getCoordinate().latitude, d.getCoordinate().longitude));
            }
            if (e != null) {
                this.W.add(new NaviLatLng(e.getCoordinate().latitude, e.getCoordinate().longitude));
            }
            this.ar = b;
            this.as = f;
            this.at = c;
            this.au = d;
            this.av = e;
            "calculate(开始算路，策略=" + i + ")";
            this.j.calculateDriveRoute(this.V, this.X, this.W, i);
            if (this.ag != null) {
                this.ag.isInRouteCal(true);
            }
            this.al = System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void f() {
        super.f();
        if (this.o != null) {
            this.o.onResume();
        }
    }

    public final void h() {
        super.h();
        if (this.o != null) {
            this.o.onPause();
        }
    }

    public final void g() {
        super.g();
        if (this.t != null) {
            this.t.b();
        }
    }

    public final void e() {
        if (this.o != null) {
            this.o.onDestroy();
            this.r.removeView(this.o);
            this.o = null;
        }
        if (this.j != null) {
            this.j.removeAMapNaviListener(this);
        }
        if (this.an != null) {
            this.an.e();
            this.an = null;
        }
        if (this.t != null) {
            this.t.c();
            this.t = null;
        }
        if (this.am != null) {
            this.am.remove();
        }
    }

    public final boolean a() {
        if (this.P == null || this.P.getPanelState() != SlidingUpPanelLayout.PanelState.EXPANDED) {
            this.V.clear();
            this.W.clear();
            this.X.clear();
            if (this.o != null) {
                this.o.onDestroy();
                this.r.removeView(this.o);
                this.o = null;
            }
            if (this.j != null) {
                this.j.removeAMapNaviListener(this);
                this.j.destroy();
                this.j = null;
            }
            if (this.an != null) {
                this.an.e();
                this.an = null;
            }
            if (this.t != null) {
                this.t.c();
                this.t = null;
            }
            if (this.Y != null) {
                this.Y.clear();
                this.Y = null;
            }
            return super.a();
        }
        this.P.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        return false;
    }

    public final void a(View view) {
        onClick(view);
    }

    public final void onClick(View view) {
        try {
            if (this.T == null || !this.T.isShowing()) {
                Bundle bundle = new Bundle();
                int id = view.getId();
                if (id == 2131296394 || id == 2131296398 || id == 2131296402) {
                    if (view.getId() == this.aj) {
                        this.P.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
                    } else {
                        c(view.getId());
                    }
                } else if (id != 2131296410) {
                    switch (id) {
                        case 2131296308:
                            this.t.a();
                            LatLng d = this.t.d();
                            if (d != null) {
                                this.p.moveCamera(CameraUpdateFactory.newLatLngZoom(d, 15.0f));
                                return;
                            }
                            return;
                        case 2131296309:
                            if (this.an == null) {
                                this.an = new ho(this.i.getApplicationContext());
                                this.an.a(false);
                            }
                            this.an.setHeight(a(300.0f));
                            this.an.d();
                            this.an.showAtLocation(this.q, 81, 0, 0);
                            final WindowManager.LayoutParams attributes = this.i.getWindow().getAttributes();
                            attributes.alpha = 0.7f;
                            this.i.getWindow().setAttributes(attributes);
                            this.an.setOnDismissListener(new PopupWindow.OnDismissListener() {
                                public final void onDismiss() {
                                    try {
                                        gf.this.ap.obtainMessage(2).sendToTarget();
                                        attributes.alpha = 1.0f;
                                        gf.this.i.getWindow().setAttributes(attributes);
                                        gf.a(gf.this, gf.this.j.strategyConvert(hf.a((Context) gf.this.i, "NAVI_STRATEGY_TAB1"), hf.a((Context) gf.this.i, "NAVI_STRATEGY_TAB2"), hf.a((Context) gf.this.i, "NAVI_STRATEGY_TAB3"), hf.a((Context) gf.this.i, "NAVI_STRATEGY_TAB4"), true));
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                            this.ao = true;
                            this.ap.obtainMessage(1).sendToTarget();
                            return;
                        case 2131296310:
                            if (System.currentTimeMillis() - this.al > 6000) {
                                j();
                                return;
                            } else {
                                Toast.makeText(this.i, "暂无新路线", 0).show();
                                return;
                            }
                        case 2131296311:
                            if (this.p.isTrafficEnabled()) {
                                this.N.setImageDrawable(hs.a().getDrawable(2130837535));
                                this.p.setTrafficEnabled(false);
                                return;
                            }
                            this.N.setImageDrawable(hs.a().getDrawable(2130837536));
                            this.p.setTrafficEnabled(true);
                            return;
                        case 2131296312:
                            this.p.animateCamera(CameraUpdateFactory.zoomIn());
                            return;
                        case 2131296313:
                            this.p.animateCamera(CameraUpdateFactory.zoomOut());
                            return;
                        default:
                            switch (id) {
                                case 2131296412:
                                    bundle.putInt("navi_type", 2);
                                    this.i.newScr(new fy(2, bundle));
                                    return;
                                case 2131296413:
                                    bundle.putInt("navi_type", 1);
                                    this.i.newScr(new fy(2, bundle));
                                    return;
                                default:
                                    return;
                            }
                    }
                } else {
                    bundle.putInt("navi_type", 1);
                    this.i.newScr(new fy(2, bundle));
                }
            } else if (view.getId() == 2131296332) {
                if (this.ak == a.CALCULATE_FAILE) {
                    j();
                }
                if (this.ak == a.LOCATION_FAILE) {
                    a(true);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final RelativeLayout d() {
        if (this.q == null) {
            this.q = (RelativeLayout) hs.a(this.i, R.attr.actionBarTabBarStyle, (ViewGroup) null);
        }
        return this.q;
    }

    private static String b(int i) {
        int i2 = (i + 59) / 60;
        if (i2 < 61) {
            return i2 + "分钟";
        }
        return (i2 / 60) + "小时" + (i2 % 60) + "分";
    }

    private void a(int i, AMapNaviPath aMapNaviPath) {
        this.p.moveCamera(CameraUpdateFactory.changeTilt(0.0f));
        final fr frVar = new fr(this.p, aMapNaviPath, this.i);
        if (this.m != i) {
            frVar.a(0);
            frVar.b(-1);
        }
        this.Y.put(i, frVar);
        new Thread(new Runnable() {
            public final void run() {
                try {
                    frVar.a();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, "AAAAA").start();
    }

    private void c(int i) {
        this.aj = i;
        if (i == 2131296394) {
            this.u.setBackgroundDrawable(hs.a().getDrawable(2130837724));
            this.v.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.w.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.x.setBackgroundColor(Color.parseColor("#4287FF"));
            this.y.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.z.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.x.setTextColor(-1);
            this.y.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.z.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.A.setTextColor(Color.parseColor("#4287FF"));
            this.B.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.C.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.D.setTextColor(Color.parseColor("#4287FF"));
            this.E.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.F.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            d(12);
        }
        if (i == 2131296398) {
            this.u.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.v.setBackgroundDrawable(hs.a().getDrawable(2130837724));
            this.w.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.x.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.y.setBackgroundColor(Color.parseColor("#4287FF"));
            this.z.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.y.setTextColor(-1);
            this.x.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.z.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.A.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.B.setTextColor(Color.parseColor("#4287FF"));
            this.C.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.D.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.E.setTextColor(Color.parseColor("#4287FF"));
            this.F.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            d(13);
        }
        if (i == 2131296402) {
            this.u.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.v.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.w.setBackgroundDrawable(hs.a().getDrawable(2130837724));
            this.x.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.y.setBackgroundColor(Color.parseColor("#E2E2E2"));
            this.z.setBackgroundColor(Color.parseColor("#4287FF"));
            this.z.setTextColor(-1);
            this.x.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.y.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.A.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.B.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.C.setTextColor(Color.parseColor("#4287FF"));
            this.E.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.D.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            this.F.setTextColor(Color.parseColor("#4287FF"));
            d(14);
        }
        this.p.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(this.j.getNaviPaths().get(12).getBoundsForPath(), a(65.0f), a(65.0f), this.ag.getHeight() + a(80.0f), a(80.0f)), 500, (AMap.CancelableCallback) null);
    }

    private void d(int i) {
        try {
            this.m = i;
            int i2 = 0;
            for (int i3 = 0; i3 < this.Y.size(); i3++) {
                int keyAt = this.Y.keyAt(i3);
                if (keyAt != i) {
                    this.Y.get(keyAt).a(0);
                    this.Y.get(keyAt).b(-1);
                }
            }
            this.Y.get(i).a(1);
            this.Y.get(i).b(0);
            this.j.selectRouteId(i);
            AMapNaviPath naviPath = this.j.getNaviPath();
            List<AMapNaviStep> steps = naviPath.getSteps();
            int tollCost = naviPath.getTollCost();
            for (AMapNaviStep trafficLightNumber : steps) {
                i2 += trafficLightNumber.getTrafficLightNumber();
            }
            this.G.setText("红绿灯" + i2 + "个 过路费" + tollCost + "元");
            Poi b = this.i.getSearchResult().b();
            if (b == null) {
                b = new Poi("当前位置", (LatLng) null, "");
            }
            this.O.setGuideData(b.getName(), this.i.getSearchResult().f().getName(), k());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(int i, LatLng latLng) {
        if (i != 0) {
            this.ak = a.LOCATION_FAILE;
            this.ag.setPoi(0, -1, new Poi("", new LatLng(0.0d, 0.0d), ""));
            this.P.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            String str = "算路失败,请稍后重试";
            switch (i) {
                case 2:
                    str = "定位失败,仅扫描到单个wifi";
                    break;
                case 4:
                    str = "定位失败,请求服务器出现异常";
                    break;
                case 5:
                    str = "定位失败,定位结果解析失败";
                    break;
                case 6:
                    str = "定位失败,定位服务返回定位失败";
                    break;
                case 7:
                    str = "定位失败,key非法或过期";
                    break;
                case 9:
                    str = "定位失败,初始化时出现异常";
                    break;
                case 11:
                    str = "定位失败,基站信息错误";
                    break;
                case 12:
                    str = "定位失败,缺少定位权限";
                    break;
                case 13:
                    str = "定位失败,未获得WIFI列表和基站信息，且GPS当前不可用";
                    break;
                case 15:
                    str = "定位失败,定位结果被模拟导致定位失败";
                    break;
            }
            a(str);
            return;
        }
        RoutePoi routePoi = new RoutePoi();
        routePoi.latitude = latLng.latitude;
        routePoi.longitude = latLng.longitude;
        en.a(new RoutePoi[]{routePoi});
        this.i.getSearchResult().a(new Poi("我的位置", latLng, ""));
        if (this.ab == null) {
            this.ab = new Poi("我的位置", latLng, "");
            this.i.getSearchResult().b(this.ab);
            this.ag.setPoi(0, -1, this.ab);
            this.ag.setShowChooseRes();
        } else {
            this.i.getSearchResult().b(this.ab);
        }
        if (this.ah != 4) {
            return;
        }
        if (this.ac == null || this.ac.getCoordinate() == null) {
            this.M.performClick();
            return;
        }
        this.i.getSearchResult().f(this.ac);
        this.ag.setPoi(1, -1, this.ac);
        this.ag.setShowChooseRes();
        j();
    }

    private void a(boolean z2) {
        if (this.t == null) {
            this.t = new ft(this.i);
            this.t.a((gd) this);
        }
        this.t.a(this.p);
        this.t.a(z2);
        this.t.a();
    }

    public final void onCalculateRouteSuccess(int[] iArr) {
        int[] iArr2 = iArr;
        try {
            if (this.ag != null) {
                this.ag.isInRouteCal(false);
            }
            if (this.am != null) {
                this.am = this.p.addPolygon(new PolygonOptions().add(new LatLng(85.0d, -180.0d), new LatLng(85.0d, 179.99999d), new LatLng(-85.0d, 179.9999d), new LatLng(-85.0d, -180.0d)).fillColor(-1996488705));
                this.am.setZIndex(-1.0f);
            }
            this.ai = iArr2;
            this.K.setVisibility(0);
            this.L.setVisibility(0);
            if (this.Y != null && this.Y.size() > 0) {
                for (int i = 0; i < this.Y.size(); i++) {
                    fr valueAt = this.Y.valueAt(i);
                    valueAt.b();
                    valueAt.c();
                }
                this.Y.clear();
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.s.getLayoutParams();
            HashMap<Integer, AMapNaviPath> naviPaths = this.j.getNaviPaths();
            if (iArr2.length == 1) {
                this.P.setPanelHeight(a(132.0f));
                this.Q.setVisibility(8);
                this.R.setVisibility(0);
                this.j.selectRouteId(iArr2[0]);
                AMapNaviPath naviPath = this.j.getNaviPath();
                this.m = iArr2[0];
                a(iArr2[0], naviPath);
                d(iArr2[0]);
                this.S.setText(b(naviPath.getAllTime()) + " " + hq.a(naviPath.getAllLength()));
                this.p.animateCamera(CameraUpdateFactory.newLatLngBoundsRect(this.j.getNaviPaths().get(Integer.valueOf(iArr2[0])).getBoundsForPath(), a(65.0f), a(65.0f), this.ag.getHeight() + a(50.0f), a(30.0f)), 500, (AMap.CancelableCallback) null);
                layoutParams.bottomMargin = a(130.0f);
            } else {
                this.P.setPanelHeight(a(150.0f));
                this.Q.setVisibility(0);
                this.R.setVisibility(8);
                if (this.aj == 2131296394) {
                    this.m = 12;
                }
                if (this.aj == 2131296398) {
                    this.m = 13;
                }
                if (this.aj == 2131296402) {
                    this.m = 14;
                }
                int length = iArr2.length;
                if (length == 2) {
                    AMapNaviPath aMapNaviPath = naviPaths.get(Integer.valueOf(iArr2[0]));
                    AMapNaviPath aMapNaviPath2 = naviPaths.get(Integer.valueOf(iArr2[1]));
                    a(iArr2[0], aMapNaviPath);
                    a(iArr2[1], aMapNaviPath2);
                    this.w.setVisibility(8);
                    this.A.setText(b(aMapNaviPath.getAllTime()));
                    this.D.setText(String.format("%.1f", new Object[]{Float.valueOf(((float) aMapNaviPath.getAllLength()) / 1000.0f)}) + "公里");
                    if (aMapNaviPath.getLabels().contains(",")) {
                        this.x.setText(aMapNaviPath.getLabels().substring(0, aMapNaviPath.getLabels().indexOf(",")));
                    } else {
                        this.x.setText(String.valueOf(aMapNaviPath.getLabels()));
                    }
                    this.B.setText(b(aMapNaviPath2.getAllTime()));
                    this.E.setText(String.format("%.1f", new Object[]{Float.valueOf(((float) aMapNaviPath2.getAllLength()) / 1000.0f)}) + "公里");
                    if (aMapNaviPath2.getLabels().contains(",")) {
                        this.y.setText(aMapNaviPath2.getLabels().substring(0, aMapNaviPath2.getLabels().indexOf(",")));
                    } else {
                        this.y.setText(String.valueOf(aMapNaviPath2.getLabels()));
                    }
                }
                if (length == 3) {
                    AMapNaviPath aMapNaviPath3 = naviPaths.get(Integer.valueOf(iArr2[0]));
                    AMapNaviPath aMapNaviPath4 = naviPaths.get(Integer.valueOf(iArr2[1]));
                    AMapNaviPath aMapNaviPath5 = naviPaths.get(Integer.valueOf(iArr2[2]));
                    a(iArr2[0], aMapNaviPath3);
                    a(iArr2[1], aMapNaviPath4);
                    a(iArr2[2], aMapNaviPath5);
                    this.w.setVisibility(0);
                    if (aMapNaviPath3 != null) {
                        this.A.setText(b(aMapNaviPath3.getAllTime()));
                        this.D.setText(String.format("%.1f", new Object[]{Float.valueOf(((float) aMapNaviPath3.getAllLength()) / 1000.0f)}) + "公里");
                        if (aMapNaviPath3.getLabels().contains(",")) {
                            this.x.setText(aMapNaviPath3.getLabels().substring(0, aMapNaviPath3.getLabels().indexOf(",")));
                        } else {
                            this.x.setText(String.valueOf(aMapNaviPath3.getLabels()));
                        }
                    }
                    if (aMapNaviPath4 != null) {
                        this.B.setText(b(aMapNaviPath4.getAllTime()));
                        this.E.setText(String.format("%.1f", new Object[]{Float.valueOf(((float) aMapNaviPath4.getAllLength()) / 1000.0f)}) + "公里");
                        if (aMapNaviPath4.getLabels().contains(",")) {
                            this.y.setText(aMapNaviPath4.getLabels().substring(0, aMapNaviPath4.getLabels().indexOf(",")));
                        } else {
                            this.y.setText(String.valueOf(aMapNaviPath4.getLabels()));
                        }
                    }
                    if (aMapNaviPath5 != null) {
                        this.C.setText(b(aMapNaviPath5.getAllTime()));
                        this.F.setText(String.format("%.1f", new Object[]{Float.valueOf(((float) aMapNaviPath5.getAllLength()) / 1000.0f)}) + "公里");
                        if (aMapNaviPath5.getLabels().contains(",")) {
                            this.z.setText(aMapNaviPath5.getLabels().substring(0, aMapNaviPath5.getLabels().indexOf(",")));
                        } else {
                            this.z.setText(String.valueOf(aMapNaviPath5.getLabels()));
                        }
                    }
                }
                "onCalculateRouteSuccess----》selectId=" + this.aj;
                c(this.aj);
                layoutParams.bottomMargin = a(150.0f);
            }
            this.s.setLayoutParams(layoutParams);
            this.T.hideLoading();
            this.T.setVisibility(8);
            this.P.setTouchEnabled(true);
            this.U.setVisibility(0);
            this.ak = a.SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(String str) {
        if (this.P.getVisibility() == 0) {
            this.T.setVisibility(0);
            this.T.showFailed(str, this);
            this.P.setTouchEnabled(false);
            this.U.setVisibility(4);
            return;
        }
        Toast.makeText(this.i, str, 1).show();
    }

    private List<fx> k() {
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            List<AMapNaviGuide> naviGuideList = this.j.getNaviGuideList();
            List<AMapNaviStep> steps = this.j.getNaviPath().getSteps();
            for (int i = 0; i < naviGuideList.size(); i++) {
                AMapNaviGuide aMapNaviGuide = naviGuideList.get(i);
                fx fxVar = new fx();
                fxVar.c(aMapNaviGuide.getIconType());
                fxVar.a(aMapNaviGuide.getLength());
                fxVar.a(aMapNaviGuide.getName());
                fxVar.d(aMapNaviGuide.getToll());
                int segCount = aMapNaviGuide.getSegCount();
                int startSegId = aMapNaviGuide.getStartSegId();
                int i2 = 0;
                int i3 = startSegId;
                while (true) {
                    int i4 = segCount + startSegId;
                    if (i3 >= i4) {
                        break;
                    }
                    AMapNaviStep aMapNaviStep = steps.get(i3);
                    i2 += aMapNaviStep.getTrafficLightNumber();
                    int i5 = i4 - 1;
                    if (i3 == i5 && i == naviGuideList.size() - 1) {
                        str = "终点";
                    } else {
                        if (i3 == i5) {
                            int i6 = i + 1;
                            if (i6 < naviGuideList.size() - 1) {
                                str = naviGuideList.get(i6).getName();
                            }
                        }
                        str = aMapNaviStep.getLinks().get(0).getRoadName();
                    }
                    fxVar.a().add(new fx.a(aMapNaviStep.getIconType(), str, aMapNaviStep.getLength()));
                    i3++;
                }
                fxVar.b(i2);
                arrayList.add(fxVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final void onInitNaviFailure() {
        INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
        if (callback != null) {
            callback.onInitNaviFailure();
        }
    }

    public final void onCalculateRouteFailure(int i) {
        if (this.ag != null) {
            this.ag.isInRouteCal(false);
        }
        this.ak = a.CALCULATE_FAILE;
        a(hf.a(i));
    }

    public final void onCameraChangeFinish(CameraPosition cameraPosition) {
        if (this.p != null) {
            if (this.p.getCameraPosition().zoom >= this.p.getMaxZoomLevel()) {
                this.k.setEnabled(false);
                this.k.setBackgroundResource(2130837570);
            } else {
                this.k.setEnabled(true);
                this.k.setBackgroundResource(2130837569);
            }
            if (this.p.getCameraPosition().zoom <= this.p.getMinZoomLevel()) {
                this.l.setEnabled(false);
                this.l.setBackgroundResource(2130837572);
                return;
            }
            this.l.setEnabled(true);
            this.l.setBackgroundResource(2130837571);
        }
    }
}
