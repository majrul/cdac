package com.cdac.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	@Id
	@GeneratedValue
	private int acno;
	
	private String name;
	
	@Column(name = "ac_type")
	private String type;
	
	private double balance;
	
	@OneToMany
	private Set<AccountInfo> accountInfo;

	public int getAcno() {
		return acno;
	}

	public void setAcno(int acno) {
		this.acno = acno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Set<AccountInfo> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(Set<AccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}
	
	
	
}
