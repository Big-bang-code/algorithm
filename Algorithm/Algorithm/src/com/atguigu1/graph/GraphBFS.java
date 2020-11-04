package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphBFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试图
		//int n = 5;//5个结点
		String VertexValue[] = {"A","B","C","D","E"};
		//创建图对象
		GraphBFS graphbfs = new GraphBFS(5);
		//循环添加顶点
		for(String vertex:VertexValue) {
			graphbfs.insertVertex(vertex);
		}
		//添加边
		//AB  AC  BC  BD  BE
		graphbfs.insertEdge(0, 1, 1);
		graphbfs.insertEdge(0, 2, 1);
		graphbfs.insertEdge(1, 2, 1);
		graphbfs.insertEdge(1, 3, 1);
		graphbfs.insertEdge(1, 4, 1);
		
		graphbfs.showGraph();
		System.out.println(graphbfs.getNumOfEdge());
	
		System.out.println(graphbfs.getValueByIndex(1));
		
		System.out.println("广度优先");
		graphbfs.bfs();
	}
	
	private ArrayList<String> vertexList;//存储顶点集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numOfEdges;//表示边的数目
	
	//定义数组boolean[],记录某个结点是否被访问
	private boolean[] isVisited;
	
	//构造器    n表示点的个数
	public GraphBFS(int n) {
		//初始化矩阵和vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0; //默认边为0
		
		isVisited = new boolean[n];
	}
	
	//插入结点
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//添加边
	/**
	 * 
	 * @param v1  表示点的下标，即第几个顶点，“A”-“B” “A”->0   "B"->1
	 * @param v2 第二个顶点的下标
	 * @param weight  
	 * Title:insertEdge
	 */
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	/**
	 * 常用方法：
	 */
	//1.返回结点的个数
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//2.得到边的个数
	public int getNumOfEdge() {
		return numOfEdges;
	}
	//3.返回结点i(下标)对应的数据 
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//4.返回v1和v2的权值
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//5.显示图对应的矩阵
	public void showGraph() {
		for(int[] link: edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	
	/**
	 * 
	 * @param index
	 * @return  如果存在，就返回对应的下标
	 * Title:getFirstNeighbor
	 */
	//得到第一个邻接结点的下标w
	public int getFirstNeighbor(int index) {
		for(int j =0;j<vertexList.size();j++) {
			if(edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeighbor(int v1,int v2) {
		for(int j =v2+1;j<vertexList.size();j++) {
			if(edges[v1][j] >0){
				return j;
			}
		}
		return -1;
	}
	
	
	//对一个结点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited,int i) {
		int u;//表示队列的头结点对应下标
		int w;//邻接结点w
		
		//队列,结点访问的顺序
		LinkedList queue = new LinkedList();
		//访问结点，输出结点信息
		System.out.print(getValueByIndex(i) + "-→");
		//标记为已访问
		isVisited[i] = true;
		
		//将结点加入队列
		queue.addLast(i);
		
		while(!queue.isEmpty()) {
			//取出队列的头结点下标
			u = (Integer)queue.removeFirst();
			//得到第一个邻接结点的下标w
			w = getFirstNeighbor(u);
			while(w != -1) {//找到
				//是否访问过
				if(!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "→");
					//标记已经访问
					isVisited[w] = true;
					//入队
					queue.addLast(w);
				}
				//以u为前驱点，找w后面的下一个邻接点
				w = getNextNeighbor(u, w);//体现出我们的广度优先
			}		
		}
	}
	
	//遍历所有的结点，都进行广度优先搜索
	public void bfs() {
		for(int i=0;i<getNumOfVertex();i++) {
			if(!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
}
