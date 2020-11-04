package com.atguigu.recursion;
/**'
 * 8�ʺ�����
 * @Title Queue8.java
 * @Description
 * @author ��BIG
 * @date2019��9��9��
 */
public class Queue8 {
	
	//1.�ȶ���һ��max��ʾ���ж��ٸ��ʺ�
	int max = 8;
	
	//2.��������array,����ʺ����λ�õĽ��,����arr[8] = {0,4,7,5,2,6,1,3}
	int[] array = new int[max];
	static int count = 0;//ͳ���ж����ֽⷨ
	static int judgeCount = 0;
	
	//6.ִ��
	public static void main(String[] args) {
		//����
		Queue8 queue8 =new Queue8();
		queue8.check(0);
		System.out.println("һ����"+count+"�ⷨ");
		System.out.printf("һ���жϳ�ͻ��%d��",judgeCount);
	}
	
	
	//5.��дһ�����������õ�n���ʺ�
	//�ر�ע�⣺check ��ÿһ�εݹ�ʱ������check������һ��forѭ������˾��л���
	private void check(int n) {
		if(n==max) {//n=8����ʵ8���ʺ��Ѿ��ź���
			print();
			return;
		}
		//���η���ʺ󣬲��ж��Ƿ��ͻ
		for (int i = 0; i < max; i++) {
			//�Ȱѵ�ǰ�Ļʺ�n�ŵ����еĵ�1��
			array[n] = i;
			//�жϵ����õ�n���ʺ�i��ʱ���Ƿ��ͻ
			if(judge(n)) {//����ͻ
				//���ſ�ʼ�ŵ�n���ʺ󣬼���ʼ�ݹ�
				check(n+1);
			}
			//�����ͻ���ͼ���ִ�����array[n] = i;��ִ�е�n���ʺ󣬷��õ����еĺ��Ƶ�һ��λ��			
		}
	}
	
	
	
	
	
	//4.�鿴�����Ƿ��õ�n���ʺ�,��ȥ���ûʺ��Ƿ��ǰ���Ѿ��ڷŵĻʺ��ͻ
	//n��ʾ��n���ʺ�
	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) {
			//(array[i] == array[n])  ��ʾ�жϵ�n���ʺ��Ƿ��ǰ���n-1���ʺ���ͬһ��
			//(Math.abs(n-i) == Math.abs(array[n]-array[i]))  ��abs��ȡ����ֵ����ʾ�жϵ�n���ʺ��Ƿ�͵�i�ʺ��Ƿ���ͬһ��б����
			//�жϷ���ͬһ�У�û��Ҫ
			if( (array[i] == array[n]) || (Math.abs(n-i) == Math.abs(array[n]-array[i])) ) {		
				return false;
			}			
		}
		return true;
	}
	
	
	
	//3.дһ�����������Խ��ʺ�ڷŵ�λ�����
	private void print() {
		count++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	
	
}
