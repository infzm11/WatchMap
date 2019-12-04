package com.iflytek.speech;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.speech.aidl.ISpeechSynthesizer;

public class SpeechSynthesizerAidl extends SpeechModuleAidl<ISpeechSynthesizer> {
    public SpeechSynthesizerAidl(Context context, InitListener initListener) {
        super(context, initListener, UtilityConfig.ACTION_SPEECH_SYNTHESIZER);
    }

    public boolean destory() {
        this.mService = null;
        return super.destory();
    }

    public /* bridge */ /* synthetic */ Intent getIntent() {
        return super.getIntent();
    }

    public String getParameter(String str) {
        if (!str.equals(SpeechConstant.LOCAL_SPEAKERS)) {
            return super.getParameter(str);
        }
        try {
            if (SpeechUtility.getUtility() == null) {
                return null;
            }
            int serviceVersion = SpeechUtility.getUtility().getServiceVersion();
            if (serviceVersion < 44) {
                return null;
            }
            if (serviceVersion < 10000 || serviceVersion >= 10013) {
                return ((ISpeechSynthesizer) this.mService).getLocalSpeakerList();
            }
            return null;
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return "20999";
        }
    }

    public /* bridge */ /* synthetic */ boolean isActionInstalled(Context context, String str) {
        return super.isActionInstalled(context, str);
    }

    public /* bridge */ /* synthetic */ boolean isAvailable() {
        return super.isAvailable();
    }

    public boolean isSpeaking() {
        try {
            if (this.mService != null) {
                return ((ISpeechSynthesizer) this.mService).isSpeaking();
            }
        } catch (RemoteException e) {
            cb.a((Throwable) e);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
        return false;
    }

    public int pauseSpeaking(SynthesizerListener synthesizerListener) {
        if (this.mService == null) {
            return 21003;
        }
        if (synthesizerListener == null) {
            return 20012;
        }
        try {
            return ((ISpeechSynthesizer) this.mService).pauseSpeaking(synthesizerListener);
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return 21004;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 21004;
        }
    }

    public int resumeSpeaking(SynthesizerListener synthesizerListener) {
        if (this.mService == null) {
            return 21003;
        }
        if (synthesizerListener == null) {
            return 20012;
        }
        try {
            return ((ISpeechSynthesizer) this.mService).resumeSpeaking(synthesizerListener);
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return 21004;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 21004;
        }
    }

    public int setParameter(String str, String str2) {
        return super.setParameter(str, str2);
    }

    public int startSpeaking(String str, SynthesizerListener synthesizerListener) {
        if (this.mService == null) {
            return 21003;
        }
        if (synthesizerListener == null) {
            return 20012;
        }
        try {
            Intent intent = getIntent();
            intent.putExtra("text", str);
            return ((ISpeechSynthesizer) this.mService).startSpeaking(intent, synthesizerListener);
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return 21004;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 21004;
        }
    }

    public int stopSpeaking(SynthesizerListener synthesizerListener) {
        if (this.mService == null) {
            return 21003;
        }
        if (synthesizerListener == null) {
            return 20012;
        }
        try {
            return ((ISpeechSynthesizer) this.mService).stopSpeaking(synthesizerListener);
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return 21004;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 21004;
        }
    }

    public int synthesizeToUrl(String str, SynthesizerListener synthesizerListener) {
        if (this.mService == null) {
            return 21003;
        }
        if (synthesizerListener == null) {
            return 20012;
        }
        try {
            Intent intent = getIntent();
            intent.putExtra("text", str);
            return ((ISpeechSynthesizer) this.mService).synthesizeToUrl(intent, synthesizerListener);
        } catch (RemoteException e) {
            cb.a((Throwable) e);
            return 21004;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 21004;
        }
    }
}
