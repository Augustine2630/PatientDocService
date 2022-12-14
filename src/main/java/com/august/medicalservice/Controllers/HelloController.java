package com.august.medicalservice.Controllers;

import com.august.medicalservice.Security.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    private String helloWorld(){
        return "Hello";
    }

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println(userDetailsImpl.getDoctor());
        return "Hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }
}
