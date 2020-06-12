package com.tomasjuan007.javalab.profile;

public class FloatComputationTask extends Thread {
    private static final int M = 20*1000;
    private static final int N = 50*1000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (float m=0; m<M; m++) {
            for (float n=0; n<N; n++) {
                //do nothing
            }
        }
        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + " Float Computation task takes: " + duration);
    }
}
