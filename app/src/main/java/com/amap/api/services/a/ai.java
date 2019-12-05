package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearchQuery;

/* compiled from: WeatherLiveHandler */
public class ai extends aj<WeatherSearchQuery, LocalWeatherLive> {
    private LocalWeatherLive i = new LocalWeatherLive();

    public /* bridge */ /* synthetic */ String i() {
        return super.i();
    }

    public ai(Context context, WeatherSearchQuery weatherSearchQuery) {
        super(context, weatherSearchQuery);
    }

    /* access modifiers changed from: protected */
    public String g() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String city = ((WeatherSearchQuery) this.a).getCity();
        if (!n.i(city)) {
            String c = c(city);
            stringBuffer.append("&city=");
            stringBuffer.append(c);
        }
        stringBuffer.append("&extensions=base");
        stringBuffer.append("&key=" + az.f(this.d));
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public LocalWeatherLive a(String str) throws AMapException {
        this.i = n.d(str);
        return this.i;
    }
}
