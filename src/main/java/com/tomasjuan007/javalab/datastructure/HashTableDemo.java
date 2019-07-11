package com.tomasjuan007.javalab.datastructure;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableDemo {
	public static void main(String[] args) {
		Hashtable<String, Double> balance = new Hashtable<>();
		Enumeration<String> names;
		String str;
		double bal;
		
		balance.put("Zara", new Double(3434.34));
	    balance.put("Mahnaz", new Double(123.22));
	    balance.put("Ayan", new Double(1378.00));
	    balance.put("Daisy", new Double(99.22));
	    balance.put("Qadir", new Double(-19.08));
	    
	    names = balance.keys();
	    while(names.hasMoreElements()){
	    	str = names.nextElement();
	    	System.out.println(str+":"+balance.get(str));
	    }
	    System.out.println();
	    bal=balance.get("Zara").doubleValue();
	    balance.put("Zara", new Double(bal+1000));
	    System.out.println("Zara's new balance:"+balance.get("Zara"));
	}
}
