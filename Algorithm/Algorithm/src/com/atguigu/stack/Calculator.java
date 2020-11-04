package com.atguigu.stack;
/**
 * 	��ջʵ�ּ�����
 * 1.һλ����ʵ��
 * 2.��λ���ĸĽ�
 * @Title Calculator.java
 * @Description
 * @author ��BIG
 * @date2019��9��2��
 */
public class Calculator {
	public static void main(String[] args) {
		String expression = "30+2*6-200";
		//��������ջ����ջ���ͷ���ջ
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		
		//������صı���
		int index = 0;//����ɨ��
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//��ÿ��ɨ��õ���char���浽ch
		String keepNum = "";//����ƴ�Ӷ�λ��
		
		//��ʼwhileѭ����ɨ��expression
		while(true) {
			//���εõ�expression��ÿһ���ַ�4
			ch = expression.substring(index,index+1).charAt(0);
			if(operStack.isOper(ch)) {//����������
				//�жϵ�ǰ�ķ���ջ�Ƿ�Ϊ��
				if(!operStack.isEmpty()) {//�������ջ�в��������ͽ��бȽ�,
					//�����ǰ�Ĳ����������ȼ�С�ڻ��ߵ���ջ�еĲ������� ����Ҫ����ջ��pop��������,
					//�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ�� 
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						 //����Ҫ����ջ��pop��������,�ڴӷ���ջ��pop��һ�����ţ��������㣬���õ����������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//������Ľ������ջ
						numStack.push(res);
						//Ȼ�󽫵�ǰ�Ĳ����������ջ
						operStack.push(ch);						
					}
					//�����ǰ�Ĳ����������ȼ�����ջ�еĲ������� ��ֱ�������ջ.
					else {
						operStack.push(ch);
					}	
				}else {
					//���Ϊ�գ�ֱ����ջ
					operStack.push(ch);
				}
				
			}else {//�����������ֱ������ջ
				//��������ʵ����һλ����
				//numStack.push(ch-48);//����ch��������ASCII���еģ�����Ҫ��ȥ48			
				
				/*	���ڣ����Ƕ�λ�������
				 *		1.�������λ��ʱ�����ܷ�����һ����������ջ����Ϊ�������Ƕ�λ��
				 *		2.�ڴ�����ʱ����Ҫ��express�ı��ʽ���ٿ�һλ������������ͼ���ɨ�裬����Ƿ��ţ�����ջ
				 *		3.��ˣ�������Ҫ����һ������  �ַ���������ƴ�� 
				 */
				//�����λ��
				keepNum += ch;
				
				//���ch�Ѿ���expression�����һλ����ֱ����ջ
				if (index == expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					//�ж���һ���ַ��ǲ������֣���������֣��ͼ���ɨ�裬����������������ջ
					if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//�����һλ�������������ջ
						numStack.push(Integer.parseInt(keepNum));
						//��Ҫ��������Ҫ��������keepNumҪ���
						keepNum ="";
					}
				}				
			}
			//��index+1�����ж��Ƿ�ɨ�赽expression���
			index++;
			if(index>=expression.length()) {
				break;
			}
		}
		//��ʼ����
		while(true) {
			//���Ը��ݷ���ջ���Ϊ�գ����жϼ��㵽�����;
			if(operStack.isEmpty()) {
				break;
			}
			
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		System.out.printf("���ʽ%s=%d",expression,numStack.pop());
	}
}

//�ȴ���һ��ջ��ֱ��ʹ��ǰ�洴���õģ���������Ҫ��չ����
class ArrayStack2{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ��ջ�����ݾͷ��ڸ�����
	private int top = -1;//top��ʾջ�ף���ʼ��Ϊ-1
	
	//������
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//����һ�����������Է��ص�ǰջ����ֵ�����ǲ���������pop
	public int peek() {
		return stack[top];
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
	//��������������ȼ���������ȼ����ɳ���Աȷ����---->���ȼ�ʹ�����ֱ�ʾ������Խ�����ȼ�Խ��
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}else if(oper =='+' || oper=='-') {
			return 0;
		}else {
			return -1;//�ٶ�Ŀǰ�ı��ʽֻ��+ - * / 
		}
	}
	//�ж��ǲ���һ�������
	public boolean isOper(char val) {
		return val == '+' || val =='-' || val =='*' || val=='/';
	}
	
	//���㷽��
	public int cal(int num1,int num2,int oper) {
		int res = 0;//res ���ڴ�ż���Ľ��
		switch (oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
	}
	
}