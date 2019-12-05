package com.loc;

import android.os.Bundle;
import com.amap.api.fence.DistrictItem;
import com.amap.api.fence.GeoFence;
import com.amap.api.fence.PoiItem;
import com.amap.api.location.DPoint;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GeoFenceSearchResultParser */
public final class c {
    private static long a;

    public static int a(String str, List<GeoFence> list, Bundle bundle) {
        int i;
        int i2;
        List<GeoFence> list2 = list;
        Bundle bundle2 = bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            char c = 0;
            int optInt = jSONObject.optInt("status", 0);
            i = jSONObject.optInt("infocode", 0);
            if (optInt == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("pois");
                if (optJSONArray != null) {
                    int i3 = 0;
                    while (i3 < optJSONArray.length()) {
                        GeoFence geoFence = new GeoFence();
                        PoiItem poiItem = new PoiItem();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        poiItem.setPoiId(jSONObject2.optString("id"));
                        poiItem.setPoiName(jSONObject2.optString("name"));
                        poiItem.setPoiType(jSONObject2.optString("type"));
                        poiItem.setTypeCode(jSONObject2.optString("typecode"));
                        poiItem.setAddress(jSONObject2.optString("address"));
                        String optString = jSONObject2.optString("location");
                        if (optString != null) {
                            String[] split = optString.split(",");
                            poiItem.setLongitude(Double.parseDouble(split[c]));
                            poiItem.setLatitude(Double.parseDouble(split[1]));
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            i2 = i;
                            DPoint dPoint = new DPoint(poiItem.getLatitude(), poiItem.getLongitude());
                            arrayList2.add(dPoint);
                            arrayList.add(arrayList2);
                            geoFence.setPointList(arrayList);
                            geoFence.setCenter(dPoint);
                        } else {
                            i2 = i;
                        }
                        poiItem.setTel(jSONObject2.optString("tel"));
                        poiItem.setProvince(jSONObject2.optString("pname"));
                        poiItem.setCity(jSONObject2.optString("cityname"));
                        poiItem.setAdname(jSONObject2.optString("adname"));
                        geoFence.setPoiItem(poiItem);
                        geoFence.setFenceId(a());
                        if (bundle2 != null) {
                            geoFence.setCustomId(bundle2.getString(GeoFence.BUNDLE_KEY_CUSTOMID));
                            geoFence.setPendingIntentAction(bundle2.getString("pendingIntentAction"));
                            geoFence.setType(2);
                            geoFence.setRadius(bundle2.getFloat("geoRadius"));
                            geoFence.setExpiration(bundle2.getLong("expiration"));
                            geoFence.setActivatesAction(bundle2.getInt("activatesAction", 1));
                        }
                        if (list2 != null) {
                            list2.add(geoFence);
                        }
                        i3++;
                        i = i2;
                        c = 0;
                    }
                }
            }
        } catch (Throwable unused) {
            i = 5;
        }
        return i;
    }

    public static synchronized long a() {
        long j;
        synchronized (c.class) {
            boolean z = false;
            while (!z) {
                try {
                    long b = da.b();
                    if (b == a) {
                        try {
                            Thread.currentThread();
                            Thread.sleep(1);
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        a = b;
                        z = true;
                    }
                } finally {
                }
            }
            j = a;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.amap.api.location.DPoint> a(java.util.List<com.amap.api.location.DPoint> r30, float r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            if (r1 != 0) goto L_0x000a
            r1 = 0
            return r1
        L_0x000a:
            int r3 = r30.size()
            r4 = 2
            if (r3 > r4) goto L_0x0012
            return r1
        L_0x0012:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r4 = 0
            java.lang.Object r5 = r1.get(r4)
            com.amap.api.location.DPoint r5 = (com.amap.api.location.DPoint) r5
            int r6 = r30.size()
            r7 = 1
            int r6 = r6 - r7
            java.lang.Object r6 = r1.get(r6)
            com.amap.api.location.DPoint r6 = (com.amap.api.location.DPoint) r6
            r8 = 0
            r13 = r4
            r10 = r7
            r11 = r8
        L_0x002f:
            int r14 = r30.size()
            int r14 = r14 - r7
            if (r10 >= r14) goto L_0x00f0
            java.lang.Object r14 = r1.get(r10)
            com.amap.api.location.DPoint r14 = (com.amap.api.location.DPoint) r14
            double r15 = r14.getLongitude()
            double r17 = r5.getLongitude()
            double r15 = r15 - r17
            double r17 = r14.getLatitude()
            double r19 = r5.getLatitude()
            double r17 = r17 - r19
            double r19 = r6.getLongitude()
            double r21 = r5.getLongitude()
            double r19 = r19 - r21
            double r21 = r6.getLatitude()
            double r23 = r5.getLatitude()
            double r21 = r21 - r23
            double r15 = r15 * r19
            double r17 = r17 * r21
            double r15 = r15 + r17
            double r17 = r19 * r19
            double r23 = r21 * r21
            double r17 = r17 + r23
            double r15 = r15 / r17
            int r17 = (r15 > r8 ? 1 : (r15 == r8 ? 0 : -1))
            if (r17 < 0) goto L_0x00b4
            double r17 = r5.getLongitude()
            double r23 = r6.getLongitude()
            int r17 = (r17 > r23 ? 1 : (r17 == r23 ? 0 : -1))
            if (r17 != 0) goto L_0x008f
            double r17 = r5.getLatitude()
            double r23 = r6.getLatitude()
            int r17 = (r17 > r23 ? 1 : (r17 == r23 ? 0 : -1))
            if (r17 != 0) goto L_0x008f
            goto L_0x00b4
        L_0x008f:
            r17 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r17 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r17 <= 0) goto L_0x009e
            double r15 = r6.getLongitude()
            double r17 = r6.getLatitude()
            goto L_0x00bc
        L_0x009e:
            double r17 = r5.getLongitude()
            double r19 = r19 * r15
            double r17 = r17 + r19
            double r19 = r5.getLatitude()
            double r15 = r15 * r21
            double r15 = r19 + r15
            r25 = r5
            r8 = r15
            r4 = r17
            goto L_0x00c1
        L_0x00b4:
            double r15 = r5.getLongitude()
            double r17 = r5.getLatitude()
        L_0x00bc:
            r25 = r5
            r4 = r15
            r8 = r17
        L_0x00c1:
            com.amap.api.location.DPoint r15 = new com.amap.api.location.DPoint
            r26 = r8
            double r7 = r14.getLatitude()
            double r0 = r14.getLongitude()
            r15.<init>(r7, r0)
            com.amap.api.location.DPoint r0 = new com.amap.api.location.DPoint
            r7 = r26
            r0.<init>(r7, r4)
            float r0 = com.loc.da.a((com.amap.api.location.DPoint) r15, (com.amap.api.location.DPoint) r0)
            double r0 = (double) r0
            int r4 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x00e2
            r11 = r0
            r13 = r10
        L_0x00e2:
            int r10 = r10 + 1
            r5 = r25
            r0 = r29
            r1 = r30
            r4 = 0
            r7 = 1
            r8 = 0
            goto L_0x002f
        L_0x00f0:
            r25 = r5
            double r0 = (double) r2
            int r0 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r0 >= 0) goto L_0x0100
            r5 = r25
            r3.add(r5)
            r3.add(r6)
            return r3
        L_0x0100:
            int r0 = r13 + 1
            r1 = r30
            r4 = 0
            java.util.List r0 = r1.subList(r4, r0)
            r4 = r29
            java.util.List r0 = r4.a(r0, r2)
            int r5 = r30.size()
            java.util.List r1 = r1.subList(r13, r5)
            java.util.List r1 = r4.a(r1, r2)
            r3.addAll(r0)
            int r0 = r3.size()
            r2 = 1
            int r0 = r0 - r2
            r3.remove(r0)
            r3.addAll(r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.c.a(java.util.List, float):java.util.List");
    }

    public static int b(String str, List<GeoFence> list, Bundle bundle) {
        return a(str, list, bundle);
    }

    public final int c(String str, List<GeoFence> list, Bundle bundle) {
        int i;
        long j;
        String str2;
        int i2;
        ArrayList arrayList;
        ArrayList arrayList2;
        long j2;
        String str3;
        String str4;
        float f;
        int i3;
        boolean z;
        long j3;
        String str5;
        String str6;
        List<GeoFence> list2 = list;
        Bundle bundle2 = bundle;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("status", 0);
            i = jSONObject.optInt("infocode", 0);
            float f2 = 0.0f;
            String str7 = null;
            if (bundle2 != null) {
                str7 = bundle2.getString(GeoFence.BUNDLE_KEY_CUSTOMID);
                String string = bundle2.getString("pendingIntentAction");
                float f3 = bundle2.getFloat("geoRadius");
                j = bundle2.getLong("expiration");
                i2 = bundle2.getInt("activatesAction");
                float f4 = f3;
                str2 = string;
                f2 = f4;
            } else {
                i2 = 0;
                j = 0;
                str2 = null;
            }
            if (optInt == 1) {
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray != null) {
                    int i4 = 0;
                    while (i4 < optJSONArray.length()) {
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        GeoFence geoFence = new GeoFence();
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        String optString = jSONObject2.optString("citycode");
                        String optString2 = jSONObject2.optString("adcode");
                        JSONArray jSONArray = optJSONArray;
                        String optString3 = jSONObject2.optString("name");
                        int i5 = i;
                        String string2 = jSONObject2.getString("center");
                        int i6 = i4;
                        DPoint dPoint = new DPoint();
                        if (string2 != null) {
                            String[] split = string2.split(",");
                            arrayList2 = arrayList3;
                            arrayList = arrayList4;
                            dPoint.setLatitude(Double.parseDouble(split[1]));
                            dPoint.setLongitude(Double.parseDouble(split[0]));
                            geoFence.setCenter(dPoint);
                        } else {
                            arrayList2 = arrayList3;
                            arrayList = arrayList4;
                        }
                        geoFence.setCustomId(str7);
                        geoFence.setPendingIntentAction(str2);
                        geoFence.setType(3);
                        geoFence.setRadius(f2);
                        geoFence.setExpiration(j);
                        geoFence.setActivatesAction(i2);
                        geoFence.setFenceId(a());
                        String optString4 = jSONObject2.optString("polyline");
                        if (optString4 != null) {
                            String[] split2 = optString4.split("\\|");
                            int length = split2.length;
                            float f5 = Float.MAX_VALUE;
                            float f6 = Float.MIN_VALUE;
                            int i7 = 0;
                            while (i7 < length) {
                                int i8 = i2;
                                String str8 = split2[i7];
                                String[] strArr = split2;
                                DistrictItem districtItem = new DistrictItem();
                                float f7 = f2;
                                List arrayList5 = new ArrayList();
                                districtItem.setCitycode(optString);
                                districtItem.setAdcode(optString2);
                                districtItem.setDistrictName(optString3);
                                String str9 = optString3;
                                String[] split3 = str8.split(VoiceWakeuperAidl.PARAMS_SEPARATE);
                                String str10 = optString;
                                int i9 = 0;
                                while (i9 < split3.length) {
                                    String[] strArr2 = split3;
                                    String[] split4 = split3[i9].split(",");
                                    String str11 = str2;
                                    if (split4.length > 1) {
                                        str5 = optString2;
                                        str6 = str7;
                                        j3 = j;
                                        arrayList5.add(new DPoint(Double.parseDouble(split4[1]), Double.parseDouble(split4[0])));
                                    } else {
                                        str5 = optString2;
                                        str6 = str7;
                                        j3 = j;
                                    }
                                    i9++;
                                    split3 = strArr2;
                                    str2 = str11;
                                    str7 = str6;
                                    optString2 = str5;
                                    j = j3;
                                }
                                String str12 = str2;
                                String str13 = optString2;
                                String str14 = str7;
                                long j4 = j;
                                if (((float) arrayList5.size()) > 100.0f) {
                                    try {
                                        arrayList5 = a(arrayList5, 100.0f);
                                    } catch (Throwable unused) {
                                        i = 5;
                                        return i;
                                    }
                                }
                                ArrayList arrayList6 = arrayList;
                                arrayList6.add(arrayList5);
                                districtItem.setPolyline(arrayList5);
                                ArrayList arrayList7 = arrayList2;
                                arrayList7.add(districtItem);
                                f6 = Math.max(f6, a.b(dPoint, (List<DPoint>) arrayList5));
                                f5 = Math.min(f5, a.a(dPoint, (List<DPoint>) arrayList5));
                                i7++;
                                arrayList = arrayList6;
                                arrayList2 = arrayList7;
                                i2 = i8;
                                split2 = strArr;
                                f2 = f7;
                                optString3 = str9;
                                optString = str10;
                                str2 = str12;
                                str7 = str14;
                                optString2 = str13;
                                j = j4;
                            }
                            i3 = i2;
                            f = f2;
                            str4 = str2;
                            str3 = str7;
                            j2 = j;
                            z = false;
                            geoFence.setMaxDis2Center(f6);
                            geoFence.setMinDis2Center(f5);
                            geoFence.setDistrictItemList(arrayList2);
                            geoFence.setPointList(arrayList);
                            List<GeoFence> list3 = list;
                            if (list3 != null) {
                                list3.add(geoFence);
                            }
                        } else {
                            i3 = i2;
                            f = f2;
                            str4 = str2;
                            str3 = str7;
                            j2 = j;
                            List<GeoFence> list4 = list;
                            z = false;
                        }
                        i4 = i6 + 1;
                        boolean z2 = z;
                        optJSONArray = jSONArray;
                        i = i5;
                        i2 = i3;
                        f2 = f;
                        str2 = str4;
                        str7 = str3;
                        j = j2;
                    }
                }
            }
        } catch (Throwable unused2) {
            i = 5;
            return i;
        }
        return i;
    }
}
