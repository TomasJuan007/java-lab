package com.tomasjuan007.javalab.acm;

import java.util.Scanner;

/**
 * 2016-09-11 Tencent
 * online 1st programming Test
 */
public class BinarySearchCase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		sc.close();
		transfer(in);
	}

	private static void transfer(int in) {
		int[] result = new int[8];
		int length = 0;
		int left = -90;
		int right = 90;
		int mid = (left + right) / 2;

		double worstCase = Math.ceil(Math.log(right-left) / Math.log(2));
		for (int i = 0; i < worstCase; i++) {
			if (in >= mid) {
				result[i] = 1;
				left = mid;
			} else {
				result[i] = 0;
				right = mid;
			}

			mid = (left + right) / 2;

			//[1,2,3) ->[1,2) / [2,3)
			//[1,2,3,4) -> [1,2) / [2,3,4)
			if (right - left == 1) {
				length = i + 1;
				break;
			}
		}

		for (int j = 0; j < length; j++) {
			System.out.print(result[j]);
		}
		System.out.println();
		System.out.println(left);
	}
}