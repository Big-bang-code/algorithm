package com.atguigu.recursion;

/**
 * �Թ� ʹ�õݹ�ΪС����·������ʹ�ö�ά���鴴����ͼ��С���ĳһ��λ�ó������������յ�
 * 
 * @Title MiGong.java
 * @Description
 * @author ��BIG
 * @date2019��9��8��
 */
public class MiGong {
	public static void main(String[] args) {
		// �ȴ���һ����ά���飬����ģ���Թ�
		int[][] map = new int[8][7];
		// ʹ��1����ʾǽ
		// ����Ϊ1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		// ����Ϊ1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;

		System.out.println("��ͼ");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		setWay(map, 1, 1);
		
		System.out.println("�µĵ�ͼ");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// ʹ�õݹ�ΪС����·
	// 1.map��ʾ��ͼ
	// 2.i,j��ʾ�ӵ�ͼ���ĸ�λ�ó���
	// 3.���С���ܵ�map[6][5]��λ�ã���ͨ��
	// 4.��Լ��������ͼ��map[][] = 0,��ʾ�õ�û���߹�����Ϊ1��ʱ���ʾǽ��2��ʾͨ·�������ߣ�3��ʾ�õ��Ѿ��߹��������߲�ͨ
	// 5.�����Թ�ʱ����Ҫȷ��һ������(����)���������棬�������棬�������棬�������棬����õ��߲�ͨ���ٻ���
	/**
	 * @param map ��ͼ
	 * @param i   ���ĸ�λ�ó���
	 * @param j
	 * @param     ����ҵ�ͨ·���ͷ���true�����򷵻�false
	 */

	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// ͨ·�Ѿ��ҵ�
			return true;
		} else {
			if (map[i][j] == 0) {// �����ǰ����㻹û���߹�
				// ���ղ����� ��-->��-->��-->��2
				map[i][j] = 2;// �ٶ��õ�����߱�
				if (setWay(map, i + 1, j)) {// ������
					return true;
				} else if (setWay(map, i, j + 1)) {// ������
					return true;
				} else if (setWay(map, i - 1, j)) {// ������
					return true;
				} else if (setWay(map, i, j - 1)) {// ������
					return true;
				} else {
					// ˵���õ����߲�ͨ�ģ���
					map[i][j] = 3;
					return false;
				}
			} else {// ��� !map[i][j]==0 ,������1��������2��������3
				return false;
			}
		}

	}
}
