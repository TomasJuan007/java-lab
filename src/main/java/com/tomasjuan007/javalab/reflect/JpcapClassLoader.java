package com.tomasjuan007.javalab.reflect;

public class JpcapClassLoader {
public static void main(String[] args) {
	new A();
	System.out.println(jpcap.JpcapSender.class.getClassLoader().getClass().getName());
	new B();
}
}
class A{
	
}
class B{
	
}