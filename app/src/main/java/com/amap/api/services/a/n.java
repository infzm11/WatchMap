package com.amap.api.services.a;

import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.district.DistrictItem;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.geocoder.AoiItem;
import com.amap.api.services.geocoder.BusinessArea;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeRoad;
import com.amap.api.services.geocoder.StreetNumber;
import com.amap.api.services.help.Tip;
import com.amap.api.services.poisearch.IndoorData;
import com.amap.api.services.poisearch.Photo;
import com.amap.api.services.poisearch.PoiItemExtension;
import com.amap.api.services.poisearch.SubPoiItem;
import com.amap.api.services.road.Crossroad;
import com.amap.api.services.route.BusPath;
import com.amap.api.services.route.BusRouteResult;
import com.amap.api.services.route.BusStep;
import com.amap.api.services.route.District;
import com.amap.api.services.route.Doorway;
import com.amap.api.services.route.DrivePath;
import com.amap.api.services.route.DriveRouteResult;
import com.amap.api.services.route.DriveStep;
import com.amap.api.services.route.Railway;
import com.amap.api.services.route.RailwaySpace;
import com.amap.api.services.route.RailwayStationItem;
import com.amap.api.services.route.RidePath;
import com.amap.api.services.route.RideRouteResult;
import com.amap.api.services.route.RideStep;
import com.amap.api.services.route.RouteBusLineItem;
import com.amap.api.services.route.RouteBusWalkItem;
import com.amap.api.services.route.RouteRailwayItem;
import com.amap.api.services.route.RouteSearchCity;
import com.amap.api.services.route.TMC;
import com.amap.api.services.route.TaxiItem;
import com.amap.api.services.route.WalkPath;
import com.amap.api.services.route.WalkRouteResult;
import com.amap.api.services.route.WalkStep;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.traffic.TrafficStatusEvaluation;
import com.amap.api.services.traffic.TrafficStatusInfo;
import com.amap.api.services.traffic.TrafficStatusResult;
import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.clientadapter.constant.ContactValue;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSONHelper */
public class n {
    private static String[] a = {"010", "021", "022", "023", "1852", "1853"};

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.amap.api.services.nearby.NearbyInfo> a(org.json.JSONObject r16, boolean r17) throws org.json.JSONException {
        /*
            java.lang.String r0 = "datas"
            r1 = r16
            org.json.JSONArray r0 = r1.getJSONArray(r0)
            if (r0 == 0) goto L_0x0086
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0012
            goto L_0x0086
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.length()
            r3 = 0
            r4 = r3
        L_0x001d:
            if (r4 >= r2) goto L_0x0085
            org.json.JSONObject r5 = r0.getJSONObject(r4)
            java.lang.String r6 = "userid"
            java.lang.String r6 = a((org.json.JSONObject) r5, (java.lang.String) r6)
            java.lang.String r7 = "location"
            java.lang.String r7 = a((org.json.JSONObject) r5, (java.lang.String) r7)
            r8 = 0
            if (r7 == 0) goto L_0x004e
            java.lang.String r10 = ","
            java.lang.String[] r7 = r7.split(r10)
            int r10 = r7.length
            r11 = 2
            if (r10 != r11) goto L_0x004e
            r8 = r7[r3]
            double r8 = l((java.lang.String) r8)
            r10 = 1
            r7 = r7[r10]
            double r10 = l((java.lang.String) r7)
            r14 = r8
            r8 = r10
            r10 = r14
            goto L_0x004f
        L_0x004e:
            r10 = r8
        L_0x004f:
            java.lang.String r7 = "distance"
            java.lang.String r7 = a((org.json.JSONObject) r5, (java.lang.String) r7)
            java.lang.String r12 = "updatetime"
            java.lang.String r5 = a((org.json.JSONObject) r5, (java.lang.String) r12)
            long r12 = m((java.lang.String) r5)
            int r5 = j((java.lang.String) r7)
            com.amap.api.services.core.LatLonPoint r7 = new com.amap.api.services.core.LatLonPoint
            r7.<init>(r8, r10)
            com.amap.api.services.nearby.NearbyInfo r8 = new com.amap.api.services.nearby.NearbyInfo
            r8.<init>()
            r8.setUserID(r6)
            r8.setTimeStamp(r12)
            r8.setPoint(r7)
            if (r17 == 0) goto L_0x007c
            r8.setDrivingDistance(r5)
            goto L_0x007f
        L_0x007c:
            r8.setDistance(r5)
        L_0x007f:
            r1.add(r8)
            int r4 = r4 + 1
            goto L_0x001d
        L_0x0085:
            return r1
        L_0x0086:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.services.a.n.a(org.json.JSONObject, boolean):java.util.ArrayList");
    }

    public static ArrayList<SuggestionCity> a(JSONObject jSONObject) throws JSONException, NumberFormatException {
        ArrayList<SuggestionCity> arrayList = new ArrayList<>();
        if (!jSONObject.has("cities")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new SuggestionCity(a(optJSONObject, "name"), a(optJSONObject, "citycode"), a(optJSONObject, "adcode"), j(a(optJSONObject, "num"))));
            }
        }
        return arrayList;
    }

    public static ArrayList<String> b(JSONObject jSONObject) throws JSONException {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        return arrayList;
    }

    public static ArrayList<PoiItem> c(JSONObject jSONObject) throws JSONException {
        ArrayList<PoiItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("pois");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(d(optJSONObject));
            }
        }
        return arrayList;
    }

    public static PoiItem d(JSONObject jSONObject) throws JSONException {
        PoiItem poiItem = new PoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        poiItem.setAdCode(a(jSONObject, "adcode"));
        poiItem.setProvinceName(a(jSONObject, "pname"));
        poiItem.setCityName(a(jSONObject, "cityname"));
        poiItem.setAdName(a(jSONObject, "adname"));
        poiItem.setCityCode(a(jSONObject, "citycode"));
        poiItem.setProvinceCode(a(jSONObject, "pcode"));
        poiItem.setDirection(a(jSONObject, "direction"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!i(a2)) {
                try {
                    poiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    i.a(e, "JSONHelper", "parseBasePoi");
                } catch (Exception e2) {
                    i.a(e2, "JSONHelper", "parseBasePoi");
                }
            }
        }
        poiItem.setTel(a(jSONObject, "tel"));
        poiItem.setTypeDes(a(jSONObject, "type"));
        poiItem.setEnter(b(jSONObject, "entr_location"));
        poiItem.setExit(b(jSONObject, "exit_location"));
        poiItem.setWebsite(a(jSONObject, FocusType.website));
        poiItem.setPostcode(a(jSONObject, "postcode"));
        poiItem.setBusinessArea(a(jSONObject, "business_area"));
        poiItem.setEmail(a(jSONObject, "email"));
        if (h(a(jSONObject, "indoor_map"))) {
            poiItem.setIndoorMap(false);
        } else {
            poiItem.setIndoorMap(true);
        }
        poiItem.setParkingType(a(jSONObject, "parking_type"));
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("children")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("children");
            if (optJSONArray == null) {
                poiItem.setSubPois(arrayList);
            } else {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        arrayList.add(x(optJSONObject));
                    }
                }
                poiItem.setSubPois(arrayList);
            }
        }
        poiItem.setIndoorDate(d(jSONObject, "indoor_data"));
        poiItem.setPoiExtension(e(jSONObject, "biz_ext"));
        poiItem.setTypeCode(a(jSONObject, "typecode"));
        poiItem.setShopID(a(jSONObject, "shopid"));
        a(poiItem, jSONObject);
        return poiItem;
    }

    private static SubPoiItem x(JSONObject jSONObject) throws JSONException {
        SubPoiItem subPoiItem = new SubPoiItem(a(jSONObject, "id"), b(jSONObject, "location"), a(jSONObject, "name"), a(jSONObject, "address"));
        subPoiItem.setSubName(a(jSONObject, "sname"));
        subPoiItem.setSubTypeDes(a(jSONObject, "subtype"));
        if (jSONObject.has("distance")) {
            String a2 = a(jSONObject, "distance");
            if (!i(a2)) {
                try {
                    subPoiItem.setDistance((int) Float.parseFloat(a2));
                } catch (NumberFormatException e) {
                    i.a(e, "JSONHelper", "parseSubPoiItem");
                } catch (Exception e2) {
                    i.a(e2, "JSONHelper", "parseSubPoiItem");
                }
            }
        }
        return subPoiItem;
    }

    public static ArrayList<BusStationItem> e(JSONObject jSONObject) throws JSONException {
        ArrayList<BusStationItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(f(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusStationItem f(JSONObject jSONObject) throws JSONException {
        BusStationItem g = g(jSONObject);
        if (g == null) {
            return g;
        }
        g.setAdCode(a(jSONObject, "adcode"));
        g.setCityCode(a(jSONObject, "citycode"));
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            g.setBusLineItems(arrayList);
            return g;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(h(optJSONObject));
            }
        }
        g.setBusLineItems(arrayList);
        return g;
    }

    public static BusStationItem g(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        busStationItem.setBusStationName(a(jSONObject, "name"));
        return busStationItem;
    }

    public static BusLineItem h(JSONObject jSONObject) throws JSONException {
        BusLineItem busLineItem = new BusLineItem();
        busLineItem.setBusLineId(a(jSONObject, "id"));
        busLineItem.setBusLineType(a(jSONObject, "type"));
        busLineItem.setBusLineName(a(jSONObject, "name"));
        busLineItem.setDirectionsCoordinates(c(jSONObject, "polyline"));
        busLineItem.setCityCode(a(jSONObject, "citycode"));
        busLineItem.setOriginatingStation(a(jSONObject, "start_stop"));
        busLineItem.setTerminalStation(a(jSONObject, "end_stop"));
        return busLineItem;
    }

    public static ArrayList<BusLineItem> i(JSONObject jSONObject) throws JSONException {
        ArrayList<BusLineItem> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(j(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusLineItem j(JSONObject jSONObject) throws JSONException {
        BusLineItem h = h(jSONObject);
        if (h == null) {
            return h;
        }
        h.setFirstBusTime(i.c(a(jSONObject, "start_time")));
        h.setLastBusTime(i.c(a(jSONObject, "end_time")));
        h.setBusCompany(a(jSONObject, "company"));
        h.setDistance(k(a(jSONObject, "distance")));
        h.setBasicPrice(k(a(jSONObject, "basic_price")));
        h.setTotalPrice(k(a(jSONObject, "total_price")));
        h.setBounds(c(jSONObject, "bounds"));
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("busstops");
        if (optJSONArray == null) {
            h.setBusStations(arrayList);
            return h;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(g(optJSONObject));
            }
        }
        h.setBusStations(arrayList);
        return h;
    }

    public static DistrictItem k(JSONObject jSONObject) throws JSONException {
        DistrictItem districtItem = new DistrictItem();
        districtItem.setCitycode(a(jSONObject, "citycode"));
        districtItem.setAdcode(a(jSONObject, "adcode"));
        districtItem.setName(a(jSONObject, "name"));
        districtItem.setLevel(a(jSONObject, "level"));
        districtItem.setCenter(b(jSONObject, "center"));
        if (jSONObject.has("polyline")) {
            String string = jSONObject.getString("polyline");
            if (string != null && string.length() > 0) {
                districtItem.setDistrictBoundary(string.split("\\|"));
            }
        }
        a(jSONObject.optJSONArray("districts"), new ArrayList(), districtItem);
        return districtItem;
    }

    public static void a(JSONArray jSONArray, ArrayList<DistrictItem> arrayList, DistrictItem districtItem) throws JSONException {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(k(optJSONObject));
                }
            }
            if (districtItem != null) {
                districtItem.setSubDistrict(arrayList);
            }
        }
    }

    public static ArrayList<GeocodeAddress> l(JSONObject jSONObject) throws JSONException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("geocodes");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                GeocodeAddress geocodeAddress = new GeocodeAddress();
                geocodeAddress.setFormatAddress(a(optJSONObject, "formatted_address"));
                geocodeAddress.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                geocodeAddress.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                geocodeAddress.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                geocodeAddress.setTownship(a(optJSONObject, "township"));
                geocodeAddress.setNeighborhood(a(optJSONObject.optJSONObject("neighborhood"), "name"));
                geocodeAddress.setBuilding(a(optJSONObject.optJSONObject("building"), "name"));
                geocodeAddress.setAdcode(a(optJSONObject, "adcode"));
                geocodeAddress.setLatLonPoint(b(optJSONObject, "location"));
                geocodeAddress.setLevel(a(optJSONObject, "level"));
                arrayList.add(geocodeAddress);
            }
        }
        return arrayList;
    }

    public static ArrayList<Tip> m(JSONObject jSONObject) throws JSONException {
        ArrayList<Tip> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("tips");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Tip tip = new Tip();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                tip.setName(a(optJSONObject, "name"));
                tip.setDistrict(a(optJSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
                tip.setAdcode(a(optJSONObject, "adcode"));
                tip.setID(a(optJSONObject, "id"));
                tip.setAddress(a(optJSONObject, "address"));
                tip.setTypeCode(a(optJSONObject, "typecode"));
                String a2 = a(optJSONObject, "location");
                if (!TextUtils.isEmpty(a2)) {
                    String[] split = a2.split(",");
                    if (split.length == 2) {
                        tip.setPostion(new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                    }
                }
                arrayList.add(tip);
            }
        }
        return arrayList;
    }

    public static void a(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Crossroad crossroad = new Crossroad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                crossroad.setId(a(optJSONObject, "id"));
                crossroad.setDirection(a(optJSONObject, "direction"));
                crossroad.setDistance(k(a(optJSONObject, "distance")));
                crossroad.setCenterPoint(b(optJSONObject, "location"));
                crossroad.setFirstRoadId(a(optJSONObject, "first_id"));
                crossroad.setFirstRoadName(a(optJSONObject, "first_name"));
                crossroad.setSecondRoadId(a(optJSONObject, "second_id"));
                crossroad.setSecondRoadName(a(optJSONObject, "second_name"));
                arrayList.add(crossroad);
            }
        }
        regeocodeAddress.setCrossroads(arrayList);
    }

    public static void b(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            RegeocodeRoad regeocodeRoad = new RegeocodeRoad();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                regeocodeRoad.setId(a(optJSONObject, "id"));
                regeocodeRoad.setName(a(optJSONObject, "name"));
                regeocodeRoad.setLatLngPoint(b(optJSONObject, "location"));
                regeocodeRoad.setDirection(a(optJSONObject, "direction"));
                regeocodeRoad.setDistance(k(a(optJSONObject, "distance")));
                arrayList.add(regeocodeRoad);
            }
        }
        regeocodeAddress.setRoads(arrayList);
    }

    public static void a(JSONObject jSONObject, RegeocodeAddress regeocodeAddress) throws JSONException {
        regeocodeAddress.setProvince(a(jSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
        regeocodeAddress.setCity(a(jSONObject, DistrictSearchQuery.KEYWORDS_CITY));
        regeocodeAddress.setCityCode(a(jSONObject, "citycode"));
        regeocodeAddress.setAdCode(a(jSONObject, "adcode"));
        regeocodeAddress.setDistrict(a(jSONObject, DistrictSearchQuery.KEYWORDS_DISTRICT));
        regeocodeAddress.setTownship(a(jSONObject, "township"));
        regeocodeAddress.setNeighborhood(a(jSONObject.optJSONObject("neighborhood"), "name"));
        regeocodeAddress.setBuilding(a(jSONObject.optJSONObject("building"), "name"));
        StreetNumber streetNumber = new StreetNumber();
        JSONObject optJSONObject = jSONObject.optJSONObject("streetNumber");
        streetNumber.setStreet(a(optJSONObject, "street"));
        streetNumber.setNumber(a(optJSONObject, ContactValue.NUMBER));
        streetNumber.setLatLonPoint(b(optJSONObject, "location"));
        streetNumber.setDirection(a(optJSONObject, "direction"));
        streetNumber.setDistance(k(a(optJSONObject, "distance")));
        regeocodeAddress.setStreetNumber(streetNumber);
        regeocodeAddress.setBusinessAreas(n(jSONObject));
        regeocodeAddress.setTowncode(a(jSONObject, "towncode"));
        a(regeocodeAddress);
    }

    private static void a(RegeocodeAddress regeocodeAddress) {
        if ((regeocodeAddress.getCity() == null || regeocodeAddress.getCity().length() < 1) && q(regeocodeAddress.getCityCode())) {
            regeocodeAddress.setCity(regeocodeAddress.getProvince());
        }
    }

    private static boolean q(String str) {
        if (str == null || str.length() < 1) {
            return false;
        }
        for (String trim : a) {
            if (str.trim().equals(trim.trim())) {
                return true;
            }
        }
        return false;
    }

    public static List<BusinessArea> n(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("businessAreas");
        if (optJSONArray == null || optJSONArray.length() == 0) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            BusinessArea businessArea = new BusinessArea();
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                businessArea.setCenterPoint(b(optJSONObject, "location"));
                businessArea.setName(a(optJSONObject, "name"));
                arrayList.add(businessArea);
            }
        }
        return arrayList;
    }

    public static BusRouteResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            BusRouteResult busRouteResult = new BusRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return busRouteResult;
            }
            busRouteResult.setStartPos(b(optJSONObject, "origin"));
            busRouteResult.setTargetPos(b(optJSONObject, "destination"));
            busRouteResult.setTaxiCost(k(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("transits")) {
                return busRouteResult;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("transits");
            if (optJSONArray == null) {
                return busRouteResult;
            }
            busRouteResult.setPaths(a(optJSONArray));
            return busRouteResult;
        } catch (JSONException unused) {
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static List<BusPath> a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            BusPath busPath = new BusPath();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                busPath.setCost(k(a(optJSONObject, "cost")));
                busPath.setDuration(m(a(optJSONObject, "duration")));
                busPath.setNightBus(n(a(optJSONObject, "nightflag")));
                busPath.setWalkDistance(k(a(optJSONObject, "walking_distance")));
                busPath.setDistance(k(a(optJSONObject, "distance")));
                JSONArray optJSONArray = optJSONObject.optJSONArray("segments");
                if (optJSONArray != null) {
                    ArrayList arrayList2 = new ArrayList();
                    float f = 0.0f;
                    float f2 = 0.0f;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            BusStep o = o(optJSONObject2);
                            if (o != null) {
                                arrayList2.add(o);
                                if (o.getWalk() != null) {
                                    f2 += o.getWalk().getDistance();
                                }
                                if (o.getBusLines() != null && o.getBusLines().size() > 0) {
                                    f += o.getBusLines().get(0).getDistance();
                                }
                            }
                        }
                    }
                    busPath.setSteps(arrayList2);
                    busPath.setBusDistance(f);
                    busPath.setWalkDistance(f2);
                    arrayList.add(busPath);
                }
            }
        }
        return arrayList;
    }

    public static BusStep o(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        BusStep busStep = new BusStep();
        JSONObject optJSONObject = jSONObject.optJSONObject("walking");
        if (optJSONObject != null) {
            busStep.setWalk(p(optJSONObject));
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("bus");
        if (optJSONObject2 != null) {
            busStep.setBusLines(q(optJSONObject2));
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("entrance");
        if (optJSONObject3 != null) {
            busStep.setEntrance(r(optJSONObject3));
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("exit");
        if (optJSONObject4 != null) {
            busStep.setExit(r(optJSONObject4));
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("railway");
        if (optJSONObject5 != null) {
            busStep.setRailway(y(optJSONObject5));
        }
        JSONObject optJSONObject6 = jSONObject.optJSONObject("taxi");
        if (optJSONObject6 != null) {
            busStep.setTaxi(E(optJSONObject6));
        }
        if ((busStep.getWalk() == null || busStep.getWalk().getSteps().size() == 0) && busStep.getBusLines().size() == 0 && busStep.getRailway() == null && busStep.getTaxi() == null) {
            return null;
        }
        return busStep;
    }

    public static RouteBusWalkItem p(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusWalkItem routeBusWalkItem = new RouteBusWalkItem();
        routeBusWalkItem.setOrigin(b(jSONObject, "origin"));
        routeBusWalkItem.setDestination(b(jSONObject, "destination"));
        routeBusWalkItem.setDistance(k(a(jSONObject, "distance")));
        routeBusWalkItem.setDuration(m(a(jSONObject, "duration")));
        if (!jSONObject.has("steps")) {
            return routeBusWalkItem;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("steps");
        if (optJSONArray == null) {
            return routeBusWalkItem;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(s(optJSONObject));
            }
        }
        routeBusWalkItem.setSteps(arrayList);
        return routeBusWalkItem;
    }

    public static List<RouteBusLineItem> q(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("buslines");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(t(optJSONObject));
            }
        }
        return arrayList;
    }

    public static Doorway r(JSONObject jSONObject) throws JSONException {
        Doorway doorway = new Doorway();
        doorway.setName(a(jSONObject, "name"));
        doorway.setLatLonPoint(b(jSONObject, "location"));
        return doorway;
    }

    public static WalkStep s(JSONObject jSONObject) throws JSONException {
        WalkStep walkStep = new WalkStep();
        walkStep.setInstruction(a(jSONObject, "instruction"));
        walkStep.setOrientation(a(jSONObject, "orientation"));
        walkStep.setRoad(a(jSONObject, "road"));
        walkStep.setDistance(k(a(jSONObject, "distance")));
        walkStep.setDuration(k(a(jSONObject, "duration")));
        walkStep.setPolyline(c(jSONObject, "polyline"));
        walkStep.setAction(a(jSONObject, "action"));
        walkStep.setAssistantAction(a(jSONObject, "assistant_action"));
        return walkStep;
    }

    public static RouteBusLineItem t(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        RouteBusLineItem routeBusLineItem = new RouteBusLineItem();
        routeBusLineItem.setDepartureBusStation(v(jSONObject.optJSONObject("departure_stop")));
        routeBusLineItem.setArrivalBusStation(v(jSONObject.optJSONObject("arrival_stop")));
        routeBusLineItem.setBusLineName(a(jSONObject, "name"));
        routeBusLineItem.setBusLineId(a(jSONObject, "id"));
        routeBusLineItem.setBusLineType(a(jSONObject, "type"));
        routeBusLineItem.setDistance(k(a(jSONObject, "distance")));
        routeBusLineItem.setDuration(k(a(jSONObject, "duration")));
        routeBusLineItem.setPolyline(c(jSONObject, "polyline"));
        routeBusLineItem.setFirstBusTime(i.c(a(jSONObject, "start_time")));
        routeBusLineItem.setLastBusTime(i.c(a(jSONObject, "end_time")));
        routeBusLineItem.setPassStationNum(j(a(jSONObject, "via_num")));
        routeBusLineItem.setPassStations(u(jSONObject));
        return routeBusLineItem;
    }

    public static List<BusStationItem> u(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("via_stops");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(v(optJSONObject));
            }
        }
        return arrayList;
    }

    public static BusStationItem v(JSONObject jSONObject) throws JSONException {
        BusStationItem busStationItem = new BusStationItem();
        busStationItem.setBusStationName(a(jSONObject, "name"));
        busStationItem.setBusStationId(a(jSONObject, "id"));
        busStationItem.setLatLonPoint(b(jSONObject, "location"));
        return busStationItem;
    }

    private static RouteRailwayItem y(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null || !jSONObject.has("id") || !jSONObject.has("name")) {
            return null;
        }
        RouteRailwayItem routeRailwayItem = new RouteRailwayItem();
        routeRailwayItem.setID(a(jSONObject, "id"));
        routeRailwayItem.setName(a(jSONObject, "name"));
        routeRailwayItem.setTime(a(jSONObject, "time"));
        routeRailwayItem.setTrip(a(jSONObject, "trip"));
        routeRailwayItem.setDistance(k(a(jSONObject, "distance")));
        routeRailwayItem.setType(a(jSONObject, "type"));
        routeRailwayItem.setDeparturestop(z(jSONObject.optJSONObject("departure_stop")));
        routeRailwayItem.setArrivalstop(z(jSONObject.optJSONObject("arrival_stop")));
        routeRailwayItem.setViastops(A(jSONObject));
        routeRailwayItem.setAlters(B(jSONObject));
        routeRailwayItem.setSpaces(C(jSONObject));
        return routeRailwayItem;
    }

    private static RailwayStationItem z(JSONObject jSONObject) throws JSONException {
        RailwayStationItem railwayStationItem = new RailwayStationItem();
        railwayStationItem.setID(a(jSONObject, "id"));
        railwayStationItem.setName(a(jSONObject, "name"));
        railwayStationItem.setLocation(b(jSONObject, "location"));
        railwayStationItem.setAdcode(a(jSONObject, "adcode"));
        railwayStationItem.setTime(a(jSONObject, "time"));
        railwayStationItem.setisStart(n(a(jSONObject, "start")));
        railwayStationItem.setisEnd(n(a(jSONObject, "end")));
        railwayStationItem.setWait(k(a(jSONObject, "wait")));
        return railwayStationItem;
    }

    private static List<RailwayStationItem> A(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("via_stops");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(z(optJSONObject));
            }
        }
        return arrayList;
    }

    private static List<Railway> B(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("alters");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                Railway railway = new Railway();
                railway.setID(a(optJSONObject, "id"));
                railway.setName(a(optJSONObject, "name"));
                arrayList.add(railway);
            }
        }
        return arrayList;
    }

    private static List<RailwaySpace> C(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("spaces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(D(optJSONObject));
            }
        }
        return arrayList;
    }

    private static RailwaySpace D(JSONObject jSONObject) throws JSONException {
        return new RailwaySpace(a(jSONObject, "code"), k(a(jSONObject, "cost")));
    }

    private static TaxiItem E(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        TaxiItem taxiItem = new TaxiItem();
        taxiItem.setOrigin(b(jSONObject, "origin"));
        taxiItem.setDestination(b(jSONObject, "destination"));
        taxiItem.setDistance(k(a(jSONObject, "distance")));
        taxiItem.setDuration(k(a(jSONObject, "duration")));
        taxiItem.setSname(a(jSONObject, "sname"));
        taxiItem.setTname(a(jSONObject, "tname"));
        return taxiItem;
    }

    public static DriveRouteResult b(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            DriveRouteResult driveRouteResult = new DriveRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            if (optJSONObject == null) {
                return driveRouteResult;
            }
            driveRouteResult.setStartPos(b(optJSONObject, "origin"));
            driveRouteResult.setTargetPos(b(optJSONObject, "destination"));
            driveRouteResult.setTaxiCost(k(a(optJSONObject, "taxi_cost")));
            if (!optJSONObject.has("paths")) {
                return driveRouteResult;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                return driveRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < optJSONArray.length(); i++) {
                DrivePath drivePath = new DrivePath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    drivePath.setDistance(k(a(optJSONObject2, "distance")));
                    drivePath.setDuration(m(a(optJSONObject2, "duration")));
                    drivePath.setStrategy(a(optJSONObject2, "strategy"));
                    drivePath.setTolls(k(a(optJSONObject2, "tolls")));
                    drivePath.setTollDistance(k(a(optJSONObject2, "toll_distance")));
                    drivePath.setTotalTrafficlights(j(a(optJSONObject2, "traffic_lights")));
                    drivePath.setRestriction(j(a(optJSONObject2, "restriction")));
                    JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                    if (optJSONArray2 != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            DriveStep driveStep = new DriveStep();
                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                            if (optJSONObject3 != null) {
                                driveStep.setInstruction(a(optJSONObject3, "instruction"));
                                driveStep.setOrientation(a(optJSONObject3, "orientation"));
                                driveStep.setRoad(a(optJSONObject3, "road"));
                                driveStep.setDistance(k(a(optJSONObject3, "distance")));
                                driveStep.setTolls(k(a(optJSONObject3, "tolls")));
                                driveStep.setTollDistance(k(a(optJSONObject3, "toll_distance")));
                                driveStep.setTollRoad(a(optJSONObject3, "toll_road"));
                                driveStep.setDuration(k(a(optJSONObject3, "duration")));
                                driveStep.setPolyline(c(optJSONObject3, "polyline"));
                                driveStep.setAction(a(optJSONObject3, "action"));
                                driveStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                a(driveStep, optJSONObject3);
                                b(driveStep, optJSONObject3);
                                arrayList2.add(driveStep);
                            }
                        }
                        drivePath.setSteps(arrayList2);
                        arrayList.add(drivePath);
                    }
                }
            }
            driveRouteResult.setPaths(arrayList);
            return driveRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseDriveRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        } catch (Throwable th) {
            i.a(th, "JSONHelper", "parseDriveRouteThrowable");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static void b(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("tmcs");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TMC tmc = new TMC();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        tmc.setDistance(j(a(optJSONObject, "distance")));
                        tmc.setStatus(a(optJSONObject, "status"));
                        tmc.setPolyline(c(optJSONObject, "polyline"));
                        arrayList.add(tmc);
                    }
                }
                driveStep.setTMCs(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseTMCs");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(DriveStep driveStep, JSONObject jSONObject) throws AMapException {
        try {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("cities");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RouteSearchCity routeSearchCity = new RouteSearchCity();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        routeSearchCity.setSearchCityName(a(optJSONObject, "name"));
                        routeSearchCity.setSearchCitycode(a(optJSONObject, "citycode"));
                        routeSearchCity.setSearchCityhAdCode(a(optJSONObject, "adcode"));
                        a(routeSearchCity, optJSONObject);
                        arrayList.add(routeSearchCity);
                    }
                }
                driveStep.setRouteSearchCityList(arrayList);
            }
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseCrossCity");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static void a(RouteSearchCity routeSearchCity, JSONObject jSONObject) throws AMapException {
        if (jSONObject.has("districts")) {
            try {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("districts");
                if (optJSONArray == null) {
                    routeSearchCity.setDistricts(arrayList);
                    return;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    District district = new District();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        district.setDistrictName(a(optJSONObject, "name"));
                        district.setDistrictAdcode(a(optJSONObject, "adcode"));
                        arrayList.add(district);
                    }
                }
                routeSearchCity.setDistricts(arrayList);
            } catch (JSONException e) {
                i.a(e, "JSONHelper", "parseCrossDistricts");
                throw new AMapException("协议解析错误 - ProtocolException");
            }
        }
    }

    public static WalkRouteResult c(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("route")) {
                return null;
            }
            WalkRouteResult walkRouteResult = new WalkRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("route");
            walkRouteResult.setStartPos(b(optJSONObject, "origin"));
            walkRouteResult.setTargetPos(b(optJSONObject, "destination"));
            if (!optJSONObject.has("paths")) {
                return walkRouteResult;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
            if (optJSONArray == null) {
                walkRouteResult.setPaths(arrayList);
                return walkRouteResult;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                WalkPath walkPath = new WalkPath();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    walkPath.setDistance(k(a(optJSONObject2, "distance")));
                    walkPath.setDuration(m(a(optJSONObject2, "duration")));
                    if (optJSONObject2.has("steps")) {
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("steps");
                        ArrayList arrayList2 = new ArrayList();
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                WalkStep walkStep = new WalkStep();
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i2);
                                if (optJSONObject3 != null) {
                                    walkStep.setInstruction(a(optJSONObject3, "instruction"));
                                    walkStep.setOrientation(a(optJSONObject3, "orientation"));
                                    walkStep.setRoad(a(optJSONObject3, "road"));
                                    walkStep.setDistance(k(a(optJSONObject3, "distance")));
                                    walkStep.setDuration(k(a(optJSONObject3, "duration")));
                                    walkStep.setPolyline(c(optJSONObject3, "polyline"));
                                    walkStep.setAction(a(optJSONObject3, "action"));
                                    walkStep.setAssistantAction(a(optJSONObject3, "assistant_action"));
                                    arrayList2.add(walkStep);
                                }
                            }
                            walkPath.setSteps(arrayList2);
                        }
                    }
                    arrayList.add(walkPath);
                }
            }
            walkRouteResult.setPaths(arrayList);
            return walkRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseWalkRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherLive d(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("lives")) {
                return null;
            }
            LocalWeatherLive localWeatherLive = new LocalWeatherLive();
            JSONArray optJSONArray = jSONObject.optJSONArray("lives");
            if (optJSONArray != null) {
                if (optJSONArray.length() > 0) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherLive;
                    }
                    localWeatherLive.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherLive.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherLive.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherLive.setWeather(a(optJSONObject, FocusType.weather));
                    localWeatherLive.setTemperature(a(optJSONObject, "temperature"));
                    localWeatherLive.setWindDirection(a(optJSONObject, "winddirection"));
                    localWeatherLive.setWindPower(a(optJSONObject, "windpower"));
                    localWeatherLive.setHumidity(a(optJSONObject, "humidity"));
                    localWeatherLive.setReportTime(a(optJSONObject, "reporttime"));
                    return localWeatherLive;
                }
            }
            return localWeatherLive;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static LocalWeatherForecast e(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("forecasts")) {
                return null;
            }
            LocalWeatherForecast localWeatherForecast = new LocalWeatherForecast();
            JSONArray jSONArray = jSONObject.getJSONArray("forecasts");
            if (jSONArray != null) {
                if (jSONArray.length() > 0) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(0);
                    if (optJSONObject == null) {
                        return localWeatherForecast;
                    }
                    localWeatherForecast.setCity(a(optJSONObject, DistrictSearchQuery.KEYWORDS_CITY));
                    localWeatherForecast.setAdCode(a(optJSONObject, "adcode"));
                    localWeatherForecast.setProvince(a(optJSONObject, DistrictSearchQuery.KEYWORDS_PROVINCE));
                    localWeatherForecast.setReportTime(a(optJSONObject, "reporttime"));
                    if (!optJSONObject.has("casts")) {
                        return localWeatherForecast;
                    }
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("casts");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() > 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                LocalDayWeatherForecast localDayWeatherForecast = new LocalDayWeatherForecast();
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                                if (optJSONObject2 != null) {
                                    localDayWeatherForecast.setDate(a(optJSONObject2, "date"));
                                    localDayWeatherForecast.setWeek(a(optJSONObject2, "week"));
                                    localDayWeatherForecast.setDayWeather(a(optJSONObject2, "dayweather"));
                                    localDayWeatherForecast.setNightWeather(a(optJSONObject2, "nightweather"));
                                    localDayWeatherForecast.setDayTemp(a(optJSONObject2, "daytemp"));
                                    localDayWeatherForecast.setNightTemp(a(optJSONObject2, "nighttemp"));
                                    localDayWeatherForecast.setDayWindDirection(a(optJSONObject2, "daywind"));
                                    localDayWeatherForecast.setNightWindDirection(a(optJSONObject2, "nightwind"));
                                    localDayWeatherForecast.setDayWindPower(a(optJSONObject2, "daypower"));
                                    localDayWeatherForecast.setNightWindPower(a(optJSONObject2, "nightpower"));
                                    arrayList.add(localDayWeatherForecast);
                                }
                            }
                            localWeatherForecast.setWeatherForecast(arrayList);
                            return localWeatherForecast;
                        }
                    }
                    localWeatherForecast.setWeatherForecast(arrayList);
                    return localWeatherForecast;
                }
            }
            return localWeatherForecast;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "WeatherForecastResult");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static String a(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str) && !jSONObject.getString(str).equals("[]")) {
            return jSONObject.optString(str).trim();
        }
        return "";
    }

    public static LatLonPoint b(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject != null && jSONObject.has(str)) {
            return g(jSONObject.optString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> c(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return f(jSONObject.getString(str));
        }
        return null;
    }

    public static ArrayList<LatLonPoint> f(String str) {
        ArrayList<LatLonPoint> arrayList = new ArrayList<>();
        String[] split = str.split(VoiceWakeuperAidl.PARAMS_SEPARATE);
        for (String g : split) {
            arrayList.add(g(g));
        }
        return arrayList;
    }

    public static LatLonPoint g(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return null;
        }
        String[] split = str.split(",| ");
        if (split.length != 2) {
            return null;
        }
        return new LatLonPoint(Double.parseDouble(split[1]), Double.parseDouble(split[0]));
    }

    public static boolean h(String str) {
        return str == null || str.equals("") || str.equals("0");
    }

    public static boolean i(String str) {
        return str == null || str.equals("");
    }

    public static int j(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2int");
            return 0;
        }
    }

    public static float k(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2float");
            return 0.0f;
        }
    }

    public static double l(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0.0d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2float");
            return 0.0d;
        }
    }

    public static long m(String str) {
        if (str == null || str.equals("") || str.equals("[]")) {
            return 0;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            i.a(e, "JSONHelper", "str2long");
            return 0;
        }
    }

    public static boolean n(String str) {
        if (str == null || str.equals("") || str.equals("[]") || str.equals("0") || !str.equals("1")) {
            return false;
        }
        return true;
    }

    private static IndoorData d(JSONObject jSONObject, String str) throws JSONException {
        int i;
        String str2 = "";
        String str3 = "";
        if (jSONObject.has(str)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null && optJSONObject.has("cpid") && optJSONObject.has("floor")) {
                str2 = a(optJSONObject, "cpid");
                i = j(a(optJSONObject, "floor"));
                str3 = a(optJSONObject, "truefloor");
                return new IndoorData(str2, i, str3);
            }
        }
        i = 0;
        return new IndoorData(str2, i, str3);
    }

    public static void c(JSONArray jSONArray, RegeocodeAddress regeocodeAddress) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            AoiItem aoiItem = new AoiItem();
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                aoiItem.setId(a(optJSONObject, "id"));
                aoiItem.setName(a(optJSONObject, "name"));
                aoiItem.setAdcode(a(optJSONObject, "adcode"));
                aoiItem.setLocation(b(optJSONObject, "location"));
                aoiItem.setArea(Float.valueOf(k(a(optJSONObject, "area"))));
                arrayList.add(aoiItem);
            }
        }
        regeocodeAddress.setAois(arrayList);
    }

    public static void a(PoiItem poiItem, JSONObject jSONObject) throws JSONException {
        List<Photo> F = F(jSONObject.optJSONObject("deep_info"));
        if (F.size() == 0) {
            F = F(jSONObject);
        }
        poiItem.setPhotos(F);
    }

    private static List<Photo> F(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null || !jSONObject.has("photos")) {
            return arrayList;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("photos");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            Photo photo = new Photo();
            photo.setTitle(a(optJSONObject, "title"));
            photo.setUrl(a(optJSONObject, "url"));
            arrayList.add(photo);
        }
        return arrayList;
    }

    private static PoiItemExtension e(JSONObject jSONObject, String str) throws JSONException {
        String str2 = "";
        String str3 = "";
        if (jSONObject.has(str)) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject != null) {
                str2 = a(optJSONObject, "open_time");
                str3 = a(optJSONObject, "rating");
            }
        }
        return new PoiItemExtension(str2, str3);
    }

    public static ArrayList<RoutePOIItem> w(JSONObject jSONObject) throws JSONException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        if (jSONObject == null) {
            return arrayList;
        }
        Object opt = jSONObject.opt("pois");
        if (opt instanceof JSONArray) {
            JSONArray optJSONArray = jSONObject.optJSONArray("pois");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return arrayList;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(G(optJSONObject));
                }
            }
        } else if (opt instanceof JSONObject) {
            arrayList.add(G(((JSONObject) opt).optJSONObject("poi")));
        }
        return arrayList;
    }

    private static RoutePOIItem G(JSONObject jSONObject) throws JSONException {
        RoutePOIItem routePOIItem = new RoutePOIItem();
        routePOIItem.setID(a(jSONObject, "id"));
        routePOIItem.setTitle(a(jSONObject, "name"));
        routePOIItem.setPoint(b(jSONObject, "location"));
        routePOIItem.setDistance(k(a(jSONObject, "distance")));
        routePOIItem.setDuration(k(a(jSONObject, "duration")));
        return routePOIItem;
    }

    public static RideRouteResult o(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("data")) {
                return null;
            }
            RideRouteResult rideRouteResult = new RideRouteResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            rideRouteResult.setStartPos(b(optJSONObject, "origin"));
            rideRouteResult.setTargetPos(b(optJSONObject, "destination"));
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("paths");
            if (opt == null) {
                rideRouteResult.setPaths(arrayList);
                return rideRouteResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("paths");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RidePath H = H(optJSONArray.optJSONObject(i));
                    if (H != null) {
                        arrayList.add(H);
                    }
                }
            } else if (opt instanceof JSONObject) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("paths");
                if (!optJSONObject2.has(AIUIConstant.RES_TYPE_PATH)) {
                    rideRouteResult.setPaths(arrayList);
                    return rideRouteResult;
                }
                RidePath H2 = H(optJSONObject2.optJSONObject(AIUIConstant.RES_TYPE_PATH));
                if (H2 != null) {
                    arrayList.add(H2);
                }
            }
            rideRouteResult.setPaths(arrayList);
            return rideRouteResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static RidePath H(JSONObject jSONObject) throws AMapException {
        RidePath ridePath = new RidePath();
        if (jSONObject == null) {
            return null;
        }
        try {
            ridePath.setDistance(k(a(jSONObject, "distance")));
            ridePath.setDuration(m(a(jSONObject, "duration")));
            if (jSONObject.has("steps")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("steps");
                ArrayList arrayList = new ArrayList();
                if (optJSONArray == null) {
                    return null;
                }
                for (int i = 0; i < optJSONArray.length(); i++) {
                    RideStep rideStep = new RideStep();
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        rideStep.setInstruction(a(optJSONObject, "instruction"));
                        rideStep.setOrientation(a(optJSONObject, "orientation"));
                        rideStep.setRoad(a(optJSONObject, "road"));
                        rideStep.setDistance(k(a(optJSONObject, "distance")));
                        rideStep.setDuration(k(a(optJSONObject, "duration")));
                        rideStep.setPolyline(c(optJSONObject, "polyline"));
                        rideStep.setAction(a(optJSONObject, "action"));
                        rideStep.setAssistantAction(a(optJSONObject, "assistant_action"));
                        arrayList.add(rideStep);
                    }
                }
                ridePath.setSteps(arrayList);
            }
            return ridePath;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRidePath");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    public static TrafficStatusResult p(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("trafficinfo")) {
                return null;
            }
            TrafficStatusResult trafficStatusResult = new TrafficStatusResult();
            JSONObject optJSONObject = jSONObject.optJSONObject("trafficinfo");
            trafficStatusResult.setDescription(a(optJSONObject, "description"));
            if (optJSONObject.has("evaluation")) {
                TrafficStatusEvaluation trafficStatusEvaluation = new TrafficStatusEvaluation();
                JSONObject jSONObject2 = optJSONObject.getJSONObject("evaluation");
                trafficStatusEvaluation.setExpedite(a(jSONObject2, "expedite"));
                trafficStatusEvaluation.setCongested(a(jSONObject2, "congested"));
                trafficStatusEvaluation.setBlocked(a(jSONObject2, "blocked"));
                trafficStatusEvaluation.setUnknown(a(jSONObject2, EnvironmentCompat.MEDIA_UNKNOWN));
                trafficStatusEvaluation.setStatus(a(jSONObject2, "status"));
                trafficStatusEvaluation.setDescription(a(jSONObject2, "description"));
                trafficStatusResult.setEvaluation(trafficStatusEvaluation);
            }
            if (!optJSONObject.has("roads")) {
                return trafficStatusResult;
            }
            ArrayList arrayList = new ArrayList();
            Object opt = optJSONObject.opt("roads");
            if (opt == null) {
                trafficStatusResult.setRoads(arrayList);
                return trafficStatusResult;
            }
            if (opt instanceof JSONArray) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    TrafficStatusInfo I = I(optJSONArray.optJSONObject(i));
                    if (I != null) {
                        arrayList.add(I);
                    }
                }
            }
            trafficStatusResult.setRoads(arrayList);
            return trafficStatusResult;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRideRoute");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }

    private static TrafficStatusInfo I(JSONObject jSONObject) throws AMapException {
        TrafficStatusInfo trafficStatusInfo = new TrafficStatusInfo();
        if (trafficStatusInfo == null) {
            return null;
        }
        try {
            trafficStatusInfo.setName(a(jSONObject, "name"));
            trafficStatusInfo.setStatus(a(jSONObject, "status"));
            trafficStatusInfo.setAngle(j(a(jSONObject, "angle")));
            trafficStatusInfo.setSpeed(k(a(jSONObject, SpeechConstant.SPEED)));
            trafficStatusInfo.setDirection(a(jSONObject, "direction"));
            trafficStatusInfo.setLcodes(a(jSONObject, "lcodes"));
            trafficStatusInfo.setCoordinates(c(jSONObject, "polyline"));
            return trafficStatusInfo;
        } catch (JSONException e) {
            i.a(e, "JSONHelper", "parseRoadInfo");
            throw new AMapException("协议解析错误 - ProtocolException");
        }
    }
}
