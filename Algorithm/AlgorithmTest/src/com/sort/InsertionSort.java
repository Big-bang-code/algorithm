package com.sort;

import java.util.Arrays;

/**
 * 03.��������
 * @Title InsertionSorting.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��10��
 */
public class InsertionSort{

	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		insertionSort(arr);
	}
	
	public static void insertionSort(int[] arr){
		System.out.println("����ǰ"+Arrays.toString(arr));
		for(int i=1;i<arr.length;i++) {
			int insertValue = arr[i];//���������
			int insertIndex = i-1;//���������� �� ǰ����� ���±�
			while(insertIndex>=0  &&  insertValue<arr[insertIndex]) { //˵�������������û���ҵ��ʵ��Ĳ���λ��
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;				
			}
			//���˳�whileѭ����˵�������λ���ҵ���insertIndex+1
			arr[insertIndex+1] = insertValue;			
		}
		System.out.println("�����"+Arrays.toString(arr));	
	}
		
}
	

