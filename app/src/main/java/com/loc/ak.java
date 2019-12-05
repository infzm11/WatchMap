package com.loc;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: DB */
public final class ak extends SQLiteOpenHelper {
    /* access modifiers changed from: private */
    public static boolean b = true;
    /* access modifiers changed from: private */
    public static boolean c = false;
    private ae a;

    /* compiled from: DB */
    public static class a extends ContextWrapper {
        private String a;
        private Context b;

        public a(Context context, String str) {
            super(context);
            this.a = str;
            this.b = context;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            com.loc.ak.d();
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0086 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.File getDatabasePath(java.lang.String r5) {
            /*
                r4 = this;
                boolean r0 = com.loc.ak.b     // Catch:{ Throwable -> 0x00a0 }
                if (r0 == 0) goto L_0x009b
                android.content.Context r0 = r4.b     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r1 = "android.permission.WRITE_EXTERNAL_STORAGE"
                boolean r0 = com.loc.t.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Throwable -> 0x00a0 }
                if (r0 != 0) goto L_0x0012
                goto L_0x009b
            L_0x0012:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a0 }
                r0.<init>()     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r1 = r4.a     // Catch:{ Throwable -> 0x00a0 }
                r0.append(r1)     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r1 = "/"
                r0.append(r1)     // Catch:{ Throwable -> 0x00a0 }
                r0.append(r5)     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00a0 }
                java.io.File r1 = new java.io.File     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r2 = r4.a     // Catch:{ Throwable -> 0x00a0 }
                r1.<init>(r2)     // Catch:{ Throwable -> 0x00a0 }
                boolean r2 = r1.exists()     // Catch:{ Throwable -> 0x00a0 }
                if (r2 != 0) goto L_0x0038
                r1.mkdirs()     // Catch:{ Throwable -> 0x00a0 }
            L_0x0038:
                boolean r1 = com.loc.ak.c     // Catch:{ Throwable -> 0x00a0 }
                if (r1 == 0) goto L_0x0044
                boolean r1 = com.loc.ak.b     // Catch:{ Throwable -> 0x00a0 }
                if (r1 != 0) goto L_0x0074
            L_0x0044:
                boolean unused = com.loc.ak.c = true     // Catch:{ Throwable -> 0x00a0 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00a0 }
                r1.<init>()     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r2 = r4.a     // Catch:{ Throwable -> 0x00a0 }
                r1.append(r2)     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r2 = java.io.File.separator     // Catch:{ Throwable -> 0x00a0 }
                r1.append(r2)     // Catch:{ Throwable -> 0x00a0 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Throwable -> 0x00a0 }
                r1.append(r2)     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r2 = ".db"
                r1.append(r2)     // Catch:{ Throwable -> 0x00a0 }
                java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x00a0 }
                java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00a0 }
                r2.<init>(r1)     // Catch:{ Throwable -> 0x00a0 }
                boolean r1 = r2.createNewFile()     // Catch:{ Throwable -> 0x00a0 }
                if (r1 == 0) goto L_0x0093
                r2.delete()     // Catch:{ Throwable -> 0x00a0 }
            L_0x0074:
                r1 = 0
                java.io.File r2 = new java.io.File     // Catch:{ Throwable -> 0x00a0 }
                r2.<init>(r0)     // Catch:{ Throwable -> 0x00a0 }
                boolean r0 = r2.exists()     // Catch:{ Throwable -> 0x00a0 }
                if (r0 != 0) goto L_0x008a
                boolean r0 = r2.createNewFile()     // Catch:{ IOException -> 0x0086 }
                r1 = r0
                goto L_0x008b
            L_0x0086:
                boolean unused = com.loc.ak.b = false     // Catch:{ Throwable -> 0x00a0 }
                goto L_0x008b
            L_0x008a:
                r1 = 1
            L_0x008b:
                if (r1 == 0) goto L_0x008e
                return r2
            L_0x008e:
                java.io.File r0 = super.getDatabasePath(r5)     // Catch:{ Throwable -> 0x00a0 }
                return r0
            L_0x0093:
                boolean unused = com.loc.ak.b = false     // Catch:{ Throwable -> 0x00a0 }
                java.io.File r0 = super.getDatabasePath(r5)     // Catch:{ Throwable -> 0x00a0 }
                return r0
            L_0x009b:
                java.io.File r0 = super.getDatabasePath(r5)     // Catch:{ Throwable -> 0x00a0 }
                return r0
            L_0x00a0:
                boolean unused = com.loc.ak.b = false
                java.io.File r5 = super.getDatabasePath(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.loc.ak.a.getDatabasePath(java.lang.String):java.io.File");
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable unused) {
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.b.getApplicationContext().getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }

        public final SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
            SQLiteDatabase sQLiteDatabase;
            if (getDatabasePath(str) != null) {
                try {
                    sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
                } catch (Throwable unused) {
                    sQLiteDatabase = null;
                }
                if (sQLiteDatabase != null) {
                    return sQLiteDatabase;
                }
            }
            return SQLiteDatabase.openOrCreateDatabase(this.b.getApplicationContext().getDatabasePath(str), (SQLiteDatabase.CursorFactory) null);
        }
    }

    public ak(Context context, String str, ae aeVar) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.a = aeVar;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        this.a.a(sQLiteDatabase);
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        ae aeVar = this.a;
    }
}
