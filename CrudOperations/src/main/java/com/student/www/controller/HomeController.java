package com.student.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.www.entity.Student;
import com.student.www.repository.StudentRepository;

@RestController
public class HomeController {
	
	@Autowired
	private StudentRepository studentRepository;
	@GetMapping("/")
	public String index() {
		return "Welcome to Spring Boot CRUD Operations !!!";
	}

	@PostMapping("/saveStudent")
	public Student saveData(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
		
	}
	@GetMapping("/getAllStudent")
	public List<Student> getAll(){
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStundent(@PathVariable int id) {
		Student student = studentRepository.findById(id).get();
		if(student!=null)
			studentRepository.delete(student);
		return "Deleted Successfully!!";
	}
	@PutMapping("/UpdateData")
	public Student updateStudentData(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}

}  
