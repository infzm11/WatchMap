package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.iflytek.cloud.util.ContactManager;

public class da extends ContactManager {
    private static da a = null;
    private static Context b = null;
    private static int c = 4;
    private static dg d;
    private static cz e;
    private static a f;
    private static ContactManager.ContactListener h;
    private HandlerThread g = null;
    private Handler i;
    /* access modifiers changed from: private */
    public long j = 0;

    private class a extends ContentObserver {
        public a(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            cb.a("iFly_ContactManager", "ContactObserver_Contact| onChange");
            if (System.currentTimeMillis() - da.this.j < 5000) {
                cb.a("iFly_ContactManager", "onChange too much");
                return;
            }
            long unused = da.this.j = System.currentTimeMillis();
            da.this.d();
        }
    }

    private da() {
        d = Build.VERSION.SDK_INT > c ? new df(b) : new de(b);
        e = new cz(b, d);
        this.g = new HandlerThread("ContactManager_worker");
        this.g.start();
        this.i = new Handler(this.g.getLooper());
        this.g.setPriority(1);
        f = new a(this.i);
    }

    public static da a() {
        return a;
    }

    public static da a(Context context, ContactManager.ContactListener contactListener) {
        h = contactListener;
        b = context;
        if (a == null) {
            a = new da();
            b.getContentResolver().registerContentObserver(d.a(), true, f);
        }
        return a;
    }

    public static void c() {
        if (a != null) {
            a.b();
            a = null;
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        try {
            if (h != null && e != null) {
                String a2 = dc.a(e.a(), 10);
                String str = b.getFilesDir().getParent() + '/' + "name.txt";
                String a3 = db.a(str);
                if (a2 == null || a3 == null || !a2.equals(a3)) {
                    db.a(str, a2, true);
                    h.onContactQueryFinish(a2, true);
                    return;
                }
                cb.a("iFly_ContactManager", "contact name is not change.");
                h.onContactQueryFinish(a2, false);
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
    }

    public void asyncQueryAllContactsName() {
        this.i.post(new Runnable() {
            public void run() {
                da.this.d();
            }
        });
    }

    public void b() {
        if (f != null) {
            b.getContentResolver().unregisterContentObserver(f);
            if (this.g != null) {
                this.g.quit();
            }
        }
    }

    public String queryAllContactsName() {
        if (e == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : e.a()) {
            sb.append(str + 10);
        }
        return sb.toString();
    }
}
