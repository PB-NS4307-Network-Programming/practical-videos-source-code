package com.nep.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GroupController {

	@RequestMapping(value="/groups")
	public String groups() {
		return "groups";
	}
	
	@RequestMapping(value="/edit_group")
	public String editGroup() {
		return "edit_group";
	}
	
}
