package com.tomasjuan007.javalab.acm;

/**
 * 2019-08-06 TP-LINK
 */
public class Equals {
	public static void main(String[] args) {
		Integer i1=127, i2=127, i3=128, i4=128;
		System.out.println(i1==i2);
		System.out.println(i1.equals(i2));
		System.out.println(i3==i4);
		System.out.println(i3.equals(i4));
		
		System.out.println();

		// 堆内存
		String str1 = new String("Hello2016");
		// 常量池
		String str2 = "Hello2016";
		String str3 = "Hello" + 2016;
		// 常量池
		String str4 = "Hello2016".intern();
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1==str4);

		System.out.println();

		String cloud1 = "cloud";
		String cloud2 = "cl" + new String("oud");
		System.out.println(cloud1==cloud2);

		// 其他补充
		System.out.println();

		String a = "abc";
		String b = "def";
		String c = a+b; //不在同一行，编译器不会优化，存在堆内存
		String d = "abc"+"def";
		String e = new String("abc");

		System.out.println(a == "abc");
		System.out.println(a == e.intern());
		System.out.println(c == "abcdef");
		System.out.println(d == "abcdef");

	}

}
