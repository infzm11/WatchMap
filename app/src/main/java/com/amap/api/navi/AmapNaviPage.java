package com.amap.api.navi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AmapNaviPage {
    public static final String PAGE_TYPE = "isNaviPage";
    public static final String POI_DATA = "data";
    public static final String POI_END = "end_poi";
    public static final String POI_START = "start_poi";
    public static final String POI_WAY1 = "way_poi1";
    public static final String POI_WAY2 = "way_poi2";
    public static final String POI_WAY3 = "way_poi3";
    public static final String TAG = "AmapNaviPage";
    private static final AmapNaviPage ourInstance = new AmapNaviPage();
    private INaviInfoCallback callback;
    private Poi poi1;
    private Poi poi2;
    private Poi poi3;
    private List<Poi> wayPointList = new ArrayList();

    class a {
        public String a = "";
        public LatLng b;
        public String c = "";

        public final int hashCode() {
            return 0;
        }

        public a(Poi poi) {
            if (poi != null) {
                this.b = poi.getCoordinate();
                this.a = poi.getName() != null ? poi.getName() : "";
                this.c = poi.getPoiId() != null ? poi.getPoiId() : "";
            }
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            String str = aVar.c != null ? aVar.c : "";
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.c)) {
                if (this.b.equals(aVar.b)) {
                    return true;
                }
                return false;
            } else if (this.c.equals(str)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static AmapNaviPage getInstance() {
        return ourInstance;
    }

    private AmapNaviPage() {
    }

    public INaviInfoCallback getCallback() {
        return this.callback;
    }

    public void showRouteActivity(Context context, AmapNaviParams amapNaviParams, INaviInfoCallback iNaviInfoCallback) {
        try {
            this.wayPointList.clear();
            Poi poi = null;
            this.poi1 = null;
            this.poi2 = null;
            this.poi3 = null;
            if (context != null) {
                if (amapNaviParams != null) {
                    if (iNaviInfoCallback != null) {
                        this.callback = iNaviInfoCallback;
                    }
                    Poi end = amapNaviParams.getEnd();
                    if (end != null) {
                        if (end.getCoordinate() == null) {
                            end = null;
                        } else {
                            String str = "终点";
                            if (!TextUtils.isEmpty(end.getName())) {
                                str = end.getName();
                            }
                            end = new Poi(str, end.getCoordinate(), end.getPoiId());
                        }
                    }
                    Poi start = amapNaviParams.getStart();
                    if (start == null) {
                        poi = start;
                    } else if (start.getCoordinate() != null) {
                        String str2 = "起点";
                        if (!TextUtils.isEmpty(start.getName())) {
                            str2 = start.getName();
                        }
                        poi = new Poi(str2, start.getCoordinate(), start.getPoiId());
                    }
                    List<Poi> ways = amapNaviParams.getWays();
                    if (ways != null && ways.size() > 0) {
                        for (int i = 0; i < ways.size(); i++) {
                            if (i < 3) {
                                Poi poi4 = ways.get(i);
                                if (!(poi4 == null || poi4.getCoordinate() == null)) {
                                    this.wayPointList.add(poi4);
                                }
                            }
                        }
                    }
                    checkMid();
                    Intent intent = new Intent(context, AmapRouteActivity.class);
                    AmapPageType pageType = amapNaviParams.getPageType();
                    intent.addFlags(268435456);
                    Bundle bundle = new Bundle();
                    if (pageType != AmapPageType.NAVI) {
                        bundle.putBoolean(PAGE_TYPE, false);
                    } else if (end == null) {
                        Toast.makeText(context, "直接导航，终点不能为空!", 0).show();
                        return;
                    } else {
                        bundle.putBoolean(PAGE_TYPE, true);
                    }
                    bundle.putParcelable(POI_START, poi);
                    bundle.putParcelable(POI_END, end);
                    bundle.putParcelable(POI_WAY1, this.poi1);
                    bundle.putParcelable(POI_WAY2, this.poi2);
                    bundle.putParcelable(POI_WAY3, this.poi3);
                    intent.putExtra("data", bundle);
                    context.startActivity(intent);
                    return;
                }
            }
            throw new Exception("context == null 或者 params == null");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void removeSamePois() {
        HashSet<a> hashSet = new HashSet<>();
        for (Poi aVar : this.wayPointList) {
            hashSet.add(new a(aVar));
        }
        this.wayPointList.clear();
        for (a aVar2 : hashSet) {
            this.wayPointList.add(new Poi(aVar2.a, aVar2.b, aVar2.c));
        }
        Collections.reverse(this.wayPointList);
    }

    private void checkMid() {
        try {
            removeSamePois();
            if (this.wayPointList != null && this.wayPointList.size() > 0) {
                switch (this.wayPointList.size()) {
                    case 1:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                            return;
                        }
                        return;
                    case 2:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                        }
                        this.poi2 = this.wayPointList.get(1);
                        if (TextUtils.isEmpty(this.poi2.getName())) {
                            this.poi2 = new Poi("途径点2", this.poi2.getCoordinate(), this.poi2.getPoiId());
                            return;
                        }
                        return;
                    case 3:
                        this.poi1 = this.wayPointList.get(0);
                        if (TextUtils.isEmpty(this.poi1.getName())) {
                            this.poi1 = new Poi("途径点1", this.poi1.getCoordinate(), this.poi1.getPoiId());
                        }
                        this.poi2 = this.wayPointList.get(1);
                        if (TextUtils.isEmpty(this.poi2.getName())) {
                            this.poi2 = new Poi("途径点2", this.poi2.getCoordinate(), this.poi2.getPoiId());
                        }
                        this.poi3 = this.wayPointList.get(2);
                        if (TextUtils.isEmpty(this.poi3.getName())) {
                            this.poi3 = new Poi("途径点3", this.poi3.getCoordinate(), this.poi3.getPoiId());
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
