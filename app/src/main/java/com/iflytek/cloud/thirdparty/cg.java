package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.iflytek.aiui.AIUIConstant;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.cloud.Setting;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.Version;
import com.iflytek.cloud.util.AudioDetector;

public class cg {
    private static String a = "xiaoyan";
    private static String b;

    public static int a(be beVar) {
        if (beVar == null || !beVar.m()) {
            return AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED;
        }
        return 5000;
    }

    public static String a() {
        return SpeechUtility.getUtility().getParameter("appid");
    }

    public static String a(Context context) {
        ce a2;
        if (context == null) {
            return "null";
        }
        String str = a2.e("os.imsi") + "|" + bp.a(context).e("os.imei");
        if (str.length() < 10) {
            str = a2.e("net.mac");
        }
        if (TextUtils.isEmpty(str) || str.length() <= 0) {
            return null;
        }
        return str;
    }

    public static String a(Context context, be beVar) throws SpeechError {
        if (context == null) {
            throw new SpeechError(20012);
        }
        ce b2 = beVar.x().clone();
        b = b2.b(SpeechConstant.NET_TYPE, b);
        a(context, b2);
        b2.a(SpeechConstant.NET_TIMEOUT, "20000", false);
        b2.a("auth", "1", false);
        b2.a("msc.ver", Version.getVersion());
        b2.a("mac", bp.a(context).e("net.mac"), false);
        b2.a("dvc", a(context), false);
        b2.a("unique_id", ca.a(context));
        b2.a("msc.lat", "" + br.a(context).a("msc.lat"), false);
        b2.a("msc.lng", "" + br.a(context).a("msc.lng"), false);
        b2.a(bp.b(context));
        a(b2);
        b(context, b2);
        b2.a(cf.c);
        return b2.toString();
    }

    public static String a(Context context, String str, be beVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        ce b2 = beVar.x().clone();
        b2.c(SpeechConstant.CLOUD_GRAMMAR);
        a(context, b2);
        b(context, b2);
        b2.a("language", "zh_cn", false);
        b2.a("accent", "mandarin", false);
        b2.a(SpeechConstant.RESULT_TYPE, "json", false);
        b2.a("rse", beVar.s(), false);
        b2.a(SpeechConstant.TEXT_ENCODING, beVar.r(), false);
        b2.a("ssm", "1", false);
        b2.a("msc.skin", "0", false);
        if (TextUtils.isEmpty(str)) {
            str2 = SpeechConstant.SUBJECT;
            str3 = "iat";
        } else {
            str2 = SpeechConstant.SUBJECT;
            str3 = "asr";
        }
        b2.a(str2, str3, false);
        int t = beVar.t();
        b2.a("auf=audio/L16;rate", Integer.toString(t), false);
        if (t == 16000) {
            str4 = "aue";
            str5 = "speex-wb";
        } else {
            str4 = "aue";
            str5 = "speex";
        }
        b2.a(str4, str5, false);
        b2.a("vad_bos", Integer.toString(a(beVar)), false);
        b2.a("vad_eos", Integer.toString(b(beVar)), false);
        if (b2.a(SpeechConstant.DVC_INFO, false)) {
            a(context, b2);
            b2.a("dvc", a(context), false);
            b2.a("unique_id", ca.a(context));
            b2.a("msc.lat", "" + br.a(context).a("msc.lat"), false);
            b2.a("msc.lng", "" + br.a(context).a("msc.lng"), false);
            String a2 = bp.a(bp.e(context));
            String f = bp.f(context);
            b2.a("user_agent", a2, false);
            b2.a("device_type", f, false);
            b2.a(bp.b(context));
        }
        b2.a(cf.c);
        return b2.toString();
    }

