package com.atguigu.linkedlist;
/**
 * Լɪ������  ����������
 * Josephu  ����Ϊ������Ϊ1��2���� n��n����Χ��һȦ��
 * Լ�����Ϊk��1<=k<=n�����˴�1��ʼ����������m ���Ǹ��˳��У�
 * ������һλ�ִ�1��ʼ����������m���Ǹ����ֳ��У�
 * �������ƣ�ֱ�������˳���Ϊֹ���ɴ˲���һ�����ӱ�ŵ����С�
	n = 5 , ����5���� 
	k = 1, �ӵ�һ���˿�ʼ����
	m = 2, ��2��
 * @Title Josepfu.java
 * @Description
 * @author ��BIG
 * @date2019��8��26��
 */
public class Josepfu {
	//����
	public static void main(String[] args) {
		CricleSingleLinkedList c1 = new CricleSingleLinkedList();
		c1.addBoy(5);
		c1.showBoy();
		
		
		c1.countBoy(1, 2, 5);
		
		
		CricleSingleLinkedList c2 = new CricleSingleLinkedList();
		c2.showBoy();
	}
}
/**
 * ����һ�����εĵ�������
 */
class CricleSingleLinkedList{
	//����һ��first�ڵ㣬���ǲ�Ҫ��ֵ
	private Boy first= new Boy(-1);
	
	//���С���ڵ㣬���ɻ�������[ֱ��ȷ����ӵĽڵ����]
	public void addBoy(int nums) {
		//nums ��һ������У��
		if(nums<1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy = null;//����ָ�룬����������������
		//ʹ��for������������
		for (int i = 1; i <= nums; i++) {
			//���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			//����ǵ�һ��С��
			if(i==1) {
				first = boy;
				first.setNextBoy(first);//ֻ��һ��BoyҲ���ɻ�
				curBoy = first;//��curBoyָ���һ��С��
			}else {
				curBoy.setNextBoy(boy);
				boy.setNextBoy(first);
				curBoy = boy;
			}			
		}
	}
	
	//������ǰ����������CurBoy���б���
	public void showBoy() {
		//���ж������Ƿ�Ϊ��
		if(first.getNextBoy() == null) {
			System.out.println("����Ϊ��");
			return;
		}
		//��Ϊfirst���ܶ��������Ȼʹ��һ������ָ����ɱ���
		Boy curBoy = first;
		while(true) {
			System.out.printf("С���ı��%d \n",curBoy.getNo());
			if (curBoy.getNextBoy() == first) {//˵���������
				break;
			}
			curBoy = curBoy.getNextBoy();//��curBoy����
		}
	}
	
	//�����û������룬�������Ȧ��˳��
	/**
	 * 
	 * Title:countBoy
	 * @param startNo  ��ʾ�ӵڼ���С����ʼ������
	 * @param countNum ��ʾ������
	 * @param nums	   ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo,int countNum,int nums) {
		//�ȶ����ݽ���У��
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("������������");
			return;
		}
		//����һ������ָ�룬�������С����Ȧ
		Boy helper = first;
		//���󴴽�һ������ָ��(����) helper , ����Ӧ��ָ����������������ڵ�.
		while(true) {
			if (helper.getNextBoy() == first) {//˵��helperָ�����С���ڵ�
				break;
			}
			helper = helper.getNextBoy();
		}
		//С������ǰ������first��helper�ƶ���k-1��
		for(int j = 0;j<startNo-1;j++) {
			first = first.getNextBoy();
			helper = helper.getNextBoy();
		}
		//��С������ʱ����first �� helper ָ��ͬʱ ���ƶ�  m  - 1 ��,Ȼ���Ȧ
		//����һ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
		while(true) {
			if(helper==first) {//˵��Ȧ��ֻ��һ���ڵ�
				break;
			}
			//��first��helperָ��ͬʱ�ƶ� countNum-1
			for (int j = 0; j < countNum-1; j++) {
				first = first.getNextBoy();
				helper = helper.getNextBoy();
			}
			//��ʱfirstָ��Ľڵ㣬����Ҫ��Ȧ��С���ڵ�
			System.out.printf("С����Ȧ%d \n",first.getNo());
			//��ʱ��firstָ���С����Ȧ
			first = first.getNextBoy();
			helper.setNextBoy(first);
		}
		System.out.printf("�������Ȧ�е�С�����%d \n",first.getNo());
	}
}


/**
 * ����һ��boy�࣬��ʾһ���ڵ�
 * @Title Josepfu.java
 * @Description
 * @author ��BIG
 * @date2019��8��26��
 */
class Boy{
	private int no;//���
	private Boy nextBoy;//ָ����һ���ڵ�
	public Boy(int no) {
		this.no = no;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public Boy getNextBoy() {
		return nextBoy;
	}
	public void setNextBoy(Boy nextBoy) {
		this.nextBoy = nextBoy;
	}	
}