package com.tomasjuan007.javalab.game;

import java.util.*;

public class GuessNumberGame {
    private static final Random random = new Random();

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        while (true) {
            int num = random.nextInt(128) + 1;
            int temp;
            int n = 0;
            int rank;

            System.out.println("Game starts, guess a number between 0 and 128.");
            while (true) {
                n++;
                Scanner sc = new Scanner(System.in);
                try {
                    temp = sc.nextInt();
                    if (temp < num) {
                        System.out.println("小了");
                    }
                    if (temp > num) {
                        System.out.println("大了");
                    }
                    if (temp == num) {
                        list.add(n);
                        Collections.sort(list);
                        rank = list.indexOf(n);
                        System.out.println("对了，你一共猜了" + n + "次,暂时排名为" + (rank + 1));
                        System.out.println(list.toString());
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Input is not a integer, exit.");
                    n--;
                }
            }
            System.out.println("Continue?Y/N");
            Scanner sc = new Scanner(System.in);
            String flag = sc.nextLine();
            if (flag.equalsIgnoreCase("N")) {
                break;
            }
        }
    }
}
