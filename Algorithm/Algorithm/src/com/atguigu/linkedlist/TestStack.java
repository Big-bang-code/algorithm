package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * 	��ʾջ�Ļ���ʹ��
 * @Title TestStack.java
 * @Description
 * @author ��BIG
 * @date2019��8��15��
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		stack.add("jack");
		stack.add("Smith");
		stack.add("tom");
		
		while(stack.size()>0) {
			System.out.println(stack.pop());//pop���ǽ�ջ��������ȡ��
		}
	}
}
