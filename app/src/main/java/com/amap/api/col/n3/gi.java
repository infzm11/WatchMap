package com.amap.api.col.n3;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.gmap.utils.GLMapStaticValue;
import com.iflytek.cloud.SpeechEvent;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BasicHandler */
public abstract class gi<T, V> extends kj {
    protected T a;
    protected int b = 1;
    protected String c = "";
    protected Context d;
    private int e = 1;

    /* access modifiers changed from: protected */
    public abstract V a(String str) throws gh;

    public Map<String, String> a() {
        return null;
    }

    public Map<String, String> b() {
        return null;
    }

    public gi(Context context, T t) {
        this.d = context;
        this.a = t;
        this.b = 1;
        b(20000);
        a(20000);
    }

    private V a(byte[] bArr) throws gh {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception unused) {
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("status")) {
                String string = jSONObject.getString("status");
                if (!string.equals("1")) {
                    if (!string.equals("0") || jSONObject.has("infocode")) {
                        int i = jSONObject.getInt("infocode");
                        if (string.equals("0")) {
                            if (i != 22000) {
                                switch (i) {
                                    case 10001:
                                        throw new gh(AMapException.AMAP_INVALID_USER_KEY);
                                    case GLMapStaticValue.AM_CALLBACK_NEED_NEXTFRAME /*10002*/:
                                        throw new gh(AMapException.AMAP_SERVICE_NOT_AVAILBALE);
                                    case 10003:
                                        throw new gh(AMapException.AMAP_DAILY_QUERY_OVER_LIMIT);
                                    case SpeechEvent.EVENT_IST_AUDIO_FILE /*10004*/:
                                        throw new gh(AMapException.AMAP_ACCESS_TOO_FREQUENT);
                                    case 10005:
                                        throw new gh(AMapException.AMAP_INVALID_USER_IP);
                                    case SpeechEvent.EVENT_IST_UPLOAD_BYTES /*10006*/:
                                        throw new gh(AMapException.AMAP_INVALID_USER_DOMAIN);
                                    case SpeechEvent.EVENT_IST_CACHE_LEFT /*10007*/:
                                        throw new gh("用户签名未通过");
                                    case SpeechEvent.EVENT_IST_RESULT_TIME /*10008*/:
                                        throw new gh(AMapException.AMAP_INVALID_USER_SCODE);
                                    case SpeechEvent.EVENT_IST_SYNC_ID /*10009*/:
                                        throw new gh(AMapException.AMAP_USERKEY_PLAT_NOMATCH);
                                    case SpeechEvent.EVENT_SESSION_BEGIN /*10010*/:
                                        throw new gh(AMapException.AMAP_IP_QUERY_OVER_LIMIT);
                                    case SpeechEvent.EVENT_SESSION_END /*10011*/:
                                        throw new gh(AMapException.AMAP_NOT_SUPPORT_HTTPS);
                                    case SpeechEvent.EVENT_VOLUME /*10012*/:
                                        throw new gh(AMapException.AMAP_INSUFFICIENT_PRIVILEGES);
                                    case SpeechEvent.EVENT_VAD_EOS /*10013*/:
                                        throw new gh(AMapException.AMAP_USER_KEY_RECYCLED);
                                    default:
                                        switch (i) {
                                            case 20000:
                                                throw new gh(AMapException.AMAP_SERVICE_INVALID_PARAMS);
                                            case 20001:
                                                throw new gh(AMapException.AMAP_SERVICE_MISSING_REQUIRED_PARAMS);
                                            case 20002:
                                                throw new gh(AMapException.AMAP_SERVICE_ILLEGAL_REQUEST);
                                            case 20003:
                                                throw new gh(AMapException.AMAP_SERVICE_UNKNOWN_ERROR);
                                            default:
                                                switch (i) {
                                                    case 20800:
                                                        throw new gh(AMapException.AMAP_ROUTE_OUT_OF_SERVICE);
                                                    case 20801:
                                                        throw new gh(AMapException.AMAP_ROUTE_NO_ROADS_NEARBY);
                                                    case 20802:
                                                        throw new gh(AMapException.AMAP_ROUTE_FAIL);
                                                    case 20803:
                                                        throw new gh(AMapException.AMAP_OVER_DIRECTION_RANGE);
                                                    default:
                                                        switch (i) {
                                                            case 30000:
                                                                throw new gh(AMapException.AMAP_ENGINE_RESPONSE_ERROR);
                                                            case 30001:
                                                                throw new gh(AMapException.AMAP_ENGINE_RESPONSE_DATA_ERROR);
                                                            case 30002:
                                                                throw new gh(AMapException.AMAP_ENGINE_CONNECT_TIMEOUT);
                                                            case 30003:
                                                                throw new gh(AMapException.AMAP_ENGINE_RETURN_TIMEOUT);
                                                            default:
                                                                switch (i) {
                                                                    case 32000:
                                                                        throw new gh(AMapException.AMAP_ENGINE_TABLEID_NOT_EXIST);
                                                                    case 32001:
                                                                        throw new gh(AMapException.AMAP_ID_NOT_EXIST);
                                                                    case 32002:
                                                                        throw new gh(AMapException.AMAP_SERVICE_MAINTENANCE);
                                                                    default:
                                                                        switch (i) {
                                                                            case 32200:
                                                                                throw new gh(AMapException.AMAP_NEARBY_INVALID_USERID);
                                                                            case 32201:
                                                                                throw new gh(AMapException.AMAP_NEARBY_KEY_NOT_BIND);
                                                                            default:
                                                                                throw new gh(jSONObject.getString("info"));
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            } else {
                                throw new gh(AMapException.AMAP_SERVICE_TABLEID_NOT_EXIST);
                            }
                        }
                    } else {
                        throw new gh(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
                    }
                }
            }
        } catch (JSONException unused2) {
            throw new gh("协议解析错误 - ProtocolException");
        } catch (Throwable unused3) {
        }
        return a(str);
    }

    public final V d() throws gh {
        if (this.a != null) {
            return e();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r5 = r2;
        r2 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        throw new com.amap.api.col.n3.gh(com.amap.api.services.core.AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        throw new com.amap.api.col.n3.gh(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        java.lang.Thread.sleep((long) (r6.e * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005d, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0081, code lost:
        throw new com.amap.api.col.n3.gh(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        throw new com.amap.api.col.n3.gh(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (com.amap.api.maps.AMapException.ERROR_CONNECTION.equals(r2.getMessage()) != false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c4, code lost:
        throw new com.amap.api.col.n3.gh(r2.a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        throw new com.amap.api.col.n3.gh(com.amap.api.services.core.AMapException.AMAP_CLIENT_NETWORK_EXCEPTION);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r5 = r2;
        r2 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[ExcHandler: Throwable (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0006] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[SYNTHETIC, Splitter:B:23:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x008a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0039 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0002 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private V e() throws com.amap.api.col.n3.gh {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            int r2 = r6.b
            if (r1 >= r2) goto L_0x00cd
            com.amap.api.col.n3.ki r2 = com.amap.api.col.n3.ki.c()     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            android.content.Context r3 = r6.d     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            java.net.Proxy r3 = com.amap.api.col.n3.ik.a(r3)     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            r6.a((java.net.Proxy) r3)     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            byte[] r2 = r2.a((com.amap.api.col.n3.kj) r6)     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            java.lang.Object r2 = r6.a((byte[]) r2)     // Catch:{ ic -> 0x0043, gh -> 0x0032, Throwable -> 0x002a }
            int r0 = r6.b     // Catch:{ ic -> 0x0025, gh -> 0x0020, Throwable -> 0x002a }
            r1 = r0
            r0 = r2
            goto L_0x0002
        L_0x0020:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0033
        L_0x0025:
            r0 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0044
        L_0x002a:
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = "未知错误"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            r2 = move-exception
        L_0x0033:
            int r1 = r1 + 1
            int r3 = r6.b
            if (r1 < r3) goto L_0x0002
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x0043:
            r2 = move-exception
        L_0x0044:
            int r1 = r1 + 1
            int r3 = r6.b
            if (r1 >= r3) goto L_0x008a
            int r3 = r6.e     // Catch:{ InterruptedException -> 0x0053 }
            int r3 = r3 * 1000
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x0053 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x0053 }
            goto L_0x0002
        L_0x0053:
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0082
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0082
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0078
            goto L_0x0082
        L_0x0078:
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x0082:
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            r0.<init>(r1)
            throw r0
        L_0x008a:
            java.lang.String r0 = "http连接失败 - ConnectionException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "socket 连接异常 - SocketException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "未知的错误"
            java.lang.String r1 = r2.a()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c5
            java.lang.String r0 = "服务器连接失败 - UnknownServiceException"
            java.lang.String r1 = r2.getMessage()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00bb
            goto L_0x00c5
        L_0x00bb:
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = r2.a()
            r0.<init>(r1)
            throw r0
        L_0x00c5:
            com.amap.api.col.n3.gh r0 = new com.amap.api.col.n3.gh
            java.lang.String r1 = "http或socket连接失败 - ConnectionException"
            r0.<init>(r1)
            throw r0
        L_0x00cd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.n3.gi.e():java.lang.Object");
    }
}
