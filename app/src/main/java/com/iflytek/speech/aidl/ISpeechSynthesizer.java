package com.iflytek.speech.aidl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.speech.SynthesizerListener;

public interface ISpeechSynthesizer extends IInterface {

    public static abstract class Stub extends Binder implements ISpeechSynthesizer {
        private static final String DESCRIPTOR = "com.iflytek.speech.aidl.ISpeechSynthesizer";
        static final int TRANSACTION_getLocalSpeakerList = 7;
        static final int TRANSACTION_isSpeaking = 6;
        static final int TRANSACTION_pauseSpeaking = 3;
        static final int TRANSACTION_resumeSpeaking = 4;
        static final int TRANSACTION_startSpeaking = 2;
        static final int TRANSACTION_stopSpeaking = 5;
        static final int TRANSACTION_synthesizeToUrl = 1;

        private static class Proxy implements ISpeechSynthesizer {
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

            public String getLocalSpeakerList() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isSpeaking() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
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

            public int pauseSpeaking(SynthesizerListener synthesizerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(synthesizerListener != null ? synthesizerListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int resumeSpeaking(SynthesizerListener synthesizerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(synthesizerListener != null ? synthesizerListener.asBinder() : null);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startSpeaking(Intent intent, SynthesizerListener synthesizerListener) throws RemoteException {
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
                    obtain.writeStrongBinder(synthesizerListener != null ? synthesizerListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stopSpeaking(SynthesizerListener synthesizerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(synthesizerListener != null ? synthesizerListener.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int synthesizeToUrl(Intent intent, SynthesizerListener synthesizerListener) throws RemoteException {
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
                    obtain.writeStrongBinder(synthesizerListener != null ? synthesizerListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISpeechSynthesizer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISpeechSynthesizer)) ? new Proxy(iBinder) : (ISpeechSynthesizer) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.content.Intent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
            /*
                r2 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r3 == r0) goto L_0x00c5
                r0 = 0
                switch(r3) {
                    case 1: goto L_0x009e;
                    case 2: goto L_0x0077;
                    case 3: goto L_0x005f;
                    case 4: goto L_0x0047;
                    case 5: goto L_0x002f;
                    case 6: goto L_0x001f;
                    case 7: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r3 = super.onTransact(r3, r4, r5, r6)
                return r3
            L_0x000f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                java.lang.String r3 = r2.getLocalSpeakerList()
                r5.writeNoException()
                r5.writeString(r3)
                return r1
            L_0x001f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                boolean r3 = r2.isSpeaking()
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x002f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SynthesizerListener r3 = com.iflytek.speech.SynthesizerListener.Stub.asInterface(r3)
                int r3 = r2.stopSpeaking(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0047:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SynthesizerListener r3 = com.iflytek.speech.SynthesizerListener.Stub.asInterface(r3)
                int r3 = r2.resumeSpeaking(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x005f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SynthesizerListener r3 = com.iflytek.speech.SynthesizerListener.Stub.asInterface(r3)
                int r3 = r2.pauseSpeaking(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0077:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x008b
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x008b:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SynthesizerListener r3 = com.iflytek.speech.SynthesizerListener.Stub.asInterface(r3)
                int r3 = r2.startSpeaking(r0, r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x009e:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x00b2
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x00b2:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.SynthesizerListener r3 = com.iflytek.speech.SynthesizerListener.Stub.asInterface(r3)
                int r3 = r2.synthesizeToUrl(r0, r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x00c5:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechSynthesizer"
                r5.writeString(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.speech.aidl.ISpeechSynthesizer.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    String getLocalSpeakerList() throws RemoteException;

    boolean isSpeaking() throws RemoteException;

    int pauseSpeaking(SynthesizerListener synthesizerListener) throws RemoteException;

    int resumeSpeaking(SynthesizerListener synthesizerListener) throws RemoteException;

    int startSpeaking(Intent intent, SynthesizerListener synthesizerListener) throws RemoteException;

    int stopSpeaking(SynthesizerListener synthesizerListener) throws RemoteException;

    int synthesizeToUrl(Intent intent, SynthesizerListener synthesizerListener) throws RemoteException;
}
