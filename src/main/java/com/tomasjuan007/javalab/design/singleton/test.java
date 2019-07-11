package com.tomasjuan007.javalab.design.singleton;

public class test {
	public static void main(String[] args) {
		//java j=new java();
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		System.out.println("单例:"+(s1==s2));
		
		test t1=new test();
		test t2=new test();
		System.out.println("单例:"+(t1==t2));

	}
}
