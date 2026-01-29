package com.bpi.M6_Activity3;

import com.bpi.M6_Activity3.model.Student;
import com.bpi.M6_Activity3.model.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class App {

	   public static void main(String[] args) {
		   

		   
		   EntityManager em = EntityManagerUtil.getInstance().createEntityManager();
	    	
	    	try {
	    		printAllStudentNames(em);
	    		countCoursesByStudentId(em, 1L);
	    		countStudentsByAgeGreaterThan(em, 25);
	    		
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
	
//	For lecture demo 
//	static void selectAllStudent(EntityManager em) {
//		
//		em.getTransaction().begin();
//		
//		String jpql = "Select s FROM Student s";
//		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
//		List<Student> students = query.getResultList();
//		
//		//print student names
//		students.forEach(student -> System.out.println(student.getName()));
//		
//		em.getTransaction().commit();
//		
//	}
//	
//	static void selectStudentByName(EntityManager em, String name) {
//		
//		em.getTransaction().begin();
//		
//		String jpql = "Select s FROM Student s where s.name = :name";
//		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
//		query.setParameter("name", name);
//		List<Student> students = query.getResultList();
//		
//		//print student names
//		students.forEach(student -> System.out.println(student.getName()));
//		
//		em.getTransaction().commit();
//		
//	}
	
	
	// For Activity 5 Start
	static void printAllStudentNames(EntityManager em) {
		em.getTransaction().begin();
		
		String jpql = "Select s FROM Student s";
		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
		List<Student> students = query.getResultList();
		
		//print student names
		System.out.println("Result all students:");
		students.forEach(student -> System.out.println(student.getName()));
		
		em.getTransaction().commit();
		
	}


	static void countCoursesByStudentId(EntityManager em, Long id) {
		em.getTransaction().begin();
		
		String jpql = "Select count(c) FROM Course c JOIN c.student s where s.id = :studId";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("studId", id);
		Long countCourse = (Long) query.getSingleResult();
		
		//print course count result
		System.out.println("Result: student count with id = 1:");
		System.out.println(countCourse); 
		
		em.getTransaction().commit();
	}

	
	static void countStudentsByAgeGreaterThan(EntityManager em, int age) {
		em.getTransaction().begin();
		
		String jpql = "Select count(s) FROM Student s where s.age > :studAge";
		TypedQuery<Long> query = em.createQuery(jpql, Long.class);
		query.setParameter("studAge", age);
		Long countStudents = (Long)query.getSingleResult();
		
		//print student age greater than
		System.out.println("Result student count with age > 25:");
		System.out.println(countStudents); 
		
		em.getTransaction().commit();
	}
	// For Activity 5 End


}


