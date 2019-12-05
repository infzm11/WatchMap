package com.loc;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class bj extends bn {
    protected Context a;
    protected s b;

    public bj(Context context, s sVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = sVar;
    }

    protected static byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private static byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(t.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                w.a(th, "bre", "gbh");
                return byteArray;
            }
        } catch (Throwable th2) {
            w.a(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    private byte[] k() {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (g()) {
                bArr = m.a(this.a, i());
                byteArrayOutputStream.write(a(bArr));
            } else {
                bArr = new byte[]{0, 0};
            }
            byteArrayOutputStream.write(bArr);
            byte[] a2 = t.a(f());
            if (a2 == null || a2.length <= 0) {
                a2 = new byte[]{0, 0};
            } else {
                byteArrayOutputStream.write(a(a2));
            }
            byteArrayOutputStream.write(a2);
            byte[] a3 = t.a(h());
            if (a3 == null || a3.length <= 0) {
                a3 = new byte[]{0, 0};
            } else {
                byteArrayOutputStream.write(a(a3));
            }
            byteArrayOutputStream.write(a3);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                w.a(th, "bre", "gred");
                return byteArray;
            }
        } catch (Throwable th2) {
            w.a(th2, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] a_ = a_();
            if (a_ != null) {
                if (a_.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(a_));
                    byteArrayOutputStream.write(a_);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (Throwable th) {
                        w.a(th, "bre", "grrd");
                        return byteArray;
                    }
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                w.a(th2, "bre", "grrd");
                return byteArray2;
            }
        } catch (Throwable th3) {
            w.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
        throw th;
    }

    private byte[] m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] e = e();
            if (e != null) {
                if (e.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    Context context = this.a;
                    byte[] a2 = m.a(e);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        return byteArray;
                    } catch (Throwable th) {
                        w.a(th, "bre", "gred");
                        return byteArray;
                    }
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray2;
            } catch (Throwable th2) {
                w.a(th2, "bre", "gred");
                return byteArray2;
            }
        } catch (Throwable th3) {
            w.a(th3, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    public abstract byte[] a_();

    public Map<String, String> b_() {
        String f = k.f(this.a);
        String a2 = m.a();
        Context context = this.a;
        String a3 = m.a(context, a2, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    public final byte[] d() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(k());
            byteArrayOutputStream.write(l());
            byteArrayOutputStream.write(m());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                w.a(th, "bre", "geb");
                return byteArray;
            }
        } catch (Throwable th2) {
            w.a(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    public abstract byte[] e();

    /* access modifiers changed from: protected */
    public String f() {
        return "2.1";
    }

    public boolean g() {
        return true;
    }

    public String h() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.b.c(), this.b.a()});
    }

    /* access modifiers changed from: protected */
    public boolean i() {
        return false;
    }
}
