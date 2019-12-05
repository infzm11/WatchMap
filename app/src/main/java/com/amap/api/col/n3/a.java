package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.amap.api.col.n3.ef;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CustomRenderer;
import com.amap.api.maps.InfoWindowAnimationManager;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.model.Arc;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.CrossOverlay;
import com.amap.api.maps.model.CrossOverlayOptions;
import com.amap.api.maps.model.GroundOverlay;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.IndoorBuildingInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MultiPointOverlay;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.MyTrafficStyle;
import com.amap.api.maps.model.NavigateArrow;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.Poi;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.RouteOverlay;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.gmap.GLMapEngine;
import com.autonavi.ae.gmap.GLMapRender;
import com.autonavi.ae.gmap.GLMapState;
import com.autonavi.ae.gmap.callback.GLMapCoreCallback;
import com.autonavi.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.ae.gmap.gloverlay.BaseMapOverlay;
import com.autonavi.ae.gmap.gloverlay.BaseRouteOverlay;
import com.autonavi.ae.gmap.gloverlay.CrossVectorOverlay;
import com.autonavi.ae.gmap.gloverlay.GLOverlayBundle;
import com.autonavi.ae.gmap.gloverlay.GLTextureProperty;
import com.autonavi.ae.gmap.listener.MapSurfaceListener;
import com.autonavi.ae.gmap.listener.MapWidgetListener;
import com.autonavi.ae.gmap.maploader.NetworkState;
import com.autonavi.ae.gmap.maploader.VMapDataCache;
import com.autonavi.ae.gmap.style.MapTilsCacheAndResManager;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.ae.gmap.utils.GLConvertUtil;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.amap.mapcore.AEUtil;
import com.autonavi.amap.mapcore.CameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.FPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapConfig;
import com.autonavi.amap.mapcore.Rectangle;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.amap.mapcore.interfaces.IAMapListener;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.amap.mapcore.message.GestureMapMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: AMapDelegateImp */
public final class a implements k, GLMapCoreCallback, IAMapListener {
    private static boolean aB = false;
    String A = "//有颜色 没有纹理\nprecision highp float;\nvoid main(){\n  gl_FragColor = vec4(1.0,0,0,1.0);\n}";
    int B = -1;
    /* access modifiers changed from: private */
    public int C = -1;
    /* access modifiers changed from: private */
    public int D = -1;
    /* access modifiers changed from: private */
    public int E = 0;
    private Bitmap F = null;
    private Bitmap G = null;
    private AMap.OnMarkerClickListener H;
    private AMap.OnPolylineClickListener I;
    private AMap.OnMarkerDragListener J;
    /* access modifiers changed from: private */
    public AMap.OnMapLoadedListener K;
    /* access modifiers changed from: private */
    public AMap.OnCameraChangeListener L;
    /* access modifiers changed from: private */
    public AMap.OnMapClickListener M;
    /* access modifiers changed from: private */
    public AMap.OnMapTouchListener N;
    /* access modifiers changed from: private */
    public AMap.OnPOIClickListener O;
    private AMap.OnMapLongClickListener P;
    private AMap.OnInfoWindowClickListener Q;
    /* access modifiers changed from: private */
    public AMap.OnIndoorBuildingActiveListener R;
    private AMap.OnMyLocationChangeListener S;
    private e T;
    /* access modifiers changed from: private */
    public AMap.onMapPrintScreenListener U = null;
    /* access modifiers changed from: private */
    public AMap.OnMapScreenShotListener V = null;
    /* access modifiers changed from: private */
    public Object W = new Object();
    private AMapGestureListener X;
    private cs Y = null;
    private UiSettings Z;
    ae a;
    private Thread aA;
    /* access modifiers changed from: private */
    public boolean aC = false;
    private int aD = 0;
    private final q aE;
    /* access modifiers changed from: private */
    public int aF = -1;
    /* access modifiers changed from: private */
    public AtomicInteger aG = new AtomicInteger();
    /* access modifiers changed from: private */
    public ConcurrentMap<Integer, AMap.CancelableCallback> aH = new ConcurrentHashMap();
    private List<r> aI = new ArrayList();
    /* access modifiers changed from: private */
    public GLMapRender aJ;
    private boolean aK = false;
    private float aL = 0.0f;
    private float aM = 1.0f;
    private boolean aN = false;
    private boolean aO = true;
    private boolean aP = false;
    /* access modifiers changed from: private */
    public boolean aQ = false;
    /* access modifiers changed from: private */
    public int aR = 0;
    private GL10 aS = null;
    /* access modifiers changed from: private */
    public volatile boolean aT = false;
    private volatile boolean aU = false;
    private boolean aV = true;
    private boolean aW = false;
    private boolean aX = false;
    private Lock aY = new ReentrantLock();
    private int aZ = 0;
    private m aa;
    /* access modifiers changed from: private */
    public final v ab;
    private boolean ac = false;
    private final l ad;
    private boolean ae = true;
    private int af;
    /* access modifiers changed from: private */
    public boolean ag = false;
    private int ah = 0;
    /* access modifiers changed from: private */
    public MapSurfaceListener ai;
    /* access modifiers changed from: private */
    public MapWidgetListener aj;
    /* access modifiers changed from: private */
    public boolean ak = false;
    private boolean al = false;
    private boolean am = false;
    private co an;
    private LocationSource ao;
    private boolean ap = false;
    private Marker aq = null;
    private cf ar = null;
    private boolean as = false;
    private boolean at = false;
    private boolean au = false;
    /* access modifiers changed from: private */
    public boolean av = false;
    private boolean aw = false;
    private Rect ax = new Rect();
    private int ay = 1;
    /* access modifiers changed from: private */
    public MyTrafficStyle az = null;
    protected boolean b = false;
    /* access modifiers changed from: private */
    public int ba;
    /* access modifiers changed from: private */
    public int bb;
    /* access modifiers changed from: private */
    public b bc;
    private C0000a bd = new C0000a() {
        public final void run() {
            super.run();
            try {
                a.this.setTrafficEnabled(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private C0000a be = new C0000a() {
        public final void run() {
            super.run();
            a.this.a(this.g, this.c);
        }
    };
    private C0000a bf = new C0000a() {
        public final void run() {
            super.run();
            try {
                a.this.setCenterToPixel(a.this.ba, a.this.bb);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private C0000a bg = new C0000a() {
        public final void run() {
            super.run();
            a.this.a(this.g, this.d, this.e, this.f);
        }
    };
    private C0000a bh = new C0000a() {
        public final void run() {
            super.run();
            a.this.setMapCustomEnable(this.c);
        }
    };
    private C0000a bi = new C0000a() {
        public final void run() {
            super.run();
            a.this.b(this.g, this.c);
        }
    };
    private C0000a bj = new C0000a() {
        public final void run() {
            super.run();
            a.this.c(this.g, this.c);
        }
    };
    private C0000a bk = new C0000a() {
        public final void run() {
            super.run();
            a.this.d(this.g, this.c);
        }
    };
    private C0000a bl = new C0000a() {
        public final void run() {
            super.run();
            a.this.e(this.g, this.c);
        }
    };
    private C0000a bm = new C0000a() {
        public final void run() {
            super.run();
            try {
                a.this.setIndoorEnabled(this.c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };
    private Runnable bn = new Runnable() {
        public final void run() {
            if (a.this.c != null) {
                ej h = a.this.c.h();
                if (h != null) {
                    h.c();
                }
            }
        }
    };
    private C0000a bo = new C0000a() {
        public final void run() {
            super.run();
            a.this.f(this.g, this.c);
        }
    };
    private EAMapPlatformGestureInfo bp = new EAMapPlatformGestureInfo();
    /* access modifiers changed from: private */
    public ac bq = null;
    private IPoint[] br = null;
    eh c;
    final u d;
    protected final p e;
    final i f;
    protected MapConfig g = new MapConfig(true);
    protected ac h;
    CustomRenderer i;
    int j = -1;
    protected Context k;
    protected GLMapEngine l;
    h m;
    public int n;
    public int o;
    cw p;
    aj q;
    protected final Handler r = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message != null && !a.this.ag) {
                try {
                    a.this.s();
                    int i = message.what;
                    if (i != 2) {
                        boolean z = false;
                        switch (i) {
                            case 10:
                                CameraPosition cameraPosition = (CameraPosition) message.obj;
                                if (!(cameraPosition == null || a.this.L == null)) {
                                    a.this.L.onCameraChange(cameraPosition);
                                    break;
                                }
                            case 11:
                                try {
                                    CameraPosition cameraPosition2 = a.this.getCameraPosition();
                                    if (!(cameraPosition2 == null || a.this.c == null)) {
                                        a.this.c.a(cameraPosition2);
                                    }
                                    if (a.this.aQ) {
                                        boolean unused = a.this.aQ = false;
                                        if (a.this.d != null) {
                                            a.this.d.b(false);
                                        }
                                        a.this.q();
                                    }
                                    if (a.this.av) {
                                        a.this.k();
                                        boolean unused2 = a.this.av = false;
                                    }
                                    a.this.a(cameraPosition2);
                                    synchronized (a.this.W) {
                                        a.this.aG.get();
                                        int i2 = -1;
                                        if (a.this.l != null) {
                                            i2 = a.this.l.getAnimateionsCount();
                                        }
                                        if (a.this.aG.get() > 0 && i2 == 0) {
                                            try {
                                                AMap.CancelableCallback cancelableCallback = (AMap.CancelableCallback) a.this.aH.remove(Integer.valueOf(a.this.aG.decrementAndGet()));
                                                if (cancelableCallback != null) {
                                                    cancelableCallback.onFinish();
                                                }
                                            } catch (Throwable th) {
                                                th.printStackTrace();
                                            }
                                        }
                                        break;
                                    }
                                } catch (Throwable th2) {
                                    iu.b(th2, "AMapDelegateImp", "CameraUpdateFinish");
                                    break;
                                }
                            case 12:
                                if (a.this.c != null) {
                                    a.this.c.a(a.this.h());
                                    break;
                                }
                                break;
                            case 13:
                                if (a.this.c != null) {
                                    ee g = a.this.c.g();
                                    if (g != null) {
                                        g.b();
                                        break;
                                    } else {
                                        return;
                                    }
                                }
                                break;
                            case 14:
                                try {
                                    if (a.this.N != null) {
                                        a.this.N.onTouch((MotionEvent) message.obj);
                                        break;
                                    }
                                } catch (Throwable th3) {
                                    iu.b(th3, "AMapDelegateImp", "onTouchHandler");
                                    th3.printStackTrace();
                                    break;
                                }
                                break;
                            case 15:
                                Bitmap bitmap = (Bitmap) message.obj;
                                int i3 = message.arg1;
                                if (bitmap == null || a.this.c == null) {
                                    if (a.this.U != null) {
                                        a.this.U.onMapPrint((Drawable) null);
                                    }
                                    if (a.this.V != null) {
                                        a.this.V.onMapScreenShot((Bitmap) null);
                                        a.this.V.onMapScreenShot((Bitmap) null, i3);
                                    }
                                } else {
                                    Canvas canvas = new Canvas(bitmap);
                                    ej h = a.this.c.h();
                                    if (h != null) {
                                        h.onDraw(canvas);
                                    }
                                    a.this.c.a(canvas);
                                    if (a.this.U != null) {
                                        a.this.U.onMapPrint(new BitmapDrawable(a.this.k.getResources(), bitmap));
                                    }
                                    if (a.this.V != null) {
                                        a.this.V.onMapScreenShot(bitmap);
                                        a.this.V.onMapScreenShot(bitmap, i3);
                                    }
                                }
                                AMap.onMapPrintScreenListener unused3 = a.this.U = null;
                                AMap.OnMapScreenShotListener unused4 = a.this.V = null;
                                break;
                            case 16:
                                if (a.this.K != null) {
                                    try {
                                        a.this.K.onMapLoaded();
                                        break;
                                    } catch (Throwable th4) {
                                        iu.b(th4, "AMapDelegateImp", "onMapLoaded");
                                        th4.printStackTrace();
                                        break;
                                    }
                                }
                                break;
                            case 17:
                                if (a.this.l.isInMapAnimation(1) && a.this.d != null) {
                                    a.this.d.b(false);
                                }
                                if (a.this.d != null) {
                                    u uVar = a.this.d;
                                    if (message.arg1 != 0) {
                                        z = true;
                                    }
                                    uVar.a(z);
                                    break;
                                }
                                break;
                            case 18:
                                if (a.this.a != null) {
                                    ad d = a.this.a.d();
                                    if (d != null) {
                                        d.a_();
                                        break;
                                    }
                                }
                                break;
                            case 19:
                                if (a.this.M != null) {
                                    DPoint obtain = DPoint.obtain();
                                    a.this.b(message.arg1, message.arg2, obtain);
                                    try {
                                        a.this.M.onMapClick(new LatLng(obtain.y, obtain.x));
                                        obtain.recycle();
                                        break;
                                    } catch (Throwable th5) {
                                        iu.b(th5, "AMapDelegateImp", "OnMapClickListener.onMapClick");
                                        th5.printStackTrace();
                                        break;
                                    }
                                }
                                break;
                            case 20:
                                a.this.O.onPOIClick((Poi) message.obj);
                                break;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Key验证失败：[");
                        if (message.obj != null) {
                            sb.append(message.obj);
                        } else {
                            sb.append(ie.b);
                        }
                        sb.append("]");
                        sb.toString();
                    }
                } catch (Throwable th6) {
                    iu.b(th6, "AMapDelegateImp", "handleMessage");
                    th6.printStackTrace();
                    return;
                }
                a.this.s();
            }
        }
    };
    Point s = new Point();
    Rect t = new Rect();
    protected String u = null;
    float[] v = new float[16];
    float[] w = new float[16];
    float[] x = new float[16];
    float[] y = new float[12];
    String z = "precision highp float;\nattribute vec3 aVertex;//顶点数组,三维坐标\nuniform mat4 aMVPMatrix;//mvp矩阵\nvoid main(){\n  gl_Position = aMVPMatrix * vec4(aVertex, 1.0);\n}";

    /* renamed from: com.amap.api.col.n3.a$a  reason: collision with other inner class name */
    /* compiled from: AMapDelegateImp */
    private static abstract class C0000a implements Runnable {
        boolean b;
        boolean c;
        int d;
        int e;
        int f;
        int g;

        private C0000a() {
            this.b = false;
            this.c = false;
        }

        /* synthetic */ C0000a(byte b2) {
            this();
        }

        public void run() {
            this.b = false;
        }
    }

    /* compiled from: AMapDelegateImp */
    class b {
        b() {
        }

        public final void a(ac acVar) {
            if (a.this.g.isIndoorEnable()) {
                final ef e = a.this.c.e();
                if (acVar == null) {
                    try {
                        if (a.this.R != null) {
                            a.this.R.OnIndoorBuilding(acVar);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (a.this.h != null) {
                        a.this.h.g = null;
                    }
                    if (e.b()) {
                        a.this.r.post(new Runnable() {
                            public final void run() {
                                e.a(false);
                            }
                        });
                    }
                    a.this.g.maxZoomLevel = a.this.g.isSetLimitZoomLevel() ? a.this.g.getMaxZoomLevel() : 19.0f;
                    try {
                        if (a.this.ab.isZoomControlsEnabled()) {
                            a.this.aj.invalidateZoomController(a.this.g.getS_z());
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                if (a.this.h == null || !a.this.h.poiid.equals(acVar.poiid) || !e.b()) {
                    if (a.this.h == null || !a.this.h.poiid.equals(acVar.poiid) || a.this.h.g == null) {
                        a.this.h = acVar;
                        if (a.this.l != null) {
                            a.this.h.g = a.this.l.getMapCenter(1);
                        }
                    }
                    try {
                        if (a.this.R != null) {
                            a.this.R.OnIndoorBuilding(acVar);
                        }
                        a.this.g.maxZoomLevel = a.this.g.isSetLimitZoomLevel() ? a.this.g.getMaxZoomLevel() : 20.0f;
                        if (a.this.ab.isZoomControlsEnabled()) {
                            a.this.aj.invalidateZoomController(a.this.g.getS_z());
                        }
                        if (a.this.ab.isIndoorSwitchEnabled()) {
                            if (!e.b()) {
                                a.this.ab.setIndoorSwitchEnabled(true);
                            }
                            a.this.r.post(new Runnable() {
                                public final void run() {
                                    try {
                                        e.a(a.this.h.floor_names);
                                        e.a(a.this.h.activeFloorName);
                                        if (!e.b()) {
                                            e.a(true);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            });
                        } else if (!a.this.ab.isIndoorSwitchEnabled() && e.b()) {
                            a.this.ab.setIndoorSwitchEnabled(false);
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp */
    private class c implements ef.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final void a(int i) {
            if (a.this.h != null) {
                a.this.h.activeFloorIndex = a.this.h.floor_indexs[i];
                a.this.h.activeFloorName = a.this.h.floor_names[i];
                try {
                    a.this.setIndoorBuildingInfo(a.this.h);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* compiled from: AMapDelegateImp */
    private class d implements Runnable {
        private Context b;
        private AMap.OnCacheRemoveListener c;

        public d(Context context, AMap.OnCacheRemoveListener onCacheRemoveListener) {
            this.b = context;
            this.c = onCacheRemoveListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:30:0x0062 A[Catch:{ Throwable -> 0x007a }] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[Catch:{ Throwable -> 0x007a }] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x0085 A[Catch:{ Throwable -> 0x009d }] */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[Catch:{ Throwable -> 0x009d }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r10 = this;
                r0 = 0
                r1 = 1
                android.content.Context r2 = r10.b     // Catch:{ Throwable -> 0x0054 }
                android.content.Context r2 = r2.getApplicationContext()     // Catch:{ Throwable -> 0x0054 }
                java.lang.String r3 = com.amap.api.col.n3.dv.b((android.content.Context) r2)     // Catch:{ Throwable -> 0x0054 }
                java.lang.String r2 = com.amap.api.col.n3.dv.a((android.content.Context) r2)     // Catch:{ Throwable -> 0x0054 }
                java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x0054 }
                r4.<init>(r3)     // Catch:{ Throwable -> 0x0054 }
                boolean r3 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r4)     // Catch:{ Throwable -> 0x0054 }
                if (r3 == 0) goto L_0x002f
                java.io.File r4 = new java.io.File     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                r4.<init>(r2)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                boolean r2 = com.autonavi.amap.mapcore.FileUtil.deleteFile(r4)     // Catch:{ Throwable -> 0x002b, all -> 0x0028 }
                if (r2 == 0) goto L_0x002f
                r0 = r1
                goto L_0x002f
            L_0x0028:
                r0 = move-exception
                r1 = r3
                goto L_0x007f
            L_0x002b:
                r1 = move-exception
                r2 = r1
                r1 = r3
                goto L_0x0055
            L_0x002f:
                com.amap.api.col.n3.a r1 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x004d }
                com.autonavi.ae.gmap.GLMapEngine r1 = r1.l     // Catch:{ Throwable -> 0x004d }
                if (r1 == 0) goto L_0x0043
                com.amap.api.col.n3.a r1 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x004d }
                com.autonavi.ae.gmap.GLMapEngine r2 = r1.l     // Catch:{ Throwable -> 0x004d }
                r3 = 1
                r4 = 2601(0xa29, float:3.645E-42)
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 0
                r2.setParamater(r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x004d }
            L_0x0043:
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r10.c     // Catch:{ Throwable -> 0x004d }
                if (r1 == 0) goto L_0x004c
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r10.c     // Catch:{ Throwable -> 0x004d }
                r1.onRemoveCacheFinish(r0)     // Catch:{ Throwable -> 0x004d }
            L_0x004c:
                return
            L_0x004d:
                r0 = move-exception
                r0.printStackTrace()
                return
            L_0x0052:
                r0 = move-exception
                goto L_0x007f
            L_0x0054:
                r2 = move-exception
            L_0x0055:
                java.lang.String r3 = "AMapDelegateImp"
                java.lang.String r4 = "RemoveCacheRunnable"
                com.amap.api.col.n3.iu.b((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0052 }
                com.amap.api.col.n3.a r1 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x007a }
                com.autonavi.ae.gmap.GLMapEngine r1 = r1.l     // Catch:{ Throwable -> 0x007a }
                if (r1 == 0) goto L_0x0070
                com.amap.api.col.n3.a r1 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x007a }
                com.autonavi.ae.gmap.GLMapEngine r2 = r1.l     // Catch:{ Throwable -> 0x007a }
                r3 = 1
                r4 = 2601(0xa29, float:3.645E-42)
                r5 = 1
                r6 = 0
                r7 = 0
                r8 = 0
                r2.setParamater(r3, r4, r5, r6, r7, r8)     // Catch:{ Throwable -> 0x007a }
            L_0x0070:
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r10.c     // Catch:{ Throwable -> 0x007a }
                if (r1 == 0) goto L_0x0079
                com.amap.api.maps.AMap$OnCacheRemoveListener r1 = r10.c     // Catch:{ Throwable -> 0x007a }
                r1.onRemoveCacheFinish(r0)     // Catch:{ Throwable -> 0x007a }
            L_0x0079:
                return
            L_0x007a:
                r0 = move-exception
                r0.printStackTrace()
                return
            L_0x007f:
                com.amap.api.col.n3.a r2 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x009d }
                com.autonavi.ae.gmap.GLMapEngine r2 = r2.l     // Catch:{ Throwable -> 0x009d }
                if (r2 == 0) goto L_0x0093
                com.amap.api.col.n3.a r2 = com.amap.api.col.n3.a.this     // Catch:{ Throwable -> 0x009d }
                com.autonavi.ae.gmap.GLMapEngine r3 = r2.l     // Catch:{ Throwable -> 0x009d }
                r4 = 1
                r5 = 2601(0xa29, float:3.645E-42)
                r6 = 1
                r7 = 0
                r8 = 0
                r9 = 0
                r3.setParamater(r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x009d }
            L_0x0093:
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r10.c     // Catch:{ Throwable -> 0x009d }
                if (r2 == 0) goto L_0x00a1
                com.amap.api.maps.AMap$OnCacheRemoveListener r2 = r10.c     // Catch:{ Throwable -> 0x009d }
                r2.onRemoveCacheFinish(r1)     // Catch:{ Throwable -> 0x009d }
                goto L_0x00a1
            L_0x009d:
                r1 = move-exception
                r1.printStackTrace()
            L_0x00a1:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.d.run():void");
        }

        public final boolean equals(Object obj) {
            return obj instanceof d;
        }
    }

    public final boolean b() {
        return false;
    }

    public final void clearException(int i2) {
    }

    public final String getSatelliteImageApprovalNumber() {
        return "GS（2017）1898";
    }

    public final int o() {
        return 0;
    }

    public final void onException(int i2, int i3) {
    }

    public final void reloadMap() {
    }

    public final void setZOrderOnTop(boolean z2) throws RemoteException {
    }

    public final void a(MapWidgetListener mapWidgetListener) {
        this.aj = mapWidgetListener;
    }

    public final void setVisibilityEx(int i2) {
        if (this.ad != null) {
            try {
                this.ad.setVisibility(i2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void onActivityPause() {
        this.ak = true;
        o(this.af);
    }

    public final void onActivityResume() {
        this.ak = false;
        int i2 = this.af;
        if (i2 == 0) {
            i2 = this.l.getEngineIDWithType(0);
        }
        p(i2);
    }

    public final void queueEvent(Runnable runnable) {
        this.ad.queueEvent(runnable);
    }

    public a(l lVar, Context context) {
        final int i2;
        this.k = context;
        AEUtil.init(this.k);
        g.b = id.c(context);
        dc.a(this.k);
        this.m = new h(this);
        this.l = new GLMapEngine(this.k, this);
        this.aJ = new GLMapRender(this);
        this.ad = lVar;
        lVar.setRenderer(this.aJ);
        Rect rect = new Rect(0, 0, this.n, this.o);
        final int i3 = this.n;
        final int i4 = this.o;
        if (this.l != null) {
            i2 = this.l.getEngineIDWithType(0);
            if (!this.l.isEngineCreated(i2)) {
                this.l.createEngineWithFrame(i2, rect, i3, i4);
                this.l.setOvelayBundle(i2, new GLOverlayBundle(i2, this));
                if (i2 == 2) {
                    queueEvent(new Runnable() {
                        final /* synthetic */ int b = -1;
                        final /* synthetic */ boolean c = false;

                        public final void run() {
                            if (a.this.l != null) {
                                a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_CONTENT, this.b, this.c ? 1 : 0, 0, 0);
                            }
                        }
                    });
                    r(i2);
                }
                this.l.setMapAngle(i2, this.g.getS_r());
                this.l.setMapZoom(i2, this.g.getS_z());
                this.l.setMapCenter(i2, this.g.getS_x(), this.g.getS_y());
                this.l.setCameraDegree(i2, this.g.getS_c());
            } else {
                final int i5 = rect.left;
                final int i6 = rect.top;
                final int width = rect.width();
                final int height = rect.height();
                final int i7 = i2;
                AnonymousClass27 r3 = new Runnable() {
                    public final void run() {
                        if (a.this.l != null) {
                            a.this.l.setServiceViewRect(i7, i5, i6, width, height, i3, i4);
                        }
                    }
                };
                queueEvent(r3);
            }
        } else {
            i2 = 0;
        }
        this.af = i2;
        this.ab = new v(this);
        this.c = new eh(this.k, this);
        this.c.e().a((ef.a) new c(this, (byte) 0));
        this.bc = new b();
        this.f = new i(this);
        this.d = new u(this.k, this);
        Context context2 = this.k;
        this.e = new p(this);
        this.l.setMapCoreListener(this);
        this.ad.setRenderMode(0);
        this.aN = false;
        this.aJ.setRenderFps(15.0f);
        this.l.setMapListener(this);
        this.aa = new s(this);
        this.T = new e(this);
        this.Y = new cs(this, context);
        this.a = new ae(this.k);
        this.a.a((ad) this.c);
        this.a.b((ad) this.Y);
        this.aE = new q();
        this.aA = new f(this.k, this);
        this.ao = new af(this.k);
        this.q = new aj(this);
        this.p = new cw();
    }

    public final GLMapEngine a() {
        return this.l;
    }

    public final void a(int i2) {
        if (this.aZ == 0 || i2 != 5) {
            this.aZ = i2;
        }
    }

    public final void a(final int i2, final boolean z2) {
        if (c(i2, 2) != z2) {
            if (!this.aT || !this.aU || !this.b) {
                this.be.c = z2;
                this.be.b = true;
                this.be.g = i2;
                return;
            }
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        a.this.a(i2, 2, z2);
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SETTRAFFICTEXTURE, z2 ^ true ? 1 : 0, 0, 0, 0);
                        a.this.resetRenderTimeLong();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public final float b(int i2) {
        if (this.aT) {
            return this.l.getMapZoomer(i2);
        }
        return 0.0f;
    }

    private float n(int i2) {
        if (this.aT) {
            return this.l.getMapZoomer(i2);
        }
        if (this.g != null) {
            return getMapConfig().getS_z();
        }
        return 0.0f;
    }

    private boolean a(int i2, int i3, int i4) {
        CameraUpdateMessage cameraUpdateMessage;
        if (!this.aT || ((int) n(i2)) >= this.l.getMaxZoomLevel(i2)) {
            return false;
        }
        try {
            if (this.al || this.ab.isZoomInByScreenCenter()) {
                cameraUpdateMessage = z.a(1.0f, (Point) null);
            } else {
                this.s.x = i3;
                this.s.y = i4;
                cameraUpdateMessage = z.a(1.0f, this.s);
            }
            b(cameraUpdateMessage);
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "onDoubleTap");
            th.printStackTrace();
        }
        s();
        return true;
    }

    public final void c(int i2) {
        if (this.aT && ((int) n(i2)) > this.l.getMinZoomLevel(i2)) {
            try {
                b(z.b());
            } catch (Throwable th) {
                iu.b(th, "AMapDelegateImp", "onDoubleTap");
                th.printStackTrace();
            }
            s();
        }
    }

    public final boolean d(int i2) {
        return c(i2, 6);
    }

    public final GLMapState c() {
        if (this.l != null) {
            return this.l.getMapState(1);
        }
        return null;
    }

    public final int d() {
        return this.C;
    }

    public final int e() {
        return this.D;
    }

    public final int f() {
        return this.E;
    }

    public final void a(Location location) throws RemoteException {
        if (location != null) {
            try {
                if (this.ae) {
                    if (this.ao != null) {
                        if (this.an == null && this.an == null) {
                            this.an = new co(this, this.k);
                        }
                        if (!(location.getLongitude() == 0.0d || location.getLatitude() == 0.0d)) {
                            this.an.a(location);
                        }
                        if (this.S != null) {
                            this.S.onMyLocationChange(location);
                        }
                        s();
                        return;
                    }
                }
                if (this.an != null) {
                    this.an.b();
                }
                this.an = null;
            } catch (Throwable th) {
                iu.b(th, "AMapDelegateImp", "showMyLocationOverlay");
                th.printStackTrace();
            }
        }
    }

    public final boolean a(String str) throws RemoteException {
        s();
        return this.f.c(str);
    }

    public final void g() {
        this.f.b();
    }

    public final void a(double d2, double d3, IPoint iPoint) {
        GLMapState.lonlat2Geo(d3, d2, iPoint);
    }

    public final void a(int i2, int i3, FPoint fPoint) {
        this.l.p20ToMapPoint(1, i3, i2, fPoint);
    }

    public final void a(int i2, int i3, DPoint dPoint) {
        GLMapState.geo2LonLat(i2, i3, dPoint);
    }

    public final float h() {
        return n(this.af);
    }

    public final n i() {
        return this.ab;
    }

    public final void a(cf cfVar) throws RemoteException {
        if (cfVar != null && this.a != null) {
            try {
                ad d2 = this.a.d();
                if (d2 != null) {
                    d2.a(cfVar);
                }
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void j() {
        if (this.a != null) {
            ad d2 = this.a.d();
            if (d2 != null) {
                d2.b_();
            }
        }
    }

    public final void a(double d2, double d3, FPoint fPoint) {
        if (this.aT && this.l != null) {
            Point LatLongToPixels = VirtualEarthProjection.LatLongToPixels(d2, d3, 20);
            this.l.p20ToMapPoint(1, LatLongToPixels.x, LatLongToPixels.y, fPoint);
        }
    }

    public final void b(int i2, int i3, DPoint dPoint) {
        if (this.aT && this.l != null) {
            Point point = new Point();
            this.l.screenToP20Point(1, (float) i2, (float) i3, point);
            DPoint PixelsToLatLong = VirtualEarthProjection.PixelsToLatLong((long) point.x, (long) point.y, 20);
            dPoint.x = PixelsToLatLong.x;
            dPoint.y = PixelsToLatLong.y;
            PixelsToLatLong.recycle();
        }
    }

    private void a(GLMapState gLMapState, int i2, int i3, DPoint dPoint) {
        if (this.aT && this.l != null) {
            Point point = new Point();
            gLMapState.screenToP20Point((float) i2, (float) i3, point);
            DPoint PixelsToLatLong = VirtualEarthProjection.PixelsToLatLong((long) point.x, (long) point.y, 20);
            dPoint.x = PixelsToLatLong.x;
            dPoint.y = PixelsToLatLong.y;
            PixelsToLatLong.recycle();
        }
    }

    public final void b(double d2, double d3, IPoint iPoint) {
        if (this.aT && this.l != null) {
            try {
                Point LatLongToPixels = VirtualEarthProjection.LatLongToPixels(d2, d3, 20);
                FPoint obtain = FPoint.obtain();
                this.l.p20ToScreenPoint(1, LatLongToPixels.x, LatLongToPixels.y, obtain);
                if (obtain.x == -10000.0f && obtain.y == -10000.0f) {
                    GLMapState newMapState = this.l.getNewMapState(1);
                    newMapState.setCameraDegree(0.0f);
                    newMapState.recalculate();
                    newMapState.p20ToScreenPoint(LatLongToPixels.x, LatLongToPixels.y, obtain);
                    newMapState.recycle();
                }
                iPoint.x = (int) obtain.x;
                iPoint.y = (int) obtain.y;
                obtain.recycle();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(int i2, int i3, IPoint iPoint) {
        if (this.aT && this.l != null) {
            this.l.screenToP20Point(1, (float) i2, (float) i3, iPoint);
        }
    }

    public final void k() {
        if (this.aT) {
            this.r.sendEmptyMessage(18);
        }
    }

    public final void a(boolean z2) {
        if (!this.ag && this.c != null) {
            this.c.b(z2);
        }
    }

    public final void b(boolean z2) {
        if (!this.ag && this.c != null) {
            this.c.a(z2);
        }
    }

    public final void c(boolean z2) {
        if (!this.ag && this.c != null) {
            this.c.c(z2);
        }
    }

    public final void d(boolean z2) {
        if (!this.ag && this.c != null) {
            this.c.d(z2);
        }
    }

    public final void e(boolean z2) {
        if (!this.ag && this.c != null) {
            this.c.e(z2);
        }
    }

    public final void e(int i2) {
        if (!this.ag && this.c != null) {
            this.c.a(i2);
        }
    }

    public final LatLngBounds a(LatLng latLng, float f2) {
        LatLng latLng2 = latLng;
        int mapWidth = getMapWidth();
        int mapHeight = getMapHeight();
        if (mapWidth <= 0 || mapHeight <= 0 || this.ag) {
            return null;
        }
        float a2 = dv.a(this.g, f2);
        GLMapState gLMapState = new GLMapState(1, this.l.getMapEnginePtr());
        if (latLng2 != null) {
            IPoint obtain = IPoint.obtain();
            GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain);
            gLMapState.setCameraDegree(0.0f);
            gLMapState.setMapAngle(0.0f);
            gLMapState.setMapGeoCenter(obtain.x, obtain.y);
            gLMapState.setMapZoomer(a2);
            gLMapState.recalculate();
            obtain.recycle();
        }
        DPoint obtain2 = DPoint.obtain();
        a(gLMapState, 0, 0, obtain2);
        LatLng latLng3 = new LatLng(obtain2.y, obtain2.x, false);
        a(gLMapState, mapWidth, mapHeight, obtain2);
        LatLng latLng4 = new LatLng(obtain2.y, obtain2.x, false);
        obtain2.recycle();
        gLMapState.recycle();
        return LatLngBounds.builder().include(latLng4).include(latLng3).build();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ak || !this.aT || !this.aO) {
            return false;
        }
        this.bp.mGestureState = 3;
        this.bp.mGestureType = 8;
        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.bp;
        eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
        final int a2 = a(this.bp);
        if (this.aJ != null) {
            this.aJ.resetTickCount(2);
        }
        switch (motionEvent.getAction() & 255) {
            case 0:
                A();
                if (this.aT) {
                    this.m.a();
                    this.aK = true;
                    this.aP = true;
                    try {
                        stopAnimation();
                    } catch (RemoteException unused) {
                    }
                    queueEvent(new Runnable() {
                        public final void run() {
                            try {
                                a.this.l.clearAllMessages(a2);
                                a.this.l.setParamater(a2, 4001, 1, 0, 0, 0);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                    break;
                }
                break;
            case 1:
                this.aK = true;
                this.aP = false;
                if (this.at) {
                    this.at = false;
                }
                if (this.as) {
                    this.as = false;
                }
                if (this.au) {
                    this.au = false;
                }
                this.ap = false;
                if (!(this.J == null || this.aq == null)) {
                    try {
                        this.J.onMarkerDragEnd(this.aq);
                    } catch (Throwable th) {
                        iu.b(th, "AMapDelegateImp", "OnMarkerDragListener.onMarkerDragEnd");
                        th.printStackTrace();
                    }
                    this.aq = null;
                }
                queueEvent(new Runnable() {
                    public final void run() {
                        try {
                            a.this.l.setParamater(a2, 4001, 0, 0, 0, 0);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                this.ad.postDelayed(new Runnable() {
                    public final void run() {
                        int unused = a.this.aR = 1;
                    }
                }, 300);
                break;
        }
        if (motionEvent.getAction() != 2 || !this.ap) {
            if (this.aK) {
                try {
                    this.m.a(motionEvent);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            if (this.N != null) {
                this.r.removeMessages(14);
                Message obtainMessage = this.r.obtainMessage();
                obtainMessage.what = 14;
                obtainMessage.obj = MotionEvent.obtain(motionEvent);
                obtainMessage.sendToTarget();
            }
            return true;
        }
        try {
            if (!(!this.ap || this.aq == null || this.ar == null)) {
                LatLng b2 = this.ar.b();
                LatLng position = this.ar.getPosition();
                DPoint obtain = DPoint.obtain();
                b((int) motionEvent.getX(), (int) (motionEvent.getY() - 60.0f), obtain);
                LatLng latLng = new LatLng((position.latitude + obtain.y) - b2.latitude, (position.longitude + obtain.x) - b2.longitude);
                obtain.recycle();
                this.aq.setPosition(latLng);
                if (this.J != null) {
                    this.J.onMarkerDrag(this.aq);
                }
            }
        } catch (Throwable th3) {
            iu.b(th3, "AMapDelegateImp", "onDragMarker");
            th3.printStackTrace();
        }
        return true;
    }

    public final void a(int i2, int i3, PointF pointF) {
        if (this.aT && !this.ak && this.l != null) {
            this.l.screenToMapGPoint(1, (float) i2, (float) i3, pointF);
        }
    }

    public final void a(float f2, float f3, IPoint iPoint) {
        if (this.aT && !this.ak && this.l != null) {
            this.l.mapToP20Point(1, f2, f3, iPoint);
        }
    }

    public final float f(int i2) {
        if (!this.aT || this.ak || this.l == null) {
            return 0.0f;
        }
        return this.l.getMapState(1).getGLUnitWithWin(i2);
    }

    private CameraPosition g(boolean z2) {
        LatLng latLng;
        DPoint dPoint;
        LatLng latLng2;
        try {
            if (!this.aT || this.ak || this.l == null) {
                DPoint obtain = DPoint.obtain();
                GLMapState.geo2LonLat(this.g.getS_x(), this.g.getS_y(), obtain);
                LatLng latLng3 = new LatLng(obtain.y, obtain.x);
                obtain.recycle();
                return CameraPosition.builder().target(latLng3).bearing(this.g.getS_r()).tilt(this.g.getS_c()).zoom(this.g.getS_z()).build();
            }
            if (z2) {
                DPoint obtain2 = DPoint.obtain();
                b(this.g.getAnchorX(), this.g.getAnchorY(), obtain2);
                latLng = new LatLng(obtain2.y, obtain2.x, false);
                obtain2.recycle();
            } else {
                if (this.aT && this.l != null) {
                    GLMapState mapState = this.l.getMapState(1);
                    if (mapState != null) {
                        Point mapGeoCenter = mapState.getMapGeoCenter();
                        dPoint = VirtualEarthProjection.PixelsToLatLong((long) mapGeoCenter.x, (long) mapGeoCenter.y, 20);
                        latLng2 = new LatLng(dPoint.y, dPoint.x, false);
                        dPoint.recycle();
                        latLng = latLng2;
                    }
                }
                dPoint = VirtualEarthProjection.PixelsToLatLong((long) this.g.getS_x(), (long) this.g.getS_y(), 20);
                latLng2 = new LatLng(dPoint.y, dPoint.x, false);
                dPoint.recycle();
                latLng = latLng2;
            }
            return CameraPosition.builder().target(latLng).bearing(this.l.getMapAngle(1)).tilt(this.l.getCameraDegree(1)).zoom(this.l.getMapZoomer(1)).build();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Point l() {
        if (this.c != null) {
            return this.c.c();
        }
        return new Point();
    }

    public final View m() {
        if (this.ad instanceof View) {
            return (View) this.ad;
        }
        return null;
    }

    public final boolean n() {
        if (this.l == null || this.l.getMapZoomer(1) < 17.0f || this.h == null || this.h.g == null) {
            return false;
        }
        FPoint obtain = FPoint.obtain();
        int i2 = this.h.g.x;
        int i3 = this.h.g.y;
        if (this.aT && this.l != null) {
            this.l.p20ToScreenPoint(1, i2, i3, obtain);
        }
        if (this.ax.contains((int) obtain.x, (int) obtain.y)) {
            return true;
        }
        return false;
    }

    private synchronized void x() {
        synchronized (this.aI) {
            int size = this.aI.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.aI.get(i2).e().recycle();
            }
            this.aI.clear();
        }
    }

    public final void a(r rVar) {
        if (rVar != null && rVar.f() != 0) {
            synchronized (this.aI) {
                this.aI.add(rVar);
            }
        }
    }

    public final void b(String str) {
        synchronized (this.aI) {
            int size = this.aI.size();
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                } else if (this.aI.get(i3).j().equals(str)) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i2 >= 0) {
                this.aI.remove(i2);
            }
        }
    }

    public final r a(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return null;
        }
        synchronized (this.aI) {
            for (int i2 = 0; i2 < this.aI.size(); i2++) {
                r rVar = this.aI.get(i2);
                if (rVar.e().equals(bitmapDescriptor)) {
                    return rVar;
                }
            }
            return null;
        }
    }

    public final void g(int i2) {
        if (this.c != null) {
            this.c.b(i2);
        }
    }

    public final void h(int i2) {
        if (this.c != null) {
            this.c.c(i2);
        }
    }

    public final void i(int i2) {
        if (this.c != null) {
            this.c.d(i2);
        }
    }

    public final float j(int i2) {
        if (this.c != null) {
            return this.c.e(i2);
        }
        return 0.0f;
    }

    public final void a(int i2, float f2) {
        if (this.c != null) {
            this.c.a(i2, f2);
        }
    }

    public final int p() {
        return this.aF;
    }

    private void a(Runnable runnable) {
        if (this.ad != null) {
            this.ad.post(runnable);
        }
    }

    public final void a(final int i2, MotionEvent motionEvent) {
        try {
            this.as = false;
            queueEvent(new Runnable() {
                public final void run() {
                    if (a.this.aT && a.this.l != null) {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_CLEAN_SELECTED_SUBWAY, 0, 0, 0, 0);
                    }
                }
            });
            this.ar = this.e.a(motionEvent);
            if (this.ar != null && this.ar.isDraggable()) {
                this.aq = new Marker(this.ar);
                LatLng position = this.aq.getPosition();
                LatLng b2 = this.ar.b();
                IPoint obtain = IPoint.obtain();
                b(b2.latitude, b2.longitude, obtain);
                obtain.y -= 60;
                DPoint obtain2 = DPoint.obtain();
                b(obtain.x, obtain.y, obtain2);
                this.aq.setPosition(new LatLng((position.latitude + obtain2.y) - b2.latitude, (position.longitude + obtain2.x) - b2.longitude));
                this.e.a(this.ar);
                if (this.J != null) {
                    this.J.onMarkerDragStart(this.aq);
                }
                this.ap = true;
                obtain.recycle();
                obtain2.recycle();
            } else if (this.P != null) {
                DPoint obtain3 = DPoint.obtain();
                b((int) motionEvent.getX(), (int) motionEvent.getY(), obtain3);
                this.P.onMapLongClick(new LatLng(obtain3.y, obtain3.x));
                this.at = true;
                obtain3.recycle();
            }
            this.aJ.resetTickCount(30);
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "onLongPress");
            th.printStackTrace();
        }
    }

    public final boolean b(int i2, MotionEvent motionEvent) {
        if (!this.aT) {
            return false;
        }
        a(i2, (int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0047 A[Catch:{ Throwable -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0068 A[Catch:{ Throwable -> 0x00a7 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0069 A[Catch:{ Throwable -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(final android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.aT
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            com.amap.api.col.n3.ae r2 = r7.a     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x0038
            com.amap.api.col.n3.ae r2 = r7.a     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.col.n3.ad r2 = r2.d()     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x0018
            boolean r2 = r2.a((android.view.MotionEvent) r8)     // Catch:{ Throwable -> 0x00a7 }
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            if (r2 == 0) goto L_0x0038
            com.amap.api.maps.AMap$OnInfoWindowClickListener r2 = r7.Q     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x0036
            com.amap.api.col.n3.p r2 = r7.e     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.col.n3.cf r2 = r2.c()     // Catch:{ Throwable -> 0x00a7 }
            boolean r3 = r2.isVisible()     // Catch:{ Throwable -> 0x00a7 }
            if (r3 != 0) goto L_0x002c
            goto L_0x0036
        L_0x002c:
            com.amap.api.maps.model.Marker r3 = new com.amap.api.maps.model.Marker     // Catch:{ Throwable -> 0x00a7 }
            r3.<init>(r2)     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.maps.AMap$OnInfoWindowClickListener r2 = r7.Q     // Catch:{ Throwable -> 0x00a7 }
            r2.onInfoWindowClick(r3)     // Catch:{ Throwable -> 0x00a7 }
        L_0x0036:
            r2 = r0
            goto L_0x0039
        L_0x0038:
            r2 = r1
        L_0x0039:
            if (r2 == 0) goto L_0x003c
            return r0
        L_0x003c:
            boolean r2 = r7.b((android.view.MotionEvent) r8)     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x0043
            return r0
        L_0x0043:
            com.amap.api.col.n3.aj r2 = r7.q     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x0066
            com.autonavi.amap.mapcore.IPoint r1 = com.autonavi.amap.mapcore.IPoint.obtain()     // Catch:{ Throwable -> 0x00a7 }
            com.autonavi.ae.gmap.GLMapEngine r2 = r7.l     // Catch:{ Throwable -> 0x00a7 }
            if (r2 == 0) goto L_0x005c
            float r2 = r8.getX()     // Catch:{ Throwable -> 0x00a7 }
            int r2 = (int) r2     // Catch:{ Throwable -> 0x00a7 }
            float r3 = r8.getY()     // Catch:{ Throwable -> 0x00a7 }
            int r3 = (int) r3     // Catch:{ Throwable -> 0x00a7 }
            r7.a((int) r2, (int) r3, (com.autonavi.amap.mapcore.IPoint) r1)     // Catch:{ Throwable -> 0x00a7 }
        L_0x005c:
            com.amap.api.col.n3.aj r2 = r7.q     // Catch:{ Throwable -> 0x00a7 }
            boolean r2 = r2.a((com.autonavi.amap.mapcore.IPoint) r1)     // Catch:{ Throwable -> 0x00a7 }
            r1.recycle()     // Catch:{ Throwable -> 0x00a7 }
            r1 = r2
        L_0x0066:
            if (r1 == 0) goto L_0x0069
            return r0
        L_0x0069:
            com.amap.api.maps.AMap$OnPolylineClickListener r1 = r7.I     // Catch:{ Throwable -> 0x00a7 }
            if (r1 == 0) goto L_0x009e
            com.autonavi.amap.mapcore.DPoint r1 = com.autonavi.amap.mapcore.DPoint.obtain()     // Catch:{ Throwable -> 0x00a7 }
            float r2 = r8.getX()     // Catch:{ Throwable -> 0x00a7 }
            int r2 = (int) r2     // Catch:{ Throwable -> 0x00a7 }
            float r3 = r8.getY()     // Catch:{ Throwable -> 0x00a7 }
            int r3 = (int) r3     // Catch:{ Throwable -> 0x00a7 }
            r7.b((int) r2, (int) r3, (com.autonavi.amap.mapcore.DPoint) r1)     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.maps.model.LatLng r2 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x00a7 }
            double r3 = r1.y     // Catch:{ Throwable -> 0x00a7 }
            double r5 = r1.x     // Catch:{ Throwable -> 0x00a7 }
            r2.<init>(r3, r5)     // Catch:{ Throwable -> 0x00a7 }
            r1.recycle()     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.col.n3.i r1 = r7.f     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.col.n3.ch r1 = r1.a((com.amap.api.maps.model.LatLng) r2)     // Catch:{ Throwable -> 0x00a7 }
            if (r1 == 0) goto L_0x009e
            com.amap.api.maps.AMap$OnPolylineClickListener r2 = r7.I     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.maps.model.Polyline r3 = new com.amap.api.maps.model.Polyline     // Catch:{ Throwable -> 0x00a7 }
            com.amap.api.col.n3.ck r1 = (com.amap.api.col.n3.ck) r1     // Catch:{ Throwable -> 0x00a7 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x00a7 }
            r2.onPolylineClick(r3)     // Catch:{ Throwable -> 0x00a7 }
        L_0x009e:
            com.amap.api.col.n3.a$10 r1 = new com.amap.api.col.n3.a$10     // Catch:{ Throwable -> 0x00a7 }
            r1.<init>(r8)     // Catch:{ Throwable -> 0x00a7 }
            r7.queueEvent(r1)     // Catch:{ Throwable -> 0x00a7 }
            return r0
        L_0x00a7:
            r8 = move-exception
            java.lang.String r1 = "AMapDelegateImp"
            java.lang.String r2 = "onSingleTapUp"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r8, (java.lang.String) r1, (java.lang.String) r2)
            r8.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.a(android.view.MotionEvent):boolean");
    }

    private boolean b(MotionEvent motionEvent) throws RemoteException {
        if (!this.e.b(motionEvent)) {
            return false;
        }
        cf c2 = this.e.c();
        if (c2 == null) {
            return true;
        }
        try {
            Marker marker = new Marker(c2);
            if (this.H == null || (!this.H.onMarkerClick(marker) && this.e.f() > 0)) {
                a(c2);
                if (!c2.g()) {
                    LatLng b2 = c2.b();
                    if (b2 != null) {
                        IPoint obtain = IPoint.obtain();
                        GLMapState.lonlat2Geo(b2.longitude, b2.latitude, obtain);
                        a(z.a((Point) obtain));
                    }
                }
                this.e.a(c2);
                return true;
            }
            this.e.a(c2);
            return true;
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "onMarkerTap");
            th.printStackTrace();
            return false;
        }
    }

    public final void drawFrame(GL10 gl10) {
        float f2;
        GLMapRender gLMapRender;
        if (!this.ag) {
            if (this.j != -1) {
                this.aJ.setRenderFps((float) this.j);
                s();
            } else {
                if (this.l.isInMapAction(1) || this.aP) {
                    gLMapRender = this.aJ;
                    f2 = 40.0f;
                } else if (this.l.isInMapAnimation(1)) {
                    this.aJ.setRenderFps(30.0f);
                    this.aJ.resetTickCount(15);
                } else if (this.aN) {
                    gLMapRender = this.aJ;
                    f2 = 10.0f;
                } else {
                    gLMapRender = this.aJ;
                    f2 = 15.0f;
                }
                gLMapRender.setRenderFps(f2);
            }
            GLES20.glClearColor(0.9453125f, 0.93359f, 0.9101f, 1.0f);
            GLES20.glClear(16640);
            this.l.drawFrame();
            this.l.pushRendererState();
            if (this.aw) {
                boolean canStopMapRender = this.l.canStopMapRender(1);
                Message obtainMessage = this.r.obtainMessage(15, dv.a(getMapWidth(), getMapHeight()));
                obtainMessage.arg1 = canStopMapRender ? 1 : 0;
                obtainMessage.sendToTarget();
                this.aw = false;
            }
            final ed d2 = this.c.d();
            if (!(d2 == null || d2.getVisibility() == 8)) {
                if (!this.am) {
                    this.r.sendEmptyMessage(16);
                    this.am = true;
                    q();
                }
                this.r.post(new Runnable() {
                    public final void run() {
                        if (!a.this.ak) {
                            try {
                                if (a.this.h != null) {
                                    a.this.setIndoorBuildingInfo(a.this.h);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            d2.a();
                        }
                    }
                });
            }
            if (!this.aW) {
                this.aW = true;
                a((Runnable) new Runnable() {
                    public final void run() {
                        if (a.this.ai != null) {
                            a.this.ai.onDrawFrameFirst(1);
                        }
                    }
                });
            }
            if (this.i != null) {
                this.i.onDrawFrame(gl10);
            }
            this.l.popRendererState();
        }
    }

    private void y() {
        if (this.g.getMapRect() == null || this.aC) {
            z();
            this.aC = false;
        }
        GLMapState mapState = this.l.getMapState(1);
        if (mapState != null) {
            Point mapGeoCenter = mapState.getMapGeoCenter();
            this.g.setS_x(mapGeoCenter.x);
            this.g.setS_y(mapGeoCenter.y);
            this.g.setS_z(mapState.getMapZoomer());
            this.g.setS_c(mapState.getCameraDegree());
            this.g.setS_r(mapState.getMapAngle());
            if (this.g.isMapStateChange()) {
                DPoint PixelsToLatLong = VirtualEarthProjection.PixelsToLatLong((long) mapGeoCenter.x, (long) mapGeoCenter.y, 20);
                LatLng latLng = new LatLng(PixelsToLatLong.y, PixelsToLatLong.x, false);
                CameraPosition cameraPosition = new CameraPosition(latLng, this.g.getS_z(), this.g.getS_c(), this.g.getS_r());
                PixelsToLatLong.recycle();
                Message obtainMessage = this.r.obtainMessage();
                obtainMessage.what = 10;
                obtainMessage.obj = cameraPosition;
                this.r.sendMessage(obtainMessage);
                this.aQ = true;
                k();
                z();
                try {
                    if (this.ab.isZoomControlsEnabled() && this.g.isNeedUpdateZoomControllerState()) {
                        this.aj.invalidateZoomController(this.g.getS_z());
                    }
                    if (this.g.getChangeGridRatio() != 1.0d) {
                        q();
                    }
                    if (this.ab.isCompassEnabled() && (this.g.isTiltChanged() || this.g.isBearingChanged())) {
                        this.aj.invalidateCompassView();
                    }
                    if (this.ab.isScaleControlsEnabled()) {
                        this.aj.invalidateScaleView();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } else if (!this.aP && this.l.getAnimateionsCount() == 0 && this.l.getStateMessageCount() == 0) {
                onChangeFinish();
            }
        }
    }

    private void z() {
        try {
            this.g.setMapRect(dv.a((k) this));
            GLMapState mapState = this.l.getMapState(1);
            if (mapState != null) {
                mapState.getPixel20Bound(this.t);
                this.g.getGeoRectangle().updateRect(this.t, this.g.getS_x(), this.g.getS_y());
                this.g.setMapPerPixelUnitLength(mapState.getGLUnitWithWin(1));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public final void q() {
        this.r.obtainMessage(17, 1, 0).sendToTarget();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00dc A[Catch:{ Throwable -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fe A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.maps.model.Poi b(int r13, int r14) {
        /*
            r12 = this;
            boolean r0 = r12.aT
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r12.aT     // Catch:{ Throwable -> 0x00ff }
            r2 = 20
            r3 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000d:
            r0 = r1
            goto L_0x00ca
        L_0x0010:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Throwable -> 0x00ff }
            r0.<init>()     // Catch:{ Throwable -> 0x00ff }
            com.autonavi.ae.gmap.GLMapEngine r4 = r12.l     // Catch:{ Throwable -> 0x00ff }
            r5 = 25
            r6 = 1
            byte[] r13 = r4.getLabelBuffer(r6, r13, r14, r5)     // Catch:{ Throwable -> 0x00ff }
            if (r13 != 0) goto L_0x0021
            goto L_0x000d
        L_0x0021:
            int r14 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r3)     // Catch:{ Throwable -> 0x00ff }
            if (r14 <= 0) goto L_0x0029
            r14 = r6
            goto L_0x002a
        L_0x0029:
            r14 = r3
        L_0x002a:
            r4 = 4
            r5 = r4
            r4 = r3
        L_0x002d:
            if (r4 >= r14) goto L_0x00ca
            com.autonavi.ae.gmap.glinterface.MapLabelItem r7 = new com.autonavi.ae.gmap.glinterface.MapLabelItem     // Catch:{ Throwable -> 0x00ff }
            r7.<init>()     // Catch:{ Throwable -> 0x00ff }
            int r8 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            int r9 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            r7.x = r8     // Catch:{ Throwable -> 0x00ff }
            com.amap.api.col.n3.l r8 = r12.ad     // Catch:{ Throwable -> 0x00ff }
            int r8 = r8.getHeight()     // Catch:{ Throwable -> 0x00ff }
            int r8 = r8 - r9
            r7.y = r8     // Catch:{ Throwable -> 0x00ff }
            int r8 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            r7.pixel20X = r8     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            int r8 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            r7.pixel20Y = r8     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            int r8 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            r7.type = r8     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            int r8 = com.autonavi.ae.gmap.utils.GLConvertUtil.getInt(r13, r5)     // Catch:{ Throwable -> 0x00ff }
            r7.mSublayerId = r8     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 4
            byte r8 = r13[r5]     // Catch:{ Throwable -> 0x00ff }
            if (r8 == 0) goto L_0x0071
            r8 = r6
            goto L_0x0072
        L_0x0071:
            r8 = r3
        L_0x0072:
            r7.mIsFouces = r8     // Catch:{ Throwable -> 0x00ff }
            int r5 = r5 + 1
            byte r8 = r13[r5]     // Catch:{ Throwable -> 0x00ff }
            if (r8 != 0) goto L_0x007d
            r7.poiid = r1     // Catch:{ Throwable -> 0x00ff }
            goto L_0x00a0
        L_0x007d:
            java.lang.String r8 = ""
            r9 = r8
            r8 = r3
        L_0x0081:
            if (r8 >= r2) goto L_0x009e
            int r10 = r8 + r5
            byte r11 = r13[r10]     // Catch:{ Throwable -> 0x00ff }
            if (r11 == 0) goto L_0x009e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00ff }
            r11.<init>()     // Catch:{ Throwable -> 0x00ff }
            r11.append(r9)     // Catch:{ Throwable -> 0x00ff }
            byte r9 = r13[r10]     // Catch:{ Throwable -> 0x00ff }
            char r9 = (char) r9     // Catch:{ Throwable -> 0x00ff }
            r11.append(r9)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r9 = r11.toString()     // Catch:{ Throwable -> 0x00ff }
            int r8 = r8 + 1
            goto L_0x0081
        L_0x009e:
            r7.poiid = r9     // Catch:{ Throwable -> 0x00ff }
        L_0x00a0:
            int r5 = r5 + 20
            int r8 = r5 + 1
            byte r5 = r13[r5]     // Catch:{ Throwable -> 0x00ff }
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch:{ Throwable -> 0x00ff }
            r9.<init>()     // Catch:{ Throwable -> 0x00ff }
            r10 = r8
            r8 = r3
        L_0x00ad:
            if (r8 >= r5) goto L_0x00bc
            short r11 = com.autonavi.ae.gmap.utils.GLConvertUtil.getShort(r13, r10)     // Catch:{ Throwable -> 0x00ff }
            char r11 = (char) r11     // Catch:{ Throwable -> 0x00ff }
            r9.append(r11)     // Catch:{ Throwable -> 0x00ff }
            int r10 = r10 + 2
            int r8 = r8 + 1
            goto L_0x00ad
        L_0x00bc:
            java.lang.String r5 = r9.toString()     // Catch:{ Throwable -> 0x00ff }
            r7.name = r5     // Catch:{ Throwable -> 0x00ff }
            r0.add(r7)     // Catch:{ Throwable -> 0x00ff }
            int r4 = r4 + 1
            r5 = r10
            goto L_0x002d
        L_0x00ca:
            if (r0 == 0) goto L_0x00d9
            int r13 = r0.size()     // Catch:{ Throwable -> 0x00ff }
            if (r13 <= 0) goto L_0x00d9
            java.lang.Object r13 = r0.get(r3)     // Catch:{ Throwable -> 0x00ff }
            com.autonavi.ae.gmap.glinterface.MapLabelItem r13 = (com.autonavi.ae.gmap.glinterface.MapLabelItem) r13     // Catch:{ Throwable -> 0x00ff }
            goto L_0x00da
        L_0x00d9:
            r13 = r1
        L_0x00da:
            if (r13 == 0) goto L_0x00fe
            int r14 = r13.pixel20X     // Catch:{ Throwable -> 0x00ff }
            long r3 = (long) r14     // Catch:{ Throwable -> 0x00ff }
            int r14 = r13.pixel20Y     // Catch:{ Throwable -> 0x00ff }
            long r5 = (long) r14     // Catch:{ Throwable -> 0x00ff }
            com.autonavi.amap.mapcore.DPoint r14 = com.autonavi.amap.mapcore.VirtualEarthProjection.PixelsToLatLong(r3, r5, r2)     // Catch:{ Throwable -> 0x00ff }
            com.amap.api.maps.model.Poi r0 = new com.amap.api.maps.model.Poi     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r2 = r13.name     // Catch:{ Throwable -> 0x00ff }
            com.amap.api.maps.model.LatLng r9 = new com.amap.api.maps.model.LatLng     // Catch:{ Throwable -> 0x00ff }
            double r4 = r14.y     // Catch:{ Throwable -> 0x00ff }
            double r6 = r14.x     // Catch:{ Throwable -> 0x00ff }
            r8 = 0
            r3 = r9
            r3.<init>(r4, r6, r8)     // Catch:{ Throwable -> 0x00ff }
            java.lang.String r13 = r13.poiid     // Catch:{ Throwable -> 0x00ff }
            r0.<init>(r2, r9, r13)     // Catch:{ Throwable -> 0x00ff }
            r14.recycle()     // Catch:{ Throwable -> 0x00ff }
            return r0
        L_0x00fe:
            return r1
        L_0x00ff:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.b(int, int):com.amap.api.maps.model.Poi");
    }

    public final float k(int i2) {
        if (!this.aT || this.l == null) {
            return 0.0f;
        }
        return this.l.getMapAngle(i2);
    }

    public final Point r() {
        if (!this.aT || this.l == null) {
            return null;
        }
        return this.l.getMapCenter(1);
    }

    public final float l(int i2) {
        if (!this.aT || this.l == null) {
            return 0.0f;
        }
        return this.l.getCameraDegree(i2);
    }

    public final void a(int i2, GestureMapMessage gestureMapMessage) {
        if (this.aT && this.l != null) {
            try {
                gestureMapMessage.isUseAnchor = this.al;
                gestureMapMessage.anchorX = this.g.getAnchorX();
                gestureMapMessage.anchorY = this.g.getAnchorY();
                this.l.addGestureMessage(i2, gestureMapMessage, this.ab.isGestureScaleByMapCenter(), this.g.getAnchorX(), this.g.getAnchorY());
            } catch (RemoteException unused) {
            }
        }
    }

    private void o(int i2) {
        if (this.aJ != null) {
            this.aJ.renderPause();
        }
        q(i2);
        NetworkState.getInstance().setNetWorkChangeListener((GLMapCoreCallback) null);
    }

    private void p(int i2) {
        q(i2);
        if (this.aJ != null) {
            this.aJ.renderResume();
        }
        NetworkState.getInstance().setNetWorkChangeListener(this);
    }

    public final void resetRenderTimeLong() {
        if (this.aJ != null) {
            this.aJ.resetTickCount(6);
        }
    }

    public final void resetRenderTimeLongLong() {
        if (this.aJ != null) {
            this.aJ.resetTickCount(30);
        }
    }

    public final void s() {
        if (this.aJ != null) {
            this.aJ.resetTickCount(2);
        }
    }

    public final void resetRenderTime(boolean z2) {
        if (this.aJ == null) {
            return;
        }
        if (z2) {
            this.aJ.resetTickCount(10);
        } else {
            this.aJ.resetTickCount(2);
        }
    }

    private void A() {
        if (this.aT && this.aJ != null && !this.aJ.isRenderPause()) {
            requestRender();
        }
    }

    public final void requestRender() {
        if (this.aJ != null && !this.aJ.isRenderPause()) {
            this.ad.requestRender();
        }
    }

    public final int getRenderMode() {
        return this.ad.getRenderMode();
    }

    public final float t() {
        return this.aM;
    }

    public final synchronized void a(int i2, int i3, int i4, int i5) {
        a(i2, i3, i4, i5, false, false, (StyleItem[]) null);
    }

    /* JADX INFO: finally extract failed */
    private synchronized void a(int i2, int i3, int i4, int i5, boolean z2, boolean z3, StyleItem[] styleItemArr) {
        synchronized (this) {
            try {
                this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_RESTORED_MAPMODESTATE, i3, i4, i5, 0);
                if (!this.aT) {
                    this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_MAPMODESTATE, i3, i4, i5, 0);
                } else if (!this.aU || !this.aT || !this.b) {
                    this.bg.g = i2;
                    this.bg.d = i3;
                    this.bg.e = i4;
                    this.bg.f = i5;
                    this.bg.b = true;
                } else {
                    final boolean z4 = z2;
                    final int i6 = i2;
                    final int i7 = i3;
                    final int i8 = i4;
                    final int i9 = i5;
                    final boolean z5 = z3;
                    final StyleItem[] styleItemArr2 = styleItemArr;
                    AnonymousClass16 r1 = new Runnable() {
                        public final void run() {
                            try {
                                if (!z4) {
                                    int[] mapModeState = a.this.l.getMapModeState(i6, false);
                                    if (mapModeState == null) {
                                        return;
                                    }
                                    if (mapModeState[0] == i7 && mapModeState[1] == i8 && mapModeState[2] == i9) {
                                        return;
                                    }
                                }
                                a.this.l.SetMapModeAndStyle(i6, i7, i8, i9, z4, z5, styleItemArr2);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    };
                    queueEvent(r1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void q(final int i2) {
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    a.this.l.clearAllMessages(i2);
                    a.this.l.clearAnimations(i2, true);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void postQueueEvent(Runnable runnable) {
        queueEvent(runnable);
    }

    public final void postOnUIThread(Runnable runnable) {
        a(runnable);
    }

    public final void b(final int i2, final boolean z2) {
        a(i2, 18, z2);
        if (!this.aT || !this.aU) {
            this.bi.c = z2;
            this.bi.b = true;
            this.bi.g = i2;
            return;
        }
        s();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        a.this.l.setParamater(i2, 1021, 1, 0, 0, 0);
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_PROCESS_3DOBJECT, 1, 0, 0, 0);
                        return;
                    }
                    a.this.l.setParamater(i2, 1021, 0, 0, 0, 0);
                    a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_PROCESS_3DOBJECT, 0, 0, 0, 0);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void c(final int i2, final boolean z2) {
        if (!this.aT || !this.aU) {
            this.bj.c = z2;
            this.bj.b = true;
            this.bj.g = i2;
            return;
        }
        s();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_NORMAL, 1, 0, 0, 0);
                    } else {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_NORMAL, 0, 0, 0, 0);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void d(final int i2, final boolean z2) {
        if (!this.aT || !this.aU) {
            this.bk.c = z2;
            this.bk.b = true;
            this.bk.g = i2;
            return;
        }
        s();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_MARK, 1, 0, 0, 0);
                    } else {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_MARK, 0, 0, 0, 0);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void e(final int i2, final boolean z2) {
        if (!this.aT || !this.aU) {
            this.bl.c = z2;
            this.bl.b = true;
            this.bl.g = i2;
            return;
        }
        s();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_POI, 1, 0, 0, 0);
                    } else {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_POI, 0, 0, 0, 0);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final void f(final int i2, final boolean z2) {
        a(i2, 12, z2);
        if (!this.aT || !this.aU) {
            this.bo.c = z2;
            this.bo.b = true;
            this.bo.g = i2;
            return;
        }
        s();
        queueEvent(new Runnable() {
            public final void run() {
                try {
                    if (z2) {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_TEXTURE, 1, 0, 0, 0);
                    } else {
                        a.this.l.setParamater(i2, GLMapStaticValue.AM_PARAMETERNAME_SHOW_BUILDING_TEXTURE, 0, 0, 0, 0);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:1|2|3|4|5|6|7|(1:11)|12|(1:16)|17|(1:21)|22|(2:24|25)|29|(1:31)|32|33) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ba A[SYNTHETIC, Splitter:B:24:0x00ba] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d1 A[Catch:{ Throwable -> 0x00c9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(javax.microedition.khronos.opengles.GL10 r8, javax.microedition.khronos.egl.EGLConfig r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.aS = r8     // Catch:{ all -> 0x00db }
            r0 = 0
            r7.aU = r0     // Catch:{ all -> 0x00db }
            com.amap.api.col.n3.l r1 = r7.ad     // Catch:{ all -> 0x00db }
            int r1 = r1.getWidth()     // Catch:{ all -> 0x00db }
            r7.n = r1     // Catch:{ all -> 0x00db }
            com.amap.api.col.n3.l r1 = r7.ad     // Catch:{ all -> 0x00db }
            int r1 = r1.getHeight()     // Catch:{ all -> 0x00db }
            r7.o = r1     // Catch:{ all -> 0x00db }
            r7.aX = r0     // Catch:{ all -> 0x00db }
            com.autonavi.ae.gmap.GLMapEngine r1 = r7.l     // Catch:{ all -> 0x00db }
            r1.initConnectionManager()     // Catch:{ all -> 0x00db }
            r1 = 1
            r7.r((int) r1)     // Catch:{ all -> 0x00db }
            com.amap.api.col.n3.a$24 r2 = new com.amap.api.col.n3.a$24     // Catch:{ all -> 0x00db }
            r2.<init>()     // Catch:{ all -> 0x00db }
            r7.a((java.lang.Runnable) r2)     // Catch:{ all -> 0x00db }
            r7.aT = r1     // Catch:{ all -> 0x00db }
            r2 = 7937(0x1f01, float:1.1122E-41)
            java.lang.String r2 = r8.glGetString(r2)     // Catch:{ Exception -> 0x0033 }
            r7.u = r2     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            com.autonavi.ae.gmap.GLMapEngine r2 = r7.l     // Catch:{ all -> 0x00db }
            com.autonavi.ae.gmap.GLMapState r2 = r2.getMapState(r1)     // Catch:{ all -> 0x00db }
            if (r2 == 0) goto L_0x0074
            long r3 = r2.getNativeInstance()     // Catch:{ all -> 0x00db }
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0074
            com.autonavi.amap.mapcore.MapConfig r3 = r7.g     // Catch:{ all -> 0x00db }
            int r3 = r3.getS_x()     // Catch:{ all -> 0x00db }
            com.autonavi.amap.mapcore.MapConfig r4 = r7.g     // Catch:{ all -> 0x00db }
            int r4 = r4.getS_y()     // Catch:{ all -> 0x00db }
            r2.setMapGeoCenter(r3, r4)     // Catch:{ all -> 0x00db }
            com.autonavi.amap.mapcore.MapConfig r3 = r7.g     // Catch:{ all -> 0x00db }
            float r3 = r3.getS_r()     // Catch:{ all -> 0x00db }
            r2.setMapAngle(r3)     // Catch:{ all -> 0x00db }
            com.autonavi.amap.mapcore.MapConfig r3 = r7.g     // Catch:{ all -> 0x00db }
            float r3 = r3.getS_z()     // Catch:{ all -> 0x00db }
            r2.setMapZoomer(r3)     // Catch:{ all -> 0x00db }
            com.autonavi.amap.mapcore.MapConfig r3 = r7.g     // Catch:{ all -> 0x00db }
            float r3 = r3.getS_c()     // Catch:{ all -> 0x00db }
            r2.setCameraDegree(r3)     // Catch:{ all -> 0x00db }
            com.autonavi.ae.gmap.GLMapEngine r3 = r7.l     // Catch:{ all -> 0x00db }
            r3.setMapState(r1, r2, r0)     // Catch:{ all -> 0x00db }
        L_0x0074:
            android.graphics.Bitmap r0 = r7.F     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x0080
            android.graphics.Bitmap r0 = r7.F     // Catch:{ all -> 0x00db }
            boolean r0 = r0.isRecycled()     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x008a
        L_0x0080:
            android.content.Context r0 = r7.k     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "amap_sdk_lineTexture.png"
            android.graphics.Bitmap r0 = com.amap.api.col.n3.dv.a((android.content.Context) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00db }
            r7.F = r0     // Catch:{ all -> 0x00db }
        L_0x008a:
            android.graphics.Bitmap r0 = r7.G     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x0096
            android.graphics.Bitmap r0 = r7.G     // Catch:{ all -> 0x00db }
            boolean r0 = r0.isRecycled()     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x00a0
        L_0x0096:
            android.content.Context r0 = r7.k     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "amap_sdk_lineDashTexture.png"
            android.graphics.Bitmap r0 = com.amap.api.col.n3.dv.a((android.content.Context) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00db }
            r7.G = r0     // Catch:{ all -> 0x00db }
        L_0x00a0:
            android.graphics.Bitmap r0 = r7.F     // Catch:{ all -> 0x00db }
            int r0 = com.amap.api.col.n3.dv.a((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x00db }
            r7.C = r0     // Catch:{ all -> 0x00db }
            android.graphics.Bitmap r0 = r7.G     // Catch:{ all -> 0x00db }
            int r0 = com.amap.api.col.n3.dv.b((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x00db }
            r7.D = r0     // Catch:{ all -> 0x00db }
            int r0 = com.amap.api.col.n3.dv.a()     // Catch:{ all -> 0x00db }
            r7.E = r0     // Catch:{ all -> 0x00db }
            boolean r0 = aB     // Catch:{ all -> 0x00db }
            if (r0 != 0) goto L_0x00cd
            java.lang.Thread r0 = r7.aA     // Catch:{ Throwable -> 0x00c9 }
            java.lang.String r2 = "AuthThread"
            r0.setName(r2)     // Catch:{ Throwable -> 0x00c9 }
            java.lang.Thread r0 = r7.aA     // Catch:{ Throwable -> 0x00c9 }
            r0.start()     // Catch:{ Throwable -> 0x00c9 }
            aB = r1     // Catch:{ Throwable -> 0x00c9 }
            goto L_0x00cd
        L_0x00c9:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ all -> 0x00db }
        L_0x00cd:
            com.amap.api.maps.CustomRenderer r0 = r7.i     // Catch:{ all -> 0x00db }
            if (r0 == 0) goto L_0x00d6
            com.amap.api.maps.CustomRenderer r0 = r7.i     // Catch:{ all -> 0x00db }
            r0.onSurfaceCreated(r8, r9)     // Catch:{ all -> 0x00db }
        L_0x00d6:
            com.autonavi.amap.mapcore.AMapNativeRenderer.nativeDrawLineInit()     // Catch:{ all -> 0x00db }
            monitor-exit(r7)
            return
        L_0x00db:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.a(javax.microedition.khronos.opengles.GL10, javax.microedition.khronos.egl.EGLConfig):void");
    }

    public final void destorySurface(int i2) {
        this.aY.lock();
        try {
            if (this.aT) {
                this.l.destorySurface();
                VMapDataCache.getInstance().reset();
                if (this.ai != null) {
                    this.ai.onSurfaceDestroy(i2);
                }
            }
            this.aT = false;
            this.aS = null;
            this.aU = false;
            this.aX = false;
        } catch (Throwable th) {
            this.aY.unlock();
            throw th;
        }
        this.aY.unlock();
    }

    public final Context u() {
        return this.k;
    }

    private void r(int i2) {
        int i3;
        int i4;
        int i5;
        int[] mapModeState = this.l.getMapModeState(i2, false);
        if (mapModeState != null) {
            int i6 = mapModeState[0];
            int i7 = mapModeState[1];
            i3 = mapModeState[2];
            i5 = i6;
            i4 = i7;
        } else {
            i5 = 0;
            i4 = 0;
            i3 = 0;
        }
        this.l.loadStartResource(i2, i5, i4, i3, c(i2, 2), this.n, this.o);
    }

    public final int a(EAMapPlatformGestureInfo eAMapPlatformGestureInfo) {
        if (this.l != null) {
            return this.l.getEngineIDWithGestureInfo(eAMapPlatformGestureInfo);
        }
        return 1;
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, boolean z2) {
        if (this.l != null) {
            this.l.setSrvViewStateBoolValue(i2, i3, z2);
        }
    }

    private boolean c(int i2, int i3) {
        if (this.l != null) {
            return this.l.getSrvViewStateBoolValue(i2, i3);
        }
        return false;
    }

    public final CameraPosition getCameraPosition() throws RemoteException {
        return g(this.al);
    }

    public final float getMaxZoomLevel() {
        if (this.g != null) {
            return this.g.getMaxZoomLevel();
        }
        return 19.0f;
    }

    public final float getMinZoomLevel() {
        if (this.g != null) {
            return this.g.getMinZoomLevel();
        }
        return 3.0f;
    }

    public final void moveCamera(CameraUpdate cameraUpdate) throws RemoteException {
        if (cameraUpdate != null) {
            a(cameraUpdate.getCameraUpdateFactoryDelegate());
        }
    }

    public final void a(CameraUpdateMessage cameraUpdateMessage) throws RemoteException {
        if (this.l != null && !this.ag) {
            if (this.ak && this.l.getStateMessageCount() > 0) {
                x xVar = new x();
                xVar.nowType = CameraUpdateMessage.Type.changeGeoCenterZoomTiltBearing;
                xVar.geoPoint = new Point(this.g.getS_x(), this.g.getS_y());
                xVar.zoom = this.g.getS_z();
                xVar.bearing = this.g.getS_r();
                xVar.tilt = this.g.getS_c();
                this.l.addMessage(cameraUpdateMessage);
                while (this.l.getStateMessageCount() > 0) {
                    if (this.l.getStateMessage() != null) {
                        cameraUpdateMessage.mergeCameraUpdateDelegate(xVar);
                    }
                }
                cameraUpdateMessage = xVar;
            }
            s();
            this.l.clearAnimations(1, false);
            cameraUpdateMessage.isChangeFinished = true;
            c(cameraUpdateMessage);
            this.l.addMessage(cameraUpdateMessage);
        }
    }

    private void c(CameraUpdateMessage cameraUpdateMessage) {
        cameraUpdateMessage.isUseAnchor = this.al;
        if (this.al) {
            cameraUpdateMessage.anchorX = this.g.getAnchorX();
            cameraUpdateMessage.anchorY = this.g.getAnchorY();
        }
        if (cameraUpdateMessage.width == 0) {
            cameraUpdateMessage.width = getMapWidth();
        }
        if (cameraUpdateMessage.height == 0) {
            cameraUpdateMessage.height = getMapHeight();
        }
        cameraUpdateMessage.mapConfig = this.g;
    }

    public final void animateCamera(CameraUpdate cameraUpdate) throws RemoteException {
        b(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    public final void b(CameraUpdateMessage cameraUpdateMessage) throws RemoteException {
        a(cameraUpdateMessage, 250, (AMap.CancelableCallback) null);
    }

    public final void animateCameraWithCallback(CameraUpdate cameraUpdate, AMap.CancelableCallback cancelableCallback) throws RemoteException {
        animateCameraWithDurationAndCallback(cameraUpdate, 250, cancelableCallback);
    }

    public final void animateCameraWithDurationAndCallback(CameraUpdate cameraUpdate, long j2, AMap.CancelableCallback cancelableCallback) {
        a(cameraUpdate.getCameraUpdateFactoryDelegate(), j2, cancelableCallback);
    }

    private void a(CameraUpdateMessage cameraUpdateMessage, long j2, final AMap.CancelableCallback cancelableCallback) {
        if (cameraUpdateMessage != null && !this.ag) {
            if (this.ak || getMapHeight() == 0 || getMapWidth() == 0) {
                try {
                    a(cameraUpdateMessage);
                    if (cancelableCallback != null) {
                        cancelableCallback.onFinish();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } else {
                synchronized (this.W) {
                    if (this.l.isInMapAnimation(1) && this.aG.get() > 0) {
                        try {
                            AMap.CancelableCallback cancelableCallback2 = (AMap.CancelableCallback) this.aH.remove(Integer.valueOf(this.aG.decrementAndGet()));
                            if (cancelableCallback2 != null) {
                                cancelableCallback2.onCancel();
                            }
                        } catch (Throwable th2) {
                            iu.b(th2, "AMapDelegateImp", "CancelableCallback.onCancel");
                            th2.printStackTrace();
                        }
                    }
                    try {
                        s();
                        c(cameraUpdateMessage);
                        this.l.clearAnimations(1, false);
                        cameraUpdateMessage.generateMapAnimation(this.l, (int) j2);
                        queueEvent(new Runnable() {
                            public final void run() {
                                int incrementAndGet = a.this.aG.incrementAndGet();
                                if (cancelableCallback != null) {
                                    a.this.aH.put(Integer.valueOf(incrementAndGet - 1), cancelableCallback);
                                }
                            }
                        });
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                return;
            }
        } else {
            return;
        }
    }

    public final void stopAnimation() throws RemoteException {
        if (this.l != null && this.l.getAnimateionsCount() > 0) {
            a((CameraPosition) null);
            this.l.clearAnimations(1, false);
            synchronized (this.W) {
                try {
                    if (this.aG.get() > 0) {
                        AMap.CancelableCallback cancelableCallback = (AMap.CancelableCallback) this.aH.remove(Integer.valueOf(this.aG.decrementAndGet()));
                        if (cancelableCallback != null) {
                            cancelableCallback.onCancel();
                        }
                    }
                } catch (Throwable th) {
                    iu.b(th, "AMapDelegateImp", "CancelableCallback.onCancel");
                    th.printStackTrace();
                }
            }
        }
        s();
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) throws RemoteException {
        s();
        ck a2 = this.f.a(polylineOptions);
        if (a2 != null) {
            return new Polyline(a2);
        }
        return null;
    }

    public final NavigateArrow addNavigateArrow(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        s();
        cg a2 = this.f.a(navigateArrowOptions);
        if (a2 != null) {
            return new NavigateArrow(a2);
        }
        return null;
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) throws RemoteException {
        s();
        cj a2 = this.f.a(polygonOptions);
        if (a2 != null) {
            return new Polygon(a2);
        }
        return null;
    }

    public final Circle addCircle(CircleOptions circleOptions) throws RemoteException {
        s();
        cd a2 = this.f.a(circleOptions);
        if (a2 != null) {
            return new Circle(a2);
        }
        return null;
    }

    public final Arc addArc(ArcOptions arcOptions) throws RemoteException {
        s();
        cc a2 = this.f.a(arcOptions);
        if (a2 != null) {
            return new Arc(a2);
        }
        return null;
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        s();
        ce a2 = this.f.a(groundOverlayOptions);
        if (a2 != null) {
            return new GroundOverlay(a2);
        }
        return null;
    }

    public final MultiPointOverlay addMultiPointOverlay(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        s();
        IMultiPointOverlay a2 = this.q.a(multiPointOverlayOptions);
        if (a2 != null) {
            return new MultiPointOverlay(a2);
        }
        return null;
    }

    public final Marker addMarker(MarkerOptions markerOptions) throws RemoteException {
        s();
        return this.e.a(markerOptions);
    }

    public final Text addText(TextOptions textOptions) throws RemoteException {
        s();
        return this.e.a(textOptions);
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z2) throws RemoteException {
        s();
        return this.e.a(arrayList, z2);
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        return this.d.a(tileOverlayOptions);
    }

    public final void clear() throws RemoteException {
        try {
            clear(false);
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "clear");
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039 A[Catch:{ Throwable -> 0x0042 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030 A[Catch:{ Throwable -> 0x0042 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void clear(boolean r3) throws android.os.RemoteException {
        /*
            r2 = this;
            r2.j()     // Catch:{ Throwable -> 0x0042 }
            com.amap.api.col.n3.co r0 = r2.an     // Catch:{ Throwable -> 0x0042 }
            r1 = 0
            if (r0 == 0) goto L_0x001c
            if (r3 == 0) goto L_0x0017
            com.amap.api.col.n3.co r3 = r2.an     // Catch:{ Throwable -> 0x0042 }
            java.lang.String r1 = r3.c()     // Catch:{ Throwable -> 0x0042 }
            com.amap.api.col.n3.co r3 = r2.an     // Catch:{ Throwable -> 0x0042 }
            java.lang.String r3 = r3.d()     // Catch:{ Throwable -> 0x0042 }
            goto L_0x001d
        L_0x0017:
            com.amap.api.col.n3.co r3 = r2.an     // Catch:{ Throwable -> 0x0042 }
            r3.e()     // Catch:{ Throwable -> 0x0042 }
        L_0x001c:
            r3 = r1
        L_0x001d:
            com.amap.api.col.n3.i r0 = r2.f     // Catch:{ Throwable -> 0x0042 }
            r0.b(r3)     // Catch:{ Throwable -> 0x0042 }
            com.amap.api.col.n3.u r3 = r2.d     // Catch:{ Throwable -> 0x0042 }
            r3.b()     // Catch:{ Throwable -> 0x0042 }
            com.amap.api.col.n3.p r3 = r2.e     // Catch:{ Throwable -> 0x0042 }
            r3.a((java.lang.String) r1)     // Catch:{ Throwable -> 0x0042 }
            com.amap.api.col.n3.eh r3 = r2.c     // Catch:{ Throwable -> 0x0042 }
            if (r3 == 0) goto L_0x0035
            com.amap.api.col.n3.eh r3 = r2.c     // Catch:{ Throwable -> 0x0042 }
            r3.j()     // Catch:{ Throwable -> 0x0042 }
        L_0x0035:
            com.amap.api.col.n3.aj r3 = r2.q     // Catch:{ Throwable -> 0x0042 }
            if (r3 == 0) goto L_0x003e
            com.amap.api.col.n3.aj r3 = r2.q     // Catch:{ Throwable -> 0x0042 }
            r3.c()     // Catch:{ Throwable -> 0x0042 }
        L_0x003e:
            r2.s()     // Catch:{ Throwable -> 0x0042 }
            return
        L_0x0042:
            r3 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "clear"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r0, (java.lang.String) r1)
            r3.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.clear(boolean):void");
    }

    public final int getMapType() throws RemoteException {
        return this.ay;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[Catch:{ Throwable -> 0x0059 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052 A[Catch:{ Throwable -> 0x0059 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMapType(int r15) throws android.os.RemoteException {
        /*
            r14 = this;
            r14.ay = r15
            r0 = 5
            r1 = 2
            r2 = 4
            r3 = 1
            r4 = 0
            if (r15 != r3) goto L_0x000d
        L_0x0009:
            r8 = r4
            r9 = r8
        L_0x000b:
            r10 = r9
            goto L_0x0028
        L_0x000d:
            if (r15 != r1) goto L_0x0012
            r8 = r3
            r9 = r4
            goto L_0x000b
        L_0x0012:
            r5 = 3
            if (r15 != r5) goto L_0x0019
            r10 = r2
            r9 = r3
            r8 = r4
            goto L_0x0028
        L_0x0019:
            if (r15 != r2) goto L_0x001f
            r10 = r2
            r8 = r4
            r9 = r8
            goto L_0x0028
        L_0x001f:
            if (r15 != r0) goto L_0x0025
            r10 = r0
            r8 = r1
            r9 = r4
            goto L_0x0028
        L_0x0025:
            r14.ay = r3     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0009
        L_0x0028:
            com.autonavi.amap.mapcore.MapConfig r15 = r14.g     // Catch:{ Throwable -> 0x0059 }
            r15.setMapStyleMode(r8)     // Catch:{ Throwable -> 0x0059 }
            com.autonavi.amap.mapcore.MapConfig r15 = r14.g     // Catch:{ Throwable -> 0x0059 }
            r15.setMapStyleTime(r9)     // Catch:{ Throwable -> 0x0059 }
            com.autonavi.amap.mapcore.MapConfig r15 = r14.g     // Catch:{ Throwable -> 0x0059 }
            r15.setMapStyleState(r10)     // Catch:{ Throwable -> 0x0059 }
            com.autonavi.amap.mapcore.MapConfig r15 = r14.g     // Catch:{ Throwable -> 0x0059 }
            boolean r15 = r15.isCustomStyleEnable()     // Catch:{ Throwable -> 0x0059 }
            if (r15 == 0) goto L_0x0052
            r7 = 1
            r11 = 1
            r12 = 0
            r13 = 0
            r6 = r14
            r6.a(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Throwable -> 0x0059 }
            com.autonavi.amap.mapcore.MapConfig r15 = r14.g     // Catch:{ Throwable -> 0x0059 }
            r15.setCustomStyleEnable(r4)     // Catch:{ Throwable -> 0x0059 }
            com.amap.api.col.n3.v r15 = r14.ab     // Catch:{ Throwable -> 0x0059 }
            r15.setLogoEnable(r3)     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0055
        L_0x0052:
            r14.a((int) r3, (int) r8, (int) r9, (int) r10)     // Catch:{ Throwable -> 0x0059 }
        L_0x0055:
            r14.s()     // Catch:{ Throwable -> 0x0059 }
            return
        L_0x0059:
            r15 = move-exception
            java.lang.String r0 = "AMapDelegateImp"
            java.lang.String r1 = "setMaptype"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r15, (java.lang.String) r0, (java.lang.String) r1)
            r15.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.setMapType(int):void");
    }

    public final boolean isTrafficEnabled() throws RemoteException {
        return this.g.isTrafficEnabled();
    }

    public final void setTrafficEnabled(final boolean z2) throws RemoteException {
        if (!this.aT || this.ag) {
            this.bd.c = z2;
            this.bd.b = true;
            this.bd.g = 1;
            return;
        }
        queueEvent(new Runnable(z2) {
            final /* synthetic */ boolean a;

            {
                this.a = r2;
            }

            public final void run() {
                try {
                    if (a.this.g.isTrafficEnabled() != this.a) {
                        a.this.g.setTrafficEnabled(z2);
                        a.this.aJ.setTrafficMode(this.a);
                        boolean z = this.a;
                        a.this.l.setParamater(1, AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT, 8, 10, 0, 0);
                        if (a.this.az != null) {
                            a.this.setMyTrafficStyle(a.this.az);
                        }
                        a.this.l.setParamater(1, GLMapStaticValue.AM_PARAMETERNAME_TRAFFIC, z ? 1 : 0, 0, 0, 0);
                        a.this.s();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public final boolean isIndoorEnabled() throws RemoteException {
        return this.g.isIndoorEnable();
    }

    public final void setIndoorEnabled(boolean z2) throws RemoteException {
        final boolean z3 = z2;
        if (!this.aT || this.ag) {
            this.bm.c = z3;
            this.bm.b = true;
            this.bm.g = 1;
            return;
        }
        this.g.setIndoorEnable(z3);
        s();
        if (z3) {
            this.l.setParamater(1, GLMapStaticValue.AM_PARAMETERNAME_PROCESS_INDOOR, 1, 0, 0, 0);
        } else {
            this.l.setParamater(1, GLMapStaticValue.AM_PARAMETERNAME_PROCESS_INDOOR, 0, 0, 0, 0);
            this.g.maxZoomLevel = this.g.isSetLimitZoomLevel() ? this.g.getMaxZoomLevel() : 19.0f;
            if (this.ab.isZoomControlsEnabled()) {
                this.aj.invalidateZoomController(this.g.getS_z());
            }
        }
        if (this.ab.isIndoorSwitchEnabled()) {
            this.r.post(new Runnable() {
                public final void run() {
                    if (z3) {
                        a.this.b(true);
                    } else if (a.this.c != null && a.this.c.e() != null) {
                        a.this.c.e().a(false);
                    }
                }
            });
        }
    }

    public final void set3DBuildingEnabled(boolean z2) throws RemoteException {
        o(1);
        c(1, z2);
        p(1);
    }

    public final boolean isMyLocationEnabled() throws RemoteException {
        return this.ae;
    }

    public final void setMyLocationEnabled(boolean z2) throws RemoteException {
        if (!this.ag) {
            try {
                if (this.c != null) {
                    eg f2 = this.c.f();
                    if (this.ao == null) {
                        f2.a(false);
                    } else if (z2) {
                        this.ao.activate(this.T);
                        f2.a(true);
                        if (this.an == null) {
                            this.an = new co(this, this.k);
                        }
                    } else {
                        if (this.an != null) {
                            this.an.b();
                            this.an = null;
                        }
                        this.ao.deactivate();
                    }
                }
                if (!z2) {
                    this.ab.setMyLocationButtonEnabled(z2);
                }
                this.ae = z2;
                s();
            } catch (Throwable th) {
                iu.b(th, "AMapDelegateImp", "setMyLocationEnabled");
                th.printStackTrace();
            }
        }
    }

    public final void setLoadOfflineData(final boolean z2) throws RemoteException {
        queueEvent(new Runnable() {
            public final void run() {
                if (a.this.l != null) {
                    a.this.l.setParamater(1, GLMapStaticValue.AM_PARAMETERNAME_ON_OFF_DBLITE, z2 ? 1 : 0, 0, 0, 0);
                }
            }
        });
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) throws RemoteException {
        if (!this.ag) {
            if (this.an == null) {
                this.an = new co(this, this.k);
            }
            if (this.an != null) {
                if (myLocationStyle.getInterval() < 1000) {
                    myLocationStyle.interval(1000);
                }
                if (this.ao != null && (this.ao instanceof af)) {
                    ((af) this.ao).a(myLocationStyle.getInterval());
                    ((af) this.ao).a(myLocationStyle.getMyLocationType());
                }
                this.an.a(myLocationStyle);
            }
        }
    }

    public final void setMyLocationType(int i2) throws RemoteException {
        if (this.an != null && this.an.a() != null) {
            this.an.a().myLocationType(i2);
            setMyLocationStyle(this.an.a());
        }
    }

    public final List<Marker> getMapScreenMarkers() throws RemoteException {
        if (!dv.b(getMapWidth(), getMapHeight())) {
            return new ArrayList();
        }
        return this.e.d();
    }

    public final void setMapTextEnable(boolean z2) throws RemoteException {
        o(1);
        if (z2) {
            this.l.setParamater(1, 1024, 1, 0, 0, 0);
        } else {
            this.l.setParamater(1, 1024, 0, 0, 0, 0);
        }
        p(1);
    }

    public final void setMyTrafficStyle(MyTrafficStyle myTrafficStyle) throws RemoteException {
        MyTrafficStyle myTrafficStyle2 = myTrafficStyle;
        if (!this.ag) {
            this.az = myTrafficStyle2;
            if (this.aT && myTrafficStyle2 != null) {
                this.l.setParamater(1, AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL, 1, 1, 1, 1);
                this.l.setParamater(1, AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT, myTrafficStyle.getSmoothColor(), myTrafficStyle.getSlowColor(), myTrafficStyle.getCongestedColor(), myTrafficStyle.getSeriousCongestedColor());
                this.l.setParamater(1, AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT, (int) (myTrafficStyle.getRatio() * 10.0f), 10, 0, 0);
            }
        }
    }

    public final Location getMyLocation() throws RemoteException {
        if (this.ao != null) {
            return this.T.a;
        }
        return null;
    }

    public final void setLocationSource(LocationSource locationSource) throws RemoteException {
        try {
            if (!this.ag) {
                if (this.ao != null && (this.ao instanceof af)) {
                    this.ao.deactivate();
                }
                this.ao = locationSource;
                if (locationSource != null) {
                    this.c.f().a(true);
                } else {
                    this.c.f().a(false);
                }
            }
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "setLocationSource");
            th.printStackTrace();
        }
    }

    public final void setMyLocationRotateAngle(float f2) throws RemoteException {
        if (this.an != null) {
            this.an.a(f2);
        }
    }

    public final UiSettings getAMapUiSettings() throws RemoteException {
        if (this.Z == null) {
            this.Z = new UiSettings(this.ab);
        }
        return this.Z;
    }

    public final Projection getAMapProjection() throws RemoteException {
        return new Projection(this.aa);
    }

    public final void setOnMapClickListener(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        this.M = onMapClickListener;
    }

    public final void setOnMapTouchListener(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        this.N = onMapTouchListener;
    }

    public final void setOnPOIClickListener(AMap.OnPOIClickListener onPOIClickListener) throws RemoteException {
        this.O = onPOIClickListener;
    }

    public final void setOnMapLongClickListener(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        this.P = onMapLongClickListener;
    }

    public final void setOnMarkerClickListener(AMap.OnMarkerClickListener onMarkerClickListener) throws RemoteException {
        this.H = onMarkerClickListener;
    }

    public final void setOnPolylineClickListener(AMap.OnPolylineClickListener onPolylineClickListener) throws RemoteException {
        this.I = onPolylineClickListener;
    }

    public final void setOnMarkerDragListener(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        this.J = onMarkerDragListener;
    }

    public final void setOnMaploadedListener(AMap.OnMapLoadedListener onMapLoadedListener) throws RemoteException {
        this.K = onMapLoadedListener;
    }

    public final void setOnCameraChangeListener(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        this.L = onCameraChangeListener;
    }

    public final void setOnInfoWindowClickListener(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        this.Q = onInfoWindowClickListener;
    }

    public final void setOnIndoorBuildingActiveListener(AMap.OnIndoorBuildingActiveListener onIndoorBuildingActiveListener) throws RemoteException {
        this.R = onIndoorBuildingActiveListener;
    }

    public final void setOnMyLocationChangeListener(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        this.S = onMyLocationChangeListener;
    }

    public final void setInfoWindowAdapter(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        if (!this.ag && this.a != null) {
            this.a.a(infoWindowAdapter);
        }
    }

    public final void setOnMultiPointClickListener(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        if (this.q != null) {
            this.q.a(onMultiPointClickListener);
        }
    }

    public final String getMapContentApprovalNumber() {
        if (this.g == null || this.g.isCustomStyleEnable()) {
            return null;
        }
        return "GS（2016）1474 | GS（2017）2550";
    }

    public final void getMapPrintScreen(AMap.onMapPrintScreenListener onmapprintscreenlistener) {
        this.U = onmapprintscreenlistener;
        this.aw = true;
        s();
    }

    public final void getMapScreenShot(AMap.OnMapScreenShotListener onMapScreenShotListener) {
        this.V = onMapScreenShotListener;
        this.aw = true;
        s();
    }

    public final float getScalePerPixel() throws RemoteException {
        try {
            return ((float) ((((Math.cos((getCameraPosition().target.latitude * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (256.0d * Math.pow(2.0d, (double) h())))) * this.aM;
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "getScalePerPixel");
            th.printStackTrace();
            return 0.0f;
        }
    }

    public final void setRunLowFrame(boolean z2) {
        if (!z2) {
            A();
        }
    }

    public final void removecache() throws RemoteException {
        removecache((AMap.OnCacheRemoveListener) null);
    }

    public final void removecache(AMap.OnCacheRemoveListener onCacheRemoveListener) throws RemoteException {
        if (this.r != null && this.l != null) {
            try {
                this.l.setParamater(1, GLMapStaticValue.AM_PARAMETERNAME_ON_OFF_DBLITE, 0, 0, 0, 0);
                d dVar = new d(this.k, onCacheRemoveListener);
                this.r.removeCallbacks(dVar);
                this.r.post(dVar);
            } catch (Throwable th) {
                iu.b(th, "AMapDelegateImp", "removecache");
                th.printStackTrace();
            }
        }
    }

    public final void setCustomRenderer(CustomRenderer customRenderer) throws RemoteException {
        this.i = customRenderer;
    }

    public final void setCenterToPixel(int i2, int i3) throws RemoteException {
        this.al = true;
        this.ba = i2;
        this.bb = i3;
        if (this.aU && this.aT) {
            if (this.g.getAnchorX() != this.ba || this.g.getAnchorY() != this.bb) {
                this.g.setAnchorX(this.ba);
                this.g.setAnchorY(this.bb);
                queueEvent(new Runnable() {
                    public final void run() {
                        a.this.g.setAnchorX(Math.max(0, Math.min(a.this.ba, a.this.n)));
                        a.this.g.setAnchorY(Math.max(0, Math.min(a.this.bb, a.this.o)));
                        a.this.l.setParamater(1, AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR, a.this.g.getAnchorX(), a.this.g.getAnchorY(), 0, 0);
                        boolean unused = a.this.aC = true;
                    }
                });
            }
        }
    }

    public final void setMapTextZIndex(int i2) throws RemoteException {
        this.aD = i2;
    }

    public final int getMapTextZIndex() throws RemoteException {
        return this.aD;
    }

    public final void setRenderFps(int i2) {
        try {
            this.j = Math.max(10, Math.min(i2, 40));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setIndoorBuildingInfo(IndoorBuildingInfo indoorBuildingInfo) throws RemoteException {
        if (!this.ag && indoorBuildingInfo != null && indoorBuildingInfo.activeFloorName != null && indoorBuildingInfo.poiid != null) {
            this.h = (ac) indoorBuildingInfo;
            s();
            queueEvent(new Runnable() {
                public final void run() {
                    if (a.this.l != null) {
                        a.this.l.setIndoorBuildingToBeActive(1, a.this.h.activeFloorName, a.this.h.activeFloorIndex, a.this.h.poiid);
                    }
                }
            });
        }
    }

    public final void setAMapGestureListener(AMapGestureListener aMapGestureListener) {
        if (this.m != null) {
            this.X = aMapGestureListener;
            this.m.d = aMapGestureListener;
        }
    }

    public final float getZoomToSpanLevel(LatLng latLng, LatLng latLng2) {
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.aT || this.ag) {
            return mapConfig.getS_z();
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.l.getMapEnginePtr());
        Pair<Float, IPoint> a2 = dv.a(mapConfig, 0, 0, 0, 0, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 != null) {
            return ((Float) a2.first).floatValue();
        }
        return gLMapState.getMapZoomer();
    }

    public final Pair<Float, LatLng> calculateZoomToSpanLevel(int i2, int i3, int i4, int i5, LatLng latLng, LatLng latLng2) {
        if (latLng != null && latLng2 != null && i2 == i3 && i3 == i4 && i4 == i5 && latLng.latitude == latLng2.latitude && latLng.longitude == latLng2.longitude) {
            return new Pair<>(Float.valueOf(getMaxZoomLevel()), latLng);
        }
        MapConfig mapConfig = getMapConfig();
        if (latLng == null || latLng2 == null || !this.aT || this.ag) {
            DPoint obtain = DPoint.obtain();
            GLMapState.geo2LonLat(mapConfig.getS_x(), mapConfig.getS_y(), obtain);
            Pair<Float, LatLng> pair = new Pair<>(Float.valueOf(mapConfig.getS_z()), new LatLng(obtain.y, obtain.x));
            obtain.recycle();
            return pair;
        }
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(latLng);
        builder.include(latLng2);
        GLMapState gLMapState = new GLMapState(1, this.l.getMapEnginePtr());
        Pair<Float, IPoint> a2 = dv.a(mapConfig, i2, i3, i4, i5, builder.build(), getMapWidth(), getMapHeight());
        gLMapState.recycle();
        if (a2 == null) {
            return null;
        }
        DPoint obtain2 = DPoint.obtain();
        GLMapState.geo2LonLat(((IPoint) a2.second).x, ((IPoint) a2.second).y, obtain2);
        Pair<Float, LatLng> pair2 = new Pair<>(a2.first, new LatLng(obtain2.y, obtain2.x));
        obtain2.recycle();
        return pair2;
    }

    public final InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return new InfoWindowAnimationManager(this.Y);
    }

    public final void setMaskLayerParams(int i2, int i3, int i4, int i5, final int i6, long j2) {
        GLAlphaAnimation gLAlphaAnimation;
        try {
            if (this.aE != null) {
                float f2 = ((float) i5) / 255.0f;
                if (i6 == -1) {
                    gLAlphaAnimation = new GLAlphaAnimation(f2, 0.0f);
                    gLAlphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public final void onAnimationStart() {
                        }

                        public final void onAnimationEnd() {
                            a.this.r.post(new Runnable() {
                                public final void run() {
                                    int unused = a.this.aF = i6;
                                    if (a.this.c != null) {
                                        a.this.c.h().setVisibility(0);
                                    }
                                }
                            });
                        }
                    });
                } else {
                    this.aF = i6;
                    gLAlphaAnimation = new GLAlphaAnimation(0.0f, f2);
                    if (((double) f2) > 0.2d) {
                        if (this.c != null) {
                            this.c.h().setVisibility(4);
                        }
                    } else if (this.c != null) {
                        this.c.h().setVisibility(0);
                    }
                }
                gLAlphaAnimation.setInterpolator(new LinearInterpolator());
                gLAlphaAnimation.setDuration(j2);
                this.aE.a(i2, i3, i4, i5);
                this.aE.a(gLAlphaAnimation);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMaxZoomLevel(float f2) {
        this.g.setMaxZoomLevel(f2);
    }

    public final void setMinZoomLevel(float f2) {
        this.g.setMinZoomLevel(f2);
    }

    public final void resetMinMaxZoomPreference() {
        this.g.resetMinMaxZoomPreference();
        try {
            if (this.ab.isZoomControlsEnabled() && this.g.isNeedUpdateZoomControllerState()) {
                this.aj.invalidateZoomController(this.g.getS_z());
            }
        } catch (RemoteException unused) {
        }
    }

    public final void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.g.setLimitLatLngBounds(latLngBounds);
            LatLngBounds limitLatLngBounds = this.g.getLimitLatLngBounds();
            if (this.l != null) {
                if ((limitLatLngBounds == null || limitLatLngBounds.northeast == null || limitLatLngBounds.southwest == null) ? false : true) {
                    GLMapState gLMapState = new GLMapState(1, this.l.getMapEnginePtr());
                    IPoint obtain = IPoint.obtain();
                    GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                    IPoint obtain2 = IPoint.obtain();
                    GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                    this.g.setLimitIPoints(new IPoint[]{obtain, obtain2});
                    gLMapState.recycle();
                    return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return;
        }
        this.g.setLimitIPoints((IPoint[]) null);
    }

    public final Handler getMainHandler() {
        return this.r;
    }

    public final void onChangeFinish() {
        s();
        Message obtainMessage = this.r.obtainMessage();
        obtainMessage.what = 11;
        this.r.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public final void a(CameraPosition cameraPosition) {
        if (this.g != null && this.g.getChangedCounter() != 0) {
            try {
                this.g.resetChangedCounter();
                if (this.X != null) {
                    this.X.onMapStable();
                }
                if (this.L != null && this.ad.isEnabled()) {
                    if (cameraPosition == null) {
                        cameraPosition = getCameraPosition();
                    }
                    this.L.onCameraChangeFinish(cameraPosition);
                }
            } catch (RemoteException e2) {
                iu.b((Throwable) e2, "AMapDelegateImp", "cameraChangeFinish");
                e2.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void setZoomScaleParam(float f2) {
        this.aM = f2;
    }

    public final void onFling() {
        if (this.d != null) {
            this.d.b(true);
        }
        this.av = true;
    }

    public final int getMapWidth() {
        return this.n;
    }

    public final int getMapHeight() {
        return this.o;
    }

    public final float getCameraAngle() {
        return l(this.af);
    }

    public final boolean isMaploaded() {
        return this.am;
    }

    public final MapConfig getMapConfig() {
        return this.g;
    }

    public final View getView() throws RemoteException {
        return this.c;
    }

    public final void onIndoorBuildingActivity(int i2, byte[] bArr) {
        ac acVar;
        if (bArr != null) {
            try {
                acVar = new ac();
                byte b2 = bArr[0];
                acVar.a = new String(bArr, 1, b2, "utf-8");
                int i3 = 1 + b2;
                int i4 = i3 + 1;
                byte b3 = bArr[i3];
                acVar.b = new String(bArr, i4, b3, "utf-8");
                int i5 = i4 + b3;
                int i6 = i5 + 1;
                byte b4 = bArr[i5];
                acVar.activeFloorName = new String(bArr, i6, b4, "utf-8");
                int i7 = i6 + b4;
                acVar.activeFloorIndex = GLConvertUtil.getInt(bArr, i7);
                int i8 = i7 + 4;
                int i9 = i8 + 1;
                byte b5 = bArr[i8];
                acVar.poiid = new String(bArr, i9, b5, "utf-8");
                int i10 = i9 + b5;
                int i11 = i10 + 1;
                byte b6 = bArr[i10];
                acVar.h = new String(bArr, i11, b6, "utf-8");
                int i12 = i11 + b6;
                acVar.c = GLConvertUtil.getInt(bArr, i12);
                int i13 = i12 + 4;
                acVar.floor_indexs = new int[acVar.c];
                acVar.floor_names = new String[acVar.c];
                acVar.d = new String[acVar.c];
                for (int i14 = 0; i14 < acVar.c; i14++) {
                    acVar.floor_indexs[i14] = GLConvertUtil.getInt(bArr, i13);
                    int i15 = i13 + 4;
                    int i16 = i15 + 1;
                    byte b7 = bArr[i15];
                    if (b7 > 0) {
                        acVar.floor_names[i14] = new String(bArr, i16, b7, "utf-8");
                        i16 += b7;
                    }
                    i13 = i16 + 1;
                    byte b8 = bArr[i16];
                    if (b8 > 0) {
                        acVar.d[i14] = new String(bArr, i13, b8, "utf-8");
                        i13 += b8;
                    }
                }
                acVar.e = GLConvertUtil.getInt(bArr, i13);
                int i17 = i13 + 4;
                if (acVar.e > 0) {
                    acVar.f = new int[acVar.e];
                    for (int i18 = 0; i18 < acVar.e; i18++) {
                        acVar.f[i18] = GLConvertUtil.getInt(bArr, i17);
                        i17 += 4;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            acVar = null;
        }
        this.bq = acVar;
        a((Runnable) new Runnable() {
            public final void run() {
                if (a.this.bc != null) {
                    a.this.bc.a(a.this.bq);
                }
            }
        });
    }

    public final AMapCameraInfo getCamerInfo() {
        try {
            GLMapState c2 = c();
            float mapAngle = c2.getMapAngle();
            float f2 = ((float) this.n) / ((float) this.o);
            float fov = c2.getFov();
            int[] iArr = new int[3];
            c2.getCameraPosition(iArr);
            AMapCameraInfo aMapCameraInfo = new AMapCameraInfo(fov, f2, mapAngle, (float) iArr[0], (float) iArr[1], (float) iArr[2]);
            return aMapCameraInfo;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MapTilsCacheAndResManager getMapCacheMgr() {
        if (!this.aT || this.l == null) {
            return null;
        }
        return this.l.getMapCacheMgr();
    }

    public final void destroy() {
        this.ag = true;
        try {
            if (this.q != null) {
                this.q.b();
            }
            if (this.ao != null) {
                this.ao.deactivate();
            }
            this.ao = null;
            this.bc = null;
            if (this.aJ != null) {
                this.aJ.renderPause();
            }
            if (this.G != null) {
                this.G.recycle();
                this.G = null;
            }
            if (this.F != null) {
                this.F.recycle();
                this.F = null;
            }
            if (this.m != null) {
                this.m.d = null;
                this.m.b();
                this.m = null;
            }
            if (this.f != null) {
                this.f.a();
            }
            if (this.e != null) {
                this.e.g();
            }
            if (this.d != null) {
                u uVar = this.d;
                uVar.b();
                if (uVar.d != null) {
                    uVar.d.remove();
                }
                uVar.d = null;
            }
            x();
            if (this.aA != null) {
                this.aA.interrupt();
                this.aA = null;
            }
            if (this.l != null) {
                this.l.setMapListener((IAMapListener) null);
                queueEvent(new Runnable() {
                    public final void run() {
                        try {
                            GLES20.glDeleteTextures(3, new int[]{a.this.C, a.this.D, a.this.E}, 0);
                            a.this.p.a();
                            a.this.p = null;
                            a.this.l.destorySurface();
                            a.this.l = null;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                Thread.sleep(200);
            }
            if (this.a != null) {
                this.a.b();
            }
            if (this.c != null) {
                this.c.i();
                this.c = null;
            }
            if (this.an != null) {
                this.an.b();
                this.an = null;
            }
            this.ao = null;
            this.S = null;
            this.H = null;
            this.I = null;
            this.J = null;
            this.K = null;
            this.L = null;
            this.M = null;
            this.N = null;
            this.O = null;
            this.P = null;
            this.Q = null;
            this.R = null;
            this.T = null;
            this.U = null;
            this.V = null;
            this.az = null;
            iu.b();
        } catch (Throwable th) {
            iu.b(th, "AMapDelegateImp", "destroy");
            th.printStackTrace();
        }
    }

    public final void beforeDrawLabel(int i2, GLMapState gLMapState) {
        y();
        if (this.l != null) {
            this.l.pushRendererState();
        }
        this.f.a(true, this.aD);
        if (this.l != null) {
            this.l.popRendererState();
        }
    }

    public final void afterDrawLabel(int i2, GLMapState gLMapState) {
        y();
        if (this.l != null) {
            this.l.pushRendererState();
        }
        u uVar = this.d;
        try {
            for (Integer intValue : uVar.c) {
                dv.b(intValue.intValue());
            }
            uVar.c.clear();
            if (g.c == 0 && uVar.d != null) {
                uVar.d.a();
            }
            synchronized (uVar.a) {
                int size = uVar.a.size();
                for (int i3 = 0; i3 < size; i3++) {
                    cm cmVar = uVar.a.get(i3);
                    if (cmVar.isVisible()) {
                        cmVar.a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.f.a(false, this.aD);
        if (this.q != null) {
            this.q.a(this.g, getViewMatrix(), getProjectionMatrix());
        }
        if (this.e != null) {
            this.e.a();
        }
        if (this.Y != null) {
            this.Y.a(getMapWidth(), getMapHeight());
        }
        if (this.l != null) {
            this.l.popRendererState();
        }
    }

    public final void afterDrawFrame(final int i2, GLMapState gLMapState) {
        if (!this.aX) {
            this.aX = true;
            a((Runnable) new Runnable() {
                public final void run() {
                    if (a.this.ai != null) {
                        a.this.ai.onSurfaceChanged(i2, a.this.n, a.this.o);
                    }
                }
            });
        }
    }

    public final long createGLOverlay(int i2) {
        if (this.l != null) {
            return this.l.createOverlay(1, i2);
        }
        return 0;
    }

    public final long getGlOverlayMgrPtr() {
        if (this.l != null) {
            return this.l.getGlOverlayMgrPtr(1);
        }
        return 0;
    }

    public final CrossOverlay addCrossVector(CrossOverlayOptions crossOverlayOptions) {
        if (crossOverlayOptions == null || crossOverlayOptions.getRes() == null) {
            return null;
        }
        CrossVectorOverlay crossVectorOverlay = new CrossVectorOverlay(1, this.k, this);
        if (crossOverlayOptions != null) {
            crossVectorOverlay.setAttribute(crossOverlayOptions.getAttribute());
        }
        if (this.l != null) {
            this.l.getOvelayBundle(1).addOverlay(crossVectorOverlay);
            crossVectorOverlay.resumeMarker(crossOverlayOptions.getRes());
        }
        return new CrossOverlay(crossOverlayOptions, crossVectorOverlay);
    }

    public final RouteOverlay addNaviRouteOverlay() {
        if (!this.aT || this.l == null) {
            return null;
        }
        return new RouteOverlay(new BaseRouteOverlay(1, this.k, this));
    }

    public final void addOverlayTexture(int i2, GLTextureProperty gLTextureProperty) {
        if (this.l != null) {
            this.l.addOverlayTexture(i2, gLTextureProperty);
            this.l.getOvelayBundle(1).addOverlayTextureItem(gLTextureProperty.mId, gLTextureProperty.mAnchor, gLTextureProperty.mXRatio, gLTextureProperty.mYRatio, gLTextureProperty.mBitmap.getWidth(), gLTextureProperty.mBitmap.getHeight());
        }
    }

    public final void setCustomMapStylePath(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.g.getCustomStylePath())) {
            this.g.setCustomStylePath(str);
            this.ac = true;
        }
    }

    public final void setCustomTextureResourcePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g.setCustomTextureResourcePath(str);
        }
    }

    public final MyLocationStyle getMyLocationStyle() throws RemoteException {
        if (this.an != null) {
            return this.an.a();
        }
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setMapCustomEnable(boolean r12) {
        /*
            r11 = this;
            boolean r0 = r11.aT
            r1 = 1
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r11.ag
            if (r0 != 0) goto L_0x00cc
            com.autonavi.amap.mapcore.MapConfig r0 = r11.g
            java.lang.String r0 = r0.getCustomStylePath()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0016
            return
        L_0x0016:
            boolean r0 = r11.ac     // Catch:{ Throwable -> 0x00c7 }
            r2 = 0
            if (r0 != 0) goto L_0x0024
            com.autonavi.amap.mapcore.MapConfig r0 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            boolean r0 = r0.isCustomStyleEnable()     // Catch:{ Throwable -> 0x00c7 }
            r0 = r0 ^ r12
            if (r0 == 0) goto L_0x00c4
        L_0x0024:
            com.autonavi.amap.mapcore.MapConfig r0 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            r0.setCustomStyleEnable(r12)     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.v r0 = r11.ab     // Catch:{ Throwable -> 0x00c7 }
            r3 = r12 ^ 1
            r0.setLogoEnable(r3)     // Catch:{ Throwable -> 0x00c7 }
            if (r12 == 0) goto L_0x00a7
            r11.f(r1, r1)     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.da r12 = new com.amap.api.col.n3.da     // Catch:{ Throwable -> 0x00c7 }
            android.content.Context r0 = r11.k     // Catch:{ Throwable -> 0x00c7 }
            r12.<init>(r0)     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.MapConfig r0 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            java.lang.String r0 = r0.getCustomStylePath()     // Catch:{ Throwable -> 0x00c7 }
            java.util.Map r0 = r12.a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00c7 }
            r3 = 0
            if (r0 == 0) goto L_0x0082
            int r4 = r0.size()     // Catch:{ Throwable -> 0x00c7 }
            if (r4 != 0) goto L_0x0050
            goto L_0x0082
        L_0x0050:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Throwable -> 0x00c7 }
            r4.<init>()     // Catch:{ Throwable -> 0x00c7 }
            java.util.Collection r0 = r0.values()     // Catch:{ Throwable -> 0x00c7 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Throwable -> 0x00c7 }
        L_0x005d:
            boolean r5 = r0.hasNext()     // Catch:{ Throwable -> 0x00c7 }
            if (r5 == 0) goto L_0x0073
            java.lang.Object r5 = r0.next()     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.ae.gmap.style.StyleItem r5 = (com.autonavi.ae.gmap.style.StyleItem) r5     // Catch:{ Throwable -> 0x00c7 }
            boolean r6 = r5.isValid()     // Catch:{ Throwable -> 0x00c7 }
            if (r6 == 0) goto L_0x005d
            r4.add(r5)     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x005d
        L_0x0073:
            int r0 = r4.size()     // Catch:{ Throwable -> 0x00c7 }
            if (r0 <= 0) goto L_0x0082
            com.autonavi.ae.gmap.style.StyleItem[] r0 = new com.autonavi.ae.gmap.style.StyleItem[r0]     // Catch:{ Throwable -> 0x00c7 }
            java.lang.Object[] r0 = r4.toArray(r0)     // Catch:{ Throwable -> 0x00c7 }
            r3 = r0
            com.autonavi.ae.gmap.style.StyleItem[] r3 = (com.autonavi.ae.gmap.style.StyleItem[]) r3     // Catch:{ Throwable -> 0x00c7 }
        L_0x0082:
            r10 = r3
            com.autonavi.amap.mapcore.MapConfig r0 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            int r12 = r12.a()     // Catch:{ Throwable -> 0x00c7 }
            r0.setCustomBackgroundColor(r12)     // Catch:{ Throwable -> 0x00c7 }
            if (r10 == 0) goto L_0x00a1
            int r12 = r10.length     // Catch:{ Throwable -> 0x00c7 }
            if (r12 <= 0) goto L_0x00a1
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 1
            r9 = 1
            r3 = r11
            r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00c7 }
            android.content.Context r12 = r11.k     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.du.a(r12, r1)     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x00c4
        L_0x00a1:
            android.content.Context r12 = r11.k     // Catch:{ Throwable -> 0x00c7 }
            com.amap.api.col.n3.du.a(r12, r2)     // Catch:{ Throwable -> 0x00c7 }
            goto L_0x00c4
        L_0x00a7:
            r11.f(r1, r2)     // Catch:{ Throwable -> 0x00c7 }
            r4 = 1
            com.autonavi.amap.mapcore.MapConfig r12 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            int r5 = r12.getMapStyleMode()     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.MapConfig r12 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            int r6 = r12.getMapStyleTime()     // Catch:{ Throwable -> 0x00c7 }
            com.autonavi.amap.mapcore.MapConfig r12 = r11.g     // Catch:{ Throwable -> 0x00c7 }
            int r7 = r12.getMapStyleState()     // Catch:{ Throwable -> 0x00c7 }
            r8 = 1
            r9 = 0
            r10 = 0
            r3 = r11
            r3.a(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00c7 }
        L_0x00c4:
            r11.ac = r2     // Catch:{ Throwable -> 0x00c7 }
            return
        L_0x00c7:
            r12 = move-exception
            r12.printStackTrace()
            return
        L_0x00cc:
            com.amap.api.col.n3.a$a r0 = r11.bh
            r0.b = r1
            com.amap.api.col.n3.a$a r0 = r11.bh
            r0.c = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.setMapCustomEnable(boolean):void");
    }

    public final void removeGLOverlay(BaseMapOverlay baseMapOverlay) {
        if (this.l != null) {
            this.l.getOvelayBundle(1).removeOverlay(baseMapOverlay);
        }
    }

    public final float[] v() {
        if (this.l != null) {
            GLMapState mapState = this.l.getMapState(1);
            mapState.getViewMatrix(this.w);
            mapState.getProjectionMatrix(this.x);
            if (this.w == null || this.x == null) {
                return this.v;
            }
            Matrix.multiplyMM(this.v, 0, this.x, 0, this.w, 0);
        }
        return this.v;
    }

    public final String c(String str) {
        if (this.f != null) {
            return this.f.a(str);
        }
        return null;
    }

    public final void f(boolean z2) {
        if (!this.ag) {
            this.c.f(z2);
        }
    }

    public final float[] getViewMatrix() {
        if (this.aT && this.aU && this.l != null) {
            GLMapState mapState = this.l.getMapState(1);
            if (mapState != null) {
                mapState.getViewMatrix(this.w);
            }
        }
        return this.w;
    }

    public final float[] getProjectionMatrix() {
        if (this.aT && this.aU && this.l != null) {
            GLMapState mapState = this.l.getMapState(1);
            if (mapState != null) {
                mapState.getProjectionMatrix(this.x);
            }
        }
        return this.x;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b5 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c3 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00db A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0138 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0145 A[Catch:{ all -> 0x0263, Throwable -> 0x0267 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void changeSurface(javax.microedition.khronos.opengles.GL10 r22, int r23, int r24) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r11 = r23
            r12 = r24
            r3 = 0
            r1.aX = r3     // Catch:{ Throwable -> 0x0267 }
            boolean r4 = r1.aT     // Catch:{ Throwable -> 0x0267 }
            if (r4 != 0) goto L_0x0013
            r4 = 0
            r1.a((javax.microedition.khronos.opengles.GL10) r2, (javax.microedition.khronos.egl.EGLConfig) r4)     // Catch:{ Throwable -> 0x0267 }
        L_0x0013:
            r1.n = r11     // Catch:{ Throwable -> 0x0267 }
            r1.o = r12     // Catch:{ Throwable -> 0x0267 }
            android.graphics.Rect r4 = new android.graphics.Rect     // Catch:{ Throwable -> 0x0267 }
            r4.<init>(r3, r3, r11, r12)     // Catch:{ Throwable -> 0x0267 }
            r1.ax = r4     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r1.aU     // Catch:{ Throwable -> 0x0267 }
            r13 = 1
            if (r3 != 0) goto L_0x0172
            android.content.Context r3 = r1.k     // Catch:{ Throwable -> 0x0267 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ Throwable -> 0x0267 }
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()     // Catch:{ Throwable -> 0x0267 }
            int r3 = r3.densityDpi     // Catch:{ Throwable -> 0x0267 }
            android.content.Context r4 = r1.k     // Catch:{ Throwable -> 0x0267 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ Throwable -> 0x0267 }
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()     // Catch:{ Throwable -> 0x0267 }
            float r4 = r4.density     // Catch:{ Throwable -> 0x0267 }
            r5 = 3
            r6 = 50
            r7 = 2
            r8 = 120(0x78, float:1.68E-43)
            r9 = 100
            if (r3 <= r8) goto L_0x0077
            r10 = 160(0xa0, float:2.24E-43)
            r14 = 480(0x1e0, float:6.73E-43)
            if (r3 > r10) goto L_0x0053
            int r3 = java.lang.Math.max(r23, r24)     // Catch:{ Throwable -> 0x0267 }
            if (r3 > r14) goto L_0x0077
            r6 = r8
            goto L_0x0078
        L_0x0053:
            r8 = 240(0xf0, float:3.36E-43)
            if (r3 > r8) goto L_0x0067
            int r3 = java.lang.Math.min(r23, r24)     // Catch:{ Throwable -> 0x0267 }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r5) goto L_0x0064
            r6 = 60
        L_0x0061:
            r20 = r7
            goto L_0x007a
        L_0x0064:
            r6 = 70
            goto L_0x0061
        L_0x0067:
            r7 = 320(0x140, float:4.48E-43)
            if (r3 > r7) goto L_0x006e
        L_0x006b:
            r20 = r5
            goto L_0x007a
        L_0x006e:
            if (r3 > r14) goto L_0x0071
            goto L_0x006b
        L_0x0071:
            r6 = 40
            r3 = 4
            r20 = r3
            goto L_0x007a
        L_0x0077:
            r6 = r9
        L_0x0078:
            r20 = r13
        L_0x007a:
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 2051(0x803, float:2.874E-42)
            r3 = 1120403456(0x42c80000, float:100.0)
            float r4 = r4 * r3
            int r4 = (int) r4     // Catch:{ Throwable -> 0x0267 }
            r17 = r6
            r18 = r4
            r19 = r4
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
            float r4 = (float) r6     // Catch:{ Throwable -> 0x0267 }
            float r4 = r4 / r3
            r1.aM = r4     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x00a5
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            float r4 = r1.aM     // Catch:{ Throwable -> 0x0267 }
            r3.setMapZoomScale(r4)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            r3.setMapWidth(r11)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            r3.setMapHeight(r12)     // Catch:{ Throwable -> 0x0267 }
        L_0x00a5:
            com.autonavi.ae.gmap.GLMapEngine r4 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r5 = 1
            r6 = 1001(0x3e9, float:1.403E-42)
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r4.setParamater(r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r1.aN     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x00c3
            com.autonavi.ae.gmap.GLMapEngine r4 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r5 = 1
            r6 = 1900(0x76c, float:2.662E-42)
            r7 = 1
            r8 = 15
            r9 = 0
            r10 = 0
            r4.setParamater(r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0267 }
            goto L_0x00d3
        L_0x00c3:
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 1900(0x76c, float:2.662E-42)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
        L_0x00d3:
            r3 = 18
            boolean r3 = r1.c((int) r13, (int) r3)     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x00f8
            com.autonavi.ae.gmap.GLMapEngine r4 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r5 = 1
            r6 = 1021(0x3fd, float:1.431E-42)
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r4.setParamater(r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 1022(0x3fe, float:1.432E-42)
            r17 = 1
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
            goto L_0x0114
        L_0x00f8:
            com.autonavi.ae.gmap.GLMapEngine r3 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r4 = 1
            r5 = 1021(0x3fd, float:1.431E-42)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r3.setParamater(r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 1022(0x3fe, float:1.432E-42)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
        L_0x0114:
            com.autonavi.ae.gmap.GLMapEngine r3 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r4 = 1
            r5 = 1023(0x3ff, float:1.434E-42)
            r6 = 1
            r7 = 0
            r8 = 0
            r9 = 0
            r3.setParamater(r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 1026(0x402, float:1.438E-42)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
            r3 = 16
            boolean r3 = r1.c((int) r13, (int) r3)     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0145
            com.autonavi.ae.gmap.GLMapEngine r4 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r5 = 1
            r6 = 2010(0x7da, float:2.817E-42)
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 0
            r4.setParamater(r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0267 }
            goto L_0x0155
        L_0x0145:
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 2010(0x7da, float:2.817E-42)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
        L_0x0155:
            com.autonavi.ae.gmap.GLMapEngine r3 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r4 = 1
            r5 = 1029(0x405, float:1.442E-42)
            r6 = 17
            r7 = 0
            r8 = 0
            r9 = 0
            r3.setParamater(r4, r5, r6, r7, r8, r9)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 2012(0x7dc, float:2.82E-42)
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
        L_0x0172:
            com.autonavi.ae.gmap.GLMapEngine r3 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r4 = 1
            r5 = 0
            r6 = 0
            r7 = r11
            r8 = r12
            r9 = r11
            r10 = r12
            r3.changeSurface(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x0267 }
            monitor-enter(r21)     // Catch:{ Throwable -> 0x0267 }
            r1.aU = r13     // Catch:{ all -> 0x0263 }
            monitor-exit(r21)     // Catch:{ all -> 0x0263 }
            int r3 = r1.ba     // Catch:{ Throwable -> 0x0267 }
            if (r3 != 0) goto L_0x0199
            int r3 = r1.bb     // Catch:{ Throwable -> 0x0267 }
            if (r3 != 0) goto L_0x0199
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r4 = r11 >> 1
            r3.setAnchorX(r4)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r4 = r12 >> 1
            r3.setAnchorY(r4)     // Catch:{ Throwable -> 0x0267 }
            goto L_0x01bb
        L_0x0199:
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r4 = r1.ba     // Catch:{ Throwable -> 0x0267 }
            int r5 = r11 + -1
            int r4 = java.lang.Math.min(r4, r5)     // Catch:{ Throwable -> 0x0267 }
            int r4 = java.lang.Math.max(r13, r4)     // Catch:{ Throwable -> 0x0267 }
            r3.setAnchorX(r4)     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r4 = r1.bb     // Catch:{ Throwable -> 0x0267 }
            int r5 = r12 + -1
            int r4 = java.lang.Math.min(r4, r5)     // Catch:{ Throwable -> 0x0267 }
            int r4 = java.lang.Math.max(r13, r4)     // Catch:{ Throwable -> 0x0267 }
            r3.setAnchorY(r4)     // Catch:{ Throwable -> 0x0267 }
        L_0x01bb:
            com.autonavi.ae.gmap.GLMapEngine r14 = r1.l     // Catch:{ Throwable -> 0x0267 }
            r15 = 1
            r16 = 1100(0x44c, float:1.541E-42)
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r17 = r3.getAnchorX()     // Catch:{ Throwable -> 0x0267 }
            com.autonavi.amap.mapcore.MapConfig r3 = r1.g     // Catch:{ Throwable -> 0x0267 }
            int r18 = r3.getAnchorY()     // Catch:{ Throwable -> 0x0267 }
            r19 = 0
            r20 = 0
            r14.setParamater(r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x0267 }
            r1.b = r13     // Catch:{ Throwable -> 0x0267 }
            com.amap.api.col.n3.a$a r3 = r1.bi     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x01e0
            com.amap.api.col.n3.a$a r3 = r1.bi     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x01e0:
            com.amap.api.col.n3.a$a r3 = r1.bg     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x01eb
            com.amap.api.col.n3.a$a r3 = r1.bg     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x01eb:
            com.amap.api.col.n3.a$a r3 = r1.be     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x01f6
            com.amap.api.col.n3.a$a r3 = r1.be     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x01f6:
            com.amap.api.col.n3.a$a r3 = r1.bh     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0201
            com.amap.api.col.n3.a$a r3 = r1.bh     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x0201:
            com.amap.api.col.n3.a$a r3 = r1.bd     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x020c
            com.amap.api.col.n3.a$a r3 = r1.bd     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x020c:
            com.amap.api.col.n3.a$a r3 = r1.bj     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0217
            com.amap.api.col.n3.a$a r3 = r1.bj     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x0217:
            com.amap.api.col.n3.a$a r3 = r1.bk     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0222
            com.amap.api.col.n3.a$a r3 = r1.bk     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x0222:
            com.amap.api.col.n3.a$a r3 = r1.bl     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x022d
            com.amap.api.col.n3.a$a r3 = r1.bl     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x022d:
            com.amap.api.col.n3.a$a r3 = r1.bo     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0238
            com.amap.api.col.n3.a$a r3 = r1.bo     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x0238:
            com.amap.api.col.n3.a$a r3 = r1.bm     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0243
            com.amap.api.col.n3.a$a r3 = r1.bm     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x0243:
            com.amap.api.col.n3.a$a r3 = r1.bf     // Catch:{ Throwable -> 0x0267 }
            boolean r3 = r3.b     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x024e
            com.amap.api.col.n3.a$a r3 = r1.bf     // Catch:{ Throwable -> 0x0267 }
            r3.run()     // Catch:{ Throwable -> 0x0267 }
        L_0x024e:
            com.amap.api.maps.CustomRenderer r3 = r1.i     // Catch:{ Throwable -> 0x0267 }
            if (r3 == 0) goto L_0x0257
            com.amap.api.maps.CustomRenderer r3 = r1.i     // Catch:{ Throwable -> 0x0267 }
            r3.onSurfaceChanged(r2, r11, r12)     // Catch:{ Throwable -> 0x0267 }
        L_0x0257:
            android.os.Handler r2 = r1.r     // Catch:{ Throwable -> 0x0267 }
            if (r2 == 0) goto L_0x0262
            android.os.Handler r2 = r1.r     // Catch:{ Throwable -> 0x0267 }
            java.lang.Runnable r3 = r1.bn     // Catch:{ Throwable -> 0x0267 }
            r2.post(r3)     // Catch:{ Throwable -> 0x0267 }
        L_0x0262:
            return
        L_0x0263:
            r0 = move-exception
            r2 = r0
            monitor-exit(r21)     // Catch:{ Throwable -> 0x0267 }
            throw r2     // Catch:{ Throwable -> 0x0267 }
        L_0x0267:
            r0 = move-exception
            r2 = r0
            r2.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.a.changeSurface(javax.microedition.khronos.opengles.GL10, int, int):void");
    }

    public final void createSurface(GL10 gl10, EGLConfig eGLConfig) {
        try {
            a(gl10, eGLConfig);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void renderSurface(GL10 gl10) {
        drawFrame(gl10);
    }

    public final boolean canStopMapRender() {
        if (this.l != null) {
            this.l.canStopMapRender(1);
        }
        return true;
    }

    public final void getLatLngRect(DPoint[] dPointArr) {
        try {
            Rectangle geoRectangle = this.g.getGeoRectangle();
            if (geoRectangle != null) {
                IPoint[] clipRect = geoRectangle.getClipRect();
                for (int i2 = 0; i2 < 4; i2++) {
                    GLMapState.geo2LonLat(clipRect[i2].x, clipRect[i2].y, dPointArr[i2]);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void checkMapState(GLMapState gLMapState) {
        IPoint[] iPointArr;
        GLMapState gLMapState2 = gLMapState;
        if (this.g != null && !this.ag) {
            LatLngBounds limitLatLngBounds = this.g.getLimitLatLngBounds();
            if (limitLatLngBounds != null) {
                try {
                    IPoint[] limitIPoints = this.g.getLimitIPoints();
                    if (limitIPoints == null) {
                        IPoint obtain = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.northeast.longitude, limitLatLngBounds.northeast.latitude, obtain);
                        IPoint obtain2 = IPoint.obtain();
                        GLMapState.lonlat2Geo(limitLatLngBounds.southwest.longitude, limitLatLngBounds.southwest.latitude, obtain2);
                        iPointArr = new IPoint[]{obtain, obtain2};
                        this.g.setLimitIPoints(iPointArr);
                    } else {
                        iPointArr = limitIPoints;
                    }
                    float a2 = dv.a(this.g, iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, getMapWidth(), getMapHeight());
                    float mapZoomer = gLMapState.getMapZoomer();
                    if (this.g.isSetLimitZoomLevel()) {
                        float maxZoomLevel = this.g.getMaxZoomLevel();
                        float minZoomLevel = this.g.getMinZoomLevel();
                        if (a2 < maxZoomLevel) {
                            if (a2 > minZoomLevel) {
                                a2 = Math.max(a2, Math.min(mapZoomer, maxZoomLevel));
                            }
                        }
                    } else if (a2 <= 0.0f || mapZoomer >= a2) {
                        a2 = mapZoomer;
                    }
                    gLMapState2.setMapZoomer(a2);
                    IPoint obtain3 = IPoint.obtain();
                    gLMapState2.getGeoCenter(obtain3);
                    int i2 = obtain3.x;
                    int i3 = obtain3.y;
                    int[] a3 = dv.a(iPointArr[0].x, iPointArr[0].y, iPointArr[1].x, iPointArr[1].y, this.g, gLMapState2, i2, i3);
                    if (a3 != null && a3.length == 2) {
                        i2 = a3[0];
                        i3 = a3[1];
                    }
                    gLMapState2.setMapGeoCenter(i2, i3);
                    obtain3.recycle();
                } catch (Throwable unused) {
                }
            } else if (this.g.isSetLimitZoomLevel()) {
                gLMapState2.setMapZoomer(Math.max(this.g.getMinZoomLevel(), Math.min(gLMapState.getMapZoomer(), this.g.getMaxZoomLevel())));
            }
        }
    }

    public final void setRenderMode(int i2) {
        if (this.ad != null) {
            this.ah = i2;
            this.ad.setRenderMode(i2);
        }
    }

    public final cv m(int i2) {
        if (this.p == null) {
            return null;
        }
        return this.p.a(i2);
    }

    public final cw w() {
        return this.p;
    }

    public final void a(int i2, int i3) {
        if (this.g != null) {
            this.n = i2;
            this.o = i3;
            this.g.setMapWidth(i2);
            this.g.setMapHeight(i3);
        }
    }
}
