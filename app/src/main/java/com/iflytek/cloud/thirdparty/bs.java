package com.iflytek.cloud.thirdparty;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class bs {
    private HashMap<String, ConcurrentLinkedQueue<byte[]>> a = new HashMap<>();

    public void a() {
        for (String next : this.a.keySet()) {
            bv.a(this.a.get(next), next);
        }
    }

    public void a(String str, byte[] bArr) {
        if (this.a.containsKey(str)) {
            this.a.get(str).add(bArr);
            return;
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.add(bArr);
        this.a.put(str, concurrentLinkedQueue);
    }
}
