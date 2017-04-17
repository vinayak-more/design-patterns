package com.retro.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retro.web.bean.User;
import com.retro.web.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public User isValidUser(User user){
        return repository.isValidUser(user.getUsername(), user.getPassword());
    }
    

}
