package com.iflytek.cloud.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.resource.Resource;
import com.iflytek.cloud.thirdparty.bu;
import com.iflytek.cloud.thirdparty.bw;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cg;
import com.iflytek.cloud.thirdparty.cs;
import com.iflytek.cloud.thirdparty.cv;
import com.iflytek.cloud.thirdparty.cw;

public final class a extends cv implements View.OnClickListener {
    public static int a = 9;
    private LinearLayout d;
    /* access modifiers changed from: private */
    public cw e = null;
    private RotateAnimation f = null;
    /* access modifiers changed from: private */
    public SpeechRecognizer g;
    /* access modifiers changed from: private */
    public RecognizerDialogListener h;
    private long i = 0;
    private RecognizerListener j = new RecognizerListener() {
        public void onBeginOfSpeech() {
        }

        public void onEndOfSpeech() {
            a.this.j();
        }

        public void onError(SpeechError speechError) {
            if (speechError == null || !a.this.b) {
                a.this.f();
            } else {
                a.this.a(speechError);
            }
            if (a.this.h != null) {
                a.this.h.onError(speechError);
            }
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
        }

        public void onResult(RecognizerResult recognizerResult, boolean z) {
            if (z) {
                a.this.f();
            }
            if (a.this.h != null) {
                a.this.h.onResult(recognizerResult, z);
            }
        }

        public void onVolumeChanged(int i, byte[] bArr) {
            if (a.this.k == 1 && a.this.e != null) {
                a.this.e.setVolume((i + 2) / 5);
                a.this.e.invalidate();
            }
        }
    };
    /* access modifiers changed from: private */
    public volatile int k;

    /* renamed from: com.iflytek.cloud.ui.a$a  reason: collision with other inner class name */
    public class C0006a extends ClickableSpan {
        private String b;

        public C0006a(String str) {
            this.b = str;
        }

