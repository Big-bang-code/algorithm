package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ͼ
 * @Title Graph.java
 * @Description
 * @author �Ͻ���
 * @date2020��3��12��
 */
public class Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ͼ
		//int n = 5;//5�����
		String VertexValue[] = {"A","B","C","D","E"};
		//����ͼ����
		Graph graph = new Graph(5);
		//ѭ����Ӷ���
		for(String vertex:VertexValue) {
			graph.insertVertex(vertex);
		}
		//��ӱ�
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
	
	private ArrayList<String> vertexList;//�洢���㼯��
	private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
	private int numOfEdges;//��ʾ�ߵ���Ŀ
	
	//������    n��ʾ��ĸ���
	public Graph(int n) {
		//��ʼ�������vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0; //Ĭ�ϱ�Ϊ0
	}
	
	//������
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//��ӱ�
	/**
	 * 
	 * @param v1  ��ʾ����±꣬���ڼ������㣬��A��-��B�� ��A��->0   "B"->1
	 * @param v2 �ڶ���������±�
	 * @param weight  
	 * Title:insertEdge
	 */
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
	/**
	 * ���÷�����
	 */
	//1.���ؽ��ĸ���
	public int getNumOfVertex() {
		return vertexList.size();
	}
	//2.�õ��ߵĸ���
	public int getNumOfEdge() {
		return numOfEdges;
	}
	//3.���ؽ��i(�±�)��Ӧ������ 
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	//4.����v1��v2��Ȩֵ
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	//5.��ʾͼ��Ӧ�ľ���
	public void showGraph() {
		for(int[] link: edges) {
			System.out.println(Arrays.toString(link));
		}
	}	
}
