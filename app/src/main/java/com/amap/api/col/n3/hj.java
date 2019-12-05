package com.amap.api.col.n3;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;

/* compiled from: DriveWayLinear */
public final class hj extends LinearLayout {
    LinearLayout.LayoutParams a;
    LinearLayout.LayoutParams b;
    private final int[] c;
    private final int[] d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    public hj(Context context) {
        this(context, (byte) 0);
    }

    private hj(Context context, byte b2) {
        super(context, (AttributeSet) null);
        this.c = new int[]{2130837614, 2130837615, 2130837616, 2130837617, 2130837618, 2130837619, 2130837620, 2130837621, 2130837622, 2130837623, 2130837624, 2130837625, 2130837626, 2130837627, 2130837628};
        this.d = new int[]{2130837629, 2130837630, 2130837616, 2130837633, 2130837618, 2130837636, 2130837620, 2130837621, 2130837642, 2130837623, 2130837624, 2130837625, 2130837626, 2130837651, 2130837628};
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.a = new LinearLayout.LayoutParams(-2, a(context, 39));
        this.b = new LinearLayout.LayoutParams(a(context, 22), a(context, 39));
        this.a.gravity = 81;
        this.b.gravity = 81;
        this.e = a(context, 22);
        this.f = a(context, 39);
        setGravity(1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r17, byte[] r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r16.removeAllViews()
            int r3 = r1.length
            r4 = 0
        L_0x0009:
            r5 = 15
            if (r4 >= r3) goto L_0x0016
            byte r6 = r1[r4]
            if (r6 != r5) goto L_0x0013
            r3 = r4
            goto L_0x0016
        L_0x0013:
            int r4 = r4 + 1
            goto L_0x0009
        L_0x0016:
            r0.i = r3
            r4 = 0
        L_0x0019:
            if (r4 >= r3) goto L_0x0170
            byte r6 = r1[r4]
            byte r7 = r18[r4]
            r9 = 6
            r10 = 12
            r11 = 11
            r12 = 10
            r13 = 9
            r14 = 4
            r2 = 2
            r5 = 14
            r8 = 1
            if (r6 == r5) goto L_0x0043
            if (r6 == r2) goto L_0x0043
            if (r6 == r14) goto L_0x0043
            if (r6 == r13) goto L_0x0043
            if (r6 == r12) goto L_0x0043
            if (r6 == r11) goto L_0x0043
            if (r6 == r10) goto L_0x0043
            if (r6 == r9) goto L_0x0043
            r5 = 7
            if (r6 != r5) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r5 = 0
            goto L_0x0044
        L_0x0043:
            r5 = r8
        L_0x0044:
            r10 = -1
            if (r5 == 0) goto L_0x00e8
            if (r6 != r12) goto L_0x0059
            if (r7 != 0) goto L_0x0050
            r2 = 2130837645(0x7f02008d, float:1.728025E38)
            goto L_0x00de
        L_0x0050:
            r2 = 8
            if (r7 != r2) goto L_0x00dd
            r2 = 2130837646(0x7f02008e, float:1.7280252E38)
            goto L_0x00de
        L_0x0059:
            r5 = 5
            if (r6 != r13) goto L_0x006a
            if (r7 != 0) goto L_0x0063
            r2 = 2130837643(0x7f02008b, float:1.7280246E38)
            goto L_0x00de
        L_0x0063:
            if (r7 != r5) goto L_0x00dd
            r2 = 2130837644(0x7f02008c, float:1.7280248E38)
            goto L_0x00de
        L_0x006a:
            if (r6 != r2) goto L_0x007a
            if (r7 != 0) goto L_0x0073
            r2 = 2130837631(0x7f02007f, float:1.7280222E38)
            goto L_0x00de
        L_0x0073:
            if (r7 != r8) goto L_0x00dd
            r2 = 2130837632(0x7f020080, float:1.7280224E38)
            goto L_0x00de
        L_0x007a:
            r2 = 3
            if (r6 != r14) goto L_0x008a
            if (r7 != 0) goto L_0x0084
            r2 = 2130837634(0x7f020082, float:1.7280228E38)
            goto L_0x00de
        L_0x0084:
            if (r7 != r2) goto L_0x00dd
            r2 = 2130837635(0x7f020083, float:1.728023E38)
            goto L_0x00de
        L_0x008a:
            if (r6 != r9) goto L_0x0098
            if (r7 != r8) goto L_0x0092
            r2 = 2130837637(0x7f020085, float:1.7280234E38)
            goto L_0x00de
        L_0x0092:
            if (r7 != r2) goto L_0x00dd
            r2 = 2130837638(0x7f020086, float:1.7280236E38)
            goto L_0x00de
        L_0x0098:
            r9 = 7
            if (r6 != r9) goto L_0x00ad
            if (r7 != 0) goto L_0x00a1
            r2 = 2130837639(0x7f020087, float:1.7280238E38)
            goto L_0x00de
        L_0x00a1:
            if (r7 != r8) goto L_0x00a7
            r2 = 2130837640(0x7f020088, float:1.728024E38)
            goto L_0x00de
        L_0x00a7:
            if (r7 != r2) goto L_0x00dd
            r2 = 2130837641(0x7f020089, float:1.7280242E38)
            goto L_0x00de
        L_0x00ad:
            if (r6 != r11) goto L_0x00bb
            if (r7 != r5) goto L_0x00b5
            r2 = 2130837648(0x7f020090, float:1.7280256E38)
            goto L_0x00de
        L_0x00b5:
            if (r7 != r8) goto L_0x00dd
            r2 = 2130837647(0x7f02008f, float:1.7280254E38)
            goto L_0x00de
        L_0x00bb:
            r9 = 12
            if (r6 != r9) goto L_0x00cd
            r5 = 8
            if (r7 != r5) goto L_0x00c7
            r2 = 2130837650(0x7f020092, float:1.728026E38)
            goto L_0x00de
        L_0x00c7:
            if (r7 != r2) goto L_0x00dd
            r2 = 2130837649(0x7f020091, float:1.7280258E38)
            goto L_0x00de
        L_0x00cd:
            r2 = 14
            if (r6 != r2) goto L_0x00dd
            if (r7 != r8) goto L_0x00d7
            r2 = 2130837652(0x7f020094, float:1.7280264E38)
            goto L_0x00de
        L_0x00d7:
            if (r7 != r5) goto L_0x00dd
            r2 = 2130837653(0x7f020095, float:1.7280266E38)
            goto L_0x00de
        L_0x00dd:
            r2 = r10
        L_0x00de:
            if (r2 != r10) goto L_0x00e4
            int[] r2 = r0.c
            r2 = r2[r6]
        L_0x00e4:
            r5 = r2
            r2 = 15
            goto L_0x00f7
        L_0x00e8:
            r2 = 15
            if (r7 != r2) goto L_0x00ee
            r5 = 0
            goto L_0x00ef
        L_0x00ee:
            r5 = r8
        L_0x00ef:
            if (r5 == 0) goto L_0x00f6
            int[] r5 = r0.d
            r5 = r5[r7]
            goto L_0x00f7
        L_0x00f6:
            r5 = r10
        L_0x00f7:
            if (r5 != r10) goto L_0x00ff
            int[] r5 = r0.c
            byte r6 = r1[r4]
            r5 = r5[r6]
        L_0x00ff:
            if (r3 != r8) goto L_0x0105
            r6 = 2130837691(0x7f0200bb, float:1.7280343E38)
            goto L_0x011a
        L_0x0105:
            if (r3 <= r8) goto L_0x010d
            if (r4 != 0) goto L_0x010d
            r6 = 2130837690(0x7f0200ba, float:1.7280341E38)
            goto L_0x011a
        L_0x010d:
            if (r3 <= r8) goto L_0x0117
            int r6 = r3 + -1
            if (r4 != r6) goto L_0x0117
            r6 = 2130837692(0x7f0200bc, float:1.7280345E38)
            goto L_0x011a
        L_0x0117:
            r6 = 2130837689(0x7f0200b9, float:1.728034E38)
        L_0x011a:
            android.widget.ImageView r7 = new android.widget.ImageView
            android.content.Context r9 = r16.getContext()
            r7.<init>(r9)
            android.content.res.Resources r9 = com.amap.api.col.n3.hs.a()
            android.graphics.drawable.Drawable r5 = r9.getDrawable(r5)
            r7.setImageDrawable(r5)
            android.content.res.Resources r5 = com.amap.api.col.n3.hs.a()
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r6)
            r7.setBackgroundDrawable(r5)
            android.widget.ImageView$ScaleType r5 = android.widget.ImageView.ScaleType.CENTER_INSIDE
            r7.setScaleType(r5)
            android.widget.LinearLayout$LayoutParams r5 = r0.b
            r0.addView(r7, r5)
            if (r3 <= r8) goto L_0x016b
            int r5 = r3 + -1
            if (r4 >= r5) goto L_0x016b
            android.widget.ImageView r5 = new android.widget.ImageView
            android.content.Context r6 = r16.getContext()
            r5.<init>(r6)
            android.content.res.Resources r6 = com.amap.api.col.n3.hs.a()
            r7 = 2130837685(0x7f0200b5, float:1.7280331E38)
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r5.setImageDrawable(r6)
            r6 = -16739841(0xffffffffff0091ff, float:-1.7089924E38)
            r5.setBackgroundColor(r6)
            android.widget.LinearLayout$LayoutParams r6 = r0.a
            r0.addView(r5, r6)
        L_0x016b:
            int r4 = r4 + 1
            r5 = r2
            goto L_0x0019
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.hj.a(byte[], byte[]):void");
    }

    private static int a(Context context, int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (context == null) {
            return i2;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        } catch (Exception e2) {
            e2.printStackTrace();
            iu.b((Throwable) e2, "AMapNaviView", "dp2px(int dipValue)");
            return i2;
        }
    }
}
