package com.loc;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;

/* compiled from: SPUtil */
public final class cz {
    public static String a(Context context) {
        String str;
        Throwable th;
        if (context == null) {
            return "00:00:00:00:00:00";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("pref", 0);
        if (sharedPreferences == null || !sharedPreferences.contains("smac")) {
            return "00:00:00:00:00:00";
        }
        try {
            str = sharedPreferences.getString("smac", (String) null);
            try {
                return new String(o.b(str), "UTF-8");
            } catch (Throwable th2) {
                th = th2;
                cs.a(th, "SPUtil", "getSmac");
                sharedPreferences.edit().remove("smac").commit();
                return str;
            }
        } catch (Throwable th3) {
            Throwable th4 = th3;
            str = "00:00:00:00:00:00";
            th = th4;
            cs.a(th, "SPUtil", "getSmac");
            sharedPreferences.edit().remove("smac").commit();
            return str;
        }
    }

    public static String a(Context context, String str, String str2, String str3) {
        try {
            return context.getSharedPreferences(str, 0).getString(str2, str3);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "getPrefsInt");
            return str3;
        }
    }

    public static void a(Context context, String str, String str2, int i) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putInt(str2, i);
            a(edit);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "setPrefsInt");
        }
    }

    public static void a(Context context, String str, String str2, long j) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putLong(str2, j);
            a(edit);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "setPrefsLong");
        }
    }

    public static void a(Context context, String str, String str2, boolean z) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putBoolean(str2, z);
            a(edit);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "updatePrefsBoolean");
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(final SharedPreferences.Editor editor) {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= 9) {
                editor.apply();
                return;
            }
            try {
                new AsyncTask<Void, Void, Void>() {
                    private Void a() {
                        try {
                            if (editor == null) {
                                return null;
                            }
                            editor.commit();
                            return null;
                        } catch (Throwable th) {
                            cs.a(th, "SPUtil", "commit");
                            return null;
                        }
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                        return a();
                    }
                }.execute(new Void[]{null, null, null});
            } catch (Throwable th) {
                cs.a(th, "SPUtil", "commit1");
            }
        }
    }

    public static int b(Context context, String str, String str2, int i) {
        try {
            return context.getSharedPreferences(str, 0).getInt(str2, i);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "getPrefsInt");
            return i;
        }
    }

    public static long b(Context context, String str, String str2, long j) {
        try {
            return context.getSharedPreferences(str, 0).getLong(str2, j);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "getPrefsLong");
            return j;
        }
    }

    public static boolean b(Context context, String str, String str2, boolean z) {
        try {
            return context.getSharedPreferences(str, 0).getBoolean(str2, z);
        } catch (Throwable th) {
            cs.a(th, "SPUtil", "getPrefsBoolean");
            return z;
        }
    }
}
