package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.iflytek.aiui.AIUIEvent;
import com.iflytek.aiui.AIUIListener;
import com.iflytek.aiui.AIUIMessage;

public class p {
    private HandlerThread a;
    private af b;
    private Context c;
    private HandlerThread d = new HandlerThread("AIUI:AudioThrowThread");
    /* access modifiers changed from: private */
    public Handler e = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (message.what == 1 && p.this.g != null) {
                AIUIEvent aIUIEvent = (AIUIEvent) message.obj;
                if (2 != aIUIEvent.eventType || (10141 != aIUIEvent.arg1 && 10142 != aIUIEvent.arg1)) {
                    p.this.g.onEvent(aIUIEvent);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public Handler f;
    /* access modifiers changed from: private */
    public AIUIListener g;
    private AIUIListener h;

    public p(Context context) {
        this.c = context;
    }

    public int a(String str, AIUIListener aIUIListener) {
        this.g = aIUIListener;
        this.d.start();
        this.f = new Handler(this.d.getLooper()) {
            public void handleMessage(Message message) {
                if (message.what == 1 && p.this.g != null) {
                    p.this.g.onEvent((AIUIEvent) message.obj);
                }
            }
        };
        this.h = new AIUIListener() {
            public void onEvent(AIUIEvent aIUIEvent) {
                Message.obtain(aIUIEvent.eventType == 9 ? p.this.f : p.this.e, 1, aIUIEvent).sendToTarget();
            }
        };
        this.a = new HandlerThread("AIUI:SchedulerThread");
        this.a.start();
        this.b = new af(this.c, this.a.getLooper(), str, this.h);
        return this.b.a(true);
    }

    public void a() {
        if (this.a != null) {
            this.a.quit();
        }
        if (this.b != null) {
            this.b.a();
            this.b = null;
        }
        this.d.getLooper().quit();
    }

    public void a(AIUIMessage aIUIMessage) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = aIUIMessage;
        if (this.b != null) {
            this.b.sendMessage(obtain);
        }
    }
}
