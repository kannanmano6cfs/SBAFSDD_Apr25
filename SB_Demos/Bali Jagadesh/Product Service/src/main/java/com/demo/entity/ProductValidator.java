package com.demo.entity;

import org.springframework.validation.beanvalidation.CustomValidatorBean;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductValidator implements ConstraintValidator<ValidProductName, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		return value !=null&& Character.isUpperCase(value.charAt(0));
	}

}