        public void onClick(View view) {
            try {
                Context context = view.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.b));
                intent.addFlags(268435456);
                intent.putExtra("com.android.browser.application_id", context.getPackageName());
                context.startActivity(intent);
            } catch (Exception e) {
                cb.a((Throwable) e);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
        }
    }

    public a(Context context, InitListener initListener) {
        super(context.getApplicationContext());
        this.g = SpeechRecognizer.createRecognizer(context.getApplicationContext(), initListener);
        a();
    }

    /* access modifiers changed from: private */
    public void a(SpeechError speechError) {
        try {
            LinearLayout linearLayout = (LinearLayout) this.d.findViewWithTag("error");
            a((TextView) linearLayout.findViewWithTag("errtxt"), speechError);
            linearLayout.findViewWithTag("errview").setBackgroundDrawable(cs.a(getContext(), "warning"));
            setTag(speechError);
            this.k = 3;
            k();
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
    }

    private void g() {
        cb.a("startRecognizing");
        long j2 = this.i;
        this.i = SystemClock.elapsedRealtime();
        if (this.i - j2 >= 300) {
            this.g.setParameter("msc.skin", "default");
            int startListening = this.g.startListening(this.j);
            if (startListening != 0) {
                a(new SpeechError(startListening));
            } else {
                i();
            }
        }
    }

    private void h() {
        if (this.d != null) {
            this.d.destroyDrawingCache();
            this.d = null;
        }
        this.e = null;
        System.gc();
    }

    /* access modifiers changed from: private */
    public void i() {
        if (this.e == null) {
            this.e = new cw(getContext().getApplicationContext());
        }
        this.k = 1;
        k();
    }

    /* access modifiers changed from: private */
    public void j() {
        try {
            ((FrameLayout) this.d.findViewWithTag("waiting")).findViewWithTag("control").startAnimation(this.f);
            this.k = 2;
            k();
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        FrameLayout frameLayout = (FrameLayout) this.d.findViewWithTag("waiting");
        TextView textView = (TextView) this.d.findViewWithTag("title");
        LinearLayout linearLayout = (LinearLayout) this.d.findViewWithTag("error");
        TextView textView2 = (TextView) frameLayout.findViewWithTag("tips");
        if (this.k == 1) {
            linearLayout.setVisibility(8);
            textView.setVisibility(0);
            frameLayout.setVisibility(8);
            textView.setText(Resource.getTitle(2));
            this.e.setVolume(0);
            this.e.invalidate();
            this.e.setVisibility(0);
        } else if (this.k == 2) {
            textView.setVisibility(8);
            this.e.setVisibility(8);
            frameLayout.setVisibility(0);
            textView2.setVisibility(0);
            textView2.setText(Resource.getTitle(3));
        } else if (this.k == 3) {
            textView.setVisibility(8);
            this.e.setVisibility(8);
            frameLayout.setVisibility(8);
            linearLayout.setVisibility(0);
        }
    }

    public void a() {
        try {
            final Context applicationContext = getContext().getApplicationContext();
            View a2 = cs.a(applicationContext, "recognize", this);
            a2.setBackgroundDrawable(cs.a(applicationContext.getApplicationContext(), "voice_bg.9"));
            TextView textView = (TextView) a2.findViewWithTag("textlink");
            textView.getPaint().setFlags(8);
            textView.setText("语音识别能力由讯飞输入法提供");
            textView.setLinksClickable(true);
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        String b2 = bu.b(cg.a());
                        Uri parse = Uri.parse("http://www.xunfei.cn/?appid=" + b2);
                        cb.a(parse.toString());
                        Intent intent = new Intent("android.intent.action.VIEW", parse);
                        intent.addFlags(268435456);
                        int unused = a.this.k = 1;
                        a.this.k();
                        a.this.g.stopListening();
                        a.this.i();
                        applicationContext.getApplicationContext().startActivity(intent);
                    } catch (Exception unused2) {
                        cb.e("failed");
                    }
                }
            });
            this.d = (LinearLayout) a2.findViewWithTag("container");
            bw.a(this);
            this.e = new cw(applicationContext.getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
            layoutParams.bottomMargin = 20;
            this.d.addView(this.e, 1, layoutParams);
            ((FrameLayout) this.d.findViewWithTag("waiting")).findViewWithTag("control").setBackgroundDrawable(cs.a(getContext(), "waiting"));
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
            this.f = rotateAnimation;
            this.f.setRepeatCount(-1);
            this.f.setInterpolator(new LinearInterpolator());
            this.f.setDuration(700);
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
    }

    public void a(TextView textView, SpeechError speechError) {
        boolean z;
        String parameter = this.g.getParameter("view_tips_plain");
        textView.setText(Html.fromHtml(speechError.getHtmlDescription(!(parameter != null && (parameter.equalsIgnoreCase("true") || parameter.equalsIgnoreCase("1"))))));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.bringToFront();
        CharSequence text = textView.getText();
        if (text instanceof Spannable) {
            int length = text.length();
            Spannable spannable = (Spannable) textView.getText();
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
            spannableStringBuilder.clearSpans();
            for (URLSpan uRLSpan : uRLSpanArr) {
                spannableStringBuilder.setSpan(new C0006a(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 34);
            }
            int length2 = speechError.getHtmlDescription(false).length();
            int length3 = speechError.getHtmlDescription(true).length() - "<br>".length();
            spannableStringBuilder.setSpan(new ForegroundColorSpan(cs.a()[0]), 0, length2, 34);
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cs.b()[0], true), 0, length2, 33);
            if (!z) {
                int i2 = length2 + 1;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(cs.a()[1]), i2, length3 + 1, 34);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(cs.b()[1], true), i2, length, 34);
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public void a(String str, String str2) {
        this.g.setParameter(str, str2);
    }

    public void b() {
        super.b();
        g();
    }

    public void c() {
        if (this.g.isListening()) {
            this.g.cancel();
        }
        super.c();
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        if (!super.d()) {
            return false;
        }
        h();
        return this.g.destroy();
    }

    public void onClick(View view) {
        int i2 = this.k;
        if (i2 == 1) {
            this.g.stopListening();
            j();
        } else if (i2 == 3) {
            if (view.getTag() == null || ((SpeechError) view.getTag()).getErrorCode() != 20001) {
                g();
            } else {
                e();
            }
        }
    }

    public void setResultListener(RecognizerDialogListener recognizerDialogListener) {
        this.h = recognizerDialogListener;
        setOnClickListener(this);
    }

    public void setTitle(CharSequence charSequence) {
        ((TextView) this.d.findViewWithTag("title")).setText(charSequence);
    }
}
