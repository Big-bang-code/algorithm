package com.atguigu1.search;

import java.util.ArrayList;

/**
 * 	2.折半查找、二分查找
 * 	使用二分查找的前提是该数组是有序的
 * 
 * 	对二分进行升级，如果有重复的数字，将其全部找到
 * @Title BinarySerach.java
 * @Description
 * @author 孟BIG
 * @date2019年9月23日
 */
public class BinarySearch {
	
	public static void main(String[] args) {
		int arr[] = {1,8,10,89,1000,1234};
		
		int resIndex = binarySearch(arr, 0, arr.length-1, 1);
		System.out.println("resIndex="+resIndex);
		
	}
	
	//二分查找
	/**
	 * 
	 * Title:binarySearch
	 * @param arr	数组
	 * @param left 	左边的索引
	 * @param right	右边的索引
	 * @param findVal  如果找到就返回下标，如果没有找到，就返回-1
	 * @return
	 */
	public static int binarySearch(int arr[],int left,int right,int findVal) {
		
		//当left>right，说明递归整个数组，但是没有找到
		if(left>right) {
			return -1;
		}
		int mid = (left+right)/2;
		int midVal = arr[mid];
		
		if(findVal>midVal) {
			//需要向右递归
			return binarySearch(arr, mid+1, right, findVal);
		}else if(findVal<midVal) {
			//需要向左递归
			return binarySearch(arr, left, mid-1, findVal);
		}else {
			return mid;
		}
		
	}
	
	/**
	 * 	升级的二分查找:找到全部重复的值
	 * 	1.找到mid大的值不要马上返回，
	 * 	2.向mid的索引值的左边扫描，将所有满足查找的值加入一个集合中
	 * 	3.向mid的索引值的右边扫描，将所有满足查找的值加入一个集合中
	 * 	4.将集合返回
	 * 
	 * Title:binarySearch1
	 * @param arr
	 * @param left
	 * @param right
	 * @param findVal
	 * @return
	 */
	public static ArrayList<Integer> binarySearch1(int arr[],int left,int right,int findVal) {
			
		//当left>right，说明递归整个数组，但是没有找到
		if(left>right) {
			return new ArrayList<Integer>();
		}
		int mid = (left+right)/2;
		int midVal = arr[mid];
		
		if(findVal>midVal) {
			//需要向右递归
			return binarySearch1(arr, mid+1, right, findVal);
		}else if(findVal<midVal) {
			//需要向左递归
			return binarySearch1(arr, left, mid-1, findVal);
		}else {
			
			ArrayList<Integer> resIndexList = new ArrayList<Integer>();
			
			//向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList中
			int temp = mid - 1;
			while(true) {
				if(temp<0||arr[temp]!=findVal) {//退出
					break;
				}
				//否则将这个temp放入到集合中
				resIndexList.add(temp);
				temp -= 1;//temp左移
			}
			resIndexList.add(mid);
			
			//向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList中
			temp = mid + 1;
			while(true) {
				if(temp<0||arr[temp]!=findVal) {//退出
					break;
				}
				//否则将这个temp放入到集合中
				resIndexList.add(temp);
				temp += 1;//temp右移 
			}
			return resIndexList;
		}
		
	}
	
}
