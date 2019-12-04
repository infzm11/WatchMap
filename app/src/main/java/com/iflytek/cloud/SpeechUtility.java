package com.iflytek.cloud;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.iflytek.cloud.thirdparty.bh;
import com.iflytek.cloud.thirdparty.bj;
import com.iflytek.cloud.thirdparty.bk;
import com.iflytek.cloud.thirdparty.cb;
import com.iflytek.cloud.thirdparty.cd;
import com.iflytek.cloud.thirdparty.ce;
import com.iflytek.cloud.thirdparty.cq;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import com.iflytek.speech.SpeechComponent;
import com.iflytek.speech.UtilityConfig;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SpeechUtility extends bh {
    public static final bh.a DEF_ENGINE_MODE = bh.a.MSC;
    public static final String TAG_RESOURCE_CONTENT = "tag_rescontent";
    public static final String TAG_RESOURCE_RESULT = "result";
    public static final String TAG_RESOURCE_RET = "ret";
    private static SpeechUtility d;
    protected bh.a a = DEF_ENGINE_MODE;
    private ArrayList<SpeechComponent> e = new ArrayList<>();
    private int f = -1;
    private Context g = null;
    private boolean h = false;
    private a i = null;

    private class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String dataString = intent.getDataString();
            String concat = String.valueOf("package:").concat(UtilityConfig.COMPONENT_PKG);
            if (("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action) || "android.intent.action.PACKAGE_REPLACED".equals(action)) && concat.equals(dataString) && SpeechUtility.getUtility() != null) {
                SpeechUtility.getUtility().checkServiceInstalled();
            }
        }
    }

    private SpeechUtility(Context context, String str) throws SpeechError {
        this.g = context.getApplicationContext();
        super.setParameter(SpeechConstant.PARAMS, str);
        MSC.loadLibrary(this.c.b(SpeechConstant.LIB_NAME, SpeechConstant.MODE_MSC));
        cb.c();
        setParameter(SpeechConstant.PARAMS, str);
        this.a = bh.a.MSC;
        int b = b();
        if (b != 0) {
            throw new SpeechError(b);
        }
        d();
        e();
        cd a2 = cd.a(context);
        a2.a();
        a2.b();
        try {
            com.iflytek.common.a.a(context, "appid", this.c.e("appid"));
            com.iflytek.common.a.a(context);
            com.iflytek.common.a.a(false);
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
        String parameter = getParameter("lxy_tp_dc");
        boolean z = true;
        if (!TextUtils.isEmpty(parameter) && "false".equals(parameter)) {
            z = false;
        }
        cb.a("DC init enable=" + parameter);
        cq.a(context, getParameter("appid"), z);
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            PackageManager packageManager = this.g.getPackageManager();
            Intent intent = new Intent(str);
            intent.setPackage(UtilityConfig.COMPONENT_PKG);
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 224);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                for (ResolveInfo next : queryIntentServices) {
                    SpeechComponent b = b(next.serviceInfo.packageName);
                    if (b != null) {
                        try {
                            for (String addEngine : next.serviceInfo.metaData.getString(UtilityConfig.METADATA_KEY_ENGINE_TYPE).split(",")) {
                                b.addEngine(addEngine);
                            }
                        } catch (Exception e2) {
                            cb.a((Throwable) e2);
                        }
                    }
                }
            }
        }
    }

    private static boolean a(Context context) {
        try {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
                    if (next.pid == myPid) {
                        cb.a("process name:" + next.processName);
                        if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).packageName.equals(next.processName)) {
                            cb.a("process name:" + next.processName + "is own process");
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            cb.a((Throwable) e2);
        }
        return false;
    }

    private int b() {
        if (!MSC.isLoaded()) {
            return 21002;
        }
        cb.a("SpeechUtility start login");
        SpeechError a2 = new bk(this.g, this.c).a(this.c.e("usr"), this.c.e("pwd"));
        if (a2 == null) {
            return 0;
        }
        return a2.getErrorCode();
    }

    private SpeechComponent b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        boolean z = false;
        Iterator<SpeechComponent> it = this.e.iterator();
        while (true) {
            if (it.hasNext()) {
                if (str.equals(it.next().getPackageName())) {
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (z) {
            return null;
        }
        SpeechComponent speechComponent = new SpeechComponent(str);
        this.e.add(speechComponent);
        return speechComponent;
    }

    private boolean c() {
        if (MSC.isLoaded()) {
            return bj.a();
        }
        return true;
    }

    private boolean c(String str) {
        PackageManager packageManager = this.g.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(UtilityConfig.COMPONENT_PKG);
        return packageManager.queryIntentActivities(intent, 1).size() > 0;
    }

    public static synchronized SpeechUtility createUtility(Context context, String str) {
        SpeechUtility speechUtility;
        synchronized (SpeechUtility.class) {
            synchronized (b) {
                if (d == null) {
                    ce ceVar = new ce();
                    ceVar.b(str);
                    if (ceVar.a(SpeechConstant.FORCE_LOGIN, false) || a(context.getApplicationContext())) {
                        try {
                            d = new SpeechUtility(context, str);
                        } catch (SpeechError e2) {
                            cb.c("init failed");
                            cb.a((Throwable) e2);
                        }
                    } else {
                        cb.c("init failed, please call this method in your main process!");
                        d = null;
                    }
                }
            }
            speechUtility = d;
        }
        return speechUtility;
    }

    private void d() {
        if (checkServiceInstalled()) {
            a(UtilityConfig.ACTION_SPEECH_RECOGNIZER);
            a(UtilityConfig.ACTION_SPEECH_SYNTHESIZER);
            a(UtilityConfig.ACTION_SPEECH_UNDERSTANDER);
            a(UtilityConfig.ACTION_TEXT_UNDERSTANDER);
            a(UtilityConfig.ACTION_SPEECH_WAKEUP);
        }
    }

    private void e() {
        this.i = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        this.g.registerReceiver(this.i, intentFilter);
    }

    public static synchronized SpeechUtility getUtility() {
        SpeechUtility speechUtility;
        synchronized (SpeechUtility.class) {
            speechUtility = d;
        }
        return speechUtility;
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        try {
            return this.g.getPackageManager().getPackageInfo(UtilityConfig.COMPONENT_PKG, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean checkServiceInstalled() {
        boolean z = false;
        int i2 = -1;
        try {
            PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(UtilityConfig.COMPONENT_PKG, 0);
            if (packageInfo != null) {
                z = true;
                i2 = packageInfo.versionCode;
            }
        } catch (Throwable unused) {
        }
        if (!(z == this.h && this.f == i2)) {
            this.h = z;
            this.f = i2;
            if (SpeechRecognizer.getRecognizer() != null) {
                SpeechRecognizer.getRecognizer().a(this.g);
            }
            if (SpeechSynthesizer.getSynthesizer() != null) {
                SpeechSynthesizer.getSynthesizer().a(this.g);
            }
            if (SpeechUnderstander.getUnderstander() != null) {
                SpeechUnderstander.getUnderstander().a(this.g);
            }
            if (TextUnderstander.getTextUnderstander() != null) {
                TextUnderstander.getTextUnderstander().a(this.g);
            }
        }
        return z;
    }

    public boolean destroy() {
        boolean z;
        if (d != null) {
            super.destroy();
            z = c();
        } else {
            z = true;
        }
        if (!z) {
            return z;
        }
        a aVar = this.i;
        if (aVar != null) {
            this.g.unregisterReceiver(aVar);
        }
        this.i = null;
        cb.a("SpeechUtility destory success");
        cq.a();
        synchronized (b) {
            d = null;
        }
        return z;
    }

    public String getComponentUrl() {
        StringBuffer stringBuffer = new StringBuffer(UtilityConfig.COMPONENT_URL);
        UtilityConfig.appendHttpParam(stringBuffer, "key", URLEncoder.encode(Base64.encodeToString(UtilityConfig.getComponentUrlParam(this.g).getBytes(), 0)));
        UtilityConfig.appendHttpParam(stringBuffer, "version", "2.0");
        return stringBuffer.toString();
    }

    public bh.a getEngineMode() {
        return this.a;
    }

    public String getParameter(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.c.g(str)) {
            return super.getParameter(str);
        }
        if (!MSC.isLoaded()) {
            return null;
        }
        try {
            if (!str.equals("ver_msc") && !str.equals("ver_asr") && !str.equals("ver_tts")) {
                if (!str.equals("ver_ivw")) {
                    byte[] bytes = str.getBytes("utf-8");
                    MSCSessionInfo mSCSessionInfo = new MSCSessionInfo();
                    if (MSC.QMSPGetParam(bytes, mSCSessionInfo) == 0) {
                        return new String(mSCSessionInfo.buffer, "utf-8");
                    }
                    return null;
                }
            }
            byte[] bytes2 = str.getBytes("utf-8");
            MSCSessionInfo mSCSessionInfo2 = new MSCSessionInfo();
            String str2 = new String(MSC.QMSPGetVersion(bytes2, mSCSessionInfo2), "utf-8");
            if (mSCSessionInfo2.errorcode == 0) {
                return str2;
            }
            return null;
        } catch (Exception | UnsatisfiedLinkError e2) {
            cb.b(e2);
        }
    }

    public String getPlusLocalInfo(String str) throws JSONException {
        String str2;
        int i2;
        JSONObject jSONObject = new JSONObject();
        String str3 = "";
        if (!checkServiceInstalled()) {
            str2 = TAG_RESOURCE_RET;
            i2 = 21001;
        } else if (getServiceVersion() < 97) {
            str2 = TAG_RESOURCE_RET;
            i2 = 20018;
        } else if (10000 > getServiceVersion() || getServiceVersion() > 11000) {
            Cursor query = this.g.getContentResolver().query(Uri.parse("content://com.iflytek.vflynote.providers.LocalResourceProvider"), (String[]) null, str, (String[]) null, (String) null);
            int columnIndex = query.getColumnIndex(TAG_RESOURCE_CONTENT);
            if (query != null && query.moveToFirst()) {
                str3 = query.getString(columnIndex);
                Log.v("SpeechUtility", str3);
            }
            if (query != null) {
                query.close();
            }
            if (TextUtils.isEmpty(str3)) {
                str2 = TAG_RESOURCE_RET;
                i2 = 20004;
            } else {
                jSONObject.put(TAG_RESOURCE_RET, 0);
                jSONObject.put(TAG_RESOURCE_RESULT, new JSONObject(str3));
                return jSONObject.toString();
            }
        } else {
            str2 = TAG_RESOURCE_RET;
            i2 = 20020;
        }
        jSONObject.put(str2, i2);
        return jSONObject.toString();
    }

    public int getServiceVersion() {
        if (this.f < 0) {
            try {
                PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(UtilityConfig.COMPONENT_PKG, 0);
                if (packageInfo != null) {
                    this.f = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f;
    }

    public int openEngineSettings(String str) {
        try {
            Intent intent = new Intent();
            intent.setPackage(UtilityConfig.COMPONENT_PKG);
            String str2 = UtilityConfig.COMPONENT_PKG;
            if ("tts".equals(str) && c(UtilityConfig.SETTINGS_ACTION_TTS)) {
                str2 = UtilityConfig.SETTINGS_ACTION_TTS;
            } else if ("asr".equals(str) && c(UtilityConfig.SETTINGS_ACTION_ASR)) {
                str2 = UtilityConfig.SETTINGS_ACTION_ASR;
            } else if (c(UtilityConfig.SETTINGS_ACTION_MAIN)) {
                str2 = UtilityConfig.SETTINGS_ACTION_MAIN;
            }
            intent.setAction(str2);
            intent.addFlags(268435456);
            this.g.startActivity(intent);
            return 0;
        } catch (Exception e2) {
            cb.a((Throwable) e2);
            return 21002;
        }
    }

    public String[] queryAvailableEngines() {
        this.e.clear();
        d();
        ArrayList arrayList = new ArrayList();
        Iterator<SpeechComponent> it = this.e.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getEngines());
        }
        String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            strArr[i2] = (String) arrayList.get(i2);
        }
        return strArr;
    }

    public boolean setParameter(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        super.setParameter(str, str2);
        if (!MSC.isLoaded() || SpeechConstant.PARAMS.equals(str)) {
            return true;
        }
        try {
            return MSC.QMSPSetParam(str.getBytes("utf-8"), str2.getBytes("utf-8")) == 0;
        } catch (Exception | UnsatisfiedLinkError e2) {
            cb.a(e2);
            return false;
        }
    }
}
