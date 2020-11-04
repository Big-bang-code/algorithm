package com.atguigu.stack;
/**
 * 	1.�沨�����ʽ(��׺���ʽ)
 * 		ʵ�ּ�����
 * 
 * 	2.����׺���ʽתΪ��׺���ʽ
 * 	
 * @Title PolandNotation.java
 * @Description
 * @author ��BIG
 * @date2019��9��5��
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class PolandNotation {
	public static void main(String[] args) {
		
		//��2��.��׺���ʽת��׺���ʽ
		//�Ƚ���׺���ʽ��Ϊ��Ӧ��list
		// 1 + ( ( 2 + 3 )�� 4) ) - 5   Ҫ�ȱ��   [ 1,+,(,(,2,+,3,*,4,),-,5]  
		// �ٽ�list��Ϊû�����ŵĺ�׺���ʽ      �ٱ��  [1,2,3,+,4,*,+,5,-]
		// �� s2 ��ջ  - 5 + * 4 + 3 2 1  =>  1 2 3 + 4 * + 5 -
		String expressionString = "1+((2+3)*4)-5";
		
		List<String> infixExpressionList = toInfixExpressionList(expressionString);
		System.out.println("��׺���ʽ��Ӧ��List"+infixExpressionList);
		
		List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("��׺���ʽ��Ӧ��List"+suffixExpressionList);
		
		int res1 = calculate(suffixExpressionList);
		System.out.println("������Ϊ"+res1);
		
		//��1��.����沨�����ʽ
		//�ȶ���һ���沨�����ʽ
		/*
		 * (3+4)��5-6 ��Ӧ�ĺ�׺���ʽ���� 3 4 + 5 �� 6 - , ��Ժ�׺���ʽ��ֵ��������:
		1.��������ɨ�裬��3��4ѹ���ջ��
		2.����+���������˵���4��3��4Ϊջ��Ԫ�أ�3Ϊ�ζ�Ԫ�أ��������3+4��ֵ����7���ٽ�7��ջ��
		3.��5��ջ��
		4.�������ǡ����������˵���5��7�������7��5=35����35��ջ��
		5.��6��ջ��
		6.�����-������������35-6��ֵ����29���ɴ˵ó����ս��	
		 */
		
		String suffixExpresion = "3 4 + 5 * 6 -";
		//˼·
		//1.�Ƚ�"3 4 + 5 * 6 -" ����ArrayList��
		//2.��ArrayList���ݸ�һ������������ArrayzList���ջ��ɼ���
		List<String> rpnList = getListString(suffixExpresion);
		System.out.println(rpnList);
		
		int res = calculate(rpnList);
		System.out.println("����Ľ����"+res);
	}
	
	//2.1����׺���ʽתΪ��Ӧ��list
	//s�����������׺���ʽ
	public static List<String> toInfixExpressionList(String s){
		//����һ��List�������׺���ʽ��Ӧ������
		List<String> ls = new ArrayList<String>();
		int i = 0;//�൱��һ��ָ�룬���ڱ�����׺���ʽ�ַ���
		String str;//�Զ�λ����ƴ��
		char c;//ÿ����һ���ַ����ͷ���c��
		do {
			//���c��һ��������,����Ҫ����ls
			if((c=s.charAt(i))<48 || (c=s.charAt(i))>57) {
				ls.add(""+c);
				i++;
			}else {//�����֣���Ҫ���Ƕ�λ��������
				str = "";//�Ƚ�str�ÿ�
				while(i<s.length()&&(c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) {
					str += c;//ƴ��
					i++;
				}
				ls.add(str);
			}
		}while(i<s.length());
		return ls;
	}
	
	//2.2     [ 1,+,(,(,2,+,3,*,4,),-,5] ====��[1,2,3,+,4,*,+,5,-]
	public static List<String> parseSuffixExpressionList(List<String> ls){
		//��������ջ
		Stack<String> s1 = new Stack<String>();//����ջ
		//��Ϊs2������������û��pop����(��ջ),���Һ�������Ҫ���������̫�鷳
		//����Ͳ���ջ�ṹ�ˣ�ֱ��ʹ��list�Ϳ�����
		//Stack<String> s2 = new Stack<String>();//�洢����
		List<String> s2 = new ArrayList<String>();
		
		//��ʼ����ls
		for(String item : ls) {
			//�����һ��������s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {//����������ţ���s1
				s1.push(item);
			}else if(item.equals(")")){//����������š�)���������ε���s1ջ�������������ѹ��s2��ֱ������������Ϊֹ����ʱ����һ�����Ŷ���
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//�������ŵ���ջ������С����
			}else {
				//��item���ŵ����ȼ� ��С�ڻ���ڡ� ջ������������ȼ�����s1ջ���������������ѹ�뵽s2��
				//��ǰ��item�ķ�������s1���µ�ջ���������Ƚϣ����s1Ϊ�գ���ջ�������Ϊ�����š�(������ֱ�ӽ����������ջ
				//[ȱ�����ȼ��ߵ͵ķ���]
				while(s1.size() != 0 && Operation.getValue(s1.peek())>=Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				//����Ҫ��itemѹ��ջ��
				s1.push(item);
			}
		}
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;//��Ϊ�����list�У���˰�˳������������沨�����ʽ
	}
	
	
	
	
	//1.1��һ���沨�����ʽ��һ�ν����ݺ����������ArrayList��
	public static List<String> getListString(String suffixExpresion){
		//��suffixExpresion�ָ�
		String[] split = suffixExpresion.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
	}
	
	//1.2����沨�����ʽ������
	                   
	public static int calculate(List<String> ls) {
		//����һ��ջ����
		Stack<String> stack = new Stack<String>();
		//����list
		for(String item: ls) {
			//����ʹ��������ʽ��ȡ������
			if(item.matches("\\d+")) {//ƥ����Ƕ�λ��
				stack.push(item);
			}else {
				//pop�������������㣬����ջ��num2���ȵ������ĵġ�
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) {
					res = num1 + num2;
				}else if(item.equals("-")) {
					res = num1 - num2;
				}else if(item.equals("*")) {
					res = num1 * num2;
				}else if(item.equals("/")) {
					res = num1 / num2;
				}else {
					throw new RuntimeException("���������");
				}
				//��res��ջ,�ǵð�resתΪString
				stack.push(String.valueOf(res));
			}
		}
		//��������ջ���res����������ǽ��
		return Integer.parseInt(stack.pop());
	}	
}

/**
 * 	���Է���һ�����������Ӧ�����ȼ�
 * @Title PolandNotation.java
 * @Description
 * @author ��BIG
 * @date2019��9��6��
 */
class Operation{
	private static int ADD = 1;//+
	private static int SUB = 1;//-
	private static int MUL = 2;//*
	private static int DIV = 2;///
	
	//дһ�����������ض�Ӧ�����ȼ�����
	public static int getValue(String operator) {
		int result = 0;
		switch(operator){
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("�����ڸ������");
			break;
		}
		return result;
	}
	
	
}
