package com.tomasjuan007.javalab.creativity;

import java.util.*;

public class Game {
    public static void main(String []args) {
        LinkedList<Integer> list = new LinkedList<>();
        while (true) {
            Random random = new Random();
            int num = random.nextInt(128)+1;
            int temp;
            int n=0;
            int rank;

            //System.out.println(num);
            while (true) {
                n++;
                Scanner sc = new Scanner(System.in);
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
                    rank=list.indexOf(n);
                    System.out.println("对了，你一共猜了"+n+"次,暂时排名为"+(rank+1));
                    System.out.println(list.toString());
                    break;
                }
            }
        }
    }
}
