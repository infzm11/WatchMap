package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ExpandableListView;
import com.amap.api.col.n3.fv;
import com.amap.api.col.n3.fx;
import java.util.List;

public class NaviGuideWidget extends ExpandableListView {
    public NaviGuideWidget(Context context) {
        super(context);
    }

    public NaviGuideWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NaviGuideWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void setParams() {
        setDivider((Drawable) null);
        setGroupIndicator((Drawable) null);
    }

    public void setGuideData(String str, String str2, List<fx> list) {
        setParams();
        if (list != null && list.size() > 0) {
            list.size();
            fx fxVar = new fx();
            fxVar.c(-1);
            fxVar.a(str);
            list.add(0, fxVar);
            fx fxVar2 = new fx();
            fxVar2.c(-2);
            fxVar2.a(str2);
            list.add(list.size(), fxVar2);
            setAdapter(new fv(getContext(), list));
        }
    }
}
