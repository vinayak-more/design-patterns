/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ui.module.login.LoginView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
@Theme("valo")
@SpringUI
public class LoginUI extends UI {

    
    private static final long serialVersionUID = -7679349571926742502L;
    
    @Autowired
    LoginView loginView;

    @Override
    protected void init(VaadinRequest request) {
        setContent(loginView);
//        loginView.setParent(loginView);
    }
    
    public void loginSucess(){
        getPage().setLocation("/webapp");
    }
    

}
