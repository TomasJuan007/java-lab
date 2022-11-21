package com.tomasjuan007.javalab.code.acm;

import java.util.*;

/**
 * 2021-02-23 Huawei Cloud Core Network
 * 1.输入第一行为工人数，接下来每行输入水果名，员工编号，搬运重量（测试用例都是正常数据没有多余空格）
 * 按水果分组后，按先重量后工人编号的顺序输出
 * input:
 * 5
 * Apple  1 80
 * Apple  2 62
 * Apple  4 73
 * Orange 4 65
 * Orange 1 90
 * Apple  3 91
 * Orange 3 88
 * Orange 5 90
 * output:
 * Apple  2 62
 * Apple  4 73
 * Apple  1 80
 * Apple  3 91
 * Orange 4 65
 * Orange 3 88
 * Orange 1 90
 * Orange 5 90
 * 2.输入一行字符串，获取处在最后的最长数字串
 * input
 * 1234567890abcd9.+12345.678.9ed
 * output
 * +12345.678
 **/
public class WorkerFruitRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Map<String,List<WorkStatus>> map = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (!line.contains(" ")) {break;}
            String[] strs = line.split(" ");
            String type = strs[0];
            String workerNo = strs[1];
            String weight = strs[2];
            int weightNum;
            try {
                weightNum = Integer.parseInt(weight);
            } catch (Exception e) {
                System.out.println("error");
                break;
            }
            if (map.get(type)==null) {
                List<WorkStatus> workStatusList = new ArrayList<>();
                map.put(type, workStatusList);
            }
            List<WorkStatus> workingList = map.get(type);
            WorkStatus workStatus = new WorkStatus();
            workStatus.setWorkerNo(workerNo);
            workStatus.setWeight(weightNum);
            workingList.add(workStatus);
        }

        for (Map.Entry<String, List<WorkStatus>> entry : map.entrySet()) {
            String type = entry.getKey();
            List<WorkStatus> list = entry.getValue();
            list.sort(new Comparator<WorkStatus>() {
                @Override
                public int compare(WorkStatus o1, WorkStatus o2) {
                    if (o1.getWeight().equals(o2.getWeight())) {
                        return o1.getWorkerNo().compareTo(o2.getWorkerNo());
                    }
                    return o1.getWeight()-o2.getWeight();
                }
            });
            map.put(type, list);
        }

        for (Map.Entry<String, List<WorkStatus>> entry : map.entrySet()) {
            String type = entry.getKey();
            List<WorkStatus> list = entry.getValue();
            for (WorkStatus workStatus : list) {
                System.out.println(type+" "+workStatus.getWorkerNo()+" "+workStatus.getWeight());
            }
        }

    }
    public static class WorkStatus {
        String workerNo;
        Integer weight;

        public String getWorkerNo() {
            return workerNo;
        }

        public void setWorkerNo(String workerNo) {
            this.workerNo = workerNo;
        }

        public Integer getWeight() {
            return weight;
        }

        public void setWeight(Integer weight) {
            this.weight = weight;
        }
    }
}
