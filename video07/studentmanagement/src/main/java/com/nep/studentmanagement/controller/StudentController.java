package com.nep.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

	@RequestMapping(value="/")
	@ResponseBody
	public String index() {
		return "<h1>Hello</h1><h4>World</h4>";
	}
	
}