    public static void a(Context context, ce ceVar) {
        String str;
        String str2;
        if (TextUtils.isEmpty(ceVar.e(SpeechConstant.NET_TYPE)) && !TextUtils.isEmpty(b)) {
            str = SpeechConstant.NET_TYPE;
            str2 = b;
        } else if (context == null) {
            str = SpeechConstant.NET_TYPE;
            str2 = "none";
        } else {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    ceVar.a(SpeechConstant.NET_TYPE, "none", false);
                    return;
                }
                ceVar.a(SpeechConstant.NET_TYPE, bz.a(activeNetworkInfo), false);
                ceVar.a("net_subtype", ce.f(bz.b(activeNetworkInfo)), false);
                return;
            } catch (SecurityException e) {
                cb.b("appendNetProxyParam exceptoin: " + e.getLocalizedMessage());
                return;
            } catch (Throwable th) {
                cb.a(th);
                return;
            }
        }
        ceVar.a(str, str2, false);
    }

    private static void a(ce ceVar) {
        if (ceVar != null && Setting.getLogLevel() != Setting.LOG_LEVEL.none) {
            String logPath = Setting.getLogPath();
            if (TextUtils.isEmpty(logPath)) {
                logPath = "/sdcard/msc/msc.log";
            }
            int i = -1;
            if (Setting.getLogLevel() == Setting.LOG_LEVEL.detail) {
                i = 31;
            } else if (Setting.getLogLevel() == Setting.LOG_LEVEL.normal) {
                i = 15;
            } else if (Setting.getLogLevel() == Setting.LOG_LEVEL.low) {
                i = 7;
            }
            bv.b(logPath);
            ceVar.a("log", logPath);
            ceVar.a("lvl", "" + i);
            ceVar.a("output", "1", false);
        }
    }

    public static boolean a(String str) {
        if (str != null) {
            return str.contains(FocusType.sms) || str.contains("iat");
        }
        return false;
    }

    public static int b(be beVar) {
        return (beVar == null || !beVar.m()) ? AudioDetector.DEF_EOS : AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING;
    }

    public static String b(Context context, be beVar) {
        String str;
        String str2;
        ce b2 = beVar.x().clone();
        a(context, b2);
        b(context, b2);
        b2.a(SpeechConstant.RESULT_TYPE, "json");
        b2.a("rse", beVar.s());
        b2.a(SpeechConstant.TEXT_ENCODING, beVar.r());
        b2.a("ssm", "1", false);
        b2.a(SpeechConstant.SUBJECT, SpeechConstant.ENG_IVP, false);
        int t = beVar.t();
        b2.a("auf=audio/L16;rate", Integer.toString(t), false);
        if (t == 16000) {
            str = "aue";
            str2 = "speex-wb;10";
        } else {
            str = "aue";
            str2 = "speex";
        }
        b2.a(str, str2, false);
        b2.a("vad_bos", "3000", false);
        b2.a("vad_eos", "700", false);
        b2.a(cf.c);
        return b2.toString();
    }

    public static String b(Context context, String str, be beVar) {
        String str2;
        String str3;
        ce b2 = beVar.x().clone();
        a(context, b2);
        b(context, b2);
        b2.a("sub", "mfv", false);
        b2.a("prot_ver", "50", false);
        b2.a("mver", "2.0", false);
        b2.a(AIUIConstant.KEY_SERVER_URL, "http://imfv.openspeech.cn/msp.do", false);
        if ("verify".equals(b2.e("sst"))) {
            str2 = "scene_mode";
            str3 = "vfy";
        } else {
            str2 = "scene_mode";
            str3 = "gen";
        }
        b2.a(str2, str3, false);
        b2.a(cf.c);
        return b2.toString();
    }

    public static void b(Context context, ce ceVar) {
        int i;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (context != null && br.b(context)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int phoneType = telephonyManager.getPhoneType();
                String networkOperator = telephonyManager.getNetworkOperator();
                int i2 = 0;
                int parseInt = Integer.parseInt(networkOperator.substring(0, 3));
                int parseInt2 = Integer.parseInt(networkOperator.substring(3));
                switch (phoneType) {
                    case 1:
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                        i2 = gsmCellLocation.getCid();
                        i = gsmCellLocation.getLac();
                        break;
                    case 2:
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                        i2 = cdmaCellLocation.getBaseStationId();
                        i = cdmaCellLocation.getNetworkId();
                        break;
                    default:
                        i = 0;
                        break;
                }
                ceVar.a("mmlc", parseInt + "|" + parseInt2 + "|" + i + "|" + i2);
                cb.d("MCC = " + parseInt + "\t MNC = " + parseInt2 + "\t phoneType = " + phoneType + "\t LAC = " + i + "\t CID = " + i2);
            } catch (Exception unused) {
                cb.d("get mmlc failed");
            }
            cb.d("get mmlc time cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private static void b(ce ceVar) {
        String str;
        String str2;
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null) {
            String parameter = utility.getParameter("ver_tts");
            if (!ceVar.g("speed_increase")) {
                int a2 = ceVar.a(SpeechConstant.SPEED, 50);
                if (a2 <= 100) {
                    ceVar.a(SpeechConstant.SPEED, "" + a2);
                    str = "speed_increase";
                    str2 = "1";
                } else if (100 < a2 && a2 <= 150 && (TextUtils.isEmpty(parameter) || parameter.contains("5.5."))) {
                    ceVar.a(SpeechConstant.SPEED, "" + (a2 - 50));
                    str = "speed_increase";
                    str2 = "2";
                } else if (100 < a2 && a2 <= 200) {
                    ceVar.a(SpeechConstant.SPEED, "" + (a2 - 100));
                    str = "speed_increase";
                    str2 = "4";
                } else {
                    return;
                }
                ceVar.a(str, str2);
            }
        }
    }

    public static String c(Context context, be beVar) {
        ce b2 = beVar.x().clone();
        a(context, b2);
        b(context, b2);
        b2.a("ssm", "1", false);
        b2.a(SpeechConstant.RESULT_TYPE, "json", false);
        b2.a("rse", beVar.s(), false);
        b2.a(SpeechConstant.TEXT_ENCODING, beVar.r(), false);
        b2.a(cf.c);
        return b2.toString();
    }

    public static String c(Context context, ce ceVar) {
        ce b2 = ceVar.clone();
        SpeechUtility utility = SpeechUtility.getUtility();
        if (utility != null) {
            b2.a("appid", utility.getParameter("appid"));
        }
        b2.a(bp.b(context));
        b2.a("dvc", a(context), false);
        b2.a("aue", "raw", false);
        b2.a(cf.c);
        return b2.toString();
    }

    public static String d(Context context, be beVar) {
        String str;
        String str2;
        ce b2 = beVar.x().clone();
        a(context, b2);
        b(context, b2);
        b2.a("ssm", "1", false);
        int t = beVar.t();
        b2.a("auf=audio/L16;rate", Integer.toString(t));
        if (t == 16000) {
            str = "aue";
            str2 = "speex-wb";
        } else {
            str = "aue";
            str2 = "speex";
        }
        b2.a(str, str2, false);
        b2.a(SpeechConstant.VOICE_NAME, b2.b(SpeechConstant.VOICE_NAME, a), true);
        b2.a(SpeechConstant.TEXT_ENCODING, beVar.r(), false);
        b(b2);
        b2.a(cf.c);
        return b2.toString();
    }

    public static String e(Context context, be beVar) {
        String str;
        String str2;
        ce b2 = beVar.x().clone();
        a(context, b2);
        b(context, b2);
        b2.a("ssm", "1", false);
        int t = beVar.t();
        b2.a("auf=audio/L16;rate", Integer.toString(t), false);
        if (t == 16000) {
            str = "aue";
            str2 = "speex-wb";
        } else {
            str = "aue";
            str2 = "speex";
        }
        b2.a(str, str2, false);
        b2.a(SpeechConstant.TEXT_ENCODING, beVar.r(), false);
        b2.a("plev", "1", false);
        b2.a("accent", "mandarin", false);
        b2.a(SpeechConstant.DOMAIN, "ise", false);
        b2.a(SpeechConstant.SUBJECT, "ise", false);
        b2.a(SpeechConstant.RESULT_TYPE, "xml", false);
        b2.a("vad_bos", "5000", false);
        b2.a("vad_eos", "1800", false);
        b2.a("vad_speech_timeout", "2147483647", false);
        b2.a(cf.c);
        return b2.toString();
    }
}
