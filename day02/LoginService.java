package com.cdac.training.service;

import java.util.HashMap;

public class LoginService {

	private HashMap<String, String> users = new HashMap<>();
	
	public LoginService() {
		users.put("majrul", "123");
		users.put("john", "456");
		users.put("smith", "789");
		users.put("ted", "000");
	}
	
	public boolean isValidUser(String username, String password) {
		if(users.containsKey(username)) {
			//if(users.get(username).equals(password))
			String pwd = users.get(username);
			if(pwd.equals(password))
				return true;
		}
		return false;
	}

}
