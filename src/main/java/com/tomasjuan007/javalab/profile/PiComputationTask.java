package com.tomasjuan007.javalab.profile;

public class PiComputationTask extends Thread {
    private static final int PI_SCALE = 1000*1000*1000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        //规模为PI_SCALE的圆周率运算
        long i = 1;
        double s = 0;
        for (long m=1; m<PI_SCALE; m+=2) {
            s += i*(1.0/m);
            i = -i;
        }

        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + " Pi Computation task takes: " + duration);
    }
}
