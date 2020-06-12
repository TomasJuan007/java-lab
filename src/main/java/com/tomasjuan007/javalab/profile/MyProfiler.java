package com.tomasjuan007.javalab.profile;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyProfiler {
    private static final long SCORE_SCALE = 1000*1000*1000;
    public static void main(String[] args) {
        System.out.println("=== Provision ===");
        int nThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("available processors: " + nThreads);
        System.out.println("score scale: " + SCORE_SCALE);
        ThreadFactory threadFactory = new ThreadFactory() {
            private final AtomicInteger poolNumber = new AtomicInteger(1);
            private final SecurityManager s = System.getSecurityManager();
            private final ThreadGroup group =  (s != null) ?
                    s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            private final AtomicInteger threadNumber = new AtomicInteger(1);
            private final String namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(group, r,
                        namePrefix + threadNumber.getAndIncrement(),
                        0);
                if (t.isDaemon())
                    t.setDaemon(false);
                if (t.getPriority() != Thread.NORM_PRIORITY)
                    t.setPriority(Thread.NORM_PRIORITY);
                return t;
            }
        };
        ExecutorService executorService = new ThreadPoolExecutor(nThreads, nThreads,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), threadFactory);

        System.out.println("=== Calculation ===");
        long start = System.currentTimeMillis();
        for (int i=0; i<nThreads; i++) {
            executorService.submit(new IntComputationTask());
            executorService.submit(new FloatComputationTask());
            executorService.submit(new PiComputationTask());
            executorService.submit(new SortComputationTask());
        }
        executorService.shutdown();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("=== Analyse ===");
            long end = System.currentTimeMillis();
            double duration = end - start;
            System.out.println("duration" + duration);
            double score = SCORE_SCALE/duration;
            System.out.println("score: " + score);
        }));

    }
}
