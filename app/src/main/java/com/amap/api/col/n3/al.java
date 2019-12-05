package com.amap.api.col.n3;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.n3.bd;
import com.amap.api.col.n3.bl;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: CityObject */
public final class al extends OfflineMapCity implements au, bk {
    public static final Parcelable.Creator<al> o = new Parcelable.Creator<al>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new al(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new al[i];
        }
    };
    public bp a;
    public bp b;
    public bp c;
    public bp d;
    public bp e;
    public bp f;
    public bp g;
    public bp h;
    public bp i;
    public bp j;
    public bp k;
    bp l;
    Context m;
    boolean n;
    private String p;
    private String q;
    /* access modifiers changed from: private */
    public long r;

    public final int describeContents() {
        return 0;
    }

    public final void a(String str) {
        this.q = str;
    }

    public final String a() {
        return this.q;
    }

    public final String b() {
        return getUrl();
    }

    public al(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        String str = am.a;
        this.p = str + getPinyin() + ".zip.tmp";
    }

    private al(Context context, int i2) {
        this.a = new br(this);
        this.b = new bx(this);
        this.c = new bt(this);
        this.d = new bv(this);
        this.e = new bw(this);
        this.f = new bq(this);
        this.g = new bu(this);
        this.h = new bs(-1, this);
        this.i = new bs(101, this);
        this.j = new bs(102, this);
        this.k = new bs(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.m = context;
        a(i2);
    }

    public final void a(int i2) {
        switch (i2) {
            case -1:
                this.l = this.h;
                break;
            case 0:
                this.l = this.c;
                break;
            case 1:
                this.l = this.e;
                break;
            case 2:
                this.l = this.b;
                break;
            case 3:
                this.l = this.d;
                break;
            case 4:
                this.l = this.f;
                break;
            default:
                switch (i2) {
                    case 6:
                        this.l = this.a;
                        break;
                    case 7:
                        this.l = this.g;
                        break;
                    default:
                        switch (i2) {
                            case 101:
                                this.l = this.i;
                                break;
                            case 102:
                                this.l = this.j;
                                break;
                            case 103:
                                this.l = this.k;
                                break;
                            default:
                                if (i2 < 0) {
                                    this.l = this.h;
                                    break;
                                }
                                break;
                        }
                }
        }
        setState(i2);
    }

    public final void a(bp bpVar) {
        this.l = bpVar;
        setState(bpVar.b());
    }

    public final bp c() {
        return this.l;
    }

    public final void d() {
        am a2 = am.a(this.m);
        if (a2 != null) {
            a2.c(this);
        }
    }

    public final void e() {
        am a2 = am.a(this.m);
        if (a2 != null) {
            a2.e(this);
            d();
        }
    }

    public final void f() {
        "CityOperation current State==>" + this.l.b();
        if (this.l.equals(this.d)) {
            this.l.e();
        } else if (this.l.equals(this.c)) {
            this.l.f();
        } else {
            boolean z = true;
            if (this.l.equals(this.g) || this.l.equals(this.h)) {
                am a2 = am.a(this.m);
                if (a2 != null) {
                    a2.a(this);
                }
                this.n = true;
                return;
            }
            if (!this.l.equals(this.j) && !this.l.equals(this.i)) {
                if (this.k.b() != this.l.b()) {
                    z = false;
                }
                if (!z) {
                    this.l.c();
                    return;
                }
            }
            this.l.d();
        }
    }

    public final void g() {
        this.l.f();
    }

    public final void h() {
        this.l.a(this.k.b());
    }

    public final void i() {
        this.l.a();
        if (this.n) {
            this.l.c();
        }
        this.n = false;
    }

    public final void j() {
        this.l.equals(this.f);
        this.l.g();
    }

    public final void k() {
        am a2 = am.a(this.m);
        if (a2 != null) {
            a2.b(this);
        }
    }

    public final void l() {
        am a2 = am.a(this.m);
        if (a2 != null) {
            a2.d(this);
        }
    }

    public final void m() {
        this.r = 0;
        this.l.equals(this.b);
        this.l.d();
    }

    public final void a(long j2, long j3) {
        int i2 = (int) ((j3 * 100) / j2);
        if (i2 != getcompleteCode()) {
            setCompleteCode(i2);
            d();
        }
    }

    public final void n() {
        this.l.equals(this.c);
        this.l.h();
    }

    public final void a(bl.a aVar) {
        int i2;
        switch (aVar) {
            case amap_exception:
                i2 = this.j.b();
                break;
            case file_io_exception:
                i2 = this.k.b();
                break;
            case network_exception:
                i2 = this.i.b();
                break;
            default:
                i2 = 6;
                break;
        }
        if (this.l.equals(this.c) || this.l.equals(this.b)) {
            this.l.a(i2);
        }
    }

    public final void o() {
        e();
    }

    public final void p() {
        this.r = 0;
        setCompleteCode(0);
        this.l.equals(this.e);
        this.l.d();
    }

    public final void q() {
        this.l.equals(this.e);
        this.l.a(this.h.b());
    }

    public final void a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.r > 500) {
            int i2 = (int) j2;
            if (i2 > getcompleteCode()) {
                setCompleteCode(i2);
                d();
            }
            this.r = currentTimeMillis;
        }
    }

    public final void b(String str) {
        this.l.equals(this.e);
        this.q = str;
        final String y = y();
        String z = z();
        if (TextUtils.isEmpty(y) || TextUtils.isEmpty(z)) {
            q();
            return;
        }
        final File file = new File(z + "/");
        File file2 = new File(dv.a(this.m) + File.separator + "map/");
        File file3 = new File(dv.a(this.m));
        if (!file3.exists()) {
            file3.mkdir();
        }
        if (!file2.exists()) {
            file2.mkdir();
        }
        new bd().a(file, file2, -1, bj.a(file), new bd.a() {
            public final void a(float f) {
                int i = (int) (60.0d + (((double) f) * 0.39d));
                if (i - al.this.getcompleteCode() > 0 && System.currentTimeMillis() - al.this.r > 1000) {
                    al.this.setCompleteCode(i);
                    long unused = al.this.r = System.currentTimeMillis();
                }
            }

            public final void a() {
                try {
                    new File(y).delete();
                    bj.b(file);
                    al.this.setCompleteCode(100);
                    al.this.l.h();
                } catch (Exception unused) {
                    al.this.l.a(al.this.k.b());
                }
            }

            public final void b() {
                al.this.l.a(al.this.k.b());
            }
        });
    }

    public final void r() {
        e();
    }

    private String y() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        return this.p.substring(0, this.p.lastIndexOf("."));
    }

    private String z() {
        if (TextUtils.isEmpty(this.p)) {
            return null;
        }
        String y = y();
        return y.substring(0, y.lastIndexOf(46));
    }

    public final aw s() {
        setState(this.l.b());
        aw awVar = new aw((OfflineMapCity) this, this.m);
        awVar.a(this.q);
        "vMapFileNames: " + this.q;
        return awVar;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.q);
    }

    public al(Parcel parcel) {
        super(parcel);
        this.a = new br(this);
        this.b = new bx(this);
        this.c = new bt(this);
        this.d = new bv(this);
        this.e = new bw(this);
        this.f = new bq(this);
        this.g = new bu(this);
        this.h = new bs(-1, this);
        this.i = new bs(101, this);
        this.j = new bs(102, this);
        this.k = new bs(103, this);
        this.p = null;
        this.q = "";
        this.n = false;
        this.r = 0;
        this.q = parcel.readString();
    }

    public final boolean t() {
        bj.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    public final String u() {
        StringBuffer stringBuffer = new StringBuffer(getPinyin());
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    public final String v() {
        return getAdcode();
    }

    public final String w() {
        return y();
    }

    public final String x() {
        return z();
    }

    public final bp b(int i2) {
        switch (i2) {
            case 101:
                return this.i;
            case 102:
                return this.j;
            case 103:
                return this.k;
            default:
                return this.h;
        }
    }
}
