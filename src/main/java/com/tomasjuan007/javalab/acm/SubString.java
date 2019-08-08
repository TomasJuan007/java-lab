package com.tomasjuan007.javalab.acm;

import java.util.*;

/**
 * 2016-09-23 Huawei
 * first Test
 */
public class SubString{
	public static void main(String[] args){
        char[] temp = new char[100];
        int count = 0;
        String a;
        String b;
    	Scanner cin = new Scanner(System.in);
        	a = cin.nextLine();
            b = cin.nextLine();
            cin.close();
        boolean flag = false;
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
            	flag=false;
                if(a.charAt(i)==b.charAt(j)) {flag=true;break;}
            }
            if(!flag) temp[count++]=a.charAt(i);
        }
        for(int k=0;k<count;k++) {
        	System.out.print(temp[k]);
        }
        System.out.println();
    }
}