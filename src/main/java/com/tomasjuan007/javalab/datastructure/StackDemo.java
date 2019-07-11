package com.tomasjuan007.javalab.datastructure;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
	static void showpush(Stack<Integer> st, int a){
		st.push(new Integer(a));
		System.out.println("push("+a+")");
		System.out.println("Stack:"+st);
	}
	static void showpop(Stack<Integer> st){
		System.out.print("Pop-->");
		Integer a = (Integer) st.pop();
		System.out.println(a);
		System.out.println("Stack:"+st);
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		showpush(stack,42);
		showpush(stack,66);
		showpush(stack,99);
		showpop(stack);
		showpop(stack);
		showpop(stack);
		
		try {
			showpop(stack);
		} catch (EmptyStackException e) {
			System.out.println("empty stack");
		}

	}
}
