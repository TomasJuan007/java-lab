package com.tomasjuan007.javalab.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestReflectCSDN {
	public static void main(String[] args) throws ClassNotFoundException {
		//获取类对象
		Boolean var1 = true;
		Class<?> classType2 = var1.getClass();
		System.out.println(classType2);

		Class<?> classtype4 = Field.class;
		System.out.println(classtype4);

		Class<?> classType5 = Class.forName("java.lang.Boolean");
		System.out.println(classType5);

		Class<?> classtype3 = Boolean.TYPE;
		System.out.println(classtype3);

		System.out.println("-----------------------------------");

		//获取类的Fields
		Class<?> classType = ExtendType.class;

		// 使用getFields获取属性
		Field[] fields = classType.getFields();
		for (Field f : fields)
		{
			System.out.println(f);
		}

		System.out.println();

		// 使用getDeclaredFields获取属性
		fields = classType.getDeclaredFields();
		for (Field f : fields)
		{
			System.out.println(f);
		}

		System.out.println("-----------------------------------");

		//获取类的Metthod
		// 使用getMethods获取函数
		Method[] methods = classType.getMethods();
		for (Method m : methods)
		{
			System.out.println(m);
		}

		System.out.println();

		// 使用getDeclaredMethods获取函数
		methods = classType.getDeclaredMethods();
		for (Method m : methods)
		{
			System.out.println(m);
		}

		System.out.println("-----------------------------------");

		//获取类的Constructor
		// 使用getConstructors获取构造器
		Constructor<?>[] constructors = classType.getConstructors();
		for (Constructor<?> m : constructors)
		{
			System.out.println(m);
		}

		System.out.println();

		// 使用getDeclaredConstructors获取构造器
		constructors = classType.getDeclaredConstructors();
		for (Constructor<?> m : constructors)
		{
			System.out.println(m);
		}
	}
}
class Type{
	public int pubIntField;
	public String pubStringField;
	private int prvIntField;

	public Type(){
		Log("Default Constructor");
	}

	Type(int arg1, String arg2){
		pubIntField = arg1;
		pubStringField = arg2;

		Log("Constructor with parameters");
	}

	public void setIntField(int val) {
		this.prvIntField = val;
	}
	public int getIntField() {
		return prvIntField;
	}

	private void Log(String msg){
		System.out.println("Type:" + msg);
	}
}

class ExtendType extends Type{
	public int pubIntExtendField;
	public String pubStringExtendField;
	private int prvIntExtendField;

	public ExtendType(){
		Log("Default Constructor");
	}

	ExtendType(int arg1, String arg2){
		pubIntExtendField = arg1;
		pubStringExtendField = arg2;

		Log("Constructor with parameters");
	}

	public void setIntExtendField(int field7) {
		this.prvIntExtendField = field7;
	}
	public int getIntExtendField() {
		return prvIntExtendField;
	}

	private void Log(String msg){
		System.out.println("ExtendType:" + msg);
	}
}
