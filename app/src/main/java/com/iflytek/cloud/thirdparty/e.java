package com.iflytek.cloud.thirdparty;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public final class e {
    private static final char[] b = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private PrintStream a;

    private static int a(InputStream inputStream, byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            int read = inputStream.read();
            if (read == -1) {
                return i;
            }
            bArr[i] = (byte) read;
        }
        return bArr.length;
    }

    private void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[57];
        this.a = new PrintStream(outputStream);
        while (true) {
            int a2 = a(inputStream, bArr);
            if (a2 != 0) {
                int i = 0;
                while (i < a2) {
                    int i2 = i + 3;
                    a(outputStream, bArr, i, i2 <= a2 ? 3 : a2 - i);
                    i = i2;
                }
                if (a2 >= 57) {
                    this.a.println();
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private static void a(OutputStream outputStream, byte[] bArr, int i, int i2) {
        if (i2 == 1) {
            byte b2 = bArr[i];
            outputStream.write(b[(b2 >>> 2) & 63]);
            outputStream.write(b[(b2 << 4) & 48]);
            outputStream.write(61);
            outputStream.write(61);
        } else if (i2 == 2) {
            byte b3 = bArr[i];
            byte b4 = bArr[i + 1];
            outputStream.write(b[(b3 >>> 2) & 63]);
            outputStream.write(b[((b3 << 4) & 48) + ((b4 >>> 4) & 15)]);
            outputStream.write(b[(b4 << 2) & 60]);
            outputStream.write(61);
        } else {
            byte b5 = bArr[i];
            byte b6 = bArr[i + 1];
            byte b7 = bArr[i + 2];
            outputStream.write(b[(b5 >>> 2) & 63]);
            outputStream.write(b[((b5 << 4) & 48) + ((b6 >>> 4) & 15)]);
            outputStream.write(b[((b6 << 2) & 60) + ((b7 >>> 6) & 3)]);
            outputStream.write(b[b7 & 63]);
        }
    }

    public final String a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            a((InputStream) new ByteArrayInputStream(bArr), (OutputStream) byteArrayOutputStream);
            return byteArrayOutputStream.toString("8859_1");
        } catch (Exception unused) {
            throw new Error("CharacterEncoder.encode internal error");
        }
    }
}
