package com.iflytek.cloud.record;

import android.media.AudioRecord;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.thirdparty.cb;

public class PcmRecorder extends Thread {
    public static final int RATE16K = 16000;
    public static final int READ_INTERVAL40MS = 40;
    private final short a;
    private byte[] b;
    private AudioRecord c;
    private PcmRecordListener d;
    private PcmRecordListener e;
    private volatile boolean f;
    private double g;
    private double h;
    private int i;
    private int j;
    private int k;
    private int l;

    public interface PcmRecordListener {
        void onError(SpeechError speechError);

        void onRecordBuffer(byte[] bArr, int i, int i2);

        void onRecordReleased();

        void onRecordStarted(boolean z);
    }

    public PcmRecorder(int i2, int i3) {
        this(i2, i3, 1);
    }

    public PcmRecorder(int i2, int i3, int i4) {
        this.a = 16;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = 0.0d;
        this.h = 0.0d;
        this.i = 16000;
        this.j = 40;
        this.k = 40;
        this.l = i4;
        this.i = i2;
        this.j = i3;
        if (this.j < 40 || this.j > 100) {
            this.j = 40;
        }
        this.k = 10;
    }

    private double a(byte[] bArr, int i2) {
        double d2 = 0.0d;
        if (bArr == null || i2 <= 0) {
            return 0.0d;
        }
        double d3 = 0.0d;
        for (byte b2 : bArr) {
            d3 += (double) b2;
        }
        double length = d3 / ((double) bArr.length);
        for (byte b3 : bArr) {
            d2 += Math.pow(((double) b3) - length, 2.0d);
        }
        return Math.sqrt(d2 / ((double) (bArr.length - 1)));
    }

    private int a() throws SpeechError {
        if (this.c == null || this.d == null) {
            return 0;
        }
        int read = this.c.read(this.b, 0, this.b.length);
        if (read > 0 && this.d != null) {
            this.d.onRecordBuffer(this.b, 0, read);
            return read;
        } else if (read >= 0) {
            return read;
        } else {
            cb.c("Record read data error: " + read);
            throw new SpeechError(20006);
        }
    }

    private void b() {
        synchronized (this) {
            try {
                if (this.c != null) {
                    cb.a("release record begin");
                    this.c.release();
                    this.c = null;
                    if (this.e != null) {
                        this.e.onRecordReleased();
                        this.e = null;
                    }
                    cb.a("release record over");
                }
            } catch (Exception e2) {
                cb.c(e2.toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(short s, int i2, int i3) throws SpeechError {
        if (this.c != null) {
            b();
        }
        int i4 = (i3 * i2) / 1000;
        int i5 = (((i4 * 4) * 16) * s) / 8;
        int i6 = s == 1 ? 2 : 3;
        int minBufferSize = AudioRecord.getMinBufferSize(i2, i6, 2);
        if (i5 < minBufferSize) {
            i5 = minBufferSize;
        }
        AudioRecord audioRecord = new AudioRecord(this.l, i2, i6, 2, i5);
        this.c = audioRecord;
        this.b = new byte[(((s * i4) * 16) / 8)];
        cb.a("\nSampleRate:" + i2 + "\nChannel:" + i6 + "\nFormat:" + 2 + "\nFramePeriod:" + i4 + "\nBufferSize:" + i5 + "\nMinBufferSize:" + minBufferSize + "\nActualBufferSize:" + this.b.length + "\n");
        if (this.c.getState() != 1) {
            cb.a("create AudioRecord error");
            throw new SpeechError(20006);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        b();
        super.finalize();
    }

    public void run() {
        boolean z;
        int i2;
        int i3 = 0;
        while (true) {
            try {
                z = true;
                if (this.f) {
                    break;
                }
                a(1, this.i, this.j);
                break;
            } catch (Exception unused) {
                i2++;
                if (i2 < 10) {
                    sleep(40);
                } else {
                    throw new SpeechError(20006);
                }
            } catch (Exception unused2) {
                i3++;
                if (i3 < 10) {
                    sleep(40);
                } else {
                    throw new SpeechError(20006);
                }
            } catch (Exception e2) {
                cb.a((Throwable) e2);
                if (this.d != null) {
                    this.d.onError(new SpeechError(20006));
                }
            }
        }
        i2 = 0;
        while (true) {
            if (this.f) {
                break;
            }
            this.c.startRecording();
            if (this.c.getRecordingState() != 3) {
                throw new SpeechError(20006);
            }
        }
        if (this.d != null) {
            this.d.onRecordStarted(true);
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (!this.f) {
            int a2 = a();
            if (z) {
                this.g += (double) a2;
                this.h += a(this.b, this.b.length);
                if (System.currentTimeMillis() - currentTimeMillis >= 1000) {
                    if (this.g != 0.0d) {
                        if (this.h != 0.0d) {
                            z = false;
                        }
                    }
                    cb.c("cannot get record permission, get invalid audio data.");
                    throw new SpeechError(20006);
                }
            }
            if (this.b.length > a2) {
                cb.b("current record read size is less than buffer size: " + a2);
                sleep((long) this.k);
            }
        }
        b();
    }

    public void startRecording(PcmRecordListener pcmRecordListener) throws SpeechError {
        this.d = pcmRecordListener;
        setPriority(10);
        start();
    }

    public void stopRecord(boolean z) {
        this.f = true;
        if (this.e == null) {
            this.e = this.d;
        }
        this.d = null;
        if (z) {
            synchronized (this) {
                try {
                    cb.a("stopRecord...release");
                    if (this.c != null) {
                        if (3 == this.c.getRecordingState() && 1 == this.c.getState()) {
                            cb.a("stopRecord releaseRecording ing...");
                            this.c.release();
                            cb.a("stopRecord releaseRecording end...");
                            this.c = null;
                        }
                        if (this.e != null) {
                            this.e.onRecordReleased();
                            this.e = null;
                        }
                    }
                } catch (Exception e2) {
                    cb.c(e2.toString());
                }
            }
        }
        cb.a("stop record");
    }
}
