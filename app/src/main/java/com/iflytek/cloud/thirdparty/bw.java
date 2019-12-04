package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.view.View;

public class bw {
    public static int a = 9;
    public static int b = 14;

    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= b) {
            bx.a(view);
        }
    }

    public static boolean a(Context context, Boolean bool, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (!bool.booleanValue() || Build.VERSION.SDK_INT < a) {
            return false;
        }
        bx.a(context, onAudioFocusChangeListener);
        return false;
    }

    public static boolean b(Context context, Boolean bool, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        if (!bool.booleanValue() || Build.VERSION.SDK_INT < a) {
            return false;
        }
        return bx.b(context, onAudioFocusChangeListener);
    }
}
