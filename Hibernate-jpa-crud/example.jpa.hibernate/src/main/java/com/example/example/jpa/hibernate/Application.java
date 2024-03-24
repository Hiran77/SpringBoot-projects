 package com.example.example.jpa.hibernate;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.example.jpa.hibernate.DAO.StudentDAO;
import com.example.example.jpa.hibernate.Entity.Student;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			
			createMultipleStudent(studentDAO);
			
			//readStudent(studentDAO) ;
			//queryForStudents(studentDAO);
			
			//queryForStudentsByLastName(studentDAO);
			
			//updateStudent(studentDAO);
			
			//removeStudent(studentDAO);
			
			//removeAll(studentDAO);
		};
	}
    
	private void removeAll(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count:" + numRowsDeleted);
		
	}

	private void removeStudent(StudentDAO studentDAO) {
		
		int studentId=3;
		
		System.out.println("Deleting Student id :" + studentId);
		
		studentDAO.delete(studentId);
		
	}

	private void updateStudent(StudentDAO studentDAO) {
	   int StudentId=1;
	   Student myStudent=studentDAO.findById(StudentId);
	   
	   System.out.println("Updating student...");
	   
	   myStudent.setFirstName("Jacob");
	   studentDAO.update(myStudent);
	   
	   System.out.println("Update Student : " + myStudent);
	   
		
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
        
		List<Student> theStudents= studentDAO.findByLastName("Duck");
		
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
		
			
			
	private void queryForStudents(StudentDAO studentDAO) {
		
		List<Student> theStudents= studentDAO.findAll();
		
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
		
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Create student Object..");
		Student tempStudent=new Student("Daffy" , "Duck" , "ahiranmaya@gmail.com");
		
		System.out.println("Saving Student...");
		studentDAO.save(tempStudent);

		System.out.println("Save student. Generated id :" + tempStudent.getId());
		
		System.out.println("Retrieving student with id:" + tempStudent.getId());
		Student myStudent=studentDAO.findById(tempStudent.getId());
		
		System.out.println("Found the student:" + myStudent);
		
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		
		
		//create the student object
		System.out.println("Create student Object..");
		Student tempStudent=new Student("Hiran" , "Mishra" , "mishrahiranmaya@gmail.com");
		Student tempStudent1=new Student("Daffy" , "Duck" , "duckduckgo@dand.com");
		Student tempStudent2=new Student("Monkey D. " , "Luffy" , "KingOfPriates@onepeice.com");
		
		//save the student object
		System.out.println("Saving Student...");
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		
		
	}
}
