package com.tomasjuan007.javalab.datastructure;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class PropDemo {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Properties capitals = new Properties();
		Set states;
		String str;
		
		capitals.put("Illinois", "Springfield");
	    capitals.put("Missouri", "Jefferson City");
	    capitals.put("Washington", "Olympia");
	    capitals.put("California", "Sacramento");
	    capitals.put("Indiana", "Indianapolis");
	    
	    states=capitals.keySet();
	    Iterator<String> itr = states.iterator();
	    while(itr.hasNext()){
	    	str=itr.next();
	    	System.out.println("The capital of "+str+" is "+capitals.getProperty(str)+".");
	    }
	    System.out.println();
	    str=capitals.getProperty("Florida","Not Found");
	    System.out.println("The capital of Florida is "+str+".");
	}
}
