package com.iflytek.cloud.thirdparty;

import android.content.Context;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class dk {
    private static dk a;
    private ds b;
    private dh c = null;
    private Context d;
    private dl e;
    private dp f;
    private di g = new dn(this);

    private dk(Context context) {
        this.b = new ds(context);
        this.d = context;
        this.f = new dp(context);
        this.e = new dl(this.b);
        Context context2 = this.d;
        dr.a(context2, "load settings: pkgRun=" + this.e.g() + " periodRun=" + this.e.a() + " periodUpdate=" + this.e.b());
    }

    public static synchronized dk a(Context context) {
        dk dkVar;
        synchronized (dk.class) {
            if (a == null) {
                a = new dk(context);
            }
            dkVar = a;
        }
        return dkVar;
    }

    /* access modifiers changed from: private */
    public void a(String str, int i) {
        if (i != 0 || str == null) {
            Context context = this.d;
            dr.a(context, "get config error:" + i);
        } else {
            this.e.c(System.currentTimeMillis());
            dr.a(this.d, "get config success");
            dr.a(this.d, str);
            b(str);
            dj.a(this.d);
        }
        this.c = null;
    }

    private void b(String str) {
        if (str == null || str.length() <= 0) {
            dr.a("LaunchSettings", "loadJson empty.");
            return;
        }
        JSONTokener jSONTokener = new JSONTokener(str);
        String str2 = "";
        try {
            JSONObject jSONObject = new JSONObject(jSONTokener);
            long j = jSONObject.getLong("updateperiod");
            JSONObject jSONObject2 = jSONObject.getJSONObject("launch");
            JSONArray jSONArray = jSONObject2.getJSONArray("runpackage");
            String[] strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
                str2 = str2 + strArr[i] + VoiceWakeuperAidl.PARAMS_SEPARATE;
            }
            long j2 = jSONObject2.getLong("runperiod");
            this.e.a(strArr);
            this.e.a(j);
            this.e.b(j2);
            dr.a(this.d, "parse json updateperiod:" + j + " runperiod:" + j2 + " runpackage:" + str2);
        } catch (JSONException e2) {
            String message = e2.getMessage();
            dr.a(this.d, "parse json error:" + message);
        }
    }

    private String d() {
        String f2 = f();
        String e2 = e();
        return "?t=" + f2 + "&p=" + e2;
    }

    private String e() {
        String a2 = this.f.a();
        String b2 = this.f.b();
        String f2 = this.e.f();
        StringBuilder sb = new StringBuilder();
        sb.append("imei=");
        if (a2 == null || a2.length() == 0) {
            a2 = "null";
        }
        sb.append(a2);
        sb.append(",ua=");
        sb.append(b2);
        sb.append(",appid=");
        if (f2 == null || f2.length() == 0) {
            f2 = "null";
        }
        sb.append(f2);
        sb.append(",sdkver=2.0");
        sb.append(",pkg=" + this.d.getPackageName());
        String sb2 = sb.toString();
        char[] charArray = dq.a(sb2.getBytes()).toCharArray();
        for (int i = 0; i < 8; i++) {
            char c2 = charArray[i];
            charArray[i] = charArray[(charArray.length - 8) + i];
            charArray[(charArray.length - 8) + i] = c2;
        }
        StringBuilder sb3 = new StringBuilder();
        for (char append : charArray) {
            sb3.append(append);
        }
        dr.a(this.d, sb2);
        return sb3.toString();
    }

    private String f() {
        return new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
    }

    public void a() {
        if (this.e.d() > System.currentTimeMillis()) {
            this.e.c(System.currentTimeMillis() - this.e.b());
        }
        if (System.currentTimeMillis() - this.e.d() <= this.e.b()) {
            dr.a(this.d, "check update interval=" + r0 + " period=" + r2 + " ret=false");
        } else if (this.c == null) {
            String str = "http://hxqd.openspeech.cn/launchconfig" + d();
            this.c = new dh(str, this.g);
            this.c.start();
            dr.a(this.d, "check update start get config ");
            dr.a(this.d, str);
        } else {
            dr.a("LaunchSettings", "mGetThread running.");
        }
    }

    public void a(long j) {
        this.e.d(j);
    }

    public void a(String str, String str2) {
        if ("appid".equals(str)) {
            this.e.a(str2);
            return;
        }
        dr.a("LaunchSettings", "unkown key =" + str);
    }

    public boolean a(String str) {
        if (this.e.c() == null || str == null) {
            return false;
        }
        for (String equals : this.e.c()) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        if (this.e.e() > System.currentTimeMillis()) {
            this.e.d(System.currentTimeMillis() - this.e.a());
        }
        boolean z = false;
        long currentTimeMillis = System.currentTimeMillis() - this.e.e();
        if (this.e.a() > 0 && currentTimeMillis > this.e.a()) {
            z = true;
        }
        Context context = this.d;
        dr.a(context, "check launch interval=" + currentTimeMillis + " period=" + this.e.a() + " ret=" + z);
        return z;
    }

    public long c() {
        return this.e.a();
    }
}
