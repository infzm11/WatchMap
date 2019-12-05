package com.loc;

import android.support.v4.os.EnvironmentCompat;
import java.util.Locale;

/* compiled from: Cgi */
public final class cc {
    private static cc p;
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 0;
    public int h = 0;
    public int i = 0;
    public int j = -113;
    public int k = 0;
    public short l = 0;
    public long m = 0;
    public boolean n = false;
    public boolean o = true;

    public cc(int i2, boolean z) {
        this.k = i2;
        this.n = z;
    }

    public final int a() {
        return this.c;
    }

    public final boolean a(cc ccVar) {
        if (ccVar == null) {
            return false;
        }
        switch (ccVar.k) {
            case 1:
                return this.k == 1 && ccVar.c == this.c && ccVar.d == this.d && ccVar.b == this.b;
            case 2:
                return this.k == 2 && ccVar.i == this.i && ccVar.h == this.h && ccVar.g == this.g;
            case 3:
                return this.k == 3 && ccVar.c == this.c && ccVar.d == this.d && ccVar.b == this.b;
            case 4:
                return this.k == 4 && ccVar.c == this.c && ccVar.d == this.d && ccVar.b == this.b;
            default:
                return false;
        }
    }

    public final int b() {
        return this.d;
    }

    public final int c() {
        return this.h;
    }

    public final int d() {
        return this.i;
    }

    public final int e() {
        return this.j;
    }

    public final String toString() {
        Object[] objArr;
        String str;
        Locale locale;
        switch (this.k) {
            case 1:
                locale = Locale.CHINA;
                str = "GSM lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 2:
                locale = Locale.CHINA;
                str = "CDMA bid=%d, nid=%d, sid=%d, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.i), Integer.valueOf(this.h), Integer.valueOf(this.g), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 3:
                locale = Locale.CHINA;
                str = "LTE lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            case 4:
                locale = Locale.CHINA;
                str = "WCDMA lac=%d, cid=%d, mnc=%s, valid=%b, sig=%d, age=%d, reg=%b";
                objArr = new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.b), Boolean.valueOf(this.o), Integer.valueOf(this.j), Short.valueOf(this.l), Boolean.valueOf(this.n)};
                break;
            default:
                return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        return String.format(locale, str, objArr);
    }
}
