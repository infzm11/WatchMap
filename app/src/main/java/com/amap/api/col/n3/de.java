package com.amap.api.col.n3;

import android.text.TextUtils;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: BaseTileProvider */
public abstract class de implements TileProvider {
    private final int a = 256;
    ki b;
    private final int c = 256;

    /* compiled from: BaseTileProvider */
    class a extends kj {
        private String b = "";

        public final Map<String, String> b() {
            return null;
        }

        public a(String str) {
            this.b = str;
            a(ik.a(o.a));
            a(5000);
            b(50000);
        }

        public final Map<String, String> a() {
            HashMap hashMap = new HashMap();
            hashMap.put("User-Agent", g.d);
            hashMap.put("Accept-Encoding", "gzip");
            hashMap.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"5.4.0", "3dmap"}));
            hashMap.put("X-INFO", ig.a(o.a));
            hashMap.put("key", id.f(o.a));
            hashMap.put("logversion", "2.1");
            return hashMap;
        }

        public final String c() {
            return this.b;
        }
    }

    public abstract String a(int i, int i2, int i3);

    public final Tile getTile(int i, int i2, int i3) {
        String a2 = a(i, i2, i3);
        if (TextUtils.isEmpty(a2)) {
            return NO_TILE;
        }
        try {
            return Tile.obtain(this.a, this.c, a(a2));
        } catch (IOException unused) {
            return NO_TILE;
        }
    }

    private byte[] a(String str) throws IOException {
        try {
            a aVar = new a(str);
            this.b = ki.c();
            ki kiVar = this.b;
            return ki.d(aVar);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int getTileWidth() {
        return this.a;
    }

    public int getTileHeight() {
        return this.c;
    }
}
