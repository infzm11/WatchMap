package com.iflytek.cloud.thirdparty;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class db {
    public static int a(String str, String str2, boolean z) {
        try {
            File file = new File(str);
            if (file.exists()) {
                if (z) {
                    file.delete();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(randomAccessFile.length());
                randomAccessFile.write(str2.getBytes("utf-8"));
                int length = (int) randomAccessFile.length();
                randomAccessFile.close();
                return length;
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(randomAccessFile2.length());
            randomAccessFile2.write(str2.getBytes("utf-8"));
            int length2 = (int) randomAccessFile2.length();
            randomAccessFile2.close();
            return length2;
        } catch (IOException unused) {
            cb.a("iFly_ContactManager", "save file failed. " + str);
            return 0;
        }
    }

    public static String a(String str) {
        String str2;
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = new String(bArr, "utf-8");
            try {
                fileInputStream.close();
                return str2;
            } catch (IOException unused) {
                cb.a("iFly_ContactManager", "load file failed. " + str);
                return str2;
            }
        } catch (IOException unused2) {
            str2 = null;
            cb.a("iFly_ContactManager", "load file failed. " + str);
            return str2;
        }
    }
}
