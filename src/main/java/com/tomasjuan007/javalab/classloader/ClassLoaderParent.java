package com.tomasjuan007.javalab.classloader;

public class ClassLoaderParent {
	public static void main(String[] args) {
		//获得加载JpcapSender.class这个类的类加载器
		ClassLoader loader = jpcap.JpcapSender.class.getClassLoader();
		while(loader != null) {
			System.out.println(loader.getClass().getName());
			//获得父类加载器的引用
			loader = loader.getParent();
		}
		System.out.println(loader);
	}
}

