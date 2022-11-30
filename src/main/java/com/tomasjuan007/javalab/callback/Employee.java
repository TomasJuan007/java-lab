package com.tomasjuan007.javalab.callback;

public class Employee {
	public void work(CallBack callBack){
		for (int i = 0; i < 3; i++) {
			System.out.println("做完第" + (i + 1) + "件事...");
		}
		callBack.done();
	}
}
