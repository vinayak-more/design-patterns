/**
 * @author Vinayak More
 *
 * @date 10-Dec-2016
 */
package main.java.connector.user.impl;

import main.java.connector.user.User;

public class DefaultUser implements User {

    String userName;

    public DefaultUser(String userName) {
        super();
        this.userName = userName;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }


    public enum USERS {
        USER1("USER-1"), USER2("USER-2"), USER3("USER-3");

        private String userName;

        private USERS(String userName) {
            this.userName = userName;
        }

        public User getUser() {
            return new DefaultUser(this.userName);
        }
    };
}
