package com.tomasjuan007.javalab.calculate.league;

import java.util.Arrays;

public class PointStd {
    public static void main(String[] args) {
        double[] points_08_09 = {90, 86, 83, 72, 63, 62, 53, 51, 51, 50, 45, 45, 41, 41, 41, 36, 35, 34, 32, 32};
        sd(points_08_09);
        double[] points_09_10 = {86, 85, 75, 70, 67, 64, 63, 61, 50, 50, 47, 46, 44, 39, 38, 36, 35, 30, 30, 19};
        sd(points_09_10);
        double[] points_10_11 = {80, 71, 71, 68, 62, 58, 54, 49, 48, 47, 47, 46, 46, 46, 43, 42, 40, 39, 39, 33};
        sd(points_10_11);
        double[] points_11_12 = {89, 89, 70, 69, 65, 64, 56, 52, 52, 47, 47, 47, 45, 45, 43, 38, 37, 36, 31, 25};
        sd(points_11_12);
        double[] points_12_13 = {89, 78, 75, 73, 72, 63, 61, 49, 46, 46, 44, 43, 42, 41, 41, 41, 39, 36, 28, 25};
        sd(points_12_13);
        double[] points_13_14 = {86, 84, 82, 79, 72, 69, 64, 56, 50, 49, 45, 42, 40, 38, 38, 37, 36, 33, 32, 30};
        sd(points_13_14);
        double[] points_14_15 = {87, 79, 75, 70, 64, 62, 60, 56, 54, 48, 47, 47, 44, 41, 39, 38, 38, 35, 33, 30};
        sd(points_14_15);
        double[] points_15_16 = {81, 71, 70, 66, 66, 63, 62, 60, 51, 50, 47, 47, 45, 43, 42, 42, 39, 37, 34, 17};
        sd(points_15_16);
        double[] points_16_17 = {93, 86, 78, 76, 75, 69, 61, 46, 46, 45, 45, 44, 44, 41, 41, 40, 40, 34, 28, 24};
        sd(points_16_17);
        double[] points_17_18 = {100, 81, 77, 75, 70, 63, 54, 49, 47, 44, 44, 44, 42, 41, 40, 37, 36, 33, 33, 31};
        sd(points_17_18);
        double[] points_18_19 = {98, 97, 72, 71, 70, 66, 57, 54, 52, 52, 50, 49, 45, 45, 40, 39, 36, 34, 26, 16};
        sd(points_18_19);
        double[] points_19_20 = {99, 81, 66, 66, 62, 59, 59, 56, 54, 54, 52, 49, 44, 43, 41, 39, 35, 34, 34, 21};
        sd(points_19_20);
        double[] points_20_21 = {86, 74, 69, 67, 66, 65, 62, 61, 59, 59, 55, 45, 45, 44, 43, 41, 39, 28, 26, 23};
        sd(points_20_21);
        double[] points_21_22 = {93, 92, 74, 71, 69, 58, 56, 52, 51, 51, 49, 48, 46, 45, 40, 39, 38, 35, 23, 22};
        sd(points_21_22);
        double[] points_22_23 = {89, 84, 75, 71, 67, 62, 61, 60, 59, 52, 45, 44, 41, 40, 39, 38, 36, 34, 31, 25};
        sd(points_22_23);
    }

    private static void sd(double[] points) {
        // 计算平均值
        double mean = Arrays.stream(points).average().orElse(Double.NaN);
        // 计算偏差和的平方和
        double deviationSum = Arrays.stream(points).map(point -> Math.pow(point - mean, 2)).sum();
        // 计算方差
        double variance = deviationSum / points.length;
        // 计算标准差
        double std = Math.sqrt(variance);
        System.out.println("标准差：" + std);
    }
}
