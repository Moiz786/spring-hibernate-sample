package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Student;
import com.springapp.mvc.dto.StudentDto;

import java.util.List;

/**
 * Created by moiz on 10/27/2015.
 */
public interface Studentdao {
    void insert(Student student);

    void delete(Student student);

    Student getStudentById(int id);

    Student show(String firstName, String lastName);

    List<Student> findAll();

    Student findByName(String firstName, String lastName);

    Student getStudentByName(String firstName, String lastName);

    Boolean deleteEntity(int id) throws Exception;


}
