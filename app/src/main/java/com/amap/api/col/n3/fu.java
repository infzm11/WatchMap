package com.amap.api.col.n3;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.navi.AmapRouteActivity;
import com.amap.api.services.district.DistrictSearchQuery;
import com.iflytek.aiui.AIUIConstant;

/* compiled from: ServiceModule */
public abstract class fu {
    protected final String a = DistrictSearchQuery.KEYWORDS_CITY;
    protected final String b = "hint";
    protected final String c = AIUIConstant.KEY_CONTENT;
    protected final String d = "input_type";
    protected final String e = "input_type_mid";
    protected final String f = "from";
    protected final String g = "needRecalculate";
    protected final String h = "navi_type";
    protected AmapRouteActivity i = null;

    public abstract void a(View view);

    public boolean a() {
        return true;
    }

    public abstract RelativeLayout d();

    public abstract void e();

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public final void a(AmapRouteActivity amapRouteActivity) {
        this.i = amapRouteActivity;
    }

    public void a(Bundle bundle) {
        this.i.showScr();
    }

    public final void b() {
        this.i.showLoadingDialog();
    }

    public final void c() {
        this.i.removeLoadingDialog();
    }

    public final int a(float f2) {
        return this.i != null ? (int) ((f2 * (((float) this.i.getResources().getDisplayMetrics().densityDpi) / 160.0f)) + 0.5f) : (int) f2;
    }
}
