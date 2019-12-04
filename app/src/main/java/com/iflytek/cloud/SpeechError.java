package com.iflytek.cloud;

import com.iflytek.cloud.resource.Resource;

public class SpeechError extends Exception {
    public static final int TIP_ERROR_ALREADY_EXIST = 66;
    public static final int TIP_ERROR_GROUP_EMPTY = 68;
    public static final int TIP_ERROR_IVP_EXTRA_RGN_SOPPORT = 56;
    public static final int TIP_ERROR_IVP_GENERAL = 55;
    public static final int TIP_ERROR_IVP_MUCH_NOISE = 58;
    public static final int TIP_ERROR_IVP_NO_ENOUGH_AUDIO = 63;
    public static final int TIP_ERROR_IVP_TEXT_NOT_MATCH = 62;
    public static final int TIP_ERROR_IVP_TOO_LOW = 59;
    public static final int TIP_ERROR_IVP_TRUNCATED = 57;
    public static final int TIP_ERROR_IVP_UTTER_TOO_SHORT = 61;
    public static final int TIP_ERROR_IVP_ZERO_AUDIO = 60;
    public static final int TIP_ERROR_MODEL_IS_CREATING = 65;
    public static final int TIP_ERROR_MODEL_NOT_FOUND = 64;
    public static final int TIP_ERROR_NO_GROUP = 67;
    public static final int TIP_ERROR_NO_USER = 69;
    public static final int TIP_ERROR_OVERFLOW_IN_GROUP = 70;
    private static final long serialVersionUID = 4434424251478985596L;
    private int a;
    private String b;

    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0176, code lost:
        if (r10.a == 11503) goto L_0x00be;
     */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x021c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SpeechError(int r11) {
        /*
            r10 = this;
            r10.<init>()
            r0 = 0
            r10.a = r0
            java.lang.String r0 = ""
            r10.b = r0
            r10.a = r11
            r0 = 7
            r1 = 65
            r2 = 31
            r3 = 19
            r4 = 18
            r5 = 28
            r6 = 11
            r7 = 20001(0x4e21, float:2.8027E-41)
            r8 = 64
            r9 = 3
            if (r11 >= r7) goto L_0x0198
            int r11 = r10.a
            r7 = 10118(0x2786, float:1.4178E-41)
            if (r11 != r7) goto L_0x0029
        L_0x0026:
            r0 = r6
            goto L_0x0216
        L_0x0029:
            r11 = 10106(0x277a, float:1.4162E-41)
            int r6 = r10.a
            if (r11 == r6) goto L_0x017e
            r11 = 10107(0x277b, float:1.4163E-41)
            int r6 = r10.a
            if (r11 == r6) goto L_0x017e
            r11 = 10124(0x278c, float:1.4187E-41)
            int r6 = r10.a
            if (r11 != r6) goto L_0x003d
            goto L_0x017e
        L_0x003d:
            int r11 = r10.a
            r0 = 10110(0x277e, float:1.4167E-41)
            if (r11 != r0) goto L_0x0047
            r0 = 32
            goto L_0x0216
        L_0x0047:
            int r11 = r10.a
            r0 = 10111(0x277f, float:1.4169E-41)
            if (r11 != r0) goto L_0x0050
        L_0x004d:
            r0 = r5
            goto L_0x0216
        L_0x0050:
            int r11 = r10.a
            r0 = 10200(0x27d8, float:1.4293E-41)
            if (r11 < r0) goto L_0x005e
            int r11 = r10.a
            r0 = 10300(0x283c, float:1.4433E-41)
            if (r11 >= r0) goto L_0x005e
            goto L_0x0215
        L_0x005e:
            int r11 = r10.a
            r0 = 10117(0x2785, float:1.4177E-41)
            if (r11 == r0) goto L_0x017a
            int r11 = r10.a
            r0 = 10101(0x2775, float:1.4155E-41)
            if (r11 != r0) goto L_0x006c
            goto L_0x017a
        L_0x006c:
            int r11 = r10.a
            r0 = 10113(0x2781, float:1.4171E-41)
            if (r11 != r0) goto L_0x0076
            r0 = 17
            goto L_0x0216
        L_0x0076:
            int r11 = r10.a
            r0 = 10116(0x2784, float:1.4176E-41)
            if (r11 != r0) goto L_0x007f
        L_0x007c:
            r0 = r8
            goto L_0x0216
        L_0x007f:
            int r11 = r10.a
            r0 = 10121(0x2789, float:1.4183E-41)
            if (r11 != r0) goto L_0x0089
            r0 = 66
            goto L_0x0216
        L_0x0089:
            int r11 = r10.a
            r0 = 10400(0x28a0, float:1.4574E-41)
            if (r11 < r0) goto L_0x0098
            int r11 = r10.a
            r0 = 10407(0x28a7, float:1.4583E-41)
            if (r11 > r0) goto L_0x0098
        L_0x0095:
            r0 = r4
            goto L_0x0216
        L_0x0098:
            int r11 = r10.a
            r0 = 11000(0x2af8, float:1.5414E-41)
            if (r11 < r0) goto L_0x00b8
            int r11 = r10.a
            r0 = 11099(0x2b5b, float:1.5553E-41)
            if (r11 >= r0) goto L_0x00b8
            int r11 = r10.a
            r0 = 11005(0x2afd, float:1.5421E-41)
            if (r11 != r0) goto L_0x00ae
            r0 = 23
            goto L_0x0216
        L_0x00ae:
            int r11 = r10.a
            r0 = 11006(0x2afe, float:1.5423E-41)
            if (r11 != r0) goto L_0x0095
            r0 = 24
            goto L_0x0216
        L_0x00b8:
            int r11 = r10.a
            r0 = 10129(0x2791, float:1.4194E-41)
            if (r11 != r0) goto L_0x00c1
        L_0x00be:
            r0 = r3
            goto L_0x0216
        L_0x00c1:
            int r11 = r10.a
            r0 = 10109(0x277d, float:1.4166E-41)
            if (r11 != r0) goto L_0x00cb
            r0 = 20
            goto L_0x0216
        L_0x00cb:
            int r11 = r10.a
            r0 = 10702(0x29ce, float:1.4997E-41)
            if (r11 != r0) goto L_0x00d5
            r0 = 21
            goto L_0x0216
        L_0x00d5:
            int r11 = r10.a
            r0 = 10500(0x2904, float:1.4714E-41)
            if (r11 < r0) goto L_0x00e5
            int r11 = r10.a
            r0 = 10600(0x2968, float:1.4854E-41)
            if (r11 >= r0) goto L_0x00e5
            r0 = 22
            goto L_0x0216
        L_0x00e5:
            int r11 = r10.a
            r0 = 11200(0x2bc0, float:1.5695E-41)
            if (r11 < r0) goto L_0x00f5
            int r11 = r10.a
            r0 = 11250(0x2bf2, float:1.5765E-41)
            if (r11 > r0) goto L_0x00f5
            r0 = 25
            goto L_0x0216
        L_0x00f5:
            int r11 = r10.a
            r0 = 14000(0x36b0, float:1.9618E-41)
            if (r11 < r0) goto L_0x0104
            int r11 = r10.a
            r0 = 14006(0x36b6, float:1.9627E-41)
            if (r11 > r0) goto L_0x0104
        L_0x0101:
            r0 = r2
            goto L_0x0216
        L_0x0104:
            int r11 = r10.a
            r0 = 16000(0x3e80, float:2.2421E-41)
            if (r11 < r0) goto L_0x0111
            int r11 = r10.a
            r0 = 16006(0x3e86, float:2.2429E-41)
            if (r11 > r0) goto L_0x0111
            goto L_0x0101
        L_0x0111:
            r11 = 11401(0x2c89, float:1.5976E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x011b
            r0 = 35
            goto L_0x0216
        L_0x011b:
            r11 = 11402(0x2c8a, float:1.5978E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x0125
            r0 = 36
            goto L_0x0216
        L_0x0125:
            r11 = 11403(0x2c8b, float:1.5979E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x012f
            r0 = 37
            goto L_0x0216
        L_0x012f:
            r11 = 11404(0x2c8c, float:1.598E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x0139
            r0 = 38
            goto L_0x0216
        L_0x0139:
            r11 = 11405(0x2c8d, float:1.5982E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x0143
            r0 = 39
            goto L_0x0216
        L_0x0143:
            r11 = 11406(0x2c8e, float:1.5983E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x014d
            r0 = 40
            goto L_0x0216
        L_0x014d:
            r11 = 11407(0x2c8f, float:1.5985E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x0157
            r0 = 41
            goto L_0x0216
        L_0x0157:
            r11 = 11408(0x2c90, float:1.5986E-41)
            int r0 = r10.a
            if (r11 != r0) goto L_0x0161
            r0 = 42
            goto L_0x0216
        L_0x0161:
            int r11 = r10.a
            r0 = 11501(0x2ced, float:1.6116E-41)
            if (r11 != r0) goto L_0x016a
            r0 = r1
            goto L_0x0216
        L_0x016a:
            int r11 = r10.a
            r0 = 11502(0x2cee, float:1.6118E-41)
            if (r11 != r0) goto L_0x0172
            goto L_0x007c
        L_0x0172:
            int r11 = r10.a
            r0 = 11503(0x2cef, float:1.6119E-41)
            if (r11 != r0) goto L_0x0215
            goto L_0x00be
        L_0x017a:
            r0 = 16
            goto L_0x0216
        L_0x017e:
            java.lang.String r11 = "sdk errorcode"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            int r3 = r10.a
            r2.append(r3)
            java.lang.String r3 = ""
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.iflytek.cloud.thirdparty.cb.a(r11, r2)
            goto L_0x0216
        L_0x0198:
            int r11 = r10.a
            r2 = 30000(0x7530, float:4.2039E-41)
            if (r11 >= r2) goto L_0x0215
            int r11 = r10.a
            if (r11 != r7) goto L_0x01a5
            r0 = 1
            goto L_0x0216
        L_0x01a5:
            int r11 = r10.a
            r2 = 20002(0x4e22, float:2.8029E-41)
            if (r11 != r2) goto L_0x01ae
            r0 = 2
            goto L_0x0216
        L_0x01ae:
            int r11 = r10.a
            r2 = 20003(0x4e23, float:2.803E-41)
            if (r11 != r2) goto L_0x01b6
            goto L_0x0215
        L_0x01b6:
            int r11 = r10.a
            r2 = 20004(0x4e24, float:2.8032E-41)
            if (r11 != r2) goto L_0x01be
            r0 = 5
            goto L_0x0216
        L_0x01be:
            int r11 = r10.a
            r2 = 20005(0x4e25, float:2.8033E-41)
            if (r11 != r2) goto L_0x01c7
            r0 = 10
            goto L_0x0216
        L_0x01c7:
            int r11 = r10.a
            r2 = 20006(0x4e26, float:2.8034E-41)
            if (r11 != r2) goto L_0x01d0
            r0 = 9
            goto L_0x0216
        L_0x01d0:
            int r11 = r10.a
            r2 = 20007(0x4e27, float:2.8036E-41)
            if (r11 != r2) goto L_0x01d9
            r0 = 12
            goto L_0x0216
        L_0x01d9:
            int r11 = r10.a
            r2 = 20008(0x4e28, float:2.8037E-41)
            if (r11 != r2) goto L_0x01e1
            goto L_0x0026
        L_0x01e1:
            int r11 = r10.a
            r2 = 20009(0x4e29, float:2.8039E-41)
            if (r11 != r2) goto L_0x01ea
            r0 = 13
            goto L_0x0216
        L_0x01ea:
            int r11 = r10.a
            r2 = 20010(0x4e2a, float:2.804E-41)
            if (r11 != r2) goto L_0x01f3
            r0 = 14
            goto L_0x0216
        L_0x01f3:
            int r11 = r10.a
            r2 = 20012(0x4e2c, float:2.8043E-41)
            if (r11 != r2) goto L_0x01fa
            goto L_0x0216
        L_0x01fa:
            int r11 = r10.a
            r0 = 21003(0x520b, float:2.9431E-41)
            if (r11 != r0) goto L_0x0202
            goto L_0x004d
        L_0x0202:
            int r11 = r10.a
            r0 = 21002(0x520a, float:2.943E-41)
            if (r11 == r0) goto L_0x0212
            int r11 = r10.a
            r0 = 21001(0x5209, float:2.9429E-41)
            if (r11 != r0) goto L_0x020f
            goto L_0x0212
        L_0x020f:
            r0 = 30
            goto L_0x0216
        L_0x0212:
            r0 = 29
            goto L_0x0216
        L_0x0215:
            r0 = r9
        L_0x0216:
            int r11 = r10.a
            r2 = 10031(0x272f, float:1.4056E-41)
            if (r11 == r2) goto L_0x0278
            r1 = 11610(0x2d5a, float:1.6269E-41)
            if (r11 == r1) goto L_0x0277
            switch(r11) {
                case 10141: goto L_0x0274;
                case 10142: goto L_0x0271;
                case 10143: goto L_0x026e;
                case 10144: goto L_0x026b;
                default: goto L_0x0223;
            }
        L_0x0223:
            switch(r11) {
                case 11600: goto L_0x0268;
                case 11601: goto L_0x0265;
                case 11602: goto L_0x0262;
                case 11603: goto L_0x025f;
                case 11604: goto L_0x025c;
                case 11605: goto L_0x0259;
                case 11606: goto L_0x0256;
                case 11607: goto L_0x0253;
                case 11608: goto L_0x0250;
                default: goto L_0x0226;
            }
        L_0x0226:
            switch(r11) {
                case 11700: goto L_0x024d;
                case 11701: goto L_0x024a;
                case 11702: goto L_0x0247;
                case 11703: goto L_0x0244;
                case 11704: goto L_0x0241;
                case 11705: goto L_0x023e;
                case 11706: goto L_0x023b;
                case 11707: goto L_0x0238;
                case 11708: goto L_0x0235;
                case 11709: goto L_0x0232;
                case 11710: goto L_0x022f;
                case 11711: goto L_0x022c;
                case 11712: goto L_0x0277;
                default: goto L_0x0229;
            }
        L_0x0229:
            r1 = r0
            goto L_0x0278
        L_0x022c:
            r1 = 54
            goto L_0x0278
        L_0x022f:
            r1 = 53
            goto L_0x0278
        L_0x0232:
            r1 = 52
            goto L_0x0278
        L_0x0235:
            r1 = 51
            goto L_0x0278
        L_0x0238:
            r1 = 50
            goto L_0x0278
        L_0x023b:
            r1 = 49
            goto L_0x0278
        L_0x023e:
            r1 = 48
            goto L_0x0278
        L_0x0241:
            r1 = 47
            goto L_0x0278
        L_0x0244:
            r1 = 46
            goto L_0x0278
        L_0x0247:
            r1 = 45
            goto L_0x0278
        L_0x024a:
            r1 = 44
            goto L_0x0278
        L_0x024d:
            r1 = 43
            goto L_0x0278
        L_0x0250:
            r1 = 63
            goto L_0x0278
        L_0x0253:
            r1 = 62
            goto L_0x0278
        L_0x0256:
            r1 = 61
            goto L_0x0278
        L_0x0259:
            r1 = 60
            goto L_0x0278
        L_0x025c:
            r1 = 59
            goto L_0x0278
        L_0x025f:
            r1 = 58
            goto L_0x0278
        L_0x0262:
            r1 = 57
            goto L_0x0278
        L_0x0265:
            r1 = 56
            goto L_0x0278
        L_0x0268:
            r1 = 55
            goto L_0x0278
        L_0x026b:
            r1 = 70
            goto L_0x0278
        L_0x026e:
            r1 = 67
            goto L_0x0278
        L_0x0271:
            r1 = 69
            goto L_0x0278
        L_0x0274:
            r1 = 68
            goto L_0x0278
        L_0x0277:
            r1 = r8
        L_0x0278:
            java.lang.String r11 = com.iflytek.cloud.resource.Resource.getErrorDescription(r1)
            r10.b = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.SpeechError.<init>(int):void");
    }

    public SpeechError(int i, String str) {
        this(i);
        int i2;
        if (SpeechConstant.ENG_WFR.equals(str)) {
            if (10118 == i) {
                i2 = 33;
            } else if (10119 == i) {
                i2 = 34;
            } else {
                return;
            }
            this.b = Resource.getErrorDescription(i2);
        }
    }

    public SpeechError(Exception exc) {
        this.a = 0;
        this.b = "";
        this.a = 20999;
        this.b = exc.toString();
    }

    public SpeechError(Throwable th, int i) {
        this(i);
        initCause(th);
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorDescription() {
        return this.b;
    }

    public String getHtmlDescription(boolean z) {
        String str = this.b + "...";
        if (!z) {
            return str;
        }
        String str2 = str + "<br>(";
        String str3 = str2 + Resource.getErrorTag(0) + ":";
        return str3 + this.a + ")";
    }

    public String getPlainDescription(boolean z) {
        String str = this.b;
        if (!z) {
            return str;
        }
        String str2 = str + ".";
        String str3 = str2 + "(" + Resource.getErrorTag(0) + ":";
        return str3 + this.a + ")";
    }

    public String toString() {
        return getPlainDescription(true);
    }
}
