package com.amap.api.col.n3;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class ke extends kj {
    protected Context b;
    protected im c;

    public abstract byte[] d();

    public abstract byte[] e();

    /* access modifiers changed from: protected */
    public String h() {
        return "2.1";
    }

    public boolean i() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    public ke(Context context, im imVar) {
        if (context != null) {
            this.b = context.getApplicationContext();
        }
        this.c = imVar;
    }

    public Map<String, String> b() {
        String f = id.f(this.b);
        String a = ig.a();
        Context context = this.b;
        String a2 = ig.a(context, a, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a);
        hashMap.put("key", f);
        hashMap.put("scode", a2);
        return hashMap;
    }

    public final byte[] f() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(g());
            byteArrayOutputStream.write(l());
            byteArrayOutputStream.write(m());
            byteArrayOutputStream.write(n());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ir.a(th, "bre", "geb");
            }
            return byteArray;
        } catch (Throwable th2) {
            ir.a(th2, "bre", "geb");
            return null;
        }
        throw th;
    }

    private static byte[] g() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(in.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ir.a(th, "bre", "gbh");
            }
            return byteArray;
        } catch (Throwable th2) {
            ir.a(th2, "bre", "gbh");
            return null;
        }
        throw th;
    }

    private byte[] l() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (i()) {
                byte[] a = ig.a(this.b, k());
                byteArrayOutputStream.write(a(a));
                byteArrayOutputStream.write(a);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a2 = in.a(h());
            if (a2 == null || a2.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            }
            byte[] a3 = in.a(j());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                ir.a(th, "bre", "gred");
            }
            return byteArray;
        } catch (Throwable th2) {
            ir.a(th2, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }

    public String j() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.c.c(), this.c.a()});
    }

    private static byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] m() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] e = e();
            if (e != null) {
                if (e.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(e));
                    byteArrayOutputStream.write(e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ir.a(th, "bre", "grrd");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ir.a(th2, "bre", "grrd");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ir.a(th3, "bre", "grrd");
        }
        return new byte[]{0};
        throw th;
    }

    private byte[] n() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] d = d();
            if (d != null) {
                if (d.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    Context context = this.b;
                    byte[] a = ig.a(d);
                    byteArrayOutputStream.write(a(a));
                    byteArrayOutputStream.write(a);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        ir.a(th, "bre", "gred");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                ir.a(th2, "bre", "gred");
            }
            return byteArray2;
        } catch (Throwable th3) {
            ir.a(th3, "bre", "gred");
        }
        return new byte[]{0};
        throw th;
    }
}
