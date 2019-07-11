package com.tomasjuan007.javalab.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

	public static void main(String[] args) {
		String line = "tomas007";
		String regex = "([!a-z]+)([0-9]+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		if(matcher.find()){
			for(int i=0;i<=matcher.groupCount();i++){
				System.out.println(matcher.group(i));
				System.out.println("Start:"+matcher.start(i)+",End:"+matcher.end(i));
			}
		}
	}
}
