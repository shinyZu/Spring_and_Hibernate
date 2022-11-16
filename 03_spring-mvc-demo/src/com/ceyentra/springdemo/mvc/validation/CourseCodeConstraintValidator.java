package com.ceyentra.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator
        implements ConstraintValidator<CourseCode,String> {

    private String[] coursePrefixes;

    @Override
    public void initialize(CourseCode theCourseCode) {
        this.coursePrefixes = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        /** to validate only a single prefix*/
        /*if (theCode != null) {
            return theCode.startsWith(this.coursePrefixe);
        }
        return true;*/

        /** to validate multiple prefixes*/
        boolean result = false;
        if (theCode != null) {
            for (String prefix : coursePrefixes) {
                result = theCode.startsWith(prefix);
                if (result){
                    break;
                }
            }
        } else {
            return true;
        }
        return result;
    }
}
