package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 3.插入排序
 * @Title InesrtSort.java
 * @Description
 * @author 孟BIG
 * @date2019年9月11日
 */
public class InesrtSort {
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		insertSort(arr);
	}
	
	public static void insertSort(int arr[]) {
		//第一轮 {9,100,5,7,65,88,14,1,48}
		
//		//定义待插入的数
//		int insertVal = arr[1];
//		int insertIndex = 1-1;//即arr[1]的前面的这个数的下标
//		
//		//给insertVal找到插入的位置
//		//保证给insertVal找到插入位置，不越界
//		//while中的循环条件说明待插入的数，没有找到插入位置
//		//要让arr[insertIndex]后移
//		while(insertIndex >=0 && insertVal<arr[insertIndex]) {
//			arr[insertIndex+1] = arr[insertIndex];
//			insertIndex--;
//		}//当退出while循环时，说明插入的位置找到，insertIndex+1
//		arr[insertIndex + 1] = insertVal;
//		System.out.println("第一轮插入");
		
		System.out.println(Arrays.toString(arr));
		int insertVal = 0;
		int insertIndex = 0;
		
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;
			while(insertIndex >=0 && insertVal<arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
			System.out.println("第"+i+"轮插入");
			System.out.println(Arrays.toString(arr));
		}
	
	}
	
}
