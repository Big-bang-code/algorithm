package com.atguigu.stack;
/**
 * 	用栈实现计算器
 * 1.一位数的实现
 * 2.多位数的改进
 * @Title Calculator.java
 * @Description
 * @author 孟BIG
 * @date2019年9月2日
 */
public class Calculator {
	public static void main(String[] args) {
		String expression = "30+2*6-200";
		//创建两个栈，数栈，和符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		
		//定义相关的变量
		int index = 0;//用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';//将每次扫描得到的char保存到ch
		String keepNum = "";//用于拼接多位数
		
		//开始while循环的扫描expression
		while(true) {
			//依次得到expression的每一个字符4
			ch = expression.substring(index,index+1).charAt(0);
			if(operStack.isOper(ch)) {//如果是运算符
				//判断当前的符号栈是否为空
				if(!operStack.isEmpty()) {//如果符号栈有操作符，就进行比较,
					//如果当前的操作符的优先级小于或者等于栈中的操作符， 就需要从数栈中pop出两个数,
					//在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈， 
					if(operStack.priority(ch)<=operStack.priority(operStack.peek())) {
						 //就需要从数栈中pop出两个数,在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						//把运算的结果入数栈
						numStack.push(res);
						//然后将当前的操作符入符号栈
						operStack.push(ch);						
					}
					//如果当前的操作符的优先级大于栈中的操作符， 就直接入符号栈.
					else {
						operStack.push(ch);
					}	
				}else {
					//如果为空，直接入栈
					operStack.push(ch);
				}
				
			}else {//如果是数，则直接入数栈
				//我们这里实现了一位数的
				//numStack.push(ch-48);//这里ch的数字是ASCII表中的，所以要减去48			
				
				/*	现在，考虑多位数的情况
				 *		1.当处理多位数时，不能发现是一个数立马入栈，因为它可能是多位数
				 *		2.在处理数时，需要向express的表达式后再看一位，如果是数，就继续扫描，如果是符号，才入栈
				 *		3.因此，我们需要定义一个变量  字符串，用于拼接 
				 */
				//处理多位数
				keepNum += ch;
				
				//如果ch已经是expression的最后一位，就直接入栈
				if (index == expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					//判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
					if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
						//如果后一位是运算符，则入栈
						numStack.push(Integer.parseInt(keepNum));
						//重要！！！重要！！！，keepNum要清空
						keepNum ="";
					}
				}				
			}
			//让index+1，并判断是否扫描到expression最后
			index++;
			if(index>=expression.length()) {
				break;
			}
		}
		//开始计算
		while(true) {
			//可以根据符号栈最后为空，来判断计算到最后结果;
			if(operStack.isEmpty()) {
				break;
			}
			
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		System.out.printf("表达式%s=%d",expression,numStack.pop());
	}
}

//先创建一个栈，直接使用前面创建好的，但还是需要扩展功能
class ArrayStack2{
	private int maxSize;//栈的大小
	private int[] stack;//数组，数组模拟栈，数据就放在该数组
	private int top = -1;//top表示栈底，初始化为-1
	
	//构造器
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
	public int peek() {
		return stack[top];
	}
	
	//栈满
	public boolean isFull() {
		return top == maxSize -1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈-push
	public void push(int value) {
		//先判断栈是否满
		if (isFull()) {
			System.out.println("栈满");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//出栈-pop，
	public int pop(){
		//先判断栈空
		if (isEmpty()) {
			//抛出异常
			throw new RuntimeException("栈空");
		}
		int value = stack[top];
		top--;
		return value;		
	}
	
	//显示栈的情况/遍历---->从栈顶向下遍历
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		for (int i = top; i >=0 ; i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	//返回运算符的优先级，这个优先级是由程序员确定的---->优先级使用数字表示，数字越大优先级越高
	public int priority(int oper) {
		if (oper == '*' || oper == '/') {
			return 1;
		}else if(oper =='+' || oper=='-') {
			return 0;
		}else {
			return -1;//假定目前的表达式只有+ - * / 
		}
	}
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val == '+' || val =='-' || val =='*' || val=='/';
	}
	
	//计算方法
	public int cal(int num1,int num2,int oper) {
		int res = 0;//res 用于存放计算的结果
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