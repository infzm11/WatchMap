package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.ITrafficSearch;
import com.amap.api.services.traffic.RoadTrafficQuery;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.iflytek.cloud.SpeechUtility;

/* compiled from: TrafficSearchCore */
public class aw implements ITrafficSearch {
    private static final String a = "aw";
    /* access modifiers changed from: private */
    public TrafficSearch.OnTrafficSearchListener b;
    private Context c;
    /* access modifiers changed from: private */
    public Handler d = q.a();

    public aw(Context context) {
        this.c = context.getApplicationContext();
    }

    public void setTrafficSearchListener(TrafficSearch.OnTrafficSearchListener onTrafficSearchListener) {
        this.b = onTrafficSearchListener;
    }

    public TrafficStatusResult loadTrafficByRoad(RoadTrafficQuery roadTrafficQuery) throws AMapException {
        try {
            o.a(this.c);
            if (roadTrafficQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return (TrafficStatusResult) new ac(this.c, roadTrafficQuery.clone()).c();
        } catch (AMapException e) {
            i.a(e, a, "loadTrafficByRoad");
            throw e;
        }
    }

    public void loadTrafficByRoadAsyn(final RoadTrafficQuery roadTrafficQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.what = 300;
                    obtainMessage.arg1 = 15;
                    Bundle bundle = new Bundle();
                    TrafficStatusResult trafficStatusResult = null;
                    try {
                        TrafficStatusResult loadTrafficByRoad = aw.this.loadTrafficByRoad(roadTrafficQuery);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = aw.this.b;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, loadTrafficByRoad);
                        } catch (AMapException e) {
                            TrafficStatusResult trafficStatusResult2 = loadTrafficByRoad;
                            e = e;
                            trafficStatusResult = trafficStatusResult2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                obtainMessage.obj = aw.this.b;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, trafficStatusResult);
                                obtainMessage.setData(bundle);
                                aw.this.d.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                obtainMessage.obj = aw.this.b;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, trafficStatusResult);
                                obtainMessage.setData(bundle);
                                aw.this.d.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            TrafficStatusResult trafficStatusResult3 = loadTrafficByRoad;
                            th = th2;
                            trafficStatusResult = trafficStatusResult3;
                            obtainMessage.obj = aw.this.b;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, trafficStatusResult);
                            obtainMessage.setData(bundle);
                            aw.this.d.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (AMapException e2) {
                        e = e2;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        obtainMessage.obj = aw.this.b;
                        bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, trafficStatusResult);
                        obtainMessage.setData(bundle);
                        aw.this.d.sendMessage(obtainMessage);
                    }
                    obtainMessage.setData(bundle);
                    aw.this.d.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, a, "loadTrafficByRoadAsyn");
        }
    }
}
