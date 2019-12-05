package com.amap.api.services.a;

import android.content.Context;

/* compiled from: WeatherSearchHandler */
abstract class aj<T, V> extends b<T, V> {
    public aj(Context context, T t) {
        super(context, t);
    }

    public T j() {
        return this.a;
    }

    public String i() {
        return h.a() + "/weather/weatherInfo?";
    }
}
