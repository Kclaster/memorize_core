package com.memorize.model.annotations;

import com.memorize.model.AuthUserRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        AuthUserRequest authUserRequest = (AuthUserRequest) obj;
        return authUserRequest.getPassword().equals(authUserRequest.getMatchingPassword());
    }
}