package com.iflytek.cloud.thirdparty;

import android.support.v7.widget.ActivityChooserView;
import java.util.concurrent.ConcurrentLinkedQueue;

public class aa {
    private long a;
    private int b = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private ConcurrentLinkedQueue<y> c = new ConcurrentLinkedQueue<>();

    public aa() {
    }

    public aa(int i) {
        this.b = i;
    }

    public y a() {
        y poll = this.c.poll();
        if (poll != null) {
            this.a -= (long) poll.a();
        }
        return poll;
    }

    public void a(y yVar) {
        if (yVar != null && yVar.a() != -1) {
            if (this.c.size() >= this.b) {
                this.c.poll();
            } else {
                this.a += (long) yVar.a();
            }
            this.c.add(yVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.iflytek.cloud.thirdparty.y b() {
        /*
            r5 = this;
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            r2 = r1
        L_0x0007:
            com.iflytek.cloud.thirdparty.y r3 = r5.a()     // Catch:{ IOException -> 0x0024 }
            if (r3 == 0) goto L_0x001a
            com.iflytek.cloud.thirdparty.ce r4 = r3.b     // Catch:{ IOException -> 0x0024 }
            byte[] r2 = r3.a     // Catch:{ IOException -> 0x0016 }
            r0.write(r2)     // Catch:{ IOException -> 0x0016 }
            r2 = r4
            goto L_0x0007
        L_0x0016:
            r0 = move-exception
            r3 = r1
            r2 = r4
            goto L_0x0026
        L_0x001a:
            byte[] r3 = r0.toByteArray()     // Catch:{ IOException -> 0x0024 }
            r0.close()     // Catch:{ IOException -> 0x0022 }
            goto L_0x0029
        L_0x0022:
            r0 = move-exception
            goto L_0x0026
        L_0x0024:
            r0 = move-exception
            r3 = r1
        L_0x0026:
            r0.printStackTrace()
        L_0x0029:
            if (r3 != 0) goto L_0x002c
            return r1
        L_0x002c:
            com.iflytek.cloud.thirdparty.y r0 = new com.iflytek.cloud.thirdparty.y
            r0.<init>((byte[]) r3, (com.iflytek.cloud.thirdparty.ce) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.aa.b():com.iflytek.cloud.thirdparty.y");
    }

    public long c() {
        return this.a;
    }

    public void d() {
        this.c.clear();
        this.a = 0;
    }
}
