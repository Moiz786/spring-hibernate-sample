package com.springapp.mvc;

import com.springapp.mvc.domain.Student;
import com.springapp.mvc.dto.StudentDto;
import com.springapp.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by moiz on 10/28/2015.
 */
@RestController
@RequestMapping(value = "test/student")
public class HelloRestController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/")
    public ModelAndView home(ModelMap model){
        model.put("student",studentService.findAll());
        return new ModelAndView("student",model);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public @ResponseBody StudentDto insert(@RequestBody StudentDto studentDto){
        studentService.insert(new Student(studentDto.getFirstName(),studentDto.getLastName(), studentDto.getAge()));
        return studentDto;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Student saveStudent(@ModelAttribute StudentDto student) {
        Student stu=new Student(student.getFirstName(),student.getLastName(), student.getAge());
        studentService.insert(stu);

        return stu;
    }

    @RequestMapping(value = "/delete/{firstName}/{lastName}",method = RequestMethod.DELETE)
    public void deleteStudent(@RequestBody@PathVariable("firstName") String first, @PathVariable("lastName") String last){
        studentService.delete(studentService.getStudentByName(first, last));
    }

    @RequestMapping(value = "/show/{firstName}/{lastName}", method = RequestMethod.GET)
     public Student show(@PathVariable("firstName") String first, @PathVariable("lastName") String last){
        //studentService.show(id);
        return (Student)studentService.getStudentByName(first,last);
    }

    @RequestMapping(value = "/remove/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")int id){
        //studentService.show(id);
        try {
            studentService.deleteEntity(id);

        }
        catch (Exception e){
            e.getMessage();
        }

    }
    /*@RequestMapping(value = "show/{id}", method = RequestMethod.GET)
    public Student show(@PathVariable("id")int id){
        //studentService.show(id);
        return studentService.getStudentById(id);
    }
    */
}
