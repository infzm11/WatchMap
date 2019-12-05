package com.amap.api.col.n3;

import android.content.Context;

/* compiled from: PoiSearch */
public final class gz {
    private gl a = null;

    /* compiled from: PoiSearch */
    public interface a {
        void a(gw gwVar, int i);
    }

    /* compiled from: PoiSearch */
    public static class b implements Cloneable {
        private String a;
        private String b;
        private String c;
        private int d = 1;
        private int e = 20;
        private String f = "zh-CN";
        private boolean g = false;
        private boolean h = false;
        private String i;
        private boolean j = true;
        private gs k;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        public final void a() {
            this.h = true;
        }

        public final void b() {
            this.j = false;
        }

        public final int hashCode() {
            int i2 = 0;
            int i3 = 1237;
            int hashCode = ((((((this.b == null ? 0 : this.b.hashCode()) + 31) * 31) + (this.c == null ? 0 : this.c.hashCode())) * 31) + (this.g ? 1231 : 1237)) * 31;
            if (this.h) {
                i3 = 1231;
            }
            int hashCode2 = 31 * (((((((((hashCode + i3) * 31) + (this.f == null ? 0 : this.f.hashCode())) * 31) + this.d) * 31) + this.e) * 31) + (this.a == null ? 0 : this.a.hashCode()));
            if (this.i != null) {
                i2 = this.i.hashCode();
            }
            return hashCode2 + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.b == null) {
                if (bVar.b != null) {
                    return false;
                }
            } else if (!this.b.equals(bVar.b)) {
                return false;
            }
            if (this.c == null) {
                if (bVar.c != null) {
                    return false;
                }
            } else if (!this.c.equals(bVar.c)) {
                return false;
            }
            if (this.f == null) {
                if (bVar.f != null) {
                    return false;
                }
            } else if (!this.f.equals(bVar.f)) {
                return false;
            }
            if (this.d != bVar.d || this.e != bVar.e) {
                return false;
            }
            if (this.a == null) {
                if (bVar.a != null) {
                    return false;
                }
            } else if (!this.a.equals(bVar.a)) {
                return false;
            }
            if (this.i == null) {
                if (bVar.i != null) {
                    return false;
                }
            } else if (!this.i.equals(bVar.i)) {
                return false;
            }
            return this.g == bVar.g && this.h == bVar.h;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0039  */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.amap.api.col.n3.gz.b clone() {
            /*
                r4 = this;
                super.clone()     // Catch:{ CloneNotSupportedException -> 0x0004 }
                goto L_0x000c
            L_0x0004:
                r0 = move-exception
                java.lang.String r1 = "PoiSearch"
                java.lang.String r2 = "queryclone"
                com.amap.api.col.n3.gk.a(r0, r1, r2)
            L_0x000c:
                com.amap.api.col.n3.gz$b r0 = new com.amap.api.col.n3.gz$b
                java.lang.String r1 = r4.a
                java.lang.String r2 = r4.b
                java.lang.String r3 = r4.c
                r0.<init>(r1, r2, r3)
                int r1 = r4.d
                r0.d = r1
                int r1 = r4.e
                if (r1 > 0) goto L_0x0024
                r1 = 20
            L_0x0021:
                r0.e = r1
                goto L_0x002a
            L_0x0024:
                r2 = 30
                if (r1 <= r2) goto L_0x0021
                r0.e = r2
            L_0x002a:
                java.lang.String r1 = r4.f
                java.lang.String r2 = "en"
                boolean r1 = r2.equals(r1)
                if (r1 == 0) goto L_0x0039
                java.lang.String r1 = "en"
            L_0x0036:
                r0.f = r1
                goto L_0x003c
            L_0x0039:
                java.lang.String r1 = "zh-CN"
                goto L_0x0036
            L_0x003c:
                boolean r1 = r4.g
                r0.g = r1
                boolean r1 = r4.h
                r0.h = r1
                java.lang.String r1 = r4.i
                r0.i = r1
                com.amap.api.col.n3.gs r1 = r4.k
                r0.k = r1
                boolean r1 = r4.j
                r0.j = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.gz.b.clone():com.amap.api.col.n3.gz$b");
        }
    }

    public gz(Context context, b bVar) {
        if (this.a == null) {
            try {
                this.a = new ha(context, bVar);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(a aVar) {
        if (this.a != null) {
            this.a.a(aVar);
        }
    }

    public final gw a(String str) throws gh {
        if (this.a != null) {
            return this.a.a(str);
        }
        return null;
    }

    public final void b(String str) {
        if (this.a != null) {
            this.a.b(str);
        }
    }
}
