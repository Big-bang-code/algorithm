package com.atguigu1.search;

import java.util.ArrayList;

/**
 * 	2.�۰���ҡ����ֲ���
 * 	ʹ�ö��ֲ��ҵ�ǰ���Ǹ������������
 * 
 * 	�Զ��ֽ���������������ظ������֣�����ȫ���ҵ�
 * @Title BinarySerach.java
 * @Description
 * @author ��BIG
 * @date2019��9��23��
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {1,8,10,89,1000,1234};
		
		int resIndex = binarySearch(arr, 0, arr.length-1, 1);
		System.out.println("resIndex="+resIndex);
		
	}
	
	//���ֲ���
	/**
	 * 
	 * Title:binarySearch
	 * @param arr	����
	 * @param left 	��ߵ�����
	 * @param right	�ұߵ�����
	 * @param findVal  ����ҵ��ͷ����±꣬���û���ҵ����ͷ���-1
	 * @return
	 */
	public static int binarySearch(int arr[],int left,int right,int findVal) {
		
		//��left>right��˵���ݹ��������飬����û���ҵ�
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		int midVal = arr[mid];
		
		if(findVal>midVal) {
			//��Ҫ���ҵݹ�
			return binarySearch(arr, mid+1, right, findVal);
		}else if(findVal<midVal) {
			//��Ҫ����ݹ�
			return binarySearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
		
	}
	
	/**
	 * 	�����Ķ��ֲ���:�ҵ�ȫ���ظ���ֵ
	 * 	1.�ҵ�mid���ֵ��Ҫ���Ϸ��أ�
	 * 	2.��mid������ֵ�����ɨ�裬������������ҵ�ֵ����һ��������
	 * 	3.��mid������ֵ���ұ�ɨ�裬������������ҵ�ֵ����һ��������
	 * 	4.�����Ϸ���
	 * 
	 * Title:binarySearch1
	 * @param arr
	 * @param left
	 * @param right
	 * @param findVal
	 * @return
	 */
	public static ArrayList<Integer> binarySearch1(int arr[],int left,int right,int findVal) {
			
		//��left>right��˵���ݹ��������飬����û���ҵ�
		if(left>right) {
			return new ArrayList<Integer>();
		}
		int mid = (left+right)/2;
		int midVal = arr[mid];
		
		if(findVal>midVal) {
			//��Ҫ���ҵݹ�
			return binarySearch1(arr, mid+1, right, findVal);
		}else if(findVal<midVal) {
			//��Ҫ����ݹ�
			return binarySearch1(arr, left, mid-1, findVal);
		}else {
			
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			
			//��mid����ֵ�����ɨ�裬����������1000��Ԫ�ص��±꣬���뵽����ArrayList��
			int temp = mid - 1;
			while(true) {
				if(temp<0||arr[temp]!=findVal) {//�˳�
					break;
				}
				//�������temp���뵽������
				resIndexList.add(temp);
				temp -= 1;//temp����
			}
			resIndexList.add(mid);
			
			//��mid����ֵ���ұ�ɨ�裬����������1000��Ԫ�ص��±꣬���뵽����ArrayList��
			temp = mid + 1;
			while(true) {
				if(temp<0||arr[temp]!=findVal) {//�˳�
					break;
				}
				//�������temp���뵽������
				resIndexList.add(temp);
				temp += 1;//temp���� 
			}
			return resIndexList;
		}
		
	}
	
}
