package com.tomasjuan007.javalab.newcoder;


/*二维数组中的查找*/
/*在一个二维数组中，每一行从左到右递增，每一列从上到下递增，请完成一个函数，输入这样一个二维数组和一个整数，判断数组中是否有该整数*/
public class Solution1 {
    public boolean find(int target, int[][] array) {
        int row = array.length - 1;
        int column = 0;
        while (row >= 0 && column < array[0].length) {
            int temp = array[row][column];
            if (temp == target) {
                return true;
            } else if (temp > target) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }

    //less efficient one
    @Deprecated
    public boolean Find(int target, int [][] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        boolean test = solution.find(7, array);
        System.out.println(test);
    }
}
