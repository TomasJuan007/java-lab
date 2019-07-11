package com.tomasjuan007.javalab.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflection {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "Reflect.T";
		Class<?> c = Class.forName(str);
		Object o = c.newInstance();
		Method[] methods = c.getMethods();
		for(Method m : methods){
			if(m.getName().equals("mm")){
				m.invoke(o);
			}
			for(Class<?> paramtype : m.getParameterTypes()){
				System.out.println(paramtype.getName());
			}
		}
	}
}

class T {
	static {
		System.out.println("T loaded!");
	}
	public T(){
		System.out.println("T constructed!");
	}
	
	int i;
	String s;
	
	public void mm(){
		System.out.println("mm invoked!");
	}
	
	public void setI(int i){
		this.i = i;
	}
	
	public String getS(){
		return s;
	}
}
