package com.tomasjuan007.javalab.string;

public class StringTest {
public static void main(String[] args) {
	String a = "abc";
	String b = "def";
	String c = a+b;
	String d = "abc"+"def";
	String e = new String("abc");
	//String f = "abc";
	
	//System.out.println(a == e);
	//System.out.println(a.equals(e));
	System.out.println(a == "abc");
	System.out.println(a == e.intern());
	System.out.println(c == "abcdef");
	System.out.println(d == "abcdef");
	//System.out.println(a == f);
}
}