package com.amap.api.col.n3;

import android.content.Context;
import android.support.v7.widget.helper.ItemTouchHelper;

/* compiled from: SPUtil */
public final class lt {
    public static int a(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        } catch (Throwable th) {
            lr.a(th, "SPUtil", "getPrefsInt");
            return ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, true);
        } catch (Throwable th) {
            lr.a(th, "SPUtil", "getPrefsBoolean");
            return true;
        }
    }
}
