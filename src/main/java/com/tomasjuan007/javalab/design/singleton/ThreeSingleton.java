package com.tomasjuan007.javalab.design.singleton;

import java.util.HashMap;
import java.util.Map;

public class ThreeSingleton {
 private final static String DEFAULT_PREKEY = "cache";
 private static Map<String,ThreeSingleton>
 map = new HashMap<>();
 private static int number = 1;
 private final static int NUM_MAX = 3;
 
 private ThreeSingleton(){
 
 }
 
 public static synchronized ThreeSingleton getInstance(){
 String key = DEFAULT_PREKEY + number;
 ThreeSingleton threeSingleton = map.get(key);
 if(threeSingleton==null){
 threeSingleton = new ThreeSingleton();
 map.put(key, threeSingleton);
 }
 number++;
 if(number>NUM_MAX){
 number=1;
 }
 return threeSingleton;
 }
 
 public static void main(String args[]){
 ThreeSingleton t1 = getInstance();
 ThreeSingleton t2 = getInstance();
 ThreeSingleton t3 = getInstance();
 ThreeSingleton t4 = getInstance();
 ThreeSingleton t5 = getInstance();
 ThreeSingleton t6 = getInstance();
 System.out.println(t1.toString());
 System.out.println(t2.toString());
 System.out.println(t3.toString());
 System.out.println(t4.toString());
 System.out.println(t5.toString());
 System.out.println(t6.toString());
 }
}