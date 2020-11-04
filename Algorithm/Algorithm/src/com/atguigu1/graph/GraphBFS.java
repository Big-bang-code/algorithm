package com.atguigu1.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class GraphBFS {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ͼ
		//int n = 5;//5�����
		String VertexValue[] = {"A","B","C","D","E"};
		//����ͼ����
		GraphBFS graphbfs = new GraphBFS(5);
		//ѭ����Ӷ���
		for(String vertex:VertexValue) {
			graphbfs.insertVertex(vertex);
		}
		//��ӱ�
		//AB  AC  BC  BD  BE
		graphbfs.insertEdge(0, 1, 1);
		graphbfs.insertEdge(0, 2, 1);
		graphbfs.insertEdge(1, 2, 1);
		graphbfs.insertEdge(1, 3, 1);
		graphbfs.insertEdge(1, 4, 1);
		
		graphbfs.showGraph();
		System.out.println(graphbfs.getNumOfEdge());
	
		System.out.println(graphbfs.getValueByIndex(1));
		
		System.out.println("�������");
		graphbfs.bfs();
	}
	
	private ArrayList<String> vertexList;//�洢���㼯��
	private int[][] edges;//�洢ͼ��Ӧ���ڽӾ���
	private int numOfEdges;//��ʾ�ߵ���Ŀ
	
	//��������boolean[],��¼ĳ������Ƿ񱻷���
	private boolean[] isVisited;
	
	//������    n��ʾ��ĸ���
	public GraphBFS(int n) {
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
	
	
	//��һ�������й�����ȱ����ķ���
	private void bfs(boolean[] isVisited,int i) {
		int u;//��ʾ���е�ͷ����Ӧ�±�
		int w;//�ڽӽ��w
		
		//����,�����ʵ�˳��
		LinkedList queue = new LinkedList();
		//���ʽ�㣬��������Ϣ
		System.out.print(getValueByIndex(i) + "-��");
		//���Ϊ�ѷ���
		isVisited[i] = true;
		
		//�����������
		queue.addLast(i);
		
		while(!queue.isEmpty()) {
			//ȡ�����е�ͷ����±�
			u = (Integer)queue.removeFirst();
			//�õ���һ���ڽӽ����±�w
			w = getFirstNeighbor(u);
			while(w != -1) {//�ҵ�
				//�Ƿ���ʹ�
				if(!isVisited[w]) {
					System.out.print(getValueByIndex(w) + "��");
					//����Ѿ�����
					isVisited[w] = true;
					//���
					queue.addLast(w);
				}
				//��uΪǰ���㣬��w�������һ���ڽӵ�
				w = getNextNeighbor(u, w);//���ֳ����ǵĹ������
			}		
		}
	}
	
	//�������еĽ�㣬�����й����������
	public void bfs() {
		for(int i=0;i<getNumOfVertex();i++) {
			if(!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}
}
