package com.amap.api.services.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public class bm {
    public static final String a = "/a/";
    static final String b = "b";
    static final String c = "c";
    static final String d = "d";
    public static final String e = "g";
    public static final String f = "h";
    public static final String g = "e";
    public static final String h = "f";

    public static String a(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + a + str;
    }

    public static Class<? extends cd> a(int i) {
        switch (i) {
            case 0:
                return by.class;
            case 1:
                return ca.class;
            case 2:
                return bx.class;
            default:
                return null;
        }
    }

    public static cd b(int i) {
        switch (i) {
            case 0:
                return new by();
            case 1:
                return new ca();
            case 2:
                return new bx();
            default:
                return null;
        }
    }

    public static String c(int i) {
        switch (i) {
            case 0:
                return c;
            case 1:
                return b;
            case 2:
                return d;
            default:
                return "";
        }
    }

    static bs a(Context context, int i) {
        switch (i) {
            case 0:
                return new bq(i);
            case 1:
                return new br(i);
            case 2:
                return new bp(i);
            default:
                return null;
        }
    }

    static void a(final Context context, final bh bhVar, final String str, final String str2) {
        try {
            if (bhVar.e()) {
                ExecutorService b2 = bo.b();
                if (b2 == null) {
                    return;
                }
                if (!b2.isShutdown()) {
                    b2.submit(new Runnable() {
                        public void run() {
                            try {
                                bs a2 = bm.a(context, 1);
                                if (TextUtils.isEmpty(str2)) {
                                    a2.a(bhVar, context, new Throwable("gpsstatistics"), str, (String) null, (String) null);
                                } else {
                                    a2.a(bhVar, context, str2, str, (String) null, (String) null);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void a(Context context, Throwable th, int i, String str, String str2) {
        try {
            ExecutorService b2 = bo.b();
            if (b2 == null) {
                return;
            }
            if (!b2.isShutdown()) {
                final Context context2 = context;
                final int i2 = i;
                final Throwable th2 = th;
                final String str3 = str;
                final String str4 = str2;
                AnonymousClass2 r2 = new Runnable() {
                    public void run() {
                        try {
                            bs a2 = bm.a(context2, i2);
                            if (a2 != null) {
                                a2.a(context2, th2, str3, str4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                };
                b2.submit(r2);
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    static void a(Context context) {
        try {
            bs a2 = a(context, 2);
            if (a2 != null) {
                a2.b(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void b(final Context context) {
        try {
            ExecutorService b2 = bo.b();
            if (b2 == null) {
                return;
            }
            if (!b2.isShutdown()) {
                b2.submit(new Runnable() {
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Removed duplicated region for block: B:44:0x008d  */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
                    /* JADX WARNING: Removed duplicated region for block: B:50:0x009c  */
                    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1  */
                    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a6  */
                    /* JADX WARNING: Removed duplicated region for block: B:60:? A[ExcHandler: RejectedExecutionException (unused java.util.concurrent.RejectedExecutionException), SYNTHETIC, Splitter:B:7:0x0016] */
                    /* JADX WARNING: Removed duplicated region for block: B:61:0x00af  */
                    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b4  */
                    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b9  */
                    /* JADX WARNING: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r7 = this;
                            r0 = 0
                            android.content.Context r1 = r2     // Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x007f, all -> 0x0079 }
                            r2 = 0
                            com.amap.api.services.a.bs r1 = com.amap.api.services.a.bm.a((android.content.Context) r1, (int) r2)     // Catch:{ RejectedExecutionException -> 0x00aa, Throwable -> 0x007f, all -> 0x0079 }
                            android.content.Context r2 = r2     // Catch:{ RejectedExecutionException -> 0x0077, Throwable -> 0x0072, all -> 0x006d }
                            r3 = 1
                            com.amap.api.services.a.bs r2 = com.amap.api.services.a.bm.a((android.content.Context) r2, (int) r3)     // Catch:{ RejectedExecutionException -> 0x0077, Throwable -> 0x0072, all -> 0x006d }
                            android.content.Context r3 = r2     // Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0066, all -> 0x0061 }
                            r4 = 2
                            com.amap.api.services.a.bs r3 = com.amap.api.services.a.bm.a((android.content.Context) r3, (int) r4)     // Catch:{ RejectedExecutionException -> 0x006b, Throwable -> 0x0066, all -> 0x0061 }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            r1.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            r2.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            r3.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            com.amap.api.services.a.dj.a(r0)     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            com.amap.api.services.a.dh.a((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            java.util.List r0 = com.amap.api.services.a.bs.a()     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            int r4 = r0.size()     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            if (r4 <= 0) goto L_0x004f
                            java.util.Iterator r0 = r0.iterator()     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                        L_0x003d:
                            boolean r4 = r0.hasNext()     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            if (r4 == 0) goto L_0x004f
                            java.lang.Object r4 = r0.next()     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            com.amap.api.services.a.bs$b r4 = (com.amap.api.services.a.bs.b) r4     // Catch:{ RejectedExecutionException -> 0x00ad, Throwable -> 0x005f }
                            android.content.Context r5 = r2     // Catch:{ Throwable -> 0x003d, RejectedExecutionException -> 0x00ad }
                            r4.a(r5)     // Catch:{ Throwable -> 0x003d, RejectedExecutionException -> 0x00ad }
                            goto L_0x003d
                        L_0x004f:
                            if (r1 == 0) goto L_0x0054
                            r1.d()
                        L_0x0054:
                            if (r2 == 0) goto L_0x0059
                            r2.d()
                        L_0x0059:
                            if (r3 == 0) goto L_0x0098
                        L_0x005b:
                            r3.d()
                            goto L_0x0098
                        L_0x005f:
                            r0 = move-exception
                            goto L_0x0084
                        L_0x0061:
                            r3 = move-exception
                            r6 = r3
                            r3 = r0
                            r0 = r6
                            goto L_0x009a
                        L_0x0066:
                            r3 = move-exception
                            r6 = r3
                            r3 = r0
                            r0 = r6
                            goto L_0x0084
                        L_0x006b:
                            r3 = r0
                            goto L_0x00ad
                        L_0x006d:
                            r2 = move-exception
                            r3 = r0
                            r0 = r2
                            r2 = r3
                            goto L_0x009a
                        L_0x0072:
                            r2 = move-exception
                            r3 = r0
                            r0 = r2
                            r2 = r3
                            goto L_0x0084
                        L_0x0077:
                            r2 = r0
                            goto L_0x00ac
                        L_0x0079:
                            r1 = move-exception
                            r2 = r0
                            r3 = r2
                            r0 = r1
                            r1 = r3
                            goto L_0x009a
                        L_0x007f:
                            r1 = move-exception
                            r2 = r0
                            r3 = r2
                            r0 = r1
                            r1 = r3
                        L_0x0084:
                            java.lang.String r4 = "Log"
                            java.lang.String r5 = "processLog"
                            com.amap.api.services.a.bl.a((java.lang.Throwable) r0, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0099 }
                            if (r1 == 0) goto L_0x0090
                            r1.d()
                        L_0x0090:
                            if (r2 == 0) goto L_0x0095
                            r2.d()
                        L_0x0095:
                            if (r3 == 0) goto L_0x0098
                            goto L_0x005b
                        L_0x0098:
                            return
                        L_0x0099:
                            r0 = move-exception
                        L_0x009a:
                            if (r1 == 0) goto L_0x009f
                            r1.d()
                        L_0x009f:
                            if (r2 == 0) goto L_0x00a4
                            r2.d()
                        L_0x00a4:
                            if (r3 == 0) goto L_0x00a9
                            r3.d()
                        L_0x00a9:
                            throw r0
                        L_0x00aa:
                            r1 = r0
                            r2 = r1
                        L_0x00ac:
                            r3 = r2
                        L_0x00ad:
                            if (r1 == 0) goto L_0x00b2
                            r1.d()
                        L_0x00b2:
                            if (r2 == 0) goto L_0x00b7
                            r2.d()
                        L_0x00b7:
                            if (r3 == 0) goto L_0x00bc
                            r3.d()
                        L_0x00bc:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bm.AnonymousClass3.run():void");
                    }
                });
            }
        } catch (Throwable th) {
            bl.a(th, "Log", "processLog");
        }
    }
}
