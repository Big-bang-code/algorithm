package com.atguigu.stack;

import java.util.Scanner;
/**
 * 	����ģ��ջ
 * @Title ArrayStackDemo.java
 * @Description
 * @author ��BIG
 * @date2019��8��29��
 */
public class ArrayStackDemo {
	public static void main(String[] args) {
		//����һ��ArrayStack�Ƿ���ȷ
		//�ȴ���һ������
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;//�����Ƿ��˳��˵�
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("push:��ʾ������ݵ�ջ");
			System.out.println("pop:��ʾ��ջ��ȡ������");
			System.out.println("show:��ʾջ");
			System.out.println("exit:�˳�����");
			System.out.println("���������ѡ��");
			key = scanner.next();
			switch (key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ����");
				int value = scanner.nextInt();
				stack.push(value);				
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ��������%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}	
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("�����˳�");
	}
}

class ArrayStack{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;//top��ʾջ�ף���ʼ��Ϊ-1
	
	//������
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize -1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ-push
	public void push(int value) {
		//���ж�ջ�Ƿ���
		if (isFull()) {
			System.out.println("ջ��");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ-pop��
	public int pop(){
		//���ж�ջ��
		if (isEmpty()) {
			//�׳��쳣
			throw new RuntimeException("ջ��");
		}
		int value = stack[top];
		top--;
		return value;		
	}
	
	//��ʾջ�����/����---->��ջ�����±���
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		for (int i = top; i >=0 ; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
}




















