package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			displayStudents(theStudents);
			
			// query students: lastName='Bhai'
			theStudents = session.createQuery("from Student s where s.lastName='Bhai'").getResultList();
			
			// display the students
			System.out.println("\n\nStudents who have last name of Bhai");
			displayStudents(theStudents);
			
			// query students: lastName='Bhai' OR firstName='Sanath'
			theStudents =
					session.createQuery("from Student s where"
							+ " s.lastName='Bhai' OR s.firstName='Sanath'").getResultList();
			
			System.out.println("\n\nStudents who have last name of Bhai OR first name Sanath");
			displayStudents(theStudents);
			
			// query students where email LIKE '%zemoso.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%zemoso.com'").getResultList();

			System.out.println("\n\nStudents whose email ends with zemoso.com");
			displayStudents(theStudents);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

}





