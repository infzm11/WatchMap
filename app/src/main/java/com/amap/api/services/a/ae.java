package com.amap.api.services.a;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.autonavi.ae.guide.GuideControl;
import com.iflytek.clientadapter.constant.FocusType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShareUrlSearchHandler */
public class ae extends a<String, String> {
    private String i;

    public ae(Context context, String str) {
        super(context, str);
        this.i = str;
    }

    public Map<String, String> d() {
        byte[] bArr;
        StringBuilder sb = new StringBuilder();
        sb.append("channel=open_api");
        sb.append("&flag=1");
        sb.append("&address=" + URLEncoder.encode(this.i));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("open_api");
        stringBuffer.append("1");
        stringBuffer.append(this.i);
        stringBuffer.append("@");
        stringBuffer.append("8UbJH6N2szojnTHONAWzB6K7N1kaj7Y0iUMarxac");
        String b = bf.b(stringBuffer.toString());
        sb.append("&sign=");
        sb.append(b.toUpperCase(Locale.US));
        sb.append("&output=json");
        try {
            bArr = ak.a(sb.toString().getBytes("utf-8"), "Yaynpa84IKOfasFx".substring(0, 16).getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            i.a(e, "ShareUrlSearchHandler", "getParams");
            bArr = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ent", "2");
        hashMap.put("in", be.a(bArr));
        hashMap.put("keyt", "openapi");
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String a = n.a(jSONObject, "code");
            String a2 = n.a(jSONObject, FocusType.message);
            if ("1".equals(a)) {
                return n.a(jSONObject, "transfer_url");
            }
            if ("0".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_UNKNOWN_ERROR, 0, a2);
            } else if ("2".equals(a)) {
                throw new AMapException(AMapException.AMAP_SHARE_FAILURE, 0, a2);
            } else if ("3".equals(a)) {
                throw new AMapException(AMapException.AMAP_SERVICE_INVALID_PARAMS, 0, a2);
            } else if ("4".equals(a)) {
                throw new AMapException("用户签名未通过", 0, a2);
            } else if (!GuideControl.CHANGE_PLAY_TYPE_BBHX.equals(a)) {
                return null;
            } else {
                throw new AMapException(AMapException.AMAP_SHARE_LICENSE_IS_EXPIRED, 0, a2);
            }
        } catch (JSONException e) {
            i.a(e, "ShareUrlSearchHandler", "paseJSON");
            return null;
        }
    }

    public String i() {
        return h.e();
    }

    /* access modifiers changed from: protected */
    public byte[] a(int i2, dc dcVar, dd ddVar) throws ay {
        if (i2 == 1) {
            return dcVar.c(ddVar);
        }
        if (i2 == 2) {
            return dcVar.d(ddVar);
        }
        return null;
    }
}
