package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.services.a.aq;
import com.amap.api.services.a.ay;
import com.amap.api.services.a.cj;
import com.amap.api.services.a.h;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

public final class Inputtips {
    private IInputtipsSearch a = null;

    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) {
        try {
            Context context2 = context;
            this.a = (IInputtipsSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.InputtipsSearchWrapper", aq.class, new Class[]{Context.class, InputtipsListener.class}, new Object[]{context, inputtipsListener});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new aq(context, inputtipsListener);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        try {
            Context context2 = context;
            this.a = (IInputtipsSearch) cj.a(context2, h.a(true), "com.amap.api.services.dynamic.InputtipsSearchWrapper", aq.class, new Class[]{Context.class, InputtipsQuery.class}, new Object[]{context, inputtipsQuery});
        } catch (ay e) {
            e.printStackTrace();
        }
        if (this.a == null) {
            try {
                this.a = new aq(context, inputtipsQuery);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public InputtipsQuery getQuery() {
        if (this.a != null) {
            return this.a.getQuery();
        }
        return null;
    }

    public void setQuery(InputtipsQuery inputtipsQuery) {
        if (this.a != null) {
            this.a.setQuery(inputtipsQuery);
        }
    }

    public void setInputtipsListener(InputtipsListener inputtipsListener) {
        if (this.a != null) {
            this.a.setInputtipsListener(inputtipsListener);
        }
    }

    public void requestInputtipsAsyn() {
        if (this.a != null) {
            this.a.requestInputtipsAsyn();
        }
    }

    public List<Tip> requestInputtips() throws AMapException {
        if (this.a != null) {
            return this.a.requestInputtips();
        }
        return null;
    }

    public void requestInputtips(String str, String str2) throws AMapException {
        if (this.a != null) {
            this.a.requestInputtips(str, str2);
        }
    }

    public void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (this.a != null) {
            this.a.requestInputtips(str, str2, str3);
        }
    }
}
