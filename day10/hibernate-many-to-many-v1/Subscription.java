package com.cdac.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Subscription1")
@Table(name = "TBL_subscription")
public class Subscription {

	@Id
	@GeneratedValue
	private int id;
	
	private String type;
	private double cost;
	private int duration;
	
	@ManyToMany
	@JoinTable(name = "TBL_user_subscription",
				joinColumns = @JoinColumn(name = "subs_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
	
}
