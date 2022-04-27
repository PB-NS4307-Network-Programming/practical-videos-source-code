package com.nep.studentmanagement.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nep.studentmanagement.model.Student;

@Controller
public class StudentController {

	@RequestMapping(value="/")
	public String index(ModelMap modelMap) {
		ArrayList<Student> studentsList = new ArrayList<>();
		Student student = new Student(101, "Abu Bakar", "DITN11");
		Student student2 = new Student(102, "Curi Daging", "DITN11");
		Student student3 = new Student(201, "Emak Fatimah", "DISS06");
		Student student4 = new Student(202, "Geli Hati", "DISS06");
		studentsList.add(student);
		studentsList.add(student2);
		studentsList.add(student3);
		studentsList.add(student4);
		modelMap.put("studentsList", studentsList);
		return "students";
	}
	
	@RequestMapping(value="/add_student")
	public String addStudent() {
		return "add_student";
	}
	
	@RequestMapping(value="/edit_student")
	public String editStudent() {
		return "edit_student";
	}
	
}
