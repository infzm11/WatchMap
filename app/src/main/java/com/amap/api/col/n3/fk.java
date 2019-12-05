package com.amap.api.col.n3;

import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.iflytek.cloud.SpeechEvent;
import org.json.JSONObject;

/* compiled from: RestFront */
public final class fk {
    public static void a(String str, int i) {
        String str2 = "";
        String str3 = "";
        switch (i) {
            case 3:
                str2 = "5030";
                str3 = "起点错误";
                break;
            case 4:
                str2 = "5031";
                str3 = AMapException.AMAP_SERVICE_ILLEGAL_REQUEST;
                break;
            case 5:
                str2 = "5050";
                str3 = "呼叫中心错误";
                break;
            case 6:
                str2 = "5060";
                str3 = "终点错误";
                break;
            case 7:
                str2 = "5070";
                str3 = "算路服务端编码失败";
                break;
            case 8:
                str2 = "5080";
                str3 = "路径数据缺乏预览数据";
                break;
            case 9:
                str2 = "5090";
                str3 = "Buf数据格式错误";
                break;
            case 10:
                str2 = "5100";
                str3 = "起点找不到道路";
                break;
            case 11:
                str2 = "5110";
                str3 = "终点找不到道路";
                break;
            case 12:
                str2 = "5120";
                str3 = "途经点找不到道路";
                break;
            default:
                switch (i) {
                    case 19:
                        str2 = "5042";
                        str3 = "算路失败未知错误";
                        break;
                    case 20:
                        str2 = "5051";
                        str3 = "路径距离太长";
                        break;
                    case 21:
                        str2 = "5210";
                        str3 = "途经点错误";
                        break;
                }
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            iu.a(hq.a(), str, str3, "", str2);
        }
    }

    public static int a(String str, kl klVar) {
        if (klVar == null) {
            return 2;
        }
        try {
            String str2 = klVar.d;
            String str3 = new String(klVar.a, "UTF-8");
            if (!str3.contains("\"status\":\"0\"")) {
                return -1;
            }
            "错误码:" + str3;
            fl flVar = new fl();
            JSONObject jSONObject = new JSONObject(str3);
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            flVar.a(Integer.parseInt(string));
            flVar.a(string2);
            flVar.b(Integer.parseInt(string3));
            if (flVar.a() != 0) {
                return 19;
            }
            iu.a(hq.a(), str, flVar.c(), str2, String.valueOf(flVar.b()));
            switch (flVar.b()) {
                case 10001:
                    return 13;
                case 10003:
                case 10016:
                    return 17;
                case SpeechEvent.EVENT_IST_AUDIO_FILE /*10004*/:
                    return 23;
                case SpeechEvent.EVENT_IST_RESULT_TIME /*10008*/:
                    return 22;
                case SpeechEvent.EVENT_IST_SYNC_ID /*10009*/:
                    return 24;
                case 20000:
                case 20001:
                    return 18;
                case 20800:
                    return 25;
                case 20803:
                    return 26;
                default:
                    return 19;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }
}
