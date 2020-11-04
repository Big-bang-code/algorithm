package com.atguigu1.tree;

/**
 * ������������
 * 
 * @Title ThreadeBinaryTree1Demo.java
 * @Description
 * @author ��BIG
 * @date2019��11��4��
 */
public class ThreadeBinaryTreeDemo {

	public static void main(String[] args) {
		//������������������
		HeroNode1 node1 = new HeroNode1(1, "a");
		HeroNode1 node2 =new HeroNode1(3, "b");
		HeroNode1 node3 =new HeroNode1(6, "c");
		HeroNode1 node4 =new HeroNode1(8, "d");
		HeroNode1 node5 =new HeroNode1(10, "e");
		HeroNode1 node6 =new HeroNode1(14, "f");
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		BinaryTree1 brBinaryTree1 = new BinaryTree1();
		brBinaryTree1.setRoot(node1);
		brBinaryTree1.threadedNodes(node1);
		
		HeroNode1 leftNode1 = node5.getLeft();
		System.out.println(leftNode1);
		
		
		//������������������ԭ���ı�����ʽ
		System.out.println("ʹ������������");
		brBinaryTree1.threadList();
	}
}

//����һ�ö�����
class BinaryTree1 {
	private HeroNode1 root;

	// Ϊ��ʵ������������Ҫ����һ��ָ��ǰ�ڵ��ǰ���ڵ��һ������
	// �ڵݹ����������ʱ��pre���Ǳ���ǰһ���ڵ�
	private HeroNode1 pre = null;

	public void setRoot(HeroNode1 root1) {
		this.root = root1;
	}
	//�����������ķ���
	public void threadedNodes() {
		this.threadedNodes(root);
	}

	//���������������������ķ���
	public void threadList() {
		//����һ���������洢��ǰ�����Ľڵ㣬��root��ʼ
		HeroNode1 node1 = root;
		while(node1 != null) {
			//ѭ���ҵ�leftType==1�Ľڵ�
			//��������ű������仯����Ϊ��left����1ʱ��˵���ýڵ��ǰ�����������������Ч�ڵ�
			while(node1.getLeftType()==0) {
				node1 = node1.getLeft();
				
			}
			//��ӡ��ǰ�ڵ�
			System.out.println(node1);
			//�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬��һֱ���
			while(node1.getRightType() ==1) {
				//��ȡ����ǰ�ڵ�ĺ�̽ڵ�
				node1 = node1.getRight();
				System.out.println(node1);
			}
			//�滻��������Ľڵ�
			node1 = node1.getRight();
		}
	}
	
	
	// ��д�Զ��������������������ķ���
	/**
	 * 
	 * Title:threadedNodes
	 * 
	 * @param node1 ��ǰ��Ҫ�������Ľ��
	 */
	public void threadedNodes(HeroNode1 node1) {
		// �����ǰ���������Ϊ�գ�node1==null
		if (node1 == null) {
			return;
		}
		// ����������
		// 1.��������������
		threadedNodes(node1.getLeft());

		// 2.��������ǰ�ڵ�
		// 2.1�ȴ���ǰ�ڵ��ǰ���ڵ�
		if (node1.getLeft() == null) {
			// �õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node1.setLeft(pre);
			// �޸ĵ�ǰ�ڵ����ָ�������:ָ��ǰ���ڵ�
			node1.setLeftType(1);
		}
		//2.2�����̽��
		if (pre != null && pre.getRight() == null) {
			//��ǰ���ڵ����ָ��ָ��ǰ�ڵ�
			pre.setRight(node1);
			//�޸�ǰ���ڵ����ָ������
			pre.setRightType(1);
		}
		//��Ҫ��ÿ����һ���ڵ���õ�ǰ�ڵ��Ϊ��һ���ڵ��ǰ���ڵ�
		pre = node1;

		// 3.��������������
		threadedNodes(node1.getRight());

	}

	// �����ı����Ƕ�����ʵ�ֵ�

