package com.iflytek.sunflower.task;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.iflytek.sunflower.a.b;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.d;
import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.BootEntity;
import com.iflytek.sunflower.entity.CloseEntity;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.entity.EventEntity;
import com.iflytek.sunflower.util.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SendTask extends Thread {
    private b a;
    private Context b;
    private WifiManager c;

    public SendTask(Context context) {
        this.b = context.getApplicationContext();
    }

    public void run() {
        try {
            send();
        } catch (Exception e) {
            j.d("Collector", "send data error:" + e);
        }
    }

    public synchronized void send() {
        try {
            JSONObject a2 = a();
            if (a2 == null) {
                j.a("Collector", "nothing to send");
                return;
            }
            j.b("Collector", "send: " + a2.toString());
            this.a = new b(this.b);
            this.a.a(a2, 0);
        } catch (Throwable th) {
            j.d("Collector", "send message error", th);
        }
        return;
    }

    private JSONObject a() {
        JSONObject e = c.e(this.b);
        if (e.k() == 0 && e == null) {
            return null;
        }
        Iterator<CloseEntity> it = e.d().iterator();
        while (it.hasNext()) {
            e = d.a(it.next(), e);
        }
        Iterator<BootEntity> it2 = e.c().iterator();
        while (it2.hasNext()) {
            e = d.a(it2.next(), e);
        }
        ArrayList<EventEntity> a2 = e.a();
        if (a2.size() != 0) {
            e = d.b(d.a(a2), e);
        }
        ArrayList<ErrorEntity> b2 = e.b();
        if (b2.size() != 0) {
            e = d.a(d.b(b2), e);
        }
        e.j();
        JSONObject a3 = d.a(this.b);
        if (a.i.booleanValue()) {
            a3 = a(a3);
        }
        return d.a(e, a3);
    }

    private List<ScanResult> b() {
        try {
            this.c = (WifiManager) this.b.getSystemService("wifi");
            if (this.c == null || !this.c.isWifiEnabled()) {
                return null;
            }
            return this.c.getScanResults();
        } catch (Exception e) {
            j.c("Collector", "get wifimanager failed:" + e);
            return null;
        }
    }

    private JSONObject a(JSONObject jSONObject) {
        List<ScanResult> b2 = b();
        if (b2 != null && b2.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                for (ScanResult next : b2) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("name", next.SSID);
                    jSONObject2.put("addr", next.BSSID);
                    jSONObject2.put("level", next.level);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("wf_list", jSONArray);
            } catch (JSONException unused) {
                j.c("Collector", "merger wifilist to json failed");
            }
        }
        return jSONObject;
    }
}
