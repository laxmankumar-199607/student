package com.csv.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csv.demo.model.Student;
import com.csv.demo.service.IStudentService;

@RestController
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	

	@PostMapping("/student/save")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		Student stu = null;
		try {
			stu = this.studentService.storeStudent(student);
			return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/student/get")
	public ResponseEntity<?> findStudent() {
		
		try {
			List<Student> list = this.studentService.getAllStudent();
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/student/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable Long id,@RequestParam int dateOfYear, @RequestParam int dateOfMonth, 
			@RequestParam int dateOfDay) {
		Student stu = null;
		try {
			stu = this.studentService.updateAndStoreStudent(id, dateOfYear, dateOfMonth, dateOfDay);
			return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Student>(HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping("/student/get/age")
	public ResponseEntity<?> getStudentByAge() {
		
		try {
			List<Student> list = this.studentService.getAllageBetweenStudent();
			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
