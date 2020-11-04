package com.atguigu.recursion;
/**'
 * 8皇后问题
 * @Title Queue8.java
 * @Description
 * @author 孟BIG
 * @date2019年9月9日
 */
public class Queue8 {
	
	//1.先定义一个max表示共有多少个皇后
	int max = 8;
	
	//2.定义数组array,保存皇后放置位置的结果,比如arr[8] = {0,4,7,5,2,6,1,3}
	int[] array = new int[max];
	static int count = 0;//统计有多少种解法
	static int judgeCount = 0;
	
	//6.执行
	public static void main(String[] args) {
		//测试
		Queue8 queue8 =new Queue8();
		queue8.check(0);
		System.out.println("一共有"+count+"解法");
		System.out.printf("一共判断冲突有%d次",judgeCount);
	}
	
	
	//5.编写一个方法，放置第n个皇后
	//特别注意：check 是每一次递归时，进入check，都有一次for循环，因此就有回溯
	private void check(int n) {
		if(n==max) {//n=8，其实8个皇后已经放好了
			print();
			return;
		}
		//依次放入皇后，并判断是否冲突
		for (int i = 0; i < max; i++) {
			//先把当前的皇后n放到该行的第1列
			array[n] = i;
			//判断当放置第n个皇后到i列时，是否冲突
			if(judge(n)) {//不冲突
				//接着开始放第n个皇后，即开始递归
				check(n+1);
			}
			//如果冲突，就继续执行这个array[n] = i;即执行第n个皇后，放置到本行的后移的一个位置			
		}
	}
	
	
	
	
	
	//4.查看当我们放置第n个皇后,就去检测该皇后是否和前面已经摆放的皇后冲突
	//n表示第n个皇后
	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			//(array[i] == array[n])  表示判断第n个皇后是否和前面的n-1个皇后是同一列
			//(Math.abs(n-i) == Math.abs(array[n]-array[i]))  【abs是取绝对值】表示判断第n个皇后是否和第i皇后是否在同一条斜线上
			//判断放在同一行，没必要
			if( (array[i] == array[n]) || (Math.abs(n-i) == Math.abs(array[n]-array[i])) ) {		
				return false;
			}			
		}
		return true;
	}
	
	
	
	//3.写一个方法，可以将皇后摆放的位置输出
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	
}
