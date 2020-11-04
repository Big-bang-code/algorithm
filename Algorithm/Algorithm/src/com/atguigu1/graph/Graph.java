package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 图
 * @Title Graph.java
 * @Description
 * @author 孟建邦
 * @date2020年3月12日
 */
public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试图
		//int n = 5;//5个结点
		String VertexValue[] = {"A","B","C","D","E"};
		//创建图对象
		Graph graph = new Graph(5);
		//循环添加顶点
		for(String vertex:VertexValue) {
			graph.insertVertex(vertex);
		}
		//添加边
		//AB  AC  BC  BD  BE
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		graph.showGraph();
		System.out.println(graph.getNumOfEdge());
	
		System.out.println(	graph.getValueByIndex(1));
	}
	
	private ArrayList<String> vertexList;//存储顶点集合
	private int[][] edges;//存储图对应的邻接矩阵
	private int numOfEdges;//表示边的数目
	
	//构造器    n表示点的个数
	public Graph(int n) {
		//初始化矩阵和vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0; //默认边为0
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
}
