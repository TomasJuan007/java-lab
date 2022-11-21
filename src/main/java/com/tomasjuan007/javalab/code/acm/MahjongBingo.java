package com.tomasjuan007.javalab.code.acm;

import java.util.*;

/**
 * 2019-08-21 Huawei HiSilicon
 * only Test
 */
public class MahjongBingo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split("");
        LinkedList<Integer> numList = new LinkedList<>();
        for (String str : split) {
            Integer integer = Integer.valueOf(str);
            numList.add(integer);
        }
        Collections.sort(numList);
        boolean result = fun(numList);
        if (result) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
        LinkedList<Integer> case1 = new LinkedList<>();
        case1.add(1);
        case1.add(1);
        case1.add(2);
        case1.add(2);
        case1.add(3);
        case1.add(3);
        case1.add(4);
        case1.add(4);
        case1.add(5);
        case1.add(6);
        case1.add(7);
        LinkedList<Integer> case2 = new LinkedList<>();
        case2.add(1);
        case2.add(1);
        case2.add(2);
        case2.add(2);
        case2.add(3);
        case2.add(3);
        case2.add(5);
        case2.add(5);
        case2.add(6);
        case2.add(7);
        case2.add(8);
        System.out.println("The result for 11223344567 is "+fun(case1));
        System.out.println("The result for 11223355678 is "+fun(case2));
    }

    /**
     * 解析：
     * 1. 判断只剩对子的情况
     * 2. 先判断有没有刻子?
     *   2.1. 如果没有，则循环结束开始查询有没有顺子；
     *   2.2. 如果有，删除刻子元素后递归调用；
     *      2.2.1. 递归返回true, 则证明可以胡牌，继续返回即可；
     *      2.2.2. 递归返回false, 则恢复刚刚删除的刻子元素并跳出循环,让其找顺子
     *      依次递归...
     * 3. 判断有没有顺子？
     *   3.1. 如果没有，则循环结束自动返回false;
     *   3.2. 如果有，则删除顺子元素后递归调用；
     *      3.2.1. 递归返回true, 则可以胡牌，继续返回false即可
     *      3.2.2. 递归返回false, 则恢复刚刚删除的顺子元素，顺延开始元素换其他顺子方案继续查找
     *      (eg: "12344", 上次从链表最后一个开始找，找到234，剩下14，无法胡牌；
     *           则恢复删除的234，从列表的倒数第二个开始找顺子；
     *           依次顺延，最后找到123，剩下44)
     * （参考解法）
     */
    private static boolean fun(LinkedList<Integer> list) {
        if(list.size() == 2){
            if(list.get(0) == list.get(1)){
                return true;
            }else{
                return false;
            }
        }
        boolean flag;
        for(int start = list.size()-1; start > 1; start--){
            //找刻子
            if(list.get(start) == list.get(start-1) && list.get(start-1) == list.get(start-2)){
                Integer a = list.get(start);
                list.remove(a);
                list.remove(a);
                list.remove(a);
                flag = fun(list);
                if(flag){
                    return true;
                }else{
                    list.add(start-2, a);
                    list.add(start-2, a);
                    list.add(start-2, a);
                    break;
                }
            }
        }
        int temp = list.size()-1;
        for(int start = temp; start > 1; start--){
            //找顺子
            if(list.get(start)-1 == list.get(start-1)){
                //找到第一个不相同的点
                int i = start-2;
                while(i>=0){
                    if(list.get(start-1)-1 == list.get(i)){
                        Integer a = list.get(start);
                        Integer b = list.get(start-1);
                        Integer c = list.get(i);
                        list.remove(a);
                        list.remove(b);
                        list.remove(c);
                        flag = fun(list);
                        if(!flag){
                            list.add(i, c);
                            list.add(start-1, a);
                            list.add(start-1, b);
                            start = temp--;
                            break;
                        }else{
                            return true;
                        }
                    }
                    i--;
                }
            }
        }
        return false;
    }

    // 第一个解法错误原因：未考虑不同组合可能交错
    private static class Solution1 {
        public static void firstVersion(String[] args) {
            // 接受输入input
            Scanner sc = new Scanner(System.in);
            long n = sc.nextLong();
            LinkedList<Long> input = new LinkedList<>();
            while (n > 0) {
                input.add(n % 10);
                n = n / 10;
            }

            boolean result;
            if (input.size() != 2 && input.size() != 5 && input.size() != 8
                    && input.size() != 11 && input.size() != 14) {
                // 张数判断
                System.out.println("no");
                return;
            } else {
                // 递归处理，前一个参数为剩余的牌面，后一个参数标识是否已去掉对子
                result = traverse(input, false);
            }
            // 输出结果
            if (result) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        private static boolean traverse(LinkedList<Long> input, boolean pairExisted) {
            // 退出条件
            if (input.size() == 0) {
                return true;
            }
            if (input.size() != 2 && input.size() != 5 && input.size() != 8
                    && input.size() != 11 && input.size() != 14) {
                return false;
            }

            LinkedList<Long> inputCopy = new LinkedList<>(input);
            long first = inputCopy.remove(0);
            long second = inputCopy.remove(0);
            // 如果未排除对子
            if (!pairExisted) {
                // 前两张牌相同
                if (first == second) {
                    // 去掉对子
                    boolean flag = traverse(inputCopy, true);
                    if (flag) {
                        return true;
                    } else {
                        // 凑对子不能胡，尝试凑刻子，如果凑刻子不成功，返回失败（这里有问题，如果凑不成刻子，可能是因为这些牌要凑顺子）
                        long third = inputCopy.remove(0);
                        return third == first && traverse(inputCopy, false);
                    }
                } else if (first == second + 1) {
                    // 前三张牌凑顺子
                    long third = inputCopy.remove(0);
                    return third == second - 1 && traverse(inputCopy, false);
                } else {
                    // 前三张牌凑不成顺子，失败，同理有问题
                    return false;
                }
            } else {
                // 已凑成对子
                if (inputCopy.size() == 0) {
                    // 已经不需要对子
                    return false;
                }
                if (first == second) {
                    // 前两张牌相同，认为要凑刻子
                    long third = inputCopy.remove(0);
                    return third == first && traverse(inputCopy, true);
                } else if (first == second + 1) {
                    // 前两张牌相差一，凑顺子
                    long third = inputCopy.remove(0);
                    return third == second - 1 && traverse(inputCopy, true);
                } else {
                    // 没办法凑刻子或顺子
                    return false;
                }
            }
        }
    }
}
