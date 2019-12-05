package com.amap.api.col.n3;

import android.location.Location;
import com.amap.api.navi.model.AMapNaviGuide;
import com.amap.api.navi.model.AMapNaviPath;
import com.amap.api.navi.model.NaviInfo;
import java.util.List;

/* compiled from: ICommon */
public interface ez {
    void a(int i, double d, double d2);

    void a(int i, Location location);

    boolean a(int i);

    void b(int i);

    int c(int i);

    NaviInfo c();

    void d(int i);

    void h();

    void i();

    void j();

    boolean k();

    AMapNaviPath l();

    List<AMapNaviGuide> m();
}
