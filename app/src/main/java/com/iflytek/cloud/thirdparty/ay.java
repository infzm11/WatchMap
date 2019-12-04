package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.record.PcmRecorder;
import com.iflytek.cloud.record.a;
import com.iflytek.cloud.thirdparty.be;
import com.iflytek.cloud.util.AudioDetector;
import java.io.IOException;

public class ay extends ax {
    private AudioDetector A;
    private byte[] B;
    boolean q;
    private int z = 16000;

    public ay(Context context, ce ceVar, HandlerThread handlerThread) {
        super(context, ceVar, handlerThread);
        int i = 16000;
        String str = null;
        this.A = null;
        this.q = false;
        this.B = null;
        ce x = x();
        this.z = x != null ? x.a("sample_rate", 16000) : i;
        x.a("vad_enable", "0", true);
        this.A = AudioDetector.getDetector();
        if (this.A == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("sample_rate");
            stringBuffer.append("=");
            stringBuffer.append(this.z);
            String b = x.b(AudioDetector.VAD_ENGINE, AudioDetector.TYPE_META);
            stringBuffer.append(",");
            stringBuffer.append(AudioDetector.VAD_ENGINE);
            stringBuffer.append("=");
            stringBuffer.append(b);
            str = x != null ? x.e(AudioDetector.RES_PATH) : str;
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(",");
                stringBuffer.append(AudioDetector.RES_PATH);
                stringBuffer.append("=");
                stringBuffer.append(str);
            }
            this.A = AudioDetector.createDetector(context, stringBuffer.toString());
        }
        this.A.setParameter("vad_bos", Integer.toString(this.r > 0 ? this.r : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        String b2 = x.b("vad_eos", Integer.toString(cg.b((be) this)));
        cb.a("meta vad eos on recog: " + b2);
        this.A.setParameter("vad_eos", b2);
        this.A.setParameter(SpeechConstant.KEY_SPEECH_TIMEOUT, Integer.toString(this.r));
    }

    private void E() throws Exception {
        if (SpeechUtility.getUtility() != null) {
            this.o.a("app_ssb");
            cb.a("begin session");
            i();
            return;
        }
        cb.c("not init while begin session");
        b(new SpeechError(20015));
    }

    private byte[] a(byte[] bArr) throws Exception {
        if (this.A != null) {
            byte[] bArr2 = null;
            int min = Math.min(32768, bArr.length);
            AudioDetector.DetectorResult detectorResult = null;
            int i = 0;
            int i2 = 0;
            boolean z2 = false;
            while (min > 0) {
                detectorResult = this.A.detect(bArr, i, min, false);
                if (detectorResult.error != 0) {
                    throw new SpeechError(detectorResult.error);
                }
                if (3 == detectorResult.status) {
                    this.A.reset();
                } else if (detectorResult.status == 0) {
                    continue;
                } else {
                    if (!this.q) {
                        i2 = Math.max(i2, i - this.B.length);
                        this.q = true;
                        cb.a("detectAudioData find start and begin session");
                        E();
                        z2 = true;
                    }
                    if (1 != detectorResult.status) {
                        break;
                    }
                }
                i += min;
                min = Math.min(32768, bArr.length - i);
            }
            if (detectorResult != null) {
                a(bArr, detectorResult.volume);
            }
            if (detectorResult == null || !this.q) {
                int min2 = Math.min(this.B.length, bArr.length);
                System.arraycopy(this.B, min2, this.B, 0, this.B.length - min2);
                System.arraycopy(bArr, bArr.length - min2, this.B, this.B.length - min2, min2);
            } else {
                if (z2) {
                    byte[] bArr3 = new byte[((bArr.length - i2) + this.B.length)];
                    if (this.B.length <= i2) {
                        System.arraycopy(bArr, i2 - this.B.length, bArr3, 0, bArr3.length);
                    } else {
                        System.arraycopy(this.B, i2, bArr3, 0, this.B.length - i2);
                        System.arraycopy(bArr, 0, bArr3, this.B.length - i2, bArr.length);
                    }
                    bArr2 = bArr3;
                } else {
                    bArr2 = bArr;
                }
                if (2 == detectorResult.status || 4 == detectorResult.status) {
                    cb.a("detectAudioData find eos or timeout");
                    l();
                    return bArr2;
                }
            }
            return bArr2;
        }
        throw new SpeechError(22001);
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, boolean z2) throws SpeechError {
        if (!this.c) {
            this.c = true;
            this.o.a("app_fau");
            if (this.a != null) {
                this.a.onEvent(22002, 0, 0, (Bundle) null);
            }
        }
        this.h.a(bArr, bArr.length);
    }

    /* access modifiers changed from: protected */
    public void b(Message message) throws Exception {
        byte[] bArr = (byte[]) message.obj;
        if (bArr != null && bArr.length != 0) {
            byte[] a = a(bArr);
            if (a != null) {
                this.m.add(a);
                a(a, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void h() throws Exception {
        cb.a("start connecting");
        String e = x().e("engine_type");
        if (x().a(SpeechConstant.NET_CHECK, true)) {
            if ("cloud".equals(e)) {
                bz.a(this.t);
            } else if ("mixed".equals(e) || "mixed".equals(e)) {
                try {
                    bz.a(this.t);
                } catch (Exception unused) {
                    x().a("engine_type", "local");
                }
            }
        }
        int a = x().a("record_read_rate", 40);
        a(be.b.recording);
        int i = ((300 * this.z) * 2) / 1000;
        cb.a("MscRecognizerMeta last buffer len: " + i);
        this.B = new byte[i];
        if (this.f != -1 && v()) {
            cb.a("start  record");
            if (this.f == -2) {
                this.i = new a(t(), a, this.f, x().e(SpeechConstant.ASR_SOURCE_PATH));
            } else {
                this.i = new PcmRecorder(t(), a, this.f);
                if (hasMessages(3)) {
                    throw new SpeechError(10118);
                }
            }
            this.o.a("rec_open");
            this.i.startRecording(this);
            this.r = x().a(SpeechConstant.KEY_SPEECH_TIMEOUT, -1);
            if (-1 != this.r) {
                a(9, be.a.normal, false, this.r);
            }
        }
        if (this.a != null && this.f > -1) {
            this.a.onBeginOfSpeech();
        }
        if (this.A == null) {
            throw new SpeechError(21003);
        }
        this.A.reset();
    }

    /* access modifiers changed from: protected */
    public void j() throws SpeechError, IOException, InterruptedException {
        if (this.q) {
            this.o.a("app_lau");
            this.h.a();
            p();
            return;
        }
        cb.a("exit with no speech audio");
        b((SpeechError) null);
    }
}
