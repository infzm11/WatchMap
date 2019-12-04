package com.iflytek.sdk.clientSvc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.IMusicClientSvc;
import com.iflytek.clientadapter.aidl.Music;
import com.iflytek.sdk.client.CustomMusicClient;
import java.util.List;

public class CustomMusicClientSvc extends Service {
    private static final String TAG = "CustomMusicClientSvc";
    /* access modifiers changed from: private */
    public static CustomMusicClient musicClient;
    private IMusicClientSvc.Stub serviceBinder = new IMusicClientSvc.Stub() {
        public boolean switchPlayMode(int i) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.switchPlayMode(i);
            }
            return false;
        }

        public boolean stop() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.stop();
            }
            return false;
        }

        public boolean showDeskLyrics(boolean z) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.showDeskLyrics(z);
            }
            return false;
        }

        public List<Music> search(String str, String str2, String str3, int i) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.search(str, str2, str3, i);
            }
            return null;
        }

        public boolean resume() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.resume();
            }
            return false;
        }

        public boolean playPrevious() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.playPrevious();
            }
            return false;
        }

        public boolean play2(List<Music> list) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.play(list);
            }
            return false;
        }

        public boolean play(String str) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.play(str);
            }
            return false;
        }

        public boolean pause() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.pause();
            }
            return false;
        }

        public boolean palyNext() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.palyNext();
            }
            return false;
        }

        public boolean open() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.open();
            }
            return false;
        }

        public boolean isRunning() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.isRunning();
            }
            return false;
        }

        public int getStatus() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.getStatus();
            }
            return -1;
        }

        public Music getCurrentMusic() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.getCurrentMusic();
            }
            return null;
        }

        public boolean download(Music music) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.download(music);
            }
            return false;
        }

        public boolean collect(Music music) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.collect(music);
            }
            return false;
        }

        public boolean close() throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.close();
            }
            return false;
        }

        public boolean changeVolume(int i) throws RemoteException {
            if (CustomMusicClientSvc.musicClient != null) {
                return CustomMusicClientSvc.musicClient.changeVolume(i);
            }
            return false;
        }
    };

    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return this.serviceBinder;
    }

    public void onCreate() {
        Log.d(TAG, "onCreate");
        super.onCreate();
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    public void onRebind(Intent intent) {
        Log.d(TAG, "onRebind");
        super.onRebind(intent);
    }

    public void onStart(Intent intent, int i) {
        Log.d(TAG, "onStart");
        super.onStart(intent, i);
    }

    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    public static void setMusicClient(CustomMusicClient customMusicClient) {
        musicClient = customMusicClient;
    }
}
