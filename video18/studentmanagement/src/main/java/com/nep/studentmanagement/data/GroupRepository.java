package com.nep.studentmanagement.data;

import org.springframework.data.repository.CrudRepository;

import com.nep.studentmanagement.model.Group;

public interface GroupRepository extends CrudRepository<Group, Integer> {

}
