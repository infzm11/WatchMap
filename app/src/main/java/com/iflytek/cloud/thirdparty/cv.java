package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iflytek.cloud.thirdparty.cu;

public class cv extends LinearLayout {
    private cu.a a = null;
    protected boolean b = true;
    protected boolean c = true;

    public cv(Context context) {
        super(context);
    }

    protected static boolean a(ViewGroup viewGroup) {
        try {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                childAt.setOnClickListener((View.OnClickListener) null);
                childAt.setBackgroundDrawable((Drawable) null);
            }
            viewGroup.removeAllViews();
            viewGroup.setOnClickListener((View.OnClickListener) null);
            viewGroup.setBackgroundDrawable((Drawable) null);
            return true;
        } catch (Exception e) {
            cb.a((Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        try {
            a(this);
            return true;
        } catch (Exception e) {
            cb.a((Throwable) e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void e() {
        Intent intent = new Intent();
        intent.setAction(Build.VERSION.SDK_INT > 10 ? "android.settings.SETTINGS" : "android.settings.WIRELESS_SETTINGS");
        intent.addFlags(268435456);
        getContext().startActivity(intent);
    }

    public void f() {
        if (this.a != null) {
            this.a.a();
        }
    }

    public void setExitCallBack(cu.a aVar) {
        this.a = aVar;
    }
}
