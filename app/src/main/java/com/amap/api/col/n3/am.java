package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: OfflineDownloadManager */
public class am {
    public static String a = "";
    public static boolean b = false;
    public static String d = "";
    private static volatile am k;
    List<al> c = new Vector();
    b e = null;
    public aq f;
    as g;
    ap h = null;
    /* access modifiers changed from: private */
    public Context i;
    /* access modifiers changed from: private */
    public boolean j = true;
    /* access modifiers changed from: private */
    public a l;
    private av m;
    /* access modifiers changed from: private */
    public bb n;
    private ExecutorService o = null;
    private ExecutorService p = null;
    private ExecutorService q = null;
    private boolean r = true;

    /* compiled from: OfflineDownloadManager */
    public interface a {
        void a();

        void a(al alVar);

        void b(al alVar);

        void c(al alVar);
    }

    /* compiled from: OfflineDownloadManager */
    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            al alVar;
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof al) {
                    "OfflineMapHandler handleMessage CitObj  name: " + alVar.getCity() + " complete: " + alVar.getcompleteCode() + " status: " + ((al) obj).getState();
                    if (am.this.l != null) {
                        am.this.l.a(alVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private am(Context context) {
        this.i = context;
    }

    public static am a(Context context) {
        if (k == null) {
            synchronized (am.class) {
                if (k == null && !b) {
                    k = new am(context.getApplicationContext());
                }
            }
        }
        return k;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b5 A[Catch:{ JSONException -> 0x00c6, Throwable -> 0x00db }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            android.content.Context r0 = r7.i
            android.content.Context r0 = r0.getApplicationContext()
            com.amap.api.col.n3.bb r0 = com.amap.api.col.n3.bb.a((android.content.Context) r0)
            r7.n = r0
            java.lang.String r0 = "000001"
            com.amap.api.col.n3.bb r1 = r7.n     // Catch:{ Throwable -> 0x0026 }
            com.amap.api.col.n3.aw r1 = r1.a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0026 }
            if (r1 == 0) goto L_0x002e
            com.amap.api.col.n3.bb r2 = r7.n     // Catch:{ Throwable -> 0x0026 }
            r2.c(r0)     // Catch:{ Throwable -> 0x0026 }
            java.lang.String r0 = "100000"
            r1.c(r0)     // Catch:{ Throwable -> 0x0026 }
            com.amap.api.col.n3.bb r0 = r7.n     // Catch:{ Throwable -> 0x0026 }
            r0.a((com.amap.api.col.n3.aw) r1)     // Catch:{ Throwable -> 0x0026 }
            goto L_0x002e
        L_0x0026:
            r0 = move-exception
            java.lang.String r1 = "OfflineDownloadManager"
            java.lang.String r2 = "changeBadCase"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r0, (java.lang.String) r1, (java.lang.String) r2)
        L_0x002e:
            android.content.Context r0 = r7.i
            android.os.Looper r0 = r0.getMainLooper()
            com.amap.api.col.n3.am$b r1 = new com.amap.api.col.n3.am$b
            r1.<init>(r0)
            r7.e = r1
            com.amap.api.col.n3.aq r0 = new com.amap.api.col.n3.aq
            android.content.Context r1 = r7.i
            com.amap.api.col.n3.am$b r2 = r7.e
            r0.<init>(r1, r2)
            r7.f = r0
            com.amap.api.col.n3.av r0 = com.amap.api.col.n3.av.a()
            r7.m = r0
            android.content.Context r0 = r7.i
            java.lang.String r0 = com.amap.api.col.n3.dv.b((android.content.Context) r0)
            a = r0
            android.content.Context r0 = r7.i     // Catch:{ Throwable -> 0x00db }
            java.lang.String r0 = com.amap.api.col.n3.dv.b((android.content.Context) r0)     // Catch:{ Throwable -> 0x00db }
            java.lang.String r1 = ""
            boolean r0 = r0.equals(r1)     // Catch:{ Throwable -> 0x00db }
            if (r0 != 0) goto L_0x00df
            java.io.File r0 = new java.io.File     // Catch:{ Throwable -> 0x00db }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00db }
            r1.<init>()     // Catch:{ Throwable -> 0x00db }
            android.content.Context r2 = r7.i     // Catch:{ Throwable -> 0x00db }
            java.lang.String r2 = com.amap.api.col.n3.dv.b((android.content.Context) r2)     // Catch:{ Throwable -> 0x00db }
            r1.append(r2)     // Catch:{ Throwable -> 0x00db }
            java.lang.String r2 = "offlinemapv4.png"
            r1.append(r2)     // Catch:{ Throwable -> 0x00db }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x00db }
            r0.<init>(r1)     // Catch:{ Throwable -> 0x00db }
            boolean r1 = r0.exists()     // Catch:{ Throwable -> 0x00db }
            if (r1 != 0) goto L_0x008d
            android.content.Context r1 = r7.i     // Catch:{ Throwable -> 0x00db }
            java.lang.String r2 = "offlinemapv4.png"
            java.lang.String r1 = com.amap.api.col.n3.bj.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00db }
            goto L_0x0091
        L_0x008d:
            java.lang.String r1 = com.amap.api.col.n3.bj.c(r0)     // Catch:{ Throwable -> 0x00db }
        L_0x0091:
            if (r1 == 0) goto L_0x00df
            android.content.Context r2 = r7.i     // Catch:{ JSONException -> 0x00c6 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ JSONException -> 0x00c6 }
            if (r1 == 0) goto L_0x00ae
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r1)     // Catch:{ JSONException -> 0x00c6 }
            if (r3 == 0) goto L_0x00a4
            goto L_0x00ae
        L_0x00a4:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00c6 }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x00c6 }
            java.util.List r1 = com.amap.api.col.n3.bj.a((org.json.JSONObject) r3, (android.content.Context) r2)     // Catch:{ JSONException -> 0x00c6 }
            goto L_0x00b3
        L_0x00ae:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ JSONException -> 0x00c6 }
            r1.<init>()     // Catch:{ JSONException -> 0x00c6 }
        L_0x00b3:
            if (r1 == 0) goto L_0x00df
            int r2 = r1.size()     // Catch:{ JSONException -> 0x00c6 }
            if (r2 != 0) goto L_0x00bc
            goto L_0x00df
        L_0x00bc:
            com.amap.api.col.n3.aq r2 = r7.f     // Catch:{ JSONException -> 0x00c6 }
            if (r2 == 0) goto L_0x00df
            com.amap.api.col.n3.aq r2 = r7.f     // Catch:{ JSONException -> 0x00c6 }
            r2.a((java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince>) r1)     // Catch:{ JSONException -> 0x00c6 }
            goto L_0x00df
        L_0x00c6:
            r1 = move-exception
            boolean r2 = r0.exists()     // Catch:{ Throwable -> 0x00db }
            if (r2 == 0) goto L_0x00d0
            r0.delete()     // Catch:{ Throwable -> 0x00db }
        L_0x00d0:
            java.lang.String r0 = "MapDownloadManager"
            java.lang.String r2 = "paseJson io"
            com.amap.api.col.n3.iu.b((java.lang.Throwable) r1, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Throwable -> 0x00db }
            r1.printStackTrace()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00df:
            java.util.List<com.amap.api.col.n3.al> r0 = r7.c
            monitor-enter(r0)
            com.amap.api.col.n3.aq r1 = r7.f     // Catch:{ all -> 0x012b }
            java.util.ArrayList r1 = r1.a()     // Catch:{ all -> 0x012b }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x012b }
        L_0x00ec:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x012b }
            if (r2 == 0) goto L_0x011b
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x012b }
            com.amap.api.maps.offlinemap.OfflineMapProvince r2 = (com.amap.api.maps.offlinemap.OfflineMapProvince) r2     // Catch:{ all -> 0x012b }
            java.util.ArrayList r2 = r2.getCityList()     // Catch:{ all -> 0x012b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x012b }
        L_0x0100:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x012b }
            if (r3 == 0) goto L_0x00ec
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x012b }
            com.amap.api.maps.offlinemap.OfflineMapCity r3 = (com.amap.api.maps.offlinemap.OfflineMapCity) r3     // Catch:{ all -> 0x012b }
            if (r3 == 0) goto L_0x0100
            java.util.List<com.amap.api.col.n3.al> r4 = r7.c     // Catch:{ all -> 0x012b }
            com.amap.api.col.n3.al r5 = new com.amap.api.col.n3.al     // Catch:{ all -> 0x012b }
            android.content.Context r6 = r7.i     // Catch:{ all -> 0x012b }
            r5.<init>((android.content.Context) r6, (com.amap.api.maps.offlinemap.OfflineMapCity) r3)     // Catch:{ all -> 0x012b }
            r4.add(r5)     // Catch:{ all -> 0x012b }
            goto L_0x0100
        L_0x011b:
            monitor-exit(r0)     // Catch:{ all -> 0x012b }
            com.amap.api.col.n3.ap r0 = new com.amap.api.col.n3.ap
            android.content.Context r1 = r7.i
            r0.<init>(r1)
            r7.h = r0
            com.amap.api.col.n3.ap r0 = r7.h
            r0.start()
            return
        L_0x012b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.am.a():void");
    }

    public final void b() {
        Iterator<aw> it = this.n.a().iterator();
        while (it.hasNext()) {
            aw next = it.next();
            if (!(next == null || next.c() == null || next.e().length() <= 0)) {
                if (!(next.l == 4 || next.l == 7 || next.l < 0)) {
                    next.l = 3;
                }
                al g2 = g(next.c());
                if (g2 != null) {
                    String d2 = next.d();
                    if (d2 == null || !b(d, d2)) {
                        g2.a(next.l);
                        g2.setCompleteCode(next.f());
                    } else {
                        g2.a(7);
                    }
                    if (next.d().length() > 0) {
                        g2.setVersion(next.d());
                    }
                    List<String> b2 = this.n.b(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String append : b2) {
                        stringBuffer.append(append);
                        stringBuffer.append(VoiceWakeuperAidl.PARAMS_SEPARATE);
                    }
                    g2.a(stringBuffer.toString());
                    if (this.f != null) {
                        this.f.a(g2);
                    }
                }
            }
        }
        if (this.l != null) {
            try {
                this.l.a();
            } catch (Throwable th) {
                iu.b(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void a(final String str) {
        if (str == null) {
            try {
                if (this.l != null) {
                    this.l.b((al) null);
                }
            } catch (Throwable th) {
                iu.b(th, "OfflineDownloadManager", "checkUpdate");
            }
        } else {
            if (this.o == null) {
                this.o = Executors.newSingleThreadExecutor();
            }
            this.o.execute(new Runnable() {
                public final void run() {
                    al a2 = am.this.g(str);
                    if (a2 != null) {
                        try {
                            if (!a2.c().equals(a2.c)) {
                                if (!a2.c().equals(a2.e)) {
                                    String pinyin = a2.getPinyin();
                                    if (pinyin.length() > 0) {
                                        String d = am.this.n.d(pinyin);
                                        if (d == null) {
                                            d = a2.getVersion();
                                        }
                                        if (am.d.length() > 0 && d != null) {
                                            am amVar = am.this;
                                            if (am.b(am.d, d)) {
                                                a2.j();
                                            }
                                        }
                                    }
                                }
                            }
                            if (am.this.l != null) {
                                synchronized (am.this) {
                                    try {
                                        am.this.l.b(a2);
                                    } catch (Throwable th) {
                                        iu.b(th, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (am.this.l != null) {
                                synchronized (am.this) {
                                    am.this.l.b(a2);
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            iu.b(th2, "OfflineDownloadManager", "checkUpdatefinally");
                        }
                    }
                    am.this.g();
                    an anVar = (an) new ao(am.this.i, am.d).c();
                    if (am.this.l != null) {
                        if (anVar == null) {
                            if (am.this.l != null) {
                                synchronized (am.this) {
                                    try {
                                        am.this.l.b(a2);
                                    } catch (Throwable th3) {
                                        iu.b(th3, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (anVar.a()) {
                            am.this.c();
                        }
                    }
                    if (am.this.l != null) {
                        synchronized (am.this) {
                            try {
                                am.this.l.b(a2);
                            } catch (Throwable th4) {
                                iu.b(th4, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                    return;
                    throw th;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void g() throws AMapException {
        if (!dv.c(this.i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    /* access modifiers changed from: protected */
    public final void c() throws AMapException {
        if (this.f != null) {
            at atVar = new at(this.i, "");
            atVar.a(this.i);
            List list = (List) atVar.c();
            if (this.c != null) {
                this.f.a((List<OfflineMapProvince>) list);
            }
            synchronized (this.c) {
                Iterator<OfflineMapProvince> it = this.f.a().iterator();
                while (it.hasNext()) {
                    Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        for (al next2 : this.c) {
                            if (next.getPinyin().equals(next2.getPinyin())) {
                                String version = next2.getVersion();
                                if (next2.getState() != 4 || d.length() <= 0 || !b(d, version)) {
                                    next2.setCity(next.getCity());
                                    next2.setUrl(next.getUrl());
                                    next2.setAdcode(next.getAdcode());
                                    next2.setVersion(next.getVersion());
                                    next2.setSize(next.getSize());
                                    next2.setCode(next.getCode());
                                    next2.setJianpin(next.getJianpin());
                                    next2.setPinyin(next.getPinyin());
                                } else {
                                    next2.j();
                                    next2.setUrl(next.getUrl());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        int i2 = 0;
        while (i2 < str2.length()) {
            try {
                if (str.charAt(i2) > str2.charAt(i2)) {
                    return true;
                }
                if (str.charAt(i2) < str2.charAt(i2)) {
                    return false;
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public final boolean b(String str) {
        return g(str) != null;
    }

    public final void c(String str) {
        al g2 = g(str);
        if (g2 != null) {
            d(g2);
            a(g2, true);
        } else if (this.l != null) {
            try {
                this.l.c(g2);
            } catch (Throwable th) {
                iu.b(th, "OfflineDownloadManager", "remove");
            }
        }
    }

    public final void a(al alVar) {
        a(alVar, false);
    }

    private void a(final al alVar, final boolean z) {
        if (this.g == null) {
            this.g = new as(this.i);
        }
        if (this.p == null) {
            this.p = Executors.newSingleThreadExecutor();
        }
        try {
            this.p.execute(new Runnable() {
                public final void run() {
                    try {
                        if (!alVar.c().equals(alVar.a)) {
                            if (alVar.getState() != 7) {
                                if (alVar.getState() != -1) {
                                    am.this.g.a(alVar);
                                    if (am.this.l != null) {
                                        am.this.l.c(alVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                            am.this.g.a(alVar);
                            if (z && am.this.l != null) {
                                am.this.l.c(alVar);
                            }
                        } else if (am.this.l != null) {
                            am.this.l.c(alVar);
                        }
                    } catch (Throwable th) {
                        iu.b(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            iu.b(th, "requestDelete", "removeExcecRunnable");
        }
    }

    public final void b(al alVar) {
        try {
            if (this.m != null) {
                this.m.a(alVar, this.i);
            }
        } catch (ic e2) {
            e2.printStackTrace();
        }
    }

    public final void c(al alVar) {
        if (this.f != null) {
            this.f.a(alVar);
        }
        if (this.e != null) {
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.obj = alVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    public final void d() {
        synchronized (this.c) {
            for (al next : this.c) {
                if (next.c().equals(next.c) || next.c().equals(next.b)) {
                    d(next);
                    next.g();
                }
            }
        }
    }

    public final void e() {
        synchronized (this.c) {
            Iterator<al> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                al next = it.next();
                if (next.c().equals(next.c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void f() {
        if (this.o != null && !this.o.isShutdown()) {
            this.o.shutdownNow();
        }
        if (this.q != null && !this.q.isShutdown()) {
            this.q.shutdownNow();
        }
        if (this.h != null) {
            if (this.h.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        if (this.e != null) {
            this.e.removeCallbacksAndMessages((Object) null);
            this.e = null;
        }
        if (this.m != null) {
            this.m.b();
        }
        if (this.f != null) {
            this.f.g();
        }
        k = null;
        b = true;
        this.j = true;
        synchronized (this) {
            this.l = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.col.n3.al g(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x003a
            int r1 = r6.length()
            if (r1 > 0) goto L_0x000a
            goto L_0x003a
        L_0x000a:
            java.util.List<com.amap.api.col.n3.al> r1 = r5.c
            monitor-enter(r1)
            java.util.List<com.amap.api.col.n3.al> r2 = r5.c     // Catch:{ all -> 0x0037 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0013:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0035
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0037 }
            com.amap.api.col.n3.al r3 = (com.amap.api.col.n3.al) r3     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = r3.getCity()     // Catch:{ all -> 0x0037 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0037 }
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r3.getPinyin()     // Catch:{ all -> 0x0037 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0013
        L_0x0033:
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            return r3
        L_0x0035:
            monitor-exit(r1)
            return r0
        L_0x0037:
            r6 = move-exception
            monitor-exit(r1)
            throw r6
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.am.g(java.lang.String):com.amap.api.col.n3.al");
    }

    private al h(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.c) {
            for (al next : this.c) {
                if (str.equals(next.getCode())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final void d(String str) throws AMapException {
        al g2 = g(str);
        if (str == null || str.length() <= 0 || g2 == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        f(g2);
    }

    public final void e(String str) throws AMapException {
        al h2 = h(str);
        if (h2 != null) {
            f(h2);
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    private void f(final al alVar) throws AMapException {
        g();
        if (alVar == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        if (this.q == null) {
            this.q = Executors.newSingleThreadExecutor();
        }
        try {
            this.q.execute(new Runnable() {
                public final void run() {
                    try {
                        if (am.this.j) {
                            am.this.g();
                            an anVar = (an) new ao(am.this.i, am.d).c();
                            if (anVar != null) {
                                boolean unused = am.this.j = false;
                                if (anVar.a()) {
                                    am.this.c();
                                }
                            }
                        }
                        alVar.setVersion(am.d);
                        alVar.f();
                    } catch (AMapException e) {
                        e.printStackTrace();
                    } catch (Throwable th) {
                        iu.b(th, "OfflineDownloadManager", "startDownloadRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            iu.b(th, "startDownload", "downloadExcecRunnable");
        }
    }

    public final void d(al alVar) {
        if (this.m != null) {
            this.m.a(alVar);
        }
    }

    public final void e(al alVar) {
        if (this.m != null) {
            this.m.b(alVar);
        }
    }

    public final void a(a aVar) {
        this.l = aVar;
    }

    public final String f(String str) {
        if (str == null) {
            return "";
        }
        al g2 = g(str);
        if (g2 == null) {
            return "";
        }
        return g2.getAdcode();
    }
}
