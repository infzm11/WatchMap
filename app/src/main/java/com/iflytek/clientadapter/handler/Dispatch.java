package com.iflytek.clientadapter.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class Dispatch {
    /* access modifiers changed from: private */
    public static final String TAG = "Dispatch";
    private static Dispatch dispatch;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("reConnect");
    /* access modifiers changed from: private */
    public MessageEntity mHandlerThreadMessage = new MessageEntity();

    private Dispatch() {
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                HandleListener takeMessage = Dispatch.this.mHandlerThreadMessage.takeMessage(message);
                if (takeMessage != null) {
                    takeMessage.handleMessage((Message) message.obj);
                } else {
                    Log.e(Dispatch.TAG, "listener is null");
                }
            }
        };
        this.mHandler.post(new Runnable() {
            public void run() {
                Process.setThreadPriority(-4);
            }
        });
    }

    public static Dispatch getInstance() {
        if (dispatch == null) {
            dispatch = new Dispatch();
        }
        return dispatch;
    }

    public void sendMessage(Message message, String str, HandleListener handleListener) {
        sendMessageDelayed(message, 0, str, handleListener);
    }

    public void sendMessageDelayed(Message message, long j, String str, HandleListener handleListener) {
        if (handleListener == null) {
            String str2 = TAG;
            Log.e(str2, String.valueOf(str) + " : HandleListener is null");
            return;
        }
        this.mHandler.sendMessageDelayed(this.mHandlerThreadMessage.obtainMessage(message, str, handleListener), j);
    }

    public void removeMessage(String str) {
        this.mHandlerThreadMessage.removeMessage(str);
    }
}
