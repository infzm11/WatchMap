package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.net.Uri;
import com.iflytek.clientadapter.constant.ContactValue;

public abstract class dg {
    protected static final String[] a = {ContactValue.NUMBER, "name", "date"};
    protected static String[] c;
    protected Context b = null;

    public dg(Context context) {
        this.b = context;
    }

    public abstract Uri a();

    /* access modifiers changed from: protected */
    public void a(Context context) {
        c = new String[100];
        c[0] = "其他";
        c[1] = "住宅";
        c[2] = "手机";
        c[3] = "工作";
        c[4] = "工作传真";
        c[5] = "住宅传真";
        c[6] = "寻呼机";
        c[7] = "其他";
        c[9] = "SIM卡";
        for (int i = 10; i < c.length; i++) {
            c[i] = "自定义电话";
        }
    }

    /* access modifiers changed from: protected */
    public abstract String[] b();

    /* access modifiers changed from: protected */
    public abstract String c();

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.HashMap<java.lang.String, java.lang.String> d() {
        /*
            r9 = this;
            java.lang.String[] r6 = r9.b()
            java.util.HashMap r7 = new java.util.HashMap
            r7.<init>()
            r8 = 0
            android.content.Context r0 = r9.b     // Catch:{ Exception -> 0x007c }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x007c }
            android.net.Uri r1 = r9.a()     // Catch:{ Exception -> 0x007c }
            r3 = 0
            r4 = 0
            java.lang.String r5 = r9.c()     // Catch:{ Exception -> 0x007c }
            r2 = r6
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x007c }
            if (r0 != 0) goto L_0x002e
            java.lang.String r1 = "iFly_ContactManager"
            java.lang.String r2 = "queryContacts------cursor is null"
        L_0x0025:
            com.iflytek.cloud.thirdparty.cb.a(r1, r2)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            goto L_0x0073
        L_0x0029:
            r1 = move-exception
            goto L_0x0086
        L_0x002b:
            r1 = move-exception
            r8 = r0
            goto L_0x007d
        L_0x002e:
            int r1 = r0.getCount()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            if (r1 != 0) goto L_0x0039
            java.lang.String r1 = "iFly_ContactManager"
            java.lang.String r2 = "queryContacts------cursor getCount == 0"
            goto L_0x0025
        L_0x0039:
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            if (r1 == 0) goto L_0x005b
            r1 = 0
            r1 = r6[r1]     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            int r1 = r0.getColumnIndex(r1)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r2 = 1
            r2 = r6[r2]     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            int r2 = r0.getColumnIndex(r2)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            if (r1 == 0) goto L_0x0039
            r7.put(r2, r1)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            goto L_0x0039
        L_0x005b:
            java.lang.String r1 = "iFly_ContactManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r2.<init>()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            java.lang.String r3 = "queryContacts_20------count = "
            r2.append(r3)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            int r3 = r0.getCount()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            r2.append(r3)     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x002b, all -> 0x0029 }
            goto L_0x0025
        L_0x0073:
            if (r0 == 0) goto L_0x0085
            r0.close()
            return r7
        L_0x0079:
            r1 = move-exception
            r0 = r8
            goto L_0x0086
        L_0x007c:
            r1 = move-exception
        L_0x007d:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0079 }
            if (r8 == 0) goto L_0x0085
            r8.close()
        L_0x0085:
            return r7
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            r0.close()
        L_0x008b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.dg.d():java.util.HashMap");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0084, code lost:
        if (r2 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0091, code lost:
        if (r2 != null) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0093, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0096, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.iflytek.cloud.thirdparty.dd> e() {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r11.b     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            android.content.ContentResolver r3 = r2.getContentResolver()     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            java.lang.String r2 = "content://icc/adn"
            android.net.Uri r4 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x008a, all -> 0x0087 }
            if (r2 == 0) goto L_0x007f
            int r1 = r2.getCount()     // Catch:{ Exception -> 0x007d }
            if (r1 <= 0) goto L_0x007f
        L_0x0022:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x007d }
            if (r1 == 0) goto L_0x0062
            java.lang.String r1 = "name"
            int r1 = r2.getColumnIndex(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r2.getString(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = "_id"
            int r1 = r2.getColumnIndex(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r2.getString(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = "number"
            int r1 = r2.getColumnIndex(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r1 = com.iflytek.cloud.thirdparty.dc.a(r1)     // Catch:{ Exception -> 0x007d }
            java.lang.String r7 = com.iflytek.cloud.thirdparty.bu.a((java.lang.String) r1)     // Catch:{ Exception -> 0x007d }
            if (r5 == 0) goto L_0x0022
            com.iflytek.cloud.thirdparty.dd r1 = new com.iflytek.cloud.thirdparty.dd     // Catch:{ Exception -> 0x007d }
            r6 = 0
            r8 = 0
            java.lang.String[] r3 = c     // Catch:{ Exception -> 0x007d }
            r9 = 9
            r9 = r3[r9]     // Catch:{ Exception -> 0x007d }
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x007d }
            r0.add(r1)     // Catch:{ Exception -> 0x007d }
            goto L_0x0022
        L_0x0062:
            java.lang.String r1 = "iFly_ContactManager"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r3.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = "querySIM-------count = "
            r3.append(r4)     // Catch:{ Exception -> 0x007d }
            int r4 = r2.getCount()     // Catch:{ Exception -> 0x007d }
            r3.append(r4)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007d }
        L_0x0079:
            com.iflytek.cloud.thirdparty.cb.a(r1, r3)     // Catch:{ Exception -> 0x007d }
            goto L_0x0084
        L_0x007d:
            r1 = move-exception
            goto L_0x008e
        L_0x007f:
            java.lang.String r1 = "iFly_ContactManager"
            java.lang.String r3 = "querySIM-------cursor getCount = 0 or cursor is null"
            goto L_0x0079
        L_0x0084:
            if (r2 == 0) goto L_0x0096
            goto L_0x0093
        L_0x0087:
            r0 = move-exception
            r2 = r1
            goto L_0x0098
        L_0x008a:
            r2 = move-exception
            r10 = r2
            r2 = r1
            r1 = r10
        L_0x008e:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0097 }
            if (r2 == 0) goto L_0x0096
        L_0x0093:
            r2.close()
        L_0x0096:
            return r0
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            if (r2 == 0) goto L_0x009d
            r2.close()
        L_0x009d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.dg.e():java.util.List");
    }
}
