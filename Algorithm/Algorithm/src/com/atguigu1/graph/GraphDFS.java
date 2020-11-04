package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphDFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试图
		//int n = 5;//5个结点
		String VertexValue[] = {"A","B","C","D","E"};
		//创建图对象
		GraphDFS graphDFS = new GraphDFS(5);
		//循环添加顶点
		for(String vertex:VertexValue) {
			graphDFS.insertVertex(vertex);
		}
		//添加边
		//AB  AC  BC  BD  BE
		graphDFS.insertEdge(0, 1, 1);
		graphDFS.insertEdge(0, 2, 1);
		graphDFS.insertEdge(1, 2, 1);
		graphDFS.insertEdge(1, 3, 1);
		graphDFS.insertEdge(1, 4, 1); 
		
		graphDFS.showGraph();
		System.out.println(graphDFS.getNumOfEdge());
		
		//graphDFS.getValueByIndex(1);
		//测试dfs
		System.out.println("深度遍历");
		graphDFS.dfs();
	}
	
	private ArrayList<String> vertexList;//存储顶点集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numOfEdges;//表示边的数目
	//定义数组boolean[],记录某个结点是否被访问
	private boolean[] isVisited;
	
	
	//构造器    n表示点的个数
	public GraphDFS(int n) {
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
	
	//深度优先遍历算法
	//i 第一次就是0
	private void dfs(boolean[] isVisited,int i) {
		//1.首先访问该节点
		System.out.print(getValueByIndex(i)+"→");
		//2.将这个结点设置为已经访问过
		isVisited[i] = true;
		
		int w = getFirstNeighbor(i);
		while(w != -1) {//说明有邻接结点
			if(!isVisited[w]) {//如果该点没有访问
				dfs(isVisited, w);
			}
			//如果该点已经被访问过，就去查找邻接结点的下一点
			w = getNextNeighbor(i, w);			
		}
	}
	
	//对dfs进行一个重载，遍历所有的结点并进行dfs
	public void dfs() {
		
		isVisited = new boolean[vertexList.size()];
		
		//遍历所有的结点，进行dfs
		for(int i = 0;i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}	
}







