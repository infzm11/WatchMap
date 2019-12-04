package com.iflytek.sdk.client;

import com.iflytek.clientadapter.aidl.Music;
import java.util.List;

public abstract class CustomMusicClient {
    public static final int MODE_ALL_CIRCLE = 4100;
    public static final int MODE_ALL_ORDER = 4098;
    public static final int MODE_ALL_RANDOM = 4099;
    public static final int MODE_SINGLE_CIRCLE = 4097;
    public static final int SEARCH_MODE_ALL = 1;
    public static final int SEARCH_MODE_LOCAL = 2;
    public static final int SEARCH_MODE_ONLINE = 3;

    public abstract boolean changeVolume(int i);

    public abstract boolean close();

    public abstract boolean collect(Music music);

    public abstract boolean download(Music music);

    public abstract Music getCurrentMusic();

    public abstract int getStatus();

    public abstract boolean isRunning();

    public abstract boolean open();

    public abstract boolean palyNext();

    public abstract boolean pause();

    public abstract boolean play(String str);

    public abstract boolean play(List<Music> list);

    public abstract boolean playPrevious();

    public abstract boolean resume();

    public abstract List<Music> search(String str, String str2, String str3, int i);

    public abstract boolean showDeskLyrics(boolean z);

    public abstract boolean stop();

    public abstract boolean switchPlayMode(int i);
}
