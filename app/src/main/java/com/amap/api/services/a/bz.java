package com.amap.api.services.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public class bz extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c = false;
    private bt a;

    public bz(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, bt btVar) {
        super(context, str, cursorFactory, i);
        this.a = btVar;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i, i2);
    }
}
