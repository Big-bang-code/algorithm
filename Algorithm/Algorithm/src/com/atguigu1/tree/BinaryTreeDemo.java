package com.atguigu1.tree;

/**
 * 	������
 * 	ǰ������������������
 * 	������ɾ�����
 * @Title BinaryTreeDemo.java
 * @Description
 * @author ��BIG
 * @date2019��11��1��
 */
public class BinaryTreeDemo {
	public static void main(String[] args) {
		//�ȴ���һ�ö�����
		BinaryTree binaryTree = new BinaryTree();	
		HeroNode hero1 = new HeroNode(1, "�ν�");
		HeroNode hero2 = new HeroNode(2, "¬����");
		HeroNode hero3 = new HeroNode(3, "����");
		HeroNode hero4 = new HeroNode(4, "�ֳ�");
		HeroNode hero5 = new HeroNode(5, "��ʤ");
		
		//˵�������ֶ������ö����������ѧϰ�Եݹ�ķ�ʽ����������
		hero1.setLeft(hero2);
		hero1.setRight(hero3);
		hero3.setRight(hero4);
		hero3.setLeft(hero5);
		
		binaryTree.setRoot(hero1);
		
		System.out.println("ǰ�����");
		binaryTree.preOrder();
		
		System.out.println("�������");
		binaryTree.infixOrder();
		
		System.out.println("�������");
		binaryTree.postOrder();
		
		
		System.out.println("����");
		System.out.println("ǰ�����");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if (resNode != null) {
			System.out.printf("�ҵ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("û���ҵ�no = %d ��Ӣ��",5);
		}
		
		System.out.println();
		System.out.println("�������");
		HeroNode infixNode = binaryTree.infixOrderSearch(5);
		if (infixNode != null) {
			System.out.printf("�ҵ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("û���ҵ�no = %d ��Ӣ��",5);
		}
		
		System.out.println();
		System.out.println("�������");
		HeroNode postNode = binaryTree.postOrderSearch(5);
		if (postNode != null) {
			System.out.printf("�ҵ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("û���ҵ�no = %d ��Ӣ��",5);
		}
	}
}

//����һ�ö�����
class BinaryTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//�����ı����Ƕ�����ʵ�ֵ�
	
	//ǰ�����
	public void preOrder() {
		if(this.root !=null) {
			this.root.preOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}	
	//�������
	public void infixOrder() {
		if(this.root !=null) {
			this.root.infixOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
	//�������
	public void postOrder() {
		if(this.root !=null) {
			this.root.postOrder();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}		
	//ǰ���������
	public HeroNode preOrderSearch(int no) {		
		if(root != null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}	
	//�����������
	public HeroNode infixOrderSearch(int no) {		
		if(root != null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}	
	//�����������
	public HeroNode postOrderSearch(int no) {	
		if(root != null) {
			return root.postOrderSearch(no);
		}else {
			return null;
		}
	}
	
	//ɾ���ڵ�
	public void delNode(int no) {
		if(root != null) {
			//���ֻ��һ��root��㣬���������ж�root�ǲ��Ǿ���Ҫɾ�����
			if(root.getNo()==no) {
				root = null;
			}else {//�ݹ�ɾ��		
				this.root.delNode(no);
			}
		}else {
			System.out.println("��������ɾ��");
		}
	}
}


//�ڵ�
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;//Ĭ��null
	private HeroNode right;

	
	public HeroNode(int no, String name) {
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

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}	
	
	//��дǰ������ķ���
	public void preOrder() {
		System.out.println(this);//����������
		
		//�ݹ�������
		if(this.left != null) {
			this.left.preOrder();
		
		}
		//�ݹ���������ǰ�����
		if(this.right != null) {
			this.right.preOrder();
		
		}

	}

	//��д��������ķ���
	public void infixOrder() {
		//�ݹ�������
		if(this.left != null) {
			this.left.infixOrder();

		}
		
		System.out.println(this);//��������
			
		//�ݹ����������������
		if(this.right != null) {
			this.right.infixOrder();
	
		}
	
	}

	//��д��������ķ���
	public void postOrder() {
		//�ݹ�������
		if(this.left != null) {
			this.left.postOrder();
		
		}		
			
		//�ݹ���������ǰ�����
		if(this.right != null) {
			this.right.postOrder();
		
		}
		
		System.out.println(this);//��������

	}
	
	
	/**
	 * ǰ���������
	 * Title:preOrderSearch
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode preOrderSearch(int no) {
		System.out.println("����ǰ�����");
		//1.��ǰ�ڵ��ҵ�
		if(this.no==no) {
			return this;
		}
		//2.��ǰ�ڵ�����ӽڵ��Ƿ�Ϊ�գ�����Ϊ�գ���ݹ�ǰ�����
		HeroNode resNode= null;
		if(this.left != null) {
			resNode = this.left.preOrderSearch(no);			
		}
		//2.1����ǰ�ڵ��ҵ�������
		if(resNode != null) {
			return resNode;
		}
		//2.2��û���ҵ�
		if(this.right != null) {
			resNode = this.right.preOrderSearch(no);	
		}
//		if(resNode != null) {
//			return resNode;
//		}		
		return resNode;
	}
	
	/**
	 * �����������
	 * Title:preOrderSearch
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode= null;
		
		if(this.left != null) {
			resNode = this.left.infixOrderSearch(no);	
		}	
		if(resNode != null) {
			return resNode;
		}
		System.out.println("�����������");
		if(this.no==no) {
			return this;
		}
		if(this.right != null) {
			resNode = this.right.infixOrderSearch(no);	
		}		
		return resNode;
	}

	/**
	 * �����������
	 * Title:preOrderSearch
	 * @param no
	 * @return ����ҵ����ظ�Node��û�з���null
	 */
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode= null;
		
		if(this.left != null) {
			resNode = this.left.postOrderSearch(no);	
		}	
		//�������ҵ�
		if(resNode != null) {
			return resNode;
		}		
		if(this.right != null) {
			resNode = this.right.postOrderSearch(no);	
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("����������");
		if(this.no==no) {
			return this;
		}
		return resNode;
	}
	
	/**
	 * ɾ�����
	 * 1.���ɾ���Ľڵ���Ҷ�ӽڵ㣬��ɾ���ýڵ�
	 * 2.���ɾ���Ľڵ��Ƿ�Ҷ�ӽڵ㣬��ɾ��������
	 * Title:delNode
	 * @param no
	 */
	public void delNode(int no) {
		/*
		 * ˼·��
		 * 1.��Ϊ����Ķ������ǵ���ģ������������жϵ�ǰ�����ӽ���Ƿ�Ҫɾ����㣬������ȥ�жϵ�ǰ���������ǲ�����Ҫɾ�����
		 * 2.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����ͽ�this.left = null;���Ҿͷ���(�����ݹ�ɾ��)
		 * 3.�����ǰ�������ӽ�㲻Ϊ�գ��������ӽ�����Ҫɾ�����ͽ�this.right = null;���Ҿͷ���(�����ݹ�ɾ��)
		 * 4.����ڶ����͵�����û��ɾ����㣬��ô���Ǿ���Ҫ�����������еݹ�ɾ��
		 * 5.�����4��Ҳû��ɾ����㣬��Ӧ�������������еݹ�ɾ��
		 */
		if(this.left != null && this.left.no == no) {
			this.left = null;
			return;
		}
		if(this.right != null && this.right.no == no) {
			this.right = null;
			return;
		}
		if(this.left !=null) {
			this.left.delNode(no);
		}
		if(this.right !=null) {
			this.right.delNode(no);
		}					
	}
}



