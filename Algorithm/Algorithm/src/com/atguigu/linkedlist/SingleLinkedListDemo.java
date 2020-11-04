package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * ������
 * 
 * @Title SingleLinkedList.java
 * @Description
 * @author ��BIG
 * @date2019��8��6��
 */

public class SingleLinkedListDemo {
	public static void main(String[] args) {
		// ���в��ԣ�
		// 1.�ȴ��������ڵ�
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");

		// 2.����һ������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		// ����
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);

		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero2);

		// �����޸Ľڵ�Ĵ���

		HeroNode newHeroNode = new HeroNode(2, "С¬", "���");
		singleLinkedList.update(newHeroNode);

		singleLinkedList.list();
		System.out.println("*********");

//		System.out.println(singleLinkedList.getClass().getClass());
//		System.out.println(hero1.next);
//		System.out.println(hero2);

		singleLinkedList.del(2);
		singleLinkedList.list();

		//�����������е���Ч�ڵ�ĸ���
		System.out.println(getLength(singleLinkedList.getHead()));
		
		//�����Ƿ�õ�������k���ڵ�
		HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
		System.out.println(res);
		
		//���Է�ת		
		System.out.println("��ת");
		//reversetList(singleLinkedList.getHead());
		
		//���������ӡwww
		reversePrint(singleLinkedList.getHead());
		
	}

	// ��������ȡ������Ľڵ�ĸ���() ����Ǵ�ͷ�ڵ��������Ҫ��ͳ��ͷ�ڵ�
	/**
	 * 
	 * Title:getLength
	 * 
	 * @return ������Ч�����Ľڵ�
	 */
	public static int getLength(HeroNode head) {
		if (head.next == null) {
			return 0;
		}
		int length = 0;
		// ����û��ͳ��ͷ�ڵ�
		HeroNode cur = head.next;
		while (cur != null) {
			length++;
			cur = cur.next;// ����
		}
		return length;
	}
	
	//���ҵ�����ĵ�����k���ڵ�
	//˼·
	//1.��дһ������������head�ڵ㣬ͬʱ����һ��index
	//2.index��ʾ�ǵ�����index���ڵ�
	//3.�Ȱ������ͷ��β�������õ�������ܵĳ���size------->getlength
	//4.�õ�size�����Ǵ������һ����ʼ����(size-index)��
	//5.����ҵ��ˣ��򷵻ظýڵ㣬���򷵻�null
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		//�жϣ��������Ϊ�գ�����null
		if(head.next == null) {
			return null;//û���ҵ�
		}
		//��һ�������õ�����ĳ���(�ڵ����)
		int size = getLength(head);
		//�ڶ��α��� size-indexλ�ã�����ǵ����ĵ�k���ڵ�
		//����һ��index��У��
		if(index<=0||index>size) {
			return null;
		}
		//����һ����������,forѭ����λ��������index
		HeroNode cur = head.next;
		for(int i=0;i<size-index;i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	//��ת������
	public static void reversetList(HeroNode head) {
		//�����ǰ����Ϊ�գ���ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
		if(head.next == null || head.next.next ==null) {
			return;
		}
		//����һ������ָ��(����)���������Ǳ���ԭ��������
		HeroNode cur = head.next;
		HeroNode next = null;//ָ��ǰ�ڵ�[cur]����һ���ڵ�
		HeroNode reverseHead = new HeroNode(0,"","");//�ÿսڵ����ڽ��շ�ת�Ľڵ�
		
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ�����reverseHead����ǰ��
		while(cur!=null) {
			next = cur.next;//����ʱ���浱ǰ�ڵ����һ���ڵ㣬��Ϊ����Ҫ��
			cur.next = reverseHead.next;//��cur����һ���ڵ�ָ���µ��������ǰ��
			reverseHead.next = cur;
			cur = next;//��cur����
		}
		//��head.nextָ��reversetList.next,ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
	}
	
	//��β��ͷ��ӡ������Ҫ�󣺷�ʽһ�����������  ��ʽ��  Stackջ
	// ��ʽ1�� �Ƚ���������з�ת������Ȼ���ٱ������ɣ����������������ǻ��ƻ�ԭ���ĵ�����Ľṹ��������
	//��ʽ2����������ջ������ݽṹ���������ڵ�ѹ�뵽ջ�У�Ȼ������ջ���Ƚ�������ص㣬��ʵ���������ӡ��Ч��.������ʾջ��ʹ�� Stack 
	
	public static void reversePrint(HeroNode head) {
		if (head.next == null) {
			return;//������
		}
		//����һ��ջ���������ڵ�ѹ��ջ��
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur= head.next;
		//����������нڵ�ѹ��ջ��
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;//��cur���ƣ������Ϳ���ѹ����һ���ڵ�
		}
		//��ջ�еĽڵ���д�ӡ��pop��ջ
		while(stack.size()>0) {
			System.out.println(stack.pop());//stack���ص����Ƚ����
		}
	}
	
}




