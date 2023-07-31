package com.csv.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.csv.demo.model.Student;

@Service
public interface IStudentService {
/**
 * 
 * @param student
 * @return
 * @throws Exception
 * 
 * Store Student Data 
 */
	Student storeStudent(Student student) throws Exception;

	/**
	 * 
	 * @return
	 * 
	 * Get all Students
	 */
	List<Student> getAllStudent();

	/**
	 * 
	 * @return
	 * 
	 * Get students age between 18 to 25
	 */
	List<Student> getAllageBetweenStudent();

	/**
	 * 
	 * @param id
	 * @param dateOfYear
	 * @param dateOfMonth
	 * @param dateOfDay
	 * @return
	 * @throws Exception
	 * 
	 * update DOB of Student
	 */
	Student updateAndStoreStudent(Long id, int dateOfYear, int dateOfMonth, int dateOfDay) throws Exception;

}
