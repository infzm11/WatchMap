package com.iflytek.cloud.thirdparty;

import android.os.Bundle;
import android.util.Log;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.alsa.AlsaRecorder;

public class l extends j implements AlsaRecorder.PcmListener {
    private int c = 2;
    private int d = 96000;
    private int e = 1536;
    private AlsaRecorder f;

    public l(k kVar) {
        super(kVar);
    }

    private void e() {
        this.c = ac.a(AIUIConstant.AUDIO_CAPTOR_ALSA, AIUIConstant.KEY_SOUND_CARD, 2);
        this.d = ac.a(AIUIConstant.AUDIO_CAPTOR_ALSA, AIUIConstant.KEY_CARD_SAMPLE_RATE, 96000);
        this.e = ac.a(AIUIConstant.AUDIO_CAPTOR_ALSA, "period_size", this.e);
        this.f = AlsaRecorder.createInstance(this.c, this.d, this.e);
        this.f.setBufferSize(12288);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        if (d()) {
            cb.a("AlsaAudioCaptor", "AlsaAudioCaptor was already started.");
            return 0;
        }
        e();
        int startRecording = this.f != null ? this.f.startRecording(this) : -1;
        if (startRecording == 0) {
            this.a = true;
            if (this.b != null) {
                this.b.a();
            }
            cb.a("AlsaAudioCaptor", "AlsaAudioCaptor started.");
            return startRecording;
        }
        Log.e("AlsaAudioCaptor", "AlsaAudioCaptor start error, error=" + 20006);
        return 20006;
    }

    public void c() {
        if (!d()) {
            Log.e("AlsaAudioCaptor", "AlsaAudioCaptor was not started.");
            return;
        }
        if (this.f != null) {
            this.f.stopRecording();
            this.f.destroy();
            this.a = false;
            if (this.b != null) {
                this.b.b();
            }
        }
        cb.a("AlsaAudioCaptor", "AlsaAudioCaptor stopped.");
    }

    public void onPcmData(byte[] bArr, int i) {
        if (this.b != null) {
            this.b.a(bArr, i, (Bundle) null);
        }
    }
}
