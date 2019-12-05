package com.amap.api.col.n3;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.n3.ie;
import com.amap.api.maps.MapsInitializer;
import com.iflytek.speech.VoiceWakeuperAidl;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AuthTask */
public final class f extends Thread {
    private Context a;
    private k b;

    public f(Context context, k kVar) {
        this.a = context;
        this.b = kVar;
    }

    public final void run() {
        try {
            if (MapsInitializer.getNetWorkEnable()) {
                ie.a a2 = ie.a(this.a, dv.f(), "002" + VoiceWakeuperAidl.PARAMS_SEPARATE + "11K" + VoiceWakeuperAidl.PARAMS_SEPARATE + "001", (Map<String, String>) null);
                if (ie.a != 1) {
                    Message obtainMessage = this.b.getMainHandler().obtainMessage();
                    obtainMessage.what = 2;
                    if (a2.a != null) {
                        obtainMessage.obj = a2.a;
                    }
                    this.b.getMainHandler().sendMessage(obtainMessage);
                }
                if (a2 != null) {
                    if (a2.w != null) {
                        dv.f().a(a2.w.a);
                    }
                    if (a2.y != null) {
                        new il(this.a, "3dmap", a2.y.a, a2.y.b).a();
                    }
                }
                ie.a.C0001a aVar = a2.w;
                if (aVar != null) {
                    ds.a(this.a, "maploc", "ue", Boolean.valueOf(aVar.a));
                    JSONObject jSONObject = aVar.c;
                    int optInt = jSONObject.optInt("fn", 1000);
                    int optInt2 = jSONObject.optInt("mpn", 0);
                    if (optInt2 > 500) {
                        optInt2 = 500;
                    }
                    if (optInt2 < 30) {
                        optInt2 = 30;
                    }
                    ko.a(optInt, ie.a(jSONObject.optString("igu"), false));
                    ds.a(this.a, "maploc", "opn", Integer.valueOf(optInt2));
                }
                if (!(a2 == null || a2.x == null)) {
                    ie.a.d dVar = a2.x;
                    if (dVar != null) {
                        String str = dVar.b;
                        String str2 = dVar.a;
                        String str3 = dVar.c;
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                            if (!TextUtils.isEmpty(str3)) {
                                new jn(this.a, new jo(str2, str), dv.f()).a();
                            }
                        }
                        new jn(this.a, (jo) null, dv.f()).a();
                    } else {
                        new jn(this.a, (jo) null, dv.f()).a();
                    }
                }
                iu.a(this.a, dv.f());
                interrupt();
                this.b.setRunLowFrame(false);
            }
        } catch (Throwable th) {
            interrupt();
            iu.b(th, "AMapDelegateImpGLSurfaceView", "mVerfy");
            th.printStackTrace();
        }
    }
}
