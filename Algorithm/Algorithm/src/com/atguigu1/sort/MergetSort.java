package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 6.�鲢����
 * @Title MergetSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��17��
 */
public class MergetSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
		System.out.println("�鲢�����:"+Arrays.toString(arr));
	}
	
	//�ϲ��ķ���
	/**
	 * 
	 * Title:merge
	 * @param arr �����������
	 * @param left	�������ĳ�ʼ����
	 * @param mid	�м�����
	 * @param right �ұ�����
	 * @param temp  ����ת������
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i =left;//��ʼ��i,����������еĳ�ʼ����
		int j = mid+1;//��ʼ��j,��ʾ�ұ��������еĳ�ʼ����
		int t = 0;//ָ��temp����ĵ�ǰ����
		System.out.println("�鲢����:"+Arrays.toString(arr));
		//һ��
		//�Ȱ���������(����)�����ݰ��չ�����䵽temp����
		//ֱ���������ߵ�����������һ���������Ϊֹ
		while(i<=mid&&j<=right) {
			//�����ߵ��������еĵ�ǰԪ�أ�С�ڵ����ұ��������еĵ�ǰԪ��
			//�� ����ߵĵ�ǰԪ��,������temp����
			//Ȼ��t��i��Ҫ����
			if(arr[i]<=arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {//��֮���ұ��������еĵ�ǰԪ�أ���䵽temp����
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		//����
		//����ʣ�����ݵ�һ�ߵ�����ȫ����䵽temp��
		while(i<=mid) {//��ߵ�Ԫ�ػ���ʣ��,��ȫ����䵽temp��
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while(j<=right) {//��ߵ�Ԫ�ػ���ʣ��,��ȫ����䵽temp��
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		
		//����
		//��temp�����е�Ԫ�ؿ�����arr
		//ע�⣬������ÿ�ο�������
		t = 0;
		int tempLeft = left;
		System.out.println("tempLeft"+tempLeft+",right"+right);
		while(tempLeft <= right) {//��һ�κϲ�  tempLeft = 0; right = 1;
								  //�ڶ��κϲ�  tempLeft = 2; right = 3;
								  //�����κϲ�  tempLeft = 0; right = 3;	
								  //���һ��:              0          7
			
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;					
		}
				
	}
	
	//�ּӺϵķ���
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;//�м�����
			//����ݹ���зֽ�
			mergeSort(arr, left, mid, temp);
			//���ҵݹ���зֽ�
			mergeSort(arr, mid+1, right, temp);
			
			//���ϲ�ʱ
			merge(arr, left, mid, right, temp);
		}
	}

}
