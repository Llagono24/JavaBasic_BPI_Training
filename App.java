package com.bpi.M6_Activity2;

import com.bpi.M6_Activity2.model.Student;

import jakarta.persistence.EntityManager;

public class App {

	   public static void main(String[] args) {
		   
		   EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	    	
	    	try {
	    		runM6Activity2(em);
	    		
	    	} finally {
	    		EntityManagerUtil.getInstance().closeEntityManager(em);
	    		EntityManagerUtil.getInstance().shutdownFactory();
	    	}
	    	
	    	
	   }

	   
	static void runM6Activity2(EntityManager em) {
		
		try {
			em.getTransaction().begin();

			Student newStudent = new Student();
			newStudent.setName("Juan Dela Cruz");
			newStudent.setAge(50);
			newStudent.setEmail("juandelacruz@gmail.com");

			em.persist(newStudent);
			em.getTransaction().commit();
		}finally{
			
		}
	}

}
