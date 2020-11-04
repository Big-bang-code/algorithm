package com.atguigu1.binarysorttree;

/**
 * ����������
 * @Title BinarySortTreeDemo.java
 * @Description
 * @author ��BIG
 * @date2020��2��13��
 */
public class BinarySortTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {7,3,10,12,5,1,9};
		BinarySortTree binarySortTree = new BinarySortTree();
		//ѭ������ӽ�㵽����������
		for (int i = 0; i < arr.length; i++) {
			binarySortTree.add(new Node(arr[i]));
		}
		
		//�����������������
		System.out.println("�������������������");
		binarySortTree.infixOrder();
		
	}

}

//��������������
class BinarySortTree{
	private Node root;
	//��ӽ��ķ���
	public void add(Node node) {
		if(root == null) {
			root = node;//���rootΪ�գ�ֱ����rootָ��node
		}else {
			root.add(node);
		}
	}
	//�������
	public void infixOrder() {
		if(root != null) {
			root.infixOrder();
		}else {
			System.out.println("����������Ϊ��");
		}
	}
}




//�������
class Node{
	int value;
	Node left;
	Node right;
	public Node(int value) {		
		this.value = value;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	//��ӽڵ�ķ���
	//�ݹ����ʽ��ӽ�㣬ע����Ҫ���������������Ҫ��
	public void add(Node node) {
		if(node == null) {
			return;
		}
		//�жϴ���Ľ���ֵ���͵�ǰ�����ĸ��ڵ��ֵ�Ĺ�ϵ
		if(node.value<this.value) {
			//�����ǰ�������ӽ��Ϊ��
			if(this.left==null) {
				this.left = node;
			}else {
				//�ݹ�������������
				this.left.add(node);
			}
		}else {//��ӵĽ���ֵ���ڵ�ǰ����ֵ
			//�����ǰ�������ӽ��Ϊ��
			if(this.right==null) {
				this.right = node;
			}else {
				//�ݹ�������������
				this.right.add(node);
			}
		}	
	}
	
	//�������
	public void infixOrder(){
		if(this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if(this.right != null) {
			this.right.infixOrder();
		}
	}
	
}





