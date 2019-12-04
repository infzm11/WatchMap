package com.iflytek.speech;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface SpeechUnderstanderListener extends IInterface {

    public static abstract class Stub extends Binder implements SpeechUnderstanderListener {
        private static final String DESCRIPTOR = "com.iflytek.speech.SpeechUnderstanderListener";
        static final int TRANSACTION_onBeginOfSpeech = 2;
        static final int TRANSACTION_onEndOfSpeech = 3;
        static final int TRANSACTION_onError = 5;
        static final int TRANSACTION_onEvent = 6;
        static final int TRANSACTION_onResult = 4;
        static final int TRANSACTION_onVolumeChanged = 1;

        private static class Proxy implements SpeechUnderstanderListener {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public void onBeginOfSpeech() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onEndOfSpeech() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onError(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onEvent(int i, int i2, int i3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(6, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onResult(UnderstanderResult understanderResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (understanderResult != null) {
                        obtain.writeInt(1);
                        understanderResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onVolumeChanged(int i, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeByteArray(bArr);
                    this.mRemote.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SpeechUnderstanderListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof SpeechUnderstanderListener)) ? new Proxy(iBinder) : (SpeechUnderstanderListener) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.iflytek.speech.UnderstanderResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: android.os.Bundle} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v9 */
        /* JADX WARNING: type inference failed for: r0v10 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r4 == r0) goto L_0x007b
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x006a;
                    case 2: goto L_0x0061;
                    case 3: goto L_0x0058;
                    case 4: goto L_0x0040;
                    case 5: goto L_0x0033;
                    case 6: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x000f:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                int r6 = r5.readInt()
                int r7 = r5.readInt()
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x002f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r5 = r0.createFromParcel(r5)
                r0 = r5
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x002f:
                r3.onEvent(r4, r6, r7, r0)
                return r1
            L_0x0033:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                r3.onError(r4)
                return r1
            L_0x0040:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.iflytek.speech.UnderstanderResult> r4 = com.iflytek.speech.UnderstanderResult.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r0 = r4
                com.iflytek.speech.UnderstanderResult r0 = (com.iflytek.speech.UnderstanderResult) r0
            L_0x0054:
                r3.onResult(r0)
                return r1
            L_0x0058:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                r3.onEndOfSpeech()
                return r1
            L_0x0061:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                r3.onBeginOfSpeech()
                return r1
            L_0x006a:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                byte[] r5 = r5.createByteArray()
                r3.onVolumeChanged(r4, r5)
                return r1
            L_0x007b:
                java.lang.String r4 = "com.iflytek.speech.SpeechUnderstanderListener"
                r6.writeString(r4)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.speech.SpeechUnderstanderListener.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onBeginOfSpeech() throws RemoteException;

    void onEndOfSpeech() throws RemoteException;

    void onError(int i) throws RemoteException;

    void onEvent(int i, int i2, int i3, Bundle bundle) throws RemoteException;

    void onResult(UnderstanderResult understanderResult) throws RemoteException;

    void onVolumeChanged(int i, byte[] bArr) throws RemoteException;
}
