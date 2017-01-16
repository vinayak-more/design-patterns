/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.example.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.login.LoginRepository;
import com.example.service.login.LoginService;
import com.example.ui.module.login.LoginBean;
@Service
public class LoginServiceImpl implements LoginService {
    
    @Autowired
    LoginRepository repository;

    @Override
    public boolean isValidUser(LoginBean loginBean) {
        boolean isValid=repository.isValidUser(loginBean.getUsername(), loginBean.getPassword());
        return isValid;
    }

}
