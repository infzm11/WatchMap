package com.iflytek.clientadapter.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface INaviClientSvc extends IInterface {

    public static abstract class Stub extends Binder implements INaviClientSvc {
        private static final String DESCRIPTOR = "com.iflytek.clientadapter.aidl.INaviClientSvc";
        static final int TRANSACTION_cancelNavigation = 21;
        static final int TRANSACTION_changeMode = 4;
        static final int TRANSACTION_changeReportMode = 27;
        static final int TRANSACTION_changeScale = 3;
        static final int TRANSACTION_changeView = 5;
        static final int TRANSACTION_changeVolume = 26;
        static final int TRANSACTION_clearPoiInfo = 29;
        static final int TRANSACTION_close = 2;
        static final int TRANSACTION_getCompanyPoi = 12;
        static final int TRANSACTION_getCurrentPoi = 7;
        static final int TRANSACTION_getCurrentRouteInfo = 15;
        static final int TRANSACTION_getHomePoi = 10;
        static final int TRANSACTION_getSurplusDistance = 25;
        static final int TRANSACTION_getSurplusTime = 24;
        static final int TRANSACTION_isNavigationGuide = 28;
        static final int TRANSACTION_open = 1;
        static final int TRANSACTION_planRoute = 17;
        static final int TRANSACTION_poiNavigate = 19;
        static final int TRANSACTION_poiSimulateNavigation = 23;
        static final int TRANSACTION_previewRoute = 16;
        static final int TRANSACTION_replanRoute = 20;
        static final int TRANSACTION_routeNavigate = 18;
        static final int TRANSACTION_routeSimulateNavigation = 22;
        static final int TRANSACTION_search = 13;
        static final int TRANSACTION_searchByRoute = 14;
        static final int TRANSACTION_setCompanyPoi = 11;
        static final int TRANSACTION_setHomePoi = 9;
        static final int TRANSACTION_showPoi = 8;
        static final int TRANSACTION_showTraffic = 6;

        private static class Proxy implements INaviClientSvc {
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

            public boolean open() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

            public boolean close() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(2, obtain, obtain2, 0);
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

            public boolean changeScale(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(3, obtain, obtain2, 0);
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

            public boolean changeMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
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

            public boolean changeView(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(5, obtain, obtain2, 0);
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

            public boolean showTraffic(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    boolean z2 = false;
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PoiInfo getCurrentPoi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PoiInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean showPoi(PoiInfo poiInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setHomePoi(PoiInfo poiInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PoiInfo getHomePoi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PoiInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setCompanyPoi(PoiInfo poiInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PoiInfo getCompanyPoi() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? PoiInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PoiInfo> search(String str, PoiInfo poiInfo, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PoiInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public List<PoiInfo> searchByRoute(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PoiInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public RouteInfo getCurrentRouteInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? RouteInfo.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean previewRoute() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(16, obtain, obtain2, 0);
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

            public List<RouteInfo> planRoute(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
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
                    if (poiInfo2 != null) {
                        obtain.writeInt(1);
                        poiInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(RouteInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean routeNavigate(RouteInfo routeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (routeInfo != null) {
                        obtain.writeInt(1);
                        routeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean poiNavigate(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (poiInfo2 != null) {
                        obtain.writeInt(1);
                        poiInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean replanRoute(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(20, obtain, obtain2, 0);
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

            public boolean cancelNavigation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(21, obtain, obtain2, 0);
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

            public boolean routeSimulateNavigation(RouteInfo routeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (routeInfo != null) {
                        obtain.writeInt(1);
                        routeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean poiSimulateNavigation(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = true;
                    if (poiInfo != null) {
                        obtain.writeInt(1);
                        poiInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (poiInfo2 != null) {
                        obtain.writeInt(1);
                        poiInfo2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.mRemote.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSurplusTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int getSurplusDistance() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean changeVolume(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(26, obtain, obtain2, 0);
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

            public boolean changeReportMode(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    boolean z = false;
                    this.mRemote.transact(27, obtain, obtain2, 0);
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

            public boolean isNavigationGuide() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z = false;
                    this.mRemote.transact(28, obtain, obtain2, 0);
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

            public void clearPoiInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
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

        public static INaviClientSvc asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof INaviClientSvc)) {
                return new Proxy(iBinder);
            }
            return (INaviClientSvc) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: com.iflytek.clientadapter.aidl.RouteInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: com.iflytek.clientadapter.aidl.RouteInfo} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: com.iflytek.clientadapter.aidl.PoiInfo} */
        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v28 */
        /* JADX WARNING: type inference failed for: r2v29 */
        /* JADX WARNING: type inference failed for: r2v30 */
        /* JADX WARNING: type inference failed for: r2v31 */
        /* JADX WARNING: type inference failed for: r2v32 */
        /* JADX WARNING: type inference failed for: r2v33 */
        /* JADX WARNING: type inference failed for: r2v34 */
        /* JADX WARNING: type inference failed for: r2v35 */
        /* JADX WARNING: type inference failed for: r2v36 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r1 = 1
                if (r4 == r0) goto L_0x02f8
                r0 = 0
                r2 = 0
                switch(r4) {
                    case 1: goto L_0x02e8;
                    case 2: goto L_0x02d8;
                    case 3: goto L_0x02c4;
                    case 4: goto L_0x02b0;
                    case 5: goto L_0x029c;
                    case 6: goto L_0x0285;
                    case 7: goto L_0x026c;
                    case 8: goto L_0x024d;
                    case 9: goto L_0x022e;
                    case 10: goto L_0x0215;
                    case 11: goto L_0x01f6;
                    case 12: goto L_0x01dd;
                    case 13: goto L_0x01b6;
                    case 14: goto L_0x019e;
                    case 15: goto L_0x0185;
                    case 16: goto L_0x0175;
                    case 17: goto L_0x0140;
                    case 18: goto L_0x0121;
                    case 19: goto L_0x00ec;
                    case 20: goto L_0x00d8;
                    case 21: goto L_0x00c8;
                    case 22: goto L_0x00a9;
                    case 23: goto L_0x0074;
                    case 24: goto L_0x0064;
                    case 25: goto L_0x0054;
                    case 26: goto L_0x0040;
                    case 27: goto L_0x002c;
                    case 28: goto L_0x001c;
                    case 29: goto L_0x0010;
                    default: goto L_0x000b;
                }
            L_0x000b:
                boolean r4 = super.onTransact(r4, r5, r6, r7)
                return r4
            L_0x0010:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                r3.clearPoiInfo()
                r6.writeNoException()
                return r1
            L_0x001c:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                boolean r4 = r3.isNavigationGuide()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x002c:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.changeReportMode(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0040:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.changeVolume(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0054:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r3.getSurplusDistance()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0064:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r3.getSurplusTime()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0074:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0088
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = (com.iflytek.clientadapter.aidl.PoiInfo) r4
                goto L_0x0089
            L_0x0088:
                r4 = r2
            L_0x0089:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0098
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r5)
                r2 = r7
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x0098:
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.util.ArrayList r5 = r5.createTypedArrayList(r7)
                boolean r4 = r3.poiSimulateNavigation(r4, r2, r5)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x00a9:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x00bd
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.RouteInfo> r4 = com.iflytek.clientadapter.aidl.RouteInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                com.iflytek.clientadapter.aidl.RouteInfo r2 = (com.iflytek.clientadapter.aidl.RouteInfo) r2
            L_0x00bd:
                boolean r4 = r3.routeSimulateNavigation(r2)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x00c8:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                boolean r4 = r3.cancelNavigation()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x00d8:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.replanRoute(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x00ec:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0100
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = (com.iflytek.clientadapter.aidl.PoiInfo) r4
                goto L_0x0101
            L_0x0100:
                r4 = r2
            L_0x0101:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0110
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r5)
                r2 = r7
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x0110:
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.util.ArrayList r5 = r5.createTypedArrayList(r7)
                boolean r4 = r3.poiNavigate(r4, r2, r5)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0121:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0135
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.RouteInfo> r4 = com.iflytek.clientadapter.aidl.RouteInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                com.iflytek.clientadapter.aidl.RouteInfo r2 = (com.iflytek.clientadapter.aidl.RouteInfo) r2
            L_0x0135:
                boolean r4 = r3.routeNavigate(r2)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0140:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0154
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = (com.iflytek.clientadapter.aidl.PoiInfo) r4
                goto L_0x0155
            L_0x0154:
                r4 = r2
            L_0x0155:
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x0164
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r5)
                r2 = r7
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x0164:
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.util.ArrayList r5 = r5.createTypedArrayList(r7)
                java.util.List r4 = r3.planRoute(r4, r2, r5)
                r6.writeNoException()
                r6.writeTypedList(r4)
                return r1
            L_0x0175:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                boolean r4 = r3.previewRoute()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0185:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                com.iflytek.clientadapter.aidl.RouteInfo r4 = r3.getCurrentRouteInfo()
                r6.writeNoException()
                if (r4 == 0) goto L_0x019a
                r6.writeInt(r1)
                r4.writeToParcel(r6, r1)
                goto L_0x019d
            L_0x019a:
                r6.writeInt(r0)
            L_0x019d:
                return r1
            L_0x019e:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r5 = r5.readInt()
                java.util.List r4 = r3.searchByRoute(r4, r5)
                r6.writeNoException()
                r6.writeTypedList(r4)
                return r1
            L_0x01b6:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                java.lang.String r4 = r5.readString()
                int r7 = r5.readInt()
                if (r7 == 0) goto L_0x01ce
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r7 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r7 = r7.createFromParcel(r5)
                r2 = r7
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x01ce:
                int r5 = r5.readInt()
                java.util.List r4 = r3.search(r4, r2, r5)
                r6.writeNoException()
                r6.writeTypedList(r4)
                return r1
            L_0x01dd:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = r3.getCompanyPoi()
                r6.writeNoException()
                if (r4 == 0) goto L_0x01f2
                r6.writeInt(r1)
                r4.writeToParcel(r6, r1)
                goto L_0x01f5
            L_0x01f2:
                r6.writeInt(r0)
            L_0x01f5:
                return r1
            L_0x01f6:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x020a
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x020a:
                boolean r4 = r3.setCompanyPoi(r2)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x0215:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = r3.getHomePoi()
                r6.writeNoException()
                if (r4 == 0) goto L_0x022a
                r6.writeInt(r1)
                r4.writeToParcel(r6, r1)
                goto L_0x022d
            L_0x022a:
                r6.writeInt(r0)
            L_0x022d:
                return r1
            L_0x022e:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0242
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x0242:
                boolean r4 = r3.setHomePoi(r2)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x024d:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0261
                android.os.Parcelable$Creator<com.iflytek.clientadapter.aidl.PoiInfo> r4 = com.iflytek.clientadapter.aidl.PoiInfo.CREATOR
                java.lang.Object r4 = r4.createFromParcel(r5)
                r2 = r4
                com.iflytek.clientadapter.aidl.PoiInfo r2 = (com.iflytek.clientadapter.aidl.PoiInfo) r2
            L_0x0261:
                boolean r4 = r3.showPoi(r2)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x026c:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                com.iflytek.clientadapter.aidl.PoiInfo r4 = r3.getCurrentPoi()
                r6.writeNoException()
                if (r4 == 0) goto L_0x0281
                r6.writeInt(r1)
                r4.writeToParcel(r6, r1)
                goto L_0x0284
            L_0x0281:
                r6.writeInt(r0)
            L_0x0284:
                return r1
            L_0x0285:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                if (r4 == 0) goto L_0x0291
                r0 = r1
            L_0x0291:
                boolean r4 = r3.showTraffic(r0)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x029c:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.changeView(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x02b0:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.changeMode(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x02c4:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                int r4 = r5.readInt()
                boolean r4 = r3.changeScale(r4)
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x02d8:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                boolean r4 = r3.close()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x02e8:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r5.enforceInterface(r4)
                boolean r4 = r3.open()
                r6.writeNoException()
                r6.writeInt(r4)
                return r1
            L_0x02f8:
                java.lang.String r4 = "com.iflytek.clientadapter.aidl.INaviClientSvc"
                r6.writeString(r4)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.aidl.INaviClientSvc.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    boolean cancelNavigation() throws RemoteException;

    boolean changeMode(int i) throws RemoteException;

    boolean changeReportMode(int i) throws RemoteException;

    boolean changeScale(int i) throws RemoteException;

    boolean changeView(int i) throws RemoteException;

    boolean changeVolume(int i) throws RemoteException;

    void clearPoiInfo() throws RemoteException;

    boolean close() throws RemoteException;

    PoiInfo getCompanyPoi() throws RemoteException;

    PoiInfo getCurrentPoi() throws RemoteException;

    RouteInfo getCurrentRouteInfo() throws RemoteException;

    PoiInfo getHomePoi() throws RemoteException;

    int getSurplusDistance() throws RemoteException;

    int getSurplusTime() throws RemoteException;

    boolean isNavigationGuide() throws RemoteException;

    boolean open() throws RemoteException;

    List<RouteInfo> planRoute(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException;

    boolean poiNavigate(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException;

    boolean poiSimulateNavigation(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException;

    boolean previewRoute() throws RemoteException;

    boolean replanRoute(int i) throws RemoteException;

    boolean routeNavigate(RouteInfo routeInfo) throws RemoteException;

    boolean routeSimulateNavigation(RouteInfo routeInfo) throws RemoteException;

    List<PoiInfo> search(String str, PoiInfo poiInfo, int i) throws RemoteException;

    List<PoiInfo> searchByRoute(String str, int i) throws RemoteException;

    boolean setCompanyPoi(PoiInfo poiInfo) throws RemoteException;

    boolean setHomePoi(PoiInfo poiInfo) throws RemoteException;

    boolean showPoi(PoiInfo poiInfo) throws RemoteException;

    boolean showTraffic(boolean z) throws RemoteException;
}
