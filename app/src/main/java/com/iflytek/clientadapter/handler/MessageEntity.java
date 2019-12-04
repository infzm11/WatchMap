package com.iflytek.clientadapter.handler;

import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class MessageEntity {
    private static Integer MAX_LIST_SIZE = 1000;
    private static final String TAG = "MessageEntity";
    private ConcurrentHashMap<Integer, HandleListener> mHandlerListenerMap = new ConcurrentHashMap<>();
    private ConcurrentHashMap<Integer, String> mIdtoTagListMap = new ConcurrentHashMap<>();
    private Integer mMessageCount = 0;
    private ConcurrentHashMap<String, ArrayList<Integer>> mTagListMap = new ConcurrentHashMap<>();

    public synchronized Message obtainMessage(Message message, String str, HandleListener handleListener) {
        if (this.mHandlerListenerMap.size() == MAX_LIST_SIZE.intValue()) {
            Log.e(TAG, "Dispatch message is over size !");
            return null;
        }
        Message message2 = new Message();
        message2.what = getMessageId().intValue();
        message2.obj = message;
        this.mHandlerListenerMap.put(Integer.valueOf(message2.what), handleListener);
        if (this.mTagListMap.contains(str)) {
            this.mTagListMap.get(str).add(Integer.valueOf(message2.what));
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(message2.what));
            this.mTagListMap.put(str, arrayList);
        }
        this.mIdtoTagListMap.put(Integer.valueOf(message2.what), str);
        return message2;
    }

    private Integer getMessageId() {
        Integer valueOf = Integer.valueOf(this.mMessageCount.intValue() + 1);
        this.mMessageCount = valueOf;
        if (valueOf.intValue() == Integer.MAX_VALUE) {
            this.mMessageCount = 0;
        }
        while (this.mHandlerListenerMap.contains(this.mMessageCount)) {
            this.mMessageCount = Integer.valueOf(this.mMessageCount.intValue() + 1);
        }
        return this.mMessageCount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.iflytek.clientadapter.handler.HandleListener takeMessage(android.os.Message r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.iflytek.clientadapter.handler.HandleListener> r0 = r4.mHandlerListenerMap     // Catch:{ all -> 0x0076 }
            int r1 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0076 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0076 }
            r1 = 0
            if (r0 == 0) goto L_0x0073
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.iflytek.clientadapter.handler.HandleListener> r0 = r4.mHandlerListenerMap     // Catch:{ all -> 0x0076 }
            int r2 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0076 }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x0076 }
            com.iflytek.clientadapter.handler.HandleListener r0 = (com.iflytek.clientadapter.handler.HandleListener) r0     // Catch:{ all -> 0x0076 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.String> r2 = r4.mIdtoTagListMap     // Catch:{ all -> 0x0076 }
            int r3 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0076 }
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x006a
            if (r2 != 0) goto L_0x0031
            goto L_0x006a
        L_0x0031:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r3 = r4.mTagListMap     // Catch:{ all -> 0x0076 }
            boolean r3 = r3.containsKey(r2)     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x0042
            java.lang.String r5 = "MessageEntity"
            java.lang.String r0 = "ConcurrentHashMap object is not exist !"
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x0076 }
            monitor-exit(r4)
            return r1
        L_0x0042:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.ArrayList<java.lang.Integer>> r1 = r4.mTagListMap     // Catch:{ all -> 0x0076 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0076 }
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch:{ all -> 0x0076 }
            int r2 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0076 }
            r1.remove(r2)     // Catch:{ all -> 0x0076 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, com.iflytek.clientadapter.handler.HandleListener> r1 = r4.mHandlerListenerMap     // Catch:{ all -> 0x0076 }
            int r2 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0076 }
            r1.remove(r2)     // Catch:{ all -> 0x0076 }
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, java.lang.String> r1 = r4.mIdtoTagListMap     // Catch:{ all -> 0x0076 }
            int r5 = r5.what     // Catch:{ all -> 0x0076 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0076 }
            r1.remove(r5)     // Catch:{ all -> 0x0076 }
            goto L_0x0074
        L_0x006a:
            java.lang.String r5 = "MessageEntity"
            java.lang.String r0 = "ConcurrentHashMap object is not exist !"
            android.util.Log.e(r5, r0)     // Catch:{ all -> 0x0076 }
            monitor-exit(r4)
            return r1
        L_0x0073:
            r0 = r1
        L_0x0074:
            monitor-exit(r4)
            return r0
        L_0x0076:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iflytek.clientadapter.handler.MessageEntity.takeMessage(android.os.Message):com.iflytek.clientadapter.handler.HandleListener");
    }

    public void removeMessage(String str) {
        if (!this.mTagListMap.containsKey(str)) {
            Log.d(TAG, String.valueOf(str) + " message is not exist !");
            return;
        }
        ArrayList arrayList = this.mTagListMap.get(str);
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                this.mHandlerListenerMap.remove(num);
                this.mIdtoTagListMap.remove(num);
            }
            this.mTagListMap.remove(str);
            Log.d(TAG, String.valueOf(str) + " message remove ok !");
        }
    }

    public void clearAllMessage() {
        this.mHandlerListenerMap.clear();
        this.mTagListMap.clear();
        this.mIdtoTagListMap.clear();
    }
}
