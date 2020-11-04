package com.sort;

import java.util.Arrays;

/**
 * 01.冒泡排序
 * @Title BubbleSort.java
 * @Description
 * @author 孟建邦
 * @date2020年3月10日
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		
		System.out.println("排序前"+Arrays.toString(arr));
		bubbleSort(arr);
				
	}
	
	public static void bubbleSort(int arr[]) {
		int temp = 0;
		boolean flag = false;
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]){
					flag = true;
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] =temp;
				}
			}
			if(!flag) {
				return;
			}else {
				flag = false;//重置flag，进行下一次的判断
			}
			System.out.println(Arrays.toString(arr));
		}	
	}
}
