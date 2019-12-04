package com.iflytek.sunflower.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class f {
    private static String a = "";

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        File file = new File(str);
        boolean z = false;
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        i.a(file2);
        File parentFile = file2.getParentFile();
        if (parentFile.exists() || parentFile.mkdirs()) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    i.a((InputStream) fileInputStream);
                    i.a((OutputStream) fileOutputStream);
                    throw th;
                }
                try {
                    i.a(fileInputStream2, fileOutputStream);
                    z = true;
                    i.a((InputStream) fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    i.a((InputStream) fileInputStream);
                    i.a((OutputStream) fileOutputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                i.a((InputStream) fileInputStream);
                i.a((OutputStream) fileOutputStream);
                throw th;
            }
            i.a((OutputStream) fileOutputStream);
        }
        return z;
    }

    public static boolean b(String str, String str2) throws IOException {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
            hashMap.put(readLine, "");
        }
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str2));
        for (String readLine2 = bufferedReader2.readLine(); readLine2 != null; readLine2 = bufferedReader2.readLine()) {
            hashMap2.put(readLine2, "");
        }
        int size = hashMap.size();
        int size2 = hashMap2.size();
        if (size != size2 && size > size2) {
            return false;
        }
        if (size == size2) {
            Iterator it = hashMap.entrySet().iterator();
            for (Map.Entry entry : hashMap.entrySet()) {
                while (true) {
                    if (it.hasNext()) {
                        if (entry.equals((Map.Entry) it.next())) {
                            return true;
                        }
                        j.b("FileUtil", "There is new ANR");
                    }
                }
            }
        } else if (size < size2) {
            return false;
        }
        return true;
    }

    public static boolean a(String str) {
        if (!l.a((CharSequence) str)) {
            return new File(str).exists();
        }
        j.c("FileUtil", "geiven path is null");
        return false;
    }
}
