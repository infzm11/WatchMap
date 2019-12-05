package com.amap.api.navi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.amap.api.col.n3.hs;
import com.amap.api.navi.AMapNaviView;

public class DriveWayView extends ImageView {
    private int[] driveWayBackgroundId = {2130837614, 2130837615, 2130837616, 2130837617, 2130837618, 2130837619, 2130837620, 2130837621, 2130837622, 2130837623, 2130837624, 2130837625, 2130837626, 2130837627, 2130837628};
    private Bitmap[] driveWayBitMapBgs = null;
    private Bitmap[] driveWayBitMaps = null;
    private int[] driveWayForegroundId = {2130837629, 2130837630, 2130837616, 2130837633, 2130837618, 2130837636, 2130837620, 2130837621, 2130837642, 2130837623, 2130837624, 2130837625, 2130837626, 2130837651, 2130837628};
    private int driveWayHeight = 0;
    private int driveWaySize = 0;
    private int driveWayWidth = 0;
    private int height;
    private AMapNaviView mAMapNaviView = null;
    private int width;

    private boolean isComplexLane(int i) {
        return i == 14 || i == 2 || i == 4 || i == 9 || i == 10 || i == 11 || i == 12 || i == 6 || i == 7;
    }

    private boolean isThisLaneRecommended(byte b) {
        return b != 15;
    }

    public DriveWayView(Context context) {
        super(context);
    }

    public DriveWayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DriveWayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int getDriveWayWidth() {
        return this.driveWayWidth;
    }

    public void setAMapNaviView(AMapNaviView aMapNaviView) {
        this.mAMapNaviView = aMapNaviView;
    }

