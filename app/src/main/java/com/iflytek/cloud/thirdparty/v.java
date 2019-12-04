package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUISetting;
import com.iflytek.cloud.GrammarListener;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.LexiconListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.util.ResourceUtil;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class v extends u {
    /* access modifiers changed from: private */
    public static final String d = (AIUISetting.getAIUIPath() + "asr/grammar/");
    private static Pattern e = Pattern.compile("!grammar .+?;");
    private static Pattern f = Pattern.compile("#BNF.+?;");
    /* access modifiers changed from: private */
    public String g = "cloud";
    /* access modifiers changed from: private */
    public String h = "";
    /* access modifiers changed from: private */
    public String i = "0";
    /* access modifiers changed from: private */
    public String j = "";
    /* access modifiers changed from: private */
    public ae k;
    private HandlerThread l;
    private a m;
    /* access modifiers changed from: private */
    public Object n = new Object();
    /* access modifiers changed from: private */
    public SpeechRecognizer o;
    /* access modifiers changed from: private */
    public boolean p = false;
    /* access modifiers changed from: private */
    public boolean q = false;
    /* access modifiers changed from: private */
    public boolean r = false;
    private GrammarListener s = new GrammarListener() {
        public void onBuildFinish(String str, SpeechError speechError) {
            if (speechError != null) {
                v.this.a(speechError.getErrorCode(), speechError.getErrorDescription());
                cb.c("AsrUnit", "build grammar, error=" + speechError.getErrorCode());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AIUIConstant.KEY_GRAMMAR_ID, str);
                AIUIEvent aIUIEvent = new AIUIEvent(8, 16, 0, jSONObject.toString(), (Bundle) null);
                v.this.a(Message.obtain(v.this.b.a(), 8, aIUIEvent));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    private LexiconListener t = new LexiconListener() {
        public void onLexiconUpdated(String str, SpeechError speechError) {
            if (speechError != null) {
                v.this.a(speechError.getErrorCode(), speechError.getErrorDescription());
                cb.c("AsrUnit", "update asr lexicon, error=" + speechError.getErrorCode());
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(AIUIConstant.KEY_LEXICON_ID, str);
                AIUIEvent aIUIEvent = new AIUIEvent(8, 17, 0, jSONObject.toString(), (Bundle) null);
                v.this.a(Message.obtain(v.this.b.a(), 8, aIUIEvent));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    /* access modifiers changed from: private */
    public RecognizerListener u = new RecognizerListener() {
        public void onBeginOfSpeech() {
        }

        public void onEndOfSpeech() {
        }

        /* JADX INFO: finally extract failed */
        public void onError(SpeechError speechError) {
            synchronized (v.this.n) {
                try {
                    if (!v.this.p) {
                        boolean unused = v.this.r = true;
                    }
                    boolean unused2 = v.this.q = false;
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            if (20005 == speechError.getErrorCode() || 23008 == speechError.getErrorCode()) {
                long currentTimeMillis = System.currentTimeMillis();
                String a2 = am.a();
                JSONObject b = am.b();
                HashMap hashMap = new HashMap();
                try {
                    hashMap.put("0", b.toString().getBytes("utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ad adVar = r5;
                ad adVar2 = new ad("asr", "", a2, v.this.j, hashMap, currentTimeMillis, false);
                v.this.e();
                if ("local".equals(v.this.g)) {
                    adVar.a(true);
                    v.this.k.a(v.this.j, "asr", adVar);
                    v.this.a(a2, (Map<String, byte[]>) hashMap, currentTimeMillis);
                } else if ("mixed".equals(v.this.g)) {
                    v.this.k.a(v.this.j, "asr", adVar);
                }
            } else {
                v.this.a(speechError.getErrorCode(), speechError.getErrorDescription());
            }
            cb.c("AsrUnit", "error=" + speechError.getErrorCode());
        }

        public void onEvent(int i, int i2, int i3, Bundle bundle) {
        }

        public void onResult(RecognizerResult recognizerResult, boolean z) {
            long currentTimeMillis = System.currentTimeMillis();
            synchronized (v.this.n) {
                if (!v.this.p) {
                    boolean unused = v.this.r = true;
                }
                boolean unused2 = v.this.q = false;
            }
            if (!v.this.k.d(v.this.j, "nlp")) {
                HashMap hashMap = new HashMap();
                try {
                    cb.a("asr_result", recognizerResult.getResultString());
                    JSONObject jSONObject = new JSONObject(recognizerResult.getResultString());
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject.put("rc", 0);
                    jSONObject2.put(AIUIConstant.WORK_MODE_INTENT, jSONObject);
                    hashMap.put("0", jSONObject2.toString().getBytes("utf-8"));
                    String a2 = am.a();
                    ad adVar = new ad("asr", "", a2, v.this.j, hashMap, currentTimeMillis, true);
                    v.this.k.a(v.this.j, "asr", adVar);
                    v.this.a(a2, (Map<String, byte[]>) hashMap, currentTimeMillis);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void onVolumeChanged(int i, byte[] bArr) {
        }
    };
    /* access modifiers changed from: private */
    public boolean v = false;

    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        private void a() {
            String a2;
            SpeechRecognizer unused = v.this.o = SpeechRecognizer.createRecognizer(v.this.b.b(), (InitListener) null);
            v.this.o.setParameter("engine_type", "local");
            v.this.o.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
            v.this.o.setParameter(SpeechConstant.RESULT_TYPE, "json");
            v.this.o.setParameter(ResourceUtil.ASR_RES_PATH, v.this.h);
            v.this.o.setParameter(ResourceUtil.GRM_BUILD_PATH, v.d + a2);
            v.this.o.setParameter(SpeechConstant.LOCAL_GRAMMAR, a2);
            v.this.o.setParameter("vad_enable", "0");
            v.this.o.setParameter(SpeechConstant.AUDIO_SOURCE, "-1");
            v.this.o.setParameter(SpeechConstant.ASR_THRESHOLD, v.this.i);
            v.this.o.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "0");
            if (aj.e()) {
                v.this.o.setParameter(SpeechConstant.ASR_AUDIO_PATH, aj.a() + "asr-audio/" + v.this.j + ".pcm");
            }
            v.this.o.startListening(v.this.u);
            boolean unused2 = v.this.p = false;
            boolean unused3 = v.this.r = false;
            boolean unused4 = v.this.q = false;
            cb.a("AsrUnit", "start recognizing.");
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 3:
                    y yVar = (y) message.obj;
                    int i = yVar.c;
                    if (i != 4) {
                        switch (i) {
                            case 1:
                                boolean unused = v.this.v = true;
                                String e = yVar.b.e("stream_id");
                                if (TextUtils.isEmpty(v.this.j) || !v.this.j.equals(e)) {
                                    String unused2 = v.this.j = e;
                                }
                                a();
                                break;
                            case 2:
                                break;
                        }
                        if (v.this.o.isListening()) {
                            v.this.o.writeAudio(yVar.a, 0, yVar.a());
                        }
                    } else if (v.this.v) {
                        boolean unused3 = v.this.v = false;
                        synchronized (v.this.n) {
                            boolean unused4 = v.this.p = true;
                            if (v.this.r) {
                                boolean unused5 = v.this.q = false;
                            } else {
                                boolean unused6 = v.this.q = true;
                            }
                        }
                        if (v.this.o != null) {
                            v.this.o.stopListening();
                        }
                    }
                    while (v.this.q) {
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    return;
                case 4:
                    if (v.this.o != null) {
                        v.this.o.cancel();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public v(t tVar) {
        super("AsrUnit", tVar);
        e();
        this.l = new HandlerThread("AIUI:ASR-HandlerThread");
        this.l.start();
        this.k = ae.a();
    }

    /* access modifiers changed from: private */
    public void a(String str, Map<String, byte[]> map, long j2) {
        try {
            this.b.a().f().a("", str, map, "", this.j, j2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
    }

    private void h() {
        this.h = ResourceUtil.generateResourcePath(this.b.b(), ac.a(ac.a("asr", AIUIConstant.KEY_RES_TYPE, "")), ac.a("asr", AIUIConstant.KEY_RES_PATH, ""));
        this.i = ac.a("asr", "threshold", "0");
    }

    public void a(y yVar) {
        if (this.c && yVar != null) {
            Message.obtain(this.m, 3, yVar).sendToTarget();
        }
    }

    public void a(String str) {
        h();
        String a2 = ac.a("global", "scene", "");
        String str2 = d + a2;
        String str3 = "!grammar " + a2 + VoiceWakeuperAidl.PARAMS_SEPARATE;
        Matcher matcher = e.matcher(str);
        if (matcher.find()) {
            str = matcher.replaceAll(str3);
        } else {
            Matcher matcher2 = f.matcher(str);
            if (matcher2.find()) {
                str = matcher2.replaceAll("$0\n" + str3);
            }
        }
        cb.a("AsrUnit", "replace grammar " + str);
        this.o = SpeechRecognizer.createRecognizer(this.b.b(), (InitListener) null);
        this.o.setParameter("engine_type", "local");
        this.o.setParameter(SpeechConstant.TEXT_ENCODING, "utf-8");
        this.o.setParameter(SpeechConstant.RESULT_TYPE, "json");
        this.o.setParameter(ResourceUtil.ASR_RES_PATH, this.h);
        this.o.setParameter(ResourceUtil.GRM_BUILD_PATH, str2);
        this.o.buildGrammar("bnf", str, this.s);
        cb.a("AsrUnit", "build grammar.");
    }

    public int b() {
        if (this.c) {
            cb.c("AsrUnit", "AsrUnit is already started.");
            return 0;
        }
        h();
        this.m = new a(this.l.getLooper());
        this.c = true;
        this.v = false;
        cb.a("AsrUnit", "AsrUnit started");
        return super.b();
    }

    public void b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("name");
            String string2 = jSONObject.getString(AIUIConstant.KEY_CONTENT);
            String a2 = ac.a("global", "scene", "");
            this.o = SpeechRecognizer.createRecognizer(this.b.b(), (InitListener) null);
            this.o.setParameter("engine_type", "local");
            this.o.setParameter(SpeechConstant.GRAMMAR_LIST, a2);
            this.o.setParameter(SpeechConstant.KEY_REQUEST_FOCUS, "0");
            this.o.updateLexicon(string, string2, this.t);
            cb.a("AsrUnit", "update asr lexicon.");
        } catch (JSONException e2) {
            e2.printStackTrace();
            a(20012, "Invalid asr lexicon json!");
        }
    }

    public void c() {
        this.q = false;
        if (this.m != null) {
            this.m.removeMessages(3);
            Message.obtain(this.m, 4).sendToTarget();
        }
        this.c = false;
        cb.a("AsrUnit", "AsrUnit stopped");
    }

    public void d() {
    }

    public void e() {
        this.g = ac.a("speech", AIUIConstant.KEY_INTENT_ENGINE_TYPE, "cloud");
    }

    public void f() {
        c();
        if (this.l != null) {
            this.l.quit();
        }
        cb.a("AsrUnit", "destoryed");
    }
}
