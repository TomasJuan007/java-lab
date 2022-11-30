package com.tomasjuan007.javalab.callback;

public class CallBackTest {
	public static void main(String[] args) {
		Employee employee = new Employee();
		CallBack callBack = new Boss() {
			@Override
			public void done() {
				System.out.println("员工向老板做新的反馈");
			}
		};
		employee.work(callBack);
	}
}