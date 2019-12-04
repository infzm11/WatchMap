package com.iflytek.cloud.record;

import android.content.Context;
import android.media.AudioTrack;
import android.os.MemoryFile;
import com.iflytek.cloud.thirdparty.bv;
import com.iflytek.cloud.thirdparty.cb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class b {
    private final int a = 2;
    private final int b = 1;
    private final int c = 16000;
    private final int d = 60;
    private final int e = 500;
    private final int f = 1920000;
    private int g = 1920000;
    private ArrayList<a> h = null;
    private Context i = null;
    private int j = 16000;
    private volatile long k = 0;
    private MemoryFile l = null;
    private volatile long m = 0;
    private volatile int n = 0;
    private a o = null;
    private String p = "";
    private String q = null;
    private byte[] r = null;
    private int s = 0;
    private int t = 0;
    private int u = 100;
    private final float v = 0.95f;
    private boolean w = true;

    public class a {
        long a;
        long b;
        int c;
        int d;

        public a(long j, long j2, int i, int i2) {
            this.a = j;
            this.b = j2;
            this.c = i;
            this.d = i2;
        }
    }

    public b(Context context, int i2, int i3, String str, int i4) {
        this.i = context;
        this.k = 0;
        this.h = new ArrayList<>();
        this.m = 0;
        this.j = i2;
        this.q = str;
        this.u = i4;
        this.g = (this.j * 2 * 1 * i3) + 1920000;
        cb.a("min audio seconds: " + i3 + ", max audio buf size: " + this.g);
    }

    private void a(byte[] bArr) throws IOException {
        if (bArr != null && bArr.length != 0) {
            if (this.l == null) {
                this.p = k();
                this.l = new MemoryFile(this.p, this.g);
                this.l.allowPurging(false);
            }
            this.l.writeBytes(bArr, 0, (int) this.m, bArr.length);
            this.m += (long) bArr.length;
        }
    }

    private void c(int i2) throws IOException {
        if (this.r == null) {
            this.r = new byte[(10 * i2)];
        }
        int length = this.r.length;
        int i3 = (int) (this.m - ((long) this.n));
        if (i3 < length) {
            length = i3;
        }
        this.l.readBytes(this.r, this.n, 0, length);
        this.n += length;
        this.s = 0;
        this.t = length;
        cb.a("readAudio leave, dataSize=" + length + ", bufLen=" + i3);
    }

    private String k() {
        String a2 = bv.a(this.i);
        return a2 + System.currentTimeMillis() + "tts.pcm";
    }

    public int a() {
        return this.j;
    }

    public void a(AudioTrack audioTrack, int i2) throws IOException {
        if (this.s >= this.t) {
            c(i2);
        }
        int i3 = 2 * i2 > this.t - this.s ? this.t - this.s : i2;
        audioTrack.write(this.r, this.s, i3);
        this.s += i3;
        if (f() && i()) {
            b(audioTrack, i2);
        }
    }

    public void a(ArrayList<byte[]> arrayList, int i2, int i3, int i4) throws IOException {
        cb.b("buffer percent = " + i2 + ", beg=" + i3 + ", end=" + i4);
        a aVar = new a(this.m, this.m, i3, i4);
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            a(arrayList.get(i5));
        }
        aVar.b = this.m;
        this.k = (long) i2;
        synchronized (this.h) {
            this.h.add(aVar);
        }
        cb.b("allSize = " + this.m + " maxSize=" + this.g);
    }

    public void a(boolean z) {
        this.w = z;
    }

    public boolean a(int i2) {
        if (((float) this.k) > 0.95f * ((float) this.u)) {
            return true;
        }
        return this.m / 32 >= ((long) i2) && 0 < this.m;
    }

    public boolean a(String str) {
        cb.a("save to local: format = " + str + " totalSize = " + this.m + " maxSize=" + this.g);
        if (bv.a(this.l, this.m, this.q)) {
            return bv.a(str, this.q, a());
        }
        return false;
    }

    public int b() {
        if (this.l != null) {
            return this.l.length();
        }
        return 0;
    }

    public void b(AudioTrack audioTrack, int i2) {
        int i3 = (((500 * this.j) * 2) * 1) / 1000;
        cb.a("mBuffer.writeTrack writeTrackBlankBlock size: " + i3);
        audioTrack.write(new byte[i3], 0, i3);
    }

    public boolean b(int i2) {
        return ((long) i2) <= ((this.m - ((long) this.n)) + ((long) this.t)) - ((long) this.s);
    }

    public void c() throws IOException {
        this.n = 0;
        this.o = null;
        if (this.h.size() > 0) {
            this.o = this.h.get(0);
        }
    }

    public int d() {
        if (this.m <= 0) {
            return 0;
        }
        return (int) ((((long) (this.n - (this.t - this.s))) * this.k) / this.m);
    }

    public a e() {
        if (this.o == null) {
            return null;
        }
        long j2 = (long) (this.n - (this.t - this.s));
        if (j2 >= this.o.a && j2 <= this.o.b) {
            return this.o;
        }
        synchronized (this.h) {
            Iterator<a> it = this.h.iterator();
            while (it.hasNext()) {
                this.o = it.next();
                if (j2 >= this.o.a && j2 <= this.o.b) {
                    a aVar = this.o;
                    return aVar;
                }
            }
            return null;
        }
    }

    public boolean f() {
        return ((long) this.u) == this.k && ((long) this.n) >= this.m && this.s >= this.t;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        j();
        super.finalize();
    }

    public boolean g() {
        return ((long) this.n) < this.m || this.s < this.t;
    }

    public boolean h() {
        return ((long) this.u) == this.k;
    }

    public boolean i() {
        return this.w;
    }

    public void j() {
        cb.a("deleteFile");
        try {
            if (this.l != null) {
                this.l.close();
                this.l = null;
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
    }
}
