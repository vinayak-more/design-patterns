package com.retro.web.bean;

/**
 * @author Vinayak More
 *
 * @date 08-Apr-2017
 */
public class User {

    private Long userId;
    private String username="";
    private String password="";

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public User() {
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", username=" + username + ", password=" + password + "]";
    }
}
