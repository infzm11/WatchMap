package com.amap.api.navi;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.col.n3.hq;
import com.amap.api.col.n3.hs;
import com.amap.api.col.n3.iu;
import com.amap.api.navi.model.AMapLaneInfo;
import com.amap.api.navi.model.AMapModelCross;
import com.amap.api.navi.model.AMapNaviCameraInfo;
import com.amap.api.navi.model.AMapNaviCross;
import com.amap.api.navi.model.AMapNaviInfo;
import com.amap.api.navi.model.AMapNaviLocation;
import com.amap.api.navi.model.AMapNaviTrafficFacilityInfo;
import com.amap.api.navi.model.AMapServiceAreaInfo;
import com.amap.api.navi.model.AimLessModeCongestionInfo;
import com.amap.api.navi.model.AimLessModeStat;
import com.amap.api.navi.model.AmapCarLocation;
import com.amap.api.navi.model.InnerNaviInfo;
import com.amap.api.navi.model.NaviInfo;
import com.amap.api.navi.view.AutoNaviHudMirrorImage;
import com.android.hoinnet.highde.R;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.autonavi.tbt.TrafficFacilityInfo;

public class AMapHudView extends FrameLayout implements View.OnClickListener, View.OnTouchListener, MyNaviListener {
    private static final long delayMillis = 2000;
    static final int[] hud_imgActions = {2130837601, 2130837601, 2130837601, 2130837602, 2130837603, 2130837604, 2130837605, 2130837606, 2130837607, 2130837608, 2130837591, 2130837592, 2130837593, 2130837594, 2130837595, 2130837596, 2130837597, 2130837598, 2130837599, 2130837600};
    AMapHudViewListener aMapHudVewListener;
    /* access modifiers changed from: private */
    public AutoNaviHudMirrorImage autonaviHudMirrorImage;
    /* access modifiers changed from: private */
    public Handler disappearHudHandler = new Handler();
    /* access modifiers changed from: private */
    public Runnable disappearHudTitleRunnable = new Runnable() {
        public final void run() {
            try {
                AMapHudView.this.loadHideHudTitleAnimation();
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "AMapHudView", "disappearHudTitleRunnable");
            }
        }
    };
    private String distanceTimeTextStr;
    private View frameLayout;
    /* access modifiers changed from: private */
    public int hudMode = 1;
    private boolean isHudMenu = true;
    boolean isLandscape = false;
    private TextView limitSpeedTextView;
    private INavi mAMapNavi;
    private int mHeight = GLMapStaticValue.ANIMATION_FLUENT_TIME;
    /* access modifiers changed from: private */
    public View mHudMirrorTitle;
    private CheckBox mMirrorModeCheckBox;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            try {
                if (AMapHudView.this.autonaviHudMirrorImage != null) {
                    if (z) {
                        int unused = AMapHudView.this.hudMode = 2;
                    } else {
                        int unused2 = AMapHudView.this.hudMode = 1;
                    }
                    AMapHudView.this.setCheckBoxAndMirrorImageState(z);
                    AMapHudView.this.removeCallbacks();
                    AMapHudView.this.disappearHudHandler.postDelayed(AMapHudView.this.disappearHudTitleRunnable, AMapHudView.delayMillis);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "AMapHudView", "mOnCheckedChangeListener");
            }
        }
    };
    private int mWidth = 480;
    private SpannableString nextRoadDisTextSpannableStr = null;
    private TextView nextRoadDistanceText;
    private TextView nextRoadNameText;
    private String nextRoadNameTextStr;
    private int resId;
    private TextView restDistanceText;
    private String restDistanceTextStr;
    private TextView restDistanceTime;
    private ImageView roadsignimg;
    private View title_btn_goback;

    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo aMapNaviTrafficFacilityInfo) {
    }

    public void OnUpdateTrafficFacility(TrafficFacilityInfo trafficFacilityInfo) {
    }

    public void OnUpdateTrafficFacility(AMapNaviTrafficFacilityInfo[] aMapNaviTrafficFacilityInfoArr) {
    }

    public void carProjectionChange(AmapCarLocation amapCarLocation) {
    }

    public void hideCross() {
    }

    public void hideLaneInfo() {
    }

    public void hideModeCross() {
    }

    public void notifyParallelRoad(int i) {
    }

    public void onArriveDestination() {
    }

    public void onArrivedWayPoint(int i) {
    }

    public void onCalculateRouteFailure(int i) {
    }

    public void onCalculateRouteSuccess(int[] iArr) {
    }

    public final void onCreate(Bundle bundle) {
    }

    public void onEndEmulatorNavi() {
    }

    public void onGetNavigationText(int i, String str) {
    }

    public void onGetNavigationText(String str) {
    }

    public void onGpsOpenStatus(boolean z) {
    }

    public void onInitNaviFailure() {
    }

    public void onInitNaviSuccess() {
    }

    public void onInnerNaviInfoUpdate(InnerNaviInfo innerNaviInfo) {
    }

    public void onLocationChange(AMapNaviLocation aMapNaviLocation) {
    }

    public void onNaviInfoUpdated(AMapNaviInfo aMapNaviInfo) {
    }

    public final void onPause() {
    }

    public void onPlayRing(int i) {
    }

    public void onReCalculateRouteForTrafficJam() {
    }

    public void onReCalculateRouteForYaw() {
    }

    public final void onResume() {
    }

    public final void onSaveInstanceState(Bundle bundle) {
    }

    public void onServiceAreaUpdate(AMapServiceAreaInfo[] aMapServiceAreaInfoArr) {
    }

    public void onStartNavi(int i) {
    }

    public void onTrafficStatusUpdate() {
    }

    public void showCross(AMapNaviCross aMapNaviCross) {
    }

    public void showLaneInfo(AMapLaneInfo[] aMapLaneInfoArr, byte[] bArr, byte[] bArr2) {
    }

    public void showModeCross(AMapModelCross aMapModelCross) {
    }

    public void updateAimlessModeCongestionInfo(AimLessModeCongestionInfo aimLessModeCongestionInfo) {
    }

    public void updateAimlessModeStatistics(AimLessModeStat aimLessModeStat) {
    }

    public void updateCameraInfo(AMapNaviCameraInfo[] aMapNaviCameraInfoArr) {
    }

    public AMapHudView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "AMapHudView(Context context, AttributeSet attrs, int defStyle) ");
        }
    }

    public AMapHudView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            init(context);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "AMapHudView(Context context, AttributeSet attrs) ");
        }
    }

    public AMapHudView(Context context) {
        super(context);
        init(context);
    }

    public int getHudViewMode() {
        return this.hudMode;
    }

    public void setHudViewMode(int i) {
        try {
            this.hudMode = i;
            setCheckBoxAndMirrorImageState(this.hudMode == 2);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "setHudViewMode(int mode)");
        }
    }

    public boolean getHudMenuEnabled() {
        return this.isHudMenu;
    }

    public void setHudMenuEnabled(Boolean bool) {
        this.isHudMenu = bool.booleanValue();
    }

    public final void onDestroy() {
        try {
            if (this.autonaviHudMirrorImage != null) {
                this.autonaviHudMirrorImage.recycleMirrorBitmap();
            }
            this.aMapHudVewListener = null;
            if (this.disappearHudHandler != null) {
                this.disappearHudHandler.removeCallbacksAndMessages((Object) null);
                this.disappearHudHandler = null;
            }
            this.mAMapNavi.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onDestroy()");
        }
    }

    public void setHudViewListener(AMapHudViewListener aMapHudViewListener) {
        this.aMapHudVewListener = aMapHudViewListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002a A[Catch:{ Throwable -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038 A[Catch:{ Throwable -> 0x005e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void init(android.content.Context r3) {
        /*
            r2 = this;
            com.amap.api.navi.AMapNavi r3 = com.amap.api.navi.AMapNavi.getInstance(r3)     // Catch:{ Throwable -> 0x005e }
            r2.mAMapNavi = r3     // Catch:{ Throwable -> 0x005e }
            android.content.Context r3 = r2.getContext()     // Catch:{ Throwable -> 0x005e }
            android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Throwable -> 0x005e }
            int r3 = r3.getRequestedOrientation()     // Catch:{ Throwable -> 0x005e }
            if (r3 == 0) goto L_0x0022
            android.content.res.Resources r3 = r2.getResources()     // Catch:{ Throwable -> 0x005e }
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch:{ Throwable -> 0x005e }
            int r3 = r3.orientation     // Catch:{ Throwable -> 0x005e }
            r0 = 2
            if (r3 != r0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            r2.isLandscape = r3     // Catch:{ Throwable -> 0x005e }
            boolean r3 = r2.isLandscape     // Catch:{ Throwable -> 0x005e }
            r0 = 0
            if (r3 == 0) goto L_0x0038
            android.content.Context r3 = r2.getContext()     // Catch:{ Throwable -> 0x005e }
            r1 = 2130903041(0x7f030001, float:1.7412889E38)
            android.view.View r3 = com.amap.api.col.n3.hs.a(r3, r1, r0)     // Catch:{ Throwable -> 0x005e }
            r2.frameLayout = r3     // Catch:{ Throwable -> 0x005e }
            goto L_0x0044
        L_0x0038:
            android.content.Context r3 = r2.getContext()     // Catch:{ Throwable -> 0x005e }
            r1 = 2130903040(0x7f030000, float:1.7412887E38)
            android.view.View r3 = com.amap.api.col.n3.hs.a(r3, r1, r0)     // Catch:{ Throwable -> 0x005e }
            r2.frameLayout = r3     // Catch:{ Throwable -> 0x005e }
        L_0x0044:
            android.view.View r3 = r2.frameLayout     // Catch:{ Throwable -> 0x005e }
            r2.addView(r3)     // Catch:{ Throwable -> 0x005e }
            r2.initResolution()     // Catch:{ Throwable -> 0x005e }
            r2.initWidget()     // Catch:{ Throwable -> 0x005e }
            com.amap.api.navi.INavi r3 = r2.mAMapNavi     // Catch:{ Throwable -> 0x005e }
            r3.addAMapNaviListener(r2)     // Catch:{ Throwable -> 0x005e }
            com.amap.api.navi.INavi r3 = r2.mAMapNavi     // Catch:{ Throwable -> 0x005e }
            com.amap.api.navi.model.NaviInfo r3 = r3.getNaviInfo()     // Catch:{ Throwable -> 0x005e }
            r2.onNaviInfoUpdate(r3)     // Catch:{ Throwable -> 0x005e }
            return
        L_0x005e:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r0 = "AMapHudView"
            java.lang.String r1 = "init(Context context)"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r3, (java.lang.String) r0, (java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.AMapHudView.init(android.content.Context):void");
    }

    private void initResolution() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.mWidth = displayMetrics.widthPixels;
        this.mHeight = displayMetrics.heightPixels;
    }

    public boolean onTouchHudMirrorEvent(MotionEvent motionEvent) {
        try {
            if (!this.isHudMenu) {
                return true;
            }
            loadShowHudTitleAnimation();
            removeCallbacks();
            this.disappearHudHandler.postDelayed(this.disappearHudTitleRunnable, delayMillis);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onTouchHudMirrorEvent(MotionEvent event)");
            return true;
        }
    }

    private void loadShowHudTitleAnimation() {
        if (this.mHudMirrorTitle != null && this.mHudMirrorTitle.getVisibility() == 8) {
            Animation a = hs.a(getContext(), R.bool.abc_action_bar_embed_tabs);
            this.mHudMirrorTitle.setVisibility(0);
            this.mHudMirrorTitle.startAnimation(a);
        }
    }

    private void initWidget() {
        this.mHudMirrorTitle = this.frameLayout.findViewById(2131296267);
        this.autonaviHudMirrorImage = (AutoNaviHudMirrorImage) this.frameLayout.findViewById(R.integer.design_snackbar_text_max_lines);
        this.mMirrorModeCheckBox = (CheckBox) this.frameLayout.findViewById(2131296269);
        this.nextRoadNameText = (TextView) this.frameLayout.findViewById(R.integer.status_bar_notification_info_maxnum);
        this.restDistanceText = (TextView) this.frameLayout.findViewById(2131296264);
        this.roadsignimg = (ImageView) this.frameLayout.findViewById(2131296262);
        this.nextRoadDistanceText = (TextView) this.frameLayout.findViewById(2131296263);
        this.title_btn_goback = this.frameLayout.findViewById(2131296268);
        this.restDistanceTime = (TextView) this.frameLayout.findViewById(2131296265);
        this.limitSpeedTextView = (TextView) this.frameLayout.findViewById(2131296266);
        getScreenInfo();
        setWidgetListener();
        updateHudWidgetContent();
    }

    private void getScreenInfo() {
        if (this.autonaviHudMirrorImage != null) {
            this.autonaviHudMirrorImage.mWidth = this.mWidth;
            this.autonaviHudMirrorImage.mHeight = this.mHeight - 50;
        }
    }

    private void updateHudWidgetContent() {
        if (this.nextRoadNameText != null) {
            this.nextRoadNameText.setText(this.nextRoadNameTextStr);
        }
        if (this.nextRoadDistanceText != null) {
            this.nextRoadDistanceText.setText(this.nextRoadDisTextSpannableStr);
        }
        if (this.restDistanceText != null) {
            this.restDistanceText.setText(this.restDistanceTextStr);
        }
        if (this.restDistanceTime != null) {
            this.restDistanceTime.setText(this.distanceTimeTextStr);
        }
        if (this.roadsignimg != null && this.resId != 0 && this.resId != 1) {
            this.roadsignimg.setBackgroundDrawable(hs.a().getDrawable(hud_imgActions[this.resId]));
            if (this.autonaviHudMirrorImage != null) {
                this.autonaviHudMirrorImage.invalidate();
                this.autonaviHudMirrorImage.postInvalidate();
            }
        }
    }

    private void setWidgetListener() {
        if (this.autonaviHudMirrorImage != null) {
            this.autonaviHudMirrorImage.setAMapHudView(this);
            setOnTouchListener(this);
        }
        if (this.mMirrorModeCheckBox != null) {
            this.mMirrorModeCheckBox.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
        }
        if (this.title_btn_goback != null) {
            this.title_btn_goback.setOnClickListener(this);
        }
    }

    /* access modifiers changed from: private */
    public void removeCallbacks() {
        if (this.disappearHudHandler != null && this.disappearHudTitleRunnable != null) {
            this.disappearHudHandler.removeCallbacks(this.disappearHudTitleRunnable);
        }
    }

    /* access modifiers changed from: private */
    public void setCheckBoxAndMirrorImageState(boolean z) {
        if (this.mMirrorModeCheckBox != null) {
            this.mMirrorModeCheckBox.setChecked(z);
        }
        if (this.autonaviHudMirrorImage != null) {
            this.autonaviHudMirrorImage.setMirrorState(z);
            this.autonaviHudMirrorImage.invalidate();
            this.autonaviHudMirrorImage.postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public void loadHideHudTitleAnimation() {
        if (this.mHudMirrorTitle != null && this.mHudMirrorTitle.getVisibility() == 0) {
            Animation a = hs.a(getContext(), R.bool.abc_allow_stacked_button_bar);
            a.setAnimationListener(new Animation.AnimationListener() {
                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    AMapHudView.this.mHudMirrorTitle.setVisibility(8);
                }
            });
            this.mHudMirrorTitle.startAnimation(a);
        }
    }

    private boolean isHudMirror() {
        return this.hudMode == 2;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        try {
            if (this.autonaviHudMirrorImage != null) {
                this.autonaviHudMirrorImage.recycleMirrorBitmap();
                this.autonaviHudMirrorImage = null;
            }
            removeAllViews();
            if (getResources().getConfiguration().orientation == 2) {
                this.frameLayout = hs.a(getContext(), R.attr.actionBarItemBackground, (ViewGroup) null);
            } else {
                this.frameLayout = hs.a(getContext(), R.attr.actionBarDivider, (ViewGroup) null);
            }
            addView(this.frameLayout);
            initResolution();
            initWidget();
            getScreenInfo();
            onNaviInfoUpdate(this.mAMapNavi.getNaviInfo());
            setCheckBoxAndMirrorImageState(isHudMirror());
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onConfigurationChanged(Configuration newConfig)");
        }
        super.onConfigurationChanged(configuration);
    }

    private void updateHudUI(NaviInfo naviInfo) {
        if (naviInfo != null) {
            try {
                this.nextRoadNameTextStr = naviInfo.m_NextRoadName;
                this.restDistanceTextStr = hq.a(naviInfo.getPathRetainDistance());
                this.nextRoadDisTextSpannableStr = switchStrFromMeter(naviInfo.m_SegRemainDis);
                this.resId = naviInfo.m_Icon;
                this.distanceTimeTextStr = hq.b(naviInfo.m_RouteRemainTime);
                if (this.mAMapNavi.getNaviSetting().isMonitorCameraEnabled() && this.mAMapNavi.getEngineType() == 0 && naviInfo.getCameraDistance() > 0 && this.limitSpeedTextView != null && naviInfo.m_CameraSpeed > 0) {
                    TextView textView = this.limitSpeedTextView;
                    textView.setText(naviInfo.m_CameraSpeed);
                    this.limitSpeedTextView.setVisibility(0);
                } else if (naviInfo.m_CameraSpeed == 0 && this.limitSpeedTextView != null) {
                    this.limitSpeedTextView.setVisibility(8);
                }
                updateHudWidgetContent();
            } catch (Throwable th) {
                th.printStackTrace();
                iu.b(th, "AMapHudView", "updateHudUI(NaviInfo naviInfo)");
            }
        }
    }

    private SpannableString switchStrFromMeter(int i) {
        if (i >= 1000) {
            Context context = getContext();
            return getSpanableString(context, (((float) Math.round((((float) i) / 1000.0f) * 10.0f)) / 10.0f), "公里");
        }
        Context context2 = getContext();
        return getSpanableString(context2, i, "米");
    }

    private SpannableString getSpanableString(Context context, String str, String str2) {
        SpannableString spannableString = new SpannableString(str + str2);
        int b = hq.b(context, 60);
        int b2 = hq.b(context, 30);
        int length = str.length();
        spannableString.setSpan(new AbsoluteSizeSpan(b), 0, length, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, length, 33);
        int length2 = str2.length() + length;
        spannableString.setSpan(new AbsoluteSizeSpan(b2), length, length2, 33);
        spannableString.setSpan(new ForegroundColorSpan(-1), length, length2, 33);
        return spannableString;
    }

    public void onClick(View view) {
        try {
            if (this.title_btn_goback == view && this.aMapHudVewListener != null) {
                this.aMapHudVewListener.onHudViewCancel();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onClick(View v)");
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            onTouchHudMirrorEvent(motionEvent);
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onTouch(View arg0, MotionEvent arg1)");
            return false;
        }
    }

    public void onNaviInfoUpdate(NaviInfo naviInfo) {
        try {
            updateHudUI(naviInfo);
        } catch (Throwable th) {
            th.printStackTrace();
            iu.b(th, "AMapHudView", "onNaviInfoUpdate(NaviInfo naviinfo)");
        }
    }
}
