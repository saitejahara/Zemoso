package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean premium) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
}
