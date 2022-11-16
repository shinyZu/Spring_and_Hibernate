package com.ceyentra.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) // class that contains the business logic
@Target({ElementType.METHOD, ElementType.FIELD}) // elements that can be applied
@Retention(RetentionPolicy.RUNTIME) // retain this annotation(@CourseCode) in the bytecode & also use it at runtime by JVM
public @interface CourseCode {

    // define default course code
//    public String value() default "LUV";
    public String[] value() default {"LUV"};

    // define default error message
    public String message() default "must start with LUV";

    // define default groups -> where u can group validations/related constraints together
    public Class<?>[] groups() default {};

    // define default payloads -> where u can give additional information abt the validation error
    public Class<? extends Payload>[] payload() default{};
}
