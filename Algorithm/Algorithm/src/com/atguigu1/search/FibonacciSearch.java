package com.atguigu1.search;

import java.util.Arrays;

/**
 * 	쳲���������
 * @Title FibonacciSearch.java
 * @Description
 * @author ��BIG
 * @date2019��9��27��
 */
public class FibonacciSearch {
	public static int maxSize = 20;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,8,10,89,1000,1234};
		System.out.println(fibSearch(arr, 1000));
	}
	
	//��Ϊ�������ǵ�mid=low+F(k-1)-1,��Ҫʹ�õ�쳲��������С����������Ҫ�Ȼ�ȡ��һ��쳲���������
	//�÷ǵݹ�ķ�ʽ�õ�һ��쳲���������
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		return f;		
	}
	
	//��д쳲����������㷨
	//ʹ�÷ǵݹ�ķ�ʽ��д�㷨
	/**
	 * 
	 * Title:fibSearch
	 * @param a	����
	 * @param key	��Ҫ���ҵ�ֵ
	 * @return	���ض�Ӧ�±�,��û�У�����-1
	 */
	public static int fibSearch(int[] a,int key) {
		int low = 0;
		int high = a.length - 1;//�������һλ
		int k = 0;//��ʾ쳲������ָ���ֵ���±�
		int mid = 0;//���midֵ
		int f[] = fib();//��ȡ��쳲���������
		
		//��ȡ��쳲������ָ���ֵ���±�
		while(high>f[k]-1) {
			k++;
		}
		//��Ϊf[k]��ֵ���ܴ���a�ĳ��ȣ����������Ҫʹ��arrays�࣬����һ���µ����飬��ָ��a[]
		//����Ĳ��ֻ�ʹ��0���
		int[] temp = Arrays.copyOf(a, f[k]);
		
		//ʵ������Ҫʹ��a�����������������
		//����
		//temp = {1,8,10,89,1000,1234,0,0}; ==> temp = {1,8,10,89,1000,1234,1234,1234};
		for(int i = high+1;i<temp.length;i++) {
			temp[i] = a[high];
		}
		
		//ʹ��whileѭ�������ҵ���key
		while(low <= high) {//ֻҪ����������㣬�Ϳ����ҵ�key
			mid = low+f[k-1]-1;
			if (key<temp[mid]) {//����Ӧ�ü����������ǰ�����(���)
				high = mid -1;
				/*
				 * 	Ϊʲô��k--
				 * 	1.ȫ��Ԫ�� = ǰ���Ԫ��+�����Ԫ��
				 * 	2.f[k] = f[k-1] + f[k-2];
				 * 	��Ϊǰ����f[k-1]��Ԫ�أ����Կ��Լ������f[k-1] = f[k-2] + f[k-3];
				 * 	����f[k-1]��ǰ��������� k--
				 * 	���´�ѭ�� mid = f[k-1 - 1] - 1;  
				 */
				k--;
			}else if(key>temp[mid]){
				high = mid +1;
				/*
				 * 	Ϊʲô��k -= 2;
				 * 	1.ȫ��Ԫ�� = ǰ���Ԫ��+�����Ԫ��
				 * 	2.f[k] = f[k-1] + f[k-2];
				 * 	��Ϊ������f[k-2]��Ԫ�أ����Կ��Լ������f[k-1] = f[k-3] + f[k-4];
				 * 	����f[k-2]��ǰ��������� k -=2;
				 * 	���´�ѭ�� mid = f[k - 1 - 2] - 1;
				 */
				k -= 2;
			}else {//�ҵ���
				//��Ҫȷ�����ص����ĸ��±�
				if(mid<=high) {
					return mid;
				}else {
					return high;
				}
			}
		}
		return -1;
	}
	
}
