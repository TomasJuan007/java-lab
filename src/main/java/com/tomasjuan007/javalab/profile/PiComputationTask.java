package com.tomasjuan007.javalab.profile;

public class PiComputationTask extends Thread {
    private static final int SCALE = 1000*1000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long m, i = 1;
        double s = 0;

        for (m=1; m<SCALE; m+=2) {
            s += i*(1.0/m);
            i = -i;
        }
        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + "Pi Computation task takes: " + duration);
    }
}
