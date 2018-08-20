package com.ashyleika.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashyleika.rest.entity.Student;
import com.ashyleika.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;
	
	@PostConstruct
	private void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Aliaksandr", "Shyleika"));
		theStudents.add(new Student("Michael", "Jordan"));
		theStudents.add(new Student("Lewis", "Hamilton"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getSingleStudent(@PathVariable int studentId) {
		if( (studentId >= theStudents.size()) || (studentId < 0) ) {
			throw new StudentNotFoundException("Student id not found - " + studentId);
		}
		
		return theStudents.get(studentId);
	}

	
}

























