package com.tomasjuan007.javalab.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String line = sc.nextLine();
	sc.close();
	String[] split = line.split(" ");
	List<String> list =  Arrays.asList(split); 
	for(int i=0;i<list.size();i++){
		String s = list.get(i);
		if (" ".equals(s)) {
			list.remove(i);
		}
	}
	int[] ints = new int[list.size()];
	for(int i=0;i<ints.length;i++){/*不用list.size()*/
		ints[i] = Integer.parseInt(list.get(i));
	}
	for(int i = 0; i <  ints.length; i++){
		for(int j = 1; j < ints.length - i; j++){
			int temp = ints[j-1];
			if (temp > ints[j]) {
			ints[j-1] = ints[j];
			ints[j] = temp;
			}
		}
	}
	for(int i = 0; i < ints.length-1; i++){
		//System.out.print(ints[i]+" ");/*直接输出会在OJ出错*/
		int anInt = ints[i];
		System.out.print(String.format("%d ", anInt));
	}
	System.out.println(ints[ints.length-1]);
	}
}
