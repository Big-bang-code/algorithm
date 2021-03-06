package com.atguigu1.tree;
/**
 * 	顺序存储二叉树
 * @Title ArrBinaryTreeDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年11月2日
 */
public class ArrBinaryTreeDemo {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		
		//创建一个tree
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
		arrBinaryTree.preOrder();
		
		
	}
}

//编写一个ArrBinaryTree，实现顺序存储二叉树遍历
class ArrBinaryTree{
	private int[] arr;//存储数据节点的数组
	
	public ArrBinaryTree(int[] arr) {
		this.arr = arr;
	}
	//重载preOrder这个方法
	public void preOrder() {
		this.preOrder(0);
	}
	
	//编写一个方法，完成顺序存储二叉树的前序遍历
	/**
	 * 	表示数组的下标
	 * Title:preOrder
	 * @param index
	 */
	public void preOrder(int index) {
		//如果数组为空，或者arr.length = 0
		if(arr == null || arr.length == 0) {
			System.out.println("数组为空，不能按照二叉树的前序遍历");
		}	
		//输出当前的元素
		System.out.println(arr[index]);
		
		//向左递归遍历
		if(index*2+1<arr.length) {
			preOrder(2*index +1);
		}
		//向右递归
		if(index*2+2<arr.length) {
			preOrder(2*index +2);
		}
	}
	
	
}