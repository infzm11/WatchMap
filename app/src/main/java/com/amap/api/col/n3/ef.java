package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IndoorFloorSwitchView */
public class ef extends ScrollView {
    public static final String a = "ef";
    int b = 1;
    private Context c;
    private LinearLayout d;
    /* access modifiers changed from: private */
    public int e = 0;
    private List<String> f;
    private int g = -1;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public Bitmap i = null;
    /* access modifiers changed from: private */
    public int j = Color.parseColor("#eeffffff");
    /* access modifiers changed from: private */
    public int k = Color.parseColor("#44383838");
    /* access modifiers changed from: private */
    public int l = 4;
    /* access modifiers changed from: private */
    public int m = 1;
    private int n;
    /* access modifiers changed from: private */
    public int o;
    /* access modifiers changed from: private */
    public Runnable p;
    /* access modifiers changed from: private */
    public int q = 50;
    private a r;

    /* compiled from: IndoorFloorSwitchView */
    public interface a {
        void a(int i);
    }

    static /* synthetic */ void d(ef efVar) {
        if (efVar.r != null) {
            try {
                a aVar = efVar.r;
                int i2 = 0;
                if (efVar.f != null) {
                    if (efVar.f.size() != 0) {
                        i2 = Math.min(efVar.f.size() - (2 * efVar.m), Math.max(0, ((efVar.f.size() - 1) - efVar.b) - efVar.m));
                    }
                }
                aVar.a(i2);
            } catch (Throwable unused) {
            }
        }
    }

    static /* synthetic */ int[] i(ef efVar) {
        return new int[]{efVar.e * efVar.m, efVar.e * (efVar.m + 1)};
    }

    public ef(Context context) {
        super(context);
        this.c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.i == null) {
                InputStream open = dr.a(context).open("map_indoor_select.png");
                this.i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        this.d = new LinearLayout(context);
        this.d.setOrientation(1);
        addView(this.d);
        this.p = new Runnable() {
            public final void run() {
                if (ef.this.o - ef.this.getScrollY() != 0) {
                    int unused = ef.this.o = ef.this.getScrollY();
                    ef.this.postDelayed(ef.this.p, (long) ef.this.q);
                } else if (ef.this.e != 0) {
                    final int a2 = ef.this.o % ef.this.e;
                    final int a3 = ef.this.o / ef.this.e;
                    if (a2 == 0) {
                        ef.this.b = a3 + ef.this.m;
                        ef.d(ef.this);
                    } else if (a2 > ef.this.e / 2) {
                        ef.this.post(new Runnable() {
                            public final void run() {
                                ef.this.smoothScrollTo(0, (ef.this.o - a2) + ef.this.e);
                                ef.this.b = a3 + ef.this.m + 1;
                                ef.d(ef.this);
                            }
                        });
                    } else {
                        ef.this.post(new Runnable() {
                            public final void run() {
                                ef.this.smoothScrollTo(0, ef.this.o - a2);
                                ef.this.b = a3 + ef.this.m;
                                ef.d(ef.this);
                            }
                        });
                    }
                }
            }
        };
    }

    private void c() {
        if (this.f != null && this.f.size() != 0) {
            this.d.removeAllViews();
            this.n = (this.m * 2) + 1;
            for (int size = this.f.size() - 1; size >= 0; size--) {
                LinearLayout linearLayout = this.d;
                TextView textView = new TextView(this.c);
                textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                textView.setSingleLine(true);
                textView.setTextSize(2, 16.0f);
                textView.setText(this.f.get(size));
                textView.setGravity(17);
                textView.getPaint().setFakeBoldText(true);
                int a2 = a(this.c, 8.0f);
                int a3 = a(this.c, 6.0f);
                textView.setPadding(a2, a3, a2, a3);
                if (this.e == 0) {
                    textView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
                    this.e = textView.getMeasuredHeight();
                    this.d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.e * this.n));
                    setLayoutParams(new LinearLayout.LayoutParams(-2, this.e * this.n));
                }
                linearLayout.addView(textView);
            }
            a(0);
        }
    }

    private void a(int i2) {
        if (this.e != 0) {
            int i3 = (i2 / this.e) + this.m;
            int i4 = i2 % this.e;
            int i5 = i2 / this.e;
            if (i4 == 0) {
                i3 = this.m + i5;
            } else if (i4 > this.e / 2) {
                i3 = i5 + this.m + 1;
            }
            int childCount = this.d.getChildCount();
            int i6 = 0;
            while (i6 < childCount) {
                TextView textView = (TextView) this.d.getChildAt(i6);
                if (textView != null) {
                    if (i3 == i6) {
                        textView.setTextColor(Color.parseColor("#0288ce"));
                    } else {
                        textView.setTextColor(Color.parseColor("#bbbbbb"));
                    }
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    public final void a(String[] strArr) {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        this.f.clear();
        for (String add : strArr) {
            this.f.add(add);
        }
        for (int i2 = 0; i2 < this.m; i2++) {
            this.f.add(0, "");
            this.f.add("");
        }
        c();
    }

    public void setBackgroundColor(int i2) {
        this.j = i2;
    }

    public final void a() {
        if (this.i != null && !this.i.isRecycled()) {
            this.i.recycle();
            this.i = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.h == 0) {
            try {
                this.h = ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getWidth();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() {
            public final int getOpacity() {
                return 0;
            }

            public final void setAlpha(int i) {
            }

            public final void setColorFilter(ColorFilter colorFilter) {
            }

            public final void draw(Canvas canvas) {
                try {
                    canvas.drawColor(ef.this.j);
                    Paint paint = new Paint();
                    Rect rect = new Rect();
                    Rect rect2 = new Rect();
                    rect.left = 0;
                    rect.top = 0;
                    rect.right = ef.this.i.getWidth() + 0;
                    rect.bottom = ef.this.i.getHeight() + 0;
                    rect2.left = 0;
                    rect2.top = ef.i(ef.this)[0];
                    rect2.right = 0 + ef.this.h;
                    rect2.bottom = ef.i(ef.this)[1];
                    canvas.drawBitmap(ef.this.i, rect, rect2, paint);
                    Paint paint2 = new Paint();
                    Rect clipBounds = canvas.getClipBounds();
                    paint2.setColor(ef.this.k);
                    paint2.setStyle(Paint.Style.STROKE);
                    paint2.setStrokeWidth((float) ef.this.l);
                    canvas.drawRect(clipBounds, paint2);
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.h = i2;
        try {
            setBackgroundDrawable((Drawable) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a(i3);
        if (i3 > i5) {
            this.g = 1;
        } else {
            this.g = 0;
        }
    }

    public final void a(String str) {
        if (this.f != null && this.f.size() != 0) {
            final int size = ((this.f.size() - this.m) - 1) - this.f.indexOf(str);
            this.b = this.m + size;
            post(new Runnable() {
                public final void run() {
                    ef.this.smoothScrollTo(0, size * ef.this.e);
                }
            });
        }
    }

    public void fling(int i2) {
        super.fling(i2 / 3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.o = getScrollY();
            postDelayed(this.p, (long) this.q);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void a(a aVar) {
        this.r = aVar;
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public final boolean b() {
        return getVisibility() == 0;
    }
}
