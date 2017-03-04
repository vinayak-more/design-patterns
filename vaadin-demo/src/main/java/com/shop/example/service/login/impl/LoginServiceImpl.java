/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.shop.example.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.example.repository.login.LoginRepository;
import com.shop.example.service.login.LoginService;
import com.shop.example.ui.module.login.LoginBean;
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
