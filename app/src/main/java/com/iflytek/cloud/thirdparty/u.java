package com.iflytek.cloud.thirdparty;

import android.os.Message;

public abstract class u {
    protected String a = "";
    /* access modifiers changed from: protected */
    public t b;
    /* access modifiers changed from: protected */
    public boolean c;

    public u(String str, t tVar) {
        this.a = str;
        this.b = tVar;
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str) {
        af a2 = this.b.a();
        if (a2 != null) {
            a2.a(i, str);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Message message) {
        af a2 = this.b.a();
        if (a2 != null) {
            a2.sendMessage(message);
        }
    }

    public void a(y yVar) {
    }

    public void a(byte[] bArr, String str, int i, int i2, int i3) {
    }

    public boolean a() {
        return false;
    }

    public int b() {
        return 0;
    }

    public void c() {
    }

    public void d() {
    }
}
