package com.csv.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
