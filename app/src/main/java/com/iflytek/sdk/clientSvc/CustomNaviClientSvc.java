package com.iflytek.sdk.clientSvc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.iflytek.clientadapter.aidl.INaviClientSvc;
import com.iflytek.clientadapter.aidl.PoiInfo;
import com.iflytek.clientadapter.aidl.RouteInfo;
import com.iflytek.sdk.client.CustomNaviClient;
import java.util.List;

public class CustomNaviClientSvc extends Service {
    private static final String TAG = "CustomNaviClientSvc";
    /* access modifiers changed from: private */
    public static CustomNaviClient naviClient;
    private INaviClientSvc.Stub serviceBinder = new INaviClientSvc.Stub() {
        public boolean showTraffic(boolean z) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.showTraffic(z);
            }
            return false;
        }

        public boolean showPoi(PoiInfo poiInfo) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.showPoi(poiInfo);
            }
            return false;
        }

        public boolean setHomePoi(PoiInfo poiInfo) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.setHomePoi(poiInfo);
            }
            return false;
        }

        public boolean setCompanyPoi(PoiInfo poiInfo) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.setCompanyPoi(poiInfo);
            }
            return false;
        }

        public List<PoiInfo> searchByRoute(String str, int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.searchByRoute(str, i);
            }
            return null;
        }

        public List<PoiInfo> search(String str, PoiInfo poiInfo, int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.search(str, poiInfo, i);
            }
            return null;
        }

        public boolean open() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.open();
            }
            return false;
        }

        public boolean close() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.close();
            }
            return false;
        }

        public boolean changeScale(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.changeScale(i);
            }
            return false;
        }

        public boolean changeMode(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.changeMode(i);
            }
            return false;
        }

        public boolean changeView(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.changeView(i);
            }
            return false;
        }

        public PoiInfo getCurrentPoi() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getCurrentPoi();
            }
            return null;
        }

        public PoiInfo getHomePoi() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getHomePoi();
            }
            return null;
        }

        public PoiInfo getCompanyPoi() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getCompanyPoi();
            }
            return null;
        }

        public RouteInfo getCurrentRouteInfo() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getCurrentRouteInfo();
            }
            return null;
        }

        public boolean previewRoute() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.previewRoute();
            }
            return false;
        }

        public boolean replanRoute(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.replanRoute(i);
            }
            return false;
        }

        public boolean cancelNavigation() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.cancelNavigation();
            }
            return false;
        }

        public boolean routeSimulateNavigation(RouteInfo routeInfo) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.simulateNavigation(routeInfo);
            }
            return false;
        }

        public int getSurplusTime() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getTimeLeft();
            }
            return 0;
        }

        public int getSurplusDistance() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.getDistanceLeft();
            }
            return 0;
        }

        public boolean changeVolume(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.changeVolume(i);
            }
            return false;
        }

        public boolean changeReportMode(int i) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.changeMode(i);
            }
            return false;
        }

        public boolean isNavigationGuide() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.isNavigationGuide();
            }
            return false;
        }

        public void clearPoiInfo() throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                CustomNaviClientSvc.naviClient.clearPoiInfo();
            }
        }

        public List<RouteInfo> planRoute(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.planRoute(poiInfo, poiInfo2, list);
            }
            return null;
        }

        public boolean routeNavigate(RouteInfo routeInfo) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.navigate(routeInfo);
            }
            return false;
        }

        public boolean poiNavigate(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.navigate(poiInfo, poiInfo2, list);
            }
            return false;
        }

        public boolean poiSimulateNavigation(PoiInfo poiInfo, PoiInfo poiInfo2, List<PoiInfo> list) throws RemoteException {
            if (CustomNaviClientSvc.naviClient != null) {
                return CustomNaviClientSvc.naviClient.simulateNavigation(poiInfo, poiInfo2, list);
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

    public static void setNaviClient(CustomNaviClient customNaviClient) {
        naviClient = customNaviClient;
    }
}
