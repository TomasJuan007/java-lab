package com.tomasjuan007.javalab.datastructure;

import java.util.HashMap;
import java.util.Map;

public class CollectionsDemo {
	public static void main(String[] args) {
		Map<Object, Object> m1 = new HashMap<>();
		m1.put("Zara", "8");
	    m1.put("Mahnaz", "31");
	    m1.put("Ayan", "12");
	    m1.put("Daisy", "14");
	    System.out.println();
	    System.out.println("Map Elements");
	    System.out.println("\t"+m1);
	}
}
