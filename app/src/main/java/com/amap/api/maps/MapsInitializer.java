package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.col.n3.Cif;
import com.amap.api.col.n3.g;
import com.amap.api.col.n3.o;
import com.autonavi.ae.gmap.GLMapEngine;

public final class MapsInitializer {
    private static boolean a = true;
    public static String sdcardDir = "";

    public static String getVersion() {
        return "5.4.0";
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            o.a = context.getApplicationContext();
        }
    }

    public static void setNetWorkEnable(boolean z) {
        a = z;
    }

    public static boolean getNetWorkEnable() {
        return a;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            Cif.a(str);
        }
    }

    public static void loadWorldGridMap(boolean z) {
        g.c = z ^ true ? 1 : 0;
    }

    public static void setBuildingHeight(int i) {
        GLMapEngine.BUILDINGHEIGHT = i;
    }
}
