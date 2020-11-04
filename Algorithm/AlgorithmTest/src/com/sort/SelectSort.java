package com.sort;

import java.util.Arrays;

/**
 * 02.ѡ������
 * @Title SelectSort.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��10��
 */
public class SelectSort {
	
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		selectSort(arr);
	}
	
	public static void selectSort(int arr[]) {
		System.out.println("����ǰ"+Arrays.toString(arr));
		
		for(int i=0;i<arr.length;i++) {
			int minindex = i;
			int min = arr[i];
			for(int j=i;j<arr.length;j++) {
				if(min >arr[j]) {
					min = arr[j];
					minindex = j;
				}
			}
			if(minindex != i) {//˵����������
				arr[minindex] = arr[i];
				arr[i] = min;
			}
		}
		
		System.out.println("�����"+Arrays.toString(arr));
	}
}
