package com.csv.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private LocalDate dob;

	private Integer age;

	private int dateOfDay;

	private int dateOfMonth;

	private int dateOfYear;

	public int getDateOfDay() {
		return dateOfDay;
	}

	public void setDateOfDay(int dateOfDay) {
		this.dateOfDay = dateOfDay;
	}

	public int getDateOfMonth() {
		return dateOfMonth;
	}

	public void setDateOfMonth(int dateOfMonth) {
		this.dateOfMonth = dateOfMonth;
	}

	public int getDateOfYear() {
		return dateOfYear;
	}

	public void setDateOfYear(int dateOfYear) {
		this.dateOfYear = dateOfYear;
	}

	public Student() {
		super();
	}

	public Student(Long id, String name, LocalDate dob, Integer age, int dateOfDay, int dateOfMonth, int dateOfYear) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
		this.dateOfDay = dateOfDay;
		this.dateOfMonth = dateOfMonth;
		this.dateOfYear = dateOfYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
