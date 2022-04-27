package com.nep.studentmanagement.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nep.studentmanagement.data.GroupRepository;
import com.nep.studentmanagement.data.StudentRepository;
import com.nep.studentmanagement.model.Group;
import com.nep.studentmanagement.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepo;
	@Autowired
	GroupRepository groupRepo;

	@RequestMapping(value="/")
	public String index(ModelMap modelMap) {
		Iterable<Student> studentsList = studentRepo.findAll();
		modelMap.put("studentsList", studentsList);
		return "students";
	}
	
	@RequestMapping(value="/add_student")
	public String addStudent(ModelMap modelMap) {
		Iterable<Group> groupsList = groupRepo.findAll();
		modelMap.put("groupsList", groupsList);
		return "add_student";
	}
	
	@RequestMapping(value="/add/student")
	public String addNewStudent(
			@RequestParam(required=true) String student_id,
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) int group_code
			) {
		Group group = groupRepo.findById(group_code).get();
		Student student = new Student(student_id, full_name, group);
		studentRepo.save(student);
		return "redirect:/";
	}
	
	@RequestMapping(value="/edit_student/{studentId}")
	public String editStudent(@PathVariable String studentId, ModelMap modelMap) {
		Student student = studentRepo.findById(studentId).get();
		if(student != null) {
			Iterable<Group> groupsList = groupRepo.findAll();
			modelMap.put("student", student);
			modelMap.put("groupsList", groupsList);
			return "edit_student";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/edit/student/{student_id}")
	public String edit(
			@PathVariable String student_id,
			@RequestParam(required=true) String full_name,
			@RequestParam(required=true) int group_code
			) {
		Student student = studentRepo.findById(student_id).get();
		Group group = groupRepo.findById(group_code).get();
		student.setName(full_name);
		student.setGroupCode(group);
		studentRepo.save(student);
		return "redirect:/edit_student/" + student_id;
	}
	
	@RequestMapping(value="/delete_student/{studentId}")
	public String deleteStudent(@PathVariable String studentId) {
		studentRepo.deleteById(studentId);
		return "redirect:/";
	}
	
}
