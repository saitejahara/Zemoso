package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

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
