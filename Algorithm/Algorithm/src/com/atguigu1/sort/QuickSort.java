package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 5.快速排序
 * @Title QuickSort.java
 * @Description
 * @author 孟BIG
 * @date2019年9月13日
 */  
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {100,9,5,7,65,88,14,1,48,3};
		
		quickSort( arr,0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left,int right) {
		int l = left;//左下标
		int r = right;//右下标
		
		//pivot中轴
		int pivot = arr[(left+right)/2];
		
		int temp = 0;//临时变量，作为交换
		
		//while循环的目的是让比pivot小的值，放到左边
		//比pivot大的值，放到右边
		while(l<r) {
			//在pivot的左边一直找，找到比pivot大于或等于的值，才退出
			while(arr[l]<pivot) {
				l +=1;
			}
			//在pivot的右边一直找，找到比pivot小于或等于的值，才退出
			while(arr[r]>pivot) {
				r -=1;
			}	
			//如果l>=r，说明pivot的左右两边的值，已经全按照左边全部是小于等于pivot的值，右边全是大于等于pivot的值
			if(l>=r) {
				break;
			}	
			
			temp = arr[l];
			arr[l] = arr[r];
			arr[r] = temp;
			
			
			//如果交换完的值，发现这个arr[l] == pivot  相等  r--，前移			
			if(arr[l]==pivot) {
				r -= 1;
			}
			//如果交换完的值，发现这个arr[r] == pivot  相等  l++，后移			
			if(arr[r]==pivot) {
				l += 1;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		//判断：如果l==r，必须让l++,r--
		if(l==r) {
			l+=1;
			r-=1;
		}
		//向左递归
		if(left<r) {
			quickSort(arr, left, r);
		}
		//向右递归
		if(right>l) {
			quickSort(arr, l,right);
		}
	}
	
}
