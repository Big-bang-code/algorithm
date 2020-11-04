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
 * @author 孟BIG
 * @date2019年11月20日
 */
public class HuffmanCode {
	
	public static void main(String[] args) {
//		String str = "i like like like java do you like a java";//40
//		byte[] contentBytes = str.getBytes();
		
//		System.out.println(contentBytes.length);
//		List<Node1> nodes = getNodes(contentBytes);
//		System.out.println("nodes="+nodes);
//		
//		//测试创建的二叉树
//		System.out.println("赫夫曼树");
//		Node1 huffmanTreeRoot = createHuffmanTree(nodes);
//		System.out.println("前序遍历");
//		preOrder(huffmanTreeRoot);
//		
//		//测试是否生成了赫夫曼编码
//		//getCodes(huffmanTreeRoot, "", stringBuilder);
//		//System.out.println("赫夫曼编码表"+huffmanCodes);
//		
//		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
//		System.out.println("赫夫曼编码表"+huffmanCodes);
//		
//		byte[] huffmanCodeBytes = zip(contentBytes, huffmanCodes);
//		System.out.println("压缩后的："+Arrays.toString(huffmanCodeBytes));//17
//		
//		//发送huffmanCodeBytes 数组
		
		//《主要代码！！！》
//		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
//		System.out.println("压缩后的："+Arrays.toString(huffmanCodeBytes));
//		
//		
//		//开始解压
//		byte[] sourceBytes = decode(huffmanCodes, huffmanCodeBytes);
//		System.out.println("原来的字符串是："+new String(sourceBytes));
		
		
		
		
		//测试压缩文件的代码
//		String srcFile = "D:\\GraduationProject\\projectDocument\\1.jpg";
//		String dstFile = "D:\\GraduationProject\\projectDocument\\1.zip";
//		zipFile(srcFile, dstFile);
//		System.out.println("压缩文件成功");
		
		//测试解压文件
		String zipFile = "D:\\GraduationProject\\projectDocument\\1.zip";
		String dstFile = "D:\\GraduationProject\\projectDocument\\2.jpg";
		unZipFile(zipFile, dstFile);
		System.out.println("解压文件成功");
	}
	
	
	//<一>
	//通过List，创建对应的赫夫曼树
	private static Node1 createHuffmanTree(List<Node1> nodes) {
		while(nodes.size() > 1 ) {
			//排序,从小到大排
			Collections.sort(nodes);
			//取出第一棵最小的二叉树
			Node1 leftNode = nodes.get(0);
			//取出第二棵最小的二叉树
			Node1 rightNode = nodes.get(1);
			//创建一棵新的二叉树，它的根节点没有data,只有权值
			Node1 parent = new Node1(null, leftNode.weight+rightNode.weight);
			parent.left = leftNode;
			parent.right = rightNode;
			
			//将已经处理的二叉树从nodes移除
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			//将新的二叉树加入
			nodes.add(parent);
		}
		//nodes 最后的结点就是赫夫曼树的根节点
		return nodes.get(0);
	}
	
	/**
	 * <二>
	 * Title:getNodes
	 * @param bytes 接收字节数组
	 * @return 返回的就是List  形式：[Node[date = 97,weight = 5],Node[date = 32,weight = 9]...]  体现：d:1,y:1....
	 */
	private static List<Node1> getNodes(byte[] bytes){
		//1.创建一个ArrayList
		ArrayList<Node1> nodes = new ArrayList<Node1>();
		
		//遍历bytes,统计每一个byte出现的次数 - > map
		Map<Byte, Integer> counts = new HashMap<>();
		for(byte b :bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				//说明Map还没有这个字符数据
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
		}
		//把每个键值对转成Node对象，并加入到nodes集合
		for(Map.Entry<Byte, Integer> entry: counts.entrySet() ){
			nodes.add(new Node1(entry.getKey(), entry.getValue()));			
		}
		return nodes;
	}
		
	//<三>	
	//前序遍历
	public static void preOrder(Node1 root) {
		if(root !=null) {
			root.preOrder();
		}else {
			System.out.println("树是空树");
		}
	}
		
	/**
	 * <四>
	 * 功能：将传入的Node结点的所有叶子结点的赫夫曼编码得到，存放到huffmanCode集合
	 * Title:getCodes
	 * @param node1  传入结点
	 * @param code	路径：左子结点是0，右子结点是1
	 * @param stringBuilder	用于拼接路径
	 */
	private static void getCodes(Node1 node1,String code,StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		//将code加入到stringBuilder2中
		stringBuilder2.append(code);
		if(node1 != null) {//如果node == null 不处理
			//判断当前node是叶子结点还是非叶子结点
			if(node1.data == null) {//非叶子结点
				//递归处理
				//向左递归
				getCodes(node1.left, "0", stringBuilder2);
				//向右递归
				getCodes(node1.right, "1", stringBuilder2);
			}else {//说明是一个叶子结点
				//就表示找到了 某个叶子结点的最后
				huffmanCodes.put(node1.data, stringBuilder2.toString());
			}
		}
	}
		
