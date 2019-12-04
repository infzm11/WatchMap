package com.iflytek.sunflower.util;

import android.content.Context;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.task.g;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public class e implements Thread.UncaughtExceptionHandler {
    private static e c;
    private Thread.UncaughtExceptionHandler a;
    private Context b;

    private e(Context context) {
        if (Thread.getDefaultUncaughtExceptionHandler() != this) {
            this.a = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
            this.b = context.getApplicationContext();
        }
    }

    public static void a(Context context) {
        if (c == null) {
            c = new e(context);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (a.k.booleanValue()) {
            String a2 = a(th);
            ErrorEntity errorEntity = new ErrorEntity();
            errorEntity.sid = a.f;
            errorEntity.msg = g.a(a2);
            errorEntity.startTp = System.currentTimeMillis();
            errorEntity.errorType = "crash";
            errorEntity.appver = a.a(this.b).b("app.ver.name");
            com.iflytek.sunflower.e.a(errorEntity);
        }
        new g(this.b).a();
        if (this.a != null) {
            this.a.uncaughtException(thread, th);
        }
    }

    private String a(Throwable th) {
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
