package com.tomasjuan007.javalab.profile;

public class IntComputationTask extends Thread {
    private static final int M = 20*1000;
    private static final int N = 50*1000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        //规模为M*N次的整数类型加法运算
        for (int m=0; m<M; m++) {
            for (int n=0; n<N; n++) {
                //do nothing
            }
        }

        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + " Int Computation task takes: " + duration);
    }
}
