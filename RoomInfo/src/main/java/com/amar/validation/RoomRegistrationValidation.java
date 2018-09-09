package com.amar.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.amar.forms.RoomRegistrationForm;

//@Component
public class RoomRegistrationValidation implements Validator {

	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return RoomRegistrationForm.class.equals(aClass);
	}

	public void validate(Object o, Errors errors) {

		RoomRegistrationForm roomRegistrationForm = (RoomRegistrationForm) o;
		
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
	       
	       // ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
	        if (roomRegistrationForm.getPassword().length() < 8 || roomRegistrationForm.getPassword().length() > 32) {
	            errors.rejectValue("password", "Size.userForm.password");
	        }

	        if (!roomRegistrationForm.getConfirmPassword().equals(roomRegistrationForm.getConfirmPassword())) {
	            errors.rejectValue("confirmPassword", "Diff.userForm.passwordConfirm");
	        }
	}

}
