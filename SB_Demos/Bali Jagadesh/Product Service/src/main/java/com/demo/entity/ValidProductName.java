package com.demo.entity;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = ProductValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface ValidProductName {
	String message() default"Product name should start with an upper case letter";
	Class<?>[] groups() default{};
	Class<? extends Payload>[] payload() default{};
	
	

}
