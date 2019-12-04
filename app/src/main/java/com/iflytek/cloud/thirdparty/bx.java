package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.graphics.Paint;
import android.media.AudioManager;
import android.os.Build;
import android.view.View;

public class bx {
    private static int a;

    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 11) {
            view.setLayerType(1, (Paint) null);
        }
    }

    public static boolean a(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            ((AudioManager) context.getSystemService("audio")).requestAudioFocus(onAudioFocusChangeListener, 3, 2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener) {
        try {
            ((AudioManager) context.getSystemService("audio")).abandonAudioFocus(onAudioFocusChangeListener);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
