package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.iflytek.clientadapter.constant.ContactValue;
import com.iflytek.cloud.SpeechConstant;
import com.loc.s;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public final class cs {
    static String a = "http://apilocate.amap.com/mobile/binary";
    static String b = "";
    static String c = "001;002;11B;11C;11F;11G;11H;11I;11K;121;122;135;13J;13S";
    public static String d = null;
    public static String e = null;
    public static int f = 30000;
    public static String g = null;
    public static String h = null;
    static String i = null;
    static HashMap<String, String> j = null;
    public static boolean k = false;
    public static boolean l = false;
    static boolean m = false;
    static boolean n = false;
    private static final String[] o = {"com.amap.api.location", "com.loc", "com.amap.api.fence"};
    private static s p;

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.location.AMapLocation a(com.amap.api.location.AMapLocation r4, com.amap.api.location.AMapLocation r5) {
        /*
            if (r5 != 0) goto L_0x0003
            return r4
        L_0x0003:
            java.lang.String r0 = r5.getCountry()     // Catch:{ Throwable -> 0x00bb }
            r4.setCountry(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getRoad()     // Catch:{ Throwable -> 0x00bb }
            r4.setRoad(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getPoiName()     // Catch:{ Throwable -> 0x00bb }
            r4.setPoiName(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getStreet()     // Catch:{ Throwable -> 0x00bb }
            r4.setStreet(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getStreetNum()     // Catch:{ Throwable -> 0x00bb }
            r4.setNumber(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getCityCode()     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r1 = r5.getAdCode()     // Catch:{ Throwable -> 0x00bb }
            r4.setCityCode(r0)     // Catch:{ Throwable -> 0x00bb }
            r4.setAdCode(r1)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getCity()     // Catch:{ Throwable -> 0x00bb }
            r4.setCity(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getDistrict()     // Catch:{ Throwable -> 0x00bb }
            r4.setDistrict(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getProvince()     // Catch:{ Throwable -> 0x00bb }
            r4.setProvince(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getAoiName()     // Catch:{ Throwable -> 0x00bb }
            r4.setAoiName(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getAddress()     // Catch:{ Throwable -> 0x00bb }
            r4.setAddress(r0)     // Catch:{ Throwable -> 0x00bb }
            java.lang.String r0 = r5.getDescription()     // Catch:{ Throwable -> 0x00bb }
            r4.setDescription(r0)     // Catch:{ Throwable -> 0x00bb }
            android.os.Bundle r0 = r4.getExtras()     // Catch:{  }
            if (r0 == 0) goto L_0x0092
            android.os.Bundle r0 = r4.getExtras()     // Catch:{  }
            java.lang.String r1 = "citycode"
            java.lang.String r2 = r5.getCityCode()     // Catch:{  }
            r0.putString(r1, r2)     // Catch:{  }
            android.os.Bundle r0 = r4.getExtras()     // Catch:{  }
            java.lang.String r1 = "desc"
            android.os.Bundle r2 = r5.getExtras()     // Catch:{  }
            java.lang.String r3 = "desc"
            java.lang.String r2 = r2.getString(r3)     // Catch:{  }
            r0.putString(r1, r2)     // Catch:{  }
            android.os.Bundle r0 = r4.getExtras()     // Catch:{  }
            java.lang.String r1 = "adcode"
            java.lang.String r5 = r5.getAdCode()     // Catch:{  }
            r0.putString(r1, r5)     // Catch:{  }
            return r4
        L_0x0092:
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{  }
            r0.<init>()     // Catch:{  }
            java.lang.String r1 = "citycode"
            java.lang.String r2 = r5.getCityCode()     // Catch:{  }
            r0.putString(r1, r2)     // Catch:{  }
            java.lang.String r1 = "desc"
            android.os.Bundle r2 = r5.getExtras()     // Catch:{  }
            java.lang.String r3 = "desc"
            java.lang.String r2 = r2.getString(r3)     // Catch:{  }
            r0.putString(r1, r2)     // Catch:{  }
            java.lang.String r1 = "adcode"
            java.lang.String r5 = r5.getAdCode()     // Catch:{  }
            r0.putString(r1, r5)     // Catch:{  }
            r4.setExtras(r0)     // Catch:{  }
        L_0x00bb:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cs.a(com.amap.api.location.AMapLocation, com.amap.api.location.AMapLocation):com.amap.api.location.AMapLocation");
    }

    public static AMapLocationClientOption a(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        if (bundle == null) {
            return aMapLocationClientOption;
        }
        try {
            bundle.setClassLoader(AMapLocationClientOption.class.getClassLoader());
            return (AMapLocationClientOption) bundle.getParcelable("opt");
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionFromBundle");
            return aMapLocationClientOption;
        }
    }

    public static s a(String str, String str2) {
        try {
            return new s.a(str, str2, "AMAP_Location_SDK_Android 3.6.1").a(d()).a();
        } catch (Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
            return null;
        }
    }

    public static String a() {
        return a;
    }

    public static JSONObject a(AMapLocationClientOption aMapLocationClientOption) {
        JSONObject jSONObject = new JSONObject();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            jSONObject.put("nbssid", "0");
            jSONObject.put("reversegeo", aMapLocationClientOption.isNeedAddress());
            jSONObject.put("isOffset", aMapLocationClientOption.isOffset());
            jSONObject.put("wifiactivescan", aMapLocationClientOption.isWifiActiveScan() ? "1" : "0");
            jSONObject.put("httptimeout", aMapLocationClientOption.getHttpTimeOut());
            jSONObject.put("isLocationCacheEnable", aMapLocationClientOption.isLocationCacheEnable());
            jSONObject.put("isOnceLocationLatest", aMapLocationClientOption.isOnceLocationLatest());
            jSONObject.put("isKillProcess", aMapLocationClientOption.isKillProcess() ? "1" : "0");
            boolean z = true;
            if (aMapLocationClientOption.getLocationProtocol().ordinal() != 1) {
                z = false;
            }
            jSONObject.put("locationProtocol", z);
            jSONObject.put("sensorEnable", aMapLocationClientOption.isSensorEnable());
            jSONObject.put("isWifiPassiveScan", aMapLocationClientOption.isWifiScan());
            jSONObject.put("isMock", aMapLocationClientOption.isMockEnable());
            return jSONObject;
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionJson");
            return jSONObject;
        }
    }

    public static void a(Context context) {
        try {
            if (da.a(e(context))) {
                a = "http://abroad.apilocate.amap.com/mobile/binary";
                return;
            }
            if (j == null) {
                j = new HashMap<>();
            }
            j.clear();
            j.put("a9a9d23668a1a7ea93de9b21d67e436a", "F13160D440C7D0229DA95450F66AF92154AC84DF088F8CA3100B2E8131D57F3DC67124D4C466056E7A3DFBE035E1B9A4B9DA4DB68AE65A43EDFD92F5C60EF0C9");
            j.put("fe643c382e5c3b3962141f1a2e815a78", "FB923EE67A8B4032DAA517DD8CD7A26FF7C25B0C3663F92A0B61251C4FFFA858DF169D61321C3E7919CB67DF8EFEC827");
            j.put("b2e8bd171989cb2c3c13bd89b4c1067a", "239CE372F804D4BE4EAFFD183668379BDF274440E6F246AB16BBE6F5D1D30DEACFBBF0C942485727FF12288228760A9E");
            j.put("9a571aa113ad987d626c0457828962e6", "D2FF99A88BEB04683D89470D4FA72B1749DA456AB0D0F1A476477CE5A6874F53A9106423D905F9D808C0FCE8E7F1E04AC642F01FE41D0C7D933971F45CBA72B7");
            j.put("668319f11506def6208d6afe320dfd52", "53E53D46011A6BBAEA4FAE5442E659E0577CDD336F930C28635C322FB3F51C3C63F7FBAC9EAE448DFA2E5E5D716C4807");
            j.put("256b0f26bb2a9506be6cfdb84028ae08", "AF2228680EDC323FBA035362EB7E1E38A0C33E1CF6F6FB805EE553A230CBA754CD9552EB9B546542CBE619E8293151BE");
            String a2 = ch.a(k.f(context));
            i = a2;
            if (a2 != null) {
                try {
                    if (a2.length() != 0 && j != null && j.containsKey(a2)) {
                        String str = j.get(a2);
                        String str2 = null;
                        if (str != null && str.length() > 0) {
                            str2 = new String(ch.d(a(str), a2), "utf-8");
                        }
                        if (str2 != null && str2.length() > 0 && str2.contains("http:")) {
                            b = str2;
                            a = str2;
                        }
                    }
                } catch (Throwable th) {
                    a(th, "CoreUtil", "checkUrl");
                }
            }
        } catch (Throwable th2) {
            a(th2, "CoreUtil", "checkUrl");
        }
    }

    public static void a(AMapLocation aMapLocation, JSONObject jSONObject) {
        if (jSONObject != null && aMapLocation != null) {
            try {
                aMapLocation.setProvider(jSONObject.optString("provider", aMapLocation.getProvider()));
                aMapLocation.setLatitude(jSONObject.optDouble("lat", aMapLocation.getLatitude()));
                aMapLocation.setLongitude(jSONObject.optDouble("lon", aMapLocation.getLongitude()));
                aMapLocation.setAltitude(jSONObject.optDouble("altitude", aMapLocation.getAltitude()));
                try {
                    String optString = jSONObject.optString("accuracy");
                    if (!TextUtils.isEmpty(optString)) {
                        aMapLocation.setAccuracy(Float.parseFloat(optString));
                    }
                } catch (Throwable unused) {
                }
                try {
                    String optString2 = jSONObject.optString(SpeechConstant.SPEED);
                    if (!TextUtils.isEmpty(optString2)) {
                        aMapLocation.setSpeed(Float.parseFloat(optString2));
                    }
                } catch (Throwable unused2) {
                }
                try {
                    String optString3 = jSONObject.optString("bearing");
                    if (!TextUtils.isEmpty(optString3)) {
                        aMapLocation.setBearing(Float.parseFloat(optString3));
                    }
                } catch (Throwable unused3) {
                }
                aMapLocation.setAdCode(jSONObject.optString("adcode", aMapLocation.getAdCode()));
                aMapLocation.setCityCode(jSONObject.optString("citycode", aMapLocation.getCityCode()));
                aMapLocation.setAddress(jSONObject.optString("address", aMapLocation.getAddress()));
                String optString4 = jSONObject.optString("desc", "");
                aMapLocation.setCountry(jSONObject.optString(DistrictSearchQuery.KEYWORDS_COUNTRY, aMapLocation.getCountry()));
                aMapLocation.setProvince(jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince()));
                aMapLocation.setCity(jSONObject.optString(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity()));
                aMapLocation.setDistrict(jSONObject.optString(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict()));
                aMapLocation.setRoad(jSONObject.optString("road", aMapLocation.getRoad()));
                aMapLocation.setStreet(jSONObject.optString("street", aMapLocation.getStreet()));
                aMapLocation.setNumber(jSONObject.optString(ContactValue.NUMBER, aMapLocation.getStreetNum()));
                aMapLocation.setPoiName(jSONObject.optString("poiname", aMapLocation.getPoiName()));
                aMapLocation.setAoiName(jSONObject.optString("aoiname", aMapLocation.getAoiName()));
                aMapLocation.setErrorCode(jSONObject.optInt(MyLocationStyle.ERROR_CODE, aMapLocation.getErrorCode()));
                aMapLocation.setErrorInfo(jSONObject.optString(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo()));
                aMapLocation.setLocationType(jSONObject.optInt(MyLocationStyle.LOCATION_TYPE, aMapLocation.getLocationType()));
                aMapLocation.setLocationDetail(jSONObject.optString("locationDetail", aMapLocation.getLocationDetail()));
                aMapLocation.setTime(jSONObject.optLong("time", aMapLocation.getTime()));
                aMapLocation.setOffset(jSONObject.optBoolean("isOffset", aMapLocation.isOffset()));
                aMapLocation.setBuildingId(jSONObject.optString("poiid", aMapLocation.getBuildingId()));
                aMapLocation.setFloor(jSONObject.optString("floor", aMapLocation.getFloor()));
                aMapLocation.setDescription(jSONObject.optString("description", aMapLocation.getDescription()));
                Bundle bundle = new Bundle();
                bundle.putString("citycode", aMapLocation.getCityCode());
                bundle.putString("desc", optString4.toString());
                bundle.putString("adcode", aMapLocation.getAdCode());
                aMapLocation.setExtras(bundle);
            } catch (Throwable th) {
                a(th, "CoreUtil", "transformLocation");
            }
        }
    }

    public static void a(Throwable th, String str, String str2) {
        if (!"reportError".equals(str2)) {
            try {
                th.printStackTrace();
                if (!(th instanceof j)) {
                    z.b(th, str, str2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean a(double d2, double d3) {
        int i2 = (int) ((d3 - 73.0d) / 0.5d);
        int i3 = (int) ((d2 - 3.5d) / 0.5d);
        if (i3 < 0 || i3 >= 101 || i2 < 0 || i2 >= 124) {
            return false;
        }
        try {
            return "00000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000001011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011101010111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111101111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001000110111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011010111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000110000001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001010011100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100110001000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111110011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111000000000111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111100000000000010111110100000011000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111110000000001111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111000000111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111101111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000101111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000011110000000001111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000000000000011000011111100000000111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000001111111100111111111100110111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000101111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111011111000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100100000000000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100011100000000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110011111110000000000000000000000111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110111111110000000000000000000000111011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111110000000000000000000000001111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000011111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111000000000000000000000000011111111111111111111111111111111111111111111111100001111111111111111111111111111111111111111111111111010000000000000000000000111111111111111111111111111111111111111111110000000000000001111111111111111111111111111111111111111111100000000000000000000011111111111111111111111111111111100000000000000000000000000001111111111111111111111111111111111111111110000000000000000000001111111111111111111111111111111100000000000000000000000000000001111111111111111111111111111111111111111000000000000000000000111111111111111111111111111111110000000000000000000000000000001111111111111111111111111111111111111111100000000000000000000111111111111111111111111111111000000000000000000000000000000000111111111111111111111111111111111111111111000000000000000000001111111111111111111111111110000000000000000000000000000000000001110011111111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000001111111111111111111111111111111111111000000000000000000001111111111111111111000000000000000000000000000000000000000000000000011111111111111111111111111111111111100000000000000000000011111111111111111100000000000000000000000000000000000000000000000000011111111111111111111111111111111111000000000000000000001111111111111111100000000000000000000000000000000000000000000000000000000111111111111111111111111111111110000000000000000000000000111111111100000000000000000000000000000000000000000000000000111111111111111111111111111111111111111000000000000000000000000011111111100000000000000000000000000000000000000000000000000011111111111111111111111111111110001111100000000000000000000000000111110000000000000000000000000000000000000000000000000000001111111111111111111111111111111000000000000000000000000000000000001110000000000000000000000000000000000000000000000000000000011111111111111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111111000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000011111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001111111111110000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000010110000000000000000000000".charAt((124 * i3) + i2) == '1';
        } catch (Throwable th) {
            a(th, "CoreUtil", "isChina");
            return true;
        }
    }

    private static byte[] a(String str) {
        if (str == null || str.length() < 2) {
            return new byte[0];
        }
        String lowerCase = str.toLowerCase(Locale.US);
        int length = lowerCase.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = 2 * i2;
            bArr[i2] = (byte) (Integer.parseInt(lowerCase.substring(i3, i3 + 2), 16) & 255);
        }
        return bArr;
    }

    public static Bundle b(AMapLocationClientOption aMapLocationClientOption) {
        Bundle bundle = new Bundle();
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        try {
            bundle.putParcelable("opt", aMapLocationClientOption);
            return bundle;
        } catch (Throwable th) {
            a(th, "CoreUtil", "getOptionBundle");
            return bundle;
        }
    }

    public static s b() {
        try {
            if (p == null) {
                p = new s.a("loc", "3.6.1", "AMAP_Location_SDK_Android 3.6.1").a(d()).a("3.6.1").a();
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "getSDKInfo");
        }
        return p;
    }

    public static String b(Context context) {
        boolean b2 = cz.b(context, "pref", "colde", false);
        if (b2) {
            l = b2;
            if (!c.contains("11Z")) {
                c += ";11Z";
            }
        }
        return c;
    }

    public static String c(Context context) {
        return p.b(k.e(context));
    }

    public static boolean c() {
        if (!m) {
            m = true;
            n = false;
        }
        return n;
    }

    public static void d(Context context) {
        try {
            if (da.a(e(context))) {
                a = "http://abroad.apilocate.amap.com/mobile/binary";
            } else if (TextUtils.isEmpty(b)) {
                a = "http://apilocate.amap.com/mobile/binary";
            } else {
                a = b;
            }
        } catch (Throwable th) {
            a(th, "CoreUtil", "changeUrl");
        }
    }

    private static String[] d() {
        return (String[]) o.clone();
    }

    private static String e(Context context) {
        try {
            return da.a((TelephonyManager) context.getSystemService("phone"))[0];
        } catch (Throwable th) {
            a(th, "CoreUtil", "getMcc");
            return "";
        }
    }
}
