package com.atguigu1.search;
/**
 * 	1.˳�����
 * @Title SeqSearch.java
 * @Description
 * @author ��BIG
 * @date2019��9��20��
 */
public class SeqSearch {
	public static void main(String[] args) {
		int arr[] = {1,9,-1,11,34,89};
		seqSearch(arr, 89);
	}
	
	/**
	 * ����ʵ�ֵ����Բ������ҵ�һ������������ֵ�ͷ���
	 * Title:seqSearch
	 * @param arr
	 * @param value
	 * @return
	 */
	public static int seqSearch(int[] arr,int value) {
		/*
		 * ���Բ�������һ�ȶԣ���������ͬ��ֵʱ�ͷ����±�
		 */
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==value) {
				System.out.println("�������±�Ϊ:"+i+",����"+(i+1)+"����");
				return i;
			}
		}
		return -1;
	}
	
}
