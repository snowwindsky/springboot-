package com.sn.springboot.controller;

import com.sn.springboot.entity.User;
import com.sn.springboot.repositpry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id")Integer id){
        Optional<User> optional =repository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            return user;
        }
        else return null;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        return repository.save(user);
    }
}
