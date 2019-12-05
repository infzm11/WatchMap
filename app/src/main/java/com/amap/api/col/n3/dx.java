package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amap.api.col.n3.cu;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* compiled from: ImageFetcher */
public final class dx extends dy {
    private TileProvider e = null;

    public dx(Context context, int i, int i2) {
        super(context, i, i2);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            activeNetworkInfo.isConnectedOrConnecting();
        }
    }

    public final void a(TileProvider tileProvider) {
        this.e = tileProvider;
    }

    private Bitmap c(cu.a aVar) {
        try {
            Tile tile = this.e.getTile(aVar.a, aVar.b, aVar.c);
            if (tile == null || tile == TileProvider.NO_TILE) {
                return null;
            }
            return BitmapFactory.decodeByteArray(tile.data, 0, tile.data.length);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final Bitmap a(Object obj) {
        return c((cu.a) obj);
    }
}
