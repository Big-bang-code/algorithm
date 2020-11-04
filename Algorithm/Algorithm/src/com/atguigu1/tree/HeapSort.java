package com.atguigu1.tree;

import java.util.Arrays;

public class HeapSort {
	
	public static void main(String[] args) {
		int arr[] = {4,6,8,5,9};
		heapSort(arr);
	}
	
	//编写一个堆排序的方法
	public static void heapSort(int arr[]) {
		System.out.println("堆排序的方法");
		int temp = 0;
//		//分布完成
//		adjustHeap(arr, 1, arr.length);
//		System.out.println("第一次"+Arrays.toString(arr));
//		
//		adjustHeap(arr, 0, arr.length);
//		System.out.println("第二次"+Arrays.toString(arr));
		
		//完成最终代码
		//1.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
		for(int i=arr.length /2 - 1;i>=0;i--) {
			adjustHeap(arr, i, arr.length);
		}
		
		for(int j = arr.length -1;j>0;j--) {
			//交换
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr, 0, j);
		}
		System.out.println("数组："+Arrays.toString(arr));
	}
	
	//将一个数组(二叉树)调整成一个大顶堆，
	/**
	 * 功能:完成将以i的非叶子节点的树调整成大顶堆
	 * Title:adjustHeap
	 * @param arr	待调整的数组
	 * @param i		表示非叶子节点的在数组中的索引
	 * @param length	表示对多少个元素进行调整，length是在逐渐的减少
	 */
	public static void adjustHeap(int arr[],int i,int length) {
		int temp = arr[i];//先取出当前元素的值，保存在临时变量
		//开始调整
		//说明：
		//1.  k = i*2+1   k是i结点的左子结点
		for (int k = i*2+1; k < length; k=k*2+1) {
			if(k+1<length && arr[k]<arr[k+1]) {//说明左子结点的值小于右子结点的值
				k++;//k就指向右子结点
			}
			if(arr[k]>temp) {//如果子结点大于父结点
				arr[i] = arr[k];//把较大的值赋给当前结点
				i = k;//！！！！i指向k，继续循环比较
			}else {
				break;
			}
		}
		//当for循环结束后，我们已经将以i为父结点的树的最大值，放在了最顶端(局部)
		
		arr[i] = temp;//将temp值放在调整后的位置
	}
}
