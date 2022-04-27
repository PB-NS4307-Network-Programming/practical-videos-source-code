package com.nep.studentmanagement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="pbgroups")
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String groupCode;
	@Column(nullable=false)
	private String programme;
	@OneToMany(fetch=FetchType.LAZY, mappedBy="groupCode", cascade=CascadeType.ALL)
	private Set<Student> students = new HashSet<Student>();
	
	public Group() { }

	public Group(String groupCode, String programme) {
		this.groupCode = groupCode;
		this.programme = programme;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

}
