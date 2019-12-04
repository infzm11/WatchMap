package com.iflytek.speech.aidl;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.speech.GrammarListener;
import com.iflytek.speech.LexiconListener;
import com.iflytek.speech.RecognizerListener;

public interface ISpeechRecognizer extends IInterface {

    public static abstract class Stub extends Binder implements ISpeechRecognizer {
        private static final String DESCRIPTOR = "com.iflytek.speech.aidl.ISpeechRecognizer";
        static final int TRANSACTION_buildGrammar = 5;
        static final int TRANSACTION_cancel = 3;
        static final int TRANSACTION_isListening = 4;
        static final int TRANSACTION_startListening = 1;
        static final int TRANSACTION_stopListening = 2;
        static final int TRANSACTION_updateLexicon = 6;
        static final int TRANSACTION_writeAudio = 7;

        private static class Proxy implements ISpeechRecognizer {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public void buildGrammar(Intent intent, GrammarListener grammarListener) throws RemoteException {
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
                    obtain.writeStrongBinder(grammarListener != null ? grammarListener.asBinder() : null);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancel(RecognizerListener recognizerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(recognizerListener != null ? recognizerListener.asBinder() : null);
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

            public boolean isListening() throws RemoteException {
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

            public void startListening(Intent intent, RecognizerListener recognizerListener) throws RemoteException {
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
                    obtain.writeStrongBinder(recognizerListener != null ? recognizerListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void stopListening(RecognizerListener recognizerListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(recognizerListener != null ? recognizerListener.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void updateLexicon(Intent intent, LexiconListener lexiconListener) throws RemoteException {
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
                    obtain.writeStrongBinder(lexiconListener != null ? lexiconListener.asBinder() : null);
                    this.mRemote.transact(6, obtain, obtain2, 0);
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
                    this.mRemote.transact(7, obtain, obtain2, 0);
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

        public static ISpeechRecognizer asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISpeechRecognizer)) ? new Proxy(iBinder) : (ISpeechRecognizer) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: android.content.Intent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: android.content.Intent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
            /*
                r2 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r3 == r0) goto L_0x00d7
                r0 = 0
                switch(r3) {
                    case 1: goto L_0x00b4;
                    case 2: goto L_0x00a0;
                    case 3: goto L_0x008c;
                    case 4: goto L_0x007c;
                    case 5: goto L_0x0059;
                    case 6: goto L_0x0036;
                    case 7: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r3 = super.onTransact(r3, r4, r5, r6)
                return r3
            L_0x000f:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
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
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x004a
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x004a:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.LexiconListener r3 = com.iflytek.speech.LexiconListener.Stub.asInterface(r3)
                r2.updateLexicon(r0, r3)
                r5.writeNoException()
                return r1
            L_0x0059:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x006d
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x006d:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.GrammarListener r3 = com.iflytek.speech.GrammarListener.Stub.asInterface(r3)
                r2.buildGrammar(r0, r3)
                r5.writeNoException()
                return r1
            L_0x007c:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                boolean r3 = r2.isListening()
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x008c:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.RecognizerListener r3 = com.iflytek.speech.RecognizerListener.Stub.asInterface(r3)
                r2.cancel(r3)
                r5.writeNoException()
                return r1
            L_0x00a0:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.RecognizerListener r3 = com.iflytek.speech.RecognizerListener.Stub.asInterface(r3)
                r2.stopListening(r3)
                r5.writeNoException()
                return r1
            L_0x00b4:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x00c8
                android.os.Parcelable$Creator r3 = android.content.Intent.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                android.content.Intent r0 = (android.content.Intent) r0
            L_0x00c8:
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.speech.RecognizerListener r3 = com.iflytek.speech.RecognizerListener.Stub.asInterface(r3)
                r2.startListening(r0, r3)
                r5.writeNoException()
                return r1
            L_0x00d7:
                java.lang.String r3 = "com.iflytek.speech.aidl.ISpeechRecognizer"
                r5.writeString(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.speech.aidl.ISpeechRecognizer.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void buildGrammar(Intent intent, GrammarListener grammarListener) throws RemoteException;

    void cancel(RecognizerListener recognizerListener) throws RemoteException;

    boolean isListening() throws RemoteException;

    void startListening(Intent intent, RecognizerListener recognizerListener) throws RemoteException;

    void stopListening(RecognizerListener recognizerListener) throws RemoteException;

    void updateLexicon(Intent intent, LexiconListener lexiconListener) throws RemoteException;

    void writeAudio(Intent intent, byte[] bArr, int i, int i2) throws RemoteException;
}
