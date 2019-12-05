package com.amap.api.maps.offlinemap;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.n3.al;
import com.amap.api.col.n3.am;
import com.amap.api.col.n3.aq;
import com.amap.api.col.n3.dv;
import com.amap.api.col.n3.iu;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapException;
import java.util.ArrayList;
import java.util.Iterator;

public final class OfflineMapManager {
    aq a;
    am b;
    private Context c;
    /* access modifiers changed from: private */
    public OfflineMapDownloadListener d;
    /* access modifiers changed from: private */
    public OfflineLoadedListener e;
    /* access modifiers changed from: private */
    public Handler f = new Handler(this.c.getMainLooper());
    private Handler g = new Handler(this.c.getMainLooper());

    public interface OfflineLoadedListener {
        void onVerifyComplete();
    }

    public interface OfflineMapDownloadListener {
        void onCheckUpdate(boolean z, String str);

        void onDownload(int i, int i2, String str);

        void onRemove(boolean z, String str, String str2);
    }

    public final void restart() {
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        a(context);
    }

    public OfflineMapManager(Context context, OfflineMapDownloadListener offlineMapDownloadListener, AMap aMap) {
        this.d = offlineMapDownloadListener;
        this.c = context.getApplicationContext();
        try {
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(Context context) {
        this.c = context.getApplicationContext();
        am.b = false;
        this.b = am.a(this.c);
        this.b.a((am.a) new am.a() {
            public final void a(final al alVar) {
                if (OfflineMapManager.this.d != null && alVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public final void run() {
                            try {
                                OfflineMapManager.this.d.onDownload(alVar.c().b(), alVar.getcompleteCode(), alVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void b(final al alVar) {
                if (OfflineMapManager.this.d != null && alVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public final void run() {
                            try {
                                if (!alVar.c().equals(alVar.g)) {
                                    if (!alVar.c().equals(alVar.a)) {
                                        OfflineMapManager.this.d.onCheckUpdate(false, alVar.getCity());
                                        return;
                                    }
                                }
                                OfflineMapManager.this.d.onCheckUpdate(true, alVar.getCity());
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void c(final al alVar) {
                if (OfflineMapManager.this.d != null && alVar != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public final void run() {
                            try {
                                if (alVar.c().equals(alVar.a)) {
                                    OfflineMapManager.this.d.onRemove(true, alVar.getCity(), "");
                                } else {
                                    OfflineMapManager.this.d.onRemove(false, alVar.getCity(), "");
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }

            public final void a() {
                if (OfflineMapManager.this.e != null) {
                    OfflineMapManager.this.f.post(new Runnable() {
                        public final void run() {
                            try {
                                OfflineMapManager.this.e.onVerifyComplete();
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        });
        try {
            this.b.a();
            this.a = this.b.f;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityCode(String str) throws AMapException {
        try {
            this.b.e(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByCityName(String str) throws AMapException {
        try {
            this.b.d(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void downloadByProvinceName(String str) throws AMapException {
        try {
            if (!dv.c(this.c)) {
                throw new AMapException(AMapException.ERROR_CONNECTION);
            }
            OfflineMapProvince itemByProvinceName = getItemByProvinceName(str);
            if (itemByProvinceName == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            Iterator<OfflineMapCity> it = itemByProvinceName.getCityList().iterator();
            while (it.hasNext()) {
                final String city = it.next().getCity();
                this.g.post(new Runnable() {
                    public final void run() {
                        try {
                            OfflineMapManager.this.b.d(city);
                        } catch (AMapException e) {
                            iu.b((Throwable) e, "OfflineMapManager", "downloadByProvinceName");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if (th instanceof AMapException) {
                throw ((AMapException) th);
            }
            iu.b(th, "OfflineMapManager", "downloadByProvinceName");
        }
    }

    public final void remove(String str) {
        try {
            if (this.b.b(str)) {
                this.b.c(str);
                return;
            }
            OfflineMapProvince c2 = this.a.c(str);
            if (c2 != null) {
                if (c2.getCityList() != null) {
                    Iterator<OfflineMapCity> it = c2.getCityList().iterator();
                    while (it.hasNext()) {
                        final String city = it.next().getCity();
                        this.g.post(new Runnable() {
                            public final void run() {
                                OfflineMapManager.this.b.c(city);
                            }
                        });
                    }
                    return;
                }
            }
            if (this.d != null) {
                this.d.onRemove(false, str, "没有该城市");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ArrayList<OfflineMapProvince> getOfflineMapProvinceList() {
        return this.a.a();
    }

    public final OfflineMapCity getItemByCityCode(String str) {
        return this.a.a(str);
    }

    public final OfflineMapCity getItemByCityName(String str) {
        return this.a.b(str);
    }

    public final OfflineMapProvince getItemByProvinceName(String str) {
        return this.a.c(str);
    }

    public final ArrayList<OfflineMapCity> getOfflineMapCityList() {
        return this.a.b();
    }

    public final ArrayList<OfflineMapCity> getDownloadingCityList() {
        return this.a.e();
    }

    public final ArrayList<OfflineMapProvince> getDownloadingProvinceList() {
        return this.a.f();
    }

    public final ArrayList<OfflineMapCity> getDownloadOfflineMapCityList() {
        return this.a.c();
    }

    public final ArrayList<OfflineMapProvince> getDownloadOfflineMapProvinceList() {
        return this.a.d();
    }

    private void a(String str) throws AMapException {
        this.b.a(str);
    }

    public final void updateOfflineCityByCode(String str) throws AMapException {
        OfflineMapCity itemByCityCode = getItemByCityCode(str);
        if (itemByCityCode == null || itemByCityCode.getCity() == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        a(itemByCityCode.getCity());
    }

    public final void updateOfflineCityByName(String str) throws AMapException {
        a(str);
    }

    public final void updateOfflineMapProvinceByName(String str) throws AMapException {
        a(str);
    }

    public final void stop() {
        this.b.d();
    }

    public final void pause() {
        this.b.e();
    }

    public final void destroy() {
        try {
            if (this.b != null) {
                this.b.f();
            }
            this.d = null;
            if (this.f != null) {
                this.f.removeCallbacksAndMessages((Object) null);
            }
            this.f = null;
            if (this.g != null) {
                this.g.removeCallbacksAndMessages((Object) null);
            }
            this.g = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnOfflineLoadedListener(OfflineLoadedListener offlineLoadedListener) {
        this.e = offlineLoadedListener;
    }
}
