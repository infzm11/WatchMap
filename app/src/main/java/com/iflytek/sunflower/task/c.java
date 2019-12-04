package com.iflytek.sunflower.task;

import com.iflytek.sunflower.e;
import com.iflytek.sunflower.entity.ErrorEntity;
import com.iflytek.sunflower.util.j;

public class c extends Thread {
    private ErrorEntity a;

    public c(ErrorEntity errorEntity) {
        this.a = errorEntity;
    }

    public void run() {
        try {
            a();
        } catch (Exception e) {
            j.d("Collector", "call onError error:" + e);
        }
    }

    private void a() {
        e.a(this.a);
    }
}
