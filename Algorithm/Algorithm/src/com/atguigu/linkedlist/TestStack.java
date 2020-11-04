package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * 	演示栈的基本使用
 * @Title TestStack.java
 * @Description
 * @author 孟BIG
 * @date2019年8月15日
 */
public class TestStack {
	public static void main(String[] args) {
		Stack<String> stack = new Stack();
		stack.add("jack");
		stack.add("Smith");
		stack.add("tom");
		
		while(stack.size()>0) {
			System.out.println(stack.pop());//pop就是将栈顶的数据取出
		}
	}
}
