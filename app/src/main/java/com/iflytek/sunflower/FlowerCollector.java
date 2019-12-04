package com.iflytek.sunflower;

import android.content.Context;
import android.content.SharedPreferences;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.entity.UserEntity;
import com.iflytek.sunflower.task.g;
import com.iflytek.sunflower.util.c;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.util.HashMap;
import org.json.JSONObject;

public class FlowerCollector {

    public enum Gender {
        Male,
        Female,
        Unknown
    }

    public enum UserState {
        Register,
        Login,
        Logout
    }

    public static void setAutoLocation(boolean z) {
        a.r = Boolean.valueOf(z);
    }

    public static void setAppid(String str) {
        a.b = str;
    }

    public static void setCollectWfEnable(boolean z) {
        a.i = Boolean.valueOf(z);
    }

    public static void openPageMode(Boolean bool) {
        a.j = bool;
    }

    public static void setChannel(String str) {
        a.e = str;
    }

    public static void setDebugMode(boolean z) {
        j.a(z);
    }

    public static void setEnabled(boolean z) {
        a.s = Boolean.valueOf(z);
    }

    public static void setGender(Context context, Gender gender) {
        if (gender == null) {
            j.a("Collector", "input Gender is null ");
            return;
        }
        try {
            SharedPreferences a = c.a(context);
            int i = 0;
            switch (gender) {
                case Male:
                    i = 1;
                    break;
                case Female:
                    i = 2;
                    break;
                case Unknown:
                    break;
            }
            a.edit().putInt("gender", i).commit();
        } catch (Exception e) {
            j.a("Collector", "input Gender error:" + e);
        }
    }

    public static void setAge(Context context, int i) {
        try {
            SharedPreferences a = c.a(context);
            if (i >= 0) {
                if (i <= 200) {
                    a.edit().putInt("age", i).commit();
                    return;
                }
            }
            j.a("Collector", "input Age is not valid ");
        } catch (Exception e) {
            j.a("Collector", "input age error:" + e);
        }
    }

    public static void setUserID(Context context, String str) {
        try {
            SharedPreferences a = c.a(context);
            if (l.a((CharSequence) str)) {
                j.a("Collector", "input userID is null or empty");
            } else if (!c.a(str, a.u)) {
                j.a("Collector", "input userID is large than " + a.u);
            } else {
                a.edit().putString("user_id", str).commit();
            }
        } catch (Exception e) {
            j.a("Collector", "input userId error:" + e);
        }
    }

    public static void setSessionContinueMillis(long j) {
        if (j <= 0) {
            j.a("Collector", "input millis is not valid ");
        } else {
            a.a = j;
        }
    }

    public static void setCaptureUncaughtException(Boolean bool) {
        a.k = bool;
    }

    public static void setCatchAnr(Boolean bool) {
        a.l = bool;
    }

    public static void setCatchNativeCrash(Boolean bool) {
        a.m = bool;
    }

    public static void setParameter(String str, String str2) {
        b.a((Context) null).a(str, str2);
    }

    public static void onPageStart(String str) {
        if (a.s.booleanValue()) {
            if (!l.b(str)) {
                j.c("Collector", "pageName is null or empty");
            } else if (!c.a(str, a.u)) {
                j.c("Collector", "pageName is large than " + a.u);
            } else {
                b.a((Context) null).a(str);
            }
        }
    }

    public static void onPageEnd(String str) {
        if (a.s.booleanValue()) {
            if (!l.b(str)) {
                j.c("Collector", "pageName is null or empty");
            } else if (!c.a(str, a.u)) {
                j.c("Collector", "pageName is large than " + a.u);
            } else {
                b.a((Context) null).b(str);
            }
        }
    }

    public static void onPause(Context context) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onPause");
            } else {
                b.a(context).b();
            }
        }
    }

    public static void onResume(Context context) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onResume");
            } else {
                b.a(context).a();
            }
        }
    }

    public static void onError(Context context, String str, String str2) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onError");
            } else {
                b.a(context).b(str, str2);
            }
        }
    }

    public static void flush(Context context) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in flush");
            } else {
                b.a(context).c();
            }
        }
    }

    public static void onEvent(Context context, String str) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEvent");
            } else {
                b.a(context).a(str, (String) null, (HashMap<String, String>) null, 0);
            }
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEvent");
            } else {
                b.a(context).a(str, str2, (HashMap<String, String>) null, 0);
            }
        }
    }

    public static void onEvent(Context context, String str, HashMap<String, String> hashMap) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEvent");
            } else {
                b.a(context).a(str, (String) null, hashMap, 0);
            }
        }
    }

    public static void onEventDuration(Context context, String str, long j) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEventDuration");
            } else if (j <= 0) {
                j.c("Collector", "duration is not valid in onEventDuration");
            } else {
                b.a(context).a(str, (String) null, (HashMap<String, String>) null, j);
            }
        }
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEventDuration");
            } else if (j <= 0) {
                j.c("Collector", "duration is not valid in onEventDuration");
            } else {
                b.a(context).a(str, str2, (HashMap<String, String>) null, j);
            }
        }
    }

    public static void onEventDuration(Context context, String str, HashMap<String, String> hashMap, long j) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "context is null in onEventDuration");
            } else if (j <= 0) {
                j.c("Collector", "duration is not valid in onEventDuration");
            } else {
                b.a(context).a(str, (String) null, hashMap, j);
            }
        }
    }

    public static void onEventBegin(Context context, String str) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "unexpected null context in onEventBegin");
            } else {
                b.a(context).b(str, (String) null, (HashMap<String, String>) null, 0);
            }
        }
    }

    public static void onEventBegin(Context context, String str, HashMap<String, String> hashMap) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "unexpected null context in onEventBegin");
            } else {
                b.a(context).b(str, (String) null, hashMap, 0);
            }
        }
    }

    public static void onEventEnd(Context context, String str) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "unexpected null context in onEventEnd");
            } else {
                b.a(context).c(str, (String) null, (HashMap<String, String>) null, 0);
            }
        }
    }

    public static void onLog(Context context, JSONObject jSONObject, String str, HashMap<String, String> hashMap) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "unexpected null context in onEventEnd");
            } else {
                b.a(context).a(jSONObject, str, hashMap);
            }
        }
    }

    public static String getOnlineParams(Context context, String str) {
        if (!a.s.booleanValue()) {
            return "";
        }
        if (context != null) {
            return c.b(context).getString(str, "");
        }
        j.c("Collector", "unexpected null context in getOnlineParams");
        return "";
    }

    public static void updateOnlineConfig(Context context, OnlineConfigListener onlineConfigListener) {
        if (a.s.booleanValue()) {
            if (context == null) {
                j.c("Collector", "unexpected null context in updateOnlineConfig");
            } else {
                b.a(context).a(onlineConfigListener);
            }
        }
    }

    public static void onKillProcess(Context context) {
        if (a.s.booleanValue()) {
            new g(context).a();
        }
    }

    public static void setOnLineConfig(String str) {
        a.B = str;
    }

    public static void bindUser(Context context, UserState userState, UserEntity userEntity) {
        switch (userState) {
            case Register:
                if (userEntity != null) {
                    try {
                        onEvent(context, "$user_register$", userEntity.compose2Map());
                        a.I = userEntity.uId;
                        return;
                    } catch (Exception unused) {
                        return;
                    }
                } else {
                    return;
                }
            case Login:
                if (userEntity != null) {
                    a.I = userEntity.uId;
                }
                a.J = true;
                return;
            case Logout:
                a.I = null;
                a.J = false;
                return;
            default:
                return;
        }
    }
}
