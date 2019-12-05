package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.n3.hs;

public class TrafficButtonView extends ImageView {
    private boolean mIsTrafficOpen;
    private Bitmap trafficCloseBitmap;
    private Bitmap trafficOpenBitmap;

    public TrafficButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initBackground();
    }

    public TrafficButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initBackground();
    }

    public TrafficButtonView(Context context) {
        super(context);
        initBackground();
    }

    private void initBackground() {
        try {
            this.trafficOpenBitmap = BitmapFactory.decodeResource(hs.a(), 2130837682);
            this.trafficCloseBitmap = BitmapFactory.decodeResource(hs.a(), 2130837681);
            setIsTrafficOpen(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void reDrawBackground(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && bitmap2 != null) {
            try {
                this.trafficOpenBitmap = bitmap;
                this.trafficCloseBitmap = bitmap2;
                setIsTrafficOpen(this.mIsTrafficOpen);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean getIsTrafficOpen() {
        return this.mIsTrafficOpen;
    }

    public void setIsTrafficOpen(boolean z) {
        try {
            this.mIsTrafficOpen = z;
            if (this.mIsTrafficOpen) {
                setImageBitmap(this.trafficOpenBitmap);
            } else {
                setImageBitmap(this.trafficCloseBitmap);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recycleResource() {
        try {
            if (this.trafficCloseBitmap != null) {
                this.trafficCloseBitmap.recycle();
                this.trafficCloseBitmap = null;
            }
            if (this.trafficOpenBitmap != null) {
                this.trafficOpenBitmap.recycle();
                this.trafficOpenBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
