package com.aopdemo;

import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the business method
		theAccountDAO.addAccount(new Account(), true);

		//calling getter/setter methods
		theAccountDAO.setName("premium account");
		theAccountDAO.setServiceCode("HB57");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);

		theMembershipDAO.addSillyMember();

		theMembershipDAO.anotherMethod();
				
		// close the context
		context.close();
	}

}










