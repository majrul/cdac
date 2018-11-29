package com.cdac.validation;

import java.util.ArrayList;
import java.util.List;

import com.cdac.form.RegistrationForm;

public class RegistrationFormValidation {

	public List<String> validate(RegistrationForm registrationForm) {
		//TODO : a better way of doing validation is to use Regexp
		List<String> errors = new ArrayList<>();
		if(!registrationForm.getEmail().contains("@"))
			errors.add("Email address is invalid");
		if(registrationForm.getName().length() < 3)
			errors.add("Name entered is too short");
		
		return errors;
	}

}
