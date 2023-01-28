package com.hali.demo.student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    
	@GetMapping
	public List<Student> getStudents(){
        return studentService.getStudents();   
	}

    @PostMapping
    public Student registerStudent(@RequestBody Student student){
        Student newStudent = studentService.addNewStudent(student);
        return newStudent;
    }

    @DeleteMapping(path="/delete/{studentID}")
    public Student deleteStudent(@PathVariable("studentID") Long id){
        return studentService.removeStudent(id);
    }
}
