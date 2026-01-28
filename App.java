package com.bpi.M6_Activity3;

import com.bpi.M6_Activity3.model.Student;
import com.bpi.M6_Activity3.model.Course;

import jakarta.persistence.EntityManager;

public class App {

	   public static void main(String[] args) {
		   
		   EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	    	
	    	try {
	    		persistOneToMany(em);
	    		
	    	} finally {
	    		EntityManagerUtil.getInstance().closeEntityManager(em);
	    		EntityManagerUtil.getInstance().shutdownFactory();
	    	}
	    	
	    	
	   }

	
	
	static void persistOneToMany(EntityManager em) {
		
	
		try {
			em.getTransaction().begin();
			
			Student student1 = em.find(Student.class, 1L);
		
			
			Course mathCourse = new Course();
			mathCourse.setCourseName("Math");
			mathCourse.setGrade("80");
			mathCourse.setStudent(student1);
			
			Course EnglishCourse = new Course();
			EnglishCourse.setCourseName("English");
			EnglishCourse.setGrade("75");
			EnglishCourse.setStudent(student1);

			em.persist(mathCourse);
			em.persist(EnglishCourse);
			
			em.getTransaction().commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


