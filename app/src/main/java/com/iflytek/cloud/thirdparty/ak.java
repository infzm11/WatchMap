package com.iflytek.cloud.thirdparty;

import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ak {

    public static class a {
        private String a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/DataFiles/");
        private BufferedOutputStream b;
        private FileInputStream c;
        private BufferedWriter d;
        private long e = 0;

        public a(String str) {
            this.a = str;
        }

        public int a() {
            if (this.c == null) {
                return -1;
            }
            try {
                return this.c.available();
            } catch (IOException e2) {
                e2.printStackTrace();
                return -1;
            }
        }

        public int a(byte[] bArr) {
            synchronized (this) {
                if (this.c == null) {
                    return -1;
                }
                try {
                    int read = this.c.read(bArr);
                    return read;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    b();
                    return 0;
                }
            }
        }

        public void a(String str, String str2) {
            File file = new File(this.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.d == null) {
                if (TextUtils.isEmpty(str)) {
                    str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA).format(new Date());
                }
                File file2 = new File(this.a + str + str2);
                try {
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    this.d = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file2, true)));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void a(String str, String str2, boolean z) {
            File file = new File(this.a);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (this.b == null) {
                if (TextUtils.isEmpty(str)) {
                    str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA).format(new Date());
                }
                try {
                    this.b = new BufferedOutputStream(new FileOutputStream(new File(this.a + str + str2), z));
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void a(byte[] bArr, boolean z) throws IOException {
            synchronized (this) {
                if (this.b != null) {
                    this.b.write(bArr);
                    if (z) {
                        this.b.flush();
                    }
                    this.e += (long) bArr.length;
                }
            }
        }

        public boolean a(String str) {
            return a(str, true);
        }

        public boolean a(String str, boolean z) {
            File file;
            if (z) {
                file = new File(this.a + str);
            } else {
                file = new File(str);
            }
            try {
                this.c = new FileInputStream(file);
                return true;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                this.c = null;
                return false;
            }
        }

        public void b() {
            synchronized (this) {
                if (this.c != null) {
                    try {
                        this.c.close();
                        this.c = null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void b(String str) {
            synchronized (this) {
                if (this.d != null) {
                    try {
                        this.d.write(str);
                        this.d.flush();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void c() {
            synchronized (this) {
                if (this.d != null) {
                    try {
                        this.d.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.d = null;
                }
            }
        }

        public void c(String str) {
            if (TextUtils.isEmpty(str)) {
                str = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA).format(new Date());
            }
            a(str, ".pcm", false);
        }

        public void d() {
            synchronized (this) {
                if (this.b != null) {
                    try {
                        this.b.flush();
                        this.b.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    this.b = null;
                }
                this.e = 0;
            }
        }

        public long e() {
            long j;
            synchronized (this) {
                j = this.e;
            }
            return j;
        }

        public void f() {
            b();
            c();
            d();
        }
    }

    public static class b extends Thread {
        private File a;
        private long b;
        private long c;
        private int d = 600;
        private boolean e = false;
        private Comparator<File> f = new Comparator<File>() {
            /* renamed from: a */
            public int compare(File file, File file2) {
                int i = (file.lastModified() > file2.lastModified() ? 1 : (file.lastModified() == file2.lastModified() ? 0 : -1));
                if (i < 0) {
                    return -1;
                }
                return i > 0 ? 1 : 0;
            }
        };

        public b(String str, long j, long j2, int i) {
            super("DirSizeDeamonThread");
            this.a = new File(str);
            this.b = j;
            this.c = j2;
            this.d = i;
            if (this.d < 600) {
                this.d = 600;
            }
        }

        private List<File> a(List<File> list, Map<File, Long> map, double d2) {
            if (list == null || map == null) {
                return null;
            }
            double d3 = 0.0d;
            if (d2 <= 0.0d) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (File next : list) {
                d3 += (double) map.get(next).longValue();
                arrayList.add(next);
                if (d3 >= d2) {
                    break;
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList;
        }

        private void a(List<File> list) {
            if (list != null) {
                for (File next : list) {
                    try {
                        cb.a("DirSizeDeamon", "del file:" + next.getName());
                        ak.a(next);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        public void a() {
            this.e = true;
            interrupt();
        }

        public void a(String str) {
            this.a = new File(str);
        }

        public void run() {
            super.run();
            while (!this.e) {
                HashMap hashMap = new HashMap();
                long currentTimeMillis = System.currentTimeMillis();
                cb.a("DirSizeDeamon", "get total file size, spent=" + (System.currentTimeMillis() - currentTimeMillis));
                if (((double) ak.a(this.a, hashMap, true)) - ((double) this.b) > 0.0d) {
                    ArrayList arrayList = new ArrayList(hashMap.keySet());
                    Collections.sort(arrayList, this.f);
                    List<File> a2 = a(arrayList, hashMap, (double) this.c);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    a(a2);
                    long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                    cb.a("DirSizeDeamon", "delete files, spent=" + currentTimeMillis3);
                }
                try {
                    sleep((long) (this.d * 1000));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static long a(File file, Map<File, Long> map, boolean z) {
        long j = 0;
        if (!file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                long a2 = a(file2, (Map<File, Long>) null, z);
                if (map != null && (!z || file2.isDirectory())) {
                    map.put(file2.getAbsoluteFile(), Long.valueOf(a2));
                }
                j += a2;
            }
        }
        return j;
    }

    public static a a(String str) {
        return new a(str);
    }

    public static boolean a(File file) {
        if (file == null) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        boolean z = true;
        if (listFiles != null) {
            for (File a2 : listFiles) {
                z = a(a2);
                if (!z) {
                    return z;
                }
            }
        }
        return z;
    }
}
