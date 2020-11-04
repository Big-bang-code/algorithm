package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 6.归并排序
 * @Title MergetSort.java
 * @Description
 * @author 孟BIG
 * @date2019年9月17日
 */
public class MergetSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[arr.length];
		mergeSort(arr, 0, arr.length-1, temp);
		System.out.println("归并排序后:"+Arrays.toString(arr));
	}
	
	//合并的方法
	/**
	 * 
	 * Title:merge
	 * @param arr 待排序的数组
	 * @param left	左边有序的初始索引
	 * @param mid	中间索引
	 * @param right 右边索引
	 * @param temp  做中转的数组
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i =left;//初始化i,左边有序序列的初始索引
		int j = mid+1;//初始化j,表示右边有序序列的初始索引
		int t = 0;//指向temp数组的当前索引
		System.out.println("归并排序:"+Arrays.toString(arr));
		//一、
		//先把左右两边(有序)的数据按照规则填充到temp数组
		//直到左右两边的有序序列有一方处理完毕为止
		while(i<=mid&&j<=right) {
			//如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
			//即 将左边的当前元素,拷贝到temp数组
			//然后t、i都要后移
			if(arr[i]<=arr[j]) {
				temp[t] = arr[i];
				t += 1;
				i += 1;
			}else {//反之将右边有序序列的当前元素，填充到temp数组
				temp[t] = arr[j];
				t += 1;
				j += 1;
			}
		}
		
		//二、
		//把有剩余数据的一边的数据全部填充到temp中
		while(i<=mid) {//左边的元素还有剩余,就全部填充到temp中
			temp[t] = arr[i];
			t += 1;
			i += 1;
		}
		while(j<=right) {//左边的元素还有剩余,就全部填充到temp中
			temp[t] = arr[j];
			t += 1;
			j += 1;
		}
		
		//三、
		//将temp数组中的元素拷贝到arr
		//注意，并不是每次拷贝所有
		t = 0;
		int tempLeft = left;
		System.out.println("tempLeft"+tempLeft+",right"+right);
		while(tempLeft <= right) {//第一次合并  tempLeft = 0; right = 1;
								  //第二次合并  tempLeft = 2; right = 3;
								  //第三次合并  tempLeft = 0; right = 3;	
								  //最后一次:              0          7
			
			arr[tempLeft] = temp[t];
			t += 1;
			tempLeft += 1;					
		}
				
	}
	
	//分加合的方法
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;//中间索引
			//向左递归进行分解
			mergeSort(arr, left, mid, temp);
			//向右递归进行分解
			mergeSort(arr, mid+1, right, temp);
			
			//到合并时
			merge(arr, left, mid, right, temp);
		}
	}

}
