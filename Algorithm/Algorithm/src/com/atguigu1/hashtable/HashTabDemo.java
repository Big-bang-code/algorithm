package com.atguigu1.hashtable;

import java.util.Scanner;

/**
 * 	哈希table
 * @Title HashTabDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年10月12日
 */
public class HashTabDemo {
	public static void main(String[] args) {
		//创建hash表
		HashTab hashTab = new HashTab(7);
		
		//写一个简单的菜单
		String key = "";
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("add:添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("find:查找雇员");
			System.out.println("exit:退出系统");
			System.out.println();
			
			key = scanner.next();
			
			switch (key) {
			case "add":
				System.out.println("输入id:");
				int id = scanner.nextInt();
				System.out.println("输入名字:");
				String name = scanner.next();
				//创建一个雇员
				Emp emp = new Emp(id, name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "find":
				System.out.println("输入要查找的id");
				id = scanner.nextInt();
				hashTab.findEmpById(id);
				break;
			case "edit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
			
		}		
	}
}

/**'
 * 	创建HashTab，管理多条链表
 * @Title HashTabDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年10月12日
 */
class HashTab{
	private EmpLinkedList[] empLinkedListArray;
	private int size;//表示有多少条链表
	
	//构造器
	public HashTab(int size) {
		this.size = size;
		//初始化empLinkedListArray
		empLinkedListArray = new EmpLinkedList[size];
		//有一个坑【这里要分别初始化每一条链表】
		for (int i = 0; i < size; i++) {
			empLinkedListArray[i] = new EmpLinkedList();
		}		
	}
	
	//添加雇员
	public void add(Emp emp) {
		//根据雇员id，得到该雇员应当添加到哪条链表
		int empLinkedListNO = hashFun(emp.id);
		//将emp添加到对应的链表中
		empLinkedListArray[empLinkedListNO].add(emp);
	}
	
	//遍历所有的链表,遍历hash表【数组加上链表共同构成hash表】
	public void list() {
		for(int i =0;i<size;i++) {
			empLinkedListArray[i].list(i);
		}
	}
	
	//根据输入的id,查找雇员
	public void findEmpById(int id) {
		//使用散列函数确定到哪条链表查找
		int empLinkedListNO = hashFun(id);
		Emp emp = empLinkedListArray[empLinkedListNO].findEmpById(id);
		
		if(emp != null) {
			System.out.printf("在第%d条链表中找到雇员id=%d\n",(empLinkedListNO+1),id);
		}else {
			System.out.println("在哈希表中，没有找到该雇员");
		}
	}
	
	//编写散列函数，使用一个简单取模法
	public int hashFun(int id) {
		return id % size;
	}
}



/**
 * 	表示一条链表
 * @Title HashTabDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年10月12日
 */
class EmpLinkedList{
	//头指针指向第一个雇员,因此我们这个链表的head是直接指向第一个雇员
	private Emp head;//默认为空
	
	//添加雇员到链表
	//说明：
	//1.假定：当添加雇员时，id是自增长，即id的分配总是从小到大的
	//		  因此我们将该雇员直接加入到本链表的最后即可
	public void add(Emp emp) {
		//如果是添加第一个雇员
		if(head == null) {
			head = emp;
			return;
		}
		//如果不是第一个雇员，则添加一个辅助的指针，帮助定位到最后
		Emp curEmp = head;
		while(true) {
			if(curEmp.next == null) {
				//说明到了链表的最后
				break;
			}
			curEmp = curEmp.next;//后移,直到到了最后
		}
		//退出时直接将emp加入链表
		curEmp.next = emp;
	}
	
	//遍历链表的雇员信息
	public void list(int no) {
		if(head == null) {//说明当前链表为空
			System.out.println("第"+(no+1)+"链表为空");
			return;
		}
		System.out.println("第"+(no+1)+"链表信息为:");
		Emp curEmp = head;//辅助指针
		while(true) {
			System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
			if(curEmp.next == null) {
				//说明curEmp是最后节点
				break;
			}
			curEmp = curEmp.next;//后移，遍历
		}
		System.out.println();
	}
	
	//根据id查找雇员
	//如果查找到，就返回Emp,如果没有，就返回null
	public Emp findEmpById(int id) {
		//判断链表是否为空
		if(head == null) {
			System.out.println("链表为空");
			return null;
		}
		Emp curEmp = head;
		while(true) {
			if(curEmp.id == id) {
				break;//这时curEmp就指向要查找的雇员
			}
			//退出
			if(curEmp.next == null) {//说明遍历当前链表没有找到该雇员
				curEmp = null;
				break;
			}
			curEmp = curEmp.next;
		}
		return curEmp;
	}
}




/**
 * 	表示一个雇员
 * @Title HashTabDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年10月12日
 */
class Emp{
	public int id;
	public String name;
	public Emp next;//默认为空
	
	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}