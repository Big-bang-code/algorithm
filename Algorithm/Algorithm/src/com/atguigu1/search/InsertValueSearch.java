package com.atguigu1.search;

import java.util.Arrays;

/**
 * 	3.插值查找
 * @Title InsertValueSearch.java
 * @Description
 * @author 孟BIG
 * @date2019年9月25日
 */
public class InsertValueSearch {
	
	public static void main(String[] args) {
		int arr[] = new int[100];
		for (int i = 0; i < 100; i++) {
			arr[i] = i+1;
		}
		System.out.println(Arrays.toString(arr));
		
		System.out.println(insertValueSearch(arr, 0, 99, 2));
		
	}
	
	/**
	 * 
	 * 	插值查找，也要求数组是有序的
	 * Title:insertValueSearch
	 * @param arr		数组
	 * @param left		左索引
	 * @param right		右索引
	 * @param findval 	查找值
	 * @return
	 */
	public static int insertValueSearch(int arr[],int left,int right,int findVal) {
		//这里数组从小到大排序
		if( left>right || findVal<arr[0] || findVal>arr[arr.length-1]){
			return -1;
		}
		//求出mid
		int mid = left + (right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
		int midVal = arr[mid];
		if(findVal>midVal) {//说明数组应该向右递归
			return insertValueSearch(arr, mid+1, right, findVal);
		}else if(findVal<midVal) {//说明数组应该向左递归
			return insertValueSearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}		
	}	
}
