package com.amap.api.services.a;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BinaryRequest */
public abstract class cy extends dd {
    protected Context a;
    protected bh b;

    public abstract byte[] b();

    public abstract byte[] c();

    /* access modifiers changed from: protected */
    public String f() {
        return "2.1";
    }

    public boolean g() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return false;
    }

    public cy(Context context, bh bhVar) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
        this.b = bhVar;
    }

    public Map<String, String> d() {
        String f = az.f(this.a);
        String a2 = bc.a();
        Context context = this.a;
        String a3 = bc.a(context, a2, "key=" + f);
        HashMap hashMap = new HashMap();
        hashMap.put("ts", a2);
        hashMap.put("key", f);
        hashMap.put("scode", a3);
        return hashMap;
    }

    public final byte[] h() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(a());
            byteArrayOutputStream.write(j());
            byteArrayOutputStream.write(o());
            byteArrayOutputStream.write(p());
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bl.a(th, "BinaryRequest", "getEntityBytes");
            }
            return byteArray;
        } catch (Throwable th2) {
            bl.a(th2, "BinaryRequest", "getEntityBytes");
            return null;
        }
        throw th;
    }

    private byte[] a() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(bi.a("PANDORA$"));
            byteArrayOutputStream.write(new byte[]{1});
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bl.a(th, "BinaryRequest", "getBinaryHead");
            }
            return byteArray;
        } catch (Throwable th2) {
            bl.a(th2, "BinaryRequest", "getBinaryHead");
            return null;
        }
        throw th;
    }

    public byte[] j() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(new byte[]{3});
            if (g()) {
                byte[] a2 = bc.a(this.a, l());
                byteArrayOutputStream.write(a(a2));
                byteArrayOutputStream.write(a2);
            } else {
                byteArrayOutputStream.write(new byte[]{0, 0});
            }
            byte[] a3 = bi.a(f());
            if (a3 == null || a3.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a3));
                byteArrayOutputStream.write(a3);
            }
            byte[] a4 = bi.a(k());
            if (a4 == null || a4.length <= 0) {
                byteArrayOutputStream.write(new byte[]{0, 0});
            } else {
                byteArrayOutputStream.write(a(a4));
                byteArrayOutputStream.write(a4);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th) {
                bl.a(th, "BinaryRequest", "getRequestEncryptData");
            }
            return byteArray;
        } catch (Throwable th2) {
            bl.a(th2, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{0};
        throw th;
    }

    public String k() {
        return String.format("platform=Android&sdkversion=%s&product=%s", new Object[]{this.b.c(), this.b.a()});
    }

    /* access modifiers changed from: protected */
    public byte[] a(byte[] bArr) {
        int length = bArr.length;
        return new byte[]{(byte) (length / 256), (byte) (length % 256)};
    }

    private byte[] o() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] b2 = b();
            if (b2 != null) {
                if (b2.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byteArrayOutputStream.write(a(b2));
                    byteArrayOutputStream.write(b2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        bl.a(th, "BinaryRequest", "getRequestRawData");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                bl.a(th2, "BinaryRequest", "getRequestRawData");
            }
            return byteArray2;
        } catch (Throwable th3) {
            bl.a(th3, "BinaryRequest", "getRequestRawData");
        }
        return new byte[]{0};
        throw th;
    }

    private byte[] p() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] c = c();
            if (c != null) {
                if (c.length != 0) {
                    byteArrayOutputStream.write(new byte[]{1});
                    byte[] a2 = bc.a(this.a, c);
                    byteArrayOutputStream.write(a(a2));
                    byteArrayOutputStream.write(a2);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        bl.a(th, "BinaryRequest", "getRequestEncryptData");
                    }
                    return byteArray;
                }
            }
            byteArrayOutputStream.write(new byte[]{0});
            byte[] byteArray2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                bl.a(th2, "BinaryRequest", "getRequestEncryptData");
            }
            return byteArray2;
        } catch (Throwable th3) {
            bl.a(th3, "BinaryRequest", "getRequestEncryptData");
        }
        return new byte[]{0};
        throw th;
    }
}
