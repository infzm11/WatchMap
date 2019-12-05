package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import com.iflytek.cloud.SpeechUtility;
import java.util.ArrayList;

/* compiled from: InputtipsSearchCore */
public class aq implements IInputtipsSearch {
    private Context a;
    /* access modifiers changed from: private */
    public Inputtips.InputtipsListener b;
    /* access modifiers changed from: private */
    public Handler c = q.a();
    /* access modifiers changed from: private */
    public InputtipsQuery d;

    public aq(Context context, Inputtips.InputtipsListener inputtipsListener) {
        this.a = context.getApplicationContext();
        this.b = inputtipsListener;
    }

    public aq(Context context, InputtipsQuery inputtipsQuery) {
        this.a = context.getApplicationContext();
        this.d = inputtipsQuery;
    }

    public InputtipsQuery getQuery() {
        return this.d;
    }

    public void setQuery(InputtipsQuery inputtipsQuery) {
        this.d = inputtipsQuery;
    }

    public void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.b = inputtipsListener;
    }

    public void requestInputtipsAsyn() {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.obj = aq.this.b;
                    obtainMessage.arg1 = 5;
                    try {
                        ArrayList a2 = aq.this.a(aq.this.d);
                        Bundle bundle = new Bundle();
                        bundle.putParcelableArrayList(SpeechUtility.TAG_RESOURCE_RESULT, a2);
                        obtainMessage.setData(bundle);
                        obtainMessage.what = 1000;
                    } catch (AMapException e) {
                        obtainMessage.what = e.getErrorCode();
                    } catch (Throwable th) {
                        aq.this.c.sendMessage(obtainMessage);
                        throw th;
                    }
                    aq.this.c.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    public ArrayList<Tip> requestInputtips() throws AMapException {
        return a(this.d);
    }

    public void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, (String) null);
    }

    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str == null || str.equals("")) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        this.d = new InputtipsQuery(str, str2);
        this.d.setType(str3);
        requestInputtipsAsyn();
    }

    /* access modifiers changed from: private */
    public ArrayList<Tip> a(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            o.a(this.a);
            if (inputtipsQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (inputtipsQuery.getKeyword() != null) {
                if (!inputtipsQuery.getKeyword().equals("")) {
                    return (ArrayList) new m(this.a, inputtipsQuery).c();
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            i.a(th, "Inputtips", "requestInputtips");
            if (!(th instanceof AMapException)) {
                return null;
            }
            throw ((AMapException) th);
        }
    }
}
