package com.atguiguAlgorithm.the001binarySearchNoRecursion;


/**
 * 001.二分查找的非递归实现
 * @Title BinarySearchNoRecur.java
 * @Description
 * @author 孟建邦
 * @date2020年3月14日
 */
public class BinarySearchNoRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,8,10,89,1000,1234};
		
		int resIndex = binarySearch(arr,10);
		System.out.println("resIndex="+resIndex);
		
		
	}
	
	/**
	 * 
	 * @param arr	待查找的数组  arr是升序排列
	 * @param target	需要查找的数
	 * @return	返回对应下标，-1表示没有找到
	 * Title:binarySearch
	 */
	public static int binarySearch(int[] arr,int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {//说明可以继续查找
			int mid = (left + right) / 2 ;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {
				right = mid - 1;//需要向左边查找
			}else {
				left = mid + 1;//需要向右边查找
			}
		}
		return -1;
	}

}
