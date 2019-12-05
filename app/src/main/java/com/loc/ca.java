package com.loc;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BeaconManager */
public final class ca {
    BluetoothAdapter a = null;
    boolean b = false;
    a c = null;
    Object d = new Object();
    /* access modifiers changed from: private */
    public ArrayList<bz> e = new ArrayList<>();
    private ArrayList<bz> f = new ArrayList<>();
    private boolean g = false;
    private Map<String, String> h = new HashMap();

    @SuppressLint({"NewApi"})
    /* compiled from: BeaconManager */
    class a implements BluetoothAdapter.LeScanCallback {
        a() {
        }

        public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            try {
                bz a2 = ca.this.a(bluetoothDevice, i, bArr);
                synchronized (ca.this.d) {
                    int i2 = 0;
                    while (i2 < ca.this.e.size()) {
                        bz bzVar = (bz) ca.this.e.get(i2);
                        if (bzVar.h.equals(a2.h)) {
                            ca.this.e.remove(bzVar);
                            ca.this.e.add(a2);
                            return;
                        }
                        if (da.b() - bzVar.i > 3000) {
                            ca.this.e.remove(bzVar);
                            i2--;
                        }
                        i2++;
                    }
                    ca.this.e.add(a2);
                }
            } catch (Throwable th) {
                cs.a(th, "APS", "onLeScan");
            }
        }
    }

    public ca(Context context) {
        try {
            if (context.checkCallingOrSelfPermission("android.permission.BLUETOOTH_ADMIN") == 0 && context.checkCallingOrSelfPermission("android.permission.BLUETOOTH") == 0) {
                this.g = true;
            }
            if (da.c() >= 18 && this.g) {
                this.a = BluetoothAdapter.getDefaultAdapter();
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9 A[Catch:{ Throwable -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d6 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.loc.bz a(android.bluetooth.BluetoothDevice r19, int r20, byte[] r21) {
        /*
            r18 = this;
            r1 = r21
            long r12 = com.loc.da.b()     // Catch:{ Throwable -> 0x00dc }
            r14 = r18
            java.lang.String r3 = r14.a((byte[]) r1)     // Catch:{ Throwable -> 0x00da }
            int r4 = r3.length()     // Catch:{ Throwable -> 0x00da }
            r5 = 16
            r6 = 0
            if (r4 != r5) goto L_0x002a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00da }
            r4.<init>()     // Catch:{ Throwable -> 0x00da }
            r4.append(r3)     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = "0000000000000000"
            r4.append(r3)     // Catch:{ Throwable -> 0x00da }
        L_0x0022:
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x00da }
            r4 = r3
            r9 = r6
            r10 = r9
            goto L_0x0095
        L_0x002a:
            int r4 = r3.length()     // Catch:{ Throwable -> 0x00da }
            r7 = 12
            if (r4 != r7) goto L_0x0040
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00da }
            r4.<init>()     // Catch:{ Throwable -> 0x00da }
            r4.append(r3)     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = "00000000000000000000"
            r4.append(r3)     // Catch:{ Throwable -> 0x00da }
            goto L_0x0022
        L_0x0040:
            byte[] r3 = new byte[r5]     // Catch:{ Throwable -> 0x00da }
            r4 = 9
            java.lang.System.arraycopy(r1, r4, r3, r6, r5)     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = com.loc.da.b((byte[]) r3)     // Catch:{ Throwable -> 0x00da }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00da }
            r4.<init>()     // Catch:{ Throwable -> 0x00da }
            r7 = 32
            java.lang.String r3 = r3.substring(r6, r7)     // Catch:{ Throwable -> 0x00da }
            r4.append(r3)     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = r4.toString()     // Catch:{ Throwable -> 0x00da }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = r3.toUpperCase(r4)     // Catch:{ Throwable -> 0x00da }
            r4 = 25
            byte r4 = r1[r4]     // Catch:{ Throwable -> 0x00da }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 * 256
            r7 = 26
            byte r7 = r1[r7]     // Catch:{ Throwable -> 0x00da }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r7
            r7 = 27
            byte r7 = r1[r7]     // Catch:{ Throwable -> 0x00da }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r7 = r7 * 256
            r8 = 28
            byte r8 = r1[r8]     // Catch:{ Throwable -> 0x00da }
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r7 = r7 + r8
            r8 = 11669(0x2d95, float:1.6352E-41)
            if (r7 == r8) goto L_0x00d8
            r8 = 2080(0x820, float:2.915E-42)
            if (r4 == r8) goto L_0x00d8
            r8 = 1796(0x704, float:2.517E-42)
            if (r4 == r8) goto L_0x00d8
            if (r19 != 0) goto L_0x0092
            goto L_0x00d8
        L_0x0092:
            r9 = r4
            r10 = r7
            r4 = r3
        L_0x0095:
            r3 = 29
            byte r1 = r1[r3]     // Catch:{ Throwable -> 0x00da }
            java.lang.String r7 = r19.getAddress()     // Catch:{ Throwable -> 0x00da }
            java.util.Locale r3 = java.util.Locale.CHINA     // Catch:{ Throwable -> 0x00da }
            java.lang.String r3 = r7.toUpperCase(r3)     // Catch:{ Throwable -> 0x00da }
            boolean r3 = android.bluetooth.BluetoothAdapter.checkBluetoothAddress(r3)     // Catch:{ Throwable -> 0x00da }
            if (r3 == 0) goto L_0x00d6
            java.lang.String r3 = ":"
            java.lang.String[] r3 = r7.split(r3)     // Catch:{ Throwable -> 0x00da }
            r11 = 6
            byte[] r11 = new byte[r11]     // Catch:{ Throwable -> 0x00da }
            int r15 = r3.length     // Catch:{ Throwable -> 0x00da }
            r16 = r6
        L_0x00b5:
            if (r6 >= r15) goto L_0x00c5
            r2 = r3[r6]     // Catch:{ Throwable -> 0x00da }
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ Throwable -> 0x00da }
            byte r2 = (byte) r2     // Catch:{ Throwable -> 0x00da }
            r11[r16] = r2     // Catch:{ Throwable -> 0x00da }
            int r16 = r16 + 1
            int r6 = r6 + 1
            goto L_0x00b5
        L_0x00c5:
            com.loc.bz r2 = new com.loc.bz     // Catch:{ Throwable -> 0x00da }
            java.lang.String r5 = r19.getName()     // Catch:{ Throwable -> 0x00da }
            r3 = r2
            r6 = r11
            r8 = r9
            r9 = r10
            r10 = r1
            r11 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Throwable -> 0x00da }
            return r2
        L_0x00d6:
            r1 = 0
            return r1
        L_0x00d8:
            r1 = 0
            return r1
        L_0x00da:
            r0 = move-exception
            goto L_0x00df
        L_0x00dc:
            r0 = move-exception
            r14 = r18
        L_0x00df:
            r1 = r0
            java.lang.String r2 = "APS"
            java.lang.String r3 = "createFromScanData"
            com.loc.cs.a(r1, r2, r3)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.ca.a(android.bluetooth.BluetoothDevice, int, byte[]):com.loc.bz");
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length <= 24) {
            return "";
        }
        if (bArr[0] == 2 && bArr[1] == 1 && ((bArr[2] == 5 || bArr[2] == 6) && bArr[3] == 23)) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 9, bArr2, 0, 16);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte valueOf : bArr2) {
                stringBuffer.append(String.format("%02X", new Object[]{Byte.valueOf(valueOf)}));
            }
            String stringBuffer2 = stringBuffer.toString();
            String str = this.h.get(stringBuffer2);
            if (str != null) {
                return str;
            }
            byte[] a2 = ch.a(da.c(bArr2), new BigInteger("8021267762677846189778330391499"), new BigInteger("49549924105414102803086139689747"));
            if (a2 == null || a2.length < 8) {
                return "";
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            for (int i = 6; i > 0; i--) {
                stringBuffer3.append(String.format("%02X", new Object[]{Byte.valueOf(a2[i])}));
            }
            String stringBuffer4 = stringBuffer3.toString();
            this.h.put(stringBuffer2, stringBuffer4);
            return stringBuffer4;
        } else if (bArr[0] != 2 || bArr[1] != 1 || bArr[2] != 6 || bArr[3] != 22 || bArr[5] != -88 || bArr[6] != 1 || bArr[7] != 32) {
            return "";
        } else {
            try {
                byte[] b2 = ch.b(da.d(bArr), new byte[]{-1, -15, 55, 33, 4, 21, 16, 20, -85, 9, 0, 2, -91, -43, -59, -75});
                if (b2 == null) {
                    return "";
                }
                StringBuffer stringBuffer5 = new StringBuffer();
                for (int i2 = 0; i2 < 8; i2++) {
                    stringBuffer5.append(String.format("%02X", new Object[]{Byte.valueOf(b2[i2])}));
                }
                return stringBuffer5.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    private synchronized void e() {
        ArrayList<bz> arrayList = this.f;
        ArrayList<bz> arrayList2 = this.e;
        arrayList.clear();
        synchronized (this.d) {
            if (arrayList2 != null) {
                try {
                    if (arrayList2.size() > 0) {
                        if (arrayList2.size() > 20) {
                            Collections.sort(arrayList2);
                        }
                        for (int i = 0; i < arrayList2.size(); i++) {
                            arrayList.add(arrayList2.get(i));
                            if (i >= 25) {
                                break;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private boolean f() {
        try {
            return this.a != null && this.a.isEnabled() && cr.B() && da.c() >= 18;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public final void a() {
        try {
            if (da.c() >= 18 && this.a != null) {
                if (this.c == null) {
                    this.c = new a();
                }
                if (this.b) {
                    this.a.stopLeScan(this.c);
                }
                this.b = false;
                this.f.clear();
                this.e.clear();
            }
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public final void b() {
        if (!this.b && f()) {
            if (this.c == null) {
                this.c = new a();
            }
            this.a.startLeScan(this.c);
            this.b = true;
        }
    }

    public final ArrayList<bz> c() {
        if (f()) {
            e();
        } else {
            this.f.clear();
        }
        return this.f;
    }

    public final void d() {
        a();
        this.a = null;
    }
}
