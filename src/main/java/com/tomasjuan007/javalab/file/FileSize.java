package com.tomasjuan007.javalab.file;

import java.io.File;

public class FileSize {
    private static double getDirSize(File file) {
        //判断文件是否存在
        if (file.exists()) {
            //如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children == null || children.length ==0) {
                    return 0.0;
                }
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {//如果是文件则直接返回其大小,以“兆”为单位
                return (double) file.length() / 1024 / 1024;
            }
        } else {
            System.out.println("文件或者文件夹不存在，请检查路径是否正确！");
            return 0.0;
        }
    }
    public static void main(String[] args) {
        double totalSize = getDirSize(new File("C:\\Users\\Administrator\\Desktop\\"));
        System.out.println(totalSize);
    }
}
