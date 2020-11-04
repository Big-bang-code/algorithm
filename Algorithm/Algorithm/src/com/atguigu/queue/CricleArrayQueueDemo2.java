package com.atguigu.queue;

import java.util.Scanner;

/**
 * ����һ������ģ�⻷�ζ���
 * 
 * @Title CricleArrayQueueDemo.java
 * @Description
 * @author ��BIG
 * @date2019��8��5��
 */
public class CricleArrayQueueDemo2 {
	public static void main(String[] args) {
		//����һ�����ζ���
		CricleArrayQueue arrayQueue = new CricleArrayQueue(4);//��һ���յĿռ䣬�������õ�Ϊ4����������Ϊ3��
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
class CricleArrayQueue {
	private int maxSize;// ��ʾ������������
	private int[] arr;// ���������ڴ�����ݣ�ģ�����
	private int front;// front ��ָ����еĵ�һ��Ԫ��, Ҳ����˵ arr[front] ���Ƕ��еĵ�һ��Ԫ�� ,front �ĳ�ʼֵ = 0
	private int rear;// rear ָ����е����һ��Ԫ�صĺ�һ��λ��. ��Ϊϣ���ճ�һ���ռ���ΪԼ��.,rear �ĳ�ʼֵ = 0

	// 1.�������еĹ�����
	public CricleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0;
		rear = 0;

	}

	// �ж϶����Ƿ�����
	public boolean isFull() {
		return (rear+1)%maxSize == front;
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
		//ֱ�ӽ����ݼ���
		arr[rear] = n;
		//��rear���ƣ�������뿼��ȡģ
		rear = (rear+1)%maxSize;
	}

	// ��ȡ���е����ݣ�������
	public int getQueue() {
		// �ж϶����Ƿ�Ϊ��
		if (isEmpty()) {
			// ͨ���׳��쳣����
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		//������Ҫ������front��ָ����еĵ�һ��Ԫ��
		//1.�Ȱ�front��Ӧ��ֵ���浽һ����ʱ�ı���
		//2.��front����,����ȡģ
		//3.����ʱ����ı�������
		int value = arr[front];
		front = (front + 1)%maxSize;
		return value;
	}

	// ��ʾ���е���������
	public void showQueue() {
		// ����
		if (isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return;
		}
		//��front��ʼ�������������ٸ�Ԫ��
		//
		for (int i = front; i < front+size(); i++) {
			System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i]);
		}
	}

	//�����ǰ������Ч���ݵĸ���
	public int size() {
		return (rear+maxSize-front)%maxSize;
	}
	
	// ��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
	public int headQueue() {
		// �ж϶���Ϊ��
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
		return arr[front];
	}

}
