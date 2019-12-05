package com.loc;

import android.content.Context;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.SparseArray;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ReportUtil */
public final class cx {
    static AMapLocation g;
    private static List<br> h = new ArrayList();
    private static JSONArray i;
    public SparseArray<Long> a = new SparseArray<>();
    public int b = -1;
    public long c = 0;
    String[] d = {"ol", "cl", "gl", "ha", "bs", "ds"};
    public int e = -1;
    public long f = -1;

    public static void a(Context context) {
        if (context != null) {
            try {
                if (cr.o()) {
                    if (h != null && h.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(h);
                        bs.a((List<br>) arrayList, context);
                        h.clear();
                    }
                    f(context);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "destroy");
            }
        }
    }

    public static void a(Context context, int i2, int i3, long j, long j2) {
        if (i2 != -1 && i3 != -1 && context != null) {
            try {
                if (cr.o()) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("param_int_first", i2);
                    jSONObject.put("param_int_second", i3);
                    jSONObject.put("param_long_first", j);
                    jSONObject.put("param_long_second", j2);
                    a(context, "O012", jSONObject);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "reportServiceAliveTime");
            }
        }
    }

    public static void a(Context context, long j, boolean z) {
        if (context != null) {
            try {
                if (cr.o()) {
                    int intValue = Long.valueOf(j).intValue();
                    String str = "domestic";
                    if (!z) {
                        str = "abroad";
                    }
                    a(context, "O015", str, (String) null, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "reportGPSLocUseTime");
            }
        }
    }

    public static void a(Context context, AMapLocation aMapLocation) {
        int i2;
        String str;
        String str2;
        String str3;
        if (aMapLocation != null) {
            try {
                if (!GeocodeSearch.GPS.equalsIgnoreCase(aMapLocation.getProvider()) && aMapLocation.getLocationType() != 1) {
                    String str4 = "domestic";
                    if (a(aMapLocation)) {
                        str4 = "abroad";
                    }
                    String str5 = str4;
                    if (aMapLocation.getErrorCode() != 0) {
                        int errorCode = aMapLocation.getErrorCode();
                        if (errorCode != 11) {
                            switch (errorCode) {
                                case 4:
                                case 5:
                                case 6:
                                    break;
                                default:
                                    str3 = "cache";
                                    break;
                            }
                        }
                        str3 = "net";
                        i2 = 0;
                        str = str3;
                    } else {
                        switch (aMapLocation.getLocationType()) {
                            case 5:
                            case 6:
                                str2 = "net";
                                break;
                            default:
                                str2 = "cache";
                                break;
                        }
                        str = str2;
                        i2 = 1;
                    }
                    a(context, "O016", str, str5, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "reportBatting");
            }
        }
    }

    public static void a(Context context, cw cwVar) {
        String str;
        if (context != null) {
            try {
                if (cr.o()) {
                    AMapLocationServer c2 = cwVar.c();
                    if (da.a(c2) && !GeocodeSearch.GPS.equalsIgnoreCase(c2.getProvider()) && c2.getLocationType() != 1) {
                        int intValue = Long.valueOf(cwVar.b() - cwVar.a()).intValue();
                        boolean z = false;
                        int intValue2 = Long.valueOf(c2.j()).intValue();
                        switch (c2.getLocationType()) {
                            case 5:
                            case 6:
                                str = "net";
                                break;
                            default:
                                str = "cache";
                                z = true;
                                break;
                        }
                        String str2 = a((AMapLocation) c2) ? "abroad" : "domestic";
                        if (!z) {
                            a(context, "O014", str2, (String) null, intValue2, intValue);
                        }
                        a(context, "O013", str, str2, intValue, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "reportLBSLocUseTime");
            }
        }
    }

    public static void a(Context context, String str) {
        try {
            a(context, "O010", 0, str);
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "reportDex_dexFunction");
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            a(context, "O009", i2, str);
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "reportDex_dexLoadClass");
        }
    }

    private static void a(Context context, String str, int i2, String str2) {
        if (context != null) {
            try {
                if (cr.o()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, int i2, int i3) {
        if (context != null) {
            try {
                if (cr.o()) {
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(str2)) {
                        jSONObject.put("param_string_first", str2);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        jSONObject.put("param_string_second", str3);
                    }
                    if (i2 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_first", i2);
                    }
                    if (i3 != Integer.MAX_VALUE) {
                        jSONObject.put("param_int_second", i3);
                    }
                    a(context, str, jSONObject);
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "applyStatisticsEx");
            }
        }
    }

    private static void a(Context context, String str, JSONObject jSONObject) {
        if (context != null) {
            try {
                if (cr.o()) {
                    br brVar = new br(context, "loc", "3.6.1", str);
                    brVar.a(jSONObject.toString());
                    h.add(brVar);
                    if (h.size() >= 100) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.addAll(h);
                        bs.a((List<br>) arrayList, context);
                        h.clear();
                    }
                }
            } catch (Throwable th) {
                cs.a(th, "ReportUtil", "applyStatistics");
            }
        }
    }

    public static void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        try {
            if (g == null) {
                if (!da.a(aMapLocation)) {
                    g = aMapLocation2;
                    return;
                }
                g = aMapLocation.clone();
            }
            if (da.a(g) && da.a(aMapLocation2)) {
                AMapLocation clone = aMapLocation2.clone();
                if (!(g.getLocationType() == 1 || g.getLocationType() == 9 || g.getProvider().equalsIgnoreCase(GeocodeSearch.GPS) || g.getLocationType() == 7 || clone.getLocationType() == 1 || clone.getLocationType() == 9 || clone.getProvider().equalsIgnoreCase(GeocodeSearch.GPS) || clone.getLocationType() == 7)) {
                    long abs = Math.abs(clone.getTime() - g.getTime()) / 1000;
                    if (abs <= 0) {
                        abs = 1;
                    }
                    if (abs <= 1800000) {
                        float a2 = da.a(g, clone);
                        float f2 = a2 / ((float) abs);
                        if (a2 > 30000.0f && f2 > 1000.0f) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(g.getLatitude());
                            sb.append(",");
                            sb.append(g.getLongitude());
                            sb.append(",");
                            sb.append(g.getAccuracy());
                            sb.append(",");
                            sb.append(g.getLocationType());
                            sb.append(",");
                            if (aMapLocation.getTime() != 0) {
                                sb.append(da.a(g.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(g.getTime());
                            }
                            sb.append("#");
                            sb.append(clone.getLatitude());
                            sb.append(",");
                            sb.append(clone.getLongitude());
                            sb.append(",");
                            sb.append(clone.getAccuracy());
                            sb.append(",");
                            sb.append(clone.getLocationType());
                            sb.append(",");
                            sb.append(clone.getTime());
                            if (clone.getTime() != 0) {
                                sb.append(da.a(clone.getTime(), "yyyyMMdd_HH:mm:ss:SS"));
                            } else {
                                sb.append(clone.getTime());
                            }
                            a("bigshiftstatistics", sb.toString());
                            sb.delete(0, sb.length());
                        }
                    }
                }
                g = clone;
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, int i2) {
        String valueOf = String.valueOf(i2);
        String str2 = "";
        switch (i2) {
            case 2011:
                str2 = "ContextIsNull";
                break;
            case GLMapStaticValue.AM_PARAMETERNAME_TEXTURE_ICON_INFO:
                str2 = "OnlyMainWifi";
                break;
            case 2022:
                str2 = "OnlyOneWifiButNotMain";
                break;
            case 2031:
                str2 = "CreateApsReqException";
                break;
            case 2041:
                str2 = "ResponseResultIsNull";
                break;
            case GLMapStaticValue.AM_PARAMETERNAME_MAP_VALUE:
                str2 = "NeedLoginNetWork\t";
                break;
            case GLMapStaticValue.AM_PARAMETERNAME_MAP_TEXTSCALE:
                str2 = "MaybeIntercepted";
                break;
            case GLMapStaticValue.AM_PARAMETERNAME_RESTORED_MAPMODESTATE:
                str2 = "DecryptResponseException";
                break;
            case 2054:
                str2 = "ParserDataException";
                break;
            case 2061:
                str2 = "ServerRetypeError";
                break;
            case 2062:
                str2 = "ServerLocFail";
                break;
            case 2081:
                str2 = "LocalLocException";
                break;
            case 2091:
                str2 = "InitException";
                break;
            case AMapException.CODE_AMAP_NEARBY_KEY_NOT_BIND:
                str2 = "BindAPSServiceException";
                break;
            case 2102:
                str2 = "AuthClientScodeFail";
                break;
            case 2111:
                str2 = "ErrorCgiInfo";
                break;
            case 2121:
                str2 = "NotLocPermission";
                break;
            case 2131:
                str2 = "NoCgiOAndWifiInfo";
                break;
            case 2132:
                str2 = "AirPlaneModeAndWifiOff";
                break;
            case 2133:
                str2 = "NoCgiAndWifiOff";
                break;
            case 2141:
                str2 = "NoEnoughStatellites";
                break;
            case 2151:
                str2 = "MaybeMockNetLoc";
                break;
            case 2152:
                str2 = "MaybeMockGPSLoc";
                break;
        }
        a(str, valueOf, str2);
    }

    public static void a(String str, String str2) {
        try {
            z.b(cs.b(), str2, str);
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "reportLog");
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            z.a(cs.b(), "/mobile/binary", str3, str, str2);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, Throwable th) {
        try {
            if (th instanceof j) {
                z.a(cs.b(), str, (j) th);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context, s sVar) {
        try {
            return au.a(context, sVar);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(AMapLocation aMapLocation) {
        return da.a(aMapLocation) ? !cs.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) : "http://abroad.apilocate.amap.com/mobile/binary".equals(cs.a);
    }

    public static void b(Context context, AMapLocation aMapLocation) {
        try {
            if (da.a(aMapLocation)) {
                int i2 = 0;
                boolean z = true;
                switch (aMapLocation.getLocationType()) {
                    case 1:
                        break;
                    case 2:
                    case 4:
                    case 8:
                        i2 = 1;
                        break;
                    case 9:
                        i2 = 2;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    if (i == null) {
                        i = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("lon", aMapLocation.getLongitude());
                    jSONObject.put("lat", aMapLocation.getLatitude());
                    jSONObject.put("type", i2);
                    jSONObject.put("timestamp", da.a());
                    JSONArray put = i.put(jSONObject);
                    i = put;
                    if (put.length() >= cr.p()) {
                        f(context);
                    }
                }
            }
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "recordOfflineLocLog");
        }
    }

    private static void f(Context context) {
        try {
            if (i != null && i.length() > 0) {
                bq.a(new bp(context, cs.b(), i.toString()), context);
                i = null;
            }
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "writeOfflineLocLog");
        }
    }

    public final void a(Context context, int i2) {
        try {
            if (this.b != i2) {
                if (!(this.b == -1 || this.b == i2)) {
                    this.a.append(this.b, Long.valueOf((da.b() - this.c) + this.a.get(this.b, 0L).longValue()));
                }
                this.c = da.b() - cz.b(context, "pref", this.d[i2], 0);
                this.b = i2;
            }
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "setLocationType");
        }
    }

    public final void a(Context context, AMapLocationClientOption aMapLocationClientOption) {
        int i2;
        try {
            switch (aMapLocationClientOption.getLocationMode()) {
                case Battery_Saving:
                    i2 = 4;
                    break;
                case Device_Sensors:
                    i2 = 5;
                    break;
                case Hight_Accuracy:
                    i2 = 3;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            if (this.e != i2) {
                if (!(this.e == -1 || this.e == i2)) {
                    this.a.append(this.e, Long.valueOf((da.b() - this.f) + this.a.get(this.e, 0L).longValue()));
                }
                this.f = da.b() - cz.b(context, "pref", this.d[i2], 0);
                this.e = i2;
            }
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "setLocationMode");
        }
    }

    public final void b(Context context) {
        try {
            long b2 = da.b() - this.c;
            if (this.b != -1) {
                this.a.append(this.b, Long.valueOf(b2 + this.a.get(this.b, 0L).longValue()));
            }
            long b3 = da.b() - this.f;
            if (this.e != -1) {
                this.a.append(this.e, Long.valueOf(b3 + this.a.get(this.e, 0L).longValue()));
            }
            for (int i2 = 0; i2 < 6; i2++) {
                long longValue = this.a.get(i2, 0L).longValue();
                if (longValue > 0 && longValue > cz.b(context, "pref", this.d[i2], 0)) {
                    cz.a(context, "pref", this.d[i2], longValue);
                }
            }
        } catch (Throwable th) {
            cs.a(th, "ReportUtil", "saveLocationTypeAndMode");
        }
    }

    public final int c(Context context) {
        try {
            long b2 = cz.b(context, "pref", this.d[2], 0);
            long b3 = cz.b(context, "pref", this.d[0], 0);
            long b4 = cz.b(context, "pref", this.d[1], 0);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            long j = b3 - b2;
            long j2 = b4 - b2;
            return b2 > j ? b2 > j2 ? 2 : 1 : j > j2 ? 0 : 1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final int d(Context context) {
        try {
            long b2 = cz.b(context, "pref", this.d[3], 0);
            long b3 = cz.b(context, "pref", this.d[4], 0);
            long b4 = cz.b(context, "pref", this.d[5], 0);
            if (b2 == 0 && b3 == 0 && b4 == 0) {
                return -1;
            }
            return b2 > b3 ? b2 > b4 ? 3 : 5 : b3 > b4 ? 4 : 5;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public final void e(Context context) {
        int i2 = 0;
        while (i2 < this.d.length) {
            try {
                cz.a(context, "pref", this.d[i2], 0);
                i2++;
            } catch (Throwable unused) {
                return;
            }
        }
    }
}