	//<五>
	//生成赫夫曼树对应的赫夫曼编码
	//1.将赫夫曼编码表存放到Map<Byte,String>
	//	如    空 32=>01   a 97=>100 d 100=>11000 u=11001 e=1110 v=11011 i=101 y=11010 j=0010 k=1111 l=000 o=0011
	static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
	//2.在生成赫夫曼编码表时，需要去拼接路径，定义一个StringBuilder 存储某个叶子结点的路径
	static StringBuilder stringBuilder = new StringBuilder();
	
	//为了调用方便，重载getCodes
	private static Map<Byte, String> getCodes(Node1 root){
		if(root == null) {
			return null;
		}
		//处理root左子树
		getCodes(root.left,"0",stringBuilder);
		//处理root右子树
		getCodes(root.right,"1",stringBuilder);
		return huffmanCodes;
	}
		
	//<六>	
	//编写一个方法，将一个字符串对应的Byte数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码表压缩后的Byte数组
	/**
	 * 
	 * Title:zip
	 * @param bytes	这是原始的字符串对应的Byte数组
	 * @param huffmanCodes	生成的赫夫曼编码Map
	 * @return	返回赫夫曼编码处理后的byte[]
	 * 
	 * 返回的是压缩后的字符串
	 */
	private static byte[] zip(byte[] bytes,Map<Byte, String> huffmanCodes) {
		
		//1.先使用赫夫曼编码表将传进的Byte数组转成赫夫曼编码的字符串
		//如i like like like java do you like a java
		//转为1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		StringBuilder stringBuilder = new StringBuilder();
		//遍历bytes数组
		for(byte b: bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		System.out.println("测试stringBuilder="+stringBuilder.toString());
		
		//2.将101010001011111111001000101.....转为byte[]		
		int len;
		if(stringBuilder.length() % 8 ==0) {
			len = stringBuilder.length() / 8 ;
		}else {
			len = stringBuilder.length() / 8 + 1;
		}
		//一句话搞定
		//int len = (stringBuilder.length()+7)/8;
		
		//3.创建一个存储压缩后的byte数组
		byte[] huffmanCodeBytes = new byte[len];
		int index = 0;//记录是第几个byte
		for(int i=0;i<stringBuilder.length();i+=8) {//因为是每8位对应一个byte,所以步长+8
			String strByte;
			if(i+8>stringBuilder.length()) {//最后不够8位
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			//将strByte转成一个byte,放入到huffmanCodeBytes中
			huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte, 2);
			index++;
		}
		return huffmanCodeBytes;
	}
	

	//<七>
	//使用一个方法，将前面的方法封装起来，便于调用
	/**
	 * 
	 * Title:huffmanZip
	 * @param bytes	原来的字符串对应的字节数组 
	 * @return	是经过赫夫曼编码处理后的字节数组(压缩后的数组)
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		
		System.out.println("压缩前的："+Arrays.toString(bytes));
		//1.
		List<Node1> nodes = getNodes(bytes);
		
		//2.创建赫夫曼树
		System.out.println("赫夫曼树");
		Node1 huffmanTreeRoot = createHuffmanTree(nodes);
//			System.out.println("前序遍历");
//			preOrder(huffmanTreeRoot);
		
		//3.生成对应的赫夫曼编码
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		System.out.println("赫夫曼编码表"+huffmanCodes);
		
		//4.进行压缩(根据生成的赫夫曼编码压缩，得到压缩后的赫夫曼编码字节数组)
		byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
		//System.out.println("压缩后的："+Arrays.toString(huffmanCodeBytes));
		
		return huffmanCodeBytes;
	}
		
	
	//<解压 八>
	//完成数据的解压
	//1.先把压缩后的压缩后的：[-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	//	转为 stringBuilder=1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
	//2.将字符串对照赫夫曼编码重新转为 i like like like java do you like a java
	/**
	 * 	将一个byte转为一个二进制的字符串
	 * Title:byteToBitString
	 * @param flag 表示标识是否需要补高位，如果是true,表示需要补高位，如果是false,表示不补,如果是最后一个字节不需要补高位
	 * @param b
	 * @return 是该b对应的二进制的字符串（是按补码返回 ）
	 */
	private static String byteToBitString(Boolean flag,byte b) {
		//使用一个变量保存b
		int temp = b;//将b转为int
		//如果是正数，需要补高位
		if(flag) {
			temp |= 256;		
		}
		String str = Integer.toBinaryString(temp);//返回的是temp二进制的补码
		if(flag) {
			return str.substring(str.length()-8);
		}else{
			return str;
		}
	}
	
	//<九>
	//编写方法，完成对压缩数据的解码
	/**
	 * 
	 * Title:decode
	 * @param huffmanCode	原先用的赫夫曼编码
	 * @param huffmanBytes	就是赫夫曼编码得到的字节数组 [-88, -65, -56, -65, -56, -65, -55, 77, -57, 6, -24, -14, -117, -4, -60, -90, 28]
	 * @return	原来的字符串对应的数组
	 */	
	private static byte[] decode(Map<Byte, String> huffmanCode,byte[] huffmanBytes) {
		//1.先得到huffmanBytes对应的二进制的字符串：
		//	1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		StringBuilder stringBuilder = new StringBuilder();
		//2.将byte数组转为二进制的字符串
		for(int i=0;i<huffmanBytes.length;i++) {
			byte b = huffmanBytes[i];
			//判断是不是最后一个字节
			boolean flag = (i== huffmanBytes.length-1);
			stringBuilder.append(byteToBitString(!flag, b));
		}
		System.out.println("赫夫曼字节数组对应的二进制字符串="+stringBuilder.toString());
		
		//把字符串按照指定的赫夫曼编码进行编码
		//把赫夫曼编码表进行调换，要反向查询
		Map<String, Byte> map = new HashMap<String, Byte>();
		for(Map.Entry<Byte, String> entry:huffmanCodes.entrySet()) {
			map.put(entry.getValue(), entry.getKey());
		}
		System.out.println("map"+map);
		
		//创建一个集合，存放byte
		List<Byte> list = new ArrayList<>();
		for(int i=0;i<stringBuilder.length();) {//i可理解为一个索引
			int count = 1;//小的计数器
			boolean flag = true;
			Byte b = null;
			while(flag) {
				//取出一个‘1’，‘0’
				String key = stringBuilder.substring(i,i+count);//i不动,让count移动,指定匹配到一个字符
				b = map.get(key);
				if(b == null) {//说明没有匹配到
					count++;
				}else {
					//匹配到
					flag = false;
				}
			}
			list.add(b);
			i += count;//i直接移动到count位置
		}
		//当for循环结束后，就存放了所有的字符
		//把list中的数据放到byte[] 并返回
		byte b[] = new byte[list.size()];
		for(int i = 0;i<b.length;i++) {
			b[i] = list.get(i);
		}
		return b;	
	}
	
	
	//<十>
	//编写一个方法，将一个文件压缩
	/**
	 * 
	 * Title:zipFile
	 * @param srcFile  传入希望压缩的文件的路径
	 * @param dstFile  压缩后将压缩文件放到某个目录下
	 */
	public static void zipFile(String srcFile,String dstFile) {
		//创建输出流
		OutputStream os = null;
		ObjectOutputStream oos = null;
		//创建文件的输入流
		FileInputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			//创建一个和源文件一样大小的byte[]
			byte[] b = new byte[is.available()];
			//读取文件
			is.read(b);
			
			//获取到文件对应的赫夫曼编码表
			byte[] huffmanBytes = huffmanZip(b);
			//创建文件的输出流,存放压缩文件
			os = new FileOutputStream(dstFile);
			//创建一个和文件输出流关联的ObjectOutputStream
			oos = new ObjectOutputStream(os);
			//把赫夫曼编码后的字节数组写入压缩文件
			oos.writeObject(huffmanBytes);
			
			//这里我们以对象流的方式写入赫夫曼的编码，是为了以后解压或恢复源文件时使用
			//一定要把赫夫曼编码写入压缩文件
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
	
	//<十一>
	//编写一个方法，完成对压缩文件的解压
	/**
	 * 
	 * Title:unZipFile
	 * @param zipFile	要准备解压的文件
	 * @param dstFile	将文件减压的路径
	 */
	public static void unZipFile(String zipFile,String dstFile) {
		//定义文件的输入流
		InputStream is = null;
		//定义一个对象输入流
		ObjectInputStream ois = null;
		//定义一个文件的输出流
		OutputStream os = null;
		
		try {
			//定义一个文件输入流
			is = new FileInputStream(zipFile);
			//创建一个和is关联的对象输入流
			ois = new ObjectInputStream(is);
			//读取Byte数组  huffmanBytes
			byte[] huffmanBytes = (byte[])ois.readObject();
			//读取赫夫曼编码表
			Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
			//进行解码
			byte[] bytes = decode(huffmanCodes, huffmanBytes);
			//将bytes数组写入到目标文件
			os = new FileOutputStream(dstFile);
			//写出数据到文件中
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

//创建code，带数值和权值
class Node1 implements Comparable<Node1>{
	Byte data;//存放数据本身，如'a' => 97   ' ' => 32
	int weight;//权值，表示字符出现的次数
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

	//前序遍历
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
