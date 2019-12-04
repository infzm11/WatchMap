package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.net.Uri;
import android.provider.Contacts;
import com.iflytek.clientadapter.constant.ContactValue;

public class de extends dg {
    private static final String[] d = {"_id", "name"};
    private static final String[] e = {"name", ContactValue.NUMBER, "_id"};
    private static final String[] f = {"person"};
    private static final String[] g = {"display_name"};
    private static final String[] h = {ContactValue.NUMBER, "type", "name"};
    private static final String[] i = {"_id", "name", ContactValue.NUMBER, "type"};
    private static final String[] j = {ContactValue.NUMBER};

    public de(Context context) {
        super(context);
        a(context);
    }

    public Uri a() {
        return Contacts.People.CONTENT_URI;
    }

    /* access modifiers changed from: protected */
    public String[] b() {
        return d;
    }

    /* access modifiers changed from: protected */
    public String c() {
        return "name";
    }
}
