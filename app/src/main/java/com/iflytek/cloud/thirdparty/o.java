package com.iflytek.cloud.thirdparty;

import android.text.TextUtils;
import com.autonavi.ae.guide.GuideControl;

public class o {
    public static byte[] a;
    private ah b;

    public o(ah ahVar) {
        this.b = ahVar;
    }

    public static String a(int i) {
        switch (i) {
            case 1:
                return "idle";
            case 2:
                return "ready";
            case 3:
                return "working";
            default:
                return "idle";
        }
    }

    public void a(String str, String str2, String str3, String str4, byte[] bArr, String str5, String str6) throws n {
        if (TextUtils.isEmpty(str4)) {
            str4 = "null";
        }
        String a2 = al.a("event");
        ce ceVar = new ce();
        ceVar.a("stream_id", a2);
        ceVar.a("event", str);
        ceVar.a("state", str2);
        ceVar.a("last_state", str3);
        ceVar.a("operation", str4);
        ceVar.a("source", str6);
        ceVar.a("scene", ac.a("global", "scene", ""), false);
        ceVar.a("userparams", ac.a());
        if (bArr == null) {
            str5 = "null";
            ceVar.a("event_only", "1");
            bArr = new byte[1];
        } else {
            ceVar.a("event_only", "0");
        }
        ceVar.a("data_type", str5);
        if ("audio".equals(str5)) {
            ceVar = ac.a(ceVar);
        } else {
            ac.b(ceVar);
            ceVar.a(i.a);
        }
        if (this.b != null) {
            ceVar.a("dts", GuideControl.CHANGE_PLAY_TYPE_BBHX);
            this.b.a(ac.c(ceVar), ac.d(ceVar), bArr, bArr.length);
        }
    }
}
