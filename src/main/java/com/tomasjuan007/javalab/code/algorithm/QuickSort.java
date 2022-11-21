package com.tomasjuan007.javalab.code.algorithm;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i=0; i<arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        int[] result = quickSort(arr, 0, arr.length-1);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (arr[high] >= pivot && low < high) {
                high--;
            }
            arr[low] = arr[high];
            arr[high] = pivot;
            while (arr[low] <= pivot && low < high) {
                low++;
            }
            arr[high] = arr[low];
            arr[low] = pivot;
        }
        return low;
    }

    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
        return arr;
    }
}
