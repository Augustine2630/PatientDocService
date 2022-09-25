package com.august.medicalservice.Utils;

import com.august.medicalservice.Service.UserDetailsService;
import com.august.medicalservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserDetailsService userDetailsService;

    @Autowired
    public UserValidator(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        try{
            userDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException e){
            e.printStackTrace();
            return;
        }

        errors.rejectValue("username", "", "Already exists");
    }
}
