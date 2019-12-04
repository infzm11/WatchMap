package com.iflytek.cloud.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class ResourceUtil {
    public static final String ASR_RES_PATH = "asr_res_path";
    public static final String ENGINE_DESTROY = "engine_destroy";
    public static final String ENGINE_START = "engine_start";
    public static final String GRM_BUILD_PATH = "grm_build_path";
    public static final String IVW_RES_PATH = "ivw_res_path";
    public static final String TTS_RES_PATH = "tts_res_path";

    public enum RESOURCE_TYPE {
        assets,
        res,
        path
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070 A[SYNTHETIC, Splitter:B:32:0x0070] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A[SYNTHETIC, Splitter:B:39:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r6, com.iflytek.cloud.util.ResourceUtil.RESOURCE_TYPE r7, java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0086
            if (r6 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = r6.getPackageResourcePath()
            com.iflytek.cloud.util.ResourceUtil$RESOURCE_TYPE r2 = com.iflytek.cloud.util.ResourceUtil.RESOURCE_TYPE.assets     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            if (r7 != r2) goto L_0x0025
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            android.content.res.AssetFileDescriptor r6 = r6.openFd(r8)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r7 = r6.getStartOffset()     // Catch:{ Exception -> 0x0023 }
        L_0x001e:
            long r2 = r6.getLength()     // Catch:{ Exception -> 0x0023 }
            goto L_0x003a
        L_0x0023:
            r7 = move-exception
            goto L_0x006b
        L_0x0025:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            android.content.res.AssetFileDescriptor r6 = r6.openRawResourceFd(r7)     // Catch:{ Exception -> 0x0069, all -> 0x0066 }
            long r7 = r6.getStartOffset()     // Catch:{ Exception -> 0x0023 }
            goto L_0x001e
        L_0x003a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            r4.<init>()     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = "fo|"
            r4.append(r5)     // Catch:{ Exception -> 0x0023 }
            r4.append(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = "|"
            r4.append(r0)     // Catch:{ Exception -> 0x0023 }
            r4.append(r7)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = "|"
            r4.append(r7)     // Catch:{ Exception -> 0x0023 }
            r4.append(r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x0023 }
            if (r6 == 0) goto L_0x0079
            r6.close()     // Catch:{ Exception -> 0x0061 }
            return r7
        L_0x0061:
            r6 = move-exception
            r6.printStackTrace()
            return r7
        L_0x0066:
            r7 = move-exception
            r6 = r1
            goto L_0x007b
        L_0x0069:
            r7 = move-exception
            r6 = r1
        L_0x006b:
            com.iflytek.cloud.thirdparty.cb.a((java.lang.Throwable) r7)     // Catch:{ all -> 0x007a }
            if (r6 == 0) goto L_0x0078
            r6.close()     // Catch:{ Exception -> 0x0074 }
            goto L_0x0078
        L_0x0074:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0078:
            r7 = r1
        L_0x0079:
            return r7
        L_0x007a:
            r7 = move-exception
        L_0x007b:
            if (r6 == 0) goto L_0x0085
            r6.close()     // Catch:{ Exception -> 0x0081 }
            goto L_0x0085
        L_0x0081:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0085:
            throw r7
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.util.ResourceUtil.a(android.content.Context, com.iflytek.cloud.util.ResourceUtil$RESOURCE_TYPE, java.lang.String):java.lang.String");
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isFile()) {
            return null;
        }
        long length = file.length();
        return "fo|" + str + "|" + 0 + "|" + length;
    }

    public static String generateResourcePath(Context context, RESOURCE_TYPE resource_type, String str) {
        return resource_type == RESOURCE_TYPE.path ? a(str) : a(context, resource_type, str);
    }
}
