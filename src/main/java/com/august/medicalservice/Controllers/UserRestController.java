package com.august.medicalservice.Controllers;

import com.august.medicalservice.Repositories.UserRepository;
import com.august.medicalservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserRepository userRepository;

    @Autowired
    public UserRestController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
