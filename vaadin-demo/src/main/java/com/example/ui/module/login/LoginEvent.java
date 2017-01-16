/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.example.ui.module.login;

import org.springframework.context.ApplicationEvent;

public class LoginEvent extends ApplicationEvent {

    private static final long serialVersionUID = -3676129466030835781L;
    private LoginBean loginBean;

    public LoginEvent(LoginBean loginBean) {
        super(loginBean);
        this.loginBean = loginBean;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    

}
