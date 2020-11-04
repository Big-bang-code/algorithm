package com.atguigu1.tree;

/**
 * 线索化二叉树
 * 
 * @Title ThreadeBinaryTree1Demo.java
 * @Description
 * @author 孟BIG
 * @date2019年11月4日
 */
public class ThreadeBinaryTreeDemo {

	public static void main(String[] args) {
		//测试中序线索二叉树
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
		
		
		//线索化二叉树不能用原来的遍历方式
		System.out.println("使用线索化遍历");
		brBinaryTree1.threadList();
	}
}

//定义一棵二叉树
class BinaryTree1 {
	private HeroNode1 root;

	// 为了实现线索化，需要创建一个指向当前节点的前驱节点的一个变量
	// 在递归进行线索化时，pre总是保留前一个节点
	private HeroNode1 pre = null;

	public void setRoot(HeroNode1 root1) {
		this.root = root1;
	}
	//重载线索化的方法
	public void threadedNodes() {
		this.threadedNodes(root);
	}

	//遍历中序线索化二叉树的方法
	public void threadList() {
		//定义一个变量，存储当前便利的节点，从root开始
		HeroNode1 node1 = root;
		while(node1 != null) {
			//循环找到leftType==1的节点
			//后面会随着遍历而变化，因为当left等于1时，说明该节点是按照线索化处理后的有效节点
			while(node1.getLeftType()==0) {
				node1 = node1.getLeft();
				
			}
			//打印当前节点
			System.out.println(node1);
			//如果当前节点的右指针指向的是后继节点，就一直输出
			while(node1.getRightType() ==1) {
				//获取到当前节点的后继节点
				node1 = node1.getRight();
				System.out.println(node1);
			}
			//替换这个遍历的节点
			node1 = node1.getRight();
		}
	}
	
	
	// 编写对二叉树进行中序线索化的方法
	/**
	 * 
	 * Title:threadedNodes
	 * 
	 * @param node1 当前需要线索化的结点
	 */
	public void threadedNodes(HeroNode1 node1) {
		// 如果当前线索化结点为空，node1==null
		if (node1 == null) {
			return;
		}
		// 中序线索化
		// 1.先线索化左子树
		threadedNodes(node1.getLeft());

		// 2.线索化当前节点
		// 2.1先处理当前节点的前驱节点
		if (node1.getLeft() == null) {
			// 让当前节点的左指针指向前驱节点
			node1.setLeft(pre);
			// 修改当前节点的左指针的类型:指向前驱节点
			node1.setLeftType(1);
		}
		//2.2处理后继结点
		if (pre != null && pre.getRight() == null) {
			//让前驱节点的右指针指向当前节点
			pre.setRight(node1);
			//修改前驱节点的右指针类型
			pre.setRightType(1);
		}
		//重要：每处理一个节点后让当前节点变为下一个节点的前驱节点
		pre = node1;

		// 3.再线索化右子树
		threadedNodes(node1.getRight());

	}

	// 真正的遍历是二叉树实现的

	// 前序遍历
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 中序遍历
	public void infixOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 后序遍历
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	// 前序遍历查找
	public HeroNode1 preOrderSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}

	// 中序遍历查找
	public HeroNode1 infixOrderSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}

	// 后序遍历查找
	public HeroNode1 postOrderSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}

	// 删除节点
	public void delNode(int no) {
		if (root != null) {
			// 如果只有一个root结点，这里立即判断root是不是就是要删除结点
			if (root.getNo() == no) {
				root = null;
			} else {// 递归删除
				this.root.delNode(no);
			}
		} else {
			System.out.println("空树不能删除");
		}
	}
}

//创建HeroNode1
//节点
class HeroNode1 {
	private int no;
	private String name;
	private HeroNode1 left;// 默认null
	private HeroNode1 right;

	// 说明：
	// 1.如果leftType==0 表示指向的是左子树，1表示指向前驱节点
	// 2.如果rightType==0 表示指向的是右子树，1表示指向后继结点
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

	// 编写前序遍历的方法
	public void preOrder() {
		System.out.println(this);// 先输出父结点

		// 递归左子树
		if (this.left != null) {
			this.left.preOrder();

		}
		// 递归向右子树前序遍历
		if (this.right != null) {
			this.right.preOrder();

		}

	}

	// 编写中序遍历的方法
	public void infixOrder() {
		// 递归左子树
		if (this.left != null) {
			this.left.infixOrder();

		}

		System.out.println(this);// 输出父结点

		// 递归向右子树中序遍历
		if (this.right != null) {
			this.right.infixOrder();

		}

	}

	// 编写后序遍历的方法
	public void postOrder() {
		// 递归左子树
		if (this.left != null) {
			this.left.postOrder();

		}

		// 递归向右子树前序遍历
		if (this.right != null) {
			this.right.postOrder();

		}

		System.out.println(this);// 输出父结点

	}

	/**
	 * 前序遍历查找 Title:preOrderSearch
	 * 
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode1 preOrderSearch(int no) {
		System.out.println("进入前序遍历");
		// 1.当前节点找到
		if (this.no == no) {
			return this;
		}
		// 2.当前节点的左子节点是否为空，若不为空，则递归前序查找
		HeroNode1 resNode = null;
		if (this.left != null) {
			resNode = this.left.preOrderSearch(no);
		}
		// 2.1若当前节点找到，返回
		if (resNode != null) {
			return resNode;
		}
		// 2.2若没有找到
		if (this.right != null) {
			resNode = this.right.preOrderSearch(no);
		}
//		if(resNode != null) {
//			return resNode;
//		}		
		return resNode;
	}

	/**
	 * 中序遍历查找 Title:preOrderSearch
	 * 
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode1 infixOrderSearch(int no) {
		HeroNode1 resNode = null;

		if (this.left != null) {
			resNode = this.left.infixOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入中序遍历");
		if (this.no == no) {
			return this;
		}
		if (this.right != null) {
			resNode = this.right.infixOrderSearch(no);
		}
		return resNode;
	}

	/**
	 * 后序遍历查找 Title:preOrderSearch
	 * 
	 * @param no
	 * @return 如果找到返回该Node，没有返回null
	 */
	public HeroNode1 postOrderSearch(int no) {
		HeroNode1 resNode = null;

		if (this.left != null) {
			resNode = this.left.postOrderSearch(no);
		}
		// 左子树找到
		if (resNode != null) {
			return resNode;
		}
		if (this.right != null) {
			resNode = this.right.postOrderSearch(no);
		}
		if (resNode != null) {
			return resNode;
		}
		System.out.println("进入后序遍历");
		if (this.no == no) {
			return this;
		}
		return resNode;
	}

	/**
	 * 删除结点 1.如果删除的节点是叶子节点，则删除该节点 2.如果删除的节点是非叶子节点，则删除该子树 Title:delNode
	 * 
	 * @param no
	 */
	public void delNode(int no) {
		/*
		 * 思路： 1.因为这里的二叉树是单向的，所以我们是判断当前结点的子结点是否要删除结点，而不能去判断当前的这个结点是不是需要删除结点
		 * 2.如果当前结点的左子结点不为空，并且左子结点就是要删除，就将this.left = null;并且就返回(结束递归删除)
		 * 3.如果当前结点的右子结点不为空，并且右子结点就是要删除，就将this.right = null;并且就返回(结束递归删除)
		 * 4.如果第二步和第三步没有删除结点，那么我们就需要向左子树进行递归删除 5.如果第4步也没有删除结点，则应当向右子树进行递归删除
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
