/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.shop.example.repository.login;

public interface LoginRepository {

    boolean isValidUser(String username, String password);

}
