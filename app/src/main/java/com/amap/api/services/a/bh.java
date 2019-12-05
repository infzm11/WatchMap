package com.amap.api.services.a;

import android.text.TextUtils;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.HashMap;
import java.util.Map;

@bv(a = "a")
/* compiled from: SDKInfo */
public class bh {
    @bw(a = "a1", b = 6)
    private String a;
    @bw(a = "a2", b = 6)
    private String b;
    @bw(a = "a6", b = 2)
    private int c;
    @bw(a = "a3", b = 6)
    private String d;
    @bw(a = "a4", b = 6)
    private String e;
    @bw(a = "a5", b = 6)
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

        public a a(boolean z) {
            this.e = z;
            return this;
        }

        public a a(String[] strArr) {
            this.g = (String[]) strArr.clone();
            return this;
        }

        public a a(String str) {
            this.b = str;
            return this;
        }

        public bh a() throws ay {
            if (this.g != null) {
                return new bh(this);
            }
            throw new ay("sdk packages is null");
        }
    }

    public static String g() {
        return "a6=1";
    }

    private bh() {
        this.c = 1;
        this.l = null;
    }

    private bh(a aVar) {
        this.c = 1;
        this.l = null;
        this.g = aVar.a;
        this.h = aVar.b;
        this.j = aVar.c;
        this.i = aVar.d;
        this.c = aVar.e ? 1 : 0;
        this.k = aVar.f;
        this.l = aVar.g;
        this.b = bi.b(this.h);
        this.a = bi.b(this.j);
        this.d = bi.b(this.i);
        this.e = bi.b(a(this.l));
        this.f = bi.b(this.k);
    }

    public String a() {
        if (TextUtils.isEmpty(this.j) && !TextUtils.isEmpty(this.a)) {
            this.j = bi.c(this.a);
        }
        return this.j;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        if (TextUtils.isEmpty(this.h) && !TextUtils.isEmpty(this.b)) {
            this.h = bi.c(this.b);
        }
        return this.h;
    }

    public String d() {
        if (TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.f)) {
            this.k = bi.c(this.f);
        }
        if (TextUtils.isEmpty(this.k)) {
            this.k = "standard";
        }
        return this.k;
    }

    public boolean e() {
        return this.c == 1;
    }

    public String[] f() {
        if ((this.l == null || this.l.length == 0) && !TextUtils.isEmpty(this.e)) {
            this.l = b(bi.c(this.e));
        }
        return (String[]) this.l.clone();
    }

    private String[] b(String str) {
        try {
            return str.split(VoiceWakeuperAidl.PARAMS_SEPARATE);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String a(String[] strArr) {
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
        hashMap.put("a1", bi.b(str));
        return bu.a((Map<String, String>) hashMap);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() == obj.getClass() && hashCode() == ((bh) obj).hashCode()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        bk bkVar = new bk();
        bkVar.a((Object) this.j).a((Object) this.g).a((Object) this.h).a((Object[]) this.l);
        return bkVar.a();
    }
}
