package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 	7.��������(Ͱ����)
 * @Title RadixSort.java
 * @Description
 * @author ��BIG
 * @date2019��9��19��
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {53, 3, 542, 748, 14, 214};
		radixSortTest(arr);
		
		int arr1[] = {53, 3, 542, 748, 14, 214};
		radixSort(arr1);
	}
	
	//�������򷽷�(��һ��)
	public static void radixSortTest(int[] arr) {
		
		//��һ��(���Ԫ�صĸ�λ���д���)
		
		//����һ����ά�����ʾ10��Ͱ��ÿ��Ͱ����һ��һά����
		//1.��ά�������10��һά����
		//2.ÿ��һά����ĳ��ȴ�СΪarr.length
		//����ȷ������������ʹ�ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];
		
		//Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʷ��˶��ٸ����ݣ����Ƕ���һ��һά��������¼����Ͱÿ�η�������ݵĸ���
		//bucketElementCounts[0]  ��¼�ľ���bucket[0] ÿ�η�������ݵĸ���
		int[] bucketElementCounts = new int[10];
		 
		//��һ��(���ÿ��Ԫ�صĸ�λ����������)
		for (int j = 0; j < arr.length; j++) {
			//ȡ��ÿ��Ԫ�صĸ�λ��ֵ
			int digiOfElement = arr[j] % 10;
		
			//���뵽��Ӧ��Ͱ��
			//[bucketElementCounts[digiOfElement] ���������Ϊ����Ͱ�е������������·ţ�
			//����bucket[digiOfElement]��Ӧ���ǵڼ���Ͱ��[bucketElementCounts[digiOfElement]���ǵ�0������ 
			bucket[digiOfElement][bucketElementCounts[digiOfElement]] = arr[j];
			
			//bucketElementCounts[digiOfElement]++  ���Ӻ��к��������־��ܹ���Ͱ�з�����һ��λ�� 
			bucketElementCounts[digiOfElement]++;
		}
	
		//Ҫ��Ͱ��˳�����η��뵽������
		int index = 0;
		//����ÿһ��Ͱ��
		for (int j = 0; j < bucketElementCounts.length; j++) {
			//���Ͱ�������ݣ����ǲŷ��뵽ԭ������
			if(bucketElementCounts[j] != 0) {//��Ͱ��������
				//ѭ����Ͱ,����k��Ͱ(����k��һά����),����
				for(int l=0;l<bucketElementCounts[j];l++) {
					//ȡ��Ԫ�ط��뵽arr��
					arr[index++] = bucket[j][l];				
				}			
			}
			//��һ�ִ������Ҫ��ÿ��bucketElementCounts��0��  bucketElementCounts[l] = 0;
			bucketElementCounts[j] = 0;
		}
		
		System.out.println("��һ��,�Ը�λ��������:"+Arrays.toString(arr));		
	}
	//�������򷽷�(�ܽ�)
	public static void radixSort(int[] arr) {
		//1.�õ��������������λ��
		int max = arr[0];//�����һ�����������
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//2.�õ��������λ��
		int maxLength = (max+"").length();
		
		//����һ����ά�����ʾ10��Ͱ��ÿ��Ͱ����һ��һά����
		//1.��ά�������10��һά����
		//2.ÿ��һά����ĳ��ȴ�СΪarr.length
		//����ȷ������������ʹ�ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];
				
		//Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʷ��˶��ٸ����ݣ����Ƕ���һ��һά��������¼����Ͱÿ�η�������ݵĸ���
		//bucketElementCounts[0]  ��¼�ľ���bucket[0] ÿ�η�������ݵĸ���
		int[] bucketElementCounts = new int[10];
		
		
		//3.ʹ��ѭ�������봦��
		for (int i = 0 , n = 1; i < maxLength; i++,n *=10) {
			//���ÿ��Ԫ�صĶ�Ӧλ����������
			for (int j = 0; j < arr.length; j++) {
				//ȡ��ÿ��Ԫ�صĶ�Ӧ��λ����ֵ
				int digiOfElement = arr[j] / n % 10;
			
				//���뵽��Ӧ��Ͱ��
				//[bucketElementCounts[digiOfElement] ���������Ϊ����Ͱ�е������������·ţ�
				//����bucket[digiOfElement]��Ӧ���ǵڼ���Ͱ��[bucketElementCounts[digiOfElement]���ǵ�0������ 
				bucket[digiOfElement][bucketElementCounts[digiOfElement]] = arr[j];
				
				//bucketElementCounts[digiOfElement]++  ���Ӻ��к��������־��ܹ���Ͱ�з�����һ��λ�� 
				bucketElementCounts[digiOfElement]++;
			}
		
			//Ҫ��Ͱ��˳�����η��뵽������
			int index = 0;
			//����ÿһ��Ͱ��
			for (int j = 0; j < bucketElementCounts.length; j++) {
				//���Ͱ�������ݣ����ǲŷ��뵽ԭ������
				if(bucketElementCounts[j] != 0) {//��Ͱ��������
					//ѭ����Ͱ,����k��Ͱ(����k��һά����),����
					for(int l=0;l<bucketElementCounts[j];l++) {
						//ȡ��Ԫ�ط��뵽arr��
						arr[index++] = bucket[j][l];				
					}			
				}
				//��i+1�ִ������Ҫ��ÿ��bucketElementCounts��0��  bucketElementCounts[l] = 0;
				bucketElementCounts[j] = 0;
			}
			
			System.out.println("��"+(1+i)+"��,��"+n+"λ��������:"+Arrays.toString(arr));	
		}
	}
	
}
