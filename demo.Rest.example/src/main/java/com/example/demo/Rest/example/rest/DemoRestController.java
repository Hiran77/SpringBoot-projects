package com.example.demo.Rest.example.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Rest.example.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class DemoRestController {
	
	
	private List<Student> theStudent;
	
	
	//define @PostConstruct to load the student data..only once
	@PostConstruct
	public void loadData() {
		
        theStudent=new ArrayList<>();
		
		theStudent.add(new Student("Hiranmaya","Mishra"));
		theStudent.add(new Student("Anindita","Mishra"));
		theStudent.add(new Student("Saniya","Chaudhary"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudent;
	}
	
	//define endpoint -return student at index
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		
		if((studentId>=theStudent.size()) || (studentId<0)) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudent.get(studentId);
	}

	
	
}
