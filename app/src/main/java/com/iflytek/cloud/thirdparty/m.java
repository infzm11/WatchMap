package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.util.Log;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.record.PcmRecorder;

public class m extends j implements PcmRecorder.PcmRecordListener {
    private int c = 16000;
    private PcmRecorder d;

    public m(k kVar) {
        super(kVar);
    }

    private void e() {
        this.c = ac.a("iat", "sample_rate", 16000);
        this.d = new PcmRecorder(this.c, 40);
    }

    public int a() {
        return this.c;
    }

    public int b() {
        if (d()) {
            cb.a("SystemAudioCaptor", "SingleAudioCaptor was already started.");
            return 0;
        }
        e();
        if (this.d == null) {
            return 0;
        }
        try {
            this.d.startRecording(this);
            return 0;
        } catch (SpeechError e) {
            e.printStackTrace();
            int errorCode = e.getErrorCode();
            Log.e("SystemAudioCaptor", "SingleAudioCaptor start error, error=" + errorCode);
            return errorCode;
        }
    }

    public void c() {
        if (d() && this.d != null) {
            this.d.stopRecord(true);
        }
    }

    public void onError(SpeechError speechError) {
        if (this.b != null) {
            this.b.a(speechError.getErrorCode(), speechError.getErrorDescription());
        }
        Log.e("SystemAudioCaptor", "SingleAudioCaptor error, error=" + speechError.getErrorCode());
    }

    public void onRecordBuffer(byte[] bArr, int i, int i2) {
        if (this.b != null) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            this.b.a(bArr2, i2, (Bundle) null);
        }
    }

    public void onRecordReleased() {
        this.a = false;
        if (this.b != null) {
            this.b.b();
        }
        cb.a("SystemAudioCaptor", "SingleAudioCaptor stopped.");
    }

    public void onRecordStarted(boolean z) {
        if (z) {
            this.a = true;
            if (this.b != null) {
                this.b.a();
            }
            cb.a("SystemAudioCaptor", "SingleAudioCaptor started.");
        }
    }
}
