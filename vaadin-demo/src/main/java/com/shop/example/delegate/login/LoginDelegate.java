/**
 * @author Vinayak More
 *
 * @date 15-Jan-2017
 */
package com.shop.example.delegate.login;

import com.shop.example.ui.module.login.LoginBean;

public interface LoginDelegate {

    boolean isValidUser(LoginBean loginBean);

}
