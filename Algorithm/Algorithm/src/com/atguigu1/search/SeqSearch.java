package com.atguigu1.search;
/**
 * 	1.顺序查找
 * @Title SeqSearch.java
 * @Description
 * @author 孟BIG
 * @date2019年9月20日
 */
public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = {1,9,-1,11,34,89};
		seqSearch(arr, 89);
	}
	
	/**
	 * 这里实现的线性查找是找到一个满足条件的值就返回
	 * Title:seqSearch
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr,int value) {
		/*
		 * 线性查找是逐一比对，发现有相同的值时就返回下标
		 */
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==value) {
				System.out.println("该数的下标为:"+i+",即第"+(i+1)+"个数");
				return i;
			}
		}
		return -1;
	}
	
}
