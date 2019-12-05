package com.amap.api.services.a;

import android.database.sqlite.SQLiteDatabase;

/* compiled from: DynamicFileDBCreator */
public class cq implements bt {
    private static cq a;

    public String a() {
        return "dafile.db";
    }

    public void a(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public int b() {
        return 1;
    }

    public static synchronized cq c() {
        cq cqVar;
        synchronized (cq.class) {
            if (a == null) {
                a = new cq();
            }
            cqVar = a;
        }
        return cqVar;
    }

    private cq() {
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS file (_id integer primary key autoincrement, sname  varchar(20), fname varchar(100),md varchar(20),version varchar(20),dversion varchar(20),status varchar(20),reservedfield varchar(20));");
        } catch (Throwable th) {
            cs.a(th, "DynamicFileDBCreator", "onCreate");
        }
    }
}
