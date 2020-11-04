package com.atguigu.linkedlist;
/**
 * 约瑟夫问题  单向环形链表
 * Josephu  问题为：设编号为1，2，… n的n个人围坐一圈，
 * 约定编号为k（1<=k<=n）的人从1开始报数，数到m 的那个人出列，
 * 它的下一位又从1开始报数，数到m的那个人又出列，
 * 依次类推，直到所有人出列为止，由此产生一个出队编号的序列。
	n = 5 , 即有5个人 
	k = 1, 从第一个人开始报数
	m = 2, 数2下
 * @Title Josepfu.java
 * @Description
 * @author 孟BIG
 * @date2019年8月26日
 */
public class Josepfu {
	//测试
	public static void main(String[] args) {
		CricleSingleLinkedList c1 = new CricleSingleLinkedList();
		c1.addBoy(5);
		c1.showBoy();
		
		
		c1.countBoy(1, 2, 5);
		
		
		CricleSingleLinkedList c2 = new CricleSingleLinkedList();
		c2.showBoy();
	}
}
/**
 * 创建一个环形的单向链表
 */
class CricleSingleLinkedList{
	//创建一个first节点，但是不要赋值
	private Boy first= new Boy(-1);
	
	//添加小孩节点，构成环形链表[直接确定添加的节点个数]
	public void addBoy(int nums) {
		//nums 做一个数据校验
		if(nums<1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null;//辅助指针，帮助创建环形链表
		//使用for创建环形链表
		for (int i = 1; i <= nums; i++) {
			//根据编号，创建小孩节点
			Boy boy = new Boy(i);
			//如果是第一个小孩
			if(i==1) {
				first = boy;
				first.setNextBoy(first);//只有一个Boy也构成环
				curBoy = first;//让curBoy指向第一个小孩
			}else {
				curBoy.setNextBoy(boy);
				boy.setNextBoy(first);
				curBoy = boy;
			}			
		}
	}
	
	//遍历当前环形链表，用CurBoy进行遍历
	public void showBoy() {
		//先判断链表是否为空
		if(first.getNextBoy() == null) {
			System.out.println("链表为空");
			return;
		}
		//因为first不能动，因此仍然使用一个辅助指针完成遍历
		Boy curBoy = first;
		while(true) {
			System.out.printf("小孩的编号%d \n",curBoy.getNo());
			if (curBoy.getNextBoy() == first) {//说明遍历完毕
				break;
			}
			curBoy = curBoy.getNextBoy();//让curBoy后移
		}
	}
	
	//根据用户的输入，计算出出圈的顺序
	/**
	 * 
	 * Title:countBoy
	 * @param startNo  表示从第几个小孩开始数数，
	 * @param countNum 表示数几下
	 * @param nums	   表示最初有多少小孩在圈中
	 */
	public void countBoy(int startNo,int countNum,int nums) {
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误");
			return;
		}
		//创建一个辅助指针，帮助完成小孩出圈
		Boy helper = first;
		//需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点.
		while(true) {
			if (helper.getNextBoy() == first) {//说明helper指向最后小孩节点
				break;
			}
			helper = helper.getNextBoy();
		}
		//小孩报数前，先让first和helper移动到k-1次
		for(int j = 0;j<startNo-1;j++) {
			first = first.getNextBoy();
			helper = helper.getNextBoy();
		}
		//当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次,然后出圈
		//这是一个循环操作，直到圈中只有一个节点
		while(true) {
			if(helper==first) {//说明圈中只有一个节点
				break;
			}
			//让first和helper指针同时移动 countNum-1
			for (int j = 0; j < countNum-1; j++) {
				first = first.getNextBoy();
				helper = helper.getNextBoy();
			}
			//这时first指向的节点，就是要出圈的小孩节点
			System.out.printf("小孩出圈%d \n",first.getNo());
			//这时将first指向的小孩出圈
			first = first.getNextBoy();
			helper.setNextBoy(first);
		}
		System.out.printf("最后留在圈中的小孩编号%d \n",first.getNo());
	}
}


/**
 * 创建一个boy类，表示一个节点
 * @Title Josepfu.java
 * @Description
 * @author 孟BIG
 * @date2019年8月26日
 */
class Boy{
	private int no;//编号
	private Boy nextBoy;//指向下一个节点
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNextBoy() {
		return nextBoy;
	}
	public void setNextBoy(Boy nextBoy) {
		this.nextBoy = nextBoy;
	}	
}