package com.tomasjuan007.javalab.code.acm;

import java.util.Scanner;

/**
 * 2016-09-06 CVTE
 *
 */
public class Bracket {
	
	private static boolean validate(String str){
		boolean[] stack = new boolean[100];
		int index = 0;
		for(int i=0; i<str.length();i++){
			if(str.charAt(i)=='{'){
				stack[index++]=true;
			}
			if(str.charAt(i)=='('){
				stack[index++]=false;
			}
			if (str.charAt(i)=='}') {
				if(index!=0 && stack[index - 1]){
					index--;
				}else {
					return false;
				}
			}
			if(str.charAt(i)==')'){
				if (index!=0 && !stack[index - 1]) {
					index--;
				}else{
					return false;
				}
			}
		}
		return index == 0;
	}
	public static void main(String[] args) {
		String str1 = "0{1(2(3)4)(5{6}7)8}9";
		System.out.println("使用说明： 输入字符串判断括号是否匹配，输入以0开头字符串退出");
		System.out.println("示例\n"+str1+'\n'+validate(str1));

		String str2;
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			str2 = sc.next();
			if(str2.charAt(0)=='0') break;
			System.out.println(validate(str2));
		}
		sc.close();
	}
}
