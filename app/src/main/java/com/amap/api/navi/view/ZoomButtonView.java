package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.amap.api.col.n3.hs;
import com.android.hoinnet.highde.R;

public class ZoomButtonView extends LinearLayout {
    private ImageButton zoomInBtn;
    private ImageButton zoomOutBtn;

    public ZoomButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public ZoomButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ZoomButtonView(Context context) {
        super(context);
        init();
    }

    public ImageButton getZoomOutBtn() {
        return this.zoomOutBtn;
    }

    public ImageButton getZoomInBtn() {
        return this.zoomInBtn;
    }

    private void init() {
        try {
            View a = hs.a(getContext(), R.attr.actionBarSplitStyle, (ViewGroup) null);
            addView(a);
            this.zoomOutBtn = (ImageButton) a.findViewById(2131296303);
            this.zoomInBtn = (ImageButton) a.findViewById(2131296302);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
