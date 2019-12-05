package com.amap.api.col.n3;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.amap.api.col.n3.gn;
import com.amap.api.col.n3.gz;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Poi;
import com.amap.api.navi.view.LoadingView;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.hoinnet.highde.R;
import com.iflytek.aiui.AIUIConstant;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SearchPage */
public final class gg extends fu implements TextWatcher, View.OnClickListener, View.OnTouchListener, AdapterView.OnItemClickListener, gn.a, gz.a {
    private InputMethodManager A = null;
    private Poi B;
    private final String j = "SearchPage";
    private String k = "北京";
    private String l = "输入起点";
    private String m = "";
    private int n;
    private int o;
    private AutoCompleteTextView p;
    private ListView q;
    private List<he> r;
    private fw s;
    private ProgressBar t;
    private RelativeLayout u;
    private ImageView v;
    private View w;
    private TextView x;
    private LoadingView y;
    private ImageView z;

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void e() {
    }

    public final void a(Bundle bundle) {
        super.a(bundle);
        this.i.setRequestedOrientation(1);
        try {
            this.A = (InputMethodManager) this.i.getSystemService("input_method");
            if (bundle != null) {
                this.k = bundle.getString(DistrictSearchQuery.KEYWORDS_CITY, "北京");
                this.l = bundle.getString("hint", "请输入位置");
                this.m = bundle.getString(AIUIConstant.KEY_CONTENT, "");
                this.n = bundle.getInt("input_type", 0);
                this.o = bundle.getInt("input_type_mid", 0);
            }
            this.p = (AutoCompleteTextView) this.u.findViewById(2131296437);
            this.q = (ListView) this.u.findViewById(2131296320);
            this.t = (ProgressBar) this.u.findViewById(2131296438);
            this.x = (TextView) this.u.findViewById(2131296318);
            this.v = (ImageView) this.u.findViewById(2131296431);
            this.w = this.u.findViewById(2131296440);
            this.y = (LoadingView) this.u.findViewById(2131296319);
            this.z = (ImageView) this.u.findViewById(2131296439);
            "SearchPage-->onCreate(),city=" + this.k + ",content=" + this.m;
            this.q.setOnItemClickListener(this);
            this.q.setOnTouchListener(this);
            this.v.setOnTouchListener(this);
            this.w.setOnClickListener(this);
            this.A.showSoftInput(this.p, 0);
            this.x.setVisibility(8);
            this.y.setVisibility(8);
            this.z.setOnClickListener(this);
            this.p.addTextChangedListener(this);
            this.p.setHint(this.l);
            this.p.setText(this.m);
            this.p.requestFocus();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onClick(View view) {
        a(view);
    }

    public final void a(View view) {
        try {
            switch (view.getId()) {
                case 2131296439:
                    this.p.setText("");
                    return;
                case 2131296440:
                    i();
                    Poi a = this.i.getSearchResult().a();
                    Bundle bundle = new Bundle();
                    bundle.putInt("from", 3);
                    bundle.putBoolean("needRecalculate", false);
                    if (b(a) && c(a)) {
                        bundle.putBoolean("needRecalculate", true);
                    }
                    bundle.putInt("input_type", this.n);
                    bundle.putInt("input_type_mid", this.o);
                    this.i.closeScr(bundle);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    private void i() {
        View peekDecorView = this.i.getWindow().peekDecorView();
        if (peekDecorView != null) {
            ((InputMethodManager) this.i.getSystemService("input_method")).hideSoftInputFromWindow(peekDecorView.getWindowToken(), 0);
        }
    }

    public final RelativeLayout d() {
        try {
            this.u = (RelativeLayout) hs.a(this.i, R.attr.actionBarTabStyle, (ViewGroup) null);
            return this.u;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void f() {
        super.f();
    }

    public final void g() {
        super.g();
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        try {
            if (!hq.b(this.u.getContext())) {
                this.x.setText("当前网络不可用，无法进行搜索");
                this.x.setVisibility(0);
                a(false);
                return;
            }
            if (this.x.getVisibility() == 0) {
                this.x.setVisibility(8);
            }
            String trim = charSequence.toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                a(true);
                gn gnVar = new gn(this.i.getApplicationContext(), new gp(trim, this.k));
                gnVar.a(this);
                gnVar.a();
                return;
            }
            this.z.setVisibility(8);
            this.q.setVisibility(8);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.p.getText().toString())) {
            this.z.setVisibility(8);
        }
    }

    public final void a(List<he> list, int i) {
        a(false);
        try {
            if (!TextUtils.isEmpty(this.p.getText().toString())) {
                this.z.setVisibility(0);
            }
            if (i == 1000) {
                this.r = new ArrayList();
                for (he next : list) {
                    if (next.b() != null) {
                        this.r.add(next);
                    }
                }
                if (this.r != null) {
                    if (!this.r.isEmpty()) {
                        this.q.setVisibility(0);
                        this.s = new fw(this.i.getApplicationContext(), this.r);
                        this.q.setAdapter(this.s);
                        this.s.notifyDataSetChanged();
                        return;
                    }
                }
                this.x.setText("抱歉，没有搜索到结果，请换个关键词试试");
                this.x.setVisibility(0);
                this.q.setVisibility(8);
                return;
            }
            this.x.setText("出错了，请稍后重试");
            this.x.setVisibility(0);
        } catch (Throwable unused) {
            this.x.setText("出错了，请稍后重试");
            this.x.setVisibility(0);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j2) {
        try {
            if (this.r != null) {
                he heVar = (he) adapterView.getItemAtPosition(i);
                this.B = new Poi(heVar.c(), new LatLng(heVar.b().b(), heVar.b().a()), heVar.a());
                if (!TextUtils.isEmpty(this.B.getPoiId())) {
                    gz.b bVar = new gz.b(this.B.getName(), "", this.k);
                    bVar.b();
                    bVar.a();
                    gz gzVar = new gz(this.i, bVar);
                    gzVar.a((gz.a) this);
                    gzVar.b(this.B.getPoiId());
                    b();
                    return;
                }
                a(this.B);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Poi poi) {
        Bundle bundle = new Bundle();
        bundle.putInt("from", 3);
        bundle.putBoolean("needRecalculate", false);
        if (b(poi) && c(poi)) {
            bundle.putBoolean("needRecalculate", true);
        }
        bundle.putInt("input_type", this.n);
        bundle.putInt("input_type_mid", this.o);
        this.i.closeScr(bundle);
    }

    public final boolean a() {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("from", 3);
            bundle.putBoolean("needRecalculate", false);
            bundle.putInt("input_type", this.n);
            bundle.putInt("input_type_mid", this.o);
            this.i.closeScr(bundle);
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (view.getId() != 2131296431) {
                this.A.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } else {
                i();
                a();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean b(Poi poi) {
        Poi b = this.i.getSearchResult().b();
        Poi f = this.i.getSearchResult().f();
        Poi c = this.i.getSearchResult().c();
        Poi d = this.i.getSearchResult().d();
        Poi e = this.i.getSearchResult().e();
        String str = "";
        if (this.n != 0) {
            if (this.n != 1) {
                if (this.n == 2) {
                    switch (this.o) {
                        case 0:
                            if (c == null || !c.getCoordinate().equals(poi.getCoordinate())) {
                                if (b != null && (b.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(b.getName()))) {
                                    str = "途径点1坐标与起点坐标一样";
                                }
                                if (f != null && (f.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(f.getName()))) {
                                    str = "途径点1坐标与终点坐标一样";
                                }
                                if (d != null && (d.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(d.getName()))) {
                                    str = "途径点1坐标与途经点2坐标一样";
                                }
                                if (e != null && (e.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(e.getName()))) {
                                    str = "途径点1坐标与途经点3坐标一样";
                                    break;
                                }
                            } else {
                                return false;
                            }
                            break;
                        case 1:
                            if (d == null || !d.getCoordinate().equals(poi.getCoordinate())) {
                                if (b != null && (b.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(b.getName()))) {
                                    str = "途径点2坐标与起点坐标一样";
                                }
                                if (f != null && (f.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(f.getName()))) {
                                    str = "途径点2坐标与终点坐标一样";
                                }
                                if (c != null && (c.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(c.getName()))) {
                                    str = "途径点2坐标与途经点1坐标一样";
                                }
                                if (e != null && (e.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(e.getName()))) {
                                    str = "途径点2坐标与途经点3坐标一样";
                                    break;
                                }
                            } else {
                                return false;
                            }
                            break;
                        case 2:
                            if (e == null || !e.getCoordinate().equals(poi.getCoordinate())) {
                                if (b != null && (b.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(b.getName()))) {
                                    str = "途径点3坐标与起点坐标一样";
                                }
                                if (f != null && (f.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(f.getName()))) {
                                    str = "途径点3坐标与终点坐标一样";
                                }
                                if (c != null && (c.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(c.getName()))) {
                                    str = "途径点3坐标与途经点1坐标一样";
                                }
                                if (d != null && (d.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(d.getName()))) {
                                    str = "途径点3坐标与途经点2坐标一样";
                                    break;
                                }
                            } else {
                                return false;
                            }
                            break;
                    }
                }
            } else if (f != null && f.getCoordinate().equals(poi.getCoordinate())) {
                return false;
            } else {
                if (b != null && ((b.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(b.getName())) && c == null && d == null && e == null)) {
                    str = "起点坐标与终点坐标一样";
                }
                if (c != null && (c.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(c.getName()))) {
                    str = "终点坐标与途经点1坐标一样";
                }
                if (d != null && (d.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(d.getName()))) {
                    str = "终点坐标与途经点2坐标一样";
                }
                if (e != null && (e.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(e.getName()))) {
                    str = "终点坐标与途经点3坐标一样";
                }
            }
        } else if (b != null && b.getCoordinate().equals(poi.getCoordinate())) {
            return false;
        } else {
            if (f != null && ((f.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(f.getName())) && c == null && d == null && e == null)) {
                str = "起点坐标与终点坐标一样";
            }
            if (c != null && (c.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(c.getName()))) {
                str = "起点坐标与途经点1一样";
            }
            if (d != null && (d.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(d.getName()))) {
                str = "起点坐标与途经点2一样";
            }
            if (e != null && (e.getCoordinate().equals(poi.getCoordinate()) || poi.getName().equals(e.getName()))) {
                str = "起点坐标与途经点3一样";
            }
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Toast.makeText(this.i, str, 0).show();
        return false;
    }

    private boolean c(Poi poi) {
        fz searchResult = this.i.getSearchResult();
        if (searchResult == null) {
            return false;
        }
        if (this.n != 0) {
            if (this.n != 1) {
                if (this.n == 2) {
                    switch (this.o) {
                        case 0:
                            searchResult.c(poi);
                            break;
                        case 1:
                            searchResult.d(poi);
                            break;
                        case 2:
                            searchResult.e(poi);
                            break;
                    }
                }
            } else {
                searchResult.f(poi);
            }
        } else {
            searchResult.b(poi);
        }
        if (searchResult.b() == null || searchResult.f() == null) {
            return false;
        }
        return true;
    }

    private void a(boolean z2) {
        if (z2) {
            try {
                this.z.setVisibility(8);
                this.t.setVisibility(0);
                this.y.showLoading();
                this.y.setVisibility(0);
            } catch (Throwable unused) {
            }
        } else {
            this.t.setVisibility(8);
            this.y.hideLoading();
            this.y.setVisibility(8);
        }
    }

    public final void a(gw gwVar, int i) {
        Poi poi;
        try {
            c();
            LatLng latLng = null;
            if (i == 1000) {
                if (gwVar != null) {
                    gs d = gwVar.d();
                    gs c = gwVar.c();
                    if (this.n == 0) {
                        if (d != null) {
                            latLng = new LatLng(d.b(), d.a());
                        } else if (c != null) {
                            latLng = new LatLng(c.b(), c.a());
                        }
                    }
                    if ((this.n == 1 || this.n == 2) && c != null) {
                        latLng = new LatLng(c.b(), c.a());
                    }
                } else {
                    return;
                }
            }
            if (latLng != null) {
                poi = new Poi(this.B.getName(), latLng, this.B.getPoiId());
            } else {
                poi = this.B;
            }
            a(poi);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
