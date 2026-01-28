package com.bpi.M6_Activity3;

import com.bpi.M6_Activity3.model.Student;
import com.bpi.M6_Activity3.model.Course;

import jakarta.persistence.EntityManager;

public class App {

	   public static void main(String[] args) {
		   
		   EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	    	
	    	try {
	    		m6Activity4Solution(em);
	    		
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
	
	//M6 Activity 4 
	static void m6Activity4Solution(EntityManager em) {
		
		em.getTransaction().begin();
		
		// 1. create Student object, assign values
		Student newStudent = new Student();
		newStudent.setName("Jimboy Llagono");
		newStudent.setAge(26);
		newStudent.setEmail("llagonojimboy@gmail.com");
		// 2. attach transient student object to persistence context
		em.persist(newStudent);
		// 3. call flush()	
		em.flush();
		// 4. detach the managed newStudent from the persistence context
		em.detach(newStudent);

		// 5. print "is newStudent inside the persistence context: " + call contains()
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));

		// 6. reattach the detached newStudent
		newStudent = em.merge(newStudent);
		// 7. update newStudent, change some values like age or email
		newStudent.setAge(26);
		newStudent.setEmail("juan.delacruz@gmail.com");
		// 8. call flush()
		em.flush();
		// 9. print "is newStudent inside the persistence context: " + call contains()
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
		// 11. mark managed newStudent for deletion
		em.remove(newStudent);
		// 12. call flush()
		em.flush();
		// 13. print "is newStudent inside the persistence context: " + call contains()
		System.out.println("is newStudent inside the persistence context: " + em.contains(newStudent));
		
		em.getTransaction().commit();
	}

}


