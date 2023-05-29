package com.example.demo_.passValid;

import com.example.demo_.models.Identity.AppUser;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidatePassword, Object> {
    @Override
    public void initialize(ValidatePassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        AppUser user = (AppUser) obj;
        return user.getPassword().equals(user.getPasswordComfirm());
    }
}