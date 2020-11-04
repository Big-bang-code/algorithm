package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 5.��������
 * @Title QuickSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��13��
 */  
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100,9,5,7,65,88,14,1,48,3};
		
		quickSort( arr,0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left,int right) {
		int l = left;//���±�
		int r = right;//���±�
		
		//pivot����
		int pivot = arr[(left+right)/2];
		
		int temp = 0;//��ʱ��������Ϊ����
		
		//whileѭ����Ŀ�����ñ�pivotС��ֵ���ŵ����
		//��pivot���ֵ���ŵ��ұ�
		while(l<r) {
			//��pivot�����һֱ�ң��ҵ���pivot���ڻ���ڵ�ֵ�����˳�
			while(arr[l]<pivot) {
				l +=1;
			}
			//��pivot���ұ�һֱ�ң��ҵ���pivotС�ڻ���ڵ�ֵ�����˳�
			while(arr[r]>pivot) {
				r -=1;
			}	
			//���l>=r��˵��pivot���������ߵ�ֵ���Ѿ�ȫ�������ȫ����С�ڵ���pivot��ֵ���ұ�ȫ�Ǵ��ڵ���pivot��ֵ
			if(l>=r) {
				break;
			}	
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			
			//����������ֵ���������arr[l] == pivot  ���  r--��ǰ��			
			if(arr[l]==pivot) {
				r -= 1;
			}
			//����������ֵ���������arr[r] == pivot  ���  l++������			
			if(arr[r]==pivot) {
				l += 1;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		//�жϣ����l==r��������l++,r--
		if(l==r) {
			l+=1;
			r-=1;
		}
		//����ݹ�
		if(left<r) {
			quickSort(arr, left, r);
		}
		//���ҵݹ�
		if(right>l) {
			quickSort(arr, l,right);
		}
	}
	
}
