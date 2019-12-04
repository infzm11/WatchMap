package com.iflytek.clientadapter.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IHmiSvc extends IInterface {

    public static abstract class Stub extends Binder implements IHmiSvc {
        private static final String DESCRIPTOR = "com.iflytek.clientadapter.aidl.IHmiSvc";
        static final int TRANSACTION_cancelInteraction = 7;
        static final int TRANSACTION_cancelSelector = 9;
        static final int TRANSACTION_doAction = 17;
        static final int TRANSACTION_getVersionInfo = 18;
        static final int TRANSACTION_inCommingCall = 11;
        static final int TRANSACTION_init = 1;
        static final int TRANSACTION_isInitComplete = 3;
        static final int TRANSACTION_listSelectResult = 5;
        static final int TRANSACTION_selectContactItem = 10;
        static final int TRANSACTION_selectNaviItem = 13;
        static final int TRANSACTION_setAllowInteraction = 4;
        static final int TRANSACTION_setApplication = 16;
        static final int TRANSACTION_setCallState = 12;
        static final int TRANSACTION_setHmiKeyWords = 14;
        static final int TRANSACTION_setOneShotState = 15;
        static final int TRANSACTION_speakEnd = 8;
        static final int TRANSACTION_startInteraction = 6;
        static final int TRANSACTION_syncSysData = 2;

        private static class Proxy implements IHmiSvc {
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

            public int init(IAHmiListener iAHmiListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iAHmiListener != null ? iAHmiListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void syncSysData(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeStringArray(strArr);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int isInitComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAllowInteraction(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void listSelectResult(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void startInteraction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelInteraction() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void speakEnd() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void cancelSelector() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void selectContactItem(ContactEntity contactEntity) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (contactEntity != null) {
                        obtain.writeInt(1);
                        contactEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void inCommingCall(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCallState(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void selectNaviItem(PoiInfo poiInfo, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setHmiKeyWords(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setOneShotState(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int setApplication(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void doAction(ActionModel actionModel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (actionModel != null) {
                        obtain.writeInt(1);
                        actionModel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getVersionInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
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

        public static IHmiSvc asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IHmiSvc)) {
                return new Proxy(iBinder);
            }
            return (IHmiSvc) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.iflytek.clientadapter.aidl.ContactEntity} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.iflytek.clientadapter.aidl.ActionModel} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: type inference failed for: r0v12 */
        /* JADX WARNING: type inference failed for: r0v13 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
            /*
                r2 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r3 == r0) goto L_0x0164
                r0 = 0
                switch(r3) {
                    case 1: goto L_0x014c;
                    case 2: goto L_0x0138;
                    case 3: goto L_0x0128;
                    case 4: goto L_0x0118;
                    case 5: goto L_0x0108;
                    case 6: goto L_0x00fc;
                    case 7: goto L_0x00f0;
                    case 8: goto L_0x00e4;
                    case 9: goto L_0x00d8;
                    case 10: goto L_0x00bd;
                    case 11: goto L_0x00ad;
                    case 12: goto L_0x009d;
                    case 13: goto L_0x007e;
                    case 14: goto L_0x006a;
                    case 15: goto L_0x0056;
                    case 16: goto L_0x003a;
                    case 17: goto L_0x001f;
                    case 18: goto L_0x000f;
                    default: goto L_0x000a;
                }
            L_0x000a:
                boolean r3 = super.onTransact(r3, r4, r5, r6)
                return r3
            L_0x000f:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                java.lang.String r3 = r2.getVersionInfo()
                r5.writeNoException()
                r5.writeString(r3)
                return r1
            L_0x001f:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x0033
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.ActionModel> r3 = com.iflytek.clientadapter.aidl.ActionModel.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                com.iflytek.clientadapter.aidl.ActionModel r0 = (com.iflytek.clientadapter.aidl.ActionModel) r0
            L_0x0033:
                r2.doAction(r0)
                r5.writeNoException()
                return r1
            L_0x003a:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                int r6 = r4.readInt()
                java.lang.String r4 = r4.readString()
                int r3 = r2.setApplication(r3, r6, r4)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0056:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                int r3 = r2.setOneShotState(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x006a:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                java.lang.String r3 = r4.readString()
                int r3 = r2.setHmiKeyWords(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x007e:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x0092
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r3 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                com.iflytek.clientadapter.aidl.PoiInfo r0 = (com.iflytek.clientadapter.aidl.PoiInfo) r0
            L_0x0092:
                int r3 = r4.readInt()
                r2.selectNaviItem(r0, r3)
                r5.writeNoException()
                return r1
            L_0x009d:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                r2.setCallState(r3)
                r5.writeNoException()
                return r1
            L_0x00ad:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                java.lang.String r3 = r4.readString()
                r2.inCommingCall(r3)
                r5.writeNoException()
                return r1
            L_0x00bd:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                if (r3 == 0) goto L_0x00d1
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.ContactEntity> r3 = com.iflytek.clientadapter.aidl.ContactEntity.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r4)
                r0 = r3
                com.iflytek.clientadapter.aidl.ContactEntity r0 = (com.iflytek.clientadapter.aidl.ContactEntity) r0
            L_0x00d1:
                r2.selectContactItem(r0)
                r5.writeNoException()
                return r1
            L_0x00d8:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                r2.cancelSelector()
                r5.writeNoException()
                return r1
            L_0x00e4:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                r2.speakEnd()
                r5.writeNoException()
                return r1
            L_0x00f0:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                r2.cancelInteraction()
                r5.writeNoException()
                return r1
            L_0x00fc:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                r2.startInteraction()
                r5.writeNoException()
                return r1
            L_0x0108:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                r2.listSelectResult(r3)
                r5.writeNoException()
                return r1
            L_0x0118:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r4.readInt()
                r2.setAllowInteraction(r3)
                r5.writeNoException()
                return r1
            L_0x0128:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                int r3 = r2.isInitComplete()
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0138:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                java.lang.String r3 = r4.readString()
                java.lang.String[] r4 = r4.createStringArray()
                r2.syncSysData(r3, r4)
                r5.writeNoException()
                return r1
            L_0x014c:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r4.enforceInterface(r3)
                android.os.IBinder r3 = r4.readStrongBinder()
                com.iflytek.clientadapter.aidl.IAHmiListener r3 = com.iflytek.clientadapter.aidl.IAHmiListener.Stub.asInterface(r3)
                int r3 = r2.init(r3)
                r5.writeNoException()
                r5.writeInt(r3)
                return r1
            L_0x0164:
                java.lang.String r3 = "com.iflytek.clientadapter.aidl.IHmiSvc"
                r5.writeString(r3)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.aidl.IHmiSvc.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void cancelInteraction() throws RemoteException;

    void cancelSelector() throws RemoteException;

    void doAction(ActionModel actionModel) throws RemoteException;

    String getVersionInfo() throws RemoteException;

    void inCommingCall(String str) throws RemoteException;

    int init(IAHmiListener iAHmiListener) throws RemoteException;

    int isInitComplete() throws RemoteException;

    void listSelectResult(int i) throws RemoteException;

    void selectContactItem(ContactEntity contactEntity) throws RemoteException;

    void selectNaviItem(PoiInfo poiInfo, int i) throws RemoteException;

    void setAllowInteraction(int i) throws RemoteException;

    int setApplication(int i, int i2, String str) throws RemoteException;

    void setCallState(int i) throws RemoteException;

    int setHmiKeyWords(String str) throws RemoteException;

    int setOneShotState(int i) throws RemoteException;

    void speakEnd() throws RemoteException;

    void startInteraction() throws RemoteException;

    void syncSysData(String str, String[] strArr) throws RemoteException;
}
