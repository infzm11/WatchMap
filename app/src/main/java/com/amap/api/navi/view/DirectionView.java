package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.n3.hs;

public class DirectionView extends ImageView {
    private int height;
    private Bitmap mDirectionBitmap;
    private int mLastAngle;
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private int width;

    public DirectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        try {
            this.mDirectionBitmap = BitmapFactory.decodeResource(hs.a(), 2130837694);
            setImageBitmap(this.mDirectionBitmap);
            this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
            this.width = this.mDirectionBitmap.getWidth();
            this.height = this.mDirectionBitmap.getHeight();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public DirectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DirectionView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            getImageMatrix().setRotate((float) this.mLastAngle, ((float) this.width) / 2.0f, ((float) this.height) / 2.0f);
            canvas.setDrawFilter(this.mPaintFlagsDrawFilter);
            super.onDraw(canvas);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setRotate(float f) {
        try {
            int i = (int) f;
            if (this.mLastAngle != i) {
                this.mLastAngle = i;
                invalidate();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recycleResource() {
        try {
            if (this.mDirectionBitmap != null) {
                this.mDirectionBitmap.recycle();
                this.mDirectionBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Bitmap getDirectionBitmap() {
        return this.mDirectionBitmap;
    }

    public void setDirectionBitmap(Bitmap bitmap) {
        this.mDirectionBitmap = bitmap;
        setImageBitmap(this.mDirectionBitmap);
    }
}
