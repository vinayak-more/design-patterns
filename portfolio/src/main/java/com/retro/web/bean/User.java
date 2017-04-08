package com.retro.web.bean;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
public class User {

    private Long userId;
    private final String username;
    private final String password;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
    }
}
