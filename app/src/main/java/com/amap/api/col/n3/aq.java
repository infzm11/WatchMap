package com.amap.api.col.n3;

import android.content.Context;
import android.os.Handler;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: OfflineMapDownloadList */
public final class aq {
    public ArrayList<OfflineMapProvince> a = new ArrayList<>();
    private bb b;
    private Context c;
    private Handler d;

    private static boolean a(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    public aq(Context context, Handler handler) {
        this.c = context;
        this.d = handler;
        this.b = bb.a(context);
    }

    private void a(aw awVar) {
        if (this.b != null && awVar != null) {
            this.b.a(awVar);
        }
    }

    private void b(aw awVar) {
        if (this.b != null) {
            this.b.b(awVar);
        }
    }

    private static boolean a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    public final ArrayList<OfflineMapProvince> a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final OfflineMapCity a(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCode().equals(str)) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final OfflineMapCity b(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        OfflineMapCity next = it2.next();
                        if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                            return next;
                        }
                    }
                }
            }
            return null;
        }
    }

    public final OfflineMapProvince c(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next.getProvinceName().trim().equalsIgnoreCase(str.trim())) {
                    return next;
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.a) {
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.a) {
            if (this.a.size() > 0) {
                for (int i = 0; i < this.a.size(); i++) {
                    OfflineMapProvince offlineMapProvince2 = this.a.get(i);
                    Iterator<OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        } else if ((offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals("100000")) && offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                            break;
                        }
                    }
                    if (offlineMapProvince != null) {
                        offlineMapProvince2.setUrl(offlineMapProvince.getUrl());
                        offlineMapProvince2.setVersion(offlineMapProvince.getVersion());
                        offlineMapProvince2.setSize(offlineMapProvince.getSize());
                        offlineMapProvince2.setPinyin(offlineMapProvince.getPinyin());
                        offlineMapProvince2.setJianpin(offlineMapProvince.getJianpin());
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        for (int i2 = 0; i2 < cityList.size(); i2++) {
                            OfflineMapCity offlineMapCity2 = cityList.get(i2);
                            Iterator<OfflineMapCity> it2 = cityList2.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    offlineMapCity = null;
                                    break;
                                }
                                offlineMapCity = it2.next();
                                if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                    break;
                                }
                            }
                            if (offlineMapCity != null) {
                                offlineMapCity2.setUrl(offlineMapCity.getUrl());
                                offlineMapCity2.setVersion(offlineMapCity.getVersion());
                                offlineMapCity2.setSize(offlineMapCity.getSize());
                                offlineMapCity2.setCode(offlineMapCity.getCode());
                                offlineMapCity2.setPinyin(offlineMapCity.getPinyin());
                                offlineMapCity2.setJianpin(offlineMapCity.getJianpin());
                            }
                        }
                    }
                }
            } else {
                for (OfflineMapProvince add : list) {
                    this.a.add(add);
                }
            }
        }
    }

    public final ArrayList<OfflineMapCity> c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity next2 : next.getCityList()) {
                        if (next2.getState() == 4 || next2.getState() == 7) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity next2 : next.getCityList()) {
                        if (a(next2.getState())) {
                            arrayList.add(next2);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && a(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r0 = r9.c().b();
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0055, code lost:
        if (r9.c().equals(r9.a) == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0057, code lost:
        b(r9.s());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        if (r9.c().equals(r9.f) == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006b, code lost:
        "saveJSONObjectToFile  CITY " + r9.getCity();
        b(r9);
        r9.s().b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        r2 = r9.getcompleteCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0092, code lost:
        if (r9.c().b() != 1) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0095, code lost:
        if (r2 <= 2) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0099, code lost:
        if (r2 < 98) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009c, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x009e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (r2 == false) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a1, code lost:
        a(r9.s());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a8, code lost:
        r5.setState(r0);
        r5.setCompleteCode(r9.getcompleteCode());
        r0 = r9.c().b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bb, code lost:
        if (r0 != 6) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        r3.setState(r0);
        r3.setCompleteCode(0);
        b(new com.amap.api.col.n3.aw(r3, r8.c));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        com.amap.api.col.n3.bj.a(r3.getProvinceCode(), r8.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d8, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00de, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e4, code lost:
        if (r0 != 4) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e6, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e7, code lost:
        if (r4 == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ed, code lost:
        if (a(r3) == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00fb, code lost:
        if (r9.getPinyin().equals(r3.getPinyin()) == false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00fd, code lost:
        r3.setState(r0);
        r3.setCompleteCode(r9.getcompleteCode());
        r3.setVersion(r9.getVersion());
        r3.setUrl(r9.getUrl());
        r0 = new com.amap.api.col.n3.aw(r3, r8.c);
        r0.a(r9.a());
        r0.d(r9.getCode());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012b, code lost:
        r3.setState(r0);
        r3.setCompleteCode(100);
        r0 = new com.amap.api.col.n3.aw(r3, r8.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x013a, code lost:
        r0.b();
        a(r0);
        "saveJSONObjectToFile  province " + r0.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.col.n3.al r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.getPinyin()
            java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> r1 = r8.a
            monitor-enter(r1)
            java.util.ArrayList<com.amap.api.maps.offlinemap.OfflineMapProvince> r2 = r8.a     // Catch:{ all -> 0x0153 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0153 }
        L_0x000d:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0153 }
            if (r3 == 0) goto L_0x0151
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0153 }
            com.amap.api.maps.offlinemap.OfflineMapProvince r3 = (com.amap.api.maps.offlinemap.OfflineMapProvince) r3     // Catch:{ all -> 0x0153 }
            if (r3 == 0) goto L_0x000d
            java.util.ArrayList r4 = r3.getCityList()     // Catch:{ all -> 0x0153 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0153 }
        L_0x0023:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0153 }
            if (r5 == 0) goto L_0x000d
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0153 }
            com.amap.api.maps.offlinemap.OfflineMapCity r5 = (com.amap.api.maps.offlinemap.OfflineMapCity) r5     // Catch:{ all -> 0x0153 }
            java.lang.String r6 = r5.getPinyin()     // Catch:{ all -> 0x0153 }
            java.lang.String r6 = r6.trim()     // Catch:{ all -> 0x0153 }
            java.lang.String r7 = r0.trim()     // Catch:{ all -> 0x0153 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0153 }
            if (r6 == 0) goto L_0x0023
            com.amap.api.col.n3.bp r0 = r9.c()     // Catch:{ all -> 0x0153 }
            int r0 = r0.b()     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.bp r2 = r9.c()     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.bp r4 = r9.a     // Catch:{ all -> 0x0153 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0153 }
            r4 = 0
            r6 = 1
            if (r2 == 0) goto L_0x005f
            com.amap.api.col.n3.aw r2 = r9.s()     // Catch:{ all -> 0x0153 }
            r8.b((com.amap.api.col.n3.aw) r2)     // Catch:{ all -> 0x0153 }
            goto L_0x00a8
        L_0x005f:
            com.amap.api.col.n3.bp r2 = r9.c()     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.bp r7 = r9.f     // Catch:{ all -> 0x0153 }
            boolean r2 = r2.equals(r7)     // Catch:{ all -> 0x0153 }
            if (r2 == 0) goto L_0x0086
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0153 }
            java.lang.String r7 = "saveJSONObjectToFile  CITY "
            r2.<init>(r7)     // Catch:{ all -> 0x0153 }
            java.lang.String r7 = r9.getCity()     // Catch:{ all -> 0x0153 }
            r2.append(r7)     // Catch:{ all -> 0x0153 }
            r2.toString()     // Catch:{ all -> 0x0153 }
            r8.b((com.amap.api.col.n3.al) r9)     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.aw r2 = r9.s()     // Catch:{ all -> 0x0153 }
            r2.b()     // Catch:{ all -> 0x0153 }
        L_0x0086:
            int r2 = r9.getcompleteCode()     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.bp r7 = r9.c()     // Catch:{ all -> 0x0153 }
            int r7 = r7.b()     // Catch:{ all -> 0x0153 }
            if (r7 != r6) goto L_0x009e
            r7 = 2
            if (r2 <= r7) goto L_0x009e
            r7 = 98
            if (r2 < r7) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r2 = r4
            goto L_0x009f
        L_0x009e:
            r2 = r6
        L_0x009f:
            if (r2 == 0) goto L_0x00a8
            com.amap.api.col.n3.aw r2 = r9.s()     // Catch:{ all -> 0x0153 }
            r8.a((com.amap.api.col.n3.aw) r2)     // Catch:{ all -> 0x0153 }
        L_0x00a8:
            r5.setState(r0)     // Catch:{ all -> 0x0153 }
            int r0 = r9.getcompleteCode()     // Catch:{ all -> 0x0153 }
            r5.setCompleteCode(r0)     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.bp r0 = r9.c()     // Catch:{ all -> 0x0153 }
            int r0 = r0.b()     // Catch:{ all -> 0x0153 }
            r2 = 6
            if (r0 != r2) goto L_0x00e3
            r3.setState(r0)     // Catch:{ all -> 0x0153 }
            r3.setCompleteCode(r4)     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.aw r9 = new com.amap.api.col.n3.aw     // Catch:{ all -> 0x0153 }
            android.content.Context r0 = r8.c     // Catch:{ all -> 0x0153 }
            r9.<init>((com.amap.api.maps.offlinemap.OfflineMapProvince) r3, (android.content.Context) r0)     // Catch:{ all -> 0x0153 }
            r8.b((com.amap.api.col.n3.aw) r9)     // Catch:{ all -> 0x0153 }
            java.lang.String r9 = r3.getProvinceCode()     // Catch:{ IOException -> 0x00de, Exception -> 0x00d8 }
            android.content.Context r0 = r8.c     // Catch:{ IOException -> 0x00de, Exception -> 0x00d8 }
            com.amap.api.col.n3.bj.a((java.lang.String) r9, (android.content.Context) r0)     // Catch:{ IOException -> 0x00de, Exception -> 0x00d8 }
            goto L_0x0151
        L_0x00d8:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x0153 }
            goto L_0x0151
        L_0x00de:
            r9 = move-exception
            r9.printStackTrace()     // Catch:{ all -> 0x0153 }
            goto L_0x0151
        L_0x00e3:
            r2 = 4
            if (r0 != r2) goto L_0x00e7
            r4 = r6
        L_0x00e7:
            if (r4 == 0) goto L_0x0151
            boolean r2 = a((com.amap.api.maps.offlinemap.OfflineMapProvince) r3)     // Catch:{ all -> 0x0153 }
            if (r2 == 0) goto L_0x0151
            java.lang.String r2 = r9.getPinyin()     // Catch:{ all -> 0x0153 }
            java.lang.String r4 = r3.getPinyin()     // Catch:{ all -> 0x0153 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0153 }
            if (r2 == 0) goto L_0x012b
            r3.setState(r0)     // Catch:{ all -> 0x0153 }
            int r0 = r9.getcompleteCode()     // Catch:{ all -> 0x0153 }
            r3.setCompleteCode(r0)     // Catch:{ all -> 0x0153 }
            java.lang.String r0 = r9.getVersion()     // Catch:{ all -> 0x0153 }
            r3.setVersion(r0)     // Catch:{ all -> 0x0153 }
            java.lang.String r0 = r9.getUrl()     // Catch:{ all -> 0x0153 }
            r3.setUrl(r0)     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.aw r0 = new com.amap.api.col.n3.aw     // Catch:{ all -> 0x0153 }
            android.content.Context r2 = r8.c     // Catch:{ all -> 0x0153 }
            r0.<init>((com.amap.api.maps.offlinemap.OfflineMapProvince) r3, (android.content.Context) r2)     // Catch:{ all -> 0x0153 }
            java.lang.String r2 = r9.a()     // Catch:{ all -> 0x0153 }
            r0.a(r2)     // Catch:{ all -> 0x0153 }
            java.lang.String r9 = r9.getCode()     // Catch:{ all -> 0x0153 }
            r0.d(r9)     // Catch:{ all -> 0x0153 }
            goto L_0x013a
        L_0x012b:
            r3.setState(r0)     // Catch:{ all -> 0x0153 }
            r9 = 100
            r3.setCompleteCode(r9)     // Catch:{ all -> 0x0153 }
            com.amap.api.col.n3.aw r0 = new com.amap.api.col.n3.aw     // Catch:{ all -> 0x0153 }
            android.content.Context r9 = r8.c     // Catch:{ all -> 0x0153 }
            r0.<init>((com.amap.api.maps.offlinemap.OfflineMapProvince) r3, (android.content.Context) r9)     // Catch:{ all -> 0x0153 }
        L_0x013a:
            r0.b()     // Catch:{ all -> 0x0153 }
            r8.a((com.amap.api.col.n3.aw) r0)     // Catch:{ all -> 0x0153 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0153 }
            java.lang.String r2 = "saveJSONObjectToFile  province "
            r9.<init>(r2)     // Catch:{ all -> 0x0153 }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x0153 }
            r9.append(r0)     // Catch:{ all -> 0x0153 }
            r9.toString()     // Catch:{ all -> 0x0153 }
        L_0x0151:
            monitor-exit(r1)     // Catch:{ all -> 0x0153 }
            return
        L_0x0153:
            r9 = move-exception
            monitor-exit(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.aq.a(com.amap.api.col.n3.al):void");
    }

    private void b(al alVar) {
        File[] listFiles = new File(dv.b(this.c)).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isFile() && file.exists() && file.getName().contains(alVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                    file.delete();
                }
            }
        }
    }

    public final void g() {
        if (this.a != null) {
            synchronized (this.a) {
                this.a.clear();
            }
        }
        this.d = null;
        this.b = null;
        this.c = null;
    }
}
