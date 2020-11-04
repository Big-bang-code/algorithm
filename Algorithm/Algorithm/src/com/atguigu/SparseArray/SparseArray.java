package com.atguigu.SparseArray;

public class SparseArray {
	public static void main(String[] args) {
		//1.创建一个原始的二维数组
		//  0表示没有棋子   1表示黑子   2表示蓝子
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[10][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[6][3] = 2;
		chessArr1[2][8] = 2;

		//输出原始数组
		
//		for(int i=0;i<chessArr1.length;i++) {
//			for (int j = 0; j < chessArr1[i].length; j++) {
//				System.out.print(chessArr1[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("*******************");
		
		System.out.println("原始的二维数组");
		for(int[] row:chessArr1) {
			for(int data : row ) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		
		
		//将二维数组  转  稀疏数组
		//1.先遍历二维数组，得到非0数据的个数
		int sum = 0;
		for(int i=0;i<chessArr1.length;i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j]!=0) {
					sum++;
				}			
			}
		}
		System.out.println("该原始数组非0数的个数为"+sum);
		
		//2.创建对应的稀疏数组
		int sparseArr[][] = new int[sum+1][3];
		//3.给稀疏数组赋值
		//第一行：说明原始数组的信息：[0][0] 代表原始数组的行  [0][1]代表原始数组的列   [0][2]代表原始数组的非0个数
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//遍历二维数组，将非0的值存放到稀疏数组中
		int row = 0;//用于记录是第几个非0数据
		for(int i=0;i<chessArr1.length;i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j]!=0) {
					row++;
					sparseArr[row][0] = i;
					sparseArr[row][1] = j;
					sparseArr[row][2] = chessArr1[i][j];
				}
			}
		}
		
		System.out.println("*******************");
		//遍历稀疏数组
		System.out.println("遍历稀疏数组");
		for(int i=0;i<sparseArr.length;i++) {
			for (int j = 0; j < sparseArr[i].length; j++) {
				System.out.print(sparseArr[i][j]+"\t");	
			}
			System.out.println();
		}
		
//		for(int i=0;i<sparseArr.length;i++) {
//			System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
//		}
		
		System.out.println("*******************");
		
		//4.将稀疏数组恢复成原始的数组
		//确定原始数组的行和列，对应的是sparseArr第一行的第一个和第二个数
		int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		/*
		 * 	要先将稀疏数组遍历，将其数字对应到恢复的数组中
		 * 	   sparseArr[i][0] 	这个值对应的是行数
		 * 	   sparseArr[i][1]    列
		 * 	   sparseArr[i][2]    对应的是非0数
		 * 
		 * 从稀疏数组的第二行开始
		 */
		
		for(int k=1;k<sparseArr.length;k++) {
			chessArr2[sparseArr[k][0]][sparseArr[k][1]] =  sparseArr[k][2] ;	
			System.out.println(chessArr2[sparseArr[k][0]][sparseArr[k][1]]);
		}

		System.out.println("*******************");
		//遍历重新赋值的原始数组
		for(int i=0;i<chessArr2.length;i++) {
			for (int j = 0; j < chessArr2[i].length; j++) {
				System.out.print(chessArr2[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}
}
