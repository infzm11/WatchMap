package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: MapParser */
public final class lg {
    private StringBuilder a = new StringBuilder();

    public final kx a(String str, Context context, kl klVar) {
        kx kxVar = new kx("");
        kxVar.setErrorCode(7);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                StringBuilder sb = this.a;
                sb.append("json is error " + str);
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            if (string.equals("0")) {
                StringBuilder sb2 = this.a;
                sb2.append("auth fail:" + string2);
            }
        } catch (Throwable th) {
            StringBuilder sb3 = this.a;
            sb3.append("json exception error:" + th.getMessage());
            lr.a(th, "parser", "paseAuthFailurJson");
        }
        try {
            StringBuilder sb4 = this.a;
            sb4.append("#SHA1AndPackage#");
            sb4.append(id.e(context));
            String str2 = (String) klVar.b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                StringBuilder sb5 = this.a;
                sb5.append(" #gsid#");
                sb5.append(str2);
            }
            String str3 = klVar.c;
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb6 = this.a;
                sb6.append(" #csid#" + str3);
            }
        } catch (Throwable unused) {
        }
        kxVar.setLocationDetail(this.a.toString());
        if (this.a.length() > 0) {
            this.a.delete(0, this.a.length());
        }
        return kxVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(50:17|18|19|20|21|(4:22|23|24|25)|28|29|(4:30|31|32|33)|36|37|(4:38|39|40|41)|44|45|46|47|48|49|52|53|54|55|56|57|(4:58|59|60|61)|64|65|66|67|68|69|(4:70|71|72|73)|76|77|78|79|80|81|(1:83)|84|(1:90)|91|(1:93)|94|(1:96)|97|(3:99|(1:101)|102)|103|(1:109)(1:107)|108) */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02a6, code lost:
        if (r15 != null) goto L_0x02a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02a8, code lost:
        r15.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x02ac, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x02e0, code lost:
        if (r15 != null) goto L_0x02a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x02e9, code lost:
        if (r14.a.length() <= 0) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x02eb, code lost:
        r14.a.delete(0, r14.a.length());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x02f6, code lost:
        return r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x0262 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:122:0x0277 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x00ae */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x00dc */
    /* JADX WARNING: Missing exception handler attribute for start block: B:44:0x00f3 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x010d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:56:0x0122 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x0139 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x014e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:76:0x0165 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:80:0x017a */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x020e A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027d A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x028c A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02fa  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0185 A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01af A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01bd A[Catch:{ Throwable -> 0x02ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01cb A[Catch:{ Throwable -> 0x02ac }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.amap.api.col.n3.kx a(byte[] r15) {
        /*
            r14 = this;
            r0 = 0
            r1 = 5
            r2 = 0
            com.amap.api.col.n3.kx r3 = new com.amap.api.col.n3.kx     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.String r4 = ""
            r3.<init>(r4)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            if (r15 != 0) goto L_0x002b
            r3.setErrorCode(r1)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.StringBuilder r15 = r14.a     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.String r4 = "byte[] is null"
            r15.append(r4)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.StringBuilder r15 = r14.a     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.String r15 = r15.toString()     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            r3.setLocationDetail(r15)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.StringBuilder r15 = r14.a     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            java.lang.StringBuilder r4 = r14.a     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            r15.delete(r0, r4)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            return r3
        L_0x002b:
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.wrap(r15)     // Catch:{ Throwable -> 0x02b2, all -> 0x02ae }
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            if (r2 != 0) goto L_0x0049
            short r2 = r15.getShort()     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x02ac }
            r3.b(r2)     // Catch:{ Throwable -> 0x02ac }
            r15.clear()     // Catch:{ Throwable -> 0x02ac }
            if (r15 == 0) goto L_0x0048
            r15.clear()
        L_0x0048:
            return r3
        L_0x0049:
            int r2 = r15.getInt()     // Catch:{ Throwable -> 0x02ac }
            double r4 = (double) r2     // Catch:{ Throwable -> 0x02ac }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r4 = r4 / r6
            double r4 = com.amap.api.col.n3.lu.a((double) r4)     // Catch:{ Throwable -> 0x02ac }
            r3.setLongitude(r4)     // Catch:{ Throwable -> 0x02ac }
            int r2 = r15.getInt()     // Catch:{ Throwable -> 0x02ac }
            double r4 = (double) r2     // Catch:{ Throwable -> 0x02ac }
            double r4 = r4 / r6
            double r4 = com.amap.api.col.n3.lu.a((double) r4)     // Catch:{ Throwable -> 0x02ac }
            r3.setLatitude(r4)     // Catch:{ Throwable -> 0x02ac }
            short r2 = r15.getShort()     // Catch:{ Throwable -> 0x02ac }
            float r2 = (float) r2     // Catch:{ Throwable -> 0x02ac }
            r3.setAccuracy(r2)     // Catch:{ Throwable -> 0x02ac }
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x02ac }
            r3.c(r2)     // Catch:{ Throwable -> 0x02ac }
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Throwable -> 0x02ac }
            r3.d(r2)     // Catch:{ Throwable -> 0x02ac }
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r4 = 1
            if (r2 != r4) goto L_0x022d
            java.lang.String r2 = ""
            java.lang.String r5 = ""
            java.lang.String r6 = ""
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            byte r10 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte[] r10 = new byte[r10]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r10)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r11 = new java.lang.String     // Catch:{ Throwable -> 0x00ae }
            java.lang.String r12 = "UTF-8"
            r11.<init>(r10, r12)     // Catch:{ Throwable -> 0x00ae }
            r3.setCountry(r11)     // Catch:{ Throwable -> 0x00ae }
        L_0x00ae:
            byte r10 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte[] r10 = new byte[r10]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r10)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r11 = new java.lang.String     // Catch:{ Throwable -> 0x00c4 }
            java.lang.String r12 = "UTF-8"
            r11.<init>(r10, r12)     // Catch:{ Throwable -> 0x00c4 }
            r3.setProvince(r11)     // Catch:{ Throwable -> 0x00c5 }
            goto L_0x00c5
        L_0x00c4:
            r11 = r2
        L_0x00c5:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r10 = new java.lang.String     // Catch:{ Throwable -> 0x00db }
            java.lang.String r12 = "UTF-8"
            r10.<init>(r2, r12)     // Catch:{ Throwable -> 0x00db }
            r3.setCity(r10)     // Catch:{ Throwable -> 0x00dc }
            goto L_0x00dc
        L_0x00db:
            r10 = r5
        L_0x00dc:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x00f2 }
            java.lang.String r12 = "UTF-8"
            r5.<init>(r2, r12)     // Catch:{ Throwable -> 0x00f2 }
            r3.setDistrict(r5)     // Catch:{ Throwable -> 0x00f3 }
            goto L_0x00f3
        L_0x00f2:
            r5 = r6
        L_0x00f3:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r6 = new java.lang.String     // Catch:{ Throwable -> 0x010c }
            java.lang.String r12 = "UTF-8"
            r6.<init>(r2, r12)     // Catch:{ Throwable -> 0x010c }
            r3.setStreet(r6)     // Catch:{ Throwable -> 0x010d }
            r3.setRoad(r6)     // Catch:{ Throwable -> 0x010d }
            goto L_0x010d
        L_0x010c:
            r6 = r7
        L_0x010d:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r7 = new java.lang.String     // Catch:{ Throwable -> 0x0122 }
            java.lang.String r12 = "UTF-8"
            r7.<init>(r2, r12)     // Catch:{ Throwable -> 0x0122 }
            r3.setNumber(r7)     // Catch:{ Throwable -> 0x0122 }
        L_0x0122:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r7 = new java.lang.String     // Catch:{ Throwable -> 0x0138 }
            java.lang.String r12 = "UTF-8"
            r7.<init>(r2, r12)     // Catch:{ Throwable -> 0x0138 }
            r3.setPoiName(r7)     // Catch:{ Throwable -> 0x0139 }
            goto L_0x0139
        L_0x0138:
            r7 = r8
        L_0x0139:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x014e }
            java.lang.String r12 = "UTF-8"
            r8.<init>(r2, r12)     // Catch:{ Throwable -> 0x014e }
            r3.setAoiName(r8)     // Catch:{ Throwable -> 0x014e }
        L_0x014e:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r8 = new java.lang.String     // Catch:{ Throwable -> 0x0164 }
            java.lang.String r12 = "UTF-8"
            r8.<init>(r2, r12)     // Catch:{ Throwable -> 0x0164 }
            r3.setAdCode(r8)     // Catch:{ Throwable -> 0x0165 }
            goto L_0x0165
        L_0x0164:
            r8 = r9
        L_0x0165:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r9 = new java.lang.String     // Catch:{ Throwable -> 0x017a }
            java.lang.String r12 = "UTF-8"
            r9.<init>(r2, r12)     // Catch:{ Throwable -> 0x017a }
            r3.setCityCode(r9)     // Catch:{ Throwable -> 0x017a }
        L_0x017a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x02ac }
            r2.<init>()     // Catch:{ Throwable -> 0x02ac }
            boolean r9 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Throwable -> 0x02ac }
            if (r9 != 0) goto L_0x018d
            r2.append(r11)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r9 = " "
            r2.append(r9)     // Catch:{ Throwable -> 0x02ac }
        L_0x018d:
            boolean r9 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Throwable -> 0x02ac }
            if (r9 != 0) goto L_0x01a9
            java.lang.String r9 = "市"
            boolean r9 = r11.contains(r9)     // Catch:{ Throwable -> 0x02ac }
            if (r9 == 0) goto L_0x01a1
            boolean r9 = r11.equals(r10)     // Catch:{ Throwable -> 0x02ac }
            if (r9 != 0) goto L_0x01a9
        L_0x01a1:
            r2.append(r10)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r9 = " "
            r2.append(r9)     // Catch:{ Throwable -> 0x02ac }
        L_0x01a9:
            boolean r9 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x02ac }
            if (r9 != 0) goto L_0x01b7
            r2.append(r5)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = " "
            r2.append(r5)     // Catch:{ Throwable -> 0x02ac }
        L_0x01b7:
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x02ac }
            if (r5 != 0) goto L_0x01c5
            r2.append(r6)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = " "
            r2.append(r5)     // Catch:{ Throwable -> 0x02ac }
        L_0x01c5:
            boolean r5 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Throwable -> 0x02ac }
            if (r5 != 0) goto L_0x01de
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Throwable -> 0x02ac }
            if (r5 != 0) goto L_0x01d6
            java.lang.String r5 = "靠近"
            r2.append(r5)     // Catch:{ Throwable -> 0x02ac }
        L_0x01d6:
            r2.append(r7)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = " "
            r2.append(r5)     // Catch:{ Throwable -> 0x02ac }
        L_0x01de:
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ Throwable -> 0x02ac }
            r5.<init>()     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r6 = "citycode"
            java.lang.String r7 = r3.getCityCode()     // Catch:{ Throwable -> 0x02ac }
            r5.putString(r6, r7)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r6 = "desc"
            java.lang.String r7 = r2.toString()     // Catch:{ Throwable -> 0x02ac }
            r5.putString(r6, r7)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r6 = "adcode"
            java.lang.String r7 = r3.getAdCode()     // Catch:{ Throwable -> 0x02ac }
            r5.putString(r6, r7)     // Catch:{ Throwable -> 0x02ac }
            r3.setExtras(r5)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = r2.toString()     // Catch:{ Throwable -> 0x02ac }
            r3.e(r5)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = r3.getAdCode()     // Catch:{ Throwable -> 0x02ac }
            if (r5 == 0) goto L_0x0228
            java.lang.String r5 = r5.trim()     // Catch:{ Throwable -> 0x02ac }
            int r5 = r5.length()     // Catch:{ Throwable -> 0x02ac }
            if (r5 <= 0) goto L_0x0228
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = " "
            java.lang.String r6 = ""
            java.lang.String r2 = r2.replace(r5, r6)     // Catch:{ Throwable -> 0x02ac }
        L_0x0224:
            r3.setAddress(r2)     // Catch:{ Throwable -> 0x02ac }
            goto L_0x022d
        L_0x0228:
            java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x02ac }
            goto L_0x0224
        L_0x022d:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            if (r2 != r4) goto L_0x0247
            r15.getInt()     // Catch:{ Throwable -> 0x02ac }
            r15.getInt()     // Catch:{ Throwable -> 0x02ac }
            r15.getShort()     // Catch:{ Throwable -> 0x02ac }
        L_0x0247:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            if (r2 != r4) goto L_0x0277
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x0262 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r2, r6)     // Catch:{ Throwable -> 0x0262 }
            r3.setBuildingId(r5)     // Catch:{ Throwable -> 0x0262 }
        L_0x0262:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r5 = new java.lang.String     // Catch:{ Throwable -> 0x0277 }
            java.lang.String r6 = "UTF-8"
            r5.<init>(r2, r6)     // Catch:{ Throwable -> 0x0277 }
            r3.setFloor(r5)     // Catch:{ Throwable -> 0x0277 }
        L_0x0277:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            if (r2 != r4) goto L_0x0286
            r15.get()     // Catch:{ Throwable -> 0x02ac }
            r15.getInt()     // Catch:{ Throwable -> 0x02ac }
            r15.get()     // Catch:{ Throwable -> 0x02ac }
        L_0x0286:
            byte r2 = r15.get()     // Catch:{ Throwable -> 0x02ac }
            if (r2 != r4) goto L_0x0293
            long r4 = r15.getLong()     // Catch:{ Throwable -> 0x02ac }
            r3.setTime(r4)     // Catch:{ Throwable -> 0x02ac }
        L_0x0293:
            short r2 = r15.getShort()     // Catch:{ Throwable -> 0x02ac }
            byte[] r2 = new byte[r2]     // Catch:{ Throwable -> 0x02ac }
            r15.get(r2)     // Catch:{ Throwable -> 0x02ac }
            java.lang.String r1 = new java.lang.String     // Catch:{ Throwable -> 0x02a6 }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r2, r4)     // Catch:{ Throwable -> 0x02a6 }
            r3.a(r1)     // Catch:{ Throwable -> 0x02a6 }
        L_0x02a6:
            if (r15 == 0) goto L_0x02e3
        L_0x02a8:
            r15.clear()
            goto L_0x02e3
        L_0x02ac:
            r2 = move-exception
            goto L_0x02b6
        L_0x02ae:
            r15 = move-exception
            r0 = r15
            r15 = r2
            goto L_0x02f8
        L_0x02b2:
            r15 = move-exception
            r13 = r2
            r2 = r15
            r15 = r13
        L_0x02b6:
            com.amap.api.col.n3.kx r3 = new com.amap.api.col.n3.kx     // Catch:{ all -> 0x02f7 }
            java.lang.String r4 = ""
            r3.<init>(r4)     // Catch:{ all -> 0x02f7 }
            r3.setErrorCode(r1)     // Catch:{ all -> 0x02f7 }
            java.lang.StringBuilder r1 = r14.a     // Catch:{ all -> 0x02f7 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f7 }
            java.lang.String r5 = "parser data error:"
            r4.<init>(r5)     // Catch:{ all -> 0x02f7 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x02f7 }
            r4.append(r2)     // Catch:{ all -> 0x02f7 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x02f7 }
            r1.append(r2)     // Catch:{ all -> 0x02f7 }
            java.lang.StringBuilder r1 = r14.a     // Catch:{ all -> 0x02f7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02f7 }
            r3.setLocationDetail(r1)     // Catch:{ all -> 0x02f7 }
            if (r15 == 0) goto L_0x02e3
            goto L_0x02a8
        L_0x02e3:
            java.lang.StringBuilder r15 = r14.a
            int r15 = r15.length()
            if (r15 <= 0) goto L_0x02f6
            java.lang.StringBuilder r15 = r14.a
            java.lang.StringBuilder r1 = r14.a
            int r1 = r1.length()
            r15.delete(r0, r1)
        L_0x02f6:
            return r3
        L_0x02f7:
            r0 = move-exception
        L_0x02f8:
            if (r15 == 0) goto L_0x02fd
            r15.clear()
        L_0x02fd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.lg.a(byte[]):com.amap.api.col.n3.kx");
    }
}
