package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;

public class df extends dg {
    private static final String[] d = {"display_name", "_id"};
    private static final String[] e = {"display_name", "data1", "contact_id"};
    private static final String[] f = {"_id", "has_phone_number"};
    private static final String[] g = {"contact_id"};
    private static final String[] h = {"display_name"};
    private static final String[] i = {"data1", "data2", "display_name"};
    private static final String[] j = {"has_phone_number"};

    public df(Context context) {
        super(context);
        a(context);
    }

    public Uri a() {
        return ContactsContract.Contacts.CONTENT_URI;
    }

    /* access modifiers changed from: protected */
    public String[] b() {
        return d;
    }

    /* access modifiers changed from: protected */
    public String c() {
        return Integer.parseInt(Build.VERSION.SDK) >= 8 ? "sort_key" : "display_name";
    }
}
