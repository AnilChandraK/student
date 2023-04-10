/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */
package com.example.school.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.school.model.Student;
import java.util.*;

import com.example.school.model.Student;
import com.example.school.repository.StudentRepository;
import com.example.school.service.StudentH2Service;

@RestController
public class StudentController{
    @Autowired
    private StudentH2Service SService;

    @GetMapping("/students")
    public ArrayList<Student> getStudents(){
        return SService.getStudents();
    }
    
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId){
        return SService.getStudentById(studentId);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        return SService.addStudent(student);
    }
    
    public String addMultipleStudents(@RequestBody ArrayList<Student> getStudents) { //here we are using the ArrayList concept to add the multiple students
        return SService.addMultipleStudents(getStudents);
    }

    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student){
        return SService.updateStudent(studentId,student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int studentId){
        SService.deleteStudent(studentId);
    }

}
