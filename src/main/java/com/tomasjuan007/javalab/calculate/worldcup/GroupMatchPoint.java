package com.tomasjuan007.javalab.calculate.worldcup;

import java.util.*;

public class GroupMatchPoint {
    public static void main(String[] args) {
        // AB队伍匹配轮次的九种情况
        int[][] values_ab = {
                {3, 0, 3, 0}, {3, 0, 1, 1}, {3, 0, 0, 3},
                {1, 1, 3, 0}, {1, 1, 1, 1}, {1, 1, 0, 3},
                {0, 3, 3, 0}, {0, 3, 1, 1}, {0, 3, 0, 3}
        };
        // AC队伍匹配轮次的九种情况
        int[][] values_ac = {
                {3, 3, 0, 0}, {3, 1, 0, 1}, {3, 0, 0, 3},
                {1, 3, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 3},
                {0, 3, 3, 0}, {0, 1, 3, 1}, {0, 0, 3, 3}
        };
        // AD队伍匹配轮次的九种情况
        int[][] values_ad = {
                {3, 3, 0, 0}, {3, 1, 1, 0}, {3, 0, 3, 0},
                {1, 3, 0, 1}, {1, 1, 1, 1}, {1, 0, 3, 1},
                {0, 3, 0, 3}, {0, 1, 1, 3}, {0, 0, 3, 3}
        };
        // 排序后得分形式计数
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();
        // 对三轮比赛三次循环，遍历出所有729种情况
        for (int[] v_ab : values_ab) {
            for (int[] v_ac : values_ac) {
                for (int[] v_ad : values_ad) {
                    // 该情况下ABCD分别得分
                    int[] element = reduce(v_ab, v_ac, v_ad);
                    // 只关注排序后得分的形式
                    Arrays.sort(element);
                    int temp = 0;
                    for (int i = element.length - 1; i >= 0; i--) {
                        temp = temp * 10 + element[i];
                    }

                    Integer count = resultMap.get(temp);
                    if (count == null) {
                        count = 0;
                    }
                    count = count + 1;
                    resultMap.put(temp, count);
                }
            }
        }
        // 得分形式排序后输出
        Set<Integer> keySet = resultMap.keySet();
        List<Integer> keyList = new ArrayList<>(keySet);
        keyList.sort(((o1, o2) -> o2 - o1));
        System.out.println("The possible result space is " + keyList.size() + ", as below:");
        System.out.println(keyList);
        // 得分形式按计数排序输出
        Map<Integer, Integer> sortMap = sortMap(resultMap);
        System.out.println("For each result, the case as below: ");
        for (Map.Entry<Integer, Integer> entry : sortMap.entrySet()) {
            System.out.println(entry);
        }
    }

    private static int[] reduce(int[] v_ab, int[] v_ac, int[] v_ad) {
        assert v_ab.length == v_ac.length;
        assert v_ab.length == v_ad.length;
        int[] result = new int[v_ab.length];
        for (int i = 0; i < v_ab.length; i++) {
            result[i] = v_ab[i] + v_ac[i] + v_ad[i];
        }
        return result;
    }

    public static Map<Integer, Integer> sortMap(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> e : entryList) {
            linkedHashMap.put(e.getKey(), e.getValue());
        }
        return linkedHashMap;
    }
}
