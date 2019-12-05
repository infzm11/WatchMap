package com.amap.api.services.a;

import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: BaseNetManager */
public class cx {
    private static cx a;

    /* compiled from: BaseNetManager */
    public interface a {
        URLConnection a(Proxy proxy, URL url);
    }

    public static cx a() {
        if (a == null) {
            a = new cx();
        }
        return a;
    }

    public byte[] a(dd ddVar) throws ay {
        try {
            df a2 = a(ddVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (ay e) {
            throw e;
        } catch (Throwable th) {
            bl.a(th, "BaseNetManager", "makeSyncPostRequest");
            throw new ay("未知的错误");
        }
    }

    /* access modifiers changed from: protected */
    public void b(dd ddVar) throws ay {
        if (ddVar == null) {
            throw new ay("requeust is null");
        } else if (ddVar.i() == null || "".equals(ddVar.i())) {
            throw new ay("request url is empty");
        }
    }

    public df a(dd ddVar, boolean z) throws ay {
        Proxy proxy;
        try {
            b(ddVar);
            if (ddVar.h == null) {
                proxy = null;
            } else {
                proxy = ddVar.h;
            }
            return new da(ddVar.f, ddVar.g, proxy, z).a(ddVar.m(), ddVar.e(), ddVar.n());
        } catch (ay e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new ay("未知的错误");
        }
    }
}
