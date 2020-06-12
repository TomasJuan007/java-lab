package com.tomasjuan007.javalab.profile;

public class SortComputationTask extends Thread {
    private static final int SCALE = 10000;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        int[] a = new int[SCALE];
        for (int i=SCALE; i>0; i--) {
            a[i-1] = i;
        }
        int[] result = quickSort(a,0,a.length-1);
        long end = System.currentTimeMillis();
        double duration = end - start;
        System.out.println(this.getName() + " Sort Computation task takes: " + duration);
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
