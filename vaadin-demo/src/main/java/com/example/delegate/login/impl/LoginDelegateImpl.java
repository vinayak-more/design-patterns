/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.example.delegate.login.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.delegate.login.LoginDelegate;
import com.example.service.login.LoginService;
import com.example.ui.module.login.LoginBean;
import com.vaadin.spring.annotation.SpringComponent;
@SpringComponent
public class LoginDelegateImpl implements LoginDelegate {
    
    @Autowired
    private LoginService service;

    @Override
    public boolean isValidUser(LoginBean loginBean) {
        return service.isValidUser(loginBean);
    }

}
