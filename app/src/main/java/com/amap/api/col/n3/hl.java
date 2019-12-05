package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Html;
import android.text.Spanned;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.model.InnerNaviInfo;
import com.android.hoinnet.highde.R;

/* compiled from: NaviInfoLayout_L */
public final class hl extends hi {
    private Bitmap b;
    private ImageView c;
    private RelativeLayout d;
    private RelativeLayout e;
    private ImageView f;
    private TextView g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private TextView k;
    private Button l;
    private TextView m;
    private TextView n;
    private TextView o;
    private String p;
    private String q;

    private hl(Context context) {
        super(context);
        this.p = "#FFFFFF";
        this.q = "#FFFFFF";
        LinearLayout linearLayout = (LinearLayout) hs.a(context, R.attr.actionMenuTextAppearance, (ViewGroup) null);
        this.c = (ImageView) linearLayout.findViewById(2131296362);
        this.d = (RelativeLayout) linearLayout.findViewById(2131296363);
        this.e = (RelativeLayout) linearLayout.findViewById(2131296375);
        this.f = (ImageView) linearLayout.findViewById(2131296365);
        this.g = (TextView) linearLayout.findViewById(2131296364);
        this.h = (TextView) linearLayout.findViewById(2131296367);
        this.i = (ImageView) linearLayout.findViewById(2131296376);
        this.j = (TextView) linearLayout.findViewById(2131296377);
        this.k = (TextView) linearLayout.findViewById(2131296379);
        this.l = (Button) linearLayout.findViewById(2131296373);
        this.m = (TextView) linearLayout.findViewById(2131296372);
        this.n = (TextView) linearLayout.findViewById(2131296371);
        this.o = (TextView) linearLayout.findViewById(2131296370);
        addView(linearLayout);
    }

    public hl(Context context, byte b2) {
        this(context);
    }

    public final void a(boolean z) {
        if (!z) {
            this.e.setVisibility(0);
            this.d.setVisibility(8);
            return;
        }
        this.e.setVisibility(8);
        this.d.setVisibility(0);
    }

    public final void b(boolean z) {
        super.b(z);
        AMapNavi instance = AMapNavi.getInstance(getContext());
        if (instance != null && instance.getNaviType() == 2) {
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        } else if (z) {
            this.l.setVisibility(0);
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            this.n.setVisibility(8);
        } else {
            this.l.setVisibility(8);
            this.m.setVisibility(0);
            this.o.setVisibility(0);
            this.n.setVisibility(0);
        }
    }

    public final void b() {
        if (this.b != null) {
            this.b.recycle();
            this.b = null;
        }
        this.b = null;
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
        this.n = null;
        this.o = null;
    }

    public final void a(int i2) {
        switch (i2) {
            case 1:
                this.l.setText("低速");
                return;
            case 2:
                this.l.setText("中速");
                return;
            case 3:
                this.l.setText("高速");
                return;
            default:
                return;
        }
    }

    public final void c(boolean z) {
        if (z) {
            this.c.setVisibility(0);
        } else {
            this.c.setVisibility(8);
        }
    }

    public final Button a() {
        return this.l;
    }

    public final void a(InnerNaviInfo innerNaviInfo) {
        if (this.d.getVisibility() == 0) {
            this.g.setText(hq.a(innerNaviInfo.getCurStepRetainDistance()));
            this.h.setText(innerNaviInfo.getNextRoadName());
            Spanned fromHtml = Html.fromHtml(hq.a(hq.b(innerNaviInfo.getPathRetainTime()), this.p, this.q));
            Spanned fromHtml2 = Html.fromHtml(hq.a(innerNaviInfo.getPathRetainDistance(), this.p, this.q));
            this.m.setText(fromHtml);
            this.n.setText(fromHtml2);
        }
        if (this.e.getVisibility() == 0) {
            this.j.setText(hq.a(innerNaviInfo.getCurStepRetainDistance()));
            this.k.setText(innerNaviInfo.getNextRoadName());
        }
        byte[] iconData = innerNaviInfo.getIconData();
        int iconType = innerNaviInfo.getIconType();
        if (iconType <= 19) {
            if (iconData != null) {
                this.b = BitmapFactory.decodeByteArray(iconData, 0, iconData.length);
            } else {
                this.b = BitmapFactory.decodeResource(hs.a(), this.a[iconType]);
            }
            this.f.setImageBitmap(this.b);
            this.i.setImageBitmap(this.b);
        }
    }
}
