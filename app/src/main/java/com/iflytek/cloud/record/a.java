package com.iflytek.cloud.record;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.record.PcmRecorder;
import com.iflytek.cloud.thirdparty.cb;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class a extends PcmRecorder {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private boolean d = false;
    private int e = 16000;
    private final short f = 16;
    private int g = 40;
    private int h = 40;
    private byte[] i = null;
    private RandomAccessFile j = null;
    private String k = null;
    private PcmRecorder.PcmRecordListener l = null;

    public a(int i2, int i3, int i4, String str) {
        super(i2, i3, i4);
        this.e = i2;
        this.g = i3;
        this.h = i3;
        this.k = str;
    }

    private int a() throws SpeechError {
        int i2 = 0;
        if (this.j != null) {
            if (this.l == null) {
                return 0;
            }
            if (this.b >= this.a) {
                try {
                    this.b = 0;
                    this.a = this.j.read(this.i, this.b, this.i.length);
                    if (this.a < 0) {
                        return -1;
                    }
                } catch (IOException unused) {
                    throw new SpeechError(20006);
                }
            }
            if (this.a > 0 && this.l != null) {
                i2 = this.a - this.b > this.c ? this.c : this.a - this.b;
                this.l.onRecordBuffer(this.i, this.b, i2);
                this.b += i2;
            }
        }
        return i2;
    }

    private void b() {
        if (this.j != null) {
            cb.a("release record begin");
            try {
                this.j.close();
            } catch (IOException e2) {
                cb.a((Throwable) e2);
            }
            this.j = null;
            if (this.l != null) {
                this.l.onRecordReleased();
                this.l = null;
            }
            cb.a("release record over");
        }
        if (this.i != null) {
            this.i = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(short s, int i2, int i3) throws SpeechError {
        this.c = ((((i2 * 40) / 1000) * s) * 16) / 8;
        this.i = new byte[(10 * this.c)];
        try {
            this.j = new RandomAccessFile(this.k, "r");
        } catch (FileNotFoundException unused) {
            throw new SpeechError(20006);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        b();
        super.finalize();
    }

    public void run() {
        try {
            a(1, this.e, this.g);
            if (this.l != null) {
                this.l.onRecordStarted(true);
            }
            while (true) {
                if (this.d) {
                    break;
                } else if (a() < 0) {
                    this.d = true;
                    break;
                } else {
                    sleep((long) this.h);
                }
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
            if (this.l != null) {
                this.l.onError(new SpeechError(20006));
            }
        }
        b();
    }

    public void startRecording(PcmRecorder.PcmRecordListener pcmRecordListener) throws SpeechError {
        this.l = pcmRecordListener;
        setPriority(10);
        start();
    }

    public void stopRecord(boolean z) {
        this.d = true;
    }
}
