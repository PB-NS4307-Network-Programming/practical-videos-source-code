package com.nep.studentmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nep.studentmanagement.data.StudentRepository;
import com.nep.studentmanagement.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;

	@RequestMapping(value="/")
	public String index(ModelMap modelMap) {
		ArrayList<Student> studentsList = StudentRepository.getAllStudents();
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
