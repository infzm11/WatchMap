package com.amap.api.services.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public class cv implements Closeable {
    private final InputStream a;
    /* access modifiers changed from: private */
    public final Charset b;
    private byte[] c;
    private int d;
    private int e;

    public cv(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public cv(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (!charset.equals(cw.a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        } else {
            this.a = inputStream;
            this.b = charset;
            this.c = new byte[i];
        }
    }

    public void close() throws IOException {
        synchronized (this.a) {
            if (this.c != null) {
                this.c = null;
                this.a.close();
            }
        }
    }

    public String a() throws IOException {
        int i;
        int i2;
        synchronized (this.a) {
            if (this.c == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.d >= this.e) {
                b();
            }
            for (int i3 = this.d; i3 != this.e; i3++) {
                if (this.c[i3] == 10) {
                    if (i3 != this.d) {
                        i2 = i3 - 1;
                        if (this.c[i2] == 13) {
                            String str = new String(this.c, this.d, i2 - this.d, this.b.name());
                            this.d = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(this.c, this.d, i2 - this.d, this.b.name());
                    this.d = i3 + 1;
                    return str2;
                }
            }
            AnonymousClass1 r1 = new ByteArrayOutputStream((this.e - this.d) + 80) {
                public String toString() {
                    try {
                        return new String(this.buf, 0, (this.count <= 0 || this.buf[this.count + -1] != 13) ? this.count : this.count - 1, cv.this.b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                r1.write(this.c, this.d, this.e - this.d);
                this.e = -1;
                b();
                i = this.d;
                while (true) {
                    if (i != this.e) {
                        if (this.c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
            }
            if (i != this.d) {
                r1.write(this.c, this.d, i - this.d);
            }
            this.d = i + 1;
            String byteArrayOutputStream = r1.toString();
            return byteArrayOutputStream;
        }
    }

    private void b() throws IOException {
        int read = this.a.read(this.c, 0, this.c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = read;
    }
}
