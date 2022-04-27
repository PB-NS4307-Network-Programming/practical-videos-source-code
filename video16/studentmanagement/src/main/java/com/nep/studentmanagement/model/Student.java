package com.nep.studentmanagement.model;

import javax.persistence.*;

@Entity
@Table(name="pbstudents")
public class Student {

	@Id
	private String id;
	@Column(nullable=false)
	private String name;
	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="group_id")
	private Group groupCode;
	
	public Student(String id, String name, Group groupCode) {
		this.id = id;
		this.name = name;
		this.groupCode = groupCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Group getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(Group groupCode) {
		this.groupCode = groupCode;
	}
	
}
