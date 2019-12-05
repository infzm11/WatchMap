package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRouteSearch;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.WalkRouteResult;
import com.iflytek.cloud.SpeechUtility;

/* compiled from: RouteSearchCore */
public class au implements IRouteSearch {
    /* access modifiers changed from: private */
    public RouteSearch.OnRouteSearchListener a;
    private Context b;
    /* access modifiers changed from: private */
    public Handler c = q.a();

    public au(Context context) {
        this.b = context.getApplicationContext();
    }

    public void setRouteSearchListener(RouteSearch.OnRouteSearchListener onRouteSearchListener) {
        this.a = onRouteSearchListener;
    }

    public WalkRouteResult calculateWalkRoute(RouteSearch.WalkRouteQuery walkRouteQuery) throws AMapException {
        try {
            o.a(this.b);
            if (walkRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (!a(walkRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                RouteSearch.WalkRouteQuery clone = walkRouteQuery.clone();
                WalkRouteResult walkRouteResult = (WalkRouteResult) new ag(this.b, clone).c();
                if (walkRouteResult != null) {
                    walkRouteResult.setWalkQuery(clone);
                }
                return walkRouteResult;
            }
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculateWalkRoute");
            throw e;
        }
    }

    public void calculateWalkRouteAsyn(final RouteSearch.WalkRouteQuery walkRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.what = 102;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    WalkRouteResult walkRouteResult = null;
                    try {
                        WalkRouteResult calculateWalkRoute = au.this.calculateWalkRoute(walkRouteQuery);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, calculateWalkRoute);
                        } catch (AMapException e) {
                            WalkRouteResult walkRouteResult2 = calculateWalkRoute;
                            e = e;
                            walkRouteResult = walkRouteResult2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, walkRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, walkRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            WalkRouteResult walkRouteResult3 = calculateWalkRoute;
                            th = th2;
                            walkRouteResult = walkRouteResult3;
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, walkRouteResult);
                            obtainMessage.setData(bundle);
                            au.this.c.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (AMapException e2) {
                        e = e2;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        obtainMessage.obj = au.this.a;
                        bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, walkRouteResult);
                        obtainMessage.setData(bundle);
                        au.this.c.sendMessage(obtainMessage);
                    }
                    obtainMessage.setData(bundle);
                    au.this.c.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateWalkRouteAsyn");
        }
    }

    public BusRouteResult calculateBusRoute(RouteSearch.BusRouteQuery busRouteQuery) throws AMapException {
        try {
            o.a(this.b);
            if (busRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (!a(busRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                RouteSearch.BusRouteQuery clone = busRouteQuery.clone();
                BusRouteResult busRouteResult = (BusRouteResult) new c(this.b, clone).c();
                if (busRouteResult != null) {
                    busRouteResult.setBusQuery(clone);
                }
                return busRouteResult;
            }
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculateBusRoute");
            throw e;
        }
    }

    public void calculateBusRouteAsyn(final RouteSearch.BusRouteQuery busRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.what = 100;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    BusRouteResult busRouteResult = null;
                    try {
                        BusRouteResult calculateBusRoute = au.this.calculateBusRoute(busRouteQuery);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, calculateBusRoute);
                        } catch (AMapException e) {
                            BusRouteResult busRouteResult2 = calculateBusRoute;
                            e = e;
                            busRouteResult = busRouteResult2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, busRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, busRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            BusRouteResult busRouteResult3 = calculateBusRoute;
                            th = th2;
                            busRouteResult = busRouteResult3;
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, busRouteResult);
                            obtainMessage.setData(bundle);
                            au.this.c.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (AMapException e2) {
                        e = e2;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        obtainMessage.obj = au.this.a;
                        bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, busRouteResult);
                        obtainMessage.setData(bundle);
                        au.this.c.sendMessage(obtainMessage);
                    }
                    obtainMessage.setData(bundle);
                    au.this.c.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateBusRouteAsyn");
        }
    }

    public DriveRouteResult calculateDriveRoute(RouteSearch.DriveRouteQuery driveRouteQuery) throws AMapException {
        try {
            o.a(this.b);
            if (driveRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (!a(driveRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                RouteSearch.DriveRouteQuery clone = driveRouteQuery.clone();
                DriveRouteResult driveRouteResult = (DriveRouteResult) new k(this.b, clone).c();
                if (driveRouteResult != null) {
                    driveRouteResult.setDriveQuery(clone);
                }
                return driveRouteResult;
            }
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculateDriveRoute");
            throw e;
        }
    }

    public void calculateDriveRouteAsyn(final RouteSearch.DriveRouteQuery driveRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.what = 101;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    DriveRouteResult driveRouteResult = null;
                    try {
                        DriveRouteResult calculateDriveRoute = au.this.calculateDriveRoute(driveRouteQuery);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, calculateDriveRoute);
                        } catch (AMapException e) {
                            DriveRouteResult driveRouteResult2 = calculateDriveRoute;
                            e = e;
                            driveRouteResult = driveRouteResult2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, driveRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, driveRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            DriveRouteResult driveRouteResult3 = calculateDriveRoute;
                            th = th2;
                            driveRouteResult = driveRouteResult3;
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, driveRouteResult);
                            obtainMessage.setData(bundle);
                            au.this.c.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (AMapException e2) {
                        e = e2;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        obtainMessage.obj = au.this.a;
                        bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, driveRouteResult);
                        obtainMessage.setData(bundle);
                        au.this.c.sendMessage(obtainMessage);
                    }
                    obtainMessage.setData(bundle);
                    au.this.c.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateDriveRouteAsyn");
        }
    }

    private boolean a(RouteSearch.FromAndTo fromAndTo) {
        if (fromAndTo == null || fromAndTo.getFrom() == null || fromAndTo.getTo() == null) {
            return false;
        }
        return true;
    }

    public void calculateRideRouteAsyn(final RouteSearch.RideRouteQuery rideRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    Message obtainMessage = q.a().obtainMessage();
                    obtainMessage.what = 103;
                    obtainMessage.arg1 = 1;
                    Bundle bundle = new Bundle();
                    RideRouteResult rideRouteResult = null;
                    try {
                        RideRouteResult calculateRideRoute = au.this.calculateRideRoute(rideRouteQuery);
                        try {
                            bundle.putInt(MyLocationStyle.ERROR_CODE, 1000);
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, calculateRideRoute);
                        } catch (AMapException e) {
                            RideRouteResult rideRouteResult2 = calculateRideRoute;
                            e = e;
                            rideRouteResult = rideRouteResult2;
                            try {
                                bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, rideRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                            } catch (Throwable th) {
                                th = th;
                                obtainMessage.obj = au.this.a;
                                bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, rideRouteResult);
                                obtainMessage.setData(bundle);
                                au.this.c.sendMessage(obtainMessage);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            RideRouteResult rideRouteResult3 = calculateRideRoute;
                            th = th2;
                            rideRouteResult = rideRouteResult3;
                            obtainMessage.obj = au.this.a;
                            bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, rideRouteResult);
                            obtainMessage.setData(bundle);
                            au.this.c.sendMessage(obtainMessage);
                            throw th;
                        }
                    } catch (AMapException e2) {
                        e = e2;
                        bundle.putInt(MyLocationStyle.ERROR_CODE, e.getErrorCode());
                        obtainMessage.obj = au.this.a;
                        bundle.putParcelable(SpeechUtility.TAG_RESOURCE_RESULT, rideRouteResult);
                        obtainMessage.setData(bundle);
                        au.this.c.sendMessage(obtainMessage);
                    }
                    obtainMessage.setData(bundle);
                    au.this.c.sendMessage(obtainMessage);
                }
            }.start();
        } catch (Throwable th) {
            i.a(th, "RouteSearch", "calculateRideRouteAsyn");
        }
    }

    public RideRouteResult calculateRideRoute(RouteSearch.RideRouteQuery rideRouteQuery) throws AMapException {
        try {
            o.a(this.b);
            if (rideRouteQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else if (!a(rideRouteQuery.getFromAndTo())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } else {
                RouteSearch.RideRouteQuery clone = rideRouteQuery.clone();
                RideRouteResult rideRouteResult = (RideRouteResult) new ab(this.b, clone).c();
                if (rideRouteResult != null) {
                    rideRouteResult.setRideQuery(clone);
                }
                return rideRouteResult;
            }
        } catch (AMapException e) {
            i.a(e, "RouteSearch", "calculaterideRoute");
            throw e;
        }
    }
}
