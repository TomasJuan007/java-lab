package com.tomasjuan007.javalab.string;

import java.util.Random;

public class RandomString {

	public static void main(String[] args) {
		String base = "abcdefghijklmnopqrstuvwxyz1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<8;i++){
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		System.out.println(sb);
	}
}
