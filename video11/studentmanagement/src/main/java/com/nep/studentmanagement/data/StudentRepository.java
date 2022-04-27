package com.nep.studentmanagement.data;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.nep.studentmanagement.model.Student;

@Component
public class StudentRepository {
	
	private static ArrayList<Student> studentsList = new ArrayList<Student>(
			Arrays.asList(
					new Student(101, "Abu Bakar", "DITN11"),
					new Student(102, "Curi Daging", "DITN11"),
					new Student(201, "Emak Fatimah", "DISS06"),
					new Student(202, "Geli Hati", "DISS06")
					)
			);
	
	public static ArrayList<Student> getAllStudents() {
		return studentsList;
	}
	
	public Student findById(int id) {
		for(Student student : studentsList) {
			if(student.getId() == id) {
				return student;
			}
		}
		return null;
	}
	
	public void add(Student student) {
		studentsList.add(student);
	}
	
	public void delete(int id) {
		Student student = findById(id);
		studentsList.remove(student);
	}

}
