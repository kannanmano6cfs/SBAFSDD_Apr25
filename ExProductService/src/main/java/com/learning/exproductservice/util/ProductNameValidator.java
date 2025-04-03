package com.learning.exproductservice.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductNameValidator implements ConstraintValidator<ValidProductName, String> {

    @Override
    public boolean isValid(String productName, ConstraintValidatorContext context) {
        return productName != null && Character.isUpperCase(productName.charAt(0));
    }
}
