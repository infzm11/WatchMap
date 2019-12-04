package com.iflytek.sunflower.task;

import android.content.Context;
import com.iflytek.sunflower.OnlineConfigListener;
import com.iflytek.sunflower.a.a;
import com.iflytek.sunflower.util.d;
import com.iflytek.sunflower.util.j;
import org.apache.http.util.EncodingUtils;
import org.json.JSONObject;

public class f extends Thread {
    a.C0007a a = new a.C0007a() {
        public void a(byte[] bArr) {
        }

        public void a(a aVar, byte[] bArr) {
            if (bArr != null) {
                try {
                    f.this.a(new JSONObject(EncodingUtils.getString(d.b(bArr), "utf-8")));
                } catch (Exception e) {
                    j.d("Collector", "data error");
                    a(e);
                }
            }
        }

        public void a(Exception exc) {
            j.c("Collector", "get online config error:" + exc);
        }
    };

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
    }

    public f(Context context, OnlineConfigListener onlineConfigListener) {
    }

    public void run() {
        super.run();
        a();
    }
}
