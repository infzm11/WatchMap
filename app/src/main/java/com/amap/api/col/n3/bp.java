package com.amap.api.col.n3;

/* compiled from: CityStateImp */
public abstract class bp {
    protected int a;
    protected al b;

    public abstract void c();

    public bp(int i, al alVar) {
        this.a = i;
        this.b = alVar;
    }

    public final int b() {
        return this.a;
    }

    public final void a(bp bpVar) {
        this.a + " ==> " + bpVar.a + "   " + getClass() + "==>" + bpVar.getClass();
    }

    public void d() {
        "Wrong call start()  State: " + this.a + "  " + getClass();
    }

    public void e() {
        "Wrong call continueDownload()  State: " + this.a + "  " + getClass();
    }

    public void f() {
        "Wrong call pause()  State: " + this.a + "  " + getClass();
    }

    public void a() {
        "Wrong call delete()  State: " + this.a + "  " + getClass();
    }

    public void a(int i) {
        "Wrong call fail()  State: " + this.a + "  " + getClass();
    }

    public void g() {
        "Wrong call hasNew()  State: " + this.a + "  " + getClass();
    }

    public void h() {
        "Wrong call complete()  State: " + this.a + "  " + getClass();
    }
}
