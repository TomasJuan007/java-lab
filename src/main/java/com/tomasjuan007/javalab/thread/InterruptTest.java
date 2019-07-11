package com.tomasjuan007.javalab.thread;
import java.util.*;
public class InterruptTest {
	public static void main(String[] args){
		MyThread thread=new MyThread();
		thread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException ignored) {
		}
		thread.interrupt();
	}
	public static class MyThread extends Thread{
		boolean flag = true;
		public void run(){
			while(flag){
				System.out.println("==="+new Date()+"===");
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					return;
				}
			}
		}
	}
}