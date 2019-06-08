package com.tomasjuan007.javalab.callback;

public class Employee {
	private CallBack callBack =null;
	
	public void setCallBack(CallBack callBack) {
		this.callBack = callBack;
	}
	
	public void work(){
		for(int i=0;i<3;i++){
			System.out.println("做完第"+(i+1)+"件事...");
		}
		
		callBack.done();
	}
	
//	public void work(CallBack callBack){
//		for(int i=0;i<3;i++){
//			System.out.println("做完第"+(i+1)+"件事...");
//		}
//		
//		callBack.done();
//	}
}
