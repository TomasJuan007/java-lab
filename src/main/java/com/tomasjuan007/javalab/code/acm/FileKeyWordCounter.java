package com.tomasjuan007.javalab.code.acm;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

/**
 * 2019-08-06 TP-LINK
 * use multi-thread to count file name keyword
 **/
public class FileKeyWordCounter {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        String filePath = "";
        File file = new File(filePath);
        count(file, "a");
        sleep(200);
        System.out.println(atomicInteger);
    }

    private static void count(File file, String keyword) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                Thread t = new Thread(() -> count(f, keyword));
                t.start();
            }
        } else {
            String fileName = file.getName();
            int count = fileName.split(keyword).length-1;
            atomicInteger.getAndAdd(count);
        }
    }
}
