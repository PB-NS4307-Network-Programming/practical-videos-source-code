package com.nep.studentmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nep.studentmanagement.data.StudentRepository;
import com.nep.studentmanagement.model.Student;

@Controller
public class StudentController {
	
//	@Autowired
//	StudentRepository studentRepo;
//
//	@RequestMapping(value="/")
//	public String index(ModelMap modelMap) {
//		ArrayList<Student> studentsList = StudentRepository.getAllStudents();
//		modelMap.put("studentsList", studentsList);
//		return "students";
//	}
//	
//	@RequestMapping(value="/add_student")
//	public String addStudent() {
//		return "add_student";
//	}
//	
//	@RequestMapping(value="/add/student")
//	public String addNewStudent(
//			@RequestParam(required=true) int student_id,
//			@RequestParam(required=true) String full_name,
//			@RequestParam(required=true) String group_code
//			) {
//		Student student = new Student(student_id, full_name, group_code);
//		studentRepo.add(student);
//		return "redirect:/";
//	}
//	
//	@RequestMapping(value="/edit_student/{studentId}")
//	public String editStudent(@PathVariable int studentId, ModelMap modelMap) {
//		Student student = studentRepo.findById(studentId);
//		if(student != null) {
//			modelMap.put("student", student);
//			return "edit_student";
//		} else {
//			return "redirect:/";
//		}
//	}
//	
//	@RequestMapping(value="/edit/student/{student_id}")
//	public String edit(
//			@PathVariable int student_id,
//			@RequestParam(required=true) String full_name,
//			@RequestParam(required=true) String group_code
//			) {
//		Student student = studentRepo.findById(student_id);
//		student.setName(full_name);
//		student.setGroupCode(group_code);
//		return "redirect:/edit_student/" + student_id;
//	}
//	
//	@RequestMapping(value="/delete_student/{studentId}")
//	public String deleteStudent(@PathVariable int studentId) {
//		studentRepo.delete(studentId);
//		return "redirect:/";
//	}
	
}
