package com.amap.api.col.n3;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OfflineMapDataVerify */
public final class ap extends Thread {
    private Context a;
    private bb b;

    public ap(Context context) {
        this.a = context;
        this.b = bb.a(context);
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        ArrayList<aw> a2 = this.b.a();
        a((ArrayList<String>) arrayList, "vmap/");
        a((ArrayList<String>) arrayList, "map/");
        ArrayList<String> a3 = a();
        Iterator<aw> it = a2.iterator();
        while (it.hasNext()) {
            aw next = it.next();
            if (!(next == null || next.c() == null)) {
                if (next.l != 4 && next.l != 7) {
                    boolean z = false;
                    if (next.l == 0 || next.l == 1) {
                        if (a3.contains(next.e()) || a3.contains(next.g())) {
                            z = true;
                        }
                        if (z) {
                        }
                    } else if (next.l == 3 && next.f() != 0) {
                        if (a3.contains(next.e()) || a3.contains(next.g())) {
                            z = true;
                        }
                        if (z) {
                        }
                    }
                } else if (arrayList.contains(next.g())) {
                }
                this.b.b(next);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (!a(str, a2)) {
                aw a4 = a(str);
                if (a4 != null) {
                    this.b.a(a4);
                }
            }
        }
        am a5 = am.a(this.a);
        if (a5 != null) {
            a5.b();
        }
    }

    public final void destroy() {
        this.a = null;
        this.b = null;
    }

    private aw a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        am a2 = am.a(this.a);
        aw awVar = null;
        if (a2 == null) {
            return null;
        }
        String f = a2.f(str);
        File[] listFiles = new File(dv.b(this.a)).listFiles();
        if (listFiles == null) {
            return null;
        }
        for (File file : listFiles) {
            if ((file.getName().contains(f) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                String a3 = dv.a(file);
                aw awVar2 = new aw();
                awVar2.b(a3);
                if (awVar2.c() != null) {
                    return awVar2;
                }
                awVar = awVar2;
            }
        }
        return awVar;
    }

    private static boolean a(String str, ArrayList<aw> arrayList) {
        Iterator<aw> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().g())) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<String> arrayList, String str) {
        File file = new File(dv.a(this.a) + str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.getName().endsWith(".dat")) {
                        String name = file2.getName();
                        int lastIndexOf = name.lastIndexOf(46);
                        if (lastIndexOf >= 0 && lastIndexOf < name.length()) {
                            String substring = name.substring(0, lastIndexOf);
                            if (!arrayList.contains(substring)) {
                                arrayList.add(substring);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(dv.b(this.a));
        if (!file.exists()) {
            return arrayList;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        for (File file2 : listFiles) {
            if (file2.getName().endsWith(".zip")) {
                String name = file2.getName();
                int lastIndexOf = name.lastIndexOf(46);
                if (lastIndexOf >= 0 && lastIndexOf < name.length()) {
                    arrayList.add(name.substring(0, lastIndexOf));
                }
            }
        }
        return arrayList;
    }
}
