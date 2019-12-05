package com.amap.api.col.n3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public final class jf extends SQLiteOpenHelper {
    private static boolean b = true;
    private static boolean c = false;
    private iz a;

    public jf(Context context, String str, int i, iz izVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.a = izVar;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.a.a(sQLiteDatabase, i);
    }
}
