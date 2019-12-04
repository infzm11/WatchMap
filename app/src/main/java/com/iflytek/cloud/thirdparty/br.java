package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import com.iflytek.cloud.Setting;

public class br {
    public static br a;
    private SharedPreferences b = null;
    private Context c = null;
    private boolean d = true;
    private long e = 0;

    private br(Context context) {
        this.c = context;
        this.b = context.getSharedPreferences("com.iflytek.msc", 0);
        this.d = b(context);
    }

    public static br a(Context context) {
        if (a == null && context != null) {
            c(context);
        }
        return a;
    }

    public static boolean b(Context context) {
        try {
            if (!Setting.getLocationEnable() || context == null) {
                return false;
            }
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            for (int i = 0; i < strArr.length; i++) {
                if ("android.permission.ACCESS_FINE_LOCATION".equalsIgnoreCase(strArr[i]) || "android.permission.ACCESS_COARSE_LOCATION".equalsIgnoreCase(strArr[i])) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    private static synchronized br c(Context context) {
        br brVar;
        synchronized (br.class) {
            if (a == null) {
                a = new br(context);
            }
            bv.a(context);
            bp.a(context);
            brVar = a;
        }
        return brVar;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x00a7 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized float a(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.d     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00a7
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a7 }
            long r2 = r4.e     // Catch:{ Exception -> 0x00a7 }
            long r0 = r0 - r2
            r2 = 216000(0x34bc0, double:1.06718E-318)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a7
            android.content.Context r0 = r4.c     // Catch:{ Exception -> 0x00a7 }
            android.content.Context r0 = r0.getApplicationContext()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "location"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ Exception -> 0x00a7 }
            android.location.LocationManager r0 = (android.location.LocationManager) r0     // Catch:{ Exception -> 0x00a7 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a7 }
            r4.e = r1     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "loction_last_update"
            long r2 = r4.e     // Catch:{ Exception -> 0x00a7 }
            r4.a(r1, r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r1.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r2 = "getLocation begin:"
            r1.append(r2)     // Catch:{ Exception -> 0x00a7 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a7 }
            r1.append(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x00a7 }
            com.iflytek.cloud.thirdparty.cb.d(r1)     // Catch:{ Exception -> 0x00a7 }
            android.location.Criteria r1 = new android.location.Criteria     // Catch:{ Exception -> 0x00a7 }
            r1.<init>()     // Catch:{ Exception -> 0x00a7 }
            r2 = 1
            r1.setAccuracy(r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = r0.getBestProvider(r1, r2)     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r2.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = "bestProvider:"
            r2.append(r3)     // Catch:{ Exception -> 0x00a7 }
            r2.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x00a7 }
            com.iflytek.cloud.thirdparty.cb.d(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "gps"
            android.location.Location r1 = r0.getLastKnownLocation(r1)     // Catch:{ Exception -> 0x00a7 }
            if (r1 == 0) goto L_0x007a
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x00a7 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00a7 }
            r4.a((android.location.Location) r1)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x008c
        L_0x007a:
            java.lang.String r1 = "network"
            android.location.Location r0 = r0.getLastKnownLocation(r1)     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x008c
            java.lang.String r1 = r0.toString()     // Catch:{ Exception -> 0x00a7 }
            com.iflytek.cloud.thirdparty.cb.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00a7 }
            r4.a((android.location.Location) r0)     // Catch:{ Exception -> 0x00a7 }
        L_0x008c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r0.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r1 = "getLocation end:"
            r0.append(r1)     // Catch:{ Exception -> 0x00a7 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a7 }
            r0.append(r1)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a7 }
            com.iflytek.cloud.thirdparty.cb.d(r0)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00a7
        L_0x00a5:
            r5 = move-exception
            goto L_0x00b2
        L_0x00a7:
            android.content.SharedPreferences r0 = r4.b     // Catch:{ all -> 0x00a5 }
            r1 = -1110651699(0xffffffffbdcccccd, float:-0.1)
            float r5 = r0.getFloat(r5, r1)     // Catch:{ all -> 0x00a5 }
            monitor-exit(r4)
            return r5
        L_0x00b2:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.br.a(java.lang.String):float");
    }

    public void a(Location location) {
        if (location != null) {
            SharedPreferences.Editor edit = this.b.edit();
            edit.putFloat("msc.lat", (float) location.getLatitude());
            edit.putFloat("msc.lng", (float) location.getLongitude());
            edit.commit();
        }
    }

    public void a(String str, long j) {
        SharedPreferences.Editor edit = this.b.edit();
        edit.putLong(str, j);
        edit.commit();
    }
}
