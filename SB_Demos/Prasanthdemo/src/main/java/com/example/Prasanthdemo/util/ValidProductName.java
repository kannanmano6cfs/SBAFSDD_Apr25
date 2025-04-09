package com.example.Prasanthdemo.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ProductNameValidator.class)
public @interface ValidProductName {

    String message() default "Product Name must start with an upper case letter";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
