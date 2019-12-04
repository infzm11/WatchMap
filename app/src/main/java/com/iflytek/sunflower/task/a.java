package com.iflytek.sunflower.task;

import android.content.Context;
import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.util.f;
import com.iflytek.sunflower.util.g;
import com.iflytek.sunflower.util.i;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class a extends Thread {
    /* access modifiers changed from: private */
    public Context a;
    private String b = null;
    private final String c = "data/anr/traces.txt";
    private C0008a d;
    private boolean e;

    /* renamed from: com.iflytek.sunflower.task.a$a  reason: collision with other inner class name */
    class C0008a implements Runnable {
        private String b;

        public C0008a(String str) {
            this.b = str;
        }

        public void run() {
            if (a.this.a(this.b, a.this.a.getPackageName())) {
                a.this.a(this.b);
            } else {
                j.b("AnrCheckTask", "do not contain this package");
            }
        }
    }

    public a(Context context) {
        this.a = context;
        this.b = this.a.getFilesDir().getAbsolutePath() + "/xcrash_trace_txt";
    }

    public void run() {
        a();
    }

    public void a() {
        if (!g.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            j.c("AnrCheckTask", "Request WRITE_EXTERNAL_STORAGE permission for getting ANR info");
            return;
        }
        if (f.a(this.b)) {
            this.e = false;
        } else if (f.a("data/anr/traces.txt", this.b)) {
            this.e = true;
        } else {
            j.c("AnrCheckTask", "discoverANR failed");
            return;
        }
        try {
            if (!this.e) {
                if (f.b("data/anr/traces.txt", this.b)) {
                    j.c("AnrCheckTask", "No new ANR");
                    return;
                }
                f.a("data/anr/traces.txt", this.b);
            }
            this.d = new C0008a(this.b);
            new Thread(this.d).start();
        } catch (Exception unused) {
            j.d("AnrCheckTask", "compare failed,throws IOException");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.iflytek.sunflower.a r1 = new com.iflytek.sunflower.a     // Catch:{ Throwable -> 0x0019 }
            r1.<init>()     // Catch:{ Throwable -> 0x0019 }
            android.content.Context r2 = r4.a     // Catch:{ Throwable -> 0x0019 }
            java.util.List r5 = r1.a(r5, r2)     // Catch:{ Throwable -> 0x0019 }
            r4.a((java.util.List<java.util.List<java.lang.String>>) r5)     // Catch:{ Throwable -> 0x0014 }
            goto L_0x0022
        L_0x0014:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x001a
        L_0x0019:
            r5 = move-exception
        L_0x001a:
            java.lang.String r1 = "AnrCheckTask"
            java.lang.String r2 = "handleTraceFile error"
            com.iflytek.sunflower.util.j.d(r1, r2, r5)
            r5 = r0
        L_0x0022:
            boolean r5 = com.iflytek.sunflower.util.b.a(r5)
            if (r5 == 0) goto L_0x0030
            java.lang.String r5 = "AnrCheckTask"
            java.lang.String r0 = "handleTraceFile | parser trace return null"
            com.iflytek.sunflower.util.j.a(r5, r0)
            return
        L_0x0030:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.sunflower.task.a.a(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2) {
        boolean z = false;
        if (l.a((CharSequence) str) || l.a((CharSequence) str2)) {
            j.b("AnrCheckTask", "There is no NAR by this process");
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            j.c("AnrCheckTask", "hasContainPackage | " + str + " is not exists");
            return false;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        if (l.a(readLine, str2)) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        j.d("AnrCheckTask", "hasContainPackage error", e);
                        i.a((Reader) bufferedReader);
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        i.a((Reader) bufferedReader);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    i.a((Reader) bufferedReader);
                    throw th;
                }
            }
            i.a((Reader) bufferedReader2);
        } catch (Exception e3) {
            e = e3;
            j.d("AnrCheckTask", "hasContainPackage error", e);
            i.a((Reader) bufferedReader);
            return z;
        }
        return z;
    }

    private void a(List<List<String>> list) {
        ListIterator<List<String>> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ErrorEntity errorEntity = new ErrorEntity();
            errorEntity.sid = com.iflytek.sunflower.config.a.f;
            StringBuffer stringBuffer = new StringBuffer();
            Iterator it = ((ArrayList) listIterator.next()).iterator();
            while (it.hasNext()) {
                stringBuffer.append((String) it.next());
                stringBuffer.append(10);
            }
            errorEntity.msg = g.a(stringBuffer.toString());
            errorEntity.startTp = System.currentTimeMillis();
            errorEntity.errorType = "block";
            errorEntity.appver = com.iflytek.sunflower.util.a.a(this.a).b("app.ver.name");
            e.a(errorEntity);
        }
    }
}
