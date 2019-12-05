package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.loc.ak;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DBOperation */
public final class af {
    private static Map<Class<? extends ae>, ae> d = new HashMap();
    private ak a;
    private SQLiteDatabase b;
    private ae c;

    public af(Context context, ae aeVar) {
        try {
            this.a = new ak(context.getApplicationContext(), aeVar.a(), aeVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = aeVar;
    }

    public af(Context context, ae aeVar, String str) {
        try {
            boolean equals = "mounted".equals(Environment.getExternalStorageState());
            if (!TextUtils.isEmpty(str) && equals) {
                context = new ak.a(context.getApplicationContext(), str);
            }
            this.a = new ak(context, aeVar.a(), aeVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = aeVar;
    }

    private static ContentValues a(Object obj, ag agVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), agVar.b())) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ah.class);
            if (annotation != null) {
                ah ahVar = (ah) annotation;
                switch (ahVar.b()) {
                    case 1:
                        contentValues.put(ahVar.a(), Short.valueOf(field.getShort(obj)));
                        break;
                    case 2:
                        contentValues.put(ahVar.a(), Integer.valueOf(field.getInt(obj)));
                        break;
                    case 3:
                        contentValues.put(ahVar.a(), Float.valueOf(field.getFloat(obj)));
                        break;
                    case 4:
                        contentValues.put(ahVar.a(), Double.valueOf(field.getDouble(obj)));
                        break;
                    case 5:
                        contentValues.put(ahVar.a(), Long.valueOf(field.getLong(obj)));
                        break;
                    case 6:
                        contentValues.put(ahVar.a(), (String) field.get(obj));
                        break;
                    case 7:
                        try {
                            contentValues.put(ahVar.a(), (byte[]) field.get(obj));
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

    private SQLiteDatabase a() {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            w.a(th, "dbs", "gwd");
        }
        return this.b;
    }

    private SQLiteDatabase a(boolean z) {
        try {
            if (this.b == null) {
                this.b = this.a.getReadableDatabase();
            }
        } catch (Throwable th) {
            if (!z) {
                w.a(th, "dbs", "grd");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    public static synchronized ae a(Class<? extends ae> cls) throws IllegalAccessException, InstantiationException {
        ae aeVar;
        synchronized (af.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            aeVar = d.get(cls);
        }
        return aeVar;
    }

    private static <T> T a(Cursor cursor, Class<T> cls, ag agVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object obj;
        Field[] a2 = a((Class<?>) cls, agVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(ah.class);
            if (annotation != null) {
                ah ahVar = (ah) annotation;
                int b2 = ahVar.b();
                int columnIndex = cursor.getColumnIndex(ahVar.a());
                switch (b2) {
                    case 1:
                        obj = Short.valueOf(cursor.getShort(columnIndex));
                        break;
                    case 2:
                        obj = Integer.valueOf(cursor.getInt(columnIndex));
                        break;
                    case 3:
                        obj = Float.valueOf(cursor.getFloat(columnIndex));
                        break;
                    case 4:
                        obj = Double.valueOf(cursor.getDouble(columnIndex));
                        break;
                    case 5:
                        obj = Long.valueOf(cursor.getLong(columnIndex));
                        break;
                    case 6:
                        obj = cursor.getString(columnIndex);
                        break;
                    case 7:
                        obj = cursor.getBlob(columnIndex);
                        break;
                }
                field.set(newInstance, obj);
            }
        }
        return newInstance;
    }

    private static <T> String a(ag agVar) {
        if (agVar == null) {
            return null;
        }
        return agVar.a();
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

    private static Field[] a(Class<?> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        return z ? cls.getSuperclass().getDeclaredFields() : cls.getDeclaredFields();
    }

    private static <T> ag b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(ag.class);
        if (!(annotation != null)) {
            return null;
        }
        return (ag) annotation;
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
            com.loc.ae r0 = r12.c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            com.loc.ag r2 = b(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = a((com.loc.ag) r2)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x0066:
            r14 = move-exception
            goto L_0x00a3
        L_0x0068:
            boolean r3 = r13.moveToNext()     // Catch:{ Throwable -> 0x0066 }
            if (r3 == 0) goto L_0x0076
            java.lang.Object r3 = a((android.database.Cursor) r13, r14, (com.loc.ag) r2)     // Catch:{ Throwable -> 0x0066 }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r14, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r15, (java.lang.String) r1)     // Catch:{ all -> 0x00fd }
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
            com.loc.w.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
        throw new UnsupportedOperationException("Method not decompiled: com.loc.af.a(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    public final <T> void a(T t) {
        b(t);
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
                            w.a(th, "dbs", "dld");
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

    public final <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    public final <T> void a(String str, Object obj, boolean z) {
        synchronized (this.c) {
            if (obj != null) {
                ag b2 = b(obj.getClass());
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
                                        w.a(th, "dbs", "udd");
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

    public final <T> List<T> b(String str, Class<T> cls) {
        return a(str, cls, false);
    }

    /* JADX INFO: finally extract failed */
    public final <T> void b(T t) {
        synchronized (this.c) {
            this.b = a();
            if (this.b != null) {
                try {
                    SQLiteDatabase sQLiteDatabase = this.b;
                    ag b2 = b(t.getClass());
                    String a2 = a(b2);
                    if (!TextUtils.isEmpty(a2) && t != null) {
                        if (sQLiteDatabase != null) {
                            ContentValues a3 = a((Object) t, b2);
                            if (a3 != null) {
                                sQLiteDatabase.insert(a2, (String) null, a3);
                            }
                        }
                    }
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    try {
                        w.a(th, "dbs", "itd");
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
