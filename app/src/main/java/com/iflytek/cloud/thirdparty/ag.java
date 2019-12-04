package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUIMessage;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

public class ag {
    private boolean a = false;
    private String b = "cloud";
    private af c;
    private String d;
    private Queue<String> e = new ConcurrentLinkedQueue();
    private ae f;
    private aj g;

    public ag(af afVar) {
        this.c = afVar;
        this.f = ae.a();
        this.g = new aj();
    }

    private void a(Message message, boolean z) {
        if (this.c == null) {
            return;
        }
        if (z) {
            this.c.sendMessageAtFrontOfQueue(message);
        } else {
            this.c.sendMessage(message);
        }
    }

    private void a(String str) {
        if (!str.equals(this.d)) {
            this.d = str;
            int size = this.e.size();
            if (size > 5) {
                for (int i = 0; i < size - 3; i++) {
                    this.f.f(this.e.poll());
                }
            }
        }
    }

    private void a(String str, String str2, int i, String str3) throws UnsupportedEncodingException {
        this.g.b();
        this.g.a(str, ".txt", true);
        aj ajVar = this.g;
        ajVar.a(("sid=" + str2 + "\n").getBytes("utf-8"), true);
        aj ajVar2 = this.g;
        ajVar2.a(("error=" + i + "\n").getBytes("utf-8"), true);
        aj ajVar3 = this.g;
        ajVar3.a(("des=" + str3).getBytes("utf-8"), true);
        this.g.a("\n\n".getBytes("utf-8"), true);
        this.g.c();
    }

    private void a(String str, String str2, long j, long j2, long j3, JSONObject jSONObject, String str3, JSONObject jSONObject2) throws JSONException, UnsupportedEncodingException {
        aj ajVar;
        StringBuilder sb;
        String str4;
        this.g.b();
        this.g.a(str, ".txt", true);
        aj ajVar2 = this.g;
        ajVar2.a(("sid=" + str2 + "\n").getBytes("utf-8"), true);
        String jSONObject3 = jSONObject2.toString();
        if ("nlp".equals(str3)) {
            b(str, str2, j, j2, j3, jSONObject, str3, jSONObject2);
            aj ajVar3 = this.g;
            ajVar3.a(("bos_nlp=" + j2 + "\n").getBytes("utf-8"), true);
            ajVar = this.g;
            sb = new StringBuilder();
            str4 = "eos_nlp=";
        } else if ("iat".equals(str3)) {
            aj ajVar4 = this.g;
            ajVar4.a(("bos_iat=" + j2 + "\n").getBytes("utf-8"), true);
            ajVar = this.g;
            sb = new StringBuilder();
            str4 = "eos_iat=";
        } else if ("asr".equals(str3)) {
            aj ajVar5 = this.g;
            ajVar5.a(("bos_asr=" + j2 + "\n").getBytes("utf-8"), true);
            ajVar = this.g;
            sb = new StringBuilder();
            str4 = "eos_asr=";
        } else {
            if ("tpp".equals(str3)) {
                b(str, str2, j, j2, j3, jSONObject, str3, jSONObject2);
            }
            this.g.a(jSONObject3.getBytes("utf-8"), true);
            this.g.a("\n\n".getBytes("utf-8"), true);
            this.g.c();
            cb.a("ResultScheduler", jSONObject3);
            cb.a("ResultScheduler", "<---------------------------------------------->");
        }
        sb.append(str4);
        sb.append(j3);
        sb.append("\n");
        ajVar.a(sb.toString().getBytes("utf-8"), true);
        this.g.a(jSONObject3.getBytes("utf-8"), true);
        this.g.a("\n\n".getBytes("utf-8"), true);
        this.g.c();
        cb.a("ResultScheduler", jSONObject3);
        cb.a("ResultScheduler", "<---------------------------------------------->");
    }

