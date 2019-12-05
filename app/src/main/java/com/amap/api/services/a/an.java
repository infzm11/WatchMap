package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.a.q;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.iflytek.cloud.util.AudioDetector;
import java.util.HashMap;
import java.util.List;

/* compiled from: CloudSearchCore */
public class an implements ICloudSearch {
    private Context a;
    /* access modifiers changed from: private */
    public CloudSearch.OnCloudSearchListener b;
    private CloudSearch.Query c;
    private int d;
    private HashMap<Integer, CloudResult> e;
    /* access modifiers changed from: private */
    public Handler f = q.a();

    public an(Context context) {
        this.a = context.getApplicationContext();
    }

    public void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.b = onCloudSearchListener;
    }

    /* access modifiers changed from: private */
    public CloudResult a(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult;
        try {
            if (!b(query)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!query.queryEquals(this.c)) {
                this.d = 0;
                this.c = query.clone();
                if (this.e != null) {
                    this.e.clear();
                }
            }
            if (this.d == 0) {
                CloudResult cloudResult2 = (CloudResult) new g(this.a, query).c();
                try {
                    a(cloudResult2, query);
                    return cloudResult2;
                } catch (Throwable th) {
                    th = th;
                }
            } else {
                cloudResult = a(query.getPageNum());
                if (cloudResult != null) {
                    return cloudResult;
                }
                CloudResult cloudResult3 = (CloudResult) new g(this.a, query).c();
                this.e.put(Integer.valueOf(query.getPageNum()), cloudResult3);
                return cloudResult3;
            }
        } catch (Throwable th2) {
            th = th2;
            cloudResult = null;
            i.a(th, "CloudSearch", "searchCloud");
            if (th instanceof AMapException) {
                throw ((AMapException) th);
            }
            th.printStackTrace();
            return cloudResult;
        }
    }

    public void searchCloudAsyn(final CloudSearch.Query query) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = AudioDetector.DEF_EOS;
                        q.d dVar = new q.d();
                        dVar.b = an.this.b;
                        obtainMessage.obj = dVar;
                        dVar.a = an.this.a(query);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        an.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    an.this.f.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public CloudItemDetail a(String str, String str2) throws AMapException {
        if (str == null || str.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else if (str2 == null || str2.trim().equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } else {
            try {
                return (CloudItemDetail) new f(this.a, new y(str, str2)).c();
            } catch (Throwable th) {
                i.a(th, "CloudSearch", "searchCloudDetail");
                if (th instanceof AMapException) {
                    throw ((AMapException) th);
                }
                th.printStackTrace();
                return null;
            }
        }
    }

    public void searchCloudDetailAsyn(final String str, final String str2) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    try {
                        obtainMessage.arg1 = 12;
                        obtainMessage.what = 701;
                        q.c cVar = new q.c();
                        cVar.b = an.this.b;
                        obtainMessage.obj = cVar;
                        cVar.a = an.this.a(str, str2);
                        obtainMessage.arg2 = 1000;
                    } catch (AMapException e) {
                        obtainMessage.arg2 = e.getErrorCode();
                    } catch (Throwable th) {
                        an.this.f.sendMessage(obtainMessage);
                        throw th;
                    }
                    an.this.f.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(CloudResult cloudResult, CloudSearch.Query query) {
        this.e = new HashMap<>();
        if (this.d > 0) {
            this.e.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    /* access modifiers changed from: protected */
    public CloudResult a(int i) {
        if (b(i)) {
            return this.e.get(Integer.valueOf(i));
        }
        throw new IllegalArgumentException("page out of range");
    }

    private boolean b(int i) {
        return i <= this.d && i > 0;
    }

    private boolean b(CloudSearch.Query query) {
        if (query == null || i.a(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }
}
