package com.amap.api.services.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* compiled from: ShareSearchCore */
public class av implements IShareSearch {
    private static String b = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";
    private static String c = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";
    private static String d = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";
    private static String e = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";
    private static final String f = String.valueOf("");
    private Context a;
    /* access modifiers changed from: private */
    public ShareSearch.OnShareSearchListener g;

    public av(Context context) {
        this.a = context;
    }

    public void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.g = onShareSearchListener;
    }

    public void searchPoiShareUrlAsyn(final PoiItem poiItem) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_ERROR;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchPoiShareUrl = av.this.searchPoiShareUrl(poiItem);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchPoiShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchBusRouteShareUrlAsyn(final ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchBusRouteShareUrl = av.this.searchBusRouteShareUrl(shareBusRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchBusRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchWalkRouteShareUrlAsyn(final ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1105;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchWalkRouteShareUrl = av.this.searchWalkRouteShareUrl(shareWalkRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchDrivingRouteShareUrlAsyn(final ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = 1104;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchDrivingRouteShareUrl = av.this.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchNaviShareUrlAsyn(final ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchNaviShareUrl = av.this.searchNaviShareUrl(shareNaviQuery);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchNaviShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void searchLocationShareUrlAsyn(final LatLonSharePoint latLonSharePoint) {
        try {
            new Thread() {
                public void run() {
                    if (av.this.g != null) {
                        Message obtainMessage = q.a().obtainMessage();
                        obtainMessage.arg1 = 11;
                        obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
                        obtainMessage.obj = av.this.g;
                        try {
                            String searchLocationShareUrl = av.this.searchLocationShareUrl(latLonSharePoint);
                            Bundle bundle = new Bundle();
                            bundle.putString("shareurlkey", searchLocationShareUrl);
                            obtainMessage.setData(bundle);
                            obtainMessage.arg2 = 1000;
                        } catch (AMapException e) {
                            obtainMessage.arg2 = e.getErrorCode();
                        } catch (Throwable th) {
                            q.a().sendMessage(obtainMessage);
                            throw th;
                        }
                        q.a().sendMessage(obtainMessage);
                    }
                }
            }.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return (String) new ae(this.a, String.format(e, new Object[]{poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet()})).c();
                }
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchPoiShareUrl");
                throw e2;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        String str;
        if (shareNaviQuery == null) {
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchNaviShareUrl");
                throw e2;
            }
        } else {
            ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
            if (fromAndTo.getTo() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            LatLonPoint from = fromAndTo.getFrom();
            LatLonPoint to = fromAndTo.getTo();
            int naviMode = shareNaviQuery.getNaviMode();
            if (fromAndTo.getFrom() == null) {
                str = String.format(d, new Object[]{null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)});
            } else {
                str = String.format(d, new Object[]{Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode)});
            }
            return (String) new ae(this.a, str).c();
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        if (latLonSharePoint == null) {
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchLocationShareUrl");
                throw e2;
            }
        } else {
            return (String) new ae(this.a, String.format(c, new Object[]{Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName()})).c();
        }
    }

    public String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        if (shareBusRouteQuery == null) {
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchBusRouteShareUrl");
                throw e2;
            }
        } else {
            int busMode = shareBusRouteQuery.getBusMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() != null) {
                if (shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    return (String) new ae(this.a, String.format(b, new Object[]{Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, f, f, f})).c();
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    public String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        if (shareDrivingRouteQuery == null) {
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchDrivingRouteShareUrl");
                throw e2;
            }
        } else {
            int drivingMode = shareDrivingRouteQuery.getDrivingMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() != null) {
                if (shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    return (String) new ae(this.a, String.format(b, new Object[]{Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, f, f, f})).c();
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }

    public String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        if (shareWalkRouteQuery == null) {
            try {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            } catch (AMapException e2) {
                i.a(e2, "ShareSearch", "searchWalkRouteShareUrl");
                throw e2;
            }
        } else {
            int walkMode = shareWalkRouteQuery.getWalkMode();
            ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
            if (shareFromAndTo.getFrom() != null) {
                if (shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    return (String) new ae(this.a, String.format(b, new Object[]{Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, f, f, f})).c();
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
    }
}
