package com.amap.api.col.n3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.net.Proxy;

/* compiled from: NetManger */
public final class ki extends kd {
    private static ki a;
    private ks b;
    private Handler c;

    /* compiled from: NetManger */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b) {
            this(looper);
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }

        public final void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 0:
                        kk kkVar = ((km) message.obj).b;
                        return;
                    case 1:
                        km kmVar = (km) message.obj;
                        kk kkVar2 = kmVar.b;
                        ic icVar = kmVar.a;
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static ki b() {
        return a(true);
    }

    public static ki c() {
        return a(false);
    }

    private static synchronized ki a(boolean z) {
        ki kiVar;
        synchronized (ki.class) {
            try {
                if (a == null) {
                    a = new ki(z);
                } else if (z && a.b == null) {
                    a.b = ks.a(5);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            kiVar = a;
        }
        return kiVar;
    }

    private ki(boolean z) {
        if (z) {
            try {
                this.b = ks.a(5);
            } catch (Throwable th) {
                iu.b(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (Looper.myLooper() == null) {
            this.c = new a(Looper.getMainLooper(), (byte) 0);
        } else {
            this.c = new a();
        }
    }

    public final byte[] a(kj kjVar) throws ic {
        try {
            kl a2 = a(kjVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (ic e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            iu.a().c(th, "NetManager", "makeSyncPostRequest");
            throw new ic("未知的错误");
        }
    }

    public static byte[] d(kj kjVar) throws ic {
        try {
            kl e = e(kjVar);
            if (e != null) {
                return e.a;
            }
            return null;
        } catch (ic e2) {
            throw e2;
        } catch (Throwable unused) {
            throw new ic("未知的错误");
        }
    }

    public static kl e(kj kjVar) throws ic {
        Proxy proxy;
        try {
            c(kjVar);
            if (kjVar.h == null) {
                proxy = null;
            } else {
                proxy = kjVar.h;
            }
            return new kg(kjVar.f, kjVar.g, proxy, false).a(kjVar.c(), kjVar.a(), kjVar.b());
        } catch (ic e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ic("未知的错误");
        }
    }
}
