package com.example.example.jpa.hibernate.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.example.jpa.hibernate.Entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class StudentDAOImpl implements StudentDAO{

	//define field for entity manager
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	//implement save method
	@Transactional
	public void save(Student theStudent) {
		entityManager.persist(theStudent);
		
	}

	@Override
	public Student findById(Integer id) {
		return entityManager.find(Student.class, id);
	}
	
	@Override
	public List<Student> findAll() {
		// create query
		TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastName asc", Student.class);
		
		//return query results
		return theQuery.getResultList();
	}

	@Override
	public List<Student> findByLastName(String theLastName) {
		
		TypedQuery<Student> theQuery=entityManager.createQuery(
				"FROM Student WHERE lastName=:theData" , Student.class);
		
		theQuery.setParameter("theData" , theLastName);
		
		return theQuery.getResultList();
		
		
	}

	@Override
	@Transactional
	public void update(Student theStudent) {
		entityManager.merge(theStudent);
		
	}

	@Override
	@Transactional
	public void delete(Integer Id) {
		Student theStudent=entityManager.find(Student.class, Id);
	    entityManager.remove(theStudent);
		
	}

	@Override
	@Transactional
	public int deleteAll() {
		int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
		return numRowsDeleted;
	}
   
}
