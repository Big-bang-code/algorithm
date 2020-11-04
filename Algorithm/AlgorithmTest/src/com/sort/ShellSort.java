package com.sort;

import java.util.Arrays;

/**
 * 04.希尔排序
 * @Title ShellSort.java
 * @Description
 * @author 孟建邦
 * @date2020年3月10日
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100,9,5,7,65,88,14,1,48,3};
		int arr1[] = {100,9,5,7,65,88,14,1,48,3};
		
		
	}
	/**
	 * shellSort1
	 * 希尔排序时， 对有序序列在插入时采用交换法【好理解，但是速度相对较慢】
	 * @param arr
	 * Title:shellSort1
	 */
	public static void shellSort1(int[] arr) {
		System.out.println("排序前"+Arrays.toString(arr));
		
		
		
		
		System.out.println("排序后"+Arrays.toString(arr));
	}
	
	/**
	 * shellSort1
	 * 希尔排序时， 对有序序列在插入时采用移动法【效率较高，但是不好理解】
	 * @param arr
	 * Title:shellSort2
	 */
	public static void shellSort21(int[] arr) {
		System.out.println("排序前"+Arrays.toString(arr));
		
		System.out.println("排序后"+Arrays.toString(arr));
	}
}
