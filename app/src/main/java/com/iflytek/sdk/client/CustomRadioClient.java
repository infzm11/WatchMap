package com.iflytek.sdk.client;

import com.iflytek.clientadapter.aidl.Radio;
import java.util.List;

public abstract class CustomRadioClient {
    public static final int MODE_ALL_CIRCLE = 4100;
    public static final int MODE_ALL_ORDER = 4098;
    public static final int MODE_ALL_RANDOM = 4099;
    public static final int MODE_SINGLE_CIRCLE = 4097;

    public abstract boolean changeVolume(int i);

    public abstract boolean close();

    public abstract boolean collect(Radio radio);

    public abstract boolean download(Radio radio);

    public abstract Radio getCurrentRadio();

    public abstract int getStatus();

    public abstract boolean open();

    public abstract boolean palyNext();

    public abstract boolean pause();

    public abstract boolean play(String str);

    public abstract boolean play(List<Radio> list);

    public abstract boolean playPrevious();

    public abstract boolean resume();

    public abstract List<Radio> search(String str, boolean z);

    public abstract boolean stop();

    public abstract boolean switchPlayMode(int i);
}
