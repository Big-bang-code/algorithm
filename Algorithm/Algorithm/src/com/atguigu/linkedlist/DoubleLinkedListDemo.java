package com.atguigu.linkedlist;

/**
 * 双向链表
 * 
 * @Title DoubleLinkedListDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年8月16日
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// 测试
		System.out.println("双向链表的测试");
		// 1.先创建几个节点
		HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
		HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
		
		//2.创建双向链表对象
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		
		doubleLinkedList.list();
		
		//3.修改测试
		HeroNode2 hero5 = new HeroNode2(2, "老卢", "小玉");
		doubleLinkedList.update(hero5);
		System.out.println("修改后的链表");
		doubleLinkedList.list();
		
		//4.删除测试
		doubleLinkedList.del(2);
		System.out.println("删除后的链表");
		doubleLinkedList.list();

	}

}

//创建一个双向链表类
class DoubleLinkedList {
	// 先初始化一个头节点，头节点不要动,不存放具体的数据
	private HeroNode2 head = new HeroNode2(0, "", "");

	// 返回头节点
	public HeroNode2 getHead() {
		return head;
	}

	// 遍历双向链表的方法
	// 显示链表:遍历------>通过一个辅助变量，帮助遍历整个链表
	public void list() {
		// 先判断链表是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 不为空，因为头节点不能动，因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				//
				break;
			}
			// 输出节点的信息
			System.out.println(temp.toString());
			// 将temp后移,否则死循环
			temp = temp.next;

		}
	}

	// 默认添加到链表最后
	// 添加节点到双向链表的最后
	public void add(HeroNode2 heroNode) {
		// 因为头节点不能动，因此，我们需要一个辅助变量temp
		HeroNode2 temp = head;
		// 遍历链表，找到最后
		while (true) {
			// 找到链表最后
			if (temp.next == null) {
				//
				break;
			}
			// 如果没有找到，就将temp后移
			temp = temp.next;
		}
		// 当退出while循环时，temp就指向了链表的最后
		// 形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	// 修改一个节点的内容，可以看出双向链表的节点内容修改和单向链表的一样
	// 修改节点的信息，根据no编号来修改，即no编号不能改
	// 根据newHeroNode 的 no来修改即可
	public void update(HeroNode2 newHeroNode) {
		// 判断是否为空
		if (head.next == null) {
			System.out.println("链表为空");
			return;
		}
		// 找到需要修改的节点，根据no编号
		// 定义一个辅助变量
		HeroNode2 temp = head.next;
		boolean flag = false;// 标识是否找到该节点
		while (true) {
			if (temp == null) {
				break;// 遍历完毕
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// 根据flag判断是否找到要修改的节点
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("没有找到编号 %d 的节点,不能修改\n", newHeroNode.no);
		}
	}

	// 从双向链表中删除一个节点
	// 说明
	// 1.对于双向链表，我们可以直接找到要删除的这个节点，不用找删除节点的上一个节点(和单向链表的区别)
	// 2.找到后自我删除即可
	public void del(int no) {

		// 判断当前链表是否为空
		if (head.next == null) {// 空链表
			System.out.println("链表为空，无法删除");
		}

		HeroNode2 temp = head.next;// 辅助遍量(指针)
		boolean flag = false;// 标志是否找到待删除节点
		while (true) {
			if (temp == null) {// 已经到链表的最后节点的next
				break;
			}
			if (temp.no == no) {

				flag = true;
				break;
			}
			temp = temp.next;// temp后移，遍历
		}
		// 判断flag
		if (flag) {
			temp.pre.next = temp.next;
			// 这里的代码是有问题的
			// 如果删除的是最后一个节点的话，就不需要执行下面这句话，否则这样会报空指针异常
			// temp.next.pre = temp.pre;

			// 所以，加上if判断
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("要删除的%d节点不存在", no);
		}
	}

}

//1.定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;// 指向下一个节点的域，默认为null
	public HeroNode2 pre;// 指向前一个节点，默认为null

	// 构造器
	public HeroNode2(int hNo, String hName, String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}

//	@Override
//	public String toString() {
//		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ", next=" + next + "]";
//	}

	// 为了显示方便，重写toString
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}