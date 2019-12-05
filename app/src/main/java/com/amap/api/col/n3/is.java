package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: Log */
public final class is {
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

    public static Class<? extends jj> a(int i) {
        switch (i) {
            case 0:
                return je.class;
            case 1:
                return jg.class;
            case 2:
                return jd.class;
            default:
                return null;
        }
    }

    public static jj b(int i) {
        switch (i) {
            case 0:
                return new je();
            case 1:
                return new jg();
            case 2:
                return new jd();
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

    static iy d(int i) {
        switch (i) {
            case 0:
                return new iw(i);
            case 1:
                return new ix(i);
            case 2:
                return new iv(i);
            default:
                return null;
        }
    }

    static void a(final Context context, final im imVar, final String str, final String str2) {
        try {
            if (imVar.f()) {
                ExecutorService c2 = iu.c();
                if (c2 == null) {
                    return;
                }
                if (!c2.isShutdown()) {
                    c2.submit(new Runnable() {
                        public final void run() {
                            try {
                                Context context = context;
                                iy d2 = is.d(1);
                                if (TextUtils.isEmpty(str2)) {
                                    d2.a(imVar, context, new Throwable("gpsstatistics"), str, (String) null, (String) null);
                                } else {
                                    d2.a(imVar, context, str2, str, (String) null, (String) null);
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
            ExecutorService c2 = iu.c();
            if (c2 == null) {
                return;
            }
            if (!c2.isShutdown()) {
                final Context context2 = context;
                final int i2 = i;
                final Throwable th2 = th;
                final String str3 = str;
                final String str4 = str2;
                AnonymousClass2 r2 = new Runnable() {
                    public final void run() {
                        try {
                            Context context = context2;
                            iy d2 = is.d(i2);
                            if (d2 != null) {
                                d2.a(context2, th2, str3, str4);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                };
                c2.submit(r2);
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    static void a(Context context) {
        try {
            iy d2 = d(2);
            if (d2 != null) {
                d2.b(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static void b(final Context context) {
        try {
            ExecutorService c2 = iu.c();
            if (c2 == null) {
                return;
            }
            if (!c2.isShutdown()) {
                c2.submit(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
                        r0 = th;
                     */
                    /* JADX WARNING: Failed to process nested try/catch */
                    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ExcHandler: RejectedExecutionException (unused java.util.concurrent.RejectedExecutionException), SYNTHETIC, Splitter:B:7:0x0016] */
                    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
                    /* JADX WARNING: Removed duplicated region for block: B:48:0x008d  */
                    /* JADX WARNING: Removed duplicated region for block: B:50:0x0092  */
                    /* JADX WARNING: Removed duplicated region for block: B:53:0x0099  */
                    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
                    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a3  */
                    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ab  */
                    /* JADX WARNING: Removed duplicated region for block: B:64:0x00b0  */
                    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b5  */
                    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
                    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                            r7 = this;
                            r0 = 0
                            android.content.Context r1 = r2     // Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x007a, all -> 0x0074 }
                            r1 = 0
                            com.amap.api.col.n3.iy r1 = com.amap.api.col.n3.is.d(r1)     // Catch:{ RejectedExecutionException -> 0x00a7, Throwable -> 0x007a, all -> 0x0074 }
                            android.content.Context r2 = r2     // Catch:{ RejectedExecutionException -> 0x0072, Throwable -> 0x006d, all -> 0x0068 }
                            r2 = 1
                            com.amap.api.col.n3.iy r2 = com.amap.api.col.n3.is.d(r2)     // Catch:{ RejectedExecutionException -> 0x0072, Throwable -> 0x006d, all -> 0x0068 }
                            android.content.Context r3 = r2     // Catch:{ RejectedExecutionException -> 0x0065, Throwable -> 0x0060, all -> 0x005b }
                            r3 = 2
                            com.amap.api.col.n3.iy r3 = com.amap.api.col.n3.is.d(r3)     // Catch:{ RejectedExecutionException -> 0x0065, Throwable -> 0x0060, all -> 0x005b }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            r1.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            r2.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            r3.c((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            com.amap.api.col.n3.kq.a((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            android.content.Context r0 = r2     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            com.amap.api.col.n3.ko.a((android.content.Context) r0)     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            java.util.List r0 = com.amap.api.col.n3.iy.a()     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            int r4 = r0.size()     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            if (r4 <= 0) goto L_0x0049
                            java.util.Iterator r0 = r0.iterator()     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                        L_0x003d:
                            boolean r4 = r0.hasNext()     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            if (r4 == 0) goto L_0x0049
                            r0.next()     // Catch:{ RejectedExecutionException -> 0x0066, Throwable -> 0x0059 }
                            android.content.Context r4 = r2     // Catch:{ Throwable -> 0x003d, RejectedExecutionException -> 0x0066 }
                            goto L_0x003d
                        L_0x0049:
                            if (r1 == 0) goto L_0x004e
                            r1.c()
                        L_0x004e:
                            if (r2 == 0) goto L_0x0053
                            r2.c()
                        L_0x0053:
                            if (r3 == 0) goto L_0x0058
                            r3.c()
                        L_0x0058:
                            return
                        L_0x0059:
                            r0 = move-exception
                            goto L_0x007f
                        L_0x005b:
                            r3 = move-exception
                            r6 = r3
                            r3 = r0
                            r0 = r6
                            goto L_0x0097
                        L_0x0060:
                            r3 = move-exception
                            r6 = r3
                            r3 = r0
                            r0 = r6
                            goto L_0x007f
                        L_0x0065:
                            r3 = r0
                        L_0x0066:
                            r0 = r2
                            goto L_0x00a9
                        L_0x0068:
                            r2 = move-exception
                            r3 = r0
                            r0 = r2
                            r2 = r3
                            goto L_0x0097
                        L_0x006d:
                            r2 = move-exception
                            r3 = r0
                            r0 = r2
                            r2 = r3
                            goto L_0x007f
                        L_0x0072:
                            r3 = r0
                            goto L_0x00a9
                        L_0x0074:
                            r1 = move-exception
                            r2 = r0
                            r3 = r2
                            r0 = r1
                            r1 = r3
                            goto L_0x0097
                        L_0x007a:
                            r1 = move-exception
                            r2 = r0
                            r3 = r2
                            r0 = r1
                            r1 = r3
                        L_0x007f:
                            java.lang.String r4 = "Lg"
                            java.lang.String r5 = "proL"
                            com.amap.api.col.n3.ir.a((java.lang.Throwable) r0, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0096 }
                            if (r1 == 0) goto L_0x008b
                            r1.c()
                        L_0x008b:
                            if (r2 == 0) goto L_0x0090
                            r2.c()
                        L_0x0090:
                            if (r3 == 0) goto L_0x0095
                            r3.c()
                        L_0x0095:
                            return
                        L_0x0096:
                            r0 = move-exception
                        L_0x0097:
                            if (r1 == 0) goto L_0x009c
                            r1.c()
                        L_0x009c:
                            if (r2 == 0) goto L_0x00a1
                            r2.c()
                        L_0x00a1:
                            if (r3 == 0) goto L_0x00a6
                            r3.c()
                        L_0x00a6:
                            throw r0
                        L_0x00a7:
                            r1 = r0
                            r3 = r1
                        L_0x00a9:
                            if (r1 == 0) goto L_0x00ae
                            r1.c()
                        L_0x00ae:
                            if (r0 == 0) goto L_0x00b3
                            r0.c()
                        L_0x00b3:
                            if (r3 == 0) goto L_0x00b8
                            r3.c()
                        L_0x00b8:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.is.AnonymousClass3.run():void");
                    }
                });
            }
        } catch (Throwable th) {
            ir.a(th, "Lg", "proL");
        }
    }
}
