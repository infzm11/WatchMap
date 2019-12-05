package com.amap.api.navi.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.col.n3.hs;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.view.PoiInputSearchWidget;
import com.android.hoinnet.highde.R;

public class PoiInputItemWidget extends RelativeLayout implements View.OnClickListener {
    public static final int SWITCH_ANIMATION_DOWN = 1;
    public static final int SWITCH_ANIMATION_UP = 0;
    public static final int TYPE_DEST = 1;
    public static final int TYPE_MIDDLE = 2;
    public static final int TYPE_START = 0;
    private int animDuration = PoiInputSearchWidget.DEF_ANIMATION_DURATION;
    private Callback mCallback;
    private ImageView mDeleteIV;
    private Poi mPoi;
    private TextView mPoiTV;
    private int mType;
    private TextView mTypeTV;

    public interface Callback {
        void onAddMid();

        void onBack();

        void onClick(PoiInputItemWidget poiInputItemWidget);

        void onDelete(PoiInputItemWidget poiInputItemWidget);
    }

    private String getHintStr(int i) {
        return i == 0 ? "请输入起点" : "请输入终点";
    }

    public PoiInputItemWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputItemWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputItemWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private void init() {
        hs.a(getContext(), R.attr.actionModeFindDrawable, this);
        setBackgroundDrawable(hs.a().getDrawable(2130837729));
        this.mTypeTV = (TextView) findViewById(2131296444);
        this.mDeleteIV = (ImageView) findViewById(2131296445);
        this.mPoiTV = (TextView) findViewById(2131296446);
        this.mTypeTV.setOnClickListener(this);
        this.mPoiTV.setOnClickListener(this);
        this.mDeleteIV.setOnClickListener(this);
    }

    public void initUI(int i, Poi poi) {
        this.mType = i;
        this.mPoi = poi;
        if (this.mTypeTV != null && this.mPoiTV != null) {
            setType(i);
            setPoi(i, poi);
        }
    }

    public void setPoi(int i, Poi poi) {
        this.mPoi = poi;
        this.mType = i;
        if (i == 2) {
            setPoiForMid(poi);
        } else if (poi == null || TextUtils.isEmpty(poi.getName())) {
            this.mPoiTV.setText(getHintStr(i));
            this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_dark));
        } else {
            this.mPoiTV.setText(poi.getName());
            this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_light));
        }
    }

    public void setPoi(Poi poi) {
        setPoi(this.mType, poi);
    }

    public void setPos(int i) {
        if (this.mType != 2 || this.mPoi != null) {
            return;
        }
        if (i > 0) {
            TextView textView = this.mPoiTV;
            textView.setText(hs.a().getString(R.drawable.abc_btn_switch_to_on_mtrl_00012) + i);
            return;
        }
        this.mPoiTV.setText(hs.a().getString(R.drawable.abc_btn_switch_to_on_mtrl_00012));
    }

    private void setType(int i) {
        if (i == 2) {
            this.mDeleteIV.setVisibility(0);
            this.mTypeTV.setVisibility(8);
            return;
        }
        this.mDeleteIV.setVisibility(8);
        this.mTypeTV.setVisibility(0);
        this.mTypeTV.setText(getTypeStr(i));
    }

    public int getType() {
        return this.mType;
    }

    public Poi getPoi() {
        return this.mPoi;
    }

    private void setPoiForMid(Poi poi) {
        if (poi == null) {
            this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_dark));
            this.mPoiTV.setText(R.drawable.abc_btn_switch_to_on_mtrl_00012);
            return;
        }
        this.mPoiTV.setTextColor(hs.a().getColor(R.color.accent_material_light));
        this.mPoiTV.setText(poi.getName());
    }

    private String getTypeStr(int i) {
        switch (i) {
            case 0:
                return hs.a().getString(R.drawable.abc_btn_radio_to_on_mtrl_000);
            case 1:
                return hs.a().getString(R.drawable.abc_btn_radio_to_on_mtrl_015);
            default:
                return "";
        }
    }

    public void onClick(View view) {
        try {
            switch (view.getId()) {
                case 2131296444:
                case 2131296446:
                    if (this.mCallback != null) {
                        this.mCallback.onClick(this);
                        return;
                    }
                    return;
                case 2131296445:
                    if (this.mCallback != null) {
                        this.mCallback.onDelete(this);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void switchAnim(int i, final Runnable runnable) {
        final TextView textView = this.mPoiTV;
        switch (i) {
            case 0:
                mid2Up(textView, new PoiInputSearchWidget.AnimationListenerAdapter() {
                    public final void onAnimationEnd(Animation animation) {
                        PoiInputItemWidget.this.post(runnable);
                        PoiInputItemWidget.this.up2Mid(textView, (PoiInputSearchWidget.AnimationListenerAdapter) null);
                    }
                });
                return;
            case 1:
                mid2Down(textView, new PoiInputSearchWidget.AnimationListenerAdapter() {
                    public final void onAnimationEnd(Animation animation) {
                        PoiInputItemWidget.this.post(runnable);
                        PoiInputItemWidget.this.down2Mid(textView, (PoiInputSearchWidget.AnimationListenerAdapter) null);
                    }
                });
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void down2Mid(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getHeight(), 0.0f);
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    private void mid2Up(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (-getHeight()));
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    /* access modifiers changed from: private */
    public void up2Mid(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (-getHeight()), 0.0f);
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }

    private void mid2Down(View view, PoiInputSearchWidget.AnimationListenerAdapter animationListenerAdapter) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) getHeight());
        translateAnimation.setDuration((long) this.animDuration);
        translateAnimation.setAnimationListener(animationListenerAdapter);
        view.startAnimation(translateAnimation);
    }
}
