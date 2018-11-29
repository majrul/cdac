package com.cdac.service;

import java.util.Date;

import com.cdac.dao.GenericDao;
import com.cdac.entity.Account;
import com.cdac.entity.AccountInfo;

public class AccountService {

	public void openAccount(String name, String type, double balance) {
		Account acc = new Account();
		acc.setName(name);
		acc.setType(type);
		acc.setBalance(balance);
		
		GenericDao dao = new GenericDao();
		dao.save(acc);
	}
	
	public void withdraw(int acno, double amount) {
		GenericDao dao = new GenericDao();
		Account acc = dao.fetch(Account.class, acno);
		acc.setBalance(acc.getBalance() - amount);
		dao.save(acc);
		
		AccountInfo accInfo = new AccountInfo();
		accInfo.setType("withdraw");
		accInfo.setDate(new Date());
		accInfo.setAmount(amount);
		accInfo.setAccount(acc);
		dao.save(accInfo);
	}

	public void deposit(int acno, double amount) {
		
	}
	
	public void transfer(int fromacno, int toacno, double amount) {
		
	}
	
	public double getBalance(int acno) {
		
	}

}
