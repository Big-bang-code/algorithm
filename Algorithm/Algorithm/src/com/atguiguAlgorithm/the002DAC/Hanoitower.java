package com.atguiguAlgorithm.the002DAC;
/**
 * ��ŵ���ƶ�����
 * @Title Hanoitwer.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��22��
 */
public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoiTower(2,'A','B','C');
	}

	
	//��ŵ���ƶ�����
	//ʹ�÷����㷨
	/**
	 * 
	 * @param num	һ���ж��ٸ�����
	 * @param a		����
	 * @param b
	 * @param c
	 * Title:hanoiTower
	 */
	public static void hanoiTower(int num,char a,char b,char c) {
		
		if(num == 1) {
			System.out.println("��1���̴� "+a+"-->"+c);
		} else {
			//��������� n >= 2 ������������ǿ��Կ����������� 1.���±ߵ�һ���� 2. �����������
			
			//1.�Ȱ� ��������� A->B ���ƶ����̻�ʹ�õ�c
			hanoiTower(num-1, a, c, b);
						
			//2.�����±ߵ��� A->C
			System.out.println("��"+num+"���̴� "+a+"-->"+c);
			
			//3.��B���������� �� B->C  ,�ƶ�����ʹ�õ�a�� 
			hanoiTower(num-1, b, a, c);
			
		}
		
		
	}
	
	
	
}
