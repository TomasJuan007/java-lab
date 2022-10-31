package com.tomasjuan007.javalab.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SelectSort {
	private static void selectSort(int[] ints) {
		for (int i = 0; i < ints.length; i++) {
			int minIdx = i;
			for (int j = i; j < ints.length; j++) {
				if (ints[j] < ints[minIdx]) {
					minIdx = j;
				}
			}
			int temp = ints[i];
			ints[i] = ints[minIdx];
			ints[minIdx] = temp;
		}
	}

	public static void main(String[] args) {
		int[] ints = parseInput();
		selectSort(ints);
		formatOutput(ints);
	}

	private static void formatOutput(int[] ints) {
		for (int i = 0; i < ints.length - 1; i++) {
			int anInt = ints[i];
			System.out.print(String.format("%d ", anInt));
		}
		System.out.println(ints[ints.length - 1]);
	}

	private static int[] parseInput() {
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		sc.close();
		String[] split = line.split(" ");
		List<String> newList = new ArrayList<>();
		for (String s : split) {
			if (!"".equals(s)) {
				newList.add(s);
			}
		}
		int[] ints = new int[newList.size()];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = Integer.parseInt(newList.get(i));
		}
		return ints;
	}
}
