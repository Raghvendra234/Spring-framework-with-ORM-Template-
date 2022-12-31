package com.spring.orm.dao;

import com.spring.orm.entities.Student;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class StudentDao
{

	private HibernateTemplate hibernateTemplate;
 
	public HibernateTemplate getHibernateTemplate() 
	{
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}
	
  
	// Insert Data
	
	@Transactional  // for only save data 
	public int insert(Student student)
	{
	    Integer	i=(Integer)this.hibernateTemplate.save(student);
		return i;
	}

	
	// Get the Single Data(Object)
	 public Student getStudent(int studentId)
	 {
		Student student = this.hibernateTemplate.get(Student.class,studentId); 
		return student;
		 
	 }
     
	// Get all student (All rows)
	 public List<Student> getAllStudent()
	 {
	
		List<Student> student=this.hibernateTemplate.loadAll(Student.class);
		return student;
		 
	 }
	 
	 
	 // Delete the data
	 @Transactional
	 public void deleteStudent(int studentId)
	 {
	   Student student=this.hibernateTemplate.get(Student.class,studentId);
		
       this.hibernateTemplate.delete(student);
	 }
	 
	 // Update the Data
	 @Transactional
	 public void updateStudent(Student student)
	 {
		 this.hibernateTemplate.update(student);
	 }
	 
	 
	 
	
}















