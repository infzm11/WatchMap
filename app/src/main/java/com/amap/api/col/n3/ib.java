package com.amap.api.col.n3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TraceResultPool */
public class ib {
    private static ib c;
    private String a;
    private Map<String, a> b;

    /* compiled from: TraceResultPool */
    class a {
        private int b = 0;
        private int c = 0;
        private int d = 0;
        private int e = 0;
        private int f = 0;
        private HashMap<Integer, List<LatLng>> g;
        private List<LatLng> h = new ArrayList();

        public a(int i, int i2, int i3, HashMap<Integer, List<LatLng>> hashMap) {
            this.b = i2;
            this.g = hashMap;
            this.c = i;
            this.e = i3;
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.g;
        }

        public final void a(Handler handler) {
            for (int i = this.d; i <= this.b; i++) {
                List list = this.g.get(Integer.valueOf(i));
                if (list == null) {
                    break;
                }
                this.h.addAll(list);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = list;
                obtainMessage.what = 100;
                obtainMessage.arg1 = this.d;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.c);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                this.d++;
                this.f++;
            }
            if (this.d != this.b + 1) {
                return;
            }
            if (this.f > 0) {
                int a2 = hy.a(this.h);
                Message obtainMessage2 = handler.obtainMessage();
                obtainMessage2.obj = this.h;
                obtainMessage2.what = 101;
                obtainMessage2.arg1 = a2;
                obtainMessage2.arg2 = this.e;
                Bundle bundle2 = new Bundle();
                bundle2.putInt("lineID", this.c);
                obtainMessage2.setData(bundle2);
                handler.sendMessage(obtainMessage2);
                return;
            }
            ib ibVar = ib.this;
            ib.a(handler, this.c, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }
    }

    public ib() {
        this.a = "TraceResultPool";
        this.b = null;
        this.b = Collections.synchronizedMap(new HashMap());
    }

    public static ib a() {
        if (c == null) {
            synchronized (ib.class) {
                if (c == null) {
                    c = new ib();
                }
            }
        }
        return c;
    }

    public final synchronized void a(String str, int i, List<LatLng> list) {
        if (this.b != null) {
            this.b.get(str).a().put(Integer.valueOf(i), list);
        }
    }

    public final synchronized void a(String str, int i, int i2, int i3) {
        if (this.b != null) {
            Map<String, a> map = this.b;
            a aVar = new a(i, i2, i3, new HashMap());
            map.put(str, aVar);
        }
    }

    public final synchronized a a(String str) {
        if (this.b == null) {
            return null;
        }
        return this.b.get(str);
    }

    public static void a(Handler handler, int i, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }
}
