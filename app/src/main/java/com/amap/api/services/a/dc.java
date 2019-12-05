package com.amap.api.services.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

/* compiled from: NetManger */
public class dc extends cx {
    private static dc a;
    private dl b;
    private Handler c;

    /* renamed from: com.amap.api.services.a.dc$1  reason: invalid class name */
    /* compiled from: NetManger */
    class AnonymousClass1 extends dm {
        final /* synthetic */ dd a;
        final /* synthetic */ de b;
        final /* synthetic */ dc c;

        public void a() {
            try {
                this.c.a(this.c.b(this.a, false), this.b);
            } catch (ay e) {
                this.c.a(e, this.b);
            }
        }
    }

    /* compiled from: NetManger */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, AnonymousClass1 r2) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        ((dg) message.obj).b.a();
                        return;
                    case 1:
                        dg dgVar = (dg) message.obj;
                        dgVar.b.a(dgVar.a);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static dc a(boolean z) {
        return a(z, 5);
    }

    private static synchronized dc a(boolean z, int i) {
        dc dcVar;
        synchronized (dc.class) {
            try {
                if (a == null) {
                    a = new dc(z, i);
                } else if (z && a.b == null) {
                    a.b = dl.a(i);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            dcVar = a;
        }
        return dcVar;
    }

    private dc(boolean z, int i) {
        if (z) {
            try {
                this.b = dl.a(i);
            } catch (Throwable th) {
                bo.b(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.c = new a(Looper.getMainLooper(), (AnonymousClass1) null);
        } else {
            this.c = new a();
        }
    }

    public byte[] a(dd ddVar) throws ay {
        try {
            df a2 = a(ddVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (ay e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            bo.a().c(th, "NetManager", "makeSyncPostRequest");
            throw new ay("未知的错误");
        }
    }

    public byte[] c(dd ddVar) throws ay {
        try {
            df b2 = b(ddVar, false);
            if (b2 != null) {
                return b2.a;
            }
            return null;
        } catch (ay e) {
            throw e;
        } catch (Throwable unused) {
            throw new ay("未知的错误");
        }
    }

    public byte[] d(dd ddVar) throws ay {
        try {
            df b2 = b(ddVar, true);
            if (b2 != null) {
                return b2.a;
            }
            return null;
        } catch (ay e) {
            throw e;
        } catch (Throwable unused) {
            throw new ay("未知的错误");
        }
    }

    public df b(dd ddVar, boolean z) throws ay {
        Proxy proxy;
        try {
            b(ddVar);
            if (ddVar.h == null) {
                proxy = null;
            } else {
                proxy = ddVar.h;
            }
            return new da(ddVar.f, ddVar.g, proxy, z).a(ddVar.i(), ddVar.e(), ddVar.d());
        } catch (ay e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ay("未知的错误");
        }
    }

    /* access modifiers changed from: private */
    public void a(ay ayVar, de deVar) {
        dg dgVar = new dg();
        dgVar.a = ayVar;
        dgVar.b = deVar;
        Message obtain = Message.obtain();
        obtain.obj = dgVar;
        obtain.what = 1;
        this.c.sendMessage(obtain);
    }

    /* access modifiers changed from: private */
    public void a(df dfVar, de deVar) {
        deVar.a(dfVar.b, dfVar.a);
        dg dgVar = new dg();
        dgVar.b = deVar;
        Message obtain = Message.obtain();
        obtain.obj = dgVar;
        obtain.what = 0;
        this.c.sendMessage(obtain);
    }
}
