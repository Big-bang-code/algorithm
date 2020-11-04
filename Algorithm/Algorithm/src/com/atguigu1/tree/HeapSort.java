package com.atguigu1.tree;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int arr[] = {4,6,8,5,9};
		heapSort(arr);
	}
	
	//��дһ��������ķ���
	public static void heapSort(int arr[]) {
		System.out.println("������ķ���");
		int temp = 0;
//		//�ֲ����
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("��һ��"+Arrays.toString(arr));
//		
//		adjustHeap(arr, 0, arr.length);
//		System.out.println("�ڶ���"+Arrays.toString(arr));
		
		//������մ���
		//1.���������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
		for(int i=arr.length /2 - 1;i>=0;i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		for(int j = arr.length -1;j>0;j--) {
			//����
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println("���飺"+Arrays.toString(arr));
	}
	
	//��һ������(������)������һ���󶥶ѣ�
	/**
	 * ����:��ɽ���i�ķ�Ҷ�ӽڵ���������ɴ󶥶�
	 * Title:adjustHeap
	 * @param arr	������������
	 * @param i		��ʾ��Ҷ�ӽڵ���������е�����
	 * @param length	��ʾ�Զ��ٸ�Ԫ�ؽ��е�����length�����𽥵ļ���
	 */
	public static void adjustHeap(int arr[],int i,int length) {
		int temp = arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����
		//��ʼ����
		//˵����
		//1.  k = i*2+1   k��i�������ӽ��
		for (int k = i*2+1; k < length; k=k*2+1) {
			if(k+1<length && arr[k]<arr[k+1]) {//˵�����ӽ���ֵС�����ӽ���ֵ
				k++;//k��ָ�����ӽ��
			}
			if(arr[k]>temp) {//����ӽ����ڸ����
				arr[i] = arr[k];//�ѽϴ��ֵ������ǰ���
				i = k;//��������iָ��k������ѭ���Ƚ�
			}else {
				break;
			}
		}
		//��forѭ�������������Ѿ�����iΪ�������������ֵ�����������(�ֲ�)
		
		arr[i] = temp;//��tempֵ���ڵ������λ��
	}
}
