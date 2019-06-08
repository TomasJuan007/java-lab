package com.tomasjuan007.javalab.callback;

public class Test {
	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setCallBack(new Boss());
		employee.work();
		}
	
//实际开发调用接口更像以下实现方式，把实现接口的对象作为参数实际开发调用接口更像以下实现方式，把实现接口的对象作为参数
//	Employee employee = new Employee();
//	employee.work(callBack);
	
//	private static CallBack callBack =new CallBack() {
//		
//		@Override
//		public void done() {
//			System.out.println("员工向老板反馈");
//		}
//		};
	}