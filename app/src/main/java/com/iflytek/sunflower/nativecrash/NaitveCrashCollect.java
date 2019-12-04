package com.iflytek.sunflower.nativecrash;

import android.content.Context;
import com.iflytek.sunflower.util.Linker;

public class NaitveCrashCollect {
    private static native void nativeCrashCollectInit(Context context, Object obj, String str, String str2, int i);

    public static boolean a(Context context, a aVar, String str, String str2, int i) {
        boolean loadLibrary = Linker.loadLibrary(context, "csunflower");
        if (loadLibrary) {
            nativeCrashCollectInit(context, aVar, str, str2, i);
        }
        return loadLibrary;
    }
}
