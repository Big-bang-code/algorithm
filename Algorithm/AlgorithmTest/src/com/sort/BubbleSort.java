package com.sort;

import java.util.Arrays;

/**
 * 01.ð������
 * @Title BubbleSort.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��10��
 */
public class BubbleSort {

	public static void main(String[] args) {
		
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		
		System.out.println("����ǰ"+Arrays.toString(arr));
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
				flag = false;//����flag��������һ�ε��ж�
			}
			System.out.println(Arrays.toString(arr));
		}	
	}
}
