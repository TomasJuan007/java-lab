package com.tomasjuan007.javalab.callback;

public class Boss implements CallBack{
	@Override
	public void done() {
		System.out.println("员工向老板反馈");
	}
}
