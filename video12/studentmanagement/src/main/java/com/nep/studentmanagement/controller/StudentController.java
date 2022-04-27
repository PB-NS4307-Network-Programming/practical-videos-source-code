package com.nep.studentmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/edit_student/{studentId}")
	public String editStudent(@PathVariable int studentId, ModelMap modelMap) {
		Student student = studentRepo.findById(studentId);
		if(student != null) {
			modelMap.put("student", student);
			return "edit_student";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/delete_student/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {
		studentRepo.delete(studentId);
		return "redirect:/";
	}
	
}
