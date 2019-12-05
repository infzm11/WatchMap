package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.amap.api.col.n3.ga;
import com.amap.api.navi.model.AMapTrafficStatus;
import java.util.List;

public class TmcBarView extends View {
    private static final int DISTANCE_MAX = 50000;
    private static final int DISTANCE_MID = 5000;
    private static final int DISTANCE_MIN = 10;
    private int jamTrafficColor;
    private float mCursorPos;
    float mCursorRatio = 0.0f;
    ImageView mDefaultTmcBarCarView = null;
    private Paint mPaint;
    private Path mPath = new Path();
    private int mPathHeight;
    private int mRouteTotalLength;
    private final TmcTag mTagCache = new TmcTag();
    private List<AMapTrafficStatus> mTmcBarItems;
    private TmcBarListener mTmcBarListener;
    private float[] radiusArray = new float[8];
    private int slowTrafficColor;
    private int smoothTrafficColor;
    private int unknownTrafficColor;
    private int veryJamTrafficColor;

    public interface TmcBarListener {
        void dismissBottomTag();

        void showBottomTag(TmcTag tmcTag);
    }

    public static class TmcTag {
        public int bgResId;
        public int index;
        public int roadLength;
        public int status;
        public int textColor;
        public int translationY;
        public float viewHeight;
    }

    public TmcBarView(Context context) {
        super(context);
        init();
    }

    public TmcBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TmcBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        if (Build.VERSION.SDK_INT < 18) {
            setLayerType(1, (Paint) null);
        }
    }

    public void setData(List<AMapTrafficStatus> list, int i) {
        this.mTmcBarItems = list;
        this.mRouteTotalLength = i;
    }

    public void setCarView(ImageView imageView) {
        this.mDefaultTmcBarCarView = imageView;
    }

    public void setCursorPos(int i) {
        this.mCursorRatio = (i > 20 ? (float) (i - 20) : ((float) i) * 1.0f) / ((float) this.mRouteTotalLength);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            int width = getWidth();
            int height = getHeight();
            float f = (float) height;
            this.mCursorPos = this.mCursorRatio * f;
            if (this.mDefaultTmcBarCarView != null) {
                this.mDefaultTmcBarCarView.setTranslationY(this.mCursorPos);
                this.mDefaultTmcBarCarView.invalidate();
            }
            if (this.mTmcBarItems != null && height > 0) {
                if (this.mPathHeight != height) {
                    this.mPath.reset();
                    for (int i = 0; i < this.radiusArray.length; i++) {
                        this.radiusArray[i] = (float) (width / 2);
                    }
                    this.mPath.addRoundRect(new RectF(0.0f, 0.0f, (float) width, f), this.radiusArray, Path.Direction.CW);
                    this.mPathHeight = height;
                }
                canvas.save();
                Canvas canvas2 = canvas;
                canvas2.clipPath(this.mPath);
                int size = this.mTmcBarItems.size();
                float f2 = (f * 1.0f) / (((float) this.mRouteTotalLength) * 1.0f);
                int i2 = 0;
                for (int i3 = size - 1; i3 >= 0; i3--) {
                    AMapTrafficStatus aMapTrafficStatus = this.mTmcBarItems.get(i3);
                    aMapTrafficStatus.getLength();
                    float round = (float) Math.round(((float) aMapTrafficStatus.getLength()) * f2);
                    if (aMapTrafficStatus.getStatus() >= 2) {
                        float f3 = this.mCursorPos;
                        float f4 = this.mCursorPos;
                    }
                    i2 = (int) (((float) i2) + round);
                    float f5 = (float) i2;
                    canvas2.drawRect(0.0f, f5 - round, (float) width, f5, getPaintInColor(getColor(aMapTrafficStatus.getStatus())));
                }
                if (i2 < height) {
                    canvas2.drawRect(0.0f, (float) i2, (float) width, f, getPaintInColor(getColor(this.mTmcBarItems.get(0).getStatus())));
                }
                if (f > this.mCursorPos) {
                    canvas.drawRect(0.0f, this.mCursorPos, (float) width, f, getPaintInColor(getColor(-1)));
                }
                if (this.mTmcBarListener != null) {
                    this.mTmcBarListener.dismissBottomTag();
                }
                canvas.restore();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private Paint getPaintInColor(int i) {
        if (this.mPaint == null) {
            this.mPaint = new Paint();
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.FILL);
        }
        this.mPaint.setColor(i);
        return this.mPaint;
    }

    public void setUnknownTrafficColor(int i) {
        this.unknownTrafficColor = i;
    }

    public void setSmoothTrafficColor(int i) {
        this.smoothTrafficColor = i;
    }

    public void setSlowTrafficColor(int i) {
        this.slowTrafficColor = i;
    }

    public void setJamTrafficColor(int i) {
        this.jamTrafficColor = i;
    }

    public void setVeryJamTrafficColor(int i) {
        this.veryJamTrafficColor = i;
    }

    private int getColor(int i) {
        switch (i) {
            case 0:
                if (this.unknownTrafficColor != 0) {
                    return this.unknownTrafficColor;
                }
                return Color.rgb(ga.UNKNOWN.a(), ga.UNKNOWN.b(), ga.UNKNOWN.c());
            case 1:
                if (this.smoothTrafficColor != 0) {
                    return this.smoothTrafficColor;
                }
                return Color.rgb(ga.UNBLOCK.a(), ga.UNBLOCK.b(), ga.UNBLOCK.c());
            case 2:
                if (this.slowTrafficColor != 0) {
                    return this.slowTrafficColor;
                }
                return Color.rgb(ga.SLOW.a(), ga.SLOW.b(), ga.SLOW.c());
            case 3:
                if (this.jamTrafficColor != 0) {
                    return this.jamTrafficColor;
                }
                return Color.rgb(ga.BLOCK.a(), ga.BLOCK.b(), ga.BLOCK.c());
            case 4:
                if (this.veryJamTrafficColor != 0) {
                    return this.veryJamTrafficColor;
                }
                return Color.rgb(ga.GRIDLOCKED.a(), ga.GRIDLOCKED.b(), ga.GRIDLOCKED.c());
            default:
                return Color.rgb(ga.NOTRAFFIC.a(), ga.NOTRAFFIC.b(), ga.NOTRAFFIC.c());
        }
    }

    public void setTacBarListener(TmcBarListener tmcBarListener) {
        this.mTmcBarListener = tmcBarListener;
    }
}
