package com.amap.api.col.n3;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.autonavi.ae.gmap.style.StyleElement;
import com.autonavi.ae.gmap.style.StyleItem;
import com.autonavi.amap.mapcore.Convert;
import com.autonavi.amap.mapcore.FileUtil;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: StyleParser */
public final class da {
    private Context a;
    private int b = 0;
    private char c = '#';

    public da(Context context) {
        this.a = context;
    }

    public final Map<Integer, StyleItem> a(String str) {
        HashMap hashMap = new HashMap();
        try {
            byte[] readFileContents = FileUtil.readFileContents(str);
            if (!b(hashMap, readFileContents)) {
                a(hashMap, readFileContents);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    private void a(Map<Integer, StyleItem> map, byte[] bArr) {
        cx a2 = a(bArr);
        if (a2 != null && a2.a() != null) {
            try {
                JSONObject jSONObject = new JSONObject(a2.a());
                JSONArray names = jSONObject.names();
                for (int i = 0; i < names.length(); i++) {
                    String string = names.getString(i);
                    if (string == null || !string.trim().equals("background")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(string);
                        if (jSONObject2 != null) {
                            a(string, map, jSONObject2);
                        }
                    } else {
                        String optString = jSONObject.optString("background");
                        this.b = b("#" + optString);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void a(String str, Map<Integer, StyleItem> map, JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("subType");
            if (optJSONObject == null) {
                a((String) null, str, map, jSONObject);
                return;
            }
            JSONArray names = optJSONObject.names();
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                a(str, string, map, optJSONObject.getJSONObject(string));
            }
        }
    }

    private static void a(String str, String str2, Map<Integer, StyleItem> map, JSONObject jSONObject) throws JSONException {
        if (str != null && str.equals("roads") && str2.equals("subway")) {
            str2 = "subwayline";
        }
        int a2 = db.a(str2);
        if (!jSONObject.optBoolean("visible", true)) {
            a(map, a2, cy.a("visible")).textureId = -1;
            return;
        }
        if (!jSONObject.optBoolean("showIcon", true)) {
            a(map, a2, cy.a("textFillColor")).textureId = -1;
        }
        if (!jSONObject.optBoolean("showLabel", true)) {
            a(map, a2, cy.a("textFillColor")).opacity = 0.0f;
            a(map, a2, cy.a("textStrokeColor")).opacity = 0.0f;
        }
        a(map, jSONObject, "color", "opacity", a2);
        a(map, jSONObject, "fillColor", "fillOpacity", a2);
        a(map, jSONObject, "strokeColor", "strokeOpacity", a2);
        a(map, jSONObject, "textFillColor", "textFillOpacity", a2);
        a(map, jSONObject, "textStrokeColor", "textStrokeOpacity", a2);
        a(map, jSONObject, "backgroundColor", "backgroundOpacity", a2);
    }

    private static void a(Map<Integer, StyleItem> map, JSONObject jSONObject, String str, String str2, int i) {
        try {
            String optString = jSONObject.optString(str, (String) null);
            float f = 1.0f;
            int i2 = 0;
            if (TextUtils.isEmpty(optString)) {
                f = (float) jSONObject.optDouble(str2, 1.0d);
            } else {
                i2 = b("#" + optString);
            }
            if (i2 != 0 || ((double) f) != 1.0d) {
                int a2 = cy.a(str);
                StyleElement a3 = a(map, i, a2);
                a3.value = i2;
                a3.opacity = f;
                if (i == 39) {
                    a(map, i, 2).opacity = 0.0f;
                } else if (i == 12 && a2 == 3) {
                    StyleElement a4 = a(map, i, 2);
                    a4.value = i2;
                    a4.opacity = f;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static cx a(byte[] bArr) {
        cx cxVar;
        try {
            cxVar = new cx();
            try {
                byte[] bytes = "l".getBytes("utf-8");
                int length = bArr.length;
                int length2 = bytes.length;
                for (int i = 0; i < length; i++) {
                    bArr[i] = (byte) (bytes[i % length2] ^ bArr[i]);
                }
                cxVar.a(Convert.getString(bArr, 0, 4));
                cxVar.b(Convert.getString(bArr, 4, 32));
                cxVar.c(Convert.getString(bArr, 36, 10));
                cxVar.d(a(Convert.getSubBytes(bArr, 78, length - 78), Convert.getSubBytes(bArr, 46, 16), Convert.getSubBytes(bArr, 62, 16)));
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return cxVar;
            }
        } catch (Throwable th2) {
            th = th2;
            cxVar = null;
            th.printStackTrace();
            return cxVar;
        }
        return cxVar;
    }

    private static String a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
            instance.init(2, secretKeySpec, ivParameterSpec);
            return new String(instance.doFinal(bArr), "utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private boolean b(Map<Integer, StyleItem> map, byte[] bArr) {
        try {
            JSONArray jSONArray = new JSONArray(new String(bArr, "UTF-8"));
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("featureType");
                if (!TextUtils.isEmpty(string)) {
                    if (string.equals("background")) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("stylers");
                        if (jSONObject2 != null) {
                            int b2 = b(jSONObject2.getString("color"));
                            if (b2 != 0) {
                                this.b = b2;
                            }
                        }
                    } else {
                        int[] a2 = cz.a(string);
                        if (!(a2 == null || a2.length == 0)) {
                            String string2 = jSONObject.getString("elementType");
                            if (!TextUtils.isEmpty(string2)) {
                                int a3 = cy.a(string2);
                                if (a3 != -1) {
                                    a(map, jSONObject, a2, a3);
                                }
                            }
                        }
                    }
                }
            }
            return true;
        } catch (JSONException unused) {
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static void a(Map<Integer, StyleItem> map, JSONObject jSONObject, int[] iArr, int i) throws JSONException {
        for (int i2 : iArr) {
            StyleElement a2 = a(map, i2, i);
            JSONObject jSONObject2 = jSONObject.getJSONObject("stylers");
            if (jSONObject2 != null) {
                int b2 = b(jSONObject2.getString("color"));
                if (b2 != 0) {
                    a2.value = b2;
                    a2.textureId = jSONObject2.optInt("textureid", 0);
                    if (i2 >= 30 && i2 <= 38) {
                        a(map, i2, 4).opacity = 0.1f;
                    } else if (i2 == 12 && i == 3) {
                        a(map, i2, 2).value = b2;
                    }
                }
            }
        }
    }

    private static StyleElement a(Map<Integer, StyleItem> map, int i, int i2) {
        StyleItem styleItem = map.get(Integer.valueOf(i));
        if (styleItem == null) {
            styleItem = new StyleItem(i);
            map.put(Integer.valueOf(i), styleItem);
        }
        StyleElement styleElement = styleItem.get(i2);
        if (styleElement != null) {
            return styleElement;
        }
        StyleElement styleElement2 = new StyleElement();
        styleElement2.styleElementType = i2;
        styleItem.put(i2, styleElement2);
        return styleElement2;
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Color.parseColor(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int a() {
        return this.b;
    }
}
