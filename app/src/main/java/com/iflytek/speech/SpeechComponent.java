package com.iflytek.speech;

import android.text.TextUtils;
import com.iflytek.cloud.thirdparty.cb;
import java.util.ArrayList;
import java.util.Iterator;

public final class SpeechComponent {
    private ArrayList<String> mEngines = new ArrayList<>();
    private String mPackageName = "";

    public SpeechComponent(String str) {
        if (str != null) {
            this.mPackageName = str;
        }
    }

    public void addEngine(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mEngines.add(str);
        }
    }

    public ArrayList<String> getEngines() {
        return this.mEngines;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public boolean isEngineAvaible(String str) {
        if (TextUtils.isEmpty(str) || this.mEngines.size() == 0) {
            return false;
        }
        Iterator<String> it = this.mEngines.iterator();
        while (it.hasNext()) {
            try {
                if (it.next().contains(str)) {
                    return true;
                }
            } catch (Exception e) {
                cb.a((Throwable) e);
            }
        }
        return false;
    }
}
