package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int a;
    private final int b;

    public abstract URL getTileUrl(int i, int i2, int i3);

    public UrlTileProvider(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final Tile getTile(int i, int i2, int i3) {
        URL tileUrl = getTileUrl(i, i2, i3);
        if (tileUrl == null) {
            return NO_TILE;
        }
        try {
            int i4 = this.a;
            int i5 = this.b;
            InputStream openStream = tileUrl.openStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            a(openStream, byteArrayOutputStream);
            return Tile.obtain(i4, i5, byteArrayOutputStream.toByteArray());
        } catch (IOException unused) {
            return NO_TILE;
        }
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j;
            }
            outputStream.write(bArr, 0, read);
            j += (long) read;
        }
    }

    public int getTileWidth() {
        return this.a;
    }

    public int getTileHeight() {
        return this.b;
    }
}
