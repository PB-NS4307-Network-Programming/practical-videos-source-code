package com.nep.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping(value="/")
	public String index() {
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
