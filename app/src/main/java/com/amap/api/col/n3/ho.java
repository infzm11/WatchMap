package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.navi.AMapNavi;
import com.amap.api.navi.AmapNaviPage;
import com.amap.api.navi.INaviInfoCallback;
import com.android.hoinnet.highde.R;

/* compiled from: StrategyPopWindow */
public final class ho extends PopupWindow implements View.OnClickListener {
    private static int a = 5;
    private Context b;
    private RelativeLayout c;
    private RelativeLayout d;
    private RelativeLayout e;
    private RelativeLayout f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private ImageView r;
    private RelativeLayout s;

    public static void a() {
        a = 5;
    }

    public static int b() {
        return a;
    }

    public static void c() {
        a--;
    }

    public ho(final Context context) {
        this.b = context;
        View a2 = hs.a(context, R.attr.actionModeCloseButtonStyle, (ViewGroup) null);
        ((RadioGroup) a2.findViewById(2131296321)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                try {
                    ho.a();
                    AMapNavi instance = AMapNavi.getInstance(context);
                    if (instance != null) {
                        if (i == 2131296322) {
                            AMapNavi.setTtsPlaying(false);
                            instance.setBroadcastMode(2);
                        }
                        if (i == 2131296323) {
                            AMapNavi.setTtsPlaying(false);
                            instance.setBroadcastMode(1);
                        }
                        if (i == 2131296324) {
                            AMapNavi.setTtsPlaying(true);
                            INaviInfoCallback callback = AmapNaviPage.getInstance().getCallback();
                            if (callback != null) {
                                callback.onStopSpeaking();
                            }
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.s = (RelativeLayout) a2.findViewById(2131296415);
        this.c = (RelativeLayout) a2.findViewById(2131296417);
        this.d = (RelativeLayout) a2.findViewById(2131296420);
        this.e = (RelativeLayout) a2.findViewById(2131296423);
        this.f = (RelativeLayout) a2.findViewById(2131296426);
        this.o = (ImageView) a2.findViewById(2131296418);
        this.p = (ImageView) a2.findViewById(2131296421);
        this.q = (ImageView) a2.findViewById(2131296424);
        this.r = (ImageView) a2.findViewById(2131296427);
        this.k = (TextView) a2.findViewById(2131296419);
        this.l = (TextView) a2.findViewById(2131296422);
        this.m = (TextView) a2.findViewById(2131296425);
        this.n = (TextView) a2.findViewById(2131296428);
        this.c.setOnClickListener(this);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
        ((Button) a2.findViewById(2131296429)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    ho.this.dismiss();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        setOutsideTouchable(true);
        setContentView(a2);
        setHeight(((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight() / 2);
        setWidth(-1);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(-1342177280));
        this.g = hf.a(context, "NAVI_STRATEGY_TAB1");
        this.h = hf.a(context, "NAVI_STRATEGY_TAB2");
        this.i = hf.a(context, "NAVI_STRATEGY_TAB3");
        this.j = hf.a(context, "NAVI_STRATEGY_TAB4");
    }

    public final void d() {
        if (this.g) {
            this.c.setBackgroundDrawable(hs.a().getDrawable(2130837755));
            this.o.setImageDrawable(hs.a().getDrawable(2130837530));
            this.k.setTextColor(-1);
        } else {
            this.c.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.o.setImageDrawable(hs.a().getDrawable(2130837529));
            this.k.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this.h) {
            this.d.setBackgroundDrawable(hs.a().getDrawable(2130837755));
            this.p.setImageDrawable(hs.a().getDrawable(2130837526));
            this.l.setTextColor(-1);
        } else {
            this.d.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.p.setImageDrawable(hs.a().getDrawable(2130837525));
            this.l.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this.i) {
            this.e.setBackgroundDrawable(hs.a().getDrawable(2130837755));
            this.q.setImageDrawable(hs.a().getDrawable(2130837528));
            this.m.setTextColor(-1);
        } else {
            this.e.setBackgroundDrawable(hs.a().getDrawable(2130837723));
            this.q.setImageDrawable(hs.a().getDrawable(2130837527));
            this.m.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        }
        if (this.j) {
            this.f.setBackgroundDrawable(hs.a().getDrawable(2130837755));
            this.r.setImageDrawable(hs.a().getDrawable(2130837532));
            this.n.setTextColor(-1);
            return;
        }
        this.f.setBackgroundDrawable(hs.a().getDrawable(2130837723));
        this.r.setImageDrawable(hs.a().getDrawable(2130837531));
        this.n.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    public final void a(boolean z) {
        if (this.s != null) {
            this.s.setVisibility(z ? 0 : 8);
        }
    }

    public final void onClick(View view) {
        TextView textView;
        TextView textView2;
        try {
            int id = view.getId();
            if (id == 2131296417) {
                if (this.g) {
                    hf.a(this.b, false);
                    this.g = false;
                    this.c.setBackgroundDrawable(hs.a().getDrawable(2130837723));
                    this.o.setImageDrawable(hs.a().getDrawable(2130837529));
                    textView2 = this.k;
                } else {
                    hf.a(this.b, true);
                    this.g = true;
                    this.c.setBackgroundDrawable(hs.a().getDrawable(2130837755));
                    this.o.setImageDrawable(hs.a().getDrawable(2130837530));
                    textView = this.k;
                    textView.setTextColor(-1);
                    a = 5;
                }
            } else if (id == 2131296420) {
                if (this.h) {
                    hf.b(this.b, false);
                    this.h = false;
                    this.d.setBackgroundDrawable(hs.a().getDrawable(2130837723));
                    this.p.setImageDrawable(hs.a().getDrawable(2130837525));
                    textView2 = this.l;
                } else {
                    if (this.j) {
                        this.f.performClick();
                    }
                    hf.b(this.b, true);
                    this.h = true;
                    this.d.setBackgroundDrawable(hs.a().getDrawable(2130837755));
                    this.p.setImageDrawable(hs.a().getDrawable(2130837526));
                    textView = this.l;
                    textView.setTextColor(-1);
                    a = 5;
                }
            } else if (id != 2131296423) {
                if (id == 2131296426) {
                    if (this.j) {
                        hf.d(this.b, false);
                        this.j = false;
                        this.f.setBackgroundDrawable(hs.a().getDrawable(2130837723));
                        this.r.setImageDrawable(hs.a().getDrawable(2130837531));
                        textView2 = this.n;
                    } else {
                        if (this.i) {
                            this.e.performClick();
                        }
                        if (this.h) {
                            this.d.performClick();
                        }
                        hf.d(this.b, true);
                        this.j = true;
                        this.f.setBackgroundDrawable(hs.a().getDrawable(2130837755));
                        this.r.setImageDrawable(hs.a().getDrawable(2130837532));
                        textView = this.n;
                        textView.setTextColor(-1);
                    }
                }
                a = 5;
            } else if (this.i) {
                hf.c(this.b, false);
                this.i = false;
                this.e.setBackgroundDrawable(hs.a().getDrawable(2130837723));
                this.q.setImageDrawable(hs.a().getDrawable(2130837527));
                textView2 = this.m;
            } else {
                if (this.j) {
                    this.f.performClick();
                }
                hf.c(this.b, true);
                this.i = true;
                this.e.setBackgroundDrawable(hs.a().getDrawable(2130837755));
                this.q.setImageDrawable(hs.a().getDrawable(2130837528));
                textView = this.m;
                textView.setTextColor(-1);
                a = 5;
            }
            textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            a = 5;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void e() {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
    }
}
