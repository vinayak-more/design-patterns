package com.retro.web.repository;

import com.retro.web.bean.RegisterUser;
import com.retro.web.bean.User;


/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
public interface UserRepository {
    public boolean saveUser(final User user);
    
    public User isValidUser(final String username,final String password);
    
    public boolean register(final RegisterUser user);
    
}
