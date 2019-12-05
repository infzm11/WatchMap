package com.loc;

/* compiled from: Parser */
public final class cp {
    private StringBuilder a = new StringBuilder();

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0083 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d1 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e3 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f0 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010c A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0136 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0144 A[Catch:{ Throwable -> 0x01c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0152 A[Catch:{ Throwable -> 0x01c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.autonavi.aps.amapapi.model.AMapLocationServer a(java.lang.String r10) {
        /*
            r0 = 0
            com.autonavi.aps.amapapi.model.AMapLocationServer r1 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = ""
            r1.<init>(r2)     // Catch:{ Throwable -> 0x01c7 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Throwable -> 0x01c7 }
            r2.<init>(r10)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r10 = "regeocode"
            org.json.JSONObject r10 = r2.optJSONObject(r10)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = "addressComponent"
            org.json.JSONObject r2 = r10.optJSONObject(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = "country"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = b(r3)     // Catch:{ Throwable -> 0x01c7 }
            r1.setCountry(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = "province"
            java.lang.String r3 = r2.optString(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = b(r3)     // Catch:{ Throwable -> 0x01c7 }
            r1.setProvince(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r4 = "citycode"
            java.lang.String r4 = r2.optString(r4)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r4 = b(r4)     // Catch:{ Throwable -> 0x01c7 }
            r1.setCityCode(r4)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r5 = "city"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r6 = "010"
            boolean r6 = r4.endsWith(r6)     // Catch:{ Throwable -> 0x01c7 }
            if (r6 != 0) goto L_0x006f
            java.lang.String r6 = "021"
            boolean r6 = r4.endsWith(r6)     // Catch:{ Throwable -> 0x01c7 }
            if (r6 != 0) goto L_0x006f
            java.lang.String r6 = "022"
            boolean r6 = r4.endsWith(r6)     // Catch:{ Throwable -> 0x01c7 }
            if (r6 != 0) goto L_0x006f
            java.lang.String r6 = "023"
            boolean r4 = r4.endsWith(r6)     // Catch:{ Throwable -> 0x01c7 }
            if (r4 == 0) goto L_0x0067
            goto L_0x006f
        L_0x0067:
            java.lang.String r4 = b(r5)     // Catch:{ Throwable -> 0x01c7 }
            r1.setCity(r4)     // Catch:{ Throwable -> 0x01c7 }
            goto L_0x007d
        L_0x006f:
            if (r3 == 0) goto L_0x007c
            int r4 = r3.length()     // Catch:{ Throwable -> 0x01c7 }
            if (r4 <= 0) goto L_0x007c
            r1.setCity(r3)     // Catch:{ Throwable -> 0x01c7 }
            r4 = r3
            goto L_0x007d
        L_0x007c:
            r4 = r5
        L_0x007d:
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x01c7 }
            if (r5 == 0) goto L_0x0087
            r1.setCity(r3)     // Catch:{ Throwable -> 0x01c7 }
            r4 = r3
        L_0x0087:
            java.lang.String r5 = "district"
            java.lang.String r5 = r2.optString(r5)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r5 = b(r5)     // Catch:{ Throwable -> 0x01c7 }
            r1.setDistrict(r5)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r6 = "adcode"
            java.lang.String r6 = r2.optString(r6)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r6 = b(r6)     // Catch:{ Throwable -> 0x01c7 }
            r1.setAdCode(r6)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r7 = "streetNumber"
            org.json.JSONObject r2 = r2.optJSONObject(r7)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r7 = "street"
            java.lang.String r7 = r2.optString(r7)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r7 = b(r7)     // Catch:{ Throwable -> 0x01c7 }
            r1.setStreet(r7)     // Catch:{ Throwable -> 0x01c7 }
            r1.setRoad(r7)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r8 = "number"
            java.lang.String r2 = r2.optString(r8)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = b(r2)     // Catch:{ Throwable -> 0x01c7 }
            r1.setNumber(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = "pois"
            org.json.JSONArray r2 = r10.optJSONArray(r2)     // Catch:{ Throwable -> 0x01c7 }
            int r8 = r2.length()     // Catch:{ Throwable -> 0x01c7 }
            r9 = 0
            if (r8 <= 0) goto L_0x00e3
            org.json.JSONObject r2 = r2.getJSONObject(r9)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r8 = "name"
            java.lang.String r2 = r2.optString(r8)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = b(r2)     // Catch:{ Throwable -> 0x01c7 }
            r1.setPoiName(r2)     // Catch:{ Throwable -> 0x01c7 }
            goto L_0x00e4
        L_0x00e3:
            r2 = r0
        L_0x00e4:
            java.lang.String r8 = "aois"
            org.json.JSONArray r10 = r10.optJSONArray(r8)     // Catch:{ Throwable -> 0x01c7 }
            int r8 = r10.length()     // Catch:{ Throwable -> 0x01c7 }
            if (r8 <= 0) goto L_0x0101
            org.json.JSONObject r10 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r8 = "name"
            java.lang.String r10 = r10.optString(r8)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r10 = b(r10)     // Catch:{ Throwable -> 0x01c7 }
            r1.setAoiName(r10)     // Catch:{ Throwable -> 0x01c7 }
        L_0x0101:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01c7 }
            r10.<init>()     // Catch:{ Throwable -> 0x01c7 }
            boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x01c7 }
            if (r8 != 0) goto L_0x0114
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r8 = " "
            r10.append(r8)     // Catch:{ Throwable -> 0x01c7 }
        L_0x0114:
            boolean r8 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Throwable -> 0x01c7 }
            if (r8 != 0) goto L_0x0130
            java.lang.String r8 = "市"
            boolean r8 = r3.contains(r8)     // Catch:{ Throwable -> 0x01c7 }
            if (r8 == 0) goto L_0x0128
            boolean r3 = r3.equals(r4)     // Catch:{ Throwable -> 0x01c7 }
            if (r3 != 0) goto L_0x0130
        L_0x0128:
            r10.append(r4)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = " "
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
        L_0x0130:
            boolean r3 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x01c7 }
            if (r3 != 0) goto L_0x013e
            r10.append(r5)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = " "
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
        L_0x013e:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x01c7 }
            if (r3 != 0) goto L_0x014c
            r10.append(r7)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = " "
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
        L_0x014c:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x01c7 }
            if (r3 != 0) goto L_0x017b
            boolean r3 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x01c7 }
            if (r3 != 0) goto L_0x015d
            java.lang.String r3 = "靠近"
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
        L_0x015d:
            r10.append(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = " "
            r10.append(r3)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r4 = "在"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x01c7 }
            r3.append(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = "附近"
            r3.append(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = r3.toString()     // Catch:{ Throwable -> 0x01c7 }
            r1.setDescription(r2)     // Catch:{ Throwable -> 0x01c7 }
        L_0x017b:
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ Throwable -> 0x01c7 }
            r2.<init>()     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = "citycode"
            java.lang.String r4 = r1.getCityCode()     // Catch:{ Throwable -> 0x01c7 }
            r2.putString(r3, r4)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = "desc"
            java.lang.String r4 = r10.toString()     // Catch:{ Throwable -> 0x01c7 }
            r2.putString(r3, r4)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r3 = "adcode"
            java.lang.String r4 = r1.getAdCode()     // Catch:{ Throwable -> 0x01c7 }
            r2.putString(r3, r4)     // Catch:{ Throwable -> 0x01c7 }
            r1.setExtras(r2)     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = r10.toString()     // Catch:{ Throwable -> 0x01c7 }
            r1.f(r2)     // Catch:{ Throwable -> 0x01c7 }
            if (r6 == 0) goto L_0x01c1
            java.lang.String r2 = r6.trim()     // Catch:{ Throwable -> 0x01c7 }
            int r2 = r2.length()     // Catch:{ Throwable -> 0x01c7 }
            if (r2 <= 0) goto L_0x01c1
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x01c7 }
            java.lang.String r2 = " "
            java.lang.String r3 = ""
            java.lang.String r10 = r10.replace(r2, r3)     // Catch:{ Throwable -> 0x01c7 }
        L_0x01bd:
            r1.setAddress(r10)     // Catch:{ Throwable -> 0x01c7 }
            return r1
        L_0x01c1:
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x01c7 }
            goto L_0x01bd
            return r1
        L_0x01c7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cp.a(java.lang.String):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    private static String b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02da, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02db, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x0335, code lost:
        r6.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cc, code lost:
        r5 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e3, code lost:
        r7 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00fa, code lost:
        r9 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0114, code lost:
        r10 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012b, code lost:
        r11 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x016e, code lost:
        r13 = "";
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:128:0x0290 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x02a5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x00b6 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00fb */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0115 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x012c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0143 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0158 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x016f */
    /* JADX WARNING: Missing exception handler attribute for start block: B:87:0x0184 */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01b9 A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x01c7 A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01d5 A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01e3 A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x023c A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02ab A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02ba A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02da A[ExcHandler: all (r0v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:23:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0335  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x018f A[Catch:{ Throwable -> 0x02dd, all -> 0x02da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer a(com.autonavi.aps.amapapi.model.AMapLocationServer r18, byte[] r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = 0
            r4 = 5
            if (r19 != 0) goto L_0x0031
            r2.setErrorCode(r4)     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.StringBuilder r6 = r1.a     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.String r7 = "binaryResult is null#0504"
            r6.append(r7)     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.StringBuilder r6 = r1.a     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.String r6 = r6.toString()     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            r2.setLocationDetail(r6)     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.StringBuilder r6 = r1.a     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            java.lang.StringBuilder r7 = r1.a     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            int r7 = r7.length()     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            r6.delete(r3, r7)     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            return r2
        L_0x0027:
            r0 = move-exception
            r2 = r0
            r6 = 0
            goto L_0x0333
        L_0x002c:
            r0 = move-exception
            r2 = r0
            r5 = 0
            goto L_0x02e0
        L_0x0031:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r19)     // Catch:{ Throwable -> 0x002c, all -> 0x0027 }
            byte r7 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r7 != 0) goto L_0x004f
            short r7 = r6.getShort()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.b((java.lang.String) r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.clear()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r6 == 0) goto L_0x004e
            r6.clear()
        L_0x004e:
            return r2
        L_0x004f:
            int r7 = r6.getInt()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            double r7 = (double) r7     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r9 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r7 = r7 / r9
            double r7 = com.loc.da.a((double) r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setLongitude(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            int r7 = r6.getInt()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            double r7 = (double) r7     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            double r7 = r7 / r9
            double r7 = com.loc.da.a((double) r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setLatitude(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            short r7 = r6.getShort()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            float r7 = (float) r7     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setAccuracy(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            byte r7 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.c(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            byte r7 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.d(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            byte r7 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r8 = 1
            if (r7 != r8) goto L_0x025b
            java.lang.String r7 = ""
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            java.lang.String r11 = ""
            java.lang.String r12 = ""
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            byte r15 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r15 = r15 & 255(0xff, float:3.57E-43)
            byte[] r15 = new byte[r15]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r15)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r3 = new java.lang.String     // Catch:{ Throwable -> 0x00b6, all -> 0x02da }
            java.lang.String r5 = "UTF-8"
            r3.<init>(r15, r5)     // Catch:{ Throwable -> 0x00b6, all -> 0x02da }
            r2.setCountry(r3)     // Catch:{ Throwable -> 0x00b6, all -> 0x02da }
        L_0x00b6:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x00cc, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r5.<init>(r3, r15)     // Catch:{ Throwable -> 0x00cc, all -> 0x02da }
            r2.setProvince(r5)     // Catch:{ Throwable -> 0x00cd, all -> 0x02da }
            goto L_0x00cd
        L_0x00cc:
            r5 = r7
        L_0x00cd:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = new java.lang.String     // Catch:{ Throwable -> 0x00e3, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r7.<init>(r3, r15)     // Catch:{ Throwable -> 0x00e3, all -> 0x02da }
            r2.setCity(r7)     // Catch:{ Throwable -> 0x00e4, all -> 0x02da }
            goto L_0x00e4
        L_0x00e3:
            r7 = r9
        L_0x00e4:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r9 = new java.lang.String     // Catch:{ Throwable -> 0x00fa, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r9.<init>(r3, r15)     // Catch:{ Throwable -> 0x00fa, all -> 0x02da }
            r2.setDistrict(r9)     // Catch:{ Throwable -> 0x00fb, all -> 0x02da }
            goto L_0x00fb
        L_0x00fa:
            r9 = r10
        L_0x00fb:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r10 = new java.lang.String     // Catch:{ Throwable -> 0x0114, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r10.<init>(r3, r15)     // Catch:{ Throwable -> 0x0114, all -> 0x02da }
            r2.setStreet(r10)     // Catch:{ Throwable -> 0x0115, all -> 0x02da }
            r2.setRoad(r10)     // Catch:{ Throwable -> 0x0115, all -> 0x02da }
            goto L_0x0115
        L_0x0114:
            r10 = r11
        L_0x0115:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r11 = new java.lang.String     // Catch:{ Throwable -> 0x012b, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r11.<init>(r3, r15)     // Catch:{ Throwable -> 0x012b, all -> 0x02da }
            r2.setNumber(r11)     // Catch:{ Throwable -> 0x012c, all -> 0x02da }
            goto L_0x012c
        L_0x012b:
            r11 = r12
        L_0x012c:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r12 = new java.lang.String     // Catch:{ Throwable -> 0x0142, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r12.<init>(r3, r15)     // Catch:{ Throwable -> 0x0142, all -> 0x02da }
            r2.setPoiName(r12)     // Catch:{ Throwable -> 0x0143, all -> 0x02da }
            goto L_0x0143
        L_0x0142:
            r12 = r13
        L_0x0143:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r13 = new java.lang.String     // Catch:{ Throwable -> 0x0158, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r13.<init>(r3, r15)     // Catch:{ Throwable -> 0x0158, all -> 0x02da }
            r2.setAoiName(r13)     // Catch:{ Throwable -> 0x0158, all -> 0x02da }
        L_0x0158:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r13 = new java.lang.String     // Catch:{ Throwable -> 0x016e, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r13.<init>(r3, r15)     // Catch:{ Throwable -> 0x016e, all -> 0x02da }
            r2.setAdCode(r13)     // Catch:{ Throwable -> 0x016f, all -> 0x02da }
            goto L_0x016f
        L_0x016e:
            r13 = r14
        L_0x016f:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r14 = new java.lang.String     // Catch:{ Throwable -> 0x0184, all -> 0x02da }
            java.lang.String r15 = "UTF-8"
            r14.<init>(r3, r15)     // Catch:{ Throwable -> 0x0184, all -> 0x02da }
            r2.setCityCode(r14)     // Catch:{ Throwable -> 0x0184, all -> 0x02da }
        L_0x0184:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3.<init>()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            boolean r14 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r14 != 0) goto L_0x0197
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r14 = " "
            r3.append(r14)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x0197:
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r14 != 0) goto L_0x01b3
            java.lang.String r14 = "市"
            boolean r14 = r5.contains(r14)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r14 == 0) goto L_0x01ab
            boolean r5 = r5.equals(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x01b3
        L_0x01ab:
            r3.append(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x01b3:
            boolean r5 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x01c1
            r3.append(r9)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x01c1:
            boolean r5 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x01cf
            r3.append(r10)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x01cf:
            boolean r5 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x01dd
            r3.append(r11)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x01dd:
            boolean r5 = android.text.TextUtils.isEmpty(r12)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x020c
            boolean r5 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 != 0) goto L_0x01ee
            java.lang.String r5 = "靠近"
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x01ee:
            r3.append(r12)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            r3.append(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = "在"
            r5.<init>(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r5.append(r12)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = "附近"
            r5.append(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = r5.toString()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setDescription(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x020c:
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r5.<init>()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = "citycode"
            java.lang.String r9 = r18.getCityCode()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r5.putString(r7, r9)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = "desc"
            java.lang.String r9 = r3.toString()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r5.putString(r7, r9)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r7 = "adcode"
            java.lang.String r9 = r18.getAdCode()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r5.putString(r7, r9)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setExtras(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = r3.toString()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.f(r5)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = r18.getAdCode()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 == 0) goto L_0x0256
            java.lang.String r5 = r5.trim()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            int r5 = r5.length()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r5 <= 0) goto L_0x0256
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = " "
            java.lang.String r7 = ""
            java.lang.String r3 = r3.replace(r5, r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x0252:
            r2.setAddress(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            goto L_0x025b
        L_0x0256:
            java.lang.String r3 = r3.toString()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            goto L_0x0252
        L_0x025b:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r3 != r8) goto L_0x0275
            r6.getInt()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.getInt()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.getShort()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x0275:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r3 != r8) goto L_0x02a5
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x0290, all -> 0x02da }
            java.lang.String r7 = "UTF-8"
            r5.<init>(r3, r7)     // Catch:{ Throwable -> 0x0290, all -> 0x02da }
            r2.setBuildingId(r5)     // Catch:{ Throwable -> 0x0290, all -> 0x02da }
        L_0x0290:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x02a5, all -> 0x02da }
            java.lang.String r7 = "UTF-8"
            r5.<init>(r3, r7)     // Catch:{ Throwable -> 0x02a5, all -> 0x02da }
            r2.setFloor(r5)     // Catch:{ Throwable -> 0x02a5, all -> 0x02da }
        L_0x02a5:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r3 != r8) goto L_0x02b4
            r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.getInt()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x02b4:
            byte r3 = r6.get()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            if (r3 != r8) goto L_0x02c1
            long r7 = r6.getLong()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r2.setTime(r7)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
        L_0x02c1:
            short r3 = r6.getShort()     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            byte[] r3 = new byte[r3]     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            r6.get(r3)     // Catch:{ Throwable -> 0x02dd, all -> 0x02da }
            java.lang.String r4 = new java.lang.String     // Catch:{ Throwable -> 0x02d4, all -> 0x02da }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch:{ Throwable -> 0x02d4, all -> 0x02da }
            r2.a((java.lang.String) r4)     // Catch:{ Throwable -> 0x02d4, all -> 0x02da }
        L_0x02d4:
            if (r6 == 0) goto L_0x031b
            r6.clear()
            goto L_0x031b
        L_0x02da:
            r0 = move-exception
            r2 = r0
            goto L_0x0333
        L_0x02dd:
            r0 = move-exception
            r2 = r0
            r5 = r6
        L_0x02e0:
            com.autonavi.aps.amapapi.model.AMapLocationServer r3 = new com.autonavi.aps.amapapi.model.AMapLocationServer     // Catch:{ all -> 0x0330 }
            java.lang.String r6 = ""
            r3.<init>(r6)     // Catch:{ all -> 0x0330 }
            r3.setErrorCode(r4)     // Catch:{ all -> 0x0330 }
            java.lang.StringBuilder r4 = r1.a     // Catch:{ all -> 0x0330 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0330 }
            java.lang.String r7 = "parser data error:"
            r6.<init>(r7)     // Catch:{ all -> 0x0330 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0330 }
            r6.append(r2)     // Catch:{ all -> 0x0330 }
            java.lang.String r2 = "#0505"
            r6.append(r2)     // Catch:{ all -> 0x0330 }
            java.lang.String r2 = r6.toString()     // Catch:{ all -> 0x0330 }
            r4.append(r2)     // Catch:{ all -> 0x0330 }
            r2 = 2054(0x806, float:2.878E-42)
            r4 = 0
            com.loc.cx.a((java.lang.String) r4, (int) r2)     // Catch:{ all -> 0x0330 }
            java.lang.StringBuilder r2 = r1.a     // Catch:{ all -> 0x0330 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0330 }
            r3.setLocationDetail(r2)     // Catch:{ all -> 0x0330 }
            if (r5 == 0) goto L_0x031a
            r5.clear()
        L_0x031a:
            r2 = r3
        L_0x031b:
            java.lang.StringBuilder r3 = r1.a
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x032f
            java.lang.StringBuilder r3 = r1.a
            java.lang.StringBuilder r4 = r1.a
            int r4 = r4.length()
            r5 = 0
            r3.delete(r5, r4)
        L_0x032f:
            return r2
        L_0x0330:
            r0 = move-exception
            r2 = r0
            r6 = r5
        L_0x0333:
            if (r6 == 0) goto L_0x0338
            r6.clear()
        L_0x0338:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cp.a(com.autonavi.aps.amapapi.model.AMapLocationServer, byte[]):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|(1:4)|5|(1:7)|8|9|(1:13)|14|(1:16)|19|(1:21)|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ae, code lost:
        r7 = r5.a;
        r7.append("json exception error:");
        r7.append(r6.getMessage());
        r7.append(r1);
        r7.append("#0703");
        com.loc.cs.a(r6, "parser", "paseAuthFailurJson");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0054 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0095 A[Catch:{ Throwable -> 0x00ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.autonavi.aps.amapapi.model.AMapLocationServer a(java.lang.String r6, android.content.Context r7, com.loc.bo r8) {
        /*
            r5 = this;
            com.autonavi.aps.amapapi.model.AMapLocationServer r0 = new com.autonavi.aps.amapapi.model.AMapLocationServer
            java.lang.String r1 = ""
            r0.<init>(r1)
            r1 = 7
            r0.setErrorCode(r1)
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            r2 = 0
            java.lang.String r3 = "#SHA1AndPackage#"
            r1.append(r3)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = com.loc.k.e(r7)     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7 = r8.b     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r3 = "gsid"
            java.lang.Object r7 = r7.get(r3)     // Catch:{ Throwable -> 0x0054 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ Throwable -> 0x0054 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Throwable -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x0054 }
            if (r3 != 0) goto L_0x003b
            java.lang.String r3 = "#gsid#"
            r1.append(r3)     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
        L_0x003b:
            java.lang.String r7 = r8.c     // Catch:{ Throwable -> 0x0054 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x0054 }
            if (r3 != 0) goto L_0x0054
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r4 = "#csid#"
            r3.<init>(r4)     // Catch:{ Throwable -> 0x0054 }
            r3.append(r7)     // Catch:{ Throwable -> 0x0054 }
            java.lang.String r7 = r3.toString()     // Catch:{ Throwable -> 0x0054 }
            r1.append(r7)     // Catch:{ Throwable -> 0x0054 }
        L_0x0054:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Throwable -> 0x00ad }
            r7.<init>(r6)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r3 = "status"
            boolean r3 = r7.has(r3)     // Catch:{ Throwable -> 0x00ad }
            if (r3 == 0) goto L_0x0069
            java.lang.String r3 = "info"
            boolean r3 = r7.has(r3)     // Catch:{ Throwable -> 0x00ad }
            if (r3 != 0) goto L_0x007b
        L_0x0069:
            java.lang.StringBuilder r3 = r5.a     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "json is error:"
            r3.append(r4)     // Catch:{ Throwable -> 0x00ad }
            r3.append(r6)     // Catch:{ Throwable -> 0x00ad }
            r3.append(r1)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r6 = "#0702"
            r3.append(r6)     // Catch:{ Throwable -> 0x00ad }
        L_0x007b:
            java.lang.String r6 = "status"
            java.lang.String r6 = r7.getString(r6)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r3 = "info"
            java.lang.String r3 = r7.getString(r3)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "infocode"
            java.lang.String r7 = r7.getString(r4)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "0"
            boolean r6 = r6.equals(r4)     // Catch:{ Throwable -> 0x00ad }
            if (r6 == 0) goto L_0x00cb
            java.lang.StringBuilder r6 = r5.a     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "auth fail:"
            r6.append(r4)     // Catch:{ Throwable -> 0x00ad }
            r6.append(r3)     // Catch:{ Throwable -> 0x00ad }
            r6.append(r1)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r4 = "#0701"
            r6.append(r4)     // Catch:{ Throwable -> 0x00ad }
            java.lang.String r6 = r8.d     // Catch:{ Throwable -> 0x00ad }
            com.loc.cx.a((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r3)     // Catch:{ Throwable -> 0x00ad }
            goto L_0x00cb
        L_0x00ad:
            r6 = move-exception
            java.lang.StringBuilder r7 = r5.a
            java.lang.String r8 = "json exception error:"
            r7.append(r8)
            java.lang.String r8 = r6.getMessage()
            r7.append(r8)
            r7.append(r1)
            java.lang.String r8 = "#0703"
            r7.append(r8)
            java.lang.String r7 = "parser"
            java.lang.String r8 = "paseAuthFailurJson"
            com.loc.cs.a(r6, r7, r8)
        L_0x00cb:
            java.lang.StringBuilder r6 = r5.a
            java.lang.String r6 = r6.toString()
            r0.setLocationDetail(r6)
            java.lang.StringBuilder r6 = r5.a
            int r6 = r6.length()
            if (r6 <= 0) goto L_0x00e7
            java.lang.StringBuilder r6 = r5.a
            java.lang.StringBuilder r7 = r5.a
            int r7 = r7.length()
            r6.delete(r2, r7)
        L_0x00e7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.cp.a(java.lang.String, android.content.Context, com.loc.bo):com.autonavi.aps.amapapi.model.AMapLocationServer");
    }
}
