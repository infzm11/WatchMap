package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.navi.model.InnerNaviInfo;
import com.android.hoinnet.highde.R;

/* compiled from: NaviInfoLayout_P */
public final class hm extends hi {
    private Bitmap b;
    private RelativeLayout c;
    private RelativeLayout d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;

    private hm(Context context) {
        super(context);
        LinearLayout linearLayout = (LinearLayout) hs.a(context, R.attr.actionMenuTextColor, (ViewGroup) null);
        this.c = (RelativeLayout) linearLayout.findViewById(2131296386);
        this.d = (RelativeLayout) linearLayout.findViewById(2131296381);
        this.m = (ImageView) linearLayout.findViewById(2131296380);
        this.e = (ImageView) linearLayout.findViewById(2131296382);
        this.f = (TextView) linearLayout.findViewById(2131296383);
        this.g = (TextView) linearLayout.findViewById(2131296384);
        this.h = (TextView) linearLayout.findViewById(2131296385);
        this.i = (ImageView) linearLayout.findViewById(2131296388);
        this.j = (TextView) linearLayout.findViewById(2131296387);
        this.k = (TextView) linearLayout.findViewById(2131296378);
        this.l = (TextView) linearLayout.findViewById(2131296389);
        addView(linearLayout);
    }

    public hm(Context context, byte b2) {
        this(context);
    }

    public final void a(InnerNaviInfo innerNaviInfo) {
        if (!(this.f == null || this.h == null)) {
            this.f.setText(hq.a(innerNaviInfo.getCurStepRetainDistance()));
            this.h.setText(innerNaviInfo.getNextRoadName());
        }
        if (!(this.j == null || this.l == null)) {
            this.j.setText(hq.a(innerNaviInfo.getCurStepRetainDistance()));
            this.l.setText(innerNaviInfo.getNextRoadName());
        }
        byte[] iconData = innerNaviInfo.getIconData();
        int iconType = innerNaviInfo.getIconType();
        if (iconType <= 19) {
            if (iconData != null) {
                this.b = BitmapFactory.decodeByteArray(iconData, 0, iconData.length);
            } else {
                this.b = BitmapFactory.decodeResource(hs.a(), this.a[iconType]);
            }
            this.i.setImageBitmap(this.b);
            this.e.setImageBitmap(this.b);
        }
    }

    public final void a(boolean z) {
        if (z) {
            this.c.setVisibility(8);
            this.d.setVisibility(0);
            return;
        }
        this.c.setVisibility(0);
        this.d.setVisibility(8);
    }

    public final void b() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
    }

    public final void c(boolean z) {
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }
}
