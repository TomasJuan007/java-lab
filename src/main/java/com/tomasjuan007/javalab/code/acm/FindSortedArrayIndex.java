package com.tomasjuan007.javalab.code.acm;

/**
 * 2019-08-06 TP-LINK
 * use bisection to find first index in a sorted array
 */
public class FindSortedArrayIndex {
    public static void main(String[] args) {
        int[] sortedArray = new int[]{40, 41, 42, 43, 44, 45, 45, 45, 45, 45, 46, 47, 48};
        int index = findIndex(sortedArray, 0, sortedArray.length-1, 49);
        System.out.println(index);
    }

    private static int findIndex(int[] sortedArray, int start, int end, int i) {
        if (end - start == 1) {
            if (sortedArray[start] == i) {
                return start;
            } else if (sortedArray[end] == i){
                return end;
            }
            return -1;
        } else if (sortedArray[(start + end) / 2] < i) {
            return findIndex(sortedArray, (start + end) / 2, end, i);
        } else {
            return findIndex(sortedArray, start, (start + end) / 2, i);
        }
    }
}
