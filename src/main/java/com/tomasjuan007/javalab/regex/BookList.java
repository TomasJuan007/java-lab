package com.tomasjuan007.javalab.regex;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BookList {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        String regex = "(《)(.*?)(》)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            for (int i = 0; i < matcher.groupCount() / 3; i++) {
                String bookName = matcher.group(2);
                Integer result = map.get(bookName);
                if (result == null) {
                    result = 0;
                }
                result++;
                map.put(bookName, result);
            }

        }
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                System.out.println(e.getValue());
                System.out.println(e.getKey());
            }
        }
    }

    private static final String line = "Joel Spolsky\n" +
            "\n" +
            "\n" +
            "\n" +
            "Joel Spolsky毕业于耶鲁大学计算机系，从2000年就开始从事软件开发，2008年联合创立了Stack Overflow，致力于拯救所有领域的开发人员。到目前为止,开发人员在该网站上提出了数百万个各个开发领域内的不同问题。目前是Stack Overflow的CEO，同时他也是Fog Creek Software的联合创始人，Fog Creek Software是纽约市的一家软件公司，创建了FogBugz和Trello\n" +
            "\n" +
            "Joel Spolsky向我们推荐了以下书籍：\n" +
            "《人件》豆瓣评分8.2\n" +
            "《快速软件开发》 豆瓣评分8.5\n" +
            "《代码大全2》豆瓣评分9.3\n" +
            "《程序员修炼之道：从小工到专家》豆瓣评分8.6\n" +
            "《人月神话》豆瓣评分8.3\n" +
            "\n" +
            "\n" +
            "Steve Yegge\n" +
            "\n" +
            "\n" +
            "\n" +
            "Steve Yegge是Grab的Data Insights工程主管，拥有近30年的技术行业经验。曾任职于Amazon，而后在Google工作了13年之久，于2018年1月份离开Google，加入Grab。\n" +
            "\n" +
            "Steve Yegge向我们推荐了以下书籍：\n" +
            "《程序员修炼之道：从小工到专家》豆瓣评分8.8\n" +
            "《重构：改善既有代码的设计》豆瓣评分9.2\n" +
            "《设计模式：可复用面向对象软件的基础》豆瓣评分9.4\n" +
            "《Java并发编程》豆瓣评分8.4\n" +
            "《精通正则表达式（第3版）》豆瓣评分9.2\n" +
            "《算法设计手册（第2版）》豆瓣评分9.0\n" +
            "《C程序设计语言》豆瓣评分9.4\n" +
            "《The Little Schemer》豆瓣评分9.3\n" +
            "《编译原理》豆瓣评分9.1\n" +
            "\n" +
            "\n" +
            "Scott Hanselman\n" +
            "\n" +
            "\n" +
            "\n" +
            "Scott Hanselman是一位知名黑客，教授，每年都会在自己的博客上，整理推荐Windows平台的软件，同时还是《Professional ASP.NET 4.5 in C# and VB》、《ASP.NET MVC 4.5》、《Relationship Hacks》的书籍作者\n" +
            "\n" +
            "Scott Hanselman向我们推荐了以下书籍：\n" +
            "《代码大全2》豆瓣评分9.3\n" +
            "《程序员修炼之道：从小工到专家》豆瓣评分8.6\n" +
            "《编程珠玑》豆瓣评分9.1\n" +
            "《重构：改善既有代码的设计》豆瓣评分9.2\n" +
            "《UNIX操作系统设计》豆瓣评分7.8\n" +
            "《设计模式：可复用面向对象软件的基础》豆瓣评分9.4\n" +
            "\n" +
            "\n" +
            "Stack Overflow\n" +
            "\n" +
            "前面我们提到了Stack Overflow，这是全球IT界最受欢迎的技术问答网站，此前，该网站上曾有一个问题调查： 哪本书是对程序员最有影响、每个程序员都该阅读的书， 这个调查吸引了 153,432 人访问，读者共推荐出了 478 本书，下面列举了投票排行前十的书籍：\n" +
            "《代码大全2》豆瓣评分9.3\n" +
            "《程序员修炼之道：从小工到专家》豆瓣评分8.6\n" +
            "《计算机程序的构造和解释》豆瓣评分8.6\n" +
            "《C程序设计语言》豆瓣评分9.4\n" +
            "《算法导论》豆瓣评分9.5\n" +
            "《设计模式：可复用面向对象软件的基础》豆瓣评分9.4\n" +
            "《重构：改善既有代码的设计》豆瓣评分9.2\n" +
            "《人月神话》豆瓣评分8.4\n" +
            "《计算机程序设计艺术 （第一卷）》豆瓣评分9.4\n" +
            "《编译原理》豆瓣评分9.1\n" +
            "\n";
}
