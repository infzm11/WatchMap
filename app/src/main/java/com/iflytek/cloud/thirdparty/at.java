package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

public class at {

    public enum a {
        a,
        res,
        c
    }

    public static String a(Context context, a aVar, String str) {
        return aVar == a.c ? a(str) : b(context, aVar, str);
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

    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[SYNTHETIC, Splitter:B:32:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007a A[SYNTHETIC, Splitter:B:39:0x007a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(android.content.Context r6, com.iflytek.cloud.thirdparty.at.a r7, java.lang.String r8) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 0
            if (r0 != 0) goto L_0x0083
            if (r6 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.lang.String r0 = r6.getPackageResourcePath()
            com.iflytek.cloud.thirdparty.at$a r2 = com.iflytek.cloud.thirdparty.at.a.a     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            if (r7 != r2) goto L_0x0025
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            android.content.res.AssetFileDescriptor r6 = r6.openFd(r8)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            long r7 = r6.getStartOffset()     // Catch:{ Exception -> 0x0023 }
        L_0x001e:
            long r2 = r6.getLength()     // Catch:{ Exception -> 0x0023 }
            goto L_0x003a
        L_0x0023:
            r7 = move-exception
            goto L_0x0068
        L_0x0025:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            int r7 = r7.intValue()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            android.content.res.Resources r6 = r6.getResources()     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            android.content.res.AssetFileDescriptor r6 = r6.openRawResourceFd(r7)     // Catch:{ Exception -> 0x0066, all -> 0x0063 }
            long r7 = r6.getStartOffset()     // Catch:{ Exception -> 0x0023 }
            goto L_0x001e
        L_0x003a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0023 }
            java.lang.String r5 = "fo|"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0023 }
            r4.append(r0)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r0 = "|"
            r4.append(r0)     // Catch:{ Exception -> 0x0023 }
            r4.append(r7)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = "|"
            r4.append(r7)     // Catch:{ Exception -> 0x0023 }
            r4.append(r2)     // Catch:{ Exception -> 0x0023 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x0023 }
            if (r6 == 0) goto L_0x0076
            r6.close()     // Catch:{ Exception -> 0x005e }
            return r7
        L_0x005e:
            r6 = move-exception
            r6.printStackTrace()
            return r7
        L_0x0063:
            r7 = move-exception
            r6 = r1
            goto L_0x0078
        L_0x0066:
            r7 = move-exception
            r6 = r1
        L_0x0068:
            r7.printStackTrace()     // Catch:{ all -> 0x0077 }
            if (r6 == 0) goto L_0x0075
            r6.close()     // Catch:{ Exception -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0075:
            r7 = r1
        L_0x0076:
            return r7
        L_0x0077:
            r7 = move-exception
        L_0x0078:
            if (r6 == 0) goto L_0x0082
            r6.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0082:
            throw r7
        L_0x0083:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.at.b(android.content.Context, com.iflytek.cloud.thirdparty.at$a, java.lang.String):java.lang.String");
    }
}
