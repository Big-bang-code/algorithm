package com.atguigu.queue;

import java.util.Scanner;

/**
 * ����һ������ģ�����
 * 
 * @Title ArrayQueueDemo.java
 * @Description
 * @author ��BIG
 * @date2019��8��4��
 */
public class ArrayQueueDemo {
	public static void main(String[] args) {
		//����һ������
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';//�����û�����
		Scanner scan = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key = scan.next().charAt(0);//����һ���ַ�
			switch (key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("����һ������");
				int value = scan.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("ȡ��������%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h'://�鿴����ͷ������
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("����ͷ��������%d/n",res);
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
		System.out.println("�����˳�");
	}
}

//ʹ������ģ����С�����дһ��ArrayQueue��
class ArrayQueue {
	private int maxSize;// ��ʾ������������
	private int front;// ����ͷ
	private int rear;// ����β
	private int[] arr;// ���������ڴ�����ݣ�ģ�����

	// 1.�������еĹ�����
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;// ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear = -1;// ָ�����β��ָ�����β������(���Ƕ������һ������)
	}

	// �ж϶����Ƿ�����
	public boolean isFull() {
		return rear == maxSize - 1;
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}

	// ������ݵ�����
	public void addQueue(int n) {
		// �ж϶����Ƿ�����
		if (isFull()) {
			System.out.println("�������ˣ���������");
			return;
		}
		rear++;// ��rear����
		arr[rear] = n;
	}

	// ��ȡ���е����ݣ�������
	public int getQueue() {
		// �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			// ͨ���׳��쳣����
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		front++;// ��front����
		return arr[front];
	}

	// ��ʾ���е���������
	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}

	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
	public int headQueue() {
		// �ж϶���Ϊ��
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		return arr[front + 1];
	}

}
