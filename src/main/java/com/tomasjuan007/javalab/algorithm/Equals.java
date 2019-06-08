package com.tomasjuan007.javalab.algorithm;

public class Equals {
	public static void main(String[] args) {
		Integer i1=127, i2=127, i3=128, i4=128;
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		System.out.println(i3==i4);
		System.out.println(i3.equals(i4));
		
		System.out.println('\n');
		
		String str1 = new String("Hello2016");
		String str2 = "Hello2016";
		String str3 = "Hello" + 2016;
		String str4 = "Hello2016".intern();
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1==str4);
		
	}

}
