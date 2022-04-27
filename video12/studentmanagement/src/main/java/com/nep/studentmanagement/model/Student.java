package com.nep.studentmanagement.model;

public class Student {

	private int id;
	private String name;
	private String groupCode;
	
	public Student(int id, String name, String groupCode) {
		this.id = id;
		this.name = name;
		this.groupCode = groupCode;
	}

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

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
}
