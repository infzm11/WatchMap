package com.iflytek.clientadapter.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.iflytek.clientadapter.aidl.IATtsListener;

public interface ITtsSvc extends IInterface {

    public static abstract class Stub extends Binder implements ITtsSvc {
        private static final String DESCRIPTOR = "com.iflytek.clientadapter.aidl.ITtsSvc";
        static final int TRANSACTION_create = 1;
        static final int TRANSACTION_destroy = 7;
        static final int TRANSACTION_pause = 5;
        static final int TRANSACTION_resume = 6;
        static final int TRANSACTION_setParam = 2;
        static final int TRANSACTION_startSpeak = 3;
        static final int TRANSACTION_stop = 4;

        private static class Proxy implements ITtsSvc {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int create(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setParam(String str, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int startSpeak(String str, String str2, IATtsListener iATtsListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(iATtsListener != null ? iATtsListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stop(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int pause(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int resume(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int destroy(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITtsSvc asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof ITtsSvc)) {
                return new Proxy(iBinder);
            }
            return (ITtsSvc) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        int create = create(parcel.readString(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(create);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        int param = setParam(parcel.readString(), parcel.readInt(), parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(param);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        int startSpeak = startSpeak(parcel.readString(), parcel.readString(), IATtsListener.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startSpeak);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        int stop = stop(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(stop);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        int pause = pause(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(pause);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        int resume = resume(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(resume);
                        return true;
                    case 7:
                        parcel.enforceInterface(DESCRIPTOR);
                        int destroy = destroy(parcel.readString());
                        parcel2.writeNoException();
                        parcel2.writeInt(destroy);
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    int create(String str, int i) throws RemoteException;

    int destroy(String str) throws RemoteException;

    int pause(String str) throws RemoteException;

    int resume(String str) throws RemoteException;

    int setParam(String str, int i, int i2) throws RemoteException;

    int startSpeak(String str, String str2, IATtsListener iATtsListener) throws RemoteException;

    int stop(String str) throws RemoteException;
}
