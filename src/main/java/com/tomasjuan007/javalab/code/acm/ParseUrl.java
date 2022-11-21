package com.tomasjuan007.javalab.code.acm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019-08-06 TP-LINK
 * regex to get domain, port, url path
 **/
public class ParseUrl {
    public static void main(String[] args) {
        String url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1";
        Pattern p = Pattern.compile("https?://([\\w.]+):?(\\d+)?/([?/=\\-_&%\\w]*)");
        Matcher m = p.matcher(url);
        while(m.find()) {
            String urlPath = m.group(2);
            if (urlPath == null) {
                urlPath = "80";
            }
            System.out.println("The domain is " + m.group(1));
            System.out.println("The port is " + urlPath);
            System.out.println("The url path is " + m.group(3));
        }
    }
}
