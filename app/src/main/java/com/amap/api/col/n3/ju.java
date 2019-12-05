package com.amap.api.col.n3;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public final class ju implements iz {
    private static ju a;

    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
    }

    public final String b() {
        return "dafile.db";
    }

    public final int c() {
        return 1;
    }

    public static synchronized ju a() {
        ju juVar;
        synchronized (ju.class) {
            if (a == null) {
                a = new ju();
            }
            juVar = a;
        }
        return juVar;
    }

    private ju() {
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            ir.a(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
