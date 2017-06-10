/**
 * @author Vinayak More
 * @date 17-Apr-2017
 */
package com.retro.vaadin.module.login.delegate;

import org.springframework.beans.factory.annotation.Autowired;

import com.retro.vaadin.module.login.bean.UserRegistrationBean;
import com.retro.web.bean.User;
import com.retro.web.service.UserService;
import com.vaadin.spring.annotation.SpringComponent;

/**
 * @author Vinayak More
 *
 * @date 17-Apr-2017
 */
@SpringComponent
public class LoginDelegate {
    
    @Autowired
    private UserService service;

    public User isValidUser(User bean) {
        return service.isValidUser(bean);
    }
    
    public boolean isUsernameAvailable(String username){
    	return service.isUsernameAvailable(username);
    }

	public boolean register(UserRegistrationBean bean) {
		return service.registerUser(bean);
	}

}
