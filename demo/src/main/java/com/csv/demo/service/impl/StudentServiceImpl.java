package com.csv.demo.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csv.demo.Repo.StudentRepository;
import com.csv.demo.model.Student;
import com.csv.demo.service.IStudentService;

@Component
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentRepository repository;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
	
	@Override
	public Student storeStudent(Student student)throws Exception {
		
		LocalDate birthDate = LocalDate.of(student.getDateOfYear(), student.getDateOfMonth(), student.getDateOfDay());
		int actual = calculateAge(birthDate, LocalDate.now());
		student.setAge(actual);
		student.setDob(birthDate);
		try {
			
			return this.repository.save(student);
		} catch (Exception e) {
			throw new Exception("Failed to store student data");
		}
		
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> students=null;
		try {
			 students = this.repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
		
	}

	@Override
	public List<Student> getAllageBetweenStudent() {
		
		BeanPropertyRowMapper<Student> mapper = new BeanPropertyRowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

				Student student = new Student();

				student.setId(rs.getLong("id"));
				student.setDateOfDay(rs.getInt("date_of_day"));
				student.setDateOfYear(rs.getInt("date_of_year"));
				student.setAge(rs.getInt("age"));
				student.setName(rs.getString("name"));

				return student;
			}
		};
		List<Student> tempList = jdbcTemplate.query(getStudentsByQuery(),
				mapper);

		return tempList;
		
	}
	
	public static final String getStudentsByQuery() {
		return "select * from student_table where age between 18 and 25";
	}

	@Override
	public Student updateAndStoreStudent(Long id, int dateOfYear, int dateOfMonth, int dateOfDay) throws Exception {
		Student student = null;
		
		try {
			student = this.repository.findById(id).get();
			student.setDateOfDay(dateOfDay);
			student.setDateOfMonth(dateOfMonth);
			student.setDateOfYear(dateOfYear);
			
			LocalDate birthDate = LocalDate.of(student.getDateOfYear(), student.getDateOfMonth(), student.getDateOfDay());
			int actual = calculateAge(birthDate, LocalDate.now());
			student.setAge(actual);
			student.setDob(birthDate);
			student = this.repository.save(student);
			
		} catch (Exception e) {
			throw new Exception("failed to update");
		}
		return student;
	}

}
