package com.aopdemo;

import com.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aopdemo.dao.AccountDAO;

import java.util.List;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		//after returning demo
		List<Account> accountList = null;

		try {
			boolean tripWire = true;
			accountList = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("Thrown exception is: "+e);
		}
		System.out.println("\nIn main prog");
		System.out.println("----");
		System.out.println(accountList);

		// join point implementation
	/*	Account account = new Account();
		account.setName("Teja");
		account.setLevel("Platinum");


		// call the business method
		theAccountDAO.addAccount(account, true);

		//calling getter/setter methods
		theAccountDAO.setName("premium account");
		theAccountDAO.setServiceCode("HB57");

		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();

		MembershipDAO theMembershipDAO =
				context.getBean("membershipDAO", MembershipDAO.class);

		theMembershipDAO.addSillyMember();

		theMembershipDAO.anotherMethod();
				*/
		// close the context
		context.close();
	}

}










