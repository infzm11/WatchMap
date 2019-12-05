package com.amap.api.services.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.amap.api.services.share.ShareSearch;
import com.amap.api.services.traffic.TrafficSearch;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.iflytek.cloud.SpeechUtility;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageHandler */
public class q extends Handler {
    private static q a;

    /* compiled from: MessageHandler */
    public static class a {
        public BusLineResult a;
        public BusLineSearch.OnBusLineSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class b {
        public BusStationResult a;
        public BusStationSearch.OnBusStationSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class c {
        public CloudItemDetail a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class d {
        public CloudResult a;
        public CloudSearch.OnCloudSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class e {
        public GeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class f {
        public List<NearbySearch.NearbyListener> a;
        public NearbySearchResult b;
    }

    /* compiled from: MessageHandler */
    public static class g {
        public PoiItem a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class h {
        public PoiResult a;
        public PoiSearch.OnPoiSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class i {
        public RegeocodeResult a;
        public GeocodeSearch.OnGeocodeSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class j {
        public RoutePOISearchResult a;
        public RoutePOISearch.OnRoutePOISearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class k {
        public LocalWeatherForecastResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    /* compiled from: MessageHandler */
    public static class l {
        public LocalWeatherLiveResult a;
        public WeatherSearch.OnWeatherSearchListener b;
    }

    public static synchronized q a() {
        q qVar;
        synchronized (q.class) {
            if (a == null) {
                if (Looper.myLooper() != null) {
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        a = new q();
                    }
                }
                a = new q(Looper.getMainLooper());
            }
            qVar = a;
        }
        return qVar;
    }

    q() {
    }

    q(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        try {
            switch (message.arg1) {
                case 1:
                    k(message);
                    return;
                case 2:
                    h(message);
                    return;
                case 3:
                    j(message);
                    return;
                case 4:
                    i(message);
                    return;
                case 5:
                    g(message);
                    return;
                case 6:
                    f(message);
                    return;
                case 7:
                    e(message);
                    return;
                case 8:
                    d(message);
                    return;
                case 9:
                    c(message);
                    return;
                case 10:
                    b(message);
                    return;
                case 11:
                    a(message);
                    return;
                case 12:
                    l(message);
                    return;
                case 13:
                    m(message);
                    return;
                case 14:
                    n(message);
                    return;
                case 15:
                    o(message);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            i.a(th, "MessageHandler", "handleMessage");
        }
    }

    private void a(Message message) {
        int i2 = message.arg2;
        ShareSearch.OnShareSearchListener onShareSearchListener = (ShareSearch.OnShareSearchListener) message.obj;
        String string = message.getData().getString("shareurlkey");
        if (onShareSearchListener != null) {
            switch (message.what) {
                case AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR /*1100*/:
                    onShareSearchListener.onPoiShareUrlSearched(string, i2);
                    return;
                case AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR /*1101*/:
                    onShareSearchListener.onLocationShareUrlSearched(string, i2);
                    return;
                case AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT /*1102*/:
                    onShareSearchListener.onNaviShareUrlSearched(string, i2);
                    return;
                case AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT /*1103*/:
                    onShareSearchListener.onBusRouteShareUrlSearched(string, i2);
                    return;
                case 1104:
                    onShareSearchListener.onDrivingRouteShareUrlSearched(string, i2);
                    return;
                case 1105:
                    onShareSearchListener.onWalkRouteShareUrlSearched(string, i2);
                    return;
                default:
                    return;
            }
        }
    }

    private void b(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            for (NearbySearch.NearbyListener onNearbyInfoUploaded : list) {
                onNearbyInfoUploaded.onNearbyInfoUploaded(message.what);
            }
        }
    }

    private void c(Message message) {
        f fVar = (f) message.obj;
        if (fVar != null) {
            List<NearbySearch.NearbyListener> list = fVar.a;
            if (list != null && list.size() != 0) {
                NearbySearchResult nearbySearchResult = null;
                if (message.what == 1000) {
                    nearbySearchResult = fVar.b;
                }
                for (NearbySearch.NearbyListener onNearbyInfoSearched : list) {
                    onNearbyInfoSearched.onNearbyInfoSearched(nearbySearchResult, message.what);
                }
            }
        }
    }

    private void d(Message message) {
        List<NearbySearch.NearbyListener> list = (List) message.obj;
        if (list != null && list.size() != 0) {
            for (NearbySearch.NearbyListener onUserInfoCleared : list) {
                onUserInfoCleared.onUserInfoCleared(message.what);
            }
        }
    }

    private void e(Message message) {
        b bVar = (b) message.obj;
        if (bVar != null) {
            BusStationSearch.OnBusStationSearchListener onBusStationSearchListener = bVar.b;
            if (onBusStationSearchListener != null) {
                BusStationResult busStationResult = null;
                if (message.what == 1000) {
                    busStationResult = bVar.a;
                }
                onBusStationSearchListener.onBusStationSearched(busStationResult, message.what);
            }
        }
    }

    private void f(Message message) {
        if (message.what == 600) {
            h hVar = (h) message.obj;
            if (hVar != null) {
                PoiSearch.OnPoiSearchListener onPoiSearchListener = hVar.b;
                if (onPoiSearchListener != null) {
                    Bundle data = message.getData();
                    if (data != null) {
                        onPoiSearchListener.onPoiSearched(hVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
                    }
                }
            }
        } else if (message.what == 602) {
            g gVar = (g) message.obj;
            if (gVar != null) {
                PoiSearch.OnPoiSearchListener onPoiSearchListener2 = gVar.b;
                Bundle data2 = message.getData();
                if (data2 != null) {
                    onPoiSearchListener2.onPoiItemSearched(gVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
                }
            }
        }
    }

    private void g(Message message) {
        Inputtips.InputtipsListener inputtipsListener = (Inputtips.InputtipsListener) message.obj;
        if (inputtipsListener != null) {
            ArrayList arrayList = null;
            if (message.what == 1000) {
                arrayList = message.getData().getParcelableArrayList(SpeechUtility.TAG_RESOURCE_RESULT);
            }
            inputtipsListener.onGetInputtips(arrayList, message.what);
        }
    }

    private void h(Message message) {
        if (message.what == 201) {
            i iVar = (i) message.obj;
            if (iVar != null) {
                GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener = iVar.b;
                if (onGeocodeSearchListener != null) {
                    onGeocodeSearchListener.onRegeocodeSearched(iVar.a, message.arg2);
                }
            }
        } else if (message.what == 200) {
            e eVar = (e) message.obj;
            if (eVar != null) {
                GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener2 = eVar.b;
                if (onGeocodeSearchListener2 != null) {
                    onGeocodeSearchListener2.onGeocodeSearched(eVar.a, message.arg2);
                }
            }
        }
    }

    private void i(Message message) {
        DistrictSearch.OnDistrictSearchListener onDistrictSearchListener = (DistrictSearch.OnDistrictSearchListener) message.obj;
        if (onDistrictSearchListener != null) {
            onDistrictSearchListener.onDistrictSearched((DistrictResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT));
        }
    }

    private void j(Message message) {
        a aVar = (a) message.obj;
        if (aVar != null) {
            BusLineSearch.OnBusLineSearchListener onBusLineSearchListener = aVar.b;
            if (onBusLineSearchListener != null) {
                BusLineResult busLineResult = null;
                if (message.what == 1000) {
                    busLineResult = aVar.a;
                }
                onBusLineSearchListener.onBusLineSearched(busLineResult, message.what);
            }
        }
    }

    private void k(Message message) {
        RouteSearch.OnRouteSearchListener onRouteSearchListener = (RouteSearch.OnRouteSearchListener) message.obj;
        if (onRouteSearchListener != null) {
            if (message.what == 100) {
                Bundle data = message.getData();
                if (data != null) {
                    onRouteSearchListener.onBusRouteSearched((BusRouteResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT), data.getInt(MyLocationStyle.ERROR_CODE));
                }
            } else if (message.what == 101) {
                Bundle data2 = message.getData();
                if (data2 != null) {
                    onRouteSearchListener.onDriveRouteSearched((DriveRouteResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT), data2.getInt(MyLocationStyle.ERROR_CODE));
                }
            } else if (message.what == 102) {
                Bundle data3 = message.getData();
                if (data3 != null) {
                    onRouteSearchListener.onWalkRouteSearched((WalkRouteResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT), data3.getInt(MyLocationStyle.ERROR_CODE));
                }
            } else if (message.what == 103) {
                Bundle data4 = message.getData();
                if (data4 != null) {
                    onRouteSearchListener.onRideRouteSearched((RideRouteResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT), data4.getInt(MyLocationStyle.ERROR_CODE));
                }
            }
        }
    }

    private void l(Message message) {
        if (message.what == 700) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                dVar.b.onCloudSearched(dVar.a, message.arg2);
            }
        } else if (message.what == 701) {
            c cVar = (c) message.obj;
            if (cVar != null) {
                cVar.b.onCloudItemDetailSearched(cVar.a, message.arg2);
            }
        }
    }

    private void m(Message message) {
        if (message.what == 1301) {
            l lVar = (l) message.obj;
            if (lVar != null) {
                WeatherSearch.OnWeatherSearchListener onWeatherSearchListener = lVar.b;
                if (onWeatherSearchListener != null) {
                    Bundle data = message.getData();
                    if (data != null) {
                        onWeatherSearchListener.onWeatherLiveSearched(lVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
                    }
                }
            }
        } else if (message.what == 1302) {
            k kVar = (k) message.obj;
            if (kVar != null) {
                WeatherSearch.OnWeatherSearchListener onWeatherSearchListener2 = kVar.b;
                if (onWeatherSearchListener2 != null) {
                    Bundle data2 = message.getData();
                    if (data2 != null) {
                        onWeatherSearchListener2.onWeatherForecastSearched(kVar.a, data2.getInt(MyLocationStyle.ERROR_CODE));
                    }
                }
            }
        }
    }

    private void n(Message message) {
        j jVar = (j) message.obj;
        if (jVar != null) {
            RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener = jVar.b;
            if (onRoutePOISearchListener != null) {
                Bundle data = message.getData();
                if (data != null) {
                    onRoutePOISearchListener.onRoutePoiSearched(jVar.a, data.getInt(MyLocationStyle.ERROR_CODE));
                }
            }
        }
    }

    private void o(Message message) {
        TrafficSearch.OnTrafficSearchListener onTrafficSearchListener = (TrafficSearch.OnTrafficSearchListener) message.obj;
        if (onTrafficSearchListener != null) {
            if (message.what == 300) {
                Bundle data = message.getData();
                if (data != null) {
                    onTrafficSearchListener.onRoadTrafficSearched((TrafficStatusResult) message.getData().getParcelable(SpeechUtility.TAG_RESOURCE_RESULT), data.getInt(MyLocationStyle.ERROR_CODE));
                }
            } else if (message.what == 301) {
                message.getData();
            } else if (message.what == 302) {
                message.getData();
            }
        }
    }
}