//2.����SingleLinkedList   �������ǵ�Ӣ��
class SingleLinkedList {
	// �ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��,����ž��������
	private HeroNode head = new HeroNode(0, "", "");

	// ����ͷ�ڵ�
	public HeroNode getHead() {
		return head;
	}

	// ��ӽڵ㵽��������
	// ˼·���������Ǳ��˳��ʱ
	// 1.�ҵ���ǰ��������ڵ�
	// 2.���������ڵ��next ָ���µĽڵ�
	public void add(HeroNode heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ�����ˣ�������Ҫһ����������temp
		HeroNode temp = head;
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
		// ���������ڵ��next ָ���µĽڵ�
		temp.next = heroNode;
	}

	// �ڶ��ַ�ʽ���Ӣ�ۣ�����������Ӣ�۲��뵽ָ��λ��
	public void addByOrder(HeroNode heroNode) {
		// ��Ϊͷ�ڵ㲻�ܶ������������Ȼͨ��һ������ָ���������ҵ���ӵ�λ��
		// ��Ϊ��������������ҵ�temp��λ�����λ�õ�ǰһ���ڵ㣬������벻��
		HeroNode temp = head;
		boolean flag = false;// ��ʶ��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
		while (true) {
			if (temp.next == null) {// ˵��temp������������
				break;
			}
			if (temp.next.no > heroNode.no) {// λ���ҵ��ˣ�����temp�ĺ������
				break;
			} else if (temp.next.no == heroNode.no) {// ˵��ϣ����ӵ�heroNode�ı���Ѿ�����
				flag = true;// ˵����Ŵ���
				break;
			}
			temp = temp.next;// ���ƣ�������ǰ����
		}
		// �ж�flag��ֵ
		if (flag) {// ������ӣ�˵����Ŵ���
			System.out.printf("׼�������Ӣ�۵ı��%d�Ѿ����ڣ��������\n", heroNode.no);
		} else {
			// ���뵽�����У�temp����
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
	}

	// �޸Ľڵ����Ϣ������no������޸ģ���no��Ų��ܸ�
	// ����newHeroNode �� no���޸ļ���
	public void update(HeroNode newHeroNode) {
		// �ж��Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// �ҵ���Ҫ�޸ĵĽڵ㣬����no���
		// ����һ����������
		HeroNode temp = head.next;
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

	// ɾ���ڵ�
	// ˼·��
	// 1.head���ܶ��������Ҫtemp�����ڵ��ҵ���ɾ���ڵ��ǰһ���ڵ�
	// 2.�����ڱȽ�ʱ����temp.next.no����Ҫɾ���Ľڵ��no���бȽ�
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;// ��־�Ƿ��ҵ���ɾ���ڵ�
		while (true) {
			if (temp.next == null) {// �Ѿ�����������
				break;
			}
			if (temp.next.no == no) {
				// �ҵ��˴�ɾ���ڵ��ǰһ���ڵ�
				flag = true;
				break;
			}
			temp = temp.next;// temp���ƣ�����
		}
		// �ж�flag
		if (flag) {
			// �ҵ�������ɾ��
			temp.next = temp.next.next;
		} else {
			System.out.printf("Ҫɾ����%d�ڵ㲻����", no);
		}
	}

	// ��ʾ����:����------>ͨ��һ����������������������������
	public void list() {
		// ���ж������Ƿ�Ϊ��
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		// ��Ϊ�գ���Ϊͷ�ڵ㲻�ܶ������������Ҫһ����������������
		HeroNode temp = head.next;
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

}

//1.����һ��HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;// ָ����һ���ڵ����

	// ������
	public HeroNode(int hNo, String hName, String hNickname) {
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
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}

}