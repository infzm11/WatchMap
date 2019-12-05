package com.amap.api.services.a;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.services.a.q;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* compiled from: NearbySearchCore */
public class ar implements INearbySearch {
    private static long e;
    /* access modifiers changed from: private */
    public List<NearbySearch.NearbyListener> a = new ArrayList();
    private String b;
    private Context c;
    /* access modifiers changed from: private */
    public q d;
    private ExecutorService f;
    private LatLonPoint g = null;
    private String h = null;
    private boolean i = false;
    private Timer j = new Timer();
    /* access modifiers changed from: private */
    public UploadInfoCallback k;
    private TimerTask l;

    /* compiled from: NearbySearchCore */
    private class a extends TimerTask {
        private a() {
        }

        public void run() {
            try {
                if (ar.this.k != null) {
                    int b = ar.this.b(ar.this.k.OnUploadInfoCallback());
                    Message obtainMessage = ar.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = ar.this.a;
                    obtainMessage.what = b;
                    ar.this.d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                i.a(th, "NearbySearch", "UpdateDataTask");
            }
        }
    }

    public ar(Context context) {
        this.c = context.getApplicationContext();
        this.d = q.a();
    }

    public synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.a.add(nearbyListener);
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "addNearbyListener");
        }
        return;
    }

    public synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener != null) {
            try {
                this.a.remove(nearbyListener);
            } catch (Throwable th) {
                i.a(th, "NearbySearch", "removeNearbyListener");
            }
        } else {
            return;
        }
        return;
    }

    public void clearUserInfoAsyn() {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = ar.this.d.obtainMessage();
                    obtainMessage.arg1 = 8;
                    obtainMessage.obj = ar.this.a;
                    try {
                        int unused = ar.this.a();
                        obtainMessage.what = 1000;
                        if (ar.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        i.a(e, "NearbySearch", "clearUserInfoAsyn");
                        if (ar.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (ar.this.d != null) {
                            ar.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    ar.this.d.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    /* access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (this.i) {
                throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
            } else if (!a(this.b)) {
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            } else {
                o.a(this.c);
                return ((Integer) new r(this.c, this.b).c()).intValue();
            }
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    public void setUserID(String str) {
        this.b = str;
    }

    public synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i2) {
        if (i2 < 7000) {
            i2 = 7000;
        }
        try {
            this.k = uploadInfoCallback;
            if (this.i && this.l != null) {
                this.l.cancel();
            }
            this.i = true;
            this.l = new a();
            this.j.schedule(this.l, 0, (long) i2);
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
        return;
    }

    public synchronized void stopUploadNearbyInfoAuto() {
        try {
            if (this.l != null) {
                this.l.cancel();
            }
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "stopUploadNearbyInfoAuto");
        }
        this.i = false;
        this.l = null;
    }

    /* access modifiers changed from: private */
    public int a(UploadInfo uploadInfo) {
        if (this.i) {
            return AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR;
        }
        return b(uploadInfo);
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* access modifiers changed from: private */
    public int b(UploadInfo uploadInfo) {
        try {
            o.a(this.c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - e < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            e = time;
            String userID = uploadInfo.getUserID();
            if (!a(userID)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            if (TextUtils.isEmpty(this.h)) {
                this.h = userID;
            }
            if (!userID.equals(this.h)) {
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            LatLonPoint point = uploadInfo.getPoint();
            if (point == null) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
            }
            if (point.equals(this.g)) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
            }
            Integer num = (Integer) new t(this.c, uploadInfo).c();
            this.g = point.copy();
            return 1000;
        } catch (AMapException e2) {
            return e2.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    public void uploadNearbyInfoAsyn(final UploadInfo uploadInfo) {
        if (this.f == null) {
            this.f = Executors.newSingleThreadExecutor();
        }
        this.f.submit(new Runnable() {
            public void run() {
                try {
                    Message obtainMessage = ar.this.d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = ar.this.a;
                    obtainMessage.what = ar.this.a(uploadInfo);
                    ar.this.d.sendMessage(obtainMessage);
                } catch (Throwable th) {
                    i.a(th, "NearbySearch", "uploadNearbyInfoAsyn");
                }
            }
        });
    }

    public void searchNearbyInfoAsyn(final NearbySearch.NearbyQuery nearbyQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = ar.this.d.obtainMessage();
                    obtainMessage.arg1 = 9;
                    q.f fVar = new q.f();
                    fVar.a = ar.this.a;
                    obtainMessage.obj = fVar;
                    try {
                        fVar.b = ar.this.searchNearbyInfo(nearbyQuery);
                        obtainMessage.what = 1000;
                        if (ar.this.d == null) {
                            return;
                        }
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                        i.a(e, "NearbySearch", "searchNearbyInfoAsyn");
                        if (ar.this.d == null) {
                            return;
                        }
                    } catch (Throwable th) {
                        if (ar.this.d != null) {
                            ar.this.d.sendMessage(obtainMessage);
                        }
                        throw th;
                    }
                    ar.this.d.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    public NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            o.a(this.c);
            if (a(nearbyQuery)) {
                return (NearbySearchResult) new s(this.c, nearbyQuery).c();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e2) {
            throw e2;
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    private boolean a(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    public synchronized void destroy() {
        try {
            this.j.cancel();
        } catch (Throwable th) {
            i.a(th, "NearbySearch", "destryoy");
        }
        return;
    }
}
