package com.amap.api.col.n3;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: AndroidAssets */
public final class dc {
    static dc b;
    Context a;

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        InputStream b2 = b.b(str);
        if (b2 == null) {
            return null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(b2, "utf-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append(10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void a(Context context) {
        b = new dc(context);
    }

    private dc(Context context) {
        this.a = context;
    }

    private InputStream b(String str) {
        try {
            return this.a.getAssets().open(str);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
