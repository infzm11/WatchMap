package com.iflytek.cloud.thirdparty;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class dt {
    public static final ExecutorService a;
    private static final BlockingQueue b = new LinkedBlockingQueue(1);
    private static final ThreadFactory c = new du();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, b, c, new ThreadPoolExecutor.DiscardPolicy());
        a = threadPoolExecutor;
    }
}
