package com.tomasjuan007.javalab.design.singleton;

public class Singleton {
	private Singleton(){
		
	}

	private static final Singleton singleton=new Singleton();
	public static Singleton getInstance() {
		return singleton;
	}
}
