package com.iflytek.sunflower.nativecrash;

import android.content.Context;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.os.SystemClock;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.sunflower.FlowerCollector;
import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.task.g;
import com.iflytek.sunflower.util.a;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;

public class b implements a {
    /* access modifiers changed from: private */
    public static final String a = "b";
    private Context b;
    /* access modifiers changed from: private */
    public LocalServerSocket c;
    private String d;

    public b(Context context) {
        this.b = context;
    }

    private String c() {
        if (l.a((CharSequence) this.d)) {
            this.d = this.b.getPackageName() + ".singelinstance" + System.currentTimeMillis();
        }
        return this.d;
    }

    public void a() {
        int a2 = a.a();
        if (a2 >= 21) {
            try {
                this.c = new LocalServerSocket(c());
                j.a(a, "start | start localServerSocket");
                d();
            } catch (Exception e) {
                j.d(a, "", e);
            }
        }
        try {
            NaitveCrashCollect.a(this.b, this, this.b.getFilesDir().getAbsolutePath(), c(), a2);
            j.a(a, "start | loadLibrary finished");
        } catch (Throwable th) {
            FlowerCollector.onError(this.b, th.getMessage() + "", th.getCause() + "");
            j.d(a, "start | NaitveCrashCollect.loadLibrary error");
        }
    }

    public void a(String str, String str2, int i) {
        String str3 = a;
        j.d(str3, "onNativeCrash | msg = " + str2 + ", threadId = " + i);
        String str4 = a;
        StringBuilder sb = new StringBuilder();
        sb.append("onNativeCrash | crashStack = ");
        sb.append(str);
        j.d(str4, sb.toString());
        if (com.iflytek.sunflower.config.a.k.booleanValue()) {
            ErrorEntity errorEntity = new ErrorEntity();
            errorEntity.sid = com.iflytek.sunflower.config.a.f;
            errorEntity.errorType = "crash_native";
            errorEntity.threadName = str2;
            errorEntity.startTp = System.currentTimeMillis();
            errorEntity.msg = str;
            e.a(errorEntity);
        }
        new g(this.b).a();
        SystemClock.sleep(500);
    }

    private void d() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    j.a(b.a, "startLocalServerSocket | run");
                    while (true) {
                        LocalSocket accept = b.this.c.accept();
                        j.a(b.a, "startLocalServerSocket | localServerSocket.accept()");
                        b.this.a(accept);
                    }
                } catch (Exception e) {
                    j.d(b.a, "startLocalServerSocket | error", e);
                }
            }
        });
        thread.setName("LocalServerThread");
        thread.start();
    }

    /* access modifiers changed from: private */
    public void a(final LocalSocket localSocket) {
        j.a(a, "handleLocalSocketConnect");
        new Thread(new Runnable() {
            public void run() {
                if (localSocket != null) {
                    while (localSocket.getInputStream() != null) {
                        try {
                            byte[] bArr = new byte[102400];
                            localSocket.getInputStream().available();
                            int read = localSocket.getInputStream().read(bArr);
                            String str = new String(bArr, 0, read);
                            String b2 = b.a;
                            j.a(b2, "localSocketTask.run | read length = " + read);
                            b.this.a(str);
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    Thread.sleep(100);
                }
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        String[] split = str.split(":|;");
        String str2 = null;
        int i = 0;
        String str3 = null;
        for (int i2 = 0; i2 < split.length - 1; i2 += 2) {
            String str4 = split[i2];
            String str5 = split[i2 + 1];
            if ("crash_thread_id".equals(str4)) {
                try {
                    i = Integer.valueOf(str5).intValue();
                } catch (Exception e) {
                    j.d(a, "handleCrashMsg error", e);
                }
            } else if ("reason".equals(str4)) {
                str3 = str5;
            } else if (AIUIConstant.KEY_CONTENT.equals(str4)) {
                str2 = str5;
            }
        }
        a(str2, str3, i);
    }
}