    private void a(String str, String str2, String str3, String str4, Map<String, byte[]> map, long j, long j2, long j3) {
        Bundle a2 = am.a(map);
        a2.putString(SpeechConstant.IST_SESSION_ID, str);
        a2.putString("stream_id", str2);
        a2.putLong("p_rslt", j);
        a2.putLong("bos_rslt", j2);
        a2.putLong("eos_rslt", j3);
        if (!TextUtils.isEmpty(str3)) {
            a2.putString(AIUIConstant.KEY_TAG, str3);
        }
        ad c2 = this.f.c(str2, "iat");
        if (c2 != null) {
            Long a3 = this.f.a(str2);
            Long b2 = this.f.b(str2);
            long e2 = c2.e();
            Long valueOf = Long.valueOf(a3 == null ? 0 : a3.longValue());
            long j4 = -1;
            Long valueOf2 = Long.valueOf(b2 == null ? -1 : b2.longValue());
            Long valueOf3 = Long.valueOf(e2 - valueOf.longValue());
            if (-1 != valueOf2.longValue()) {
                j4 = e2 - valueOf2.longValue();
            }
            Long valueOf4 = Long.valueOf(j4);
            a2.putLong("p_bos", valueOf.longValue());
            a2.putLong("p_eos", valueOf2.longValue());
            a2.putLong("bos_iat", valueOf3.longValue());
            a2.putLong("eos_iat", valueOf4.longValue());
        }
        Message obtain = Message.obtain();
        obtain.what = 5;
        AIUIEvent aIUIEvent = new AIUIEvent(1, 0, 0, str4, a2);
        obtain.obj = aIUIEvent;
        a(obtain, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r3) {
        /*
            r2 = this;
            r0 = 4
            java.lang.String r1 = "intent"
            boolean r1 = r3.has(r1)     // Catch:{ JSONException -> 0x0016 }
            if (r1 == 0) goto L_0x001a
            java.lang.String r1 = "intent"
            org.json.JSONObject r3 = r3.getJSONObject(r1)     // Catch:{ JSONException -> 0x0016 }
            java.lang.String r1 = "rc"
            int r3 = r3.getInt(r1)     // Catch:{ JSONException -> 0x0016 }
            goto L_0x001b
        L_0x0016:
            r3 = move-exception
            r3.printStackTrace()
        L_0x001a:
            r3 = r0
        L_0x001b:
            if (r3 != 0) goto L_0x0027
            android.os.Message r3 = android.os.Message.obtain()
            r3.what = r0
            r0 = 1
            r2.a(r3, r0)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ag.a(org.json.JSONObject):void");
    }

    private void b(String str, String str2, long j, long j2, long j3, JSONObject jSONObject, String str3, JSONObject jSONObject2) {
        int i;
        String str4 = str;
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        String str5 = str3;
        JSONObject jSONObject3 = jSONObject2;
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("stream_id", str4);
            jSONObject4.put(SpeechConstant.IST_SESSION_ID, str2);
            jSONObject4.put("sub", str5);
            jSONObject4.put("confidence", (double) this.f.c(str4));
            if ("nlp".equals(str5)) {
                jSONObject4.put("p_nlp_sdk", j4);
                jSONObject4.put("bos_nlp", j5);
                jSONObject4.put("eos_nlp", j6);
                ad c2 = this.f.c(str4, "iat");
                if (c2 != null) {
                    Long a2 = this.f.a(str4);
                    Long b2 = this.f.b(str4);
                    long e2 = c2.e();
                    Long valueOf = Long.valueOf(a2 == null ? 0 : a2.longValue());
                    long j7 = -1;
                    Long valueOf2 = Long.valueOf(b2 == null ? -1 : b2.longValue());
                    Long valueOf3 = Long.valueOf(e2 - valueOf.longValue());
                    if (-1 != valueOf2.longValue()) {
                        j7 = e2 - valueOf2.longValue();
                    }
                    Long valueOf4 = Long.valueOf(j7);
                    jSONObject4.put("p_bos", valueOf);
                    jSONObject4.put("p_eos", valueOf2);
                    jSONObject4.put("bos_iat", valueOf3);
                    jSONObject4.put("eos_iat", valueOf4);
                }
            } else if ("tpp".equals(str5)) {
                jSONObject4.put("p_tpp_sdk", j4);
                jSONObject4.put("bos_tpp", j5);
                jSONObject4.put("eos_tpp", j6);
            }
            jSONObject4.put(SpeechConstant.PARAMS, jSONObject);
            int i2 = -1;
            try {
                if (jSONObject3.has(AIUIConstant.WORK_MODE_INTENT)) {
                    JSONObject jSONObject5 = jSONObject3.getJSONObject(AIUIConstant.WORK_MODE_INTENT);
                    String optString = jSONObject5.optString("service", "");
                    i = jSONObject5.optInt("rc", -1);
                    try {
                        jSONObject4.put("service", optString);
                    } catch (JSONException e3) {
                        e = e3;
                    }
                    i2 = i;
                }
            } catch (JSONException e4) {
                e = e4;
                i = -1;
                e.printStackTrace();
                i2 = i;
                jSONObject4.put("rc", i2);
                Message obtain = Message.obtain();
                obtain.what = 2;
                AIUIMessage aIUIMessage = new AIUIMessage(12, 1, 0, jSONObject4.toString(), (byte[]) null);
                obtain.obj = aIUIMessage;
                a(obtain, false);
            }
            jSONObject4.put("rc", i2);
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            AIUIMessage aIUIMessage2 = new AIUIMessage(12, 1, 0, jSONObject4.toString(), (byte[]) null);
            obtain2.obj = aIUIMessage2;
            a(obtain2, false);
        } catch (JSONException e5) {
            e5.printStackTrace();
        }
    }

    public void a() {
        this.b = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r27, java.lang.String r28, java.util.Map<java.lang.String, byte[]> r29, java.lang.String r30, java.lang.String r31, long r32) throws org.json.JSONException, java.io.UnsupportedEncodingException {
        /*
            r26 = this;
            r12 = r26
            r13 = r28
            r14 = r30
            r15 = r31
            java.lang.String r0 = r12.d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0012
            r12.d = r15
        L_0x0012:
            java.util.Queue<java.lang.String> r0 = r12.e
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x001f
            java.util.Queue<java.lang.String> r0 = r12.e
            r0.add(r15)
        L_0x001f:
            r0 = 0
            r2 = -1
            com.iflytek.cloud.thirdparty.ae r4 = r12.f
            java.lang.Long r4 = r4.a(r15)
            com.iflytek.cloud.thirdparty.ae r5 = r12.f
            java.lang.Long r5 = r5.b(r15)
            if (r4 == 0) goto L_0x0037
            long r0 = r4.longValue()
            long r0 = r32 - r0
        L_0x0037:
            r16 = r0
            if (r5 == 0) goto L_0x0044
            long r0 = r5.longValue()
            long r0 = r32 - r0
            r18 = r0
            goto L_0x0046
        L_0x0044:
            r18 = r2
        L_0x0046:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r13)
            java.lang.String r1 = "data"
            org.json.JSONArray r0 = r0.getJSONArray(r1)
            r1 = 0
            org.json.JSONObject r0 = r0.getJSONObject(r1)
            java.lang.String r2 = "params"
            org.json.JSONObject r10 = r0.getJSONObject(r2)
            java.lang.String r2 = "content"
            org.json.JSONArray r0 = r0.getJSONArray(r2)
            org.json.JSONObject r11 = r0.getJSONObject(r1)
            java.lang.String r0 = "sub"
            java.lang.String r9 = r10.optString(r0)
            com.iflytek.cloud.thirdparty.ae r0 = r12.f
            java.lang.String r20 = r0.d(r15)
            com.iflytek.cloud.thirdparty.ae r0 = r12.f
            boolean r0 = r0.e(r15)
            r8 = 1
            if (r0 == 0) goto L_0x011c
            com.iflytek.cloud.thirdparty.ad r6 = new com.iflytek.cloud.thirdparty.ad
            r21 = 0
            r0 = r6
            r1 = r9
            r2 = r27
            r3 = r13
            r4 = r15
            r5 = r29
            r22 = r10
            r10 = r6
            r6 = r32
            r23 = r11
            r11 = r8
            r8 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r8)
            java.lang.String r0 = "nlp"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00e6
            com.iflytek.cloud.thirdparty.ae r0 = r12.f
            java.lang.String r1 = "asr"
            boolean r0 = r0.d(r15, r1)
            if (r0 != 0) goto L_0x00dd
            r10.a(r11)
            com.iflytek.cloud.thirdparty.ae r0 = r12.f
            r0.a(r15, r9, r10)
            r0 = r12
            r1 = r14
            r2 = r15
            r3 = r20
            r4 = r13
            r5 = r29
            r6 = r32
            r10 = r9
            r8 = r16
            r13 = r10
            r14 = r11
            r21 = r22
            r24 = r23
            r10 = r18
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, byte[]>) r5, (long) r6, (long) r8, (long) r10)
            java.lang.String r0 = "ResultScheduler"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "notify "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            goto L_0x00e2
        L_0x00dd:
            r21 = r22
            r24 = r23
            r13 = r9
        L_0x00e2:
            r14 = r30
            goto L_0x0144
        L_0x00e6:
            r13 = r9
            r14 = r11
            r21 = r22
            r24 = r23
            r10.a(r14)
            com.iflytek.cloud.thirdparty.ae r0 = r12.f
            r0.a(r15, r13, r10)
            r0 = r12
            r10 = r14
            r14 = r30
            r1 = r14
            r2 = r15
            r3 = r20
            r11 = r13
            r13 = r28
            r4 = r13
            r5 = r29
            r6 = r32
            r8 = r16
            r13 = r11
            r10 = r18
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.util.Map<java.lang.String, byte[]>) r5, (long) r6, (long) r8, (long) r10)
            java.lang.String r0 = "ResultScheduler"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "notify "
            r1.append(r2)
            r1.append(r13)
            goto L_0x013d
        L_0x011c:
            r13 = r9
            r21 = r10
            r24 = r11
            java.lang.String r0 = "ResultScheduler"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "no "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r2 = " in statistic list, ignore this "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = " result."
            r1.append(r2)
        L_0x013d:
            java.lang.String r1 = r1.toString()
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
        L_0x0144:
            r12.a((java.lang.String) r15)
            java.lang.String r0 = "ResultScheduler"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "sid="
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            java.lang.String r0 = "ResultScheduler"
            r1 = r27
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            java.lang.String r0 = "ResultScheduler"
            r10 = r13
            r1 = r28
            com.iflytek.cloud.thirdparty.cb.a(r0, r1)
            java.lang.String r0 = "cnt_id"
            r1 = r24
            boolean r0 = r1.has(r0)
            if (r0 == 0) goto L_0x01df
            java.lang.String r0 = "cnt_id"
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r1 = ""
            r2 = r29
            java.lang.Object r0 = r2.get(r0)
            byte[] r0 = (byte[]) r0
            if (r0 == 0) goto L_0x0190
            java.lang.String r1 = new java.lang.String
            java.lang.String r2 = "utf-8"
            r1.<init>(r0, r2)
            goto L_0x0197
        L_0x0190:
            java.lang.String r0 = "ResultScheduler"
            java.lang.String r2 = "content data is null."
            android.util.Log.e(r0, r2)
        L_0x0197:
            android.os.Message r0 = android.os.Message.obtain()
            r2 = 11
            r0.what = r2
            r2 = 1
            r12.a(r0, r2)
            org.json.JSONObject r11 = new org.json.JSONObject
            r11.<init>(r1)
            java.lang.String r0 = "nlp"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01bd
            r12.a((org.json.JSONObject) r11)
            java.lang.String r0 = "result"
            java.lang.String r1 = com.iflytek.cloud.thirdparty.al.a()
            com.iflytek.cloud.thirdparty.ao.a((java.lang.String) r0, (java.lang.String) r14, (java.lang.String) r1)
            goto L_0x01d1
        L_0x01bd:
            java.lang.String r0 = "iat"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01c6
            goto L_0x01d1
        L_0x01c6:
            java.lang.String r0 = "asr"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01d1
            r12.a((org.json.JSONObject) r11)
        L_0x01d1:
            r0 = r12
            r1 = r15
            r2 = r14
            r3 = r32
            r5 = r16
            r7 = r18
            r9 = r21
            r0.a((java.lang.String) r1, (java.lang.String) r2, (long) r3, (long) r5, (long) r7, (org.json.JSONObject) r9, (java.lang.String) r10, (org.json.JSONObject) r11)
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ag.a(java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, long):void");
    }

    public void b() {
        this.a = false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0069, code lost:
        r2.a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        a(r2.a(), r2.b(), r2.d(), "", r2.c(), r2.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x008d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f2 A[Catch:{ UnsupportedEncodingException -> 0x0103 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void errorCb(char[] r17, int r18, byte[] r19) {
        /*
            r16 = this;
            r9 = r16
            r10 = r18
            java.lang.String r11 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r1 = "utf-8"
            r2 = r19
            r11.<init>(r2, r1)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            android.os.Message r7 = android.os.Message.obtain()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r1 = 7
            r7.what = r1     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            com.iflytek.aiui.AIUIEvent r8 = new com.iflytek.aiui.AIUIEvent     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2 = 2
            r4 = 0
            r6 = 0
            r1 = r8
            r3 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r7.obj = r8     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            com.iflytek.cloud.thirdparty.ce r1 = new com.iflytek.cloud.thirdparty.ce     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r1.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r1.a((java.lang.String) r11)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r2 = "stmid"
            java.lang.String r3 = ""
            java.lang.String r12 = r1.b((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r2 = "sid"
            java.lang.String r3 = ""
            java.lang.String r13 = r1.b((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r1 = "mixed"
            java.lang.String r2 = r9.b     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            boolean r1 = r1.equals(r2)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2 = 10120(0x2788, float:1.4181E-41)
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x0097
            if (r2 != r10) goto L_0x0093
            com.iflytek.cloud.thirdparty.ae r1 = r9.f     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r2 = "asr"
            java.util.List r1 = r1.b(r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r1 == 0) goto L_0x00c7
            java.util.Iterator r1 = r1.iterator()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
        L_0x0057:
            boolean r2 = r1.hasNext()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r2 == 0) goto L_0x00c7
            java.lang.Object r2 = r1.next()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            com.iflytek.cloud.thirdparty.ad r2 = (com.iflytek.cloud.thirdparty.ad) r2     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            boolean r4 = r2.f()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r4 != 0) goto L_0x0057
            r2.a(r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r3 = r2.a()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r4 = r2.b()     // Catch:{ JSONException -> 0x008d }
            java.util.Map r5 = r2.d()     // Catch:{ JSONException -> 0x008d }
            java.lang.String r6 = ""
            java.lang.String r7 = r2.c()     // Catch:{ JSONException -> 0x008d }
            long r14 = r2.e()     // Catch:{ JSONException -> 0x008d }
            r1 = r9
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r14
            r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ JSONException -> 0x008d }
            goto L_0x00c7
        L_0x008d:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            goto L_0x00c7
        L_0x0093:
            r9.a(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            goto L_0x00c7
        L_0x0097:
            if (r2 != r10) goto L_0x0093
            java.lang.String r1 = "vad"
            java.lang.String r2 = "vad_enable"
            boolean r1 = com.iflytek.cloud.thirdparty.ac.a((java.lang.String) r1, (java.lang.String) r2, (boolean) r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r1 != 0) goto L_0x00a4
            goto L_0x0093
        L_0x00a4:
            com.iflytek.cloud.thirdparty.ae r1 = r9.f     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            float r1 = r1.c(r12)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2 = 1060320051(0x3f333333, float:0.7)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x00b2
            goto L_0x0093
        L_0x00b2:
            r2 = 0
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x00b8
            goto L_0x0093
        L_0x00b8:
            java.lang.String r1 = "ResultScheduler"
            java.lang.String r2 = "%s had low confidence, ignore 10120 error."
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r3[r4] = r12     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r2 = java.lang.String.format(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
        L_0x00c7:
            java.lang.String r1 = "ResultScheduler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r3 = "errorCode="
            r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2.append(r10)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r3 = ", "
            r2.append(r3)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r2.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r2 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            java.lang.String r1 = "ResultScheduler"
            java.lang.String r2 = "<---------------------------------------------->"
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            boolean r1 = android.text.TextUtils.isEmpty(r12)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r1 != 0) goto L_0x0108
            java.util.Queue<java.lang.String> r1 = r9.e     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            boolean r1 = r1.contains(r12)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            if (r1 != 0) goto L_0x00ff
            java.util.Queue<java.lang.String> r1 = r9.e     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            r1.add(r12)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
        L_0x00ff:
            r9.a(r12, r13, r10, r11)     // Catch:{ UnsupportedEncodingException -> 0x0103 }
            return
        L_0x0103:
            r0 = move-exception
            r1 = r0
            r1.printStackTrace()
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.ag.errorCb(char[], int, byte[]):void");
    }

    /* access modifiers changed from: package-private */
    public void pushCb(char[] cArr, byte[] bArr, byte[] bArr2, Object obj) {
        String str = new String(bArr2);
        Bundle a2 = am.a((Map<String, byte[]>) (Map) obj);
        cb.a("ResultScheduler", "received push message, bizparams=" + str);
        AIUIEvent aIUIEvent = new AIUIEvent(1001, 0, 0, str, a2);
        Message obtain = Message.obtain();
        obtain.what = 10;
        obtain.obj = aIUIEvent;
        a(obtain, false);
    }

    /* access modifiers changed from: package-private */
    public void resultCb(char[] cArr, byte[] bArr, byte[] bArr2, Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        if (cArr == null || bArr == null || bArr2 == null || obj == null) {
            Log.e("ResultScheduler", "resultCb has null params.");
            return;
        }
        try {
            String str = new String(bArr, "utf-8");
            ce ceVar = new ce();
            ceVar.b(str.replace("&", ","));
            a(str, new String(bArr2, "utf-8"), (Map) obj, ceVar.e(SpeechConstant.IST_SESSION_ID), ceVar.e("stmid"), currentTimeMillis);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public void statusCb(char[] cArr, int i, int i2, byte[] bArr, int i3) {
        if (!(i2 == 10114 || i2 == 10205)) {
            switch (i2) {
                case 11801:
                    Log.d("ServerConnection", "connect to server success.");
                    if (this.c != null) {
                        this.c.removeMessages(12);
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 13;
                    a(obtain, false);
                    this.a = false;
                    return;
                case 11802:
                    break;
                default:
                    return;
            }
        }
        Log.e("ServerConnection", "connect to server failed.");
        if (!this.a) {
            this.a = true;
            if (this.c != null) {
                this.c.sendEmptyMessageDelayed(12, 600000);
            }
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 14;
        a(obtain2, false);
    }

    /* access modifiers changed from: package-private */
    public void syncDataCb(char[] cArr, int i, byte[] bArr, int i2) {
        Message obtain;
        AIUIEvent aIUIEvent;
        AIUIEvent aIUIEvent2;
        cb.a("ResultScheduler", "sync data, ret=" + i + ", dataType=" + i2);
        String str = bArr != null ? new String(bArr) : "";
        Bundle bundle = new Bundle();
        bundle.putInt("sync_dtype", i2);
        if (3 == i2) {
            try {
                bundle.putString(SpeechConstant.IST_SESSION_ID, new JSONObject(str).getString(SpeechConstant.IST_SESSION_ID));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (4 == i2) {
            bundle.putString(SpeechUtility.TAG_RESOURCE_RESULT, str);
            obtain = Message.obtain();
            obtain.what = 8;
            if (200 != i) {
                aIUIEvent2 = new AIUIEvent(8, 24, i, "query athena sync status error.", bundle);
            } else {
                aIUIEvent = new AIUIEvent(8, 24, 0, "query athena sync status.", bundle);
                obtain.obj = aIUIEvent;
                a(obtain, false);
            }
        } else {
            obtain = Message.obtain();
            obtain.what = 8;
            if (200 != i) {
                aIUIEvent2 = new AIUIEvent(8, 13, i, "sync data error. dataType=" + i2, bundle);
            } else {
                aIUIEvent = new AIUIEvent(8, 13, 0, "sync data success. dataType=" + i2, bundle);
                obtain.obj = aIUIEvent;
                a(obtain, false);
            }
        }
        obtain.obj = aIUIEvent2;
        a(obtain, false);
    }
}
