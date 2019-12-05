package com.amap.api.services.a;

import com.amap.api.services.a.bh;
import com.amap.api.services.core.ServiceSettings;

/* compiled from: ConfigableConst */
public class h {
    public static final String[] a = {"com.amap.api.services", "com.amap.api.search.admic"};

    public static String a() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restapi.amap.com/v3" : "https://restapi.amap.com/v3";
    }

    public static String b() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://restapi.amap.com/v4" : "https://restapi.amap.com/v4";
    }

    public static String c() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://yuntuapi.amap.com" : "https://yuntuapi.amap.com";
    }

    public static String d() {
        return ServiceSettings.getInstance().getLanguage();
    }

    public static bh a(boolean z) {
        try {
            return new bh.a("sea", "5.3.1", "AMAP SDK Android Search 5.3.1").a(a).a(z).a("5.3.1").a();
        } catch (ay e) {
            i.a(e, "ConfigableConst", "getSDKInfo");
            return null;
        }
    }

    public static bh b(boolean z) {
        try {
            return new bh.a("cloud", "5.3.1", "AMAP SDK Android Search 5.3.1").a(a).a(z).a();
        } catch (ay e) {
            i.a(e, "ConfigableConst", "getCloudSDKInfo");
            return null;
        }
    }

    public static String e() {
        return ServiceSettings.getInstance().getProtocol() == 1 ? "http://m5.amap.com/ws/mapapi/shortaddress/transform" : "https://m5.amap.com/ws/mapapi/shortaddress/transform";
    }
}
