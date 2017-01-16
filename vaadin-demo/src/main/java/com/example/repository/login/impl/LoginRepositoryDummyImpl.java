/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.example.repository.login.impl;

import org.springframework.stereotype.Repository;

import com.example.repository.login.LoginRepository;
@Repository
public class LoginRepositoryDummyImpl implements LoginRepository {

    private String dummyUsername = "username";
    private String dummyPassword = "password";

    @Override
    public boolean isValidUser(String username, String password) {
        return dummyUsername.equals(username) && dummyPassword.equals(password);

    }

}