	// ǰ�����
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// �������
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// �������
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	// ǰ���������
	public HeroNode1 preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	// �����������
	public HeroNode1 infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	// �����������
	public HeroNode1 postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}

	// ɾ���ڵ�
	public void delNode(int no) {
		if (root != null) {
			// ���ֻ��һ��root��㣬���������ж�root�ǲ��Ǿ���Ҫɾ�����
			if (root.getNo() == no) {
				root = null;
			} else {// �ݹ�ɾ��
				this.root.delNode(no);
			}
		} else {
			System.out.println("��������ɾ��");
		}
	}
}

//����HeroNode1
//�ڵ�
class HeroNode1 {
	private int no;
	private String name;
	private HeroNode1 left;// Ĭ��null
	private HeroNode1 right;

	// ˵����
	// 1.���leftType==0 ��ʾָ�������������1��ʾָ��ǰ���ڵ�
	// 2.���rightType==0 ��ʾָ�������������1��ʾָ���̽��
	private int leftType;
	private int rightType;

	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}

	public HeroNode1(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode1 getLeft() {
		return left;
	}

	public void setLeft(HeroNode1 left) {
		this.left = left;
	}

	public HeroNode1 getRight() {
		return right;
	}

	public void setRight(HeroNode1 right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode1 [no=" + no + ", name=" + name + "]";
	}

	// ��дǰ������ķ���
	public void preOrder() {
		System.out.println(this);// ����������

		// �ݹ�������
		if (this.left != null) {
			this.left.preOrder();

		}
		// �ݹ���������ǰ�����
		if (this.right != null) {
			this.right.preOrder();

		}

	}

	// ��д��������ķ���
	public void infixOrder() {
		// �ݹ�������
		if (this.left != null) {
			this.left.infixOrder();

		}

		System.out.println(this);// ��������

		// �ݹ����������������
		if (this.right != null) {
			this.right.infixOrder();

		}

	}

	// ��д��������ķ���
	public void postOrder() {
		// �ݹ�������
		if (this.left != null) {
			this.left.postOrder();

		}

		// �ݹ���������ǰ�����
		if (this.right != null) {
			this.right.postOrder();

		}

		System.out.println(this);// ��������

	}

	/**
	 * ǰ��������� Title:preOrderSearch
	 * 
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode1 preOrderSearch(int no) {
		System.out.println("����ǰ�����");
		// 1.��ǰ�ڵ��ҵ�
		if (this.no == no) {
			return this;
		}
		// 2.��ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�����Ϊ�գ���ݹ�ǰ�����
		HeroNode1 resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		// 2.1����ǰ�ڵ��ҵ�������
		if (resNode != null) {
			return resNode;
		}
		// 2.2��û���ҵ�
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
//		if(resNode != null) {
//			return resNode;
//		}		
		return resNode;
	}

	/**
	 * ����������� Title:preOrderSearch
	 * 
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode1 infixOrderSearch(int no) {
		HeroNode1 resNode = null;

		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("�����������");
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

	/**
	 * ����������� Title:preOrderSearch
	 * 
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode1 postOrderSearch(int no) {
		HeroNode1 resNode = null;

		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		// �������ҵ�
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("����������");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	/**
	 * ɾ����� 1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ� 2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ�������� Title:delNode
	 * 
	 * @param no
	 */
	public void delNode(int no) {
		/*
		 * ˼·�� 1.��Ϊ����Ķ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ�Ҫɾ����㣬������ȥ�жϵ�ǰ���������ǲ�����Ҫɾ�����
		 * 2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����ͽ�this.left = null;���Ҿͷ���(�����ݹ�ɾ��)
		 * 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����ͽ�this.right = null;���Ҿͷ���(�����ݹ�ɾ��)
		 * 4.����ڶ����͵�����û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ�� 5.�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
		 */
		if (this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if (this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if (this.left != null) {
			this.left.delNode(no);
		}
		if (this.right != null) {
			this.right.delNode(no);
		}
	}
}
