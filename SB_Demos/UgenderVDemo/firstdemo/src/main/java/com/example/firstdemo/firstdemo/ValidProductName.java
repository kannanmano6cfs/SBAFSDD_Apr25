package com.example.firstdemo.firstdemo;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = validator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface ValidProductName {
    String message() default"Product name should start with an upper case letter";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default{};
}
