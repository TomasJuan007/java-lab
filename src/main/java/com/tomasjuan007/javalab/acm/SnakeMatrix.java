package com.tomasjuan007.javalab.acm;

import java.util.Scanner;

/**
 * 2016-09-01 Tencent
 */
public class SnakeMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.close();
		int[][] matrix = new int[size][size];

		assign(matrix);

		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(matrix[i][j]<10){
					System.out.print("   "+matrix[i][j]+" ");
				}else if(matrix[i][j]<100){
					System.out.print("  "+matrix[i][j]+" ");
				}else if(matrix[i][j]<1000){
					System.out.print(" "+matrix[i][j]+" ");
				}else{
					System.out.print(matrix[i][j]+" ");
				}
			}
			System.out.println();
		}
	}

	private static void assign(int[][] matrix) {
		int size = matrix.length;
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++){
				//获得层数
				int level = getLevelByPosition(size,i,j);
				//获得该层左上角元素的值
				int leftup = getLUValueByLevel(size,level);

				int rightup = leftup+size-(2*level-1);
				int rightdown = leftup+2*(size-(2*level-1));
				int leftdown = leftup+3*(size-(2*level-1));

				int leftupY = level-1;
				int rightupX = size-level;
				int rightdownY = size-level;
				int leftdownX = level-1;

				int leftupX = level-1;
				int rightupY = level-1;
				int rightdownX = size-level;
				int leftdownY = size-level;

				if(i==leftupY){
					matrix[i][j]=leftup+j-leftupX;
				}else if(j==rightupX){
					matrix[i][j]=rightup+i-rightupY;
				}else if(i==rightdownY){
					matrix[i][j]=rightdown+rightdownX-j;
				}else if(j==leftdownX){
					matrix[i][j]=leftdown+leftdownY-i;
				}
				//System.out.println(level);
				//System.out.println(leftup);

			}

	}

	private static int getLUValueByLevel(int size, int level) {
		int value = 1;
		for(int i=1;i<level;i++){
			value += 4*(size-(2*i-1));
		}
		return value;
	}

	private static int getLevelByPosition(int size,int i, int j) {
		int level = Math.min(i+1, j+1);
		level = Math.min(level, size-i);
		level = Math.min(level, size-j);
		return level;
	}

}
