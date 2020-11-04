package com.atguigu.linkedlist;

/**
 * ˫������
 * 
 * @Title DoubleLinkedListDemo.java
 * @Description
 * @author ��BIG
 * @date2019��8��16��
 */
public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// ����
		System.out.println("˫������Ĳ���");
		// 1.�ȴ��������ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		
		//2.����˫���������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.add(hero1);
		doubleLinkedList.add(hero2);
		doubleLinkedList.add(hero3);
		
		doubleLinkedList.list();
		
		//3.�޸Ĳ���
		HeroNode2 hero5 = new HeroNode2(2, "��¬", "С��");
		doubleLinkedList.update(hero5);
		System.out.println("�޸ĺ������");
		doubleLinkedList.list();
		
		//4.ɾ������
		doubleLinkedList.del(2);
		System.out.println("ɾ���������");
		doubleLinkedList.list();

	}

}

//����һ��˫��������
class DoubleLinkedList {
	// �ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��,����ž��������
	private HeroNode2 head = new HeroNode2(0, "", "");

	// ����ͷ�ڵ�
	public HeroNode2 getHead() {
		return head;
	}

	// ����˫������ķ���
	// ��ʾ����:����------>ͨ��һ����������������������������
	public void list() {
		// ���ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊ�գ���Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������������
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				//
				break;
			}
			// ����ڵ����Ϣ
			System.out.println(temp.toString());
			// ��temp����,������ѭ��
			temp = temp.next;

		}
	}

	// Ĭ����ӵ��������
	// ��ӽڵ㵽˫����������
	public void add(HeroNode2 heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ�����ˣ�������Ҫһ����������temp
		HeroNode2 temp = head;
		// ���������ҵ����
		while (true) {
			// �ҵ��������
			if (temp.next == null) {
				//
				break;
			}
			// ���û���ҵ����ͽ�temp����
			temp = temp.next;
		}
		// ���˳�whileѭ��ʱ��temp��ָ������������
		// �γ�һ��˫������
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	// �޸�һ���ڵ�����ݣ����Կ���˫������Ľڵ������޸ĺ͵��������һ��
	// �޸Ľڵ����Ϣ������no������޸ģ���no��Ų��ܸ�
	// ����newHeroNode �� no���޸ļ���
	public void update(HeroNode2 newHeroNode) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
		// ����һ����������
		HeroNode2 temp = head.next;
		boolean flag = false;// ��ʶ�Ƿ��ҵ��ýڵ�
		while (true) {
			if (temp == null) {
				break;// �������
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		// ����flag�ж��Ƿ��ҵ�Ҫ�޸ĵĽڵ�
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.printf("û���ҵ���� %d �Ľڵ�,�����޸�\n", newHeroNode.no);
		}
	}

	// ��˫��������ɾ��һ���ڵ�
	// ˵��
	// 1.����˫���������ǿ���ֱ���ҵ�Ҫɾ��������ڵ㣬������ɾ���ڵ����һ���ڵ�(�͵������������)
	// 2.�ҵ�������ɾ������
	public void del(int no) {

		// �жϵ�ǰ�����Ƿ�Ϊ��
		if (head.next == null) {// ������
			System.out.println("����Ϊ�գ��޷�ɾ��");
		}

		HeroNode2 temp = head.next;// ��������(ָ��)
		boolean flag = false;// ��־�Ƿ��ҵ���ɾ���ڵ�
		while (true) {
			if (temp == null) {// �Ѿ�����������ڵ��next
				break;
			}
			if (temp.no == no) {

				flag = true;
				break;
			}
			temp = temp.next;// temp���ƣ�����
		}
		// �ж�flag
		if (flag) {
			temp.pre.next = temp.next;
			// ����Ĵ������������
			// ���ɾ���������һ���ڵ�Ļ����Ͳ���Ҫִ��������仰�����������ᱨ��ָ���쳣
			// temp.next.pre = temp.pre;

			// ���ԣ�����if�ж�
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
		} else {
			System.out.printf("Ҫɾ����%d�ڵ㲻����", no);
		}
	}

}

//1.����һ��HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;// ָ����һ���ڵ����Ĭ��Ϊnull
	public HeroNode2 pre;// ָ��ǰһ���ڵ㣬Ĭ��Ϊnull

	// ������
	public HeroNode2(int hNo, String hName, String hNickname) {
		this.no = hNo;
		this.name = hName;
		this.nickname = hNickname;
	}

//	@Override
//	public String toString() {
//		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ", next=" + next + "]";
//	}

	// Ϊ����ʾ���㣬��дtoString
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}