package com.loc;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthConfigManager */
public final class l {
    public static int a = -1;
    public static String b = "";

    /* compiled from: AuthConfigManager */
    public static class a {
        public b A;
        public b B;
        public b C;
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
        public JSONObject u;
        public JSONObject v;
        public C0012a w;
        public d x;
        public c y;
        public b z;

        /* renamed from: com.loc.l$a$a  reason: collision with other inner class name */
        /* compiled from: AuthConfigManager */
        public static class C0012a {
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
            public boolean e;
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
    static class b extends bj {
        private String f;
        private Map<String, String> g = null;
        private boolean h;

        b(Context context, s sVar, String str) {
            super(context, sVar);
            this.f = str;
            this.h = Build.VERSION.SDK_INT != 19;
        }

        public final boolean a() {
            return this.h;
        }

        public final byte[] a_() {
            return null;
        }

        public final Map<String, String> b() {
            return null;
        }

        public final String c() {
            return this.h ? "https://restapi.amap.com/v3/iasdkauth" : "http://restapi.amap.com/v3/iasdkauth";
        }

        public final byte[] e() {
            String r = n.r(this.a);
            if (TextUtils.isEmpty(r)) {
                r = n.c();
            }
            if (!TextUtils.isEmpty(r)) {
                r = p.b(new StringBuilder(r).reverse().toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("authkey", this.f);
            hashMap.put("plattype", "android");
            hashMap.put("product", this.b.a());
            hashMap.put("version", this.b.b());
            hashMap.put("output", "json");
            hashMap.put("androidversion", Build.VERSION.SDK_INT);
            hashMap.put("deviceId", r);
            hashMap.put("manufacture", Build.MANUFACTURER);
            if (this.g != null && !this.g.isEmpty()) {
                hashMap.putAll(this.g);
            }
            hashMap.put("abitype", t.a(this.a));
            hashMap.put("ext", this.b.d());
            return t.a(t.a((Map<String, String>) hashMap));
        }

        /* access modifiers changed from: protected */
        public final String f() {
            return "3.0";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r11 = null;
        r3 = null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[ExcHandler: IllegalBlockSizeException (unused javax.crypto.IllegalBlockSizeException), SYNTHETIC, Splitter:B:1:0x0007] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.loc.l.a a(android.content.Context r9, com.loc.s r10, java.lang.String r11) {
        /*
            com.loc.l$a r0 = new com.loc.l$a
            r0.<init>()
            r1 = 0
            r2 = 0
            com.loc.bi r3 = new com.loc.bi     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            r3.<init>()     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            com.loc.l$b r3 = new com.loc.l$b     // Catch:{ j -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            r3.<init>(r9, r10, r11)     // Catch:{ j -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            boolean r11 = r3.a()     // Catch:{ j -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            com.loc.bo r11 = com.loc.bi.a(r3, r11)     // Catch:{ j -> 0x006a, Throwable -> 0x0062, IllegalBlockSizeException -> 0x0078 }
            if (r11 == 0) goto L_0x0029
            byte[] r3 = r11.a     // Catch:{ j -> 0x0025, IllegalBlockSizeException -> 0x0022, Throwable -> 0x001e }
            goto L_0x002a
        L_0x001e:
            r3 = move-exception
            r4 = r3
            r3 = r1
            goto L_0x0070
        L_0x0022:
            r3 = r1
            goto L_0x008a
        L_0x0025:
            r3 = move-exception
            r4 = r3
            r3 = r1
            goto L_0x007f
        L_0x0029:
            r3 = r1
        L_0x002a:
            r4 = 16
            byte[] r5 = new byte[r4]     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r6 = r3.length     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r6 = r6 - r4
            byte[] r6 = new byte[r6]     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.System.arraycopy(r3, r2, r5, r2, r4)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r7 = r3.length     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            int r7 = r7 - r4
            java.lang.System.arraycopy(r3, r4, r6, r2, r7)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r7 = "AES"
            r4.<init>(r5, r7)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r5 = "AES/CBC/PKCS5Padding"
            javax.crypto.Cipher r5 = javax.crypto.Cipher.getInstance(r5)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            javax.crypto.spec.IvParameterSpec r7 = new javax.crypto.spec.IvParameterSpec     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            byte[] r8 = com.loc.t.b()     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r7.<init>(r8)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r8 = 2
            r5.init(r8, r4, r7)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            byte[] r4 = r5.doFinal(r6)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            java.lang.String r4 = com.loc.t.a((byte[]) r4)     // Catch:{ j -> 0x0060, IllegalBlockSizeException -> 0x008a, Throwable -> 0x005e }
            r1 = r4
            goto L_0x008a
        L_0x005e:
            r4 = move-exception
            goto L_0x0070
        L_0x0060:
            r4 = move-exception
            goto L_0x007f
        L_0x0062:
            com.loc.j r11 = new com.loc.j     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            java.lang.String r3 = "未知的错误"
            r11.<init>(r3)     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
            throw r11     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
        L_0x006a:
            r11 = move-exception
            throw r11     // Catch:{ j -> 0x007b, IllegalBlockSizeException -> 0x0078, Throwable -> 0x006c }
        L_0x006c:
            r3 = move-exception
            r11 = r1
            r4 = r3
            r3 = r11
        L_0x0070:
            java.lang.String r5 = "at"
            java.lang.String r6 = "lc"
            com.loc.z.b((java.lang.Throwable) r4, (java.lang.String) r5, (java.lang.String) r6)
            goto L_0x008a
        L_0x0078:
            r11 = r1
            r3 = r11
            goto L_0x008a
        L_0x007b:
            r3 = move-exception
            r11 = r1
            r4 = r3
            r3 = r11
        L_0x007f:
            java.lang.String r5 = r4.a()
            r0.a = r5
            java.lang.String r5 = "/v3/iasdkauth"
            com.loc.z.a((com.loc.s) r10, (java.lang.String) r5, (com.loc.j) r4)
        L_0x008a:
            if (r3 != 0) goto L_0x008d
            return r0
        L_0x008d:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            if (r4 == 0) goto L_0x0097
            java.lang.String r1 = com.loc.t.a((byte[]) r3)
        L_0x0097:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x0372 }
            r3.<init>(r1)     // Catch:{ Throwable -> 0x0372 }
            java.lang.String r1 = "status"
            boolean r1 = r3.has(r1)     // Catch:{ Throwable -> 0x0372 }
            if (r1 == 0) goto L_0x037a
            java.lang.String r1 = "status"
            int r1 = r3.getInt(r1)     // Catch:{ Throwable -> 0x0372 }
            r4 = 1
            if (r1 != r4) goto L_0x00b0
            a = r4     // Catch:{ Throwable -> 0x0372 }
            goto L_0x00f1
        L_0x00b0:
            if (r1 != 0) goto L_0x00f1
            java.lang.String r1 = "authcsid"
            java.lang.String r4 = "authgsid"
            if (r11 == 0) goto L_0x00bc
            java.lang.String r1 = r11.c     // Catch:{ Throwable -> 0x0372 }
            java.lang.String r4 = r11.d     // Catch:{ Throwable -> 0x0372 }
        L_0x00bc:
            com.loc.t.a(r9, r1, r4, r3)     // Catch:{ Throwable -> 0x0372 }
            a = r2     // Catch:{ Throwable -> 0x0372 }
            java.lang.String r9 = "info"
            boolean r9 = r3.has(r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x00d1
            java.lang.String r9 = "info"
            java.lang.String r9 = r3.getString(r9)     // Catch:{ Throwable -> 0x0372 }
            b = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x00d1:
            java.lang.String r9 = ""
            java.lang.String r11 = "infocode"
            boolean r11 = r3.has(r11)     // Catch:{ Throwable -> 0x0372 }
            if (r11 == 0) goto L_0x00e1
            java.lang.String r9 = "infocode"
            java.lang.String r9 = r3.getString(r9)     // Catch:{ Throwable -> 0x0372 }
        L_0x00e1:
            java.lang.String r11 = "/v3/iasdkauth"
            java.lang.String r1 = b     // Catch:{ Throwable -> 0x0372 }
            com.loc.z.a(r10, r11, r1, r4, r9)     // Catch:{ Throwable -> 0x0372 }
            int r9 = a     // Catch:{ Throwable -> 0x0372 }
            if (r9 != 0) goto L_0x00f1
            java.lang.String r9 = b     // Catch:{ Throwable -> 0x0372 }
            r0.a = r9     // Catch:{ Throwable -> 0x0372 }
            return r0
        L_0x00f1:
            java.lang.String r9 = "ver"
            boolean r9 = r3.has(r9)     // Catch:{ Throwable -> 0x0102 }
            if (r9 == 0) goto L_0x010a
            java.lang.String r9 = "ver"
            int r9 = r3.getInt(r9)     // Catch:{ Throwable -> 0x0102 }
            r0.b = r9     // Catch:{ Throwable -> 0x0102 }
            goto L_0x010a
        L_0x0102:
            r9 = move-exception
            java.lang.String r10 = "at"
            java.lang.String r11 = "lc"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)     // Catch:{ Throwable -> 0x0372 }
        L_0x010a:
            java.lang.String r9 = "result"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r3, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0371
            com.loc.l$a$a r9 = new com.loc.l$a$a     // Catch:{ Throwable -> 0x0372 }
            r9.<init>()     // Catch:{ Throwable -> 0x0372 }
            r9.a = r2     // Catch:{ Throwable -> 0x0372 }
            r9.b = r2     // Catch:{ Throwable -> 0x0372 }
            r0.w = r9     // Catch:{ Throwable -> 0x0372 }
            java.lang.String r10 = "result"
            org.json.JSONObject r10 = r3.getJSONObject(r10)     // Catch:{ Throwable -> 0x0372 }
            java.lang.String r11 = "11K"
            boolean r11 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r11)     // Catch:{ Throwable -> 0x0372 }
            if (r11 == 0) goto L_0x0156
            java.lang.String r11 = "11K"
            org.json.JSONObject r11 = r10.getJSONObject(r11)     // Catch:{ Throwable -> 0x014e }
            java.lang.String r1 = "able"
            java.lang.String r1 = r11.getString(r1)     // Catch:{ Throwable -> 0x014e }
            boolean r1 = a((java.lang.String) r1, (boolean) r2)     // Catch:{ Throwable -> 0x014e }
            r9.a = r1     // Catch:{ Throwable -> 0x014e }
            java.lang.String r1 = "off"
            boolean r1 = r11.has(r1)     // Catch:{ Throwable -> 0x014e }
            if (r1 == 0) goto L_0x0156
            java.lang.String r1 = "off"
            org.json.JSONObject r11 = r11.getJSONObject(r1)     // Catch:{ Throwable -> 0x014e }
            r9.c = r11     // Catch:{ Throwable -> 0x014e }
            goto L_0x0156
        L_0x014e:
            r9 = move-exception
            java.lang.String r11 = "AuthConfigManager"
            java.lang.String r1 = "loadException"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r11, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0372 }
        L_0x0156:
            java.lang.String r9 = "11B"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0166
            java.lang.String r9 = "11B"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.h = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0166:
            java.lang.String r9 = "11C"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0176
            java.lang.String r9 = "11C"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.k = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0176:
            java.lang.String r9 = "11I"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0186
            java.lang.String r9 = "11I"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.l = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0186:
            java.lang.String r9 = "11H"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0196
            java.lang.String r9 = "11H"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.m = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0196:
            java.lang.String r9 = "11E"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x01a6
            java.lang.String r9 = "11E"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.n = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x01a6:
            java.lang.String r9 = "11F"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x01b6
            java.lang.String r9 = "11F"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.o = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x01b6:
            java.lang.String r9 = "13A"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x01c6
            java.lang.String r9 = "13A"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.q = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x01c6:
            java.lang.String r9 = "13J"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x01d6
            java.lang.String r9 = "13J"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.i = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x01d6:
            java.lang.String r9 = "11G"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x01e6
            java.lang.String r9 = "11G"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.p = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x01e6:
            java.lang.String r9 = "001"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0231
            java.lang.String r9 = "001"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$d r11 = new com.loc.l$a$d     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x022f
            java.lang.String r1 = "md5"
            java.lang.String r1 = a((org.json.JSONObject) r9, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0227 }
            java.lang.String r2 = "url"
            java.lang.String r2 = a((org.json.JSONObject) r9, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0227 }
            java.lang.String r3 = "sdkversion"
            java.lang.String r9 = a((org.json.JSONObject) r9, (java.lang.String) r3)     // Catch:{ Throwable -> 0x0227 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Throwable -> 0x0227 }
            if (r3 != 0) goto L_0x022f
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Throwable -> 0x0227 }
            if (r3 != 0) goto L_0x022f
            boolean r3 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Throwable -> 0x0227 }
            if (r3 == 0) goto L_0x0220
            goto L_0x022f
        L_0x0220:
            r11.a = r2     // Catch:{ Throwable -> 0x0227 }
            r11.b = r1     // Catch:{ Throwable -> 0x0227 }
            r11.c = r9     // Catch:{ Throwable -> 0x0227 }
            goto L_0x022f
        L_0x0227:
            r9 = move-exception
            java.lang.String r1 = "at"
            java.lang.String r2 = "psu"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0372 }
        L_0x022f:
            r0.x = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x0231:
            java.lang.String r9 = "002"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0261
            java.lang.String r9 = "002"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$c r11 = new com.loc.l$a$c     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x025f
            java.lang.String r1 = "md5"
            java.lang.String r1 = a((org.json.JSONObject) r9, (java.lang.String) r1)     // Catch:{ Throwable -> 0x0257 }
            java.lang.String r2 = "url"
            java.lang.String r9 = a((org.json.JSONObject) r9, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0257 }
            r11.b = r1     // Catch:{ Throwable -> 0x0257 }
            r11.a = r9     // Catch:{ Throwable -> 0x0257 }
            goto L_0x025f
        L_0x0257:
            r9 = move-exception
            java.lang.String r1 = "At"
            java.lang.String r2 = "psc"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0372 }
        L_0x025f:
            r0.y = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x0261:
            java.lang.String r9 = "006"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0271
            java.lang.String r9 = "006"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.r = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0271:
            java.lang.String r9 = "010"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0281
            java.lang.String r9 = "010"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.s = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0281:
            java.lang.String r9 = "11Z"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0299
            java.lang.String r9 = "11Z"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$b r11 = new com.loc.l$a$b     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            a((org.json.JSONObject) r9, (com.loc.l.a.b) r11)     // Catch:{ Throwable -> 0x0372 }
            r0.z = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x0299:
            java.lang.String r9 = "135"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x02a9
            java.lang.String r9 = "135"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.j = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x02a9:
            java.lang.String r9 = "13S"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x02b9
            java.lang.String r9 = "13S"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.g = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x02b9:
            java.lang.String r9 = "121"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x02d1
            java.lang.String r9 = "121"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$b r11 = new com.loc.l$a$b     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            a((org.json.JSONObject) r9, (com.loc.l.a.b) r11)     // Catch:{ Throwable -> 0x0372 }
            r0.A = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x02d1:
            java.lang.String r9 = "122"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x02e9
            java.lang.String r9 = "122"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$b r11 = new com.loc.l$a$b     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            a((org.json.JSONObject) r9, (com.loc.l.a.b) r11)     // Catch:{ Throwable -> 0x0372 }
            r0.B = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x02e9:
            java.lang.String r9 = "123"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0301
            java.lang.String r9 = "123"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            com.loc.l$a$b r11 = new com.loc.l$a$b     // Catch:{ Throwable -> 0x0372 }
            r11.<init>()     // Catch:{ Throwable -> 0x0372 }
            a((org.json.JSONObject) r9, (com.loc.l.a.b) r11)     // Catch:{ Throwable -> 0x0372 }
            r0.C = r11     // Catch:{ Throwable -> 0x0372 }
        L_0x0301:
            java.lang.String r9 = "011"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0311
            java.lang.String r9 = "011"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.c = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0311:
            java.lang.String r9 = "012"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0321
            java.lang.String r9 = "012"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.d = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0321:
            java.lang.String r9 = "013"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0331
            java.lang.String r9 = "013"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.e = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0331:
            java.lang.String r9 = "014"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0341
            java.lang.String r9 = "014"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.f = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0341:
            java.lang.String r9 = "145"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0351
            java.lang.String r9 = "145"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.t = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0351:
            java.lang.String r9 = "14B"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0361
            java.lang.String r9 = "14B"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.u = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0361:
            java.lang.String r9 = "14D"
            boolean r9 = com.loc.t.a((org.json.JSONObject) r10, (java.lang.String) r9)     // Catch:{ Throwable -> 0x0372 }
            if (r9 == 0) goto L_0x0371
            java.lang.String r9 = "14D"
            org.json.JSONObject r9 = r10.getJSONObject(r9)     // Catch:{ Throwable -> 0x0372 }
            r0.v = r9     // Catch:{ Throwable -> 0x0372 }
        L_0x0371:
            return r0
        L_0x0372:
            r9 = move-exception
            java.lang.String r10 = "at"
            java.lang.String r11 = "lc"
            com.loc.w.a((java.lang.Throwable) r9, (java.lang.String) r10, (java.lang.String) r11)
        L_0x037a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.l.a(android.content.Context, com.loc.s, java.lang.String):com.loc.l$a");
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) ? jSONObject.optString(str) : "";
    }

    @Deprecated
    public static void a(String str) {
        k.b(str);
    }

    private static void a(JSONObject jSONObject, a.b bVar) {
        if (bVar != null) {
            try {
                String a2 = a(jSONObject, "m");
                String a3 = a(jSONObject, "u");
                String a4 = a(jSONObject, "v");
                String a5 = a(jSONObject, "able");
                String a6 = a(jSONObject, "on");
                bVar.c = a2;
                bVar.b = a3;
                bVar.d = a4;
                bVar.a = a(a5, false);
                bVar.e = a(a6, true);
            } catch (Throwable th) {
                w.a(th, "at", "pe");
            }
        }
    }

    public static boolean a(String str, boolean z) {
        try {
            if (TextUtils.isEmpty(str)) {
                return z;
            }
            String[] split = URLDecoder.decode(str).split("/");
            return split[split.length - 1].charAt(4) % 2 == 1;
        } catch (Throwable unused) {
            return z;
        }
    }
}
