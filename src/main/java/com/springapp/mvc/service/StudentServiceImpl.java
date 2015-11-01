package com.springapp.mvc.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springapp.mvc.dao.Studentdao;
import com.springapp.mvc.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by moiz on 10/27/2015.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private Studentdao studentdao;

    @Override
    @Transactional
    public void insert(Student student) {
        studentdao.insert(student);
    }

    @Override
    @Transactional
    public void delete(Student student){
        studentdao.delete(student);
    }

    @Override
    @JsonIgnore
    public Boolean deleteEntity(int id) throws Exception{
        return studentdao.deleteEntity(id);
    }

    @Override
    public Student getStudentById(int id) {
        return (Student)studentdao.getStudentById(id);
    }

    @Override
    public Student show(String firstName, String lastName) {
        return (Student)studentdao.getStudentByName(firstName,lastName);
    }

    @Override
    public Student findByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentdao.findAll();
    }

    @Override
    public Student getStudentByName(String firstName, String lastName) {
        return (Student)studentdao.getStudentByName(firstName,lastName);
    }
}
