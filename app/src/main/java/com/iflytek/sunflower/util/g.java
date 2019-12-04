package com.iflytek.sunflower.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.TrafficStats;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.iflytek.sunflower.config.a;
import java.util.List;
import java.util.regex.Pattern;

public class g {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String a(Context context) {
        if (l.b(a.E)) {
            return a.E;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (a(context, "android.permission.ACCESS_WIFI_STATE")) {
                String macAddress = wifiManager.getConnectionInfo().getMacAddress();
                if (TextUtils.isEmpty(macAddress)) {
                    macAddress = "";
                }
                return macAddress;
            }
            j.a("Collector", "Get mac address failed. please check permission: ACCESS_WIFI_STATE");
            return "";
        } catch (Exception e) {
            j.a("Collector", "Get mac address failed.", e);
            return "";
        }
    }

    public static String b(Context context) {
        if (l.b(a.C)) {
            return a.C;
        }
        String str = "";
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                if (a(context, "android.permission.READ_PHONE_STATE")) {
                    String deviceId = telephonyManager.getDeviceId();
                    if (!TextUtils.isEmpty(deviceId)) {
                        str = deviceId;
                    }
                }
            } catch (Exception e) {
                j.a("Collector", "Get IMEI failed.", e);
            }
        }
        if (TextUtils.isEmpty(str)) {
            j.a("Collector", "Get IMEI failed. Try to use mac.");
            String a = a(context);
            if (!TextUtils.isEmpty(a)) {
                str = a;
            }
        }
        if (TextUtils.isEmpty(str)) {
            j.a("Collector", "Get mac failed. Try to use Secure.ANDROID_ID.");
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            if (!TextUtils.isEmpty(string)) {
                str = string;
            }
            j.a("Collector", "getDeviceId: Secure.ANDROID_ID: " + str);
        }
        return str;
    }

    public static String c(Context context) {
        try {
            String networkOperatorName = ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
            if (!TextUtils.isEmpty(networkOperatorName)) {
                return networkOperatorName;
            }
            return "";
        } catch (Exception e) {
            j.a("Collector", "Get carrier failed. ", e);
            return "";
        }
    }

    @RequiresPermission(allOf = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.WRITE_EXTERNAL_STORAGE"})
    public static Location d(Context context) {
        String str;
        j.c("Collector", "getLocation start 1");
        try {
            j.c("Collector", "getLocation start 2");
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            List<String> providers = locationManager.getProviders(true);
            if (providers.contains(GeocodeSearch.GPS)) {
                str = GeocodeSearch.GPS;
            } else if (providers.contains("network")) {
                str = "network";
            } else {
                j.c("Collector", "getLocation failed,provider was null");
                return null;
            }
            j.c("Collector", "getLocation start 3");
            if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                j.c("Collector", "getLocation start 4：" + str);
                if (locationManager.isProviderEnabled(str)) {
                    Location lastKnownLocation = locationManager.getLastKnownLocation(str);
                    int i = 0;
                    while (i < 10 && lastKnownLocation == null) {
                        lastKnownLocation = locationManager.getLastKnownLocation(str);
                        i++;
                        j.c("Collector", "getLocation start 4：" + i);
                    }
                    if (lastKnownLocation != null) {
                        j.c("Collector", "getLocation start 5");
                        if (lastKnownLocation != null) {
                            j.b("Collector", "Get location from gps:" + lastKnownLocation.getLatitude() + "," + lastKnownLocation.getLongitude());
                            return lastKnownLocation;
                        }
                    } else {
                        j.c("Collector", "getLocation start 6");
                    }
                }
                return null;
            }
            j.c("Collector", "Get location failed, please check permission: ACCESS_COARSE_LOCATION,ACCESS_COARSE_LOCATION");
            return null;
        } catch (Exception e) {
            j.c("Collector", "Get location failed", e);
        }
    }

    public static long[] e(Context context) throws Exception {
        int i = context.getApplicationInfo().uid;
        if (i == -1) {
            return null;
        }
        return new long[]{TrafficStats.getUidRxBytes(i), TrafficStats.getUidTxBytes(i)};
    }

    public static String f(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(a.b)) {
            return a.b;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String obj = applicationInfo.metaData.get("IFLYTEK_APPKEY").toString();
                if (!TextUtils.isEmpty(obj)) {
                    String trim = obj.trim();
                    try {
                        str = trim.contains("'") ? trim.replace("'", "") : trim;
                    } catch (Exception e) {
                        Exception exc = e;
                        str = trim;
                        e = exc;
                        j.d("Collector", "Can not find IFLYTEK_APPKEY meta-data from AndroidManifest.xml.", e);
                        return str;
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                j.d("Collector", "Can not find IFLYTEK_APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e2) {
            e = e2;
            j.d("Collector", "Can not find IFLYTEK_APPKEY meta-data from AndroidManifest.xml.", e);
            return str;
        }
        return str;
    }

    public static String g(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(a.e)) {
            return a.e;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                String obj = applicationInfo.metaData.get("IFLYTEK_CHANNEL").toString();
                if (!TextUtils.isEmpty(obj)) {
                    str = obj.trim();
                }
            }
            if (TextUtils.isEmpty(str)) {
                j.b("Collector", "Can not find IFLYTEK_CHANNEL meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e) {
            j.b("Collector", "Can not find IFLYTEK_CHANNEL meta-data from AndroidManifest.xml.", e);
        }
        return str;
    }

    public static String a(String str) {
        try {
            return Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("").trim();
        } catch (Exception unused) {
            j.d("Collector", "string contains special characters");
            return "";
        }
    }
}
