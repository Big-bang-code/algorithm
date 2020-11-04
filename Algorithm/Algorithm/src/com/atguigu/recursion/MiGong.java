package com.atguigu.recursion;

/**
 * 迷宫 使用递归为小球找路，下面使用二维数组创作地图，小球从某一个位置出发，到达最终点
 * 
 * @Title MiGong.java
 * @Description
 * @author 孟BIG
 * @date2019年9月8日
 */
public class MiGong {
	public static void main(String[] args) {
		// 先创建一个二维数组，用于模拟迷宫
		int[][] map = new int[8][7];
		// 使用1，表示墙
		// 上下为1
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		// 左右为1
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		map[3][1] = 1;
		map[3][2] = 1;

		System.out.println("地图");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		setWay(map, 1, 1);
		
		System.out.println("新的地图");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 使用递归为小球找路
	// 1.map表示地图
	// 2.i,j表示从地图的哪个位置出发
	// 3.如果小球能到map[6][5]的位置，则通过
	// 4.做约定，当地图的map[][] = 0,表示该点没有走过，当为1的时候表示墙，2表示通路，可以走，3表示该点已经走过，但是走不通
	// 5.在走迷宫时，需要确定一个策略(方法)，先走下面，再走右面，再走上面，再走左面，如果该点走不通，再回溯
	/**
	 * @param map 地图
	 * @param i   从哪个位置出发
	 * @param j
	 * @param     如果找到通路，就返回true，否则返回false
	 */

	public static boolean setWay(int[][] map, int i, int j) {
		if (map[6][5] == 2) {// 通路已经找到
			return true;
		} else {
			if (map[i][j] == 0) {// 如果当前这个点还没有走过
				// 按照策略走 下-->右-->上-->左2
				map[i][j] = 2;// 假定该点可以走遍
				if (setWay(map, i + 1, j)) {// 向下走
					return true;
				} else if (setWay(map, i, j + 1)) {// 向右走
					return true;
				} else if (setWay(map, i - 1, j)) {// 向上走
					return true;
				} else if (setWay(map, i, j - 1)) {// 向左走
					return true;
				} else {
					// 说明该点是走不通的，是
					map[i][j] = 3;
					return false;
				}
			} else {// 如果 !map[i][j]==0 ,可能是1，可能是2，可能是3
				return false;
			}
		}

	}
}
