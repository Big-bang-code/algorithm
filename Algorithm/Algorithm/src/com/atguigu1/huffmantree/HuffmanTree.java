package com.atguigu1.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	赫夫曼树
 * @Title HuffmanTree.java
 * @Description
 * @author 孟BIG
 * @date2019年11月13日
 */
public class HuffmanTree {
	public static void main(String[] args) {
		int arr[] = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		
		preOrder(root);
		
	}
	//编写一个前序遍历的方法
	public static void preOrder(Node root) {
		if(root !=null) {
			root.preOrder();
		}else {
			System.out.println("树是空树，不能遍历");
		}
	}
	/**
	 * 	
	 * Title:createHuffmanTree
	 * @param arr  需要创建的赫夫曼树的数组
	 * @return	创建好后的赫夫曼的root结点
	 */
	//创建赫夫曼树
	public static Node createHuffmanTree(int arr[]) {
		//数组本身不支持排序
		//1.为了操作方便，先遍历arr数组
		//2.将arr的每个元素构建成一个Node
		//3.将Node放入到ArrayList中
		List<Node> nodes = new ArrayList<Node>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		
		//我们处理的过程是一个循环的过程
		
		while(nodes.size()>1) {
			//排序：从小到大
			Collections.sort(nodes);
			System.out.println("nodes="+nodes);
			
			//取出根节点权值最小得两棵二叉树
			//1.取出权值最小得结点(二叉树)
			Node leftNode = nodes.get(0);
			//2.取出权值第二小得结点(二叉树)
			Node rightNode = nodes.get(1);
			//3.构建一棵新的二叉树
			Node parent = new Node(leftNode.value+rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			//4.从ArrayList中删除处理过的二叉树
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//5.将parent加入到Nodes中
			nodes.add(parent);
		}
		//返回赫夫曼树的root结点
		return nodes.get(0);

		//例：
//		//排序：从小到大
//		Collections.sort(nodes);
//		System.out.println("nodes="+nodes);
//		
//		//取出根节点权值最小得两棵二叉树
//		//1.取出权值最小得结点(二叉树)
//		Node leftNode = nodes.get(0);
//		//2.取出权值第二小得结点(二叉树)
//		Node rightNode = nodes.get(1);
//		//3.构建一棵新的二叉树
//		Node parent = new Node(leftNode.value+rightNode.value);
//		parent.left = leftNode;
//		parent.right = rightNode;
//		//4.从ArrayList中删除处理过的二叉树
//		nodes.remove(leftNode);
//		nodes.remove(rightNode);
//		//5.将parent加入到Nodes中
//		nodes.add(parent);
//		
//		System.out.println("第一次处理后"+nodes);
	}
}


//创建节点类
//为了让Node对象持续排序Collections集合排序
class Node implements Comparable<Node>{
	int value;//结点权值
	Node left;//指向左子节点
	Node right;//指向右子节点
	
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if(this.left !=null) {
			this.left.preOrder();
		}
		if(this.right !=null) {
			this.right.preOrder();
		}
	}
	
	public Node(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		//表示从小到大排序
		return this.value - o.value;
	}
	
	
}