package com.amap.api.services.weather;

import android.content.Context;
import com.amap.api.services.a.ax;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.interfaces.IWeatherSearch;

public class WeatherSearch {
    private IWeatherSearch a = null;

    public interface OnWeatherSearchListener {
        void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int i);

        void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int i);
    }

    public WeatherSearch(Context context) {
        try {
            Context context2 = context;
            this.a = (IWeatherSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.WeatherSearchWrapper", ax.class, new Class[]{Context.class}, new Object[]{context});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new ax(context);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public WeatherSearchQuery getQuery() {
        if (this.a != null) {
            return this.a.getQuery();
        }
        return null;
    }

    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        if (this.a != null) {
            this.a.setQuery(weatherSearchQuery);
        }
    }

    public void searchWeatherAsyn() {
        if (this.a != null) {
            this.a.searchWeatherAsyn();
        }
    }

    public void setOnWeatherSearchListener(OnWeatherSearchListener onWeatherSearchListener) {
        if (this.a != null) {
            this.a.setOnWeatherSearchListener(onWeatherSearchListener);
        }
    }
}
