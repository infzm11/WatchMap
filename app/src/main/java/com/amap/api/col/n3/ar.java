package com.amap.api.col.n3;

import android.content.Context;
import android.os.Bundle;
import com.amap.api.col.n3.bg;
import com.amap.api.maps.AMap;
import java.io.IOException;

/* compiled from: OfflineMapDownloadTask */
public final class ar extends kt implements bg.a {
    private bg a;
    private bi b;
    private bk c;
    private Context d;
    private Bundle e;
    private AMap f;
    private boolean g;

    private ar(bk bkVar, Context context) {
        this.e = new Bundle();
        this.g = false;
        this.c = bkVar;
        this.d = context;
    }

    public ar(bk bkVar, Context context, byte b2) {
        this(bkVar, context);
        this.f = null;
    }

    public final void a() {
        this.c.t();
        try {
            this.a = new bg(new bh(this.c.getUrl(), dv.b(this.d), this.c.u(), this.c.v()), this.c.getUrl(), this.d, this.c);
            this.a.a((bg.a) this);
            this.b = new bi(this.c, this.c);
            if (!this.g) {
                this.a.a();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void b() {
        this.g = true;
        if (this.a != null) {
            this.a.b();
        } else {
            e();
        }
        if (this.b != null) {
            this.b.a();
        }
    }

    public final void c() {
        this.f = null;
        if (this.e != null) {
            this.e.clear();
            this.e = null;
        }
    }

    public final void d() {
        if (this.b != null) {
            this.b.b();
        }
    }
}
