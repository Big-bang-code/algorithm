package com.sort;

import java.util.Arrays;

/**
 * 02.选择排序
 * @Title SelectSort.java
 * @Description
 * @author 孟建邦
 * @date2020年3月10日
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		selectSort(arr);
	}
	
	public static void selectSort(int arr[]) {
		System.out.println("排序前"+Arrays.toString(arr));
		
		for(int i=0;i<arr.length;i++) {
			int minindex = i;
			int min = arr[i];
			for(int j=i;j<arr.length;j++) {
				if(min >arr[j]) {
					min = arr[j];
					minindex = j;
				}
			}
			if(minindex != i) {//说明发生交换
				arr[minindex] = arr[i];
				arr[i] = min;
			}
		}
		
		System.out.println("排序后"+Arrays.toString(arr));
	}
}
