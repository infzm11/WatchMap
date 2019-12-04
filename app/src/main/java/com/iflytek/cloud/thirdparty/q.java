package com.iflytek.cloud.thirdparty;

public class q {
    private String a = "";
    private String b = "";
    private int c = 1;
    private int d = 1;
    private int e = -1;
    private af f;

    public q(af afVar) {
        this.f = afVar;
    }

    public void a(int i) {
        this.e = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e5 A[Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010a }
            r0.<init>(r5)     // Catch:{ JSONException -> 0x010a }
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010a }
            r5.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = "sid"
            java.lang.String r2 = ""
            java.lang.String r1 = r0.optString(r1, r2)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "mic_type"
            int r3 = r4.e     // Catch:{ JSONException -> 0x010a }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "sdk_ver"
            java.lang.String r3 = com.iflytek.aiui.Version.getVersion()     // Catch:{ JSONException -> 0x010a }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "ver_type"
            java.lang.String r3 = com.iflytek.aiui.Version.getVersionType()     // Catch:{ JSONException -> 0x010a }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "dev_lang"
            java.lang.String r3 = "java"
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "os"
            java.lang.String r3 = "android"
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x010a }
            r2.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = "sid"
            r2.put(r3, r1)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = "sess"
            r5.put(r3, r2)     // Catch:{ JSONException -> 0x010a }
            com.iflytek.cloud.thirdparty.af r2 = r4.f     // Catch:{ JSONException -> 0x010a }
            if (r2 == 0) goto L_0x005e
            java.lang.String r2 = "interact_mode"
            com.iflytek.cloud.thirdparty.af r3 = r4.f     // Catch:{ JSONException -> 0x010a }
            java.lang.String r3 = r3.d()     // Catch:{ JSONException -> 0x010a }
            r0.put(r2, r3)     // Catch:{ JSONException -> 0x010a }
        L_0x005e:
            r2 = 1
            if (r6 != 0) goto L_0x0091
            java.lang.String r6 = r4.a     // Catch:{ JSONException -> 0x010a }
            boolean r6 = r6.equals(r1)     // Catch:{ JSONException -> 0x010a }
            if (r6 != 0) goto L_0x006e
            r4.a = r1     // Catch:{ JSONException -> 0x010a }
            r4.c = r2     // Catch:{ JSONException -> 0x010a }
            goto L_0x0073
        L_0x006e:
            int r6 = r4.c     // Catch:{ JSONException -> 0x010a }
            int r6 = r6 + r2
            r4.c = r6     // Catch:{ JSONException -> 0x010a }
        L_0x0073:
            java.lang.String r6 = "app"
            r5.put(r6, r0)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r6 = "tran_id"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010a }
            r1.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "app#"
            r1.append(r2)     // Catch:{ JSONException -> 0x010a }
            int r2 = r4.c     // Catch:{ JSONException -> 0x010a }
            r1.append(r2)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x010a }
        L_0x008d:
            r5.put(r6, r1)     // Catch:{ JSONException -> 0x010a }
            goto L_0x00c0
        L_0x0091:
            if (r2 != r6) goto L_0x00c0
            java.lang.String r6 = r4.b     // Catch:{ JSONException -> 0x010a }
            boolean r6 = r6.equals(r1)     // Catch:{ JSONException -> 0x010a }
            if (r6 != 0) goto L_0x00a0
            r4.b = r1     // Catch:{ JSONException -> 0x010a }
            r4.d = r2     // Catch:{ JSONException -> 0x010a }
            goto L_0x00a5
        L_0x00a0:
            int r6 = r4.d     // Catch:{ JSONException -> 0x010a }
            int r6 = r6 + r2
            r4.d = r6     // Catch:{ JSONException -> 0x010a }
        L_0x00a5:
            java.lang.String r6 = "sdk"
            r5.put(r6, r0)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r6 = "tran_id"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010a }
            r1.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r2 = "sdk#"
            r1.append(r2)     // Catch:{ JSONException -> 0x010a }
            int r2 = r4.d     // Catch:{ JSONException -> 0x010a }
            r1.append(r2)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = r1.toString()     // Catch:{ JSONException -> 0x010a }
            goto L_0x008d
        L_0x00c0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x010a }
            r6.<init>()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = "sid="
            r6.append(r1)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r1 = "sid"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ JSONException -> 0x010a }
            r6.append(r0)     // Catch:{ JSONException -> 0x010a }
            java.lang.String r6 = r6.toString()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r5 = r5.toString()     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            java.lang.String r0 = "utf-8"
            byte[] r5 = r5.getBytes(r0)     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            com.iflytek.cloud.thirdparty.af r0 = r4.f     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            if (r0 == 0) goto L_0x010e
            com.iflytek.cloud.thirdparty.af r0 = r4.f     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            com.iflytek.cloud.thirdparty.ah r0 = r0.e()     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            if (r0 == 0) goto L_0x010e
            int r1 = r5.length     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            r0.a(r6, r5, r1)     // Catch:{ n -> 0x00f7, UnsupportedEncodingException -> 0x00f2 }
            return
        L_0x00f2:
            r5 = move-exception
            r5.printStackTrace()     // Catch:{ JSONException -> 0x010a }
            return
        L_0x00f7:
            r5 = move-exception
            com.iflytek.cloud.thirdparty.af r6 = r4.f     // Catch:{ JSONException -> 0x010a }
            if (r6 == 0) goto L_0x010e
            com.iflytek.cloud.thirdparty.af r6 = r4.f     // Catch:{ JSONException -> 0x010a }
            int r0 = r5.a()     // Catch:{ JSONException -> 0x010a }
            java.lang.String r5 = r5.b()     // Catch:{ JSONException -> 0x010a }
            r6.a((int) r0, (java.lang.String) r5)     // Catch:{ JSONException -> 0x010a }
            return
        L_0x010a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x010e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.q.a(java.lang.String, int):void");
    }
}
