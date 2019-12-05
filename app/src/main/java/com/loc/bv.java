package com.loc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.cloud.SpeechUtility;
import com.loc.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ConnectionServiceManager */
public class bv {
    public boolean a = false;
    boolean b = false;
    private String c = null;
    private Context d = null;
    private boolean e = true;
    /* access modifiers changed from: private */
    public i f = null;
    private ServiceConnection g = null;
    private ServiceConnection h = null;
    private ServiceConnection i = null;
    private Intent j = new Intent();
    private String k = "com.autonavi.minimap";
    private String l = "com.amap.api.service.AMapService";
    private String m = "com.autonavi.minimap.LBSConnectionService";
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private String s = "invaid type";
    private String t = "empty appkey";
    private String u = "refused";
    private String v = "failed";

    public bv(Context context) {
        this.d = context;
        try {
            this.c = o.a(ch.a(k.f(context).getBytes("UTF-8"), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n"));
        } catch (Throwable th) {
            cs.a(th, "ConnectionServiceManager", "ConnectionServiceManager");
        }
    }

    private AMapLocationServer a(Bundle bundle) {
        byte[] bArr;
        if (bundle == null || !bundle.containsKey("key")) {
            return null;
        }
        try {
            bArr = ch.b(o.b(bundle.getString("key")), "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDCEYwdO3V2ANrhApjqyk7X8FH5AEaWly58kP9IDAhMqwtIbmcJrUK9oO9Afh3KZnOlDtjiowy733YqpLRO7WBvdbW/c4Dz/d3dy/m+6HMqxaak+GQQRHw/VPdKciaZ3eIZp4MWOyIQwiFSQvPTAo/Na8hV4SgBZHB3lGFw0yu+BmG+h32eIE6p4Y8EDCn+G+yzekX+taMrWTQIysledrygZSGPv1ukbdFDnH/xZEI0dCr9pZT+AZQl3o9a2aMyuRrHM0oupXKKiYl69Y8fKh1Tyd752rF6LrR5uOb9aOfXt18hb+3YL5P9rQ+ZRYbyHYFaxzBPA2jLq0KUQ+Dmg7YhAgMBAAECggEAL9pj0lF3BUHwtssNKdf42QZJMD0BKuDcdZrLV9ifs0f54EJY5enzKw8j76MpdV8N5QVkNX4/BZR0bs9uJogh31oHFs5EXeWbb7V8P7bRrxpNnSAijGBWwscQsyqymf48YlcL28949ujnjoEz3jQjgWOyYnrCgpVhphrQbCGmB5TcZnTFvHfozt/0tzuMj5na5lRnkD0kYXgr0x/SRZcPoCybSpc3t/B/9MAAboGaV/QQkTotr7VOuJfaPRjvg8rzyPzavo3evxsjXj7vDXbN4w0cbk/Uqn2JtvPQ8HoysmF2HdYvILZibvJmWH1hA58b4sn5s6AqFRjMOL7rHdD+gQKBgQD+IzoofmZK5tTxgO9sWsG71IUeshQP9fe159jKCehk1RfuIqqbRP0UcxJiw4eNjHs4zU0HeRL3iF5XfUs0FQanO/pp6YL1xgVdfQlDdTdk6KFHJ0sUJapnJn1S2k7IKfRKE1+rkofSXMYUTsgHF1fDp+gxy4yUMY+h9O+JlKVKOwKBgQDDfaDIblaSm+B0lyG//wFPynAeGd0Q8wcMZbQQ/LWMJZhMZ7fyUZ+A6eL/jB53a2tgnaw2rXBpMe1qu8uSpym2plU0fkgLAnVugS5+KRhOkUHyorcbpVZbs5azf7GlTydR5dI1PHF3Bncemoa6IsEvumHWgQbVyTTz/O9mlFafUwKBgQCvDebms8KUf5JY1F6XfaCLWGVl8nZdVCmQFKbA7Lg2lI5KS3jHQWsupeEZRORffU/3nXsc1apZ9YY+r6CYvI77rRXd1KqPzxos/o7d96TzjkZhc9CEjTlmmh2jb5rqx/Ns/xFcZq/GGH+cx3ODZvHeZQ9NFY+9GLJ+dfB2DX0ZtwKBgQC+9/lZ8telbpqMqpqwqRaJ8LMn5JIdHZu0E6IcuhFLr+ogMW3zTKMpVtGGXEXi2M/TWRPDchiO2tQX4Q5T2/KW19QCbJ5KCwPWiGF3owN4tNOciDGh0xkSidRc0xAh8bnyejSoBry8zlcNUVztdkgMLOGonvCjZWPSOTNQnPYluwKBgCV+WVftpTk3l+OfAJTaXEPNYdh7+WQjzxZKjUaDzx80Ts7hRo2U+EQT7FBjQQNqmmDnWtujo5p1YmJC0FT3n1CVa7g901pb3b0RcOziYWAoJi0/+kLyeo6XBhuLeZ7h90S70GGh1o0V/j/9N1jb5DCL4xKkvdYePPTSTku0BM+n");
        } catch (Throwable th) {
            cs.a(th, "ConnectionServiceManager", "parseData part");
            bArr = null;
        }
        if (bundle.containsKey(SpeechUtility.TAG_RESOURCE_RESULT)) {
            try {
                JSONObject jSONObject = new JSONObject(new String(ch.a(bArr, o.b(bundle.getString(SpeechUtility.TAG_RESOURCE_RESULT))), "utf-8"));
                if (jSONObject.has("error")) {
                    String string = jSONObject.getString("error");
                    if (this.s.equals(string)) {
                        this.e = false;
                    }
                    if (this.t.equals(string)) {
                        this.e = false;
                    }
                    if (this.u.equals(string)) {
                        this.e = false;
                    }
                    this.v.equals(string);
                    return null;
                }
                AMapLocationServer aMapLocationServer = new AMapLocationServer("");
                aMapLocationServer.b(jSONObject);
                aMapLocationServer.setProvider(FocusType.lbs);
                aMapLocationServer.setLocationType(7);
                if ("WGS84".equals(aMapLocationServer.e()) && cs.a(aMapLocationServer.getLatitude(), aMapLocationServer.getLongitude())) {
                    DPoint a2 = ct.a(this.d, aMapLocationServer.getLongitude(), aMapLocationServer.getLatitude());
                    aMapLocationServer.setLatitude(a2.getLatitude());
                    aMapLocationServer.setLongitude(a2.getLongitude());
                }
                return aMapLocationServer;
            } catch (Throwable th2) {
                cs.a(th2, bv.class.getName(), "parseData");
            }
        }
        return null;
    }

    private void f() {
        if (cr.c(this.d)) {
            Intent intent = new Intent();
            intent.putExtra("appkey", this.c);
            intent.setComponent(new ComponentName(this.k, this.m));
            try {
                this.o = this.d.bindService(intent, this.h, 1);
            } catch (Throwable unused) {
            }
            if (!this.o) {
                ArrayList<String> n2 = cr.n();
                if (n2 != null) {
                    Iterator<String> it = n2.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (!next.equals(this.m)) {
                            intent.setComponent(new ComponentName(this.k, next));
                            try {
                                this.o = this.d.bindService(intent, this.h, 1);
                            } catch (Throwable unused2) {
                            }
                            if (this.n) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private AMapLocationServer g() {
        try {
            if (!this.e || !this.n) {
                return null;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "corse");
            bundle.putString("appkey", this.c);
            bundle.putInt("opensdk", 1);
            if (this.f != null) {
                this.f.a(bundle);
                if (bundle.size() > 0) {
                    return a(bundle);
                }
            }
            return null;
        } catch (Throwable th) {
            cs.a(th, "ConnectionServiceManager", "sendCommand");
        }
    }

    public final void a() {
        try {
            if (this.n) {
                this.d.unbindService(this.g);
            }
            if (this.o) {
                this.d.unbindService(this.h);
            }
            if (this.p) {
                this.d.unbindService(this.i);
            }
        } catch (Throwable th) {
            cs.a(th, "ConnectionServiceManager", "unbindService");
        }
        this.f = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.e = true;
        this.a = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.b = false;
        this.r = false;
        this.q = false;
    }

    public final void b() {
        try {
            if (this.g == null) {
                this.g = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                        bv.this.a = true;
                        i unused = bv.this.f = i.a.a(iBinder);
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                        bv.this.a = false;
                        i unused = bv.this.f = null;
                    }
                };
            }
            if (this.h == null) {
                this.h = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
            if (this.i == null) {
                this.i = new ServiceConnection() {
                    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public final void onServiceDisconnected(ComponentName componentName) {
                    }
                };
            }
        } catch (Throwable th) {
            cs.a(th, "ConnectionServiceManager", "init");
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0031 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0035 A[Catch:{ Throwable -> 0x0075 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[EDGE_INSN: B:32:0x006f->B:26:0x006f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x003f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r6 = this;
            boolean r0 = r6.q
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 1
            android.content.Context r1 = r6.d     // Catch:{ Throwable -> 0x0075 }
            boolean r1 = com.loc.cr.b((android.content.Context) r1)     // Catch:{ Throwable -> 0x0075 }
            if (r1 == 0) goto L_0x006f
            android.content.Intent r1 = r6.j     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r2 = "appkey"
            java.lang.String r3 = r6.c     // Catch:{ Throwable -> 0x0075 }
            r1.putExtra(r2, r3)     // Catch:{ Throwable -> 0x0075 }
            android.content.Intent r1 = r6.j     // Catch:{ Throwable -> 0x0075 }
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r3 = r6.k     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r4 = r6.l     // Catch:{ Throwable -> 0x0075 }
            r2.<init>(r3, r4)     // Catch:{ Throwable -> 0x0075 }
            r1.setComponent(r2)     // Catch:{ Throwable -> 0x0075 }
            android.content.Context r1 = r6.d     // Catch:{ Throwable -> 0x0031 }
            android.content.Intent r2 = r6.j     // Catch:{ Throwable -> 0x0031 }
            android.content.ServiceConnection r3 = r6.g     // Catch:{ Throwable -> 0x0031 }
            boolean r1 = r1.bindService(r2, r3, r0)     // Catch:{ Throwable -> 0x0031 }
            r6.n = r1     // Catch:{ Throwable -> 0x0031 }
        L_0x0031:
            boolean r1 = r6.n     // Catch:{ Throwable -> 0x0075 }
            if (r1 != 0) goto L_0x006f
            java.util.ArrayList r1 = com.loc.cr.m()     // Catch:{ Throwable -> 0x0075 }
            if (r1 == 0) goto L_0x006f
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Throwable -> 0x0075 }
        L_0x003f:
            boolean r2 = r1.hasNext()     // Catch:{ Throwable -> 0x0075 }
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r1.next()     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r3 = r6.l     // Catch:{ Throwable -> 0x0075 }
            boolean r3 = r2.equals(r3)     // Catch:{ Throwable -> 0x0075 }
            if (r3 != 0) goto L_0x003f
            android.content.Intent r3 = r6.j     // Catch:{ Throwable -> 0x0075 }
            android.content.ComponentName r4 = new android.content.ComponentName     // Catch:{ Throwable -> 0x0075 }
            java.lang.String r5 = r6.k     // Catch:{ Throwable -> 0x0075 }
            r4.<init>(r5, r2)     // Catch:{ Throwable -> 0x0075 }
            r3.setComponent(r4)     // Catch:{ Throwable -> 0x0075 }
            android.content.Context r2 = r6.d     // Catch:{ Throwable -> 0x006b }
            android.content.Intent r3 = r6.j     // Catch:{ Throwable -> 0x006b }
            android.content.ServiceConnection r4 = r6.g     // Catch:{ Throwable -> 0x006b }
            boolean r2 = r2.bindService(r3, r4, r0)     // Catch:{ Throwable -> 0x006b }
            r6.n = r2     // Catch:{ Throwable -> 0x006b }
        L_0x006b:
            boolean r2 = r6.n     // Catch:{ Throwable -> 0x0075 }
            if (r2 == 0) goto L_0x003f
        L_0x006f:
            r6.f()     // Catch:{ Throwable -> 0x0075 }
            r6.d()     // Catch:{ Throwable -> 0x0075 }
        L_0x0075:
            r6.q = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.bv.c():void");
    }

    public final void d() {
        if (!this.r && !this.q) {
            try {
                if (cr.g(this.d)) {
                    List<cu> y = cr.y();
                    if (y != null && y.size() > 0) {
                        for (cu next : y) {
                            if (next != null) {
                                if (next.a()) {
                                    Intent intent = new Intent();
                                    intent.setComponent(new ComponentName(next.b(), next.c()));
                                    if (!TextUtils.isEmpty(next.e())) {
                                        intent.setAction(next.e());
                                    }
                                    List<Map<String, String>> d2 = next.d();
                                    if (d2 != null && d2.size() > 0) {
                                        for (int i2 = 0; i2 < d2.size(); i2++) {
                                            Iterator it = d2.get(i2).entrySet().iterator();
                                            if (it.hasNext()) {
                                                Map.Entry entry = (Map.Entry) it.next();
                                                intent.putExtra(((String) entry.getKey()).toString(), ((String) entry.getValue()).toString());
                                            }
                                        }
                                    }
                                    if (next.f()) {
                                        this.d.startService(intent);
                                    }
                                    if (this.d.bindService(intent, this.i, 1)) {
                                        this.p = true;
                                    }
                                }
                            }
                        }
                    }
                    this.r = true;
                }
            } catch (Throwable th) {
                cs.a(th, "ConnectionServiceManager", "bindOtherService");
            }
        }
    }

    public final AMapLocationServer e() {
        if (!cr.l()) {
            return null;
        }
        c();
        for (int i2 = 4; i2 > 0 && !this.a; i2--) {
            SystemClock.sleep(500);
        }
        if (this.a) {
            AMapLocationServer g2 = g();
            if (g2 != null) {
                return g2;
            }
        }
        return null;
    }
}
