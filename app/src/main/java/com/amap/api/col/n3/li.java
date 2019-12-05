package com.amap.api.col.n3;

/* compiled from: Beacon */
public final class li implements Comparable<li> {
    public String a;
    public String b;
    public byte[] c;
    public String d;
    public String e;
    public int f;
    public int g;
    public long h;
    public int i;

    public final /* synthetic */ int compareTo(Object obj) {
        li liVar = (li) obj;
        if (this.g < liVar.g) {
            return 1;
        }
        return (this.g == liVar.g || this.g <= liVar.g) ? 0 : -1;
    }

    public final String toString() {
        return "name = " + this.b + ",uuid = " + this.a + ",major = " + this.d + ",minor = " + this.e + ",TxPower = " + this.f + ",rssi = " + this.g + ",time = " + this.h;
    }
}
