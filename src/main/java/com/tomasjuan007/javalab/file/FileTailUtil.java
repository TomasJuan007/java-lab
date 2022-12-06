package com.tomasjuan007.javalab.file;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class FileTailUtil {
    public static void main(String[] args) throws Exception {
        tail("src/main/resources/spring/config.xml", "5");
        tail("src/main/java/com/tomasjuan007/javalab/file/FileTailUtil.java", "3");
    }

    private static void tail(String fileName, String lineNumber) throws Exception {
        int lineNum;
        try {
            lineNum = Integer.parseInt(lineNumber);
        } catch (Exception e) {
            throw new Exception(lineNumber + " can not be parsed as a Integer", e);
        }
        if (lineNum == 0) {
            return;
        }

        List<String> result = new ArrayList<>(lineNum);
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(fileName, "r");
            long len = rf.length();
            long start = rf.getFilePointer();
            long nextEnd = start + len - 1;
            String line;
            rf.seek(nextEnd);
            int c;
            int counter = 0;
            while (nextEnd > start && counter < lineNum) {
                c = rf.read();
                if (c == '\n' || c == '\r') {
                    line = rf.readLine();
                    if (line != null) {
                        result.add(line);
                    } else {
                        result.add("");
                    }
                    counter++;
                    nextEnd--;
                }
                nextEnd--;
                rf.seek(nextEnd);
                if (nextEnd == 0) {
                    result.add(rf.readLine());
                }
            }
            for (int i = lineNum - 1; i >= 0; i--) {
                if (i < counter) {
                    System.out.println(result.get(i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rf != null) {
                    rf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}