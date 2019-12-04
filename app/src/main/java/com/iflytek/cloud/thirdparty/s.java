package com.iflytek.cloud.thirdparty;

import android.content.Context;
import com.iflytek.aiui.AIUIMessage;
import com.iflytek.cloud.SpeechConstant;
import org.json.JSONException;
import org.json.JSONObject;

public class s extends r {
    public s(Context context, af afVar) {
        super(context, afVar);
    }

    private void a(int i, String str) {
        if (this.c != null) {
            this.c.a(i, str);
        }
    }

    private void a(byte[] bArr, byte[] bArr2, int i, int i2) throws n {
        if (this.c != null) {
            ah e = this.c.e();
            if (e != null) {
                e.a(bArr, bArr2, i, i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0190 A[Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.iflytek.aiui.AIUIMessage r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r9.params     // Catch:{ JSONException -> 0x01b8 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01b8 }
            if (r1 != 0) goto L_0x0015
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01b8 }
            java.lang.String r1 = r9.params     // Catch:{ JSONException -> 0x01b8 }
            r0.<init>(r1)     // Catch:{ JSONException -> 0x01b8 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01b8 }
        L_0x0015:
            java.lang.String r1 = "utf-8"
            byte[] r0 = r0.getBytes(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            byte[] r1 = r9.data     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r2 = 3
            int r3 = r9.arg1     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r2 != r3) goto L_0x00dd
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r3.<init>(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r2.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = "param"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = "appid"
            boolean r3 = r1.has(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r3 != 0) goto L_0x0053
            com.iflytek.cloud.thirdparty.af r3 = r8.c     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r3 != 0) goto L_0x0041
            java.lang.String r3 = ""
            goto L_0x0047
        L_0x0041:
            com.iflytek.cloud.thirdparty.af r3 = r8.c     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = r3.h()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0047:
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r4 != 0) goto L_0x0059
            java.lang.String r4 = "appid"
            r1.put(r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x0059
        L_0x0053:
            java.lang.String r3 = "appid"
            java.lang.String r3 = r1.optString(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0059:
            java.lang.String r4 = "uid"
            boolean r4 = r1.has(r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r4 != 0) goto L_0x0071
            java.lang.String r4 = com.iflytek.cloud.thirdparty.ac.c()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r5 != 0) goto L_0x0077
            java.lang.String r5 = "uid"
            r1.put(r5, r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x0077
        L_0x0071:
            java.lang.String r4 = "uid"
            java.lang.String r4 = r1.optString(r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0077:
            java.lang.String r5 = "id_name"
            boolean r5 = r1.has(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r5 == 0) goto L_0x00b2
            java.lang.String r5 = "id_name"
            java.lang.String r5 = r1.getString(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r6 = "id_value"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r7 = "appid"
            boolean r7 = r7.equals(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r7 == 0) goto L_0x009f
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r5 == 0) goto L_0x00b2
            java.lang.String r5 = "id_value"
            r1.put(r5, r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x00b2
        L_0x009f:
            java.lang.String r7 = "uid"
            boolean r5 = r7.equals(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r5 == 0) goto L_0x00b2
            boolean r5 = android.text.TextUtils.isEmpty(r6)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r5 == 0) goto L_0x00b2
            java.lang.String r5 = "id_value"
            r1.put(r5, r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x00b2:
            java.lang.String r1 = "csid"
            java.lang.String r5 = "atn"
            java.lang.String r3 = com.iflytek.cloud.thirdparty.al.a((java.lang.String) r3, (java.lang.String) r5, (java.lang.String) r4)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r2.put(r1, r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            byte[] r2 = r1.getBytes()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = "SyncDataModule"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r5 = "schema data:"
            r4.append(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r4.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x00d8:
            com.iflytek.cloud.thirdparty.cb.a(r3, r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x018d
        L_0x00dd:
            r2 = 5
            int r3 = r9.arg1     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r2 != r3) goto L_0x018c
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r3.<init>(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r2.<init>(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = "iat_user_data"
            boolean r1 = r2.has(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r1 == 0) goto L_0x0105
            java.lang.String r1 = "iat_user_data"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = "audioparams"
            java.lang.String r4 = "rec_user_data"
            java.lang.String r1 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            com.iflytek.cloud.thirdparty.ac.b(r3, r4, r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0105:
            java.lang.String r1 = "nlp_user_data"
            boolean r1 = r2.has(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r1 == 0) goto L_0x018b
            java.lang.String r1 = "nlp_user_data"
            org.json.JSONObject r1 = r2.getJSONObject(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r2 = "appid"
            boolean r2 = r1.has(r2)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r2 != 0) goto L_0x0134
            com.iflytek.cloud.thirdparty.af r2 = r8.c     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r2 != 0) goto L_0x0122
            java.lang.String r2 = ""
            goto L_0x0128
        L_0x0122:
            com.iflytek.cloud.thirdparty.af r2 = r8.c     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r2 = r2.h()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0128:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r3 != 0) goto L_0x013a
            java.lang.String r3 = "appid"
            r1.put(r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x013a
        L_0x0134:
            java.lang.String r2 = "appid"
            java.lang.String r2 = r1.optString(r2)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x013a:
            java.lang.String r3 = "uid"
            boolean r3 = r1.has(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r3 != 0) goto L_0x014c
            java.lang.String r3 = com.iflytek.cloud.thirdparty.ac.c()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r4 = "uid"
        L_0x0148:
            r1.put(r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x015f
        L_0x014c:
            java.lang.String r3 = "uid"
            java.lang.String r3 = r1.getString(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            if (r4 == 0) goto L_0x015f
            java.lang.String r3 = com.iflytek.cloud.thirdparty.ac.c()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r4 = "uid"
            goto L_0x0148
        L_0x015f:
            java.lang.String r4 = "csid"
            java.lang.String r5 = "atn"
            java.lang.String r2 = com.iflytek.cloud.thirdparty.al.a((java.lang.String) r2, (java.lang.String) r5, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r1.put(r4, r2)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r2 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            byte[] r2 = r2.getBytes()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r3 = "SyncDataModule"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r4.<init>()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r5 = "nlp_user_data:"
            r4.append(r5)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = r1.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r4.append(r1)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            java.lang.String r1 = r4.toString()     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            goto L_0x00d8
        L_0x018b:
            return
        L_0x018c:
            r2 = r1
        L_0x018d:
            r1 = 0
            if (r2 == 0) goto L_0x0191
            int r1 = r2.length     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
        L_0x0191:
            int r9 = r9.arg1     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            r8.a(r0, r2, r1, r9)     // Catch:{ UnsupportedEncodingException -> 0x01b3, n -> 0x01a3, JSONException -> 0x0197 }
            return
        L_0x0197:
            r9 = move-exception
            r9.printStackTrace()
            r9 = 10107(0x277b, float:1.4163E-41)
            java.lang.String r0 = "sync data error, invalid data json."
            r8.a(r9, r0)
            return
        L_0x01a3:
            r9 = move-exception
            r9.printStackTrace()
            int r0 = r9.a()
            java.lang.String r9 = r9.b()
            r8.a(r0, r9)
            return
        L_0x01b3:
            r9 = move-exception
            r9.printStackTrace()
            return
        L_0x01b8:
            r9 = move-exception
            r9.printStackTrace()
            r9 = 10106(0x277a, float:1.4162E-41)
            java.lang.String r0 = "sync data: params invalid json format."
            r8.a(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.s.a(com.iflytek.aiui.AIUIMessage):void");
    }

    public void b(AIUIMessage aIUIMessage) {
        try {
            JSONObject jSONObject = new JSONObject(aIUIMessage.params);
            if (3 != aIUIMessage.arg1) {
                return;
            }
            if (!jSONObject.has(SpeechConstant.IST_SESSION_ID)) {
                cb.c("SyncDataModule", "query params does not have sid.");
                return;
            }
            String string = jSONObject.getString(SpeechConstant.IST_SESSION_ID);
            jSONObject.put("query_str", "csid=" + string);
            cb.a("SyncDataModule", jSONObject.toString());
            a(jSONObject.toString().getBytes(), new byte[1], 1, 4);
        } catch (JSONException e) {
            e.printStackTrace();
            a(10106, "query sync: params invalid json format.");
        } catch (n e2) {
            e2.printStackTrace();
            a(e2.a(), e2.b());
        }
    }
}
