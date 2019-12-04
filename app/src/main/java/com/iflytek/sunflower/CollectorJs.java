package com.iflytek.sunflower;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.iflytek.clientadapter.constant.FocusType;
import com.iflytek.sunflower.util.j;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class CollectorJs {
    /* access modifiers changed from: private */
    public Context a;

    private class a extends WebChromeClient {
        WebChromeClient a;

        public a(WebChromeClient webChromeClient) {
            if (webChromeClient == null) {
                this.a = new WebChromeClient();
            } else {
                this.a = webChromeClient;
            }
        }

        public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
            if (!com.iflytek.sunflower.config.a.s.booleanValue()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            j.a("Collector", "onJsPrompt:" + str2 + " value:" + str3);
            if (!"event".equals(str2)) {
                return this.a.onJsPrompt(webView, str, str2, str3, jsPromptResult);
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("label");
                long optLong = jSONObject.optLong("duration");
                HashMap hashMap = null;
                JSONObject optJSONObject = jSONObject.optJSONObject(FocusType.map);
                if (optJSONObject != null) {
                    hashMap = new HashMap();
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, optJSONObject.getString(next));
                    }
                }
                b.a(CollectorJs.this.a).a(optString, optString2, hashMap, optLong);
                j.a("Collector", "timecost-Prompt " + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
            } catch (Exception e) {
                j.d("Collector", "onEvent error.", e);
            }
            jsPromptResult.confirm();
            return true;
        }

        public void onCloseWindow(WebView webView) {
            this.a.onCloseWindow(webView);
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            return this.a.onCreateWindow(webView, z, z2, message);
        }

        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return this.a.onJsAlert(webView, str, str2, jsResult);
        }

        public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
            return this.a.onJsBeforeUnload(webView, str, str2, jsResult);
        }

        public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
            return this.a.onJsConfirm(webView, str, str2, jsResult);
        }

        public void onProgressChanged(WebView webView, int i) {
            this.a.onProgressChanged(webView, i);
        }

        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            this.a.onReceivedIcon(webView, bitmap);
        }

        public void onReceivedTitle(WebView webView, String str) {
            this.a.onReceivedTitle(webView, str);
        }

        public void onRequestFocus(WebView webView) {
            this.a.onRequestFocus(webView);
        }
    }

    public CollectorJs(Context context, WebView webView) {
        this(context, webView, (WebChromeClient) null);
    }

    public CollectorJs(Context context, WebView webView, WebChromeClient webChromeClient) {
        this.a = context;
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new a(webChromeClient));
    }
}
