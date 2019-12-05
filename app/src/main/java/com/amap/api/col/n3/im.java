package com.amap.api.col.n3;

import android.text.TextUtils;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.HashMap;
import java.util.Map;

@jb(a = "a")
/* compiled from: SDKInfo */
public class im {
    @jc(a = "a1", b = 6)
    private String a;
    @jc(a = "a2", b = 6)
    private String b;
    @jc(a = "a6", b = 2)
    private int c;
    @jc(a = "a3", b = 6)
    private String d;
    @jc(a = "a4", b = 6)
    private String e;
    @jc(a = "a5", b = 6)
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String[] l;

    /* compiled from: SDKInfo */
    public static class a {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public boolean e = true;
        /* access modifiers changed from: private */
        public String f = "standard";
        /* access modifiers changed from: private */
        public String[] g = null;

        public a(String str, String str2, String str3) {
            this.a = str2;
            this.b = str2;
            this.d = str3;
            this.c = str;
        }

        public final a a(String[] strArr) {
            this.g = (String[]) strArr.clone();
            return this;
        }

        public final a a(String str) {
            this.b = str;
            return this;
        }

        public final im a() throws ic {
            if (this.g != null) {
                return new im(this, (byte) 0);
            }
            throw new ic("sdk packages is null");
        }
    }

    public static String h() {
        return "a6=1";
    }

    /* synthetic */ im(a aVar, byte b2) {
        this(aVar);
    }

    private im() {
        this.c = 1;
        this.l = null;
    }

    private im(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = in.b(this.h);
        this.a = in.b(this.j);
        this.d = in.b(this.i);
        this.e = in.b(a(this.l));
        this.f = in.b(this.k);
    }

    public final void a(boolean z) {
        this.c = z ? 1 : 0;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = in.c(this.a);
        }
        return this.j;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = in.c(this.b);
        }
        return this.h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.i) && !TextUtils.isEmpty(this.d)) {
            this.i = in.c(this.d);
        }
        return this.i;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = in.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public final boolean f() {
        return this.c == 1;
    }

    public final String[] g() {
        if ((this.l == null || this.l.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = b(in.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private static String[] b(String str) {
        try {
            return str.split(VoiceWakeuperAidl.PARAMS_SEPARATE);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("a1", in.b(str));
        return ja.a((Map<String, String>) hashMap);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return getClass() == obj.getClass() && hashCode() == ((im) obj).hashCode();
    }

    public int hashCode() {
        iq iqVar = new iq();
        iqVar.a((Object) this.j).a((Object) this.g).a((Object) this.h).a((Object[]) this.l);
        return iqVar.a();
    }
}
