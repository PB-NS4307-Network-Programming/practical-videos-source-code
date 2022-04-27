package com.nep.studentmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nep.studentmanagement.data.GroupRepository;
import com.nep.studentmanagement.model.Group;

@Controller
public class GroupController {
	
	@Autowired
	GroupRepository groupRepo;

	@RequestMapping(value="/groups")
	public String groups(ModelMap modelMap) {
		Iterable<Group> listOfGroups = groupRepo.findAll();
		modelMap.put("listOfGroups", listOfGroups);
		return "groups";
	}
	
	@RequestMapping(value="/add_group")
	public String addGroup(
			@RequestParam(required=true) String group_code,
			@RequestParam(required=true) String programme
			) {
		Group group = new Group(group_code, programme);
		groupRepo.save(group);
		return "redirect:/groups";
	}
	
	@RequestMapping(value="/edit_group/{group_id}")
	public String editGroup(
			@PathVariable int group_id,
			ModelMap modelMap
			) {
		Group group = groupRepo.findById(group_id).get();
		modelMap.put("group", group);
		return "edit_group";
	}
	
	@RequestMapping(value="/edit/group/{group_id}")
	public String edit(
			@PathVariable int group_id,
			@RequestParam(required=true) String group_code,
			@RequestParam(required=true) String programme
			) {
		Group group = groupRepo.findById(group_id).get();
		group.setGroupCode(group_code);
		group.setProgramme(programme);
		groupRepo.save(group);
		return "redirect:/edit_group/" + group_id;
	}
	
	@RequestMapping(value="/delete_group/{group_id}")
	public String deleteGroup(
			@PathVariable int group_id
			) {
		groupRepo.deleteById(group_id);
		return "redirect:/groups";
	}
	
}
