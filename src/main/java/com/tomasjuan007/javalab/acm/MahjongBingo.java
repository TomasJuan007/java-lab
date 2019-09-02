package com.tomasjuan007.javalab.acm;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 2019-08-21 Huawei HiSilicon
 * only Test
 */
public class MahjongBingo {
    //TODO
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int[] input = new int[20];
        while (n > 0) {
            int index = (int) (n%10);
            input[index]+=1;
            n=n/10;
        }
        boolean result;
        result = hoo(input);
        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        System.out.println("The result for 11223344567 is "+hoo(new int[]{1,1,2,2,3,3,4,4,5,6,7,0,0,0,0,0}));
        System.out.println("The result for 11223355678 is "+hoo(new int[]{1,1,2,2,3,3,5,5,6,7,8,0,0,0,0,0}));
    }

    private static boolean hoo(int[] input) {
        boolean result1 = false;
        boolean pairExcluded = false;
        for (int i=1; i<16; i++) {
            int[] temp=input.clone();
            if (temp[i] >= 2 && !pairExcluded) {
                temp[i]=temp[i]-2;
                pairExcluded = true;
                result1 = hoo2(temp);
            }
            boolean result2 = hoo2(input);
            if (result1 || result2) {
                return true;
            }
        }
        return false;
    }

    private static boolean hoo2(int[] input) {
        for (int i=1; i<16; i++) {
            input[i] = input[i]%3;
            if (input[i]==1) {
                input[i]-=1;
                input[i+1]-=1;
                input[i+2]-=1;
            } else if (input[i]==2) {
                input[i]-=2;
                input[i+1]-=2;
                input[i+2]-=2;
            }
        }
        for (int i=1; i<16; i++) {
            if (input[i]!=0) {
                return false;
            }
        }
        return true;
    }

    //TODO: remove first-1 and first-2 instead of next one
    public static void firstVersion(String[] args) {
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
