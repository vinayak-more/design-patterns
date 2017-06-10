package com.retro.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retro.vaadin.module.login.bean.UserRegistrationBean;
import com.retro.web.bean.User;
import com.retro.web.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public User isValidUser(User user){
        return repository.isValidUser(user.getUsername(), user.getPassword());
    }

	public boolean registerUser(UserRegistrationBean bean) {
		return repository.register(bean);
	}

	public boolean isUsernameAvailable(String username) {
		User user=repository.getUserByUsername(username);
		return user==null;
	}
    

}
