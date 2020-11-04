package com.atguigu.queue;

import java.util.Scanner;

/**
 * 这是一个数组模拟环形队列
 * 
 * @Title CricleArrayQueueDemo.java
 * @Description
 * @author 孟BIG
 * @date2019年8月5日
 */
public class CricleArrayQueueDemo2 {
	public static void main(String[] args) {
		//创建一个环形队列
		CricleArrayQueue arrayQueue = new CricleArrayQueue(4);//有一个空的空间，这里设置的为4，其队列最多为3个
		char key = ' ';//接收用户输入
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		//输出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scan.next().charAt(0);//接收一个字符
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("输入一个数字");
				int value = scan.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出数据是%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h'://查看队列头的数据
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("队列头的数据是%d/n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'e':
				scan.close();
				loop = false;
			default:
				break;
			}
		}
		System.out.println("程序退出");
	}
}

//使用数组模拟队列——编写一个ArrayQueue类
class CricleArrayQueue {
	private int maxSize;// 表示数组的最大容量
	private int[] arr;// 该数据用于存放数据，模拟队列
	private int front;// front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素 ,front 的初始值 = 0
	private int rear;// rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.,rear 的初始值 = 0

	// 1.创建队列的构造器
	public CricleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;

	}

	// 判断队列是否满了
	public boolean isFull() {
		return (rear+1)%maxSize == front;
	}

	// 判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}

	// 添加数据到队列
	public void addQueue(int n) {
		// 判断队列是否满了
		if (isFull()) {
			System.out.println("队列满了，不能输入");
			return;
		}
		//直接将数据加入
		arr[rear] = n;
		//将rear后移，这里必须考虑取模
		rear = (rear+1)%maxSize;
	}

	// 获取队列的数据，出队列
	public int getQueue() {
		// 判断队列是否为空
		if (isEmpty()) {
			// 通过抛出异常处理
			throw new RuntimeException("队列为空，不能取数据");
		}
		//这里需要分析出front是指向队列的第一个元素
		//1.先把front对应的值保存到一个临时的变量
		//2.将front后移,考虑取模
		//3.将临时保存的变量返回
		int value = arr[front];
		front = (front + 1)%maxSize;
		return value;
	}

	// 显示队列的所有数据
	public void showQueue() {
		// 遍历
		if (isEmpty()) {
			System.out.println("队列为空，没有数据");
			return;
		}
		//从front开始遍历，遍历多少个元素
		//
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i]);
		}
	}

	//求出当前队列有效数据的个数
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	
	// 显示队列的头数据，注意不是取出数据
	public int headQueue() {
		// 判断队列为空
		if (isEmpty()) {
			throw new RuntimeException("队列为空，不能取数据");
		}
		return arr[front];
	}

}
