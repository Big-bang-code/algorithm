package com.atguigu1.sort;

import java.util.Arrays;

/**
 * 	7.基数排序(桶排序)
 * @Title RadixSort.java
 * @Description
 * @author 孟BIG
 * @date2019年9月19日
 */
public class RadixSort {
	public static void main(String[] args) {
		int arr[] = {53, 3, 542, 748, 14, 214};
		radixSortTest(arr);
		
		int arr1[] = {53, 3, 542, 748, 14, 214};
		radixSort(arr1);
	}
	
	//基数排序方法(第一轮)
	public static void radixSortTest(int[] arr) {
		
		//第一轮(针对元素的个位进行处理)
		
		//定义一个二维数组表示10个桶，每个桶就是一个一维数组
		//1.二维数组包含10个一维数组
		//2.每个一维数组的长度大小为arr.length
		//很明确：基数排序是使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];
		
		//为了记录每个桶中，实际放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据的个数
		//bucketElementCounts[0]  记录的就是bucket[0] 每次放入的数据的个数
		int[] bucketElementCounts = new int[10];
		 
		//第一轮(针对每个元素的个位进行排序处理)
		for (int j = 0; j < arr.length; j++) {
			//取出每个元素的个位的值
			int digiOfElement = arr[j] % 10;
		
			//放入到对应的桶中
			//[bucketElementCounts[digiOfElement] 这个东西是为了让桶中的数据依次向下放，
			//先是bucket[digiOfElement]对应的是第几个桶，[bucketElementCounts[digiOfElement]先是第0个数字 
			bucket[digiOfElement][bucketElementCounts[digiOfElement]] = arr[j];
			
			//bucketElementCounts[digiOfElement]++  增加后，有后来的数字就能够在桶中放在下一个位置 
			bucketElementCounts[digiOfElement]++;
		}
	
		//要把桶的顺序依次放入到数组中
		int index = 0;
		//遍历每一个桶，
		for (int j = 0; j < bucketElementCounts.length; j++) {
			//如果桶中有数据，我们才放入到原数组中
			if(bucketElementCounts[j] != 0) {//该桶中有数据
				//循环该桶,即第k个桶(即第k个一维数组),放入
				for(int l=0;l<bucketElementCounts[j];l++) {
					//取出元素放入到arr中
					arr[index++] = bucket[j][l];				
				}			
			}
			//第一轮处理后，需要将每个bucketElementCounts置0，  bucketElementCounts[l] = 0;
			bucketElementCounts[j] = 0;
		}
		
		System.out.println("第一轮,对个位的排序处理:"+Arrays.toString(arr));		
	}
	//基数排序方法(总结)
	public static void radixSort(int[] arr) {
		//1.得到数组中最大数的位数
		int max = arr[0];//假设第一个数就是最大
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//2.得到最大数的位数
		int maxLength = (max+"").length();
		
		//定义一个二维数组表示10个桶，每个桶就是一个一维数组
		//1.二维数组包含10个一维数组
		//2.每个一维数组的长度大小为arr.length
		//很明确：基数排序是使用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];
				
		//为了记录每个桶中，实际放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据的个数
		//bucketElementCounts[0]  记录的就是bucket[0] 每次放入的数据的个数
		int[] bucketElementCounts = new int[10];
		
		
		//3.使用循环将代码处理
		for (int i = 0 , n = 1; i < maxLength; i++,n *=10) {
			//针对每个元素的对应位进行排序处理
			for (int j = 0; j < arr.length; j++) {
				//取出每个元素的对应的位数的值
				int digiOfElement = arr[j] / n % 10;
			
				//放入到对应的桶中
				//[bucketElementCounts[digiOfElement] 这个东西是为了让桶中的数据依次向下放，
				//先是bucket[digiOfElement]对应的是第几个桶，[bucketElementCounts[digiOfElement]先是第0个数字 
				bucket[digiOfElement][bucketElementCounts[digiOfElement]] = arr[j];
				
				//bucketElementCounts[digiOfElement]++  增加后，有后来的数字就能够在桶中放在下一个位置 
				bucketElementCounts[digiOfElement]++;
			}
		
			//要把桶的顺序依次放入到数组中
			int index = 0;
			//遍历每一个桶，
			for (int j = 0; j < bucketElementCounts.length; j++) {
				//如果桶中有数据，我们才放入到原数组中
				if(bucketElementCounts[j] != 0) {//该桶中有数据
					//循环该桶,即第k个桶(即第k个一维数组),放入
					for(int l=0;l<bucketElementCounts[j];l++) {
						//取出元素放入到arr中
						arr[index++] = bucket[j][l];				
					}			
				}
				//第i+1轮处理后，需要将每个bucketElementCounts置0，  bucketElementCounts[l] = 0;
				bucketElementCounts[j] = 0;
			}
			
			System.out.println("第"+(1+i)+"轮,对"+n+"位的排序处理:"+Arrays.toString(arr));	
		}
	}
	
}
