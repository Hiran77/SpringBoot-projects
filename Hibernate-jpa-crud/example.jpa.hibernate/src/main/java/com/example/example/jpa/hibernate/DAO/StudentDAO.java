package com.example.example.jpa.hibernate.DAO;

import java.util.List;

import com.example.example.jpa.hibernate.Entity.Student;

public interface StudentDAO {
    
	void save(Student theStudent);
	
	Student findById(Integer id);
	
	List<Student> findAll();
	
	List<Student> findByLastName(String theLastName);
	
	void update(Student theStudent);
	
	void delete(Integer Id);
	
	int deleteAll();
  }
