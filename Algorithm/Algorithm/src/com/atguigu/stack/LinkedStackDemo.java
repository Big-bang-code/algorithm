package com.atguigu.stack;



/**
 * 	����ģ��ջ
 * @Title LinkedStackDemo.java
 * @Description
 * @author ��BIG
 * @date2019��8��29��
 */
public class LinkedStackDemo {
	public static void main(String[] args) {
		LinkList list = new LinkList();
		Node node1 = new Node(5);
		Node node2 = new Node(66);
		Node node3 = new Node(345);
		Node node4 = new Node(55);
		
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
	}
}

class LinkList{
	private Node first = new Node(0);//ͷ�ڵ�
	
	// ����ͷ�ڵ�
		public Node getHead() {
			return first;
		}
	//��ӽڵ�
	public void add(Node node) {
		Node temp = first;
		while(true) {
			if(temp.nextNode==null) {
				break;
			}
			temp = temp.nextNode;
		}
		temp.nextNode = node;
	}
	
	
	//��������
	
}




class Node{
	int num;
	Node nextNode;
	
	public Node(int num) {
		
		this.num = num;
	}
}