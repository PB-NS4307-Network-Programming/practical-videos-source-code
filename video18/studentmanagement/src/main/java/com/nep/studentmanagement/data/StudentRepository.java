package com.nep.studentmanagement.data;

import org.springframework.data.repository.CrudRepository;

import com.nep.studentmanagement.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
