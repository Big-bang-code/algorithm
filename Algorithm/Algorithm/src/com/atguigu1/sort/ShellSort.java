package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 4.ϣ������
 * @Title ShellSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��12��
 */
public class ShellSort {
	
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,3};
		int arr1[] = {100,9,5,7,65,88,14,1,48,3};
		shellSort(arr);
		shellSort1(arr1);
	}
	
	/**
	 * ��������ϣ������
	 * Title:shellSort
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
//		int temp = 0;
//		//ϣ������ĵ�һ��
//		//��һ������:10��Ԫ�ط�Ϊ5��
//		for(int i = 5;i<arr.length;i++) {
//			//���������е����е�Ԫ��(��5�飬ÿ������Ԫ��),����Ϊ5
//			for (int j = i-5; j >=0; j-=5) {
//				//�����ǰ��Ԫ�ش��ڼ��ϲ������Ǹ�Ԫ�أ�˵����Ҫ����
//				if(arr[j]>arr[j+5]) {
//					temp = arr[j];
//					arr[j] = arr[j+5];
//					arr[j+5] = temp;
//				}
//			}
//		}
//		System.out.println("ϣ�������1��"+Arrays.toString(arr));
//		
//		//�ڶ���:10��Ԫ�ط�Ϊ 10/2==>5��      5/2==>2��
//		for(int i = 2;i<arr.length;i++) {
//			//���������е����е�Ԫ��(��5�飬ÿ������Ԫ��),����Ϊ5
//			for (int j = i-2; j >=0; j-=2) {
//				//�����ǰ��Ԫ�ش��ڼ��ϲ������Ǹ�Ԫ�أ�˵����Ҫ����
//				if(arr[j]>arr[j+2]) {
//					temp = arr[j];
//					arr[j] = arr[j+2];
//					arr[j+2] = temp;
//				}
//			}
//		}
//		System.out.println("ϣ�������2��"+Arrays.toString(arr));
//		
//		//������:10��Ԫ�ط�Ϊ 10/2==>5��      5/2==>2��    2/2==>1��
//		for(int i = 1;i<arr.length;i++) {
//			//���������е����е�Ԫ��(��5�飬ÿ������Ԫ��),����Ϊ5
//			for (int j = i-1; j >=0; j-=1) {
//				//�����ǰ��Ԫ�ش��ڼ��ϲ������Ǹ�Ԫ�أ�˵����Ҫ����
//				if(arr[j]>arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
//		System.out.println("ϣ�������3��"+Arrays.toString(arr));
		
		int temp = 0;
		int count = 0;
		for (int gap = arr.length/2; gap >0 ; gap /= 2) {
			
			for(int i = gap;i<arr.length;i++) {
				//���������е����е�Ԫ��(��5�飬ÿ������Ԫ��),����Ϊ5
				for (int j = i-gap; j >=0; j-=gap) {
					//�����ǰ��Ԫ�ش��ڼ��ϲ������Ǹ�Ԫ�أ�˵����Ҫ����
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("ϣ�������"+(++count)+"��"+Arrays.toString(arr));
		}	
	}
	
	/**
	 * �ƶ�����ϣ������
	 * Title:shellSort1
	 * @param arr
	 */
	public static void shellSort1(int[] arr) {
		int count = 0;
		for (int gap = arr.length/2; gap >0 ; gap /= 2) {
			
			//�ӵ�gapԪ�أ�����������ڵ������ֱ�Ӳ�������
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if(arr[j]<arr[j-gap]) {
					while(j-gap >=0 && temp<arr[j-gap]) {
						//��ʼ�ƶ�
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//���˳�whileѭ���󣬾͸�temp�ҵ������λ��
					arr[j] = temp;
				}
				
			}
			System.out.println("ϣ�������"+(++count)+"��"+Arrays.toString(arr));
		}
		
		
	}
	
	
	
}
