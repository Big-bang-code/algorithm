package com.atguigu.linkedlist;

public class Test {
	public static void main(String[] args) {
		dianqi  d1 = new dianqi();
		
		dianqi  d2 = new dianqi();
		
		d1.setChild(d2);
		d1.child= d2;
	}

}


class  dianqi{
	int id;
	String name;
	dianqi child;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public dianqi getChild() {
		return child;
	}
	public void setChild(dianqi child) {
		this.child = child;
	}
	
	
}