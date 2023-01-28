package com.hali.demo.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service // same as Component, just for semantic reasons
public class StudentService {

	// @Autowired
	StudentRepository studentRepo;

	@Autowired
	public StudentService(StudentRepository studentRepo){
		this.studentRepo = studentRepo;
	}
    
	public List<Student> getStudents(){
		return studentRepo.findAll();
	}

	public Student addNewStudent(Student student){
		Optional<Student> opt = studentRepo.findStudentByEmail(student.getEmail());
		if(opt.isPresent()) throw new IllegalStateException("email taken");
		studentRepo.save(student);
		return student;
	}

	public Student removeStudent(Long id){
		Optional<Student> targetStudent = studentRepo.findById(id);
		if(targetStudent.isPresent()) studentRepo.deleteById(id);
		else throw new IllegalStateException("student does not exist");

		return targetStudent.get();
	}
}
