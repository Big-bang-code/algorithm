package com.atguigu.SparseArray;

public class SparseArray {
	public static void main(String[] args) {
		//1.����һ��ԭʼ�Ķ�ά����
		//  0��ʾû������   1��ʾ����   2��ʾ����
		int[][] chessArr1 = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[10][2] = 1;
		chessArr1[2][3] = 2;
		chessArr1[6][3] = 2;
		chessArr1[2][8] = 2;

		//���ԭʼ����
		
//		for(int i=0;i<chessArr1.length;i++) {
//			for (int j = 0; j < chessArr1[i].length; j++) {
//				System.out.print(chessArr1[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("*******************");
		
		System.out.println("ԭʼ�Ķ�ά����");
		for(int[] row:chessArr1) {
			for(int data : row ) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		
		
		//����ά����  ת  ϡ������
		//1.�ȱ�����ά���飬�õ���0���ݵĸ���
		int sum = 0;
		for(int i=0;i<chessArr1.length;i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j]!=0) {
					sum++;
				}			
			}
		}
		System.out.println("��ԭʼ�����0���ĸ���Ϊ"+sum);
		
		//2.������Ӧ��ϡ������
		int sparseArr[][] = new int[sum+1][3];
		//3.��ϡ�����鸳ֵ
		//��һ�У�˵��ԭʼ�������Ϣ��[0][0] ����ԭʼ�������  [0][1]����ԭʼ�������   [0][2]����ԭʼ����ķ�0����
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		
		//������ά���飬����0��ֵ��ŵ�ϡ��������
		int row = 0;//���ڼ�¼�ǵڼ�����0����
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
		//����ϡ������
		System.out.println("����ϡ������");
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
		
		//4.��ϡ������ָ���ԭʼ������
		//ȷ��ԭʼ������к��У���Ӧ����sparseArr��һ�еĵ�һ���͵ڶ�����
		int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
		
		/*
		 * 	Ҫ�Ƚ�ϡ������������������ֶ�Ӧ���ָ���������
		 * 	   sparseArr[i][0] 	���ֵ��Ӧ��������
		 * 	   sparseArr[i][1]    ��
		 * 	   sparseArr[i][2]    ��Ӧ���Ƿ�0��
		 * 
		 * ��ϡ������ĵڶ��п�ʼ
		 */
		
		for(int k=1;k<sparseArr.length;k++) {
			chessArr2[sparseArr[k][0]][sparseArr[k][1]] =  sparseArr[k][2] ;	
			System.out.println(chessArr2[sparseArr[k][0]][sparseArr[k][1]]);
		}

		System.out.println("*******************");
		//�������¸�ֵ��ԭʼ����
		for(int i=0;i<chessArr2.length;i++) {
			for (int j = 0; j < chessArr2[i].length; j++) {
				System.out.print(chessArr2[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}
}
