package com.atguigu1.huffmantree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 
 * @Title HuffmanCode.java
 * @Description
 * @author ��BIG
 * @date2019��11��20��
 */
public class HuffmanCode {
	
	public static void main(String[] args) {
//		String str = "i like like like java do you like a java";//40
//		byte[] contentBytes = str.getBytes();
		
//		System.out.println(contentBytes.length);
//		List<Node1> nodes = getNodes(contentBytes);
//		System.out.println("nodes="+nodes);
//		
//		//���Դ����Ķ�����
//		System.out.println("�շ�����");
//		Node1 huffmanTreeRoot = createHuffmanTree(nodes);
//		System.out.println("ǰ�����");
//		preOrder(huffmanTreeRoot);
//		
//		//�����Ƿ������˺շ�������
//		//getCodes(huffmanTreeRoot, "", stringBuilder);
//		//System.out.println("�շ��������"+huffmanCodes);
//		
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//		System.out.println("�շ��������"+huffmanCodes);
//		
//		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//		System.out.println("ѹ����ģ�"+Arrays.toString(huffmanCodeBytes));//17
//		
//		//����huffmanCodeBytes ����
		
		//����Ҫ���룡������
//		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//		System.out.println("ѹ����ģ�"+Arrays.toString(huffmanCodeBytes));
//		
//		
//		//��ʼ��ѹ
//		byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
//		System.out.println("ԭ�����ַ����ǣ�"+new String(sourceBytes));
		
		
		
		
		//����ѹ���ļ��Ĵ���
//		String srcFile = "D:\\GraduationProject\\projectDocument\\1.jpg";
//		String dstFile = "D:\\GraduationProject\\projectDocument\\1.zip";
//		zipFile(srcFile, dstFile);
//		System.out.println("ѹ���ļ��ɹ�");
		
		//���Խ�ѹ�ļ�
		String zipFile = "D:\\GraduationProject\\projectDocument\\1.zip";
		String dstFile = "D:\\GraduationProject\\projectDocument\\2.jpg";
		unZipFile(zipFile, dstFile);
		System.out.println("��ѹ�ļ��ɹ�");
	}
	
	
	//<һ>
	//ͨ��List��������Ӧ�ĺշ�����
	private static Node1 createHuffmanTree(List<Node1> nodes) {
		while(nodes.size() > 1 ) {
			//����,��С������
			Collections.sort(nodes);
			//ȡ����һ����С�Ķ�����
			Node1 leftNode = nodes.get(0);
			//ȡ���ڶ�����С�Ķ�����
			Node1 rightNode = nodes.get(1);
			//����һ���µĶ����������ĸ��ڵ�û��data,ֻ��Ȩֵ
			Node1 parent = new Node1(null, leftNode.weight+rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//���Ѿ�����Ķ�������nodes�Ƴ�
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//���µĶ���������
			nodes.add(parent);
		}
		//nodes ���Ľ����Ǻշ������ĸ��ڵ�
		return nodes.get(0);
	}
	
	/**
	 * <��>
	 * Title:getNodes
	 * @param bytes �����ֽ�����
	 * @return ���صľ���List  ��ʽ��[Node[date = 97,weight = 5],Node[date = 32,weight = 9]...]  ���֣�d:1,y:1....
	 */
	private static List<Node1> getNodes(byte[] bytes){
		//1.����һ��ArrayList
		ArrayList<Node1> nodes = new ArrayList<Node1>();
		
		//����bytes,ͳ��ÿһ��byte���ֵĴ��� - > map
		Map<Byte, Integer> counts = new HashMap<>();
		for(byte b :bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				//˵��Map��û������ַ�����
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//��ÿ����ֵ��ת��Node���󣬲����뵽nodes����
		for(Map.Entry<Byte, Integer> entry: counts.entrySet() ){
			nodes.add(new Node1(entry.getKey(), entry.getValue()));			
		}
		return nodes;
	}
		
	//<��>	
	//ǰ�����
	public static void preOrder(Node1 root) {
		if(root !=null) {
			root.preOrder();
		}else {
			System.out.println("���ǿ���");
		}
	}
		
	/**
	 * <��>
	 * ���ܣ��������Node��������Ҷ�ӽ��ĺշ�������õ�����ŵ�huffmanCode����
	 * Title:getCodes
	 * @param node1  ������
	 * @param code	·�������ӽ����0�����ӽ����1
	 * @param stringBuilder	����ƴ��·��
	 */
	private static void getCodes(Node1 node1,String code,StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		//��code���뵽stringBuilder2��
		stringBuilder2.append(code);
		if(node1 != null) {//���node == null ������
			//�жϵ�ǰnode��Ҷ�ӽ�㻹�Ƿ�Ҷ�ӽ��
			if(node1.data == null) {//��Ҷ�ӽ��
				//�ݹ鴦��
				//����ݹ�
				getCodes(node1.left, "0", stringBuilder2);
				//���ҵݹ�
				getCodes(node1.right, "1", stringBuilder2);
			}else {//˵����һ��Ҷ�ӽ��
				//�ͱ�ʾ�ҵ��� ĳ��Ҷ�ӽ������
				huffmanCodes.put(node1.data, stringBuilder2.toString());
			}
		}
	}
		
	//<��>
	//���ɺշ�������Ӧ�ĺշ�������
	//1.���շ���������ŵ�Map<Byte,String>
	//	��    �� 32=>01   a 97=>100 d 100=>11000 u=11001 e=1110 v=11011 i=101 y=11010 j=0010 k=1111 l=000 o=0011
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	//2.�����ɺշ��������ʱ����Ҫȥƴ��·��������һ��StringBuilder �洢ĳ��Ҷ�ӽ���·��
	static StringBuilder stringBuilder = new StringBuilder();
	
	//Ϊ�˵��÷��㣬����getCodes
	private static Map<Byte, String> getCodes(Node1 root){
		if(root == null) {
			return null;
		}
		//����root������
		getCodes(root.left,"0",stringBuilder);
		//����root������
		getCodes(root.right,"1",stringBuilder);
		return huffmanCodes;
	}
		
	//<��>	
	//��дһ����������һ���ַ�����Ӧ��Byte���飬ͨ�����ɵĺշ������������һ���շ��������ѹ�����Byte����
	/**
	 * 
	 * Title:zip
	 * @param bytes	����ԭʼ���ַ�����Ӧ��Byte����
	 * @param huffmanCodes	���ɵĺշ�������Map
	 * @return	���غշ������봦����byte[]
	 * 
	 * ���ص���ѹ������ַ���
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> huffmanCodes) {
		
		//1.��ʹ�úշ��������������Byte����ת�ɺշ���������ַ���
		//��i like like like java do you like a java
		//תΪ1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		StringBuilder stringBuilder = new StringBuilder();
		//����bytes����
		for(byte b: bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		System.out.println("����stringBuilder="+stringBuilder.toString());
		
		//2.��101010001011111111001000101.....תΪbyte[]		
		int len;
		if(stringBuilder.length() % 8 ==0) {
			len = stringBuilder.length() / 8 ;
		}else {
			len = stringBuilder.length() / 8 + 1;
		}
		//һ�仰�㶨
		//int len = (stringBuilder.length()+7)/8;
		
		//3.����һ���洢ѹ�����byte����
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//��¼�ǵڼ���byte
		for(int i=0;i<stringBuilder.length();i+=8) {//��Ϊ��ÿ8λ��Ӧһ��byte,���Բ���+8
			String strByte;
			if(i+8>stringBuilder.length()) {//��󲻹�8λ
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			//��strByteת��һ��byte,���뵽huffmanCodeBytes��
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;
	}
	

	//<��>
	//ʹ��һ����������ǰ��ķ�����װ���������ڵ���
	/**
	 * 
	 * Title:huffmanZip
	 * @param bytes	ԭ�����ַ�����Ӧ���ֽ����� 
	 * @return	�Ǿ����շ������봦�����ֽ�����(ѹ���������)
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		
		System.out.println("ѹ��ǰ�ģ�"+Arrays.toString(bytes));
		//1.
		List<Node1> nodes = getNodes(bytes);
		
		//2.�����շ�����
		System.out.println("�շ�����");
		Node1 huffmanTreeRoot = createHuffmanTree(nodes);
//			System.out.println("ǰ�����");
//			preOrder(huffmanTreeRoot);
		
		//3.���ɶ�Ӧ�ĺշ�������
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		System.out.println("�շ��������"+huffmanCodes);
		
		//4.����ѹ��(�������ɵĺշ�������ѹ�����õ�ѹ����ĺշ��������ֽ�����)
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		//System.out.println("ѹ����ģ�"+Arrays.toString(huffmanCodeBytes));
		
		return huffmanCodeBytes;
	}
		
	
	//<��ѹ ��>
	//������ݵĽ�ѹ
	//1.�Ȱ�ѹ�����ѹ����ģ�[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	//	תΪ stringBuilder=1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
	//2.���ַ������պշ�����������תΪ i like like like java do you like a java
	/**
	 * 	��һ��byteתΪһ�������Ƶ��ַ���
	 * Title:byteToBitString
	 * @param flag ��ʾ��ʶ�Ƿ���Ҫ����λ�������true,��ʾ��Ҫ����λ�������false,��ʾ����,��������һ���ֽڲ���Ҫ����λ
	 * @param b
	 * @return �Ǹ�b��Ӧ�Ķ����Ƶ��ַ������ǰ����뷵�� ��
	 */
	private static String byteToBitString(Boolean flag,byte b) {
		//ʹ��һ����������b
		int temp = b;//��bתΪint
		//�������������Ҫ����λ
		if(flag) {
			temp |= 256;		
		}
		String str = Integer.toBinaryString(temp);//���ص���temp�����ƵĲ���
		if(flag) {
			return str.substring(str.length()-8);
		}else{
			return str;
		}
	}
	
	//<��>
	//��д��������ɶ�ѹ�����ݵĽ���
	/**
	 * 
	 * Title:decode
	 * @param huffmanCode	ԭ���õĺշ�������
	 * @param huffmanBytes	���Ǻշ�������õ����ֽ����� [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	 * @return	ԭ�����ַ�����Ӧ������
	 */	
	private static byte[] decode(Map<Byte, String> huffmanCode,byte[] huffmanBytes) {
		//1.�ȵõ�huffmanBytes��Ӧ�Ķ����Ƶ��ַ�����
		//	1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		StringBuilder stringBuilder = new StringBuilder();
		//2.��byte����תΪ�����Ƶ��ַ���
		for(int i=0;i<huffmanBytes.length;i++) {
			byte b = huffmanBytes[i];
			//�ж��ǲ������һ���ֽ�
			boolean flag = (i== huffmanBytes.length-1);
			stringBuilder.append(byteToBitString(!flag, b));
		}
		System.out.println("�շ����ֽ������Ӧ�Ķ������ַ���="+stringBuilder.toString());
		
		//���ַ�������ָ���ĺշ���������б���
		//�Ѻշ����������е�����Ҫ�����ѯ
		Map<String, Byte> map = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry:huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		System.out.println("map"+map);
		
		//����һ�����ϣ����byte
		List<Byte> list = new ArrayList<>();
		for(int i=0;i<stringBuilder.length();) {//i�����Ϊһ������
			int count = 1;//С�ļ�����
			boolean flag = true;
			Byte b = null;
			while(flag) {
				//ȡ��һ����1������0��
				String key = stringBuilder.substring(i,i+count);//i����,��count�ƶ�,ָ��ƥ�䵽һ���ַ�
				b = map.get(key);
				if(b == null) {//˵��û��ƥ�䵽
					count++;
				}else {
					//ƥ�䵽
					flag = false;
				}
			}
			list.add(b);
			i += count;//iֱ���ƶ���countλ��
		}
		//��forѭ�������󣬾ʹ�������е��ַ�
		//��list�е����ݷŵ�byte[] ������
		byte b[] = new byte[list.size()];
		for(int i = 0;i<b.length;i++) {
			b[i] = list.get(i);
		}
		return b;	
	}
	
	
	//<ʮ>
	//��дһ����������һ���ļ�ѹ��
	/**
	 * 
	 * Title:zipFile
	 * @param srcFile  ����ϣ��ѹ�����ļ���·��
	 * @param dstFile  ѹ����ѹ���ļ��ŵ�ĳ��Ŀ¼��
	 */
	public static void zipFile(String srcFile,String dstFile) {
		//���������
		OutputStream os = null;
		ObjectOutputStream oos = null;
		//�����ļ���������
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			//����һ����Դ�ļ�һ����С��byte[]
			byte[] b = new byte[is.available()];
			//��ȡ�ļ�
			is.read(b);
			
			//��ȡ���ļ���Ӧ�ĺշ��������
			byte[] huffmanBytes = huffmanZip(b);
			//�����ļ��������,���ѹ���ļ�
			os = new FileOutputStream(dstFile);
			//����һ�����ļ������������ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//�Ѻշ����������ֽ�����д��ѹ���ļ�
			oos.writeObject(huffmanBytes);
			
			//���������Զ������ķ�ʽд��շ����ı��룬��Ϊ���Ժ��ѹ��ָ�Դ�ļ�ʱʹ��
			//һ��Ҫ�Ѻշ�������д��ѹ���ļ�
			oos.writeObject(huffmanCodes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				os.close();
				oos.close();
			}catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	//<ʮһ>
	//��дһ����������ɶ�ѹ���ļ��Ľ�ѹ
	/**
	 * 
	 * Title:unZipFile
	 * @param zipFile	Ҫ׼����ѹ���ļ�
	 * @param dstFile	���ļ���ѹ��·��
	 */
	public static void unZipFile(String zipFile,String dstFile) {
		//�����ļ���������
		InputStream is = null;
		//����һ������������
		ObjectInputStream ois = null;
		//����һ���ļ��������
		OutputStream os = null;
		
		try {
			//����һ���ļ�������
			is = new FileInputStream(zipFile);
			//����һ����is�����Ķ���������
			ois = new ObjectInputStream(is);
			//��ȡByte����  huffmanBytes
			byte[] huffmanBytes = (byte[])ois.readObject();
			//��ȡ�շ��������
			Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
			//���н���
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			//��bytes����д�뵽Ŀ���ļ�
			os = new FileOutputStream(dstFile);
			//д�����ݵ��ļ���
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {			
				os.close();
				ois.close();
				is.close();
			}catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
	
	
}

//����code������ֵ��Ȩֵ
class Node1 implements Comparable<Node1>{
	Byte data;//������ݱ�����'a' => 97   ' ' => 32
	int weight;//Ȩֵ����ʾ�ַ����ֵĴ���
	Node1 left;
	Node1 right;
	
		
	public Node1(Byte data, int weight) {

		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node1 o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
	@Override
	public String toString() {
		return "Node1 [data=" + data + ", weight=" + weight + "]";
	}

	//ǰ�����
	public void preOrder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
	
}
