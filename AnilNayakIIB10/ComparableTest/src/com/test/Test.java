package com.test;

import java.util.TreeSet;

public class Test implements Comparable<Test>{

	/**
	 * @param args
	 */
	String name;
	
	public Test(String name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}


	public static void main(String[] args) {
           TreeSet<Test> t = new TreeSet<Test>();
           t.add(new Test("Anil"));
           t.add(new Test("Gayatree"));
           t.add(new Test("Bandana"));
           t.add(new Test("Nami"));
           System.out.println(t);
	}

	@Override
	public int compareTo(Test t) {
		return t.name.compareTo(this.name);
	}

}
