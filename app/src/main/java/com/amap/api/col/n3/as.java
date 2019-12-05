package com.amap.api.col.n3;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* compiled from: OfflineMapRemoveTask */
public final class as {
    private Context a;

    public as(Context context) {
        this.a = context;
    }

    public final void a(al alVar) {
        if (alVar != null) {
            String pinyin = alVar.getPinyin();
            boolean a2 = a(pinyin, this.a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            if (a(pinyin, this.a, "map/") || a2) {
                alVar.i();
            } else {
                alVar.h();
            }
        }
    }

    private static boolean a(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String a2 = dv.a(context);
        try {
            File file = new File(a2 + str2 + str + ".dat");
            if (file.exists() && !bj.b(file)) {
                return false;
            }
            try {
                bj.a(a2 + str2);
                bj.a(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }
}
