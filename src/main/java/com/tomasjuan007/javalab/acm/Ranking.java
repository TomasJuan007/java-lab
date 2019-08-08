package com.tomasjuan007.javalab.acm;

/**
 * 2016-09-23 Huawei
 * second Test
 * input example
 * LOD GRADE:NAME=XiaoMing,MATH=80,LANG=90;
LOD GRADE:NAME=XiaoHong,LANG=60,MATH=100;
LOD GRADE:NAME=XiaoMei,MATH=70,LANG=90;
LST GRADE:NAME=XiaoHong;
 */
import java.util.*;
public class Ranking{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
        String a;
        String temp;
        String name = null;
        int math;
        int lang;
        int total;
        Map<String,Integer> Math = new HashMap<String,Integer>();
        Map<String,Integer> Lang = new HashMap<String,Integer>();
        Map<String,Integer> Total = new HashMap<String,Integer>();
		while(cin.hasNext()){
        	temp = cin.nextLine();
        	a=temp.replace(';', ',');
            if(a.charAt(1)=='S') {
                name = a.substring(15,a.indexOf(','));
                break;
        	}else if(a.charAt(1)=='O') {
            	name = a.substring(15,a.indexOf(','));
                math=Integer.parseInt(a.substring(a.indexOf("MATH=")+5,a.indexOf(',',a.indexOf("MATH="))));
                lang=Integer.parseInt(a.substring(a.indexOf("LANG=")+5,a.indexOf(',',a.indexOf("LANG="))));
                total=math+lang;
                Math.put(name,math);
                Lang.put(name,lang);
                Total.put(name,total);
            }
            
		}
		cin.close();
        System.out.println(name+" "
                           +Math.get(name)+" "
                           +Lang.get(name)+" "
                           +Total.get(name)+" "
                           +getRank(Math,name)+" "
                           +getRank(Lang,name)+" "
                           +getRank(Total,name));
	}
    private static int getRank(Map<String, Integer> map, String str){
    	int rank = 1;
        for (String s : map.keySet()) {
            String key;
            int value;
            key = s;
            value = map.get(key);
            if (value > map.get(str)) rank++;
        }
        return rank;
    }
}