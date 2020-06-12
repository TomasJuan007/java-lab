package com.tomasjuan007.javalab.profile;

public class FloatComputationTask extends Thread {
    private static final int M = 201000;
    private static final int N = 501000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        for (float m=0; m<M; m++) {
            for (float n=0; m<N; n++) {
                //do nothing
            }
        }
        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + "Int Computation task takes: " + duration);
    }
}
