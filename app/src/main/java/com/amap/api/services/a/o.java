package com.amap.api.services.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: ManifestConfig */
public class o {
    public static bh a;
    private static o b;
    /* access modifiers changed from: private */
    public static Context c;
    /* access modifiers changed from: private */
    public a d;
    private HandlerThread e = new HandlerThread("manifestThread") {
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0098, code lost:
            if (com.amap.api.services.a.o.a(r9.a) != null) goto L_0x00ad;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
            if (com.amap.api.services.a.o.a(r9.a) == null) goto L_0x00b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ad, code lost:
            com.amap.api.services.a.o.a(r9.a).sendMessage(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            java.lang.Thread.sleep(10000);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bc, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00bd, code lost:
            r0.printStackTrace();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                java.lang.String r0 = "run"
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                java.lang.String r2 = "ManifestConfigThread"
                r1.setName(r2)
                android.os.Message r1 = new android.os.Message
                r1.<init>()
                r2 = 3
                android.content.Context r3 = com.amap.api.services.a.o.c     // Catch:{ Throwable -> 0x009d }
                r4 = 0
                com.amap.api.services.a.bh r5 = com.amap.api.services.a.h.a(r4)     // Catch:{ Throwable -> 0x009d }
                java.lang.String r6 = "11K;001"
                r7 = 0
                com.amap.api.services.a.ba$a r3 = com.amap.api.services.a.ba.a(r3, r5, r6, r7)     // Catch:{ Throwable -> 0x009d }
                if (r3 == 0) goto L_0x0036
                com.amap.api.services.a.ba$a$a r5 = r3.u     // Catch:{ Throwable -> 0x009d }
                if (r5 == 0) goto L_0x0036
                com.amap.api.services.a.p r5 = new com.amap.api.services.a.p     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.ba$a$a r6 = r3.u     // Catch:{ Throwable -> 0x009d }
                boolean r6 = r6.b     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.ba$a$a r8 = r3.u     // Catch:{ Throwable -> 0x009d }
                boolean r8 = r8.a     // Catch:{ Throwable -> 0x009d }
                r5.<init>(r6, r8)     // Catch:{ Throwable -> 0x009d }
                r1.obj = r5     // Catch:{ Throwable -> 0x009d }
            L_0x0036:
                if (r3 == 0) goto L_0x0090
                com.amap.api.services.a.ba$a$d r5 = r3.v     // Catch:{ Throwable -> 0x009d }
                if (r5 == 0) goto L_0x0090
                com.amap.api.services.a.ba$a$d r3 = r3.v     // Catch:{ Throwable -> 0x009d }
                if (r3 == 0) goto L_0x0080
                java.lang.String r5 = r3.b     // Catch:{ Throwable -> 0x009d }
                java.lang.String r6 = r3.a     // Catch:{ Throwable -> 0x009d }
                java.lang.String r3 = r3.c     // Catch:{ Throwable -> 0x009d }
                boolean r8 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Throwable -> 0x009d }
                if (r8 != 0) goto L_0x006f
                boolean r8 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Throwable -> 0x009d }
                if (r8 != 0) goto L_0x006f
                boolean r8 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Throwable -> 0x009d }
                if (r8 == 0) goto L_0x0059
                goto L_0x006f
            L_0x0059:
                com.amap.api.services.a.ci r7 = new com.amap.api.services.a.ci     // Catch:{ Throwable -> 0x009d }
                r7.<init>(r6, r5, r3)     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.ch r3 = new com.amap.api.services.a.ch     // Catch:{ Throwable -> 0x009d }
                android.content.Context r5 = com.amap.api.services.a.o.c     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.bh r4 = com.amap.api.services.a.h.a(r4)     // Catch:{ Throwable -> 0x009d }
                r3.<init>(r5, r7, r4)     // Catch:{ Throwable -> 0x009d }
                r3.a()     // Catch:{ Throwable -> 0x009d }
                goto L_0x0090
            L_0x006f:
                com.amap.api.services.a.ch r3 = new com.amap.api.services.a.ch     // Catch:{ Throwable -> 0x009d }
                android.content.Context r5 = com.amap.api.services.a.o.c     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.bh r4 = com.amap.api.services.a.h.a(r4)     // Catch:{ Throwable -> 0x009d }
                r3.<init>(r5, r7, r4)     // Catch:{ Throwable -> 0x009d }
                r3.a()     // Catch:{ Throwable -> 0x009d }
                goto L_0x0090
            L_0x0080:
                com.amap.api.services.a.ch r3 = new com.amap.api.services.a.ch     // Catch:{ Throwable -> 0x009d }
                android.content.Context r5 = com.amap.api.services.a.o.c     // Catch:{ Throwable -> 0x009d }
                com.amap.api.services.a.bh r4 = com.amap.api.services.a.h.a(r4)     // Catch:{ Throwable -> 0x009d }
                r3.<init>(r5, r7, r4)     // Catch:{ Throwable -> 0x009d }
                r3.a()     // Catch:{ Throwable -> 0x009d }
            L_0x0090:
                r1.what = r2
                com.amap.api.services.a.o r0 = com.amap.api.services.a.o.this
                com.amap.api.services.a.o$a r0 = r0.d
                if (r0 == 0) goto L_0x00b6
                goto L_0x00ad
            L_0x009b:
                r0 = move-exception
                goto L_0x00c1
            L_0x009d:
                r3 = move-exception
                java.lang.String r4 = "ManifestConfig"
                com.amap.api.services.a.i.a(r3, r4, r0)     // Catch:{ all -> 0x009b }
                r1.what = r2
                com.amap.api.services.a.o r0 = com.amap.api.services.a.o.this
                com.amap.api.services.a.o$a r0 = r0.d
                if (r0 == 0) goto L_0x00b6
            L_0x00ad:
                com.amap.api.services.a.o r0 = com.amap.api.services.a.o.this
                com.amap.api.services.a.o$a r0 = r0.d
                r0.sendMessage(r1)
            L_0x00b6:
                r0 = 10000(0x2710, double:4.9407E-320)
                java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00bc }
                goto L_0x00c0
            L_0x00bc:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00c0:
                return
            L_0x00c1:
                r1.what = r2
                com.amap.api.services.a.o r2 = com.amap.api.services.a.o.this
                com.amap.api.services.a.o$a r2 = r2.d
                if (r2 == 0) goto L_0x00d4
                com.amap.api.services.a.o r2 = com.amap.api.services.a.o.this
                com.amap.api.services.a.o$a r2 = r2.d
                r2.sendMessage(r1)
            L_0x00d4:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.o.AnonymousClass1.run():void");
        }
    };

    /* compiled from: ManifestConfig */
    class a extends Handler {
        String a = "handleMessage";

        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message != null && message.what == 3) {
                try {
                    p pVar = (p) message.obj;
                    if (pVar == null) {
                        pVar = new p(false, false);
                    }
                    bo.a(o.c, h.a(pVar.a()));
                    o.a = h.a(pVar.a());
                } catch (Throwable th) {
                    i.a(th, "ManifestConfig", this.a);
                }
            }
        }
    }

    private o(Context context) {
        c = context;
        a = h.a(false);
        try {
            this.d = new a(Looper.getMainLooper());
            this.e.start();
        } catch (Throwable th) {
            i.a(th, "ManifestConfig", "ManifestConfig");
        }
    }

    public static o a(Context context) {
        if (b == null) {
            b = new o(context);
        }
        return b;
    }
}
