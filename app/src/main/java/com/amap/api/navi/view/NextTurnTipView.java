package com.amap.api.navi.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.amap.api.col.n3.hs;

public class NextTurnTipView extends ImageView {
    private int[] customIconTypeDrawables;
    private Resources customRes;
    private int[] defaultIconTypes = {2130837549, 2130837549, 2130837746, 2130837747, 2130837748, 2130837749, 2130837750, 2130837751, 2130837752, 2130837753, 2130837736, 2130837737, 2130837738, 2130837739, 2130837740, 2130837741, 2130837742, 2130837743, 2130837744, 2130837745};
    private long mLastIconType = -1;
    private Bitmap nextTurnBitmap;

    public Resources getCustomResources() {
        return this.customRes;
    }

    public int[] getCustomIconTypeDrawables() {
        return this.customIconTypeDrawables;
    }

    public void setCustomIconTypes(Resources resources, int[] iArr) {
        if (resources != null && iArr != null) {
            try {
                this.customRes = resources;
                this.customIconTypeDrawables = new int[(iArr.length + 2)];
                for (int i = 0; i < iArr.length; i++) {
                    this.customIconTypeDrawables[i + 2] = iArr[i];
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public NextTurnTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public NextTurnTipView(Context context) {
        super(context);
    }

    public void recycleResource() {
        try {
            if (this.nextTurnBitmap != null) {
                this.nextTurnBitmap.recycle();
                this.nextTurnBitmap = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setIconType(int i) {
        if (i <= 19) {
            try {
                long j = (long) i;
                if (this.mLastIconType != j) {
                    recycleResource();
                    if (this.customIconTypeDrawables == null || this.customRes == null) {
                        this.nextTurnBitmap = BitmapFactory.decodeResource(hs.a(), this.defaultIconTypes[i]);
                    } else {
                        this.nextTurnBitmap = BitmapFactory.decodeResource(this.customRes, this.customIconTypeDrawables[i]);
                    }
                    setImageBitmap(this.nextTurnBitmap);
                    this.mLastIconType = j;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
