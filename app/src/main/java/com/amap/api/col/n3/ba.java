package com.amap.api.col.n3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: OfflineDBCreator */
public class ba implements iz {
    private static volatile ba a;

    public final String b() {
        return "offlineDbV4.db";
    }

    public final int c() {
        return 2;
    }

    public static ba a() {
        if (a == null) {
            synchronized (ba.class) {
                if (a == null) {
                    a = new ba();
                }
            }
        }
        return a;
    }

    private ba() {
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item (_id integer primary key autoincrement, title  TEXT, url TEXT,mAdcode TEXT,fileName TEXT,version TEXT,lLocalLength INTEGER,lRemoteLength INTEGER,localPath TEXT,mIndex INTEGER,isProvince INTEGER NOT NULL,mCompleteCode INTEGER,mCityCode TEXT,mState INTEGER,mPinyin TEXT, UNIQUE(mAdcode));");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_file (_id integer primary key autoincrement,mAdcode TTEXT, file TEXT);");
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS update_item_download_info (_id integer primary key autoincrement,mAdcode TEXT,fileLength integer,splitter integer,startPos integer,endPos integer, UNIQUE(mAdcode));");
            } catch (Throwable th) {
                iu.b(th, "DB", "onCreate");
                th.printStackTrace();
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase, int i) {
        if (sQLiteDatabase != null && i == 1) {
            sQLiteDatabase.execSQL("ALTER TABLE update_item ADD COLUMN mPinyin TEXT;");
            Cursor query = sQLiteDatabase.query("update_item", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            if (query == null) {
                sQLiteDatabase.close();
                sQLiteDatabase = null;
            }
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("url"));
                    String substring = string.substring(string.lastIndexOf("/") + 1);
                    sQLiteDatabase.execSQL("update update_item set mPinyin=? where url =?", new String[]{substring.substring(0, substring.lastIndexOf(".")), string});
                }
                query.close();
            }
        }
    }
}
