package com.amap.api.col.n3;

/* compiled from: RectPacker */
public class ea {
    b a;

    /* compiled from: RectPacker */
    enum a {
        FAIL,
        PERFECT,
        FIT
    }

    /* compiled from: RectPacker */
    class b {
        static final /* synthetic */ boolean e = true;
        String a;
        c b;
        b c = null;
        b d = null;

        static {
            Class<ea> cls = ea.class;
        }

        b(c cVar) {
            this.b = cVar;
        }

        /* access modifiers changed from: package-private */
        public final b a(int i, int i2, String str) {
            c cVar;
            c cVar2;
            int i3 = i;
            int i4 = i2;
            String str2 = str;
            b bVar = this;
            while (bVar.a()) {
                if (bVar.a != null) {
                    return null;
                }
                switch ((i3 > bVar.b.c || i4 > bVar.b.d) ? a.FAIL : (i3 == bVar.b.c && i4 == bVar.b.d) ? a.PERFECT : a.FIT) {
                    case FAIL:
                        return null;
                    case PERFECT:
                        bVar.a = str2;
                        return bVar;
                    case FIT:
                        int i5 = bVar.b.c - i3;
                        int i6 = bVar.b.d - i4;
                        if (!e && i5 < 0) {
                            throw new AssertionError();
                        } else if (e || i6 >= 0) {
                            if (i5 > i6) {
                                cVar = new c(bVar.b.a, bVar.b.b, i3, bVar.b.d);
                                cVar2 = new c(cVar.a + i3, bVar.b.b, bVar.b.c - i3, bVar.b.d);
                            } else {
                                cVar = new c(bVar.b.a, bVar.b.b, bVar.b.c, i4);
                                cVar2 = new c(bVar.b.a, cVar.b + i4, bVar.b.c, bVar.b.d - i4);
                            }
                            bVar.c = new b(cVar);
                            bVar.d = new b(cVar2);
                            break;
                        } else {
                            throw new AssertionError();
                        }
                }
                bVar = bVar.c;
            }
            b a2 = bVar.c.a(i3, i4, str2);
            return a2 == null ? bVar.d.a(i3, i4, str2) : a2;
        }

        private boolean a() {
            return this.c == null;
        }

        private boolean b() {
            return this.a != null || !a();
        }

        /* access modifiers changed from: package-private */
        public final boolean a(String str) {
            if (!a()) {
                boolean a2 = this.c.a(str);
                if (!a2) {
                    a2 = this.d.a(str);
                }
                if (a2 && !this.c.b() && !this.d.b()) {
                    this.c = null;
                    this.d = null;
                }
                return a2;
            } else if (!str.equals(this.a)) {
                return false;
            } else {
                this.a = null;
                return true;
            }
        }
    }

    /* compiled from: RectPacker */
    public class c {
        public int a;
        public int b;
        public int c;
        public int d;

        c(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        public final String toString() {
            return "[ x: " + this.a + ", y: " + this.b + ", w: " + this.c + ", h: " + this.d + " ]";
        }
    }

    public ea() {
        c cVar = new c(0, 0, 512, 1024);
        this.a = new b(cVar);
    }

    public final c a(int i, int i2, String str) {
        b a2 = this.a.a(i, i2, str);
        if (a2 == null) {
            return null;
        }
        c cVar = new c(a2.b.a, a2.b.b, a2.b.c, a2.b.d);
        return cVar;
    }

    public final boolean a(String str) {
        return this.a.a(str);
    }

    public final int a() {
        return this.a.b.c;
    }

    public final int b() {
        return this.a.b.d;
    }
}
