package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.aiui.AIUISetting;
import com.iflytek.cloud.thirdparty.ak;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class aj {
    private static String a = (AIUISetting.getAIUIPath() + "data/");
    private static String b = a;
    private static boolean c = false;
    private static ak.b d;
    private static int e;
    private ak.a f;

    public static String a() {
        return b;
    }

    private static String a(Context context, String str) {
        int i;
        String str2;
        ak.a a2 = ak.a(a);
        if (a2.a("index.txt")) {
            byte[] bArr = new byte[a2.a()];
            a2.a(bArr);
            a2.b();
            try {
                i = Integer.parseInt(new String(bArr));
            } catch (NumberFormatException unused) {
            }
            e = i;
            a2.a("history", ".txt");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("----------------------------------\n");
            stringBuffer.append(new Date().toString());
            stringBuffer.append(" ");
            stringBuffer.append(str);
            stringBuffer.append(i);
            stringBuffer.append("\n");
            a2.b(stringBuffer.toString());
            a2.c();
            str2 = a + str + i + "/";
            int i2 = i + 1;
            a2.a("index", ".txt", false);
            a2.a(String.valueOf(i2).getBytes("utf-8"), true);
            a2.d();
            return str2;
        }
        i = 1;
        e = i;
        a2.a("history", ".txt");
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("----------------------------------\n");
        stringBuffer2.append(new Date().toString());
        stringBuffer2.append(" ");
        stringBuffer2.append(str);
        stringBuffer2.append(i);
        stringBuffer2.append("\n");
        a2.b(stringBuffer2.toString());
        a2.c();
        str2 = a + str + i + "/";
        int i22 = i + 1;
        try {
            a2.a("index", ".txt", false);
            a2.a(String.valueOf(i22).getBytes("utf-8"), true);
            a2.d();
            return str2;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str2;
        } catch (IOException e3) {
            e3.printStackTrace();
            return str2;
        }
    }

    public static void a(Context context, String str, String str2) {
        if (c) {
            if (TextUtils.isEmpty(str)) {
                b = a(context, str2);
            } else {
                b = str;
            }
        }
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.endsWith("/")) {
                str = str + "/";
            }
            a = str;
            if (d != null) {
                d.a(a);
            }
        }
    }

    public static void a(boolean z, long j, long j2, int i) {
        c = z;
        if (z) {
            if (d == null) {
                if (-1 != j) {
                    ak.b bVar = new ak.b(a, j, j2, i);
                    d = bVar;
                    d.setName("AIUI:DataSizeDeamonThread");
                    d.start();
                    return;
                }
                return;
            } else if (-1 != j) {
                return;
            }
        } else if (d == null) {
            return;
        }
        d.a();
        d = null;
    }

    public static int d() {
        return e;
    }

    public static boolean e() {
        return c;
    }

    public void a(String str, String str2, boolean z) {
        if (this.f != null) {
            this.f.a(str, str2, z);
        }
    }

    public boolean a(byte[] bArr, boolean z) {
        if (this.f == null) {
            return false;
        }
        try {
            this.f.a(bArr, z);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void b() {
        if (c) {
            if (this.f != null) {
                this.f.f();
            }
            this.f = ak.a(b);
        }
    }

    public void c() {
        if (this.f != null) {
            this.f.d();
        }
    }
}
