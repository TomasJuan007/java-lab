package com.tomasjuan007.javalab.thread;

public class ThreadTest {

    static boolean answerReady = false;
    static int answer = 0;

    static Thread t1 = new Thread(new Runnable() {
        public void run() {
            answer = 42;
            answerReady = true;
            System.out.println("The answer of life is " + answer);
        }
    });

    static Thread t2 = new Thread(new Runnable() {
        public void run() {
            if (!answerReady) {
                System.out.println("The answer of life is " + answer);
            } else {
                System.out.println("I don't know the answer " + answer);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
