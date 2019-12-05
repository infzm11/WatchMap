package com.amap.api.col.n3;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.iflytek.cloud.SpeechUtility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utility */
public final class bj {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getFreeBlocks()) * ((long) statFs.getBlockSize());
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has(SpeechUtility.TAG_RESOURCE_RESULT)) {
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(SpeechUtility.TAG_RESOURCE_RESULT, new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                b(jSONObject4.toString(), context);
                jSONObject2 = jSONObject4.optJSONObject(SpeechUtility.TAG_RESOURCE_RESULT);
            } catch (JSONException e) {
                JSONObject optJSONObject = jSONObject.optJSONObject(SpeechUtility.TAG_RESOURCE_RESULT);
                iu.b((Throwable) e, "Utility", "parseJson");
                e.printStackTrace();
                jSONObject2 = optJSONObject;
            }
        } else {
            jSONObject2 = jSONObject.optJSONObject(SpeechUtility.TAG_RESOURCE_RESULT);
        }
        if (jSONObject2 != null) {
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject2 == null) {
                return arrayList;
            }
            jSONObject3 = optJSONObject2.optJSONObject("offlinemapinfo_with_province");
        } else {
            jSONObject3 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        if (jSONObject3.has("version")) {
            am.d = a(jSONObject3, "version");
        }
        JSONArray optJSONArray = jSONObject3.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
            if (optJSONObject3 != null) {
                arrayList.add(a(optJSONObject3));
            }
        }
        JSONArray optJSONArray2 = jSONObject3.optJSONArray("others");
        JSONObject jSONObject5 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject5 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject5 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject5));
        return arrayList;
    }

    private static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(b(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, "size")));
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            if (optJSONArray.length() == 0) {
                arrayList.add(b(jSONObject));
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(b(optJSONObject));
                }
            }
        }
        offlineMapProvince.setCityList(arrayList);
        return offlineMapProvince;
    }

    private static String b(String str) {
        return str.equals("000001") ? "100000" : str;
    }

    private static OfflineMapCity b(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(b(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, "size")));
        return offlineMapCity;
    }

    public static long a(File file) {
        long j;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j2 = 0;
        if (listFiles == null) {
            return 0;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                j = a(file2);
            } else {
                j = file2.length();
            }
            j2 += j;
        }
        return j2;
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    if (!listFiles[i].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String a(Context context, String str) {
        try {
            return dv.a(dr.a(context).open(str));
        } catch (Throwable th) {
            iu.b(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056 A[SYNTHETIC, Splitter:B:35:0x0056] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0060 A[SYNTHETIC, Splitter:B:40:0x0060] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0073 A[SYNTHETIC, Splitter:B:48:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x007d A[SYNTHETIC, Splitter:B:53:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0089 A[SYNTHETIC, Splitter:B:60:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0093 A[SYNTHETIC, Splitter:B:65:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r5) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0047, all -> 0x0043 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x0047, all -> 0x0043 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003d, all -> 0x003a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003d, all -> 0x003a }
            java.lang.String r4 = "utf-8"
            r3.<init>(r2, r4)     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003d, all -> 0x003a }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0040, IOException -> 0x003d, all -> 0x003a }
        L_0x0017:
            java.lang.String r3 = r5.readLine()     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            if (r3 == 0) goto L_0x0021
            r0.append(r3)     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            goto L_0x0017
        L_0x0021:
            java.lang.String r0 = r0.toString()     // Catch:{ FileNotFoundException -> 0x0038, IOException -> 0x0036 }
            r5.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r5 = move-exception
            r5.printStackTrace()
        L_0x002d:
            r2.close()     // Catch:{ IOException -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0035:
            return r0
        L_0x0036:
            r0 = move-exception
            goto L_0x004a
        L_0x0038:
            r0 = move-exception
            goto L_0x0067
        L_0x003a:
            r0 = move-exception
            r5 = r1
            goto L_0x0087
        L_0x003d:
            r0 = move-exception
            r5 = r1
            goto L_0x004a
        L_0x0040:
            r0 = move-exception
            r5 = r1
            goto L_0x0067
        L_0x0043:
            r0 = move-exception
            r5 = r1
            r2 = r5
            goto L_0x0087
        L_0x0047:
            r0 = move-exception
            r5 = r1
            r2 = r5
        L_0x004a:
            java.lang.String r3 = "MapDownloadManager"
            java.lang.String r4 = "readOfflineSD io"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0086 }
            r0.printStackTrace()     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x005e
            r5.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x005e
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x005e:
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0064:
            r0 = move-exception
            r5 = r1
            r2 = r5
        L_0x0067:
            java.lang.String r3 = "MapDownloadManager"
            java.lang.String r4 = "readOfflineSD filenotfound"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0086 }
            r0.printStackTrace()     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x007b
            r5.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r5 = move-exception
            r5.printStackTrace()
        L_0x007b:
            if (r2 == 0) goto L_0x0085
            r2.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0085:
            return r1
        L_0x0086:
            r0 = move-exception
        L_0x0087:
            if (r5 == 0) goto L_0x0091
            r5.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x0091
        L_0x008d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0091:
            if (r2 == 0) goto L_0x009b
            r2.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r5 = move-exception
            r5.printStackTrace()
        L_0x009b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bj.c(java.io.File):java.lang.String");
    }

    public static void a(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(dv.b(context)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.exists() && file.getName().contains(str)) {
                    b(file);
                }
            }
            a(dv.b(context));
        }
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.exists() && file2.isDirectory()) {
                        String[] list = file2.list();
                        if (list == null) {
                            file2.delete();
                        } else if (list.length == 0) {
                            file2.delete();
                        }
                    }
                }
            }
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0077 A[SYNTHETIC, Splitter:B:35:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d A[SYNTHETIC, Splitter:B:46:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098 A[SYNTHETIC, Splitter:B:53:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r5, android.content.Context r6) {
        /*
            java.lang.String r0 = com.amap.api.col.n3.dv.b((android.content.Context) r6)
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r6 = com.amap.api.col.n3.dv.b((android.content.Context) r6)
            r1.append(r6)
            java.lang.String r6 = "offlinemapv4.png"
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            boolean r6 = r0.exists()
            if (r6 != 0) goto L_0x003c
            r0.createNewFile()     // Catch:{ IOException -> 0x0031 }
            goto L_0x003c
        L_0x0031:
            r6 = move-exception
            java.lang.String r1 = "OfflineUpdateCityHandler"
            java.lang.String r2 = "writeSD dirCreate"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r2)
            r6.printStackTrace()
        L_0x003c:
            long r1 = a()
            r3 = 1048576(0x100000, double:5.180654E-318)
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x00a1
            r6 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x006a }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0080, IOException -> 0x006a }
            java.lang.String r6 = "utf-8"
            byte[] r5 = r5.getBytes(r6)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x005f }
            r1.write(r5)     // Catch:{ FileNotFoundException -> 0x0065, IOException -> 0x0062, all -> 0x005f }
            r1.close()     // Catch:{ IOException -> 0x005a }
            return
        L_0x005a:
            r5 = move-exception
            r5.printStackTrace()
            return
        L_0x005f:
            r5 = move-exception
            r6 = r1
            goto L_0x0096
        L_0x0062:
            r5 = move-exception
            r6 = r1
            goto L_0x006b
        L_0x0065:
            r5 = move-exception
            r6 = r1
            goto L_0x0081
        L_0x0068:
            r5 = move-exception
            goto L_0x0096
        L_0x006a:
            r5 = move-exception
        L_0x006b:
            java.lang.String r0 = "OfflineUpdateCityHandler"
            java.lang.String r1 = "writeSD io"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r5, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0068 }
            r5.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x00a1
            r6.close()     // Catch:{ IOException -> 0x007b }
            return
        L_0x007b:
            r5 = move-exception
            r5.printStackTrace()
            return
        L_0x0080:
            r5 = move-exception
        L_0x0081:
            java.lang.String r0 = "OfflineUpdateCityHandler"
            java.lang.String r1 = "writeSD filenotfound"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r5, (java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0068 }
            r5.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x00a1
            r6.close()     // Catch:{ IOException -> 0x0091 }
            return
        L_0x0091:
            r5 = move-exception
            r5.printStackTrace()
            return
        L_0x0096:
            if (r6 == 0) goto L_0x00a0
            r6.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a0:
            throw r5
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.bj.b(java.lang.String, android.content.Context):void");
    }
}
