package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 3.��������
 * @Title InesrtSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��11��
 */
public class InesrtSort {
	public static void main(String[] args) {
		int arr[] = {100,9,5,7,65,88,14,1,48,5};
		insertSort(arr);
	}
	
	public static void insertSort(int arr[]) {
		//��һ�� {9,100,5,7,65,88,14,1,48}
		
//		//������������
//		int insertVal = arr[1];
//		int insertIndex = 1-1;//��arr[1]��ǰ�����������±�
//		
//		//��insertVal�ҵ������λ��
//		//��֤��insertVal�ҵ�����λ�ã���Խ��
//		//while�е�ѭ������˵�������������û���ҵ�����λ��
//		//Ҫ��arr[insertIndex]����
//		while(insertIndex >=0 && insertVal<arr[insertIndex]) {
//			arr[insertIndex+1] = arr[insertIndex];
//			insertIndex--;
//		}//���˳�whileѭ��ʱ��˵�������λ���ҵ���insertIndex+1
//		arr[insertIndex + 1] = insertVal;
//		System.out.println("��һ�ֲ���");
		
		System.out.println(Arrays.toString(arr));
		int insertVal = 0;
		int insertIndex = 0;
		
		for (int i = 1; i < arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;
			while(insertIndex >=0 && insertVal<arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			arr[insertIndex + 1] = insertVal;
			System.out.println("��"+i+"�ֲ���");
			System.out.println(Arrays.toString(arr));
		}
	
	}
	
}
