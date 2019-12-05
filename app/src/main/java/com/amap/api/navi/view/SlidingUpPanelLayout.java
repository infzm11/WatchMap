package com.amap.api.navi.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.n3.hn;
import com.amap.api.col.n3.hp;
import com.amap.api.col.n3.hq;
import java.util.List;

public class SlidingUpPanelLayout extends ViewGroup {
    public static final int ACTION_MASK = 255;
    private static final float DEFAULT_ANCHOR_POINT = 1.0f;
    private static final int[] DEFAULT_ATTRS = {16842927};
    private static final boolean DEFAULT_CLIP_PANEL_FLAG = true;
    private static final int DEFAULT_FADE_COLOR = -1728053248;
    private static final int DEFAULT_MIN_FLING_VELOCITY = 400;
    private static final boolean DEFAULT_OVERLAY_FLAG = false;
    private static final int DEFAULT_PANEL_HEIGHT = 68;
    private static final int DEFAULT_PARALLAX_OFFSET = 0;
    private static final int DEFAULT_SHADOW_HEIGHT = 4;
    private static PanelState DEFAULT_SLIDE_STATE = PanelState.COLLAPSED;
    public static final String SLIDING_STATE = "sliding_state";
    private static final String TAG = "SlidingUpPanelLayout";
    /* access modifiers changed from: private */
    public float mAnchorPoint;
    private boolean mClipPanel;
    private int mCoveredFadeColor;
    private final Paint mCoveredFadePaint;
    /* access modifiers changed from: private */
    public final hp mDragHelper;
    private View mDragView;
    private int mDragViewResId;
    private View.OnClickListener mFadeOnClickListener;
    private boolean mFirstLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsScrollableViewHandlingTouch;
    /* access modifiers changed from: private */
    public boolean mIsSlidingUp;
    private boolean mIsTouchEnabled;
    /* access modifiers changed from: private */
    public boolean mIsUnableToDrag;
    private PanelState mLastNotDraggingSlideState;
    private View mMainView;
    private int mMinFlingVelocity;
    private boolean mOverlayContent;
    private int mPanelHeight;
    private final List<PanelSlideListener> mPanelSlideListeners;
    private int mParallaxOffset;
    private float mPrevMotionY;
    private View mScrollableView;
    private hn mScrollableViewHelper;
    private int mScrollableViewResId;
    private final Drawable mShadowDrawable;
    private int mShadowHeight;
    /* access modifiers changed from: private */
    public float mSlideOffset;
    /* access modifiers changed from: private */
    public int mSlideRange;
    /* access modifiers changed from: private */
    public PanelState mSlideState;
    /* access modifiers changed from: private */
    public View mSlideableView;
    private final Rect mTmpRect;
    private View mTopView;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        private static final int[] ATTRS = {16843137};
        public float weight = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS);
            if (obtainStyledAttributes != null) {
                this.weight = obtainStyledAttributes.getFloat(0, 0.0f);
                obtainStyledAttributes.recycle();
            }
        }
    }

    public interface PanelSlideListener {
        void onPanelSlide(View view, float f);

        void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2);
    }

    public enum PanelState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    public static class SimplePanelSlideListener implements PanelSlideListener {
        public void onPanelSlide(View view, float f) {
        }

        public void onPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        }
    }

    private class a extends hp.a {
        private a() {
        }

        /* synthetic */ a(SlidingUpPanelLayout slidingUpPanelLayout, byte b) {
            this();
        }

        public final boolean a(View view) {
            return !SlidingUpPanelLayout.this.mIsUnableToDrag && view == SlidingUpPanelLayout.this.mSlideableView;
        }

        public final void a() {
            if (SlidingUpPanelLayout.this.mDragHelper != null && SlidingUpPanelLayout.this.mDragHelper.a() == 0) {
                float unused = SlidingUpPanelLayout.this.mSlideOffset = SlidingUpPanelLayout.this.computeSlideOffset(SlidingUpPanelLayout.this.mSlideableView.getTop());
                SlidingUpPanelLayout.this.applyParallaxForCurrentSlideOffset();
                if (SlidingUpPanelLayout.this.mSlideOffset == 1.0f) {
                    SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.EXPANDED);
                } else if (SlidingUpPanelLayout.this.mSlideOffset == 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.COLLAPSED);
                } else if (SlidingUpPanelLayout.this.mSlideOffset < 0.0f) {
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.HIDDEN);
                    SlidingUpPanelLayout.this.mSlideableView.setVisibility(4);
                } else {
                    SlidingUpPanelLayout.this.updateObscuredViewVisibility();
                    SlidingUpPanelLayout.this.setPanelStateInternal(PanelState.ANCHORED);
                }
            }
        }

        public final void b() {
            SlidingUpPanelLayout.this.setAllChildrenVisible();
        }

        public final void a(int i) {
            SlidingUpPanelLayout.this.onPanelDragged(i);
            SlidingUpPanelLayout.this.applyParallaxForTopOffset(i);
            SlidingUpPanelLayout.this.invalidate();
        }

        public final void a(View view, float f) {
            int i;
            if (SlidingUpPanelLayout.this.mIsSlidingUp) {
                f = -f;
            }
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            if (i2 > 0 && SlidingUpPanelLayout.this.mSlideOffset <= SlidingUpPanelLayout.this.mAnchorPoint) {
                i = SlidingUpPanelLayout.this.computePanelTopPosition(SlidingUpPanelLayout.this.mAnchorPoint);
            } else if (i2 <= 0 || SlidingUpPanelLayout.this.mSlideOffset <= SlidingUpPanelLayout.this.mAnchorPoint) {
                int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i3 >= 0 || SlidingUpPanelLayout.this.mSlideOffset < SlidingUpPanelLayout.this.mAnchorPoint) {
                    if (i3 >= 0 || SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint) {
                        if (SlidingUpPanelLayout.this.mSlideOffset >= (SlidingUpPanelLayout.this.mAnchorPoint + 1.0f) / 2.0f) {
                            i = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
                        } else if (SlidingUpPanelLayout.this.mSlideOffset >= SlidingUpPanelLayout.this.mAnchorPoint / 2.0f) {
                            i = SlidingUpPanelLayout.this.computePanelTopPosition(SlidingUpPanelLayout.this.mAnchorPoint);
                        }
                    }
                    i = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
                } else {
                    i = SlidingUpPanelLayout.this.computePanelTopPosition(SlidingUpPanelLayout.this.mAnchorPoint);
                }
            } else {
                i = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            }
            if (SlidingUpPanelLayout.this.mDragHelper != null) {
                SlidingUpPanelLayout.this.mDragHelper.a(view.getLeft(), i);
            }
            SlidingUpPanelLayout.this.invalidate();
        }

        public final int c() {
            return SlidingUpPanelLayout.this.mSlideRange;
        }

        public final int b(int i) {
            int access$1300 = SlidingUpPanelLayout.this.computePanelTopPosition(0.0f);
            int access$13002 = SlidingUpPanelLayout.this.computePanelTopPosition(1.0f);
            if (SlidingUpPanelLayout.this.mIsSlidingUp) {
                return Math.min(Math.max(i, access$13002), access$1300);
            }
            return Math.min(Math.max(i, access$1300), access$13002);
        }
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0129  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlidingUpPanelLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            r11 = 400(0x190, float:5.6E-43)
            r8.mMinFlingVelocity = r11
            r0 = -1728053248(0xffffffff99000000, float:-6.617445E-24)
            r8.mCoveredFadeColor = r0
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r8.mCoveredFadePaint = r1
            r1 = -1
            r8.mPanelHeight = r1
            r8.mShadowHeight = r1
            r8.mParallaxOffset = r1
            r2 = 0
            r8.mOverlayContent = r2
            r3 = 1
            r8.mClipPanel = r3
            r8.mDragViewResId = r1
            com.amap.api.col.n3.hn r4 = new com.amap.api.col.n3.hn
            r4.<init>()
            r8.mScrollableViewHelper = r4
            com.amap.api.navi.view.SlidingUpPanelLayout$PanelState r4 = DEFAULT_SLIDE_STATE
            r8.mSlideState = r4
            com.amap.api.navi.view.SlidingUpPanelLayout$PanelState r4 = DEFAULT_SLIDE_STATE
            r8.mLastNotDraggingSlideState = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            r8.mAnchorPoint = r4
            r8.mIsScrollableViewHandlingTouch = r2
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList
            r5.<init>()
            r8.mPanelSlideListeners = r5
            r8.mFirstLayout = r3
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            r8.mTmpRect = r5
            boolean r5 = r8.isInEditMode()
            r6 = 0
            if (r5 == 0) goto L_0x0052
            r8.mShadowDrawable = r6
            r8.mDragHelper = r6
            return
        L_0x0052:
            if (r10 == 0) goto L_0x00da
            int[] r5 = DEFAULT_ATTRS
            android.content.res.TypedArray r5 = r9.obtainStyledAttributes(r10, r5)
            if (r5 == 0) goto L_0x0066
            int r7 = r5.getInt(r2, r2)
            r8.setGravity(r7)
            r5.recycle()
        L_0x0066:
            int[] r5 = com.amap.api.col.n3.kv.a.a
            android.content.res.TypedArray r10 = r9.obtainStyledAttributes(r10, r5)
            if (r10 == 0) goto L_0x00da
            int r5 = r10.getDimensionPixelSize(r2, r1)
            r8.mPanelHeight = r5
            int r5 = r10.getDimensionPixelSize(r3, r1)
            r8.mShadowHeight = r5
            r5 = 2
            int r5 = r10.getDimensionPixelSize(r5, r1)
            r8.mParallaxOffset = r5
            r5 = 4
            int r11 = r10.getInt(r5, r11)
            r8.mMinFlingVelocity = r11
            r11 = 3
            int r11 = r10.getColor(r11, r0)
            r8.mCoveredFadeColor = r11
            r11 = 5
            int r11 = r10.getResourceId(r11, r1)
            r8.mDragViewResId = r11
            r11 = 6
            int r11 = r10.getResourceId(r11, r1)
            r8.mScrollableViewResId = r11
            r11 = 7
            boolean r11 = r10.getBoolean(r11, r2)
            r8.mOverlayContent = r11
            r11 = 8
            boolean r11 = r10.getBoolean(r11, r3)
            r8.mClipPanel = r11
            r11 = 9
            float r11 = r10.getFloat(r11, r4)
            r8.mAnchorPoint = r11
            com.amap.api.navi.view.SlidingUpPanelLayout$PanelState[] r11 = com.amap.api.navi.view.SlidingUpPanelLayout.PanelState.values()
            r0 = 10
            com.amap.api.navi.view.SlidingUpPanelLayout$PanelState r4 = DEFAULT_SLIDE_STATE
            int r4 = r4.ordinal()
            int r0 = r10.getInt(r0, r4)
            r11 = r11[r0]
            r8.mSlideState = r11
            r11 = 11
            int r11 = r10.getResourceId(r11, r1)
            if (r11 == r1) goto L_0x00d5
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r9, r11)
            goto L_0x00d6
        L_0x00d5:
            r11 = r6
        L_0x00d6:
            r10.recycle()
            goto L_0x00db
        L_0x00da:
            r11 = r6
        L_0x00db:
            android.content.res.Resources r9 = r9.getResources()
            android.util.DisplayMetrics r9 = r9.getDisplayMetrics()
            float r9 = r9.density
            int r10 = r8.mPanelHeight
            r0 = 1056964608(0x3f000000, float:0.5)
            if (r10 != r1) goto L_0x00f2
            r10 = 1116209152(0x42880000, float:68.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.mPanelHeight = r10
        L_0x00f2:
            int r10 = r8.mShadowHeight
            if (r10 != r1) goto L_0x00fd
            r10 = 1082130432(0x40800000, float:4.0)
            float r10 = r10 * r9
            float r10 = r10 + r0
            int r10 = (int) r10
            r8.mShadowHeight = r10
        L_0x00fd:
            int r10 = r8.mParallaxOffset
            if (r10 != r1) goto L_0x0106
            r10 = 0
            float r10 = r10 * r9
            int r10 = (int) r10
            r8.mParallaxOffset = r10
        L_0x0106:
            int r10 = r8.mShadowHeight
            if (r10 <= 0) goto L_0x0129
            boolean r10 = r8.mIsSlidingUp
            if (r10 == 0) goto L_0x011b
            android.content.res.Resources r10 = com.amap.api.col.n3.hs.a()
            r0 = 2130837504(0x7f020000, float:1.7279964E38)
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r0)
            r8.mShadowDrawable = r10
            goto L_0x012b
        L_0x011b:
            android.content.res.Resources r10 = com.amap.api.col.n3.hs.a()
            r0 = 2130837543(0x7f020027, float:1.7280043E38)
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r0)
            r8.mShadowDrawable = r10
            goto L_0x012b
        L_0x0129:
            r8.mShadowDrawable = r6
        L_0x012b:
            r8.setWillNotDraw(r2)
            com.amap.api.navi.view.SlidingUpPanelLayout$a r10 = new com.amap.api.navi.view.SlidingUpPanelLayout$a
            r10.<init>(r8, r2)
            com.amap.api.col.n3.hp r10 = com.amap.api.col.n3.hp.a((android.view.ViewGroup) r8, (android.view.animation.Interpolator) r11, (com.amap.api.col.n3.hp.a) r10)
            r8.mDragHelper = r10
            com.amap.api.col.n3.hp r10 = r8.mDragHelper
            int r11 = r8.mMinFlingVelocity
            float r11 = (float) r11
            float r11 = r11 * r9
            r10.a((float) r11)
            r8.mIsTouchEnabled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.SlidingUpPanelLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setTopView(View view) {
        this.mTopView = view;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        if (this.mDragViewResId != -1) {
            setDragView(findViewById(this.mDragViewResId));
        }
        if (this.mScrollableViewResId != -1) {
            setScrollableView(findViewById(this.mScrollableViewResId));
        }
    }

    public void setGravity(int i) {
        if (i == 48 || i == 80) {
            this.mIsSlidingUp = i == 80;
            if (!this.mFirstLayout) {
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("gravity must be set to either top or bottom");
    }

    public void setCoveredFadeColor(int i) {
        this.mCoveredFadeColor = i;
        requestLayout();
    }

    public int getCoveredFadeColor() {
        return this.mCoveredFadeColor;
    }

    public void setTouchEnabled(boolean z) {
        this.mIsTouchEnabled = z;
    }

    public boolean isTouchEnabled() {
        return (!this.mIsTouchEnabled || this.mSlideableView == null || this.mSlideState == PanelState.HIDDEN) ? false : true;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() != i) {
            this.mPanelHeight = i;
            if (!this.mFirstLayout) {
                requestLayout();
            }
            if (getPanelState() == PanelState.COLLAPSED) {
                smoothToBottom();
                invalidate();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void smoothToBottom() {
        smoothSlideTo(0.0f, 0);
    }

    public int getShadowHeight() {
        return this.mShadowHeight;
    }

    public void setShadowHeight(int i) {
        this.mShadowHeight = i;
        if (!this.mFirstLayout) {
            invalidate();
        }
    }

    public int getPanelHeight() {
        return this.mPanelHeight;
    }

    public int getCurrentParallaxOffset() {
        int max = (int) (((float) this.mParallaxOffset) * Math.max(this.mSlideOffset, 0.0f));
        return this.mIsSlidingUp ? -max : max;
    }

    public void setParallaxOffset(int i) {
        this.mParallaxOffset = i;
        if (!this.mFirstLayout) {
            requestLayout();
        }
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public void setMinFlingVelocity(int i) {
        this.mMinFlingVelocity = i;
    }

    public void addPanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.add(panelSlideListener);
        }
    }

    public void removePanelSlideListener(PanelSlideListener panelSlideListener) {
        synchronized (this.mPanelSlideListeners) {
            this.mPanelSlideListeners.remove(panelSlideListener);
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        this.mFadeOnClickListener = onClickListener;
    }

    public void setDragView(View view) {
        if (this.mDragView != null) {
            this.mDragView.setOnClickListener((View.OnClickListener) null);
        }
        this.mDragView = view;
        if (this.mDragView != null) {
            this.mDragView.setClickable(true);
            this.mDragView.setFocusable(false);
            this.mDragView.setFocusableInTouchMode(false);
            this.mDragView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    try {
                        if (!SlidingUpPanelLayout.this.isEnabled()) {
                            return;
                        }
                        if (SlidingUpPanelLayout.this.isTouchEnabled()) {
                            if (SlidingUpPanelLayout.this.mSlideState == PanelState.EXPANDED || SlidingUpPanelLayout.this.mSlideState == PanelState.ANCHORED) {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.COLLAPSED);
                            } else if (SlidingUpPanelLayout.this.mAnchorPoint < 1.0f) {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.ANCHORED);
                            } else {
                                SlidingUpPanelLayout.this.setPanelState(PanelState.EXPANDED);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void setDragView(int i) {
        this.mDragViewResId = i;
        setDragView(findViewById(i));
    }

    public void setScrollableView(View view) {
        this.mScrollableView = view;
    }

    public void setScrollableViewHelper(hn hnVar) {
        this.mScrollableViewHelper = hnVar;
    }

    public void setAnchorPoint(float f) {
        if (f > 0.0f && f <= 1.0f) {
            this.mAnchorPoint = f;
            this.mFirstLayout = true;
            requestLayout();
        }
    }

    public float getAnchorPoint() {
        return this.mAnchorPoint;
    }

    public void setOverlayed(boolean z) {
        this.mOverlayContent = z;
    }

    public boolean isOverlayed() {
        return this.mOverlayContent;
    }

    public void setClipPanel(boolean z) {
        this.mClipPanel = z;
    }

    public boolean isClipPanel() {
        return this.mClipPanel;
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelSlide(View view) {
        synchronized (this.mPanelSlideListeners) {
            for (PanelSlideListener onPanelSlide : this.mPanelSlideListeners) {
                onPanelSlide.onPanelSlide(view, this.mSlideOffset);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchOnPanelStateChanged(View view, PanelState panelState, PanelState panelState2) {
        synchronized (this.mPanelSlideListeners) {
            for (PanelSlideListener onPanelStateChanged : this.mPanelSlideListeners) {
                onPanelStateChanged.onPanelStateChanged(view, panelState, panelState2);
            }
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void updateObscuredViewVisibility() {
        int i;
        int i2;
        int i3;
        int i4;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            int i5 = 0;
            if (this.mSlideableView == null || !hasOpaqueBackground(this.mSlideableView)) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i4 = this.mSlideableView.getLeft();
                i3 = this.mSlideableView.getRight();
                i2 = this.mSlideableView.getTop();
                i = this.mSlideableView.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i4 && max2 >= i2 && min <= i3 && min2 <= i) {
                i5 = 4;
            }
            childAt.setVisibility(i5);
        }
    }

    /* access modifiers changed from: package-private */
    public void setAllChildrenVisible() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    private static boolean hasOpaqueBackground(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824 || mode2 == Integer.MIN_VALUE) {
            int childCount = getChildCount();
            if (childCount != 2) {
                throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
            }
            this.mMainView = getChildAt(0);
            this.mSlideableView = getChildAt(1);
            if (this.mDragView == null) {
                setDragView(this.mSlideableView);
            }
            if (this.mSlideableView.getVisibility() != 0) {
                this.mSlideState = PanelState.HIDDEN;
            }
            int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (childAt.getVisibility() != 8 || i7 != 0) {
                    if (childAt == this.mMainView) {
                        i4 = (this.mOverlayContent || this.mSlideState == PanelState.HIDDEN) ? paddingTop : paddingTop - this.mPanelHeight;
                        i3 = paddingLeft - (layoutParams.leftMargin + layoutParams.rightMargin);
                    } else {
                        i4 = childAt == this.mSlideableView ? paddingTop - layoutParams.topMargin : paddingTop;
                        i3 = paddingLeft;
                    }
                    if (layoutParams.width == -2) {
                        i5 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
                    } else if (layoutParams.width == -1) {
                        i5 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    } else {
                        i5 = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    }
                    if (layoutParams.height == -2) {
                        i6 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
                    } else {
                        if (layoutParams.weight > 0.0f && layoutParams.weight < 1.0f) {
                            i4 = (int) (((float) i4) * layoutParams.weight);
                        } else if (layoutParams.height != -1) {
                            i4 = layoutParams.height;
                        }
                        i6 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    }
                    childAt.measure(i5, i6);
                    if (childAt == this.mSlideableView) {
                        this.mSlideRange = this.mSlideableView.getMeasuredHeight() - this.mPanelHeight;
                    }
                }
            }
            setMeasuredDimension(size, size2);
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.mFirstLayout) {
            switch (this.mSlideState) {
                case EXPANDED:
                    this.mSlideOffset = 1.0f;
                    break;
                case ANCHORED:
                    this.mSlideOffset = this.mAnchorPoint;
                    break;
                case HIDDEN:
                    this.mSlideOffset = computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight));
                    break;
                default:
                    this.mSlideOffset = 0.0f;
                    break;
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i5 != 0 && !this.mFirstLayout)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int computePanelTopPosition = childAt == this.mSlideableView ? computePanelTopPosition(this.mSlideOffset) : paddingTop;
                if (!this.mIsSlidingUp && childAt == this.mMainView && !this.mOverlayContent) {
                    computePanelTopPosition = computePanelTopPosition(this.mSlideOffset) + this.mSlideableView.getMeasuredHeight();
                }
                int i6 = layoutParams.leftMargin + paddingLeft;
                childAt.layout(i6, computePanelTopPosition, childAt.getMeasuredWidth() + i6, measuredHeight + computePanelTopPosition);
            }
        }
        if (this.mFirstLayout) {
            updateObscuredViewVisibility();
        }
        applyParallaxForCurrentSlideOffset();
        this.mFirstLayout = false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.mFirstLayout = true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mIsScrollableViewHandlingTouch || !isTouchEnabled()) {
            this.mDragHelper.d();
            return false;
        }
        int actionMasked = getActionMasked(motionEvent);
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float abs = Math.abs(x - this.mInitialMotionX);
        float abs2 = Math.abs(y - this.mInitialMotionY);
        int b = this.mDragHelper.b();
        switch (actionMasked) {
            case 0:
                this.mIsUnableToDrag = false;
                this.mInitialMotionX = x;
                this.mInitialMotionY = y;
                if (!isViewUnder(this.mDragView, (int) x, (int) y)) {
                    this.mDragHelper.c();
                    this.mIsUnableToDrag = true;
                    return false;
                }
                break;
            case 1:
            case 3:
                if (this.mDragHelper.f()) {
                    this.mDragHelper.b(motionEvent);
                    return true;
                }
                float f = (float) b;
                if (abs2 <= f && abs <= f && this.mSlideOffset > 0.0f && !isViewUnder(this.mSlideableView, (int) this.mInitialMotionX, (int) this.mInitialMotionY) && this.mFadeOnClickListener != null) {
                    playSoundEffect(0);
                    this.mFadeOnClickListener.onClick(this);
                    return true;
                }
            case 2:
                if (abs2 > ((float) b) && abs > abs2) {
                    this.mDragHelper.c();
                    this.mIsUnableToDrag = true;
                    return false;
                }
        }
        return this.mDragHelper.a(motionEvent);
    }

    private boolean dodo(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            this.mDragView.getLocationOnScreen(iArr);
            if (((int) motionEvent.getX()) >= iArr[0] && ((int) motionEvent.getY()) + 100 < iArr[1]) {
                return super.onTouchEvent(motionEvent);
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || !isTouchEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.mDragHelper.b(motionEvent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int getActionMasked(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00da  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.dodo(r7)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = getActionMasked(r7)
            boolean r2 = r6.isEnabled()
            if (r2 == 0) goto L_0x013b
            boolean r2 = r6.isTouchEnabled()
            if (r2 == 0) goto L_0x013b
            boolean r2 = r6.mIsUnableToDrag
            if (r2 == 0) goto L_0x0020
            if (r0 == 0) goto L_0x0020
            goto L_0x013b
        L_0x0020:
            float r2 = r7.getY()
            if (r0 != 0) goto L_0x002c
            r6.mIsScrollableViewHandlingTouch = r1
            r6.mPrevMotionY = r2
            goto L_0x0136
        L_0x002c:
            r3 = 2
            r4 = 1
            if (r0 != r3) goto L_0x012b
            float r0 = r6.mPrevMotionY
            float r0 = r2 - r0
            r6.mPrevMotionY = r2
            android.view.View r2 = r6.mScrollableView
            float r3 = r6.mInitialMotionX
            int r3 = (int) r3
            float r5 = r6.mInitialMotionY
            int r5 = (int) r5
            boolean r2 = r6.isViewUnder(r2, r3, r5)
            if (r2 != 0) goto L_0x0049
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L_0x0049:
            boolean r2 = r6.mIsSlidingUp
            r3 = -1
            if (r2 == 0) goto L_0x0050
            r2 = r4
            goto L_0x0051
        L_0x0050:
            r2 = r3
        L_0x0051:
            float r2 = (float) r2
            float r2 = r2 * r0
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L_0x00f6
            com.amap.api.col.n3.hn r0 = r6.mScrollableViewHelper
            android.view.View r0 = r6.mScrollableView
            boolean r2 = r6.mIsSlidingUp
            if (r0 == 0) goto L_0x00d0
            boolean r3 = r0 instanceof android.widget.ScrollView
            if (r3 == 0) goto L_0x0081
            if (r2 == 0) goto L_0x006b
            int r0 = r0.getScrollY()
            goto L_0x00d1
        L_0x006b:
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            android.view.View r2 = r0.getChildAt(r1)
            int r2 = r2.getBottom()
            int r3 = r0.getHeight()
            int r0 = r0.getScrollY()
            int r3 = r3 + r0
            int r0 = r2 - r3
            goto L_0x00d1
        L_0x0081:
            boolean r3 = r0 instanceof android.widget.ListView
            if (r3 == 0) goto L_0x00d0
            android.widget.ListView r0 = (android.widget.ListView) r0
            int r3 = r0.getChildCount()
            if (r3 <= 0) goto L_0x00d0
            android.widget.ListAdapter r3 = r0.getAdapter()
            if (r3 == 0) goto L_0x00d0
            if (r2 == 0) goto L_0x00a8
            android.view.View r2 = r0.getChildAt(r1)
            int r0 = r0.getFirstVisiblePosition()
            int r3 = r2.getHeight()
            int r0 = r0 * r3
            int r2 = r2.getTop()
            int r0 = r0 - r2
            goto L_0x00d1
        L_0x00a8:
            int r2 = r0.getChildCount()
            int r2 = r2 - r4
            android.view.View r2 = r0.getChildAt(r2)
            android.widget.ListAdapter r3 = r0.getAdapter()
            int r3 = r3.getCount()
            int r5 = r0.getLastVisiblePosition()
            int r3 = r3 - r5
            int r3 = r3 - r4
            int r5 = r2.getHeight()
            int r3 = r3 * r5
            int r2 = r2.getBottom()
            int r3 = r3 + r2
            int r0 = r0.getBottom()
            int r0 = r3 - r0
            goto L_0x00d1
        L_0x00d0:
            r0 = r1
        L_0x00d1:
            if (r0 <= 0) goto L_0x00da
            r6.mIsScrollableViewHandlingTouch = r4
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L_0x00da:
            boolean r0 = r6.mIsScrollableViewHandlingTouch
            if (r0 == 0) goto L_0x00ef
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r7)
            r2 = 3
            r0.setAction(r2)
            super.dispatchTouchEvent(r0)
            r0.recycle()
            r7.setAction(r1)
        L_0x00ef:
            r6.mIsScrollableViewHandlingTouch = r1
            boolean r7 = r6.onTouchEvent(r7)
            return r7
        L_0x00f6:
            boolean r2 = r6.mIsSlidingUp
            if (r2 == 0) goto L_0x00fb
            r3 = r4
        L_0x00fb:
            float r2 = (float) r3
            float r0 = r0 * r2
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0136
            float r0 = r6.mSlideOffset
            r2 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x0110
            r6.mIsScrollableViewHandlingTouch = r1
            boolean r7 = r6.onTouchEvent(r7)
            return r7
        L_0x0110:
            boolean r0 = r6.mIsScrollableViewHandlingTouch
            if (r0 != 0) goto L_0x0124
            com.amap.api.col.n3.hp r0 = r6.mDragHelper
            boolean r0 = r0.f()
            if (r0 == 0) goto L_0x0124
            com.amap.api.col.n3.hp r0 = r6.mDragHelper
            r0.c()
            r7.setAction(r1)
        L_0x0124:
            r6.mIsScrollableViewHandlingTouch = r4
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L_0x012b:
            if (r0 != r4) goto L_0x0136
            boolean r0 = r6.mIsScrollableViewHandlingTouch
            if (r0 == 0) goto L_0x0136
            com.amap.api.col.n3.hp r0 = r6.mDragHelper
            r0.a((int) r1)
        L_0x0136:
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        L_0x013b:
            com.amap.api.col.n3.hp r0 = r6.mDragHelper
            r0.d()
            boolean r7 = super.dispatchTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.SlidingUpPanelLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean isViewUnder(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i3 = iArr2[0] + i;
        int i4 = iArr2[1] + i2;
        if (i3 < iArr[0] || i3 >= iArr[0] + view.getWidth() || i4 < iArr[1] || i4 >= iArr[1] + view.getHeight()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public int computePanelTopPosition(float f) {
        int measuredHeight = this.mSlideableView != null ? this.mSlideableView.getMeasuredHeight() : 0;
        int i = (int) (f * ((float) this.mSlideRange));
        if (this.mIsSlidingUp) {
            return ((getMeasuredHeight() - getPaddingBottom()) - this.mPanelHeight) - i;
        }
        return (getPaddingTop() - measuredHeight) + this.mPanelHeight + i;
    }

    /* access modifiers changed from: private */
    public float computeSlideOffset(int i) {
        int computePanelTopPosition = computePanelTopPosition(0.0f);
        return (this.mIsSlidingUp ? (float) (computePanelTopPosition - i) : (float) (i - computePanelTopPosition)) / ((float) this.mSlideRange);
    }

    public PanelState getPanelState() {
        return this.mSlideState;
    }

    public void setPanelState(PanelState panelState) {
        if (panelState == null || panelState == PanelState.DRAGGING) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        } else if (!isEnabled()) {
        } else {
            if ((this.mFirstLayout || this.mSlideableView != null) && panelState != this.mSlideState && this.mSlideState != PanelState.DRAGGING) {
                if (this.mFirstLayout) {
                    setPanelStateInternal(panelState);
                    return;
                }
                if (this.mSlideState == PanelState.HIDDEN) {
                    this.mSlideableView.setVisibility(0);
                    requestLayout();
                }
                switch (panelState) {
                    case EXPANDED:
                        smoothSlideTo(1.0f, 0);
                        return;
                    case ANCHORED:
                        smoothSlideTo(this.mAnchorPoint, 0);
                        return;
                    case HIDDEN:
                        smoothSlideTo(computeSlideOffset(computePanelTopPosition(0.0f) + (this.mIsSlidingUp ? this.mPanelHeight : -this.mPanelHeight)), 0);
                        return;
                    case COLLAPSED:
                        smoothSlideTo(0.0f, 0);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPanelStateInternal(PanelState panelState) {
        if (this.mSlideState != panelState) {
            PanelState panelState2 = this.mSlideState;
            this.mSlideState = panelState;
            dispatchOnPanelStateChanged(this, panelState2, panelState);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void applyParallaxForCurrentSlideOffset() {
        if (this.mParallaxOffset > 0) {
            this.mMainView.setTranslationY((float) getCurrentParallaxOffset());
        }
    }

    /* access modifiers changed from: private */
    public void applyParallaxForTopOffset(int i) {
        if (this.mTopView != null) {
            int height = this.mTopView.getHeight();
            int a2 = (i - hq.a(getContext(), 100)) - height;
            if (a2 > 0) {
                a2 = 0;
            }
            int i2 = -height;
            if (a2 < i2) {
                a2 = i2;
            }
            this.mTopView.setTranslationY((float) a2);
        }
    }

    /* access modifiers changed from: private */
    public void onPanelDragged(int i) {
        if (this.mSlideState != PanelState.DRAGGING) {
            this.mLastNotDraggingSlideState = this.mSlideState;
        }
        setPanelStateInternal(PanelState.DRAGGING);
        this.mSlideOffset = computeSlideOffset(i);
        applyParallaxForCurrentSlideOffset();
        dispatchOnPanelSlide(this.mSlideableView);
        LayoutParams layoutParams = (LayoutParams) this.mMainView.getLayoutParams();
        int height = ((getHeight() - getPaddingBottom()) - getPaddingTop()) - this.mPanelHeight;
        if (this.mSlideOffset <= 0.0f && !this.mOverlayContent) {
            layoutParams.height = this.mIsSlidingUp ? i - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.mSlideableView.getMeasuredHeight()) - i;
            if (layoutParams.height == height) {
                layoutParams.height = -1;
            }
            this.mMainView.requestLayout();
        } else if (layoutParams.height != -1 && !this.mOverlayContent) {
            layoutParams.height = -1;
            this.mMainView.requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        boolean z;
        int save = canvas.save(2);
        if (this.mSlideableView == null || this.mSlideableView == view) {
            z = super.drawChild(canvas, view, j);
        } else {
            canvas.getClipBounds(this.mTmpRect);
            if (!this.mOverlayContent) {
                if (this.mIsSlidingUp) {
                    this.mTmpRect.bottom = Math.min(this.mTmpRect.bottom, this.mSlideableView.getTop());
                } else {
                    this.mTmpRect.top = Math.max(this.mTmpRect.top, this.mSlideableView.getBottom());
                }
            }
            if (this.mClipPanel) {
                canvas.clipRect(this.mTmpRect);
            }
            z = super.drawChild(canvas, view, j);
            if (this.mCoveredFadeColor != 0 && this.mSlideOffset > 0.0f) {
                this.mCoveredFadePaint.setColor((((int) (((float) ((this.mCoveredFadeColor & ViewCompat.MEASURED_STATE_MASK) >>> 24)) * this.mSlideOffset)) << 24) | (this.mCoveredFadeColor & ViewCompat.MEASURED_SIZE_MASK));
                canvas.drawRect(this.mTmpRect, this.mCoveredFadePaint);
            }
        }
        canvas.restoreToCount(save);
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean smoothSlideTo(float f, int i) {
        if (!isEnabled() || this.mSlideableView == null) {
            return false;
        }
        if (!this.mDragHelper.a(this.mSlideableView, this.mSlideableView.getLeft(), computePanelTopPosition(f))) {
            return false;
        }
        setAllChildrenVisible();
        invalidate();
        return true;
    }

    public void computeScroll() {
        if (this.mDragHelper != null && this.mDragHelper.e()) {
            if (!isEnabled()) {
                this.mDragHelper.d();
            } else {
                invalidate();
            }
        }
    }

    public void draw(Canvas canvas) {
        int i;
        int i2;
        super.draw(canvas);
        if (this.mShadowDrawable != null && this.mSlideableView != null) {
            int right = this.mSlideableView.getRight();
            if (this.mIsSlidingUp) {
                i2 = this.mSlideableView.getTop() - this.mShadowHeight;
                i = this.mSlideableView.getTop();
            } else {
                i2 = this.mSlideableView.getBottom();
                i = this.mSlideableView.getBottom() + this.mShadowHeight;
            }
            this.mShadowDrawable.setBounds(this.mSlideableView.getLeft(), i2, right, i);
            this.mShadowDrawable.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!z || !view2.canScrollHorizontally(-i)) {
            return false;
        }
        return true;
    }

    public boolean canScrollHorizontally(int i) {
        int computeHorizontalScrollOffset = computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = computeHorizontalScrollRange() - computeHorizontalScrollExtent();
        if (computeHorizontalScrollRange == 0) {
            return false;
        }
        return i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange - 1;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable(SLIDING_STATE, this.mSlideState != PanelState.DRAGGING ? this.mSlideState : this.mLastNotDraggingSlideState);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.mSlideState = (PanelState) bundle.getSerializable(SLIDING_STATE);
            this.mSlideState = this.mSlideState == null ? DEFAULT_SLIDE_STATE : this.mSlideState;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }
}
