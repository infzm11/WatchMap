package com.amap.api.col.n3;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* compiled from: DiskLruCache */
public final class jz implements Closeable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static ThreadPoolExecutor b;
    private static final ThreadFactory q = new ThreadFactory() {
        private final AtomicInteger a = new AtomicInteger(1);

        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.a.getAndIncrement());
        }
    };
    /* access modifiers changed from: private */
    public static final OutputStream s = new OutputStream() {
        public final void write(int i) throws IOException {
        }
    };
    /* access modifiers changed from: private */
    public final File c;
    private final File d;
    private final File e;
    private final File f;
    private final int g;
    private long h;
    /* access modifiers changed from: private */
    public final int i;
    private long j = 0;
    /* access modifiers changed from: private */
    public Writer k;
    private int l = 1000;
    private final LinkedHashMap<String, c> m = new LinkedHashMap<>(0, 0.75f, true);
    /* access modifiers changed from: private */
    public int n;
    private ka o;
    private long p = 0;
    private final Callable<Void> r = new Callable<Void>() {
        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r3 = this;
                com.amap.api.col.n3.jz r0 = com.amap.api.col.n3.jz.this
                monitor-enter(r0)
                com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0027 }
                java.io.Writer r1 = r1.k     // Catch:{ all -> 0x0027 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x000e:
                com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0027 }
                r1.m()     // Catch:{ all -> 0x0027 }
                com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0027 }
                boolean r1 = r1.k()     // Catch:{ all -> 0x0027 }
                if (r1 == 0) goto L_0x0025
                com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0027 }
                r1.j()     // Catch:{ all -> 0x0027 }
                com.amap.api.col.n3.jz r1 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0027 }
                int unused = r1.n = 0     // Catch:{ all -> 0x0027 }
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x0027 }
                return r2
            L_0x0027:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.AnonymousClass2.call():java.lang.Void");
        }
    };

    /* compiled from: DiskLruCache */
    public final class a {
        /* access modifiers changed from: private */
        public final c b;
        /* access modifiers changed from: private */
        public final boolean[] c;
        /* access modifiers changed from: private */
        public boolean d;
        private boolean e;

        /* renamed from: com.amap.api.col.n3.jz$a$a  reason: collision with other inner class name */
        /* compiled from: DiskLruCache */
        private class C0003a extends FilterOutputStream {
            /* synthetic */ C0003a(a aVar, OutputStream outputStream, byte b) {
                this(outputStream);
            }

            private C0003a(OutputStream outputStream) {
                super(outputStream);
            }

            public final void write(int i) {
                try {
                    this.out.write(i);
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public final void write(byte[] bArr, int i, int i2) {
                try {
                    this.out.write(bArr, i, i2);
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public final void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }

            public final void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = a.this.d = true;
                }
            }
        }

        /* synthetic */ a(jz jzVar, c cVar, byte b2) {
            this(cVar);
        }

        private a(c cVar) {
            this.b = cVar;
            this.c = cVar.d ? null : new boolean[jz.this.i];
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.io.OutputStream a() throws java.io.IOException {
            /*
                r4 = this;
                com.amap.api.col.n3.jz r0 = com.amap.api.col.n3.jz.this
                int r0 = r0.i
                if (r0 > 0) goto L_0x0022
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r2 = "Expected index 0 to be greater than 0 and less than the maximum value count of "
                r1.<init>(r2)
                com.amap.api.col.n3.jz r2 = com.amap.api.col.n3.jz.this
                int r2 = r2.i
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0022:
                com.amap.api.col.n3.jz r0 = com.amap.api.col.n3.jz.this
                monitor-enter(r0)
                com.amap.api.col.n3.jz$c r1 = r4.b     // Catch:{ all -> 0x0068 }
                com.amap.api.col.n3.jz$a r1 = r1.e     // Catch:{ all -> 0x0068 }
                if (r1 == r4) goto L_0x0033
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
                r1.<init>()     // Catch:{ all -> 0x0068 }
                throw r1     // Catch:{ all -> 0x0068 }
            L_0x0033:
                com.amap.api.col.n3.jz$c r1 = r4.b     // Catch:{ all -> 0x0068 }
                boolean r1 = r1.d     // Catch:{ all -> 0x0068 }
                r2 = 0
                if (r1 != 0) goto L_0x0041
                boolean[] r1 = r4.c     // Catch:{ all -> 0x0068 }
                r3 = 1
                r1[r2] = r3     // Catch:{ all -> 0x0068 }
            L_0x0041:
                com.amap.api.col.n3.jz$c r1 = r4.b     // Catch:{ all -> 0x0068 }
                java.io.File r1 = r1.b((int) r2)     // Catch:{ all -> 0x0068 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x004d }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x004d }
                goto L_0x005b
            L_0x004d:
                com.amap.api.col.n3.jz r3 = com.amap.api.col.n3.jz.this     // Catch:{ all -> 0x0068 }
                java.io.File r3 = r3.c     // Catch:{ all -> 0x0068 }
                r3.mkdirs()     // Catch:{ all -> 0x0068 }
                java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0062 }
                r3.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0062 }
            L_0x005b:
                com.amap.api.col.n3.jz$a$a r1 = new com.amap.api.col.n3.jz$a$a     // Catch:{ all -> 0x0068 }
                r1.<init>(r4, r3, r2)     // Catch:{ all -> 0x0068 }
                monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                return r1
            L_0x0062:
                java.io.OutputStream r1 = com.amap.api.col.n3.jz.s     // Catch:{ all -> 0x0068 }
                monitor-exit(r0)     // Catch:{ all -> 0x0068 }
                return r1
            L_0x0068:
                r1 = move-exception
                monitor-exit(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.a.a():java.io.OutputStream");
        }

        public final void b() throws IOException {
            if (this.d) {
                jz.this.a(this, false);
                jz.this.c(this.b.b);
            } else {
                jz.this.a(this, true);
            }
            this.e = true;
        }

        public final void c() throws IOException {
            jz.this.a(this, false);
        }
    }

    /* compiled from: DiskLruCache */
    public final class b implements Closeable {
        private final String b;
        private final long c;
        private final InputStream[] d;
        private final long[] e;

        /* synthetic */ b(jz jzVar, String str, long j, InputStream[] inputStreamArr, long[] jArr, byte b2) {
            this(str, j, inputStreamArr, jArr);
        }

        private b(String str, long j, InputStream[] inputStreamArr, long[] jArr) {
            this.b = str;
            this.c = j;
            this.d = inputStreamArr;
            this.e = jArr;
        }

        public final InputStream a() {
            return this.d[0];
        }

        public final void close() {
            for (InputStream a2 : this.d) {
                kc.a((Closeable) a2);
            }
        }
    }

    /* compiled from: DiskLruCache */
    private final class c {
        /* access modifiers changed from: private */
        public final String b;
        /* access modifiers changed from: private */
        public final long[] c;
        /* access modifiers changed from: private */
        public boolean d;
        /* access modifiers changed from: private */
        public a e;
        /* access modifiers changed from: private */
        public long f;

        /* synthetic */ c(jz jzVar, String str, byte b2) {
            this(str);
        }

        static /* synthetic */ void a(c cVar, String[] strArr) throws IOException {
            if (strArr.length != jz.this.i) {
                throw a(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    cVar.c[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException unused) {
                    throw a(strArr);
                }
            }
        }

        private c(String str) {
            this.b = str;
            this.c = new long[jz.this.i];
        }

        public final String a() throws IOException {
            StringBuilder sb = new StringBuilder();
            for (long append : this.c) {
                sb.append(' ');
                sb.append(append);
            }
            return sb.toString();
        }

        private static IOException a(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final File a(int i) {
            File g = jz.this.c;
            return new File(g, this.b + "." + i);
        }

        public final File b(int i) {
            File g = jz.this.c;
            return new File(g, this.b + "." + i + ".tmp");
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), q);
        b = threadPoolExecutor;
    }

    public final void a(ka kaVar) {
        this.o = kaVar;
    }

    public final void a(int i2) {
        if (i2 < 10) {
            i2 = 10;
        } else if (i2 > 10000) {
            i2 = 10000;
        }
        this.l = i2;
    }

    public static void a() {
        if (b != null && !b.isShutdown()) {
            b.shutdown();
        }
    }

    private static ThreadPoolExecutor g() {
        try {
            if (b == null || b.isShutdown()) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), q);
                b = threadPoolExecutor;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    private jz(File file, long j2) {
        this.c = file;
        this.g = 1;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = 1;
        this.h = j2;
    }

    public static jz a(File file, long j2) throws IOException {
        if (j2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                a(file2, file3, false);
            }
        }
        jz jzVar = new jz(file, j2);
        if (jzVar.d.exists()) {
            try {
                jzVar.h();
                jzVar.i();
                jzVar.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(jzVar.d, true), kc.a));
                return jzVar;
            } catch (Throwable unused) {
                jzVar.e();
            }
        }
        file.mkdirs();
        jz jzVar2 = new jz(file, j2);
        jzVar2.j();
        return jzVar2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:49|50|51|52) */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        r10.n = r2 - r10.m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0117, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x010b */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:13:0x0056=Splitter:B:13:0x0056, B:53:0x0118=Splitter:B:53:0x0118} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void h() throws java.io.IOException {
        /*
            r10 = this;
            com.amap.api.col.n3.kb r0 = new com.amap.api.col.n3.kb
            java.io.FileInputStream r1 = new java.io.FileInputStream
            java.io.File r2 = r10.d
            r1.<init>(r2)
            java.nio.charset.Charset r2 = com.amap.api.col.n3.kc.a
            r0.<init>(r1, r2)
            java.lang.String r1 = r0.a()     // Catch:{ all -> 0x0149 }
            java.lang.String r2 = r0.a()     // Catch:{ all -> 0x0149 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0149 }
            java.lang.String r4 = r0.a()     // Catch:{ all -> 0x0149 }
            java.lang.String r5 = r0.a()     // Catch:{ all -> 0x0149 }
            java.lang.String r6 = "libcore.io.DiskLruCache"
            boolean r6 = r6.equals(r1)     // Catch:{ all -> 0x0149 }
            if (r6 == 0) goto L_0x0118
            java.lang.String r6 = "1"
            boolean r6 = r6.equals(r2)     // Catch:{ all -> 0x0149 }
            if (r6 == 0) goto L_0x0118
            int r6 = r10.g     // Catch:{ all -> 0x0149 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0149 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0149 }
            if (r3 == 0) goto L_0x0118
            int r3 = r10.i     // Catch:{ all -> 0x0149 }
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x0149 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0149 }
            if (r3 == 0) goto L_0x0118
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0149 }
            if (r3 != 0) goto L_0x0054
            goto L_0x0118
        L_0x0054:
            r1 = 0
            r2 = r1
        L_0x0056:
            java.lang.String r3 = r0.a()     // Catch:{ EOFException -> 0x010b }
            r4 = 32
            int r5 = r3.indexOf(r4)     // Catch:{ EOFException -> 0x010b }
            r6 = -1
            if (r5 != r6) goto L_0x0077
            java.io.IOException r1 = new java.io.IOException     // Catch:{ EOFException -> 0x010b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x010b }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x010b }
            r4.append(r3)     // Catch:{ EOFException -> 0x010b }
            java.lang.String r3 = r4.toString()     // Catch:{ EOFException -> 0x010b }
            r1.<init>(r3)     // Catch:{ EOFException -> 0x010b }
            throw r1     // Catch:{ EOFException -> 0x010b }
        L_0x0077:
            int r7 = r5 + 1
            int r4 = r3.indexOf(r4, r7)     // Catch:{ EOFException -> 0x010b }
            if (r4 != r6) goto L_0x0094
            java.lang.String r7 = r3.substring(r7)     // Catch:{ EOFException -> 0x010b }
            r8 = 6
            if (r5 != r8) goto L_0x0098
            java.lang.String r8 = "REMOVE"
            boolean r8 = r3.startsWith(r8)     // Catch:{ EOFException -> 0x010b }
            if (r8 == 0) goto L_0x0098
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r3 = r10.m     // Catch:{ EOFException -> 0x010b }
            r3.remove(r7)     // Catch:{ EOFException -> 0x010b }
            goto L_0x00f3
        L_0x0094:
            java.lang.String r7 = r3.substring(r7, r4)     // Catch:{ EOFException -> 0x010b }
        L_0x0098:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r8 = r10.m     // Catch:{ EOFException -> 0x010b }
            java.lang.Object r8 = r8.get(r7)     // Catch:{ EOFException -> 0x010b }
            com.amap.api.col.n3.jz$c r8 = (com.amap.api.col.n3.jz.c) r8     // Catch:{ EOFException -> 0x010b }
            if (r8 != 0) goto L_0x00ac
            com.amap.api.col.n3.jz$c r8 = new com.amap.api.col.n3.jz$c     // Catch:{ EOFException -> 0x010b }
            r8.<init>(r10, r7, r1)     // Catch:{ EOFException -> 0x010b }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r9 = r10.m     // Catch:{ EOFException -> 0x010b }
            r9.put(r7, r8)     // Catch:{ EOFException -> 0x010b }
        L_0x00ac:
            r7 = 5
            if (r4 == r6) goto L_0x00d0
            if (r5 != r7) goto L_0x00d0
            java.lang.String r9 = "CLEAN"
            boolean r9 = r3.startsWith(r9)     // Catch:{ EOFException -> 0x010b }
            if (r9 == 0) goto L_0x00d0
            int r4 = r4 + 1
            java.lang.String r3 = r3.substring(r4)     // Catch:{ EOFException -> 0x010b }
            java.lang.String r4 = " "
            java.lang.String[] r3 = r3.split(r4)     // Catch:{ EOFException -> 0x010b }
            boolean unused = r8.d = true     // Catch:{ EOFException -> 0x010b }
            r4 = 0
            com.amap.api.col.n3.jz.a unused = r8.e = r4     // Catch:{ EOFException -> 0x010b }
            com.amap.api.col.n3.jz.c.a((com.amap.api.col.n3.jz.c) r8, (java.lang.String[]) r3)     // Catch:{ EOFException -> 0x010b }
            goto L_0x00f3
        L_0x00d0:
            if (r4 != r6) goto L_0x00e5
            if (r5 != r7) goto L_0x00e5
            java.lang.String r7 = "DIRTY"
            boolean r7 = r3.startsWith(r7)     // Catch:{ EOFException -> 0x010b }
            if (r7 == 0) goto L_0x00e5
            com.amap.api.col.n3.jz$a r3 = new com.amap.api.col.n3.jz$a     // Catch:{ EOFException -> 0x010b }
            r3.<init>(r10, r8, r1)     // Catch:{ EOFException -> 0x010b }
            com.amap.api.col.n3.jz.a unused = r8.e = r3     // Catch:{ EOFException -> 0x010b }
            goto L_0x00f3
        L_0x00e5:
            if (r4 != r6) goto L_0x00f7
            r4 = 4
            if (r5 != r4) goto L_0x00f7
            java.lang.String r4 = "READ"
            boolean r4 = r3.startsWith(r4)     // Catch:{ EOFException -> 0x010b }
            if (r4 != 0) goto L_0x00f3
            goto L_0x00f7
        L_0x00f3:
            int r2 = r2 + 1
            goto L_0x0056
        L_0x00f7:
            java.io.IOException r1 = new java.io.IOException     // Catch:{ EOFException -> 0x010b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x010b }
            java.lang.String r5 = "unexpected journal line: "
            r4.<init>(r5)     // Catch:{ EOFException -> 0x010b }
            r4.append(r3)     // Catch:{ EOFException -> 0x010b }
            java.lang.String r3 = r4.toString()     // Catch:{ EOFException -> 0x010b }
            r1.<init>(r3)     // Catch:{ EOFException -> 0x010b }
            throw r1     // Catch:{ EOFException -> 0x010b }
        L_0x010b:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r1 = r10.m     // Catch:{ all -> 0x0149 }
            int r1 = r1.size()     // Catch:{ all -> 0x0149 }
            int r2 = r2 - r1
            r10.n = r2     // Catch:{ all -> 0x0149 }
            com.amap.api.col.n3.kc.a((java.io.Closeable) r0)
            return
        L_0x0118:
            java.io.IOException r3 = new java.io.IOException     // Catch:{ all -> 0x0149 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0149 }
            java.lang.String r7 = "unexpected journal header: ["
            r6.<init>(r7)     // Catch:{ all -> 0x0149 }
            r6.append(r1)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0149 }
            r6.append(r2)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0149 }
            r6.append(r4)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = ", "
            r6.append(r1)     // Catch:{ all -> 0x0149 }
            r6.append(r5)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = "]"
            r6.append(r1)     // Catch:{ all -> 0x0149 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0149 }
            r3.<init>(r1)     // Catch:{ all -> 0x0149 }
            throw r3     // Catch:{ all -> 0x0149 }
        L_0x0149:
            r1 = move-exception
            com.amap.api.col.n3.kc.a((java.io.Closeable) r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.h():void");
    }

    private void i() throws IOException {
        a(this.e);
        Iterator<c> it = this.m.values().iterator();
        while (it.hasNext()) {
            c next = it.next();
            int i2 = 0;
            if (next.e == null) {
                while (i2 < this.i) {
                    this.j += next.c[i2];
                    i2++;
                }
            } else {
                a unused = next.e = null;
                while (i2 < this.i) {
                    a(next.a(i2));
                    a(next.b(i2));
                    i2++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    public synchronized void j() throws IOException {
        if (this.k != null) {
            this.k.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), kc.a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.g));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (c next : this.m.values()) {
                if (next.e != null) {
                    bufferedWriter.write("DIRTY " + next.b + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.b + next.a() + 10);
                }
            }
            bufferedWriter.close();
            if (this.d.exists()) {
                a(this.d, this.f, true);
            }
            a(this.e, this.d, false);
            this.f.delete();
            this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), kc.a));
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }

    private static void a(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void a(File file, File file2, boolean z) throws IOException {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.n++;
        r11.k.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if (k() == false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0058, code lost:
        g().submit(r11.r);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        r3 = new com.amap.api.col.n3.jz.b(r11, r12, com.amap.api.col.n3.jz.c.f(r0), r8, com.amap.api.col.n3.jz.c.c(r0), (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0073, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0074 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.amap.api.col.n3.jz.b a(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.l()     // Catch:{ all -> 0x0086 }
            e((java.lang.String) r12)     // Catch:{ all -> 0x0086 }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r0 = r11.m     // Catch:{ all -> 0x0086 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0086 }
            com.amap.api.col.n3.jz$c r0 = (com.amap.api.col.n3.jz.c) r0     // Catch:{ all -> 0x0086 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.d     // Catch:{ all -> 0x0086 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.i     // Catch:{ all -> 0x0086 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0086 }
            r2 = 0
            r3 = r2
        L_0x0022:
            int r4 = r11.i     // Catch:{ FileNotFoundException -> 0x0074 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0074 }
            java.io.File r5 = r0.a((int) r3)     // Catch:{ FileNotFoundException -> 0x0074 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0074 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0074 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.n     // Catch:{ all -> 0x0086 }
            int r1 = r1 + 1
            r11.n = r1     // Catch:{ all -> 0x0086 }
            java.io.Writer r1 = r11.k     // Catch:{ all -> 0x0086 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0086 }
            java.lang.String r3 = "READ "
            r2.<init>(r3)     // Catch:{ all -> 0x0086 }
            r2.append(r12)     // Catch:{ all -> 0x0086 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0086 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0086 }
            r1.append(r2)     // Catch:{ all -> 0x0086 }
            boolean r1 = r11.k()     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0061
            java.util.concurrent.ThreadPoolExecutor r1 = g()     // Catch:{ all -> 0x0086 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.r     // Catch:{ all -> 0x0086 }
            r1.submit(r2)     // Catch:{ all -> 0x0086 }
        L_0x0061:
            com.amap.api.col.n3.jz$b r1 = new com.amap.api.col.n3.jz$b     // Catch:{ all -> 0x0086 }
            long r6 = r0.f     // Catch:{ all -> 0x0086 }
            long[] r9 = r0.c     // Catch:{ all -> 0x0086 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x0086 }
            monitor-exit(r11)
            return r1
        L_0x0074:
            int r12 = r11.i     // Catch:{ all -> 0x0086 }
            if (r2 >= r12) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            if (r12 == 0) goto L_0x0084
            r12 = r8[r2]     // Catch:{ all -> 0x0086 }
            com.amap.api.col.n3.kc.a((java.io.Closeable) r12)     // Catch:{ all -> 0x0086 }
            int r2 = r2 + 1
            goto L_0x0074
        L_0x0084:
            monitor-exit(r11)
            return r1
        L_0x0086:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.a(java.lang.String):com.amap.api.col.n3.jz$b");
    }

    public final a b(String str) throws IOException {
        return d(str);
    }

    private synchronized a d(String str) throws IOException {
        l();
        e(str);
        c cVar = this.m.get(str);
        if (cVar == null) {
            cVar = new c(this, str, (byte) 0);
            this.m.put(str, cVar);
        } else if (cVar.e != null) {
            return null;
        }
        a aVar = new a(this, cVar, (byte) 0);
        a unused = cVar.e = aVar;
        Writer writer = this.k;
        writer.write("DIRTY " + str + 10);
        this.k.flush();
        return aVar;
    }

    public final File b() {
        return this.c;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0108, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.amap.api.col.n3.jz.a r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.amap.api.col.n3.jz$c r0 = r10.b     // Catch:{ all -> 0x0109 }
            com.amap.api.col.n3.jz$a r1 = r0.e     // Catch:{ all -> 0x0109 }
            if (r1 == r10) goto L_0x0011
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0109 }
            r10.<init>()     // Catch:{ all -> 0x0109 }
            throw r10     // Catch:{ all -> 0x0109 }
        L_0x0011:
            r1 = 0
            if (r11 == 0) goto L_0x0050
            boolean r2 = r0.d     // Catch:{ all -> 0x0109 }
            if (r2 != 0) goto L_0x0050
            r2 = r1
        L_0x001b:
            int r3 = r9.i     // Catch:{ all -> 0x0109 }
            if (r2 >= r3) goto L_0x0050
            boolean[] r3 = r10.c     // Catch:{ all -> 0x0109 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0109 }
            if (r3 != 0) goto L_0x003e
            r10.c()     // Catch:{ all -> 0x0109 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.<init>(r0)     // Catch:{ all -> 0x0109 }
            r11.append(r2)     // Catch:{ all -> 0x0109 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0109 }
            r10.<init>(r11)     // Catch:{ all -> 0x0109 }
            throw r10     // Catch:{ all -> 0x0109 }
        L_0x003e:
            java.io.File r3 = r0.b((int) r2)     // Catch:{ all -> 0x0109 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0109 }
            if (r3 != 0) goto L_0x004d
            r10.c()     // Catch:{ all -> 0x0109 }
            monitor-exit(r9)
            return
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x001b
        L_0x0050:
            int r10 = r9.i     // Catch:{ all -> 0x0109 }
            if (r1 >= r10) goto L_0x0084
            java.io.File r10 = r0.b((int) r1)     // Catch:{ all -> 0x0109 }
            if (r11 == 0) goto L_0x007e
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0109 }
            if (r2 == 0) goto L_0x0081
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x0109 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0109 }
            long[] r10 = r0.c     // Catch:{ all -> 0x0109 }
            r3 = r10[r1]     // Catch:{ all -> 0x0109 }
            long r5 = r2.length()     // Catch:{ all -> 0x0109 }
            long[] r10 = r0.c     // Catch:{ all -> 0x0109 }
            r10[r1] = r5     // Catch:{ all -> 0x0109 }
            long r7 = r9.j     // Catch:{ all -> 0x0109 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.j = r7     // Catch:{ all -> 0x0109 }
            goto L_0x0081
        L_0x007e:
            a((java.io.File) r10)     // Catch:{ all -> 0x0109 }
        L_0x0081:
            int r1 = r1 + 1
            goto L_0x0050
        L_0x0084:
            int r10 = r9.n     // Catch:{ all -> 0x0109 }
            int r10 = r10 + 1
            r9.n = r10     // Catch:{ all -> 0x0109 }
            r10 = 0
            com.amap.api.col.n3.jz.a unused = r0.e = r10     // Catch:{ all -> 0x0109 }
            boolean r10 = r0.d     // Catch:{ all -> 0x0109 }
            r10 = r10 | r11
            r1 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.d = true     // Catch:{ all -> 0x0109 }
            java.io.Writer r10 = r9.k     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = "CLEAN "
            r2.<init>(r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = r0.b     // Catch:{ all -> 0x0109 }
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = r0.a()     // Catch:{ all -> 0x0109 }
            r2.append(r3)     // Catch:{ all -> 0x0109 }
            r2.append(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0109 }
            r10.write(r1)     // Catch:{ all -> 0x0109 }
            if (r11 == 0) goto L_0x00eb
            long r10 = r9.p     // Catch:{ all -> 0x0109 }
            r1 = 1
            long r1 = r1 + r10
            r9.p = r1     // Catch:{ all -> 0x0109 }
            long unused = r0.f = r10     // Catch:{ all -> 0x0109 }
            goto L_0x00eb
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r10 = r9.m     // Catch:{ all -> 0x0109 }
            java.lang.String r11 = r0.b     // Catch:{ all -> 0x0109 }
            r10.remove(r11)     // Catch:{ all -> 0x0109 }
            java.io.Writer r10 = r9.k     // Catch:{ all -> 0x0109 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0109 }
            java.lang.String r2 = "REMOVE "
            r11.<init>(r2)     // Catch:{ all -> 0x0109 }
            java.lang.String r0 = r0.b     // Catch:{ all -> 0x0109 }
            r11.append(r0)     // Catch:{ all -> 0x0109 }
            r11.append(r1)     // Catch:{ all -> 0x0109 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0109 }
            r10.write(r11)     // Catch:{ all -> 0x0109 }
        L_0x00eb:
            java.io.Writer r10 = r9.k     // Catch:{ all -> 0x0109 }
            r10.flush()     // Catch:{ all -> 0x0109 }
            long r10 = r9.j     // Catch:{ all -> 0x0109 }
            long r0 = r9.h     // Catch:{ all -> 0x0109 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00fe
            boolean r10 = r9.k()     // Catch:{ all -> 0x0109 }
            if (r10 == 0) goto L_0x0107
        L_0x00fe:
            java.util.concurrent.ThreadPoolExecutor r10 = g()     // Catch:{ all -> 0x0109 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.r     // Catch:{ all -> 0x0109 }
            r10.submit(r11)     // Catch:{ all -> 0x0109 }
        L_0x0107:
            monitor-exit(r9)
            return
        L_0x0109:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.a(com.amap.api.col.n3.jz$a, boolean):void");
    }

    /* access modifiers changed from: private */
    public boolean k() {
        return this.n >= 2000 && this.n >= this.m.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x008a, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean c(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.l()     // Catch:{ all -> 0x008d }
            e((java.lang.String) r8)     // Catch:{ all -> 0x008d }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r0 = r7.m     // Catch:{ all -> 0x008d }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008d }
            com.amap.api.col.n3.jz$c r0 = (com.amap.api.col.n3.jz.c) r0     // Catch:{ all -> 0x008d }
            r1 = 0
            if (r0 == 0) goto L_0x008b
            com.amap.api.col.n3.jz$a r2 = r0.e     // Catch:{ all -> 0x008d }
            if (r2 == 0) goto L_0x0019
            goto L_0x008b
        L_0x0019:
            int r2 = r7.i     // Catch:{ all -> 0x008d }
            if (r1 >= r2) goto L_0x0057
            java.io.File r2 = r0.a((int) r1)     // Catch:{ all -> 0x008d }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x0041
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008d }
            if (r3 != 0) goto L_0x0041
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            java.lang.String r1 = "failed to delete "
            r0.<init>(r1)     // Catch:{ all -> 0x008d }
            r0.append(r2)     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008d }
            r8.<init>(r0)     // Catch:{ all -> 0x008d }
            throw r8     // Catch:{ all -> 0x008d }
        L_0x0041:
            long r2 = r7.j     // Catch:{ all -> 0x008d }
            long[] r4 = r0.c     // Catch:{ all -> 0x008d }
            r5 = r4[r1]     // Catch:{ all -> 0x008d }
            long r2 = r2 - r5
            r7.j = r2     // Catch:{ all -> 0x008d }
            long[] r2 = r0.c     // Catch:{ all -> 0x008d }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008d }
            int r1 = r1 + 1
            goto L_0x0019
        L_0x0057:
            int r0 = r7.n     // Catch:{ all -> 0x008d }
            r1 = 1
            int r0 = r0 + r1
            r7.n = r0     // Catch:{ all -> 0x008d }
            java.io.Writer r0 = r7.k     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008d }
            java.lang.String r3 = "REMOVE "
            r2.<init>(r3)     // Catch:{ all -> 0x008d }
            r2.append(r8)     // Catch:{ all -> 0x008d }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008d }
            r0.append(r2)     // Catch:{ all -> 0x008d }
            java.util.LinkedHashMap<java.lang.String, com.amap.api.col.n3.jz$c> r0 = r7.m     // Catch:{ all -> 0x008d }
            r0.remove(r8)     // Catch:{ all -> 0x008d }
            boolean r8 = r7.k()     // Catch:{ all -> 0x008d }
            if (r8 == 0) goto L_0x0089
            java.util.concurrent.ThreadPoolExecutor r8 = g()     // Catch:{ all -> 0x008d }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.r     // Catch:{ all -> 0x008d }
            r8.submit(r0)     // Catch:{ all -> 0x008d }
        L_0x0089:
            monitor-exit(r7)
            return r1
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.jz.c(java.lang.String):boolean");
    }

    public final synchronized boolean c() {
        return this.k == null;
    }

    private void l() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void d() throws IOException {
        l();
        m();
        this.k.flush();
    }

    public final synchronized void close() throws IOException {
        if (this.k != null) {
            Iterator it = new ArrayList(this.m.values()).iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.e != null) {
                    cVar.e.c();
                }
            }
            m();
            this.k.close();
            this.k = null;
        }
    }

    /* access modifiers changed from: private */
    public void m() throws IOException {
        while (true) {
            if (this.j > this.h || this.m.size() > this.l) {
                String str = (String) this.m.entrySet().iterator().next().getKey();
                c(str);
                if (this.o != null) {
                    this.o.a(str);
                }
            } else {
                return;
            }
        }
    }

    public final void e() throws IOException {
        close();
        kc.a(this.c);
    }

    private static void e(String str) {
        if (!a.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }
}
