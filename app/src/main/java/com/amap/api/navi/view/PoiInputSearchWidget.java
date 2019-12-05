package com.amap.api.navi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.col.n3.hs;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.view.PoiInputItemWidget;
import com.android.hoinnet.highde.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class PoiInputSearchWidget extends RelativeLayout implements View.OnClickListener {
    public static final int DEF_ANIMATION_DURATION = 150;
    private int INPUT_WIDGET_MARGIN_TOP = 30;
    /* access modifiers changed from: private */
    public AtomicBoolean isInAnim = new AtomicBoolean(false);
    private AtomicBoolean isInCalRoute = new AtomicBoolean(false);
    private View mAddBtn;
    private View mBackBtn;
    /* access modifiers changed from: private */
    public Callback mCallback;
    private PoiInputItemWidget mDestInputWidget;
    private Poi mDestPoi;
    private View mFinishChooseMidBtn;
    private PoiInputItemWidget.Callback mInputItemCallback = new PoiInputItemWidget.Callback() {
        public final void onClick(PoiInputItemWidget poiInputItemWidget) {
            try {
                if (PoiInputSearchWidget.this.mCallback != null) {
                    int i = -1;
                    if (poiInputItemWidget.getType() == 2) {
                        i = PoiInputSearchWidget.this.mMidInputWidgets.indexOf(poiInputItemWidget);
                    }
                    PoiInputSearchWidget.this.mCallback.onClick(poiInputItemWidget.getType(), i, poiInputItemWidget.getPoi());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final void onDelete(PoiInputItemWidget poiInputItemWidget) {
            if (!PoiInputSearchWidget.this.isInAnim.get()) {
                int indexOf = PoiInputSearchWidget.this.mMidInputWidgets.indexOf(poiInputItemWidget);
                if (indexOf >= 0) {
                    if (PoiInputSearchWidget.this.mCallback != null) {
                        PoiInputSearchWidget.this.mCallback.onDelete(indexOf, (Poi) PoiInputSearchWidget.this.mMidPois.get(indexOf));
                    }
                    PoiInputSearchWidget.this.mMidPois.remove(indexOf);
                    PoiInputSearchWidget.this.applyRemoveAnim((PoiInputItemWidget) PoiInputSearchWidget.this.mMidInputWidgets.get(indexOf), indexOf);
                    PoiInputSearchWidget.this.mMidInputWidgets.remove(indexOf);
                    PoiInputSearchWidget.this.checkMidInputHintPosAndAddBtn();
                }
            }
        }

        public final void onBack() {
            if (PoiInputSearchWidget.this.mCallback != null) {
                PoiInputSearchWidget.this.mCallback.onBack();
            }
        }

        public final void onAddMid() {
            if (!PoiInputSearchWidget.this.isInAnim.get()) {
                PoiInputSearchWidget.this.appendMidInputWidget((Poi) null, true);
            }
        }
    };
    private AtomicBoolean mIsChooseMid = new AtomicBoolean(false);
    private int mMaxMidNum = 3;
    /* access modifiers changed from: private */
    public ArrayList<PoiInputItemWidget> mMidInputWidgets = new ArrayList<>();
    /* access modifiers changed from: private */
    public LinearLayout mMidItemWidgetGroup;
    /* access modifiers changed from: private */
    public ArrayList<Poi> mMidPois = new ArrayList<>();
    private PoiInputResWidget mPoiInputResWidget;
    private PoiInputItemWidget mStartInputWidget;
    private Poi mStartPoi;
    private View mSwitchBtn;

    public static class AnimationListenerAdapter implements Animation.AnimationListener {
        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public interface Callback {
        void onBack();

        void onClick(int i, int i2, Poi poi);

        void onDelete(int i, Poi poi);

        void onFinishChooseMid();

        void onStartChooseMid();

        void onSwitch();

        void onSwitchFail();
    }

    public PoiInputSearchWidget(Context context) {
        super(context);
        init();
    }

    public PoiInputSearchWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public PoiInputSearchWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        hs.a(getContext(), R.attr.actionModePopupWindowStyle, this);
        this.mStartInputWidget = (PoiInputItemWidget) findViewById(2131296449);
        this.mDestInputWidget = (PoiInputItemWidget) findViewById(2131296452);
        this.mMidItemWidgetGroup = (LinearLayout) findViewById(2131296451);
        this.mFinishChooseMidBtn = findViewById(2131296455);
        this.mPoiInputResWidget = (PoiInputResWidget) findViewById(2131296450);
        this.mBackBtn = findViewById(2131296431);
        this.mAddBtn = findViewById(2131296454);
        this.mSwitchBtn = findViewById(2131296453);
        this.mBackBtn.setOnClickListener(this);
        this.mAddBtn.setOnClickListener(this);
        this.mSwitchBtn.setOnClickListener(this);
        this.mFinishChooseMidBtn.setOnClickListener(this);
        this.mPoiInputResWidget.setOnClickListener(this);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public boolean isFinishBtnVisible() {
        return this.mFinishChooseMidBtn.getVisibility() == 0;
    }

    public void initUI(Poi poi, Poi poi2, List<Poi> list, int i) {
        this.mStartPoi = poi;
        this.mDestPoi = poi2;
        this.mStartInputWidget.initUI(0, this.mStartPoi);
        this.mDestInputWidget.initUI(1, this.mDestPoi);
        this.mStartInputWidget.setCallback(this.mInputItemCallback);
        this.mDestInputWidget.setCallback(this.mInputItemCallback);
        int i2 = 0;
        while (list != null && i2 < list.size()) {
            appendMidInputWidget(list.get(i2), false);
            i2++;
        }
        checkIsToShowChooseRes();
        this.mMaxMidNum = i;
    }

    public void setPoi(int i, int i2, Poi poi) {
        PoiInputItemWidget findInputItemWidget = findInputItemWidget(i, i2);
        if (findInputItemWidget != null) {
            findInputItemWidget.setPoi(poi);
            if (i == 0) {
                this.mStartPoi = poi;
            } else if (i == 1) {
                this.mDestPoi = poi;
            } else {
                this.mMidPois.set(i2, poi);
            }
        }
    }

    public void isInRouteCal(boolean z) {
        this.isInCalRoute.set(z);
    }

    public boolean isAllInputItemsFilled() {
        if (this.mStartPoi == null || this.mDestPoi == null) {
            return false;
        }
        Iterator<Poi> it = this.mMidPois.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return false;
            }
        }
        return true;
    }

    private PoiInputItemWidget findInputItemWidget(int i, int i2) {
        switch (i) {
            case 0:
                return this.mStartInputWidget;
            case 1:
                return this.mDestInputWidget;
            case 2:
                if (i2 < 0 || i2 >= this.mMidInputWidgets.size()) {
                    return null;
                }
                return this.mMidInputWidgets.get(i2);
            default:
                return null;
        }
    }

    private void appendMidInputWidget(Poi poi) {
        appendMidInputWidget(poi, true);
    }

    /* access modifiers changed from: private */
    public void appendMidInputWidget(Poi poi, boolean z) {
        PoiInputItemWidget poiInputItemWidget = new PoiInputItemWidget(getContext());
        poiInputItemWidget.initUI(2, poi);
        poiInputItemWidget.setCallback(this.mInputItemCallback);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (int) hs.a().getDimension(R.dimen.abc_action_bar_overflow_padding_end_material));
        boolean z2 = false;
        layoutParams.setMargins(0, (int) hs.a().getDimension(R.dimen.abc_action_bar_icon_vertical_padding_material), 0, 0);
        this.mMidInputWidgets.add(poiInputItemWidget);
        this.mMidPois.add(poi);
        this.mMidItemWidgetGroup.addView(poiInputItemWidget, layoutParams);
        if (z) {
            if (this.mMidInputWidgets.size() == this.mMaxMidNum) {
                z2 = true;
            }
            applyAddAnim(poiInputItemWidget, z2);
        }
        checkMidInputHintPosAndAddBtn();
    }

    private void applyAddAnim(PoiInputItemWidget poiInputItemWidget, boolean z) {
        this.isInAnim.set(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setStartOffset(150);
        poiInputItemWidget.setAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new AnimationListenerAdapter() {
            public final void onAnimationEnd(Animation animation) {
                PoiInputSearchWidget.this.isInAnim.set(false);
            }
        });
        Animation createTransDownAnim = createTransDownAnim(-getInputWidgetHeightWithMargin());
        this.mDestInputWidget.setAnimation(createTransDownAnim);
        this.mFinishChooseMidBtn.setAnimation(createTransDownAnim);
        this.mSwitchBtn.setAnimation(createTransDownAnimForSwitchBtn());
        if (!z) {
            this.mAddBtn.setAnimation(createTransDownAnim);
        }
    }

    private Animation createTransDownAnimForSwitchBtn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (-getInputWidgetHeightWithMargin()) / 2.0f, 0.0f);
        translateAnimation.setDuration(150);
        return translateAnimation;
    }

    private Animation createTransUpAnimForSwitchBtn() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (-getInputWidgetHeightWithMargin()) / 2.0f);
        translateAnimation.setDuration(150);
        translateAnimation.setStartOffset(150);
        return translateAnimation;
    }

    private Animation createTransUpAnim() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, -getInputWidgetHeightWithMargin());
        translateAnimation.setDuration(150);
        translateAnimation.setStartOffset(150);
        return translateAnimation;
    }

    private Animation createTransDownAnim(float f) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f, 0.0f);
        translateAnimation.setDuration(150);
        return translateAnimation;
    }

    private float getInputWidgetHeightWithMargin() {
        int height = this.mDestInputWidget.getHeight();
        float dimension = hs.a().getDimension(R.dimen.abc_action_bar_icon_vertical_padding_material);
        try {
            dimension = (float) ((RelativeLayout.LayoutParams) this.mDestInputWidget.getLayoutParams()).topMargin;
        } catch (Exception unused) {
        }
        return ((float) height) + dimension;
    }

    /* access modifiers changed from: private */
    public void applyRemoveAnim(final PoiInputItemWidget poiInputItemWidget, int i) {
        this.isInAnim.set(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(150);
        alphaAnimation.setFillAfter(true);
        poiInputItemWidget.startAnimation(alphaAnimation);
        Animation createTransUpAnim = createTransUpAnim();
        this.mDestInputWidget.startAnimation(createTransUpAnim);
        this.mFinishChooseMidBtn.startAnimation(createTransUpAnim());
        this.mAddBtn.startAnimation(createTransUpAnim());
        this.mSwitchBtn.startAnimation(createTransUpAnimForSwitchBtn());
        for (int i2 = i + 1; i2 < this.mMidInputWidgets.size(); i2++) {
            this.mMidInputWidgets.get(i2).setAnimation(createTransUpAnim());
        }
        createTransUpAnim.setAnimationListener(new AnimationListenerAdapter() {
            public final void onAnimationEnd(Animation animation) {
                PoiInputSearchWidget.this.mMidItemWidgetGroup.postDelayed(new Runnable() {
                    public final void run() {
                        try {
                            PoiInputSearchWidget.this.isInAnim.set(false);
                            PoiInputSearchWidget.this.mMidItemWidgetGroup.removeView(poiInputItemWidget);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }, 0);
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkMidInputHintPosAndAddBtn() {
        checkMidInputHintPos();
        checkAddBtnVisible();
    }

    private void checkMidInputHintPos() {
        int i = 0;
        if (this.mMidInputWidgets.size() > 1) {
            while (i < this.mMidInputWidgets.size()) {
                int i2 = i + 1;
                this.mMidInputWidgets.get(i).setPos(i2);
                i = i2;
            }
        } else if (this.mMidInputWidgets.size() == 1) {
            this.mMidInputWidgets.get(0).setPos(-1);
        }
    }

    private void checkAddBtnVisible() {
        if (this.mMidInputWidgets.size() >= this.mMaxMidNum) {
            this.mAddBtn.setVisibility(8);
        } else {
            this.mAddBtn.setVisibility(0);
        }
    }

    private void checkIsToShowChooseRes() {
        Iterator<Poi> it = this.mMidPois.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next() != null) {
                i++;
            }
        }
        if (i > 0) {
            this.mPoiInputResWidget.setVisibility(0);
            this.mPoiInputResWidget.setPoi(this.mStartPoi, this.mDestPoi, this.mMidPois);
            this.mAddBtn.setVisibility(8);
            changePoiInputWidgets(false);
            return;
        }
        this.mAddBtn.setVisibility(0);
        changePoiInputWidgets(true);
    }

    private void changePoiInputWidgets(boolean z) {
        if (!z) {
            this.mStartInputWidget.setVisibility(8);
            this.mDestInputWidget.setVisibility(8);
            cleanMidInputWidgets(8);
            return;
        }
        this.mStartInputWidget.setVisibility(0);
        this.mDestInputWidget.setVisibility(0);
        cleanMidInputWidgets(0);
    }

    private void cleanMidInputWidgets(int i) {
        ArrayList<PoiInputItemWidget> arrayList = new ArrayList<>();
        ArrayList<Poi> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < this.mMidInputWidgets.size(); i2++) {
            if (this.mMidPois.get(i2) == null) {
                this.mMidItemWidgetGroup.removeView(this.mMidInputWidgets.get(i2));
            } else {
                arrayList2.add(this.mMidPois.get(i2));
                arrayList.add(this.mMidInputWidgets.get(i2));
                this.mMidInputWidgets.get(i2).setVisibility(i);
            }
        }
        this.mMidInputWidgets = arrayList;
        this.mMidPois = arrayList2;
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public void setShowChooseRes() {
        if (this.mFinishChooseMidBtn.getVisibility() != 8) {
            this.mFinishChooseMidBtn.setVisibility(8);
        }
        if (this.mCallback != null) {
            this.mIsChooseMid.set(false);
        }
        checkIsToShowChooseRes();
    }

    public void onClick(View view) {
        try {
            if (!this.isInAnim.get()) {
                int id = view.getId();
                if (id != 2131296431) {
                    if (id != 2131296450) {
                        switch (id) {
                            case 2131296453:
                                if (!this.isInCalRoute.get()) {
                                    applySwitchAnim();
                                    return;
                                } else if (this.mCallback != null) {
                                    this.mCallback.onSwitchFail();
                                    return;
                                } else {
                                    return;
                                }
                            case 2131296454:
                                appendMidInputWidget((Poi) null, true);
                                if (this.mFinishChooseMidBtn.getVisibility() != 0) {
                                    this.mFinishChooseMidBtn.setVisibility(0);
                                }
                                if (this.mCallback != null && !this.mIsChooseMid.get()) {
                                    this.mCallback.onStartChooseMid();
                                    this.mIsChooseMid.set(true);
                                    return;
                                }
                                return;
                            case 2131296455:
                                setShowChooseRes();
                                if (this.mCallback != null) {
                                    this.mCallback.onFinishChooseMid();
                                    return;
                                }
                                return;
                            default:
                                return;
                        }
                    } else {
                        this.mFinishChooseMidBtn.setVisibility(0);
                        if (this.mCallback != null) {
                            this.mCallback.onStartChooseMid();
                            this.mIsChooseMid.set(false);
                        }
                        this.mPoiInputResWidget.setVisibility(8);
                        changePoiInputWidgets(true);
                        checkAddBtnVisible();
                    }
                } else if (this.mCallback != null) {
                    this.mCallback.onBack();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void applySwitchData() {
        this.mStartInputWidget.setPoi(this.mDestPoi);
        this.mDestInputWidget.setPoi(this.mStartPoi);
        Poi poi = this.mStartPoi;
        this.mStartPoi = this.mDestPoi;
        this.mDestPoi = poi;
        ArrayList<Poi> arrayList = new ArrayList<>();
        for (int i = 0; i < this.mMidInputWidgets.size(); i++) {
            this.mMidInputWidgets.get(i).setPoi(this.mMidPois.get((this.mMidPois.size() - 1) - i));
            arrayList.add(this.mMidPois.get((this.mMidPois.size() - 1) - i));
        }
        checkMidInputHintPos();
        this.mMidPois = arrayList;
        this.isInAnim.set(false);
    }

    private void applySwitchAnim() {
        this.isInAnim.set(true);
        if (this.mCallback != null) {
            this.mCallback.onSwitch();
        }
        if (this.mPoiInputResWidget.getVisibility() == 0) {
            applySwitchData();
            this.mPoiInputResWidget.setPoi(this.mStartPoi, this.mDestPoi, this.mMidPois);
            return;
        }
        this.mStartInputWidget.switchAnim(1, new Runnable() {
            public final void run() {
                try {
                    PoiInputSearchWidget.this.applySwitchData();
                } catch (Throwable unused) {
                }
            }
        });
        this.mDestInputWidget.switchAnim(0, (Runnable) null);
        for (int i = 0; i < this.mMidInputWidgets.size(); i++) {
            int size = (this.mMidInputWidgets.size() - 1) - i;
            if (size != i) {
                if (i < size) {
                    this.mMidInputWidgets.get(i).switchAnim(1, (Runnable) null);
                } else {
                    this.mMidInputWidgets.get(i).switchAnim(0, (Runnable) null);
                }
            }
        }
    }
}
