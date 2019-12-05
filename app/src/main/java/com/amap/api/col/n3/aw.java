package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import org.json.JSONObject;

@jb(a = "update_item", b = true)
/* compiled from: UpdateItem */
public class aw extends az {
    private String n = "";
    private Context o;

    public aw() {
    }

    public aw(OfflineMapCity offlineMapCity, Context context) {
        this.o = context;
        this.a = offlineMapCity.getCity();
        this.c = offlineMapCity.getAdcode();
        this.b = offlineMapCity.getUrl();
        this.g = offlineMapCity.getSize();
        this.e = offlineMapCity.getVersion();
        this.k = offlineMapCity.getCode();
        this.i = 0;
        this.l = offlineMapCity.getState();
        this.j = offlineMapCity.getcompleteCode();
        this.m = offlineMapCity.getPinyin();
        h();
    }

    public aw(OfflineMapProvince offlineMapProvince, Context context) {
        this.o = context;
        this.a = offlineMapProvince.getProvinceName();
        this.c = offlineMapProvince.getProvinceCode();
        this.b = offlineMapProvince.getUrl();
        this.g = offlineMapProvince.getSize();
        this.e = offlineMapProvince.getVersion();
        this.i = 1;
        this.l = offlineMapProvince.getState();
        this.j = offlineMapProvince.getcompleteCode();
        this.m = offlineMapProvince.getPinyin();
        h();
    }

    private void h() {
        String b = dv.b(this.o);
        this.d = b + this.m + ".zip.tmp";
    }

    public final String a() {
        return this.n;
    }

    public final void a(String str) {
        this.n = str;
    }

    public final void b(String str) {
        if (str != null) {
            try {
                if (!str.equals("")) {
                    JSONObject jSONObject = new JSONObject(str).getJSONObject("file");
                    if (jSONObject != null) {
                        this.a = jSONObject.optString("title");
                        this.c = jSONObject.optString("code");
                        this.b = jSONObject.optString("url");
                        this.d = jSONObject.optString("fileName");
                        this.f = jSONObject.optLong("lLocalLength");
                        this.g = jSONObject.optLong("lRemoteLength");
                        this.l = jSONObject.optInt("mState");
                        this.e = jSONObject.optString("version");
                        this.h = jSONObject.optString("localPath");
                        this.n = jSONObject.optString("vMapFileNames");
                        this.i = jSONObject.optInt("isSheng");
                        this.j = jSONObject.optInt("mCompleteCode");
                        this.k = jSONObject.optString("mCityCode");
                        this.m = jSONObject == null ? "" : (!jSONObject.has("pinyin") || jSONObject.getString("pinyin").equals("[]")) ? "" : jSONObject.optString("pinyin").trim();
                        if (this.m.equals("")) {
                            String substring = this.b.substring(this.b.lastIndexOf("/") + 1);
                            this.m = substring.substring(0, substring.lastIndexOf("."));
                        }
                    }
                }
            } catch (Throwable th) {
                iu.b(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c3 A[SYNTHETIC, Splitter:B:28:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00cf A[SYNTHETIC, Splitter:B:35:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r6 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00d8 }
            r1.<init>()     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "title"
            java.lang.String r3 = r6.a     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "code"
            java.lang.String r3 = r6.c     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "url"
            java.lang.String r3 = r6.b     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "fileName"
            java.lang.String r3 = r6.d     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "lLocalLength"
            long r3 = r6.f     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "lRemoteLength"
            long r3 = r6.g     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "mState"
            int r3 = r6.l     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "version"
            java.lang.String r3 = r6.e     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "localPath"
            java.lang.String r3 = r6.h     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = r6.n     // Catch:{ Throwable -> 0x00d8 }
            if (r2 == 0) goto L_0x0054
            java.lang.String r2 = "vMapFileNames"
            java.lang.String r3 = r6.n     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
        L_0x0054:
            java.lang.String r2 = "isSheng"
            int r3 = r6.i     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "mCompleteCode"
            int r3 = r6.j     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "mCityCode"
            java.lang.String r3 = r6.k     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "pinyin"
            java.lang.String r3 = r6.m     // Catch:{ Throwable -> 0x00d8 }
            r1.put(r2, r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = "file"
            r0.put(r2, r1)     // Catch:{ Throwable -> 0x00d8 }
            java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00d8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00d8 }
            r2.<init>()     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r3 = r6.d     // Catch:{ Throwable -> 0x00d8 }
            r2.append(r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r3 = ".dt"
            r2.append(r3)     // Catch:{ Throwable -> 0x00d8 }
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x00d8 }
            r1.<init>(r2)     // Catch:{ Throwable -> 0x00d8 }
            r1.delete()     // Catch:{ Throwable -> 0x00d8 }
            r2 = 0
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00b6 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00b6 }
            r5 = 1
            r4.<init>(r1, r5)     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r1 = "utf-8"
            r3.<init>(r4, r1)     // Catch:{ IOException -> 0x00b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            r3.write(r0)     // Catch:{ IOException -> 0x00b1, all -> 0x00ae }
            r3.close()     // Catch:{ IOException -> 0x00a9 }
            return
        L_0x00a9:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x00d8 }
            return
        L_0x00ae:
            r0 = move-exception
            r2 = r3
            goto L_0x00cd
        L_0x00b1:
            r0 = move-exception
            r2 = r3
            goto L_0x00b7
        L_0x00b4:
            r0 = move-exception
            goto L_0x00cd
        L_0x00b6:
            r0 = move-exception
        L_0x00b7:
            java.lang.String r1 = "UpdateItem"
            java.lang.String r3 = "saveJSONObjectToFile"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r3)     // Catch:{ all -> 0x00b4 }
            r0.printStackTrace()     // Catch:{ all -> 0x00b4 }
            if (r2 == 0) goto L_0x00cc
            r2.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00cc
        L_0x00c7:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Throwable -> 0x00d8 }
            return
        L_0x00cc:
            return
        L_0x00cd:
            if (r2 == 0) goto L_0x00d7
            r2.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00d7
        L_0x00d3:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ Throwable -> 0x00d8 }
        L_0x00d7:
            throw r0     // Catch:{ Throwable -> 0x00d8 }
        L_0x00d8:
            r0 = move-exception
            java.lang.String r1 = "UpdateItem"
            java.lang.String r2 = "saveJSONObjectToFile parseJson"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
            r0.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.aw.b():void");
    }
}
