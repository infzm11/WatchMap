package com.amap.api.location;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.loc.cs;

public class APSService extends Service {
    APSServiceBase a;

    public IBinder onBind(Intent intent) {
        try {
            return this.a.onBind(intent);
        } catch (Throwable th) {
            cs.a(th, "APSService", "onBind");
            return null;
        }
    }

    public void onCreate() {
        onCreate(this);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0033 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0037 A[Catch:{ Throwable -> 0x0044 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.content.Context r8) {
        /*
            r7 = this;
            boolean r0 = com.loc.cy.d(r8)     // Catch:{ Throwable -> 0x0033 }
            if (r0 == 0) goto L_0x0029
            com.loc.s r2 = com.loc.cs.b()     // Catch:{ Throwable -> 0x0033 }
            java.lang.String r0 = "AY29tLmFtYXAuYXBpLmxvY2F0aW9uLkFQU1NlcnZpY2VXcmFwcGVy"
            java.lang.String r3 = com.loc.t.c((java.lang.String) r0)     // Catch:{ Throwable -> 0x0033 }
            java.lang.Class<com.loc.f> r4 = com.loc.f.class
            r0 = 1
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch:{ Throwable -> 0x0033 }
            java.lang.Class<android.content.Context> r1 = android.content.Context.class
            r6 = 0
            r5[r6] = r1     // Catch:{ Throwable -> 0x0033 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ Throwable -> 0x0033 }
            r0[r6] = r8     // Catch:{ Throwable -> 0x0033 }
            r1 = r8
            r6 = r0
            java.lang.Object r0 = com.loc.au.a(r1, r2, r3, r4, r5, r6)     // Catch:{ Throwable -> 0x0033 }
            com.amap.api.location.APSServiceBase r0 = (com.amap.api.location.APSServiceBase) r0     // Catch:{ Throwable -> 0x0033 }
        L_0x0026:
            r7.a = r0     // Catch:{ Throwable -> 0x0033 }
            goto L_0x0033
        L_0x0029:
            com.amap.api.location.APSServiceBase r0 = r7.a     // Catch:{ Throwable -> 0x0033 }
            if (r0 != 0) goto L_0x0033
            com.loc.f r0 = new com.loc.f     // Catch:{ Throwable -> 0x0033 }
            r0.<init>(r8)     // Catch:{ Throwable -> 0x0033 }
            goto L_0x0026
        L_0x0033:
            com.amap.api.location.APSServiceBase r0 = r7.a     // Catch:{ Throwable -> 0x0044 }
            if (r0 != 0) goto L_0x003e
            com.loc.f r0 = new com.loc.f     // Catch:{ Throwable -> 0x0044 }
            r0.<init>(r8)     // Catch:{ Throwable -> 0x0044 }
            r7.a = r0     // Catch:{ Throwable -> 0x0044 }
        L_0x003e:
            com.amap.api.location.APSServiceBase r8 = r7.a     // Catch:{ Throwable -> 0x0044 }
            r8.onCreate()     // Catch:{ Throwable -> 0x0044 }
            goto L_0x004c
        L_0x0044:
            r8 = move-exception
            java.lang.String r0 = "APSService"
            java.lang.String r1 = "onCreate"
            com.loc.cs.a(r8, r0, r1)
        L_0x004c:
            super.onCreate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.location.APSService.onCreate(android.content.Context):void");
    }

    public void onDestroy() {
        try {
            this.a.onDestroy();
        } catch (Throwable th) {
            cs.a(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            return this.a.onStartCommand(intent, i, i2);
        } catch (Throwable th) {
            cs.a(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
