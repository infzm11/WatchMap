package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.a.q;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherSearchCore */
public class ax implements IWeatherSearch {
    private Context a;
    /* access modifiers changed from: private */
    public WeatherSearchQuery b;
    /* access modifiers changed from: private */
    public WeatherSearch.OnWeatherSearchListener c;
    /* access modifiers changed from: private */
    public LocalWeatherLiveResult d;
    /* access modifiers changed from: private */
    public LocalWeatherForecastResult e;
    /* access modifiers changed from: private */
    public Handler f = null;

    public ax(Context context) {
        this.a = context.getApplicationContext();
        this.f = q.a();
    }

    public WeatherSearchQuery getQuery() {
        return this.b;
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.b = weatherSearchQuery;
    }

    public void searchWeatherAsyn() {
        try {
            new Thread(new Runnable() {
                public void run() {
                    q.k kVar;
                    q.l lVar;
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.arg1 = 13;
                    Bundle bundle = new Bundle();
                    if (ax.this.b == null) {
                        try {
                            throw new AMapException("无效的参数 - IllegalArgumentException");
                        } catch (AMapException e) {
                            i.a(e, "WeatherSearch", "searchWeatherAsyn");
                        }
                    } else if (ax.this.b.getType() == 1) {
                        try {
                            LocalWeatherLiveResult unused = ax.this.d = ax.this.a();
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            lVar = new q.l();
                        } catch (AMapException e2) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e2.getErrorCode());
                            i.a(e2, "WeatherSearch", "searchWeatherAsyn");
                            lVar = new q.l();
                        } catch (Throwable th) {
                            q.l lVar2 = new q.l();
                            obtainMessage.what = 1301;
                            lVar2.b = ax.this.c;
                            lVar2.a = ax.this.d;
                            obtainMessage.obj = lVar2;
                            obtainMessage.setData(bundle);
                            ax.this.f.sendMessage(obtainMessage);
                            throw th;
                        }
                        obtainMessage.what = 1301;
                        lVar.b = ax.this.c;
                        lVar.a = ax.this.d;
                        obtainMessage.obj = lVar;
                        obtainMessage.setData(bundle);
                        ax.this.f.sendMessage(obtainMessage);
                    } else if (ax.this.b.getType() == 2) {
                        try {
                            LocalWeatherForecastResult unused2 = ax.this.e = ax.this.b();
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            kVar = new q.k();
                        } catch (AMapException e3) {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, e3.getErrorCode());
                            i.a(e3, "WeatherSearch", "searchWeatherAsyn");
                            kVar = new q.k();
                        } catch (Throwable th2) {
                            q.k kVar2 = new q.k();
                            obtainMessage.what = 1302;
                            kVar2.b = ax.this.c;
                            kVar2.a = ax.this.e;
                            obtainMessage.obj = kVar2;
                            obtainMessage.setData(bundle);
                            ax.this.f.sendMessage(obtainMessage);
                            throw th2;
                        }
                        obtainMessage.what = 1302;
                        kVar.b = ax.this.c;
                        kVar.a = ax.this.e;
                        obtainMessage.obj = kVar;
                        obtainMessage.setData(bundle);
                        ax.this.f.sendMessage(obtainMessage);
                    }
                }
            }).start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public LocalWeatherLiveResult a() throws AMapException {
        o.a(this.a);
        if (this.b == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        ai aiVar = new ai(this.a, this.b);
        return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) aiVar.j(), (LocalWeatherLive) aiVar.c());
    }

    /* access modifiers changed from: private */
    public LocalWeatherForecastResult b() throws AMapException {
        o.a(this.a);
        if (this.b == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        ah ahVar = new ah(this.a, this.b);
        return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) ahVar.j(), (LocalWeatherForecast) ahVar.c());
    }

    public void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.c = onWeatherSearchListener;
    }
}
