package com.atguiguAlgorithm.the001binarySearchNoRecursion;


/**
 * 001.���ֲ��ҵķǵݹ�ʵ��
 * @Title BinarySearchNoRecur.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��14��
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
	 * @param arr	�����ҵ�����  arr����������
	 * @param target	��Ҫ���ҵ���
	 * @return	���ض�Ӧ�±꣬-1��ʾû���ҵ�
	 * Title:binarySearch
	 */
	public static int binarySearch(int[] arr,int target) {
		int left = 0;
		int right = arr.length - 1;
		while(left <= right) {//˵�����Լ�������
			int mid = (left + right) / 2 ;
			if(arr[mid] == target) {
				return mid;
			}else if(arr[mid] > target) {
				right = mid - 1;//��Ҫ����߲���
			}else {
				left = mid + 1;//��Ҫ���ұ߲���
			}
		}
		return -1;
	}

}
