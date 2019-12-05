package com.amap.api.col.n3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public final class ja {
    private static Map<Class<? extends iz>, iz> d = new HashMap();
    private jf a;
    private SQLiteDatabase b;
    private iz c;

    public static synchronized iz a(Class<? extends iz> cls) throws IllegalAccessException, InstantiationException {
        iz izVar;
        synchronized (ja.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            izVar = d.get(cls);
        }
        return izVar;
    }

    public ja(Context context, iz izVar) {
        try {
            this.a = new jf(context.getApplicationContext(), izVar.b(), izVar.c(), izVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = izVar;
    }

    public static String a(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String next : map.keySet()) {
            if (z) {
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
                z = false;
            } else {
                sb.append(" and ");
                sb.append(next);
                sb.append(" = '");
                sb.append(map.get(next));
                sb.append("'");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: finally extract failed */
    public final <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            String a2 = a(b(cls));
            if (!TextUtils.isEmpty(a2)) {
                this.b = a();
                if (this.b != null) {
                    try {
                        this.b.delete(a2, str, (String[]) null);
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th) {
                        try {
                            ir.a(th, "dbs", "dld");
                            if (this.b != null) {
                                this.b.close();
                            }
                        } catch (Throwable th2) {
                            if (this.b != null) {
                                this.b.close();
                                this.b = null;
                            }
                            throw th2;
                        }
                    }
                }
            }
        }
    }

    public final <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj != null) {
                jb b2 = b(obj.getClass());
                String a2 = a(b2);
                if (!TextUtils.isEmpty(a2)) {
                    ContentValues a3 = a(obj, b2);
                    if (a3 != null) {
                        this.b = a();
                        if (this.b != null) {
                            try {
                                this.b.update(a2, a3, str, (String[]) null);
                                if (this.b != null) {
                                    this.b.close();
                                    this.b = null;
                                }
                            } catch (Throwable th) {
                                if (!z) {
                                    try {
                                        ir.a(th, "dbs", "udd");
                                    } catch (Throwable th2) {
                                        if (this.b != null) {
                                            this.b.close();
                                            this.b = null;
                                        }
                                        throw th2;
                                    }
                                } else {
                                    th.printStackTrace();
                                }
                                if (this.b != null) {
                                    this.b.close();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    public final void a(Object obj, String str) {
        synchronized (this.c) {
            List<?> a2 = a(str, obj.getClass(), false);
            if (a2 != null) {
                if (a2.size() != 0) {
                    a(str, obj, false);
                }
            }
            b(obj);
        }
    }

    public final <T> void a(T t) {
        b(t);
    }

    /* JADX INFO: finally extract failed */
    public final <T> void b(T t) {
        synchronized (this.c) {
            this.b = a();
            if (this.b != null) {
                try {
                    a(this.b, t);
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    try {
                        ir.a(th, "dbs", "itd");
                        if (this.b != null) {
                            this.b.close();
                        }
                    } catch (Throwable th2) {
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                        throw th2;
                    }
                }
            }
        }
    }

    private static <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        jb b2 = b(t.getClass());
        String a2 = a(b2);
        if (!TextUtils.isEmpty(a2) && t != null && sQLiteDatabase != null) {
            ContentValues a3 = a((Object) t, b2);
            if (a3 != null) {
                sQLiteDatabase.insert(a2, (String) null, a3);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        com.amap.api.col.n3.ir.a(r6, "dbs", "ild");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0095, code lost:
        if (r5.b.inTransaction() != false) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0097, code lost:
        r5.b.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x009d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        com.amap.api.col.n3.ir.a(r2, "dbs", "ild");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ad, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        com.amap.api.col.n3.ir.a(r1, "dbs", "ild");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b6, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x00b9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x00bb, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:18:0x0038, B:30:0x005b, B:35:0x0066, B:52:0x008f, B:60:0x00a5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> void a(java.util.List<T> r6) {
        /*
            r5 = this;
            com.amap.api.col.n3.iz r0 = r5.c
            monitor-enter(r0)
            if (r6 == 0) goto L_0x00b8
            int r1 = r6.size()     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x000d
            goto L_0x00b8
        L_0x000d:
            android.database.sqlite.SQLiteDatabase r1 = r5.a()     // Catch:{ all -> 0x00b6 }
            r5.b = r1     // Catch:{ all -> 0x00b6 }
            android.database.sqlite.SQLiteDatabase r1 = r5.b     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x0019
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x0019:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.b     // Catch:{ Throwable -> 0x0061 }
            r2.beginTransaction()     // Catch:{ Throwable -> 0x0061 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ Throwable -> 0x0061 }
        L_0x0023:
            boolean r2 = r6.hasNext()     // Catch:{ Throwable -> 0x0061 }
            if (r2 == 0) goto L_0x0033
            java.lang.Object r2 = r6.next()     // Catch:{ Throwable -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r3 = r5.b     // Catch:{ Throwable -> 0x0061 }
            a((android.database.sqlite.SQLiteDatabase) r3, r2)     // Catch:{ Throwable -> 0x0061 }
            goto L_0x0023
        L_0x0033:
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0061 }
            r6.setTransactionSuccessful()     // Catch:{ Throwable -> 0x0061 }
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0046 }
            boolean r6 = r6.inTransaction()     // Catch:{ Throwable -> 0x0046 }
            if (r6 == 0) goto L_0x004e
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0046 }
            r6.endTransaction()     // Catch:{ Throwable -> 0x0046 }
            goto L_0x004e
        L_0x0046:
            r6 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00b6 }
        L_0x004e:
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0056 }
            r6.close()     // Catch:{ Throwable -> 0x0056 }
            r5.b = r1     // Catch:{ Throwable -> 0x0056 }
            goto L_0x008d
        L_0x0056:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "ild"
        L_0x005b:
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00b6 }
            goto L_0x008d
        L_0x005f:
            r6 = move-exception
            goto L_0x008f
        L_0x0061:
            r6 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x005f }
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0077 }
            boolean r6 = r6.inTransaction()     // Catch:{ Throwable -> 0x0077 }
            if (r6 == 0) goto L_0x007f
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0077 }
            r6.endTransaction()     // Catch:{ Throwable -> 0x0077 }
            goto L_0x007f
        L_0x0077:
            r6 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r6, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00b6 }
        L_0x007f:
            android.database.sqlite.SQLiteDatabase r6 = r5.b     // Catch:{ Throwable -> 0x0087 }
            r6.close()     // Catch:{ Throwable -> 0x0087 }
            r5.b = r1     // Catch:{ Throwable -> 0x0087 }
            goto L_0x008d
        L_0x0087:
            r6 = move-exception
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "ild"
            goto L_0x005b
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x008f:
            android.database.sqlite.SQLiteDatabase r2 = r5.b     // Catch:{ Throwable -> 0x009d }
            boolean r2 = r2.inTransaction()     // Catch:{ Throwable -> 0x009d }
            if (r2 == 0) goto L_0x00a5
            android.database.sqlite.SQLiteDatabase r2 = r5.b     // Catch:{ Throwable -> 0x009d }
            r2.endTransaction()     // Catch:{ Throwable -> 0x009d }
            goto L_0x00a5
        L_0x009d:
            r2 = move-exception
            java.lang.String r3 = "dbs"
            java.lang.String r4 = "ild"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x00b6 }
        L_0x00a5:
            android.database.sqlite.SQLiteDatabase r2 = r5.b     // Catch:{ Throwable -> 0x00ad }
            r2.close()     // Catch:{ Throwable -> 0x00ad }
            r5.b = r1     // Catch:{ Throwable -> 0x00ad }
            goto L_0x00b5
        L_0x00ad:
            r1 = move-exception
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "ild"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r1, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00b6 }
        L_0x00b5:
            throw r6     // Catch:{ all -> 0x00b6 }
        L_0x00b6:
            r6 = move-exception
            goto L_0x00ba
        L_0x00b8:
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return
        L_0x00ba:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ja.a(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x00fc, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0065, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00d7 A[SYNTHETIC, Splitter:B:86:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00e9 A[Catch:{ Throwable -> 0x00f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.util.List<T> a(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
            r12 = this;
            com.amap.api.col.n3.iz r0 = r12.c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            com.amap.api.col.n3.jb r2 = b(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = a((com.amap.api.col.n3.jb) r2)     // Catch:{ all -> 0x00fd }
            android.database.sqlite.SQLiteDatabase r3 = r12.b     // Catch:{ all -> 0x00fd }
            if (r3 != 0) goto L_0x001a
            android.database.sqlite.SQLiteDatabase r3 = r12.a((boolean) r15)     // Catch:{ all -> 0x00fd }
            r12.b = r3     // Catch:{ all -> 0x00fd }
        L_0x001a:
            android.database.sqlite.SQLiteDatabase r3 = r12.b     // Catch:{ all -> 0x00fd }
            if (r3 == 0) goto L_0x00fb
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x00fd }
            if (r3 != 0) goto L_0x00fb
            if (r13 != 0) goto L_0x0028
            goto L_0x00fb
        L_0x0028:
            r11 = 0
            android.database.sqlite.SQLiteDatabase r3 = r12.b     // Catch:{ Throwable -> 0x00a1, all -> 0x009e }
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r13
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00a1, all -> 0x009e }
            if (r13 != 0) goto L_0x0068
            android.database.sqlite.SQLiteDatabase r14 = r12.b     // Catch:{ Throwable -> 0x0066 }
            r14.close()     // Catch:{ Throwable -> 0x0066 }
            r12.b = r11     // Catch:{ Throwable -> 0x0066 }
            if (r13 == 0) goto L_0x004e
            r13.close()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x004e
        L_0x0044:
            r13 = move-exception
            if (r15 != 0) goto L_0x004e
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x004e:
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x005a }
            if (r13 == 0) goto L_0x0064
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x005a }
            r13.close()     // Catch:{ Throwable -> 0x005a }
            r12.b = r11     // Catch:{ Throwable -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r13 = move-exception
            if (r15 != 0) goto L_0x0064
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x0066:
            r14 = move-exception
            goto L_0x00a3
        L_0x0068:
            boolean r3 = r13.moveToNext()     // Catch:{ Throwable -> 0x0066 }
            if (r3 == 0) goto L_0x0076
            java.lang.Object r3 = a((android.database.Cursor) r13, r14, (com.amap.api.col.n3.jb) r2)     // Catch:{ Throwable -> 0x0066 }
            r1.add(r3)     // Catch:{ Throwable -> 0x0066 }
            goto L_0x0068
        L_0x0076:
            if (r13 == 0) goto L_0x0086
            r13.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0086
        L_0x007c:
            r13 = move-exception
            if (r15 != 0) goto L_0x0086
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x0086:
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x0093 }
            if (r13 == 0) goto L_0x00f9
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x0093 }
            r13.close()     // Catch:{ Throwable -> 0x0093 }
            r12.b = r11     // Catch:{ Throwable -> 0x0093 }
            goto L_0x00f9
        L_0x0093:
            r13 = move-exception
            if (r15 != 0) goto L_0x00f9
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
        L_0x009a:
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
            goto L_0x00f9
        L_0x009e:
            r14 = move-exception
            r13 = r11
            goto L_0x00ae
        L_0x00a1:
            r14 = move-exception
            r13 = r11
        L_0x00a3:
            if (r15 != 0) goto L_0x00d5
            java.lang.String r2 = "dbs"
            java.lang.String r3 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r14, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00d5
        L_0x00ad:
            r14 = move-exception
        L_0x00ae:
            if (r13 == 0) goto L_0x00be
            r13.close()     // Catch:{ Throwable -> 0x00b4 }
            goto L_0x00be
        L_0x00b4:
            r13 = move-exception
            if (r15 != 0) goto L_0x00be
            java.lang.String r1 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x00be:
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x00ca }
            if (r13 == 0) goto L_0x00d4
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x00ca }
            r13.close()     // Catch:{ Throwable -> 0x00ca }
            r12.b = r11     // Catch:{ Throwable -> 0x00ca }
            goto L_0x00d4
        L_0x00ca:
            r13 = move-exception
            if (r15 != 0) goto L_0x00d4
            java.lang.String r15 = "dbs"
            java.lang.String r1 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r15, (java.lang.String) r1)     // Catch:{ all -> 0x00fd }
        L_0x00d4:
            throw r14     // Catch:{ all -> 0x00fd }
        L_0x00d5:
            if (r13 == 0) goto L_0x00e5
            r13.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00e5
        L_0x00db:
            r13 = move-exception
            if (r15 != 0) goto L_0x00e5
            java.lang.String r14 = "dbs"
            java.lang.String r2 = "sld"
            com.amap.api.col.n3.ir.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
        L_0x00e5:
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x00f1 }
            if (r13 == 0) goto L_0x00f9
            android.database.sqlite.SQLiteDatabase r13 = r12.b     // Catch:{ Throwable -> 0x00f1 }
            r13.close()     // Catch:{ Throwable -> 0x00f1 }
            r12.b = r11     // Catch:{ Throwable -> 0x00f1 }
            goto L_0x00f9
        L_0x00f1:
            r13 = move-exception
            if (r15 != 0) goto L_0x00f9
            java.lang.String r14 = "dbs"
            java.lang.String r15 = "sld"
            goto L_0x009a
        L_0x00f9:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fb:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fd:
            r13 = move-exception
            monitor-exit(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.ja.a(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    public final <T> List<T> b(String str, Class<T> cls) {
        return a(str, cls, false);
    }

    private static <T> T a(Cursor cursor, Class<T> cls, jb jbVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, jbVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(jc.class);
            if (annotation != null) {
                jc jcVar = (jc) annotation;
                int b2 = jcVar.b();
                int columnIndex = cursor.getColumnIndex(jcVar.a());
                switch (b2) {
                    case 1:
                        field.set(newInstance, Short.valueOf(cursor.getShort(columnIndex)));
                        break;
                    case 2:
                        field.set(newInstance, Integer.valueOf(cursor.getInt(columnIndex)));
                        break;
                    case 3:
                        field.set(newInstance, Float.valueOf(cursor.getFloat(columnIndex)));
                        break;
                    case 4:
                        field.set(newInstance, Double.valueOf(cursor.getDouble(columnIndex)));
                        break;
                    case 5:
                        field.set(newInstance, Long.valueOf(cursor.getLong(columnIndex)));
                        break;
                    case 6:
                        field.set(newInstance, cursor.getString(columnIndex));
                        break;
                    case 7:
                        field.set(newInstance, cursor.getBlob(columnIndex));
                        break;
                }
            }
        }
        return newInstance;
    }

    private static ContentValues a(Object obj, jb jbVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), jbVar.b())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(jc.class);
            if (annotation != null) {
                jc jcVar = (jc) annotation;
                switch (jcVar.b()) {
                    case 1:
                        contentValues.put(jcVar.a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(jcVar.a(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(jcVar.a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(jcVar.a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(jcVar.a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(jcVar.a(), (String) field.get(obj));
                        break;
                    case 7:
                        try {
                            contentValues.put(jcVar.a(), (byte[]) field.get(obj));
                            break;
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            break;
                        }
                }
            }
        }
        return contentValues;
    }

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        if (z) {
            return cls.getSuperclass().getDeclaredFields();
        }
        return cls.getDeclaredFields();
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                ir.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private SQLiteDatabase a() {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            ir.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private static <T> String a(jb jbVar) {
        if (jbVar == null) {
            return null;
        }
        return jbVar.a();
    }

    private static <T> jb b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(jb.class);
        if (!(annotation != null)) {
            return null;
        }
        return (jb) annotation;
    }
}
