package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccounts(boolean tripWire) {

		if(tripWire){

			throw new RuntimeException("->->->exception in findAccounts under AccountDAO");
		}

		List<Account> myAccounts = new ArrayList<>();

		// create sample accounts
		Account temp1 = new Account("Uppi", "Silver");
		Account temp2 = new Account("Aarya", "Platinum");
		Account temp3 = new Account("Sanath", "Gold");

		// add them to our accounts list
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}

	public String getName() {
		System.out.println("getter/setter");
		return name;
	}

	public void setName(String name) {
		System.out.println("getter/setter");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("getter/setter");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("getter/setter");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean premium) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
