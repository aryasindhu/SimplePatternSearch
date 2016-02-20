package com.test.patternsearch;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class Student {

	private String name;
	private int mark;

	public Student() {
	}

	public Student(String name, int mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return this.name.equals(((Student) obj).getName());
	}

}
