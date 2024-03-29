package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.n3.hs;

public class OverviewButtonView extends ImageView {
    private boolean isON;
    private Bitmap overviewOffBitmap;
    private Bitmap overviewOnBitmap;

    public OverviewButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public OverviewButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public OverviewButtonView(Context context) {
        super(context);
        init();
    }

    private void init() {
        try {
            this.overviewOnBitmap = BitmapFactory.decodeResource(hs.a(), 2130837683);
            this.overviewOffBitmap = BitmapFactory.decodeResource(hs.a(), 2130837684);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reDrawBackground(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            try {
                this.overviewOnBitmap = bitmap;
                this.overviewOffBitmap = bitmap2;
                setChecked(this.isON);
                invalidate();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void setChecked(boolean z) {
        try {
            this.isON = z;
            if (z) {
                setImageBitmap(this.overviewOnBitmap);
            } else {
                setImageBitmap(this.overviewOffBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recycleResource() {
        try {
            if (this.overviewOffBitmap != null) {
                this.overviewOffBitmap.recycle();
                this.overviewOffBitmap = null;
            }
            if (this.overviewOnBitmap != null) {
                this.overviewOnBitmap.recycle();
                this.overviewOnBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
