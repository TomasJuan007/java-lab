package com.tomasjuan007.javalab.acm;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2016-09-06 CVTE
 */
public class StackReverse {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc;
		while(true){
			sc = new Scanner(System.in);
			int num = Integer.parseInt(sc.nextLine());
			Stack<String> stack = new Stack<String>();
			for(int i=0;i<num;i++){
				stack.push(sc.nextLine());
			}
			reverse(stack);
			System.out.println(stack);
		}
	}

	private static Stack<String> reverse(Stack<String> stack) {
		if(stack.empty()) {
			return stack;
		}else{
			String str = stack.pop();
			reverse(stack);
			pushBottom(stack, str);
		}
		return stack;
	}

	private static void pushBottom(Stack<String> stack, String str) {
		if (stack.empty()) {
			stack.push(str);
		}else{
			String top = stack.pop();
			pushBottom(stack, str);
			stack.push(top);
		}
	}

}