    public void loadDriveWayBitmap(byte[] bArr, byte[] bArr2) {
        try {
            this.driveWaySize = parseDriveWaySize(bArr);
            if (this.driveWaySize != 0) {
                this.driveWayBitMapBgs = new Bitmap[this.driveWaySize];
                this.driveWayBitMaps = new Bitmap[this.driveWaySize];
                int i = 0;
                while (i < this.driveWaySize) {
                    this.driveWayBitMapBgs[i] = BitmapFactory.decodeResource(hs.a(), this.driveWayBackgroundId[bArr[i]]);
                    if (isComplexLane(bArr[i])) {
                        this.driveWayBitMaps[i] = complexBitmap(bArr[i], bArr2[i]);
                    } else if (isThisLaneRecommended(bArr2[i])) {
                        this.driveWayBitMaps[i] = BitmapFactory.decodeResource(hs.a(), this.driveWayForegroundId[bArr2[i]]);
                    } else {
                        this.driveWayBitMaps[i] = this.driveWayBitMapBgs[i];
                    }
                    i++;
                }
                int i2 = i - 1;
                if (this.driveWayBitMapBgs[i2] != null) {
                    this.driveWayWidth = this.driveWayBitMapBgs[i2].getWidth();
                    this.driveWayHeight = this.driveWayBitMapBgs[i2].getHeight();
                }
                this.height = this.driveWayHeight;
                this.width = this.driveWayWidth * this.driveWaySize;
                setImageBitmap(produceFinalBitmap());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private int parseDriveWaySize(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] == 15) {
                return i;
            }
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap complexBitmap(int r6, int r7) {
        /*
            r5 = this;
            r0 = 8
            r1 = 10
            if (r6 != r1) goto L_0x0024
            if (r7 != 0) goto L_0x0015
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837645(0x7f02008d, float:1.728025E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x0015:
            if (r7 != r0) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837646(0x7f02008e, float:1.7280252E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x0024:
            r1 = 9
            r2 = 5
            if (r6 != r1) goto L_0x0047
            if (r7 != 0) goto L_0x0038
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837643(0x7f02008b, float:1.7280246E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x0038:
            if (r7 != r2) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837644(0x7f02008c, float:1.7280248E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x0047:
            r1 = 2
            r3 = 1
            if (r6 != r1) goto L_0x0069
            if (r7 != 0) goto L_0x005a
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837631(0x7f02007f, float:1.7280222E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x005a:
            if (r7 != r3) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837632(0x7f020080, float:1.7280224E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x0069:
            r1 = 4
            r4 = 3
            if (r6 != r1) goto L_0x008b
            if (r7 != 0) goto L_0x007c
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837634(0x7f020082, float:1.7280228E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x007c:
            if (r7 != r4) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837635(0x7f020083, float:1.728023E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x008b:
            r1 = 6
            if (r6 != r1) goto L_0x00ac
            if (r7 != r3) goto L_0x009d
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837637(0x7f020085, float:1.7280234E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x009d:
            if (r7 != r4) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837638(0x7f020086, float:1.7280236E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00ac:
            r1 = 7
            if (r6 != r1) goto L_0x00db
            if (r7 != 0) goto L_0x00be
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837639(0x7f020087, float:1.7280238E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00be:
            if (r7 != r3) goto L_0x00cd
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837640(0x7f020088, float:1.728024E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00cd:
            if (r7 != r4) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837641(0x7f020089, float:1.7280242E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00db:
            r1 = 11
            if (r6 != r1) goto L_0x00fb
            if (r7 != r2) goto L_0x00ed
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837648(0x7f020090, float:1.7280256E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00ed:
            if (r7 != r3) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837647(0x7f02008f, float:1.7280254E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x00fb:
            r1 = 12
            if (r6 != r1) goto L_0x011b
            if (r7 != r0) goto L_0x010d
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837650(0x7f020092, float:1.728026E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x010d:
            if (r7 != r4) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837649(0x7f020091, float:1.7280258E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x011b:
            r0 = 14
            if (r6 != r0) goto L_0x013b
            if (r7 != r3) goto L_0x012d
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837652(0x7f020094, float:1.7280264E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x012d:
            if (r7 != r2) goto L_0x013b
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            r0 = 2130837653(0x7f020095, float:1.7280266E38)
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r0)
            goto L_0x013c
        L_0x013b:
            r7 = 0
        L_0x013c:
            if (r7 != 0) goto L_0x014a
            android.content.res.Resources r7 = com.amap.api.col.n3.hs.a()
            int[] r0 = r5.driveWayBackgroundId
            r6 = r0[r6]
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeResource(r7, r6)
        L_0x014a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.navi.view.DriveWayView.complexBitmap(int, int):android.graphics.Bitmap");
    }

    public void setDefaultTopMargin(int i) {
        try {
            if (this.mAMapNaviView != null) {
                int i2 = (this.mAMapNaviView.isOrientationLandscape() || !this.mAMapNaviView.isShowRoadEnlarge()) ? i + 10 : ((i * 3) / 8) - (this.driveWayHeight >> 1);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
                layoutParams.setMargins(0, i2, 0, 0);
                setLayoutParams(layoutParams);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void recycleResource() {
        int i = 0;
        while (i < this.driveWaySize) {
            try {
                if (this.driveWayBitMaps[i] != null) {
                    this.driveWayBitMaps[i].recycle();
                    this.driveWayBitMaps[i] = null;
                }
                if (this.driveWayBitMapBgs[i] != null) {
                    this.driveWayBitMapBgs[i].recycle();
                    this.driveWayBitMapBgs[i] = null;
                }
                i++;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.driveWaySize = 0;
    }

    /* access modifiers changed from: package-private */
    public Bitmap produceFinalBitmap() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
            for (int i = 0; i < this.driveWaySize; i++) {
                if (this.driveWayBitMaps[i] != null) {
                    canvas.drawBitmap(this.driveWayBitMaps[i], (float) (this.driveWayWidth * i), 0.0f, (Paint) null);
                }
            }
            return createBitmap;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int getDriveWaySize() {
        return this.driveWaySize;
    }

    public int getDriveWayBgHeight() {
        return this.driveWayHeight;
    }
}
