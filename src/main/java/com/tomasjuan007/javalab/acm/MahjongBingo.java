package com.tomasjuan007.javalab.acm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 2019-08-21 Huawei HiSilicon
 * only Test
 */
public class MahjongBingo {
    //TODO: remove first-1 and first-2 instead of next one
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        LinkedList<Long> input = new LinkedList<>();
        while (n > 0) {
            input.add(n%10);
            n=n/10;
        }
        boolean result;
        if (input.size()!=2&&input.size()!=5&&input.size()!=8
                &&input.size()!=11&&input.size()!=14) {
            System.out.println("no");
            return;
        } else {
            result = traverse(input, false);
        }
        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean traverse(LinkedList<Long> input, boolean pairExisted) {
        if (input.size()==0) {
            return true;
        }
        if (input.size()!=2&&input.size()!=5&&input.size()!=8
                &&input.size()!=11&&input.size()!=14) {
            return false;
        }
        LinkedList<Long> inputCopy = new LinkedList<>(input);
        long first = inputCopy.remove(0);
        long second = inputCopy.remove(0);
        if (!pairExisted) {
            if (first == second) {
                boolean flag = traverse(inputCopy, true);
                if (inputCopy.size()==0) {
                    return flag;
                } else {
                    long third = inputCopy.remove(0);
                    return third ==  first && traverse(inputCopy, false);
                }
            } else if (first == second+1) {
                long third = inputCopy.remove(0);
                return third == second-1 && traverse(inputCopy, false);
            } else {
                return false;
            }
        } else {
            if (inputCopy.size()==0) {
                return false;
            }
            if (first == second) {
                long third = inputCopy.remove(0);
                return third ==  first && traverse(inputCopy, true);
            } else if (first == second+1) {
                long third = inputCopy.remove(0);
                return third ==  second-1 && traverse(inputCopy, true);
            } else {
                return false;
            }
        }
    }
}
