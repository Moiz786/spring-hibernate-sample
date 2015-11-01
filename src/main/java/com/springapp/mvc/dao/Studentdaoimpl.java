package com.springapp.mvc.dao;

import com.springapp.mvc.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.Transaction;
import java.util.List;

/**
 * Created by moiz on 10/27/2015.
 */
@Repository
@Transactional
public class Studentdaoimpl implements Studentdao {

    @Autowired
    private SessionFactory sessionFactory;

    Session session=null;
    org.hibernate.Transaction tx=null;

    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    public void delete(Student student) {

        sessionFactory.getCurrentSession().delete(student);
    }

    @Override

    public Boolean deleteEntity(int id)throws Exception{
        session=sessionFactory.openSession();
        Object o=session.load(Student.class,id);
        tx= session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        //session.load();
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public Student getStudentById(int id){
        return (Student)sessionFactory.getCurrentSession().get(Student.class,id);
    }

    @Override
    public Student show(String firstName, String lastName) {
        return (Student)sessionFactory.getCurrentSession().get(Student.class,firstName+" "+lastName);
    }

    @Override
    public Student findByName(String firstName, String lastName) {
        return null;
    }

    @Override
    public Student getStudentByName(String firstName, String lastName) {
        return (Student)sessionFactory.getCurrentSession().createCriteria(Student.class)
                .add(Restrictions.eq("firstName",firstName).ignoreCase())
                .add(Restrictions.eq("lastName",lastName).ignoreCase())
                .uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(Student.class).list();
    }

}
