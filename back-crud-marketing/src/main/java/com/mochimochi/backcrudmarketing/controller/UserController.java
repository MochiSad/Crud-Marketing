package com.mochimochi.backcrudmarketing.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mochimochi.backcrudmarketing.model.User;
import com.mochimochi.backcrudmarketing.repository.UserRepository;

@RestController
public class UserController{
    
    @Autowired 
    private UserRepository userRepository;

    @GetMapping("/api/user")
    public List<User> listaUsers(){
        return (List<User>) userRepository.findAll();
    }
}