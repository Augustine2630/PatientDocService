package com.august.medicalservice.Controllers;

import com.august.medicalservice.Service.RegistrationService;
import com.august.medicalservice.Utils.UserValidator;
import com.august.medicalservice.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator doctorValidator;
    private final RegistrationService registrationService;

    public AuthController(UserValidator doctorValidator, RegistrationService registrationService) {
        this.doctorValidator = doctorValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "Login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person") User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid User user, BindingResult bindingResult){
        doctorValidator.validate(user, bindingResult);

        if(bindingResult.hasErrors())
            return "redirect:/auth/registration";

        registrationService.register(user);

        return "redirect:/auth/login";
    }
}
