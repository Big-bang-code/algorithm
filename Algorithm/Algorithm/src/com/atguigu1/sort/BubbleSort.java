package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 1.ð������
 * @Title BubbleSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��10��
 */
public class BubbleSort {
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		
		int temp = 0;
		boolean flag = false;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;				
				}
			}
			if(!flag) {
				return;
			}else {
				flag = false;//����flag��������һ�ε��ж�
			}
			System.out.println(Arrays.toString(arr));
		}				
		int[] arr1 = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr1[i] = (int)(Math.random()*80000000);
		}		
	}
}
