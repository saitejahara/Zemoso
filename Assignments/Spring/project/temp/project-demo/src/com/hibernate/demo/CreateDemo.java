package com.hibernate.demo;

import com.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Driver.class)
								.addAnnotatedClass(Car.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			

			Driver driver = new Driver("John Wick","Wicker","burglary","2 years in prison");

			Car car = new Car("Mustang", "1969","petrol","supercharged","346bHp","455Nm");

			driver.setCar(car);

			session.beginTransaction();

			System.out.println("Saving Driver: " + driver);
			session.save(driver);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





