package com.iflytek.cloud.thirdparty;

import android.util.Log;
import com.autonavi.ae.guide.GuideControl;
import com.iflytek.cloud.thirdparty.ae;
import java.util.HashMap;

public class ai {
    private ah a;
    private ae b = ae.a();

    public ai(ah ahVar) {
        this.a = ahVar;
    }

    public void a(String str, byte[] bArr) throws n {
        if (bArr == null) {
            Log.e("TextUploader", "text data is null.");
            return;
        }
        String a2 = al.a("text");
        ce ceVar = new ce();
        ceVar.a(str);
        ceVar.a("stream_id", a2);
        ceVar.a("scene", ac.a("global", "scene", ""), false);
        ceVar.a("userparams", ac.a());
        ceVar.a("data_type", "text");
        ceVar.a(i.a);
        if (this.a != null) {
            ceVar.a("dts", GuideControl.CHANGE_PLAY_TYPE_BBHX);
            String c = ac.c(ceVar);
            String d = ac.d(ceVar);
            cb.a("TextUploader", "params=" + c.toString());
            this.a.a(c, d, bArr, bArr.length);
            this.b.a(a2, new ae.a(Long.valueOf(System.currentTimeMillis()), (Long) null, "", new HashMap()));
            this.b.a(a2, System.currentTimeMillis());
        }
    }
}
