package com.amap.api.col.n3;

import android.content.Context;
import org.json.JSONObject;

/* compiled from: BaseTask */
public class fj extends kt {
    protected static int a = 30000;
    protected static int b = 30000;
    protected String c;
    protected int d;
    protected String e;
    protected int f;
    protected int g;
    protected byte[] h;
    protected ki i;
    protected Context j;
    protected String k;
    protected im l;
    protected String m;
    protected String n;
    protected String o;
    protected String p;

    public void a() {
    }

    public fj(Context context, String str, int i2, String str2, int i3, int i4, byte[] bArr) {
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.l = hq.a();
        this.k = ig.b(context);
        this.c = str;
        this.d = i2;
        this.e = str2;
        this.f = i3;
        this.g = i4;
        this.h = bArr;
        this.i = ki.c();
        this.j = context;
        if (i3 == 1) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr, "UTF-8"));
                if (jSONObject.has("start")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("start");
                    this.m = jSONObject2.getString("x");
                    this.n = jSONObject2.getString("y");
                }
                if (jSONObject.has("end")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("end");
                    this.o = jSONObject3.getString("x");
                    this.p = jSONObject3.getString("y");
                }
                "bytes:" + r3;
                "bytes:iModuleID=" + i3 + ",iConnectID=" + i4;
                "坐标:start_x=" + this.m + ",start_y=" + this.n + ",end_x=" + this.o + ",end_y=" + this.p;
            } catch (Throwable th) {
                th.printStackTrace();
                "坐标位置解析错误:" + th.getMessage();
            }
        }
    }

    public static void a(int i2) {
        a = i2;
    }

    public static void b(int i2) {
        b = i2;
    }
}
