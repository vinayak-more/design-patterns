/**
 * @author Vinayak More
 *
 * @date 14-Jan-2017
 */
package com.example.ui.module.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;

import com.example.common.uihelper.view.AbstractController;
import com.example.delegate.login.LoginDelegate;
import com.vaadin.spring.annotation.SpringComponent;

@SpringComponent
@Controller(LoginView.VIEW_NAME)
public class LoginController extends AbstractController<LoginView> {

    @Autowired
    LoginDelegate delegate;


    @Override
    public void onViewEnter() {

    }

    public boolean onLoginEvent(LoginEvent event) {
        boolean validUser = delegate.isValidUser(event.getLoginBean());
        if (validUser) {
            System.out.println("Sucess");
        } else {
            System.out.println("Failure");
        }

        return validUser;
    }



}
