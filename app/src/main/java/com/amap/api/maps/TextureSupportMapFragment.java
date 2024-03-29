package com.amap.api.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.col.n3.dv;
import com.amap.api.col.n3.jp;
import com.amap.api.col.n3.o;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.IMapFragmentDelegate;

public class TextureSupportMapFragment extends Fragment {
    private AMap a;
    private IMapFragmentDelegate b;

    public static TextureSupportMapFragment newInstance() {
        return newInstance(new AMapOptions());
    }

    public static TextureSupportMapFragment newInstance(AMapOptions aMapOptions) {
        TextureSupportMapFragment textureSupportMapFragment = new TextureSupportMapFragment();
        Bundle bundle = new Bundle();
        try {
            Parcel obtain = Parcel.obtain();
            aMapOptions.writeToParcel(obtain, 0);
            bundle.putByteArray("MapOptions", obtain.marshall());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        textureSupportMapFragment.setArguments(bundle);
        return textureSupportMapFragment;
    }

    /* access modifiers changed from: protected */
    public IMapFragmentDelegate getMapFragmentDelegate(Context context) {
        if (this.b == null) {
            try {
                Context context2 = context;
                this.b = (IMapFragmentDelegate) jp.a(context2, dv.f(), "com.amap.api.wrapper.MapFragmentDelegateWrapper", o.class, new Class[]{Integer.TYPE}, new Object[]{1});
            } catch (Throwable unused) {
            }
            if (this.b == null) {
                this.b = new o(1);
                this.b.setContext(context);
            }
        }
        return this.b;
    }

    private IMapFragmentDelegate a() {
        return getMapFragmentDelegate(getActivity());
    }

    public AMap getMap() {
        IMapFragmentDelegate a2 = a();
        if (a2 == null) {
            return null;
        }
        try {
            IAMap map = a2.getMap();
            if (map == null) {
                return null;
            }
            if (this.a == null) {
                this.a = new AMap(map);
            }
            return this.a;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        try {
            getMapFragmentDelegate(activity).onInflate(activity, new AMapOptions(), bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (bundle == null) {
            try {
                bundle = getArguments();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return a().onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onResume() {
        super.onResume();
        try {
            a().onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onPause() {
        super.onPause();
        try {
            a().onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onDestroyView() {
        try {
            a().onDestroyView();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroyView();
    }

    public void onDestroy() {
        try {
            a().onDestroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        try {
            a().onLowMemory();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        try {
            a().onSaveInstanceState(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.onSaveInstanceState(bundle);
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            a().setVisibility(0);
        } else {
            a().setVisibility(8);
        }
    }
}
