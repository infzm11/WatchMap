package com.amap.api.maps.model;

import com.amap.api.col.n3.df;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PointQuadTree */
final class a {
    private final df a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<a> d;

    protected a(df dfVar) {
        this(dfVar, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private a(double r11, double r13, double r15, double r17, int r19) {
        /*
            r10 = this;
            com.amap.api.col.n3.df r9 = new com.amap.api.col.n3.df
            r0 = r9
            r1 = r11
            r3 = r13
            r5 = r15
            r7 = r17
            r0.<init>(r1, r3, r5, r7)
            r0 = r10
            r1 = r19
            r0.<init>(r9, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.a.<init>(double, double, double, double, int):void");
    }

    private a(df dfVar, int i) {
        this.d = null;
        this.a = dfVar;
        this.b = i;
    }

    /* access modifiers changed from: protected */
    public final void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }

    private void a(double d2, double d3, WeightedLatLng weightedLatLng) {
        a aVar = this;
        while (aVar.d != null) {
            if (d3 < aVar.a.f) {
                if (d2 < aVar.a.e) {
                    aVar = aVar.d.get(0);
                } else {
                    aVar = aVar.d.get(1);
                }
            } else if (d2 < aVar.a.e) {
                aVar = aVar.d.get(2);
            } else {
                aVar = aVar.d.get(3);
            }
        }
        if (aVar.c == null) {
            aVar.c = new ArrayList();
        }
        aVar.c.add(weightedLatLng);
        if (aVar.c.size() > 50 && aVar.b < 40) {
            aVar.a();
        }
    }

    private void a() {
        this.d = new ArrayList(4);
        List<a> list = this.d;
        a aVar = new a(this.a.a, this.a.e, this.a.b, this.a.f, this.b + 1);
        list.add(aVar);
        List<a> list2 = this.d;
        a aVar2 = new a(this.a.e, this.a.c, this.a.b, this.a.f, this.b + 1);
        list2.add(aVar2);
        List<a> list3 = this.d;
        a aVar3 = new a(this.a.a, this.a.e, this.a.f, this.a.d, this.b + 1);
        list3.add(aVar3);
        List<a> list4 = this.d;
        a aVar4 = new a(this.a.e, this.a.c, this.a.f, this.a.d, this.b + 1);
        list4.add(aVar4);
        List<WeightedLatLng> list5 = this.c;
        this.c = null;
        for (WeightedLatLng next : list5) {
            a(next.getPoint().x, next.getPoint().y, next);
        }
    }

    /* access modifiers changed from: protected */
    public final Collection<WeightedLatLng> a(df dfVar) {
        ArrayList arrayList = new ArrayList();
        a(dfVar, arrayList);
        return arrayList;
    }

    private void a(df dfVar, Collection<WeightedLatLng> collection) {
        if (this.a.a(dfVar)) {
            if (this.d != null) {
                for (a a2 : this.d) {
                    a2.a(dfVar, collection);
                }
            } else if (this.c != null) {
                df dfVar2 = this.a;
                if (dfVar2.a >= dfVar.a && dfVar2.c <= dfVar.c && dfVar2.b >= dfVar.b && dfVar2.d <= dfVar.d) {
                    collection.addAll(this.c);
                    return;
                }
                for (WeightedLatLng next : this.c) {
                    DPoint point = next.getPoint();
                    if (dfVar.a(point.x, point.y)) {
                        collection.add(next);
                    }
                }
            }
        }
    }
}
