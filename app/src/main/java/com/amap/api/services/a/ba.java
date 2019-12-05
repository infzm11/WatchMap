package com.amap.api.services.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public class ba {
    public static int a = -1;
    public static String b = "";

    /* compiled from: AuthConfigManager */
    public static class a {
        public b A;
        public String a;
        public int b = -1;
        public JSONObject c;
        public JSONObject d;
        public JSONObject e;
        public JSONObject f;
        public JSONObject g;
        public JSONObject h;
        public JSONObject i;
        public JSONObject j;
        public JSONObject k;
        public JSONObject l;
        public JSONObject m;
        public JSONObject n;
        public JSONObject o;
        public JSONObject p;
        public JSONObject q;
        public JSONObject r;
        public JSONObject s;
        public JSONObject t;
        public C0004a u;
        public d v;
        public c w;
        public b x;
        public b y;
        public b z;

        /* renamed from: com.amap.api.services.a.ba$a$a  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0004a {
            public boolean a;
            public boolean b;
            public JSONObject c;
        }

        /* compiled from: AuthConfigManager */
        public static class b {
            public boolean a;
            public String b;
            public String c;
            public String d;
        }

        /* compiled from: AuthConfigManager */
        public static class c {
            public String a;
            public String b;
        }

        /* compiled from: AuthConfigManager */
        public static class d {
            public String a;
            public String b;
            public String c;
        }
    }

    /* compiled from: AuthConfigManager */
    static class b extends cy {
        private String c;
        private Map<String, String> d;
        private boolean e;

        public byte[] b() {
            return null;
        }

        public Map<String, String> e() {
            return null;
        }

        /* access modifiers changed from: protected */
        public String f() {
            return "3.0";
        }

        b(Context context, bh bhVar, String str, Map<String, String> map) {
            super(context, bhVar);
            this.c = str;
            this.d = map;
            this.e = Build.VERSION.SDK_INT != 19;
        }

        public boolean a() {
            return this.e;
        }

        public String i() {
            return this.e ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        public byte[] c() {
            return bi.a(bi.a(o()));
        }

        private Map<String, String> o() {
            String q = bd.q(this.a);
            if (TextUtils.isEmpty(q)) {
                q = bd.c();
            }
            if (!TextUtils.isEmpty(q)) {
                q = bf.b(new StringBuilder(q).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.c);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", Build.VERSION.SDK_INT + "");
            hashMap.put("deviceId", q);
            if (this.d != null && !this.d.isEmpty()) {
                hashMap.putAll(this.d);
            }
            hashMap.put("abitype", bi.a(this.a));
            hashMap.put("ext", this.b.d());
            return hashMap;
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            String[] split = URLDecoder.decode(str).split("/");
            if (split[split.length - 1].charAt(4) % 2 == 1) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return z;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r10 = null;
        r11 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException), SYNTHETIC, Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.amap.api.services.a.ba.a a(android.content.Context r8, com.amap.api.services.a.bh r9, java.lang.String r10, java.util.Map<java.lang.String, java.lang.String> r11) {
        /*
            com.amap.api.services.a.ba$a r0 = new com.amap.api.services.a.ba$a
            r0.<init>()
            r1 = 0
            r2 = 0
            com.amap.api.services.a.cx r3 = new com.amap.api.services.a.cx     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            r3.<init>()     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            com.amap.api.services.a.ba$b r4 = new com.amap.api.services.a.ba$b     // Catch:{ ay -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            r4.<init>(r8, r9, r10, r11)     // Catch:{ ay -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            boolean r10 = r4.a()     // Catch:{ ay -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            com.amap.api.services.a.df r10 = r3.a(r4, r10)     // Catch:{ ay -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            if (r10 == 0) goto L_0x0029
            byte[] r11 = r10.a     // Catch:{ ay -> 0x0025, IllegalBlockSizeException -> 0x0022, Throwable -> 0x001e }
            goto L_0x002a
        L_0x001e:
            r11 = move-exception
            r3 = r11
            r11 = r1
            goto L_0x0070
        L_0x0022:
            r11 = r1
            goto L_0x008a
        L_0x0025:
            r11 = move-exception
            r3 = r11
            r11 = r1
            goto L_0x007f
        L_0x0029:
            r11 = r1
        L_0x002a:
            r3 = 16
            byte[] r4 = new byte[r3]     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r5 = r11.length     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r5 = r5 - r3
            byte[] r5 = new byte[r5]     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.System.arraycopy(r11, r2, r4, r2, r3)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r6 = r11.length     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r6 = r6 - r3
            java.lang.System.arraycopy(r11, r3, r5, r2, r6)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            javax.crypto.spec.SecretKeySpec r3 = new javax.crypto.spec.SecretKeySpec     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r6 = "AES"
            r3.<init>(r4, r6)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r4 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            javax.crypto.spec.IvParameterSpec r6 = new javax.crypto.spec.IvParameterSpec     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            byte[] r7 = com.amap.api.services.a.bi.b()     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r6.<init>(r7)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r7 = 2
            r4.init(r7, r3, r6)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            byte[] r3 = r4.doFinal(r5)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r3 = com.amap.api.services.a.bi.a((byte[]) r3)     // Catch:{ ay -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r1 = r3
            goto L_0x008a
        L_0x005e:
            r3 = move-exception
            goto L_0x0070
        L_0x0060:
            r3 = move-exception
            goto L_0x007f
        L_0x0062:
            com.amap.api.services.a.ay r10 = new com.amap.api.services.a.ay     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            java.lang.String r11 = "未知的错误"
            r10.<init>(r11)     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            throw r10     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
        L_0x006a:
            r10 = move-exception
            throw r10     // Catch:{ ay -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
        L_0x006c:
            r11 = move-exception
            r3 = r11
            r10 = r1
            r11 = r10
        L_0x0070:
            java.lang.String r4 = "ConfigManager"
            java.lang.String r5 = "loadConfig"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r3, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x008a
        L_0x0078:
            r10 = r1
            r11 = r10
            goto L_0x008a
        L_0x007b:
            r11 = move-exception
            r3 = r11
            r10 = r1
            r11 = r10
        L_0x007f:
            java.lang.String r4 = r3.a()
            r0.a = r4
            java.lang.String r4 = "/v3/iasdkauth"
            com.amap.api.services.a.bo.a((com.amap.api.services.a.bh) r9, (java.lang.String) r4, (com.amap.api.services.a.ay) r3)
        L_0x008a:
            if (r11 != 0) goto L_0x008d
            return r0
        L_0x008d:
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 == 0) goto L_0x0097
            java.lang.String r1 = com.amap.api.services.a.bi.a((byte[]) r11)
        L_0x0097:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0307 }
            r11.<init>(r1)     // Catch:{ Throwable -> 0x0307 }
            java.lang.String r1 = "status"
            boolean r1 = r11.has(r1)     // Catch:{ Throwable -> 0x0307 }
            if (r1 == 0) goto L_0x030f
            java.lang.String r1 = "status"
            int r1 = r11.getInt(r1)     // Catch:{ Throwable -> 0x0307 }
            r3 = 1
            if (r1 != r3) goto L_0x00b0
            a = r3     // Catch:{ Throwable -> 0x0307 }
            goto L_0x00f1
        L_0x00b0:
            if (r1 != 0) goto L_0x00f1
            java.lang.String r1 = "authcsid"
            java.lang.String r3 = "authgsid"
            if (r10 == 0) goto L_0x00bc
            java.lang.String r1 = r10.c     // Catch:{ Throwable -> 0x0307 }
            java.lang.String r3 = r10.d     // Catch:{ Throwable -> 0x0307 }
        L_0x00bc:
            com.amap.api.services.a.bi.a(r8, r1, r3, r11)     // Catch:{ Throwable -> 0x0307 }
            a = r2     // Catch:{ Throwable -> 0x0307 }
            java.lang.String r8 = "info"
            boolean r8 = r11.has(r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x00d1
            java.lang.String r8 = "info"
            java.lang.String r8 = r11.getString(r8)     // Catch:{ Throwable -> 0x0307 }
            b = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x00d1:
            java.lang.String r8 = ""
            java.lang.String r10 = "infocode"
            boolean r10 = r11.has(r10)     // Catch:{ Throwable -> 0x0307 }
            if (r10 == 0) goto L_0x00e1
            java.lang.String r8 = "infocode"
            java.lang.String r8 = r11.getString(r8)     // Catch:{ Throwable -> 0x0307 }
        L_0x00e1:
            java.lang.String r10 = "/v3/iasdkauth"
            java.lang.String r1 = b     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.bo.a(r9, r10, r1, r3, r8)     // Catch:{ Throwable -> 0x0307 }
            int r8 = a     // Catch:{ Throwable -> 0x0307 }
            if (r8 != 0) goto L_0x00f1
            java.lang.String r8 = b     // Catch:{ Throwable -> 0x0307 }
            r0.a = r8     // Catch:{ Throwable -> 0x0307 }
            return r0
        L_0x00f1:
            java.lang.String r8 = "ver"
            boolean r8 = r11.has(r8)     // Catch:{ Throwable -> 0x0102 }
            if (r8 == 0) goto L_0x010a
            java.lang.String r8 = "ver"
            int r8 = r11.getInt(r8)     // Catch:{ Throwable -> 0x0102 }
            r0.b = r8     // Catch:{ Throwable -> 0x0102 }
            goto L_0x010a
        L_0x0102:
            r8 = move-exception
            java.lang.String r9 = "AuthConfigManager"
            java.lang.String r10 = "loadConfigVer"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r8, (java.lang.String) r9, (java.lang.String) r10)     // Catch:{ Throwable -> 0x0307 }
        L_0x010a:
            java.lang.String r8 = "result"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r11, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0306
            com.amap.api.services.a.ba$a$a r8 = new com.amap.api.services.a.ba$a$a     // Catch:{ Throwable -> 0x0307 }
            r8.<init>()     // Catch:{ Throwable -> 0x0307 }
            r8.a = r2     // Catch:{ Throwable -> 0x0307 }
            r8.b = r2     // Catch:{ Throwable -> 0x0307 }
            r0.u = r8     // Catch:{ Throwable -> 0x0307 }
            java.lang.String r9 = "result"
            org.json.JSONObject r9 = r11.getJSONObject(r9)     // Catch:{ Throwable -> 0x0307 }
            java.lang.String r10 = "11K"
            boolean r10 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r10)     // Catch:{ Throwable -> 0x0307 }
            if (r10 == 0) goto L_0x0156
            java.lang.String r10 = "11K"
            org.json.JSONObject r10 = r9.getJSONObject(r10)     // Catch:{ Throwable -> 0x014e }
            java.lang.String r11 = "able"
            java.lang.String r11 = r10.getString(r11)     // Catch:{ Throwable -> 0x014e }
            boolean r11 = a((java.lang.String) r11, (boolean) r2)     // Catch:{ Throwable -> 0x014e }
            r8.a = r11     // Catch:{ Throwable -> 0x014e }
            java.lang.String r11 = "off"
            boolean r11 = r10.has(r11)     // Catch:{ Throwable -> 0x014e }
            if (r11 == 0) goto L_0x0156
            java.lang.String r11 = "off"
            org.json.JSONObject r10 = r10.getJSONObject(r11)     // Catch:{ Throwable -> 0x014e }
            r8.c = r10     // Catch:{ Throwable -> 0x014e }
            goto L_0x0156
        L_0x014e:
            r8 = move-exception
            java.lang.String r10 = "AuthConfigManager"
            java.lang.String r11 = "loadException"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r8, (java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Throwable -> 0x0307 }
        L_0x0156:
            java.lang.String r8 = "11B"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0166
            java.lang.String r8 = "11B"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.h = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0166:
            java.lang.String r8 = "11C"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0176
            java.lang.String r8 = "11C"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.k = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0176:
            java.lang.String r8 = "11I"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0186
            java.lang.String r8 = "11I"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.l = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0186:
            java.lang.String r8 = "11H"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0196
            java.lang.String r8 = "11H"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.m = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0196:
            java.lang.String r8 = "11E"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01a6
            java.lang.String r8 = "11E"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.n = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x01a6:
            java.lang.String r8 = "11F"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01b6
            java.lang.String r8 = "11F"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.o = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x01b6:
            java.lang.String r8 = "13A"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01c6
            java.lang.String r8 = "13A"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.q = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x01c6:
            java.lang.String r8 = "13J"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01d6
            java.lang.String r8 = "13J"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.i = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x01d6:
            java.lang.String r8 = "11G"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01e6
            java.lang.String r8 = "11G"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.p = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x01e6:
            java.lang.String r8 = "001"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x01fe
            java.lang.String r8 = "001"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$d r10 = new com.amap.api.services.a.ba$a$d     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.d) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.v = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x01fe:
            java.lang.String r8 = "002"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0216
            java.lang.String r8 = "002"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$c r10 = new com.amap.api.services.a.ba$a$c     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.c) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.w = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x0216:
            java.lang.String r8 = "006"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0226
            java.lang.String r8 = "006"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.r = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0226:
            java.lang.String r8 = "010"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0236
            java.lang.String r8 = "010"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.s = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0236:
            java.lang.String r8 = "11Z"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x024e
            java.lang.String r8 = "11Z"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$b r10 = new com.amap.api.services.a.ba$a$b     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.b) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.x = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x024e:
            java.lang.String r8 = "135"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x025e
            java.lang.String r8 = "135"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.j = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x025e:
            java.lang.String r8 = "13S"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x026e
            java.lang.String r8 = "13S"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.g = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x026e:
            java.lang.String r8 = "121"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0286
            java.lang.String r8 = "121"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$b r10 = new com.amap.api.services.a.ba$a$b     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.b) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.y = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x0286:
            java.lang.String r8 = "122"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x029e
            java.lang.String r8 = "122"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$b r10 = new com.amap.api.services.a.ba$a$b     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.b) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.z = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x029e:
            java.lang.String r8 = "123"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x02b6
            java.lang.String r8 = "123"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            com.amap.api.services.a.ba$a$b r10 = new com.amap.api.services.a.ba$a$b     // Catch:{ Throwable -> 0x0307 }
            r10.<init>()     // Catch:{ Throwable -> 0x0307 }
            a((org.json.JSONObject) r8, (com.amap.api.services.a.ba.a.b) r10)     // Catch:{ Throwable -> 0x0307 }
            r0.A = r10     // Catch:{ Throwable -> 0x0307 }
        L_0x02b6:
            java.lang.String r8 = "011"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x02c6
            java.lang.String r8 = "011"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.c = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x02c6:
            java.lang.String r8 = "012"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x02d6
            java.lang.String r8 = "012"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.d = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x02d6:
            java.lang.String r8 = "013"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x02e6
            java.lang.String r8 = "013"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.e = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x02e6:
            java.lang.String r8 = "014"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x02f6
            java.lang.String r8 = "014"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.f = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x02f6:
            java.lang.String r8 = "145"
            boolean r8 = com.amap.api.services.a.bi.a((org.json.JSONObject) r9, (java.lang.String) r8)     // Catch:{ Throwable -> 0x0307 }
            if (r8 == 0) goto L_0x0306
            java.lang.String r8 = "145"
            org.json.JSONObject r8 = r9.getJSONObject(r8)     // Catch:{ Throwable -> 0x0307 }
            r0.t = r8     // Catch:{ Throwable -> 0x0307 }
        L_0x0306:
            return r0
        L_0x0307:
            r8 = move-exception
            java.lang.String r9 = "AuthConfigManager"
            java.lang.String r10 = "loadConfig"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r8, (java.lang.String) r9, (java.lang.String) r10)
        L_0x030f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.ba.a(android.content.Context, com.amap.api.services.a.bh, java.lang.String, java.util.Map):com.amap.api.services.a.ba$a");
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str);
        }
        return "";
    }

    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, "m");
                String a3 = a(jSONObject, "u");
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.a = a(a5, false);
            } catch (Throwable th) {
                bl.a(th, "ConfigManager", "parsePluginEntity");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.c cVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                cVar.b = a2;
                cVar.a = a3;
            } catch (Throwable th) {
                bl.a(th, "ConfigManager", "parseSDKCoordinate");
            }
        }
    }

    private static void a(JSONObject jSONObject, a.d dVar) {
        if (jSONObject != null) {
            try {
                String a2 = a(jSONObject, "md5");
                String a3 = a(jSONObject, "url");
                String a4 = a(jSONObject, "sdkversion");
                if (!TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3)) {
                    if (!TextUtils.isEmpty(a4)) {
                        dVar.a = a3;
                        dVar.b = a2;
                        dVar.c = a4;
                    }
                }
            } catch (Throwable th) {
                bl.a(th, "ConfigManager", "parseSDKUpdate");
            }
        }
    }
}
