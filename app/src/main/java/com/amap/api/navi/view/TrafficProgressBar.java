package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.amap.api.col.n3.hs;
import com.amap.api.navi.model.AMapTrafficStatus;
import com.android.hoinnet.highde.R;
import java.util.List;

public class TrafficProgressBar extends RelativeLayout {
    private ImageView mDefaultTmcBarCarView;
    private TmcBarView mDefaultTmcBarView;

    public TrafficProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TrafficProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private void init() {
        try {
            View a = hs.a(getContext(), R.attr.actionBarSize, (ViewGroup) null);
            addView(a);
            this.mDefaultTmcBarView = (TmcBarView) a.findViewById(2131296299);
            this.mDefaultTmcBarCarView = (ImageView) a.findViewById(2131296301);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void update(int i, int i2, List<AMapTrafficStatus> list) {
        try {
            this.mDefaultTmcBarView.setData(list, i);
            this.mDefaultTmcBarView.setCarView(this.mDefaultTmcBarCarView);
            if (this.mDefaultTmcBarView.getHeight() > 0) {
                this.mDefaultTmcBarView.setCursorPos(i2);
                this.mDefaultTmcBarView.invalidate();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setUnknownTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setUnknownTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSmoothTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setSmoothTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setSlowTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setSlowTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setJamTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setJamTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setVeryJamTrafficColor(int i) {
        try {
            if (this.mDefaultTmcBarView != null) {
                this.mDefaultTmcBarView.setVeryJamTrafficColor(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
