package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.n3.hs;
import com.amap.api.navi.model.AMapTrafficStatus;
import java.util.List;

public class CustomTmcView extends ImageView {
    private RectF colorRectF;
    Bitmap displayingBitmap;
    private int drawTmcBarBgX;
    private int drawTmcBarBgY;
    int left;
    private List<AMapTrafficStatus> mTmcSections;
    Paint paint;
    int progressBarHeight;
    private Bitmap rawBitmap;
    int right;
    private int tmcBarBgHeight = 0;
    private int tmcBarBgWidth;
    Bitmap tmcBarBitmapLandscape;
    Bitmap tmcBarBitmapPortrait;
    private int tmcBarTopMargin = 30;
    private int totalDis = 0;

    public CustomTmcView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            initResource();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public CustomTmcView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        try {
            initResource();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public CustomTmcView(Context context) {
        super(context);
        try {
            initResource();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Bitmap getDisplayingBitmap() {
        return this.displayingBitmap;
    }

    private void initResource() {
        this.rawBitmap = BitmapFactory.decodeResource(hs.a(), 2130837706);
        this.tmcBarBitmapPortrait = this.rawBitmap;
        this.left = (this.tmcBarBitmapPortrait.getWidth() * 20) / 100;
        this.right = (this.tmcBarBitmapPortrait.getWidth() * 78) / 100;
        this.progressBarHeight = (int) (((double) this.tmcBarBitmapPortrait.getHeight()) * 0.81d);
        this.tmcBarBgWidth = this.tmcBarBitmapPortrait.getWidth();
        this.tmcBarBgHeight = this.tmcBarBitmapPortrait.getHeight();
        this.paint = new Paint();
        if (Build.VERSION.SDK_INT >= 11) {
            this.tmcBarTopMargin = (Math.abs(this.progressBarHeight - this.tmcBarBitmapPortrait.getHeight()) / 4) - ((int) (((double) this.progressBarHeight) * 0.017d));
        } else {
            this.tmcBarTopMargin = (Math.abs(this.progressBarHeight - this.tmcBarBitmapPortrait.getHeight()) / 4) - 3;
        }
        setTmcBarHeightWhenLandscape(0.6666666666666666d);
        this.displayingBitmap = this.tmcBarBitmapPortrait;
        this.colorRectF = new RectF();
    }

    public void onConfigurationChanged(boolean z) {
        if (z) {
            try {
                this.displayingBitmap = this.tmcBarBitmapLandscape;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        } else {
            this.displayingBitmap = this.tmcBarBitmapPortrait;
        }
        setProgressBarSize(z);
    }

    private void setProgressBarSize(boolean z) {
        this.progressBarHeight = (int) (((double) this.displayingBitmap.getHeight()) * 0.81d);
        this.tmcBarBgWidth = this.displayingBitmap.getWidth();
        this.tmcBarBgHeight = this.displayingBitmap.getHeight();
        if (z || Build.VERSION.SDK_INT >= 11) {
            this.tmcBarTopMargin = (Math.abs(this.progressBarHeight - this.displayingBitmap.getHeight()) / 4) - ((int) (((double) this.progressBarHeight) * 0.017d));
        } else {
            this.tmcBarTopMargin = (Math.abs(this.progressBarHeight - this.displayingBitmap.getHeight()) / 4) - 4;
        }
    }

    public void update(List<AMapTrafficStatus> list, int i) {
        this.mTmcSections = list;
        this.totalDis = i;
        try {
            if (produceFinalBitmap() != null) {
                setImageBitmap(produceFinalBitmap());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    public Bitmap produceFinalBitmap() {
        try {
            if (this.mTmcSections == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(this.displayingBitmap.getWidth(), this.displayingBitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            this.paint.setStyle(Paint.Style.FILL);
            float f = (float) this.totalDis;
            for (int i = 0; i < this.mTmcSections.size(); i++) {
                AMapTrafficStatus aMapTrafficStatus = this.mTmcSections.get(i);
                switch (aMapTrafficStatus.getStatus()) {
                    case 1:
                        this.paint.setColor(Color.parseColor("#05C300"));
                        break;
                    case 2:
                        this.paint.setColor(Color.parseColor("#FFD615"));
                        break;
                    case 3:
                        this.paint.setColor(Color.argb(255, 255, 93, 91));
                        break;
                    case 4:
                        this.paint.setColor(Color.argb(255, 179, 17, 15));
                        break;
                    default:
                        this.paint.setColor(Color.argb(255, 26, 166, 239));
                        break;
                }
                if (f - ((float) aMapTrafficStatus.getLength()) > 0.0f) {
                    this.colorRectF.set((float) this.left, ((((float) this.progressBarHeight) * (f - ((float) aMapTrafficStatus.getLength()))) / ((float) this.totalDis)) + ((float) this.tmcBarTopMargin), (float) this.right, ((((float) this.progressBarHeight) * f) / ((float) this.totalDis)) + ((float) this.tmcBarTopMargin));
                } else {
                    this.colorRectF.set((float) this.left, (float) this.tmcBarTopMargin, (float) this.right, ((((float) this.progressBarHeight) * f) / ((float) this.totalDis)) + ((float) this.tmcBarTopMargin));
                }
                if (i == this.mTmcSections.size() - 1) {
                    this.colorRectF.set((float) this.left, (float) this.tmcBarTopMargin, (float) this.right, ((((float) this.progressBarHeight) * f) / ((float) this.totalDis)) + ((float) this.tmcBarTopMargin));
                }
                canvas.drawRect(this.colorRectF, this.paint);
                f -= (float) aMapTrafficStatus.getLength();
            }
            this.paint.setColor(SupportMenu.CATEGORY_MASK);
            canvas.drawBitmap(this.displayingBitmap, 0.0f, 0.0f, (Paint) null);
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void setTmcBarPosition(int i, int i2, int i3, int i4, boolean z) {
        double d = (double) i2;
        double d2 = (double) i3;
        try {
            setTmcBarHeightWhenLandscape((0.6666666666666666d * d) / d2);
            setTmcBarHeightWhenPortrait((1.0d * d) / d2);
            int i5 = (i4 * i2) / i3;
            onConfigurationChanged(z);
            if (z) {
                this.drawTmcBarBgX = Math.abs(i - ((int) (1.3d * ((double) this.tmcBarBgWidth))));
                this.drawTmcBarBgY = ((i2 - (this.tmcBarBgHeight / 2)) * 6) / 10;
                return;
            }
            this.drawTmcBarBgX = Math.abs(i - ((int) (1.3d * ((double) this.tmcBarBgWidth))));
            this.drawTmcBarBgY = (int) ((d - (1.5d * ((double) i5))) - ((double) this.tmcBarBgHeight));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTmcBarHeightWhenLandscape(double d) {
        if (d > 1.0d) {
            d = 1.0d;
        } else if (d < 0.1d) {
            d = 0.1d;
        }
        try {
            this.tmcBarBitmapLandscape = Bitmap.createScaledBitmap(this.rawBitmap, this.rawBitmap.getWidth(), (int) (((double) this.rawBitmap.getHeight()) * d), true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTmcBarHeightWhenPortrait(double d) {
        if (d > 1.0d) {
            d = 1.0d;
        } else if (d < 0.1d) {
            d = 0.1d;
        }
        try {
            this.tmcBarBitmapPortrait = Bitmap.createScaledBitmap(this.rawBitmap, this.rawBitmap.getWidth(), (int) (((double) this.rawBitmap.getHeight()) * d), true);
            this.displayingBitmap = this.tmcBarBitmapPortrait;
            setProgressBarSize(false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getTmcBarBgPosX() {
        return this.drawTmcBarBgX;
    }

    public int getTmcBarBgPosY() {
        return this.drawTmcBarBgY;
    }

    public int getTmcBarBgWidth() {
        return this.tmcBarBgWidth;
    }

    public int getTmcBarBgHeight() {
        return this.tmcBarBgHeight;
    }

    public void recycleResource() {
        try {
            if (this.displayingBitmap != null) {
                this.displayingBitmap.recycle();
                this.displayingBitmap = null;
            }
            if (this.tmcBarBitmapPortrait != null) {
                this.tmcBarBitmapPortrait.recycle();
                this.tmcBarBitmapPortrait = null;
            }
            if (this.tmcBarBitmapLandscape != null) {
                this.tmcBarBitmapLandscape.recycle();
                this.tmcBarBitmapLandscape = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
