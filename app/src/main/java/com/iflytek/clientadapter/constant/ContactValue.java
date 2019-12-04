package com.iflytek.clientadapter.constant;

import android.net.Uri;

public class ContactValue {
    public static final String NAME = "name";
    public static final String NUMBER = "number";
    private static final String PROVIDER = "content://com.iflytek.autofly.phone.provider";
    public static final String TABLENAME = "flycontactdb";
    public static Uri URI_TABLE = Uri.withAppendedPath(Uri.parse(PROVIDER), TABLENAME);
}
