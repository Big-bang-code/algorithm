package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 2.ѡ������
 * @Title SelectSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��11��
 */
public class SelectSort {
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		selectSort(arr);
	}
	
	//ѡ������
	public static void selectSort(int arr[]) {
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			int minindex = i;
			int min = arr[i];
			for (int j = i; j < arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					minindex = j;
				}
			}
			//��Сֵ�͵�һ��ֵ����λ��
			if(minindex != i) {
				arr[minindex] = arr[i];
				arr[i] = min;		
			}
			System.out.println(Arrays.toString(arr));
		}
	}
	
	
}
