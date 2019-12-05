package com.amap.api.services.a;

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
public class bu {
    private static Map<Class<? extends bt>, bt> d = new HashMap();
    private bz a;
    private SQLiteDatabase b;
    private bt c;

    private boolean a(Annotation annotation) {
        return annotation != null;
    }

    public static synchronized bt a(Class<? extends bt> cls) throws IllegalAccessException, InstantiationException {
        bt btVar;
        synchronized (bu.class) {
            if (d.get(cls) == null) {
                d.put(cls, cls.newInstance());
            }
            btVar = d.get(cls);
        }
        return btVar;
    }

    public bu(Context context, bt btVar) {
        try {
            bz bzVar = new bz(context.getApplicationContext(), btVar.a(), (SQLiteDatabase.CursorFactory) null, btVar.b(), btVar);
            this.a = bzVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.c = btVar;
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
    public <T> void a(String str, Class<T> cls) {
        synchronized (this.c) {
            String a2 = a(b(cls));
            if (!TextUtils.isEmpty(a2)) {
                this.b = b(false);
                if (this.b != null) {
                    try {
                        this.b.delete(a2, str, (String[]) null);
                        if (this.b != null) {
                            this.b.close();
                            this.b = null;
                        }
                    } catch (Throwable th) {
                        try {
                            bl.a(th, "DataBase", "deleteData");
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

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0061, code lost:
        if (r4.b != null) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0063, code lost:
        r4.b.close();
        r4.b = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006a, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006c, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0007, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x0005, B:32:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(java.lang.String r5, java.lang.Object r6, boolean r7) {
        /*
            r4 = this;
            com.amap.api.services.a.bt r0 = r4.c
            monitor-enter(r0)
            if (r6 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x0007:
            r5 = move-exception
            goto L_0x006b
        L_0x0009:
            java.lang.Class r1 = r6.getClass()     // Catch:{ all -> 0x0007 }
            com.amap.api.services.a.bv r1 = r4.b(r1)     // Catch:{ all -> 0x0007 }
            java.lang.String r2 = r4.a((com.amap.api.services.a.bv) r1)     // Catch:{ all -> 0x0007 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0007 }
            if (r3 == 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x001d:
            android.content.ContentValues r6 = r4.a((java.lang.Object) r6, (com.amap.api.services.a.bv) r1)     // Catch:{ all -> 0x0007 }
            if (r6 != 0) goto L_0x0025
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x0025:
            android.database.sqlite.SQLiteDatabase r1 = r4.b((boolean) r7)     // Catch:{ all -> 0x0007 }
            r4.b = r1     // Catch:{ all -> 0x0007 }
            android.database.sqlite.SQLiteDatabase r1 = r4.b     // Catch:{ all -> 0x0007 }
            if (r1 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x0031:
            r1 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.b     // Catch:{ Throwable -> 0x0045 }
            r3.update(r2, r6, r5, r1)     // Catch:{ Throwable -> 0x0045 }
            android.database.sqlite.SQLiteDatabase r5 = r4.b     // Catch:{ all -> 0x0007 }
            if (r5 == 0) goto L_0x005d
            android.database.sqlite.SQLiteDatabase r5 = r4.b     // Catch:{ all -> 0x0007 }
            r5.close()     // Catch:{ all -> 0x0007 }
        L_0x0040:
            r4.b = r1     // Catch:{ all -> 0x0007 }
            goto L_0x005d
        L_0x0043:
            r5 = move-exception
            goto L_0x005f
        L_0x0045:
            r5 = move-exception
            if (r7 != 0) goto L_0x0050
            java.lang.String r6 = "DataBase"
            java.lang.String r7 = "updateData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r5, (java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0043 }
            goto L_0x0053
        L_0x0050:
            r5.printStackTrace()     // Catch:{ all -> 0x0043 }
        L_0x0053:
            android.database.sqlite.SQLiteDatabase r5 = r4.b     // Catch:{ all -> 0x0007 }
            if (r5 == 0) goto L_0x005d
            android.database.sqlite.SQLiteDatabase r5 = r4.b     // Catch:{ all -> 0x0007 }
            r5.close()     // Catch:{ all -> 0x0007 }
            goto L_0x0040
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            return
        L_0x005f:
            android.database.sqlite.SQLiteDatabase r6 = r4.b     // Catch:{ all -> 0x0007 }
            if (r6 == 0) goto L_0x006a
            android.database.sqlite.SQLiteDatabase r6 = r4.b     // Catch:{ all -> 0x0007 }
            r6.close()     // Catch:{ all -> 0x0007 }
            r4.b = r1     // Catch:{ all -> 0x0007 }
        L_0x006a:
            throw r5     // Catch:{ all -> 0x0007 }
        L_0x006b:
            monitor-exit(r0)     // Catch:{ all -> 0x0007 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bu.a(java.lang.String, java.lang.Object, boolean):void");
    }

    public <T> void a(String str, Object obj) {
        a(str, obj, false);
    }

    public void a(Object obj, String str) {
        synchronized (this.c) {
            List<?> b2 = b(str, obj.getClass());
            if (b2 != null) {
                if (b2.size() != 0) {
                    a(str, obj);
                }
            }
            a(obj);
        }
    }

    public <T> void a(T t) {
        a(t, false);
    }

    /* JADX INFO: finally extract failed */
    public <T> void a(T t, boolean z) {
        synchronized (this.c) {
            this.b = b(z);
            if (this.b != null) {
                try {
                    a(this.b, t);
                    if (this.b != null) {
                        this.b.close();
                        this.b = null;
                    }
                } catch (Throwable th) {
                    try {
                        bl.a(th, "DataBase", "insertData");
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

    private <T> void a(SQLiteDatabase sQLiteDatabase, T t) {
        bv b2 = b(t.getClass());
        String a2 = a(b2);
        if (!TextUtils.isEmpty(a2) && t != null && sQLiteDatabase != null) {
            ContentValues a3 = a((Object) t, b2);
            if (a3 != null) {
                sQLiteDatabase.insert(a2, (String) null, a3);
            }
        }
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
    public <T> java.util.List<T> a(java.lang.String r13, java.lang.Class<T> r14, boolean r15) {
        /*
            r12 = this;
            com.amap.api.services.a.bt r0 = r12.c
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00fd }
            r1.<init>()     // Catch:{ all -> 0x00fd }
            com.amap.api.services.a.bv r2 = r12.b(r14)     // Catch:{ all -> 0x00fd }
            java.lang.String r4 = r12.a((com.amap.api.services.a.bv) r2)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r14 = "DataBase"
            java.lang.String r2 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r14 = "DataBase"
            java.lang.String r15 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
        L_0x0064:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x0066:
            r14 = move-exception
            goto L_0x00a3
        L_0x0068:
            boolean r3 = r13.moveToNext()     // Catch:{ Throwable -> 0x0066 }
            if (r3 == 0) goto L_0x0076
            java.lang.Object r3 = r12.a((android.database.Cursor) r13, r14, (com.amap.api.services.a.bv) r2)     // Catch:{ Throwable -> 0x0066 }
            r1.add(r3)     // Catch:{ Throwable -> 0x0066 }
            goto L_0x0068
        L_0x0076:
            if (r13 == 0) goto L_0x0086
            r13.close()     // Catch:{ Throwable -> 0x007c }
            goto L_0x0086
        L_0x007c:
            r13 = move-exception
            if (r15 != 0) goto L_0x0086
            java.lang.String r14 = "DataBase"
            java.lang.String r2 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r14 = "DataBase"
            java.lang.String r15 = "searchListData"
        L_0x009a:
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r15)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r2 = "DataBase"
            java.lang.String r3 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r14, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ad }
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
            java.lang.String r1 = "DataBase"
            java.lang.String r2 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r15 = "DataBase"
            java.lang.String r1 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r15, (java.lang.String) r1)     // Catch:{ all -> 0x00fd }
        L_0x00d4:
            throw r14     // Catch:{ all -> 0x00fd }
        L_0x00d5:
            if (r13 == 0) goto L_0x00e5
            r13.close()     // Catch:{ Throwable -> 0x00db }
            goto L_0x00e5
        L_0x00db:
            r13 = move-exception
            if (r15 != 0) goto L_0x00e5
            java.lang.String r14 = "DataBase"
            java.lang.String r2 = "searchListData"
            com.amap.api.services.a.bl.a((java.lang.Throwable) r13, (java.lang.String) r14, (java.lang.String) r2)     // Catch:{ all -> 0x00fd }
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
            java.lang.String r14 = "DataBase"
            java.lang.String r15 = "searchListData"
            goto L_0x009a
        L_0x00f9:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fb:
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            return r1
        L_0x00fd:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00fd }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.bu.a(java.lang.String, java.lang.Class, boolean):java.util.List");
    }

    public <T> List<T> b(String str, Class<T> cls) {
        return a(str, cls, false);
    }

    private <T> T a(Cursor cursor, Class<T> cls, bv bvVar) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Field[] a2 = a((Class<?>) cls, bvVar.b());
        Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        declaredConstructor.setAccessible(true);
        T newInstance = declaredConstructor.newInstance(new Object[0]);
        for (Field field : a2) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(bw.class);
            if (annotation != null) {
                bw bwVar = (bw) annotation;
                int b2 = bwVar.b();
                int columnIndex = cursor.getColumnIndex(bwVar.a());
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

    private void a(Object obj, Field field, ContentValues contentValues) {
        Annotation annotation = field.getAnnotation(bw.class);
        if (annotation != null) {
            bw bwVar = (bw) annotation;
            switch (bwVar.b()) {
                case 1:
                    contentValues.put(bwVar.a(), Short.valueOf(field.getShort(obj)));
                    return;
                case 2:
                    contentValues.put(bwVar.a(), Integer.valueOf(field.getInt(obj)));
                    return;
                case 3:
                    contentValues.put(bwVar.a(), Float.valueOf(field.getFloat(obj)));
                    return;
                case 4:
                    contentValues.put(bwVar.a(), Double.valueOf(field.getDouble(obj)));
                    return;
                case 5:
                    contentValues.put(bwVar.a(), Long.valueOf(field.getLong(obj)));
                    return;
                case 6:
                    contentValues.put(bwVar.a(), (String) field.get(obj));
                    return;
                case 7:
                    try {
                        contentValues.put(bwVar.a(), (byte[]) field.get(obj));
                        return;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private ContentValues a(Object obj, bv bvVar) {
        ContentValues contentValues = new ContentValues();
        for (Field field : a(obj.getClass(), bvVar.b())) {
            field.setAccessible(true);
            a(obj, field, contentValues);
        }
        return contentValues;
    }

    private Field[] a(Class<?> cls, boolean z) {
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
                bl.a(th, "DBOperation", "getReadAbleDataBase");
            } else {
                th.printStackTrace();
            }
        }
        return this.b;
    }

    private SQLiteDatabase b(boolean z) {
        try {
            if (this.b == null || this.b.isReadOnly()) {
                if (this.b != null) {
                    this.b.close();
                }
                this.b = this.a.getWritableDatabase();
            }
        } catch (Throwable th) {
            bl.a(th, "DBOperation", "getWriteDatabase");
        }
        return this.b;
    }

    private <T> String a(bv bvVar) {
        if (bvVar == null) {
            return null;
        }
        return bvVar.a();
    }

    private <T> bv b(Class<T> cls) {
        Annotation annotation = cls.getAnnotation(bv.class);
        if (!a(annotation)) {
            return null;
        }
        return (bv) annotation;
    }
}
