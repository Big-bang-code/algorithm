package com.sort;

import java.util.Arrays;

/**
 * 03.插入排序
 * @Title InsertionSorting.java
 * @Description
 * @author 孟建邦
 * @date2020年3月10日
 */
public class InsertionSort{

	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		insertionSort(arr);
	}
	
	public static void insertionSort(int[] arr){
		System.out.println("排序前"+Arrays.toString(arr));
		for(int i=1;i<arr.length;i++) {
			int insertValue = arr[i];//待插入的数
			int insertIndex = i-1;//即待插入数 的 前面的数 的下标
			while(insertIndex>=0  &&  insertValue<arr[insertIndex]) { //说明待插入的数还没有找到适当的插入位置
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;				
			}
			//当退出while循环，说明插入的位置找到，insertIndex+1
			arr[insertIndex+1] = insertValue;			
		}
		System.out.println("排序后"+Arrays.toString(arr));	
	}
		
}
	

