package com.iflytek.speech.aidl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.speech.SpeechUnderstanderListener;

public interface ISpeechUnderstander extends IInterface {

    public static abstract class Stub extends Binder implements ISpeechUnderstander {
        private static final String DESCRIPTOR = "com.iflytek.speech.aidl.ISpeechUnderstander";
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_isUnderstanding = 4;
        static final int TRANSACTION_startUnderstanding = 1;
        static final int TRANSACTION_stopUnderstanding = 2;
        static final int TRANSACTION_writeAudio = 5;

        private static class Proxy implements ISpeechUnderstander {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void cancel(SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(speechUnderstanderListener != null ? speechUnderstanderListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public boolean isUnderstanding() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startUnderstanding(Intent intent, SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(speechUnderstanderListener != null ? speechUnderstanderListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopUnderstanding(SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(speechUnderstanderListener != null ? speechUnderstanderListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void writeAudio(Intent intent, byte[] bArr, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISpeechUnderstander asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISpeechUnderstander)) ? new Proxy(iBinder) : (ISpeechUnderstander) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.content.Intent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
            /*
                r2 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r3 == r0) goto L_0x0091
                r0 = 0
                switch(r3) {
                    case 1: goto L_0x006e;
                    case 2: goto L_0x005a;
                    case 3: goto L_0x0046;
                    case 4: goto L_0x0036;
                    case 5: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r3 = super.onTransact(r3, r4, r5, r6)
                return r3
            L_0x000f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x0023
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x0023:
                byte[] r3 = r4.createByteArray()
                int r6 = r4.readInt()
                int r4 = r4.readInt()
                r2.writeAudio(r0, r3, r6, r4)
                r5.writeNoException()
                return r1
            L_0x0036:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r4.enforceInterface(r3)
                boolean r3 = r2.isUnderstanding()
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0046:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SpeechUnderstanderListener r3 = com.iflytek.speech.SpeechUnderstanderListener.Stub.asInterface(r3)
                r2.cancel(r3)
                r5.writeNoException()
                return r1
            L_0x005a:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SpeechUnderstanderListener r3 = com.iflytek.speech.SpeechUnderstanderListener.Stub.asInterface(r3)
                r2.stopUnderstanding(r3)
                r5.writeNoException()
                return r1
            L_0x006e:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x0082
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x0082:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SpeechUnderstanderListener r3 = com.iflytek.speech.SpeechUnderstanderListener.Stub.asInterface(r3)
                r2.startUnderstanding(r0, r3)
                r5.writeNoException()
                return r1
            L_0x0091:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechUnderstander"
                r5.writeString(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.speech.aidl.ISpeechUnderstander.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void cancel(SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException;

    boolean isUnderstanding() throws RemoteException;

    void startUnderstanding(Intent intent, SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException;

    void stopUnderstanding(SpeechUnderstanderListener speechUnderstanderListener) throws RemoteException;

    void writeAudio(Intent intent, byte[] bArr, int i, int i2) throws RemoteException;
}
