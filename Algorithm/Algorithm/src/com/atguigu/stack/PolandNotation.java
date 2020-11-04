package com.atguigu.stack;
/**
 * 	1.逆波兰表达式(后缀表达式)
 * 		实现计算器
 * 
 * 	2.将中缀表达式转为后缀表达式
 * 	
 * @Title PolandNotation.java
 * @Description
 * @author 孟BIG
 * @date2019年9月5日
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class PolandNotation {
	public static void main(String[] args) {
		
		//【2】.中缀表达式转后缀表达式
		//先将中缀表达式变为对应的list
		// 1 + ( ( 2 + 3 )× 4) ) - 5   要先变成   [ 1,+,(,(,2,+,3,*,4,),-,5]  
		// 再将list变为没有括号的后缀表达式      再变成  [1,2,3,+,4,*,+,5,-]
		// 将 s2 出栈  - 5 + * 4 + 3 2 1  =>  1 2 3 + 4 * + 5 -
		String expressionString = "1+((2+3)*4)-5";
		
		List<String> infixExpressionList = toInfixExpressionList(expressionString);
		System.out.println("中缀表达式对应的List"+infixExpressionList);
		
		List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("后缀表达式对应的List"+suffixExpressionList);
		
		int res1 = calculate(suffixExpressionList);
		System.out.println("计算结果为"+res1);
		
		//【1】.完成逆波兰表达式
		//先定义一个逆波兰表达式
		/*
		 * (3+4)×5-6 对应的后缀表达式就是 3 4 + 5 × 6 - , 针对后缀表达式求值步骤如下:
		1.从左至右扫描，将3和4压入堆栈；
		2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4的值，得7，再将7入栈；
		3.将5入栈；
		4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
		5.将6入栈；
		6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果	
		 */
		
		String suffixExpresion = "3 4 + 5 * 6 -";
		//思路
		//1.先将"3 4 + 5 * 6 -" 放入ArrayList中
		//2.将ArrayList传递给一个方法，遍历ArrayzList配合栈完成计算
		List<String> rpnList = getListString(suffixExpresion);
		System.out.println(rpnList);
		
		int res = calculate(rpnList);
		System.out.println("计算的结果是"+res);
	}
	
	//2.1将中缀表达式转为对应的list
	//s就是输入的中缀表达式
	public static List<String> toInfixExpressionList(String s){
		//定义一个List，存放中缀表达式对应的数据
		List<String> ls = new ArrayList<String>();
		int i = 0;//相当于一个指针，用于遍历中缀表达式字符串
		String str;//对多位数的拼接
		char c;//每遍历一个字符，就放入c中
		do {
			//如果c是一个非数字,就需要加入ls
			if((c=s.charAt(i))<48 || (c=s.charAt(i))>57) {
				ls.add(""+c);
				i++;
			}else {//是数字，需要考虑多位数的问题
				str = "";//先将str置空
				while(i<s.length()&&(c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) {
					str += c;//拼接
					i++;
				}
				ls.add(str);
			}
		}while(i<s.length());
		return ls;
	}
	
	//2.2     [ 1,+,(,(,2,+,3,*,4,),-,5] ====》[1,2,3,+,4,*,+,5,-]
	public static List<String> parseSuffixExpressionList(List<String> ls){
		//定义两个栈
		Stack<String> s1 = new Stack<String>();//符号栈
		//因为s2在整个过程中没有pop操作(出栈),而且后续还需要逆序操作，太麻烦
		//这里就不用栈结构了，直接使用list就可以了
		//Stack<String> s2 = new Stack<String>();//存储数字
		List<String> s2 = new ArrayList<String>();
		
		//开始处理ls
		for(String item : ls) {
			//如果是一个数，入s2
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {//如果是左括号，入s1
				s1.push(item);
			}else if(item.equals(")")){//如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//将左括号弹出栈，消除小括号
			}else {
				//当item符号的优先级 【小于或等于】 栈顶运算符的优先级，将s1栈顶的运算符弹出并压入到s2中
				//当前的item的符号再与s1中新的栈顶运算符相比较，如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈
				//[缺少优先级高低的方法]
				while(s1.size() != 0 && Operation.getValue(s1.peek())>=Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				//还需要将item压入栈中
				s1.push(item);
			}
		}
		while(s1.size()!=0) {
			s2.add(s1.pop());
		}
		return s2;//因为存放在list中，因此按顺序输出，就是逆波兰表达式
	}
	
	
	
	
	//1.1将一个逆波兰表达式，一次将数据和运算符放入ArrayList中
	public static List<String> getListString(String suffixExpresion){
		//将suffixExpresion分割
		String[] split = suffixExpresion.split(" ");
		List<String> list = new ArrayList<String>();
		for(String ele:split) {
			list.add(ele);
		}
		return list;
	}
	
	//1.2完成逆波兰表达式的运算
	                   
	public static int calculate(List<String> ls) {
		//创建一个栈即可
		Stack<String> stack = new Stack<String>();
		//遍历list
		for(String item: ls) {
			//这里使用正则表达式来取出数字
			if(item.matches("\\d+")) {//匹配的是多位数
				stack.push(item);
			}else {
				//pop出两个数并运算，再入栈【num2是先弹出来的的】
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
					throw new RuntimeException("运算符有误");
				}
				//把res入栈,记得把res转为String
				stack.push(String.valueOf(res));
			}
		}
		//最后把留在栈里的res提出来，就是结果
		return Integer.parseInt(stack.pop());
	}	
}

/**
 * 	可以返回一个人运算符对应的优先级
 * @Title PolandNotation.java
 * @Description
 * @author 孟BIG
 * @date2019年9月6日
 */
class Operation{
	private static int ADD = 1;//+
	private static int SUB = 1;//-
	private static int MUL = 2;//*
	private static int DIV = 2;///
	
	//写一个方法，返回对应的优先级数字
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
			System.out.println("不存在该运算符");
			break;
		}
		return result;
	}
	
	
}
