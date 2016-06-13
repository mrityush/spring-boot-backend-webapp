package com.src.main.command.users;

import com.src.main.command.AbstractDomainCO;
import com.src.main.domains.users.User;

/**
 * Created by mj on 25/5/16.
 */
public class UserCO extends AbstractDomainCO<User> {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
