package com.amap.api.col.n3;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

/* compiled from: ResourcesUtil */
public final class dr {
    private static boolean a = new File("/system/framework/amap.jar").exists();

    public static AssetManager a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assets, new Object[]{"/system/framework/amap.jar"});
            } catch (Throwable th) {
                iu.b(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int b(Context context) {
        return (int) ((1.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
