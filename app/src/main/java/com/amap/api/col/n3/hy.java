package com.amap.api.col.n3;

import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.iflytek.cloud.SpeechEvent;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CoreUtil */
public final class hy {
    private static String[] a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static void a(String str) throws hv {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                return;
            }
            if (jSONObject.has("infocode")) {
                String string = jSONObject.getString("status");
                int i = jSONObject.getInt("infocode");
                if (!string.equals("1") && string.equals("0")) {
                    switch (i) {
                        case 10001:
                            throw new hv(AMapException.AMAP_INVALID_USER_KEY);
                        case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*10002*/:
                            throw new hv(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                        case 10003:
                            throw new hv(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                        case SpeechEvent.EVENT_IST_AUDIO_FILE /*10004*/:
                            throw new hv(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                        case 10005:
                            throw new hv(AMapException.AMAP_INVALID_USER_IP);
                        case SpeechEvent.EVENT_IST_UPLOAD_BYTES /*10006*/:
                            throw new hv(AMapException.AMAP_INVALID_USER_DOMAIN);
                        case SpeechEvent.EVENT_IST_CACHE_LEFT /*10007*/:
                            throw new hv("用户签名未通过");
                        case SpeechEvent.EVENT_IST_RESULT_TIME /*10008*/:
                            throw new hv(AMapException.AMAP_INVALID_USER_SCODE);
                        case SpeechEvent.EVENT_IST_SYNC_ID /*10009*/:
                            throw new hv(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                        case SpeechEvent.EVENT_SESSION_BEGIN /*10010*/:
                            throw new hv(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                        case SpeechEvent.EVENT_SESSION_END /*10011*/:
                            throw new hv(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                        case SpeechEvent.EVENT_VOLUME /*10012*/:
                            throw new hv(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                        case SpeechEvent.EVENT_VAD_EOS /*10013*/:
                            throw new hv(AMapException.AMAP_USER_KEY_RECYCLED);
                        default:
                            switch (i) {
                                case 20000:
                                    throw new hv(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                                case 20001:
                                    throw new hv(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                                case 20002:
                                    throw new hv(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                                case 20003:
                                    throw new hv(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                                default:
                                    switch (i) {
                                        case 30000:
                                            throw new hv(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                        case 30001:
                                            throw new hv(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                        case 30002:
                                            throw new hv(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                        case 30003:
                                            throw new hv(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                        default:
                                            throw new hv(jSONObject.getString("info"));
                                    }
                            }
                    }
                }
            }
        } catch (JSONException unused) {
            throw new hv("协议解析错误 - ProtocolException");
        }
    }

    public static int a(List<LatLng> list) {
        int i = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i2 = 0;
        while (i < list.size() - 1) {
            LatLng latLng = list.get(i);
            i++;
            LatLng latLng2 = list.get(i);
            if (latLng == null || latLng2 == null) {
                return i2;
            }
            i2 = (int) (((float) i2) + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i2;
    }
}
