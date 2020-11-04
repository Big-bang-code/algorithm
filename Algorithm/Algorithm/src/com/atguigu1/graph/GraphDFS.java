package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class GraphDFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ͼ
		//int n = 5;//5�����
		String VertexValue[] = {"A","B","C","D","E"};
		//����ͼ����
		GraphDFS graphDFS = new GraphDFS(5);
		//ѭ����Ӷ���
		for(String vertex:VertexValue) {
			graphDFS.insertVertex(vertex);
		}
		//��ӱ�
		//AB  AC  BC  BD  BE
		graphDFS.insertEdge(0, 1, 1);
		graphDFS.insertEdge(0, 2, 1);
		graphDFS.insertEdge(1, 2, 1);
		graphDFS.insertEdge(1, 3, 1);
		graphDFS.insertEdge(1, 4, 1); 
		
		graphDFS.showGraph();
		System.out.println(graphDFS.getNumOfEdge());
		
		//graphDFS.getValueByIndex(1);
		//����dfs
		System.out.println("��ȱ���");
		graphDFS.dfs();
	}
	
	private ArrayList<String> vertexList;//�洢���㼯��
	private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
	private int numOfEdges;//��ʾ�ߵ���Ŀ
	//��������boolean[],��¼ĳ������Ƿ񱻷���
	private boolean[] isVisited;
	
	
	//������    n��ʾ��ĸ���
	public GraphDFS(int n) {
		//��ʼ�������vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0; //Ĭ�ϱ�Ϊ0

		isVisited = new boolean[n];
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
	
	/**
	 * 
	 * @param index
	 * @return  ������ڣ��ͷ��ض�Ӧ���±�
	 * Title:getFirstNeighbor
	 */
	//�õ���һ���ڽӽ����±�w
	public int getFirstNeighbor(int index) {
		for(int j =0;j<vertexList.size();j++) {
			if(edges[index][j]>0) {
				return j;
			}
		}
		return -1;
	}
	
	//����ǰһ���ڽӽ����±�����ȡ��һ���ڽӽ��
	public int getNextNeighbor(int v1,int v2) {
		for(int j =v2+1;j<vertexList.size();j++) {
			if(edges[v1][j] >0){
				return j;
			}
		}
		return -1;
	}
	
	//������ȱ����㷨
	//i ��һ�ξ���0
	private void dfs(boolean[] isVisited,int i) {
		//1.���ȷ��ʸýڵ�
		System.out.print(getValueByIndex(i)+"��");
		//2.������������Ϊ�Ѿ����ʹ�
		isVisited[i] = true;
		
		int w = getFirstNeighbor(i);
		while(w != -1) {//˵�����ڽӽ��
			if(!isVisited[w]) {//����õ�û�з���
				dfs(isVisited, w);
			}
			//����õ��Ѿ������ʹ�����ȥ�����ڽӽ�����һ��
			w = getNextNeighbor(i, w);			
		}
	}
	
	//��dfs����һ�����أ��������еĽ�㲢����dfs
	public void dfs() {
		
		isVisited = new boolean[vertexList.size()];
		
		//�������еĽ�㣬����dfs
		for(int i = 0;i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				dfs(isVisited,i);
			}
		}
	}	
}







