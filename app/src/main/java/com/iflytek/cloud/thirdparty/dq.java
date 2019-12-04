package com.iflytek.cloud.thirdparty;

public class dq {
    private static final char[] a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b;

    static {
        byte[] bArr = new byte[128];
        bArr[0] = -1;
        bArr[1] = -1;
        bArr[2] = -1;
        bArr[3] = -1;
        bArr[4] = -1;
        bArr[5] = -1;
        bArr[6] = -1;
        bArr[7] = -1;
        bArr[8] = -1;
        bArr[9] = -1;
        bArr[10] = -1;
        bArr[11] = -1;
        bArr[12] = -1;
        bArr[13] = -1;
        bArr[14] = -1;
        bArr[15] = -1;
        bArr[16] = -1;
        bArr[17] = -1;
        bArr[18] = -1;
        bArr[19] = -1;
        bArr[20] = -1;
        bArr[21] = -1;
        bArr[22] = -1;
        bArr[23] = -1;
        bArr[24] = -1;
        bArr[25] = -1;
        bArr[26] = -1;
        bArr[27] = -1;
        bArr[28] = -1;
        bArr[29] = -1;
        bArr[30] = -1;
        bArr[31] = -1;
        bArr[32] = -1;
        bArr[33] = -1;
        bArr[34] = -1;
        bArr[35] = -1;
        bArr[36] = -1;
        bArr[37] = -1;
        bArr[38] = -1;
        bArr[39] = -1;
        bArr[40] = -1;
        bArr[41] = -1;
        bArr[42] = -1;
        bArr[43] = 62;
        bArr[44] = -1;
        bArr[45] = -1;
        bArr[46] = -1;
        bArr[47] = 63;
        bArr[48] = 52;
        bArr[49] = 53;
        bArr[50] = 54;
        bArr[51] = 55;
        bArr[52] = 56;
        bArr[53] = 57;
        bArr[54] = 58;
        bArr[55] = 59;
        bArr[56] = 60;
        bArr[57] = 61;
        bArr[58] = -1;
        bArr[59] = -1;
        bArr[60] = -1;
        bArr[61] = -1;
        bArr[62] = -1;
        bArr[63] = -1;
        bArr[64] = -1;
        bArr[66] = 1;
        bArr[67] = 2;
        bArr[68] = 3;
        bArr[69] = 4;
        bArr[70] = 5;
        bArr[71] = 6;
        bArr[72] = 7;
        bArr[73] = 8;
        bArr[74] = 9;
        bArr[75] = 10;
        bArr[76] = 11;
        bArr[77] = 12;
        bArr[78] = 13;
        bArr[79] = 14;
        bArr[80] = 15;
        bArr[81] = 16;
        bArr[82] = 17;
        bArr[83] = 18;
        bArr[84] = 19;
        bArr[85] = 20;
        bArr[86] = 21;
        bArr[87] = 22;
        bArr[88] = 23;
        bArr[89] = 24;
        bArr[90] = 25;
        bArr[91] = -1;
        bArr[92] = -1;
        bArr[93] = -1;
        bArr[94] = -1;
        bArr[95] = -1;
        bArr[96] = -1;
        bArr[97] = 26;
        bArr[98] = 27;
        bArr[99] = 28;
        bArr[100] = 29;
        bArr[101] = 30;
        bArr[102] = 31;
        bArr[103] = 32;
        bArr[104] = 33;
        bArr[105] = 34;
        bArr[106] = 35;
        bArr[107] = 36;
        bArr[108] = 37;
        bArr[109] = 38;
        bArr[110] = 39;
        bArr[111] = 40;
        bArr[112] = 41;
        bArr[113] = 42;
        bArr[114] = 43;
        bArr[115] = 44;
        bArr[116] = 45;
        bArr[117] = 46;
        bArr[118] = 47;
        bArr[119] = 48;
        bArr[120] = 49;
        bArr[121] = 50;
        bArr[122] = 51;
        bArr[123] = -1;
        bArr[124] = -1;
        bArr[125] = -1;
        bArr[126] = -1;
        bArr[127] = -1;
        b = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        r0.append(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(byte[] r8) {
        /*
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r1 = 0
            int r2 = r8.length
        L_0x0007:
            if (r1 < r2) goto L_0x000a
            goto L_0x005b
        L_0x000a:
            int r3 = r1 + 1
            byte r1 = r8[r1]
            r1 = r1 & 255(0xff, float:3.57E-43)
            if (r3 != r2) goto L_0x002c
            char[] r8 = a
            int r2 = r1 >>> 2
            char r8 = r8[r2]
            r0.append(r8)
            char[] r8 = a
            r1 = r1 & 3
            int r1 = r1 << 4
            char r8 = r8[r1]
            r0.append(r8)
            java.lang.String r8 = "=="
        L_0x0028:
            r0.append(r8)
            goto L_0x005b
        L_0x002c:
            int r4 = r3 + 1
            byte r3 = r8[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            if (r4 != r2) goto L_0x0060
            char[] r8 = a
            int r2 = r1 >>> 2
            char r8 = r8[r2]
            r0.append(r8)
            char[] r8 = a
            r1 = r1 & 3
            int r1 = r1 << 4
            r2 = r3 & 240(0xf0, float:3.36E-43)
            int r2 = r2 >>> 4
            r1 = r1 | r2
            char r8 = r8[r1]
            r0.append(r8)
            char[] r8 = a
            r1 = r3 & 15
            int r1 = r1 << 2
            char r8 = r8[r1]
            r0.append(r8)
            java.lang.String r8 = "="
            goto L_0x0028
        L_0x005b:
            java.lang.String r8 = r0.toString()
            return r8
        L_0x0060:
            int r5 = r4 + 1
            byte r4 = r8[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            char[] r6 = a
            int r7 = r1 >>> 2
            char r6 = r6[r7]
            r0.append(r6)
            char[] r6 = a
            r1 = r1 & 3
            int r1 = r1 << 4
            r7 = r3 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >>> 4
            r1 = r1 | r7
            char r1 = r6[r1]
            r0.append(r1)
            char[] r1 = a
            r3 = r3 & 15
            int r3 = r3 << 2
            r6 = r4 & 192(0xc0, float:2.69E-43)
            int r6 = r6 >>> 6
            r3 = r3 | r6
            char r1 = r1[r3]
            r0.append(r1)
            char[] r1 = a
            r3 = r4 & 63
            char r1 = r1[r3]
            r0.append(r1)
            r1 = r5
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.cloud.thirdparty.dq.a(byte[]):java.lang.String");
    }
}
