package com.atguigu1.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 	�շ�����
 * @Title HuffmanTree.java
 * @Description
 * @author ��BIG
 * @date2019��11��13��
 */
public class HuffmanTree {
	public static void main(String[] args) {
		int arr[] = {13,7,8,3,29,6,1};
		Node root = createHuffmanTree(arr);
		
		preOrder(root);
		
	}
	//��дһ��ǰ������ķ���
	public static void preOrder(Node root) {
		if(root !=null) {
			root.preOrder();
		}else {
			System.out.println("���ǿ��������ܱ���");
		}
	}
	/**
	 * 	
	 * Title:createHuffmanTree
	 * @param arr  ��Ҫ�����ĺշ�����������
	 * @return	�����ú�ĺշ�����root���
	 */
	//�����շ�����
	public static Node createHuffmanTree(int arr[]) {
		//���鱾��֧������
		//1.Ϊ�˲������㣬�ȱ���arr����
		//2.��arr��ÿ��Ԫ�ع�����һ��Node
		//3.��Node���뵽ArrayList��
		List<Node> nodes = new ArrayList<Node>();
		for(int value:arr) {
			nodes.add(new Node(value));
		}
		
		//���Ǵ���Ĺ�����һ��ѭ���Ĺ���
		
		while(nodes.size()>1) {
			//���򣺴�С����
			Collections.sort(nodes);
			System.out.println("nodes="+nodes);
			
			//ȡ�����ڵ�Ȩֵ��С�����ö�����
			//1.ȡ��Ȩֵ��С�ý��(������)
			Node leftNode = nodes.get(0);
			//2.ȡ��Ȩֵ�ڶ�С�ý��(������)
			Node rightNode = nodes.get(1);
			//3.����һ���µĶ�����
			Node parent = new Node(leftNode.value+rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			//4.��ArrayList��ɾ��������Ķ�����
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//5.��parent���뵽Nodes��
			nodes.add(parent);
		}
		//���غշ�������root���
		return nodes.get(0);

		//����
//		//���򣺴�С����
//		Collections.sort(nodes);
//		System.out.println("nodes="+nodes);
//		
//		//ȡ�����ڵ�Ȩֵ��С�����ö�����
//		//1.ȡ��Ȩֵ��С�ý��(������)
//		Node leftNode = nodes.get(0);
//		//2.ȡ��Ȩֵ�ڶ�С�ý��(������)
//		Node rightNode = nodes.get(1);
//		//3.����һ���µĶ�����
//		Node parent = new Node(leftNode.value+rightNode.value);
//		parent.left = leftNode;
//		parent.right = rightNode;
//		//4.��ArrayList��ɾ��������Ķ�����
//		nodes.remove(leftNode);
//		nodes.remove(rightNode);
//		//5.��parent���뵽Nodes��
//		nodes.add(parent);
//		
//		System.out.println("��һ�δ����"+nodes);
	}
}


//�����ڵ���
//Ϊ����Node�����������Collections��������
class Node implements Comparable<Node>{
	int value;//���Ȩֵ
	Node left;//ָ�����ӽڵ�
	Node right;//ָ�����ӽڵ�
	
	//ǰ�����
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
		//��ʾ��С��������
		return this.value - o.value;
	}
	
	
}