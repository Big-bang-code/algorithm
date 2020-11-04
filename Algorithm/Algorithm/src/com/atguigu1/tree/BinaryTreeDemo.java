package com.atguigu1.tree;

/**
 * 	二叉树
 * 	前序中序后序遍历二叉树
 * 	二叉树删除结点
 * @Title BinaryTreeDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年11月1日
 */
public class BinaryTreeDemo {
	public static void main(String[] args) {
		//先创建一棵二叉树
		BinaryTree binaryTree = new BinaryTree();	
		HeroNode hero1 = new HeroNode(1, "宋江");
		HeroNode hero2 = new HeroNode(2, "卢俊义");
		HeroNode hero3 = new HeroNode(3, "吴用");
		HeroNode hero4 = new HeroNode(4, "林冲");
		HeroNode hero5 = new HeroNode(5, "关胜");
		
		//说明：先手动创建该二叉树，后边学习以递归的方式创建二叉树
		hero1.setLeft(hero2);
		hero1.setRight(hero3);
		hero3.setRight(hero4);
		hero3.setLeft(hero5);
		
		binaryTree.setRoot(hero1);
		
		System.out.println("前序遍历");
		binaryTree.preOrder();
		
		System.out.println("中序遍历");
		binaryTree.infixOrder();
		
		System.out.println("后序遍历");
		binaryTree.postOrder();
		
		
		System.out.println("查找");
		System.out.println("前序查找");
		HeroNode resNode = binaryTree.preOrderSearch(5);
		if (resNode != null) {
			System.out.printf("找到信息为no=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("没有找到no = %d 的英雄",5);
		}
		
		System.out.println();
		System.out.println("中序查找");
		HeroNode infixNode = binaryTree.infixOrderSearch(5);
		if (infixNode != null) {
			System.out.printf("找到信息为no=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("没有找到no = %d 的英雄",5);
		}
		
		System.out.println();
		System.out.println("后序查找");
		HeroNode postNode = binaryTree.postOrderSearch(5);
		if (postNode != null) {
			System.out.printf("找到信息为no=%d name=%s",resNode.getNo(),resNode.getName());
		}else {
			System.out.printf("没有找到no = %d 的英雄",5);
		}
	}
}

//定义一棵二叉树
class BinaryTree{
	private HeroNode root;
	
	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//真正的遍历是二叉树实现的
	
	//前序遍历
	public void preOrder() {
		if(this.root !=null) {
			this.root.preOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}	
	//中序遍历
	public void infixOrder() {
		if(this.root !=null) {
			this.root.infixOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
	//后序遍历
	public void postOrder() {
		if(this.root !=null) {
			this.root.postOrder();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}		
	//前序遍历查找
	public HeroNode preOrderSearch(int no) {		
		if(root != null) {
			return root.preOrderSearch(no);
		}else {
			return null;
		}
	}	
	//中序遍历查找
	public HeroNode infixOrderSearch(int no) {		
		if(root != null) {
			return root.infixOrderSearch(no);
		}else {
			return null;
		}
	}	
	//后序遍历查找
	public HeroNode postOrderSearch(int no) {	
		if(root != null) {
			return root.postOrderSearch(no);
		}else {
			return null;
		}
	}
	
	//删除节点
	public void delNode(int no) {
		if(root != null) {
			//如果只有一个root结点，这里立即判断root是不是就是要删除结点
			if(root.getNo()==no) {
				root = null;
			}else {//递归删除		
				this.root.delNode(no);
			}
		}else {
			System.out.println("空树不能删除");
		}
	}
}


//节点
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;//默认null
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
	
	//编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);//先输出父结点
		
		//递归左子树
		if(this.left != null) {
			this.left.preOrder();
		
		}
		//递归向右子树前序遍历
		if(this.right != null) {
			this.right.preOrder();
		
		}

	}

	//编写中序遍历的方法
	public void infixOrder() {
		//递归左子树
		if(this.left != null) {
			this.left.infixOrder();

		}
		
		System.out.println(this);//输出父结点
			
		//递归向右子树中序遍历
		if(this.right != null) {
			this.right.infixOrder();
	
		}
	
	}

	//编写后序遍历的方法
	public void postOrder() {
		//递归左子树
		if(this.left != null) {
			this.left.postOrder();
		
		}		
			
		//递归向右子树前序遍历
		if(this.right != null) {
			this.right.postOrder();
		
		}
		
		System.out.println(this);//输出父结点

	}
	
	
	/**
	 * 前序遍历查找
	 * Title:preOrderSearch
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序遍历");
		//1.当前节点找到
		if(this.no==no) {
			return this;
		}
		//2.当前节点的左子节点是否为空，若不为空，则递归前序查找
		HeroNode resNode= null;
		if(this.left != null) {
			resNode = this.left.preOrderSearch(no);			
		}
		//2.1若当前节点找到，返回
		if(resNode != null) {
			return resNode;
		}
		//2.2若没有找到
		if(this.right != null) {
			resNode = this.right.preOrderSearch(no);	
		}
//		if(resNode != null) {
//			return resNode;
//		}		
		return resNode;
	}
	
	/**
	 * 中序遍历查找
	 * Title:preOrderSearch
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode infixOrderSearch(int no) {
		HeroNode resNode= null;
		
		if(this.left != null) {
			resNode = this.left.infixOrderSearch(no);	
		}	
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入中序遍历");
		if(this.no==no) {
			return this;
		}
		if(this.right != null) {
			resNode = this.right.infixOrderSearch(no);	
		}		
		return resNode;
	}

	/**
	 * 后序遍历查找
	 * Title:preOrderSearch
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode postOrderSearch(int no) {
		HeroNode resNode= null;
		
		if(this.left != null) {
			resNode = this.left.postOrderSearch(no);	
		}	
		//左子树找到
		if(resNode != null) {
			return resNode;
		}		
		if(this.right != null) {
			resNode = this.right.postOrderSearch(no);	
		}
		if(resNode != null) {
			return resNode;
		}
		System.out.println("进入后序遍历");
		if(this.no==no) {
			return this;
		}
		return resNode;
	}
	
	/**
	 * 删除结点
	 * 1.如果删除的节点是叶子节点，则删除该节点
	 * 2.如果删除的节点是非叶子节点，则删除该子树
	 * Title:delNode
	 * @param no
	 */
	public void delNode(int no) {
		/*
		 * 思路：
		 * 1.因为这里的二叉树是单向的，所以我们是判断当前结点的子结点是否要删除结点，而不能去判断当前的这个结点是不是需要删除结点
		 * 2.如果当前结点的左子结点不为空，并且左子结点就是要删除，就将this.left = null;并且就返回(结束递归删除)
		 * 3.如果当前结点的右子结点不为空，并且右子结点就是要删除，就将this.right = null;并且就返回(结束递归删除)
		 * 4.如果第二步和第三步没有删除结点，那么我们就需要向左子树进行递归删除
		 * 5.如果第4步也没有删除结点，则应当向右子树进行递归删除
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



