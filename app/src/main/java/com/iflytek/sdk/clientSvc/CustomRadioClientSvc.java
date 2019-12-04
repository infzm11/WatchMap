package com.iflytek.sdk.clientSvc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.IRadioClientSvc;
import com.iflytek.clientadapter.aidl.Radio;
import com.iflytek.sdk.client.CustomRadioClient;
import java.util.List;

public class CustomRadioClientSvc extends Service {
    private static final String TAG = "RadioAnotherClientSvc";
    /* access modifiers changed from: private */
    public static CustomRadioClient mRadioAnotherClient;
    private IRadioClientSvc.Stub serviceBinder = new IRadioClientSvc.Stub() {
        public boolean open() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.open();
            }
            return false;
        }

        public boolean close() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.close();
            }
            return false;
        }

        public List<Radio> search(String str, boolean z) throws RemoteException {
            Log.d(CustomRadioClientSvc.TAG, "search --- ");
            if (CustomRadioClientSvc.mRadioAnotherClient == null) {
                return null;
            }
            Log.d(CustomRadioClientSvc.TAG, "search");
            return CustomRadioClientSvc.mRadioAnotherClient.search(str, z);
        }

        public boolean download(Radio radio) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.download(radio);
            }
            return false;
        }

        public boolean collect(Radio radio) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.collect(radio);
            }
            return false;
        }

        public boolean play(String str) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.play(str);
            }
            return false;
        }

        public boolean play2(List<Radio> list) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.play(list);
            }
            return false;
        }

        public boolean pause() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.pause();
            }
            return false;
        }

        public boolean resume() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.resume();
            }
            return false;
        }

        public boolean stop() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.stop();
            }
            return false;
        }

        public boolean palyNext() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.palyNext();
            }
            return false;
        }

        public boolean playPrevious() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.playPrevious();
            }
            return false;
        }

        public boolean switchPlayMode(int i) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.switchPlayMode(i);
            }
            return false;
        }

        public boolean changeVolume(int i) throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.changeVolume(i);
            }
            return false;
        }

        public int getStatus() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.getStatus();
            }
            return -1;
        }

        public Radio getCurrentRadio() throws RemoteException {
            if (CustomRadioClientSvc.mRadioAnotherClient != null) {
                return CustomRadioClientSvc.mRadioAnotherClient.getCurrentRadio();
            }
            return null;
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

    public static void setmRadioAnotherClient(CustomRadioClient customRadioClient) {
        Log.d(TAG, "setmRadioAnotherClient");
        mRadioAnotherClient = customRadioClient;
    }
}
