package com.tomasjuan007.javalab.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InsertSort {

	
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
	for(int i=0;i<ints.length;i++){
		ints[i] = Integer.parseInt(list.get(i));
	}
	// DIY
	for(int i = 1; i <  ints.length; i++){
		int in = i;
		for(int j = i-1; j >= 0; j--){
			
			if (ints[j] > ints[i]) {
			in = j;
			}
		}
		int temp = ints[i];
		for(int k = i; k > in; k--){
			ints[k] = ints[k-1];
		}
		ints[in] = temp;
		
	}
	
	/* answer
         for (int i = 1; i < ints.length; i++) {
            for (int j = 0; j < i; j++) {
                if (ints[i] <= ints[j]) {
                    int temp = ints[i];
                    for (int k = i; k >= j && k > 0; k--) {
                        ints[k] = ints[k - 1];
                    }
                    ints[j] = temp;
                }
            }
        }
	 */
	for(int i = 0; i < ints.length-1; i++){
		int anInt = ints[i];
		System.out.print(String.format("%d ", anInt));
	}
	System.out.println(ints[ints.length-1]);
	}
}
