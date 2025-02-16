package com.example.demo.validators;

import com.example.demo.domain.Part;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinMaxValidator implements ConstraintValidator<ValidMinMax, Part> {


    @Override
    public void initialize(ValidMinMax constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();

        return constraintMin(part, constraintValidatorContext) && constraintMax(part, constraintValidatorContext);
    }

    public boolean constraintMin(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() < part.getMin_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be greater then min.").addConstraintViolation();
            return false;
        }
        return true;
    }

    public boolean constraintMax(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() > part.getMax_inv()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Inventory must be less then max.").addConstraintViolation();
            return false;
        }
        return true;
    }
}