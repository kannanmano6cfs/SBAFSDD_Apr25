package com.example.firstdemo.firstdemo;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class validator implements ConstraintValidator<ValidProductName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return value !=null&& Character.isUpperCase(value.charAt(0));
    }
}
