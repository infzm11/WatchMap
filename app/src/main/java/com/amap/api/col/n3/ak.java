package com.amap.api.col.n3;

import com.amap.api.maps.model.MultiPointItem;
import com.autonavi.amap.mapcore.IPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: QuadTree2 */
public final class ak {
    private final ah a;
    private final int b;
    private int c;
    private List<MultiPointItem> d;
    private List<ak> e;

    protected ak(ah ahVar) {
        this(ahVar, 0);
    }

    private ak(int i, int i2, int i3, int i4, int i5) {
        this(new ah(i, i2, i3, i4), i5);
    }

    private ak(ah ahVar, int i) {
        int i2 = 30;
        this.c = 30;
        this.e = null;
        this.a = ahVar;
        this.b = i;
        int i3 = 20;
        switch (this.b) {
            case 0:
                i2 = 50;
                break;
            case 1:
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                i3 = 10;
                break;
            default:
                i3 = 5;
                break;
        }
        i3 = i2;
        this.c = i3;
    }

    /* access modifiers changed from: protected */
    public final void a(MultiPointItem multiPointItem) {
        List list;
        int i;
        Object obj;
        IPoint iPoint = multiPointItem.getIPoint();
        if (this.a.a(iPoint.x, iPoint.y)) {
            int i2 = iPoint.x;
            int i3 = iPoint.y;
            ak akVar = this;
            while (true) {
                if (akVar.d == null) {
                    akVar.d = new ArrayList();
                }
                if (akVar.d.size() <= akVar.c || akVar.b >= 40) {
                    akVar.d.add(multiPointItem);
                } else {
                    if (akVar.e == null) {
                        akVar.e = new ArrayList(4);
                        List<ak> list2 = akVar.e;
                        ak akVar2 = new ak(akVar.a.a, akVar.a.e, akVar.a.b, akVar.a.f, akVar.b + 1);
                        list2.add(akVar2);
                        List<ak> list3 = akVar.e;
                        ak akVar3 = new ak(akVar.a.e, akVar.a.c, akVar.a.b, akVar.a.f, akVar.b + 1);
                        list3.add(akVar3);
                        List<ak> list4 = akVar.e;
                        ak akVar4 = new ak(akVar.a.a, akVar.a.e, akVar.a.f, akVar.a.d, akVar.b + 1);
                        list4.add(akVar4);
                        List<ak> list5 = akVar.e;
                        ak akVar5 = new ak(akVar.a.e, akVar.a.c, akVar.a.f, akVar.a.d, akVar.b + 1);
                        list5.add(akVar5);
                    }
                    if (akVar.e != null) {
                        if (i3 < akVar.a.f) {
                            if (i2 < akVar.a.e) {
                                list = akVar.e;
                                i = 0;
                            } else {
                                obj = akVar.e.get(1);
                                akVar = (ak) obj;
                            }
                        } else if (i2 < akVar.a.e) {
                            list = akVar.e;
                            i = 2;
                        } else {
                            list = akVar.e;
                            i = 3;
                        }
                        obj = list.get(i);
                        akVar = (ak) obj;
                    } else {
                        return;
                    }
                }
            }
            akVar.d.add(multiPointItem);
        }
    }

    /* access modifiers changed from: protected */
    public final void a() {
        this.e = null;
        if (this.d != null) {
            this.d.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void a(ah ahVar, Collection<MultiPointItem> collection, double d2) {
        a(ahVar, collection, 1.0f, d2);
    }

    private void a(ah ahVar, Collection<MultiPointItem> collection, float f, double d2) {
        boolean z;
        if (this.a.a(ahVar)) {
            if (this.d != null) {
                int size = (int) (((float) this.d.size()) * f);
                for (int i = 0; i < size; i++) {
                    MultiPointItem multiPointItem = this.d.get(i);
                    IPoint iPoint = multiPointItem.getIPoint();
                    if (iPoint == null) {
                        z = false;
                    } else {
                        z = ahVar.a(iPoint.x, iPoint.y);
                    }
                    if (z) {
                        collection.add(multiPointItem);
                    }
                }
            }
            if (d2 > 0.0d) {
                double d3 = ((((double) this.a.d) - ((double) this.a.b)) * (((double) this.a.c) - ((double) this.a.a))) / d2;
                if (d3 >= 0.7d) {
                    f = d3 > 1.0d ? 1.0f : (float) ((((4.8188d * d3) * d3) - (4.9339d * d3)) + 1.1093d);
                } else {
                    return;
                }
            }
            if (this.e != null) {
                for (ak a2 : this.e) {
                    a2.a(ahVar, collection, f, d2);
                }
            }
        }
    }

    public final ah b() {
        return this.a;
    }
}
