package com.iflytek.sunflower.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iflytek.sunflower.a.a;
import com.iflytek.sunflower.c;
import com.iflytek.sunflower.config.DataKeys;
import com.iflytek.sunflower.config.Version;
import com.iflytek.sunflower.config.a;
import com.iflytek.sunflower.util.d;
import com.iflytek.sunflower.util.j;
import com.iflytek.sunflower.util.k;
import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class b {
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public int b = 0;

    public b(Context context) {
        this.a = context;
        a.z.a("cmd", "statsdklog", false);
        a.z.a("logver", Version.getLogVersion(), false);
        a.A.a("cmd", "statsdklog", false);
        a.A.a("logver", Version.getCustomLogVersion(), false);
    }

    public void a(final JSONObject jSONObject, int i) {
        this.b = i;
        try {
            if (k.a(this.a)) {
                byte[] bytes = jSONObject.toString().getBytes("utf-8");
                byte[] a2 = d.a(bytes);
                a aVar = new a();
                aVar.b(20000);
                aVar.a(1);
                AnonymousClass1 r2 = new a.C0007a() {
                    public void a(byte[] bArr) {
                    }

                    public void a(Exception exc) {
                        if (exc != null) {
                            if (b.this.b == 0) {
                                j.d("Collector", "upload error. please check net state");
                            } else if (b.this.b == 1) {
                                j.f("Collector", "upload error. please check net state");
                            }
                            b.this.a(jSONObject);
                            return;
                        }
                        if (b.this.b == 0) {
                            j.b("Collector", "upload success");
                        } else if (b.this.b == 1) {
                            j.e("Collector", "upload success");
                        }
                        try {
                            SharedPreferences.Editor edit = c.a(b.this.a).edit();
                            edit.putLong("dntr", com.iflytek.sunflower.util.a.a[0]);
                            edit.putLong("uptr", com.iflytek.sunflower.util.a.a[1]);
                            edit.commit();
                            b.this.a();
                        } catch (Exception unused) {
                        }
                    }

                    public void a(a aVar, byte[] bArr) {
                        if (bArr != null) {
                            try {
                                if (a.a(EncodingUtils.getString(d.b(bArr), "utf-8"))) {
                                    a(new Exception());
                                } else {
                                    a((Exception) null);
                                }
                            } catch (Exception e) {
                                a(e);
                            }
                        }
                    }
                };
                if (this.b == 0) {
                    aVar.a(com.iflytek.sunflower.config.a.y, com.iflytek.sunflower.config.a.z.d() + "&size=" + bytes.length, a2);
                    c.a(this.a, DataKeys.SEND_TIME, Long.valueOf(System.currentTimeMillis()));
                    aVar.a((a.C0007a) r2);
                    aVar.a();
                    return;
                }
                aVar.a(com.iflytek.sunflower.config.a.y, com.iflytek.sunflower.config.a.A.d() + "&size=" + bytes.length, a2);
                c.a(this.a, DataKeys.SEND_TIME_LOG, Long.valueOf(System.currentTimeMillis()));
                aVar.b((a.C0007a) r2);
                return;
            }
            j.d("Collector", "upload error please check net state");
            a(jSONObject);
        } catch (OutOfMemoryError e) {
            j.c("Collector", "upload error.", e);
            a();
        } catch (Exception e2) {
            j.d("Collector", "upload error.", e2);
            a(jSONObject);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                String str = null;
                switch (this.b) {
                    case 0:
                        c.a(this.a, jSONObject.optJSONObject("body").toString(), (String) null, 0);
                        return;
                    case 1:
                        String d = c.d(this.a);
                        JSONObject optJSONObject = jSONObject.optJSONObject("body");
                        if (optJSONObject != null) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("log");
                            if (optJSONArray != null) {
                                String jSONArray = optJSONArray.toString();
                                str = "," + jSONArray.substring(1, jSONArray.length() - 1);
                            }
                        }
                        c.a(this.a, str, d, 32768);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                j.c("Collector", "write to local error.", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        switch (this.b) {
            case 0:
                String c = c.c(this.a);
                if (!TextUtils.isEmpty(c)) {
                    this.a.deleteFile(c);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
