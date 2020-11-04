package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 4.希尔排序
 * @Title ShellSort.java
 * @Description
 * @author 孟BIG
 * @date2019年9月12日
 */
public class ShellSort {
	
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,3};
		int arr1[] = {100,9,5,7,65,88,14,1,48,3};
		shellSort(arr);
		shellSort1(arr1);
	}
	
	/**
	 * 交换法的希尔排序
	 * Title:shellSort
	 * @param arr
	 */
	public static void shellSort(int[] arr) {
//		int temp = 0;
//		//希尔排序的第一轮
//		//第一轮排序:10个元素分为5组
//		for(int i = 5;i<arr.length;i++) {
//			//遍历各组中的所有的元素(共5组，每组两个元素),步长为5
//			for (int j = i-5; j >=0; j-=5) {
//				//如果当前的元素大于加上步长的那个元素，说明需要交换
//				if(arr[j]>arr[j+5]) {
//					temp = arr[j];
//					arr[j] = arr[j+5];
//					arr[j+5] = temp;
//				}
//			}
//		}
//		System.out.println("希尔排序第1轮"+Arrays.toString(arr));
//		
//		//第二轮:10个元素分为 10/2==>5组      5/2==>2组
//		for(int i = 2;i<arr.length;i++) {
//			//遍历各组中的所有的元素(共5组，每组两个元素),步长为5
//			for (int j = i-2; j >=0; j-=2) {
//				//如果当前的元素大于加上步长的那个元素，说明需要交换
//				if(arr[j]>arr[j+2]) {
//					temp = arr[j];
//					arr[j] = arr[j+2];
//					arr[j+2] = temp;
//				}
//			}
//		}
//		System.out.println("希尔排序第2轮"+Arrays.toString(arr));
//		
//		//第三轮:10个元素分为 10/2==>5组      5/2==>2组    2/2==>1组
//		for(int i = 1;i<arr.length;i++) {
//			//遍历各组中的所有的元素(共5组，每组两个元素),步长为5
//			for (int j = i-1; j >=0; j-=1) {
//				//如果当前的元素大于加上步长的那个元素，说明需要交换
//				if(arr[j]>arr[j+1]) {
//					temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//				}
//			}
//		}
//		System.out.println("希尔排序第3轮"+Arrays.toString(arr));
		
		int temp = 0;
		int count = 0;
		for (int gap = arr.length/2; gap >0 ; gap /= 2) {
			
			for(int i = gap;i<arr.length;i++) {
				//遍历各组中的所有的元素(共5组，每组两个元素),步长为5
				for (int j = i-gap; j >=0; j-=gap) {
					//如果当前的元素大于加上步长的那个元素，说明需要交换
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
			System.out.println("希尔排序第"+(++count)+"轮"+Arrays.toString(arr));
		}	
	}
	
	/**
	 * 移动法的希尔排序
	 * Title:shellSort1
	 * @param arr
	 */
	public static void shellSort1(int[] arr) {
		int count = 0;
		for (int gap = arr.length/2; gap >0 ; gap /= 2) {
			
			//从第gap元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if(arr[j]<arr[j-gap]) {
					while(j-gap >=0 && temp<arr[j-gap]) {
						//开始移动
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//当退出while循环后，就给temp找到插入的位置
					arr[j] = temp;
				}
				
			}
			System.out.println("希尔排序第"+(++count)+"轮"+Arrays.toString(arr));
		}
		
		
	}
	
	
	
}
