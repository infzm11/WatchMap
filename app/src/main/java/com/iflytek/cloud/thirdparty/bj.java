package com.iflytek.cloud.thirdparty;

import android.content.Context;
import android.text.TextUtils;
import com.iflytek.cloud.SpeechError;
import com.iflytek.msc.MSC;
import com.iflytek.msc.MSCSessionInfo;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class bj {
    public static Object a = new Object();
    private MSCSessionInfo b = new MSCSessionInfo();

    public static void a(Context context, String str, String str2, be beVar) throws SpeechError, IOException {
        byte[] bArr;
        synchronized (a) {
            String a2 = cg.a(context, beVar);
            byte[] bArr2 = null;
            if (!TextUtils.isEmpty(str)) {
                bArr = str.getBytes("utf-8");
            } else {
                if (context != null) {
                    String a3 = cg.a(context);
                    if (!TextUtils.isEmpty(a3)) {
                        bArr = a3.getBytes(beVar.q());
                    }
                }
                bArr = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                bArr2 = str2.getBytes(beVar.q());
            }
            try {
                int QMSPLogin = MSC.QMSPLogin(bArr, bArr2, a2.getBytes(beVar.q()));
                cb.a("[MSPLogin]ret:" + QMSPLogin);
                if (QMSPLogin != 0) {
                    throw new SpeechError(QMSPLogin);
                }
            } catch (UnsatisfiedLinkError e) {
                cb.a((Throwable) e);
                throw new SpeechError(20021);
            }
        }
    }

    public static boolean a() {
        boolean z = false;
        if (!be.u()) {
            cb.a("MscHandler is not empty while logout.");
            return false;
        }
        synchronized (a) {
            if (MSC.QMSPLogOut() == 0) {
                z = true;
            }
        }
        return z;
    }

    public synchronized byte[] a(Context context, be beVar) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPDownloadData;
        synchronized (a) {
            String c = cg.c(context, beVar);
            cb.a("[MSPSession downloadData]enter time:" + System.currentTimeMillis());
            cc.a("LastDataFlag", (String) null);
            QMSPDownloadData = MSC.QMSPDownloadData(c.getBytes(beVar.q()), this.b);
            cc.a("GetNotifyResult", (String) null);
            StringBuilder sb = new StringBuilder();
            sb.append("[MSPSession downloadData]leavel:");
            sb.append(this.b.errorcode);
            sb.append(",data len = ");
            sb.append(QMSPDownloadData == null ? 0 : QMSPDownloadData.length);
            cb.a(sb.toString());
            int i = this.b.errorcode;
            if (i == 0) {
                if (QMSPDownloadData == null) {
                }
            }
            throw new SpeechError(i);
        }
        return QMSPDownloadData;
    }

    public synchronized byte[] a(Context context, be beVar, String str) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPSearch;
        synchronized (a) {
            String c = cg.c(context, beVar);
            cb.a("[MSPSession searchResult]enter time:" + System.currentTimeMillis());
            byte[] bytes = str.getBytes("utf-8");
            cc.a("LastDataFlag", (String) null);
            QMSPSearch = MSC.QMSPSearch(c.getBytes(beVar.q()), bytes, this.b);
            cc.a("GetNotifyResult", (String) null);
            StringBuilder sb = new StringBuilder();
            sb.append("[QMSPSearch searchResult]leavel:");
            sb.append(this.b.errorcode);
            sb.append(",data len = ");
            sb.append(QMSPSearch == null ? 0 : QMSPSearch.length);
            cb.a(sb.toString());
            int i = this.b.errorcode;
            if (i == 0) {
                if (QMSPSearch == null) {
                }
            }
            throw new SpeechError(i);
        }
        return QMSPSearch;
    }

    public synchronized byte[] a(Context context, String str, byte[] bArr, be beVar) throws SpeechError, UnsupportedEncodingException {
        byte[] QMSPUploadData;
        synchronized (a) {
            String c = cg.c(context, beVar);
            cb.a("[MSPSession uploadData]enter time:" + System.currentTimeMillis());
            QMSPUploadData = MSC.QMSPUploadData(str.getBytes(beVar.q()), bArr, bArr.length, c.getBytes("utf-8"), this.b);
            StringBuilder sb = new StringBuilder();
            sb.append("[MSPSession uploaddData]leavel:");
            sb.append(this.b.errorcode);
            sb.append(",data len = ");
            sb.append(QMSPUploadData == null ? 0 : QMSPUploadData.length);
            cb.a(sb.toString());
            int i = this.b.errorcode;
            if (i == 0) {
                if (QMSPUploadData == null) {
                }
            }
            throw new SpeechError(i);
        }
        return QMSPUploadData;
    }
}
