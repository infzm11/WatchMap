package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.n3.hs;
import com.android.hoinnet.highde.R;

public class LoadingView extends RelativeLayout {
    private ImageView imageView;
    private RelativeLayout loadingLayout;
    private RelativeLayout refreshLayout;
    private TextView refreshText;
    private Animation rotation;
    private boolean showing = false;

    public LoadingView(Context context) {
        super(context);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        View a = hs.a(getContext(), R.attr.actionBarWidgetTheme, (ViewGroup) null);
        addView(a);
        this.imageView = (ImageView) a.findViewById(2131296330);
        this.loadingLayout = (RelativeLayout) a.findViewById(2131296329);
        this.refreshLayout = (RelativeLayout) a.findViewById(2131296332);
        this.refreshText = (TextView) a.findViewById(2131296334);
    }

    public void showLoading() {
        try {
            this.refreshLayout.setVisibility(8);
            this.loadingLayout.setVisibility(0);
            if (this.rotation == null) {
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
                this.rotation = rotateAnimation;
            }
            this.rotation.setRepeatCount(-1);
            this.rotation.setInterpolator(new LinearInterpolator());
            this.rotation.setDuration(2000);
            this.rotation.setRepeatCount(-1);
            this.imageView.startAnimation(this.rotation);
            this.showing = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showFailed(String str, View.OnClickListener onClickListener) {
        try {
            this.loadingLayout.setVisibility(8);
            this.refreshLayout.setVisibility(0);
            this.refreshLayout.setOnClickListener(onClickListener);
            this.refreshText.setText(str);
            this.showing = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hideLoading() {
        try {
            this.loadingLayout.setVisibility(8);
            this.refreshLayout.setVisibility(8);
            if (this.rotation != null) {
                this.rotation.cancel();
            }
            this.showing = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isShowing() {
        return this.showing;
    }
}
