package com.amap.api.col.n3;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.amap.api.navi.model.InnerNaviInfo;

/* compiled from: BaseNaviInfoLayout */
public abstract class hi extends RelativeLayout {
    protected int[] a = {2130837549, 2130837549, 2130837669, 2130837670, 2130837671, 2130837672, 2130837673, 2130837674, 2130837675, 2130837676, 2130837662, 2130837663, 2130837664, 2130837665, 2130837666, 2130837667, 2130837668};

    public Button a() {
        return null;
    }

    public void a(int i) {
    }

    public abstract void a(InnerNaviInfo innerNaviInfo);

    public abstract void a(boolean z);

    public abstract void b();

    public void b(boolean z) {
    }

    public abstract void c(boolean z);

    public hi(Context context) {
        super(context, (AttributeSet) null);
    }
}
