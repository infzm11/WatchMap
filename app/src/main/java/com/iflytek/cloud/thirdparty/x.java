package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.thirdparty.ae;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class x extends u {
    /* access modifiers changed from: private */
    public ae d;
    /* access modifiers changed from: private */
    public String e = "";
    /* access modifiers changed from: private */
    public ah f;
    private HandlerThread g;
    private a h;
    private LexiconListener i = new LexiconListener() {
        public void onLexiconUpdated(String str, SpeechError speechError) {
            if (speechError != null) {
                x.this.a(speechError.getErrorCode(), speechError.getErrorDescription());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AIUIConstant.KEY_LEXICON_ID, str);
                AIUIEvent aIUIEvent = new AIUIEvent(8, 11, 0, jSONObject.toString(), (Bundle) null);
                x.this.a(Message.obtain(x.this.b.a(), 8, aIUIEvent));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public aj j;

    class a extends Handler {
        private boolean b = false;

        public a(Looper looper) {
            super(looper);
            x.this.j.b();
        }

        private boolean a(y yVar) {
            return yVar != null && 4 == yVar.c;
        }

        private void b(y yVar) {
            String b2;
            String e = yVar.b.e("stream_id");
            ce a2 = ac.a(yVar.b);
            String b3 = yVar.b.b(AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
            yVar.b.d(AIUIConstant.KEY_INTENT_ENGINE_TYPE);
            if (a(yVar)) {
                try {
                    if (this.b && x.this.f != null) {
                        if (!"local".equals(b3)) {
                            x.this.f.c(a2);
                        }
                        x.this.d.a(x.this.e, System.currentTimeMillis());
                        cb.a("IatUnit", "stmid=" + x.this.e + ", confidence=" + b2);
                        try {
                            x.this.d.a(x.this.e, Float.parseFloat(b2));
                        } catch (NumberFormatException e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (n e3) {
                    x.this.a(e3);
                }
                this.b = false;
                x.this.j.c();
                return;
            }
            boolean z = true;
            if (!this.b) {
                this.b = true;
                String unused = x.this.e = e;
                x.this.d.a(x.this.e, new ae.a(Long.valueOf(System.currentTimeMillis()), (Long) null, "", new HashMap()));
                String b4 = yVar.b.b(AIUIConstant.KEY_TAG, "");
                if (!TextUtils.isEmpty(b4)) {
                    x.this.d.a(x.this.e, b4);
                }
                x.this.j.a(e, ".pcm", false);
            } else {
                z = false;
            }
            try {
                if (x.this.f != null && !"local".equals(b3)) {
                    x.this.f.a(a2, yVar.a, yVar.a(), z);
                }
            } catch (n e4) {
                x.this.a(e4);
            }
            x.this.j.a(yVar.a, false);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                b((y) message.obj);
            }
        }
    }

    public x(t tVar) {
        super("IatUnit", tVar);
        e();
        this.j = new aj();
        this.g = new HandlerThread("AIUI:IAT-WriteAudioThread");
        this.g.start();
        this.d = ae.a();
    }

    /* access modifiers changed from: private */
    public void a(n nVar) {
        af a2 = this.b.a();
        if (nVar != null && a2 != null) {
            AIUIEvent aIUIEvent = new AIUIEvent(2, nVar.a(), 0, nVar.b(), (Bundle) null);
            a2.sendMessage(a2.obtainMessage(7, aIUIEvent));
        }
    }

    public void a(y yVar) {
        synchronized (this) {
            if (this.h != null) {
                this.h.obtainMessage(1, yVar).sendToTarget();
            }
        }
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString(AIUIConstant.KEY_CONTENT);
            SpeechRecognizer createRecognizer = SpeechRecognizer.createRecognizer(this.b.b(), (InitListener) null);
            createRecognizer.setParameter(AIUIConstant.KEY_SERVER_URL, "http://open.xf-yun.com/index.htm");
            createRecognizer.setParameter("engine_type", "cloud");
            createRecognizer.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
            createRecognizer.setParameter("ent", "aiui-smsfar");
            createRecognizer.updateLexicon(string, string2, this.i);
        } catch (JSONException e2) {
            e2.printStackTrace();
            a(20012, "Invalid upload lexicon json!");
        }
    }

    public int b() {
        String str;
        String str2;
        if (this.c) {
            str = "IatUnit";
            str2 = "IatUnit is already started.";
        } else {
            this.f = this.b.a().e();
            this.h = new a(this.g.getLooper());
            this.c = true;
            str = "IatUnit";
            str2 = "IatUnit started.";
        }
        cb.a(str, str2);
        return 0;
    }

    public void c() {
        synchronized (this) {
            y yVar = new y(new byte[0], "");
            yVar.c = 4;
            yVar.a("stream_id", this.e, true);
            a(yVar);
            this.h = null;
            this.c = false;
        }
        cb.a("IatUnit", "IatUnit stopped.");
    }

    public void e() {
    }

    public void f() {
        c();
        if (this.g != null) {
            this.g.quit();
        }
    }
}
